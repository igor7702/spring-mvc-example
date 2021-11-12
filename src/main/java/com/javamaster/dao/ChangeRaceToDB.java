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

            qwRaceWeek = " '"+raceWeek+"' ,";
            qwRaceYear = " '"+raceYear+"' ,";
            qwRaceCountry = " '"+raceCountry+"' ,";
            qwraceCity = " '"+raceCity+"'";

            stmt = c.createStatement();
            String sql = "UPDATE RACES set " +
                    "WEEK_RACE =" + qwRaceWeek +
                    "YEAR_RACE =" + qwRaceYear +
                    "COUNTRY_NAME_RACE =" + qwRaceCountry +
                    "CITY_NAME_RACE =" + qwraceCity +
                    " where ID_RACE=" + idRace +
                    ";";
            System.out.println( "qwSql = " + sql );
            stmt.executeUpdate(sql);
            c.commit();

            ResultSet rs = stmt.executeQuery( "SELECT * FROM RACES;" );
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String  week_race = rs.getString("week_race");
                String  year_race = rs.getString("year_race");
                String  country_name_race = rs.getString("country_name_race");
                String  city_name_race = rs.getString("city_name_race");
                int country_id_race = rs.getInt("country_id_race");
                int city_id_race = rs.getInt("city_id_race");
                String  id_race = rs.getString("id_race");

                System.out.println( "id = " + id );
                System.out.println( "week_race = " + week_race );
                System.out.println( "year_race = " + year_race );
                System.out.println( "country_name_race = " + country_name_race );
                System.out.println( "city_name_race = " + city_name_race );
                System.out.println( "country_id_race = " + country_id_race );
                System.out.println( "city_id_race = " + city_id_race );
                System.out.println( "id_race = " + id_race );
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

