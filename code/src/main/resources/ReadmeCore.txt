

1.	function:
	spring 添加log
		在web应用中为Spring配置log4j
	 	Spring的做法是使用一个Servlet Listener，在Web Container启动时把ROOT的绝对路径写到系统变量里，
	 	这样log4j的配置文件里就可以用${myAppfuse.root}来表示刚刚设进去的系统变量：
	 	log4j.appender.logfile.File=${myAppfuse.root}/logs/mylog.log
 	
2.	error: 406 accept 
		spring 4.x 不支持 jackson 1.x 

3.	error:
		Required request body content is missing: 
		org.springframework.web.method.HandlerMethod
	solution:
		不能同时出现两个@RequestBody

4.	error: ajax 400
	ajax提供的类型与实体类类型不同    类型错误 






























