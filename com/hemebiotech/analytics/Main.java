package com.hemebiotech.analytics;

public class Main {

  /**
  * Entry file of the application.
  . Instantiate the interface and use their methods to product the Output File.
  * @param args String[]
  */
  public static void main(String[] args) {
    final ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
    final ISymptomWriter writer = new WriteSymptomDataToFile();
    final AnalyticsCounter counter = new AnalyticsCounter(reader,writer);
    writer.writeSymptoms(counter.sortSymptoms(counter.countSymptoms(counter.getSymptoms())));
  }
}