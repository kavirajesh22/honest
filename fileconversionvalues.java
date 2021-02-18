import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
class Main {
  public static void main(String[] args) {
    BufferedReader reader;
    try{
      reader = new BufferedReader(new FileReader("values.csv"));

      //String str = "49 14 50 98 99 61 62 136";
      String str = reader.readLine();
      //System.out.println(str);   
      while (str != null){
        str = str.replaceAll("[^0-9]+", " ");
        int o=str.trim().split(" ").length;
        //System.out.println(o);
        while (o<24){
          str+= "0 ";
          o+=1;
        }
        System.out.println(str);
        str="";
        str = reader.readLine();
      }
      reader.close();
    } catch (IOException e){
      e.printStackTrace();
    }
      
    
    //System.out.println(str);
  
  }


}
