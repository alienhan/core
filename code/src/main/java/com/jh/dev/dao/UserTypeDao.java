/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com 
 * 创建时间：2015-9-24 上午10:26:42 
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
import com.jh.dev.bo.UserType;

/** 
 * 用户类型数据处理类
 *
 * @ClassName: UserTypeDao 
 * @author jh 
 * @date 2015-9-28 下午3:22:27 
 *  
 */
@Repository
public class UserTypeDao extends BaseDao {
	public void save(UserType userType){
		super.save(userType);
	}
	
	public void delete(UserType userType){
		super.delete(userType);
	}
	
	public void update(UserType userType){
		super.update(userType);
	}
	
	public UserType get(int id){
		return super.get(UserType.class, id);
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
	public Condition<UserType> findByJPQLWithPage(Condition<UserType> condition){
		StringBuffer jpql = new StringBuffer("select ut from UserType ut where 1=1");
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		
		if(StringUtils.isNotBlank(condition.getT().getTypeName())){
			jpql.append(" and ut.typeName=:typeName");
			parameterMap.put("typeName", condition.getT().getTypeName());
		}
		if(condition.getT().getTypeTag() != 0){
			jpql.append(" and ut.typeTag=:typeTag");
			parameterMap.put("typeTag", condition.getT().getTypeTag());
		}
		jpql.append(" order by ut.typeId asc");
		
		condition.setQl(jpql.toString());
		return super.findByJPQLWithPage(condition, parameterMap);
	}
}
