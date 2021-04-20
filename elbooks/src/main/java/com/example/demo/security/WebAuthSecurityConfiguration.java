package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

//https://qiita.com/sukezane/items/93f9155b5a4fa1976247参照のこと
//https://qiita.com/huge-book-storage/items/56b86d2986cf04632706 最小記述で最低限のログイン実装
@Configuration
@EnableWebSecurity //Spring Securityを使うための設定
public class WebAuthSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	UserDetailsServiceImpl service;
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

	/**
	 * セキュリティ設定
	 * @param web
	 * @throws Exception
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		//主に全体に対するセキュリティ設定を行う
		//cssやイメージのファイルには適用しないように設定できる
		//書き方→web.ignoring().antMatchers("/css/**","/js/**","/images/**");
	}

	/**
	 * /セキュリティ設定
	 */

	/**
	 * 権限の設定
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//				.withUser("user")
//				.password(passwordEncoder().encode("password"))
//				.roles("USER");
//		auth.inMemoryAuthentication()
//		.withUser("admin")
//		.password(passwordEncoder().encode("adminpassword"))
//		.roles("ADMIN");
		auth.userDetailsService(service);
		//		auth.userDetailsService(userDetailsService)
		//        .passwordEncoder(passwordEncoder());
		//アプリケーションプロパティでも可能
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				// AUTHORIZE
				.mvcMatchers("/01_admin").permitAll()//”/ページのURL”はアクセスし放題 複数可能
				.mvcMatchers("/admin").hasRole("ADMIN")
				.anyRequest()//なにかリクエストがあれば
				.authenticated()//すべてのページ（上で設定した例外以外）で要認証
		;
		http.formLogin()//フォーム認証の設定を行う。
				//.loginProcessingUrl("/login")//ログイン処理をするURL
			//	.loginPage("/loginFrom")//ログイン画面のURL
			//	.failureUrl("/login?error")//認証失敗時のURL
				.defaultSuccessUrl("/success")//デフォルトではサクセス画面に飛ぶ（URL直打ちだとログイン後にそこにいってくれる）
		//.usernameParameter("email")//ユーザのパラメータ名
		//.passwordParameter("password");//パスワードのパラメータ名
		;
		http.logout()
			//	.logoutUrl("/logout**")//ログアウト時のURL（今回は未実装）
			//	.logoutSuccessUrl("/login")//ログアウト成功時のURL
		// end
		;
	}

}
