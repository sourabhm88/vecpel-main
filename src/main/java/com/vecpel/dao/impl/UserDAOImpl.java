package com.vecpel.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import com.vecpel.dao.intf.UserDAO;
import com.vecpel.model.beans.UserBean;

public class UserDAOImpl implements UserDAO {

	@Override
	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertNewUser(UserBean userBean) {
		// TODO Auto-generated method stub

	}

	@Override
	public UserBean getUserInfo(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserBean> listOfActiveUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUserInfo(UserBean userBean) {
		// TODO Auto-generated method stub

	}

}
