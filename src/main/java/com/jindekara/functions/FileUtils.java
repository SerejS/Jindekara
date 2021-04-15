package com.jindekara.functions;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.io.*;

public class FileUtils {
    public static void save(Long id, String description) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("desc_events/" + id + ".txt"))) {
            bw.write(description);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String load(Long id) {
        File file = new File("desc_events/" + id + ".txt");
        if (!file.exists()) return null;


        StringBuilder stringBuilder = new StringBuilder("");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while(br.ready()) {
                stringBuilder.append(br.readLine() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(load(1L));
    }
}
