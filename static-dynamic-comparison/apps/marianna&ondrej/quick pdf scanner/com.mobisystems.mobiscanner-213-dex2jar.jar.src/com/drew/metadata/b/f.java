package com.drew.metadata.b;

import com.drew.metadata.b;
import java.util.HashMap;

public class f
  extends b
{
  protected static final HashMap<Integer, String> gb = new HashMap();
  
  static
  {
    gb.put(Integer.valueOf(2), "Thumbnail Dimensions");
    gb.put(Integer.valueOf(3), "Thumbnail Size");
    gb.put(Integer.valueOf(4), "Thumbnail Offset");
    gb.put(Integer.valueOf(8), "Quality Mode");
    gb.put(Integer.valueOf(9), "Image Size");
    gb.put(Integer.valueOf(13), "Focus Mode");
    gb.put(Integer.valueOf(20), "ISO Sensitivity");
    gb.put(Integer.valueOf(25), "White Balance");
    gb.put(Integer.valueOf(29), "Focal Length");
    gb.put(Integer.valueOf(31), "Saturation");
    gb.put(Integer.valueOf(32), "Contrast");
    gb.put(Integer.valueOf(33), "Sharpness");
    gb.put(Integer.valueOf(3584), "Print Image Matching (PIM) Info");
    gb.put(Integer.valueOf(8192), "Casio Preview Thumbnail");
    gb.put(Integer.valueOf(8209), "White Balance Bias");
    gb.put(Integer.valueOf(8210), "White Balance");
    gb.put(Integer.valueOf(8226), "Object Distance");
    gb.put(Integer.valueOf(8244), "Flash Distance");
    gb.put(Integer.valueOf(12288), "Record Mode");
    gb.put(Integer.valueOf(12289), "Self Timer");
    gb.put(Integer.valueOf(12290), "Quality");
    gb.put(Integer.valueOf(12291), "Focus Mode");
    gb.put(Integer.valueOf(12294), "Time Zone");
    gb.put(Integer.valueOf(12295), "BestShot Mode");
    gb.put(Integer.valueOf(12308), "CCD ISO Sensitivity");
    gb.put(Integer.valueOf(12309), "Colour Mode");
    gb.put(Integer.valueOf(12310), "Enhancement");
    gb.put(Integer.valueOf(12311), "Filter");
  }
  
  public f()
  {
    a(new e(this));
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */