package com.example.demo.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class items {
@Id
@GeneratedValue
@Column(name="item_id")
private Integer itemId;
@Column(name="item_name")
private String itemName;
@Column(name="item_price")
private Integer itemPrice;
public Integer getItemId() {
	return itemId;
}

public void setItemId(Integer itemId) {
	this.itemId = itemId;
}

public String getItemName() {
	return itemName;
}

public void setItemName(String ItemName) {
	this.itemName = itemName;
}
public Integer getItemPrice() {
	return itemPrice;
}

public void setItemPrice(Integer itemPrice) {
	this.itemPrice = itemPrice;
}
@Override
public String toString() {
	return "items [itemId=" + itemId + ", itemName=" + itemName + ", itemPrice=" + itemPrice + "]";
}
}
