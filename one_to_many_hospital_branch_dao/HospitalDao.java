package com.ty.one_to_many_hospital_branch_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.one_to_many_hospital_branch_dto.Address;
import com.ty.one_to_many_hospital_branch_dto.Branch;
import com.ty.one_to_many_hospital_branch_dto.Hospital;


public class HospitalDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}
	public void saveHospital(Hospital hospital) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		List<Branch> branch=hospital.getBranch_list();
		entityTransaction.begin();
		for(Branch branch1:branch) {
			entityManager.persist(branch1);
		}
		entityManager.persist(hospital);
		entityTransaction.commit();
		
	}
	public void updateHospital(long phone,int id) {
		EntityManager  entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Hospital hospital1=entityManager.find(Hospital.class, id);
		if(hospital1!=null) {
			hospital1.setHospital_phone(phone);
		    entityTransaction.begin();
		    entityManager.merge(hospital1);
		    entityTransaction.commit();
		}else {
			System.out.println("data is does not exist");
		}
	}
	public void deleteHospital(int id) {
     EntityManager entityManager=getEntityManager();
     EntityTransaction entityTransaction=entityManager.getTransaction();
     Hospital hospital=entityManager.find(Hospital.class, id);
     List<Branch> list=hospital.getBranch_list();
     if(hospital!=null) {
    	 entityTransaction.begin();
    	 entityManager.remove(hospital);
    	 for(Branch branch:list) {
    		 entityManager.remove(branch);
    	 }
    	 entityTransaction.commit();
     }else {
    	 System.out.println("data does  not exist");
     }
		
	}
	public void getHospital_Details_On_id(int id) {
		EntityManager entityManager=getEntityManager();
		Hospital hospital=entityManager.find(Hospital.class, id);
		System.out.println(hospital);
	}
	public void get_All_Hospital_Details() {
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select hospital from Hospital hospital");
		List<Hospital> list=query.getResultList();
		System.out.println(list);
	}

}
