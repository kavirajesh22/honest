import java.util.ArrayList;
import java.util.*;
import java.io.*;
import java.io.FileWriter;   
import java.io.IOException;

public class HonestDictionary {
  private ArrayList<String> mydictionary;
  
  public HonestDictionary() {
    mydictionary = new ArrayList<String>();
  }

  public void MakeDictionaryFromFile(String fileName) {
    // Read each line from the file and invoke MakeDictionary
    // That creates a big dictionary from all the strings 
    // in the file

    try {
    Scanner myscanner = new Scanner(new File(fileName));
    while (myscanner.hasNextLine()){
      String myline = myscanner.nextLine();
      MakeDictionary(myline);
    }
    } catch(IOException e){
      //System.out.println("failed to read file");
      e.printStackTrace();
    }
  }

  public void MakeDictionary(String mystring){
    mystring = mystring.toLowerCase();
    
    mystring = mystring.trim();
    String[] splitted = mystring.split(" ");

    System.out.println(mydictionary);
    for (int i=0;i<splitted.length; i++){
      splitted[i] = splitted[i].replaceAll("[^a-z]", "");
      
      if ((!(splitted[i].equals("a"))) && (!(mydictionary.contains(splitted[i])))){
        mydictionary.add(splitted[i]);
      }
      
    } 
    
    //System.out.println(mydictionary);
  }

  //these methods add the words to the dictionary
  public void MakeDictionaryFromFiletoWrite(String fileName) {
    // Read each line from the file and invoke MakeDictionary
    // That creates a big dictionary from all the strings 
    // in the file

    try {
      Scanner myscanner = new Scanner(new File(fileName));
      while (myscanner.hasNextLine()){
        String myline = myscanner.nextLine();
        WriteDictionaryToFile(myline);
      }
    } catch(IOException e){
      System.out.println("failed to read file");
      e.printStackTrace();
    }
  }

  public void WriteDictionaryToFile(String mystring){
      
    mystring = mystring.toLowerCase();
    mystring = mystring.trim();
    String[] splitted = mystring.split(" ");
    
    try{
      FileWriter myWriter = new FileWriter("dictionary.txt");
      for (int i=0;i<splitted.length; i++){
        splitted[i] = splitted[i].replaceAll("[^a-z]", "");
        
        if ((!(splitted[i].equals("a"))) && (!(mydictionary.contains(splitted[i])))){
          mydictionary.add(splitted[i]);
        }
      } 
      for (int i=0; i<mydictionary.size(); i++){
        myWriter.write(mydictionary.get(i) + "\n");
      }
      myWriter.close();
      //System.out.println("Successfully wrote to the file.");
    }catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    //System.out.println(mydictionary);
  }

  public void WriteDataFromFile(String fileName) {
    // Read each line from the file and invoke MakeDictionary
    // That creates a big dictionary from all the strings 
    // in the file

    try {
      Scanner myscanner = new Scanner(new File(fileName));
      while (myscanner.hasNextLine()){
        String myline = myscanner.nextLine();
        WriteData(myline);
      }
    } catch(IOException e){
      System.out.println("failed to read file");
      e.printStackTrace();
    }
  }

  public void WriteData(String mystring){
      
    mystring = mystring.toLowerCase();
    mystring = mystring.trim();
    String[] splitted = mystring.split(" ");
    
    try{
      FileWriter myWriter = new FileWriter("honestvalues.csv");
      for (int i=0; i<splitted.length; i++){
        if (mydictionary.contains(splitted[i])){
          myWriter.write((mydictionary.indexOf(splitted[i])+1) + " ");
          //System.out.println((mydictionary.indexOf(splitted[i])+1) + " ");
        }
      }

      myWriter.write("\n");
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    }catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    //System.out.println(mydictionary);
  }

}
