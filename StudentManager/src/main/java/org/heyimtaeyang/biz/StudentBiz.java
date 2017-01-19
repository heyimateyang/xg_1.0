package org.heyimtaeyang.biz;

import java.util.List;

import org.heyimtaeyang.entity.Student;

public interface StudentBiz {
	
	//按学生名字寻找学生
	Student findStudentNumber(Long studentNumber);
	
	//按id查找学生
	Student findStudentById(int studentId);
	
	//按id查找学生
	Student findStudentByStudentId(int studentId);
	
	//按usersId查找学生信息
    Student findStudentByUserId(int userId);

    //模糊查询学生信息
    List<Student> findLikeStudent(String studentName,int classmessageId);
    
    //模糊查询学生信息
    List<Student> findLikeStudent(String studentName);
    
    //模糊查询学生信息
    List<Student> findLikeStudentTeacher(String studentName, int classmessageId);
    
    //修改学生资料
    Student updateStudent(int studentId,int userId,String studentName,String myFileFileName,String userPwd,Long phoneNumber,String homePhone,String email,String address,Long qqNumber);
    
    //添加学生信息
    int addStudent(String userName,String userPwd,
    		Long studentNumber,String shcoolName,
    		int gradeName,String state,String dateTime,
    		Long phoneNumber,String homePhone,Long qqNumber,
    		String email,String address,
    		String myFileFileName,String sex,String studentName,int JurisdictionId);
    
    //添加学生班级信息admin
    void updateStudentClass(int classmessageId, int studentId,int postId);
    
    //添加学生班级信息GradeTeacher
    void updateStudentClassGradeTeacher(int classmessageId, int studentId,int postId);
    
    //按找id删除用户表
  	void deleteUsersById(int userId);
  	
  	//管理员页面修改学生信息
  	void adminUpdateStudent(int studentId,String studentName,String userName,
  			String myFileFileName,String sex,
  			Long studentNumber,String shcoolName,int classmessageId,
  			String dateTime,String state,Long phoneNumber,
  			String homePhone,String email,String address,int userId,Long qqNumber,String userPwd,int PoliticallandscapeId,
  			String idcard,String interest,String dormitory,String remarks,String weight,String PlaceofBirth,String birthday,
  			String height,String corporation,String corporationpost,String nation,String WeChat,int postId,int poor,String studentGradeName
  			);
  	
  	/**
  	 * 
  	 * @author heyimtaeyang
  	 * 
  	 * 重载一个方法
  	 */
  	int addStudent(String userName,String userPwd,String myFileFileName,Long studentNumber,String studentName,
  			String sex,String nation,int PoliticallandscapeId,String PlaceofBirth,String birthday,String height,
  			String weight,int gradeName,String dateTime,String state,String corporation,String corporationpost,Long phoneNumber,
  			String homePhone,Long qqNumber,String WeChat,String email,String address,int JurisdictionId,String idcard,String shcoolName
  			,String interest,String dormitory,String remarks,int poor,String studentGradeName
  			);
  	
  	//辅导员添加学生
  	int addStudentGradeTeacher(String userName,String userPwd,String myFileFileName,Long studentNumber,String studentName,
  			String sex,String nation,int PoliticallandscapeId,String PlaceofBirth,String birthday,String height,
  			String weight,int gradeName,String dateTime,String state,String corporation,String corporationpost,Long phoneNumber,
  			String homePhone,Long qqNumber,String WeChat,String email,String address,int JurisdictionId,String idcard,String shcoolName
  			,String interest,String dormitory,String remarks,int poor ,String studentGradeName
  			);
  	
  	//修改政治面貌状态
  	void updateSutdent(int studentId);
  	
  	//修改政治面貌状态
  	void updateSutdentGradeTeacher(int studentId);
  	
  	//修改政治面貌状态
  	void updateSutdentTeacher(int studentId);
  	
  	//修改学生帐号的状态admin启用状态
  	//修改政治面貌状态
  	void updateSutdentState(int studentId);
  	
  	/**
  	 * 
  	 * @author heyimtaeyang
  	 * 
  	 * 重载一个方法
  	 * 学生修改自己的个人信息
  	 */
  	
  	void updateStudent(
  			int studentId,int userId,String userPwd,String myFileFileName,String studentName,String sex,String nation
  			,int PoliticallandscapeId,String PlaceofBirth,String birthday,String height,String weight
  			,int classmessageId,int postId,String corporation,String corporationpost,String interest,
  			String dormitory,Long phoneNumber,String homePhone,Long qqNumber,String WeChat,String email,String address
  			)throws Exception;
  	
  	//修改班级的年级级联修改学生的年级
  	int updateStudentGrade(int classmessageId,int gradeId);
}
