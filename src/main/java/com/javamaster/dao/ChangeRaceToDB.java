package com.javamaster.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ChangeRaceToDB {
    int number;
    Boolean answerAboutChange;

    void show() {
        System.out.println("Number: " + number);
    }

    public Boolean changeRaceToDB() {
        return answerAboutChange;
    }

    public ChangeRaceToDB(String raceWeek, String raceYear, String raceCountry, String raceCity) {
        number = 100;
        Connection c;
        Statement stmt;
        int idRace = 1;
        boolean answerAboutChange;
        String qwRaceWeek, qwRaceYear,qwRaceCountry, qwraceCity;
        show();

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/shoes_shop",
                            "postgres", "12");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();

            try {
                idRace = Integer.parseInt(raceYear+raceWeek);
                System.out.println(idRace);
            } catch (NumberFormatException e) {
                System.err.println("Wrong format for the idRace!");
            }

            qwRaceWeek = " '"+raceWeek+"' ,";
            qwRaceYear = " '"+raceYear+"' ,";
            qwRaceCountry = " '"+raceCountry+"' ,";
            qwraceCity = " '"+raceCity+"'";

            stmt = c.createStatement();
            String sql = "UPDATE COMPANY set " +
                    "SALARY = 30000.00 ," +
                    "RACEWEEK =" + qwRaceWeek +
                    "RACEYEAR =" + qwRaceYear +
                    "RACECOUNTRY =" + qwRaceCountry +
                    "RACECITY =" + qwraceCity +
                    " where ID=" + idRace + ";";
            System.out.println( "qwSql = " + sql );
            stmt.executeUpdate(sql);
            c.commit();

            ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String  name = rs.getString("name");
                int age  = rs.getInt("age");
                String  address = rs.getString("address");
                float salary = rs.getFloat("salary");
                System.out.println( "ID = " + id );
                System.out.println( "NAME = " + name );
                System.out.println( "AGE = " + age );
                System.out.println( "ADDRESS = " + address );
                System.out.println( "SALARY = " + salary );
                System.out.println();
            }

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            answerAboutChange = false;
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        answerAboutChange = true;
    }
}

