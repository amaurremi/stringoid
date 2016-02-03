package com.google.android.gms.internal;

public class lx
{
  private final byte[] amK = new byte['Ā'];
  private int amL;
  private int amM;
  
  public lx(byte[] paramArrayOfByte)
  {
    int j = 0;
    while (j < 256)
    {
      this.amK[j] = ((byte)j);
      j += 1;
    }
    int k = 0;
    j = 0;
    while (j < 256)
    {
      k = k + this.amK[j] + paramArrayOfByte[(j % paramArrayOfByte.length)] & 0xFF;
      int i = this.amK[j];
      this.amK[j] = this.amK[k];
      this.amK[k] = i;
      j += 1;
    }
    this.amL = 0;
    this.amM = 0;
  }
  
  public void o(byte[] paramArrayOfByte)
  {
    int m = this.amL;
    int k = this.amM;
    int j = 0;
    while (j < paramArrayOfByte.length)
    {
      m = m + 1 & 0xFF;
      k = k + this.amK[m] & 0xFF;
      int i = this.amK[m];
      this.amK[m] = this.amK[k];
      this.amK[k] = i;
      paramArrayOfByte[j] = ((byte)(paramArrayOfByte[j] ^ this.amK[(this.amK[m] + this.amK[k] & 0xFF)]));
      j += 1;
    }
    this.amL = m;
    this.amM = k;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/lx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */