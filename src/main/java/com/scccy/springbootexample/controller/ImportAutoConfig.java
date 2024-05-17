package com.scccy.springbootexample.controller;

import com.scccy.springbootexample.test.autoConfig.ImportProBean;
import com.scccy.springbootexample.test.autoConfig.ImportProBean01;
import com.scccy.springbootexample.test.autoConfig.ImportProBean02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autoconfig")
public class ImportAutoConfig {
    @GetMapping("/test01")
    public String test01(){
        return ImportProBean.AGE.toString();
    }

    @Autowired
    ImportProBean01 importProBean01;
    @GetMapping("/test02")
    public String test02(){
       return importProBean01.getId().toString();
    }
    @Autowired
    ImportProBean02 importProBean02;
    @GetMapping("/test03")
    public String test03(){
        return importProBean02.getId().toString();
    }
}
