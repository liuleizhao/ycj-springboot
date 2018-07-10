package com.cs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cs.entity.Menu;
import com.cs.service.MenuService;
import com.github.pagehelper.PageInfo;



@RunWith(SpringRunner.class)
@SpringBootTest
public class YcjApplicationTests {

	@Autowired
	private MenuService menuService;
	
	@Test
	public void menuTest() {
		try {
			PageInfo<Menu> mInfo = menuService.select(null, 1);
			System.out.println(mInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
