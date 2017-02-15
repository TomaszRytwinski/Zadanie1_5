package com.capgemini.FraudAnalyzer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
	private String ID;
	private List<Transfer> userHistory = new ArrayList<Transfer>();
	private List<Date> TransferDates = new ArrayList<Date>();
	
	public User(String _ID){
		ID=_ID;
	}
	public String GetID(){
		return ID;
	}
	public void addToUserTransferHistory(Transfer transfer){
		userHistory.add(transfer);
	}
	public Transfer getTransferFromHistory(int index){
		return userHistory.get(index);
	}
	public int countTransferPerDay(Date date){
		int sum=0;
		for (int i =0; i<userHistory.size();i++){
			if(userHistory.get(i).GetTransferDate()==date){
				sum++;
			}
		}
		return sum;
	}
	public List<Transfer> listOfTransferaDay(Date date){
		List<Transfer> TransferADay = new ArrayList<Transfer>(); 
		for (int i =0; i<userHistory.size();i++){
			if(userHistory.get(i).GetTransferDate()==date){
				TransferADay.add(userHistory.get(i));
			}
		}
		return TransferADay;
	}

	public double countAmountTransferPerDay(Date date){
		double sum=0;
		for (int i =0; i<userHistory.size();i++){
			if(userHistory.get(i).GetTransferDate()==date){
				sum= sum + userHistory.get(i).GetAmount();
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
	public List<Date> datesThatWereTransfers(){
		boolean Repeat=false;
		
		for (int i =0; i<userHistory.size();i++){
			Repeat=false;
			for(int j=0;j<i;j++){
				if (userHistory.get(i).GetTransferDate()==userHistory.get(j).GetTransferDate()){
					Repeat=true;
				}
			}
			if(!Repeat){
				TransferDates.add(userHistory.get(i).GetTransferDate());
			}
				
		}
		return TransferDates;
	}
}
