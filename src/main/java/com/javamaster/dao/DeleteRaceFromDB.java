package com.javamaster.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteRaceFromDB {
    int number;
    Boolean answerAboutDelete;

    void show() {
        System.out.println("Number: " + number);
    }

    public Boolean setRaceToDB() {
        return answerAboutDelete;
    }

    public DeleteRaceFromDB(String raceWeek, String raceYear, String specialCode) {
        number = 100;
        Connection c = null;
        Statement stmt = null;
        int idRace = 1;
        boolean answerAboutDelete;
        String qwRaceWeek="", qwRaceYear="",qwRaceCountry="", qwraceCity="";
        show();

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/shoes_shop",
                            "postgres", "12");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "DELETE from COMPANY where ID = 2;";
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
            rs.close();
            stmt.close();
            c.close();

            try {
                idRace = Integer.parseInt(raceYear+raceWeek);
                System.out.println(idRace);
            } catch (NumberFormatException e) {
                System.err.println("Wrong format for the idRace!");
            }

        } catch (Exception e) {
            answerAboutDelete = false;
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        answerAboutDelete = true;
    }
}

