package com.chartboost.sdk.impl;

public class ap
  implements am
{
  static final String[] a = new String[''];
  private byte[] b = new byte['Ѐ'];
  private byte[] c = new byte['Ѐ'];
  private av d = new av();
  
  static
  {
    a((byte)48, (byte)57);
    a((byte)97, (byte)122);
    a((byte)65, (byte)90);
  }
  
  static void a(byte paramByte1, byte paramByte2)
  {
    while (paramByte1 < paramByte2)
    {
      String str = "" + (char)paramByte1;
      a[paramByte1] = str;
      paramByte1 = (byte)(paramByte1 + 1);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */