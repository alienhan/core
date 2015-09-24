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
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.jh.core.dao.BaseDao;
import com.jh.core.util.Condition;
import com.jh.dev.bo.Module;

@Repository
public class ModuleDao extends BaseDao{
	/** 
	 * 保存菜单模型
	 *
	 * @Title: saveModule 
	 * @Author: jianghan
	 * @param module
	 *    
	 */
	public void saveModule(Module module) {
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
	public void deleteModule(Module module){
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
	public void updateModule(Module module){
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
	public Module getModule(int id){
		return super.get(Module.class, id);
	}
	
	/** 
	 * 通过jpql获取单个对象
	 *
	 * @Title: findUniqueModuleByJPQL 
	 * @Author: jianghan
	 * @param parameterMap
	 * @return
	 *    
	 */
	public Module findUniqueModuleByJPQL(Map<String, Object> parameterMap){
		StringBuffer jpql = new StringBuffer("select m from Module m where 1=1 and ");
		if(StringUtils.isNotBlank(parameterMap.get("moduleTag").toString())){
			jpql.append(" m.moduleTag=:moduleTag");
		}
		
		return super.findUniqueByJPQL(jpql.toString(), parameterMap);
	}
	
	public Condition<Module> findModuleByJPQLWithPage(Condition<Module> condition){
		StringBuffer jpql = new StringBuffer("select m from Module m where 1=1");
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		
		
		return super.findByJPQLWithPage(jpql.toString(), condition, parameterMap);
	}
}
