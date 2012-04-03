package org.example

import spock.lang.Specification


class ExampleSpecification extends Specification {

  def "use of extended assert"() {

    expect:
    assert 4 == 5, "Big Brother says there are four fingers"
  }
}
