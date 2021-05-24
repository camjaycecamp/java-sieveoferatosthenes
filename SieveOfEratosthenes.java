// cameron campbell
// advanced java
// occc spring 2021
// sieve of eratosthenes program

import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

/*
 *  
 *  largest array of type bool you can create in Java: 2,147,483,645
 *  this is the the max value of the java integer
 *  
 *  
 *  calculate from 2 to:
 *  100,000       - less than a second (9,592 prime numbers)
 *  1,000,000     - less than a second (78,498 prime numbers)
 *  10,000,000    - less than a second (664,579 prime numbers)
 *  100,000,000   - one second		   (5,761,455 prime numbers)
 *  1,000,000,000 - ten seconds		   (50,847,534 prime numbers)
 *  2,000,000,000 - twenty seconds	   (98,222,287 prime numbers)
 *  
 *  note: this is only for the computation of the sieve algorithm. the printing of these primes will take much, MUCH longer
 *  
 *  
 *  lg(100,000) = 16.609...
 *  lg(2,000,000,000) = 30.897...
 *  the asymptotic notation of my Sieve of Eratosthenes is O(lg n).
 *  20,000 times the size and only around 40 times longer to process
 *  
 */


public class SieveOfEratosthenes {
	
	public static void main(String args[]) 
	{
		Scanner sc = new Scanner(System.in);
		int startValue, stopValue;
		
		if(args.length == 2) 
		{
			startValue = Integer.parseInt(args[0]);
			stopValue = Integer.parseInt(args[1]);
		}
		else if(args.length == 1) 
		{
			startValue = Integer.parseInt(args[0]);
			System.out.println("Next, enter a stop value: ");
			stopValue = sc.nextInt();
		}
		else
		{
			System.out.println("Welcome to the Sieve of Eratosthenes Program!");
			System.out.println("To start, please provide a start value greater than 1: ");
			startValue = sc.nextInt();
			System.out.println("Next, enter a stop value: ");
			stopValue = sc.nextInt();
		}
		SieveAlgorithm(startValue, stopValue);
	}
		
		static void SieveAlgorithm(int startValue, int stopValue) 
		{
			boolean isPrimeArray[] = new boolean[stopValue];
			Arrays.fill(isPrimeArray, Boolean.TRUE);
			isPrimeArray[0] = false;
			isPrimeArray[1] = false;
			System.out.println(Math.sqrt(isPrimeArray.length));
			for (int i = 2; i < Math.sqrt(isPrimeArray.length); i++)
			{
				if(isPrimeArray[i] == true) 
				{
					for (int j = i*2; j < isPrimeArray.length; j += i)
					{
						isPrimeArray[j] = false;
					}
				}
			}
			System.out.println("Computation complete. Prime numbers from " + startValue + " to " + stopValue + ": ");
			for (int i = startValue; i < isPrimeArray.length; i++) 
			{
				if (isPrimeArray[i] == true) 
				{
					System.out.print(i + " ");
				}
		    }
		}
}
