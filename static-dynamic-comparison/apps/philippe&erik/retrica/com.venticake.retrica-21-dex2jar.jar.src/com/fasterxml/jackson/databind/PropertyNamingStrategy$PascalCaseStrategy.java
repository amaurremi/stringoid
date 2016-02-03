package com.fasterxml.jackson.databind;

public class PropertyNamingStrategy$PascalCaseStrategy
  extends PropertyNamingStrategy.PropertyNamingStrategyBase
{
  public String translate(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    char c;
    do
    {
      return paramString;
      c = paramString.charAt(0);
    } while (Character.isUpperCase(c));
    paramString = new StringBuilder(paramString);
    paramString.setCharAt(0, Character.toUpperCase(c));
    return paramString.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/PropertyNamingStrategy$PascalCaseStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */