package com.roma.candidato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.roma.candidato.modelo.Candidato;
import com.roma.candidato.negocio.repository.*;
@EnableAutoConfiguration
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})

public class RomaApplication {
	public static void main(String[] args) {
		SpringApplication.run(RomaApplication.class, args);
	}
	
	

}
