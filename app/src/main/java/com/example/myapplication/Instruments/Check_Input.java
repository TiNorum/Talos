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
    public static String CheckString(String str,int typeTask)
    {
        String answer = "";
        String invalidCharacter = "";
        String characterSet = "";
        if(typeTask == 8)
            characterSet= "abcdefghijklmnopqrstuvwxyz1234567890'\"()=<>-:/*+ \n\r";
        else
            characterSet= "абвгдеёжзийклмнопрстуфхцчшщъьыэюя1234567890'\"()=<>-:/*+ \n\r";

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
    public static String RepleceComparisonSignTask8(String str)
    {
        char[] masStr = str.toCharArray();
        String tmp = "";
        for (int i = 0; i < masStr.length; i++) {
            if(masStr[i] == '<')
            {
                tmp = "";
                for (int j = 0; j < i; j++) {
                    tmp += masStr[j];
                }
                tmp += "<span>&#60;</span>";

                for (int j = i + 1; j < masStr.length; j++) {
                    tmp += masStr[j];
                }
                masStr = tmp.toCharArray();
                i+=18;
            }
            else if(masStr[i] == '>')
            {
                tmp = "";
                for (int j = 0; j < i; j++) {
                    tmp += masStr[j];
                }
                tmp += "<span>&#62;</span>";

                for (int j = i + 1; j < masStr.length; j++) {
                    tmp += masStr[j];
                }
                masStr = tmp.toCharArray();
                i+=18;
            }
        }
        if(tmp.isEmpty())
            tmp = str;
        return  tmp;
    }
    public static String ColorEditTask8(String str)
    {
        str = RepleceComparisonSignTask8(str);
        str = str.replace("\n","<br>");
        str = str.replace(" ","<span> </span>");
        str = str.replace("elif","<font color='#0088FE'>elif</font>");
        str = str.replace("while","<font color='#FFA600'>while</font>");
        str = str.replace("if","<font color='#0088FE'>if</font>");
        str = str.replace("else","<font color='#0088FE'>else</font>");
        str = str.replace("int(input","<font color='#71FF00'>int(input</font>");
        str = str.replace("print","<font color='#71FF00'>print</font>");
        return str;
    }

    //проверка ip адреса
    public static boolean Cheсk_IP(String str) {
        int countDot = 0, prevIndeDot = -1, countNum = 0;
        String num = "";

        for (int i = 0; i < str.length(); i++) {
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
                if (countNum > 3) return true;
            }

        }

        if(countDot != 3) return true;
        return false;
    }


}
