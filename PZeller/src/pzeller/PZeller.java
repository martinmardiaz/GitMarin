/*
Autor: Martín Marín Díaz
Fecha: 16/02/2021
 */
package pzeller;

import java.util.Scanner;

public class PZeller {

    static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) 
    {
        programmerDay();
    }
    
    private static void programmerDay() 
    {
        int day = 13, month = 9, year;
        System.out.println("Write the year which you want to see Programmer's Day.");
        year = scan.nextInt();
        
        if (year < 1900)
        {
            System.out.println("The value is too low. Try again.");
            year = scan.nextInt();
        }
        
        if(leapYear(year) == 1) day = 12;
        
        String strDay = zeller(day, month, year);
        
        System.out.println("Programmer's Day is in " + strDay + ", " + day + ".");
    }
    
    private static int leapYear(int year)
    {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) ? 1 : 0; // First value, true, second value, false.
    }
    
    private static String zeller(int day, int month, int year) 
    {
        int a, y, m, d;
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        a = (14 - month) / 12;
        y = year - a;
        m = month + 12 * a - 2;
        d = (day + y + y / 4 - y / 100 + y / 400 + (31 * m) / 12) % 7;
        return week[d];
    }
}
