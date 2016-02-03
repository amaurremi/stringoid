package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.hk;
import java.util.ArrayList;
import java.util.List;

public final class ApplicationMetadata
  implements SafeParcelable
{
  public static final Parcelable.Creator<ApplicationMetadata> CREATOR = new a();
  String mName;
  private final int xM;
  String zP;
  List<WebImage> zQ;
  List<String> zR;
  String zS;
  Uri zT;
  
  private ApplicationMetadata()
  {
    this.xM = 1;
    this.zQ = new ArrayList();
    this.zR = new ArrayList();
  }
  
  ApplicationMetadata(int paramInt, String paramString1, String paramString2, List<WebImage> paramList, List<String> paramList1, String paramString3, Uri paramUri)
  {
    this.xM = paramInt;
    this.zP = paramString1;
    this.mName = paramString2;
    this.zQ = paramList;
    this.zR = paramList1;
    this.zS = paramString3;
    this.zT = paramUri;
  }
  
  public boolean areNamespacesSupported(List<String> paramList)
  {
    return (this.zR != null) && (this.zR.containsAll(paramList));
  }
  
  public Uri dX()
  {
    return this.zT;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof ApplicationMetadata)) {
        return false;
      }
      paramObject = (ApplicationMetadata)paramObject;
    } while ((gi.a(this.zP, ((ApplicationMetadata)paramObject).zP)) && (gi.a(this.zQ, ((ApplicationMetadata)paramObject).zQ)) && (gi.a(this.mName, ((ApplicationMetadata)paramObject).mName)) && (gi.a(this.zR, ((ApplicationMetadata)paramObject).zR)) && (gi.a(this.zS, ((ApplicationMetadata)paramObject).zS)) && (gi.a(this.zT, ((ApplicationMetadata)paramObject).zT)));
    return false;
  }
  
  public String getApplicationId()
  {
    return this.zP;
  }
  
  public List<WebImage> getImages()
  {
    return this.zQ;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getSenderAppIdentifier()
  {
    return this.zS;
  }
  
  int getVersionCode()
  {
    return this.xM;
  }
  
  public int hashCode()
  {
    return hk.hashCode(new Object[] { Integer.valueOf(this.xM), this.zP, this.mName, this.zQ, this.zR, this.zS, this.zT });
  }
  
  public boolean isNamespaceSupported(String paramString)
  {
    return (this.zR != null) && (this.zR.contains(paramString));
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/cast/ApplicationMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */