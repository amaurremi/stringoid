package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

public final class ApplicationMetadata
  implements SafeParcelable
{
  public static final Parcelable.Creator<ApplicationMetadata> CREATOR = new a();
  String mName;
  private final int qh;
  String qi;
  List<WebImage> qj;
  List<String> qk;
  String ql;
  Uri qm;
  
  private ApplicationMetadata()
  {
    this.qh = 1;
    this.qj = new ArrayList();
    this.qk = new ArrayList();
  }
  
  ApplicationMetadata(int paramInt, String paramString1, String paramString2, List<WebImage> paramList, List<String> paramList1, String paramString3, Uri paramUri)
  {
    this.qh = paramInt;
    this.qi = paramString1;
    this.mName = paramString2;
    this.qj = paramList;
    this.qk = paramList1;
    this.ql = paramString3;
    this.qm = paramUri;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  int lX()
  {
    return this.qh;
  }
  
  public String lY()
  {
    return this.qi;
  }
  
  public String lZ()
  {
    return this.ql;
  }
  
  public Uri ma()
  {
    return this.qm;
  }
  
  public List<WebImage> mb()
  {
    return this.qj;
  }
  
  public String toString()
  {
    return this.mName;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/cast/ApplicationMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */