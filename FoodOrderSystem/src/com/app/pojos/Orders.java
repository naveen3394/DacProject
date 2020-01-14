package com.app.pojos;

import java.util.Date;
import java.util.List;

import javax.persistence.JoinColumn;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name = "orders")
public class Orders {

	private Integer id;
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "IST")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date orderDate;
	@DateTimeFormat(pattern = "hh:mm:ss aaa")
	private Date orderTime;
	private String oStatus;
	
	private Vendor oVendor; //manytoOne
	private Customer oCustomer;//manytoone
	private DeliveryBoy oDeliveryBoy;//one to one
	private Payment oPayment;//one to one
	private List<OrderDetails> oDetails;//one to many
	
	
	public Orders() {
		// TODO Auto-generated constructor stub
	}
	
	public Orders( Date orderDate, String oStatus) {
		super();
		this.orderDate = orderDate;
		this.oStatus = oStatus;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "orderdate")
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getoStatus() {
		return oStatus;
	}

	public void setoStatus(String oStatus) {
		this.oStatus = oStatus;
	}

	@ManyToOne
	@JoinColumn(name = "vendorId")
	public Vendor getoVendor() {
		return oVendor;
	}

	public void setoVendor(Vendor oVendor) {
		this.oVendor = oVendor;
	}

	@ManyToOne
	@JoinColumn(name = "customerId")
	public Customer getoCustomer() {
		return oCustomer;
	}

	public void setoCustomer(Customer oCustomer) {
		this.oCustomer = oCustomer;
	}
	@OneToOne(mappedBy ="odId",cascade = CascadeType.ALL,orphanRemoval = true)
	public DeliveryBoy getoDeliveryBoy() {
		return oDeliveryBoy;
	}

	public void setoDeliveryBoy(DeliveryBoy oDeliveryBoy) {
		this.oDeliveryBoy = oDeliveryBoy;
	}
	
	@OneToOne(mappedBy = "pOrder",cascade = CascadeType.ALL,orphanRemoval = true)
public Payment getoPayment() {
		return oPayment;
	}

	public void setoPayment(Payment oPayment) {
		this.oPayment = oPayment;
	}

	@OneToMany(mappedBy = "oId",cascade = CascadeType.ALL,orphanRemoval = true)
	public List<OrderDetails> getoDetails() {
		return oDetails;
	}

	public void setoDetails(List<OrderDetails> oDetails) {
		this.oDetails = oDetails;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ordertime")
	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderDate=" + orderDate + ", orderTime=" + orderTime + ", oStatus=" + oStatus
				+ "]";
	}


	
	
}
