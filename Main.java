import java.util.*;
import java.util.ArrayList;

class Main{
  public static void main(String[] args){
      HonestDictionary dictionary;
      dictionary = new HonestDictionary();
      //dictionary.MakeDictionary("A symptom of covid is coughing.");
      //dictionary.MakeDictionaryFromFile("honestdata.csv");
      //dictionary.WriteDictionaryToFile("A symptom of covid includes fever and high temperature. Make sure to reduce your fever.");
      //dictionary.MakeDictionaryFromFiletoWrite("honestdata.csv");
      dictionary.WriteData("a symptom of covid is coughing.");
      //dictionary.WriteDataFromFile("honestdata.csv");
  }
}
