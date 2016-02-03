package com.drew.metadata.b;

import com.drew.metadata.b;
import java.util.HashMap;

public class w
  extends b
{
  protected static final HashMap<Integer, String> gb = new HashMap();
  
  static
  {
    gb.put(Integer.valueOf(1), "Proprietary Thumbnail Format Data");
    gb.put(Integer.valueOf(3584), "Print Image Matching (PIM) Info");
  }
  
  public w()
  {
    a(new v(this));
  }
  
  protected HashMap<Integer, String> aA()
  {
    return gb;
  }
  
  public String getName()
  {
    return "Kyocera/Contax Makernote";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */