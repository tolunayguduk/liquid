package com.liquid.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.envers.repository.config.EnableEnversRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaAuditing
@EnableEnversRepositories(basePackages = {"com.liquid.user.repository"})
@EnableTransactionManagement
public class RepositoryConfig {
	

}
