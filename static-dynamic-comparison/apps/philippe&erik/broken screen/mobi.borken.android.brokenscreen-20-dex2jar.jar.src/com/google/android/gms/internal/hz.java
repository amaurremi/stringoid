package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class hz
{
  private void a(StringBuilder paramStringBuilder, a parama, Object paramObject)
  {
    if (parama.fz() == 11)
    {
      paramStringBuilder.append(((hz)parama.fJ().cast(paramObject)).toString());
      return;
    }
    if (parama.fz() == 7)
    {
      paramStringBuilder.append("\"");
      paramStringBuilder.append(io.aK((String)paramObject));
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
    if (parama.fA() == 11)
    {
      if (parama.fG()) {
        return aI(parama.fH());
      }
      return aH(parama.fH());
    }
    return aG(parama.fH());
  }
  
  protected abstract Object aF(String paramString);
  
  protected abstract boolean aG(String paramString);
  
  protected boolean aH(String paramString)
  {
    throw new UnsupportedOperationException("Concrete types not supported");
  }
  
  protected boolean aI(String paramString)
  {
    throw new UnsupportedOperationException("Concrete type arrays not supported");
  }
  
  protected Object b(a parama)
  {
    String str = parama.fH();
    if (parama.fJ() != null)
    {
      boolean bool;
      if (aF(parama.fH()) == null)
      {
        bool = true;
        hn.a(bool, "Concrete field shouldn't be value object: %s", new Object[] { parama.fH() });
        if (!parama.fG()) {
          break label71;
        }
      }
      label71:
      for (parama = fD();; parama = fC())
      {
        if (parama == null) {
          break label79;
        }
        return parama.get(str);
        bool = false;
        break;
      }
      try
      {
        label79:
        parama = "get" + Character.toUpperCase(str.charAt(0)) + str.substring(1);
        parama = getClass().getMethod(parama, new Class[0]).invoke(this, new Object[0]);
        return parama;
      }
      catch (Exception parama)
      {
        throw new RuntimeException(parama);
      }
    }
    return aF(parama.fH());
  }
  
  public abstract HashMap<String, a<?, ?>> fB();
  
  public HashMap<String, Object> fC()
  {
    return null;
  }
  
  public HashMap<String, Object> fD()
  {
    return null;
  }
  
  public String toString()
  {
    HashMap localHashMap = fB();
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
        switch (locala.fA())
        {
        default: 
          if (locala.fF()) {
            a(localStringBuilder, locala, (ArrayList)localObject);
          }
          break;
        case 8: 
          localStringBuilder.append("\"").append(ii.d((byte[])localObject)).append("\"");
          break;
        case 9: 
          localStringBuilder.append("\"").append(ii.e((byte[])localObject)).append("\"");
          break;
        case 10: 
          ip.a(localStringBuilder, (HashMap)localObject);
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
    public static final ia CREATOR = new ia();
    protected final int GY;
    protected final boolean GZ;
    protected final int Ha;
    protected final boolean Hb;
    protected final String Hc;
    protected final int Hd;
    protected final Class<? extends hz> He;
    protected final String Hf;
    private ic Hg;
    private hz.b<I, O> Hh;
    private final int xJ;
    
    a(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, int paramInt4, String paramString2, hu paramhu)
    {
      this.xJ = paramInt1;
      this.GY = paramInt2;
      this.GZ = paramBoolean1;
      this.Ha = paramInt3;
      this.Hb = paramBoolean2;
      this.Hc = paramString1;
      this.Hd = paramInt4;
      if (paramString2 == null) {
        this.He = null;
      }
      for (this.Hf = null; paramhu == null; this.Hf = paramString2)
      {
        this.Hh = null;
        return;
        this.He = if.class;
      }
      this.Hh = paramhu.fx();
    }
    
    protected a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString, int paramInt3, Class<? extends hz> paramClass, hz.b<I, O> paramb)
    {
      this.xJ = 1;
      this.GY = paramInt1;
      this.GZ = paramBoolean1;
      this.Ha = paramInt2;
      this.Hb = paramBoolean2;
      this.Hc = paramString;
      this.Hd = paramInt3;
      this.He = paramClass;
      if (paramClass == null) {}
      for (this.Hf = null;; this.Hf = paramClass.getCanonicalName())
      {
        this.Hh = paramb;
        return;
      }
    }
    
    public static a a(String paramString, int paramInt, hz.b<?, ?> paramb, boolean paramBoolean)
    {
      return new a(paramb.fz(), paramBoolean, paramb.fA(), false, paramString, paramInt, null, paramb);
    }
    
    public static <T extends hz> a<T, T> a(String paramString, int paramInt, Class<T> paramClass)
    {
      return new a(11, false, 11, false, paramString, paramInt, paramClass, null);
    }
    
    public static <T extends hz> a<ArrayList<T>, ArrayList<T>> b(String paramString, int paramInt, Class<T> paramClass)
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
    
    public void a(ic paramic)
    {
      this.Hg = paramic;
    }
    
    public int describeContents()
    {
      ia localia = CREATOR;
      return 0;
    }
    
    public int fA()
    {
      return this.Ha;
    }
    
    public a<I, O> fE()
    {
      return new a(this.xJ, this.GY, this.GZ, this.Ha, this.Hb, this.Hc, this.Hd, this.Hf, fM());
    }
    
    public boolean fF()
    {
      return this.GZ;
    }
    
    public boolean fG()
    {
      return this.Hb;
    }
    
    public String fH()
    {
      return this.Hc;
    }
    
    public int fI()
    {
      return this.Hd;
    }
    
    public Class<? extends hz> fJ()
    {
      return this.He;
    }
    
    String fK()
    {
      if (this.Hf == null) {
        return null;
      }
      return this.Hf;
    }
    
    public boolean fL()
    {
      return this.Hh != null;
    }
    
    hu fM()
    {
      if (this.Hh == null) {
        return null;
      }
      return hu.a(this.Hh);
    }
    
    public HashMap<String, a<?, ?>> fN()
    {
      hn.f(this.Hf);
      hn.f(this.Hg);
      return this.Hg.aJ(this.Hf);
    }
    
    public int fz()
    {
      return this.GY;
    }
    
    public I g(O paramO)
    {
      return (I)this.Hh.g(paramO);
    }
    
    public int getVersionCode()
    {
      return this.xJ;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("Field\n");
      localStringBuilder1.append("            versionCode=").append(this.xJ).append('\n');
      localStringBuilder1.append("                 typeIn=").append(this.GY).append('\n');
      localStringBuilder1.append("            typeInArray=").append(this.GZ).append('\n');
      localStringBuilder1.append("                typeOut=").append(this.Ha).append('\n');
      localStringBuilder1.append("           typeOutArray=").append(this.Hb).append('\n');
      localStringBuilder1.append("        outputFieldName=").append(this.Hc).append('\n');
      localStringBuilder1.append("      safeParcelFieldId=").append(this.Hd).append('\n');
      localStringBuilder1.append("       concreteTypeName=").append(fK()).append('\n');
      if (fJ() != null) {
        localStringBuilder1.append("     concreteType.class=").append(fJ().getCanonicalName()).append('\n');
      }
      StringBuilder localStringBuilder2 = localStringBuilder1.append("          converterName=");
      if (this.Hh == null) {}
      for (String str = "null";; str = this.Hh.getClass().getCanonicalName())
      {
        localStringBuilder2.append(str).append('\n');
        return localStringBuilder1.toString();
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      ia localia = CREATOR;
      ia.a(this, paramParcel, paramInt);
    }
  }
  
  public static abstract interface b<I, O>
  {
    public abstract int fA();
    
    public abstract int fz();
    
    public abstract I g(O paramO);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/hz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */