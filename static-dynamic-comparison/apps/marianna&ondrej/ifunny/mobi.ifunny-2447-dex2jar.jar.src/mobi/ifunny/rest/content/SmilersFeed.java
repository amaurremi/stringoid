package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class SmilersFeed
        extends UserFeed {
    public static final Parcelable.Creator<SmilersFeed> CREATOR = new SmilersFeed
    .1();
    public int smiles_count;

    public SmilersFeed() {
    }

    public SmilersFeed(Parcel paramParcel) {
        this.users = ((UserList) paramParcel.readParcelable(UserList.class.getClassLoader()));
        this.smiles_count = paramParcel.readInt();
    }

    public SmilersFeed copy() {
        SmilersFeed localSmilersFeed = new SmilersFeed();
        localSmilersFeed.update(this);
        localSmilersFeed.smiles_count = this.smiles_count;
        return localSmilersFeed;
    }

    public int describeContents() {
        return 0;
    }

    public int getUsersCount() {
        return this.smiles_count;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeParcelable(this.users, paramInt);
        paramParcel.writeInt(this.smiles_count);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/SmilersFeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */