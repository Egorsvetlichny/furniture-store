package ru.esvetlichny.furniturestore.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.esvetlichny.furniturestore.service.impl.UserDetailsServiceImpl;

@Configuration
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsServiceImpl userDetailsService;

    @Bean // Объявление Java-бина (Dependency Injection)
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService) // Использовать самописный сервис (UserDetailsServiceImpl) для проверки данных пользователя
                .passwordEncoder(passwordEncoder()); // Использовать алгоритм хэширования паролей Bcrypt
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.logout() // Добавить эндпоинт "/logout" для очистки сеанса пользователя в браузере (клиенте)
                .and()
                .httpBasic() // Использовать HTTP Basic Auth (по логину и паролю)
                .and()
                .csrf() //
                .disable() // Отключить проверку на подделку межсайтовых запросов
                .authorizeRequests() // Следующие элементы будут влиять на доступ к отдельным эндпоинтам
                .antMatchers(HttpMethod.GET, "/furniture/**", "/types/**", "/placements/**") //
                .permitAll() // Разрешить неавторизованные GET запросы по указанным эндпоинтам
                .anyRequest() //
                .authenticated(); // Использовать аутентификацию для всех остальных запросов
    }
}
