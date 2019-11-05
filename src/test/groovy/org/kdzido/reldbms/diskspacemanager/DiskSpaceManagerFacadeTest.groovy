package org.kdzido.reldbms.diskspacemanager

import spock.lang.Specification

class DiskSpaceManagerFacadeTest extends Specification {

    def facade = new DiskSpaceManagerFacade()

    def "should allocate a page in a file"() {
        when:
        PageId ref = facade.allocatePageInFile(123)
        then:
        ref.pageIdAsLong() == 1
    }

    def "should allocate two pages within same file"() {
        when:
        PageId pageA = facade.allocatePageInFile(123)
        PageId pageB = facade.allocatePageInFile(123)
        then:
        pageA != pageB
    }

    def "should allocate two pages within two files"() {
        when:
        PageId pageA = facade.allocatePageInFile(111)
        PageId pageB = facade.allocatePageInFile(122)
        then:
        pageA != pageB  // no guarantee if pages are only unique within a single file
    }


    def "should deallocate the page"() {
        expect:
        false
    }

    def "should read a page"() {
        expect:
        false
    }

    def "should write a page"() {
        expect:
        false
    }
}
