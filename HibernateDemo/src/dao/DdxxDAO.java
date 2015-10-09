package dao;

import java.util.List;

import common.BaseDAO;

import entity.Ddxx;


//继承自BaseDAO，继承实现了增删改查
public class DdxxDAO extends BaseDAO<Ddxx>{
    
	
	
	 
	 
	
	 
	//自定义使用hql查询
	//根据状态查询订单
	public List findstatue(String status)
	{
		org.hibernate.Query q= gs().createQuery("from Ddxx where status=? ");
		q.setString(0,status );
		return q.list();
	}
	
	
	
	
	
	
	
	
}
