package com.drew.metadata.b;

import com.drew.metadata.f;

public class a
  extends f<b>
{
  public a(b paramb)
  {
    super(paramb);
  }
  
  public String aG()
  {
    Integer localInteger = ((b)this.ga).Z(12);
    if (localInteger == null) {
      return null;
    }
    return String.format("%04X%05d", new Object[] { Integer.valueOf(localInteger.intValue() >> 8 & 0xFF), Integer.valueOf(localInteger.intValue() & 0xFF) });
  }
  
  public String aH()
  {
    Object localObject2 = ((b)this.ga).Z(49679);
    if (localObject2 == null) {
      return null;
    }
    int i = 0;
    Object localObject1 = localObject2;
    if (((Integer)localObject2).intValue() > 61440)
    {
      i = 1;
      localObject1 = Integer.valueOf(Integer.valueOf(65535 - ((Integer)localObject2).intValue()).intValue() + 1);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (i != 0) {}
    for (localObject2 = "-";; localObject2 = "") {
      return (String)localObject2 + Float.toString(((Integer)localObject1).intValue() / 32.0F) + " EV";
    }
  }
  
  public String aI()
  {
    Integer localInteger = ((b)this.ga).Z(49678);
    if (localInteger == null) {
      return null;
    }
    if ((localInteger.intValue() & 0x7) == 0) {
      return "Right";
    }
    if ((localInteger.intValue() & 0x7) == 1) {
      return "Centre";
    }
    if ((localInteger.intValue() & 0x7) == 2) {
      return "Left";
    }
    return "Unknown (" + localInteger + ")";
  }
  
  public String aJ()
  {
    Integer localInteger = ((b)this.ga).Z(49671);
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
      return "Sunny";
    case 2: 
      return "Cloudy";
    case 3: 
      return "Tungsten";
    case 4: 
      return "Florescent";
    case 5: 
      return "Flash";
    }
    return "Custom";
  }
  
  public String aK()
  {
    Integer localInteger = ((b)this.ga).Z(49440);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Single";
    }
    return "Continuous";
  }
  
  public String aL()
  {
    Integer localInteger = ((b)this.ga).Z(49437);
    if (localInteger == null) {
      return null;
    }
    if ((localInteger.intValue() >> 14 & 0x1) > 0) {
      return "External E-TTL";
    }
    if ((localInteger.intValue() >> 13 & 0x1) > 0) {
      return "Internal flash";
    }
    if ((localInteger.intValue() >> 11 & 0x1) > 0) {
      return "FP sync used";
    }
    if ((localInteger.intValue() >> 4 & 0x1) > 0) {
      return "FP sync enabled";
    }
    return "Unknown (" + localInteger + ")";
  }
  
  public String aM()
  {
    Integer localInteger = ((b)this.ga).Z(49433);
    if (localInteger == null) {
      return null;
    }
    if (localInteger.intValue() != 0) {
      return Integer.toString(localInteger.intValue());
    }
    return "";
  }
  
  public String aN()
  {
    Integer localInteger = ((b)this.ga).Z(49432);
    if (localInteger == null) {
      return null;
    }
    String str = aM();
    return Integer.toString(localInteger.intValue()) + " " + str;
  }
  
  public String aO()
  {
    Integer localInteger = ((b)this.ga).Z(49431);
    if (localInteger == null) {
      return null;
    }
    String str = aM();
    return Integer.toString(localInteger.intValue()) + " " + str;
  }
  
  public String aP()
  {
    Integer localInteger = ((b)this.ga).Z(49428);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Easy shooting";
    case 1: 
      return "Program";
    case 2: 
      return "Tv-priority";
    case 3: 
      return "Av-priority";
    case 4: 
      return "Manual";
    }
    return "A-DEP";
  }
  
  public String aQ()
  {
    Integer localInteger = ((b)this.ga).Z(49427);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 12288: 
      return "None (MF)";
    case 12289: 
      return "Auto selected";
    case 12290: 
      return "Right";
    case 12291: 
      return "Centre";
    }
    return "Left";
  }
  
  public String aR()
  {
    Integer localInteger = ((b)this.ga).Z(49425);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 3: 
      return "Evaluative";
    case 4: 
      return "Partial";
    }
    return "Centre weighted";
  }
  
  public String aS()
  {
    Integer localInteger = ((b)this.ga).Z(49424);
    if (localInteger == null) {
      return null;
    }
    if ((0x4000 & localInteger.intValue()) > 0) {
      return "" + (localInteger.intValue() & 0xBFFF);
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Not specified (see ISOSpeedRatings tag)";
    case 15: 
      return "Auto";
    case 16: 
      return "50";
    case 17: 
      return "100";
    case 18: 
      return "200";
    }
    return "400";
  }
  
  public String aT()
  {
    Integer localInteger = ((b)this.ga).Z(49423);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 65535: 
      return "Low";
    case 0: 
      return "Normal";
    }
    return "High";
  }
  
  public String aU()
  {
    Integer localInteger = ((b)this.ga).Z(49422);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 65535: 
      return "Low";
    case 0: 
      return "Normal";
    }
    return "High";
  }
  
  public String aV()
  {
    Integer localInteger = ((b)this.ga).Z(49421);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 65535: 
      return "Low";
    case 0: 
      return "Normal";
    }
    return "High";
  }
  
  public String aW()
  {
    Integer localInteger = ((b)this.ga).Z(49419);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Full auto";
    case 1: 
      return "Manual";
    case 2: 
      return "Landscape";
    case 3: 
      return "Fast shutter";
    case 4: 
      return "Slow shutter";
    case 5: 
      return "Night";
    case 6: 
      return "B&W";
    case 7: 
      return "Sepia";
    case 8: 
      return "Portrait";
    case 9: 
      return "Sports";
    case 10: 
      return "Macro / Closeup";
    }
    return "Pan focus";
  }
  
  public String aX()
  {
    Integer localInteger = ((b)this.ga).Z(49418);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Large";
    case 1: 
      return "Medium";
    }
    return "Small";
  }
  
  public String aY()
  {
    Integer localInteger = ((b)this.ga).Z(49415);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "One-shot";
    case 1: 
      return "AI Servo";
    case 2: 
      return "AI Focus";
    case 3: 
      return "Manual Focus";
    case 4: 
      return "Single";
    case 5: 
      return "Continuous";
    }
    return "Manual Focus";
  }
  
  public String aZ()
  {
    Integer localInteger = ((b)this.ga).Z(49413);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      localInteger = ((b)this.ga).Z(49410);
      if (localInteger != null)
      {
        if (localInteger.intValue() == 0) {
          return "Single shot";
        }
        return "Single shot with self-timer";
      }
      break;
    }
    return "Continuous";
  }
  
  public String ba()
  {
    Integer localInteger = ((b)this.ga).Z(49412);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "No flash fired";
    case 1: 
      return "Auto";
    case 2: 
      return "On";
    case 3: 
      return "Red-eye reduction";
    case 4: 
      return "Slow-synchro";
    case 5: 
      return "Auto and red-eye reduction";
    case 6: 
      return "On and red-eye reduction";
    }
    return "External flash";
  }
  
  public String bb()
  {
    Integer localInteger = ((b)this.ga).Z(49410);
    if (localInteger == null) {
      return null;
    }
    if (localInteger.intValue() == 0) {
      return "Self timer not used";
    }
    return Double.toString(localInteger.intValue() * 0.1D) + " sec";
  }
  
  public String bc()
  {
    Integer localInteger = ((b)this.ga).Z(49409);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Macro";
    }
    return "Normal";
  }
  
  public String bd()
  {
    Integer localInteger = ((b)this.ga).Z(49411);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 4: 
    default: 
      return "Unknown (" + localInteger + ")";
    case 2: 
      return "Normal";
    case 3: 
      return "Fine";
    }
    return "Superfine";
  }
  
  public String be()
  {
    Integer localInteger = ((b)this.ga).Z(49420);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "No digital zoom";
    case 1: 
      return "2x";
    }
    return "4x";
  }
  
  public String bf()
  {
    Integer localInteger = ((b)this.ga).Z(49426);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 2: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Manual";
    case 1: 
      return "Auto";
    case 3: 
      return "Close-up (Macro)";
    }
    return "Locked (Pan Mode)";
  }
  
  public String bg()
  {
    Integer localInteger = ((b)this.ga).Z(49436);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Flash did not fire";
    }
    return "Flash fired";
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 12: 
      return aG();
    case 49436: 
      return bg();
    case 49426: 
      return bf();
    case 49420: 
      return be();
    case 49411: 
      return bd();
    case 49409: 
      return bc();
    case 49410: 
      return bb();
    case 49412: 
      return ba();
    case 49413: 
      return aZ();
    case 49415: 
      return aY();
    case 49418: 
      return aX();
    case 49419: 
      return aW();
    case 49421: 
      return aV();
    case 49422: 
      return aU();
    case 49423: 
      return aT();
    case 49424: 
      return aS();
    case 49425: 
      return aR();
    case 49427: 
      return aQ();
    case 49428: 
      return aP();
    case 49431: 
      return aO();
    case 49432: 
      return aN();
    case 49433: 
      return aM();
    case 49437: 
      return aL();
    case 49440: 
      return aK();
    case 49671: 
      return aJ();
    case 49678: 
      return aI();
    }
    return aH();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */