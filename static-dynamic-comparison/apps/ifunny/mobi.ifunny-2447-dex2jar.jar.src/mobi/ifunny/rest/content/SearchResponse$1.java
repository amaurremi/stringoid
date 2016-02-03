package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class SearchResponse$1
        implements Parcelable.Creator<SearchResponse> {
    public SearchResponse createFromParcel(Parcel paramParcel) {
        return new SearchResponse(paramParcel);
    }

    public SearchResponse[] newArray(int paramInt) {
        return new SearchResponse[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/SearchResponse$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */