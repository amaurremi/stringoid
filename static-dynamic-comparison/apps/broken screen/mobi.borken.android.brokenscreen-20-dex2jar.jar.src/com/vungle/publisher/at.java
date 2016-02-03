package com.vungle.publisher;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.vungle.publisher.db.model.Ad;
import com.vungle.publisher.db.model.Video;
import com.vungle.publisher.protocol.message.RequestAdResponse;

public abstract interface at<A extends Ad<A, V, R>, V extends Video<A, V, R>, R extends RequestAdResponse>
{
  public abstract void a(a parama);
  
  public abstract String f();
  
  public abstract A g();
  
  public abstract a h();
  
  public abstract b i();
  
  public static enum a
  {
    private a() {}
  }
  
  public static enum b
    implements Parcelable
  {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator() {};
    
    private b() {}
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(ordinal());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */