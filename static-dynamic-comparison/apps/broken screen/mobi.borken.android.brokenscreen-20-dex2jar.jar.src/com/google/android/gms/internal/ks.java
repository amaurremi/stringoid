package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;

public final class ks
  extends d
  implements Moment
{
  private kq adm;
  
  public ks(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  private kq kz()
  {
    try
    {
      if (this.adm == null)
      {
        byte[] arrayOfByte = getByteArray("momentImpl");
        Parcel localParcel = Parcel.obtain();
        localParcel.unmarshall(arrayOfByte, 0, arrayOfByte.length);
        localParcel.setDataPosition(0);
        this.adm = kq.CREATOR.bF(localParcel);
        localParcel.recycle();
      }
      return this.adm;
    }
    finally {}
  }
  
  public String getId()
  {
    return kz().getId();
  }
  
  public ItemScope getResult()
  {
    return kz().getResult();
  }
  
  public String getStartDate()
  {
    return kz().getStartDate();
  }
  
  public ItemScope getTarget()
  {
    return kz().getTarget();
  }
  
  public String getType()
  {
    return kz().getType();
  }
  
  public boolean hasId()
  {
    return kz().hasId();
  }
  
  public boolean hasResult()
  {
    return kz().hasId();
  }
  
  public boolean hasStartDate()
  {
    return kz().hasStartDate();
  }
  
  public boolean hasTarget()
  {
    return kz().hasTarget();
  }
  
  public boolean hasType()
  {
    return kz().hasType();
  }
  
  public kq ky()
  {
    return kz();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */