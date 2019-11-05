package org.kdzido.reldbms.fileandaccessmethods

import spock.lang.Specification

/**
 * @author Krzysztof Dzido {@literal <krzysztof.dzido@gmail.com>}
 */
class FilesAndAccessMethodsFacadeTest extends Specification {


    def "should reject invalid constructor args"() {
        when:
        new FilesAndAccessMethodsFacade(null)
        then:
        thrown(IllegalArgumentException)
    }

}
