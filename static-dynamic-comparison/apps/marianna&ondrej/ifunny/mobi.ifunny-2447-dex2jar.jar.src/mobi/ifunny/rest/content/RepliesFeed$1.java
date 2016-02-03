package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class RepliesFeed$1
        implements Parcelable.Creator<RepliesFeed> {
    public RepliesFeed createFromParcel(Parcel paramParcel) {
        return new RepliesFeed(paramParcel);
    }

    public RepliesFeed[] newArray(int paramInt) {
        return new RepliesFeed[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/RepliesFeed$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */