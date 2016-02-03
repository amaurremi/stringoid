package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class TaskInfo$Result
        implements Parcelable {
    public static final Parcelable.Creator<Result> CREATOR = new TaskInfo.Result
    .1();
    public String cid;

    public TaskInfo$Result() {
    }

    private TaskInfo$Result(Parcel paramParcel) {
        this.cid = paramParcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.cid);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/TaskInfo$Result.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */