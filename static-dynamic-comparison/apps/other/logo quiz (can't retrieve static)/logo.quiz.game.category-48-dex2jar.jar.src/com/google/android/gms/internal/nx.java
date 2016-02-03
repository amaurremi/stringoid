package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;

public final class nx
  extends d
  implements Moment
{
  private nv amO;
  
  public nx(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  private nv nr()
  {
    try
    {
      if (this.amO == null)
      {
        byte[] arrayOfByte = getByteArray("momentImpl");
        Parcel localParcel = Parcel.obtain();
        localParcel.unmarshall(arrayOfByte, 0, arrayOfByte.length);
        localParcel.setDataPosition(0);
        this.amO = nv.CREATOR.dc(localParcel);
        localParcel.recycle();
      }
      return this.amO;
    }
    finally {}
  }
  
  public String getId()
  {
    return nr().getId();
  }
  
  public ItemScope getResult()
  {
    return nr().getResult();
  }
  
  public String getStartDate()
  {
    return nr().getStartDate();
  }
  
  public ItemScope getTarget()
  {
    return nr().getTarget();
  }
  
  public String getType()
  {
    return nr().getType();
  }
  
  public boolean hasId()
  {
    return nr().hasId();
  }
  
  public boolean hasResult()
  {
    return nr().hasResult();
  }
  
  public boolean hasStartDate()
  {
    return nr().hasStartDate();
  }
  
  public boolean hasTarget()
  {
    return nr().hasTarget();
  }
  
  public boolean hasType()
  {
    return nr().hasType();
  }
  
  public nv nq()
  {
    return nr();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/nx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */