package org.Hospital.persistenciaBase;

import org.Hospital.modelo.Paciente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DataBaseManager {
    private static Connection connection;

    static {
        try {

            java.util.Properties properties = new java.util.Properties();
            properties.load(DataBaseManager.class.getClassLoader().getResourceAsStream("config.properties"));
            String url = properties.getProperty("db.url");
            String user = properties.getProperty("db.user");
            String password = properties.getProperty("db.password");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void guardarAtencion(Paciente paciente, String doctor) {
        String sql = "INSERT INTO registro_medicos (paciente, doctor) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, paciente.getNombre());
            stmt.setString(2, doctor);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
