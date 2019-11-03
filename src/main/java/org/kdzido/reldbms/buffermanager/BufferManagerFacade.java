package org.kdzido.reldbms.buffermanager;

/**
 * Reads pages from disk into memory for processing.
 */
public class BufferManagerFacade {

    public Page fetchPage(int fileId, long rid) {
        return new Page(new byte[] {1, 2, 3});
    }

}
