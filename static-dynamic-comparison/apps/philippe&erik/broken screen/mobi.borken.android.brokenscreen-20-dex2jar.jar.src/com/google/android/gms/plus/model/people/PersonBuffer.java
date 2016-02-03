package com.google.android.gms.plus.model.people;

import android.os.Bundle;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.e;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.le;

public final class PersonBuffer
  extends DataBuffer<Person>
{
  private final e<kt> adW;
  
  public PersonBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    if ((paramDataHolder.eP() != null) && (paramDataHolder.eP().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)))
    {
      this.adW = new e(paramDataHolder, kt.CREATOR);
      return;
    }
    this.adW = null;
  }
  
  public Person get(int paramInt)
  {
    if (this.adW != null) {
      return (Person)this.adW.ad(paramInt);
    }
    return new le(this.DD, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/plus/model/people/PersonBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */