package com.drew.metadata.c;

import java.util.HashMap;

public class b
  extends com.drew.metadata.b
{
  protected static final HashMap<Integer, String> gb = new HashMap();
  
  static
  {
    gb.put(Integer.valueOf(0), "Profile Size");
    gb.put(Integer.valueOf(4), "CMM Type");
    gb.put(Integer.valueOf(8), "Version");
    gb.put(Integer.valueOf(12), "Class");
    gb.put(Integer.valueOf(16), "Color space");
    gb.put(Integer.valueOf(20), "Profile Connection Space");
    gb.put(Integer.valueOf(24), "Profile Date/Time");
    gb.put(Integer.valueOf(36), "Signature");
    gb.put(Integer.valueOf(40), "Primary Platform");
    gb.put(Integer.valueOf(44), "CMM Flags");
    gb.put(Integer.valueOf(48), "Device manufacturer");
    gb.put(Integer.valueOf(52), "Device model");
    gb.put(Integer.valueOf(56), "Device attributes");
    gb.put(Integer.valueOf(64), "Rendering Intent");
    gb.put(Integer.valueOf(68), "XYZ values");
    gb.put(Integer.valueOf(80), "Profile Creator");
    gb.put(Integer.valueOf(128), "Tag Count");
    gb.put(Integer.valueOf(1093812784), "AToB 0");
    gb.put(Integer.valueOf(1093812785), "AToB 1");
    gb.put(Integer.valueOf(1093812786), "AToB 2");
    gb.put(Integer.valueOf(1649957210), "Blue Colorant");
    gb.put(Integer.valueOf(1649693251), "Blue TRC");
    gb.put(Integer.valueOf(1110589744), "BToA 0");
    gb.put(Integer.valueOf(1110589745), "BToA 1");
    gb.put(Integer.valueOf(1110589746), "BToA 2");
    gb.put(Integer.valueOf(1667329140), "Calibration Date/Time");
    gb.put(Integer.valueOf(1952543335), "Char Target");
    gb.put(Integer.valueOf(1667785060), "Chromatic Adaptation");
    gb.put(Integer.valueOf(1667789421), "Chromaticity");
    gb.put(Integer.valueOf(1668313716), "Copyright");
    gb.put(Integer.valueOf(1668441193), "CrdInfo");
    gb.put(Integer.valueOf(1684893284), "Device Mfg Description");
    gb.put(Integer.valueOf(1684890724), "Device Model Description");
    gb.put(Integer.valueOf(1684371059), "Device Settings");
    gb.put(Integer.valueOf(1734438260), "Gamut");
    gb.put(Integer.valueOf(1800688195), "Gray TRC");
    gb.put(Integer.valueOf(1733843290), "Green Colorant");
    gb.put(Integer.valueOf(1733579331), "Green TRC");
    gb.put(Integer.valueOf(1819635049), "Luminance");
    gb.put(Integer.valueOf(1835360627), "Measurement");
    gb.put(Integer.valueOf(1651208308), "Media Black Point");
    gb.put(Integer.valueOf(2004119668), "Media White Point");
    gb.put(Integer.valueOf(1852010348), "Named Color");
    gb.put(Integer.valueOf(1852009522), "Named Color 2");
    gb.put(Integer.valueOf(1919251312), "Output Response");
    gb.put(Integer.valueOf(1886545200), "Preview 0");
    gb.put(Integer.valueOf(1886545201), "Preview 1");
    gb.put(Integer.valueOf(1886545202), "Preview 2");
    gb.put(Integer.valueOf(1684370275), "Profile Description");
    gb.put(Integer.valueOf(1886610801), "Profile Sequence Description");
    gb.put(Integer.valueOf(1886610480), "Ps2 CRD 0");
    gb.put(Integer.valueOf(1886610481), "Ps2 CRD 1");
    gb.put(Integer.valueOf(1886610482), "Ps2 CRD 2");
    gb.put(Integer.valueOf(1886610483), "Ps2 CRD 3");
    gb.put(Integer.valueOf(1886597747), "Ps2 CSA");
    gb.put(Integer.valueOf(1886597737), "Ps2 Rendering Intent");
    gb.put(Integer.valueOf(1918392666), "Red Colorant");
    gb.put(Integer.valueOf(1918128707), "Red TRC");
    gb.put(Integer.valueOf(1935897188), "Screening Desc");
    gb.put(Integer.valueOf(1935897198), "Screening");
    gb.put(Integer.valueOf(1952801640), "Technology");
    gb.put(Integer.valueOf(1650877472), "Ucrbg");
    gb.put(Integer.valueOf(1987405156), "Viewing Conditions Description");
    gb.put(Integer.valueOf(1986618743), "Viewing Conditions");
    gb.put(Integer.valueOf(1685283693), "Apple Multi-language Profile Name");
  }
  
  public b()
  {
    a(new a(this));
  }
  
  protected HashMap<Integer, String> aA()
  {
    return gb;
  }
  
  public String getName()
  {
    return "ICC Profile";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */