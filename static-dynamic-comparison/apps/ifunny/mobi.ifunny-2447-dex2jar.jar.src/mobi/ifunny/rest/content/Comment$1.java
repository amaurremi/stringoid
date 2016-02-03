package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class Comment$1
        implements Parcelable.Creator<Comment> {
    public Comment createFromParcel(Parcel paramParcel) {
        return new Comment(paramParcel);
    }

    public Comment[] newArray(int paramInt) {
        return new Comment[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/Comment$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */