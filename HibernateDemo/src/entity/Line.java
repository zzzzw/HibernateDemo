package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

//线路
//注解方式
@Entity
@Table(name = "line")
public class Line {

	@Id
	@GenericGenerator(name = "generator", strategy = "identity")
	@GeneratedValue(generator = "generator")
	private Integer xlid;
	private String xlmc;

	public Integer getXlid() {
		return xlid;
	}

	public void setXlid(Integer xlid) {
		this.xlid = xlid;
	}

	public String getXlmc() {
		return xlmc;
	}

	public void setXlmc(String xlmc) {
		this.xlmc = xlmc;
	}

}
