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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jh.core.util.Condition;
import com.jh.core.util.Page;
import com.jh.dev.bo.Module;
import com.jh.dev.service.ModuleService;

@Controller
@RequestMapping("/module")
public class ModuleController {

	@Autowired
	private ModuleService moduleService;

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
	@RequestMapping("/save_module")
	public String save_module(Module module, Model model) {

		moduleService.saveModule(module);
		return "module/center";
	}
	
	@RequestMapping("/list_module")
	public String list_module(Page page, Model model){
		Condition<Module> condition = new Condition<Module>();
		condition.setPage(page);
		Condition<Module> conditionParam = moduleService.findModuleByJPQLWithPage(condition);
		model.addAttribute("conditionParam", conditionParam);
		
		return "module/center";
	}
}
