package org.heyimtaeyang.test;

import java.util.ArrayList;
import java.util.List;

import org.heyimtaeyang.biz.CalculationBiz;
import org.heyimtaeyang.biz.ClassmessageBiz;
import org.heyimtaeyang.biz.GradeteacherBiz;
import org.heyimtaeyang.biz.StudentBiz;
import org.heyimtaeyang.biz.TeacherBiz;
import org.heyimtaeyang.biz.impl.CalculationBizImpl;
import org.heyimtaeyang.biz.impl.ClassmessageBizImpl;
import org.heyimtaeyang.biz.impl.GradeteacherBizImpl;
import org.heyimtaeyang.biz.impl.StudentBizImpl;
import org.heyimtaeyang.biz.impl.TeacherBizImpl;
import org.heyimtaeyang.dao.CalculationDao;
import org.heyimtaeyang.dao.impl.CalculationDaoImpl;
import org.heyimtaeyang.entity.Classmessage;
import org.heyimtaeyang.entity.Gradeteacher;
import org.heyimtaeyang.entity.Student;
import org.heyimtaeyang.entity.Teacher;
import org.junit.Test;

public class test1 {
	
	@Test
	public void testStudent(){
		/*TeacherBiz teacherBiz = new TeacherBizImpl();
		Teacher teacher = teacherBiz.findTeacherByUserId(849);
		//查找该老师负责的班级
		ClassmessageBiz classmessageBiz = new ClassmessageBizImpl();
		List<Classmessage> list_Classmessage = classmessageBiz.findByteacherId(teacher.getTeacherId());
		for(Classmessage classmessage:list_Classmessage){
			System.out.println(classmessage.getClassmessageName());
		}*/
		int id = 1513220138;
		String name = String.valueOf(id);
		int num = name.length();
		String newss=name.substring(0,2);
		System.out.println(newss);
	}

}
