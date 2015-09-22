/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com 
 * 创建时间：2015-9-21 下午1:41:41 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package com.jh.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jh.core.util.Condition;
import com.jh.dev.bo.Menu;
import com.jh.dev.bo.Module;
import com.jh.dev.dao.MenuDao;

@Transactional
@Service
public class MenuService {
	@Autowired
	private MenuDao menuDao;
	
	public Condition<Menu> update(Menu menu){
		return menuDao.update(menu);
	}
	
	public Condition<Menu> save(Menu menu){
		return menuDao.save(menu);
	}
	
	public Condition<Module> saveModule(Module module){
		return menuDao.saveModule(module);
	}
}
