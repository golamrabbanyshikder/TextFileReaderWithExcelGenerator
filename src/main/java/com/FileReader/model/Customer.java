package com.FileReader.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String card_type;
	private String title;
	private String name;
	private String d_o_b;
	private String sex;
	private String Adress;
	private String limit_amt;

//	public Customer() {
//
//	}
//
//	public Customer(int id, String card_type, String title, String name, String d_o_b, String sex, String Adress,
//			String limit_amt) {
//		this.id = id;
//		this.card_type = card_type;
//		this.title = title;
//		this.name = name;
//		this.d_o_b = d_o_b;
//		this.sex = sex;
//		this.Adress = Adress;
//		this.limit_amt = limit_amt;
//
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCard_type() {
		return card_type;
	}

	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getD_o_b() {
		return d_o_b;
	}

	public void setD_o_b(String d_o_b) {
		this.d_o_b = d_o_b;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAdress() {
		return Adress;
	}

	public void setAdress(String adress) {
		Adress = adress;
	}

	public String getLimit_amt() {
		return limit_amt;
	}

	public void setLimit_amt(String limit_amt) {
		this.limit_amt = limit_amt;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", card_type=" + card_type + ", title=" + title + ", name=" + name + ", d_o_b="
				+ d_o_b + ", sex=" + sex + ", Adress=" + Adress + ", limit_amt=" + limit_amt + "]";
	}

}
