/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com 
 * 创建时间：2015-10-8 下午12:09:21 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.jh.core.util.Condition;
import com.jh.core.util.Page;
import com.jh.dev.bo.MenuModule;
import com.jh.dev.bo.User;
import com.jh.dev.service.UserService;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
// 加载spring 配置文件
@ContextConfiguration(locations = { "classpath:spring-context.xml",
		"classpath:spring-servlet.xml" })
// 加载事务管理类，可以省略
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
// 测试执行的类
@TestExecutionListeners(listeners = {
		DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
public class UserServiceTest {

	private final Logger logger = Logger.getLogger(UserServiceTest.class);
	
	@Autowired 
	private UserService userService;

	//@Test
	public void testSave() {
		User user = new User();
		user.setUserName("姜晗");
		user.setUserPwd("123dd");
		userService.save(user);
	}

	//@Test
	public void testDelete() {
		User user = new User();
		user.setUserId(2);
		userService.delete(user);
	}

	//@Test
	public void testUpdate() {
		User user = new User();
		user.setUserId(1);
		user.setUserTel("34567");
		userService.update(user);
	}

	//@Test
	public void testGet() {
		//验证级联关联
		logger.info("-----------" + userService.get(1).getUserType().getTypeName());
	}

	@Test
	public void testFindByJPQLWithPage() {
		User user = new User();
		Page page = new Page();
		Condition<User> condition = new Condition<User>();
		condition.setT(user);
		condition.setPage(page);
		Condition<User> conditionParam = userService.findByJPQLWithPage(condition);
		for (User u : conditionParam.getList()) {
			logger.info("-------------UserId: " + u.getUserId() + " UserName: "
					+ u.getUserName());
		}
	}

}
