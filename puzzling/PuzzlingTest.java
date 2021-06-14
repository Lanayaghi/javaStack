import java.util.ArrayList;
import java.util.Collections;

public class PuzzlingTest {
    public static void main(String[] args){
        Puzzling pz = new Puzzling ();
        int[] myArray = {3,5,1,2,7,9,8,13,25,32};
        ArrayList<Integer> al = pz.arrayHandler(myArray);
        System.out.println(al);

    ArrayList<String> al = new ArrayList<String>();
    String[] array = {"Nancy", "Jinichi", "Fujibayash", "Momochi", "Ishikawa"};
    for(String i : array){
        al.add(i);
    }
    System.out.println(pz.women(al));

ArrayList <Character> alphabet = new ArrayList<Character> ();
for (char i = 'a'; i <='z' ; i++) {
    alphabet.add(i);
}

pz.shuffling(alphabet);

System.out.println(Arrays.toString(pz.numbersArray()));

ArrayList<Integer> myArray = pz.numbers();

pz.createRandoms();
pz.generateArray();
}
}

