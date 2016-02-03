package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UserStat
        implements Parcelable {
    public static final Parcelable.Creator<UserStat> CREATOR = new UserStat
    .1();
    public int created;
    public int featured;
    public int subscribers;
    public int subscriptions;
    public int total_posts;

    public UserStat() {
    }

    public UserStat(Parcel paramParcel) {
        this.subscriptions = paramParcel.readInt();
        this.subscribers = paramParcel.readInt();
        this.total_posts = paramParcel.readInt();
        this.created = paramParcel.readInt();
        this.featured = paramParcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeInt(this.subscriptions);
        paramParcel.writeInt(this.subscribers);
        paramParcel.writeInt(this.total_posts);
        paramParcel.writeInt(this.created);
        paramParcel.writeInt(this.featured);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/UserStat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */