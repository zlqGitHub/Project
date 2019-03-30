package nuc.ee.service;

import java.util.ArrayList;
import java.util.List;

import nuc.ee.dao.UserDao;
import nuc.ee.model.Company;
import nuc.ee.model.GignUp;
import nuc.ee.model.Teacher;
import nuc.ee.model.User;
import nuc.ee.model.UserLogin;

public class UserService {
	UserDao uDao = new UserDao();
	//ע����Ϣʱ�ж��Ƿ���ע��
	public int select_user(User u) {
		int i = uDao.regist_select(u);
		return i;
	}
	
	//��ע����Ϣд�����
	public int insert_user(User u) {
		int i = uDao.user_insert(u);
		return i;
	}
	
	//�û���¼
	public User login_user(UserLogin u) {
		User user = new User();
		user = uDao.login_select(u);
		return user;
	}
	
	//�û�����ǰ��ȡ�ɱ����Ĵ���
	public int get_change(int userid) {
		int change = uDao.get_change(userid);
		return change;
	}
	
	//��������Ϣд�����
	public void insert_user(GignUp gp,int num,String time) {
		uDao.insert_user(gp, num, time);
	}
	
	//��ȡ��˾��Ϣ
	public List<Company> get_company(){
		List<Company> comList = new ArrayList<Company>();
		comList = uDao.get_company();
		return comList;
	}
	
	//��ȡ��ʦ��Ϣ
	public List<Teacher> get_teacher(){
		List<Teacher> teaList = new ArrayList<Teacher>();
		teaList = uDao.get_teacher();	
		return teaList;
	}
	
	//��ѯ������Ϣ
	public List<User> myInfo_select(int userid){
		List<User> list = new ArrayList<User>();
		list = uDao.myInfo_select(userid);
		return list;
	}
	
	//�޸ĸ�����Ϣ
	public int updateMyInfo(int userid,String pass,String tel) {
		int i = 0;
		i = uDao.updateMyInfo(userid, pass, tel);
		return i;
	}
	
	//��ȡ���˱�����Ϣ
	public GignUp get_gignUp(int userid){
		GignUp gu = new GignUp(); 
		gu = uDao.get_gignUp(userid);
		return gu;
	}
	
	//��ȡ�Լ��ķְ���Ϣ
	public String get_class(int id){
		String classes =null;
		classes = uDao.get_class(id);
		return classes;
	}
}
