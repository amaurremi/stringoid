package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ActivityRecognitionResult
  implements SafeParcelable
{
  public static final a TU = new a();
  List<DetectedActivity> TV;
  long TW;
  long TX;
  private final int qh = 1;
  
  public ActivityRecognitionResult(int paramInt, List<DetectedActivity> paramList, long paramLong1, long paramLong2)
  {
    this.TV = paramList;
    this.TW = paramLong1;
    this.TX = paramLong2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int lX()
  {
    return this.qh;
  }
  
  public String toString()
  {
    return "ActivityRecognitionResult [probableActivities=" + this.TV + ", timeMillis=" + this.TW + ", elapsedRealtimeMillis=" + this.TX + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/location/ActivityRecognitionResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */