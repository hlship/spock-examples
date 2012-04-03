package org.example.sus;

public interface CustomerDAO {

  Customer getById(long id);

  void update(Customer customer);
}
