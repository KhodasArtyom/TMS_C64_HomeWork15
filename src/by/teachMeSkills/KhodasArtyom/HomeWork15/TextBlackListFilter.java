package by.teachMeSkills.KhodasArtyom.HomeWork15;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextBlackListFilter {
    private String[] array;

    public TextBlackListFilter(String[] array) {
        this.array = array;
    }

    public boolean isObsceneLanguage(String userComment) {
        for (int i = 0; i <array.length; i++) {
            Pattern pattern = Pattern.compile("\\b" + Pattern.quote(array[i]) + "\\b",
                    Pattern.UNICODE_CHARACTER_CLASS | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
            Matcher matcher = pattern.matcher(userComment);
            if (matcher.find()) {
                return true;
            }

        }
        return false;
    }

    public int countBadWords(String userComment) {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            Pattern pattern = Pattern.compile("\\b" + Pattern.quote(array[i]) + "\\b", Pattern.UNICODE_CHARACTER_CLASS
                    | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
            Matcher matcher = pattern.matcher(userComment);
            if (matcher.find()) {
                counter++;
            }
        }
        return counter;
    }

    public String getModifiedText(String userComment) {

          for (int i = 0; i < array.length; i++) {
              userComment = userComment.replaceAll(array[i],"#####");
          }
        return userComment;
    }
}