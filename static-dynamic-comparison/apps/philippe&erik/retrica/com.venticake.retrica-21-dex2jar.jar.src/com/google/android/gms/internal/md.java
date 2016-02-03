package com.google.android.gms.internal;

import java.io.IOException;

public class md
  extends IOException
{
  public md(String paramString)
  {
    super(paramString);
  }
  
  static md nS()
  {
    return new md("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
  }
  
  static md nT()
  {
    return new md("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
  
  static md nU()
  {
    return new md("CodedInputStream encountered a malformed varint.");
  }
  
  static md nV()
  {
    return new md("Protocol message contained an invalid tag (zero).");
  }
  
  static md nW()
  {
    return new md("Protocol message end-group tag did not match expected tag.");
  }
  
  static md nX()
  {
    return new md("Protocol message tag had invalid wire type.");
  }
  
  static md nY()
  {
    return new md("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/md.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */