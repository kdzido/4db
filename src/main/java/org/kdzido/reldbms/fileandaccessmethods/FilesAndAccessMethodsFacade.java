package org.kdzido.reldbms.fileandaccessmethods;

import org.kdzido.reldbms.buffermanager.BufferManagerFacade;

/**
 * Provides the fundamental file of records abstraction in for this DBMS.
 */
public class FilesAndAccessMethodsFacade {

    private final BufferManagerFacade bufferManager;

    public FilesAndAccessMethodsFacade(final BufferManagerFacade bufferManager) {

        this.bufferManager = bufferManager;
    }

    /**
     * @param fileId the file ID
     * @param rid the record ID
     * @return the array of record bytes
     */
    public byte[] findRecordByRid(int fileId, long rid) {
        return bufferManager.fetchPage(fileId, rid).data();
    }
}
