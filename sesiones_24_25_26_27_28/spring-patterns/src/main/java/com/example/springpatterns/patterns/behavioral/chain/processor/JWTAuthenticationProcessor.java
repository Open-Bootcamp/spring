package com.example.springpatterns.patterns.behavioral.chain.processor;

import com.example.springpatterns.patterns.behavioral.chain.AuthenticationProcessor;
import com.example.springpatterns.patterns.behavioral.chain.AuthenticationProvider;
import com.example.springpatterns.patterns.behavioral.chain.provider.JWTAuthProvider;

public class JWTAuthenticationProcessor extends AuthenticationProcessor {
    public JWTAuthenticationProcessor(AuthenticationProcessor next) {
        super(next);
    }

    @Override
    public boolean isAuthorized(AuthenticationProvider provider) {

        if(provider instanceof JWTAuthProvider)
            return true;

        return next.isAuthorized(provider);
    }
}
