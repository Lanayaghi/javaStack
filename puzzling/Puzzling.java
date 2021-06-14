import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class Puzzling {
    public ArrayList <Integer> arrayHandler(int[] myArray){
        ArrayList <Integer> numbersGreaterThanTen = new ArrayList<Integer>();
    int sum = 0;
    for (int i  = 0 ; i < myArray.length ; i++){
        sum += myArray[i];
        if (myArray[i] > 10)
            numbersGreaterThanTen.add(myArray[i]);
    }
    System.out.println(sum);
    return numbersGreaterThanTen;
    }
    public ArrayList<String> women(ArrayList<String> myArray){
        Collections.shuffle(myArray);
        System.out.println(myArray);
        ArrayList<String> newAL = new ArrayList<String>();
        for(String x : myArray) {
            if(x.length() > 5)
                newAL.add(x);
        }
        return newAL;
    }
        
    public void shuffling(ArrayList<Character> jadArray){
    Collections.shuffle(jadArray);
    System.out.println(jadArray);
    System.out.println(jadArray.get(0));
    System.out.println(jadArray.get(jadArray.size()-1));
    char[] aeiou = {'a', 'e', 'i', 'o', 'u'};
    for (char i : aeiou){
        if(i == jadArray.get(0))
            System.out.println("The First letter is Vowel!");
                }
}
public int[] numbersArray(){
    int[] myArray = new int[10];
    Random r = new Random() ;
    for(int i = 0 ; i < 10 ; i++){
        myArray[i] = r.nextInt(100-55)+55;
    }
    return myArray;
}
public ArrayList<Integer> numbers(){
    ArrayList<Integer> myArray = new ArrayList<Integer>();
    Random r = new Random() ;
    for(int i = 0 ; i < 10 ; i++){
        myArray.add (r.nextInt(100-55)+55);
    }
    Collections.sort(myArray);
    System.out.println(myArray);
    System.out.println(myArray.get(0));
    System.out.println(myArray.get(myArray.size()-1));
    return myArray;
}
public String createRandoms(){
    String ran = new String();
    ArrayList<Character> alphabet = new ArrayList<Character> ();
    for(Character i = 'a' ; i <= 'z' ; i++){
        alphabet.add(i);
    }
    Random r = new Random();
    for(int i = 0 ; i < 5; i ++){
        ran += alphabet.get(r.nextInt(25));
    }
    System.out.println(ran);
    return ran;
}
public void generateArray(){
    ArrayList <String> nice = new ArrayList<String> ();
    for (int i = 0; i < 10; i++){
        nice.add(createRandoms());
    }
    System.out.println(nice);
}
}