package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class News$1
        implements Parcelable.Creator<News> {
    public News createFromParcel(Parcel paramParcel) {
        return new News(paramParcel);
    }

    public News[] newArray(int paramInt) {
        return new News[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/News$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */