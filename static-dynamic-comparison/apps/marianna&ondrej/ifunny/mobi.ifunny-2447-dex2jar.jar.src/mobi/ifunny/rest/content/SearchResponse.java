package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SearchResponse
        extends IFunnyFeed
        implements Parcelable {
    public static final String CONTENT_TYPE = "content";
    public static final Parcelable.Creator<SearchResponse> CREATOR = new SearchResponse
    .1();
    public static final String USERS_TYPE = "users";
    public SearchResponse.SearchCounters num;

    public SearchResponse() {
    }

    public SearchResponse(Parcel paramParcel) {
        super(paramParcel);
        this.num = ((SearchResponse.SearchCounters) paramParcel.readParcelable(SearchResponse.SearchCounters.class.getClassLoader()));
    }

    public SearchResponse copy() {
        SearchResponse localSearchResponse = new SearchResponse();
        localSearchResponse.update(this);
        localSearchResponse.num = new SearchResponse.SearchCounters(this.num);
        return localSearchResponse;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        super.writeToParcel(paramParcel, paramInt);
        paramParcel.writeParcelable(this.num, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/SearchResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */