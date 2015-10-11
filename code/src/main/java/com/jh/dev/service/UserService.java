/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com 
 * 创建时间：2015-9-21 下午1:41:50 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package com.jh.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jh.core.util.Condition;
import com.jh.dev.bo.User;
import com.jh.dev.dao.UserDao;

@Transactional
@Service
public class UserService {
	@Autowired
	UserDao userDao;

	public void save(User User) {
		userDao.save(User);
	}

	public void delete(User User) {
		userDao.delete(User);
	}

	public void update(User User) {
		userDao.update(User);
	}

	public User get(int id) {
		return userDao.get(id);
	}
	
	/** 
	 * 查询提示
	 *
	 * @Title: searchReminder 
	 * @Author: jianghan
	 * @param condition
	 * @return
	 *    
	 */
	public Condition<User> searchReminder(Condition<User> condition){
		return userDao.searchReminder(condition);
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
	public Condition<User> findByJPQLWithPage(Condition<User> condition) {
		return userDao.findByJPQLWithPage(condition);
	}
}
