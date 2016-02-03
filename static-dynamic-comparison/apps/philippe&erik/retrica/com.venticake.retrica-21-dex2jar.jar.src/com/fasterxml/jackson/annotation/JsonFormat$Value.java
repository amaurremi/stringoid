package com.fasterxml.jackson.annotation;

import java.util.Locale;
import java.util.TimeZone;

public class JsonFormat$Value
{
  private final Locale locale;
  private final String pattern;
  private final JsonFormat.Shape shape;
  private final TimeZone timezone;
  
  public JsonFormat$Value()
  {
    this("", JsonFormat.Shape.ANY, "", "");
  }
  
  public JsonFormat$Value(JsonFormat paramJsonFormat)
  {
    this(paramJsonFormat.pattern(), paramJsonFormat.shape(), paramJsonFormat.locale(), paramJsonFormat.timezone());
  }
  
  public JsonFormat$Value(String paramString1, JsonFormat.Shape paramShape, String paramString2, String paramString3) {}
  
  public JsonFormat$Value(String paramString, JsonFormat.Shape paramShape, Locale paramLocale, TimeZone paramTimeZone)
  {
    this.pattern = paramString;
    this.shape = paramShape;
    this.locale = paramLocale;
    this.timezone = paramTimeZone;
  }
  
  public Locale getLocale()
  {
    return this.locale;
  }
  
  public String getPattern()
  {
    return this.pattern;
  }
  
  public JsonFormat.Shape getShape()
  {
    return this.shape;
  }
  
  public TimeZone getTimeZone()
  {
    return this.timezone;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/annotation/JsonFormat$Value.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */