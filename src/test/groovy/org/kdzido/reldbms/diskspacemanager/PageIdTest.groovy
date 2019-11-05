package org.kdzido.reldbms.diskspacemanager

import spock.lang.Specification

class PageIdTest extends Specification {

    def "should create page ID"() {
        expect:
        new PageId(pageId).pageIdAsLong() == expectedIdAsLong

        where:
        pageId | expectedIdAsLong
        1      | 1
        0      | 0
        -1     | -1
    }

    def "should check equality by value"() {
        when:
        def a = new PageId(1)
        def b = new PageId(pageId)

        then:
        sameHash == a.equals(b)
        sameHash == (a.hashCode() == b.hashCode())

        where:
        pageId | sameEquals | sameHash
        1      | true       | true
        0      | false      | false
        -1     | false      | false
    }
}
