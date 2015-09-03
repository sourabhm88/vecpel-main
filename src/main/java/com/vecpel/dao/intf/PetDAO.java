package com.vecpel.dao.intf;

import java.util.List;

import javax.sql.DataSource;

import com.vecpel.model.beans.PetBean;

public interface PetDAO {
	   /** 
	    * This is the method to be used to initialize
	    * database resources ie. connection.
	    */
	   public void setDataSource(DataSource ds);
	   /** 
	    * This is the method to be used to create
	    * a record in the Student table.
	    */
	   public void insertNewPet(PetBean petBean);
	   /** 
	    * This is the method to be used to list down
	    * a record from the Student table corresponding
	    * to a passed student id.
	    */
	   public PetBean getPetInfo(String id);
	   /** 
	    * This is the method to be used to list down
	    * all the records from the Student table.
	    */
	   public List<PetBean> listOfActivePets();
	   /** 
	    * This is the method to be used to delete
	    * a record from the Student table corresponding
	    * to a passed student id.
	    */
	   public void deletePet(Integer id);
	   /** 
	    * This is the method to be used to update
	    * a record into the Student table.
	    */
	   public void updatePetInfo(PetBean petBean);
	
}
