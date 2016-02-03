package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class WebImageFeed$1
        implements Parcelable.Creator<WebImageFeed> {
    public WebImageFeed createFromParcel(Parcel paramParcel) {
        return new WebImageFeed(paramParcel);
    }

    public WebImageFeed[] newArray(int paramInt) {
        return new WebImageFeed[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/WebImageFeed$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */