package com.jindekara.functions;

import java.io.*;

public class FileUtils {
    public static void save(Long id, String description) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("desc_events/" + id + ".txt"))) {
            bw.write(description);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Возвращает по id описание события из файла
    public static String loadDesc(Long id) {
        File file = new File("desc_events/" + id + ".txt");
        if (!file.exists()) return "";


        StringBuilder stringBuilder = new StringBuilder("");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while(br.ready()) {
                stringBuilder.append(br.readLine()).append("<br>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static String loadPrefEvent(Long id) {
        return loadDesc(id).equals("") ? "" : "<b>Описание события:</b><br>" + loadDesc(id);
    }
}
