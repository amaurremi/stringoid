package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class NewsFeed$1
        implements Parcelable.Creator<NewsFeed> {
    public NewsFeed createFromParcel(Parcel paramParcel) {
        return new NewsFeed(paramParcel);
    }

    public NewsFeed[] newArray(int paramInt) {
        return new NewsFeed[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/NewsFeed$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */