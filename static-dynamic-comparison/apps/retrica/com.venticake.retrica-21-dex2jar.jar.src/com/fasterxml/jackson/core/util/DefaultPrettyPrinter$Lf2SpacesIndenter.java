package com.fasterxml.jackson.core.util;

import java.io.Serializable;
import java.util.Arrays;

public class DefaultPrettyPrinter$Lf2SpacesIndenter
  implements DefaultPrettyPrinter.Indenter, Serializable
{
  static final char[] SPACES;
  static final String SYSTEM_LINE_SEPARATOR;
  public static Lf2SpacesIndenter instance = new Lf2SpacesIndenter();
  
  static
  {
    Object localObject1 = null;
    try
    {
      localObject2 = System.getProperty("line.separator");
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      Object localObject2;
      for (;;) {}
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "\n";
    }
    SYSTEM_LINE_SEPARATOR = (String)localObject2;
    SPACES = new char[64];
    Arrays.fill(SPACES, ' ');
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/core/util/DefaultPrettyPrinter$Lf2SpacesIndenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */