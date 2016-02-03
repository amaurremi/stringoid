package com.drew.metadata.b;

import com.drew.metadata.f;

public class c
  extends f<d>
{
  public c(d paramd)
  {
    super(paramd);
  }
  
  public String aJ()
  {
    Integer localInteger = ((d)this.ga).Z(7);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Auto";
    case 2: 
      return "Tungsten";
    case 3: 
      return "Daylight";
    case 4: 
      return "Florescent";
    case 5: 
      return "Shade";
    }
    return "Manual";
  }
  
  public String aT()
  {
    Integer localInteger = ((d)this.ga).Z(11);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Normal";
    case 1: 
      return "Soft";
    }
    return "Hard";
  }
  
  public String aU()
  {
    Integer localInteger = ((d)this.ga).Z(13);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Normal";
    case 1: 
      return "Low";
    }
    return "High";
  }
  
  public String aV()
  {
    Integer localInteger = ((d)this.ga).Z(12);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Normal";
    case 1: 
      return "Low";
    }
    return "High";
  }
  
  public String ba()
  {
    Integer localInteger = ((d)this.ga).Z(4);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Auto";
    case 2: 
      return "On";
    case 3: 
      return "Off";
    }
    return "Red eye reduction";
  }
  
  public String bd()
  {
    Integer localInteger = ((d)this.ga).Z(2);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Economy";
    case 2: 
      return "Normal";
    }
    return "Fine";
  }
  
  public String be()
  {
    Integer localInteger = ((d)this.ga).Z(10);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 65536: 
      return "No digital zoom";
    case 65537: 
      return "2x digital zoom";
    case 131072: 
      return "2x digital zoom";
    }
    return "4x digital zoom";
  }
  
  public String bh()
  {
    Integer localInteger = ((d)this.ga).Z(20);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 64: 
      return "Normal";
    case 125: 
      return "+1.0";
    case 250: 
      return "+2.0";
    case 244: 
      return "+3.0";
    case 80: 
      return "Normal (ISO 80 equivalent)";
    }
    return "High";
  }
  
  public String bi()
  {
    Integer localInteger = ((d)this.ga).Z(6);
    if (localInteger == null) {
      return null;
    }
    return localInteger + " mm";
  }
  
  public String bj()
  {
    Integer localInteger = ((d)this.ga).Z(5);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 12: 
    case 14: 
    default: 
      return "Unknown (" + localInteger + ")";
    case 11: 
      return "Weak";
    case 13: 
      return "Normal";
    }
    return "Strong";
  }
  
  public String bk()
  {
    Integer localInteger = ((d)this.ga).Z(3);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 2: 
      return "Macro";
    case 3: 
      return "Auto focus";
    case 4: 
      return "Manual focus";
    }
    return "Infinity";
  }
  
  public String bl()
  {
    Integer localInteger = ((d)this.ga).Z(1);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Single shutter";
    case 2: 
      return "Panorama";
    case 3: 
      return "Night scene";
    case 4: 
      return "Portrait";
    }
    return "Landscape";
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    case 8: 
    case 9: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    default: 
      return super.getDescription(paramInt);
    case 1: 
      return bl();
    case 2: 
      return bd();
    case 3: 
      return bk();
    case 4: 
      return ba();
    case 5: 
      return bj();
    case 6: 
      return bi();
    case 7: 
      return aJ();
    case 10: 
      return be();
    case 11: 
      return aT();
    case 12: 
      return aV();
    case 13: 
      return aU();
    }
    return bh();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */