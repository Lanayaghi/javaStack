public class StringManipulatorTesting {
    public static void main(String[] args) {
        StringManipulator manipulator =new StringManipulator();
        String str = manipulator.trimAndConcat("    Hello     ","     World    ");
        System.out.println(str);



Integer value = manipulator.GetIndexOrNull("Coding",'o' );
System.out.println(value);


String word = "Hello";
String subString = "llo";
String notSubString = "world";
Integer  value1= manipulator.GetIndexOrNull(word, subString);
Integer value2 = manipulator.GetIndexOrNull(word, notSubString);
System.out.println(value1); // 2
System.out.println(value2); // null



String w = manipulator.concatSubstring("Hello", 1, 2, "world");
System.out.println(w); // eworld

    }
}
