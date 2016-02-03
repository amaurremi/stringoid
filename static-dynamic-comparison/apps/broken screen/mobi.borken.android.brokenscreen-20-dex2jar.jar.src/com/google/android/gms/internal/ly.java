package com.google.android.gms.internal;

public class ly
{
  private final byte[] amH = new byte['Ā'];
  private int amI;
  private int amJ;
  
  public ly(byte[] paramArrayOfByte)
  {
    int j = 0;
    while (j < 256)
    {
      this.amH[j] = ((byte)j);
      j += 1;
    }
    int k = 0;
    j = 0;
    while (j < 256)
    {
      k = k + this.amH[j] + paramArrayOfByte[(j % paramArrayOfByte.length)] & 0xFF;
      int i = this.amH[j];
      this.amH[j] = this.amH[k];
      this.amH[k] = i;
      j += 1;
    }
    this.amI = 0;
    this.amJ = 0;
  }
  
  public void o(byte[] paramArrayOfByte)
  {
    int m = this.amI;
    int k = this.amJ;
    int j = 0;
    while (j < paramArrayOfByte.length)
    {
      m = m + 1 & 0xFF;
      k = k + this.amH[m] & 0xFF;
      int i = this.amH[m];
      this.amH[m] = this.amH[k];
      this.amH[k] = i;
      paramArrayOfByte[j] = ((byte)(paramArrayOfByte[j] ^ this.amH[(this.amH[m] + this.amH[k] & 0xFF)]));
      j += 1;
    }
    this.amI = m;
    this.amJ = k;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */