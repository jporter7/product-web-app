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
                    .antMatchers("/vendors/{vendorId}/products").hasRole("Vendor")
                    .antMatchers("/products/{id}/status").hasRole("Vendor")
                    .antMatchers("/vendors/{id}/status").hasRole("Admin")
                    .antMatchers("/vendors/{id}/products").authenticated()
                    .antMatchers("/vendors").authenticated()
                    .antMatchers("/contacts/{id}/phones").authenticated()
                    .antMatchers("/contacts/{contactId}/phones").hasRole("Vendor")
                    .antMatchers("/contacts/{contactId}/phones").hasRole("Cleaner")
                    .and()
                .formLogin()
                    .loginPage("/login").failureUrl("/login-error");

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .inMemoryAuthentication()
                    .withUser("kcadmin").password("pass").roles("Admin")
                    .and()
                    .withUser("kccleaner").password("pass").roles("Cleaner")
                    .and()
                    .withUser("kcvendor").password("pass").roles("Vendor");
    }
}