package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class IFunnyFeed
        extends FeedPagingList<IFunny> {
    public static final Parcelable.Creator<IFunnyFeed> CREATOR = new IFunnyFeed
    .1();
    private IFunnyList content;

    public IFunnyFeed() {
        this.content = new IFunnyList();
    }

    public IFunnyFeed(Parcel paramParcel) {
        this.content = ((IFunnyList) paramParcel.readParcelable(IFunnyList.class.getClassLoader()));
    }

    public IFunnyFeed copy() {
        IFunnyFeed localIFunnyFeed = new IFunnyFeed();
        localIFunnyFeed.update(this);
        return localIFunnyFeed;
    }

    public int describeContents() {
        return 0;
    }

    public IFunnyList getContent() {
        return this.content;
    }

    public PagingList<IFunny> getPagingList() {
        return this.content;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeParcelable(this.content, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/IFunnyFeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */