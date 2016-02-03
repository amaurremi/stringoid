package com.drew.metadata.a;

import java.util.HashMap;

public class b
  extends com.drew.metadata.b
{
  private static final HashMap<Integer, String> gb = new HashMap();
  
  static
  {
    gb.put(Integer.valueOf(0), "DCT Encode Version");
    gb.put(Integer.valueOf(1), "Flags 0");
    gb.put(Integer.valueOf(2), "Flags 1");
    gb.put(Integer.valueOf(3), "Color Transform");
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
    return "Adobe Jpeg";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */