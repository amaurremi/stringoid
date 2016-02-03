package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.d.a;
import java.util.HashMap;
import java.util.Map;

public class cq$b
{
  private final Map<String, d.a> agX = new HashMap();
  private d.a agY;
  
  public b b(String paramString, d.a parama)
  {
    this.agX.put(paramString, parama);
    return this;
  }
  
  public b i(d.a parama)
  {
    this.agY = parama;
    return this;
  }
  
  public cq.a mq()
  {
    return new cq.a(this.agX, this.agY, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/cq$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */