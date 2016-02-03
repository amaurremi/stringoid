package com.google.android.gms.plus.model.people;

import android.os.Bundle;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.c;
import com.google.android.gms.internal.ih;
import com.google.android.gms.internal.is;

public final class PersonBuffer
  extends DataBuffer<Person>
{
  private final c<ih> Wr;
  
  public PersonBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    if ((paramDataHolder.getMetadata() != null) && (paramDataHolder.getMetadata().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)))
    {
      this.Wr = new c(paramDataHolder, ih.CREATOR);
      return;
    }
    this.Wr = null;
  }
  
  public Person get(int paramInt)
  {
    if (this.Wr != null) {
      return (Person)this.Wr.F(paramInt);
    }
    return new is(this.BB, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/plus/model/people/PersonBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */