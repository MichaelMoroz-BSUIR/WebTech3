package com.MichaelMoroz.server.service;

public class ServiceFactory {
    private static final ServiceFactory INSTANCE = new ServiceFactory();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return INSTANCE;
    }

    public AuthenticationService getAuthService() {
        return AuthenticationService.getInstance();
    }

    public CaseService getCaseService() {
        return CaseService.getInstance();
    }
}