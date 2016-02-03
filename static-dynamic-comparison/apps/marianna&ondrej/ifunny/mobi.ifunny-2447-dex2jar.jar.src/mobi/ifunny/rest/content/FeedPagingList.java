package mobi.ifunny.rest.content;

import android.os.Parcelable;

import java.util.List;

public abstract class FeedPagingList<T extends Parcelable>
        extends Feed<T> {
    public void clear() {
        getPagingList().clear();
    }

    public T getItem(int paramInt) {
        if (getPagingList() == null) {
            return null;
        }
        return (Parcelable) getList().get(paramInt);
    }

    public List<T> getList() {
        if (getPagingList() == null) {
            return null;
        }
        return getPagingList().items;
    }

    public String getNext() {
        if (getPaging() == null) {
            return null;
        }
        return getPaging().cursors.next;
    }

    public Paging getPaging() {
        if (getPagingList() == null) {
            return null;
        }
        return getPagingList().paging;
    }

    public abstract PagingList<T> getPagingList();

    public String getPrev() {
        if (getPaging() == null) {
            return null;
        }
        return getPaging().cursors.prev;
    }

    public boolean hasNext() {
        return (getPaging() != null) && (getPaging().hasNext);
    }

    public boolean hasPrev() {
        return (getPaging() != null) && (getPaging().hasPrev);
    }

    public int size() {
        if (getPagingList() == null) {
            return 0;
        }
        return getList().size();
    }

    public void update(Feed<T> paramFeed) {
        getPagingList().update(paramFeed);
    }

    public void updateNext(Feed<T> paramFeed) {
        getPagingList().updateNext(paramFeed);
    }

    public void updatePrev(Feed<T> paramFeed) {
        getPagingList().updatePrev(paramFeed);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/FeedPagingList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */