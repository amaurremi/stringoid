package com.drew.metadata.b;

import com.drew.metadata.b;
import java.util.HashMap;

public class ak
  extends b
{
  protected static final HashMap<Integer, String> gb = new HashMap();
  
  static
  {
    gb.put(Integer.valueOf(3584), "Print Image Matching Info");
    gb.put(Integer.valueOf(8193), "Preview Image");
    gb.put(Integer.valueOf(45088), "Color Mode Setting");
    gb.put(Integer.valueOf(45089), "Color Temperature");
    gb.put(Integer.valueOf(45091), "Scene Mode");
    gb.put(Integer.valueOf(45092), "Zone Matching");
    gb.put(Integer.valueOf(45093), "Dynamic Range Optimizer");
    gb.put(Integer.valueOf(45094), "Image Stabilisation");
    gb.put(Integer.valueOf(45095), "Lens ID");
    gb.put(Integer.valueOf(45096), "Minolta Maker Note");
    gb.put(Integer.valueOf(45097), "Color Mode");
    gb.put(Integer.valueOf(45120), "Macro");
    gb.put(Integer.valueOf(45121), "Exposure Mode");
    gb.put(Integer.valueOf(45127), "Quality");
    gb.put(Integer.valueOf(45131), "Anti Blur");
    gb.put(Integer.valueOf(45134), "Long Exposure Noise Reduction");
    gb.put(Integer.valueOf(65535), "No Print");
  }
  
  public ak()
  {
    a(new aj(this));
  }
  
  protected HashMap<Integer, String> aA()
  {
    return gb;
  }
  
  public String getName()
  {
    return "Sony Makernote";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */