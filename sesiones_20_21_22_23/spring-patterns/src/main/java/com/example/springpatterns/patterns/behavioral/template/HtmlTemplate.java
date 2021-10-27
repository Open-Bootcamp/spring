package com.example.springpatterns.patterns.behavioral.template;

// tipo abstracto
public abstract class HtmlTemplate {

    public String render(){

        // return head() + body() + footer();

        return String.format("""
                %s
                %s
                %s
                """, head(), body(), footer());
    }

    public abstract String head();
    public abstract String body();

    public String footer(){
        return """
                <footer>
                    Copyright 2021
                </footer> </body></html>
                """;
    };
}
