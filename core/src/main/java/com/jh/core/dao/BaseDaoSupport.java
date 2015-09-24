/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com 
 * 创建时间：2015-9-23 上午10:08:18 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package com.jh.core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;

import com.jh.core.exception.DaoException;
import com.jh.core.util.Condition;
import com.jh.core.util.Page;

/**
 * 数据访问接口基类父类，处理语句
 * 
 * @ClassName: BaseSupport
 * @author jh
 * @date 2015-9-23 上午10:29:32
 * 
 */
public class BaseDaoSupport {

	/** QL选项：JPA语法 */
	private final int QL_JPA = 1;

	/** QL选项：原生SQL */
	private final int QL_NATIVE = 2;

	/**
	 * 根据QL选项适配JPA语法或原生SQL，返回Query对象
	 * 
	 * @Title: createAdaptor
	 * @Author: jianghan
	 * @param em
	 * @param ql
	 * @param opt
	 * @return
	 * 
	 */
	private Query createAdaptor(EntityManager em, String ql, int opt) {
		switch (opt) {
		case QL_JPA:
			return em.createQuery(ql);
		case QL_NATIVE:
			return em.createNativeQuery(ql);
		default:
			return null;
		}
	}

	/**
	 * 将QL参数统一转为位置参数，返回Query对象
	 * 
	 * @Title: create
	 * @Author: jianghan
	 * @param em
	 * @param ql
	 * @param opt
	 * @param params
	 * @return
	 * 
	 */
	private Query create(EntityManager em, String ql, int opt, Object... params) {
		Query query = null;

		if (params == null) {
			// 无参数，直接生成适配的Query对象
			
			query = this.createAdaptor(em, ql, opt);
		} else if (params.length == 1 && params[0] instanceof Map) {
			// 集合类型参数(Map)，将命名参数统一转为位置参数

			Map<Integer, Object> map = new HashMap<Integer, Object>();
			Map<?, ?> parametersMap = (Map<?, ?>) params[0];
			int p = 1;
			for (Object k : parametersMap.keySet()) {
				if (k instanceof String) {
					ql = ql.replaceAll(":" + k, "?" + p);
					map.put(p++, parametersMap.get(k));
				} else if (k instanceof Integer) {
					ql = ql.replaceAll("\\?" + k, "?" + p);
					map.put(p++, parametersMap.get(k));
				}
			}

			query = this.createAdaptor(em, ql, opt);

			for (int i = 1; i <= map.size(); i++) {
				query.setParameter(i, map.get(i));
			}
		} else {
			// 不定长参数，认定为位置参数，根据参数位置进行设置

			query = this.createAdaptor(em, ql, opt);

			for (int i = 1; i <= params.length; i++) {
				query.setParameter(i, params[i - 1]);
			}
		}

		// 返回Query对象
		return query;
	}

	/**
	 * 根据QL语句查询获取单个对象
	 * 
	 * @param em
	 * @param ql
	 * @param opt
	 * @param params
	 *            参数（可选）
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T> T findUniqueByQL(EntityManager em, String ql, int opt,
			Object... params) {
		try {
			Query query = this.create(em, ql, opt, params);

			// 设置查询结果的开始记录数（从0开始计数）
			query.setFirstResult(0);

			// 设置查询结果的结束记录数（获取单个对象）
			query.setMaxResults(1);

			List<T> list = (List<T>) query.getResultList();
			return list == null ? null : list.isEmpty() ? null : list.get(0);
		} catch (HibernateException ex) {
			throw new DaoException(ex);
		}
	}

	/**
	 * 根据QL语句查询
	 * 
	 * @param em
	 * @param ql
	 *            查询语句
	 * @param opt
	 *            使用语言类型
	 * @param params
	 *            参数（可选）
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T> List<T> findByQL(EntityManager em, String ql, int opt,
			Object... params) {
		try {
			Query query = this.create(em, ql, opt, params);
			return (List<T>) query.getResultList();
		} catch (HibernateException ex) {
			throw new DaoException(ex);
		}
	}

	/**
	 * 根据QL语句分页查询，返回页对象
	 * @param <T>
	 * 
	 * @param em
	 * @param ql
	 * @param condition
	 * @param pn
	 *            当前页码
	 * @param ps
	 *            每页记录数
	 * @param params
	 *            参数（可选）
	 * @return
	 */
	@SuppressWarnings({"unchecked" })
	protected <T> Condition<T> findByQLWithPage(EntityManager em, String ql, Condition<T> condition, int opt, Object... params) {
		
		Condition<T> conditionParam = new Condition<T>();
		int pageNo = condition.getPage().getPageNo();
		int pageSize = condition.getPage().getPageSize();
		
		if (StringUtils.isBlank(ql)) {
			Page page = Page.EMPTY_PAGE;
			conditionParam.setPage(page);
		}
		try {

			if (pageNo < 1) {
				pageNo = 1;
			}
			if (pageSize < 1) {
				pageSize = Page.DEFAULT_PAGE_SIZE;
			}

			Query query = this.create(em, ql, opt, params);

			// 设置查询结果的开始记录数（从0开始计数）
			int firstResult = (pageNo - 1) * pageSize;
			query.setFirstResult(firstResult);
			// 设置查询结果的结束记录数
			query.setMaxResults(pageSize);
			
			List<T> list = query.getResultList();
			conditionParam.setList(list);
			Page page = new Page(list.size(), pageNo, pageSize);
			conditionParam.setPage(page);
			
			return conditionParam;
		} catch (HibernateException ex) {
			throw new DaoException(ex);
		}
	}

}
