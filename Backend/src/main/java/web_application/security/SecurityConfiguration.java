package web_application.security;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationUserDetailService authenticationUserDetailService;

    @Override protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, AuthenticationConfigConstants.SIGN_UP_URL).permitAll()
                .antMatchers(HttpMethod.POST,"/login").permitAll()
                .antMatchers(HttpMethod.POST,"/member").permitAll()
                .antMatchers(HttpMethod.GET,"/member").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET,"/member/{username}").hasAnyAuthority("ADMIN","USER")
                .antMatchers("/category").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET,"/category/woman").permitAll()
                .antMatchers(HttpMethod.GET,"/category/man").permitAll()
                .antMatchers(HttpMethod.POST,"/order").permitAll()
                .antMatchers(HttpMethod.GET,"/order").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET,"/order/{username}").hasAnyAuthority("ADMIN","USER")
                .antMatchers(HttpMethod.POST,"/product ").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET,"/product/{CatGender}/{CatName}").permitAll()

                .anyRequest().permitAll()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                // this disables session creation on Spring Security
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationUserDetailService).passwordEncoder(bCryptPasswordEncoder);
    }


}
