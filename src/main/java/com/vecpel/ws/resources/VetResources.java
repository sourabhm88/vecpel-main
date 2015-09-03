package com.vecpel.ws.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vecpel.dao.impl.VetDAOImpl;
import com.vecpel.model.beans.VetBean;
import com.vecpel.server.constants.VecpelConstants;

@Path("/vet")
public class VetResources {

	ApplicationContext context = new ClassPathXmlApplicationContext(VecpelConstants.CLASSPATH_SPRING_CONFIG);
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String listAllVets(){
		VetDAOImpl vetDB = (VetDAOImpl) context.getBean("vetDAO");
		
		StringBuilder sb = new StringBuilder();
		List<VetBean> vets = vetDB.listOfActiveVets();
		
		if(vets == null){
			return "No Active Vets";
		}
		
		for(VetBean v : vets){
			sb.append(v.toString());
			sb.append("\n");
		}
		return sb.toString();
	}
}
