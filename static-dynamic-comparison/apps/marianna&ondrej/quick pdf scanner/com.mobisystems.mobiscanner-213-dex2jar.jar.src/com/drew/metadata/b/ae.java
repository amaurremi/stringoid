package com.drew.metadata.b;

import com.drew.lang.BufferBoundsException;
import com.drew.metadata.c;
import java.util.HashMap;

public class ae
  extends com.drew.metadata.b
{
  protected static final HashMap<Integer, String> gb = new HashMap();
  
  static
  {
    gb.put(Integer.valueOf(1), "Quality Mode");
    gb.put(Integer.valueOf(2), "Version");
    gb.put(Integer.valueOf(3), "White Balance");
    gb.put(Integer.valueOf(7), "Focus Mode");
    gb.put(Integer.valueOf(15), "AF Area Mode");
    gb.put(Integer.valueOf(26), "Image Stabilization");
    gb.put(Integer.valueOf(28), "Macro Mode");
    gb.put(Integer.valueOf(31), "Record Mode");
    gb.put(Integer.valueOf(32), "Audio");
    gb.put(Integer.valueOf(37), "Internal Serial Number");
    gb.put(Integer.valueOf(33), "Unknown Data Dump");
    gb.put(Integer.valueOf(35), "White Balance Bias");
    gb.put(Integer.valueOf(36), "Flash Bias");
    gb.put(Integer.valueOf(38), "Exif Version");
    gb.put(Integer.valueOf(40), "Color Effect");
    gb.put(Integer.valueOf(41), "Camera Uptime");
    gb.put(Integer.valueOf(42), "Burst Mode");
    gb.put(Integer.valueOf(43), "Sequence Number");
    gb.put(Integer.valueOf(44), "Contrast Mode");
    gb.put(Integer.valueOf(45), "Noise Reduction");
    gb.put(Integer.valueOf(46), "Self Timer");
    gb.put(Integer.valueOf(48), "Rotation");
    gb.put(Integer.valueOf(49), "AF Assist Lamp");
    gb.put(Integer.valueOf(50), "Color Mode");
    gb.put(Integer.valueOf(51), "Baby Age");
    gb.put(Integer.valueOf(52), "Optical Zoom Mode");
    gb.put(Integer.valueOf(53), "Conversion Lens");
    gb.put(Integer.valueOf(54), "Travel Day");
    gb.put(Integer.valueOf(57), "Contrast");
    gb.put(Integer.valueOf(58), "World Time Location");
    gb.put(Integer.valueOf(59), "Text Stamp");
    gb.put(Integer.valueOf(60), "Program ISO");
    gb.put(Integer.valueOf(61), "Advanced Scene Mode");
    gb.put(Integer.valueOf(3584), "Print Image Matching (PIM) Info");
    gb.put(Integer.valueOf(63), "Number of Detected Faces");
    gb.put(Integer.valueOf(64), "Saturation");
    gb.put(Integer.valueOf(65), "Sharpness");
    gb.put(Integer.valueOf(66), "Film Mode");
    gb.put(Integer.valueOf(70), "White Balance Adjust (AB)");
    gb.put(Integer.valueOf(71), "White Balance Adjust (GM)");
    gb.put(Integer.valueOf(77), "Af Point Position");
    gb.put(Integer.valueOf(78), "Face Detection Info");
    gb.put(Integer.valueOf(81), "Lens Type");
    gb.put(Integer.valueOf(82), "Lens Serial Number");
    gb.put(Integer.valueOf(83), "Accessory Type");
    gb.put(Integer.valueOf(89), "Transform");
    gb.put(Integer.valueOf(93), "Intelligent Exposure");
    gb.put(Integer.valueOf(97), "Face Recognition Info");
    gb.put(Integer.valueOf(98), "Flash Warning");
    gb.put(Integer.valueOf(99), "Recognized Face Flags");
    gb.put(Integer.valueOf(101), "Title");
    gb.put(Integer.valueOf(102), "Baby Name");
    gb.put(Integer.valueOf(103), "Location");
    gb.put(Integer.valueOf(105), "Country");
    gb.put(Integer.valueOf(107), "State");
    gb.put(Integer.valueOf(109), "City");
    gb.put(Integer.valueOf(111), "Landmark");
    gb.put(Integer.valueOf(112), "Intelligent Resolution");
    gb.put(Integer.valueOf(32768), "Makernote Version");
    gb.put(Integer.valueOf(32769), "Scene Mode");
    gb.put(Integer.valueOf(32772), "White Balance (Red)");
    gb.put(Integer.valueOf(32773), "White Balance (Green)");
    gb.put(Integer.valueOf(32774), "White Balance (Blue)");
    gb.put(Integer.valueOf(32775), "Flash Fired");
    gb.put(Integer.valueOf(62), "Text Stamp 1");
    gb.put(Integer.valueOf(32776), "Text Stamp 2");
    gb.put(Integer.valueOf(32777), "Text Stamp 3");
    gb.put(Integer.valueOf(32784), "Baby Age 1");
    gb.put(Integer.valueOf(32786), "Transform 1");
  }
  
  public ae()
  {
    a(new ad(this));
  }
  
  protected HashMap<Integer, String> aA()
  {
    return gb;
  }
  
  public com.drew.metadata.a am(int paramInt)
  {
    String str = getString(paramInt);
    if (str == null) {
      return null;
    }
    return com.drew.metadata.a.b(str);
  }
  
  public c[] eA()
  {
    Object localObject = aa(78);
    if (localObject == null) {
      return null;
    }
    localObject = new com.drew.lang.b((byte[])localObject);
    ((com.drew.lang.a)localObject).f(false);
    try
    {
      int j = ((com.drew.lang.a)localObject).P(0);
      if (j == 0) {
        return null;
      }
      c[] arrayOfc = new c[j];
      int i = 0;
      while (i < j)
      {
        int k = i * 8 + 2;
        arrayOfc[i] = new c(((com.drew.lang.a)localObject).P(k), ((com.drew.lang.a)localObject).P(k + 2), ((com.drew.lang.a)localObject).P(k + 4), ((com.drew.lang.a)localObject).P(k + 6), null, null);
        i += 1;
      }
      return arrayOfc;
    }
    catch (BufferBoundsException localBufferBoundsException) {}
    return null;
  }
  
  public c[] eB()
  {
    Object localObject = aa(97);
    if (localObject == null) {
      return null;
    }
    localObject = new com.drew.lang.b((byte[])localObject);
    ((com.drew.lang.a)localObject).f(false);
    try
    {
      int j = ((com.drew.lang.a)localObject).P(0);
      if (j == 0) {
        return null;
      }
      c[] arrayOfc = new c[j];
      int i = 0;
      while (i < j)
      {
        int k = i * 44 + 4;
        String str1 = ((com.drew.lang.a)localObject).a(k, 20, "ASCII").trim();
        String str2 = ((com.drew.lang.a)localObject).a(k + 28, 20, "ASCII").trim();
        arrayOfc[i] = new c(((com.drew.lang.a)localObject).P(k + 20), ((com.drew.lang.a)localObject).P(k + 22), ((com.drew.lang.a)localObject).P(k + 24), ((com.drew.lang.a)localObject).P(k + 26), str1, com.drew.metadata.a.b(str2));
        i += 1;
      }
      return arrayOfc;
    }
    catch (BufferBoundsException localBufferBoundsException) {}
    return null;
  }
  
  public String getName()
  {
    return "Panasonic Makernote";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */