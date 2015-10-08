/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com 
 * 创建时间：2015-9-21 下午2:19:57 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package com.jh.dev.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "menu_item_tb")
public class MenuItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8795370729204084832L;
	/**
	 * 子菜单主键
	 */
	private Integer itemId;
	/**
	 * 子菜单名字
	 */
	private String itemName;
	/**
	 * 子菜单地址
	 */
	private String itemAddress;
	/**
	 * 子菜单位置
	 */
	private String itemPosition;
	/**
	 * 是否显示子菜单
	 */
	private String itemValid;
	/**
	 * 子菜单图片地址
	 */
	private String itemImage;
	/**
	 * 子菜单调用方法
	 */
	private String itemFunc;
	/**
	 * 子菜单真实路径
	 */
	private String itemRealPath;
	/**
	 * 子菜单显示级别
	 */
	private String itemRank;
	/**
	 * 所属父菜单
	 */
	private String itemParentId;
	/**
	 * 菜单
	 */
	private Menu menu;
	/**
	 * 子菜单描述
	 */
	private String itemDesc;

	@Id
	@GeneratedValue(generator = "uuid", strategy = GenerationType.AUTO)
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "ITEM_ID", unique = true, nullable = false, insertable = true, updatable = true)
	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	@Column(name = "ITEM_NAME")
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Column(name = "ITEM_ADDRESS")
	public String getItemAddress() {
		return itemAddress;
	}

	public void setItemAddress(String itemAddress) {
		this.itemAddress = itemAddress;
	}

	@Column(name = "ITEM_POSITION")
	public String getItemPosition() {
		return itemPosition;
	}

	public void setItemPosition(String itemPosition) {
		this.itemPosition = itemPosition;
	}

	@Column(name = "ITEM_VALID")
	public String getItemValid() {
		return itemValid;
	}

	public void setItemValid(String itemValid) {
		this.itemValid = itemValid;
	}

	@Column(name = "ITEM_IMAGE")
	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	@Column(name = "ITEM_FUNC")
	public String getItemFunc() {
		return itemFunc;
	}

	public void setItemFunc(String itemFunc) {
		this.itemFunc = itemFunc;
	}

	@Column(name = "ITEM_REAL_PATH")
	public String getItemRealPath() {
		return itemRealPath;
	}

	public void setItemRealPath(String itemRealPath) {
		this.itemRealPath = itemRealPath;
	}

	@Column(name = "ITEM_RANK")
	public String getItemRank() {
		return itemRank;
	}

	public void setItemRank(String itemRank) {
		this.itemRank = itemRank;
	}

	@Column(name = "ITEM_PARENT_ID")
	public String getItemParentId() {
		return itemParentId;
	}

	public void setItemParentId(String itemParentId) {
		this.itemParentId = itemParentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MENU_ID", referencedColumnName = "MENU_ID", insertable = false, updatable = false)
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@Column(name = "ITEM_DESC")
	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

}
