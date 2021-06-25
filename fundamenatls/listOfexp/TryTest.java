import java.util.ArrayList;

public class TryTest{
    public static void main(String[] args){
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");
        
        try {
            for (Object value : myList){
                System.out.println((int) value);
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("this exiption has accured beacuse there is a fault");

        }
    
    System.out.println("every thing is okay");
}
}