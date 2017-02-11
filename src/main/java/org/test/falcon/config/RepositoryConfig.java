package org.test.falcon.config;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@PropertySources({ @PropertySource("classpath:application.properties") })
@EnableJpaRepositories(basePackages = { "org.test" })
public class RepositoryConfig {

    @Value("${entitymanager.packages.to.scan}")
    private String                      entityManagerPackagesToScan;

    @Value("${db.url}")
    private String               falconDbUrl;

    @Value("${db.driver}")
    private String               dbDriver;

    @Value("${db.username}")
    private String               dbUserName;

    @Value("${db.password}")
    private String               dbPassword;

    @Value("${hibernate.dialect}")
    private String                      HIBERNATE_DIALECT;

    @Value("${show.sql}")
    private boolean              showSql;

    private static EntityManagerFactory falconEntityManagerFactory;

    @PostConstruct
    protected void init() {
        falconEntityManagerFactory = createCustomEntityManagerFactory(falconDbUrl);
    }

    private EntityManagerFactory createCustomEntityManagerFactory(String dbUrl) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dbDriver);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUserName);
        dataSource.setPassword(dbPassword);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(createJPAAdapter());
        factory.setDataSource(dataSource);
        factory.setPersistenceProviderClass(HibernatePersistence.class);
        factory.setPackagesToScan(entityManagerPackagesToScan.split(","));
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    /**
     * Creating hibernate jpa adapter
     * 
     * @return
     */
    private HibernateJpaVendorAdapter createJPAAdapter() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(showSql);
        vendorAdapter.setDatabase(Database.MYSQL);

        return vendorAdapter;
    }

    public static EntityManagerFactory getFalconEntityFactory() {
        return falconEntityManagerFactory;
    }

    @Bean
    public DataSource pooledDataSource() throws Exception {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        comboPooledDataSource.setJdbcUrl(falconDbUrl);
        comboPooledDataSource.setDriverClass(dbDriver);
        comboPooledDataSource.setUser(dbUserName);
        comboPooledDataSource.setPassword(dbPassword);

        return comboPooledDataSource;

    }

    @Bean
    @Autowired
    @Primary
    public EntityManagerFactory entityManagerFactory() throws Exception {

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        // set jpa vendor
        factory.setJpaVendorAdapter(createJPAAdapter());
        factory.setDataSource(pooledDataSource());
        factory.setPersistenceProviderClass(HibernatePersistence.class);
        factory.setPackagesToScan(entityManagerPackagesToScan.split(","));

        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }

    @Bean(autowire = Autowire.BY_TYPE)
    @Primary
    public JpaTransactionManager transactionManager() throws Exception {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory());

        return transactionManager;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() throws Exception {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(pooledDataSource());
        sessionFactoryBean.setHibernateProperties(createJPAProperties());
        sessionFactoryBean.afterPropertiesSet();
        return sessionFactoryBean;
    }

    private Properties createJPAProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", HIBERNATE_DIALECT);
        properties.put("hibernate.id.new_generator_mappings", false);
        return properties;
    }

    @Bean(autowire = Autowire.BY_NAME, name = "hibernateTransactionManager")
    public HibernateTransactionManager hibernateTransactionManager() throws Exception {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());

        return hibernateTransactionManager;
    }
}
