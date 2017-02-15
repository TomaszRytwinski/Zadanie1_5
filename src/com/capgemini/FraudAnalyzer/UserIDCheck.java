package com.capgemini.FraudAnalyzer;

import java.util.ArrayList;
import java.util.List;

public class UserIDCheck {
	public UserIDCheck(){
		
	}
	public static List<Transfer> SUSUser(List<Transfer> inputTransfers){
		List<String> userSUSIDBegins = new ArrayList<String>();
		List<Transfer> susTransfers = new ArrayList<Transfer>();
		String userType542 = "542";
		String userType1052 = "1052";
		String userType2103 = "2103";
		userSUSIDBegins.add(userType542);
		userSUSIDBegins.add(userType1052);
		userSUSIDBegins.add(userType2103);
		for (int i=0;i<userSUSIDBegins.size();i++){
			for(int j=0;j<inputTransfers.size();j++){
				if(inputTransfers.get(j).GetFromID().startsWith(userSUSIDBegins.get(i)))
				{
					susTransfers.add(inputTransfers.get(j));
				}
			}
		}
		return susTransfers;
	}
}
