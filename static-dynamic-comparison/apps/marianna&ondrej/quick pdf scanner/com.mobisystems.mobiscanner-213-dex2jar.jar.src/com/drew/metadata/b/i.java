package com.drew.metadata.b;

import com.drew.metadata.f;

public class i
  extends f<j>
{
  public i(j paramj)
  {
    super(paramj);
  }
  
  public String bR()
  {
    return a(((j)this.ga).getIntArray(2), 2);
  }
  
  public String bS()
  {
    String str = ((j)this.ga).getString(1);
    if (str == null) {
      return null;
    }
    if ("R98".equalsIgnoreCase(str.trim())) {
      return "Recommended Exif Interoperability Rules (ExifR98)";
    }
    return "Unknown (" + str + ")";
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 1: 
      return bS();
    }
    return bR();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */