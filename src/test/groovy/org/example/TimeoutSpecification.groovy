package org.example

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Specification
import spock.lang.Timeout

class TimeoutSpecification extends Specification {

  static Logger LOGGER = LoggerFactory.getLogger(TimeoutSpecification)

  def setup() {
    LOGGER.info "setup -- {}", this
  }

  def cleanup() {
    LOGGER.info "cleanup -- {}", this
  }

  @Timeout(1)
  def "this method will timeout"() {
    LOGGER.info "timeout method -- {}", this

    Thread.sleep 2000

    expect:
    1 == 2
  }
}
