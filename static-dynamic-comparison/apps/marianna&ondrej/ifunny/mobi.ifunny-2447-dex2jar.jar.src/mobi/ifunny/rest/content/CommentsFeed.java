package mobi.ifunny.rest.content;

import android.os.Parcelable;

public abstract class CommentsFeed<C extends Comment>
        extends FeedPagingList<C>
        implements Parcelable {
    public abstract int getExhibitCommentsCount();

    public abstract void setExhibitCommentsCount(int paramInt);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/CommentsFeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */