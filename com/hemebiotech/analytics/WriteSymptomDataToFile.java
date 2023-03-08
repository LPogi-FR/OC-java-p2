package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {


	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
        if(symptoms.isEmpty() != true){
		    try{
            FileWriter writer = new FileWriter ("result.out");
            //Ton problème est ici
            for (Map.Entry mapentry : symptoms.entrySet()) {
                // writer.write("symptom: "+mapentry.getKey()
                // + " | number: " + mapentry.getValue() + "\n") ;
                System.out.println(mapentry.getKey());
                //writer.write(String.valueOf(mapentry.getKey())+ "\n");
            }
            writer.close();

            } catch (IOException e) {
	            e.printStackTrace();
		    }
        }
	}
}
