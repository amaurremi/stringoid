package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class MemeSourcesFeed
        extends FeedPagingList<MemeSource> {
    public static final Parcelable.Creator<MemeSourcesFeed> CREATOR = new MemeSourcesFeed
    .1();
    private MemeSourcesList sources;

    public MemeSourcesFeed() {
        this.sources = new MemeSourcesList();
    }

    public MemeSourcesFeed(Parcel paramParcel) {
        this.sources = ((MemeSourcesList) paramParcel.readParcelable(MemeSourcesList.class.getClassLoader()));
    }

    public MemeSourcesFeed copy() {
        MemeSourcesFeed localMemeSourcesFeed = new MemeSourcesFeed();
        localMemeSourcesFeed.update(this);
        return localMemeSourcesFeed;
    }

    public int describeContents() {
        return 0;
    }

    public PagingList<MemeSource> getPagingList() {
        return this.sources;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeParcelable(this.sources, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/MemeSourcesFeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */