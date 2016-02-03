package com.appbrain.b;

import java.io.IOException;

public final class i
  extends IOException
{
  private m a = null;
  
  public i(String paramString)
  {
    super(paramString);
  }
  
  static i a()
  {
    return new i("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
  }
  
  static i b()
  {
    return new i("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
  
  static i c()
  {
    return new i("CodedInputStream encountered a malformed varint.");
  }
  
  static i d()
  {
    return new i("Protocol message contained an invalid tag (zero).");
  }
  
  static i e()
  {
    return new i("Protocol message end-group tag did not match expected tag.");
  }
  
  static i f()
  {
    return new i("Protocol message tag had invalid wire type.");
  }
  
  static i g()
  {
    return new i("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
  }
  
  static i h()
  {
    return new i("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
  }
  
  public final i a(m paramm)
  {
    this.a = paramm;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */