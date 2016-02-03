package com.drew.metadata.b;

import com.drew.metadata.b;
import java.util.HashMap;

public class d
  extends b
{
  protected static final HashMap<Integer, String> gb = new HashMap();
  
  static
  {
    gb.put(Integer.valueOf(20), "CCD Sensitivity");
    gb.put(Integer.valueOf(12), "Contrast");
    gb.put(Integer.valueOf(10), "Digital Zoom");
    gb.put(Integer.valueOf(5), "Flash Intensity");
    gb.put(Integer.valueOf(4), "Flash Mode");
    gb.put(Integer.valueOf(3), "Focusing Mode");
    gb.put(Integer.valueOf(6), "Object Distance");
    gb.put(Integer.valueOf(2), "Quality");
    gb.put(Integer.valueOf(1), "Recording Mode");
    gb.put(Integer.valueOf(13), "Saturation");
    gb.put(Integer.valueOf(11), "Sharpness");
    gb.put(Integer.valueOf(8), "Makernote Unknown 1");
    gb.put(Integer.valueOf(9), "Makernote Unknown 2");
    gb.put(Integer.valueOf(14), "Makernote Unknown 3");
    gb.put(Integer.valueOf(15), "Makernote Unknown 4");
    gb.put(Integer.valueOf(16), "Makernote Unknown 5");
    gb.put(Integer.valueOf(17), "Makernote Unknown 6");
    gb.put(Integer.valueOf(18), "Makernote Unknown 7");
    gb.put(Integer.valueOf(19), "Makernote Unknown 8");
    gb.put(Integer.valueOf(7), "White Balance");
  }
  
  public d()
  {
    a(new c(this));
  }
  
  protected HashMap<Integer, String> aA()
  {
    return gb;
  }
  
  public String getName()
  {
    return "Casio Makernote";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */