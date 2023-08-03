package com.example.BankAccountManager;

import com.example.BankAccountManager.Config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class BankAccountManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountManagerApplication.class, args);
	}

}
