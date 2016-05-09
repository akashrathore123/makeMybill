package com.makeMybill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import com.makeMybill.dto.BillDTO;
import com.mysql.jdbc.ResultSet;

public class Mysql implements DBConstants,DAO{
	
	private Connection getConnection() throws ClassNotFoundException, SQLException
	{
		ResourceBundle rb = ResourceBundle.getBundle("db");
		String driverName = rb.getString("drivername");
		Class.forName(driverName);
		
		String url = rb.getString("url");
		String userid = rb.getString("userid");
		String password = rb.getString("pwd");
		
		return DriverManager.getConnection(url,userid,password);
		
	}
	
	@Override
	public int cud(String sql, List<PreparedStatementDTO> psList) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try
		{
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			if(psList!=null && psList.size()>0){
				for(PreparedStatementDTO psDTO : psList){
					if(psDTO.getDatatype()==STRING){
				
						pstmt.setString(psDTO.getPosition(), psDTO.getValue().toString());
					}
					else
					if(psDTO.getDatatype()==INTEGER){
						pstmt.setInt(psDTO.getPosition(), (Integer)psDTO.getValue());
						
					}
					else
						if(psDTO.getDatatype()==DOUBLE){
							
							pstmt.setDouble(psDTO.getPosition(), (Double)psDTO.getValue());
							
						}
						else
							if(psDTO.getDatatype()==FLOAT){
								
								pstmt.setFloat(psDTO.getPosition(),(float) psDTO.getValue());
								
							}
				}
			}
			rowCount = pstmt.executeUpdate();
		}
		finally
		{
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		}
		return rowCount;
	}

	@Override
	public BillDTO checkLogin(String checkLogin, List<PreparedStatementDTO> psList)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		ResultSet rs;
		PreparedStatement ps = null;
		BillDTO billDto = null;
		try{
			con = getConnection();
			ps = con.prepareStatement(checkLogin);
			if(psList!=null && psList.size()>0){
				for(PreparedStatementDTO psDTO : psList){
					if(psDTO.getDatatype()==STRING){
				
						ps.setString(psDTO.getPosition(), psDTO.getValue().toString());
					}
					else
					if(psDTO.getDatatype()==INTEGER){
						ps.setInt(psDTO.getPosition(), (Integer)psDTO.getValue());
						
					}
					else
						if(psDTO.getDatatype()==DOUBLE){
							
							ps.setDouble(psDTO.getPosition(), (Double)psDTO.getValue());
							
						}
				}
			}
			
			rs = (ResultSet) ps.executeQuery();
			while(rs.next()){
				billDto = new BillDTO();
				billDto.setMeterId(rs.getInt("meter_id"));
				billDto.setUserId(rs.getString("user_id"));
				billDto.setPassword(rs.getString("password"));
				billDto.setBillTill(rs.getString("bill_till"));
				billDto.setLastMonthPaid(rs.getString("last_month_paid"));
				billDto.setLastPaidAmount(rs.getString("last_paid_amount"));
				billDto.setTotalPaid(rs.getString("total_paid"));
				billDto.setTotalUnit(rs.getFloat("curr_meter_reading"));
				
				
			}
		}
		finally
		{
			if(ps!=null){
				ps.close();
			}
			if(con!=null){
				con.close();
			}
		}
		return billDto;

	}

	@Override
	public int checkUser(String sql, List<PreparedStatementDTO> psList) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs;
		int rowCount = 0;
		try
		{
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			if(psList!=null && psList.size()>0){
				for(PreparedStatementDTO psDTO : psList){
					if(psDTO.getDatatype()==STRING){
				
						pstmt.setString(psDTO.getPosition(), psDTO.getValue().toString());
					}
					else
					if(psDTO.getDatatype()==INTEGER){
						pstmt.setInt(psDTO.getPosition(), (Integer)psDTO.getValue());
						
					}
					else
						if(psDTO.getDatatype()==DOUBLE){
							
							pstmt.setDouble(psDTO.getPosition(), (Double)psDTO.getValue());
							
						}
						else
							if(psDTO.getDatatype()==FLOAT){
								
								pstmt.setFloat(psDTO.getPosition(),(float) psDTO.getValue());
								
							}
				}
			}
			rs = (ResultSet) pstmt.executeQuery();
			if(rs.next()){
				
				rowCount = 1;
			}
		}
		finally
		{
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		}
		return rowCount;
	}
	}

