package com.basics.tests.specific_patterns.builder;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserBuilder {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
