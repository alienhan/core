/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com 
 * 创建时间：2015-9-23 下午1:12:16 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package com.jh.dev.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.jh.core.dao.BaseDao;
import com.jh.core.util.Condition;
import com.jh.dev.bo.MenuModule;

@Repository
public class MenuModuleDao extends BaseDao{
	/** 
	 * 保存菜单模型
	 *
	 * @Title: saveModule 
	 * @Author: jianghan
	 * @param module
	 *    
	 */
	public void saveModule(MenuModule module) {
		super.save(module);
	}
	
	/** 
	 * 删除菜单模型
	 *
	 * @Title: deleteModule 
	 * @Author: jianghan
	 * @param module
	 *    
	 */
	public void deleteModule(MenuModule module){
		super.delete(module);
	}
	
	/** 
	 * 更新菜单模型
	 *
	 * @Title: updateModule 
	 * @Author: jianghan
	 * @param module
	 *    
	 */
	public void updateModule(MenuModule module){
		super.update(module);
	}
	
	/** 
	 * 通过id获取菜单模型
	 *
	 * @Title: getModule 
	 * @Author: jianghan
	 * @param id
	 * @return
	 *    
	 */
	public MenuModule getModule(int id){
		return super.get(MenuModule.class, id);
	}
	
	/** 
	 * 获取单个对象 jpql
	 *
	 * @Title: findUniqueModuleByJPQL 
	 * @Author: jianghan
	 * @param parameterMap
	 * @return
	 *    
	 */
	public MenuModule findUniqueModuleByJPQL(Map<String, Object> parameterMap){
		StringBuffer jpql = new StringBuffer("select mm from MenuModule mm where 1=1");
		if(StringUtils.isNotBlank(parameterMap.get("moduleTag").toString())){
			jpql.append(" and mm.moduleTag=:moduleTag");
		}
		
		return super.findUniqueByJPQL(jpql.toString(), parameterMap);
	}
	
	/** 
	 * 查询 jpql
	 *
	 * @Title: findModuleByJPQL 
	 * @Author: jianghan
	 * @param module
	 * @param params
	 * @return
	 *    
	 */
	public List<MenuModule> findModuleByJPQL(MenuModule module, Object... params){
		StringBuffer jpql = new StringBuffer("select mm from MenuModule mm where 1=1");
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		
		if(StringUtils.isNotBlank(module.getModuleName())){
			jpql.append(" and mm.moduleName=:moduleName");
			parameterMap.put("moduleName", module.getModuleName());
		}
		jpql.append(" order by mm.moduleId desc");
		
		return super.findByJPQL(jpql.toString(), params);
	}
	
	/** 
	 * 分页查询 jpql
	 *
	 * @Title: findModuleByJPQLWithPage 
	 * @Author: jianghan
	 * @param condition
	 * @return
	 *    
	 */
	public Condition<MenuModule> findModuleByJPQLWithPage(Condition<MenuModule> condition){
		StringBuffer jpql = new StringBuffer("select mm from MenuModule mm where 1=1");
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		
		if(StringUtils.isNotBlank(condition.getT().getModuleName())){
			jpql.append(" and mm.moduleName=:moduleName");
			parameterMap.put("moduleName", condition.getT().getModuleName());
		}
		jpql.append(" order by mm.moduleId asc");
		
		condition.setQl(jpql.toString());
		return super.findByJPQLWithPage(condition, parameterMap);
	}
}
