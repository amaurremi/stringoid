package org.codehaus.jackson.util;

import java.util.Arrays;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.impl.Indenter;

public class DefaultPrettyPrinter$Lf2SpacesIndenter
  implements Indenter
{
  static final char[] SPACES;
  static final int SPACE_COUNT = 64;
  static final String SYSTEM_LINE_SEPARATOR;
  
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
  
  public boolean isInline()
  {
    return false;
  }
  
  public void writeIndentation(JsonGenerator paramJsonGenerator, int paramInt)
  {
    paramJsonGenerator.writeRaw(SYSTEM_LINE_SEPARATOR);
    paramInt += paramInt;
    while (paramInt > 64)
    {
      paramJsonGenerator.writeRaw(SPACES, 0, 64);
      paramInt -= SPACES.length;
    }
    paramJsonGenerator.writeRaw(SPACES, 0, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/util/DefaultPrettyPrinter$Lf2SpacesIndenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */