package com.makeMybill.jdbc;

public interface SQLConstants {
  String CHECK_LOGIN = "Select * from user where user_id=? and password=?;";
  String ADD_DATA = "Update user set curr_meter_reading=?, bill_till=? where meter_id=?;";
}
