package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.command.CustomerDto;
import org.academiadecodigo.javabank.converters.CustomerDtoToCustomer;
import org.academiadecodigo.javabank.converters.CustomerToCustomerDto;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerDtoToCustomer customerDtoToCustomer;

    @Autowired
    private CustomerToCustomerDto customerToCustomerDto;

    @RequestMapping(method = RequestMethod.GET, path = {"/list", "/", ""})
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.list());
        return "customer/list";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public ResponseEntity<CustomerDto> addCustomer(@Valid @RequestBody CustomerDto customerDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (customerDto.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Customer customerToSave = customerService.save(customerDtoToCustomer.convert(customerDto));
        return new ResponseEntity<>(customerToCustomerDto.convert(customerToSave), HttpStatus.CREATED);

    }

    @RequestMapping(method = RequestMethod.PUT, path = "/edit/{id}")
    public ResponseEntity<CustomerDto> editCustomer(@Valid @RequestBody CustomerDto customerDto, BindingResult bindingResult,
                                                    @PathVariable Integer id) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (customerService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (customerDto.getId() != id && customerDto.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        customerDto.setId(id);

        Customer customerToSave = customerService.save(customerDtoToCustomer.convert(customerDto));
        return new ResponseEntity<>(customerToCustomerDto.convert(customerToSave), HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<CustomerDto> showCustomer(@PathVariable Integer id) {

        Customer customer = customerService.get(id);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customerToCustomerDto.convert(customer), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public String saveCustomer(@Valid @ModelAttribute("customer") CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
           return "customer/add-update";
        }

        Customer savedCustomer = customerService.save(customerDtoToCustomer.convert(customerDto));

        redirectAttributes.addFlashAttribute("lastAction", "Saved " + savedCustomer.getFirstName() + " " + savedCustomer.getLastName());
        return "redirect:/customer/";

    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Integer id) {

        Customer customer = customerService.get(id);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @ExceptionHandler(Exception.class)
    public void handleAllException(Exception ex) {
        ex.printStackTrace();
    }
}
