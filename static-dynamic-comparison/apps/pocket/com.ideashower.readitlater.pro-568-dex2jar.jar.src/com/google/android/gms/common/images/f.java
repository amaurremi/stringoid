package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.internal.al;

public final class f
{
  public final Uri a;
  
  public f(Uri paramUri)
  {
    this.a = paramUri;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof f)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this == paramObject);
      bool1 = bool2;
    } while (((f)paramObject).hashCode() == hashCode());
    return false;
  }
  
  public int hashCode()
  {
    return al.a(new Object[] { this.a });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/common/images/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */