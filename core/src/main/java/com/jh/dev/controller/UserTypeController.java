/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com 
 * 创建时间：2015-9-28 下午2:58:02 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package com.jh.dev.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.jh.core.util.Condition;
import com.jh.core.util.Page;
import com.jh.dev.bo.Menu;
import com.jh.dev.bo.User;
import com.jh.dev.bo.UserType;
import com.jh.dev.service.UserTypeService;

/** 
 * 用户类型请求处理
 *
 * @ClassName: UserTypeController 
 * @author jh 
 * @date 2015-9-29 上午10:42:36 
 *  
 */
@Controller
@RequestMapping("/userType")
public class UserTypeController {

	private final Logger logger = Logger.getLogger(UserTypeController.class);

	@Autowired
	UserTypeService userTypeService;

	@RequestMapping(value = "/save_userType")
	public @ResponseBody
	Map<String, Object> save(@RequestBody final UserType userType) {
		Map<String, Object> map = new HashMap<String, Object>();
		userTypeService.save(userType);
		map.put("msg", "插入成功");
		logger.info("插入UserType成功: " + userType.getTypeName());
		return map;
	}

	@RequestMapping(value = "/delete_userType")
	public void delete(@RequestBody final UserType userType) {
		userTypeService.delete(userType);
	}

	@RequestMapping(value = "/update_userType")
	public void update(@RequestBody final UserType userType) {
		Set<Menu> menuSet = new HashSet<Menu>();
		Set<User> userSet = new HashSet<User>();
		userType.setMenuSet(menuSet);
		userType.setUserSet(userSet);

		userTypeService.update(userType);
	}

	@ResponseBody
	@RequestMapping(value = "/get_userType")
	public Map<String, Object> get(@RequestBody final UserType userType) {
		Map<String, Object> map = new HashMap<String, Object>();
		UserType userType2 = userTypeService.get(userType.getTypeId());
		map.put("userType", userType2);
		return map;
	}

	/**
	 * 分页查询
	 * 
	 * @Title: list_module
	 * @Author: jianghan
	 * @param userType
	 * @param page
	 * @param model
	 * @return
	 * 
	 */
	@RequestMapping("/list_userType")
	public String list_module(UserType userType, Page page, Model model) {
		Condition<UserType> condition = new Condition<UserType>();
		condition.setT(userType);
		condition.setPage(page);
		Condition<UserType> condition2 = userTypeService
				.findByJPQLWithPage(condition);
		model.addAttribute("condition", condition2);

		return "userType/center";
	}
}
