package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.b;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;

public final class ig
  extends b
  implements Moment
{
  private ie VG;
  
  public ig(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  private ie ju()
  {
    try
    {
      if (this.VG == null)
      {
        byte[] arrayOfByte = getByteArray("momentImpl");
        Parcel localParcel = Parcel.obtain();
        localParcel.unmarshall(arrayOfByte, 0, arrayOfByte.length);
        localParcel.setDataPosition(0);
        this.VG = ie.CREATOR.aM(localParcel);
        localParcel.recycle();
      }
      return this.VG;
    }
    finally {}
  }
  
  public String getId()
  {
    return ju().getId();
  }
  
  public ItemScope getResult()
  {
    return ju().getResult();
  }
  
  public String getStartDate()
  {
    return ju().getStartDate();
  }
  
  public ItemScope getTarget()
  {
    return ju().getTarget();
  }
  
  public String getType()
  {
    return ju().getType();
  }
  
  public boolean hasId()
  {
    return ju().hasId();
  }
  
  public boolean hasResult()
  {
    return ju().hasId();
  }
  
  public boolean hasStartDate()
  {
    return ju().hasStartDate();
  }
  
  public boolean hasTarget()
  {
    return ju().hasTarget();
  }
  
  public boolean hasType()
  {
    return ju().hasType();
  }
  
  public ie jt()
  {
    return ju();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/ig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */