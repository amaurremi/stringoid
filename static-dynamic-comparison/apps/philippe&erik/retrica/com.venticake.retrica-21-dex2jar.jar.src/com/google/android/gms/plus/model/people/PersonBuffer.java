package com.google.android.gms.plus.model.people;

import android.os.Bundle;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.e;
import com.google.android.gms.internal.ks;
import com.google.android.gms.internal.ld;

public final class PersonBuffer
  extends DataBuffer<Person>
{
  private final e<ks> adZ;
  
  public PersonBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    if ((paramDataHolder.eU() != null) && (paramDataHolder.eU().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)))
    {
      this.adZ = new e(paramDataHolder, ks.CREATOR);
      return;
    }
    this.adZ = null;
  }
  
  public Person get(int paramInt)
  {
    if (this.adZ != null) {
      return (Person)this.adZ.ad(paramInt);
    }
    return new ld(this.DG, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/plus/model/people/PersonBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */