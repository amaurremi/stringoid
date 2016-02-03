package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;

public final class lw$a$a$a
  extends ma<a>
{
  public long amA;
  public int amB;
  public int amC;
  public boolean amD;
  public lw.a[] amE;
  public lw.a.a[] amF;
  public String[] amG;
  public long[] amH;
  public float[] amI;
  public long amJ;
  public byte[] amw;
  public String amx;
  public double amy;
  public float amz;
  
  public lw$a$a$a()
  {
    nA();
  }
  
  public void a(lz paramlz)
  {
    int j = 0;
    if (!Arrays.equals(this.amw, mh.ank)) {
      paramlz.a(1, this.amw);
    }
    if (!this.amx.equals("")) {
      paramlz.b(2, this.amx);
    }
    if (Double.doubleToLongBits(this.amy) != Double.doubleToLongBits(0.0D)) {
      paramlz.a(3, this.amy);
    }
    if (Float.floatToIntBits(this.amz) != Float.floatToIntBits(0.0F)) {
      paramlz.b(4, this.amz);
    }
    if (this.amA != 0L) {
      paramlz.b(5, this.amA);
    }
    if (this.amB != 0) {
      paramlz.p(6, this.amB);
    }
    if (this.amC != 0) {
      paramlz.q(7, this.amC);
    }
    if (this.amD) {
      paramlz.a(8, this.amD);
    }
    int i;
    Object localObject;
    if ((this.amE != null) && (this.amE.length > 0))
    {
      i = 0;
      while (i < this.amE.length)
      {
        localObject = this.amE[i];
        if (localObject != null) {
          paramlz.a(9, (me)localObject);
        }
        i += 1;
      }
    }
    if ((this.amF != null) && (this.amF.length > 0))
    {
      i = 0;
      while (i < this.amF.length)
      {
        localObject = this.amF[i];
        if (localObject != null) {
          paramlz.a(10, (me)localObject);
        }
        i += 1;
      }
    }
    if ((this.amG != null) && (this.amG.length > 0))
    {
      i = 0;
      while (i < this.amG.length)
      {
        localObject = this.amG[i];
        if (localObject != null) {
          paramlz.b(11, (String)localObject);
        }
        i += 1;
      }
    }
    if ((this.amH != null) && (this.amH.length > 0))
    {
      i = 0;
      while (i < this.amH.length)
      {
        paramlz.b(12, this.amH[i]);
        i += 1;
      }
    }
    if (this.amJ != 0L) {
      paramlz.b(13, this.amJ);
    }
    if ((this.amI != null) && (this.amI.length > 0))
    {
      i = j;
      while (i < this.amI.length)
      {
        paramlz.b(14, this.amI[i]);
        i += 1;
      }
    }
    super.a(paramlz);
  }
  
  protected int c()
  {
    int i2 = 0;
    int j = super.c();
    int i = j;
    if (!Arrays.equals(this.amw, mh.ank)) {
      i = j + lz.b(1, this.amw);
    }
    j = i;
    if (!this.amx.equals("")) {
      j = i + lz.h(2, this.amx);
    }
    i = j;
    if (Double.doubleToLongBits(this.amy) != Double.doubleToLongBits(0.0D)) {
      i = j + lz.b(3, this.amy);
    }
    j = i;
    if (Float.floatToIntBits(this.amz) != Float.floatToIntBits(0.0F)) {
      j = i + lz.c(4, this.amz);
    }
    i = j;
    if (this.amA != 0L) {
      i = j + lz.d(5, this.amA);
    }
    j = i;
    if (this.amB != 0) {
      j = i + lz.r(6, this.amB);
    }
    int k = j;
    if (this.amC != 0) {
      k = j + lz.s(7, this.amC);
    }
    i = k;
    if (this.amD) {
      i = k + lz.b(8, this.amD);
    }
    j = i;
    Object localObject;
    if (this.amE != null)
    {
      j = i;
      if (this.amE.length > 0)
      {
        j = 0;
        while (j < this.amE.length)
        {
          localObject = this.amE[j];
          k = i;
          if (localObject != null) {
            k = i + lz.b(9, (me)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.amF != null)
    {
      i = j;
      if (this.amF.length > 0)
      {
        i = j;
        j = 0;
        while (j < this.amF.length)
        {
          localObject = this.amF[j];
          k = i;
          if (localObject != null) {
            k = i + lz.b(10, (me)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    j = i;
    if (this.amG != null)
    {
      j = i;
      if (this.amG.length > 0)
      {
        j = 0;
        k = 0;
        int n;
        for (int m = 0; j < this.amG.length; m = n)
        {
          localObject = this.amG[j];
          int i1 = k;
          n = m;
          if (localObject != null)
          {
            n = m + 1;
            i1 = k + lz.cz((String)localObject);
          }
          j += 1;
          k = i1;
        }
        j = i + k + m * 1;
      }
    }
    i = j;
    if (this.amH != null)
    {
      i = j;
      if (this.amH.length > 0)
      {
        k = 0;
        i = i2;
        while (i < this.amH.length)
        {
          k += lz.D(this.amH[i]);
          i += 1;
        }
        i = j + k + this.amH.length * 1;
      }
    }
    j = i;
    if (this.amJ != 0L) {
      j = i + lz.d(13, this.amJ);
    }
    i = j;
    if (this.amI != null)
    {
      i = j;
      if (this.amI.length > 0) {
        i = j + this.amI.length * 4 + this.amI.length * 1;
      }
    }
    return i;
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
        do
        {
          return bool1;
          bool1 = bool2;
        } while (!(paramObject instanceof a));
        paramObject = (a)paramObject;
        bool1 = bool2;
      } while (!Arrays.equals(this.amw, ((a)paramObject).amw));
      if (this.amx != null) {
        break;
      }
      bool1 = bool2;
    } while (((a)paramObject).amx != null);
    while (this.amx.equals(((a)paramObject).amx))
    {
      bool1 = bool2;
      if (Double.doubleToLongBits(this.amy) != Double.doubleToLongBits(((a)paramObject).amy)) {
        break;
      }
      bool1 = bool2;
      if (Float.floatToIntBits(this.amz) != Float.floatToIntBits(((a)paramObject).amz)) {
        break;
      }
      bool1 = bool2;
      if (this.amA != ((a)paramObject).amA) {
        break;
      }
      bool1 = bool2;
      if (this.amB != ((a)paramObject).amB) {
        break;
      }
      bool1 = bool2;
      if (this.amC != ((a)paramObject).amC) {
        break;
      }
      bool1 = bool2;
      if (this.amD != ((a)paramObject).amD) {
        break;
      }
      bool1 = bool2;
      if (!mc.equals(this.amE, ((a)paramObject).amE)) {
        break;
      }
      bool1 = bool2;
      if (!mc.equals(this.amF, ((a)paramObject).amF)) {
        break;
      }
      bool1 = bool2;
      if (!mc.equals(this.amG, ((a)paramObject).amG)) {
        break;
      }
      bool1 = bool2;
      if (!mc.equals(this.amH, ((a)paramObject).amH)) {
        break;
      }
      bool1 = bool2;
      if (!mc.equals(this.amI, ((a)paramObject).amI)) {
        break;
      }
      bool1 = bool2;
      if (this.amJ != ((a)paramObject).amJ) {
        break;
      }
      if ((this.amX != null) && (!this.amX.isEmpty())) {
        break label301;
      }
      if (((a)paramObject).amX != null)
      {
        bool1 = bool2;
        if (!((a)paramObject).amX.isEmpty()) {
          break;
        }
      }
      return true;
    }
    return false;
    label301:
    return this.amX.equals(((a)paramObject).amX);
  }
  
  public int hashCode()
  {
    int m = 0;
    int n = Arrays.hashCode(this.amw);
    int i;
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    int j;
    label88:
    int i6;
    int i7;
    int i8;
    int i9;
    int i10;
    int i11;
    if (this.amx == null)
    {
      i = 0;
      long l = Double.doubleToLongBits(this.amy);
      i1 = (int)(l ^ l >>> 32);
      i2 = Float.floatToIntBits(this.amz);
      i3 = (int)(this.amA ^ this.amA >>> 32);
      i4 = this.amB;
      i5 = this.amC;
      if (!this.amD) {
        break label272;
      }
      j = 1231;
      i6 = mc.hashCode(this.amE);
      i7 = mc.hashCode(this.amF);
      i8 = mc.hashCode(this.amG);
      i9 = mc.hashCode(this.amH);
      i10 = mc.hashCode(this.amI);
      i11 = (int)(this.amJ ^ this.amJ >>> 32);
      k = m;
      if (this.amX != null) {
        if (!this.amX.isEmpty()) {
          break label279;
        }
      }
    }
    label272:
    label279:
    for (int k = m;; k = this.amX.hashCode())
    {
      return (((((((j + ((((((i + (n + 527) * 31) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + k;
      i = this.amx.hashCode();
      break;
      j = 1237;
      break label88;
    }
  }
  
  public a nA()
  {
    this.amw = mh.ank;
    this.amx = "";
    this.amy = 0.0D;
    this.amz = 0.0F;
    this.amA = 0L;
    this.amB = 0;
    this.amC = 0;
    this.amD = false;
    this.amE = lw.a.nw();
    this.amF = lw.a.a.ny();
    this.amG = mh.ani;
    this.amH = mh.ane;
    this.amI = mh.anf;
    this.amJ = 0L;
    this.amX = null;
    this.anb = -1;
    return this;
  }
  
  public a t(ly paramly)
  {
    for (;;)
    {
      int i = paramly.nB();
      int j;
      Object localObject;
      int k;
      switch (i)
      {
      default: 
        if (a(paramly, i)) {}
        break;
      case 0: 
        return this;
      case 10: 
        this.amw = paramly.readBytes();
        break;
      case 18: 
        this.amx = paramly.readString();
        break;
      case 25: 
        this.amy = paramly.readDouble();
        break;
      case 37: 
        this.amz = paramly.readFloat();
        break;
      case 40: 
        this.amA = paramly.nD();
        break;
      case 48: 
        this.amB = paramly.nE();
        break;
      case 56: 
        this.amC = paramly.nG();
        break;
      case 64: 
        this.amD = paramly.nF();
        break;
      case 74: 
        j = mh.b(paramly, 74);
        if (this.amE == null) {}
        for (i = 0;; i = this.amE.length)
        {
          localObject = new lw.a[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.amE, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new lw.a();
            paramly.a(localObject[j]);
            paramly.nB();
            j += 1;
          }
        }
        localObject[j] = new lw.a();
        paramly.a(localObject[j]);
        this.amE = ((lw.a[])localObject);
        break;
      case 82: 
        j = mh.b(paramly, 82);
        if (this.amF == null) {}
        for (i = 0;; i = this.amF.length)
        {
          localObject = new lw.a.a[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.amF, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new lw.a.a();
            paramly.a(localObject[j]);
            paramly.nB();
            j += 1;
          }
        }
        localObject[j] = new lw.a.a();
        paramly.a(localObject[j]);
        this.amF = ((lw.a.a[])localObject);
        break;
      case 90: 
        j = mh.b(paramly, 90);
        if (this.amG == null) {}
        for (i = 0;; i = this.amG.length)
        {
          localObject = new String[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.amG, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = paramly.readString();
            paramly.nB();
            j += 1;
          }
        }
        localObject[j] = paramly.readString();
        this.amG = ((String[])localObject);
        break;
      case 96: 
        j = mh.b(paramly, 96);
        if (this.amH == null) {}
        for (i = 0;; i = this.amH.length)
        {
          localObject = new long[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.amH, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = paramly.nD();
            paramly.nB();
            j += 1;
          }
        }
        localObject[j] = paramly.nD();
        this.amH = ((long[])localObject);
        break;
      case 98: 
        k = paramly.ex(paramly.nI());
        i = paramly.getPosition();
        j = 0;
        while (paramly.nN() > 0)
        {
          paramly.nD();
          j += 1;
        }
        paramly.ez(i);
        if (this.amH == null) {}
        for (i = 0;; i = this.amH.length)
        {
          localObject = new long[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.amH, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length)
          {
            localObject[j] = paramly.nD();
            j += 1;
          }
        }
        this.amH = ((long[])localObject);
        paramly.ey(k);
        break;
      case 104: 
        this.amJ = paramly.nD();
        break;
      case 117: 
        j = mh.b(paramly, 117);
        if (this.amI == null) {}
        for (i = 0;; i = this.amI.length)
        {
          localObject = new float[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.amI, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = paramly.readFloat();
            paramly.nB();
            j += 1;
          }
        }
        localObject[j] = paramly.readFloat();
        this.amI = ((float[])localObject);
        break;
      case 114: 
        i = paramly.nI();
        k = paramly.ex(i);
        j = i / 4;
        if (this.amI == null) {}
        for (i = 0;; i = this.amI.length)
        {
          localObject = new float[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.amI, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length)
          {
            localObject[j] = paramly.readFloat();
            j += 1;
          }
        }
        this.amI = ((float[])localObject);
        paramly.ey(k);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/lw$a$a$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */