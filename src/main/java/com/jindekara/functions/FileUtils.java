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


    //Сохранение в файле описания события
    public static void saveDesc(Long id, String description) {
        save(id, description, "desc_events/");
    }

    //Вывод события в формате для описания в html
    public static String loadDesc(Long id) {
        String prettyOutPut = load(id, "<br>", "desc_events/");
        return prettyOutPut.equals("") ? "" : "<b>Описание события:</b><br>" + prettyOutPut;
    }

    //Удаление файла описания события
    public static boolean deleteDesc(Long id) {
        return delete(id, "desc_events/");
    }


    //Сохрание в файле биографии пресонажа
    public static void saveBio(Long id, String biography) {
        save(id, biography, "bio_personage");
    }

    //Вывод биографии персонажа
    public static String loadBio(Long id) {
        String prettyOutPut = load(id, "<br>", "bio_personage/");
        return prettyOutPut.equals("") ? "" : "<b>Биография персонажа:</b><br>" + prettyOutPut;
    }

    //Удаление файла биографии персонажа
    public static boolean deleteBio(Long id) {return delete(id, "bio_personage/");}

}
