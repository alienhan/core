/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com 
 * 创建时间：2015-9-17 下午10:03:03 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package com.jh.core.util;

/** 
 * 分页
 *
 * @ClassName: Page 
 * @author jh 
 * @date 2015-9-17 下午10:03:26 
 *  
 */
public class Page {
	
	/**
	 * page 为空
	 */
	public static final Page EMPTY_PAGE = new Page();
	/**
	 * 默认一页行数
	 */
	public static final int DEFAULT_PAGE_SIZE = 5;
	/**
	 * 记录总个数
	 */
	private int count;
	/**
	 * 当前页面位置
	 */
	private int pageNo;
	/**
	 * 页数
	 */
	private int pageCount;
	/**
	 * 一页行数
	 */
	private int pageSize;
	
	public Page(int count, int pageNo, int pageSize){
		this.count = count;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		//取整
		this.pageCount = (count + pageSize -1) / pageSize;
	}
	
	public Page() {
		this(0, 0, DEFAULT_PAGE_SIZE);
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
