package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

final class po
{
  final byte[] awK;
  final int tag;
  
  po(int paramInt, byte[] paramArrayOfByte)
  {
    this.tag = paramInt;
    this.awK = paramArrayOfByte;
  }
  
  void a(pf parampf)
    throws IOException
  {
    parampf.gz(this.tag);
    parampf.t(this.awK);
  }
  
  int c()
  {
    return 0 + pf.gA(this.tag) + this.awK.length;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof po)) {
        return false;
      }
      paramObject = (po)paramObject;
    } while ((this.tag == ((po)paramObject).tag) && (Arrays.equals(this.awK, ((po)paramObject).awK)));
    return false;
  }
  
  public int hashCode()
  {
    return (this.tag + 527) * 31 + Arrays.hashCode(this.awK);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/po.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */