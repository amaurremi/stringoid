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
  private final int kg;
  String kh;
  List<WebImage> ki;
  List<String> kj;
  String kk;
  Uri kl;
  String mName;
  
  private ApplicationMetadata()
  {
    this.kg = 1;
    this.ki = new ArrayList();
    this.kj = new ArrayList();
  }
  
  ApplicationMetadata(int paramInt, String paramString1, String paramString2, List<WebImage> paramList, List<String> paramList1, String paramString3, Uri paramUri)
  {
    this.kg = paramInt;
    this.kh = paramString1;
    this.mName = paramString2;
    this.ki = paramList;
    this.kj = paramList1;
    this.kk = paramString3;
    this.kl = paramUri;
  }
  
  public Uri aN()
  {
    return this.kl;
  }
  
  public boolean areNamespacesSupported(List<String> paramList)
  {
    return (this.kj != null) && (this.kj.containsAll(paramList));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getApplicationId()
  {
    return this.kh;
  }
  
  public List<WebImage> getImages()
  {
    return this.ki;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getSenderAppIdentifier()
  {
    return this.kk;
  }
  
  int getVersionCode()
  {
    return this.kg;
  }
  
  public boolean isNamespaceSupported(String paramString)
  {
    return (this.kj != null) && (this.kj.contains(paramString));
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/cast/ApplicationMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */