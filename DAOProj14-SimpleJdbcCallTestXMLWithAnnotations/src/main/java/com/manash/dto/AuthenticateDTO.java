package com.manash.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AuthenticateDTO implements Serializable {
	private String usern;
	private String pwd;

}
