package com.billionfun.bms.product.mall.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the sys_role database table.
 * 
 */
@Entity
@Table(name="sys_role")
@NamedQuery(name="SysRole.findAll", query="SELECT s FROM SysRole s")
public class SysRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private String code;

	private String name;

	private int status;
	
	@JsonIgnoreProperties
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@ManyToMany(mappedBy = "listRoles",cascade=CascadeType.ALL)
	private List<SysUser> listUsers;

	public SysRole() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<SysUser> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<SysUser> listUsers) {
		this.listUsers = listUsers;
	}
	
	

}