package com.drew.metadata.b;

import com.drew.lang.Rational;
import com.drew.lang.e;
import com.drew.metadata.f;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class z
  extends f<aa>
{
  public z(aa paramaa)
  {
    super(paramaa);
  }
  
  private static String a(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {}
    while ((paramArrayOfInt.length < 3) || (paramArrayOfInt[2] == 0)) {
      return null;
    }
    DecimalFormat localDecimalFormat = new DecimalFormat("0.##");
    double d = paramArrayOfInt[0] * paramArrayOfInt[1] / paramArrayOfInt[2];
    return localDecimalFormat.format(d) + " EV";
  }
  
  public String be()
  {
    Rational localRational = ((aa)this.ga).ae(134);
    if (localRational == null) {
      return null;
    }
    if (localRational.intValue() == 1) {
      return "No digital zoom";
    }
    return localRational.g(true) + "x digital zoom";
  }
  
  public String cA()
  {
    Integer localInteger = ((aa)this.ga).Z(30);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "sRGB";
    }
    return "Adobe RGB";
  }
  
  public String dA()
  {
    return a(((aa)this.ga).getIntArray(18));
  }
  
  public String dB()
  {
    return a(((aa)this.ga).getIntArray(23));
  }
  
  public String dC()
  {
    return a(((aa)this.ga).getIntArray(24));
  }
  
  public String dD()
  {
    return a(((aa)this.ga).getIntArray(28));
  }
  
  public String dE()
  {
    return a(((aa)this.ga).getIntArray(139));
  }
  
  public String dF()
  {
    int[] arrayOfInt = ((aa)this.ga).getIntArray(2);
    if (arrayOfInt == null) {
      return null;
    }
    if ((arrayOfInt[0] != 0) || (arrayOfInt[1] == 0)) {
      return "Unknown (" + ((aa)this.ga).getString(2) + ")";
    }
    return "ISO " + arrayOfInt[1];
  }
  
  public String dG()
  {
    Rational[] arrayOfRational = ((aa)this.ga).af(132);
    if (arrayOfRational == null) {
      return null;
    }
    if (arrayOfRational.length < 4) {
      return ((aa)this.ga).getString(132);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(arrayOfRational[0].intValue());
    localStringBuilder.append('-');
    localStringBuilder.append(arrayOfRational[1].intValue());
    localStringBuilder.append("mm f/");
    localStringBuilder.append(arrayOfRational[2].floatValue());
    localStringBuilder.append('-');
    localStringBuilder.append(arrayOfRational[3].floatValue());
    return localStringBuilder.toString();
  }
  
  public String dH()
  {
    String str = ((aa)this.ga).getString(146);
    if (str == null) {
      return null;
    }
    return str + " degrees";
  }
  
  public String dI()
  {
    int[] arrayOfInt = ((aa)this.ga).getIntArray(1);
    if (arrayOfInt == null) {
      return null;
    }
    return l.a(arrayOfInt, 2);
  }
  
  public String jdMethod_do()
  {
    String str2 = ((aa)this.ga).getString(141);
    String str1;
    if (str2 == null) {
      str1 = null;
    }
    do
    {
      return str1;
      str1 = str2;
    } while (!str2.startsWith("MODE1"));
    return "Mode I (sRGB)";
  }
  
  public String dp()
  {
    Long localLong = ((aa)this.ga).ad(182);
    if (localLong == null) {
      return null;
    }
    return new Date(localLong.longValue()).toString();
  }
  
  public String dq()
  {
    Integer localInteger = ((aa)this.ga).Z(177);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 3: 
    case 5: 
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Off";
    case 1: 
      return "Minimal";
    case 2: 
      return "Low";
    case 4: 
      return "Normal";
    }
    return "High";
  }
  
  public String dr()
  {
    Integer localInteger = ((aa)this.ga).Z(135);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 2: 
    case 4: 
    case 5: 
    case 6: 
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Flash Not Used";
    case 1: 
      return "Manual Flash";
    case 3: 
      return "Flash Not Ready";
    case 7: 
      return "External Flash";
    case 8: 
      return "Fired, Commander Mode";
    }
    return "Fired, TTL Mode";
  }
  
  public String ds()
  {
    Integer localInteger = ((aa)this.ga).Z(147);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 2: 
    case 4: 
    case 5: 
    case 6: 
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Lossy (Type 1)";
    case 3: 
      return "Uncompressed";
    case 7: 
      return "Lossless";
    }
    return "Lossy (Type 2)";
  }
  
  public String dt()
  {
    Integer localInteger = ((aa)this.ga).Z(137);
    if (localInteger == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if ((localInteger.intValue() & 0x1) == 1) {
      localArrayList.add("Continuous");
    }
    for (;;)
    {
      if ((localInteger.intValue() & 0x2) == 2) {
        localArrayList.add("Delay");
      }
      if ((localInteger.intValue() & 0x8) == 8) {
        localArrayList.add("PC Control");
      }
      if ((localInteger.intValue() & 0x10) == 16) {
        localArrayList.add("Exposure Bracketing");
      }
      if ((localInteger.intValue() & 0x20) == 32) {
        localArrayList.add("Auto ISO");
      }
      if ((localInteger.intValue() & 0x40) == 64) {
        localArrayList.add("White-Balance Bracketing");
      }
      if ((localInteger.intValue() & 0x80) == 128) {
        localArrayList.add("IR Control");
      }
      return e.a(localArrayList, ", ");
      localArrayList.add("Single Frame");
    }
  }
  
  public String du()
  {
    Integer localInteger = ((aa)this.ga).Z(131);
    if (localInteger == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if ((localInteger.intValue() & 0x1) == 1) {
      localArrayList.add("MF");
    }
    for (;;)
    {
      if ((localInteger.intValue() & 0x2) == 2) {
        localArrayList.add("D");
      }
      if ((localInteger.intValue() & 0x4) == 4) {
        localArrayList.add("G");
      }
      if ((localInteger.intValue() & 0x8) == 8) {
        localArrayList.add("VR");
      }
      return e.a(localArrayList, ", ");
      localArrayList.add("AF");
    }
  }
  
  public String dv()
  {
    Integer localInteger = ((aa)this.ga).Z(34);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Off";
    case 1: 
      return "Light";
    case 3: 
      return "Normal";
    case 5: 
      return "High";
    case 7: 
      return "Extra High";
    }
    return "Auto";
  }
  
  public String dw()
  {
    Integer localInteger = ((aa)this.ga).Z(42);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 2: 
    case 4: 
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Off";
    case 1: 
      return "Low";
    case 3: 
      return "Normal";
    }
    return "High";
  }
  
  public String dx()
  {
    int[] arrayOfInt = ((aa)this.ga).getIntArray(136);
    if (arrayOfInt == null) {
      return null;
    }
    if ((arrayOfInt.length != 4) || (arrayOfInt[0] != 0) || (arrayOfInt[2] != 0) || (arrayOfInt[3] != 0)) {
      return "Unknown (" + ((aa)this.ga).getString(136) + ")";
    }
    switch (arrayOfInt[1])
    {
    default: 
      return "Unknown (" + arrayOfInt[1] + ")";
    case 0: 
      return "Centre";
    case 1: 
      return "Top";
    case 2: 
      return "Bottom";
    case 3: 
      return "Left";
    }
    return "Right";
  }
  
  public String dy()
  {
    return a(((aa)this.ga).getIntArray(13));
  }
  
  public String dz()
  {
    return a(((aa)this.ga).getIntArray(14));
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 13: 
      return dy();
    case 14: 
      return dz();
    case 132: 
      return dG();
    case 146: 
      return dH();
    case 141: 
      return jdMethod_do();
    case 18: 
      return dA();
    case 23: 
      return dB();
    case 24: 
      return dC();
    case 28: 
      return dD();
    case 139: 
      return dE();
    case 30: 
      return cA();
    case 34: 
      return dv();
    case 42: 
      return dw();
    case 2: 
      return dF();
    case 134: 
      return be();
    case 135: 
      return dr();
    case 136: 
      return dx();
    case 1: 
      return dI();
    case 131: 
      return du();
    case 137: 
      return dt();
    case 147: 
      return ds();
    case 177: 
      return dq();
    }
    return dp();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */