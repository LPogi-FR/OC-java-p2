package com.hemebiotech.analytics;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class AnalyticsCounter {

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
}