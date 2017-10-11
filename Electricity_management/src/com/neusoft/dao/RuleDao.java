package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.Rule;
import com.neusoft.utils.DaoException;



public interface RuleDao {
	public boolean addRule(Rule rule) throws DaoException;
	public boolean deleteRule(Rule rule) throws DaoException;	
	public boolean changeRule(Rule rule) throws DaoException;
	public List<Rule> showRuleAll() throws DaoException;
	
	public PageModel<Rule> showPro(int pageNo, int pageSize) throws DaoException;
	public int getProTotalRecords() throws DaoException;
}
