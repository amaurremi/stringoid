package com.drew.metadata.b;

import com.drew.imaging.b;
import com.drew.lang.Rational;
import com.drew.metadata.f;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class l
  extends f<m>
{
  private static final DecimalFormat ge = new DecimalFormat("0.#");
  private final boolean gc = true;
  
  public l(m paramm)
  {
    super(paramm);
  }
  
  public String aJ()
  {
    Integer localInteger = ((m)this.ga).Z(37384);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Unknown";
    case 1: 
      return "Daylight";
    case 2: 
      return "Florescent";
    case 3: 
      return "Tungsten";
    case 10: 
      return "Flash";
    case 17: 
      return "Standard light";
    case 18: 
      return "Standard light (B)";
    case 19: 
      return "Standard light (C)";
    case 20: 
      return "D55";
    case 21: 
      return "D65";
    case 22: 
      return "D75";
    }
    return "(Other)";
  }
  
  public String aP()
  {
    Integer localInteger = ((m)this.ga).Z(41986);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Auto exposure";
    case 1: 
      return "Manual exposure";
    }
    return "Auto bracket";
  }
  
  public String aR()
  {
    Integer localInteger = ((m)this.ga).Z(37383);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "";
    case 0: 
      return "Unknown";
    case 1: 
      return "Average";
    case 2: 
      return "Center weighted average";
    case 3: 
      return "Spot";
    case 4: 
      return "Multi-spot";
    case 5: 
      return "Multi-segment";
    case 6: 
      return "Partial";
    }
    return "(Other)";
  }
  
  public String aT()
  {
    Integer localInteger = ((m)this.ga).Z(41994);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "None";
    case 1: 
      return "Low";
    }
    return "Hard";
  }
  
  public String aU()
  {
    Integer localInteger = ((m)this.ga).Z(41993);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "None";
    case 1: 
      return "Low saturation";
    }
    return "High saturation";
  }
  
  public String aV()
  {
    Integer localInteger = ((m)this.ga).Z(41992);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "None";
    case 1: 
      return "Soft";
    }
    return "Hard";
  }
  
  public String bT()
  {
    Integer localInteger = ((m)this.ga).Z(254);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Full-resolution image";
    case 2: 
      return "Reduced-resolution image";
    case 3: 
      return "Single page of multi-page reduced-resolution image";
    case 4: 
      return "Transparency mask";
    case 5: 
      return "Transparency mask of reduced-resolution image";
    case 6: 
      return "Transparency mask of multi-page image";
    }
    return "Transparency mask of reduced-resolution multi-page image";
  }
  
  public String bU()
  {
    Integer localInteger = ((m)this.ga).Z(255);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Full-resolution image";
    case 2: 
      return "Reduced-resolution image";
    }
    return "Single page of multi-page image";
  }
  
  public String bV()
  {
    Integer localInteger = ((m)this.ga).Z(263);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "No dithering or halftoning";
    case 2: 
      return "Ordered dither or halftone";
    }
    return "Randomized dither";
  }
  
  public String bW()
  {
    Integer localInteger = ((m)this.ga).Z(266);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Normal";
    }
    return "Reversed";
  }
  
  public String bX()
  {
    Integer localInteger = ((m)this.ga).Z(41996);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Unknown";
    case 1: 
      return "Macro";
    case 2: 
      return "Close view";
    }
    return "Distant view";
  }
  
  public String bY()
  {
    Integer localInteger = ((m)this.ga).Z(41991);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "None";
    case 1: 
      return "Low gain up";
    case 2: 
      return "Low gain down";
    case 3: 
      return "High gain up";
    }
    return "High gain down";
  }
  
  public String bZ()
  {
    Integer localInteger = ((m)this.ga).Z(41990);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Standard";
    case 1: 
      return "Landscape";
    case 2: 
      return "Portrait";
    }
    return "Night scene";
  }
  
  public String bz()
  {
    Rational localRational = ((m)this.ga).ae(37386);
    if (localRational == null) {
      return null;
    }
    DecimalFormat localDecimalFormat = new DecimalFormat("0.0##");
    return localDecimalFormat.format(localRational.doubleValue()) + " mm";
  }
  
  public String cA()
  {
    Integer localInteger = ((m)this.ga).Z(40961);
    if (localInteger == null) {
      return null;
    }
    if (localInteger.intValue() == 1) {
      return "sRGB";
    }
    if (localInteger.intValue() == 65535) {
      return "Undefined";
    }
    return "Unknown";
  }
  
  public String cB()
  {
    Integer localInteger = ((m)this.ga).Z(37385);
    if (localInteger == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if ((localInteger.intValue() & 0x1) != 0)
    {
      localStringBuilder.append("Flash fired");
      if ((localInteger.intValue() & 0x4) != 0)
      {
        if ((localInteger.intValue() & 0x2) == 0) {
          break label117;
        }
        localStringBuilder.append(", return detected");
      }
    }
    for (;;)
    {
      if ((localInteger.intValue() & 0x10) != 0) {
        localStringBuilder.append(", auto");
      }
      if ((localInteger.intValue() & 0x40) != 0) {
        localStringBuilder.append(", red-eye reduction");
      }
      return localStringBuilder.toString();
      localStringBuilder.append("Flash did not fire");
      break;
      label117:
      localStringBuilder.append(", return not detected");
    }
  }
  
  public String cC()
  {
    Rational localRational = ((m)this.ga).ae(37382);
    if (localRational == null) {
      return null;
    }
    DecimalFormat localDecimalFormat = new DecimalFormat("0.0##");
    return localDecimalFormat.format(localRational.doubleValue()) + " metres";
  }
  
  public String cD()
  {
    Rational localRational = ((m)this.ga).ae(37122);
    if (localRational == null) {
      return null;
    }
    String str = localRational.g(true);
    if ((localRational.aw()) && (localRational.intValue() == 1)) {
      return str + " bit/pixel";
    }
    return str + " bits/pixel";
  }
  
  public String cE()
  {
    String str = ((m)this.ga).getString(33434);
    if (str == null) {
      return null;
    }
    return str + " sec";
  }
  
  public String cF()
  {
    Float localFloat = ((m)this.ga).ac(37377);
    if (localFloat == null) {
      return null;
    }
    if (localFloat.floatValue() <= 1.0F)
    {
      float f = (float)Math.round((float)(1.0D / Math.exp(localFloat.floatValue() * Math.log(2.0D))) * 10.0D) / 10.0F;
      return f + " sec";
    }
    int i = (int)Math.exp(localFloat.floatValue() * Math.log(2.0D));
    return "1/" + i + " sec";
  }
  
  public String cG()
  {
    Rational localRational = ((m)this.ga).ae(33437);
    if (localRational == null) {
      return null;
    }
    return "F" + ge.format(localRational.doubleValue());
  }
  
  public String cH()
  {
    Integer localInteger = ((m)this.ga).Z(41495);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 6: 
    default: 
      return "";
    case 1: 
      return "(Not defined)";
    case 2: 
      return "One-chip color area sensor";
    case 3: 
      return "Two-chip color area sensor";
    case 4: 
      return "Three-chip color area sensor";
    case 5: 
      return "Color sequential area sensor";
    case 7: 
      return "Trilinear sensor";
    }
    return "Color sequential linear sensor";
  }
  
  public String cI()
  {
    int[] arrayOfInt = ((m)this.ga).getIntArray(37121);
    if (arrayOfInt == null) {
      return null;
    }
    String[] arrayOfString = new String[7];
    arrayOfString[0] = "";
    arrayOfString[1] = "Y";
    arrayOfString[2] = "Cb";
    arrayOfString[3] = "Cr";
    arrayOfString[4] = "R";
    arrayOfString[5] = "G";
    arrayOfString[6] = "B";
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < Math.min(4, arrayOfInt.length))
    {
      int j = arrayOfInt[i];
      if ((j > 0) && (j < arrayOfString.length)) {
        localStringBuilder.append(arrayOfString[j]);
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public String ca()
  {
    Integer localInteger = ((m)this.ga).Z(41989);
    if (localInteger == null) {
      return null;
    }
    if (localInteger.intValue() == 0) {
      return "Unknown";
    }
    return ge.format(localInteger) + "mm";
  }
  
  public String cb()
  {
    Rational localRational = ((m)this.ga).ae(41988);
    if (localRational == null) {
      return null;
    }
    if (localRational.au() == 0L) {
      return "Digital zoom not used.";
    }
    return ge.format(localRational.doubleValue());
  }
  
  public String cc()
  {
    Integer localInteger = ((m)this.ga).Z(41987);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Auto white balance";
    }
    return "Manual white balance";
  }
  
  public String cd()
  {
    Integer localInteger = ((m)this.ga).Z(41985);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Normal process";
    }
    return "Custom process";
  }
  
  public String ce()
  {
    Object localObject1 = ((m)this.ga).aa(37510);
    if (localObject1 == null) {
      return null;
    }
    if (localObject1.length == 0) {
      return "";
    }
    Object localObject2 = new HashMap();
    ((Map)localObject2).put("ASCII", System.getProperty("file.encoding"));
    ((Map)localObject2).put("UNICODE", "UTF-16LE");
    ((Map)localObject2).put("JIS", "Shift-JIS");
    for (;;)
    {
      int i;
      try
      {
        if (localObject1.length >= 10)
        {
          String str1 = new String((byte[])localObject1, 0, 10);
          localObject2 = ((Map)localObject2).entrySet().iterator();
          if (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
            String str2 = (String)((Map.Entry)localObject3).getKey();
            localObject3 = (String)((Map.Entry)localObject3).getValue();
            if (!str1.startsWith(str2)) {
              continue;
            }
            i = str2.length();
            if (i < 10)
            {
              int j = localObject1[i];
              if ((j == 0) || (j == 32)) {
                break label261;
              }
              return new String((byte[])localObject1, i, localObject1.length - i, (String)localObject3).trim();
            }
            return new String((byte[])localObject1, 10, localObject1.length - 10, (String)localObject3).trim();
          }
        }
        localObject1 = new String((byte[])localObject1, System.getProperty("file.encoding")).trim();
        return (String)localObject1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        return null;
      }
      label261:
      i += 1;
    }
  }
  
  public String cf()
  {
    Integer localInteger = ((m)this.ga).Z(34855);
    if (localInteger == null) {
      return null;
    }
    return Integer.toString(localInteger.intValue());
  }
  
  public String cg()
  {
    int[] arrayOfInt = ((m)this.ga).getIntArray(36864);
    if (arrayOfInt == null) {
      return null;
    }
    return a(arrayOfInt, 2);
  }
  
  public String ch()
  {
    int[] arrayOfInt = ((m)this.ga).getIntArray(40960);
    if (arrayOfInt == null) {
      return null;
    }
    return a(arrayOfInt, 2);
  }
  
  public String ci()
  {
    Integer localInteger = ((m)this.ga).Z(41729);
    if (localInteger == null) {
      return null;
    }
    if (localInteger.intValue() == 1) {
      return "Directly photographed image";
    }
    return "Unknown (" + localInteger + ")";
  }
  
  public String cj()
  {
    Integer localInteger = ((m)this.ga).Z(41728);
    if (localInteger == null) {
      return null;
    }
    if (localInteger.intValue() == 3) {
      return "Digital Still Camera (DSC)";
    }
    return "Unknown (" + localInteger + ")";
  }
  
  public String ck()
  {
    Rational localRational = ((m)this.ga).ae(37380);
    if (localRational == null) {
      return null;
    }
    return localRational.g(true) + " EV";
  }
  
  public String cl()
  {
    Double localDouble = ((m)this.ga).ab(37381);
    if (localDouble == null) {
      return null;
    }
    double d = b.b(localDouble.doubleValue());
    return "F" + ge.format(d);
  }
  
  public String cm()
  {
    Double localDouble = ((m)this.ga).ab(37378);
    if (localDouble == null) {
      return null;
    }
    double d = b.b(localDouble.doubleValue());
    return "F" + ge.format(d);
  }
  
  public String cn()
  {
    Integer localInteger = ((m)this.ga).Z(34850);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown program (" + localInteger + ")";
    case 1: 
      return "Manual control";
    case 2: 
      return "Program normal";
    case 3: 
      return "Aperture priority";
    case 4: 
      return "Shutter priority";
    case 5: 
      return "Program creative (slow program)";
    case 6: 
      return "Program action (high-speed program)";
    case 7: 
      return "Portrait mode";
    }
    return "Landscape mode";
  }
  
  public String co()
  {
    int[] arrayOfInt = ((m)this.ga).getIntArray(530);
    if (arrayOfInt == null) {
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
    Integer localInteger = ((m)this.ga).Z(284);
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
    String str = ((m)this.ga).getString(277);
    if (str == null) {
      return null;
    }
    return str + " samples/pixel";
  }
  
  public String cr()
  {
    String str = ((m)this.ga).getString(278);
    if (str == null) {
      return null;
    }
    return str + " rows/strip";
  }
  
  public String cs()
  {
    String str = ((m)this.ga).getString(279);
    if (str == null) {
      return null;
    }
    return str + " bytes";
  }
  
  public String ct()
  {
    Integer localInteger = ((m)this.ga).Z(262);
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
    String str = ((m)this.ga).getString(258);
    if (str == null) {
      return null;
    }
    return str + " bits/component/pixel";
  }
  
  public String cv()
  {
    Object localObject = ((m)this.ga).ae(41486);
    if (localObject == null) {
      return null;
    }
    String str = cx();
    localObject = new StringBuilder().append(((Rational)localObject).av().g(true));
    if (str == null) {}
    for (str = "";; str = " " + str.toLowerCase()) {
      return str;
    }
  }
  
  public String cw()
  {
    Object localObject = ((m)this.ga).ae(41487);
    if (localObject == null) {
      return null;
    }
    String str = cx();
    localObject = new StringBuilder().append(((Rational)localObject).av().g(true));
    if (str == null) {}
    for (str = "";; str = " " + str.toLowerCase()) {
      return str;
    }
  }
  
  public String cx()
  {
    Integer localInteger = ((m)this.ga).Z(41488);
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
      return "Inches";
    }
    return "cm";
  }
  
  public String cy()
  {
    Integer localInteger = ((m)this.ga).Z(40962);
    if (localInteger == null) {
      return null;
    }
    return localInteger + " pixels";
  }
  
  public String cz()
  {
    Integer localInteger = ((m)this.ga).Z(40963);
    if (localInteger == null) {
      return null;
    }
    return localInteger + " pixels";
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 254: 
      return bT();
    case 255: 
      return bU();
    case 263: 
      return bV();
    case 266: 
      return bW();
    case 33434: 
      return cE();
    case 37377: 
      return cF();
    case 33437: 
      return cG();
    case 37122: 
      return cD();
    case 37382: 
      return cC();
    case 37383: 
      return aR();
    case 37384: 
      return aJ();
    case 37385: 
      return cB();
    case 37386: 
      return bz();
    case 40961: 
      return cA();
    case 40962: 
      return cy();
    case 40963: 
      return cz();
    case 41488: 
      return cx();
    case 41486: 
      return cv();
    case 41487: 
      return cw();
    case 258: 
      return cu();
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
    case 34850: 
      return cn();
    case 37378: 
      return cm();
    case 37381: 
      return cl();
    case 41495: 
      return cH();
    case 37380: 
      return ck();
    case 41728: 
      return cj();
    case 41729: 
      return ci();
    case 37121: 
      return cI();
    case 36864: 
      return cg();
    case 40960: 
      return ch();
    case 34855: 
      return cf();
    case 37510: 
      return ce();
    case 41985: 
      return cd();
    case 41986: 
      return aP();
    case 41987: 
      return cc();
    case 41988: 
      return cb();
    case 41989: 
      return ca();
    case 41990: 
      return bZ();
    case 41991: 
      return bY();
    case 41992: 
      return aV();
    case 41993: 
      return aU();
    case 41994: 
      return aT();
    }
    return bX();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */