package mobi.ifunny.rest.content;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class TaskInfo$1
        implements Parcelable.Creator<TaskInfo> {
    public TaskInfo createFromParcel(Parcel paramParcel) {
        return new TaskInfo(paramParcel, null);
    }

    public TaskInfo[] newArray(int paramInt) {
        return new TaskInfo[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/rest/content/TaskInfo$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */