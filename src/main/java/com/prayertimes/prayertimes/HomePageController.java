/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prayertimes.prayertimes;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author fatih
 */
@Controller
public class HomePageController {

    private List<City> cities = new ArrayList<>();

    @Autowired
    GenericDaoImp<City> citydao;

    @RequestMapping("/")

    public String printHello(ModelMap model) {
        citydao.setType(City.class);
        cities = citydao.findByName("name");
        //System.out.print("deneme");
        model.addAttribute("cities", cities);
        return "fatih";
    }

    @RequestMapping(value = "/home/deneme", method = RequestMethod.POST)
    /*public @ResponseBody String search(HttpServletRequest request, @RequestParam("keyword") String  keyword) {*/
    public @ResponseBody
    List<String> search(HttpServletRequest request) {
        System.out.print(request.getParameter("keyword"));
        return new ArrayList<String>() {
            {
                add("Bursa");
                add("Istanbul");
                add("BsAnkara");
            }
        };
    }

}
