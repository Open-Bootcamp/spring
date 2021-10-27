package com.example.springpatterns.patterns.behavioral.chain.processor;

import com.example.springpatterns.patterns.behavioral.chain.AuthenticationProcessor;
import com.example.springpatterns.patterns.behavioral.chain.AuthenticationProvider;
import com.example.springpatterns.patterns.behavioral.chain.provider.OAuthProvider;

public class OAuthAuthenticationProcessor extends AuthenticationProcessor {


    public OAuthAuthenticationProcessor(AuthenticationProcessor next) {
        super(next);
    }

    @Override
    public boolean isAuthorized(AuthenticationProvider provider) {

        // comprobaciones particulares de este processor
        if(provider instanceof OAuthProvider){
            return true;
        }

        // llama al siguiente processor
        return next.isAuthorized(provider);
    }
}
