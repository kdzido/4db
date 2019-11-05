package org.kdzido.reldbms.buffermanager.scanarios

import org.kdzido.reldbms.buffermanager.BufferManagerFacade
import spock.lang.Specification

/**
 * @author Krzysztof Dzido {@literal <krzysztof.dzido@gmail.com>}
 */
class FetchPageWithRecordScenario extends Specification {

    def facade = new BufferManagerFacade()

    def "should fetch page with record"() {
        when:
        def page = facade.fetchPage(1, 1L)
        then:
        page.size() == 3
        page.data() == [1, 2, 3]
    }
}
