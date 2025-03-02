// YOUR NAME: 
// COLLABORATORS: 
// DATE: 

public class Main
{
        //ascii art credit: http://www.oocities.org/spunk1111/bodypart.htm
        static final String ASCII_ART_0 = "    .----.    .----.  ",
                ASCII_ART_1 = "   (  --  \\  /  --  )",
                ASCII_ART_2 = "          |  |        ",
                ASCII_ART_3 = "         _/  \\_      ",
                ASCII_ART_4 = "        (_    _)      ",
                ASCII_ART_5 = "     ,    `--`    ,   ",
                ASCII_ART_6 = "     \\'-.______.-'/  ",
                ASCII_ART_7 = "      \\          /   ",
                ASCII_ART_8 = "       '.--..--.'     ",
                ASCII_ART_9 = "         `\"\"\"\"\"` ",
                ASCII_CREDIT = "   ascii art by: jgs    ";

        static final String TITLE_USA = "UNITED STATES OF AMERICA",
                TITLE_EAC = "EMPLOYMENT AUTHORIZATION CARD";
        static final String LABEL_SURNAME = "Surname", LABEL_GIVEN_NAME = "Given Name", LABEL_USCIS_NUM = "USCIS#",
                LABEL_CATEGORY = "Category", LABEL_CARD_NUM = "Card#", LABEL_BIRTH_COUNTRY = "Country of Birth",
                LABEL_TERMS_CONDITIONS = "Terms and Conditions", LABEL_BIRTH_DATE = "Date of Birth",
                LABEL_SEX = "Sex", LABEL_VALID_DATE = "Valid From:", LABEL_EXPIRE_DATE = "Card Expires:",
                LABEL_REENTRY_DISCLAIMER = "NOT VALID FOR REENTRY TO U.S.";
    public static void main(String[] args)
    {
        

        //DECLARATION SECTION
        //complete fields
        String surname, givenName, category, cardNum, birthCountry, termsAndConditions;
        char sex;

        //parts of fields
        String birthMonth;
        int uscisNum1, uscisNum2, uscisNum3, birthDay, birthYear,
                validDay, validMonth, validYear, expireMonth, expireDay, expireYear;

        //extra vars to help with formatting of Strings (not raw data like above vars)
        String uscisNum, dateOfBirth, validDate, expireDate;

        //INITIALIZATION SECTION
        surname = UtilityBelt.readString("What is your surname: ", 0, 20); // "CHAPETON-LAMAS"
        givenName = UtilityBelt.readString("What is your name: ", 0, 20); // "NERY"
        uscisNum1 = UtilityBelt.readInt("Enter the first number of your USCIS: ", 0, 100);; // 12
        uscisNum2 = UtilityBelt.readInt("Enter the second number of your USCIS: ", 0, 10);; // 4
        uscisNum3 = UtilityBelt.readInt("Enter the third number of your USCIS: ", 0, 1000);; // 789
        category = UtilityBelt.readString("What is your category: ", 0, 4); // "C09"
        cardNum = UtilityBelt.readString("What is your card number: ", 0, 15); // "SRC9876543210"
        birthCountry = UtilityBelt.readString("What is your birth country: ", 0, 50); // "Guatemala"
        termsAndConditions = UtilityBelt.readString("What is your terms and conditions status: ", 0, 10); // "None"

        birthDay = UtilityBelt.readInt("What is the day of your birthday: ", 0, 12); // 1
        birthMonth = UtilityBelt.readString("What is the month (first three letter, capitalized) of your birthday: ", 0, 3); // "JAN"
        birthYear = UtilityBelt.readInt("What is the year of your birthday: ", 1900, 2100); // 1970

        sex = UtilityBelt.readChar("What is your gender (use a single letter to indicate this): ", "MmFf"); //'M', note single quotes

        // Prompt user to enter the validation date details
        // 2/2/2020
        validMonth = UtilityBelt.readInt("Enter the validation month: ", 1, 12);
        validDay = UtilityBelt.readInt("Enter the validation day: ", 1, 31);
        validYear = UtilityBelt.readInt("Enter the validation year: ", 1900, 2100);

        // Prompt user to enter the expiration date details
        // 2/2/2022
        expireMonth = UtilityBelt.readInt("Enter the expiration month: ", 1, 12);
        expireDay = UtilityBelt.readInt("Enter the expiration day: ", 1, 31);
        expireYear = UtilityBelt.readInt("Enter the expiration year: ", 1900, 2100);

        //Strings to help clean up long printf's below
        uscisNum = String.format("%03d-%03d-%03d", uscisNum1, uscisNum2, uscisNum3);
        dateOfBirth = String.format("%02d %s %d", birthDay, birthMonth, birthYear);
        validDate = formatDate(validMonth, validDay, validYear);
        expireDate = formatDate(expireMonth, expireDay, expireYear);


        //INPUT + CALCULATION SECTION
        //N/A

        //OUTPUT SECTION
        formatCard(surname, givenName, category, cardNum, birthCountry, termsAndConditions, sex, uscisNum, dateOfBirth, validDate, expireDate);
    }

    public static String formatCard(String surname, String givenName, String category, String cardNum, String birthCountry, String termsAndConditions, char sex, String uscisNum, String dateOfBirth, String validDate, String expireDate) {
        System.out.printf("╔══════════════════════════════════════════════════════════════════════╗%n");
        System.out.printf("║%35s%35s║%n", TITLE_USA, "");
        System.out.printf("║%60s%10s║%n", TITLE_EAC, "");
        System.out.printf("║%-25s%-45s║%n", "", LABEL_SURNAME);
        System.out.printf("║%-25s%-45s║%n", "", surname);
        System.out.printf("║%-25s%-45s║%n", ASCII_ART_0, LABEL_GIVEN_NAME);
        System.out.printf("║%-25s%-45s║%n", ASCII_ART_1, givenName);
        System.out.printf("║%-25s%-15s%-15s%-15s║%n", ASCII_ART_2, LABEL_USCIS_NUM, LABEL_CATEGORY, LABEL_CARD_NUM);
        System.out.printf("║%-25s%-15s%-15s%-15s║%n", ASCII_ART_3, uscisNum, category, cardNum);
        System.out.printf("║%-25s%-45s║%n", ASCII_ART_4, LABEL_BIRTH_COUNTRY);
        System.out.printf("║%-25s%-45s║%n", ASCII_ART_5, birthCountry);
        System.out.printf("║%-25s%-45s║%n", ASCII_ART_6, LABEL_TERMS_CONDITIONS);
        System.out.printf("║%-25s%-45s║%n", ASCII_ART_7, termsAndConditions);
        System.out.printf("║%-25s%-15s%-30s║%n", ASCII_ART_8, LABEL_BIRTH_DATE, LABEL_SEX);
        System.out.printf("║%-25s%-15s%-30s║%n", ASCII_ART_9, dateOfBirth, sex);
        System.out.printf("║%-25s%-15s%-30s║%n", "", LABEL_VALID_DATE, validDate);
        System.out.printf("║%-25s%-15s%-30s║%n", "", LABEL_EXPIRE_DATE, expireDate);
        System.out.printf("║%-25s%-45s║%n", ASCII_CREDIT, LABEL_REENTRY_DISCLAIMER);
        System.out.printf("╚══════════════════════════════════════════════════════════════════════╝%n");
        return "";
    }

    public static String formatDate(int month, int day, int year) {
        return String.format("%02d/%02d/%4d", month, day, year);
    }
}