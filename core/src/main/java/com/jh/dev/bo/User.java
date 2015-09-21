/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com 
 * 创建时间：2015-9-21 下午1:40:27 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package com.jh.dev.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -296538986036320598L;
	/**
	 * 用户主键
	 */
	private int userId;
	/**
	 * 用户名字
	 */
	private String userName;
	/**
	 * 用户密码
	 */
	private String userPwd;
	/**
	 * 用户初始密码
	 */
	private String userInitPwd;
	/**
	 * 用户昵称
	 */
	private String userNickName;
	/**
	 * 用户电子邮箱
	 */
	private String userEmail;
	/**
	 * 用户联系电话
	 */
	private String userTel;
	/**
	 * 此用户是否是有效用户
	 */
	private String userValid;
	/**
	 * 用户旧密码
	 */
	private String userPrevPwd;
	/**
	 * 用户类型
	 */
	private UserType userType;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "USER_ID", unique = true, nullable = false, insertable = true, updatable = true)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "USER_NAME")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "USER_PWD")
	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	@Column(name = "USER_INIT_PWD")
	public String getUserInitPwd() {
		return userInitPwd;
	}

	public void setUserInitPwd(String userInitPwd) {
		this.userInitPwd = userInitPwd;
	}

	@Column(name = "USER_NICK_NAME")
	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	@Column(name = "USER_EMAIL")
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Column(name = "USER_TEL")
	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	@Column(name = "USER_VALID")
	public String getUserValid() {
		return userValid;
	}

	public void setUserValid(String userValid) {
		this.userValid = userValid;
	}

	@Column(name = "USER_PREV_PWD")
	public String getUserPrevPwd() {
		return userPrevPwd;
	}

	public void setUserPrevPwd(String userPrevPwd) {
		this.userPrevPwd = userPrevPwd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TYPE_ID", referencedColumnName = "TYPE_ID", insertable = false, updatable = false)
	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

}
