package org.example

import org.example.sus.Customer
import org.example.sus.CustomerDAO
import org.example.sus.PaymentProcessor
import spock.lang.Specification

class ApplyPaymentSpecification extends Specification {

  CustomerDAO dao = Mock()
  PaymentProcessor processor

  def setup() {
    processor = new PaymentProcessor(customerDAO: dao)
  }

  def "unknown customer id is an exception"() {

    when:
    processor.applyPayment(12345, 100)

    then:
    1 * dao.getById(12345) >> null

    IllegalArgumentException e = thrown()

    e.message == "No customer #12345"
  }

  def "valid customer id for update"() {
    when:
    processor.applyPayment(customer.id, 200)

    then:
    1 * dao.getById(customer.id) >> customer
    1 * dao.update(customer)

    customer.accountBalance == 500

    where:
    customer = new Customer(id: 98765, accountBalance: 300)
  }
}
