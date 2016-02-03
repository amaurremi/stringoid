package com.drew.metadata.jpeg;

import java.util.HashMap;

public class b
  extends com.drew.metadata.b
{
  protected static final HashMap<Integer, String> gb = new HashMap();
  
  static
  {
    gb.put(Integer.valueOf(0), "Jpeg Comment");
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
    return "JpegComment";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/jpeg/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */