package org.kdzido.reldbms.fileandaccessmethods.scenarios

import org.kdzido.reldbms.buffermanager.BufferManagerFacade
import org.kdzido.reldbms.buffermanager.Page
import org.kdzido.reldbms.fileandaccessmethods.FilesAndAccessMethodsFacade
import spock.lang.Specification

/**
 * @author Krzysztof Dzido {@literal <krzysztof.dzido@gmail.com>}
 */
class FindRecordScenario extends Specification {

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
