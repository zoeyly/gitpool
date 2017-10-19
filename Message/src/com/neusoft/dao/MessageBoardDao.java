package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.MessageBoard;
import com.neusoft.utils.PageModel;

public interface MessageBoardDao {

	public boolean insertMessage(MessageBoard mbd) throws DaoException;
	
	public List<MessageBoard> showMsgAll() throws DaoException;
	
	public PageModel<MessageBoard> showPro(int pageNo, int pageSize) throws DaoException;
	
	public int getProTotalRecords() throws DaoException;
}
