package com.hemebiotech.analytics;

import java.util.Map;

/**.
 * Anything that will write symptom data on a valid data output format
 *
 */
public interface ISymptomWriter {
  /**
  * Take a map's data and transpose it on text format on a new file.
  * @param symptoms a {@link Map} with the number of occurrences for each symptom.
  */
  public void writeSymptoms(Map<String, Integer> symptoms);
}
