package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

//订单信息
//注解方式
@Entity
@Table(name = "ddxx")  //对应表名
public class Ddxx implements java.io.Serializable{

	
	@Id   //指定主键
	@Column(name = "id") //对应列名
    @GenericGenerator(name = "generator", strategy = "identity")
    @GeneratedValue(generator = "generator")
	private int id;
	
	@Column(name = "status") //对应列名
	private String status;

	private Integer czid;
	
	
	
	public Integer getCzid() {
		return czid;
	}

	public void setCzid(Integer czid) {
		this.czid = czid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
