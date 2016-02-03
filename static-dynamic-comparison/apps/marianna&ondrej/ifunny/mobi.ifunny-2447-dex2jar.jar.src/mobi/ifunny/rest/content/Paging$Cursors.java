package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Paging$Cursors
        implements Parcelable {
    public static final Parcelable.Creator<Cursors> CREATOR = new Paging.Cursors
    .1();
    public String next;
    public String prev;

    public Paging$Cursors() {
    }

    public Paging$Cursors(Parcel paramParcel) {
        this.next = paramParcel.readString();
        this.prev = paramParcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.next);
        paramParcel.writeString(this.prev);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/Paging$Cursors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */