package com.drew.metadata.b;

public class e
  extends com.drew.metadata.f<f>
{
  public e(f paramf)
  {
    super(paramf);
  }
  
  public String aK()
  {
    Integer localInteger = ((f)this.ga).Z(12291);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Fixation";
    }
    return "Multi-Area Focus";
  }
  
  public String aT()
  {
    Integer localInteger = ((f)this.ga).Z(33);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "-1";
    case 1: 
      return "Normal";
    }
    return "+1";
  }
  
  public String aU()
  {
    Integer localInteger = ((f)this.ga).Z(31);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "-1";
    case 1: 
      return "Normal";
    }
    return "+1";
  }
  
  public String aV()
  {
    Integer localInteger = ((f)this.ga).Z(32);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "-1";
    case 1: 
      return "Normal";
    }
    return "+1";
  }
  
  public String aX()
  {
    Integer localInteger = ((f)this.ga).Z(9);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "640 x 480 pixels";
    case 4: 
      return "1600 x 1200 pixels";
    case 5: 
      return "2048 x 1536 pixels";
    case 20: 
      return "2288 x 1712 pixels";
    case 21: 
      return "2592 x 1944 pixels";
    case 22: 
      return "2304 x 1728 pixels";
    }
    return "3008 x 2008 pixels";
  }
  
  public String aY()
  {
    Integer localInteger = ((f)this.ga).Z(13);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Normal";
    }
    return "Macro";
  }
  
  public String bA()
  {
    Integer localInteger = ((f)this.ga).Z(25);
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
      return "Florescent";
    }
    return "Manual";
  }
  
  public String bB()
  {
    Integer localInteger = ((f)this.ga).Z(20);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 5: 
    case 7: 
    case 8: 
    default: 
      return "Unknown (" + localInteger + ")";
    case 3: 
      return "50";
    case 4: 
      return "64";
    case 6: 
      return "100";
    }
    return "200";
  }
  
  public String bC()
  {
    Integer localInteger = ((f)this.ga).Z(8);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Fine";
    }
    return "Super Fine";
  }
  
  public String bD()
  {
    return ((f)this.ga).getString(4);
  }
  
  public String bE()
  {
    Integer localInteger = ((f)this.ga).Z(3);
    if (localInteger == null) {
      return null;
    }
    return Integer.toString(localInteger.intValue()) + " bytes";
  }
  
  public String bF()
  {
    int[] arrayOfInt = ((f)this.ga).getIntArray(2);
    if ((arrayOfInt == null) || (arrayOfInt.length != 2)) {
      return ((f)this.ga).getString(2);
    }
    return arrayOfInt[0] + " x " + arrayOfInt[1] + " pixels";
  }
  
  public String bd()
  {
    Integer localInteger = ((f)this.ga).Z(12290);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    }
    return "Fine";
  }
  
  public String bi()
  {
    Integer localInteger = ((f)this.ga).Z(8226);
    if (localInteger == null) {
      return null;
    }
    return Integer.toString(localInteger.intValue()) + " mm";
  }
  
  public String bm()
  {
    Integer localInteger = ((f)this.ga).Z(12311);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    }
    return "Off";
  }
  
  public String bn()
  {
    Integer localInteger = ((f)this.ga).Z(12310);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    }
    return "Off";
  }
  
  public String bo()
  {
    Integer localInteger = ((f)this.ga).Z(12309);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    }
    return "Off";
  }
  
  public String bp()
  {
    Integer localInteger = ((f)this.ga).Z(12308);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Off";
    }
    return "On";
  }
  
  public String bq()
  {
    Integer localInteger = ((f)this.ga).Z(12295);
    if (localInteger == null) {
      return null;
    }
    localInteger.intValue();
    return "Unknown (" + localInteger + ")";
  }
  
  public String br()
  {
    return ((f)this.ga).getString(12294);
  }
  
  public String bs()
  {
    Integer localInteger = ((f)this.ga).Z(12289);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    }
    return "Off";
  }
  
  public String bt()
  {
    Integer localInteger = ((f)this.ga).Z(12288);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    }
    return "Normal";
  }
  
  public String bu()
  {
    Integer localInteger = ((f)this.ga).Z(8244);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    }
    return "Off";
  }
  
  public String bv()
  {
    Integer localInteger = ((f)this.ga).Z(8210);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Manual";
    case 1: 
      return "Auto";
    case 4: 
      return "Flash";
    }
    return "Flash";
  }
  
  public String bw()
  {
    return ((f)this.ga).getString(8209);
  }
  
  public String bx()
  {
    byte[] arrayOfByte = ((f)this.ga).aa(8192);
    if (arrayOfByte == null) {
      return null;
    }
    return "<" + arrayOfByte.length + " bytes of image data>";
  }
  
  public String by()
  {
    return ((f)this.ga).getString(3584);
  }
  
  public String bz()
  {
    Double localDouble = ((f)this.ga).ab(29);
    if (localDouble == null) {
      return null;
    }
    return Double.toString(localDouble.doubleValue() / 10.0D) + " mm";
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 2: 
      return bF();
    case 3: 
      return bE();
    case 4: 
      return bD();
    case 8: 
      return bC();
    case 9: 
      return aX();
    case 13: 
      return aY();
    case 20: 
      return bB();
    case 25: 
      return bA();
    case 29: 
      return bz();
    case 31: 
      return aU();
    case 32: 
      return aV();
    case 33: 
      return aT();
    case 3584: 
      return by();
    case 8192: 
      return bx();
    case 8209: 
      return bw();
    case 8210: 
      return bv();
    case 8226: 
      return bi();
    case 8244: 
      return bu();
    case 12288: 
      return bt();
    case 12289: 
      return bs();
    case 12290: 
      return bd();
    case 12291: 
      return aK();
    case 12294: 
      return br();
    case 12295: 
      return bq();
    case 12308: 
      return bp();
    case 12309: 
      return bo();
    case 12310: 
      return bn();
    }
    return bm();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */