package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WebImageList
        extends PagingList<WebImage>
        implements Parcelable {
    public static final Parcelable.Creator<WebImageList> CREATOR = new WebImageList
    .1();

    public WebImageList() {
    }

    public WebImageList(Parcel paramParcel) {
        super(paramParcel);
    }

    public Parcelable.Creator<WebImage> getListParcelCreator() {
        return WebImage.CREATOR;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/WebImageList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */