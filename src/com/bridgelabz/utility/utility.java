package com.bridgelabz.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class utility {
public static void jsonInventry() throws Exception {
	JSONObject jsonObj_rice=new JSONObject();
	jsonObj_rice.put("item_Name", "Rice");
	jsonObj_rice.put("wieght", 20);
	jsonObj_rice.put("item_price", 49);
	
	JSONObject jsonObj_Pulses=new JSONObject();
	jsonObj_Pulses.put("item_Name", "Pulses");
	jsonObj_Pulses.put("wieght", 30);
	jsonObj_Pulses.put("item_price", 55);
	
	JSONObject jsonObj_Wheat=new JSONObject();
	jsonObj_Wheat.put("item_Name", "Wheat");
	jsonObj_Wheat.put("wieght", 60);
	jsonObj_Wheat.put("item_price", 55);

	JSONArray jsonArray=new JSONArray();
	jsonArray.add(jsonObj_rice);
	jsonArray.add(jsonObj_Pulses);
	jsonArray.add(jsonObj_Wheat);
	
	FileWriter fileWriter=new FileWriter("/home/bridgeit/eclipse-workspace/OppsPrograms/src/com/bridgelabz/programs/jsonItem.json");
	fileWriter.write(jsonArray.toJSONString());
	fileWriter.close();
	
	FileReader reader = new FileReader("/home/bridgeit/json_Details.json");
	JSONParser jsonParser = new JSONParser();
	Object obj = jsonParser.parse(reader);
	int wieghts, price_Of_Items;
	JSONArray jsonArrays = (JSONArray) obj;
	for (Object o : jsonArrays) {
		JSONObject jsonDeatils = (JSONObject) o;

		String item_name = (String) jsonDeatils.get("item_name");
		System.out.println("Item_Name--->" + item_name);

		String wieght = (String) jsonDeatils.get("wieght");
		System.out.println("Wieght--->" + wieght + "kg");
		wieghts = Integer.parseInt(wieght);

		String price_Of_Item = (String) jsonDeatils.get("price_Per_Kg");
		System.out.println("Price of Each per kg is..." + price_Of_Item);
		price_Of_Items = Integer.parseInt(price_Of_Item);

		System.out.println("Total Inventary is......." + price_Of_Items * wieghts);
		System.out.println();

	}

}

static String regx_Name="<<name>>";
static String regx_FullName="<<full name>> ";
static String regx_MobileNumber="91-xxxxxxxxxx";
static String regx_DateVal="01/01/2016";
/**
 * @param fullName
 * @param mobile_number
 * @return
 * Regular Expression to replace proper user name details,mobile number and current date.s
 */
public static String regExpression(String fullName,String mobile_number,String message) {
	String[] userFullName=fullName.split(" ");
	long millis=System.currentTimeMillis();  
	Date date=new Date(millis);  
	
	String currDate=date.toString();
	
	Pattern p1= Pattern.compile(regx_Name);
	Matcher m1=p1.matcher(message);
	message = m1.replaceAll(userFullName[0]);
	
	Pattern p2 = Pattern.compile(regx_FullName);
	Matcher m2=p2.matcher(message);
	message = m2.replaceAll(fullName);
	
	Pattern p3 = Pattern.compile(regx_MobileNumber);
	Matcher m3=p3.matcher(message);
	message = m3.replaceAll(mobile_number);
	
	Pattern p5 = Pattern.compile(regx_DateVal);
	Matcher m4=p5.matcher(message);
	message = m4.replaceAll(currDate);
	
	return message;
	
}


public static void stockReport() throws Exception {
	JSONObject stock1=new JSONObject();
	stock1.put("Stock_Name", "TCS");
	stock1.put("Number_Of_Share", "44");
	stock1.put("stock_Amount", "200");
	
	
	JSONObject stock2=new JSONObject();
	stock2.put("Stock_Name", "Oracle");
	stock2.put("Number_Of_Share", "88");
	stock2.put("stock_Amount", "400");
	
	JSONObject stock3=new JSONObject();
	stock3.put("Stock_Name", "Oracle");
	stock3.put("Number_Of_Share", "88");
	stock3.put("stock_Amount", "400");
	
	JSONArray stockList = new JSONArray();
	stockList.add(stock1);
	stockList.add(stock2);
	stockList.add(stock3);
	
	FileWriter fileWriter=new FileWriter("/home/bridgeit/eclipse-workspace/OppsPrograms/src/com/bridgelabz/programs/stockReport.json");
	fileWriter.write(stockList.toJSONString());
	fileWriter.flush();
	int total=0;
	
	FileReader reader=new FileReader("/home/bridgeit/eclipse-workspace/OppsPrograms/src/com/bridgelabz/programs/stockReport.json");
	JSONParser jsonParser = new JSONParser();
    Object obj = jsonParser.parse(reader);
    JSONArray jsonArray = (JSONArray)obj; 
    
 
	 for (Object o : jsonArray) {
	        JSONObject jsonDeatils = (JSONObject) o;

	        String item_name = (String) jsonDeatils.get("Stock_Name");
	        System.out.println("Stack_name is--->" + item_name);

	        String nunber_Share =(String)  jsonDeatils.get("Number_Of_Share");
	        System.out.println("Number_Of_Share is--->" + nunber_Share);
	        int share_Num=Integer.parseInt(nunber_Share);

	        String price_Of_Item = (String) jsonDeatils.get("stock_Amount");
	        System.out.println("Stack_Amount is..." + price_Of_Item);
	        int item_Price=Integer.parseInt(price_Of_Item);
	 
	        System.out.println("Total Inventary is......."+(share_Num+item_Price));
	        System.out.println();
	        total=total+share_Num+item_Price;
	    }

	 System.out.println("The Total of stocks Report is------>"+total);
	}

public static void createUser() throws Exception {
	
	JSONObject stock_User=new JSONObject();
	
	String name;
	int number_Of_Share,amount;
	
	Scanner scanner=new Scanner(System.in);
	System.out.println("Enter the name of the user......");
	name=scanner.next();
	
	stock_User.put("stock_Name",name);
	
	System.out.println("Enter the Number of Share");
	number_Of_Share=scanner.nextInt();
	stock_User.put("stock_Share",number_Of_Share);
	
	FileReader reader=new FileReader("/home/bridgeit/eclipse-workspace/OppsPrograms/stock_details.json");
	System.out.println("Enter the amount......");
	amount=scanner.nextInt();
	stock_User.put("stock_Amount",amount);
	
	JSONParser jsonParser = new JSONParser();
    Object obj = jsonParser.parse(reader);
    JSONArray jsonArray = (JSONArray)obj; 
    boolean b=true;
    for(Object o : jsonArray) {
    	JSONObject jsonDeatils = (JSONObject) o;
    	String user_Name=(String)jsonDeatils.get("stock_Name");
    	if(user_Name.equals(name)) {
    		System.out.println("user Already Exsists.............");
    		b=false;	
    	}
    }
    if(b==true) {
    jsonArray.add(stock_User);
	FileWriter fileWriter=new FileWriter("/home/bridgeit/eclipse-workspace/OppsPrograms/stock_details.json");
	fileWriter.write(jsonArray.toJSONString());
	fileWriter.flush();
	fileWriter.close();
	
    }
}

public static void Buy() throws Exception {
	// Date date = new Date(0);
    // System.out.println(date.toString());
	 Scanner scanner=new Scanner(System.in);
	 FileReader file1 = new FileReader("/home/bridgeit/eclipse-workspace/OppsPrograms/stock_details.json");
	 JSONParser parser_Stock = new JSONParser();
	 JSONArray jsonarray1 = (JSONArray) parser_Stock.parse(file1);
	 Iterator iterator1 = jsonarray1.iterator();
	
	 FileReader file2 = new FileReader("/home/bridgeit/eclipse-workspace/OppsPrograms/stock_symbol.json");
	 JSONParser parser_Symbol = new JSONParser();
	 JSONArray jsonarray2 = (JSONArray) parser_Symbol.parse(file2);
	 Iterator iterator2 = jsonarray2.iterator();
	 int number_Shares = 0,user_Amount = 0,amount=0,symbol_Shares=0,amounts=0;
	 String stock_Symbol=null,stockName=null,symbol = null;
	 JSONObject  jsonObject1 = null,jsonObject=null;
    boolean found=false;
	System.out.println("Enter the name of the user..........");
	String name=scanner.next();
	while (iterator1.hasNext()) {
		jsonObject=(JSONObject) iterator1.next();
		number_Shares= Integer.parseInt(jsonObject.get("number_Share").toString());
		user_Amount=Integer.parseInt(jsonObject.get("amount").toString());
		stockName=jsonObject.get("stock_Name").toString();
		if(stockName.equals(name)) {
			System.out.println("Enter the symbol......");
			symbol=scanner.next();
			System.out.println("Enter the amount...");
			amount=scanner.nextInt();
			while(iterator2.hasNext()) {
				jsonObject1=(JSONObject) iterator2.next();
				System.out.println(jsonarray1.toJSONString());
				stock_Symbol=jsonObject1.get("stock_Symbol").toString();
				symbol_Shares=Integer.parseInt(jsonObject1.get("Count").toString());
				amounts=Integer.parseInt(jsonObject1.get("amount").toString());
				if(stock_Symbol .equals(symbol)) {
					found=true;
				}else {
					System.out.println("Symbol not found..........");
				}
			}
		}else {
			System.out.println("User not found............");
		}
	}
	if(found==true) {
		jsonObject1.put("stock_Symbol", symbol);
		int counts=user_Amount/amounts;
		jsonObject1.put("Count", symbol_Shares - amount);
		jsonObject1.put("amount",amounts);
		jsonarray1.add(jsonObject);
		
		jsonObject.put("stock_Name", stockName);
		jsonObject.put("number_Share", number_Shares+counts);
		jsonarray2.add(jsonObject);
		FileWriter fileWriter1 = new FileWriter("/home/bridgeit/eclipse-workspace/OppsPrograms/stock_details.json");
		fileWriter1.write(jsonarray1.toJSONString());
		fileWriter1.flush();
		fileWriter1.close();
		
		FileWriter fileWriter2 = new FileWriter("/home/bridgeit/eclipse-workspace/OppsPrograms/stock_symbol.json");
		fileWriter2.write(jsonarray2.toJSONString());
		fileWriter2.flush();
		fileWriter2.close();
	}
}

public static void sell() throws Exception {
	
	Scanner scanner=new Scanner(System.in);
	
}

public static void display() throws Exception {
	FileReader reader1=new FileReader("/home/bridgeit/eclipse-workspace/OppsPrograms/stock_details.json");
	JSONParser jsonParser1 = new JSONParser();
	Object obj1 = jsonParser1.parse(reader1);
	JSONArray jsonArrays_StackDtails = (JSONArray) obj1;
	for (Object o1 : jsonArrays_StackDtails) {
		JSONObject jsonDetails2 = (JSONObject) o1;
		String name=(String)jsonDetails2.get("stock_Name");
		System.out.println("Stock Name:->"+name);
		
		Object share=jsonDetails2.get("number_Share");
		System.out.println("Number of share->"+share);
		
		Object amount=jsonDetails2.get("amount");
		System.out.println("Amount->"+amount);
		
		System.out.println("-----------------------------------------");
	}
	
}
}
