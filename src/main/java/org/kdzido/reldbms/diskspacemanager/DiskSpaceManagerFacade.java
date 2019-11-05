package org.kdzido.reldbms.diskspacemanager;

import org.kdzido.reldbms.shared.annotation.NonThreadSafe;

import java.util.*;

/**
 * The Facade representing the disk space manager subsystem.
 *
 * Provides concept of a page as a unit of data.
 */
@NonThreadSafe
public class DiskSpaceManagerFacade {

    private long pageSeq = 0L;

    private final Map<Long, List<PageId>> fileIdToPageId = new HashMap<>();

    public PageId allocatePageInFile(final Long fileId) {
        // TODO throw on non-existing file
        return appendNewPage(fileId);
    }


    private PageId appendNewPage(final Long fileId) {
        if (fileIdToPageId.get(fileId) == null) {
            fileIdToPageId.put(fileId, new LinkedList<>());
        }

        final PageId nextPageId = nextPageId();
        final List<PageId> pageList = fileIdToPageId.get(fileId);
        pageList.add(nextPageId);

        return nextPageId;
    }

    private PageId nextPageId() {
        return new PageId(++pageSeq);
    }

}
