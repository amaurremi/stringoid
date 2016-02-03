package com.drew.metadata.f;

import com.drew.metadata.b;
import java.util.HashMap;

public class e
  extends b
{
  protected static final HashMap<Integer, String> gb = new HashMap();
  
  static
  {
    gb.put(Integer.valueOf(1), "Channel Count");
    gb.put(Integer.valueOf(2), "Image Height");
    gb.put(Integer.valueOf(3), "Image Width");
    gb.put(Integer.valueOf(4), "Bits Per Channel");
    gb.put(Integer.valueOf(5), "Color Mode");
  }
  
  public e()
  {
    a(new d(this));
  }
  
  protected HashMap<Integer, String> aA()
  {
    return gb;
  }
  
  public String getName()
  {
    return "PSD Header";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/f/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */