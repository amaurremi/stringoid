package com.vladium.util;

public abstract interface IJREVersion
{
  public static final boolean JRE_1_2_PLUS = _JREVersion._JRE_1_2_PLUS;
  public static final boolean JRE_1_3_PLUS = _JREVersion._JRE_1_3_PLUS;
  public static final boolean JRE_1_4_PLUS = _JREVersion._JRE_1_4_PLUS;
  public static final boolean JRE_SUN_SIGNAL_COMPATIBLE = _JREVersion._JRE_SUN_SIGNAL_COMPATIBLE;
  
  public static abstract class _JREVersion
  {
    static final boolean _JRE_1_2_PLUS;
    static final boolean _JRE_1_3_PLUS;
    static final boolean _JRE_1_4_PLUS;
    static final boolean _JRE_SUN_SIGNAL_COMPATIBLE = false;
    
    static
    {
      bool1 = false;
      if ((SecurityManager.class.getModifiers() & 0x400) == 0) {
        bool1 = true;
      }
      _JRE_1_2_PLUS = bool1;
      bool2 = false;
      bool1 = bool2;
      if (_JRE_1_2_PLUS) {}
      try
      {
        StrictMath.abs(1.0D);
        bool1 = true;
      }
      catch (Error localError)
      {
        for (;;)
        {
          bool1 = bool2;
        }
      }
      _JRE_1_3_PLUS = bool1;
      bool2 = bool1;
      if (bool1) {
        bool2 = false;
      }
      try
      {
        " ".subSequence(0, 0);
        bool2 = true;
      }
      catch (NoSuchMethodError localNoSuchMethodError)
      {
        for (;;) {}
      }
      _JRE_1_4_PLUS = bool2;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/util/IJREVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */