package com.google.android.gms.internal;

import java.io.IOException;

public class me
  extends IOException
{
  public me(String paramString)
  {
    super(paramString);
  }
  
  static me nN()
  {
    return new me("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
  }
  
  static me nO()
  {
    return new me("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
  
  static me nP()
  {
    return new me("CodedInputStream encountered a malformed varint.");
  }
  
  static me nQ()
  {
    return new me("Protocol message contained an invalid tag (zero).");
  }
  
  static me nR()
  {
    return new me("Protocol message end-group tag did not match expected tag.");
  }
  
  static me nS()
  {
    return new me("Protocol message tag had invalid wire type.");
  }
  
  static me nT()
  {
    return new me("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/me.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */