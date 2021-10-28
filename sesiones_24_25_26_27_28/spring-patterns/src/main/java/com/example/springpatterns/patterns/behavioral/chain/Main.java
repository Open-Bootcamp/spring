package com.example.springpatterns.patterns.behavioral.chain;

import com.example.springpatterns.patterns.behavioral.chain.processor.CSRFAuthenticationProcessor;
import com.example.springpatterns.patterns.behavioral.chain.processor.JWTAuthenticationProcessor;
import com.example.springpatterns.patterns.behavioral.chain.processor.OAuthAuthenticationProcessor;
import com.example.springpatterns.patterns.behavioral.chain.provider.CSRFProvider;
import com.example.springpatterns.patterns.behavioral.chain.provider.JWTAuthProvider;
import com.example.springpatterns.patterns.behavioral.chain.provider.OAuthProvider;

public class Main {

    public static void main(String[] args) {

        AuthenticationProcessor jwt = new JWTAuthenticationProcessor(null);
        AuthenticationProcessor oauth = new OAuthAuthenticationProcessor(jwt);
        AuthenticationProcessor csrf = new CSRFAuthenticationProcessor(oauth);

        csrf.isAuthorized(new CSRFProvider());
        csrf.isAuthorized(new JWTAuthProvider());
        csrf.isAuthorized(new OAuthProvider());

    }
}
