package com.qa.basicJavaExercises;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Programs 32-64
 */
public class ProgramsSet2 {
	static Scanner objScanner;
	double realNum;
	double imgNum;
	
	ProgramsSet2(double real, double img){
		this.realNum=real;
		this.imgNum=img;
	}
	
	
	public static void main(String[] args) {
//		int[][] arr1= {{1,2,3,0},{1,2,3,0},{1,3,2,1}};
//		int[][] arr2= {{1,2,3,0},{1,2,3,0},{1,3,2,1}};
//		String[] strArr= {"z","B","a","b","c","A"};
//		int[] arr3= {1,2,3,4,4};
//		int[] arr4= {45,6,7};
//		ProgramsSet2 obj1= new ProgramsSet2(-5.6,-9.2);
//		ProgramsSet2 obj2= new ProgramsSet2(2,3);
//		double realSum=obj1.calculateComplexNumSum(obj1, obj2).realNum;
//		double imgSum=obj1.calculateComplexNumSum(obj1, obj2).imgNum;
//		String temp="";
//		
//		if(imgSum>0) {
//			temp="+";
//		}
//		else {
//			temp="-";
//		}
		addDates("31/01/2019","28/10/0");
	}
	
	// 32. Calculates sum of natural numbers using recursion
	static int sumOfNaturalNumbersRange(int number) {
		int sum=0;
		if(number<=0) {
			return 0;
		}
		return sum+=number+sumOfNaturalNumbersRange(number-1);
	}
	
	//33. Calculates factorial of a number using recursion
	static int factorialRecursion(int number) {
		int factorial=1;
		
		if(number==0 || number==1) {
			return 1;
		}
		return factorial=(factorial*number)*factorialRecursion(number-1);
	}
	
	//34. Calculates the gcd of two numbers using recursion
	static int gcdRecursion(int number1, int number2) {
		if(number2!=0) {
			return gcdRecursion(number2, number1%number2);
		}
		else {
			return number1;
		}
	}
	
	//Calculates lcm of two numbers
	static int lcmOfTwoNumbers(int number1, int number2) {
		return (number1*number2)/gcdRecursion(number1, number2);
	}
	
	//35. Converts a binary number to decimal number and the same decimal number back to binary
	static void convertToBinary(int num) {
		String decimalNum=Integer.toString(num);
		System.out.println("Decimal form of the given number is "+decimalNum);
		String binaryNum=Integer.toBinaryString(Integer.valueOf(decimalNum));
		System.out.println("Binary form of the given number is "+binaryNum);
	}
	
	// 36. convert octal number to decimal number and the same decimal number back to octal
	static void convertToOctal(int num) {
		String decimalNum=Integer.toString(num);
		System.out.println("Decimal form of the given number is "+decimalNum);
		String octalNum=Integer.toOctalString(Integer.valueOf(decimalNum));
		System.out.println("Octal form of the number is "+octalNum);
		
	}
	
	//37. prints the given sentence in reverse using recursion
	static String reverseRecursion(String str) {
		String temp="";
		if(str.length()==0) {
			return "";
		}
		return temp+=str.charAt(str.length()-1)+reverseRecursion(str.substring(0,str.length()-1));
	}
	
	//38. Power of a number using recursion
	static double calculatePowerOfNum(int number, int power) {
		double result=1;
		if(power==0) {
			return 1;
		}
		return result=(result*number)*calculatePowerOfNum(number, power-1);
	}
	
	//39. Calculates average of elements in the array
	static void calculateAverage(int[] arr) {
		double sum=0, avg=0;
		for(int i:arr) {
			sum+=i;
		}
		avg=sum/arr.length;
		System.out.println("Average of the given array is "+avg);
	}
	
	//40. find the largest element in the array
	static void findLargestElement(int[] arr) {
		int largest=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(i>largest) {
				largest=arr[i];
			}
		}
		System.out.println("Largest element in the given array is "+largest);
	}
	
	//41. Calculates the standard deviation of the array
	static void findStandardDeviation(int[] arr) {
		double sum=0, avg=0, sdSum=0, sd=0;
		
		for(int i:arr) {
			sum+=i;
		}
		avg=sum/arr.length;
		
		for(int i:arr) {
			double temp=Math.abs(avg-i);
			sdSum+=(temp*temp);
		}
		
		sd=Math.sqrt(sdSum/arr.length);
		System.out.println("Standard deviation of the given array is "+sd);
	}
	
	//42. Adds two matrices (i.e.) multi dimensional arrays
	static void addMultiDimensionalArrays() {
		objScanner= new Scanner(System.in);
		System.out.println("Enter the rows and columns for array 1");
		int row1=objScanner.nextInt();
		int col1=objScanner.nextInt();
		System.out.println("Enter the rows and columns for array 2");
		int row2=objScanner.nextInt();
		int col2= objScanner.nextInt();
		
		
		int minRow=row1<row2?row1:row2;
		int minCol=col1<col2?col1:col2;
		
		int[][] arr1=new int[row1][col1];
		int[][] arr2=new int[row2][col2];
		int[][] result=new int[minRow][minCol];
		
		System.out.println("Enter the elements for array 1 ");
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr1[i].length;j++){
					arr1[i][j]=objScanner.nextInt();
			}
		}
		
		System.out.println("Enter the elements for array 2 ");
		for(int i=0;i<arr2.length;i++) {
			for(int j=0;j<arr2[i].length;j++){
					arr2[i][j]=objScanner.nextInt();
			}
		}
		
		for(int i=0;i<minRow;i++) {
			for(int j=0;j<minCol;j++) {
				result[i][j]=arr1[i][j]+arr2[i][j];
			}
		}
		
		System.out.println("Array 1 elements are ");
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr1[i].length;j++){
					System.out.print(arr1[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("Array 2 elements are ");
		for(int i=0;i<arr2.length;i++) {
			for(int j=0;j<arr2[i].length;j++){
					System.out.print(arr2[i][j]+" ");
			}
			System.out.println();
		}
		
		
		System.out.println("Result Array elements are ");
		for(int i=0;i<result.length;i++) {
			for(int j=0;j<result[i].length;j++){
					System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
		
		objScanner.close();
	}
	
	//43. Multiply two matrices (i.e.) multi dimensional arrays
	static void multiplyTwoMatrices() {
		objScanner = new Scanner(System.in);
		System.out.println("Enter the number of rows and columns for array 1");
		int row1=objScanner.nextInt();
		int col1=objScanner.nextInt();
		
		System.out.println("Enter the number of rows and columns for array 2");
		int row2=objScanner.nextInt();
		int col2=objScanner.nextInt();
		
		int[][] arr1=new int[row1][col1];
		int[][] arr2=new int[row2][col2];
		
		int minRow=row1<row2?row1:row2;
		int minCol=col1<col2?col1:col2;
		int[][] result= new int[minRow][minCol];
		
		System.out.println("Enter the elements for array 1");
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr1[i].length;j++) {
				arr1[i][j]=objScanner.nextInt();
			}
		}
		
		System.out.println("Enter the elements for array 2");
		for(int i=0;i<arr2.length;i++) {
			for(int j=0;j<arr2[i].length;j++) {
				arr2[i][j]=objScanner.nextInt();
			}
		}
		
		
		for(int i=0;i<result.length;i++) {
			for(int j=0;j<result[i].length;j++) {
				result[i][j]=arr1[i][j]*arr2[i][j];
			}
		}
		
		System.out.println("Elements of array 1 are");
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr1[i].length;j++) {
				System.out.print(arr1[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("Elements of array 2 are");
		for(int i=0;i<arr2.length;i++) {
			for(int j=0;j<arr2[i].length;j++) {
				System.out.print(arr2[i][j]+" ");
			}
			System.out.println();
		}
		
		
		System.out.println("Elements of result array are");
		for(int i=0;i<result.length;i++) {
			for(int j=0;j<result[i].length;j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	//44. Multiply two matrices as parameters (i.e.) multi dimensional array
	static void multiplyTwoMatrices(int[][] arr1, int[][] arr2) {
		int minRow=arr1.length<arr2.length?arr1.length:arr2.length;
		System.out.println(minRow);
		int minCol=Integer.MAX_VALUE;
		
		for(int i=0;i<arr1.length;i++) {
			if(arr1[i].length<minCol) {
				minCol=arr1[i].length;
			}
		}
		
		for(int i=0;i<arr2.length;i++) {
			if(arr2[i].length<minCol) {
				minCol=arr2[i].length;
			}
		}
		
		System.out.println(minCol);
		
		int[][] resultArr=new int[minRow][minCol];
		
		for(int i=0;i<resultArr.length;i++) {
			for(int j=0;j<resultArr[i].length;j++) {
				resultArr[i][j]=arr1[i][j]*arr2[i][j];
			}
		}
		
		System.out.println("Elements of array 1 are ");
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr1[i].length;j++) {
				System.out.print(arr1[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("Elements of array 2 are ");
		for(int i=0;i<arr2.length;i++) {
			for(int j=0;j<arr2[i].length;j++) {
				System.out.print(arr2[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("Product of the two matrices are ");
		for(int i=0;i<resultArr.length;i++) {
			for(int j=0;j<resultArr[i].length;j++) {
				System.out.print(resultArr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	// 45. Transpose a matrix
	static void transposeMatrix() {
		objScanner= new Scanner(System.in);
		System.out.println("Enter the desired rows and columns");
		int row1= objScanner.nextInt();
		int col1= objScanner.nextInt();
		
		int[][] arr1= new int[row1][col1];
		
		System.out.println("Enter elements for array 1");
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr1[i].length;j++) {
				arr1[i][j]=objScanner.nextInt();
			}
		}
		
		int[][] result= new int[col1][row1];
		
		System.out.println("Filling the elements of arr1 in result array after transpose");
		for(int i=0;i<result.length;i++) {
			for(int j=0;j<result[i].length;j++) {
				result[i][j]=arr1[j][i];
			}
		}
		
		System.out.println("Original array elements are ");
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr1[i].length;j++) {
				System.out.print(arr1[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("Array elements after transponse is ");
		for(int i=0;i<result.length;i++) {
			for(int j=0;j<result[i].length;j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
		
		objScanner.close();
		
	}
	
	
	//46. Find the frequency of the characters in a string
	static void findCharFrequency(String str) {
		Map<String,Integer> frequencyMap= new HashMap<String,Integer>();
		int count=1;
		
		for(int i=0;i<str.length();i++) {
			String temp=str.charAt(i)+"";
			if(frequencyMap.containsKey(temp)) {
				frequencyMap.put(temp,frequencyMap.get(temp)+1);
			}
			else {
				frequencyMap.put(temp,count);
			}
		}
		
		//find most frequent character in the string
		int largestFreq=frequencyMap.values().stream().mapToInt(i->i).max().getAsInt();
		for(String temp:frequencyMap.keySet()) {
			if(frequencyMap.get(temp)==largestFreq)
				System.out.print("Most frequent character is --> "+temp+" \nThe corresponding frequency is -->  "+frequencyMap.get(temp)+"\n");
		}
	}
	
	// 47. Count vowels and consonants in the string
	static void countVowelsConsonants(String str) {
		int vowelsCount=str.replaceAll("[^aeiouAEIOU]","").length();
		int consonantCount=str.replaceAll("[aeiouAEIOU]","").length();
		
		System.out.println("Vowels count is "+vowelsCount);
		System.out.println("Consonants count is "+consonantCount);
	}
	
	// 48. Sort string in lexicographical order
	static void sortStringArr(String[] arr) {
		String[] arr2=Arrays.copyOf(arr, arr.length);
		//approach 1 using for loop
		System.out.println("Array before sorting is "+ Arrays.toString(arr));
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i].compareTo(arr[j])>0) {
					String temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println("Array after sorting is "+ Arrays.toString(arr));
		
		//approach 2 using built in method
		System.out.println("Array before sorting is "+ Arrays.toString(arr2));
		Arrays.parallelSort(arr2);
		System.out.println("Array after sorting is "+ Arrays.toString(arr2));
	}
	
	//49. Calculates the sum of two complex numbers by passing class as the parameters
	ProgramsSet2 calculateComplexNumSum(ProgramsSet2 complexNum1, ProgramsSet2 complexNum2) {
		ProgramsSet2 temp= new ProgramsSet2(0,0);
		
		temp.realNum=complexNum1.realNum+complexNum2.realNum;
		temp.imgNum=complexNum1.imgNum+complexNum2.imgNum;
		
		return temp;
	}
	
	//50. Calculates the difference between two time periods
	static void timePeriodDifference(String date1, String date2) {
		String[] arr1=date1.split("[^0-9]");
		String[] arr2=date2.split("[^0-9]");
		
		int tempDay1=Integer.valueOf(arr1[0]);
		int tempDay2=Integer.valueOf(arr2[0]);
		
		int tempMon1=Integer.valueOf(arr1[1]);
		int tempMon2=Integer.valueOf(arr2[1]);
		
		int tempYear1=Integer.valueOf(arr1[2]);
		int tempYear2=Integer.valueOf(arr2[2]);
		
		int diffDay=Math.abs(tempDay1-tempDay2);
		int diffMon=Math.abs(tempMon1-tempMon2);
		int diffYear=Math.abs(tempYear1-tempYear2);
		
		System.out.println("Difference is "+diffYear+" Years "+diffMon+" Months "+diffDay+" Days ");
	}
	
	// 51. Creates a pyramid pattern
	static void pyradmidPattern(int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-i;j++) {
				System.out.print(" ");
			}
			for(int k=0;k<=i;k++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	// 52. Remove all white spaces from string
	static void removeSpaces(String str) {
		System.out.println("Original String is "+str);
		System.out.println("String after removing spaces is "+str.replaceAll("\\s",""));
	}
	
	// 53. Prints the given array
	static void printArray(int[] arr) {
		//approach 1 using Arrays.toString() method
		System.out.println(Arrays.toString(arr));
		
		//approach 2 using for loop
		for(int i=0;i<arr.length;i++) {
			if(i<arr.length-1)
				System.out.print(i+"...");
			else
				System.out.print(i);
		}
	}
	
	// 54. converts given string to date in dd/mm/yyyy format
	static void printDate(String str) {
		String year="", mon="", day="";
		if(str.length()==6)
		{
			year=str.substring(str.length()-4,str.length());
			mon=str.substring(str.length()-5,str.length()-4);
			day=str.substring(str.length()-6,str.length()-5);
		}

		else if(str.length()==7)
		{
			year=str.substring(str.length()-4,str.length());
			String temp=str.substring(0,str.length()-4);
			if(temp.startsWith("0"))
			{
				day=temp.substring(0,temp.length()-1);
				mon=temp.substring(temp.length()-1,temp.length());
			}
			else 
			{
				mon=temp.substring(temp.length()-2,temp.length());
				day=temp.charAt(0)+"";
			}
		}
		else if (str.length()==8){
			year=str.substring(str.length()-4,str.length());
			mon=str.substring(str.length()-6,str.length()-4);
			day=str.substring(str.length()-8,str.length()-6);
		}
		
		//prints the date
		if(Integer.valueOf(day)<=31 && Integer.valueOf(mon)<=12) {
			System.out.println("Date from the given string is "+ day+"/"+mon+"/"+year);
		}
		else {
			System.out.println("Invalid value for the month or day in the given string...");
		}
	}
	
	//55. Rounds the given number to n decimal places
	static void roundDecimal(int places,float num) {
		System.out.println("Number before rounding to given decimal places "+num);
		//approach 1 using printf formatter
		System.out.printf("Number after rounding to "+places+" decimal places is %."+places+"f\n",num);
		
		//approach 2 using string formatter
		String temp=String.format("%."+places+"f",num);
		System.out.println("Number after rounding to "+places+" decimal places is "+temp);
		
		//approach 3 using Formatter class
		StringBuilder sb= new StringBuilder();
		Formatter frmt= new Formatter(sb);
		frmt.format("%."+places+"f", num);
		frmt.close();
		System.out.println("Number after rounding to "+places+" decimal places is "+sb);
		
		//approach 4 using decimal format class
		String tempFrmt=".";
		for(int i=0;i<places;i++) {
			tempFrmt+="#";
		}
		DecimalFormat df= new DecimalFormat(tempFrmt);
		String revisedNum=df.format(num);
		System.out.println("Number after rounding to "+places+" decimal places is "+revisedNum);
	}
	
	// 56. Concatenate two arrays
	static void mergeArrays(int[] arr1, int[] arr2) {
		int[] result=new int[arr1.length+arr2.length];
		int j=0;
		
		for(int i=0;i<result.length;i++) {
			if(i<arr1.length) {
				result[i]=arr1[i];
			}
			else {
				result[i]=arr2[j++];
			}
		}
		
		System.out.println("Result Array after merging two arrays is "+Arrays.toString(result));
	}
	
	//57. Finds whether array contains the given value or not
	static boolean checkElement(int[] arr, int num) {
		//approach 1 using Arrays.toString method
		System.out.println(Arrays.toString(arr).contains(num+""));
		
		//approach 2 using for loop
		boolean result=false;
		for(int i: arr) {
			if(i==num) {
				result=true;
				break;
			}
		}
		return result;
	}
	
	//58. converts the given char to String and vice versa
	static void convertValue(char ch) {
		//char to string approach 1 adding empty string to char
		System.out.println("Charecter to string conversion "+ch+"");
		
		//char to string approach 2 using Character.toString method
		String temp=Character.toString(ch);
		System.out.println("Character to string conversion "+temp);
		
		//string to char approach 1
		if(temp.length()==1)System.out.println("String to character conversion "+temp.charAt(0));
		
		//approach 2 using lamba expression
		char tempCh1=(char)temp.chars().map(i->i).max().getAsInt();
		System.out.println("String to character conversion "+tempCh1);
		
		
	}
	
	//59. checks given string is null or empty
	static boolean stringCheck(String str) {
		if(str!=null)System.out.println("Is given string empty????"+str.isEmpty());
		return str==null;
	}
	
	//60. Gets current date and time
	static void printDateTime() {
		//approach 1 using JODA API from java 8
		System.out.println(LocalDateTime.now());
		
		//approach 2 using date class
		Date dt= new Date();
		int month=dt.getMonth()+1;
		System.out.println("Current date and time is "+dt.getDate()+"/"+month+"/"+dt.getYear()+":"+dt.getHours()+":"+dt.getMinutes()+":"+dt.getSeconds());
		
		//approach 3 using DateTime class
		Calendar cal= Calendar.getInstance();
		System.out.println("Current date and time is "+cal.get(Calendar.DAY_OF_MONTH)+"/"+cal.get(Calendar.MONTH)+"/"+cal.get(Calendar.YEAR)+":"
				+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND));
	}
	
	//61. Converts current  milliseconds to seconds and minutes
	static void getSecsMins() {
		long t1=System.currentTimeMillis();
		long secs=t1/1000;
		long mins=secs/60;
		System.out.println("Current Milliseconds is "+t1);
		System.out.println("Milliseconds to seconds value is "+secs);
		System.out.println("Milliseconds to minutes value is "+mins);
		
	}
	
	//62. Adds two dates provided in the params
	static void addDates(String date1, String date2) {
		String[] arr1=date2.split("[^0-9]");
		
		int addDay=Integer.valueOf(arr1[0]);
		int addMon=Integer.valueOf(arr1[1]);
		int addYear=Integer.valueOf(arr1[2]);
		
		SimpleDateFormat objSDF= new SimpleDateFormat("dd/MM/yyyy");
		Calendar c1= Calendar.getInstance();
		try {
			c1.setTime(objSDF.parse(date1));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println("Date1 before adding Date2 is "+objSDF.format(c1.getTime()));
		c1.add(Calendar.DAY_OF_MONTH, addDay);
		c1.add(Calendar.MONTH, addMon);
		c1.add(Calendar.YEAR, addYear);
		System.out.println("Date1 after adding Date2 is "+objSDF.format(c1.getTime()));
	}
}
