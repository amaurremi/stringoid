package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class SubscriptionsUserFeed
        extends UserFeed {
    public static final Parcelable.Creator<SubscriptionsUserFeed> CREATOR = new SubscriptionsUserFeed
    .1();
    public int users_count;

    public SubscriptionsUserFeed() {
    }

    public SubscriptionsUserFeed(Parcel paramParcel) {
        this.users = ((UserList) paramParcel.readParcelable(UserList.class.getClassLoader()));
        this.users_count = paramParcel.readInt();
    }

    public SubscriptionsUserFeed copy() {
        SubscriptionsUserFeed localSubscriptionsUserFeed = new SubscriptionsUserFeed();
        localSubscriptionsUserFeed.update(this);
        localSubscriptionsUserFeed.users_count = this.users_count;
        return localSubscriptionsUserFeed;
    }

    public int describeContents() {
        return 0;
    }

    public int getUsersCount() {
        return this.users_count;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeParcelable(this.users, paramInt);
        paramParcel.writeInt(this.users_count);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/SubscriptionsUserFeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */