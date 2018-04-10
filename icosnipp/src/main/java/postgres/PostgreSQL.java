package postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQL {

    private Connection c;

    public PostgreSQL(){
        setupConnection();
    }

    private Connection setupConnection(){
        c = null;
        try {
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/ico",
                            "postgres", "acfe0b3751");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public Connection getConnection(){
        return c;
    }
}
