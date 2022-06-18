package com.myshoppingcart.currencyconverter.web;

import com.myshoppingcart.currencyconverter.entities.*;
import com.myshoppingcart.currencyconverter.services.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forex-rate")
@Slf4j
public class ForexRateController {
    @Autowired
    private ForexRateService forexRateService;

//    @PostMapping("/")
//    public ForexRate saveForexRate(@RequestBody ForexRate department) {
//        log.info("Inside saveDepartment method of DepartmentController");
//        return  forexRateService.saveDepartment(department);
//    }
//
//    @GetMapping("/")
//    public List< ForexRate > getAllEmployees() {
//        return forexRateService.findAll();
//    }

//    @GetMapping("/{id}")
//    public Department findDepartmentById(@PathVariable("id") Long departmentId) {
//        log.info("Inside findDepartmentById method of DepartmentController");
//        return departmentService.findDepartmentById(departmentId);
//    }
}
