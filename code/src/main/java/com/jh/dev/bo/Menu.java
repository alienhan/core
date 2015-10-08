/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com 
 * 创建时间：2015-9-21 下午1:40:17 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package com.jh.dev.bo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "menu_tb")
public class Menu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7213427182926027145L;
	/**
	 * 菜单主键
	 */
	private Integer menuId;
	/**
	 * 菜单名字
	 */
	private String menuName;
	/**
	 * 菜单地址
	 */
	private String menuLinkPath;
	/**
	 * 菜单位置
	 */
	private String menuPosit;
	/**
	 * 是否显示菜单
	 */
	private boolean menuValid;
	/**
	 * 菜单显示图片地址
	 */
	private String menuImage;
	/**
	 * 菜单调用方法
	 */
	private String menuFunc;
	/**
	 * 真实路径
	 */
	private String menuRealPath;
	/**
	 * 所属模块
	 */
	private Module module;
	/**
	 * 菜单描述
	 */
	private String menuDesc;
	/**
	 * 用户类型
	 */
	private UserType userType;

	private Set<MenuItem> menuItemSet;

	@Id
	@GeneratedValue
	@Column(name = "MENU_ID", unique = true, nullable = false, insertable = true, updatable = true)
	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	@Column(name = "MENU_NAME")
	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	@Column(name = "MENU_LINK_PATH")
	public String getMenuLinkPath() {
		return menuLinkPath;
	}

	public void setMenuLinkPath(String menuLinkPath) {
		this.menuLinkPath = menuLinkPath;
	}

	@Column(name = "MENU_POSIT")
	public String getMenuPosit() {
		return menuPosit;
	}

	public void setMenuPosit(String menuPosit) {
		this.menuPosit = menuPosit;
	}

	@Column(name = "MENU_VALID")
	public boolean isMenuValid() {
		return menuValid;
	}

	public void setMenuValid(boolean menuValid) {
		this.menuValid = menuValid;
	}

	@Column(name = "MENU_IMAGE")
	public String getMenuImage() {
		return menuImage;
	}

	public void setMenuImage(String menuImage) {
		this.menuImage = menuImage;
	}

	@Column(name = "MENU_FUNC")
	public String getMenuFunc() {
		return menuFunc;
	}

	public void setMenuFunc(String menuFunc) {
		this.menuFunc = menuFunc;
	}

	@Column(name = "MENU_REAL_PATH")
	public String getMenuRealPath() {
		return menuRealPath;
	}

	public void setMenuRealPath(String menuRealPath) {
		this.menuRealPath = menuRealPath;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MODULE_ID", referencedColumnName = "MODULE_ID", insertable = false, updatable = false)
	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	@Column(name = "MENU_DESC")
	public String getMenuDesc() {
		return menuDesc;
	}

	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TYPE_ID", referencedColumnName = "TYPE_ID", insertable = false, updatable = false)
	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "menu")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	public Set<MenuItem> getMenuItemSet() {
		return menuItemSet;
	}

	public void setMenuItemSet(Set<MenuItem> menuItemSet) {
		this.menuItemSet = menuItemSet;
	}

}
