package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class WebImage$1
        implements Parcelable.Creator<WebImage> {
    public WebImage createFromParcel(Parcel paramParcel) {
        return new WebImage(paramParcel, null);
    }

    public WebImage[] newArray(int paramInt) {
        return new WebImage[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/WebImage$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */