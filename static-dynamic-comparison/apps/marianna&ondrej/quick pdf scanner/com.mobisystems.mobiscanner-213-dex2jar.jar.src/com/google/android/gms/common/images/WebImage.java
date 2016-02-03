package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.cz;

public final class WebImage
  implements SafeParcelable
{
  public static final Parcelable.Creator<WebImage> CREATOR = new b();
  private final int lL;
  private final int qh;
  private final Uri st;
  private final int w;
  
  WebImage(int paramInt1, Uri paramUri, int paramInt2, int paramInt3)
  {
    this.qh = paramInt1;
    this.st = paramUri;
    this.w = paramInt2;
    this.lL = paramInt3;
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
      if ((paramObject == null) || (!(paramObject instanceof WebImage))) {
        return false;
      }
      paramObject = (WebImage)paramObject;
    } while ((cz.b(this.st, ((WebImage)paramObject).st)) && (this.w == ((WebImage)paramObject).w) && (this.lL == ((WebImage)paramObject).lL));
    return false;
  }
  
  public int getHeight()
  {
    return this.lL;
  }
  
  public int getWidth()
  {
    return this.w;
  }
  
  public int hashCode()
  {
    return cz.hashCode(new Object[] { this.st, Integer.valueOf(this.w), Integer.valueOf(this.lL) });
  }
  
  int lX()
  {
    return this.qh;
  }
  
  public Uri mP()
  {
    return this.st;
  }
  
  public String toString()
  {
    return String.format("Image %dx%d %s", new Object[] { Integer.valueOf(this.w), Integer.valueOf(this.lL), this.st.toString() });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/common/images/WebImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */