package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "orderDetails")
public class OrderDetails {

	private Integer odId;
	private int pqty;
	
	private Orders oId;
	
	private List<Product> plist;
	
	public OrderDetails() {
		// TODO Auto-generated constructor stub
	}

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getOdId() {
		return odId;
	}




	public void setOdId(Integer odId) {
		this.odId = odId;
	}




	public int getPqty() {
		return pqty;
	}

	public void setPqty(int pqty) {
		this.pqty = pqty;
	}
@ManyToOne
@JoinColumn(name = "orderId")
	public Orders getoId() {
		return oId;
	}

	public void setoId(Orders oId) {
		this.oId = oId;
	}

	@OneToMany(mappedBy = "pOrderDetails",cascade = CascadeType.ALL,orphanRemoval = true)
	public List<Product> getPlist() {
		return plist;
	}

	public void setPlist(List<Product> plist) {
		this.plist = plist;
	}

	@Override
	public String toString() {
		return "OrderDetails [odId=" + odId + ", pqty=" + pqty + "]";
	}
	
	
}
