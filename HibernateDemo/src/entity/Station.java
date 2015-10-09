package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

//站点
//注解方式
@Entity
@Table(name="station")
public class Station {
	
	
	
	@Id
	@GenericGenerator(name = "generator", strategy = "identity")
    @GeneratedValue(generator = "generator")
	private Integer czdm;
	
	
	private String czmc;
	
	
	private String dj;

	public Integer getCzdm() {
		return czdm;
	}

	public void setCzdm(Integer czdm) {
		this.czdm = czdm;
	}

	public String getCzmc() {
		return czmc;
	}

	public void setCzmc(String czmc) {
		this.czmc = czmc;
	}

	public String getDj() {
		return dj;
	}

	public void setDj(String dj) {
		this.dj = dj;
	}

	@Override
	public String toString() {
		return "Station [czdm=" + czdm + ", czmc=" + czmc + ", dj=" + dj + "]";
	}
	
	
	
	
	
}
