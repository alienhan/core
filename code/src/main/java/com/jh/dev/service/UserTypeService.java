/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com 
 * 创建时间：2015-9-28 下午2:56:55 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package com.jh.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jh.core.util.Condition;
import com.jh.dev.bo.UserType;
import com.jh.dev.dao.UserTypeDao;

@Transactional
@Service
public class UserTypeService {

	@Autowired
	UserTypeDao userTypeDao;
	
	public void save(UserType userType) {
		userTypeDao.save(userType);
	}

	public void delete(UserType userType) {
		userTypeDao.delete(userType);
	}

	public void update(UserType userType) {
		userTypeDao.update(userType);
	}

	public UserType get(int id) {
		return userTypeDao.get(id);
	}
	
	public Condition<UserType> searchReminder(Condition<UserType> condition){
		return userTypeDao.searchReminder(condition);
	}

	/**
	 * 分页
	 * 
	 * @Title: findByJPQLWithPage
	 * @Author: jianghan
	 * @param condition
	 * @return
	 * 
	 */
	public Condition<UserType> findByJPQLWithPage(Condition<UserType> condition) {
		return userTypeDao.findByJPQLWithPage(condition);
	}
}
