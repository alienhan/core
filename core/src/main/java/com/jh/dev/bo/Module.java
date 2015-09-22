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
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "module_tb")
public class Module implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7347772669234034460L;
	/**
	 * 模块主键
	 */
	private Integer moduleId;
	/**
	 * 模块名字
	 */
	private String moduleName;
	/**
	 * 模块标签
	 */
	private Integer moduleTag;
	/**
	 * 菜单主键
	 */
	private Set<Menu> menuSet;

	@Id
	@GeneratedValue
	@Column(name = "MODULE_ID", unique = true, nullable = false, insertable = true, updatable = true)
	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
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
	public Integer getModuleTag() {
		return moduleTag;
	}

	public void setModuleTag(Integer moduleTag) {
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
