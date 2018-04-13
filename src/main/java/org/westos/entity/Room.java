package org.westos.entity;

import java.math.BigDecimal;

public class Room {
	private Integer id;

	private String name;

	private Integer status;

	private BigDecimal price;

	private String type;

	private String area;

	private String configure;

	private Integer oldid;

	private String pic;

	private String oldmanName;

	public String getOldmanName() {
		return oldmanName;
	}

	public void setOldmanName(String oldmanName) {
		this.oldmanName = oldmanName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area == null ? null : area.trim();
	}

	public String getConfigure() {
		return configure;
	}

	public void setConfigure(String configure) {
		this.configure = configure == null ? null : configure.trim();
	}

	public Integer getOldid() {
		return oldid;
	}

	public void setOldid(Integer oldid) {
		this.oldid = oldid;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic == null ? null : pic.trim();
	}
}