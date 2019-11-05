package org.kdzido.reldbms.fileandaccessmethods.scenarios

import org.kdzido.reldbms.buffermanager.BufferManagerFacade
import org.kdzido.reldbms.fileandaccessmethods.FilesAndAccessMethodsFacade
import spock.lang.Specification

/**
 * @author Krzysztof Dzido {@literal <krzysztof.dzido@gmail.com>}
 */
class CreateFileOfRecordsScenario extends Specification {

    def bufferManagerMock = Mock(BufferManagerFacade)

    def facade = new FilesAndAccessMethodsFacade(bufferManagerMock)

    def "should create a new file of records"() {
        when:
        long fileId = facade.createFile()
        then:
        fileId ==  1
    }

    def "should check if file exists"() {
        when:
        long fileId = facade.createFile()
        then:
        facade.fileExists(fileId) == true
    }

}
