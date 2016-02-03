package com.drew.metadata.b;

import com.drew.metadata.b;
import java.util.HashMap;

public class h
  extends b
{
  protected static final HashMap<Integer, String> gb = new HashMap();
  
  static
  {
    gb.put(Integer.valueOf(270), "Image Description");
    gb.put(Integer.valueOf(271), "Make");
    gb.put(Integer.valueOf(272), "Model");
    gb.put(Integer.valueOf(274), "Orientation");
    gb.put(Integer.valueOf(282), "X Resolution");
    gb.put(Integer.valueOf(283), "Y Resolution");
    gb.put(Integer.valueOf(296), "Resolution Unit");
    gb.put(Integer.valueOf(305), "Software");
    gb.put(Integer.valueOf(306), "Date/Time");
    gb.put(Integer.valueOf(315), "Artist");
    gb.put(Integer.valueOf(318), "White Point");
    gb.put(Integer.valueOf(319), "Primary Chromaticities");
    gb.put(Integer.valueOf(529), "YCbCr Coefficients");
    gb.put(Integer.valueOf(531), "YCbCr Positioning");
    gb.put(Integer.valueOf(532), "Reference Black/White");
    gb.put(Integer.valueOf(33432), "Copyright");
    gb.put(Integer.valueOf(40093), "Windows XP Author");
    gb.put(Integer.valueOf(40092), "Windows XP Comment");
    gb.put(Integer.valueOf(40094), "Windows XP Keywords");
    gb.put(Integer.valueOf(40095), "Windows XP Subject");
    gb.put(Integer.valueOf(40091), "Windows XP Title");
  }
  
  public h()
  {
    a(new g(this));
  }
  
  protected HashMap<Integer, String> aA()
  {
    return gb;
  }
  
  public String getName()
  {
    return "Exif IFD0";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */