package com.vecpel.dao.intf;

import java.util.List;

import javax.sql.DataSource;

import com.vecpel.model.beans.UserBean;

public interface UserDAO {
	   /** 
	    * This is the method to be used to initialize
	    * database resources ie. connection.
	    */
	   public void setDataSource(DataSource ds);
	   /** 
	    * This is the method to be used to create
	    * a record in the Student table.
	    */
	   public void insertNewUser(UserBean userBean);
	   /** 
	    * This is the method to be used to list down
	    * a record from the Student table corresponding
	    * to a passed student id.
	    */
	   public UserBean getUserInfo(String id);
	   /** 
	    * This is the method to be used to list down
	    * all the records from the Student table.
	    */
	   public List<UserBean> listOfActiveUsers();
	   /** 
	    * This is the method to be used to delete
	    * a record from the Student table corresponding
	    * to a passed student id.
	    */
	   public void deleteUser(Integer id);
	   /** 
	    * This is the method to be used to update
	    * a record into the Student table.
	    */
	   public void updateUserInfo(UserBean userBean);
	
}
