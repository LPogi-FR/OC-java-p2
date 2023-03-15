package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
        if(symptoms.isEmpty() != true){
		    try{
           FileWriter writer = new FileWriter ("result.out"); 
            for (Map.Entry mapentry : symptoms.entrySet()) { //2nd soucis: mapentry ?
                writer.write(mapentry.getKey() + " : " + mapentry.getValue()+"\n");
                //writer.newLine(); 
                /*pour le coup -> Codio est pas vraiment en cause, mais plus le comportement
                //en général de java sous windows notamment, bien qu'ici ce soit un peu bizarre.
                //En gros, newline insère ici un retour à la ligne, ce qui est bien, parce que c'est demandé
                //par contre, il y a deux façons de faire un retour à la ligne en dev : 
                - \n -> retour à la ligne Simple
                - \r\n -> retour à la ligne avec un carriage return. 
                -> en l'occurence, ici le newline insère un carriage return, donc ce n'est malheureusement pas
                la bonne solution ici. Tu Devras absolument passer avec le \n
                */
            }
            writer.close();

            } catch (IOException e) {
	            e.printStackTrace();
		    }
        }
	}
}
