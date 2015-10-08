/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com 
 * 创建时间：2015-9-21 下午1:40:53 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package com.jh.dev.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jh.core.util.Condition;
import com.jh.core.util.Page;
import com.jh.dev.bo.User;
import com.jh.dev.service.UserService;

/**
 * 用户请求处理
 * 
 * @ClassName: UserController
 * @author jh
 * @date 2015-9-29 上午10:42:27
 * 
 */

@Controller
@RequestMapping("/user")
public class UserController {
	private final Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/save_user")
	public @ResponseBody
	Map<String, Object> save(@RequestBody final User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		userService.save(user);
		map.put("msg", "插入成功");
		logger.info("插入user成功" + user.getUserName());
		return map;
	}

	@RequestMapping(value = "/delete_user")
	public void delete(@RequestBody final User user) {
		userService.delete(user);
	}

	@RequestMapping(value = "/update_user")
	public void update(@RequestBody final User user) {
		userService.update(user);
	}

	@ResponseBody
	@RequestMapping(value = "/get_user")
	public Map<String, Object> get(@RequestBody final User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		User user2 = userService.get(user.getUserId());
		map.put("user", user2);
		return map;
	}

	/**
	 * 分页查询
	 * 
	 * @Title: list_module
	 * @Author: jianghan
	 * @param User
	 * @param page
	 * @param model
	 * @return
	 * 
	 */
	@RequestMapping("/list_User")
	public String list_module(User user, Page page, Model model) {
		Condition<User> condition = new Condition<User>();
		condition.setT(user);
		condition.setPage(page);
		Condition<User> condition2 = userService.findByJPQLWithPage(condition);
		model.addAttribute("condition", condition2);

		return "user/content";
	}
}
