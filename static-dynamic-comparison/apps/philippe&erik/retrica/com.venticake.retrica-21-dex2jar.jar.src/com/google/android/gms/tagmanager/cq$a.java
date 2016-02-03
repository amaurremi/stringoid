package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.d.a;
import java.util.Collections;
import java.util.Map;

public class cq$a
{
  private final Map<String, d.a> agX;
  private final d.a agY;
  
  private cq$a(Map<String, d.a> paramMap, d.a parama)
  {
    this.agX = paramMap;
    this.agY = parama;
  }
  
  public static cq.b mn()
  {
    return new cq.b(null);
  }
  
  public void a(String paramString, d.a parama)
  {
    this.agX.put(paramString, parama);
  }
  
  public Map<String, d.a> mo()
  {
    return Collections.unmodifiableMap(this.agX);
  }
  
  public d.a mp()
  {
    return this.agY;
  }
  
  public String toString()
  {
    return "Properties: " + mo() + " pushAfterEvaluate: " + this.agY;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/cq$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */