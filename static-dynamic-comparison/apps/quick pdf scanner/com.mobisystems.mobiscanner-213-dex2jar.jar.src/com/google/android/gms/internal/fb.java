package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class fb
{
  private void a(StringBuilder paramStringBuilder, a parama, Object paramObject)
  {
    if (parama.qC() == 11)
    {
      paramStringBuilder.append(((fb)parama.qL().cast(paramObject)).toString());
      return;
    }
    if (parama.qC() == 7)
    {
      paramStringBuilder.append("\"");
      paramStringBuilder.append(dw.aU((String)paramObject));
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
      localObject = parama.O(paramObject);
    }
    return (I)localObject;
  }
  
  protected boolean a(a parama)
  {
    if (parama.qD() == 11)
    {
      if (parama.qI()) {
        return aS(parama.qJ());
      }
      return aR(parama.qJ());
    }
    return aQ(parama.qJ());
  }
  
  protected abstract Object aP(String paramString);
  
  protected abstract boolean aQ(String paramString);
  
  protected boolean aR(String paramString)
  {
    throw new UnsupportedOperationException("Concrete types not supported");
  }
  
  protected boolean aS(String paramString)
  {
    throw new UnsupportedOperationException("Concrete type arrays not supported");
  }
  
  protected Object b(a parama)
  {
    boolean bool = true;
    String str = parama.qJ();
    if (parama.qL() != null)
    {
      if (aP(parama.qJ()) == null)
      {
        dc.a(bool, "Concrete field shouldn't be value object: " + parama.qJ());
        if (!parama.qI()) {
          break label80;
        }
      }
      label80:
      for (parama = qG();; parama = qF())
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
    return aP(parama.qJ());
  }
  
  public abstract HashMap<String, a<?, ?>> qE();
  
  public HashMap<String, Object> qF()
  {
    return null;
  }
  
  public HashMap<String, Object> qG()
  {
    return null;
  }
  
  public String toString()
  {
    HashMap localHashMap = qE();
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
        switch (locala.qD())
        {
        default: 
          if (locala.qH()) {
            a(localStringBuilder, locala, (ArrayList)localObject);
          }
          break;
        case 8: 
          localStringBuilder.append("\"").append(ds.b((byte[])localObject)).append("\"");
          break;
        case 9: 
          localStringBuilder.append("\"").append(ds.c((byte[])localObject)).append("\"");
          break;
        case 10: 
          dx.a(localStringBuilder, (HashMap)localObject);
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
    public static final dm LN = new dm();
    protected final int LD;
    protected final boolean LE;
    protected final int LF;
    protected final boolean LG;
    protected final String LH;
    protected final int LI;
    protected final Class<? extends fb> LJ;
    protected final String LK;
    private fe LL;
    private fb.b<I, O> LM;
    private final int qh;
    
    a(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, int paramInt4, String paramString2, ew paramew)
    {
      this.qh = paramInt1;
      this.LD = paramInt2;
      this.LE = paramBoolean1;
      this.LF = paramInt3;
      this.LG = paramBoolean2;
      this.LH = paramString1;
      this.LI = paramInt4;
      if (paramString2 == null) {
        this.LJ = null;
      }
      for (this.LK = null; paramew == null; this.LK = paramString2)
      {
        this.LM = null;
        return;
        this.LJ = fh.class;
      }
      this.LM = paramew.qA();
    }
    
    protected a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString, int paramInt3, Class<? extends fb> paramClass, fb.b<I, O> paramb)
    {
      this.qh = 1;
      this.LD = paramInt1;
      this.LE = paramBoolean1;
      this.LF = paramInt2;
      this.LG = paramBoolean2;
      this.LH = paramString;
      this.LI = paramInt3;
      this.LJ = paramClass;
      if (paramClass == null) {}
      for (this.LK = null;; this.LK = paramClass.getCanonicalName())
      {
        this.LM = paramb;
        return;
      }
    }
    
    public static a a(String paramString, int paramInt, fb.b<?, ?> paramb, boolean paramBoolean)
    {
      return new a(paramb.qC(), paramBoolean, paramb.qD(), false, paramString, paramInt, null, paramb);
    }
    
    public static <T extends fb> a<T, T> a(String paramString, int paramInt, Class<T> paramClass)
    {
      return new a(11, false, 11, false, paramString, paramInt, paramClass, null);
    }
    
    public static <T extends fb> a<ArrayList<T>, ArrayList<T>> b(String paramString, int paramInt, Class<T> paramClass)
    {
      return new a(11, true, 11, true, paramString, paramInt, paramClass, null);
    }
    
    public static a<Integer, Integer> e(String paramString, int paramInt)
    {
      return new a(0, false, 0, false, paramString, paramInt, null, null);
    }
    
    public static a<Double, Double> f(String paramString, int paramInt)
    {
      return new a(4, false, 4, false, paramString, paramInt, null, null);
    }
    
    public static a<Boolean, Boolean> g(String paramString, int paramInt)
    {
      return new a(6, false, 6, false, paramString, paramInt, null, null);
    }
    
    public static a<String, String> h(String paramString, int paramInt)
    {
      return new a(7, false, 7, false, paramString, paramInt, null, null);
    }
    
    public static a<ArrayList<String>, ArrayList<String>> i(String paramString, int paramInt)
    {
      return new a(7, true, 7, true, paramString, paramInt, null, null);
    }
    
    public I O(O paramO)
    {
      return (I)this.LM.O(paramO);
    }
    
    public void a(fe paramfe)
    {
      this.LL = paramfe;
    }
    
    public int describeContents()
    {
      dm localdm = LN;
      return 0;
    }
    
    public int lX()
    {
      return this.qh;
    }
    
    public int qC()
    {
      return this.LD;
    }
    
    public int qD()
    {
      return this.LF;
    }
    
    public boolean qH()
    {
      return this.LE;
    }
    
    public boolean qI()
    {
      return this.LG;
    }
    
    public String qJ()
    {
      return this.LH;
    }
    
    public int qK()
    {
      return this.LI;
    }
    
    public Class<? extends fb> qL()
    {
      return this.LJ;
    }
    
    String qM()
    {
      if (this.LK == null) {
        return null;
      }
      return this.LK;
    }
    
    public boolean qN()
    {
      return this.LM != null;
    }
    
    ew qO()
    {
      if (this.LM == null) {
        return null;
      }
      return ew.a(this.LM);
    }
    
    public HashMap<String, a<?, ?>> qP()
    {
      dc.N(this.LK);
      dc.N(this.LL);
      return this.LL.aT(this.LK);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("Field\n");
      localStringBuilder1.append("            versionCode=").append(this.qh).append('\n');
      localStringBuilder1.append("                 typeIn=").append(this.LD).append('\n');
      localStringBuilder1.append("            typeInArray=").append(this.LE).append('\n');
      localStringBuilder1.append("                typeOut=").append(this.LF).append('\n');
      localStringBuilder1.append("           typeOutArray=").append(this.LG).append('\n');
      localStringBuilder1.append("        outputFieldName=").append(this.LH).append('\n');
      localStringBuilder1.append("      safeParcelFieldId=").append(this.LI).append('\n');
      localStringBuilder1.append("       concreteTypeName=").append(qM()).append('\n');
      if (qL() != null) {
        localStringBuilder1.append("     concreteType.class=").append(qL().getCanonicalName()).append('\n');
      }
      StringBuilder localStringBuilder2 = localStringBuilder1.append("          converterName=");
      if (this.LM == null) {}
      for (String str = "null";; str = this.LM.getClass().getCanonicalName())
      {
        localStringBuilder2.append(str).append('\n');
        return localStringBuilder1.toString();
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      dm localdm = LN;
      dm.a(this, paramParcel, paramInt);
    }
  }
  
  public static abstract interface b<I, O>
  {
    public abstract I O(O paramO);
    
    public abstract int qC();
    
    public abstract int qD();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/fb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */