package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


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
                    //Cart
                    .requestMatchers(new AntPathRequestMatcher("/cleaners/{cleanerId}/carts", "POST")).hasRole("CLEANER")
                    .requestMatchers(new AntPathRequestMatcher("/carts/{id}", "DELETE")).hasRole("CLEANER")
                    .requestMatchers(new AntPathRequestMatcher("/carts/{id}", "GET")).hasRole("CLEANER")
                    .requestMatchers(new AntPathRequestMatcher("/cleaners/{id}/carts", "GET")).hasRole("CLEANER")
                    //Cart-Product
                    .requestMatchers(new AntPathRequestMatcher("/carts/{cartId}/cart-products", "POST")).hasRole("CLEANER")
                    .requestMatchers(new AntPathRequestMatcher("/cart-products/{id}", "DELETE")).hasRole("CLEANER")
                    .requestMatchers(new AntPathRequestMatcher("/carts/{id}/cart-product", "GET")).hasRole("CLEANER")
                    .requestMatchers(new AntPathRequestMatcher("/cart-products/{id}", "GET")).hasRole("CLEANER")
                    .requestMatchers(new AntPathRequestMatcher("/cart-products/{id}", "PUT")).hasRole("CLEANER")
                    //Cart-Product-Status
                    .requestMatchers(new AntPathRequestMatcher("cart-products/{cartProductId}/cart-product-statuses", "POST")).hasRole("CLEANER")
                    .requestMatchers(new AntPathRequestMatcher("cart-products/{id}/cart-product-statuses", "GET")).hasRole("CLEANER")
                    .requestMatchers(new AntPathRequestMatcher("cart-product-statuses/{id}", "GET")).hasRole("CLEANER")
                    //Cart-Status
                    .requestMatchers(new AntPathRequestMatcher("carts/{cartId}/cart-statuses", "POST")).hasRole("CLEANER")
                    .requestMatchers(new AntPathRequestMatcher("carts/{cartId}/cart-statuses", "GET")).hasRole("CLEANER")
                    .requestMatchers(new AntPathRequestMatcher("cart-statuses/{id}", "GET")).hasRole("CLEANER")
                    //Checkout
                    .requestMatchers(new AntPathRequestMatcher("carts/{id}/checkout", "POST")).hasRole("CLEANER")
                    .requestMatchers(new AntPathRequestMatcher("carts/{id}/checkout-retry", "POST")).hasRole("CLEANER")
                    //Contact
                    .requestMatchers(new AntPathRequestMatcher("/vendors/{vendorId}/contacts", "POST")).hasRole("VENDOR")
                    .requestMatchers(new AntPathRequestMatcher("/contacts/{id}", "DELETE")).hasRole("VENDOR")
                    .requestMatchers(new AntPathRequestMatcher("/contacts/{id}", "GET")).authenticated()
                    .requestMatchers(new AntPathRequestMatcher("/contacts/{id}", "PUT")).authenticated()
                    .requestMatchers(new AntPathRequestMatcher("/vendors/{id}/contacts", "GET")).authenticated()
                    //Phone
                    .requestMatchers(new AntPathRequestMatcher("contacts/{id}/phones", "GET")).authenticated()
                    .requestMatchers(new AntPathRequestMatcher("/contacts/{contactId}/phones", "POST")).hasRole("VENDOR")
                    .requestMatchers(new AntPathRequestMatcher("/phones/{id}", "DELETE")).hasRole("VENDOR")
                    .requestMatchers(new AntPathRequestMatcher("/phones/{id}", "GET")).authenticated()
                    .requestMatchers(new AntPathRequestMatcher("/phones/{id", "PUT")).hasRole("VENDOR")
                    //Product
                    .requestMatchers(new AntPathRequestMatcher("/vendor/{vendorId}/products", "POST")).hasRole("VENDOR")
                    .requestMatchers(new AntPathRequestMatcher("/products/{id}", "GET")).authenticated()
                    .requestMatchers(new AntPathRequestMatcher("/vendor/{id}/products", "GET")).hasRole("VENDOR")
                    .requestMatchers(new AntPathRequestMatcher("/products/{id}", "PUT")).hasRole("VENDOR")
                    .requestMatchers(new AntPathRequestMatcher("/products/{id}/status", "GET")).hasRole("VENDOR")
                    //Vendor
                    .requestMatchers(new AntPathRequestMatcher("/vendors", "POST")).hasRole("ADMIN")
                    .requestMatchers(new AntPathRequestMatcher("/vendors", "GET")).authenticated()
                    .requestMatchers(new AntPathRequestMatcher("/vendors/{id}", "GET")).hasRole("CLEANER")
                    .requestMatchers(new AntPathRequestMatcher("/vendors/{id}", "PUT")).hasRole("VENDOR")
                    .requestMatchers(new AntPathRequestMatcher("/vendors/{id}/status", "PUT")).hasRole("ADMIN")
                    .and()
                .formLogin()
                    .loginPage("/login").failureUrl("/login-error");


    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .inMemoryAuthentication()
                    .withUser("kcadmin").password("pass").roles("ADMIN")
                    .and()
                    .withUser("kccleaner").password("pass").roles("CLEANER")
                    .and()
                    .withUser("kcvendor").password("pass").roles("VENDOR");
    }
}