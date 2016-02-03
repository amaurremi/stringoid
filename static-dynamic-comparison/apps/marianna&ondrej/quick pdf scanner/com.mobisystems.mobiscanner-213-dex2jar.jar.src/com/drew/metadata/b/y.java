package com.drew.metadata.b;

import com.drew.metadata.b;
import java.util.HashMap;

public class y
  extends b
{
  protected static final HashMap<Integer, String> gb = new HashMap();
  
  static
  {
    gb.put(Integer.valueOf(6), "CCD Sensitivity");
    gb.put(Integer.valueOf(4), "Color Mode");
    gb.put(Integer.valueOf(10), "Digital Zoom");
    gb.put(Integer.valueOf(11), "Fisheye Converter");
    gb.put(Integer.valueOf(8), "Focus");
    gb.put(Integer.valueOf(5), "Image Adjustment");
    gb.put(Integer.valueOf(3), "Quality");
    gb.put(Integer.valueOf(2), "Makernote Unknown 1");
    gb.put(Integer.valueOf(9), "Makernote Unknown 2");
    gb.put(Integer.valueOf(3840), "Makernote Unknown 3");
    gb.put(Integer.valueOf(7), "White Balance");
  }
  
  public y()
  {
    a(new x(this));
  }
  
  protected HashMap<Integer, String> aA()
  {
    return gb;
  }
  
  public String getName()
  {
    return "Nikon Makernote";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */