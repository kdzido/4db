package org.kdzido.reldbms.fileandaccessmethods.scenarios

import org.kdzido.reldbms.buffermanager.BufferManagerFacade
import org.kdzido.reldbms.fileandaccessmethods.FilesAndAccessMethodsFacade
import spock.lang.Specification

/**
 * @author Krzysztof Dzido {@literal <krzysztof.dzido@gmail.com>}
 */
class DestroyFileOfRecordsScenario extends Specification {

    def bufferManagerMock = Mock(BufferManagerFacade)

    def facade = new FilesAndAccessMethodsFacade(bufferManagerMock)

    def "should destroy file"() {
        when:
        long fileId = facade.createFile()
        then:
        facade.fileExists(fileId) == true

        when:
        facade.destroyFile(fileId)
        then:
        facade.fileExists(fileId) == false
    }

}
