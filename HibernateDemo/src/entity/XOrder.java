package entity;

import java.util.Date;

/**
 * 配置方式
 */

public class XOrder implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Date starttime;
	private Float price;

	// Constructors

	/** default constructor */
	public XOrder() {
	}

	/** minimal constructor */
	public XOrder(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public XOrder(Integer id, String name, Date starttime, Float price) {
		this.id = id;
		this.name = name;
		this.starttime = starttime;
		this.price = price;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

}