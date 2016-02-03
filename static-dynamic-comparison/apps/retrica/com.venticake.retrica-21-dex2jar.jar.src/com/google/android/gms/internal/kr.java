package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;

public final class kr
  extends d
  implements Moment
{
  private kp adp;
  
  public kr(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  private kp kE()
  {
    try
    {
      if (this.adp == null)
      {
        byte[] arrayOfByte = getByteArray("momentImpl");
        Parcel localParcel = Parcel.obtain();
        localParcel.unmarshall(arrayOfByte, 0, arrayOfByte.length);
        localParcel.setDataPosition(0);
        this.adp = kp.CREATOR.bF(localParcel);
        localParcel.recycle();
      }
      return this.adp;
    }
    finally {}
  }
  
  public String getId()
  {
    return kE().getId();
  }
  
  public ItemScope getResult()
  {
    return kE().getResult();
  }
  
  public String getStartDate()
  {
    return kE().getStartDate();
  }
  
  public ItemScope getTarget()
  {
    return kE().getTarget();
  }
  
  public String getType()
  {
    return kE().getType();
  }
  
  public boolean hasId()
  {
    return kE().hasId();
  }
  
  public boolean hasResult()
  {
    return kE().hasId();
  }
  
  public boolean hasStartDate()
  {
    return kE().hasStartDate();
  }
  
  public boolean hasTarget()
  {
    return kE().hasTarget();
  }
  
  public boolean hasType()
  {
    return kE().hasType();
  }
  
  public kp kD()
  {
    return kE();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/kr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */