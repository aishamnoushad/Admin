package com.aisha.Admin.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="whatsapp_click_count")
public class WhatsappClickClass {
	@Id
	@Column(name="sl_no")
	private int slno;
	@Column(name="count")
	private int count;
	@Column(name="date")
	private Date clickdate;
	public int getSlno() {
		return slno;
	}
	public void setSlno(int slno) {
		this.slno = slno;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getClickdate() {
		return clickdate;
	}
	public void setClickdate(Date clickdate) {
		this.clickdate = clickdate;
	}
	public WhatsappClickClass(int slno, int count, Date clickdate) {
		super();
		this.slno = slno;
		this.count = count;
		this.clickdate = clickdate;
	}
	@Override
	public String toString() {
		return "WhatsappClickClass [slno=" + slno + ", count=" + count + ", clickdate=" + clickdate + ", getSlno()="
				+ getSlno() + ", getCount()=" + getCount() + ", getClickdate()=" + getClickdate() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public WhatsappClickClass() {
		
	}
	
}
