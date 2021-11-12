package com.javamaster.dao;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetRaceFromDB {
    int number;
    String countryRace;
    @Getter
    String cityRace;

    void show() {
        System.out.println("Number: " + number);
    }

    public String getCountryRace() {
        return countryRace;
    }
    public String getCityRace() {
        return cityRace;
    }

    public GetRaceFromDB(String raceWeek, String raceYear) {
        number = 100;
        Connection c;
        Statement stmt;
        show();

        System.out.println("Year: " + raceYear);

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "12");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM RACES;");
            while (rs.next()) {
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

                countryRace = country_name_race;
                cityRace = city_name_race;
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

