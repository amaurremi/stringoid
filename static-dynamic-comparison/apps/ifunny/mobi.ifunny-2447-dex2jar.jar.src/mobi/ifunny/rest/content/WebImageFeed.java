package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class WebImageFeed
        extends FeedPagingList<WebImage> {
    public static final Parcelable.Creator<WebImageFeed> CREATOR = new WebImageFeed
    .1();
    private WebImageList images;

    public WebImageFeed() {
        this.images = new WebImageList();
    }

    public WebImageFeed(Parcel paramParcel) {
        this.images = ((WebImageList) paramParcel.readParcelable(WebImageList.class.getClassLoader()));
    }

    public WebImageFeed copy() {
        WebImageFeed localWebImageFeed = new WebImageFeed();
        localWebImageFeed.update(this);
        return localWebImageFeed;
    }

    public int describeContents() {
        return 0;
    }

    public PagingList<WebImage> getPagingList() {
        return this.images;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeParcelable(this.images, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/WebImageFeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */