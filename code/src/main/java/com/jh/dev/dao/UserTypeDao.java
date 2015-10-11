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

import com.jh.core.constants.Constants;
import com.jh.core.dao.BaseDao;
import com.jh.core.util.Condition;
import com.jh.core.util.Page;
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
	/**
	 * 查询
	 * 
	 * @Title: save
	 * @Author: jianghan
	 * @param userType
	 * 
	 */
	public void save(UserType userType) {
		super.save(userType);
	}

	/**
	 * 删除
	 * 
	 * @Title: delete
	 * @Author: jianghan
	 * @param userType
	 * 
	 */
	public void delete(UserType userType) {
		super.delete(userType);
	}

	/**
	 * 更新
	 * 
	 * @Title: update
	 * @Author: jianghan
	 * @param userType
	 * 
	 */
	public void update(UserType userType) {
		super.update(userType);
	}

	/**
	 * 查询单个对象
	 * 
	 * @Title: get
	 * @Author: jianghan
	 * @param id
	 * @return
	 * 
	 */
	public UserType get(int id) {
		return super.get(UserType.class, id);
	}

	/**
	 * 搜索提示
	 * 
	 * @Title: SearchReminder
	 * @Author: jianghan
	 * @param condition
	 * @return
	 * 
	 */
	public Condition<UserType> searchReminder(Condition<UserType> condition) {
		StringBuffer jpql = new StringBuffer(
				"select distinct ut.typeName ,ut.typeTag from UserType ut where 1=1");
		Map<String, Object> parameterMap = new HashMap<String, Object>();

		if (StringUtils.isNotBlank(condition.getSearch())) {
			jpql.append(" and ut.typeName like :typeName");
			parameterMap.put("typeName", "%" + condition.getSearch() + "%");

		}
		jpql.append(" order by ut.typeId desc");
		
		condition.setQl(jpql.toString());
		Page page = Page.EMPTY_PAGE;
		condition.setPage(page);
		condition.getPage().setPageNo(Constants.SEARCH_FIRST);
		condition.getPage().setPageSize(Constants.SEARCH_MAX);
		
		return super.findByJPQLWithPage(condition, parameterMap);
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
		StringBuffer jpql = new StringBuffer(
				"select ut from UserType ut where 1=1");
		Map<String, Object> parameterMap = new HashMap<String, Object>();

		if (StringUtils.isNotBlank(condition.getSearch())) {
			jpql.append(" and ut.typeName like :typeName");
			parameterMap.put("typeName", "%" + condition.getSearch() + "%");

		}
		jpql.append(" order by ut.typeId asc");

		condition.setQl(jpql.toString());
		return super.findByJPQLWithPage(condition, parameterMap);
	}
}
