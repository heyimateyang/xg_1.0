package org.heyimtaeyang.test;

import org.heyimtaeyang.biz.UsersBiz;
import org.heyimtaeyang.biz.impl.UsersBizImpl;
import org.heyimtaeyang.entity.Users;
import org.heyimtaeyang.until.SHA;
import org.junit.Test;

public class shaTest {
	@Test
	public void shaTest(){
		SHA sha = new SHA();
		try {
			System.out.println(sha.shaEncode("123"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*UsersBiz usersBiz = new UsersBizImpl();
		Users users = usersBiz.login("admin123", "123");
		System.out.println(users.getUserName());*/
		
	}

}
