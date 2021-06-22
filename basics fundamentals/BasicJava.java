// Print 1-255
public class BasicJava{
    public static void main(String[] args){
        int[] myArray;
        myArray = new int[256];
        for (int i = 0; i < 256; i++){
            System.out.println( i);  
        }


// Print odd numbers between 1-255
        
        for (int i = 0; i < 256; i++){
            if (i % 2 == 0){
                System.out.println(i);
                }
            
            }

// Print Sum

    }

    	//Find Max
		int array[] = {-3,5,10};
		int Max = array[0];
		for (int i =0; i<array.length;i++){
			if (array[i] > Max){
				Max = array[i];
			}
		}
			System.out.println(Max);

            	// Get Average
		int arrayA [] = {2,10,3};
		int summa = 0;
		for (int i = 0;i<arrayA.length;i++){
			summa = summa + arrayA[i];
		}
	int avg = summa / arrayA.length;
		System.out.println(avg);
		//Array with Odd Numbers
		ArrayList<Integer> y = new ArrayList<Integer>();
		for (int i = 0; i<256;i++){
			if (i % 2 != 0){
				y.add(i);
			}
		}
		System.out.println(y);

        	//Greater than Y
		int counter = 0;
		int z = 3;
		int arrayB [] = {1,3,5,7};
		for (int i = 0;i < arrayB.length; i++){
			if (arrayB[i] > z){
				counter ++;
			}
		}
		System.out.println(counter);

        	//Square the values
		int arrayC [] = {4,6,8};
		for(int i=0; i<arrayC.length;i++){
			arrayC[i] = arrayC[i]*arrayC[i];
		}

        	//Eliminate Negatives
		int arrayD [] = {10,9,-5,-15};
		for (int i = 0; i <arrayD.length;i++){
			if (arrayD[i] < 0){
				arrayD[i] = 0;
			
            	//MaxMinAverage
		int arrayE [] = {14,2,33,100};
		int min = FindMin(arrayE);
		int max = FindMax(arrayE);
		double avg = GetAverage(arrayE);
		System.out.println(String.format("Max:%d,Min:%d,Average:%f",max,min,avg))

        		//Shifting the Values in the Array
		int arrayF [] = {1,5,10,7,-2};
		int temp = 0;
		for (int i =0;i<arrayF.length;i++){
			arrayF[i] = arrayF[i+1];
			arrayF[i.length] = 0;
		}
	}

}
  