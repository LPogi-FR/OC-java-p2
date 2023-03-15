package com.hemebiotech.analytics;

public class Main{


    public static void main(String[] args) {

        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile();
        AnalyticsCounter counter = new AnalyticsCounter(reader,writer);
        writer.writeSymptoms(counter.sortSymptoms( counter.countSymptoms(counter.getSymptoms())));

    }


}