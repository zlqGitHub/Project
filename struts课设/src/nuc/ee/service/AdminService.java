package nuc.ee.service;

import java.util.ArrayList;
import java.util.List;

import nuc.ee.dao.AdminDao;
import nuc.ee.model.Admin;
import nuc.ee.model.Course;

public class AdminService {
	AdminDao ad = new AdminDao();
	List<Admin> adList = new ArrayList<Admin>();
	
	//�����¼
	public int get_admin(String name,String pass,String type) {
		int i = ad.select_admin(name,pass,type);
		return i;
	}
	
	//��ʦ���¿γ���Ϣ
	public List<Course> uptate_course(){
		List<Course> csList = new ArrayList<Course>();
		csList = ad.update_course();
		ad.insert_course(csList);
		return csList;
	}
	
	
	
	

}
