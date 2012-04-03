package org.example

import spock.lang.Specification


class InteractionsSpecification extends Specification {

  Operation mock = Mock()

  interface Operation {
    Object op(input)
  }

  def isOdd(input) { input % 2 != 0 }

  def "closure for parameter constraint"() {
    when:
    assert mock.op(3) == 6
    assert mock.op(7) == 14

    then:
    (2..7) * mock.op({ isOdd(it) }) >> { 2 * it }
  }

  def "wrong number of invocations"() {
    when:
    assert mock.op(7) == 14

    then:
    (2..7) * mock.op({ isOdd(it) }) >> { 2 * it }
  }

  def "parameter does not match closure constraint"() {
    when:
    assert mock.op(3) == 6
    assert mock.op(4) == null
    assert mock.op(7) == 14

    then:
    _ * mock.op({ isOdd(it) }) >> { 2 * it }
  }

  def "detecting parameter that doesn't match"() {
    when:
    assert mock.op(3) == 6
    assert mock.op(4) == null
    assert mock.op(7) == 14

    then:
    _ * mock.op({ isOdd(it) }) >> { 2 * it }

    0 * _
  }
}
