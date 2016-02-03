package com.drew.metadata.b;

import com.drew.lang.Rational;
import com.drew.metadata.f;

public class x
  extends f<y>
{
  public x(y paramy)
  {
    super(paramy);
  }
  
  public String aJ()
  {
    Integer localInteger = ((y)this.ga).Z(7);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Auto";
    case 1: 
      return "Preset";
    case 2: 
      return "Daylight";
    case 3: 
      return "Incandescence";
    case 4: 
      return "Florescence";
    case 5: 
      return "Cloudy";
    }
    return "SpeedLight";
  }
  
  public String bd()
  {
    Integer localInteger = ((y)this.ga).Z(3);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "VGA Basic";
    case 2: 
      return "VGA Normal";
    case 3: 
      return "VGA Fine";
    case 4: 
      return "SXGA Basic";
    case 5: 
      return "SXGA Normal";
    }
    return "SXGA Fine";
  }
  
  public String be()
  {
    Rational localRational = ((y)this.ga).ae(10);
    if (localRational == null) {
      return null;
    }
    if (localRational.au() == 0L) {
      return "No digital zoom";
    }
    return localRational.g(true) + "x digital zoom";
  }
  
  public String bh()
  {
    Integer localInteger = ((y)this.ga).Z(6);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 1: 
    case 3: 
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "ISO80";
    case 2: 
      return "ISO160";
    case 4: 
      return "ISO320";
    }
    return "ISO100";
  }
  
  public String dl()
  {
    Integer localInteger = ((y)this.ga).Z(11);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "None";
    }
    return "Fisheye converter";
  }
  
  public String dm()
  {
    Rational localRational = ((y)this.ga).ae(8);
    if (localRational == null) {
      return null;
    }
    if ((localRational.au() == 1L) && (localRational.at() == 0L)) {
      return "Infinite";
    }
    return localRational.g(true);
  }
  
  public String dn()
  {
    Integer localInteger = ((y)this.ga).Z(5);
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
      return "Bright +";
    case 2: 
      return "Bright -";
    case 3: 
      return "Contrast +";
    }
    return "Contrast -";
  }
  
  public String jdMethod_do()
  {
    Integer localInteger = ((y)this.ga).Z(4);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Color";
    }
    return "Monochrome";
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    case 9: 
    default: 
      return super.getDescription(paramInt);
    case 3: 
      return bd();
    case 4: 
      return jdMethod_do();
    case 5: 
      return dn();
    case 6: 
      return bh();
    case 7: 
      return aJ();
    case 8: 
      return dm();
    case 10: 
      return be();
    }
    return dl();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */