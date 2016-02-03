package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TaskInfo
        implements Parcelable {
    public static final Parcelable.Creator<TaskInfo> CREATOR = new TaskInfo
    .1();
    public static final String STATE_FAILURE = "failure";
    public static final String STATE_PENDING = "pending";
    public static final String STATE_SUCCESS = "success";
    public String error;
    public String error_description;
    public String id;
    public TaskInfo.Result result;
    public int retry_after;
    public String state;
    public String type;

    public TaskInfo() {
    }

    private TaskInfo(Parcel paramParcel) {
        this.id = paramParcel.readString();
        this.type = paramParcel.readString();
        this.state = paramParcel.readString();
        this.retry_after = paramParcel.readInt();
        this.result = ((TaskInfo.Result) paramParcel.readParcelable(TaskInfo.Result.class.getClassLoader()));
        this.error = paramParcel.readString();
        this.error_description = paramParcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.id);
        paramParcel.writeString(this.type);
        paramParcel.writeString(this.state);
        paramParcel.writeInt(this.retry_after);
        paramParcel.writeParcelable(this.result, paramInt);
        paramParcel.writeString(this.error);
        paramParcel.writeString(this.error_description);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/TaskInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */