package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class MyCommentsList$1
        implements Parcelable.Creator<MyCommentsList> {
    public MyCommentsList createFromParcel(Parcel paramParcel) {
        return new MyCommentsList(paramParcel);
    }

    public MyCommentsList[] newArray(int paramInt) {
        return new MyCommentsList[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/MyCommentsList$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */