package com.example.myapplication.Instruments;

public class Check_Input {
    // метод для проверки уравнения на правильность ввода
    public static boolean Check_Equation_Number2(String input) {
        return true;
    }

    // подсчитываем количество различных переменных (строчных)
    public static int CountOfDifferentSymbols(String s)
    {
        String chars="";
        s = s.toLowerCase();
        for(byte i=0;i<s.length();i++)
        {
            String characterSet = "abcdefghijklmnopqrstuvwxyz";
            if(characterSet.contains(""+ s.charAt(i)))
            {
                if(!(chars.contains("" + s.charAt(i))))
                {
                    chars+=s.charAt(i);
                }
            }
        }
        return chars.length();
    }

}
