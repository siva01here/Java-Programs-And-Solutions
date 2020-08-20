package com.qa.basicJavaExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *	Programs 1 -31
 */
public class ProgramsSet1 {
	static Scanner objScanner;
	
	public static void main(String[] args) {
		findRootsOfQuadraticEquations(15, 68, 3);
	}
	
	//1. Prints a number entered in the console
	static void printValue_EnteredInConsole() {
		objScanner= new Scanner(System.in);
		System.out.println("Enter a number...");
		int num=objScanner.nextInt();
		objScanner.close();
		System.out.println("Value enetered in the console is "+num);
	}
	
	//2.Calculates the sum of given two numbers
	static int addTwoNumbers(int a, int b) {
		return (a+b);
	}
	
	//3.Calculates the product of two floating point numbers
	static float prodTwoNumbers(float a, float b) {
		return (a*b);
	}
	
	//4.Finds the ascill value of the given character
	static int findAsciiValueOfChar(char ch) {
		return (int)ch;
	}
	
	//5.Calculates quotient and reminder of two given numbers
	static void findQuotientReminders(int a,int b) {
		float quotient=((float)a)/((float)b);
		System.out.println("Quotient of the given two numbers is "+quotient);
		System.out.println("Reminder of the given two number is "+(a%b));
	}
	
	//6.Swaps two integer values 
	static void swapTwoNumbers(int a, int b) {
		System.out.println("Numbers before swapping is "+a+"..."+b);
		
		//approach 1 using temp variable
		int temp=a;
		a=b;
		b=temp;
		System.out.println("Numbers after swapping is "+a+"..."+b);
		
		//approach 2 using addition and subtraction
		System.out.println("Numbers before swapping is "+a+"..."+b);
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("Numbers after swapping is "+a+"..."+b);
	}
	
