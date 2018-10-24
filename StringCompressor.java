import java.util.List;
import java.util.ArrayList;
import javafx.util.Pair;
/*
String Compressor 
Finds the frequency of a given character in a string at its position

Algorithm:
Starting from the first character, compare each element(i) with the character in its (i + 1) position
Increment a varible 'frequency' for every similar character encountered when iterating through i
If a new character is found, return the previous character with its accumulated frequency
If resulting string has a greater length than original string, return original string 
*/
class StringCompressor {

    public static void main(String[] args) {
        System.out.println(compress("aabbccdd")); 
    }



    public static String compress(String string){

        List<Pair<Character, Integer>> results = new ArrayList<>();
        char [] charList = string.toCharArray();
        int frequency = 1;

        for(int i = 0; i < charList.length-1; i++){
            
           char c = charList[i];

           if(c == charList[i + 1]){
               
                frequency++;

                if(i == (charList.length-2)){
                    results.add(new Pair(charList[i], frequency));
                    break;
                }
                continue;
           }
           else{
            
               results.add(new Pair(charList[i], frequency));

               if(i == (charList.length-2)){
                    results.add(new Pair(charList[i+1], 1));
                    break;
                }
               frequency = 1;
           }

        }

        String finalString = format(results);
        
        if(finalString.length() > string.length()){
            return string;
        }else{
            return finalString;
        }
    }

    public static String format(List<Pair<Character, Integer>> listCharInt){

        StringBuilder sb = new StringBuilder();

        for(Pair pr : listCharInt){
            sb.append(pr.getKey());
            sb.append(pr.getValue());
        }

        return sb.toString();
    }
}