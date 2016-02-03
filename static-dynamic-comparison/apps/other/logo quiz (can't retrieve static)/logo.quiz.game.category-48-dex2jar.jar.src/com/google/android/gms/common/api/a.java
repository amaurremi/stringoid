package com.google.android.gms.common.api;

import com.google.android.gms.common.data.DataHolder;

public abstract class a
  implements Releasable, Result
{
  protected final Status CM;
  protected final DataHolder IC;
  
  protected a(DataHolder paramDataHolder)
  {
    this.CM = new Status(paramDataHolder.getStatusCode());
    this.IC = paramDataHolder;
  }
  
  public Status getStatus()
  {
    return this.CM;
  }
  
  public void release()
  {
    if (this.IC != null) {
      this.IC.close();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/common/api/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */