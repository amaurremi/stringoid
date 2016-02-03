package com.drew.metadata.b;

import com.drew.metadata.f;

public class af
  extends f<ag>
{
  public af(ag paramag)
  {
    super(paramag);
  }
  
  public String aJ()
  {
    Integer localInteger = ((ag)this.ga).Z(7);
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
      return "Daylight";
    case 2: 
      return "Shade";
    case 3: 
      return "Tungsten";
    case 4: 
      return "Fluorescent";
    }
    return "Manual";
  }
  
  public String aT()
  {
    Integer localInteger = ((ag)this.ga).Z(11);
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
    Integer localInteger = ((ag)this.ga).Z(13);
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
    Integer localInteger = ((ag)this.ga).Z(12);
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
    Integer localInteger = ((ag)this.ga).Z(4);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 3: 
    case 5: 
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Auto";
    case 2: 
      return "Flash On";
    case 4: 
      return "Flash Off";
    }
    return "Red-eye Reduction";
  }
  
  public String be()
  {
    Float localFloat = ((ag)this.ga).ac(10);
    if (localFloat == null) {
      return null;
    }
    if (localFloat.floatValue() == 0.0F) {
      return "Off";
    }
    return Float.toString(localFloat.floatValue());
  }
  
  public String cR()
  {
    Integer localInteger = ((ag)this.ga).Z(3);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 2: 
      return "Custom";
    }
    return "Auto";
  }
  
  public String eC()
  {
    Integer localInteger = ((ag)this.ga).Z(23);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Normal";
    case 2: 
      return "Black & White";
    }
    return "Sepia";
  }
  
  public String eD()
  {
    Integer localInteger = ((ag)this.ga).Z(20);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 10: 
      return "ISO 100";
    case 16: 
      return "ISO 200";
    case 100: 
      return "ISO 100";
    }
    return "ISO 200";
  }
  
  public String eE()
  {
    Integer localInteger = ((ag)this.ga).Z(2);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Good";
    case 1: 
      return "Better";
    }
    return "Best";
  }
  
  public String eF()
  {
    Integer localInteger = ((ag)this.ga).Z(1);
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
      return "Night-scene";
    case 3: 
      return "Manual";
    }
    return "Multiple";
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 21: 
    case 22: 
    default: 
      return super.getDescription(paramInt);
    case 1: 
      return eF();
    case 2: 
      return eE();
    case 3: 
      return cR();
    case 4: 
      return ba();
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
    case 20: 
      return eD();
    }
    return eC();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */