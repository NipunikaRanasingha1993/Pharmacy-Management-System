package lk.acpt.pharmacy.service;

import lk.acpt.pharmacy.dto.CustomerDto;
import lk.acpt.pharmacy.entity.Customer;
import lk.acpt.pharmacy.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo){
        this.customerRepo = customerRepo;
    }

    public Customer saveCustomer(CustomerDto customerDto){
        return customerRepo.save(new Customer(customerDto.getName(),customerDto.getAddress(),customerDto.getSalary()));
    }

    public List<Customer> getAllCustomer(){
        return customerRepo.findAll();
    }

    public String deleteCustomer(Integer id){
        if (customerRepo.existsById(id)){
            customerRepo.deleteById(id);
            return "customer deleted.....";
        }
        return "no found customer...";
    }

    public Customer updateCustomer(Integer id,CustomerDto customerDto){
        if (customerRepo.existsById(id)){
            return customerRepo.save(new Customer(id,customerDto.getName(),customerDto.getAddress(),customerDto.getSalary()));
        }
        return null;
    }

    public Customer searchCustomerById(Integer id){
        Optional<Customer> byId = customerRepo.findById(id);
        return byId.orElse(null);
    }

    public Customer searchCustomerByName(String name){
        return customerRepo.searchCustomerByName(name);
    }

}
