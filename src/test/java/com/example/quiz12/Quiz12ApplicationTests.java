package com.example.quiz12;

import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Quiz12ApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test 
	public void excpTest()
	{
		
	}
	@Test
	public void test2() throws Exception
	{
		Scanner scanner = new Scanner(System.in);
		try{
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			scanner.close();
		}
		int a =scanner.nextInt();
	}

}
