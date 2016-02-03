package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class el
  implements SafeParcelable
{
  public static final em CREATOR = new em();
  private final int kg;
  @Deprecated
  private final Bundle nN;
  private final int os;
  private final int pX;
  private final String pY;
  private final String pZ;
  private final String qa;
  private final String qb;
  
  el(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    this.kg = paramInt1;
    this.os = paramInt2;
    this.pX = paramInt3;
    this.pY = paramString1;
    this.pZ = paramString2;
    this.qa = paramString3;
    this.qb = paramString4;
    if (paramBundle != null) {}
    for (;;)
    {
      this.nN = paramBundle;
      return;
      paramBundle = new Bundle();
    }
  }
  
  public int bY()
  {
    return this.pX;
  }
  
  public String bZ()
  {
    return this.pY;
  }
  
  public String ca()
  {
    return this.pZ;
  }
  
  public String cb()
  {
    return this.qb;
  }
  
  public boolean cc()
  {
    return (this.os == 1) && (this.pX == -1);
  }
  
  public boolean cd()
  {
    return this.os == 2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof el)) {}
    do
    {
      return false;
      paramObject = (el)paramObject;
    } while ((this.kg != ((el)paramObject).kg) || (this.os != ((el)paramObject).os) || (this.pX != ((el)paramObject).pX) || (!ee.equal(this.pY, ((el)paramObject).pY)) || (!ee.equal(this.pZ, ((el)paramObject).pZ)));
    return true;
  }
  
  public String getDisplayName()
  {
    return this.qa;
  }
  
  @Deprecated
  public Bundle getMetadata()
  {
    return this.nN;
  }
  
  public int getType()
  {
    return this.os;
  }
  
  public int getVersionCode()
  {
    return this.kg;
  }
  
  public int hashCode()
  {
    return ee.hashCode(new Object[] { Integer.valueOf(this.kg), Integer.valueOf(this.os), Integer.valueOf(this.pX), this.pY, this.pZ });
  }
  
  public String toString()
  {
    if (cd()) {
      return String.format("Person [%s] %s", new Object[] { ca(), getDisplayName() });
    }
    if (cc()) {
      return String.format("Circle [%s] %s", new Object[] { bZ(), getDisplayName() });
    }
    return String.format("Group [%s] %s", new Object[] { bZ(), getDisplayName() });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    em.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/el.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */