package com.theironyard;

import jodd.json.JsonSerializer;
import org.h2.tools.Server;
import spark.Spark;

import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void createTables(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.execute("CREATE TABLE IF NOT EXISTS vespas (id IDENTITY, time INT, description VARCHAR, image VARCHAR, lat DOUBLE, lon DOUBLE, has_sidecar BOOLEAN)");
    }

    public static ArrayList<Vespa> selectVespas(Connection conn) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM vespas");
        ResultSet results = stmt.executeQuery();
        ArrayList<Vespa> vespas = new ArrayList<>();
        while (results.next()) {
            int id = results.getInt("id");
            int time = results.getInt("time");
            String desc = results.getString("description");
            String img = results.getString("image");
            double lat = results.getDouble("lat");
            double lon = results.getDouble("lon");
            boolean hasSidecar = results.getBoolean("has_sidecar");
            Vespa v = new Vespa(id, time, desc, img, lat, lon, hasSidecar);
            vespas.add(v);
        }
        return vespas;
    }

    public static void main(String[] args) throws SQLException {
        Server.createWebServer().start();
        Connection conn = DriverManager.getConnection("jdbc:h2:./main");
        createTables(conn);

        Spark.externalStaticFileLocation("public");
        Spark.init();
        Spark.get(
                "/vespa",
                (request, response) ->{
                    ArrayList<Vespa> vespas = selectVespas(conn);
                    JsonSerializer s = new JsonSerializer();
                    return s.serialize(vespas);
                }
        );
    }
}
