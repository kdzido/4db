package org.kdzido.reldbms.buffermanager

import spock.lang.Specification

/**
 * @author Krzysztof Dzido {@literal <krzysztof.dzido@gmail.com>}
 */
class PageTest extends Specification {

    def "should create empty page"() {
        when:
        def page = new Page([] as byte[])
        then:
        page.size() == 0
        page.data().size() == 0
    }

    def "should create full page"() {
        when:
        def page = new Page([1] * Page.PAGE_SIZE as byte[])
        then:
        page.size() == Page.PAGE_SIZE
        page.data().size() == Page.PAGE_SIZE
    }

    def "should reject null data"() {
        when:
        new Page(null)
        then:
        thrown(IllegalArgumentException)
    }

    def "should reject data exceeding page size"() {
        when:
        new Page([1] * (Page.PAGE_SIZE + 1) as byte[])
        then:
        thrown(IllegalArgumentException)
    }
}
