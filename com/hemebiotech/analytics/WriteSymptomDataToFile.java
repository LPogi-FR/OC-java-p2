package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;


/**.
* Anything that will read symptom data from a source;
* The important part is, the return value from the operation, which is a list of strings,
* that may contain many duplications.
* The implementation does not need to order the list.
*/
public class WriteSymptomDataToFile implements ISymptomWriter {
  /** 
   Attribute with the name of the output File.
  */
  private final String fileOutput = "result.out";

  @Override
  public void writeSymptoms(Map<String, Integer> symptoms) {
    if (symptoms.isEmpty() != true) {
      try {
        FileWriter writer = new FileWriter(fileOutput);
        for (Map.Entry mapentry:symptoms.entrySet()) {
          writer.write(mapentry.getKey() + " : " + mapentry.getValue() + "\n");
        }
        writer.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
