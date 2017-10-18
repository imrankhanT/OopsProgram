import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class writeJson {

	public static void main(String[] args) throws Exception {
		JSONObject jsonObject1=new JSONObject();

		jsonObject1.put("stock_Name","imran");
		jsonObject1.put("number_Share",100);
		jsonObject1.put("amount",10000);
		
		
		JSONObject jsonObject2=new JSONObject();
		jsonObject2.put("stock_Name","Adam");
		jsonObject2.put("number_Share",200);
		jsonObject2.put("amount",20000);
		

		JSONObject jsonObject3=new JSONObject();
		jsonObject3.put("stock_Name","shane");
		jsonObject3.put("number_Share",300);
		jsonObject3.put("amount",30000);
		
		JSONArray jsonArray=new JSONArray();
		jsonArray.add(jsonObject1);
		jsonArray.add(jsonObject2);
		jsonArray.add(jsonObject3);
		
		FileWriter fw=new FileWriter("/home/bridgeit/eclipse-workspace/OppsPrograms/src/com/bridgelabz/programs/inventryManager.json");
		fw.write(jsonArray.toJSONString());
		fw.flush();
		fw.close();
	}

}
