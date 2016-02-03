package org.codehaus.jackson.map;

public class PropertyNamingStrategy$LowerCaseWithUnderscoresStrategy
  extends PropertyNamingStrategy.PropertyNamingStrategyBase
{
  public String translate(String paramString)
  {
    if (paramString == null) {
      return paramString;
    }
    int n = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(n * 2);
    int m = 0;
    int j = 0;
    int i = 0;
    label33:
    int k;
    if (m < n)
    {
      char c = paramString.charAt(m);
      if ((m <= 0) && (c == '_')) {
        break label170;
      }
      if (Character.isUpperCase(c))
      {
        k = i;
        if (j == 0)
        {
          k = i;
          if (i > 0)
          {
            k = i;
            if (localStringBuilder.charAt(i - 1) != '_')
            {
              localStringBuilder.append('_');
              k = i + 1;
            }
          }
        }
        c = Character.toLowerCase(c);
        i = 1;
        j = k;
        label120:
        localStringBuilder.append(c);
        j += 1;
      }
    }
    for (;;)
    {
      m += 1;
      k = i;
      i = j;
      j = k;
      break label33;
      j = i;
      i = 0;
      break label120;
      if (i <= 0) {
        break;
      }
      return localStringBuilder.toString();
      label170:
      k = j;
      j = i;
      i = k;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/PropertyNamingStrategy$LowerCaseWithUnderscoresStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */