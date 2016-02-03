package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.internal.hk;

final class i
{
  public final Uri a;
  
  public i(Uri paramUri)
  {
    this.a = paramUri;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof i)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    return hk.equal(((i)paramObject).a, this.a);
  }
  
  public int hashCode()
  {
    return hk.hashCode(new Object[] { this.a });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/images/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */