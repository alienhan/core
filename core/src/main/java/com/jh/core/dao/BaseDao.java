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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class BaseDao {
	@PersistenceContext
	protected EntityManager em;
	
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
	protected <T> T get(Class<T> entityClass ,Object id){
		return em.find(entityClass, id);
	}
	
	/** 
	 * 保存实体对象
	 *
	 * @Title: save 
	 * @Author: jianghan
	 * @param entity
	 *    
	 */
	protected <T> void save(T entity){
		 em.persist(entity);
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
	protected <T> T update(T entity){
		return em.merge(entity);
	}
	
	protected <T> void delete(T entity){
		em.remove(entity);
	}
 }
