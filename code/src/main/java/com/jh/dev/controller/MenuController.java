/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com 
 * 创建时间：2015-9-21 下午1:40:42 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package com.jh.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jh.core.util.Condition;
import com.jh.dev.bo.Menu;
import com.jh.dev.bo.MenuModule;
import com.jh.dev.bo.UserType;
import com.jh.dev.service.MenuService;

@Controller
public class MenuController {
	@Autowired
	private MenuService menuService;

	/**
	 * 保存主菜单
	 * 
	 * @Title: save_menu
	 * @Author: jianghan
	 * @param menu
	 * @param model
	 * @return
	 * 
	 */
	@RequestMapping("menu/save_menu")
	public String save_menu(Menu menu, Model model) {
		menu.setMenuId(null);
		UserType userType = new UserType();
		MenuModule module = new MenuModule();
		menu.setModule(module);
		menu.setUserType(userType);
		menuService.saveMenu(menu);
		return "menu/center";
	}

	/**
	 * 更新主菜单
	 * 
	 * @Title: update_menu
	 * @Author: jianghan
	 * @param menu
	 * @param model
	 * @return
	 * 
	 */
	@RequestMapping("/menu/update_menu")
	public String update_menu(Menu menu, Model model) {
		menuService.updateMenu(menu);
		return "menu/center";
	}

	@RequestMapping("menu/center")
	public String menu_center(Model model) {
		return "menu/center";
	}

}
