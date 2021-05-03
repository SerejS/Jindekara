package com.jindekara.functions;

import java.io.*;

public class FileUtils {
    //Сохранение большой текствой информации файле определенной директорим
    private static void save(Long id, String content, String folder) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(folder + id + ".txt"))) {
            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Загрузка большой текстовой инофрмации из файла определенной директироии
    private static String load(Long id, String newLine, String folder) {
        File file = new File( folder+ id + ".txt");
        if (!file.exists()) return "";

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

    //Удаление файла с контентом
    private static boolean delete(Long id, String folder) {
        File file = new File(folder + id + ".txt");
        return file.delete();
    }


    //Сохранение в файле
    public static void saveDesc(Long id, String description) {
        save(id, description, "desc_events/");
    }

    //Вывод события в формате для описания в html
    public static String loadDesc(Long id) {
        String prettyOutPut = load(id, "<br>", "desc_events/");
        return prettyOutPut.equals("") ? "" : "<b>Описание события:</b><br>" + prettyOutPut;
    }

    public static boolean deleteDesc(Long id) {
        return delete(id, "desc_events/");
    }

}
