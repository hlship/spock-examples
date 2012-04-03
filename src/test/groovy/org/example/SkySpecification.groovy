package org.example

import org.example.sus.Sky
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Specification

class SkySpecification extends Specification {

  static Logger LOGGER = LoggerFactory.getLogger(SkySpecification)

  def sky = new Sky()

  def setup() {
    LOGGER.info "setup -- {}", this
  }

  def cleanup() {
    LOGGER.info "cleanup -- {}", this
  }

  def setupSpec() {
    LOGGER.info "setupSpec -- {}", this
  }

  def cleanupSpec() {
    LOGGER.info "cleanupSpec -- {}", this
  }

  def "sky is blue by default"() {
    LOGGER.info "sky is blue -- {}", this
    expect:
    sky.color == "blue"
  }

  def "clouds are grey"() {
    LOGGER.info "clouds are grey -- {}", this

    given: "A fresh Sky"

    when: "A storm system rolls in"
    sky.addStormSystem()

    then: "It all goes grey"
    sky.color == "grey"
  }
}
