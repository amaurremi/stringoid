package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class pj
{
  private ph<?, ?> awF;
  private Object awG;
  private List<po> awH = new ArrayList();
  
  private byte[] toByteArray()
    throws IOException
  {
    byte[] arrayOfByte = new byte[c()];
    a(pf.q(arrayOfByte));
    return arrayOfByte;
  }
  
  void a(pf parampf)
    throws IOException
  {
    if (this.awG != null) {
      this.awF.a(this.awG, parampf);
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.awH.iterator();
      while (localIterator.hasNext()) {
        ((po)localIterator.next()).a(parampf);
      }
    }
  }
  
  void a(po parampo)
  {
    this.awH.add(parampo);
  }
  
  <T> T b(ph<?, T> paramph)
  {
    if (this.awG != null)
    {
      if (this.awF != paramph) {
        throw new IllegalStateException("Tried to getExtension with a differernt Extension.");
      }
    }
    else
    {
      this.awF = paramph;
      this.awG = paramph.l(this.awH);
      this.awH = null;
    }
    return (T)this.awG;
  }
  
  int c()
  {
    int j;
    if (this.awG != null)
    {
      j = this.awF.A(this.awG);
      return j;
    }
    Iterator localIterator = this.awH.iterator();
    for (int i = 0;; i = ((po)localIterator.next()).c() + i)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof pj));
      paramObject = (pj)paramObject;
      if ((this.awG == null) || (((pj)paramObject).awG == null)) {
        break;
      }
      bool1 = bool2;
    } while (this.awF != ((pj)paramObject).awF);
    if (!this.awF.awz.isArray()) {
      return this.awG.equals(((pj)paramObject).awG);
    }
    if ((this.awG instanceof byte[])) {
      return Arrays.equals((byte[])this.awG, (byte[])((pj)paramObject).awG);
    }
    if ((this.awG instanceof int[])) {
      return Arrays.equals((int[])this.awG, (int[])((pj)paramObject).awG);
    }
    if ((this.awG instanceof long[])) {
      return Arrays.equals((long[])this.awG, (long[])((pj)paramObject).awG);
    }
    if ((this.awG instanceof float[])) {
      return Arrays.equals((float[])this.awG, (float[])((pj)paramObject).awG);
    }
    if ((this.awG instanceof double[])) {
      return Arrays.equals((double[])this.awG, (double[])((pj)paramObject).awG);
    }
    if ((this.awG instanceof boolean[])) {
      return Arrays.equals((boolean[])this.awG, (boolean[])((pj)paramObject).awG);
    }
    return Arrays.deepEquals((Object[])this.awG, (Object[])((pj)paramObject).awG);
    if ((this.awH != null) && (((pj)paramObject).awH != null)) {
      return this.awH.equals(((pj)paramObject).awH);
    }
    try
    {
      bool1 = Arrays.equals(toByteArray(), ((pj)paramObject).toByteArray());
      return bool1;
    }
    catch (IOException paramObject)
    {
      throw new IllegalStateException((Throwable)paramObject);
    }
  }
  
  public int hashCode()
  {
    try
    {
      int i = Arrays.hashCode(toByteArray());
      return i + 527;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/pj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */