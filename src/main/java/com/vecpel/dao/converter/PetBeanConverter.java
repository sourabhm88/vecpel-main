package com.vecpel.dao.converter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;

import com.vecpel.model.beans.PetBean;
import com.vecpel.model.beans.VetBean;
import com.vecpel.server.constants.VecpelConstants;

public class PetBeanConverter implements RowMapper<PetBean>{

	@Override
	public PetBean mapRow(ResultSet rs, int index) throws SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext(VecpelConstants.CLASSPATH_SPRING_CONFIG);
		PetBean petBean = (PetBean) context.getBean("pet");
		
		petBean.setPetId(rs.getString("PET_ID"));
		petBean.setPetTypeId(rs.getString("PET_TYPE_ID"));
		petBean.setPetTypeDesc(rs.getString("PET_TYPE"));
		petBean.setPetGrpId(rs.getString("PET_GROUP_ID"));
		petBean.setPetGrpDesc(rs.getString("PET_GROUP_NAME"));
		petBean.setPetName(rs.getString("PET_NAME"));
		
		java.sql.Date sqlDOB = rs.getDate("PET_DOB");
		petBean.setPetDOB(new Date(sqlDOB.getTime()));
		
		petBean.setPetOwnerId(rs.getString("PET_OWNER_ID"));
		return petBean;
	}

}
