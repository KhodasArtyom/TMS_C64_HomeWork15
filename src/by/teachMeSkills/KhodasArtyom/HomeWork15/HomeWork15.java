package by.teachMeSkills.KhodasArtyom.HomeWork15;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class HomeWork15 {

    public static void main(String[] args) {
        System.out.println("Choose the operation");
        String operation = """
                1)Passport validation
                2)Work with  obscene language
                """;
        System.out.println(operation);
        Scanner scanner = new Scanner(System.in);
        int button = Integer.parseInt(scanner.nextLine());
        while (true) {
            switch (button) {
                case 1 -> {
                    System.out.println("Fill in your passport details");
                    System.out.println("Enter your name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter your surname");
                    String surname = scanner.nextLine();
                    System.out.println("Enter your birthday in format(dd.MM.yyyy");
                    LocalDate birthday = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                    System.out.println("Enter your gender");
                    Gender gender = Gender.valueOf(scanner.nextLine());
                    System.out.println("Enter your passport number:");
                    String passNumber = scanner.nextLine();
                    System.out.println("Enter your passport number identity");
                    String numberIdentity = scanner.nextLine();
                    System.out.println("Enter the date of issue in format (dd.MM.yyyy");
                    LocalDate identityData = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                    System.out.println("Enter the date of expire");
                    LocalDate expireData = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                    BlrPassport blrPassport = new BlrPassport(name, surname, birthday, gender, passNumber,
                            numberIdentity, identityData, expireData);
                    String data = blrPassport.toString();
                    System.out.println(data);
                    System.out.println("Your passport is expired\n" +
                            blrPassport.isExpired(LocalDate.now(ZoneId.of("Europe/Minsk"))));
                    return;


                }
                case 2 -> {
                    System.out.println("Enter the string of bad words");
                    String phrase = scanner.nextLine();
                    String phrase2 = phrase;
                    String [] ar = phrase2.split(" ");
                    System.out.println(Arrays.toString(ar));
                    TextBlackListFilter textBlackListFilter = new TextBlackListFilter(ar);;
                    System.out.println("Enter the phrase to check for bad words ");
                    String text = scanner.nextLine();
                    System.out.println("Check for bad words...");
                    System.out.println(textBlackListFilter.isObsceneLanguage(text));

                    System.out.println("Count how much rude you are");
                    System.out.println(textBlackListFilter.countBadWords(text));

                    System.out.println("I modified your text:");
                    System.out.println(textBlackListFilter.getModifiedText(text));

                    return;

                }case 0->{
                    return;
                }
            }
        }
    }
}
