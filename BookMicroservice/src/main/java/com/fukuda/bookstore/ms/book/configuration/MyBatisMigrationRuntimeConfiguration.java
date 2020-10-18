package com.fukuda.bookstore.ms.book.configuration;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;

import org.apache.ibatis.migration.ConnectionProvider;
import org.apache.ibatis.migration.FileMigrationLoader;
import org.apache.ibatis.migration.operations.VersionOperation;
import org.apache.ibatis.migration.options.DatabaseOperationOption;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ScriptException;

@Configuration
public class MyBatisMigrationRuntimeConfiguration {
    private static final String CHANGELOG_TABLE = "changelog";
    private static final String MIGRATION_SCRIPTS = "migration/scripts";

    @Value("${current.migration.version:0}")
    private BigDecimal current_migration_version;

    @Bean
    public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(dataSource);
        dataSourceInitializer.setDatabasePopulator(new Populator());
        return dataSourceInitializer;
    }

    private DatabaseOperationOption getOption() {
        DatabaseOperationOption options = new DatabaseOperationOption();
        options.setChangelogTable(CHANGELOG_TABLE);
        return options;
    }

    private Properties getProperties() {
        Properties properties = new Properties();
        properties.setProperty("changelog", CHANGELOG_TABLE);
        return properties;
    }

    private File getScriptDir() {
        URL url = getClass().getClassLoader().getResource(MIGRATION_SCRIPTS);
        if (url == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(url.getFile());
        }
    }

    private class Populator implements DatabasePopulator {
        @Override
        public void populate(Connection connection) throws SQLException, ScriptException {
            if(current_migration_version.compareTo(BigDecimal.ZERO) > 1){
                new VersionOperation(current_migration_version).operate(
                        new SimplyConnectionProvider(connection),
                        new FileMigrationLoader(getScriptDir(), "utf-8", getProperties()),
                        getOption(),
                        System.out
                );
            }
        }
    }

    private static class SimplyConnectionProvider implements ConnectionProvider {
        private final Connection connection;

        public SimplyConnectionProvider(Connection connection) {
            this.connection = connection;
        }

        public Connection getConnection() {
            return connection;
        }
    }
}