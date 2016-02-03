package com.google.api.client.http;

import java.util.Arrays;
import java.util.logging.Logger;

public abstract class w
{
  static final Logger aao = Logger.getLogger(w.class.getName());
  private static final String[] abO = { "DELETE", "GET", "POST", "PUT" };
  
  static
  {
    Arrays.sort(abO);
  }
  
  public final r a(s params)
  {
    return new r(this, params);
  }
  
  public boolean cj(String paramString)
  {
    return Arrays.binarySearch(abO, paramString) >= 0;
  }
  
  protected abstract z l(String paramString1, String paramString2);
  
  public final r xS()
  {
    return a(null);
  }
  
  q xT()
  {
    return new q(this, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/http/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */