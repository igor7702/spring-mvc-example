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
        String qwRaceWeek="", qwRaceYear="",qwSpecialCode;
        show();

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "12");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            try {
                idRace = Integer.parseInt(raceYear+raceWeek);
                System.out.println(idRace);
            } catch (NumberFormatException e) {
                System.err.println("Wrong format for the idRace!");
            }

            stmt = c.createStatement();
            String sql = "DELETE from RACES where ID_RACE = " + idRace + ";";
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

