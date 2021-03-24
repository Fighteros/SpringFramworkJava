package com.service;

import com.model.Customer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CustomerServices {
    private int cumtoerIdCount = 1;

    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    public Customer addCustomer(Customer customer) {
        customer.setCustomerId(cumtoerIdCount);
        customerList.add(customer);
        customerList.add(customer);
        cumtoerIdCount++;
        return customer;
    }

    public List<Customer> getCustomers() {
        return customerList;
    }

    public Customer getCustomer(int customerId) {
        return customerList.
                stream()
                .filter(c -> c.getCustomerId() == customerId)
                .findFirst()
                .get();
    }

    public Customer updateCustomer(int customerId, Customer customer) {
        customerList
                .stream()
                .forEach(c -> {
                    if (c.getCustomerId() == customerId) {
                        c.setCustomerFirstName(customer.getCustomerFirstName());
                        c.setCustomerLastName(customer.getCustomerLastName());
                        c.setCustomerEmail(customer.getCustomerEmail());
                    }
                });
        return customerList
                .stream()
                .filter(c -> c.getCustomerId() == customerId)
                .findFirst()
                .get();
    }

    public void deleteCustomer(int customerId) {
        customerList.stream()
                .forEach(c -> c.getCustomerId() == customerId) {
            customerList.remove(c);
        }
    }
}
