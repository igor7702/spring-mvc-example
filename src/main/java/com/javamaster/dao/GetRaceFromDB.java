package com.javamaster.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetRaceFromDB {
    int number;
    String countryRace;

    void show() {
        System.out.println("Number: " + number);
    }

    public String getCountryRace() {
        return countryRace;
    }

    public GetRaceFromDB(String raceWeek, String raceYear) {
        number = 100;
        Connection c = null;
        Statement stmt = null;
        show();
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/shoes_shop",
                            "postgres", "12");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANY;");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                float salary = rs.getFloat("salary");
                String raceWeekOut = rs.getString("raceWeek");
                String raceYearOut = rs.getString("raceYear");
                System.out.println("ID = " + id);
                System.out.println("NAME = " + name);
                System.out.println("AGE = " + age);
                System.out.println("ADDRESS = " + address);
                System.out.println("SALARY = " + salary);
                System.out.println();

                // For getCountryRace
                countryRace = address;
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
}
