package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class CommentsList$1
        implements Parcelable.Creator<CommentsList> {
    public CommentsList createFromParcel(Parcel paramParcel) {
        return new CommentsList(paramParcel);
    }

    public CommentsList[] newArray(int paramInt) {
        return new CommentsList[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/CommentsList$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */