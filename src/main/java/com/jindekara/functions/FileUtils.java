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
    public static String loadDesc(Long id, String newLine) {
        File file = new File("desc_events/" + id + ".txt");
        if (!file.exists()) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder("");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while(br.ready()) {
                stringBuilder.append(br.readLine()).append(newLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    //Вывод события в формате для описания в html
    public static String loadPrefEvent(Long id) {
        String prettyOutPut = loadDesc(id, "<br>");
        return prettyOutPut.equals("") ? "" : "<b>Описание события:</b><br>" + prettyOutPut;
    }

    public static boolean deleteDesc(Long id) {
        File file = new File("desc_events/" + id + ".txt");
        return file.delete();
    }
}
