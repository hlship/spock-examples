package org.example.sus

class PaymentProcessor {

  CustomerDAO customerDAO

  def applyPayment(long customerId, BigDecimal amount) {

    Customer customer = customerDAO.getById(customerId)

    if (customer == null)
      throw new IllegalArgumentException("No customer #$customerId")

    customer.accountBalance += amount

    customerDAO.update(customer)
  }

}
