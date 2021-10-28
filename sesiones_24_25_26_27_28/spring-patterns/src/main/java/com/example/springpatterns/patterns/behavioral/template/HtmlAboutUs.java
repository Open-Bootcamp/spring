package com.example.springpatterns.patterns.behavioral.template;

// tipo concreto
public class HtmlAboutUs extends HtmlTemplate{
    @Override
    public String head() {
        return """
                <!DOCTYPE html>
                <html lang="en" xmlns:th="http://www.thymeleaf.org">
                <head>
                    <meta charset="UTF-8">
                    <title>Nuestro equipo</title>
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
                </head><body>
                """;
    }

    @Override
    public String body() {
        return """
                <h1> Hola desde Página Nosotros </h1>
                """;
    }

}
