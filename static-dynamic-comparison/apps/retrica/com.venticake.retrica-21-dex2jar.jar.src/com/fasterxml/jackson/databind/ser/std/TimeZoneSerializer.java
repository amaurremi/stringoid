package com.fasterxml.jackson.databind.ser.std;

import java.util.TimeZone;

public class TimeZoneSerializer
  extends StdScalarSerializer<TimeZone>
{
  public static final TimeZoneSerializer instance = new TimeZoneSerializer();
  
  public TimeZoneSerializer()
  {
    super(TimeZone.class);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/std/TimeZoneSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */