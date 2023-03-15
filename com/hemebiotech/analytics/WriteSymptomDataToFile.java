package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private final String fileOutput = "result.out" ;

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
        if(symptoms.isEmpty() != true){
		    try{
                FileWriter writer = new FileWriter (fileOutput); 
                for (Map.Entry mapentry : symptoms.entrySet()) {
                    writer.write(mapentry.getKey() + " : " + mapentry.getValue()+"\n");
                }
                writer.close();

            } catch (IOException e) {
	            e.printStackTrace();
		    }
        }
	}
}
