package com.example.myapplication.Instruments;

public class Check_Input {
    // проверка уравнения на правильность ввода
    public static boolean Check_Equation_Number2(String input) {
        int bkt_o = 0; // количество открывающихся скобок
        int bkt_c = 0; // количество закрывающихся скобоки
        int double_char_count = 0; // количество символов подряд
        char double_char = '=';   // символ идущий подряд
        // a-z, ),(, ^,' ', =, +, *, !, >
        String check_chars = "abcdefghijklmnopqrstuvwxyz+*^()=!>";

        input = input.trim();
        input = input.toLowerCase();
        for (int i = 0; i < input.length(); i++) {
            if (i != 0 && input.charAt(i) == double_char)
                return false;
            else if (i != 0 && input.charAt(i) != double_char)
                double_char_count = 0;
            if (input.charAt(i) == '(') {
                bkt_o++;
            } else if (input.charAt(i) == ')') {
                bkt_c++;
                if (bkt_c > bkt_o)
                    return false;
            } else if (!check_chars.contains("" + input.charAt(i)))
                return false;
            double_char = input.charAt(i);
            double_char_count++;
            if (double_char_count >= 2)
                return false;
        }

        if (bkt_o != bkt_c)
            return false;
        return true;
    }

    // подсчитываем количество различных переменных (строчных)
    public static int CountOfDifferentSymbols(String s) {
        String chars = "";
        s = s.toLowerCase();

        for (byte i = 0; i < s.length(); i++) {
            String characterSet = "abcdefghijklmnopqrstuvwxyz";
            if (characterSet.contains("" + s.charAt(i))) {
                if (!(chars.contains("" + s.charAt(i)))) {
                    chars += s.charAt(i);
                }
            }
        }
        return chars.length();
    }

    public static String CheckString(String str) {
        String answer = "";
        String invalidCharacter = "";
        String characterSet = "abcdefghijklmnopqrstuvwxyz1234567890'\"()=<>-:/*+ \n\r";
        str = str.toLowerCase();

        char[] masStr = str.toCharArray();
        int index;
        for (int i = 0; i < masStr.length; i++) {
            index = characterSet.indexOf(masStr[i]);
            if (index == -1)
                invalidCharacter += masStr[i];
        }
        char[] masInv = invalidCharacter.toCharArray();
        if (masInv.length != 0) {
            answer += "Неверные символы (";
            for (int i = 0; i < masInv.length; i++) {
                answer += masInv[i];
                if (i != masInv.length - 1)
                    answer += ", ";
            }
            answer += ")!!!";
        }
        return answer;
    }

    //проверка ip адреса
    public static boolean Cheсk_IP(String str) {
        int countDot = 0, prevIndeDot = -1, countNum = 0;
        String num = "";

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == '.') {
                countDot++;

                if (prevIndeDot + 1 == i || i == str.length() || countDot > 3 || Integer.parseInt(num) > 255)
                    return true;

                num = "";
                prevIndeDot = i;
                countNum = 0;
            } else {
                countNum++;
                num += str.charAt(i);
                if (countNum > 3) return false;
            }

        }
        return false;
    }


}
