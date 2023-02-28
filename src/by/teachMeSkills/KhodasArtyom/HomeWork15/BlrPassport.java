package by.teachMeSkills.KhodasArtyom.HomeWork15;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BlrPassport {
    private String surName;
    private String name;
    private LocalDate birthday;
    private Gender gender;
    private String numberOfPassport;
    private String numberIdentity;
    private LocalDate dateOfIssue;
    private LocalDate validity;

    public static void main(String[] args) {

    }


    public BlrPassport(String surName, String name, LocalDate birthday, Gender gender,
                       String numberOfPassport, String numberIdentity,
                       LocalDate dateOfIssue, LocalDate validity) {

        if(isValidatedPassportData( surName, name, numberOfPassport, numberIdentity, dateOfIssue,validity)) {
            this.surName = surName;
            this.name = name;
            this.birthday = birthday;
            this.gender = gender;
            this.numberOfPassport = numberOfPassport;
            this.numberIdentity = numberIdentity;
            this.dateOfIssue = dateOfIssue;
            this.validity = validity;

        }else {
            throw new IllegalArgumentException("incorrectly entered data. Please,try again");
        }
    }

    public boolean isCorrectNameAndSurname(String name, String surName) {
        if (name == null || surName == null) {
            throw new IllegalArgumentException("String can't be empty");
        }
        return name.matches("[A-Za-z]+") && surName.matches("[A-Za-z]+");
    }

    public boolean isCorrect(String numberOfPassport) {
        final int PASSPORT_LENGTH = 9;
        if (numberOfPassport.length() != PASSPORT_LENGTH) {
            throw new IllegalArgumentException("Uncorrected serial number of passport");
        }
        return numberOfPassport.matches("(AB|BM|NB|KN|MP|MC|KB|PP|SP|DP)\\d{7}");

    }

    public boolean isValidNumberIdentity(String numberIdentity) {
        final int NUMBERIDENTITY_LENGTH = 14;
        if (NUMBERIDENTITY_LENGTH != 14) {
            throw new IllegalArgumentException("Uncorrected numberIdentity");
        }
        return numberIdentity.matches("\\d{7}[ABCKEMH]\\d{3}(PB|BA|BI)\\d{1}");
    }

    public boolean isCorrectData(LocalDate dateOfIssue, LocalDate validity) {
        return dateOfIssue.isBefore(validity);
    }

    public boolean isExpired(LocalDate now) {
        return now.isBefore(validity);
    }

    public boolean isValidatedPassportData(String surName, String name,
                                           String numberOfPassport, String numberIdentity,
                                           LocalDate dateOfIssue, LocalDate validity) {
        return isCorrectNameAndSurname(surName, name) && isCorrect(numberOfPassport)
                && isValidNumberIdentity(numberIdentity) && isCorrectData(dateOfIssue, validity);

    }


    @Override
    public String toString() {
        return "BlrPassport: " +
                "name: '" + name + "\n" +
                ", surname:'" + surName + "\n" +
                ", birthday:" + birthday.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + "\n" +
                ", gender: " + gender +
                ", numberOfPassport:'" + numberOfPassport + "\n" +
                ", numberIdentity:'" + numberIdentity + "\n" +
                ", dateOfIssue:" + dateOfIssue.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + "\n" +
                ", validity:" + validity.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + "\n" +
                '.';
    }

}
