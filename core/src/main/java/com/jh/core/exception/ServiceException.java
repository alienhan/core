/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com 
 * 创建时间：2015-9-23 上午9:40:33 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package com.jh.core.exception;

/** 
 * 业务层  错误处理
 *
 * @ClassName: ServiceException 
 * @author jh 
 * @date 2015-9-23 上午9:40:44 
 *  
 */
public class ServiceException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -977370851071839615L;
	
	public ServiceException(){
		
	}
	
	public ServiceException(Throwable ex){
		super(ex);
	}
	
	public ServiceException(String msg){
		super(msg);
	}
	
	public ServiceException(String msg,Throwable ex){
		super(msg,ex);
	}

}
