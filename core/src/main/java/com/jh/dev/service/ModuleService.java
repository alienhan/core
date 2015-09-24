/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com 
 * 创建时间：2015-9-23 下午1:37:48 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package com.jh.dev.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jh.core.util.Condition;
import com.jh.dev.bo.Module;
import com.jh.dev.dao.ModuleDao;

@Transactional
@Service
public class ModuleService {

	@Autowired
	private ModuleDao moduleDao;

	public void saveModule(Module module) {
		moduleDao.saveModule(module);
	}

	public void deleteModule(Module module) {
		moduleDao.deleteModule(module);
	}

	public void updateModule(Module module) {
		moduleDao.updateModule(module);
	}

	public Module getModule(int id) {
		return moduleDao.getModule(id);
	}
	
	public Module findUniqueModuleByJPQL(Map<String, Object> parameterMap){
		return moduleDao.findUniqueModuleByJPQL(parameterMap);
	}
	
	public Condition<Module> findModuleByJPQLWithPage(Condition<Module> condition){
		return moduleDao.findModuleByJPQLWithPage(condition);
	}

}
