package com.appbrain.b;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class f
{
  private static volatile boolean a = false;
  private static final f c = new f((byte)0);
  private final Map b;
  
  f()
  {
    this.b = new HashMap();
  }
  
  private f(byte paramByte)
  {
    this.b = Collections.emptyMap();
  }
  
  public static f a()
  {
    return c;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */