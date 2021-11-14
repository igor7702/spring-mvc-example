package com.javamaster.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SetRaceToDB {
    int number;
    Boolean answerAbouSet;

    void show() {
        System.out.println("Number: " + number);
    }

    public Boolean setRaceToDB() {
        return answerAbouSet;
    }

    public SetRaceToDB(String raceWeek, String raceYear, String raceCountry, String raceCity,
                       String specialCode) {
        number = 100;
        Connection c = null;
        Statement stmt = null;
        int idRace = 1, idCountry = 1, idCity = 1;
        String permissionCode = "4545";
        boolean answerAbouSet;
        String qwRaceWeek="", qwRaceYear="",qwRaceCountry="", qwraceCity="";
        show();

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
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

            qwRaceWeek = "'" + raceWeek+"'";
            qwRaceYear = ", '"+raceYear+"'";
            qwRaceCountry = ", '"+raceCountry+"'";
            qwraceCity = ", '"+raceCity+"'";

            if(specialCode.equals(permissionCode)) {
                System.out.println("Statement  is true");
                String sql = "INSERT INTO RACES (WEEK_RACE,YEAR_RACE,COUNTRY_NAME_RACE,CITY_NAME_RACE," +
                        "COUNTRY_ID_RACE,CITY_ID_RACE,ID_RACE) "
                        + "VALUES (" + qwRaceWeek + qwRaceYear + qwRaceCountry + qwraceCity
                        + "," + idCountry + "," + idCity + "," + idRace +
                        ");";
                System.out.println(sql);

                stmt.executeUpdate(sql);

                stmt.close();
                c.commit();
            }
            else{
                System.out.println("Statement is false");
            }

            c.close();
        } catch (Exception e) {
            answerAbouSet = false;
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        answerAbouSet = true;
    }
}

