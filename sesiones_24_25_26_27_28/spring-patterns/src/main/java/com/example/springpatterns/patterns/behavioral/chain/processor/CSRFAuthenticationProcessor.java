package com.example.springpatterns.patterns.behavioral.chain.processor;

import com.example.springpatterns.patterns.behavioral.chain.AuthenticationProcessor;
import com.example.springpatterns.patterns.behavioral.chain.AuthenticationProvider;
import com.example.springpatterns.patterns.behavioral.chain.provider.CSRFProvider;

public class CSRFAuthenticationProcessor extends AuthenticationProcessor {
    public CSRFAuthenticationProcessor(AuthenticationProcessor next) {
        super(next);
    }

    @Override
    public boolean isAuthorized(AuthenticationProvider provider) {
        // ... codigo
        if(provider instanceof CSRFProvider)
            return true;
        //
        return next.isAuthorized(provider);
    }
}
