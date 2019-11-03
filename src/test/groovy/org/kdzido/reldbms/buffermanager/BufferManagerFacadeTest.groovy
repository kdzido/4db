package org.kdzido.reldbms.buffermanager

import spock.lang.Specification

class BufferManagerFacadeTest extends Specification {

    def facade = new BufferManagerFacade()

    def "should fetch page with record"() {
        when:
        def page = facade.fetchPage(1, 1L)
        then:
        page.size() == 3
        page.data() == [1, 2, 3]
    }
}
