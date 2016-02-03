package com.google.android.gms.plus.model.people;

import android.os.Bundle;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.e;
import com.google.android.gms.internal.ny;
import com.google.android.gms.internal.oj;

public final class PersonBuffer
  extends DataBuffer<Person>
{
  private final e<ny> any;
  
  public PersonBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    if ((paramDataHolder.gz() != null) && (paramDataHolder.gz().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)))
    {
      this.any = new e(paramDataHolder, ny.CREATOR);
      return;
    }
    this.any = null;
  }
  
  public Person get(int paramInt)
  {
    if (this.any != null) {
      return (Person)this.any.aq(paramInt);
    }
    return new oj(this.IC, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/plus/model/people/PersonBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */