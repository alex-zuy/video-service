package org.pirat9600q.configs;

import org.pirat9600q.App;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackageClasses = {App.class})
public class SpringDataJpaConfig {}
