package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SearchResponse$SearchCounters
        implements Parcelable {
    public static final Parcelable.Creator<SearchCounters> CREATOR = new SearchResponse.SearchCounters
    .1();
    public int content;
    public int users;

    public SearchResponse$SearchCounters() {
    }

    public SearchResponse$SearchCounters(Parcel paramParcel) {
        this.users = paramParcel.readInt();
        this.content = paramParcel.readInt();
    }

    public SearchResponse$SearchCounters(SearchCounters paramSearchCounters) {
        this.users = paramSearchCounters.users;
        this.content = paramSearchCounters.content;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeInt(this.users);
        paramParcel.writeInt(this.content);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/SearchResponse$SearchCounters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */