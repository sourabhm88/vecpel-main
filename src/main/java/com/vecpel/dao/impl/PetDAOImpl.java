package com.vecpel.dao.impl;

import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.vecpel.dao.intf.PetDAO;
import com.vecpel.model.beans.PetBean;

public class PetDAOImpl implements PetDAO {

	private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private Properties queries;
    
	/**
	 * @return the queries
	 */
	public Properties getQueries() {
		return queries;
	}

	/**
	 * @param queries the queries to set
	 */
	public void setQueries(Properties queries) {
		this.queries = queries;
	}

	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insertNewPet(PetBean petBean) {
		// TODO Auto-generated method stub

	}

	@Override
	public PetBean getPetInfo(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PetBean> listOfActivePets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePet(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePetInfo(PetBean petBean) {
		// TODO Auto-generated method stub

	}

}
