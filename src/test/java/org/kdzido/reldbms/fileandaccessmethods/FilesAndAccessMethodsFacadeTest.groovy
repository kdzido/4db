package org.kdzido.reldbms.fileandaccessmethods

import spock.lang.Specification

class FilesAndAccessMethodsFacadeTest extends Specification {

    def facade = new FilesAndAccessMethodsFacade()

    def "should insert new record"() {
        def record = [1, 2, 3]
        when:
        def newRid = facade.insertRecord(record)
        then:
        facade.findRecordByRid(newRid) == record
    }

}
