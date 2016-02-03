package org.b.a.a.b;

public class c
  extends g
{
  protected int a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt] & 0xFF;
    if (i >= 161) {
      return (i - 161) * 94 + (paramArrayOfByte[(paramInt + 1)] & 0xFF) - 161;
    }
    return -1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/b/a/a/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */