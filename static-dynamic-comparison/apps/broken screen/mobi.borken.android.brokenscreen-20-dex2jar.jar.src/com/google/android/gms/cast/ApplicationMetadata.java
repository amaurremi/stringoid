package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.gj;
import com.google.android.gms.internal.hl;
import java.util.ArrayList;
import java.util.List;

public final class ApplicationMetadata
  implements SafeParcelable
{
  public static final Parcelable.Creator<ApplicationMetadata> CREATOR = new a();
  String mName;
  private final int xJ;
  String zM;
  List<WebImage> zN;
  List<String> zO;
  String zP;
  Uri zQ;
  
  private ApplicationMetadata()
  {
    this.xJ = 1;
    this.zN = new ArrayList();
    this.zO = new ArrayList();
  }
  
  ApplicationMetadata(int paramInt, String paramString1, String paramString2, List<WebImage> paramList, List<String> paramList1, String paramString3, Uri paramUri)
  {
    this.xJ = paramInt;
    this.zM = paramString1;
    this.mName = paramString2;
    this.zN = paramList;
    this.zO = paramList1;
    this.zP = paramString3;
    this.zQ = paramUri;
  }
  
  public boolean areNamespacesSupported(List<String> paramList)
  {
    return (this.zO != null) && (this.zO.containsAll(paramList));
  }
  
  public Uri dS()
  {
    return this.zQ;
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
    } while ((gj.a(this.zM, ((ApplicationMetadata)paramObject).zM)) && (gj.a(this.zN, ((ApplicationMetadata)paramObject).zN)) && (gj.a(this.mName, ((ApplicationMetadata)paramObject).mName)) && (gj.a(this.zO, ((ApplicationMetadata)paramObject).zO)) && (gj.a(this.zP, ((ApplicationMetadata)paramObject).zP)) && (gj.a(this.zQ, ((ApplicationMetadata)paramObject).zQ)));
    return false;
  }
  
  public String getApplicationId()
  {
    return this.zM;
  }
  
  public List<WebImage> getImages()
  {
    return this.zN;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getSenderAppIdentifier()
  {
    return this.zP;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    return hl.hashCode(new Object[] { Integer.valueOf(this.xJ), this.zM, this.mName, this.zN, this.zO, this.zP, this.zQ });
  }
  
  public boolean isNamespaceSupported(String paramString)
  {
    return (this.zO != null) && (this.zO.contains(paramString));
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/cast/ApplicationMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */