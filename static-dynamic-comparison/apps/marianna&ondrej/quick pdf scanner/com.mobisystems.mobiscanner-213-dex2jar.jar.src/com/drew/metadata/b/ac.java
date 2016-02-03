package com.drew.metadata.b;

import com.drew.metadata.b;
import java.util.HashMap;

public class ac
  extends b
{
  protected static final HashMap<Integer, String> gb = new HashMap();
  
  static
  {
    gb.put(Integer.valueOf(512), "Special Mode");
    gb.put(Integer.valueOf(513), "Jpeg Quality");
    gb.put(Integer.valueOf(514), "Macro");
    gb.put(Integer.valueOf(515), "Makernote Unknown 1");
    gb.put(Integer.valueOf(516), "DigiZoom Ratio");
    gb.put(Integer.valueOf(517), "Makernote Unknown 2");
    gb.put(Integer.valueOf(518), "Makernote Unknown 3");
    gb.put(Integer.valueOf(519), "Firmware Version");
    gb.put(Integer.valueOf(520), "Pict Info");
    gb.put(Integer.valueOf(521), "Camera Id");
    gb.put(Integer.valueOf(3840), "Data Dump");
    gb.put(Integer.valueOf(0), "Makernote Version");
    gb.put(Integer.valueOf(1), "Camera Settings");
    gb.put(Integer.valueOf(3), "Camera Settings");
    gb.put(Integer.valueOf(64), "Compressed Image Size");
    gb.put(Integer.valueOf(129), "Thumbnail Offset");
    gb.put(Integer.valueOf(136), "Thumbnail Offset");
    gb.put(Integer.valueOf(137), "Thumbnail Length");
    gb.put(Integer.valueOf(257), "Colour Mode");
    gb.put(Integer.valueOf(258), "Image Quality");
    gb.put(Integer.valueOf(259), "Image Quality");
    gb.put(Integer.valueOf(524), "Image Height");
    gb.put(Integer.valueOf(523), "Image Width");
    gb.put(Integer.valueOf(525), "Original Manufacturer Model");
    gb.put(Integer.valueOf(3584), "Print Image Matching (PIM) Info");
    gb.put(Integer.valueOf(4100), "Flash Mode");
    gb.put(Integer.valueOf(4102), "Bracket");
    gb.put(Integer.valueOf(4107), "Focus Mode");
    gb.put(Integer.valueOf(4108), "Focus Distance");
    gb.put(Integer.valueOf(4109), "Zoom");
    gb.put(Integer.valueOf(4110), "Macro Focus");
    gb.put(Integer.valueOf(4111), "Sharpness");
    gb.put(Integer.valueOf(4113), "Colour Matrix");
    gb.put(Integer.valueOf(4114), "Black Level");
    gb.put(Integer.valueOf(4117), "White Balance");
    gb.put(Integer.valueOf(4119), "Red Bias");
    gb.put(Integer.valueOf(4120), "Blue Bias");
    gb.put(Integer.valueOf(4122), "Serial Number");
    gb.put(Integer.valueOf(4131), "Flash Bias");
    gb.put(Integer.valueOf(4137), "Contrast");
    gb.put(Integer.valueOf(4138), "Sharpness Factor");
    gb.put(Integer.valueOf(4139), "Colour Control");
    gb.put(Integer.valueOf(4140), "Valid Bits");
    gb.put(Integer.valueOf(4141), "Coring Filter");
    gb.put(Integer.valueOf(4142), "Final Width");
    gb.put(Integer.valueOf(4143), "Final Height");
    gb.put(Integer.valueOf(4148), "Compression Ratio");
  }
  
  public ac()
  {
    a(new ab(this));
  }
  
  protected HashMap<Integer, String> aA()
  {
    return gb;
  }
  
  public String getName()
  {
    return "Olympus Makernote";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */