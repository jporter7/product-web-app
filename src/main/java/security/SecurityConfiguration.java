package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    public SecurityConfiguration() {
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/*");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().and()
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/vendors/{vendorId}/products").hasRole("VENDOR")
                    .antMatchers("/products/{id}/status").hasRole("VENDOR")
                    .antMatchers("/vendors/{id}/status").hasRole("ADMIN")
                    .antMatchers("/vendors/{id}/products").permitAll()
                    .antMatchers("/vendors").permitAll()
                    .antMatchers("/contacts/{id}/phones").permitAll()
                    .antMatchers("/contacts/{contactId}/phones").hasRole("VENDOR")
                    .antMatchers("/contacts/{contactId}/phones").hasRole("CLEANER")
                    .and()
                .formLogin()
                    .loginPage("/login").failureUrl("/login-error");

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .inMemoryAuthentication()
                    .withUser("kcadmin").password("vinceisgreat").roles("ADMIN");
    }
}