	//7. Checks given number is even or odd
	static boolean checkEvenOrOdd(int num) {
		if(num%2==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//8. Checks given character is a vowel or consonant
	static boolean isVowel(char ch) {
		String temp=Character.toString(ch);
		return temp.replaceAll("[aeiouAEIOU]", "").length()==0;
	}
	
	//9. Finds the largest of 3 numbers 
	static void largestOfThree(int a, int b, int c) {
		//approach 1 using if condition
		if(a>b && a>c) {
			System.out.println(a+" is the largest of 3 numbers");
		}
		else if(b>a && b>c) {
			System.out.println(b+" is the largest of 3 numbers");
		}
		
		else {
			System.out.println(c+" is the largest of 3 numbers");
		}
		
		//approach 2 ternary operator
		int temp1=a>b && a>c? a: (b>a && b>c)? b:c;
		
		System.out.println(temp1);
	}
	
	//10. Finds the Roots of a quadratic equation using the formula
	static void findRootsOfQuadraticEquations(double a, double b, double c) {
		/*
		 * formula is x=(-b(+or-)sqrtOf(b^2-(4ac))/(2*a)
		 */
		
		double determinant=(b*b)-(4*a*c);
		double root1=0, root2=0;
		
		/*
		 * if determinant is greater than zero then the roots are -b+sqrt(determinant)/(2*a) & -b-sqrt(determinant)/(2*a)
		 * else -b/(2*a) 
		 */
		
		if(determinant>0) {
			root1=((-1*b)+Math.sqrt(determinant))/(2*a);
			root2=((-1*b)-Math.sqrt(determinant))/(2*a);
		}
		else {
			root1=root2=((-1*b)+Math.sqrt(determinant))/(2*a);
		}
		System.out.println("Roots of the quadratic equation are "+root1+"..."+root2);
	}
	//11. Checks the given is a leap year or not
	static boolean leapYearCheck(int year) {
		return (year%4==0);
	}
	//12. Checks the given number is positve or negative
	static boolean checkNumber_PositiveOrNegative(int number) {
		if(number<0) {
			System.out.println("Number is negative");
			return true;
		}
		else if(number==0) {
			System.out.println("Number is zero so it is neither positive nor negative");
			return false;
		}
		else {
			System.out.println("Number is positive");
			return false;
		}
	}
	//13. Checks the given character is an alphabet or not
	static void checkAlphabetOrNot(char ch) {
		int temp=(int)ch;
		if((temp>=65 && temp<=90) || (temp>=97 && temp<=122)) {
			System.out.println("Given character is an alphabet");
		}
		else {
			System.out.println("Given character is not a alphabet");
		}
	}
	
	//14. Calculates the sum of given natural numbers
	static void sumOfNaturalNumbers(int a, int b, int c) {
		int sum=0;
		
		if(a<0) {
			System.out.println(a+" is not a natural number so it will be skipped");
			sum=b+c;
		}
		else if(b<0) {
			System.out.println(b+" is not a natural number so it will be skipped");
			sum=a+c;
		}
		else if(c<0) {
			System.out.println(c+" is not a natural number so it will be skipped");
			sum=a+b;
		}
		else {
			System.out.println("All given numbers are natural numbers");
			sum=a+b+c;
		}
		System.out.println("Sum of natural numbers "+sum);
	}
	
	//15. Find factorial of a number
	static void findFactorial(int num) {
		int product=1;
		if(num>0) {
			for(int i=num;i>=1;i--) {
				product=product*i;
			}
		}
		System.out.println("Factorial of "+num+" is "+ product);
	}
	
	//16. Generate multiplication table till 10 for the given number
	static void generateMultiplicationTable(int num) {
		if(num>0) {
			for(int i=1;i<=10;i++) {
				System.out.println(num+" * "+i+" = "+(num*i));
			}
		}
		else {
			System.out.println("Enter a number > 0");
		}
	}
	
	//17. Calculates fibonacci series from 0 till the given number
	static void fibonacciSeries(int num) {
		int n1=0, n2=1, n3=0;
		
		for(int i=0;i<=num;i++) {
			if(i==0) {
				System.out.print(n1);
			}
			else if(i==1) {
				System.out.print("..."+n2);
				if(num>1) {
					System.out.print("...");
				}
			}
			else {
				n3=n1+n2;
				if(i<num) {
					System.out.print(n3+"...");
				}
				else {
					System.out.println(n3);
				}
				n1=n2;
				n2=n3;
			}
		}
	}
	
	//18. Find GCD of two numbes
	static void findGCD(int a, int b) {
		int gcdValue=Integer.MIN_VALUE;
        int n=a>b?a:b;
        for(int i=1;i<=n;i++)
        {
        	if(a%i==0 && b%i==0)
        	{
        		if(i>gcdValue)
        		{
        			gcdValue=i;
        		}
        	}
        }
        System.out.println("GCD of the given two numbers is "+gcdValue);
	}
	
	//19. Find LCM of two numbers
	static void findLCM(int a, int b) {
		int gcdValue=Integer.MIN_VALUE;
		int n=a>b?a:b;
		
		for(int i=1;i<=n;i++) {
			if(a%i==0 && b%i==0) {
				if(i>gcdValue) {
					gcdValue=i;
				}
			}
		}
		
		int lcmValue=(a*b)/gcdValue;
		
		System.out.println("LCM value of "+a+" and "+b+" are "+lcmValue);
	}
	
	//20. Prints the alphabets from A-Z or a-z depends on the given choice
	static void printAlphabets(String choice) {
		int num1=65, num2=num1+25, num3=97, num4=num3+25;;
		
		if(choice.equalsIgnoreCase("Upper Case")) {
			for(int i=num1;i<=num2;i++) {
				if(i<num2) {
					System.out.print((char)i+"....");
				}
				else {
					System.out.print((char)i);
				}
			}
		}
		else if(choice.equalsIgnoreCase("Lower Case")) {
			for(int i=num3;i<=num4;i++) {
				if(i<num4) {
					System.out.print((char)i+"....");
				}
				else {
					System.out.print((char)i);
				}
				
			}
		}
		else {
			System.out.println("Invalid choice of alphabets");
		}
	}
	
	//21. Counts the number of digits in the given integer
	static void countNumberOfDigits(int number) {
		//approach 1 using String length
		String temp=Integer.toString(number);
		System.out.println("Number of digits in "+number+" is "+temp.replaceAll("[^0-9]", "").length());
		
		//approach 2 using while loop
		int countDigits=0, origNum=number;
		while(number!=0) {
			countDigits++;
			number=number/10;
		}
		
		System.out.println("Number of digits in "+origNum+" is "+countDigits);
	}
	
	//22. Reverse the given number
	static void reverseNum(int number) {
		int origNum=number, reverseNum=0;
		while(number!=0) {
			reverseNum=(reverseNum*10)+number%10;
			number=number/10;
		}
		System.out.println("Number "+origNum+" after reversal is "+reverseNum);
	}
	
	//23. Calculate the power of the given numbers
	static void calculatePower(int number, int power) {
		//approach 1 using Math.pow
		double result1= Math.pow(number, power);
		System.out.println(number+" to the power of "+power+" is "+result1);
		
		//approach 2 using for loop
		double result2=1;
		for(int i=1;i<=power;i++) {
			result2=result2*number;
		}
		System.out.println(number+" to the power of "+power+" is "+result2);
		
	}
	
	//24. Check number is palindrome or not
	static boolean numberPalindromeCheck(int number) {
		int origNum=number, reverseNum=0;
		
		while(number!=0) {
			reverseNum=(reverseNum*10)+(number%10);
			number=number/10;
		}
		
		return origNum==reverseNum;
	}
	
	//25. Check number is prime or not
	static boolean numberPrimeCheck(int number) {
		boolean result=false;
		
		for(int i=2;i<=number;i++) {
			int k=0;
			for(int j=2;j<=i/2;j++) {
				if(i%j==0) {
					k=k+1;
				}
			}
			if(k<=0) {
				System.out.print(i+"...");
				if(i==number) {
					result=true;
				}
			}
		}
		return result;
	}
	//26. Prints all prime number between the given range
	static void printPrimeRange(int num1, int num2) {
		for(int i=num1;i<=num2;i++) {
			int k=0;
			for(int j=num1;j<=i/2;j++) {
				if(i%j==0) {
					k+=1;
				}
			}
			if(k<=0) {
				System.out.print(i+"\t");
			}
		}
	}
	//27. Check given number is armstrong number
	static boolean numberArmstrongCheck(int number) {
		int origNum=number, armstrongNum=0;
		while(number!=0) {
			int temp=number%10;
			armstrongNum=armstrongNum+(temp*temp*temp);
			number=number/10;
		}
		return origNum==armstrongNum;
	}
	
	//28. Check armstrong number in the given range
	static void armstrongNumbersInRange(int number1, int number2) {
		int armstrongNum=0;
		
		for(int i=number1;i<=number2;i++) {
			int temp1=i;
			while(temp1!=0) {
				int temp2=temp1%10;
				armstrongNum=armstrongNum+(temp2*temp2*temp2);
				temp1=temp1/10;
			}
			if(armstrongNum==i) {
				System.out.println("Number "+i+" is an armstrong number");
			}
			else {
				System.out.println("Number "+i+" is not an armstrong number");
			}
			armstrongNum=0;
		}
	}
	
	// 29. Finds all the factors of the given number
	static void findFactorsOfNumber(int number) {
		System.out.println("Factors of the given number is :");
		for(int i=1;i<=number;i++) {
			if(number%i==0) {
				System.out.println(i);
			}
		}
	}
	
	// 30. Simple calculator using switch case
	static void simpleCalculator(int num1, int num2, String ops) {
		
		switch(ops.toUpperCase()) {
		case "ADD":
			System.out.println(num1+num2);
			break;
		case "SUB":
			System.out.println(num1-num2);
			break;
		case "MUL":
			System.out.println(num1*num2);
			break;
		case "DIV":
			System.out.println(num1/num2);
			break;
		case "MOD":
			System.out.println(num1%num2);
			break;
		default:
			System.out.println("Invalid operation");
			break;
		}
	}
	
	// 31. Check whether number can be expressed as a sum of two prime numbers
	static void checkSumOfPrimes(int number) {
		int temp1=0, temp2=0;
		boolean result=false;
		List<Integer> primes= new ArrayList<Integer>();
		
		for(int i=2;i<=number;i++) {
			int k=0;
			for(int j=2;j<=i/2;j++) {
				if(i%j==0) {
					k=k+1;
				}
			}
			if(k<=0) {
				primes.add(i);
			}
		}
		
		for(int i:primes) {
			temp2=number-i;
			if(primes.contains(temp2)) {
				temp1=i;
				result=true;
				break;
			}
		}
		
		if(result) {
			System.out.println("Yes the number "+number+" can be expressed as a sum of two prime numbers which are "+temp1+"..."+temp2);
		}
		else {
			System.out.println("No the number cannot be expressed as a sum of two prime numbers");
		}
	}
}
