package com.appbrain.b;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class j
{
  private static volatile boolean a = false;
  private static final j c = new j((byte)0);
  private final Map b;
  
  j()
  {
    this.b = new HashMap();
  }
  
  private j(byte paramByte)
  {
    this.b = Collections.emptyMap();
  }
  
  public static j a()
  {
    return c;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */