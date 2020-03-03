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
        for (int i = 0; i < input.length(); i++)
        {
            if (i != 0 && input.charAt(i) == double_char)
                return false;
            else if (i != 0 && input.charAt(i) != double_char)
                double_char_count = 0;
            if (input.charAt(i) == '(')
            {
                bkt_o++;
            }
            else if (input.charAt(i) == ')')
            {
                bkt_c++;
                if (bkt_c > bkt_o)
                    return false;
            }
            else if (!check_chars.contains("" + input.charAt(i)))
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

}
