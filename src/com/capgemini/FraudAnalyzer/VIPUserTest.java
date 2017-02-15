package com.capgemini.FraudAnalyzer;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VIPUserTest {
	FraudAnalyzer f = new FraudAnalyzer();
	Date date1 = new Date(2017-1900,1, 14);
	List<Transfer> inputTransfers = new ArrayList<Transfer>();
	@Before
	public void setup(){
		inputTransfers.add(new Transfer(date1,1000,"606454545","223232323"));
		inputTransfers.add(new Transfer(date1,1111,"542454545","223232323"));
		inputTransfers.add(new Transfer(date1,2222,"542454545","223232323"));
		inputTransfers.add(new Transfer(date1,3333,"777777777","223232323"));
		inputTransfers.add(new Transfer(date1,4444,"777777777","223232323"));
		inputTransfers.add(new Transfer(date1,5555,"777777777","223232323"));
	}
	@Test
	public void ShouldDeleteVIPfromFirstPlace(){
		inputTransfers=VIPUser.excludeVIPUser(inputTransfers);
		Assert.assertEquals("542454545", inputTransfers.get(0).GetFromID());
	}
	@Test
	public void ShouldNotDeleteANYfromFirstPlace(){
		List<Transfer> inputTransfers = new ArrayList<Transfer>();
		inputTransfers.add(new Transfer(date1,1000,"100454545","223232323"));
		inputTransfers.add(new Transfer(date1,1111,"542454545","223232323"));
		inputTransfers.add(new Transfer(date1,2222,"542454545","223232323"));
		inputTransfers=VIPUser.excludeVIPUser(inputTransfers);
		Assert.assertEquals("100454545", inputTransfers.get(0).GetFromID());
	}
}
