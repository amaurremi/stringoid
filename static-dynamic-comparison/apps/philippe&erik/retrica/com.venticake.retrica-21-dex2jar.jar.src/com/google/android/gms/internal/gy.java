package com.google.android.gms.internal;

import android.view.View;
import java.util.Collection;
import java.util.List;

public final class gy
{
  private final View DJ;
  private final gy.a FU;
  
  public gy(String paramString1, Collection<String> paramCollection, int paramInt, View paramView, String paramString2)
  {
    this.FU = new gy.a(paramString1, paramCollection, paramInt, paramString2);
    this.DJ = paramView;
  }
  
  public String fj()
  {
    return this.FU.fj();
  }
  
  public int fk()
  {
    return this.FU.fk();
  }
  
  public List<String> fl()
  {
    return this.FU.fl();
  }
  
  public String[] fm()
  {
    return (String[])this.FU.fl().toArray(new String[0]);
  }
  
  public String fn()
  {
    return this.FU.fn();
  }
  
  public View fo()
  {
    return this.DJ;
  }
  
  public String getAccountName()
  {
    return this.FU.getAccountName();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/gy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */