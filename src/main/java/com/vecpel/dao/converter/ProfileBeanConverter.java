package com.vecpel.dao.converter;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;

import com.vecpel.model.beans.ProfileBean;
import com.vecpel.server.constants.VecpelConstants;

public class ProfileBeanConverter implements RowMapper<ProfileBean>{

	@Override
	public ProfileBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext(VecpelConstants.CLASSPATH_SPRING_CONFIG);
		ProfileBean profile = (ProfileBean) context.getBean("profile");
		
		profile.setProfileID(rs.getString("VET_PROFILE_ID"));
		String[] name = rs.getString("VET_NAME").split(" ");
		profile.setFirstName(name[0]);
		profile.setLastName(name[1]);
		profile.setAddr1(rs.getString("VET_ADDR1"));
		profile.setAddr2(rs.getString("VET_ADDR2"));
		profile.setAddr3(rs.getString("VET_ADDR3"));
		profile.setCity(rs.getString("VET_CITY"));
		profile.setPinCode(rs.getLong("VET_PINCODE"));
		profile.setState(rs.getString("VET_STATE"));
		 
		return profile;
	}

}
