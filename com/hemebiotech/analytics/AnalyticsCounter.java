package com.hemebiotech.analytics;

// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.FileWriter;

 import java.io.FileWriter;
// import java.io.IOException;
// import java.util.Iterator;
 import java.io.BufferedWriter;

//import java.util.Map;
//import java.util.List;
import java.util.*;
import java.util.stream.Collectors;


public class AnalyticsCounter {

	private static int headacheCount = 0;	
	private static int rashCount = 0;		
	private static int pupilCount = 0;

//    private static int countedSymptoms = 0;
//     private static int counter ;
private final ISymptomReader  reader ;
private final ISymptomWriter writer ;

	

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader ;
		this.writer = writer ;
     }

     public List<String> getSymptoms() {
		return reader.getSymptoms() ; 

     }


     public Map<String, Integer> countSymptoms(List<String> symptoms) {
         Map<String,Integer> countedSymptoms = new HashMap<>() ;
       
        for(String i : symptoms ){
            if(countedSymptoms.containsKey(i)){
                countedSymptoms.replace(i,countedSymptoms.get(i)+1) ;
            } else {
                countedSymptoms.put(i,1) ;
            }
            

        }
        return countedSymptoms ; 
      }


      public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
              return symptoms.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e2, LinkedHashMap::new));
       }

       public void writeSymptoms(Map<String, Integer> symptoms) {
	        writer.writeSymptoms(symptoms) ;
        }
	// public static void main(String args[]) throws Exception {
	// 	// first get input
	// 	BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
	// 	String line = reader.readLine();

	// 	int i = 0;
	// 	int headCount = 0;	// counts headaches
	// 	while (line != null) {
	// 		i++;
	// 		System.out.println("symptom from file: " + line);
	// 		if (line.equals("headache")) {
	// 			headCount++;
	// 			System.out.println("number of headaches: " + headCount);
	// 		}
	// 		else if (line.equals("rush")) {
	// 			rashCount++;
	// 		}
	// 		else if (line.contains("pupils")) {
	// 			pupilCount++;
	// 		}

	// 		line = reader.readLine();	// get another symptom
	// 	}
		
	// 	// next generate output
	// 	FileWriter writer = new FileWriter ("result.out");
	// 	writer.write("headache: " + headacheCount + "\n");
	// 	writer.write("rash: " + rashCount + "\n");
	// 	writer.write("dialated pupils: " + pupilCount + "\n");
	// 	writer.close();
	// }
}