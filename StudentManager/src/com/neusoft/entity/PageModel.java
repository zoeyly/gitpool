package com.neusoft.entity;

import java.util.List;

/** ��ҳ����ģ�� */
public class PageModel {
	/**		 �ܼ�¼��			 */
	private  Integer totalCount;
		/**		 ÿһҳ���ݼ���		 */
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
