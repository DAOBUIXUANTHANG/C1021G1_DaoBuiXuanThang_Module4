package vn.codegym.repository.impl;

import org.springframework.stereotype.Repository;
import vn.codegym.model.Customer;
import vn.codegym.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    private static List<Customer> customerList;

    static {
        customerList = new ArrayList<>();
        customerList.add(new Customer(1, "Nguyen Van A", "NguyenVanA@gmail.com", "NinhBinh"));
        customerList.add(new Customer(2, "Tran Van B", "tranvanb@gmail.com", "DaNang"));
        customerList.add(new Customer(3, "Tran Van B1", "tranvanb1@gmail.com", "NinhBinh"));
        customerList.add(new Customer(4, "Tran Van B2", "tranvanb2@gmail.com", "NinhBinh"));
        customerList.add(new Customer(5, "Tran Van B3", "tranvanb3@gmail.com", "NinhBinh"));
        customerList.add(new Customer(6, "Tran Van B4", "tranvanb4@gmail.com", "NinhBinh"));
        customerList.add(new Customer(7, "Tran Van B5", "tranvanb5@gmail.com", "NinhBinh"));
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public List<Customer> findOne(int id) {
        List<Customer> customers = new ArrayList<>();
        for (Customer customer : customerList) {
            if (id == customer.getId()) {
                customers.add(customer);
            }
        }
        return customers;
    }

    @Override
    public void updateCustomer(Customer customer) {
        for(int i=0;i<customerList.size();i++){
            if (customerList.get(i).getId() == customer.getId()) {
                customerList.get(i).setId(customer.getId());
                customerList.get(i).setName(customer.getName());
                customerList.get(i).setEmail(customer.getEmail());
                customerList.get(i).setAddress(customer.getAddress());
            }
        }
    }

    @Override
    public void deleteCustomer(int id) {

    }
}

