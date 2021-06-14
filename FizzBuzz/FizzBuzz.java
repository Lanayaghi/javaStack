public class FizzBuzz{
    public String TestNumber(int number) {
    if (number % 3 == 0){
        System.out.println("Fizz");
    }
    if (number % 5 == 0 ){
        System.out.println("Buzz");
    }
    if (number % 3 ==0 && number % 5 == 0){
        System.out.println("FIzzBuzz");
    }
    return "thats it!";
    }
}