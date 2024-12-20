package pe.edu.cibertec.bookFlow.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HikariCpConfig {
    @Value("${DB_URL}")
    private String dbUrl;
    @Value("${DB_USER}")
    private String dbUser;
    @Value("${DB_PASSWORD}")
    private String dbPass;
    @Value("${DB_DRIVER}")
    private String dbDriver;

    @Bean
    public HikariDataSource hikariDataSource() {

        System.out.println("HikariDataSource Configured with URL: " + dbUrl);

        HikariConfig config = new HikariConfig();

        /**
         * Configurar propiedad de conexion a BD
         */
        config.setJdbcUrl(dbUrl);
        config.setUsername(dbUser);
        config.setPassword(dbPass);
        config.setDriverClassName(dbDriver);

        config.setMaximumPoolSize(20);
        config.setMinimumIdle(5);
        config.setIdleTimeout(300000);
        config.setConnectionTimeout(30000);

        System.out.println(config.getMaximumPoolSize());
        System.out.println("##### HikariCp initialized ######");
        return new HikariDataSource(config);

    }
    
}
