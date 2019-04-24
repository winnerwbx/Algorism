import java.util.ArrayList;
import java.util.List;
import java.net.*;
import java.io.*;

import com.sun.org.apache.regexp.internal.recompile;

public class Main {

    public static void main(String[] args) throws Exception{
        //File file = new File("/Users/test-xq/Desktop/movies.csv.webarchive");
        //System.out.println("Hello World!");
        List<MyRate> result = getHTML("https://gist.githubusercontent.com/tyrchen/32c50aadca48aee3da10a77a18479517/raw/3aa07629e61239cd26cf514584c949a98aa38d67/movies.csv");
        List<MyRate> sortedList = new ArrayList<MyRate>();
        sortedList = sortList(result);
       // System.out.println(sortedList.size());
        for(int i = 0;i<10;i++){
            System.out.println(sortedList.get(i).toMyString());
        }
    }
    static class MyRate{
        String name;
        String running_time;
        String rating;

        double getRating(){
            try{
                return Double.parseDouble(rating);
            } catch(Exception e){
                return 0.0;
            }
        }
          
        
        String toMyString() {
            return(name+","+running_time+","+rating);
        }
    }

    public static List<MyRate> getHTML(String urlToRead) throws Exception {
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        List<MyRate> myRateList = new ArrayList<>();
        String line;
        while ((line = rd.readLine()) != null) {
            if(line.startsWith("name")){
                continue;
            }
            String[] splits = line.split(",");
            int size = splits.length;
            //".*,[\d\.].*,\d"
            MyRate myRate = new MyRate();
            myRate.name = splits[0];
            myRate.running_time = splits[1];
            myRate.rating = splits[2];
            myRateList.add(myRate);
        }
        rd.close();
        return myRateList;
     }

     static List<MyRate> sortList(List<MyRate> input){
        for(int i = 0; i< input.size();i++){
            int j = i+1;
            MyRate tmp = input.get(i);
            for(;j<input.size();j++){
                if(input.get(j).getRating() > input.get(i).getRating()){
                    input.set(i, input.get(j));
                    input.set(j, tmp);
                }
            }
        }
        return input;
     }
     
}
