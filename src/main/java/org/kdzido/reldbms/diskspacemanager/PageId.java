package org.kdzido.reldbms.diskspacemanager;

import com.google.common.base.Objects;

/**
 * Value Object representing unique page ID within a file.
 *
 * @author Krzysztof Dzido {@literal <krzysztof.dzido@gmail.com>}
 */
public final class PageId {

    private final long pageId;

    public PageId(final long pageId) {
        this.pageId = pageId;
    }

    public long pageIdAsLong() {
        return pageId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PageId{");
        sb.append("pageId=").append(pageId);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageId pageId1 = (PageId) o;
        return pageId == pageId1.pageId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(pageId);
    }
}
