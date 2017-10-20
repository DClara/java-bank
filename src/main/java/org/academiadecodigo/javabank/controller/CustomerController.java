package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    // Map the URL/Verb to the method
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String showAll(Model model) {


            // Add an attribute to the request
            model.addAttribute("customers", customerService.findAll());

            // Return the view name
            return "customer";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/delete/{id}")
    public String deleteClient(@PathVariable Integer id) {
        customerService.delete(id);
        return "redirect:/customer/";
    }


    @RequestMapping(method = RequestMethod.GET, value = "show/{id}")
    public String showCustomerDetails(Model model, @PathVariable Integer id){

        Customer c1 = customerService.findById(id);

        model.addAttribute("customer", c1);
        model.addAttribute("accounts", customerService.getCustomerAccountIds(c1.getId()));

        return "details";
    }
}

