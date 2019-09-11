/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Davor
 */
public class MindfulDictionary {

    private Map<String, String> dictionary;
    private String filePath;

    public MindfulDictionary() {
        this.dictionary = new HashMap<String, String>();
    }

    public MindfulDictionary(String file) {
        this.dictionary = new HashMap<String, String>();
        this.filePath = file;
    }

    public boolean load() {
        File text = new File(this.filePath);
        try {
            Scanner scan = new Scanner(text);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] parts = line.split(":");
                this.add(parts[0], parts[1]);
            }
        } catch (Exception e) {
        }
        return true;
    }

    public boolean save() {
        try {
            FileWriter writer = new FileWriter(this.filePath);
            for (String key : this.dictionary.keySet()) {
                writer.write(key + ":" + this.dictionary.get(key) + "\n");
            }
            writer.close();
        } catch (Exception e) {
            
        }
        return true;

    }

    public void add(String word, String translation) {
        if (!this.dictionary.keySet().contains(word)) {
            this.dictionary.put(word, translation);
        }
    }

    public String translate(String word) {
        for (String key : this.dictionary.keySet()) {
            if (key.equals(word)) {
                return this.dictionary.get(key);
            }
            if (this.dictionary.get(key).equals(word)) {
                return key;
            }
        }
        return null;
    }

    public void remove(String word) {
        for (String key : this.dictionary.keySet()) {
            if (key.equals(word)) {
                this.dictionary.remove(key);
                return;
            }
            if (this.dictionary.get(key).equals(word)) {
                this.dictionary.remove(key);
                return;
            }
        }
    }
}
