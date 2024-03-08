package lk.acpt.pharmacy.repo;

import lk.acpt.pharmacy.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    Customer searchCustomerByName(String name);
}
