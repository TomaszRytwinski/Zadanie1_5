package com.capgemini.FraudAnalyzer;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class UserTransferHistory {
	private List<Transfer> userHistory = new ArrayList<Transfer>();
	private List<Date> TransferDates = new ArrayList<Date>();
	private String userID;
	public UserTransferHistory(String _userId){
		userID=_userId;
	}
	public void addToUserTransferHistory(Transfer transfer){
		userHistory.add(transfer);
	}
	public double countTransferPerDay(Date date){
		double sum=0;
		for (int i =0; i<userHistory.size();i++){
			if(userHistory.get(i).GetTransferDate()==date){
				sum++;
			}
		}
		return sum;
	}
	public int sentHowManyTimes(String ToWho){
		int howMany=0;
		for (int i =0; i<userHistory.size();i++){
			if (userHistory.get(i).GetToID() == ToWho){
				howMany++;
			}
		}
		return howMany;
	}
}
