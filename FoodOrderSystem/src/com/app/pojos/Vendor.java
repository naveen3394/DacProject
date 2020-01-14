package com.app.pojos;

import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

@Entity
@Table(name = "vendor")
public class Vendor 
{
	//	; inherited from uid
	//	@AttributeOverride(name = "owner", column =
	//			@Column(name = "CC_OWNER", nullable = false)
	//	
	private Integer vId;
	private User userVendor;
	
	
	@Override
	public String toString() {
		return "Vendor [vId=" + vId + ", vRestaurant=" + vRestaurant + ", itemList=" + itemList + ", vOrder=" + vOrder
				+ "]";
	}
	public Vendor() {
		// TODO Auto-generated constructor stub
	}
	public Vendor(String vRestaurant) {
		super();
		this.vRestaurant = vRestaurant;
	}
	private String vRestaurant;//restaurant name

	private List<Feedback> vFb; //one to many to feedbacks

	private List<Product> itemList;//one to many to products
	
	private List<Orders> vOrder;
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
public Integer getvId() {
		return vId;
	}
	public void setvId(Integer vId) {
		this.vId = vId;
	}
@OneToOne
@JoinColumn(name="uv")
	public User getUserVendor() {
		return userVendor;
	}
	public void setUserVendor(User userVendor) {
		this.userVendor = userVendor;
	}
	
	
	public String getvRestaurant() {
		return vRestaurant;
	}
	public void setvRestaurant(String vRestaurant) {
		this.vRestaurant = vRestaurant;
	}


	@OneToMany(mappedBy = "fVendor",cascade = CascadeType.ALL,orphanRemoval = true)
	public List<Feedback> getvFb() {
		return vFb;
	}

	public void setvFb(List<Feedback> vFb) {
		this.vFb = vFb;
	}

	@OneToMany(mappedBy = "pVendor",cascade = CascadeType.ALL,orphanRemoval = true)
	public List<Product> getItemList() {
		return itemList;
	}
	public void setItemList(List<Product> itemList) {
		this.itemList = itemList;
	}
@OneToMany(mappedBy = "oVendor",cascade = CascadeType.ALL,orphanRemoval = true)
public List<Orders> getvOrder() {
	return vOrder;
}
public void setvOrder(List<Orders> vOrder) {
	this.vOrder = vOrder;
}




}
