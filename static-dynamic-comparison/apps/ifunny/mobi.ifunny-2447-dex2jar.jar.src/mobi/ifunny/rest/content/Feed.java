package mobi.ifunny.rest.content;

import android.os.Parcelable;

import java.util.List;

public abstract class Feed
        implements Parcelable {
    public abstract void clear();

    public abstract T getItem(int paramInt);

    public abstract List<T> getList();

    public abstract String getNext();

    public abstract Paging getPaging();

    public abstract String getPrev();

    public abstract boolean hasNext();

    public abstract boolean hasPrev();

    public abstract int size();

    public abstract void update(Feed<T> paramFeed);

    public abstract void updateNext(Feed<T> paramFeed);

    public abstract void updatePrev(Feed<T> paramFeed);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/Feed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */