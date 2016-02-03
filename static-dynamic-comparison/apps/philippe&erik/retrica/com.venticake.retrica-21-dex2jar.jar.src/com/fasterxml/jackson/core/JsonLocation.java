package com.fasterxml.jackson.core;

import java.io.Serializable;

public class JsonLocation
  implements Serializable
{
  public static final JsonLocation NA = new JsonLocation("N/A", -1L, -1L, -1, -1);
  final int _columnNr;
  final int _lineNr;
  final Object _sourceRef;
  final long _totalBytes;
  final long _totalChars;
  
  public JsonLocation(Object paramObject, long paramLong, int paramInt1, int paramInt2)
  {
    this(paramObject, -1L, paramLong, paramInt1, paramInt2);
  }
  
  public JsonLocation(Object paramObject, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    this._sourceRef = paramObject;
    this._totalBytes = paramLong1;
    this._totalChars = paramLong2;
    this._lineNr = paramInt1;
    this._columnNr = paramInt2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool3;
        } while (paramObject == null);
        bool1 = bool3;
      } while (!(paramObject instanceof JsonLocation));
      paramObject = (JsonLocation)paramObject;
      if (this._sourceRef != null) {
        break;
      }
      bool1 = bool3;
    } while (((JsonLocation)paramObject)._sourceRef != null);
    if ((this._lineNr == ((JsonLocation)paramObject)._lineNr) && (this._columnNr == ((JsonLocation)paramObject)._columnNr) && (this._totalChars == ((JsonLocation)paramObject)._totalChars) && (getByteOffset() == ((JsonLocation)paramObject).getByteOffset())) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return bool1;
      if (this._sourceRef.equals(((JsonLocation)paramObject)._sourceRef)) {
        break;
      }
      return false;
    }
  }
  
  public long getByteOffset()
  {
    return this._totalBytes;
  }
  
  public int hashCode()
  {
    if (this._sourceRef == null) {}
    for (int i = 1;; i = this._sourceRef.hashCode()) {
      return ((i ^ this._lineNr) + this._columnNr ^ (int)this._totalChars) + (int)this._totalBytes;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(80);
    localStringBuilder.append("[Source: ");
    if (this._sourceRef == null) {
      localStringBuilder.append("UNKNOWN");
    }
    for (;;)
    {
      localStringBuilder.append("; line: ");
      localStringBuilder.append(this._lineNr);
      localStringBuilder.append(", column: ");
      localStringBuilder.append(this._columnNr);
      localStringBuilder.append(']');
      return localStringBuilder.toString();
      localStringBuilder.append(this._sourceRef.toString());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/core/JsonLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */