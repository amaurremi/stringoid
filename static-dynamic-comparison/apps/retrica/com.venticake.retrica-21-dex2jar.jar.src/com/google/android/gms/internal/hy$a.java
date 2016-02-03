package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;

public class hy$a<I, O>
  implements SafeParcelable
{
  public static final hz CREATOR = new hz();
  protected final int Hb;
  protected final boolean Hc;
  protected final int Hd;
  protected final boolean He;
  protected final String Hf;
  protected final int Hg;
  protected final Class<? extends hy> Hh;
  protected final String Hi;
  private ib Hj;
  private hy.b<I, O> Hk;
  private final int xM;
  
  hy$a(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, int paramInt4, String paramString2, ht paramht)
  {
    this.xM = paramInt1;
    this.Hb = paramInt2;
    this.Hc = paramBoolean1;
    this.Hd = paramInt3;
    this.He = paramBoolean2;
    this.Hf = paramString1;
    this.Hg = paramInt4;
    if (paramString2 == null) {
      this.Hh = null;
    }
    for (this.Hi = null; paramht == null; this.Hi = paramString2)
    {
      this.Hk = null;
      return;
      this.Hh = ie.class;
    }
    this.Hk = paramht.fC();
  }
  
  protected hy$a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString, int paramInt3, Class<? extends hy> paramClass, hy.b<I, O> paramb)
  {
    this.xM = 1;
    this.Hb = paramInt1;
    this.Hc = paramBoolean1;
    this.Hd = paramInt2;
    this.He = paramBoolean2;
    this.Hf = paramString;
    this.Hg = paramInt3;
    this.Hh = paramClass;
    if (paramClass == null) {}
    for (this.Hi = null;; this.Hi = paramClass.getCanonicalName())
    {
      this.Hk = paramb;
      return;
    }
  }
  
  public static a a(String paramString, int paramInt, hy.b<?, ?> paramb, boolean paramBoolean)
  {
    return new a(paramb.fE(), paramBoolean, paramb.fF(), false, paramString, paramInt, null, paramb);
  }
  
  public static <T extends hy> a<T, T> a(String paramString, int paramInt, Class<T> paramClass)
  {
    return new a(11, false, 11, false, paramString, paramInt, paramClass, null);
  }
  
  public static <T extends hy> a<ArrayList<T>, ArrayList<T>> b(String paramString, int paramInt, Class<T> paramClass)
  {
    return new a(11, true, 11, true, paramString, paramInt, paramClass, null);
  }
  
  public static a<Integer, Integer> g(String paramString, int paramInt)
  {
    return new a(0, false, 0, false, paramString, paramInt, null, null);
  }
  
  public static a<Double, Double> h(String paramString, int paramInt)
  {
    return new a(4, false, 4, false, paramString, paramInt, null, null);
  }
  
  public static a<Boolean, Boolean> i(String paramString, int paramInt)
  {
    return new a(6, false, 6, false, paramString, paramInt, null, null);
  }
  
  public static a<String, String> j(String paramString, int paramInt)
  {
    return new a(7, false, 7, false, paramString, paramInt, null, null);
  }
  
  public static a<ArrayList<String>, ArrayList<String>> k(String paramString, int paramInt)
  {
    return new a(7, true, 7, true, paramString, paramInt, null, null);
  }
  
  public void a(ib paramib)
  {
    this.Hj = paramib;
  }
  
  public int describeContents()
  {
    hz localhz = CREATOR;
    return 0;
  }
  
  public int fE()
  {
    return this.Hb;
  }
  
  public int fF()
  {
    return this.Hd;
  }
  
  public a<I, O> fJ()
  {
    return new a(this.xM, this.Hb, this.Hc, this.Hd, this.He, this.Hf, this.Hg, this.Hi, fR());
  }
  
  public boolean fK()
  {
    return this.Hc;
  }
  
  public boolean fL()
  {
    return this.He;
  }
  
  public String fM()
  {
    return this.Hf;
  }
  
  public int fN()
  {
    return this.Hg;
  }
  
  public Class<? extends hy> fO()
  {
    return this.Hh;
  }
  
  String fP()
  {
    if (this.Hi == null) {
      return null;
    }
    return this.Hi;
  }
  
  public boolean fQ()
  {
    return this.Hk != null;
  }
  
  ht fR()
  {
    if (this.Hk == null) {
      return null;
    }
    return ht.a(this.Hk);
  }
  
  public HashMap<String, a<?, ?>> fS()
  {
    hm.f(this.Hi);
    hm.f(this.Hj);
    return this.Hj.aJ(this.Hi);
  }
  
  public I g(O paramO)
  {
    return (I)this.Hk.g(paramO);
  }
  
  public int getVersionCode()
  {
    return this.xM;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("Field\n");
    localStringBuilder1.append("            versionCode=").append(this.xM).append('\n');
    localStringBuilder1.append("                 typeIn=").append(this.Hb).append('\n');
    localStringBuilder1.append("            typeInArray=").append(this.Hc).append('\n');
    localStringBuilder1.append("                typeOut=").append(this.Hd).append('\n');
    localStringBuilder1.append("           typeOutArray=").append(this.He).append('\n');
    localStringBuilder1.append("        outputFieldName=").append(this.Hf).append('\n');
    localStringBuilder1.append("      safeParcelFieldId=").append(this.Hg).append('\n');
    localStringBuilder1.append("       concreteTypeName=").append(fP()).append('\n');
    if (fO() != null) {
      localStringBuilder1.append("     concreteType.class=").append(fO().getCanonicalName()).append('\n');
    }
    StringBuilder localStringBuilder2 = localStringBuilder1.append("          converterName=");
    if (this.Hk == null) {}
    for (String str = "null";; str = this.Hk.getClass().getCanonicalName())
    {
      localStringBuilder2.append(str).append('\n');
      return localStringBuilder1.toString();
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    hz localhz = CREATOR;
    hz.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/hy$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */