package com.MichaelMoroz.server.service;

import com.MichaelMoroz.server.model.AuthType;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationService {
    private static final AuthenticationService INSTANCE = new AuthenticationService();

    private final Map<Object, AuthType> users;

    private AuthenticationService() {
        users = new HashMap<>();
    }

    public static AuthenticationService getInstance() {
        return INSTANCE;
    }

    public AuthType getAuthType(Object user) {
        if (!users.containsKey(user)) {
            users.put(user, AuthType.UNAUTH);
        }

        return users.get(user);
    }

    public void setAuthType(Object user, AuthType type) {
        users.put(user, type);
    }
}