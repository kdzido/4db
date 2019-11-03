package org.kdzido.reldbms.fileandaccessmethods;

/**
 * Provides the fundamental file of records abstraction in for this DBMS.
 */
public final class FilesAndAccessMethodsFacade {

    /**
     * @param record the array of record byte contents
     * @return the new record ID
     */
    public long insertRecord(byte[] record) {
        return 1L;
    }

    /**
     * @param rid the record ID
     * @return the array of record bytes
     */
    public byte[] findRecordByRid(long rid) {
        return new byte[] {1,2,3};
    }
}
