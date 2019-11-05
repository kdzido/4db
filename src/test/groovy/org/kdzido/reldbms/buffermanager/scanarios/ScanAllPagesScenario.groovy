package org.kdzido.reldbms.buffermanager.scanarios

import spock.lang.Specification

/**
 * @author Krzysztof Dzido {@literal <krzysztof.dzido@gmail.com>}
 */
class ScanAllPagesScenario extends Specification {

    def "should scan all pages"() {
        given: "1 000 000 page file"
        and: "1 000 page buffer pool"

        when: "I scan all pages"
        false
        then: "all pages are traversed"
        false
    }
}
