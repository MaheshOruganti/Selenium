package Comcast;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Basket_Fruits_Calculation {

	
		// this is main program
public static void main(String[] args) throws Exception {
		
	String FILE_PATH= args[0];
	
	FileInputStream fis = null;
	fis = new FileInputStream(FILE_PATH);
	Workbook workbook = new XSSFWorkbook(fis);
	Sheet sheet = workbook.getSheetAt(0);
	int rows= workbook.getSheetAt(0).getLastRowNum();
	int total_rows = rows+1;
	
	//First task
	System.out.print("Total number of fruits: "+total_rows);
	System.out.println("\n");
			
	Iterator<Row> rowIterator = sheet.iterator();
	Basket[] fruitArray = new Basket[total_rows]; 
					
	for(int i=0;i<total_rows;i++)
	{ 
		 Row row = (Row) rowIterator.next();
		 fruitArray[i]=new Basket();     	         	    
	     fruitArray[i].fruit_name= row.getCell(0).toString();
	     fruitArray[i].fruit_day = (int) row.getCell(1).getNumericCellValue();
	     fruitArray[i].fruit_chacterType1= row.getCell(2).toString();
	     fruitArray[i].fruit_chacterType2=row.getCell(3).toString();
    	        		
	}
	
	//Second task
	List<String>fruit_list = new ArrayList<String>();
	for (int j=0;j<fruitArray.length;j++){
		
		fruit_list.add(fruitArray[j].fruit_name);
	}
	HashSet<String> uniqueset = new HashSet<String>(fruit_list);
	System.out.print("Types of fruits: "+uniqueset.size()+" ");
	System.out.print(uniqueset);
	System.out.println("\n");
	
	// Third task
	ArrayList<String> fruit_names = new ArrayList<String>();
	ArrayList<Integer> fruits_count = new ArrayList<Integer>();
    for (int k=0;k<fruitArray.length;k++){
		
    	String nextword = fruitArray[k].fruit_name;
    	if(fruit_names.contains(nextword)){
    		
    		int index =  fruit_names.indexOf(nextword);
    		fruits_count.set(index, fruits_count.get(index) +1);
    	}
    	else{
    		fruit_names.add(nextword);
    		fruits_count.add(1);
    	  	}
	}
    System.out.print("The number of each type of fruit in order:");
    System.out.println("\n");
	for(int l=0;l<fruit_names.size();l++){
		System.out.println(fruit_names.get(l)+":"+fruits_count.get(l));
	}
    
	//4th task
	
	ArrayList<String> fruit_types = new ArrayList<String>();
	ArrayList<Integer> fruits_type_count = new ArrayList<Integer>();
	ArrayList<String> fruit_characterstics = new ArrayList<String>();
	ArrayList<Integer> fruit_characterstics_count = new ArrayList<Integer>();
	ArrayList<String> fruit_characterstics1 = new ArrayList<String>();
	ArrayList<Integer> fruit_characterstics1_count = new ArrayList<Integer>();
	
    for (int f=0;f<fruitArray.length;f++){
		
    	String nextword = fruitArray[f].fruit_name;
    	String character1=  fruitArray[f].fruit_chacterType1;
    	String character2 = fruitArray[f].fruit_chacterType2;
    	
    	if(fruit_types.contains(nextword)){
    		int index =  fruit_types.indexOf(nextword);
    		fruits_type_count.set(index, fruits_type_count.get(index) +1);
    	}else{
    		fruit_types.add(nextword);
    		fruits_type_count.add(1);
    	  	}
    	
    	if(fruit_characterstics.contains(character1)){
    	   int cindex =  fruit_characterstics.indexOf(character1);
    	   fruit_characterstics_count.set(cindex, fruit_characterstics_count.get(cindex) +1);
         }else{
    	   fruit_characterstics.add(character1);
    	   fruit_characterstics_count.add(1);
       }
      if(fruit_characterstics1.contains(character2)){
     	   int lindex =  fruit_characterstics1.indexOf(character2);
     	   fruit_characterstics1_count.set(lindex, fruit_characterstics1_count.get(lindex) +1);
          }else{
        	  fruit_characterstics1.add(character2);
        	  fruit_characterstics1_count.add(1);
        }
    	  	
	}
    System.out.print("The characteristics (size, color, shape, etc.) of each fruit by type:");
    System.out.println("\n");
	for(int l=0;l<fruit_names.size();l++){
		System.out.println(fruits_type_count.get(l)+" "+fruit_types.get(l)+ ":"+fruit_characterstics.get(l)+":"+fruit_characterstics1.get(l));
	}
		
	// 5th task
	
	ArrayList<String> fruit_name = new ArrayList<String>();
	ArrayList<Integer> fruit_count = new ArrayList<Integer>();
	ArrayList<Integer> fruit_day_count = new ArrayList<Integer>();
   	for (int d=0;d<fruitArray.length;d++){
	   	String nextfruit = fruitArray[d].fruit_name;
    	int day = fruitArray[d].fruit_day;
    	if(fruit_name.contains(nextfruit)){
    	if(day >= 3){
    			int index =  fruit_name.indexOf(nextfruit);
    			fruit_count.set(index, fruit_count.get(index) +1);
    			}
    	}else if(day >= 3){
    		fruit_name.add(nextfruit);
			fruit_count.add(1);
    	}
	}
	System.out.print("Have any fruit been in the basket for over 3 days:");
    System.out.println("\n");
	for(int l=0;l<fruit_name.size();l++){
		System.out.println(fruit_count.get(l)+" "+fruit_name.get(l)+" are over 3 days old");
	}
}

}	


 




