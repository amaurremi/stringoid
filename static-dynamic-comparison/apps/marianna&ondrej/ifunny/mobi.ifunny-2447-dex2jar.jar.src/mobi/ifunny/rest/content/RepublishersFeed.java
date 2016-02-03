package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class RepublishersFeed
        extends UserFeed {
    public static final Parcelable.Creator<RepublishersFeed> CREATOR = new RepublishersFeed
    .1();
    private int republishes_count;

    public RepublishersFeed() {
    }

    public RepublishersFeed(Parcel paramParcel) {
        this.users = ((UserList) paramParcel.readParcelable(UserList.class.getClassLoader()));
        this.republishes_count = paramParcel.readInt();
    }

    public RepublishersFeed copy() {
        RepublishersFeed localRepublishersFeed = new RepublishersFeed();
        localRepublishersFeed.update(this);
        localRepublishersFeed.republishes_count = this.republishes_count;
        return localRepublishersFeed;
    }

    public int describeContents() {
        return 0;
    }

    public int getUsersCount() {
        return this.republishes_count;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeParcelable(this.users, paramInt);
        paramParcel.writeInt(this.republishes_count);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/RepublishersFeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */