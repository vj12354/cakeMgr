package com.waracle.cake.config;
import com.waracle.cake.CakeMgrApplication;
import io.springlets.data.jpa.repository.support.DetachableJpaRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(repositoryBaseClass = DetachableJpaRepositoryImpl.class,basePackageClasses = CakeMgrApplication.class)
/**
 * = SpringDataJpaDetachableRepositoryConfiguration
 *
 * TODO Auto-generated class documentation
 *
 */
public class SpringDataJpaDetachableRepositoryConfiguration {
}
