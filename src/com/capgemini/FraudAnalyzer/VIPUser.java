package com.capgemini.FraudAnalyzer;

import java.util.ArrayList;
import java.util.List;

public class VIPUser {
	 //list of users that are not checked
	public VIPUser(){
		
	}
	public static List<Transfer> excludeVIPUser(List<Transfer> inputTransfers){
		List<String> userVIPIDBegins = new ArrayList<String>();
		String userType101 = "101";
		String userType606 = "606";
		userVIPIDBegins.add(userType101);
		userVIPIDBegins.add(userType606);
		for (int i=0;i<userVIPIDBegins.size();i++){
			for(int j=0;j<inputTransfers.size();j++){
				if(inputTransfers.get(j).GetFromID().startsWith(userVIPIDBegins.get(i)))
				{
					inputTransfers.remove(j);
				}
			}
		}
		return inputTransfers;
	}

}
