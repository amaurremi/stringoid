package com.amazonaws.util;

public enum Base64
{
  private static final Base64Codec codec = new Base64Codec();
  
  public static String encodeAsString(byte... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return null;
    }
    if (paramVarArgs.length == 0) {
      return "";
    }
    return CodecUtils.toStringDirect(codec.encode(paramVarArgs));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/util/Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */