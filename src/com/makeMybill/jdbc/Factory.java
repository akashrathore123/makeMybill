package com.makeMybill.jdbc;

import java.util.ResourceBundle;

public class Factory {

	public static DAO getDAOObject(){
	DAO dao=null;	
	ResourceBundle rb=ResourceBundle.getBundle("db");
	String database=rb.getString("dbtype");
	if(database.equals("mysql")){
		dao=new Mysql();
	}
	return dao;
	}
}
