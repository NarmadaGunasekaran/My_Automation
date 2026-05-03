package com.test1;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.example.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Java extends BaseClass {

    @Test(priority = 0 , enabled = true )
    public void stringManipulationReverseProgram() {
        //Reverse a string
        String a = "Narmada";
        String reversed = "";
        for (int i = a.length() - 1; i >= 0; i--) {
            reversed = reversed + a.charAt(i);
        }
        System.out.println(reversed);
    }
    @Test (priority = 1 , enabled = true , dependsOnMethods ="stringManipulationReverseProgram" )
    public void stringManipulationPalindromeProgram() {
        //Check if a string is a palindrome

        String a = "Narmada";
        String reversed = "";

        for (int i = a.length() - 1; i >= 0; i--) {
            reversed = reversed + a.charAt(i);
        }

        if (reversed.equals(a)) {
            System.out.println(a + " is a palindrome");
        } else {
            System.out.println(a + " is not a palindrome");
        }
    }
    @Test(enabled = true)
    public void stringManipulationCount_charactersProgram() {

        String a= "Narmada is a good girl";
        int count = 0;

        for(int j = a.length()-1 ; j>=0 ; j--){
            if(a.charAt(j) !=' '){
                count=count+1;
            }
        }
        System.out.println(count);
    }

    @Test(enabled = true)
    public void stringManipulationCount_vowels_and_consonantsProgram() {

        String a = "Conso";
        String vowels = "aeiou";
        String resultvowls ="";
        String resultconsonents = "";

        for(int i =0 ; i<= a.length()-1 ; i++){
            char n = a.charAt(i);
            if(vowels.indexOf(n) != -1)
                resultvowls +=n;
            else resultconsonents += n;
        }
        System.out.println("vowels = " + resultvowls +"\n" + "consonants ="+ resultconsonents);
    }

    @Test(enabled = true)
    public void stringManipulationRemove_duplicates_Program() {

        String a = "Narmada is Narmada only";
        String result = "";
        for(int i = 0 ; i <= a.length()-1 ; i++){
            if(result.indexOf(a.charAt(i)) == -1){
                result = result + a.charAt(i);
            }
        }
        System.out.println(result);
    }
}

