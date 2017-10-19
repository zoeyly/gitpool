package com.neusoft.utils;

import java.util.List;

/**
 * ��װ��ҳ��Ϣ
 * @author Administrator
 *
 */
public class PageModel<A> {

	//�����
	private List<A> list;
	
	//��ѯ��¼��
	private int totalRecords;
	
	//��ѯ��ǰҳ��
	private int pageNo;
	
	//ÿҳ����������
	private int pageSize;
	
	//��ҳ��
	private int totalPageNo;
	
	
	public int getTotalPageNo() {
		return totalPageNo;
	}

	public void setTotalPageNo(int totalPageNo) {
		this.totalPageNo = totalPageNo;
	}

	/**
	 * һ���м�ҳ
	 * @return
	 */
	public int getTotalPages(){
		return (totalRecords + pageSize - 1)/pageSize;
	}

	/**
	 * ȡ����ҳҳ��
	 * @return
	 */
	public int getTopPageNo(){
		return 1;
	}
	
	/**
	 * ȡ��βҳ
	 * @return
	 */
	public int getBottonPageNo(){
		return getTotalPages();
	}
	
	/**
	 * ȡ����һҳ
	 * @return
	 */
	public int getPreviousPageNo(){
		if(pageNo <= 1){
			return 1;
		}
		return pageNo - 1;
	}
	
	/**
	 * ȡ����һҳ
	 * @return
	 */
	public int getNextPageNo(){
		if(pageNo >= getTotalPages()){
			return getTotalPages();
		}
		return pageNo + 1;
	}
	public List<A> getList() {
		return list;
	}

	public void setList(List<A> list) {
		this.list = list;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
