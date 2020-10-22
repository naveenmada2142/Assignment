# Assignment
Assigment Nithya INC
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corejava;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Naveen
 */
public class Assignment {
    private static Month printFiles(File file) {
        
     
          long m = getFileCreation(file);
          Instant instant = Instant.ofEpochMilli(m);
         LocalDateTime  date = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
          Month month=date.getMonth();
         
         
          
      
     return  date.getMonth();
  }

  public static void sortFilesByDateCreated (File[] files) {
      Arrays.sort(files, new Comparator<File>() {
          public int compare (File f1, File f2) {
              long l1 = getFileCreation(f1);
              long l2 = getFileCreation(f2);
              return Long.valueOf(l1).compareTo(l2);
          }
      });
  }

  public static long getFileCreation (File file) {
      try {
          BasicFileAttributes attr = Files.readAttributes(file.toPath(),
                  BasicFileAttributes.class);
          return attr.creationTime()
                     .toInstant().toEpochMilli();
      } catch (IOException e) {
          throw new RuntimeException(file.getAbsolutePath(), e);
      }
  }
  
  
   public static void main(String[] args) {
      File dir = new File("C:\\Users\\apalya\\Downloads\\Microsoft.SkypeApp_kzf8qxf38zg5c!App\\All");
      File[] files = dir.listFiles();
     // System.out.println("-- printing files before sort --");
     
      sortFilesByDateCreated(files);
      //System.out.println("-- printing files after sort --");
      ii:for(int i=0;i<files.length;i++)
      {
          Month moni=  printFiles(files[i]);
          //System.out.println("corejava.Assignment.main()i mon"+moni);
          int count =0;
          for (int j=i;j<files.length;j++){
             
            Month monj = printFiles(files[j]);
           if (moni==monj)
           {
               if(j<files.length-1){
                 count ++;
           }
               else {
                   count ++;
                  System.out.println(moni +":"+count);
                  break ii;
               }
              
              
           }
           else {
               
               i=j-1;
               break;
           
               
               
           }
          }
          System.out.println(moni +":"+count);
      }
    
  }
}
