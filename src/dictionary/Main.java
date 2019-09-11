package dictionary;

public class Main {

    public static void main(String[] args) {
        MindfulDictionary dict = new MindfulDictionary("src/words.txt");
        dict.add("zec", "bunny");
        dict.add("zmija", "snake");
        dict.add("medvjed", "bear");
        dict.save();
      
        System.out.println(dict.translate("zec"));
        System.out.println(dict.translate("snake"));
        System.out.println(dict.translate("medvjed"));
       
        
        
        
        
        
        
        
        
    }
}
