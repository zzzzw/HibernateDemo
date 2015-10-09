package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

import common.BaseDAO;
import common.DataZh;

import entity.Station;


//station和ddxx是一对多关系，为保证代码整洁，每个实体的增删改查写在自己的dao,复杂查询可以写在需要的dao里
public class StationDAO extends BaseDAO<Station> {

	
	 ////////////////////////////////////////////////////////////////演示hql查询
	// 使用Hql查询站名里含"京"字的所有站点
	public List findByproperty(String propertyName) {

		// 通过占位符传参
		String querystring = "from Station as model where model.czmc like ?";

		// 显示传参
		// String
		// querystring="from Station as model where model.czmc like '%"+propertyName+"%'";

		Query queryObject = gs().createQuery(querystring);

		queryObject.setParameter(0, "%" + propertyName + "%"); // 传参

		return queryObject.list();
	}

	// 查询最后一个字是"京"字并且等级是"一级的"所有站点
	public List findByKey(String Key1, String Key2) {

		String querystring = "from Station as model where model.czmc like ? and model.dj=?";

		// 显示传参
		// String
		// querystring="from Station as model where model.czmc like '%"+propertyName+"%'";

		Query queryObject = gs().createQuery(querystring);

		queryObject.setParameter(0, "%" + Key1);
		queryObject.setParameter(1, Key2); // 传参

		return queryObject.list();
	}

	 
	// 通过判断参数动态组合Hql语句，生成基本通用查询
	public List find(Station entity) {
		List reuslt = null;

		// 字符串辅助类
		StringBuffer hql = new StringBuffer("from Station where 1=1");

		List vp = new ArrayList();

		if (entity != null) {

			// 小于0的和null都不做比较
			if (entity.getCzdm() != null && entity.getCzdm() < 0) {
				hql.append(" and czdm=?");
				vp.add(entity.getCzdm());
			}

			// 空字符串和null都不做比较
			if (entity.getCzmc() != null && entity.getCzmc().length() > 0) {
				hql.append(" and czmc = ?");
				vp.add(entity.getCzmc());
			}

			if (entity.getDj() != null) {
				hql.append(" and dj=?");
				vp.add(entity.getDj());
			}
		}

		Query q = gs().createQuery(hql.toString());

		for (int i = 0; i < vp.size(); i++) {
			q.setParameter(i, vp.get(i));
		}

		reuslt = q.list();
		return reuslt;
	}

	
	 ////////////////////////////////////////////////////////////////演示复杂查询
	
	// 使用原生sql,根据等级模糊查询符合条件的所有车站名
	public List<String> findonebydj(String dj) {
		// sql语句
		String sql = "select czmc from station where dj like '%" + dj + "%'";

		SQLQuery q = gs().createSQLQuery(sql);
	    
	  return DataZh.ObjtoStr(q.list());
	}

	// 使用原生sql,根据等级模糊查询符合条件的所有的车站名和车站代码
	public List<String[]> findmanybydj(String dj) {
		// sql语句
		String sql = "select czmc,czdm from station where dj like '%" + dj
				+ "%'";

		SQLQuery q = gs().createSQLQuery(sql);
		
		return DataZh.ObjArrtoStrArr(q.list());
	}

	
	// 使用原生sql,关联两表station,ddxx, 查询广州东发出的所有订单id,状态,等级
	public List<String[]> findmanysbydj(String dj) {
		// sql语句
		String sql = "select a.czmc,id,b.status,dj from station a,ddxx b where a.czdm=b.czid and a.czmc='"
				+ dj + "'";

		SQLQuery q = gs().createSQLQuery(sql);
		return DataZh.ObjArrtoStrArr(q.list());
	}

    ////////////////////////////////////////////////////////////////演示复杂删除
	
