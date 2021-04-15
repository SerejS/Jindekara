package com.jindekara.functions;

//Работа с календарем Джиндекары
public class JindekaraCalender {
    //Перевод номера дня в формат день-месяц Джиндекары
    public static String numberDayToDate(short day) {
        if (day>390) return "30.13";
        else if (day < 1) return "01.01";

        String date = "";
        if (day % 30 == 0) date += "30.";
        else {
            if (day % 30 > 9) date += day % 30 + ".";
            else date += "0" + day % 30 + ".";
        }
        if (day/30 > 8) {
            date += (day / 30 + 1);
        }
        else date += "0" + (day / 30 + 1);
        return date;
    }
}
