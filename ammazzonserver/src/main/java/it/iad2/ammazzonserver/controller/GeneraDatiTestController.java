/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.iad2.ammazzonserver.controller;

import it.iad2.ammazzonserver.service.GeneraDatiTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author matte
 */
@CrossOrigin("*")
@RestController
public class GeneraDatiTestController {
    @Autowired
    GeneraDatiTestService generaDatiTestService;
    
    @RequestMapping("/genera-dati-test")
    public void generaDatiTest(){
    generaDatiTestService.generaDatiTest();}
}
