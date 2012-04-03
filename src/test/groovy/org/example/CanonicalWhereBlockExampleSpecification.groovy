package org.example

import spock.lang.Specification
import spock.lang.Unroll


@Unroll
class CanonicalWhereBlockExampleSpecification extends Specification {

  def "Crew member '#name' length is #length"() {
    expect:
    name.length() == length

    where:
    name     | length
    "Spock"  | 5
    "Kirk"   | 4
    "Scotty" | 6
  }

  def "length of crew member names (using lists)"() {
    expect:
    name.length() == length

    where:
    name << ["Spock", "Kirk", "Scotty"]
    length << [5, 4, 6]
  }

  def "length of crew member names (with derived values)"() {
    expect:
    name.length() == length

    where:
    name << ["Spock", "Kirk", "Scotty"]
    length = name.length()
  }
}
