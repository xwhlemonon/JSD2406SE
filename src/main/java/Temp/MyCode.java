package Temp;

import java.util.Arrays;

public class MyCode {
    public static void main(String[] args) {
        String str = "hello world! i love java!";
        System.out.println(str);
        char[] ch = pup(str);
//        for (char i : ch) {
//            System.out.print(i);
//        }
//        System.out.println();
        int[] number = numberOfLetters(ch);
        char[] charNumber = charOfLetters(ch);
        for (int i = 0; i < number.length; i++) {
            System.out.println(charNumber[i] + "出现" + number[i] + "次");
        }
    }

    public static char[] pup(String str) {
        char[] ch = str.toCharArray();
        char flag;
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (ch[i] == ch[j]) {
                    flag = ch[i + 1];
                    ch[i + 1] = ch[j];
                    ch[j] = flag;
                }
            }
        }
        return ch;
    }

    public static int[] numberOfLetters(char[] ch) {
        int[] letters = new int[0];
        char[] chLetters = new char[0];
        for (int i = 0, num = 1; i < ch.length - 1; i += num, num = 1) {
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[i] != ch[j]) {
                    break;
                }
                num++;
            }
            letters = addArr(letters, num);
        }
        return letters;
    }

    public static char[] charOfLetters(char[] ch) {
        int[] letters = new int[0];
        char[] chLetters = new char[0];
        for (int i = 0, num = 1; i < ch.length - 1; i += num, num = 1) {
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[i] != ch[j]) {
                    break;
                }
                num++;
            }
            chLetters = addArr(chLetters, ch[i]);
        }
        return chLetters;
    }

    public static int[] addArr(int[] letters, int num) {
        letters = Arrays.copyOf(letters, letters.length + 1);
        letters[letters.length - 1] = num;
        return letters;
    }

    public static char[] addArr(char[] letters, char ch) {
        letters = Arrays.copyOf(letters, letters.length + 1);
        letters[letters.length - 1] = ch;
        return letters;
    }
}
