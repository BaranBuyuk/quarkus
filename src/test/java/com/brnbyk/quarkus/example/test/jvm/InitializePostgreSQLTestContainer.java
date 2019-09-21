package com.brnbyk.quarkus.example.test.jvm;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.HashMap;
import java.util.Map;

/**
 * Username = baranbuyuk
 * Date = 21.09.2019 14:42
 **/

public class InitializePostgreSQLTestContainer implements QuarkusTestResourceLifecycleManager {


    private PostgreSQLContainer postgreSQLContainer;


    @Override
    public Map<String, String> start() {
        this.postgreSQLContainer = new PostgreSQLContainer();
        postgreSQLContainer.start();
        return configurationParameters();
    }

    @Override
    public void stop() {
        if (postgreSQLContainer != null) {
            postgreSQLContainer.stop();
        }
    }

    private Map<String, String> configurationParameters() {
        Map<String, String> config = new HashMap<>();
        config.put("quarkus.datasource.url", postgreSQLContainer.getJdbcUrl());
        config.put("quarkus.datasource.driver", postgreSQLContainer.getDriverClassName());
        config.put("quarkus.datasource.username", postgreSQLContainer.getUsername());
        config.put("quarkus.datasource.password", postgreSQLContainer.getPassword());
        config.put("quarkus.flyway.locations", "db/migration/");
        config.put("quarkus.flyway.migrate-at-start", "true");
        config.put("quarkus.flyway.baseline-on-migrate", "true");
        config.put("quarkus.flyway.table", "quarkus_versioning_history");
        return config;
    }
}
