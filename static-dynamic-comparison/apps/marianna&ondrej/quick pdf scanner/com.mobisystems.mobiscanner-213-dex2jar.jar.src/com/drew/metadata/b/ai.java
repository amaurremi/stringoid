package com.drew.metadata.b;

import com.drew.metadata.b;
import java.util.HashMap;

public class ai
  extends b
{
  protected static final HashMap<Integer, String> gb = new HashMap();
  
  static
  {
    gb.put(Integer.valueOf(2), "Serial Number");
    gb.put(Integer.valueOf(3), "Drive Mode");
    gb.put(Integer.valueOf(4), "Resolution Mode");
    gb.put(Integer.valueOf(5), "Auto Focus Mode");
    gb.put(Integer.valueOf(6), "Focus Setting");
    gb.put(Integer.valueOf(7), "White Balance");
    gb.put(Integer.valueOf(8), "Exposure Mode");
    gb.put(Integer.valueOf(9), "Metering Mode");
    gb.put(Integer.valueOf(10), "Lens Range");
    gb.put(Integer.valueOf(11), "Color Space");
    gb.put(Integer.valueOf(12), "Exposure");
    gb.put(Integer.valueOf(13), "Contrast");
    gb.put(Integer.valueOf(14), "Shadow");
    gb.put(Integer.valueOf(15), "Highlight");
    gb.put(Integer.valueOf(16), "Saturation");
    gb.put(Integer.valueOf(17), "Sharpness");
    gb.put(Integer.valueOf(18), "Fill Light");
    gb.put(Integer.valueOf(20), "Color Adjustment");
    gb.put(Integer.valueOf(21), "Adjustment Mode");
    gb.put(Integer.valueOf(22), "Quality");
    gb.put(Integer.valueOf(23), "Firmware");
    gb.put(Integer.valueOf(24), "Software");
    gb.put(Integer.valueOf(25), "Auto Bracket");
  }
  
  public ai()
  {
    a(new ah(this));
  }
  
  protected HashMap<Integer, String> aA()
  {
    return gb;
  }
  
  public String getName()
  {
    return "Sigma Makernote";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */