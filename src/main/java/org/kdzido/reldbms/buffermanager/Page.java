package org.kdzido.reldbms.buffermanager;

import java.util.Arrays;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * @author Krzysztof Dzido {@literal <krzysztof.dzido@gmail.com>}
 */
public final class Page {
    static final int PAGE_SIZE = 8 * 1024;

    private byte[] data;

    public Page() {
        this.data = new byte[0];
    }

    public Page(final byte[] data) {
        checkArgument(data != null, "Page date cannot be null");
        checkArgument(data.length <= PAGE_SIZE, "Page size cannot be exceeded");
        this.data = Arrays.copyOf(data, data.length);
    }

    public byte[] data() {
        return data;
    }

    public int size() {
        return data.length;
    }
}
