package com.google.android.gms.internal;

public class pd
{
  private final byte[] awl = new byte['Ā'];
  private int awm;
  private int awn;
  
  public pd(byte[] paramArrayOfByte)
  {
    int j = 0;
    while (j < 256)
    {
      this.awl[j] = ((byte)j);
      j += 1;
    }
    int k = 0;
    j = 0;
    while (j < 256)
    {
      k = k + this.awl[j] + paramArrayOfByte[(j % paramArrayOfByte.length)] & 0xFF;
      int i = this.awl[j];
      this.awl[j] = this.awl[k];
      this.awl[k] = i;
      j += 1;
    }
    this.awm = 0;
    this.awn = 0;
  }
  
  public void o(byte[] paramArrayOfByte)
  {
    int m = this.awm;
    int k = this.awn;
    int j = 0;
    while (j < paramArrayOfByte.length)
    {
      m = m + 1 & 0xFF;
      k = k + this.awl[m] & 0xFF;
      int i = this.awl[m];
      this.awl[m] = this.awl[k];
      this.awl[k] = i;
      paramArrayOfByte[j] = ((byte)(paramArrayOfByte[j] ^ this.awl[(this.awl[m] + this.awl[k] & 0xFF)]));
      j += 1;
    }
    this.awm = m;
    this.awn = k;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/pd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */