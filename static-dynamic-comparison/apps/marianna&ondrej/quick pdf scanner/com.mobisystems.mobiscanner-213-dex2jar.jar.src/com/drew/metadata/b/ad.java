package com.drew.metadata.b;

import com.drew.lang.BufferBoundsException;
import com.drew.lang.b;
import com.drew.metadata.c;
import com.drew.metadata.f;
import java.io.UnsupportedEncodingException;

public class ad
  extends f<ae>
{
  public ad(ae paramae)
  {
    super(paramae);
  }
  
  private String a(c[] paramArrayOfc)
  {
    if (paramArrayOfc == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfc.length)
    {
      localStringBuilder.append("Face ").append(i + 1).append(": ").append(paramArrayOfc[i].toString()).append("\n");
      i += 1;
    }
    if (localStringBuilder.length() > 0) {
      return localStringBuilder.substring(0, localStringBuilder.length() - 1);
    }
    return null;
  }
  
  private String ah(int paramInt)
  {
    Integer localInteger = ((ae)this.ga).Z(paramInt);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Off";
    }
    return "On";
  }
  
  private String ak(int paramInt)
  {
    Object localObject = ((ae)this.ga).aa(paramInt);
    if (localObject == null) {
      return null;
    }
    localObject = new b((byte[])localObject);
    int i;
    label95:
    do
    {
      try
      {
        paramInt = ((com.drew.lang.a)localObject).P(0);
        i = ((com.drew.lang.a)localObject).P(2);
        if ((paramInt != -1) || (i != 1)) {
          break label95;
        }
        return "Slim Low";
      }
      catch (BufferBoundsException localBufferBoundsException)
      {
        return null;
      }
      localObject = "Unknown (" + paramInt + " " + i + ")";
      return (String)localObject;
      if ((paramInt == -3) && (i == 2)) {
        return "Slim High";
      }
      if ((paramInt == 0) && (i == 0)) {
        return "Off";
      }
      if ((paramInt == 1) && (i == 1)) {
        return "Stretch Low";
      }
    } while ((paramInt != 3) || (i != 2));
    return "Stretch High";
  }
  
  private String al(int paramInt)
  {
    Object localObject = ((ae)this.ga).aa(paramInt);
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = new String((byte[])localObject, "ASCII").trim();
      return (String)localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return null;
  }
  
  public String aJ()
  {
    Integer localInteger = ((ae)this.ga).Z(3);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 6: 
    case 7: 
    case 9: 
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Auto";
    case 2: 
      return "Daylight";
    case 3: 
      return "Cloudy";
    case 4: 
      return "Incandescent";
    case 5: 
      return "Manual";
    case 8: 
      return "Flash";
    case 10: 
      return "Black & White";
    case 11: 
      return "Manual";
    }
    return "Shade";
  }
  
  public String aV()
  {
    Integer localInteger = ((ae)this.ga).Z(57);
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
  
  public String bC()
  {
    Integer localInteger = ((ae)this.ga).Z(1);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 4: 
    case 5: 
    case 8: 
    default: 
      return "Unknown (" + localInteger + ")";
    case 2: 
      return "High";
    case 3: 
      return "Normal";
    case 6: 
      return "Very High";
    case 7: 
      return "Raw";
    }
    return "Motion Picture";
  }
  
  public String bc()
  {
    return ah(28);
  }
  
  public String bs()
  {
    Integer localInteger = ((ae)this.ga).Z(46);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Off";
    case 2: 
      return "10 s";
    }
    return "2 s";
  }
  
  public String bt()
  {
    Integer localInteger = ((ae)this.ga).Z(31);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 38: 
    case 40: 
    case 47: 
    case 48: 
    case 49: 
    case 50: 
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Normal";
    case 2: 
      return "Portrait";
    case 3: 
      return "Scenery";
    case 4: 
      return "Sports";
    case 5: 
      return "Night Portrait";
    case 6: 
      return "Program";
    case 7: 
      return "Aperture Priority";
    case 8: 
      return "Shutter Priority";
    case 9: 
      return "Macro";
    case 10: 
      return "Spot";
    case 11: 
      return "Manual";
    case 12: 
      return "Movie Preview";
    case 13: 
      return "Panning";
    case 14: 
      return "Simple";
    case 15: 
      return "Color Effects";
    case 16: 
      return "Self Portrait";
    case 17: 
      return "Economy";
    case 18: 
      return "Fireworks";
    case 19: 
      return "Party";
    case 20: 
      return "Snow";
    case 21: 
      return "Night Scenery";
    case 22: 
      return "Food";
    case 23: 
      return "Baby";
    case 24: 
      return "Soft Skin";
    case 25: 
      return "Candlelight";
    case 26: 
      return "Starry Night";
    case 27: 
      return "High Sensitivity";
    case 28: 
      return "Panorama Assist";
    case 29: 
      return "Underwater";
    case 30: 
      return "Beach";
    case 31: 
      return "Aerial Photo";
    case 32: 
      return "Sunset";
    case 33: 
      return "Pet";
    case 34: 
      return "Intelligent ISO";
    case 35: 
      return "Clipboard";
    case 36: 
      return "High Speed Continuous Shooting";
    case 37: 
      return "Intelligent Auto";
    case 39: 
      return "Multi-aspect";
    case 41: 
      return "Transform";
    case 42: 
      return "Flash Burst";
    case 43: 
      return "Pin Hole";
    case 44: 
      return "Film Grain";
    case 45: 
      return "My Color";
    case 46: 
      return "Photo Frame";
    }
    return "HDR";
  }
  
  public String by()
  {
    byte[] arrayOfByte = ((ae)this.ga).aa(3584);
    if (arrayOfByte == null) {
      return null;
    }
    return "(" + arrayOfByte.length + " bytes)";
  }
  
  public String cR()
  {
    Integer localInteger = ((ae)this.ga).Z(7);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 3: 
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Auto";
    case 2: 
      return "Manual";
    case 4: 
      return "Auto, Focus Button";
    }
    return "Auto, Continuous";
  }
  
  public String cg()
  {
    return a(((ae)this.ga).getIntArray(38), 2);
  }
  
  public String dM()
  {
    return ah(59);
  }
  
  public String dN()
  {
    return ah(62);
  }
  
  public String dO()
  {
    return ah(32776);
  }
  
  public String dP()
  {
    return ah(32777);
  }
  
  public String dQ()
  {
    return ah(32775);
  }
  
  public String dR()
  {
    Integer localInteger = ((ae)this.ga).Z(26);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 2: 
      return "On, Mode 1";
    case 3: 
      return "Off";
    }
    return "On, Mode 2";
  }
  
  public String dS()
  {
    return ah(32);
  }
  
  public String dT()
  {
    return ak(89);
  }
  
  public String dU()
  {
    return ak(32786);
  }
  
  public String dV()
  {
    Integer localInteger = ((ae)this.ga).Z(93);
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
      return "Low";
    case 2: 
      return "Standard";
    }
    return "High";
  }
  
  public String dW()
  {
    Integer localInteger = ((ae)this.ga).Z(98);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "No";
    }
    return "Yes (Flash required but disabled)";
  }
  
  public String dX()
  {
    return al(105);
  }
  
  public String dY()
  {
    return al(107);
  }
  
  public String dZ()
  {
    return al(109);
  }
  
  public String jdMethod_do()
  {
    Integer localInteger = ((ae)this.ga).Z(50);
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
      return "Natural";
    }
    return "Vivid";
  }
  
  public String ea()
  {
    return al(111);
  }
  
  public String eb()
  {
    return al(101);
  }
  
  public String ec()
  {
    return al(102);
  }
  
  public String ed()
  {
    return al(103);
  }
  
  public String ee()
  {
    Integer localInteger = ((ae)this.ga).Z(112);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 1: 
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Off";
    case 2: 
      return "Auto";
    }
    return "On";
  }
  
  public String ef()
  {
    Integer localInteger = ((ae)this.ga).Z(58);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Home";
    }
    return "Destination";
  }
  
  public String eg()
  {
    Integer localInteger = ((ae)this.ga).Z(61);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 6: 
    case 11: 
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Normal";
    case 2: 
      return "Outdoor/Illuminations/Flower/HDR Art";
    case 3: 
      return "Indoor/Architecture/Objects/HDR B&W";
    case 4: 
      return "Creative";
    case 5: 
      return "Auto";
    case 7: 
      return "Expressive";
    case 8: 
      return "Retro";
    case 9: 
      return "Pure";
    case 10: 
      return "Elegant";
    case 12: 
      return "Monochrome";
    case 13: 
      return "Dynamic Art";
    }
    return "Silhouette";
  }
  
  public String eh()
  {
    byte[] arrayOfByte = ((ae)this.ga).aa(33);
    if (arrayOfByte == null) {
      return null;
    }
    return "[" + arrayOfByte.length + " bytes]";
  }
  
  public String ei()
  {
    Integer localInteger = ((ae)this.ga).Z(40);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Off";
    case 2: 
      return "Warm";
    case 3: 
      return "Cool";
    case 4: 
      return "Black & White";
    }
    return "Sepia";
  }
  
  public String ej()
  {
    Integer localInteger = ((ae)this.ga).Z(41);
    if (localInteger == null) {
      return null;
    }
    return localInteger.intValue() / 100.0F + " s";
  }
  
  public String ek()
  {
    Integer localInteger = ((ae)this.ga).Z(42);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 3: 
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Off";
    case 1: 
      return "On";
    case 2: 
      return "Infinite";
    }
    return "Unlimited";
  }
  
  public String el()
  {
    Integer localInteger = ((ae)this.ga).Z(44);
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
    case 2: 
      return "High";
    case 6: 
      return "Medium Low";
    case 7: 
      return "Medium High";
    case 256: 
      return "Low";
    case 272: 
      return "Normal";
    }
    return "High";
  }
  
  public String em()
  {
    Integer localInteger = ((ae)this.ga).Z(45);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 0: 
      return "Standard (0)";
    case 1: 
      return "Low (-1)";
    case 2: 
      return "High (+1)";
    case 3: 
      return "Lowest (-2)";
    }
    return "Highest (+2)";
  }
  
  public String en()
  {
    Integer localInteger = ((ae)this.ga).Z(48);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 2: 
    case 4: 
    case 5: 
    case 7: 
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Horizontal";
    case 3: 
      return "Rotate 180";
    case 6: 
      return "Rotate 90 CW";
    }
    return "Rotate 270 CW";
  }
  
  public String eo()
  {
    Integer localInteger = ((ae)this.ga).Z(49);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Fired";
    case 2: 
      return "Enabled but not used";
    case 3: 
      return "Disabled but required";
    }
    return "Disabled and not required";
  }
  
  public String ep()
  {
    Integer localInteger = ((ae)this.ga).Z(52);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Standard";
    }
    return "Extended";
  }
  
  public String eq()
  {
    Integer localInteger = ((ae)this.ga).Z(53);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Off";
    case 2: 
      return "Wide";
    case 3: 
      return "Telephoto";
    }
    return "Macro";
  }
  
  public String er()
  {
    return a(((ae)this.ga).eA());
  }
  
  public String es()
  {
    return a(((ae)this.ga).eB());
  }
  
  public String et()
  {
    Integer localInteger = ((ae)this.ga).Z(32769);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    case 38: 
    case 40: 
    case 47: 
    case 48: 
    case 49: 
    case 50: 
    default: 
      return "Unknown (" + localInteger + ")";
    case 1: 
      return "Normal";
    case 2: 
      return "Portrait";
    case 3: 
      return "Scenery";
    case 4: 
      return "Sports";
    case 5: 
      return "Night Portrait";
    case 6: 
      return "Program";
    case 7: 
      return "Aperture Priority";
    case 8: 
      return "Shutter Priority";
    case 9: 
      return "Macro";
    case 10: 
      return "Spot";
    case 11: 
      return "Manual";
    case 12: 
      return "Movie Preview";
    case 13: 
      return "Panning";
    case 14: 
      return "Simple";
    case 15: 
      return "Color Effects";
    case 16: 
      return "Self Portrait";
    case 17: 
      return "Economy";
    case 18: 
      return "Fireworks";
    case 19: 
      return "Party";
    case 20: 
      return "Snow";
    case 21: 
      return "Night Scenery";
    case 22: 
      return "Food";
    case 23: 
      return "Baby";
    case 24: 
      return "Soft Skin";
    case 25: 
      return "Candlelight";
    case 26: 
      return "Starry Night";
    case 27: 
      return "High Sensitivity";
    case 28: 
      return "Panorama Assist";
    case 29: 
      return "Underwater";
    case 30: 
      return "Beach";
    case 31: 
      return "Aerial Photo";
    case 32: 
      return "Sunset";
    case 33: 
      return "Pet";
    case 34: 
      return "Intelligent ISO";
    case 35: 
      return "Clipboard";
    case 36: 
      return "High Speed Continuous Shooting";
    case 37: 
      return "Intelligent Auto";
    case 39: 
      return "Multi-aspect";
    case 41: 
      return "Transform";
    case 42: 
      return "Flash Burst";
    case 43: 
      return "Pin Hole";
    case 44: 
      return "Film Grain";
    case 45: 
      return "My Color";
    case 46: 
      return "Photo Frame";
    }
    return "HDR";
  }
  
  public String eu()
  {
    int[] arrayOfInt = ((ae)this.ga).getIntArray(15);
    if ((arrayOfInt == null) || (arrayOfInt.length < 2)) {
      return null;
    }
    switch (arrayOfInt[0])
    {
    default: 
      return "Unknown (" + arrayOfInt[0] + " " + arrayOfInt[1] + ")";
    case 0: 
      switch (arrayOfInt[1])
      {
      default: 
        return "Unknown (" + arrayOfInt[0] + " " + arrayOfInt[1] + ")";
      case 1: 
        return "Spot Mode On";
      }
      return "Spot Mode Off";
    case 1: 
      switch (arrayOfInt[1])
      {
      default: 
        return "Unknown (" + arrayOfInt[0] + " " + arrayOfInt[1] + ")";
      case 0: 
        return "Spot Focusing";
      }
      return "5-area";
    case 16: 
      switch (arrayOfInt[1])
      {
      default: 
        return "Unknown (" + arrayOfInt[0] + " " + arrayOfInt[1] + ")";
      case 0: 
        return "1-area";
      }
      return "1-area (high speed)";
    case 32: 
      switch (arrayOfInt[1])
      {
      default: 
        return "Unknown (" + arrayOfInt[0] + " " + arrayOfInt[1] + ")";
      case 0: 
        return "Auto or Face Detect";
      case 1: 
        return "3-area (left)";
      case 2: 
        return "3-area (center)";
      }
      return "3-area (right)";
    }
    return "Face Detect";
  }
  
  public String ev()
  {
    return a(((ae)this.ga).getIntArray(2), 2);
  }
  
  public String ew()
  {
    return a(((ae)this.ga).getIntArray(32768), 2);
  }
  
  public String ex()
  {
    byte[] arrayOfByte = ((ae)this.ga).aa(37);
    if (arrayOfByte == null) {
      return null;
    }
    int k = arrayOfByte.length;
    int i = 0;
    if (i < arrayOfByte.length)
    {
      int m = arrayOfByte[i] & 0xFF;
      j = i;
      if (m != 0) {
        if (m <= 127) {
          break label72;
        }
      }
    }
    for (int j = i;; j = k)
    {
      return new String(arrayOfByte, 0, j);
      label72:
      i += 1;
      break;
    }
  }
  
  public String ey()
  {
    com.drew.metadata.a locala = ((ae)this.ga).am(51);
    if (locala == null) {
      return null;
    }
    return locala.az();
  }
  
  public String ez()
  {
    com.drew.metadata.a locala = ((ae)this.ga).am(32784);
    if (locala == null) {
      return null;
    }
    return locala.az();
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 1: 
      return bC();
    case 2: 
      return ev();
    case 3: 
      return aJ();
    case 7: 
      return cR();
    case 15: 
      return eu();
    case 26: 
      return dR();
    case 28: 
      return bc();
    case 31: 
      return bt();
    case 32: 
      return dS();
    case 33: 
      return eh();
    case 40: 
      return ei();
    case 41: 
      return ej();
    case 42: 
      return ek();
    case 44: 
      return el();
    case 45: 
      return em();
    case 46: 
      return bs();
    case 48: 
      return en();
    case 49: 
      return eo();
    case 50: 
      return jdMethod_do();
    case 52: 
      return ep();
    case 53: 
      return eq();
    case 57: 
      return aV();
    case 58: 
      return ef();
    case 61: 
      return eg();
    case 78: 
      return er();
    case 89: 
      return dT();
    case 32786: 
      return dU();
    case 93: 
      return dV();
    case 98: 
      return dW();
    case 105: 
      return dX();
    case 107: 
      return dY();
    case 109: 
      return dZ();
    case 111: 
      return ea();
    case 112: 
      return ee();
    case 97: 
      return es();
    case 3584: 
      return by();
    case 32769: 
      return et();
    case 32775: 
      return dQ();
    case 59: 
      return dM();
    case 62: 
      return dN();
    case 32776: 
      return dO();
    case 32777: 
      return dP();
    case 32768: 
      return ew();
    case 38: 
      return cg();
    case 37: 
      return ex();
    case 101: 
      return eb();
    case 102: 
      return ec();
    case 103: 
      return ed();
    case 51: 
      return ey();
    }
    return ez();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/b/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */