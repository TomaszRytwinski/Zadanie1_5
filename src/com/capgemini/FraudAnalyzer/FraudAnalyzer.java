package com.capgemini.FraudAnalyzer;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class FraudAnalyzer {

	private VIPUser vipUser = new VIPUser();
	public List<User> users = new ArrayList<User>();
	public List<Transfer> susTransfers = new ArrayList<Transfer>();
	public List<Transfer> susTransfers2 = new ArrayList<Transfer>();
	private List<Date> daysOfTransfers = new ArrayList<Date>();
	public void createUserHistory(List<Transfer> inputTransfers){
		int i=0;
		boolean added=false;
		while(i<inputTransfers.size()) {
				for(int j=0;j<users.size();j++){
						if(users.get(j).GetID().equals(inputTransfers.get(i).GetFromID())){
							users.get(j).addToUserTransferHistory(inputTransfers.get(i));
							added=true;
							break;
						}else{
							added=false;
						}
				} 
				if (!added){
					users.add(new User(inputTransfers.get(i).GetFromID()));
					users.get(users.size()-1).addToUserTransferHistory(inputTransfers.get(i));
				}
				i++;
			}
	}
	
	private List<Transfer> checkNumberAndAmount(){
		List<Transfer> susTransfers = new ArrayList<Transfer>();
		double sum=0;
		int counter=0;
		int counter2=0; //counter for 5 condition
		for(int i=0;i<users.size();i++){
			daysOfTransfers = users.get(i).datesThatWereTransfers();
			counter=0;
			counter2=0; 
			for(int j=0; j<daysOfTransfers.size(); j++){
				counter = users.get(i).countTransferPerDay(daysOfTransfers.get(j));
				sum = users.get(i).countAmountTransferPerDay(daysOfTransfers.get(j));
				List<Transfer> listOfTransferaDay = users.get(i).listOfTransferaDay(daysOfTransfers.get(j));
				if (counter>5){
					susTransfers.addAll(listOfTransferaDay);
					listOfTransferaDay.removeAll(susTransfers);
				}else if (counter>3 && sum>5000){
					susTransfers.addAll(listOfTransferaDay);
					listOfTransferaDay.removeAll(susTransfers);
				}else if (counter>2 && sum>10000){
					susTransfers.addAll(listOfTransferaDay);
					listOfTransferaDay.removeAll(susTransfers);
				}			
				for (int k=0;k<listOfTransferaDay.size();k++){
					counter2=0;
					for (int l=k;l<listOfTransferaDay.size();l++){
					if(listOfTransferaDay.get(k).GetToID()==
							listOfTransferaDay.get(l).GetToID()){
							counter2++;
						}
					}
				}
				if(counter2>4){
					susTransfers.addAll(listOfTransferaDay);
					listOfTransferaDay.removeAll(susTransfers);
				}
			}
	}
		return susTransfers;
	}
	
	public void startFraudAnalyzer(List<Transfer> inputTransfers){
		
		//przypadek 0
		inputTransfers=vipUser.excludeVIPUser(inputTransfers);
		createUserHistory(inputTransfers);
		//przypadek 1
		susTransfers = UserIDCheck.SUSUser(inputTransfers);
		inputTransfers.removeAll(susTransfers);
		//przypadek 2, 3, 4, 5
		susTransfers2 = checkNumberAndAmount();
		susTransfers.addAll(susTransfers2);
		
	} 
}
