/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com 
 * 创建时间：2015-9-23 下午1:42:29 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.jh.core.util.Condition;
import com.jh.core.util.Page;
import com.jh.dev.bo.Menu;
import com.jh.dev.bo.Module;
import com.jh.dev.service.ModuleService;

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
public class ModuleServiceTest {

	private final Logger logger = Logger.getLogger(ModuleServiceTest.class);

	@Resource
	private ModuleService moduleService;

	// @Test
	public void testSaveModule() {
		Module module = new Module();
		module.setModuleName("其他模板");
		// module.setModuleTag(4);
		moduleService.saveModule(module);

	}

	// @Test
	public void testDeleteModule() {
		Module module = new Module();
		module.setModuleId(25);
		moduleService.deleteModule(module);
	}

	// @Test
	public void testUpdateModule() {
		Module module = new Module();
		module.setModuleId(23);
		module.setModuleName("系统模板3");
		module.setModuleTag(5);
		// module.getMenuSet().clear();
		// Menu menu = new Menu();
		Set<Menu> menuSet = new HashSet<Menu>();
		module.setMenuSet(menuSet);
		moduleService.updateModule(module);
	}

	// @Test
	public void testGetModule() {
		Module module = moduleService.getModule(1);
		logger.info("module name: " + module.getModuleName());
	}

	// @Test
	public void testFindUniqueModuleByJPQL() {
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("moduleTag", 2);
		Module module = moduleService.findUniqueModuleByJPQL(parameterMap);
		logger.info("module name: " + module.getModuleName());
	}

	@Test
	public void testFindModuleByJPQLWithPage() {
		Module module = new Module();
		module.setModuleName("管理员模板");
		Page page = new Page();
		Condition<Module> condition = new Condition<Module>();
		condition.setT(module);
		condition.setPage(page);
		Condition<Module> conditionParam = moduleService
				.findModuleByJPQLWithPage(condition);
		for (Module m : conditionParam.getList()) {
			logger.info("moduleId: " + m.getModuleId() + " ModuleName: "
					+ m.getModuleName());
		}
	}

}
