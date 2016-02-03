package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Asset
  implements SafeParcelable
{
  public static final Parcelable.Creator<Asset> CREATOR = new a();
  final int BR;
  private byte[] acw;
  private String auF;
  public ParcelFileDescriptor auG;
  public Uri uri;
  
  Asset(int paramInt, byte[] paramArrayOfByte, String paramString, ParcelFileDescriptor paramParcelFileDescriptor, Uri paramUri)
  {
    this.BR = paramInt;
    this.acw = paramArrayOfByte;
    this.auF = paramString;
    this.auG = paramParcelFileDescriptor;
    this.uri = paramUri;
  }
  
  public static Asset createFromBytes(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("Asset data cannot be null");
    }
    return new Asset(1, paramArrayOfByte, null, null, null);
  }
  
  public static Asset createFromFd(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    if (paramParcelFileDescriptor == null) {
      throw new IllegalArgumentException("Asset fd cannot be null");
    }
    return new Asset(1, null, null, paramParcelFileDescriptor, null);
  }
  
  public static Asset createFromRef(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Asset digest cannot be null");
    }
    return new Asset(1, null, paramString, null, null);
  }
  
  public static Asset createFromUri(Uri paramUri)
  {
    if (paramUri == null) {
      throw new IllegalArgumentException("Asset uri cannot be null");
    }
    return new Asset(1, null, null, null, paramUri);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Asset)) {
        return false;
      }
      paramObject = (Asset)paramObject;
    } while ((m.equal(this.acw, ((Asset)paramObject).acw)) && (m.equal(this.auF, ((Asset)paramObject).auF)) && (m.equal(this.auG, ((Asset)paramObject).auG)) && (m.equal(this.uri, ((Asset)paramObject).uri)));
    return false;
  }
  
  public byte[] getData()
  {
    return this.acw;
  }
  
  public String getDigest()
  {
    return this.auF;
  }
  
  public ParcelFileDescriptor getFd()
  {
    return this.auG;
  }
  
  public Uri getUri()
  {
    return this.uri;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { this.acw, this.auF, this.auG, this.uri });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Asset[@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (this.auF == null) {
      localStringBuilder.append(", nodigest");
    }
    for (;;)
    {
      if (this.acw != null)
      {
        localStringBuilder.append(", size=");
        localStringBuilder.append(this.acw.length);
      }
      if (this.auG != null)
      {
        localStringBuilder.append(", fd=");
        localStringBuilder.append(this.auG);
      }
      if (this.uri != null)
      {
        localStringBuilder.append(", uri=");
        localStringBuilder.append(this.uri);
      }
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      localStringBuilder.append(", ");
      localStringBuilder.append(this.auF);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt | 0x1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/wearable/Asset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */