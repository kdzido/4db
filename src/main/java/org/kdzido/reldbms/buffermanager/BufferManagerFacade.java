package org.kdzido.reldbms.buffermanager;

import org.kdzido.reldbms.shared.annotation.NonThreadSafe;

/**
 * Reads pages from disk into memory for processing.
 */
@NonThreadSafe
public class BufferManagerFacade {

    public Page fetchPage(long fileId, long rid) {
        return new Page(new byte[] {1, 2, 3});
    }

}
