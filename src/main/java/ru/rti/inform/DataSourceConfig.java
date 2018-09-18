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
import ru.rti.inform.entity.Employee;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "employeeEntityManager",
        transactionManagerRef = "employeeTransactionManager",
        basePackages = "ru.rti.inform.repository"
)
public class DataSourceConfig {
    @Value("${app.jpa.hibernate.ddl-auto}")
    private String ddlAuto;

    @Bean
    @Primary
    PlatformTransactionManager employeeTransactionManager(EntityManagerFactory employeeEntityManager) {
        return new JpaTransactionManager(employeeEntityManager);
    }

    @Bean
    @Primary
    LocalContainerEntityManagerFactoryBean employeeEntityManager(EntityManagerFactoryBuilder builder) {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", ddlAuto);  //"org.hibernate.dialect.SQLServer2008Dialect"

        LocalContainerEntityManagerFactoryBean em = builder
                .dataSource(employeeDataSource())
                .packages(Employee.class)
                .persistenceUnit("employees")
                .build();
        em.setJpaProperties(properties);

        return em;
//        return builder
//                .dataSource(employeeDataSource())
//                .packages(Employee.class)
//                .persistenceUnit("employees")
//                .build();
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "app.datasource")
    DataSource employeeDataSource() {
        return DataSourceBuilder
                .create()
                .build();
    }

}
