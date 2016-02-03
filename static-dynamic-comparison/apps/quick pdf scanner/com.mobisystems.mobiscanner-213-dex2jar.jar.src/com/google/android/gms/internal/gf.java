package com.google.android.gms.internal;

public class gf
{
  private final byte[] SS = new byte['Ā'];
  private int ST;
  private int SU;
  
  public gf(byte[] paramArrayOfByte)
  {
    int j = 0;
    while (j < 256)
    {
      this.SS[j] = ((byte)j);
      j += 1;
    }
    int k = 0;
    j = 0;
    while (j < 256)
    {
      k = k + this.SS[j] + paramArrayOfByte[(j % paramArrayOfByte.length)] & 0xFF;
      int i = this.SS[j];
      this.SS[j] = this.SS[k];
      this.SS[k] = i;
      j += 1;
    }
    this.ST = 0;
    this.SU = 0;
  }
  
  public void d(byte[] paramArrayOfByte)
  {
    int m = this.ST;
    int k = this.SU;
    int j = 0;
    while (j < paramArrayOfByte.length)
    {
      m = m + 1 & 0xFF;
      k = k + this.SS[m] & 0xFF;
      int i = this.SS[m];
      this.SS[m] = this.SS[k];
      this.SS[k] = i;
      paramArrayOfByte[j] = ((byte)(paramArrayOfByte[j] ^ this.SS[(this.SS[m] + this.SS[k] & 0xFF)]));
      j += 1;
    }
    this.ST = m;
    this.SU = k;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/gf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */