package com.drew.metadata.b;

import com.drew.metadata.b;
import java.util.HashMap;

public class o
  extends b
{
  protected static final HashMap<Integer, String> gb = new HashMap();
  private byte[] gf;
  
  static
  {
    gb.put(Integer.valueOf(256), "Thumbnail Image Width");
    gb.put(Integer.valueOf(257), "Thumbnail Image Height");
    gb.put(Integer.valueOf(258), "Bits Per Sample");
    gb.put(Integer.valueOf(259), "Thumbnail Compression");
    gb.put(Integer.valueOf(262), "Photometric Interpretation");
    gb.put(Integer.valueOf(273), "Strip Offsets");
    gb.put(Integer.valueOf(274), "Orientation");
    gb.put(Integer.valueOf(277), "Samples Per Pixel");
    gb.put(Integer.valueOf(278), "Rows Per Strip");
    gb.put(Integer.valueOf(279), "Strip Byte Counts");
    gb.put(Integer.valueOf(282), "X Resolution");
    gb.put(Integer.valueOf(283), "Y Resolution");
    gb.put(Integer.valueOf(284), "Planar Configuration");
    gb.put(Integer.valueOf(296), "Resolution Unit");
    gb.put(Integer.valueOf(513), "Thumbnail Offset");
    gb.put(Integer.valueOf(514), "Thumbnail Length");
    gb.put(Integer.valueOf(529), "YCbCr Coefficients");
    gb.put(Integer.valueOf(530), "YCbCr Sub-Sampling");
    gb.put(Integer.valueOf(531), "YCbCr Positioning");
    gb.put(Integer.valueOf(532), "Reference Black/White");
  }
  
  public o()
  {
    a(new n(this));
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.gf = paramArrayOfByte;
  }
  
  protected HashMap<Integer, String> aA()
  {
    return gb;
  }
  
  public String getName()
  {
    return "Exif Thumbnail";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */