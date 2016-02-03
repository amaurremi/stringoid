package com.google.android.gms.internal;

public class iv
{
  private final byte[] Hm = new byte['Ā'];
  private int Hn;
  private int Ho;
  
  public iv(byte[] paramArrayOfByte)
  {
    int j = 0;
    while (j < 256)
    {
      this.Hm[j] = ((byte)j);
      j += 1;
    }
    int k = 0;
    j = 0;
    while (j < 256)
    {
      k = k + this.Hm[j] + paramArrayOfByte[(j % paramArrayOfByte.length)] & 0xFF;
      int i = this.Hm[j];
      this.Hm[j] = this.Hm[k];
      this.Hm[k] = i;
      j += 1;
    }
    this.Hn = 0;
    this.Ho = 0;
  }
  
  public void h(byte[] paramArrayOfByte)
  {
    int m = this.Hn;
    int k = this.Ho;
    int j = 0;
    while (j < paramArrayOfByte.length)
    {
      m = m + 1 & 0xFF;
      k = k + this.Hm[m] & 0xFF;
      int i = this.Hm[m];
      this.Hm[m] = this.Hm[k];
      this.Hm[k] = i;
      paramArrayOfByte[j] = ((byte)(paramArrayOfByte[j] ^ this.Hm[(this.Hm[m] + this.Hm[k] & 0xFF)]));
      j += 1;
    }
    this.Hn = m;
    this.Ho = k;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/iv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */