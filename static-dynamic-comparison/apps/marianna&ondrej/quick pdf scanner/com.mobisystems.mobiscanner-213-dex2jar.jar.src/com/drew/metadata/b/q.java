package com.drew.metadata.b;

import com.drew.metadata.b;
import java.util.HashMap;

public class q
  extends b
{
  protected static final HashMap<Integer, String> gb = new HashMap();
  
  static
  {
    gb.put(Integer.valueOf(0), "Makernote Version");
    gb.put(Integer.valueOf(4096), "Quality");
    gb.put(Integer.valueOf(4097), "Sharpness");
    gb.put(Integer.valueOf(4098), "White Balance");
    gb.put(Integer.valueOf(4099), "Color Saturation");
    gb.put(Integer.valueOf(4100), "Tone (Contrast)");
    gb.put(Integer.valueOf(4112), "Flash Mode");
    gb.put(Integer.valueOf(4113), "Flash Strength");
    gb.put(Integer.valueOf(4128), "Macro");
    gb.put(Integer.valueOf(4129), "Focus Mode");
    gb.put(Integer.valueOf(4144), "Slow Synch");
    gb.put(Integer.valueOf(4145), "Picture Mode");
    gb.put(Integer.valueOf(4146), "Makernote Unknown 1");
    gb.put(Integer.valueOf(4352), "Continuous Taking Or Auto Bracketting");
    gb.put(Integer.valueOf(4608), "Makernote Unknown 2");
    gb.put(Integer.valueOf(4864), "Blur Warning");
    gb.put(Integer.valueOf(4865), "Focus Warning");
    gb.put(Integer.valueOf(4866), "AE Warning");
  }
  
  public q()
  {
    a(new p(this));
  }
  
  protected HashMap<Integer, String> aA()
  {
    return gb;
  }
  
  public String getName()
  {
    return "FujiFilm Makernote";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */