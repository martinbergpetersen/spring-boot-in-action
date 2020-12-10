package com.springbootinaction.book.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import com.springbootinaction.book.config.ApplicationProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private Environment env;

    @GetMapping("/name")
    public String name() {
        return applicationProperties.getName();
    }
    @GetMapping("/version")
    public String version() {
        return applicationProperties.getVersion();
    }

    @GetMapping("/title")
    public String title() {
        return applicationProperties.getTitle();
    }

    @GetMapping("/env")
    public String env() {
        return applicationProperties.getEnv();
    }

    @GetMapping("/info")
    public Map<String, String> info(){
        var info = new LinkedHashMap<String, String>();
        info.put("name", env.getProperty("application.name"));
        info.put("version", env.getProperty("application.version"));
        info.put("title", env.getProperty("application.title"));
        info.put("env", env.getProperty("application.env"));
        return info;
    }

}


