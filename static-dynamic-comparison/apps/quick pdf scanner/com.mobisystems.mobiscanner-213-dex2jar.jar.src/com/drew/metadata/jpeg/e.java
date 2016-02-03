package com.drew.metadata.jpeg;

import com.drew.metadata.b;
import java.util.HashMap;

public class e
  extends b
{
  protected static final HashMap<Integer, String> gb = new HashMap();
  
  static
  {
    gb.put(Integer.valueOf(-3), "Compression Type");
    gb.put(Integer.valueOf(0), "Data Precision");
    gb.put(Integer.valueOf(3), "Image Width");
    gb.put(Integer.valueOf(1), "Image Height");
    gb.put(Integer.valueOf(5), "Number of Components");
    gb.put(Integer.valueOf(6), "Component 1");
    gb.put(Integer.valueOf(7), "Component 2");
    gb.put(Integer.valueOf(8), "Component 3");
    gb.put(Integer.valueOf(9), "Component 4");
  }
  
  public e()
  {
    a(new d(this));
  }
  
  protected HashMap<Integer, String> aA()
  {
    return gb;
  }
  
  public JpegComponent aq(int paramInt)
  {
    return (JpegComponent)getObject(paramInt + 6);
  }
  
  public String getName()
  {
    return "Jpeg";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/jpeg/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */