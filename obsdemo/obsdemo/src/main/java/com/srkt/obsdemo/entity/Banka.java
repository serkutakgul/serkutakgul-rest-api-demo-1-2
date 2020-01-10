package com.srkt.obsdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SBANK")
public class Banka {
	@Id
	@Column(name="ogrenci_no")
	private Integer oNo;
	@Column(name="borc_durumu")
	private String borcDurumu;
	public Integer getoNo() {
		return oNo;
	}
	public void setoNo(Integer oNo) {
		this.oNo = oNo;
	}
	public String getBorcDurumu() {
		return borcDurumu;
	}
	public void setBorcDurumu(String borcDurumu) {
		this.borcDurumu = borcDurumu;
	}
	public Banka(Integer oNo, String borcDurumu) {
		super();
		this.oNo = oNo;
		this.borcDurumu = borcDurumu;
	}
	public Banka() {
		super();
	}
	@Override
	public String toString() {
		return "Banka [oNo=" + oNo + ", borcDurumu=" + borcDurumu + "]";
	}

}
