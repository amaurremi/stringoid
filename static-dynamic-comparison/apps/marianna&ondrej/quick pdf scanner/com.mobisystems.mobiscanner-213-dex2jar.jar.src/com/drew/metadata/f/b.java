package com.drew.metadata.f;

import java.util.HashMap;

public class b
  extends com.drew.metadata.b
{
  protected static final HashMap<Integer, String> gb = new HashMap();
  
  static
  {
    gb.put(Integer.valueOf(1000), "Channels, Rows, Columns, Depth, Mode");
    gb.put(Integer.valueOf(1001), "Mac Print Info");
    gb.put(Integer.valueOf(1002), "XML Data");
    gb.put(Integer.valueOf(1003), "Indexed Color Table");
    gb.put(Integer.valueOf(1005), "Resolution Info");
    gb.put(Integer.valueOf(1006), "Alpha Channels");
    gb.put(Integer.valueOf(1007), "Display Info");
    gb.put(Integer.valueOf(1008), "Caption");
    gb.put(Integer.valueOf(1009), "Border Information");
    gb.put(Integer.valueOf(1010), "Background Color");
    gb.put(Integer.valueOf(1011), "Print Flags");
    gb.put(Integer.valueOf(1012), "Grayscale and Multichannel Halftoning Information");
    gb.put(Integer.valueOf(1013), "Color Halftoning Information");
    gb.put(Integer.valueOf(1014), "Duotone Halftoning Information");
    gb.put(Integer.valueOf(1015), "Grayscale and Multichannel Transfer Function");
    gb.put(Integer.valueOf(1016), "Color Transfer Functions");
    gb.put(Integer.valueOf(1017), "Duotone Transfer Functions");
    gb.put(Integer.valueOf(1018), "Duotone Image Information");
    gb.put(Integer.valueOf(1019), "Effective Black and White Values");
    gb.put(Integer.valueOf(1021), "EPS Options");
    gb.put(Integer.valueOf(1022), "Quick Mask Information");
    gb.put(Integer.valueOf(1024), "Layer State Information");
    gb.put(Integer.valueOf(1026), "Layers Group Information");
    gb.put(Integer.valueOf(1028), "IPTC-NAA Record");
    gb.put(Integer.valueOf(1029), "Image Mode for Raw Format Files");
    gb.put(Integer.valueOf(1030), "JPEG Quality");
    gb.put(Integer.valueOf(1032), "Grid and Guides Information");
    gb.put(Integer.valueOf(1033), "Photoshop 4.0 Thumbnail");
    gb.put(Integer.valueOf(1034), "Copyright Flag");
    gb.put(Integer.valueOf(1035), "URL");
    gb.put(Integer.valueOf(1036), "Thumbnail Data");
    gb.put(Integer.valueOf(1037), "Global Angle");
    gb.put(Integer.valueOf(1041), "ICC Untagged Profile");
    gb.put(Integer.valueOf(1044), "Seed Number");
    gb.put(Integer.valueOf(1049), "Global Altitude");
    gb.put(Integer.valueOf(1050), "Slices");
    gb.put(Integer.valueOf(1054), "URL List");
    gb.put(Integer.valueOf(1057), "Version Info");
    gb.put(Integer.valueOf(1061), "Caption Digest");
    gb.put(Integer.valueOf(1062), "Print Scale");
    gb.put(Integer.valueOf(1064), "Pixel Aspect Ratio");
    gb.put(Integer.valueOf(1071), "Print Info");
    gb.put(Integer.valueOf(10000), "Print Flags Information");
  }
  
  public b()
  {
    a(new a(this));
  }
  
  protected HashMap<Integer, String> aA()
  {
    return gb;
  }
  
  public String getName()
  {
    return "Photoshop";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */