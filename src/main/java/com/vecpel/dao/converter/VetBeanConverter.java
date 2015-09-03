package com.vecpel.dao.converter;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;

import com.vecpel.model.beans.ProfileBean;
import com.vecpel.model.beans.VetBean;
import com.vecpel.server.constants.VecpelConstants;

public class VetBeanConverter implements RowMapper<VetBean>{

	@Override
	public VetBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext(VecpelConstants.CLASSPATH_SPRING_CONFIG);
		VetBean vetBean =(VetBean) context.getBean("vet");
		
		vetBean.setVetId(rs.getString("VET_ID"));
		
		Blob vetPhoto = rs.getBlob("VET_PHOTO");
		InputStream is = vetPhoto.getBinaryStream();
		
		File photo = new File("/Users/sourabhmishra/Downloads/IMG_20150513_135844073.jpg");
		try {
			FileOutputStream fos = new FileOutputStream(photo);
			
			int b = 0;
			while ((b = is.read()) != -1)
			{
			    fos.write(b); 
			}    
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) 
	    {
		 e.getMessage (); e.printStackTrace(); 
		 System.out.println(e); 
	    }
		
		vetBean.setVetPhoto(photo);
		vetBean.setVetScore(rs.getInt("VET_SCORE"));
		vetBean.setVetQualification(rs.getString("VET_QUAL"));
		vetBean.setVetSpecialization(rs.getString("VET_SPCL"));
		
		ProfileBeanConverter converter = new ProfileBeanConverter();
		ProfileBean vetProfile = converter.mapRow(rs, rowNum);
		vetBean.setVetProfileBean(vetProfile);
		
		return vetBean;
	}

}
