package org.example


class SubSpecificationA extends BaseSpecification {

  def "subA feature method"() {
    println "$this: subA feature method"

    expect:
    1 == 1
  }
}
