package com.ty.one_to_many_hospital_branch_controller;

import java.util.ArrayList;
import java.util.List;

import com.ty.one_to_many_hospital_branch_dao.HospitalDao;
import com.ty.one_to_many_hospital_branch_dto.Branch;
import com.ty.one_to_many_hospital_branch_dto.Hospital;

public class HospitalMain {
	public static void main(String[] args) {
		Branch branch=new Branch();
		branch.setBranch_id(10);
		branch.setBranch_name("xyz");
		branch.setBranch_phone(199991);
		branch.setHeadOfBranch("subrahanyam");
		Branch branch1=new Branch();
		branch1.setBranch_id(11);
		branch1.setBranch_name("zzz");
		branch1.setBranch_phone(177791);
		branch1.setHeadOfBranch("sudhakar");
		Branch branch2=new Branch();
		branch2.setBranch_id(12);
		branch2.setBranch_name("yyy");
		branch2.setBranch_phone(1345991);
		branch2.setHeadOfBranch("srinivasulu");
	    Hospital hospital=new Hospital();
	    hospital.setHospital_id(101);
	    hospital.setHospital_name("24/7 Hospital");
	    hospital.setHospital_address("Nammabangulur");
	    hospital.setGst("xyz12c");
	    hospital.setHospital_phone(99999);
	    List<Branch> list =new ArrayList<Branch>();
	    list.add(branch);
	    list.add(branch1);
	    list.add(branch2);
	    hospital.setBranch_list(list);
	    HospitalDao dao=new HospitalDao();
	    dao.saveHospital(hospital);
	   // dao.updateHospital(phone, 1001);
	    //dao.getHospital_Details_On_id(1001);
	   // dao.deleteHospital(1001);
	}

}
