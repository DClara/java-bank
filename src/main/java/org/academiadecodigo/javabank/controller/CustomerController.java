package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.command.CustomerConverter;
import org.academiadecodigo.javabank.command.CustomerDto;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerConverter customerConverter;

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

        Customer activeCustomer = customerService.findById(id);
        List<Account> customerAccounts = customerService.findById(id).getAccounts();

        model.addAttribute("customer", activeCustomer);
        model.addAttribute("accounts", customerAccounts);

        return "show";
    }

    @RequestMapping(method = RequestMethod.GET, value = "edit/{id}")
    public String editCustomerDetails(Model model, @PathVariable Integer id){

        Customer activeCustomer = customerService.findById(id);

        model.addAttribute("customer", customerConverter.convertToDto(activeCustomer));

        return "newCustomer";
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/add", "/update"})
    public String addCustomer(@Valid @ModelAttribute("customer") CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "newCustomer";
        }

        Customer customer = customerConverter.convertToCustomer(customerDto);

        customerService.save(customer);
        redirectAttributes.addFlashAttribute("add_success", "Customer updated successfully!");

        // Instead of returning a rendered view to the browser,
        // a 302 redirect is sent to the browser, forcing showCustomer()
        // to execute after adding a new user
        return "redirect:/customer/";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/newCustomer")
    public String newCustomer(Model model) {

        Customer customer = new Customer();

        model.addAttribute("customer", customerConverter.convertToDto(customer));
        return "newCustomer";
    }
}

