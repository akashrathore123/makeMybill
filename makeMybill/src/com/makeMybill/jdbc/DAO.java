package com.makeMybill.jdbc;

import java.sql.SQLException;
import java.util.List;

import com.makeMybill.dto.BillDTO;

public interface DAO {
	public int cud(String sql,List<PreparedStatementDTO> psList) throws ClassNotFoundException,SQLException;

	public BillDTO checkLogin(String checkLogin, List<PreparedStatementDTO> pslist) throws ClassNotFoundException,SQLException;
	public int checkUser(String sql,List<PreparedStatementDTO> psList) throws ClassNotFoundException,SQLException;
}