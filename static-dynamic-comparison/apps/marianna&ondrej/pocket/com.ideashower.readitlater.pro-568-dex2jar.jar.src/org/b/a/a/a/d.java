package org.b.a.a.a;

public class d
  extends b
{
  protected int a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte[paramInt] & 0xFF) == 130)
    {
      paramInt = paramArrayOfByte[(paramInt + 1)] & 0xFF;
      if ((paramInt >= 159) && (paramInt <= 241)) {
        return paramInt - 159;
      }
    }
    return -1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/b/a/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */