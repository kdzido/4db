package org.kdzido.reldbms.fileandaccessmethods;

import org.kdzido.reldbms.buffermanager.BufferManagerFacade;
import org.kdzido.reldbms.shared.annotation.NonThreadSafe;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Provides the fundamental file of records abstraction in for this DBMS.
 *
 * @author Krzysztof Dzido {@literal <krzysztof.dzido@gmail.com>}
 */
@NonThreadSafe
public class FilesAndAccessMethodsFacade {

    private final BufferManagerFacade bufferManager;

    private static long fileIdSeq = 0L;

    private Map<Long, Boolean> filesMap = new HashMap<>();

    public FilesAndAccessMethodsFacade(final BufferManagerFacade bufferManager) {
        checkArgument(bufferManager != null, "BufferManagerFacade cannot be null");
        this.bufferManager = bufferManager;
    }

    /**
     * @param fileId the file ID
     * @param rid    the record ID
     * @return the array of record bytes
     */
    public byte[] findRecordByRid(final long fileId, final long rid) {
        return bufferManager.fetchPage(fileId, rid).data();
    }

    /**
     * Creates a new file
     *
     * @return the new file ID
     */
    public long createFile() {
        final Long id = nextFileId();
        filesMap.put(id, Boolean.TRUE);
        return id;
    }

    /**
     * @param fileId the file ID
     * @return true if a file with the given ID exists
     */
    public boolean fileExists(final long fileId) {
        return Optional.ofNullable(filesMap.get(fileId))
                .orElse(false);
    }

    /**
     * @param fileId the file ID
     */
    public void destroyFile(final long fileId) {
        final boolean fileExists  = Optional.ofNullable(filesMap.get(fileId))
                .orElse(false);

        if (fileExists)  {
            filesMap.remove(fileId);
        }
    }

    private Long nextFileId() {
        return ++fileIdSeq;
    }
}
