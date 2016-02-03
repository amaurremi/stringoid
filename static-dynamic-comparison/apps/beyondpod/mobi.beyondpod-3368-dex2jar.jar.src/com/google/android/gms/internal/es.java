package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class es
{
  private void a(StringBuilder paramStringBuilder, a parama, Object paramObject)
  {
    if (parama.ch() == 11)
    {
      paramStringBuilder.append(((es)parama.cr().cast(paramObject)).toString());
      return;
    }
    if (parama.ch() == 7)
    {
      paramStringBuilder.append("\"");
      paramStringBuilder.append(fe.aa((String)paramObject));
      paramStringBuilder.append("\"");
      return;
    }
    paramStringBuilder.append(paramObject);
  }
  
  private void a(StringBuilder paramStringBuilder, a parama, ArrayList<Object> paramArrayList)
  {
    paramStringBuilder.append("[");
    int i = 0;
    int j = paramArrayList.size();
    while (i < j)
    {
      if (i > 0) {
        paramStringBuilder.append(",");
      }
      Object localObject = paramArrayList.get(i);
      if (localObject != null) {
        a(paramStringBuilder, parama, localObject);
      }
      i += 1;
    }
    paramStringBuilder.append("]");
  }
  
  protected abstract Object V(String paramString);
  
  protected abstract boolean W(String paramString);
  
  protected boolean X(String paramString)
  {
    throw new UnsupportedOperationException("Concrete types not supported");
  }
  
  protected boolean Y(String paramString)
  {
    throw new UnsupportedOperationException("Concrete type arrays not supported");
  }
  
  protected <O, I> I a(a<I, O> parama, Object paramObject)
  {
    Object localObject = paramObject;
    if (a.c(parama) != null) {
      localObject = parama.g(paramObject);
    }
    return (I)localObject;
  }
  
  protected boolean a(a parama)
  {
    if (parama.ci() == 11)
    {
      if (parama.co()) {
        return Y(parama.cp());
      }
      return X(parama.cp());
    }
    return W(parama.cp());
  }
  
  protected Object b(a parama)
  {
    boolean bool = true;
    String str = parama.cp();
    if (parama.cr() != null)
    {
      if (V(parama.cp()) == null)
      {
        eg.a(bool, "Concrete field shouldn't be value object: " + parama.cp());
        if (!parama.co()) {
          break label80;
        }
      }
      label80:
      for (parama = cl();; parama = ck())
      {
        if (parama == null) {
          break label88;
        }
        return parama.get(str);
        bool = false;
        break;
      }
      try
      {
        label88:
        parama = "get" + Character.toUpperCase(str.charAt(0)) + str.substring(1);
        parama = getClass().getMethod(parama, new Class[0]).invoke(this, new Object[0]);
        return parama;
      }
      catch (Exception parama)
      {
        throw new RuntimeException(parama);
      }
    }
    return V(parama.cp());
  }
  
  public abstract HashMap<String, a<?, ?>> cj();
  
  public HashMap<String, Object> ck()
  {
    return null;
  }
  
  public HashMap<String, Object> cl()
  {
    return null;
  }
  
  public String toString()
  {
    HashMap localHashMap = cj();
    StringBuilder localStringBuilder = new StringBuilder(100);
    Iterator localIterator = localHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      a locala = (a)localHashMap.get(str);
      if (a(locala))
      {
        Object localObject = a(locala, b(locala));
        if (localStringBuilder.length() == 0) {
          localStringBuilder.append("{");
        }
        for (;;)
        {
          localStringBuilder.append("\"").append(str).append("\":");
          if (localObject != null) {
            break label135;
          }
          localStringBuilder.append("null");
          break;
          localStringBuilder.append(",");
        }
        label135:
        switch (locala.ci())
        {
        default: 
          if (locala.cn()) {
            a(localStringBuilder, locala, (ArrayList)localObject);
          }
          break;
        case 8: 
          localStringBuilder.append("\"").append(fb.b((byte[])localObject)).append("\"");
          break;
        case 9: 
          localStringBuilder.append("\"").append(fb.c((byte[])localObject)).append("\"");
          break;
        case 10: 
          ff.a(localStringBuilder, (HashMap)localObject);
          continue;
          a(localStringBuilder, locala, localObject);
        }
      }
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.append("}");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("{}");
    }
  }
  
  public static class a<I, O>
    implements SafeParcelable
  {
    public static final et CREATOR = new et();
    private final int kg;
    protected final int qi;
    protected final boolean qj;
    protected final int qk;
    protected final boolean ql;
    protected final String qm;
    protected final int qn;
    protected final Class<? extends es> qo;
    protected final String qp;
    private ev qq;
    private es.b<I, O> qr;
    
    a(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, int paramInt4, String paramString2, en paramen)
    {
      this.kg = paramInt1;
      this.qi = paramInt2;
      this.qj = paramBoolean1;
      this.qk = paramInt3;
      this.ql = paramBoolean2;
      this.qm = paramString1;
      this.qn = paramInt4;
      if (paramString2 == null) {
        this.qo = null;
      }
      for (this.qp = null; paramen == null; this.qp = paramString2)
      {
        this.qr = null;
        return;
        this.qo = ey.class;
      }
      this.qr = paramen.cf();
    }
    
    protected a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString, int paramInt3, Class<? extends es> paramClass, es.b<I, O> paramb)
    {
      this.kg = 1;
      this.qi = paramInt1;
      this.qj = paramBoolean1;
      this.qk = paramInt2;
      this.ql = paramBoolean2;
      this.qm = paramString;
      this.qn = paramInt3;
      this.qo = paramClass;
      if (paramClass == null) {}
      for (this.qp = null;; this.qp = paramClass.getCanonicalName())
      {
        this.qr = paramb;
        return;
      }
    }
    
    public static a a(String paramString, int paramInt, es.b<?, ?> paramb, boolean paramBoolean)
    {
      return new a(paramb.ch(), paramBoolean, paramb.ci(), false, paramString, paramInt, null, paramb);
    }
    
    public static <T extends es> a<T, T> a(String paramString, int paramInt, Class<T> paramClass)
    {
      return new a(11, false, 11, false, paramString, paramInt, paramClass, null);
    }
    
    public static <T extends es> a<ArrayList<T>, ArrayList<T>> b(String paramString, int paramInt, Class<T> paramClass)
    {
      return new a(11, true, 11, true, paramString, paramInt, paramClass, null);
    }
    
    public static a<Integer, Integer> d(String paramString, int paramInt)
    {
      return new a(0, false, 0, false, paramString, paramInt, null, null);
    }
    
    public static a<Double, Double> e(String paramString, int paramInt)
    {
      return new a(4, false, 4, false, paramString, paramInt, null, null);
    }
    
    public static a<Boolean, Boolean> f(String paramString, int paramInt)
    {
      return new a(6, false, 6, false, paramString, paramInt, null, null);
    }
    
    public static a<String, String> g(String paramString, int paramInt)
    {
      return new a(7, false, 7, false, paramString, paramInt, null, null);
    }
    
    public static a<ArrayList<String>, ArrayList<String>> h(String paramString, int paramInt)
    {
      return new a(7, true, 7, true, paramString, paramInt, null, null);
    }
    
    public void a(ev paramev)
    {
      this.qq = paramev;
    }
    
    public int ch()
    {
      return this.qi;
    }
    
    public int ci()
    {
      return this.qk;
    }
    
    public a<I, O> cm()
    {
      return new a(this.kg, this.qi, this.qj, this.qk, this.ql, this.qm, this.qn, this.qp, cu());
    }
    
    public boolean cn()
    {
      return this.qj;
    }
    
    public boolean co()
    {
      return this.ql;
    }
    
    public String cp()
    {
      return this.qm;
    }
    
    public int cq()
    {
      return this.qn;
    }
    
    public Class<? extends es> cr()
    {
      return this.qo;
    }
    
    String cs()
    {
      if (this.qp == null) {
        return null;
      }
      return this.qp;
    }
    
    public boolean ct()
    {
      return this.qr != null;
    }
    
    en cu()
    {
      if (this.qr == null) {
        return null;
      }
      return en.a(this.qr);
    }
    
    public HashMap<String, a<?, ?>> cv()
    {
      eg.f(this.qp);
      eg.f(this.qq);
      return this.qq.Z(this.qp);
    }
    
    public int describeContents()
    {
      et localet = CREATOR;
      return 0;
    }
    
    public I g(O paramO)
    {
      return (I)this.qr.g(paramO);
    }
    
    public int getVersionCode()
    {
      return this.kg;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("Field\n");
      localStringBuilder1.append("            versionCode=").append(this.kg).append('\n');
      localStringBuilder1.append("                 typeIn=").append(this.qi).append('\n');
      localStringBuilder1.append("            typeInArray=").append(this.qj).append('\n');
      localStringBuilder1.append("                typeOut=").append(this.qk).append('\n');
      localStringBuilder1.append("           typeOutArray=").append(this.ql).append('\n');
      localStringBuilder1.append("        outputFieldName=").append(this.qm).append('\n');
      localStringBuilder1.append("      safeParcelFieldId=").append(this.qn).append('\n');
      localStringBuilder1.append("       concreteTypeName=").append(cs()).append('\n');
      if (cr() != null) {
        localStringBuilder1.append("     concreteType.class=").append(cr().getCanonicalName()).append('\n');
      }
      StringBuilder localStringBuilder2 = localStringBuilder1.append("          converterName=");
      if (this.qr == null) {}
      for (String str = "null";; str = this.qr.getClass().getCanonicalName())
      {
        localStringBuilder2.append(str).append('\n');
        return localStringBuilder1.toString();
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      et localet = CREATOR;
      et.a(this, paramParcel, paramInt);
    }
  }
  
  public static abstract interface b<I, O>
  {
    public abstract int ch();
    
    public abstract int ci();
    
    public abstract I g(O paramO);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/es.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */