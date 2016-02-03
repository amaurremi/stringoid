package com.drew.metadata.b;

import com.drew.lang.Rational;
import com.drew.lang.c;
import com.drew.metadata.f;
import java.text.DecimalFormat;

public class r
  extends f<s>
{
  public r(s params)
  {
    super(params);
  }
  
  private String cY()
  {
    return a(((s)this.ga).getIntArray(0), 1);
  }
  
  public String ai(int paramInt)
  {
    Object localObject = ((s)this.ga).ae(paramInt);
    if (localObject != null) {}
    for (localObject = new DecimalFormat("0.##").format(((Rational)localObject).doubleValue()); (localObject == null) || (((String)localObject).trim().length() == 0); localObject = ((s)this.ga).getString(paramInt)) {
      return null;
    }
    return ((String)localObject).trim() + " degrees";
  }
  
  public String aj(int paramInt)
  {
    String str = ((s)this.ga).getString(paramInt);
    if (str == null) {
      return null;
    }
    str = str.trim();
    if ("T".equalsIgnoreCase(str)) {
      return "True direction";
    }
    if ("M".equalsIgnoreCase(str)) {
      return "Magnetic direction";
    }
    return "Unknown (" + str + ")";
  }
  
  public String cZ()
  {
    c localc = ((s)this.ga).dj();
    if (localc == null) {
      return null;
    }
    return c.c(localc.getLatitude());
  }
  
  public String da()
  {
    c localc = ((s)this.ga).dj();
    if (localc == null) {
      return null;
    }
    return c.c(localc.getLongitude());
  }
  
  public String db()
  {
    int[] arrayOfInt = ((s)this.ga).getIntArray(7);
    if (arrayOfInt == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(arrayOfInt[0]);
    localStringBuilder.append(":");
    localStringBuilder.append(arrayOfInt[1]);
    localStringBuilder.append(":");
    localStringBuilder.append(arrayOfInt[2]);
    localStringBuilder.append(" UTC");
    return localStringBuilder.toString();
  }
  
  public String dc()
  {
    String str = ((s)this.ga).getString(25);
    if (str == null) {
      return null;
    }
    str = str.trim();
    if ("K".equalsIgnoreCase(str)) {
      return "kilometers";
    }
    if ("M".equalsIgnoreCase(str)) {
      return "miles";
    }
    if ("N".equalsIgnoreCase(str)) {
      return "knots";
    }
    return "Unknown (" + str + ")";
  }
  
  public String dd()
  {
    String str = ((s)this.ga).getString(12);
    if (str == null) {
      return null;
    }
    str = str.trim();
    if ("K".equalsIgnoreCase(str)) {
      return "kph";
    }
    if ("M".equalsIgnoreCase(str)) {
      return "mph";
    }
    if ("N".equalsIgnoreCase(str)) {
      return "knots";
    }
    return "Unknown (" + str + ")";
  }
  
  public String de()
  {
    String str = ((s)this.ga).getString(10);
    if (str == null) {
      return null;
    }
    str = str.trim();
    if ("2".equalsIgnoreCase(str)) {
      return "2-dimensional measurement";
    }
    if ("3".equalsIgnoreCase(str)) {
      return "3-dimensional measurement";
    }
    return "Unknown (" + str + ")";
  }
  
  public String df()
  {
    String str = ((s)this.ga).getString(9);
    if (str == null) {
      return null;
    }
    str = str.trim();
    if ("A".equalsIgnoreCase(str)) {
      return "Active (Measurement in progress)";
    }
    if ("V".equalsIgnoreCase(str)) {
      return "Void (Measurement Interoperability)";
    }
    return "Unknown (" + str + ")";
  }
  
  public String dg()
  {
    Integer localInteger = ((s)this.ga).Z(5);
    if (localInteger == null) {
      return null;
    }
    if (localInteger.intValue() == 0) {
      return "Sea level";
    }
    if (localInteger.intValue() == 1) {
      return "Below sea level";
    }
    return "Unknown (" + localInteger + ")";
  }
  
  public String dh()
  {
    Rational localRational = ((s)this.ga).ae(6);
    if (localRational == null) {
      return null;
    }
    return localRational.intValue() + " metres";
  }
  
  public String di()
  {
    Integer localInteger = ((s)this.ga).Z(30);
    if (localInteger == null) {
      return null;
    }
    if (localInteger.intValue() == 0) {
      return "No Correction";
    }
    if (localInteger.intValue() == 1) {
      return "Differential Corrected";
    }
    return "Unknown (" + localInteger + ")";
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 3: 
    case 8: 
    case 11: 
    case 13: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    default: 
      return super.getDescription(paramInt);
    case 0: 
      return cY();
    case 6: 
      return dh();
    case 5: 
      return dg();
    case 9: 
      return df();
    case 10: 
      return de();
    case 12: 
      return dd();
    case 14: 
    case 16: 
    case 23: 
      return aj(paramInt);
    case 15: 
    case 17: 
    case 24: 
      return ai(paramInt);
    case 25: 
      return dc();
    case 7: 
      return db();
    case 4: 
      return da();
    case 2: 
      return cZ();
    }
    return di();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */