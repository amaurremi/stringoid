package com.drew.metadata.b;

import com.drew.metadata.b;
import java.util.HashMap;

public class ag
  extends b
{
  protected static final HashMap<Integer, String> gb = new HashMap();
  
  static
  {
    gb.put(Integer.valueOf(1), "Capture Mode");
    gb.put(Integer.valueOf(2), "Quality Level");
    gb.put(Integer.valueOf(3), "Focus Mode");
    gb.put(Integer.valueOf(4), "Flash Mode");
    gb.put(Integer.valueOf(7), "White Balance");
    gb.put(Integer.valueOf(10), "Digital Zoom");
    gb.put(Integer.valueOf(11), "Sharpness");
    gb.put(Integer.valueOf(12), "Contrast");
    gb.put(Integer.valueOf(13), "Saturation");
    gb.put(Integer.valueOf(20), "ISO Speed");
    gb.put(Integer.valueOf(23), "Colour");
    gb.put(Integer.valueOf(3584), "Print Image Matching (PIM) Info");
    gb.put(Integer.valueOf(4096), "Time Zone");
    gb.put(Integer.valueOf(4097), "Daylight Savings");
  }
  
  public ag()
  {
    a(new af(this));
  }
  
  protected HashMap<Integer, String> aA()
  {
    return gb;
  }
  
  public String getName()
  {
    return "Pentax Makernote";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */