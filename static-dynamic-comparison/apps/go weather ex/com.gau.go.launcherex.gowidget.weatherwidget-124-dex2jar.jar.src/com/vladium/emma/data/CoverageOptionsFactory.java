package com.vladium.emma.data;

import com.vladium.util.IProperties;
import com.vladium.util.Property;
import java.util.Properties;

public abstract class CoverageOptionsFactory
{
  public static CoverageOptions create(IProperties paramIProperties)
  {
    return new CoverageOptions(Property.toBoolean(paramIProperties.getProperty("instr.exclude_synthetic_methods", "true")), Property.toBoolean(paramIProperties.getProperty("instr.exclude_bridge_methods", "true")), Property.toBoolean(paramIProperties.getProperty("instr.do_suid_compensation", "true")));
  }
  
  public static CoverageOptions create(Properties paramProperties)
  {
    return new CoverageOptions(Property.toBoolean(paramProperties.getProperty("instr.exclude_synthetic_methods", "true")), Property.toBoolean(paramProperties.getProperty("instr.exclude_bridge_methods", "true")), Property.toBoolean(paramProperties.getProperty("instr.do_suid_compensation", "true")));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/data/CoverageOptionsFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */