/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com 
 * 创建时间：2015-9-21 下午2:20:27 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package com.jh.dev.bo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

public class UserType {
	/**
	 * 用户类型主键
	 */
	private int typeId;
	/**
	 * 用户名字
	 */
	private String typeName;
	/**
	 * 用户类型标签
	 */
	private int typeTag;

	/**
	 * 用户
	 */
	private Set<User> userSet;
	
	/**
	 * 菜单
	 */
	private Set<Menu> menuSet;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "TYPE_ID", unique = true, nullable = false, insertable = true, updatable = true)
	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	@Column(name = "TYPE_NAME")
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Column(name = "TYPE_TAG")
	public int getTypeTag() {
		return typeTag;
	}

	public void setTypeTag(int typeTag) {
		this.typeTag = typeTag;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userType")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	public Set<User> getUserSet() {
		return userSet;
	}

	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userType")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	public Set<Menu> getMenuSet() {
		return menuSet;
	}

	public void setMenuSet(Set<Menu> menuSet) {
		this.menuSet = menuSet;
	}
	
	

}
