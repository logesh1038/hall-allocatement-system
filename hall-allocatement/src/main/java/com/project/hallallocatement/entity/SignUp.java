package com.project.hallallocatement.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class SignUp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String password;
	private String staffid;
	private String department;
	public int getid(){
		return id;
	}
		public void setid(int id){
			this.id=id;
		}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getstaffid() {
		return staffid;
	}
	public void setstaffid(String staffid) {
		this.staffid = staffid;
	}
	public String getdepartment(){
		return department;
	}
	public void setdepartment(String department) {
		this.department = department;
	}
	
}
