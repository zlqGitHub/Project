package nuc.ee.service;

import java.util.List;

import nuc.ee.dao.TeacherDao;
import nuc.ee.model.*;
public class TeacherService {
	TeacherDao dao = new TeacherDao();
	//��ȡ��ʦ��Ϣ
	public List<Teacher> selectTeacher(String en ,String td){
		List<Teacher> teacherlist = dao.selectTeacher(en,td);
		return teacherlist;
	}
}
