/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com 
 * 创建时间：2015-9-23 下午1:37:01 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package com.jh.dev.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jh.core.util.Condition;
import com.jh.core.util.Page;
import com.jh.dev.bo.Menu;
import com.jh.dev.bo.MenuModule;
import com.jh.dev.service.MenuModuleService;

@Controller
@RequestMapping("/module")
public class MenuModuleController {

	private final Logger logger = Logger.getLogger(MenuModuleController.class);

	@Autowired
	private MenuModuleService moduleService;

	/**
	 * 保存菜单所属模型
	 * 
	 * @Title: save_module
	 * @Author: jianghan
	 * @param module
	 * @param model
	 * @return
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/save_module", method = RequestMethod.POST)
	public Map<String, Object> save_module(@RequestBody final MenuModule module,
			Model model) {

		Map<String, Object> map = new HashMap<String, Object>();
		moduleService.saveModule(module);

		map.put("msg", "插入成功");
		logger.info("插入菜单模板信息" + module.getModuleName());

		return map;
	}

	/**
	 * 删除菜单所属模块
	 * 
	 * @Title: delete_module
	 * @Author: jianghan
	 * @param module
	 * @param model
	 * 
	 */

	@RequestMapping("/delete_module")
	public @ResponseBody
	Map<String, Object> delete_module(@RequestBody final MenuModule module,
			Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		moduleService.deleteModule(module);

		map.put("msg", "成功");
		logger.info("删除成功" + module.getModuleId());

		return map;
	}

	/**
	 * 更新菜单所属模块
	 * 
	 * @Title: update_module
	 * @Author: jianghan
	 * @param module
	 * @param model
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/update_module", method = RequestMethod.POST)
	public Map<String, Object> update_module(@RequestBody final MenuModule module,
			Model model) throws IllegalAccessException,
			InvocationTargetException {

		Map<String, Object> map = new HashMap<String, Object>();

		Set<Menu> menuSet = new HashSet<Menu>();
		module.setMenuSet(menuSet);

		moduleService.updateModule(module);

		map.put("msg", "更新成功");
		logger.info("moduleName" + module.getModuleName());

		return map;
	}

	/**
	 * 查询 菜单所属模块对象
	 * 
	 * @Title: get_moduel
	 * @Author: jianghan
	 * @param module
	 * @param model
	 * @return
	 * 
	 */
	@RequestMapping("/get_module")
	public @ResponseBody
	Map<String, Object> get_module(@RequestBody final MenuModule module, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		MenuModule moduleParam = moduleService.getModule(module.getModuleId());
		map.put("module", moduleParam);
		return map;
	}

	/**
	 * 查询 菜单所属模块 分页
	 * 
	 * @Title: list_module
	 * @Author: jianghan
	 * @param module
	 * @param page
	 * @param model
	 * @return
	 * 
	 */
	@RequestMapping("/list_module")
	public String list_module(MenuModule module, Page page, Model model) {
		Condition<MenuModule> condition = new Condition<MenuModule>();
		condition.setT(module);
		condition.setPage(page);
		Condition<MenuModule> conditionParam = moduleService
				.findModuleByJPQLWithPage(condition);
		model.addAttribute("conditionParam", conditionParam);

		return "module/center";
	}
}
