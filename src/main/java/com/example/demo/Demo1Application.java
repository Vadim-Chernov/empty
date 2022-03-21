package com.example.demo;

import com.example.demo.services.PDFConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@SpringBootApplication
public class Demo1Application {
    @Autowired
    private PDFConvertor convertor;

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    /**
     * создаем PDF файл.
     * Параметр - str
     * Имя файла - значение переменно str + .pdf
     * Содержимрое файла - значение переменно str.
     */
    @Bean
    RouterFunction<ServerResponse> strToPdf() {
        return route(GET("/pdf/{str}"), request -> ok().body(fromValue("Convert STR : "
                + convertor.convert(request.pathVariable("str")))));
    }
}
