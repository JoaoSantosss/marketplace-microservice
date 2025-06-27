package com.marketplace.user.data.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserForm {
	
	private String email;
	private String name;
	private String password;

}
