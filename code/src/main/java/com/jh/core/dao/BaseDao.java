/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com 
 * 创建时间：2015-9-21 下午1:24:08 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package com.jh.core.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import com.jh.core.exception.DaoException;
import com.jh.core.util.Condition;

/**
 * 数据访问接口基类
 * 
 * @ClassName: BaseDao
 * @author jh
 * @date 2015-9-23 上午10:29:53
 * 
 */
@Repository
public class BaseDao extends BaseDaoSupport {

	/**
	 * QL选项：JPA语法
	 */
	private final int QL_JPA = 1;
	/**
	 * QL选项：原生SQL
	 */
	private final int QL_NATIVE = 2;

	@PersistenceContext(unitName = "itcast")
	protected EntityManager em;

	/**
	 * 保存实体对象
	 * 
	 * @Title: save
	 * @Author: jianghan
	 * @param entity
	 * 
	 */
	protected <T> void save(T entity) {
		try {
			em.persist(entity);
		} catch (HibernateException ex) {
			throw new DaoException(ex);
		}
	}

	/**
	 * 删除实体对象
	 * 
	 * @Title: delete
	 * @Author: jianghan
	 * @param entity
	 * 
	 */
	protected <T> void delete(T entity) {
		try {
			em.remove(em.merge(entity));
		} catch (HibernateException ex) {
			throw new DaoException(ex);
		}
	}

	/**
	 * 更新实体对象
	 * 
	 * @Title: update
	 * @Author: jianghan
	 * @param entity
	 * @return
	 * 
	 */
	protected <T> T update(T entity) {
		try {
			return em.merge(entity);
		} catch (HibernateException ex) {
			throw new DaoException(ex);
		}
	}

	/**
	 * 根据实体类型和主键获取实体对象
	 * 
	 * @Title: get
	 * @Author: jianghan
	 * @param entityClass
	 * @param id
	 * @return 获取的实体类
	 * 
	 */
	protected <T> T get(Class<T> entityClass, Object id) {
		try {
			return em.find(entityClass, id);
		} catch (HibernateException ex) {
			throw new DaoException(ex);
		}
	}

	/**
	 * 根据SQL语句查询获取单个对象
	 * 
	 * @Title: findUniqueBySQL
	 * @Author: jianghan
	 * @param ql
	 * @param params
	 * @return
	 * 
	 */
	protected <T> T findUniqueBySQL(String sql, Object... params) {
		return super.findUniqueByQL(em, sql, QL_NATIVE, params);
	}

	/**
	 * 根据JPQL语句查询获取单个对象
	 * 
	 * @Title: findUniqueByJPQL
	 * @Author: jianghan
	 * @param ql
	 * @param params
	 * @return
	 * 
	 */
	protected <T> T findUniqueByJPQL(String jpql, Object... params) {
		return super.findUniqueByQL(em, jpql, QL_JPA, params);
	}

	/**
	 * 根据SQL语句查询
	 * 
	 * @Title: findBySQL
	 * @Author: jianghan
	 * @param ql
	 * @param params
	 * @return
	 * 
	 */
	protected <T> List<T> findBySQL(String sql, Object... params) {
		return super.findByQL(em, sql, QL_NATIVE, params);
	}

	/**
	 * 根据JPQL语句查询
	 * 
	 * @Title: findByJPQL
	 * @Author: jianghan
	 * @param ql
	 * @param params
	 * @return
	 * 
	 */
	protected <T> List<T> findByJPQL(String jpql, Object... params) {
		return super.findByQL(em, jpql, QL_JPA, params);
	}

	/**
	 * 根据SQL语句分页查询，返回条件对象
	 * 
	 * @Title: findBySQLWithPage
	 * @Author: jianghan
	 * @param condition
	 *            查询条件
	 * @param params
	 *            查询参数（可选）
	 * @return 条件对象
	 * 
	 */
	protected <T> Condition<T> findBySQLWithPage(Condition<T> condition,
			Object... params) {
		return super.findByQLWithPage(em, condition, QL_NATIVE, params);
	}

	/**
	 * 根据SQL语句分页查询，返回条件对象
	 * 
	 * @Title: findByJPQLWithPage
	 * @Author: jianghan
	 * @param condition
	 *            查询条件
	 * @param params
	 *            查询参数（可选）
	 * @return 条件对象
	 * 
	 */
	protected <T> Condition<T> findByJPQLWithPage(Condition<T> condition,
			Object... params) {
		return super.findByQLWithPage(em, condition, QL_JPA, params);
	}

	/**
	 * 根据SQL语句（使用聚合函数count）获取记录数
	 * 
	 * @Title: countBySQL
	 * @Author: jianghan
	 * @param condition
	 * @param params
	 * @return
	 * 
	 */
	protected <T> int countBySQL(Condition<T> condition, Object... params) {
		return super.countByQl(em, condition, QL_NATIVE, params);
	}

	/**
	 * 根据JPQL语句（使用聚合函数count）获取记录数
	 * 
	 * @Title: countByJPQL
	 * @Author: jianghan
	 * @param condition
	 *            查询条件
	 * @param params
	 *            查询参数（可选）
	 * @return
	 * 
	 */
	protected <T> int countByJPQL(Condition<T> condition, Object... params) {
		return super.countByQl(em, condition, QL_JPA, params);
	}
}
