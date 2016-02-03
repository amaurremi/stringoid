package com.google.api.client.http;

import com.google.api.client.util.k;
import com.google.api.client.util.k.a;

@Deprecated
public class f
  implements c
{
  private final k aaR;
  
  public f()
  {
    this(new a());
  }
  
  protected f(a parama)
  {
    this.aaR = parama.aaS.yO();
  }
  
  public boolean eE(int paramInt)
  {
    switch (paramInt)
    {
    case 501: 
    case 502: 
    default: 
      return false;
    }
    return true;
  }
  
  public final void reset()
  {
    this.aaR.reset();
  }
  
  public long wU()
  {
    return this.aaR.yG();
  }
  
  @Deprecated
  public static class a
  {
    final k.a aaS = new k.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/http/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */