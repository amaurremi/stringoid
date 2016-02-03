package com.flurry.org.codehaus.jackson;

public final class Base64Variants
{
  public static final Base64Variant MIME = new Base64Variant("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
  public static final Base64Variant MIME_NO_LINEFEEDS = new Base64Variant(MIME, "MIME-NO-LINEFEEDS", Integer.MAX_VALUE);
  public static final Base64Variant MODIFIED_FOR_URL;
  public static final Base64Variant PEM = new Base64Variant(MIME, "PEM", true, '=', 64);
  static final String STD_BASE64_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
  
  static
  {
    StringBuffer localStringBuffer = new StringBuffer("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
    localStringBuffer.setCharAt(localStringBuffer.indexOf("+"), '-');
    localStringBuffer.setCharAt(localStringBuffer.indexOf("/"), '_');
    MODIFIED_FOR_URL = new Base64Variant("MODIFIED-FOR-URL", localStringBuffer.toString(), false, '\000', Integer.MAX_VALUE);
  }
  
  public static Base64Variant getDefaultVariant()
  {
    return MIME_NO_LINEFEEDS;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/Base64Variants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */