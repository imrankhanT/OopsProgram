package com.bridgelabz.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

public class utility {
	static Scanner scanner=new Scanner(System.in);
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
static String regx_MobileNumber="xxxxxxxxxx";
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
	FileReader reader=new FileReader("/home/bridgeit/eclipse-workspace/OppsPrograms/stock_details.json");
	String name;
	int number_Of_Share,amount;
	
	//Scanner scanner=new Scanner(System.in);
	System.out.println("Enter the name of the user......");
	name=scanner.next();
	
	stock_User.put("user_Name",name);
	
	System.out.println("Enter the Number of Share");
	number_Of_Share=scanner.nextInt();
	stock_User.put("number_Share",number_Of_Share);
	
	
	System.out.println("Enter the amount......");
	amount=scanner.nextInt();
	stock_User.put("amount",amount);
	
	JSONParser jsonParser = new JSONParser();
    JSONArray jsonArray = (JSONArray) jsonParser.parse(reader); 
    boolean b=true;
    for(Object o : jsonArray) 
    {
    	JSONObject jsonDeatils = (JSONObject) o;
    	String user_Name=(String)jsonDeatils.get("user_Name");
    	if(user_Name.equals(name)) 
    	{
    		System.out.println("user Already Exsists.............");
    		b=false;	
    	}
    }
    if(b==true) 
    {
    jsonArray.add(stock_User);
	FileWriter fileWriter=new FileWriter("/home/bridgeit/eclipse-workspace/OppsPrograms/stock_details.json");
	fileWriter.write(jsonArray.toJSONString());
	fileWriter.flush();
	fileWriter.close();
	
    }
}

public static void Buy() throws IOException, ParseException, org.json.simple.parser.ParseException 
{
	File file = new File("/home/bridgeit/eclipse-workspace/OppsPrograms/stock_details.json");
	File file1 =new File("/home/bridgeit/eclipse-workspace/OppsPrograms/stock_symbol.json");
	if(file.exists() && file1.exists())
	{
		Scanner scan = new Scanner(System.in);
		// reading stock file
		FileReader fr = new FileReader(file);
		JSONParser parser = new JSONParser();
		JSONArray stock = (JSONArray) parser.parse(fr);
		//reading share file
		
		FileReader sf = new FileReader(file1);
		JSONParser parser1 = new JSONParser();
		JSONArray share = (JSONArray) parser1.parse(sf);
		
		System.out.println("Enter the user");
		String name = scan.nextLine();
		Iterator<?> itr = stock.iterator();
		Iterator<?> itr1 = share.iterator();
		boolean flag = false;
		while (itr.hasNext())
		{
			JSONObject obj=(JSONObject) itr.next();
			if(obj.get("user_Name").equals(name))
			{
				System.out.println("Enter the share sysmbol to buy share:[@,!,#]");
				String sym = scan.nextLine();
				/*obj.put("Share symbol", sym);
				if(obj.get("Share Symbol").equals(sym))
				{*/
					while(itr1.hasNext())
					{
						JSONObject obj1 = (JSONObject) itr1.next();
						if(obj1.get("stock_Symbol").equals(sym))
						{	
							System.out.println("Enter the amount");
							int amt= scan.nextInt();
							int bal =  Integer.parseInt(obj.get("amount").toString());
							int price = Integer.parseInt(obj1.get("amount").toString());
							int noShare =  Integer.parseInt(obj.get("number_Share").toString());
							int stockShare = Integer.parseInt(obj1.get("Count").toString());
							int numofshare = amt/price;
							int newbal = bal-amt;
							int sharecountcus = noShare+numofshare;
							int sharecountstock = stockShare-numofshare;
							obj.remove("amount");
							obj.remove("number_Share");
							obj1.remove("Count");
						    long millis=System.currentTimeMillis();  
						    java.util.Date date=new java.util.Date(millis);  
						    System.out.println("Transaction time is : "+date);  
							obj.put("amount",newbal);
							obj.put("number_Share",sharecountcus);
							obj1.put("Count", sharecountstock);
							
							flag= true;
							break;
						}
					}
				//}
				/*else
				{
					obj.put("Share symbol", sym);
					flag= true;
				}*/
			}
			FileWriter fs = new FileWriter(file);
			fs.write(JSONValue.toJSONString(stock));
			fs.flush();	
			fs.close();
		}
		if(flag == false)
		{
			System.out.println("User name not exits");
		}
		FileWriter fw = new FileWriter(file1);
		fw.write(JSONValue.toJSONString(share));
		fw.flush();
		fw.close();
	}
	else
	{
		System.out.println("File does not exits");
	}
}

public static void sell() throws Exception {
	File file = new File("/home/bridgeit/eclipse-workspace/OppsPrograms/stock_details.json");
	File file1 =new File("/home/bridgeit/eclipse-workspace/OppsPrograms/stock_symbol.json");
	if(file.exists() && file1.exists())
	{
		Scanner scan = new Scanner(System.in);
		
		FileReader fr = new FileReader(file);
		JSONParser parser = new JSONParser();
		JSONArray stock = (JSONArray) parser.parse(fr);
		
		FileReader sf = new FileReader(file1);
		JSONParser parser1 = new JSONParser();
		JSONArray share = (JSONArray) parser1.parse(sf);
		
		System.out.println("Enter the user");
		String name = scan.nextLine();
		Iterator<?> itr = stock.iterator();
		Iterator<?> itr1 = share.iterator();
		boolean flag = false;
		while (itr.hasNext())
		{
			JSONObject obj=(JSONObject) itr.next();
			if(obj.get("user_Name").equals(name))
			{
				System.out.println("Enter the share sysmbol to buy share:[@,!,#]");
				String sym = scan.nextLine();
			
					while(itr1.hasNext())
					{
						JSONObject obj1 = (JSONObject) itr1.next();
						if(obj1.get("stock_Symbol").equals(sym))
						{	
							System.out.println("Enter the amount");
							int amt= scan.nextInt();
							int bal =  Integer.parseInt(obj.get("amount").toString());
							int price = Integer.parseInt(obj1.get("amount").toString());
							int noShare =  Integer.parseInt(obj.get("number_Share").toString());
							int stockShare = Integer.parseInt(obj1.get("Count").toString());
							int numofshare = amt/price;
							int newbal = bal+amt;
							int sharecountcus = noShare-numofshare;
							int sharecountstock = stockShare+numofshare;
							obj.remove("amount");
							obj.remove("number_Share");
							obj1.remove("Count");
							long millis=System.currentTimeMillis();  
							java.util.Date date=new java.util.Date(millis);  
							System.out.println("Transaction time is"+date);  
							obj.put("amount",newbal);
							obj.put("number_Share",sharecountcus);
							obj1.put("Count", sharecountstock);
							
							flag= true;
							break;
						}
					}
			}
			FileWriter fs = new FileWriter(file);
			fs.write(JSONValue.toJSONString(stock));
			fs.flush();	
			fs.close();
		}
		if(flag == false)
		{
			System.out.println("User name not exits");
		}
		FileWriter fw = new FileWriter(file1);
		fw.write(JSONValue.toJSONString(share));
		fw.flush();
		fw.close();
	}
	else
	{
		System.out.println("File does not exits");
	}
	
}

public static void display() throws Exception 
{
	FileReader reader1=new FileReader("/home/bridgeit/eclipse-workspace/OppsPrograms/stock_details.json");
	JSONParser jsonParser1 = new JSONParser();
	JSONArray jsonArrays_StackDtails = (JSONArray) jsonParser1.parse(reader1);
	for (Object o1 : jsonArrays_StackDtails) 
	{
		JSONObject jsonDetails2 = (JSONObject) o1;
		String name=(String)jsonDetails2.get("user_Name");
		System.out.println("User Name:->"+name);
		
		Object share=jsonDetails2.get("number_Share");
		System.out.println("Number of share->"+share);
		
		Object amount=jsonDetails2.get("amount");
		System.out.println("Amount->"+amount);
		
		System.out.println("-----------------------------------------");
	}
	
}

public static void addDoctors() {
	System.out.println("Enter no. of doctors :");
	
	int num0fDoctor = scanner.nextInt();
	JSONArray array = new JSONArray();
	for (int i = 0; i < num0fDoctor; i++) {
		JSONObject json = new JSONObject();
		System.out.println("Enter name of doctor");
		String name = scanner.next();
		json.put("Doctor_Name", name);
		System.out.println("Enter I.D doctor");
		int id = scanner.nextInt();
		json.put("Doctor_ID", id);
		System.out.println("Enter Specialization of doctor");
		String specilization = scanner.next();
		json.put("Doctor_Specialization", specilization);
		System.out.println("Enter Availablity of doctor");
		String available = scanner.next();
		json.put("Doctor_Availiablity", available);
		array.add(json);
	}
	try {
		System.out.println("Data has been uploaded :");
		FileWriter jsonFileWriter = new FileWriter(
				"/home/bridgeit/eclipse-workspace/OppsPrograms/src/dotctor.json");
		jsonFileWriter.write(array.toJSONString());
		jsonFileWriter.flush();
		jsonFileWriter.close();
		System.out.println("Doctor Added:" + array);
	} catch (IOException e) {
		e.printStackTrace();
	}
}

public static void addPatient() {
	System.out.println("Enter no. of Patient");
	int num = scanner.nextInt();
	JSONArray array = new JSONArray();
	for (int i = 0; i < num; i++) {
		JSONObject json1 = new JSONObject();
		System.out.println("Enter patient name :");
		String patientname = scanner.next();
		json1.put("Patient_Name", patientname);
		System.out.println("Enter patient ID. :");
		int id = scanner.nextInt();
		json1.put("Patient_ID", id);
		System.out.println("Enter patient mobile number :");
		long number = scanner.nextLong();
		json1.put("Patient_MobileNumber", number);
		System.out.println("Enter patient age");
		int age = scanner.nextInt();
		json1.put("Patient_Age", age);
		array.add(json1);
	}
	try {
		System.out.println(" Patient data has been uploaded ...");
		FileWriter jsonFileWriter = new FileWriter(
				"/home/bridgeit/eclipse-workspace/OppsPrograms/src/patient.json");
		jsonFileWriter.write(array.toJSONString());
		jsonFileWriter.flush();
		jsonFileWriter.close();
		System.out.println("Pateint Added: " + array);
	} catch (IOException e) {
		e.printStackTrace();
	}

}
public static void searchDoctor() {
	try {
		JSONParser parser = new JSONParser();
		JSONArray array = (JSONArray) parser.parse(new FileReader(
				"/home/bridgeit/eclipse-workspace/OppsPrograms/src/dotctor.json"));
		System.out.println("Search Doctor_Name :");
		String name = scanner.next();
		for (Object obj : array) {
			JSONObject object = (JSONObject) obj;
			String string = (String) object.get("Doctor_Name");
			if (name.equals(string)) {
				System.out.println("Doctor_founded" + object);
			} else {
				System.out.println("Not Found !");
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}

}

public static void searchPatient() {
	System.out.println("Enter Name Of Patient");
	String name = scanner.next();
	try {
		JSONParser parser = new JSONParser();
		JSONArray array = (JSONArray) parser.parse(new FileReader(
				"/home/bridgeit/eclipse-workspace/OppsPrograms/src/patient.json"));
		for (Object object : array) {
			JSONObject jsonobject = (JSONObject) object;
			String string = (String) jsonobject.get("Patient_Name");
			if (name.equals(string)) {
				System.out.println("Patient_found " + jsonobject);
			} else {
				System.out.println("Not found !");
			}
		}
	} catch (Exception e) {
		System.out.println(e);
	}
}
	public static void takeAnAppointment() {
		System.out.println("Please enter Patient_Name");
		String patient_name = scanner.next();
		System.out.println("Enter Doctor_Name for to take an Appointment");
		String doctername = scanner.next();
		System.out.println("Enter the date");
		String stringDate = scanner.next();

		String doctorInfo = null;

		try {
			JSONParser parser = new JSONParser();
			JSONArray array = (JSONArray) parser.parse(new FileReader(
					"/home/bridgeit/eclipse-workspace/OppsPrograms/src/dotctor.json"));
			for (int i = 0; i < array.size(); i++) {
				JSONObject obj = (JSONObject) array.get(i);
				String doctorName = (String) obj.get("Doctor_Name");

				if (doctorName.equals(doctername)) {
					doctorInfo = doctorName;
				} else {
					System.out.println("doctors not found in this name");
				}
			}
			JSONArray appointmentFileObj = new JSONArray();

			JSONObject obj1 = new JSONObject();

			obj1.put("Doctor_Name", doctorInfo);

			obj1.put("Patient_Name", patient_name);
			obj1.put("Booking Date ", (stringDate));
			appointmentFileObj.add(obj1);
			FileWriter filewriter = new FileWriter(
					"/home/bridgeit/eclipse-workspace/OppsPrograms/src/com/bridgelabz/utility/appointment.json");
			filewriter.write(appointmentFileObj.toJSONString());
			filewriter.flush();
			filewriter.close();
			System.out.println("hello " + patient_name + " Your Appointment is fixed  With Doctor " + doctorInfo
					+ " For: " + (stringDate));
			System.exit(0);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	public static void inventryManager() throws Exception {
		JSONObject jsonObject1=new JSONObject();

		jsonObject1.put("company_Name","TCS");
		jsonObject1.put("companyShare","100");
		jsonObject1.put("amount","10000");
		
		
		JSONObject jsonObject2=new JSONObject();

		jsonObject2.put("company_Name","Orcale");
		jsonObject2.put("companyShare","200");
		jsonObject2.put("amount","20000");
		
		JSONObject jsonObject3=new JSONObject();
		
		jsonObject3.put("company_Name","Infosys");
		jsonObject3.put("companyShare","300");
		jsonObject3.put("amount","30000");
		
		JSONArray jsonArray=new JSONArray();
		jsonArray.add(jsonObject1);
		jsonArray.add(jsonObject2);
		jsonArray.add(jsonObject3);
	
		
		FileWriter fw=new FileWriter("/home/bridgeit/eclipse-workspace/OppsPrograms/src/com/bridgelabz/programs/jsonItem.json");
		fw.write(jsonArray.toJSONString());
		fw.flush();
		fw.close();
		
		FileReader reader = new FileReader("/home/bridgeit/eclipse-workspace/OppsPrograms/src/com/bridgelabz/programs/jsonItem.json");
		JSONParser jsonParser = new JSONParser();
		Object obj = jsonParser.parse(reader);
		JSONArray jsonArrays = (JSONArray) obj;
		for (Object o : jsonArrays) {
			JSONObject jsonDeatils = (JSONObject) o;

			String company_Name = (String) jsonDeatils.get("company_Name");
			System.out.println("company_Name--->" + company_Name);

			String company_Share = (String) jsonDeatils.get("companyShare");
			System.out.println("company_Share--->" + company_Share);
			int companyShare = Integer.parseInt(company_Share);

			String amount = (String) jsonDeatils.get("amount");
			System.out.println("Amount is......." + amount);
			int amounts = Integer.parseInt(amount);

			System.out.println("Total Inventary is......." + amounts * companyShare);
			System.out.println();

		}

	}
	
	public static<T extends Comparable> T[][] Sort(T[][] arr) {
		 int i,j;
		 for(i=0;i<arr.length;i++) {
			 for(j=1;j<(arr.length)-i;j++) {
				    if( (arr[j-1]).length > 0) {
					 T[] temp=arr[j-1];
					 arr[j-1]=arr[j];
					 arr[j]=temp;
				 }
	 }
		 }
		return arr;
	}
}


