package com.capgemini.FraudAnalyzer;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class UserIDCheckTest {
	List<Transfer> inputTransfers = new ArrayList<Transfer>();
	List<Transfer> SUSTransfers = new ArrayList<Transfer>();
	Date date1 = new Date(2017-1900,1, 14);
	FraudAnalyzer f = new FraudAnalyzer();
	@Before
	public void setup(){
		FraudAnalyzer f = new FraudAnalyzer();
		inputTransfers.add(new Transfer(date1,1000,"542454545","223232323"));
		inputTransfers.add(new Transfer(date1,1111,"1052454545","223232323"));
		inputTransfers.add(new Transfer(date1,2222,"210354545","223232323"));
		inputTransfers.add(new Transfer(date1,3333,"777777777","223232323"));
		inputTransfers.add(new Transfer(date1,4444,"777777777","223232323"));
		inputTransfers.add(new Transfer(date1,5555,"777777777","223232323"));
	}
	@Test
	public void ShouldCatchSusTransferOf542(){
		SUSTransfers = UserIDCheck.SUSUser(inputTransfers);
		Assert.assertEquals("542454545", SUSTransfers.get(0).GetFromID());
	}
	@Test
	public void ShouldCatchSusTransferOf105(){
		SUSTransfers = UserIDCheck.SUSUser(inputTransfers);
		Assert.assertEquals("1052454545", SUSTransfers.get(1).GetFromID());
	}
	@Test
	public void ShouldCatchSusTransferOf2103(){

		SUSTransfers = UserIDCheck.SUSUser(inputTransfers);
		Assert.assertEquals("210354545", SUSTransfers.get(2).GetFromID());
	}
}
