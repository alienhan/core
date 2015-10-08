/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com 
 * 创建时间：2015-9-21 下午1:41:20 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package com.jh.dev.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.jh.core.dao.BaseDao;
import com.jh.core.util.Condition;
import com.jh.dev.bo.User;

@Repository
public class UserDao extends BaseDao{
	public void save(User User){
		super.save(User);
	}
	
	public void delete(User User){
		super.delete(User);
	}
	
	public void update(User User){
		super.update(User);
	}
	
	public User get(int id){
		return super.get(User.class, id);
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
	public Condition<User> findByJPQLWithPage(Condition<User> condition){
		StringBuffer jpql = new StringBuffer("select u from User u where 1=1");
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		
		if(StringUtils.isNotBlank(condition.getT().getUserName())){
			jpql.append(" and u.userName=:userName");
			parameterMap.put("userName", condition.getT().getUserName());
		}
		if(StringUtils.isNoneBlank(condition.getT().getUserEmail())){
			jpql.append(" and u.userEmail=:userEmail");
			parameterMap.put("userEmail", condition.getT().getUserEmail());
		}
		
		jpql.append(" order by u.userId asc");
		
		condition.setQl(jpql.toString());
		return super.findByJPQLWithPage(condition, parameterMap);
	}
}
