package ru.rti.inform.pbd;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import ru.rti.inform.pbd.entity.PbdPerson;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "pbdEntityManager",
        transactionManagerRef = "pbdTransactionManager",
        basePackages = "ru.rti.inform.pbd.repository"
)
public class PbdDataSourceConfig {
    @Bean
    PlatformTransactionManager pbdTransactionManager(@Qualifier("pbdEntityManager") EntityManagerFactory pbdEntityManager) {
        return new JpaTransactionManager(pbdEntityManager);
    }

    @Bean
    LocalContainerEntityManagerFactoryBean pbdEntityManager(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(pbdDataSource())
                .packages("ru.rti.inform.pbd.entity")
                .persistenceUnit("pbdPersistenceUnit")
                .build();
    }

    @Bean
    @ConfigurationProperties(prefix = "pbd.datasource")
    DataSource pbdDataSource() {
        return DataSourceBuilder
                .create()
                .build();
    }

}
