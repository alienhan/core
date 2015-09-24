/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com 
 * 创建时间：2015-9-23 上午9:26:36 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package com.jh.core.exception;

/** 
 * 数据访问接口层 错误处理
 *
 * @ClassName: DaoException 
 * @author jh 
 * @date 2015-9-23 上午9:28:01 
 *  
 */
public class DaoException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6138793638117764466L;

	public DaoException(){
		
	}
	
	public DaoException(Throwable ex){
		super(ex);
	}
	
	public DaoException(String msg){
		super(msg);
	}
	
	public DaoException(String msg, Throwable ex){
		super(msg, ex);
	}
}
