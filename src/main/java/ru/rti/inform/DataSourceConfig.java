package ru.rti.inform;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import ru.rti.inform.entity.Person;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "mainEntityManager",
//        entityManagerFactoryRef = "personEntityManager",
        transactionManagerRef = "mainTransactionManager",
//        transactionManagerRef = "personTransactionManager",
        basePackages = "ru.rti.inform.repository"
)
public class DataSourceConfig {
    @Value("${app.jpa.hibernate.ddl-auto}")
    private String ddlAuto;

    @Bean
    @Primary
    PlatformTransactionManager mainTransactionManager(EntityManagerFactory mainEntityManager) {
        return new JpaTransactionManager(mainEntityManager);
    }

    @Bean
    @Primary
    LocalContainerEntityManagerFactoryBean mainEntityManager(EntityManagerFactoryBuilder builder) {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", ddlAuto);

        LocalContainerEntityManagerFactoryBean em = builder
                .dataSource(appDataSource())
                .packages("ru.rti.inform.entity")
                .persistenceUnit("mainPersistenceUnit")
                .build();
        em.setJpaProperties(properties);

        return em;
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "app.datasource")
    DataSource appDataSource() {
        return DataSourceBuilder
                .create()
                .build();
    }

}