	// 输入车站代码，将相关的车站和订单全部删除
	public int excuteFzDelete(Integer id) {
		
		//分别删除
		String sql = "delete from station where czdm=" + id;
		String sql2 = "delete from ddxx where czid=" + id;

		// 增删改需要事务，事务开始
		Transaction tx = null;
		tx = gs().beginTransaction();

		SQLQuery q = gs().createSQLQuery(sql);

		int a = q.executeUpdate();

		SQLQuery q2 = gs().createSQLQuery(sql2);
		int b = q2.executeUpdate();

		tx.commit(); // 提交事务

		if (a > 0 || b > 0)  //有效删除则返回1
			return 1;
		else               
			return 0;       //无效删除则返回0

	}

	 ////////////////////////////////////////////////////////////////演示复杂更新
	
	// 将所有无效的（车站已经不存在的）订单全部车站ID（czid）全部更新为指定的车站ID
	
	//复杂更新，需用inner join	
	//update ddxx a INNER JOIN
	//(select id from ddxx where czid  not in(select DISTINCT czdm from station)) as b 
	//ON a.id=b.id set czid=222
	public int excuteFzUpdate(Integer czid)
	{
		StringBuffer s=new StringBuffer();
		s.append("update ddxx a INNER JOIN");	
		s.append("(select id from ddxx where czid  not in(select DISTINCT czdm from station)) as b");
		s.append(" ON a.id=b.id set czid="+czid);
		
		//增删改加事务
		Transaction tx;
		tx=gs().beginTransaction();
		SQLQuery q=gs().createSQLQuery(s.toString());
		
		//受影响的行数
		int a=q.executeUpdate();
		tx.commit();	
		return a;
	}
	 
  
	
	
  ////////////////////////////////////////////////////////////////演示多对多
	
	/*
	 * 站点（Station）与线路(Line)是多对多关系，
	 * 在数据库里面，解决方式是拆成三张表，做一个中间表，中间表要包含两个主表的主键
	 * 多对多拆成了两个一对多
	 * 
	 */
	
	
	//查询经过指定站点的所有线路名称
	public List<String> searchLineByStation(String czmc)
	{ 
		String sql = "select xlmc from line where xlid in (select a.LID from stationjoinline a,station b where a.SID = b.czdm and b.czmc=?)";
		SQLQuery q=gs().createSQLQuery(sql);
		
		//建议使用setParameter加参数
		q.setParameter(0, czmc);		
		return DataZh.ObjtoStr(q.list());
	}
	
	
	
	//查询指定线路经过的所有站点名称,站点ID
	public List<String[]> searchStationByLine(String xlmc)
	{ 
		String sql="SELECT * from station c WHERE c.czdm IN"+
"(SELECT b.SID FROM stationjoinline b WHERE b.LID IN"+
"(SELECT a.xlid FROM line a WHERE a.xlmc=?))";
		SQLQuery q=gs().createSQLQuery(sql);
		q.setParameter(0, xlmc);
		List<String[]> list=q.list();
		return DataZh.ObjArrtoStrArr(q.list());
	}
	
	
	
	
	
	 ////////////////////////////////////////////////////////////dao总结
	/*
	 * 总结：
	 * 
	 * --------------------------------------查询
	 * 1.hql查询
	 * 
	 *  StringBuffer hql = new StringBuffer("from Station where 1=1");
	 *  
	 *  Query q = gs().createQuery(hql.toString());
	 *  
	 *  q.list();
	 * 
	 * 2.sql查询
	 * 
	 * String sql = "select czmc,czdm from station where dj like '%" + dj
				+ "%'";
				
		SQLQuery q = gs().createSQLQuery(sql);  //sql查询使用createSQLQuery
		
		q.list();		
	 * 
	 * DataZh.ObjArrtoStrArr(q.list())  //sql查询返回的是Object，记得转换
	 * 
	 * 
	 * --------------------------------------增删改
	 * 使用原生sql语句执行
	 * 
	 * String sql = "delete from station where czdm=" + id;
	 * 
	 * Transaction tx = null;
		tx = gs().beginTransaction();

		SQLQuery q = gs().createSQLQuery(sql);
		
		
	 * tx.commit(); // 提交事务
	 * 
	 * q.executeUpdate()    //增删改的语句使用这个函数
	 * 
	 * return result      //返回受影响的行数
	 * 
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
