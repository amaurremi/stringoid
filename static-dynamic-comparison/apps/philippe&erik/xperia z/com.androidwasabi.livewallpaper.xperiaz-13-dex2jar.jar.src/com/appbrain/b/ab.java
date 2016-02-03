package com.appbrain.b;

import java.util.List;

public final class ab
  extends RuntimeException
{
  private final List a = null;
  
  public ab()
  {
    super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
  }
  
  public final o a()
  {
    return new o(getMessage());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/b/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */