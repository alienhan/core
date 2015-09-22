/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com 
 * 创建时间：2015-9-21 下午1:41:10 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package com.jh.dev.dao;

import org.springframework.stereotype.Repository;

import com.jh.core.dao.BaseDao;
import com.jh.core.util.Condition;
import com.jh.dev.bo.Menu;
import com.jh.dev.bo.Module;

/** 
 * 菜单dao
 *
 * @ClassName: MenuDao 
 * @author jh 
 * @date 2015-9-21 下午4:54:44 
 *  
 */
@Repository
public class MenuDao extends BaseDao{

	/** 
	 * 保存或更新菜单
	 *
	 * @Title: update 
	 * @Author: jianghan
	 * @param menu
	 * @return
	 *    
	 */
	public Condition<Menu> update(Menu menu){
		Condition<Menu> conditionParam = new Condition<Menu>();
		super.update(menu);
		return conditionParam;
	}
	
	public Condition<Menu> save(Menu menu){
		Condition<Menu> conditionParam = new Condition<Menu>();
		super.save(menu);
		return conditionParam;
	}
	
	public Condition<Module> saveModule(Module module){
		Condition<Module> conditionParam = new Condition<Module>();
		super.save(module);
		return conditionParam;
	}
}
