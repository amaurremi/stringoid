package com.drew.metadata.b;

import com.drew.lang.Rational;
import com.drew.metadata.f;

public class n
  extends f<o>
{
  private final boolean gc = true;
  
  public n(o paramo)
  {
    super(paramo);
  }
  
  public String bD()
  {
    String str = ((o)this.ga).getString(513);
    if (str == null) {
      return null;
    }
    return str + " bytes";
  }
  
  public String bG()
  {
    int[] arrayOfInt = ((o)this.ga).getIntArray(532);
    if (arrayOfInt == null) {
      return null;
    }
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = arrayOfInt[2];
    int m = arrayOfInt[3];
    int n = arrayOfInt[4];
    int i1 = arrayOfInt[5];
    return "[" + i + "," + k + "," + n + "] " + "[" + j + "," + m + "," + i1 + "]";
  }
  
  public String bH()
  {
    Object localObject = ((o)this.ga).ae(283);
    if (localObject == null) {
      return null;
    }
    String str = bL();
    localObject = new StringBuilder().append(((Rational)localObject).g(true)).append(" dots per ");
    if (str == null) {}
    for (str = "unit";; str = str.toLowerCase()) {
      return str;
    }
  }
  
  public String bI()
  {
    Object localObject = ((o)this.ga).ae(282);
    if (localObject == null) {
      return null;
    }
    String str = bL();
    localObject = new StringBuilder().append(((Rational)localObject).g(true)).append(" dots per ");
    if (str == null) {}
    for (str = "unit";; str = str.toLowerCase()) {
      return str;
    }
  }
  
  public String bJ()
  {
    Integer localInteger = ((o)this.ga).Z(531);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return String.valueOf(localInteger);
    case 1: 
      return "Center of pixel array";
    }
    return "Datum point";
  }
  
  public String bK()
  {
    Integer localInteger = ((o)this.ga).Z(274);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return String.valueOf(localInteger);
    case 1: 
      return "Top, left side (Horizontal / normal)";
    case 2: 
      return "Top, right side (Mirror horizontal)";
    case 3: 
      return "Bottom, right side (Rotate 180)";
    case 4: 
      return "Bottom, left side (Mirror vertical)";
    case 5: 
      return "Left side, top (Mirror horizontal and rotate 270 CW)";
    case 6: 
      return "Right side, top (Rotate 90 CW)";
    case 7: 
      return "Right side, bottom (Mirror horizontal and rotate 90 CW)";
    }
    return "Left side, bottom (Rotate 270 CW)";
  }
  
  public String bL()
  {
    Integer localInteger = ((o)this.ga).Z(296);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "";
    case 1: 
      return "(No unit)";
    case 2: 
      return "Inch";
    }
    return "cm";
  }
  
  public String cJ()
  {
    Integer localInteger = ((o)this.ga).Z(259);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown compression";
    case 1: 
      return "Uncompressed";
    case 2: 
      return "CCITT 1D";
    case 3: 
      return "T4/Group 3 Fax";
    case 4: 
      return "T6/Group 4 Fax";
    case 5: 
      return "LZW";
    case 6: 
      return "JPEG (old-style)";
    case 7: 
      return "JPEG";
    case 8: 
      return "Adobe Deflate";
    case 9: 
      return "JBIG B&W";
    case 10: 
      return "JBIG Color";
    case 32766: 
      return "Next";
    case 32771: 
      return "CCIRLEW";
    case 32773: 
      return "PackBits";
    case 32809: 
      return "Thunderscan";
    case 32895: 
      return "IT8CTPAD";
    case 32896: 
      return "IT8LW";
    case 32897: 
      return "IT8MP";
    case 32898: 
      return "IT8BL";
    case 32908: 
      return "PixarFilm";
    case 32909: 
      return "PixarLog";
    case 32946: 
      return "Deflate";
    case 32947: 
      return "DCS";
    case 32661: 
      return "JBIG";
    case 32676: 
      return "SGILog";
    case 32677: 
      return "SGILog24";
    case 32712: 
      return "JPEG 2000";
    }
    return "Nikon NEF Compressed";
  }
  
  public String cK()
  {
    String str = ((o)this.ga).getString(256);
    if (str == null) {
      return null;
    }
    return str + " pixels";
  }
  
  public String cL()
  {
    String str = ((o)this.ga).getString(257);
    if (str == null) {
      return null;
    }
    return str + " pixels";
  }
  
  public String cM()
  {
    String str = ((o)this.ga).getString(514);
    if (str == null) {
      return null;
    }
    return str + " bytes";
  }
  
  public String co()
  {
    int[] arrayOfInt = ((o)this.ga).getIntArray(530);
    if ((arrayOfInt == null) || (arrayOfInt.length < 2)) {
      return null;
    }
    if ((arrayOfInt[0] == 2) && (arrayOfInt[1] == 1)) {
      return "YCbCr4:2:2";
    }
    if ((arrayOfInt[0] == 2) && (arrayOfInt[1] == 2)) {
      return "YCbCr4:2:0";
    }
    return "(Unknown)";
  }
  
  public String cp()
  {
    Integer localInteger = ((o)this.ga).Z(284);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown configuration";
    case 1: 
      return "Chunky (contiguous for each subsampling pixel)";
    }
    return "Separate (Y-plane/Cb-plane/Cr-plane format)";
  }
  
  public String cq()
  {
    String str = ((o)this.ga).getString(277);
    if (str == null) {
      return null;
    }
    return str + " samples/pixel";
  }
  
  public String cr()
  {
    String str = ((o)this.ga).getString(278);
    if (str == null) {
      return null;
    }
    return str + " rows/strip";
  }
  
  public String cs()
  {
    String str = ((o)this.ga).getString(279);
    if (str == null) {
      return null;
    }
    return str + " bytes";
  }
  
  public String ct()
  {
    Integer localInteger = ((o)this.ga).Z(262);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown colour space";
    case 0: 
      return "WhiteIsZero";
    case 1: 
      return "BlackIsZero";
    case 2: 
      return "RGB";
    case 3: 
      return "RGB Palette";
    case 4: 
      return "Transparency Mask";
    case 5: 
      return "CMYK";
    case 6: 
      return "YCbCr";
    case 8: 
      return "CIELab";
    case 9: 
      return "ICCLab";
    case 10: 
      return "ITULab";
    case 32803: 
      return "Color Filter Array";
    case 32844: 
      return "Pixar LogL";
    case 32845: 
      return "Pixar LogLuv";
    }
    return "Linear Raw";
  }
  
  public String cu()
  {
    String str = ((o)this.ga).getString(258);
    if (str == null) {
      return null;
    }
    return str + " bits/component/pixel";
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 274: 
      return bK();
    case 296: 
      return bL();
    case 531: 
      return bJ();
    case 282: 
      return bI();
    case 283: 
      return bH();
    case 513: 
      return bD();
    case 514: 
      return cM();
    case 256: 
      return cK();
    case 257: 
      return cL();
    case 258: 
      return cu();
    case 259: 
      return cJ();
    case 262: 
      return ct();
    case 278: 
      return cr();
    case 279: 
      return cs();
    case 277: 
      return cq();
    case 284: 
      return cp();
    case 530: 
      return co();
    }
    return bG();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */