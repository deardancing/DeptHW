package com.training.spring.bean;

import org.springframework.stereotype.Component;

/**
 * Date: 10/31/2014
 * Time: 3:32 PM
 *
 * @author assanai.manurat
 */

@Component
public class Humen {
	
	Hello hello;

    private String firstName;

    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    
    public Hello getHello() {
		return hello;
	}

	public void setHello(Hello hello) {
		this.hello = hello;
	}

	
	
	@Override
	public String toString() {
		return "Humen [hello=" + hello + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}

}
