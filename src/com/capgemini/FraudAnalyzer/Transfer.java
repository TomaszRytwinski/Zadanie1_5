package com.capgemini.FraudAnalyzer;

import java.util.Date;
public class Transfer {
	private Date transferDate;
	private double amount;
	private String fromID;
	private String toID;
	
	public Transfer(Date _transferDate, double _amount, String _fromID, String _toID){
		transferDate = _transferDate;
		amount = _amount;
		fromID = _fromID;
		toID = _toID;
	}
	public Date GetTransferDate(){
		return transferDate;
	}
	public double GetAmount(){
		return amount;
	}
	public String GetFromID(){
		return fromID;
	}
	public String GetToID(){
		return toID;
	}
}
