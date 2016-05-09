package com.makeMybill.jdbc;

public interface SQLConstants {
  String CHECK_LOGIN = "Select * from user where user_id=? and password=?;";
  String ADD_DATA = "Update user set curr_meter_reading=?, bill_till=? where meter_id=?;";
  String CHECK_USER = "Select * from user where meter_id=?;";
  String ADD_COMPLAIN = "Insert into complain values(?,?,?,?,'In Flow');";
  String ADD_CONTACT = "Insert into contact values(?,?,?);";
}