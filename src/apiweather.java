import java.io.*;
import java.net.*;
import java.util.*;

import com.google.gson.*;
import com.google.gson.reflect.*;

class apiwJava{
    public static Map<String, Object> jsonToMap(String str) {
        Map<String, Object> map = new Gson().fromJson(str, new TypeToken<HashMap<String, Object>>() {}.getType());
        
        return map;
    }

    public static void main(String[] args) {
        String key = "";
        String pincode = "600001,IN";
        String urlsite = "https://api.weathersource.com/v1/"+ key +"/postal_codes/"+ pincode +"/history.json?period=day&timestamp_between=2020-04-08,2020-04-14&fields=allTemp,allHum";

        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL(urlsite);
            URLConnection connection = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream() ));
            String line;
            while((line = rd.readLine()) != null)
            {
                result.append(line);
            } 
            rd.close();
            System.out.println(result);
            try (PrintWriter out = new PrintWriter("wthr.json")) {
                out.println(result);
            }catch (Exception e) {
                System.out.println("Err: " + e);
            }
            Map <String, Object> respMap = jsonToMap(result.toString());

            System.out.println(respMap.get("dewptavg"));
        } catch (Exception e) {
            System.out.println("Err: " + e);
        }
    }
}
