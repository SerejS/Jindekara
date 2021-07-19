package com.jindekara.util;

import java.io.*;

public class FileUtils {
    private static final String home_dir = "src/main/resources/full_info/";

    //Сохранение большой текствой информации файле определенной директорим
    private static void save(Long id, String content, String folder) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(home_dir + folder + id + ".txt"))) {
            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Загрузка большой текстовой инофрмации из файла определенной директироии
    private static String load(Long id, String newLine, String folder) {
        File file = new File( home_dir + folder + id + ".txt");
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
        File file = new File(home_dir + folder + id + ".txt");
        return file.delete();
    }


    //Сохранение в файле описания события
    public static void saveDesc(Long id, String description) {
        save(id, description, "src/main/com.jindekara.desc_events/");
    }

    //Вывод события в формате для описания в html
    public static String loadDescHTML(Long id) {
        String prettyOutPut = load(id, "<br>", "src/main/com.jindekara.desc_events/");
        return prettyOutPut.equals("") ? "" : "<b>Описание события:</b><br>" + prettyOutPut;
    }

    //Вывод описания события для его изменения
    public static String loadDesc(Long id) {
        return load(id, "\n", "src/main/com.jindekara.desc_events/");
    }

    //Удаление файла описания события
    public static boolean deleteDesc(Long id) {
        return delete(id, "src/main/com.jindekara.desc_events/");
    }


    //Сохрание в файле биографии пресонажа
    public static void saveBio(Long id, String biography) {
        save(id, biography, "bio_personage/");
    }

    //Вывод биографии персонажа
    public static String loadBio(Long id) {
        String prettyOutPut = load(id, "<br>", "bio_personage/");
        return prettyOutPut.equals("") ? "" : "<b>Биография персонажа:</b><br>" + prettyOutPut;
    }

    //Удаление файла биографии персонажа
    public static boolean deleteBio(Long id) {return delete(id, "bio_personage/");}

    //Сохранение в файле слабостей расы
    public static void saveWeakness(Long id, String weakness) {save(id, weakness, "bestiary/weakness/");}

    //Вывод описания слабостей
    public static String loadWeakness(Long id) {
        return load(id, "\n", "bestiary/weakness/");
    }

    public static void saveNote(Long id, String note) {save(id, note, "bestiary/notes/");}

    public static String loadNote(Long id) {
        return load(id, "\n", "bestiary/notes/");
    }



}
