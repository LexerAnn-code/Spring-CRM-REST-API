package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.ErrorResponse.ErrorExceptionCustomer;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    @Autowired
   private CustomerService customerService;
@GetMapping("/customers")
    public List<Customer> getCustomers(){
    return customerService.getCustomers();
}
@GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable int id){
    Customer customer=customerService.getCustomer(id);
    if(customer==null){
        throw new ErrorExceptionCustomer("STUDENT NOT FOUND");
    }
    return customerService.getCustomer(id);
}
@PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer){
    theCustomer.setId(0);
    customerService.saveCustomer(theCustomer);
    return theCustomer;
}
@PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer theCustomer){
    customerService.saveCustomer(theCustomer);
    return  theCustomer;
}

}
