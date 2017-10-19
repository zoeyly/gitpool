package com.neusoft.entity;

import java.util.List;

/** 分页数据模型 */
public class PageModel {
	/**		 总记录数			 */
	private  Integer totalCount;
		/**		 每一页数据集合		 */
	private List<Account>  list;
	
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public List<Account> getList() {
		return list;
	}
	public void setList(List<Account> list) {
		this.list = list;
	}
	
}
