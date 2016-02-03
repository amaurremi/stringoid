package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.kr;

public final class MomentBuffer
  extends DataBuffer<Moment>
{
  public MomentBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  public Moment get(int paramInt)
  {
    return new kr(this.DG, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/plus/model/moments/MomentBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */