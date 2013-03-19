package org.example

import spock.lang.Specification

/** Base specification class, to help determine the order of calls to setupSpec()/cleanupSpec() across subclasses. */
abstract class BaseSpecification extends Specification {

  def setupSpec() {
    println "$this: setupSpec()"
  }

  def cleanupSpec() {
    println "$this: cleanupSpec()"
  }
}
