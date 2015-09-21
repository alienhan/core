/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com 
 * 创建时间：2015-9-21 下午2:20:12 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package com.jh.dev.bo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

public class Module implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7347772669234034460L;
	/**
	 * 模块主键
	 */
	private int moduleId;
	/**
	 * 模块名字
	 */
	private String moduleName;
	/**
	 * 模块标签
	 */
	private int moduleTag;
	/**
	 * 菜单主键
	 */
	private Set<Menu> menuSet;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "MENU_ID", unique = true, nullable = false, insertable = true, updatable = true)
	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	
	@Column(name = "MODULE_NAME")
	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	@Column(name = "MODULE_TAG")
	public int getModuleTag() {
		return moduleTag;
	}

	public void setModuleTag(int moduleTag) {
		this.moduleTag = moduleTag;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "module")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	public Set<Menu> getMenuSet() {
		return menuSet;
	}

	public void setMenuSet(Set<Menu> menuSet) {
		this.menuSet = menuSet;
	}

}
