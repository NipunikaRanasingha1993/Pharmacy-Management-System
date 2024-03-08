package lk.acpt.pharmacy.controller;

import lk.acpt.pharmacy.dto.CustomerDto;
import lk.acpt.pharmacy.entity.Customer;
import lk.acpt.pharmacy.repo.CustomerRepo;
import lk.acpt.pharmacy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {

        this.customerService = customerService;
    }
    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody CustomerDto customer){
        Customer cus = customerService.saveCustomer(customer);
        return new ResponseEntity<>(cus, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Customer>> getCustomer(){
        List<Customer> all = customerService.getAllCustomer();
        return new ResponseEntity<>(all,HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer customerId){
        String output = customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(output,HttpStatus.CREATED);
    }
    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer customerId,@RequestBody CustomerDto customerDto){
        Customer customer = customerService.updateCustomer(customerId, customerDto);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }
    @GetMapping("/search_customer_by_id/{customerId}")
     public ResponseEntity<Customer> searchCustomerById(@PathVariable Integer customerId){
         Customer customer = customerService.searchCustomerById(customerId);
         return new ResponseEntity<>(customer,HttpStatus.OK);

     }

     @GetMapping("/search_customer_by_name/{customerName}")
     public ResponseEntity<Customer> searchCustomerByName(@PathVariable String customerName){
         Customer customer = customerService.searchCustomerByName(customerName);
         return new ResponseEntity<>(customer,HttpStatus.OK);


     }






}
