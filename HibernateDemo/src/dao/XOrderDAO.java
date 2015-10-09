package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;

import common.BaseDAO;

import entity.XOrder;

 

public class XOrderDAO extends BaseDAO<XOrder> {
	 
	
	

	public List findByProperty(String propertyName, Object value) {
		
		String queryString = "from XOrder as model where model."+ propertyName + "= ?";
		
		//from XOrder as model where model.name='zhangsan'£»
		
	Query queryObject = gs().createQuery(queryString);
	
	queryObject.setParameter(0, value);  //´«²Î
	
	
	return queryObject.list();
	
	
	}

	 

	
	 
 

 
}