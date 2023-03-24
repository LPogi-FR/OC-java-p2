package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

  private final ISymptomReader reader;
  private final ISymptomWriter writer;

  /**
  * default constructor for AnalyticsCounter.
  * @param reader ISymptomReader 
  * @param writer ISymptomWriter
  */
  public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
    this.reader = reader;
    this.writer = writer;
  }

  /**
  * Implement the interface to recoup the symptom from a file.
  * @return List of String 
  */
  public List<String> getSymptoms() {
    return reader.getSymptoms();
  }

  /**
  * This method will count the number of occurrences a symptom is in the list of symptoms.
  * @param symptoms is the list of symptoms.
  * @return a {@link Map} with the number of occurrences for each symptom.
  */
  public Map<String, Integer> countSymptoms(List<String> symptoms) {
    Map<String, Integer> countedSymptoms = new HashMap<>();
    for (String i : symptoms) {
      if (countedSymptoms.containsKey(i)) {
        countedSymptoms.replace(i, countedSymptoms.get(i) + 1);
      } else {
        countedSymptoms.put(i, 1);
      }
    }
    return countedSymptoms;
  }

  /**
  * Method that @return the same map sorted by Key. 
  * @param symptoms a {@link Map} with the number of occurrences for each symptom.
  */
  public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
    return new TreeMap<>(symptoms);
  }

  public void writeSymptoms(Map<String, Integer> symptoms) {
    writer.writeSymptoms(symptoms);
  }
}