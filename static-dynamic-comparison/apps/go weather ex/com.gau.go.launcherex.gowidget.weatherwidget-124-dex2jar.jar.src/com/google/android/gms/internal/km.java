package com.google.android.gms.internal;

public class km
{
  private final byte[] adH = new byte['Ā'];
  private int adI;
  private int adJ;
  
  public km(byte[] paramArrayOfByte)
  {
    int j = 0;
    while (j < 256)
    {
      this.adH[j] = ((byte)j);
      j += 1;
    }
    int k = 0;
    j = 0;
    while (j < 256)
    {
      k = k + this.adH[j] + paramArrayOfByte[(j % paramArrayOfByte.length)] & 0xFF;
      int i = this.adH[j];
      this.adH[j] = this.adH[k];
      this.adH[k] = i;
      j += 1;
    }
    this.adI = 0;
    this.adJ = 0;
  }
  
  public void m(byte[] paramArrayOfByte)
  {
    int m = this.adI;
    int k = this.adJ;
    int j = 0;
    while (j < paramArrayOfByte.length)
    {
      m = m + 1 & 0xFF;
      k = k + this.adH[m] & 0xFF;
      int i = this.adH[m];
      this.adH[m] = this.adH[k];
      this.adH[k] = i;
      paramArrayOfByte[j] = ((byte)(paramArrayOfByte[j] ^ this.adH[(this.adH[m] + this.adH[k] & 0xFF)]));
      j += 1;
    }
    this.adI = m;
    this.adJ = k;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/km.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */