package org.kdzido.reldbms.fileandaccessmethods

import org.kdzido.reldbms.buffermanager.BufferManagerFacade
import org.kdzido.reldbms.buffermanager.Page
import spock.lang.Specification

class FilesAndAccessMethodsFacadeTest extends Specification {

    def bufferManagerMock = Mock(BufferManagerFacade)

    def facade = new FilesAndAccessMethodsFacade(bufferManagerMock)

    def "should find record"() {
        def record = [1, 2, 3]
        when:
        def data = facade.findRecordByRid(1, 1L)
        then:
        1 * bufferManagerMock.fetchPage(1, 1L) >> new Page(record as byte[])
        data == record
    }

}
