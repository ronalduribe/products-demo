package com.inditex.products.infraestructure.config.spring;

import com.inditex.products.application.port.in.FindPrice;
import com.inditex.products.application.port.out.repository.ProductRepository;
import com.inditex.products.application.usecases.FindPriceUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SpringBootServiceConfig {

    private final ProductRepository repository;

    @Bean
    public FindPrice findPrice() { return new FindPriceUseCase(repository);
    }

}
