package sgm.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.*;

import javax.validation.*;

@Configuration
public class AppConfiguration {

    @Bean
    public Validator validator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return factory.getValidator();
    }

}
