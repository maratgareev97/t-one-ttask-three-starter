package org.example.marat;

import com.example.service.Authenticator;
import com.example.service.AuthenticatorConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties(AuthProperties.class)  // Активируем биндинг свойств
public class AuthAutoConfiguration {
    private final AuthProperties authProperties;

    public AuthAutoConfiguration(AuthProperties authProperties) {
        this.authProperties = authProperties;
    }


    @Bean
    @ConditionalOnProperty(name = "auth.enabled", havingValue = "true", matchIfMissing = true)
    public Authenticator authenticator(AuthenticatorConfig config){
        return new Authenticator(config);
    }

    @Bean AuthenticatorConfig authenticatorConfig(){
        Map<String,String> correctCredentials = authProperties.getCredentials();
        if (correctCredentials == null || correctCredentials.isEmpty()){
            correctCredentials= new HashMap<>();
            correctCredentials.put("root","0000");
        }
        return new AuthenticatorConfig(correctCredentials);
    }
}
