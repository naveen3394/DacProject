package com.app.pojos;

import java.util.Arrays;

import javax.persistence.*;


@Entity
@Table(name = "product")
public class Product {
private Integer pId;
private String pName;
private float pPrice;
private byte[] image;
private Pcategory vegnonveg;
private CuisineType cType;
private Vendor pVendor;
private OrderDetails pOrderDetails;
public Product() {
	// TODO Auto-generated constructor stub
}

public Product(String pName, float pPrice, byte[] image, Pcategory vegnonveg, CuisineType cType) {
	super();
	this.pName = pName;
	this.pPrice = pPrice;
	this.image = image;
	this.vegnonveg = vegnonveg;
	this.cType = cType;
}

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Integer getpId() {
	return pId;
}

public void setpId(Integer pId) {
	this.pId = pId;
}

public String getpName() {
	return pName;
}

public void setpName(String pName) {
	this.pName = pName;
}

public float getpPrice() {
	return pPrice;
}

public void setpPrice(float pPrice) {
	this.pPrice = pPrice;
}

@Lob
public byte[] getImage() {
	return image;
}

public void setImage(byte[] image) {
	this.image = image;
}

@Enumerated(EnumType.STRING)
public Pcategory getVegnonveg() {
	return vegnonveg;
}

public void setVegnonveg(Pcategory vegnonveg) {
	this.vegnonveg = vegnonveg;
}


@ManyToOne
@JoinColumn(name = "pVendor")
public Vendor getpVendor() {
	return pVendor;
}

public void setpVendor(Vendor pVendor) {
	this.pVendor = pVendor;
}


@ManyToOne
@JoinColumn(name = "orderdtls_Id")
public OrderDetails getpOrderDetails() {
	return pOrderDetails;
}

public void setpOrderDetails(OrderDetails pOrderDetails) {
	this.pOrderDetails = pOrderDetails;
}
@Enumerated(EnumType.STRING)
public CuisineType getcType() {
	return cType;
}

public void setcType(CuisineType cType) {
	this.cType = cType;
}

@Override
public String toString() {
	return "Product [pId=" + pId + ", pName=" + pName + ", pPrice=" + pPrice + ", image=" + Arrays.toString(image)
			+ ", vegnonveg=" + vegnonveg + ", cType=" + cType + "]";
}



}
