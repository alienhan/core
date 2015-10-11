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

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jh.core.util.Condition;
import com.jh.dev.bo.MenuModule;
import com.jh.dev.dao.MenuModuleDao;

@Transactional
@Service
public class MenuModuleService {

	@Autowired
	private MenuModuleDao moduleDao;

	public void saveModule(MenuModule module) {
		moduleDao.saveModule(module);
	}

	public void deleteModule(MenuModule module) {
		moduleDao.deleteModule(module);
	}

	public void updateModule(MenuModule module) {
		moduleDao.updateModule(module);
	}

	public MenuModule getModule(int id) {
		return moduleDao.getModule(id);
	}
	
	public MenuModule findUniqueModuleByJPQL(Map<String, Object> parameterMap){
		return moduleDao.findUniqueModuleByJPQL(parameterMap);
	}
	
	public List<MenuModule> findModuleByJPQL(MenuModule module, Object... params){
		return moduleDao.findModuleByJPQL(module, params);
	}
	
	public Condition<MenuModule> findModuleByJPQLWithPage(Condition<MenuModule> condition){
		return moduleDao.findModuleByJPQLWithPage(condition);
	}

}
