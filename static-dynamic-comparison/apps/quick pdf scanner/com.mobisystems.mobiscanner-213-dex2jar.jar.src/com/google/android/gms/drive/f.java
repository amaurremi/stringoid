package com.google.android.gms.drive;

import com.google.android.gms.common.data.c;
import com.google.android.gms.drive.metadata.b;
import com.google.android.gms.internal.dz;
import com.google.android.gms.internal.ea;
import java.util.Date;

public abstract class f
  implements c<f>
{
  protected abstract <T> T a(b<T> paramb);
  
  public DriveId mV()
  {
    return (DriveId)a(dz.Mg);
  }
  
  public Date mX()
  {
    return (Date)a(ea.Mz);
  }
  
  public boolean mY()
  {
    Boolean localBoolean = (Boolean)a(dz.ui);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */