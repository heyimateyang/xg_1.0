package org.heyimtaeyang.dao;

import java.util.List;

import org.heyimtaeyang.entity.Student;

public interface StudentDao {
	

	/**
	 * 学生信息分页显示
	 * @author heyimtaeyang
	 *
	 */
	List<Student> queryByPage(String hql, int offset, int pageSize);
    int getAllRowCount(String hql);
    
    List<Student> queryByPages(String sql, int offset, int pageSize);
    int getAllRowCounts(String sql);
    
    //按学号查找学生信息
    Student findStudentNumber(String hql);
    
    //按id查找学生信息
    Student findStudentById(String hql);
    
    //按id查找学生信息
    Student findStudentByStudentId(String hql);
    
    //按usersId查找学生信息
    Student findStudentByUserId(String sql);
    
    //模糊查询学生信息
    List<Student> findLikeStudent(String sql);
    
    //修改学生资料
    int updateStudent(Student student);
    
    //添加学生信息
    int addStudent(Student student);
    
    //更新学生班级信息
    int updateStudentClass(Student student);
    
    //根据id删除学生
    int deleteUsersById(String sql);
    
    //修改单个字段
    int updateStudent(String sql);
}
