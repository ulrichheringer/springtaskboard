package com.ulrich.taskboard;

import com.ulrich.taskboard.persistence.migration.MigrationStrategy;
import static com.ulrich.taskboard.persistence.config.ConnectionConfig.getConnection;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        try(var connection = getConnection()) {
            new MigrationStrategy(connection).executeMigration();
        }
    }
}
