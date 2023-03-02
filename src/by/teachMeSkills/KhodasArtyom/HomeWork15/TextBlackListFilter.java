package by.teachMeSkills.KhodasArtyom.HomeWork15;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextBlackListFilter {
    private Pattern[] arrayOfBadWords;

    public TextBlackListFilter(String[] array) {
        arrayOfBadWords = new Pattern[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayOfBadWords[i] = Pattern.compile("\\b" + Pattern.quote(array[i]) + "\\b",
                      Pattern.UNICODE_CHARACTER_CLASS|Pattern.CASE_INSENSITIVE|Pattern.UNICODE_CASE
            );
        }
    }

    public boolean isObsceneLanguage(String userComment) {
        for (int i = 0; i < arrayOfBadWords.length; i++) {
            Matcher matcher = arrayOfBadWords[i].matcher(userComment);
            if (matcher.find()) {
                return true;
            }

        }
        return false;
    }

    public int countBadWords(String userComment) {
        int counter = 0;
        for (int i = 0; i < arrayOfBadWords.length; i++) {
            Matcher matcher = arrayOfBadWords[i].matcher(userComment);
            while (matcher.find()) {
                counter++;
            }
        }
        return counter;
    }

    public String getModifiedText(String userComment) {
        String newText= userComment;
        for (int i = 0; i < arrayOfBadWords.length; i++) {
            Matcher matcher = arrayOfBadWords[i].matcher(newText);
            newText =matcher.replaceAll("####");
        }
        return newText;
    }
}