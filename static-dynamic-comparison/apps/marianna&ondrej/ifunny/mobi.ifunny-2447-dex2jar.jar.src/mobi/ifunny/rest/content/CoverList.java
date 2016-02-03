package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import java.util.ArrayList;
import java.util.List;

public class CoverList
        implements Parcelable {
    public static final Parcelable.Creator<CoverList> CREATOR = new CoverList
    .1();
    public List<Cover> items = new ArrayList();

    public CoverList() {
    }

    public CoverList(Parcel paramParcel) {
        this();
        paramParcel.readTypedList(this.items, Cover.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeTypedList(this.items);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/CoverList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */