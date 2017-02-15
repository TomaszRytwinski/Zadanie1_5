package com.capgemini.FraudAnalyzer;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class FraudAnalyzerTest {
	private FraudAnalyzer f;
	private List<Transfer> inputTransfers = new ArrayList<Transfer>();
	private Date date1 = new Date(2017-1900,1, 14);
	private Date date2 = new Date(2017-1900,1, 15);
	private Date date3 = new Date(2017-1900,1, 16);
	private Date date4 = new Date(2017-1900,1, 17);
	@Before
	public void setup(){
		inputTransfers.add(new Transfer(date1,1000,"1012454545","223232323"));
		inputTransfers.add(new Transfer(date1,1000,"606454545","223232323"));
		inputTransfers.add(new Transfer(date1,1000,"542454545","223232323"));
		inputTransfers.add(new Transfer(date1,1,"542454545","223232323"));
		inputTransfers.add(new Transfer(date1,2,"542454545","223232323"));
		inputTransfers.add(new Transfer(date1,1,"542454545","223232323"));
		inputTransfers.add(new Transfer(date1,1,"542454545","223232323"));
		inputTransfers.add(new Transfer(date1,1,"542454545","223232323"));
		inputTransfers.add(new Transfer(date1,1,"542454545","223232323"));
		inputTransfers.add(new Transfer(date1,3333,"777777777","223232323"));
		inputTransfers.add(new Transfer(date1,4444,"777777777","223232323"));
		inputTransfers.add(new Transfer(date1,5555,"777777777","223232323"));
		inputTransfers.add(new Transfer(date2,1000,"3434343434","223232323"));
		inputTransfers.add(new Transfer(date2,1111,"3434343434","223232323"));
		inputTransfers.add(new Transfer(date2,2222,"3434343434","223232323"));
		inputTransfers.add(new Transfer(date2,2222,"3434343434","223232323"));
		inputTransfers.add(new Transfer(date2,2222,"3111111134","223232323"));
		inputTransfers.add(new Transfer(date2,1122,"3111111134","223232323"));
	}
	
	@Test // if there are more than 5 transfers from one account
	public void ShouldRetrunUserIDofFirstSuspiciousTransfer(){	
		FraudAnalyzer f = new FraudAnalyzer();
		f.startFraudAnalyzer(inputTransfers);
		Assert.assertEquals("542454545", f.susTransfers2.get(0).GetFromID());
	}
	@Test // if there are more than 5 transfers from one account, last suspiscious is 6th
	public void ShouldRetrunUserIDofLastSuspiciousTransfer(){	
		FraudAnalyzer f = new FraudAnalyzer();
		f.startFraudAnalyzer(inputTransfers);
		Assert.assertEquals("542454545", f.susTransfers2.get(6).GetFromID());
	}
	@Test // if there are more than 2 transfers from one account, sum of transfers more than 10 000
	public void ShouldRetrunUserIDofFirstSuspiciousTransferHighValue(){	
		FraudAnalyzer f = new FraudAnalyzer();
		f.startFraudAnalyzer(inputTransfers);
		Assert.assertEquals("777777777", f.susTransfers2.get(7).GetFromID());
	}
	@Test // if there are more than 2 transfers from one account, sum of transfers more than 10 000
	public void ShouldRetrunUserIDofLastSuspiciousTransferHighValue(){	
		FraudAnalyzer f = new FraudAnalyzer();
		f.startFraudAnalyzer(inputTransfers);
		Assert.assertEquals("777777777", f.susTransfers2.get(9).GetFromID());
	}
	@Test // if there are more than 3 transfers from one account, sum of transfers more than 5 000
	public void ShouldRetrunUserIDofFirstSuspiciousTransferMediumValue(){	
		FraudAnalyzer f = new FraudAnalyzer();
		f.startFraudAnalyzer(inputTransfers);
		Assert.assertEquals("3434343434", f.susTransfers2.get(10).GetFromID());
	}
	@Test // if there are more than 3 transfers from one account, sum of transfers more than 5 000
	public void ShouldRetrunUserIDofLastSuspiciousTransferMediumValue(){	
		FraudAnalyzer f = new FraudAnalyzer();
		f.startFraudAnalyzer(inputTransfers);
		Assert.assertEquals("3434343434", f.susTransfers2.get(13).GetFromID());
	}
	
}
