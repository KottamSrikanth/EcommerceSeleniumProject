package com.EcommerceProject.Qa.TestCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public  class  GenerateFakeData 
{
	static Faker fake = new Faker();;
	@Test
	static String Name()
	{
		
		return fake.name().firstName();
		
	}
	
	static String phoneNumber()
	{
		return fake.phoneNumber().cellPhone();
	}
	
	static String Email()
	{
		return fake.internet().emailAddress();
	}
	
	static String Password()
	{
		String password=fake.internet().password();
		return password;
	}


}
