package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class NewsFeed
        extends FeedPagingList<News>
        implements Parcelable {
    public static final Parcelable.Creator<NewsFeed> CREATOR = new NewsFeed
    .1();
    public NewsList news;

    public NewsFeed() {
        this.news = new NewsList();
    }

    public NewsFeed(Parcel paramParcel) {
        this.news = ((NewsList) paramParcel.readParcelable(NewsList.class.getClassLoader()));
    }

    public NewsFeed copy() {
        NewsFeed localNewsFeed = new NewsFeed();
        localNewsFeed.update(this);
        return localNewsFeed;
    }

    public int describeContents() {
        return 0;
    }

    public PagingList<News> getPagingList() {
        return this.news;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeParcelable(this.news, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/NewsFeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */