package com.qa.basicJavaExercises;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Programs 62- 82
 */
public class ProgramsSet3 {
	private int num;
	private String name;
	
	
	public ProgramsSet3(int number, String nme) {
		this.num=number;
		this.name=nme;
	}
	public int getNum() {
		return num;
	}

	public String getName() {
		return name;
	}	
	
	
	static enum Priority{
		LOW, MEDIUM, HIGH;
	}
	
	public static void main(String[] args) {
		convertOutputStreamToStr();
	}
	
	//63. Joins the given lists
	static void joinTwoLists() {
		List<Integer> list1= new ArrayList<Integer>(Arrays.asList(new Integer[]{1,23,4,5,6,9}));
		List<Integer> list2=new ArrayList<Integer>(Arrays.asList(new Integer[] {7,8,9,11,12}));
		//approach 1 using addAll method and insert at last index
		//list1.retainAll(list2);
		
		//approach 2 using for loop
		int max=list1.size()+list2.size(), index=0;
		for(int i=list1.size();i<max;i++) {
			list1.add(list2.get(index++));
		}
		System.out.println(list1);
	}
	
	
	//64. Converts the given array to arraylist and vice versa
	static void convertArrayToList() {
		int[] arr1= {1,2,3,5,6,7};
		//approach 1 using lambda expression
		List<Integer> revisedList1=Arrays.stream(arr1).boxed().collect(Collectors.toList());
		System.out.println("Array to Array list using lambda 8 "+revisedList1);
		
		//approach 2 using Arrays.asList method
		List<Integer> revisedList2=new ArrayList<Integer>(Arrays.asList(new Integer[] {1,2,3,5,6,7}));
		System.out.println("Array to Array list using Arrays.asList method "+revisedList2);
		
		//approach 3 using for loop
		List<Integer> revisedList3= new ArrayList<Integer>();
		for(int i:arr1) {
			revisedList3.add(i);
		}
		System.out.println("Array to Array List using for loop "+revisedList3);
		
		//ArrayList to arrays
		//approach 1 using lambda expression
		int[] revisedArr1= revisedList1.stream().mapToInt(i->i).toArray();
		System.out.println("Array list to Array using lambda expression "+Arrays.toString(revisedArr1));
		
		//approach 2 using for loop
		int[] revisedArr2=new int[revisedList3.size()];
		for(int i=0; i<revisedList3.size();i++) {
			revisedArr2[i]=revisedList3.get(i);
		}
		System.out.println("Array list to Array using for loop "+Arrays.toString(revisedArr2));
		
	}
	
	//65. gets current working directory
	static void getCurrentWorkingDirectory() {
		String currentWorkingDirectory=System.getProperty("user.dir");
		System.out.println("Current working directory is "+currentWorkingDirectory);
	}
	
	//66. converts the given hash map to list, keys as one list and values as another list
	static void hashMapToLists() {
		Map<String,Integer> tempMap= new HashMap<String,Integer>();
		char ch='A';
		tempMap.put((ch+""),(int)ch);
		tempMap.put((char)(ch+1)+"",(int)ch+1);
		tempMap.put((char)(ch+2)+"",(int)ch+2);
		tempMap.put((char)(ch+3)+"",(int)ch+3);
		tempMap.put((char)(ch+4)+"",(int)ch+4);
		//We can use for loop in both keys and values
		//approach 1 using add all method add all keys to a list
		List<String> keyList1=new ArrayList<String>();
		keyList1.addAll(tempMap.keySet());
		System.out.println("Keys list using addAll method is "+keyList1);
		
		//approach 2 using streams and collectors in java8
		List<String> keyList2=tempMap.keySet().stream().collect(Collectors.toList());
		System.out.println("Keys list using streams and collectors is "+keyList2);
		
		//approach 1 using addAll method 
		List<Integer> valuesList1=new ArrayList<Integer>();
		valuesList1.addAll(tempMap.values());
		System.out.println("Values list using addAll method is "+valuesList1);
		
		//approach 2 using streams and collectors in java
		List<Integer> valuesList2=tempMap.values().stream().collect(Collectors.toList());
		System.out.println("Values list using addAll method is "+valuesList2);
	}
	
	// 67. Converts an array to Hashset
	static void arrayToHashset() {
		int[] arr1= {0,5,1,3,9,6,1,9};
		Integer[] arr2={0,5,1,3,9,6,1,9};
		//approach 1 using Integer[] and arrays as list method
		Set<Integer> numSet1= new HashSet<Integer>(Arrays.asList(arr2));
		System.out.println("Arrays to set using Arrays.asList method "+numSet1);
		
		//approach 2 using streams and collectors
		Set<Integer> numSet2= Arrays.stream(arr1).boxed().collect(Collectors.toSet());
		System.out.println("Arrays to set using streams and collectors "+numSet2);
		
		//approach 3 using for loop
		Set<Integer> numSet3= new HashSet<Integer>();
		for(int i:arr1) {
			numSet3.add(i);
		}
		System.out.println("Arrays to set using for loop "+numSet3);
		
		//Set to arrays, approach 1 using streams and map in java 8
		int[] arr3= numSet1.stream().mapToInt(i->i).toArray();
		System.out.println("Set to array using streams and map in java 8"+Arrays.toString(arr3));
		
		//Set to arrays, approach 2 using for loop
		int[] arr4= new int[numSet2.size()];
		int counter=0;
		for(int i:numSet2) {
			arr4[counter++]=i;
		}
		System.out.println("Set to array using for loop"+Arrays.toString(arr4));
	}
	
	//68. Converts a byte array to hexadecimal string
	static void byteArrToHex() {
		byte[] byteArr= {9,10,61,11,12,13,14,15,16,17,18,19,20};
		StringBuilder hexString= new StringBuilder();
		
		for(int i=0;i<byteArr.length;i++){
			int temp=(int) byteArr[i]&0XFF;
			String hexTemp=Integer.toHexString(temp);
			if(hexTemp.length()%2==1) {
				hexTemp="0"+hexTemp;
			}
			hexString.append(hexTemp);
			if(i<byteArr.length-1) {
				hexString.append(",");
			}
			
		}
		
		System.out.println(hexString.toString());
	}
	
	//69. Appends text to existing file
	static void appendTextToFile() {
		File testFile= new File("D:\\EclipseProjects\\JavaGitUpload\\Resources\\TextFile.txt");
		FileWriter writer;
		
		try {
			System.out.println("Text in the file before appending text is ");
			readFileData("D:\\EclipseProjects\\JavaGitUpload\\Resources\\TextFile.txt");
			writer= new FileWriter(testFile, true);
			writer.append("\rAppended the text to file");
			writer.write("\r"+LocalDateTime.now().toString());
			writer.close();
			System.out.println("Text in the file after appending text is ");
			readFileData("D:\\EclipseProjects\\JavaGitUpload\\Resources\\TextFile.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//reads the text in give file
	static void readFileData(String path) {
		//File readFile= new File(path);
		FileReader fReader;
		BufferedReader bReader;
		String data;
		
		try {
			fReader= new FileReader(path);
			bReader= new BufferedReader(fReader);
			System.out.println("***********************************");
			while((data=bReader.readLine())!=null) {
				System.out.println(data);
			}
			System.out.println("***********************************");
			fReader.close();
			bReader.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//70. Converts stack trace on exception to string
	static void getStackTrace() {
		try {
			System.out.println((4/0));
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
	}
	
	//71. Converts the file content to byte array 
	static void getFileContent() {
		String path="D:\\EclipseProjects\\JavaGitUpload\\Resources\\TextFile.txt";
		String copyPath="D:\\EclipseProjects\\JavaGitUpload\\Resources\\CopyFile.txt";
		byte[] byteArr1;
		try {
			byteArr1 = Files.readAllBytes(Paths.get(path));
			for(byte i: byteArr1) {
				System.out.println(i);
			}
			Files.write(Paths.get(copyPath), byteArr1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//72. Converts inputstream to string
	static void convertInputStreamToString() {
		File tempFile1= new File("D:\\EclipseProjects\\JavaGitUpload\\Resources\\TextFile.txt");
		StringBuilder sb= new StringBuilder();
		int temp=0;
		
		InputStream is;
		try {
			is= new FileInputStream(tempFile1);
			while((temp=is.read())!=-1) {
				sb.append((char)temp);
			}
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(sb.toString());
	}
	
	//73. Converts outputstream to string
	static void convertOutputStreamToStr() {
		File actFile=new File("D://EclipseProjects//JavaGitUpload//Resources//CopyFile.txt");
		ByteArrayOutputStream baos=null;
		
		try {
			baos= new ByteArrayOutputStream();
			byte[] tempByte=Files.readAllBytes(Paths.get(actFile.getAbsolutePath()));
			baos.write(tempByte);
			System.out.println(baos.toString());
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				baos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	//74. Looks up enum by string
	static void lookUpEnum() {
		String text="LOW";
		System.out.println(Priority.valueOf(text));
		
		for(Priority temp: Priority.values()) {
			System.out.println(temp.name());
		}
	}
	
	//75. compares given two strings
	static boolean compareString(String str1, String str2) {
		if(str1.compareTo(str2)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//76. Sorts the given map by the values in the map
	static void sortMapByValues() {
		Map<String,Integer> tempMap1= new LinkedHashMap<String,Integer>();
			
		tempMap1.put("Z",5);
		tempMap1.put("Y",4);
		tempMap1.put("X",3);
		tempMap1.put("V",1);
		tempMap1.put("U",2);
		tempMap1.put("F",2);
		
		List<String> tempList=new ArrayList<String>();
		
		for(String temp: tempMap1.keySet()) {
			tempList.add(tempMap1.get(temp)+temp);
		}
		Collections.sort(tempList);
		System.out.println("Map before sorted by values "+tempList);
		
		tempMap1.clear();
		for(String temp1: tempList) {
			int iTemp=Integer.parseInt(temp1.replaceAll("[a-zA-Z]", ""));
			String sTemp=temp1.replaceAll("[0-9]", "");
			tempMap1.put(sTemp,iTemp);
		}
		
		System.out.println("Map after sorted by values "+tempMap1);
	}
	
	//77. Sorts the given arraylist by custom object property
	static void sortListByCustomObjects() {
		ArrayList<ProgramsSet3> customList= new ArrayList<ProgramsSet3>();
		
		customList.add(new ProgramsSet3(1,"A"));
		customList.add(new ProgramsSet3(4,"D"));
		customList.add(new ProgramsSet3(2,"B"));
		customList.add(new ProgramsSet3(3,"C"));
		customList.add(new ProgramsSet3(3,"F"));
		
		customList.sort((o1,o2)->{
			if(o1.getNum()<o2.getNum()) {
				return -1;
			}
			else if(o1.getNum()>o2.getNum()) {
				return 1;
			}
			else {
				return -1;
			}
		});
		
		for(ProgramsSet3 obj1: customList) {
			System.out.println(obj1.getNum()+"---"+obj1.getName());
		}
		
	}
	
	//78.Checks the given string is numeric
	static boolean checkNumeric(String str) {
		if(str.replaceAll("[0-9]","").length()==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//79. creates directory in the specified path
	static void createDirectory() {
		File folder1=new File("D://EclipseProjects//JavaGitUpload//Resources//");
		File folder2=new File(folder1,"Test"+System.currentTimeMillis());
		File textFile=new File(folder2,"TextFile.txt");
		boolean result=folder2.mkdir();
		System.out.println("New folder in specified location???"+result);
		boolean newFileCreated;
		try {
			Thread.sleep(5000);
			newFileCreated = textFile.createNewFile();
			System.out.println("New file created in new folder????"+newFileCreated);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	//80. Rename a file in the sepcified path
	static void renameFile() {
		File folder1=new File("D://EclipseProjects//JavaGitUpload//Resources//");
		File fileFolder= new File(folder1,"RenameTest"+System.currentTimeMillis());
		
		
		boolean folderCreated=fileFolder.mkdir();
		boolean fileCreated=false;
		if(folderCreated) {
			try {
				Thread.sleep(1500);
				for(int i=0;i<10;i++) {
					File createFile=new File(fileFolder,"TextFile"+System.currentTimeMillis()+".txt");
					Thread.sleep(1000);
					fileCreated=createFile.createNewFile();
				}
				if(fileCreated) {
					File[] fileArr=fileFolder.listFiles();
					System.out.println("File names before rename is ");
					for(File temp1: fileArr) {
						System.out.println(temp1.getName());
					}
					
					//rename all files
					for(File temp2: fileArr) {
						Thread.sleep(1000);
						temp2.renameTo(new File(fileFolder+"\\"+System.currentTimeMillis()+"TextFile.txt"));
					}
					
					System.out.println("File names after rename is ");
					File[] fileArr1=fileFolder.listFiles();
					for(File temp3: fileArr1) {
						System.out.println(temp3.getName());
					}
				}					
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//81. prints all file names in the directory
	static void getFileNames() {
		File dirPath=new File("D://EclipseProjects//JavaGitUpload//Resources//");
		String[] fileArr=dirPath.list();
		System.out.println("All files are listed as below: ");
		for(String temp: fileArr) {
			System.out.println(temp);
		}
	}
	
	//82. Copies the file in the given path
	static void copyFile() {
		File dirPath=new File("D://EclipseProjects//JavaGitUpload//Resources//CopyFile.txt");
		File newFile= new File("D://EclipseProjects//JavaGitUpload//Resources//","TestCopyFile"+System.currentTimeMillis()+".txt");
		Path fromPath=Paths.get(dirPath.getAbsolutePath());
		Path toPath=Paths.get(newFile.getAbsolutePath());
		//approach 1 using copy method
		try {
			
			newFile.createNewFile();
			Thread.sleep(2000);
			System.out.println("Is new file created "+newFile.exists());
			Files.copy(fromPath,toPath,StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//approach 2 using write method
		try {
			byte[] tempByte=Files.readAllBytes(fromPath);
			File newFile1= new File("D://EclipseProjects//JavaGitUpload//Resources//","TestCopyFile"+System.currentTimeMillis()+".txt");
			newFile1.createNewFile();
			Thread.sleep(2000);
			System.out.println("Is new file created "+newFile1.exists());
			Files.write(Paths.get(newFile1.getAbsolutePath()), tempByte);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}
}
