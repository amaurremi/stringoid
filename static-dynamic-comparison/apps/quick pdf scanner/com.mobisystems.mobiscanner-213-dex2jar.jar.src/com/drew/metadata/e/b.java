package com.drew.metadata.e;

import java.util.HashMap;

public class b
  extends com.drew.metadata.b
{
  protected static final HashMap<Integer, String> gb = new HashMap();
  
  static
  {
    gb.put(Integer.valueOf(5), "Version");
    gb.put(Integer.valueOf(7), "Resolution Units");
    gb.put(Integer.valueOf(10), "Y Resolution");
    gb.put(Integer.valueOf(8), "X Resolution");
  }
  
  public b()
  {
    a(new a(this));
  }
  
  protected HashMap<Integer, String> aA()
  {
    return gb;
  }
  
  public String getName()
  {
    return "Jfif";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */