package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class SearchUsersResponce
        extends FeedPagingList<User> {
    public static final Parcelable.Creator<SearchUsersResponce> CREATOR = new SearchUsersResponce
    .1();
    public SearchResponse.SearchCounters num;
    public UserList users;

    public SearchUsersResponce() {
        this.users = new UserList();
    }

    public SearchUsersResponce(Parcel paramParcel) {
        this.users = ((UserList) paramParcel.readParcelable(UserList.class.getClassLoader()));
        this.num = ((SearchResponse.SearchCounters) paramParcel.readParcelable(SearchResponse.SearchCounters.class.getClassLoader()));
    }

    public SearchUsersResponce copy() {
        SearchUsersResponce localSearchUsersResponce = new SearchUsersResponce();
        localSearchUsersResponce.update(this);
        localSearchUsersResponce.num = new SearchResponse.SearchCounters(this.num);
        return localSearchUsersResponce;
    }

    public int describeContents() {
        return 0;
    }

    public PagingList<User> getPagingList() {
        return this.users;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeParcelable(this.users, paramInt);
        paramParcel.writeParcelable(this.num, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/SearchUsersResponce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */