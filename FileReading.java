/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corejava;

import java.io.File;
import java.io.FileNotFoundException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author apalya
 */
public class FileReading {
    public static void main(String[] args) throws ParseException {
        
        try {
      File myObj = new File("C:\\Users\\apalya\\Documents\\filename.txt");
      Scanner myReader = new Scanner(myObj);
      List<String> list=new ArrayList<>();
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        list.add(data);
       // System.out.println(data);
      }
     
      
      for(int i=0;i<list.size();i++){
     String value= list.get(i).split(",")[0];
        // System.out.println(value);
         for(int j=i+1;j<list.size();j++)
         {
            String valueOfNext= list.get(j).split(",")[0];
            if (value.equalsIgnoreCase(valueOfNext))
            {
                if(!list.get(i).split(",")[3].equalsIgnoreCase(list.get(j).split(",")[3]))
                {
                    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm a");
                  
                String time=list.get(i).split(",")[2];
                  //System.out.println("listofj"+time); 
               String time1=list.get(j).split(",")[2];
                
     
    Date date1 = formatter.parse(time);
		Date date2 = formatter.parse(time1);
    
             
      long milliSeconds=      date2.getTime()- date1.getTime();
      
     System.out.println("For Transction ID:"+value+"  milliseconds"+milliSeconds);
     /// System.out.println(" occurred."+valuein);
      long seconds = (milliSeconds/1000);
      System.out.println("For Transction ID:"+value+"  seconds"+seconds);
         long minutes = (seconds/60);
      System.out.println("For Transction ID:"+value+"  minutes"+minutes);

                }
               
            }
         }
         
      }
      
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
        
    }
}
