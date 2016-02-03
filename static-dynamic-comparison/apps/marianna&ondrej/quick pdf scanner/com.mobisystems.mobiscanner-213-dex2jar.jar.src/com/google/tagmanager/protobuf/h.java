package com.google.tagmanager.protobuf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

final class h<FieldDescriptorType extends a<FieldDescriptorType>>
{
  private static final h ajF = new h(true);
  private final s<FieldDescriptorType, Object> ajC;
  private boolean ajD;
  private boolean ajE = false;
  
  private h()
  {
    this.ajC = s.fv(16);
  }
  
  private h(boolean paramBoolean)
  {
    this.ajC = s.fv(0);
    Bx();
  }
  
  public static <T extends a<T>> h<T> Bv()
  {
    return new h();
  }
  
  public static <T extends a<T>> h<T> Bw()
  {
    return ajF;
  }
  
  private static int a(WireFormat.FieldType paramFieldType, int paramInt, Object paramObject)
  {
    paramInt = CodedOutputStream.fm(paramInt);
    if ((paramFieldType == WireFormat.FieldType.akZ) && (!i.g((n)paramObject))) {
      paramInt *= 2;
    }
    for (;;)
    {
      return paramInt + b(paramFieldType, paramObject);
    }
  }
  
  static int a(WireFormat.FieldType paramFieldType, boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2;
    }
    return paramFieldType.Cs();
  }
  
  public static Object a(f paramf, WireFormat.FieldType paramFieldType, boolean paramBoolean)
  {
    switch (1.ajH[paramFieldType.ordinal()])
    {
    default: 
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case 1: 
      return Double.valueOf(paramf.readDouble());
    case 2: 
      return Float.valueOf(paramf.readFloat());
    case 3: 
      return Long.valueOf(paramf.AV());
    case 4: 
      return Long.valueOf(paramf.AU());
    case 5: 
      return Integer.valueOf(paramf.AW());
    case 6: 
      return Long.valueOf(paramf.AX());
    case 7: 
      return Integer.valueOf(paramf.AY());
    case 8: 
      return Boolean.valueOf(paramf.AZ());
    case 9: 
      if (paramBoolean) {
        return paramf.Ba();
      }
      return paramf.readString();
    case 10: 
      return paramf.Bb();
    case 11: 
      return Integer.valueOf(paramf.Bc());
    case 12: 
      return Integer.valueOf(paramf.Be());
    case 13: 
      return Long.valueOf(paramf.Bf());
    case 14: 
      return Integer.valueOf(paramf.Bg());
    case 15: 
      return Long.valueOf(paramf.Bh());
    case 16: 
      throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
    case 17: 
      throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
    }
    throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
  }
  
  private static void a(CodedOutputStream paramCodedOutputStream, WireFormat.FieldType paramFieldType, int paramInt, Object paramObject)
  {
    if (paramFieldType == WireFormat.FieldType.akZ)
    {
      if (i.g((n)paramObject))
      {
        paramCodedOutputStream.B(paramInt, 3);
        paramCodedOutputStream.c((n)paramObject);
        return;
      }
      paramCodedOutputStream.a(paramInt, (n)paramObject);
      return;
    }
    paramCodedOutputStream.B(paramInt, a(paramFieldType, false));
    a(paramCodedOutputStream, paramFieldType, paramObject);
  }
  
  private static void a(CodedOutputStream paramCodedOutputStream, WireFormat.FieldType paramFieldType, Object paramObject)
  {
    switch (1.ajH[paramFieldType.ordinal()])
    {
    default: 
      return;
    case 1: 
      paramCodedOutputStream.m(((Double)paramObject).doubleValue());
      return;
    case 2: 
      paramCodedOutputStream.t(((Float)paramObject).floatValue());
      return;
    case 3: 
      paramCodedOutputStream.G(((Long)paramObject).longValue());
      return;
    case 4: 
      paramCodedOutputStream.F(((Long)paramObject).longValue());
      return;
    case 5: 
      paramCodedOutputStream.eZ(((Integer)paramObject).intValue());
      return;
    case 6: 
      paramCodedOutputStream.H(((Long)paramObject).longValue());
      return;
    case 7: 
      paramCodedOutputStream.fa(((Integer)paramObject).intValue());
      return;
    case 8: 
      paramCodedOutputStream.aI(((Boolean)paramObject).booleanValue());
      return;
    case 9: 
      paramCodedOutputStream.cV((String)paramObject);
      return;
    case 16: 
      paramCodedOutputStream.c((n)paramObject);
      return;
    case 17: 
      paramCodedOutputStream.d((n)paramObject);
      return;
    case 10: 
      if ((paramObject instanceof e))
      {
        paramCodedOutputStream.b((e)paramObject);
        return;
      }
      paramCodedOutputStream.n((byte[])paramObject);
      return;
    case 11: 
      paramCodedOutputStream.fb(((Integer)paramObject).intValue());
      return;
    case 12: 
      paramCodedOutputStream.fd(((Integer)paramObject).intValue());
      return;
    case 13: 
      paramCodedOutputStream.I(((Long)paramObject).longValue());
      return;
    case 14: 
      paramCodedOutputStream.fe(((Integer)paramObject).intValue());
      return;
    case 15: 
      paramCodedOutputStream.J(((Long)paramObject).longValue());
      return;
    }
    if ((paramObject instanceof i.a))
    {
      paramCodedOutputStream.fc(((i.a)paramObject).ga());
      return;
    }
    paramCodedOutputStream.fc(((Integer)paramObject).intValue());
  }
  
  private static void a(WireFormat.FieldType paramFieldType, Object paramObject)
  {
    boolean bool = false;
    if (paramObject == null) {
      throw new NullPointerException();
    }
    switch (1.ajG[paramFieldType.Cr().ordinal()])
    {
    }
    while (!bool)
    {
      throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      bool = paramObject instanceof Integer;
      continue;
      bool = paramObject instanceof Long;
      continue;
      bool = paramObject instanceof Float;
      continue;
      bool = paramObject instanceof Double;
      continue;
      bool = paramObject instanceof Boolean;
      continue;
      bool = paramObject instanceof String;
      continue;
      if (((paramObject instanceof e)) || ((paramObject instanceof byte[])))
      {
        bool = true;
        continue;
        if (((paramObject instanceof Integer)) || ((paramObject instanceof i.a)))
        {
          bool = true;
          continue;
          if (((paramObject instanceof n)) || ((paramObject instanceof j))) {
            bool = true;
          }
        }
      }
    }
  }
  
  public static void a(a<?> parama, Object paramObject, CodedOutputStream paramCodedOutputStream)
  {
    WireFormat.FieldType localFieldType = parama.Bz();
    int i = parama.ga();
    if (parama.BB())
    {
      paramObject = (List)paramObject;
      if (parama.BC())
      {
        paramCodedOutputStream.B(i, 2);
        i = 0;
        parama = ((List)paramObject).iterator();
        while (parama.hasNext()) {
          i += b(localFieldType, parama.next());
        }
        paramCodedOutputStream.fn(i);
        parama = ((List)paramObject).iterator();
        while (parama.hasNext()) {
          a(paramCodedOutputStream, localFieldType, parama.next());
        }
      }
      parama = ((List)paramObject).iterator();
      while (parama.hasNext()) {
        a(paramCodedOutputStream, localFieldType, i, parama.next());
      }
    }
    if ((paramObject instanceof j))
    {
      a(paramCodedOutputStream, localFieldType, i, ((j)paramObject).BX());
      return;
    }
    a(paramCodedOutputStream, localFieldType, i, paramObject);
  }
  
  private static int b(WireFormat.FieldType paramFieldType, Object paramObject)
  {
    switch (1.ajH[paramFieldType.ordinal()])
    {
    default: 
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case 1: 
      return CodedOutputStream.n(((Double)paramObject).doubleValue());
    case 2: 
      return CodedOutputStream.u(((Float)paramObject).floatValue());
    case 3: 
      return CodedOutputStream.L(((Long)paramObject).longValue());
    case 4: 
      return CodedOutputStream.K(((Long)paramObject).longValue());
    case 5: 
      return CodedOutputStream.ff(((Integer)paramObject).intValue());
    case 6: 
      return CodedOutputStream.M(((Long)paramObject).longValue());
    case 7: 
      return CodedOutputStream.fg(((Integer)paramObject).intValue());
    case 8: 
      return CodedOutputStream.aJ(((Boolean)paramObject).booleanValue());
    case 9: 
      return CodedOutputStream.cW((String)paramObject);
    case 16: 
      return CodedOutputStream.e((n)paramObject);
    case 10: 
      if ((paramObject instanceof e)) {
        return CodedOutputStream.c((e)paramObject);
      }
      return CodedOutputStream.o((byte[])paramObject);
    case 11: 
      return CodedOutputStream.fh(((Integer)paramObject).intValue());
    case 12: 
      return CodedOutputStream.fj(((Integer)paramObject).intValue());
    case 13: 
      return CodedOutputStream.N(((Long)paramObject).longValue());
    case 14: 
      return CodedOutputStream.fk(((Integer)paramObject).intValue());
    case 15: 
      return CodedOutputStream.O(((Long)paramObject).longValue());
    case 17: 
      if ((paramObject instanceof j)) {
        return CodedOutputStream.a((j)paramObject);
      }
      return CodedOutputStream.f((n)paramObject);
    }
    if ((paramObject instanceof i.a)) {
      return CodedOutputStream.fi(((i.a)paramObject).ga());
    }
    return CodedOutputStream.fi(((Integer)paramObject).intValue());
  }
  
  private boolean b(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    a locala = (a)paramEntry.getKey();
    if (locala.BA() == WireFormat.JavaType.alr)
    {
      if (locala.BB())
      {
        paramEntry = ((List)paramEntry.getValue()).iterator();
        do
        {
          if (!paramEntry.hasNext()) {
            break;
          }
        } while (((n)paramEntry.next()).isInitialized());
        return false;
      }
      paramEntry = paramEntry.getValue();
      if ((paramEntry instanceof n))
      {
        if (!((n)paramEntry).isInitialized()) {
          return false;
        }
      }
      else
      {
        if ((paramEntry instanceof j)) {
          return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
    }
    return true;
  }
  
  public static int c(a<?> parama, Object paramObject)
  {
    int j = 0;
    int i = 0;
    WireFormat.FieldType localFieldType = parama.Bz();
    int k = parama.ga();
    if (parama.BB())
    {
      if (parama.BC())
      {
        parama = ((List)paramObject).iterator();
        while (parama.hasNext()) {
          i += b(localFieldType, parama.next());
        }
        j = CodedOutputStream.fm(k);
        j = CodedOutputStream.fo(i) + (j + i);
        return j;
      }
      parama = ((List)paramObject).iterator();
      i = j;
      for (;;)
      {
        j = i;
        if (!parama.hasNext()) {
          break;
        }
        i += a(localFieldType, k, parama.next());
      }
    }
    return a(localFieldType, k, paramObject);
  }
  
  private void c(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    a locala = (a)paramEntry.getKey();
    Object localObject = paramEntry.getValue();
    paramEntry = (Map.Entry<FieldDescriptorType, Object>)localObject;
    if ((localObject instanceof j)) {
      paramEntry = ((j)localObject).BX();
    }
    if (locala.BB())
    {
      localObject = a(locala);
      if (localObject == null)
      {
        this.ajC.a(locala, new ArrayList((List)paramEntry));
        return;
      }
      ((List)localObject).addAll((List)paramEntry);
      return;
    }
    if (locala.BA() == WireFormat.JavaType.alr)
    {
      localObject = a(locala);
      if (localObject == null)
      {
        this.ajC.a(locala, paramEntry);
        return;
      }
      if ((localObject instanceof p)) {}
      for (paramEntry = locala.a((p)localObject, (p)paramEntry);; paramEntry = locala.a(((n)localObject).fM(), (n)paramEntry).fY())
      {
        this.ajC.a(locala, paramEntry);
        return;
      }
    }
    this.ajC.a(locala, paramEntry);
  }
  
  public void Bx()
  {
    if (this.ajD) {
      return;
    }
    this.ajC.Bx();
    this.ajD = true;
  }
  
  public h<FieldDescriptorType> By()
  {
    h localh = Bv();
    int i = 0;
    while (i < this.ajC.Cg())
    {
      localObject = this.ajC.fw(i);
      localh.a((a)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
      i += 1;
    }
    Object localObject = this.ajC.Ch().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localh.a((a)localEntry.getKey(), localEntry.getValue());
    }
    localh.ajE = this.ajE;
    return localh;
  }
  
  public Object a(FieldDescriptorType paramFieldDescriptorType)
  {
    Object localObject = this.ajC.get(paramFieldDescriptorType);
    paramFieldDescriptorType = (FieldDescriptorType)localObject;
    if ((localObject instanceof j)) {
      paramFieldDescriptorType = ((j)localObject).BX();
    }
    return paramFieldDescriptorType;
  }
  
  public void a(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    if (paramFieldDescriptorType.BB())
    {
      if (!(paramObject instanceof List)) {
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll((List)paramObject);
      paramObject = localArrayList.iterator();
      while (((Iterator)paramObject).hasNext())
      {
        Object localObject = ((Iterator)paramObject).next();
        a(paramFieldDescriptorType.Bz(), localObject);
      }
      paramObject = localArrayList;
    }
    for (;;)
    {
      if ((paramObject instanceof j)) {
        this.ajE = true;
      }
      this.ajC.a(paramFieldDescriptorType, paramObject);
      return;
      a(paramFieldDescriptorType.Bz(), paramObject);
    }
  }
  
  public void a(h<FieldDescriptorType> paramh)
  {
    int i = 0;
    while (i < paramh.ajC.Cg())
    {
      c(paramh.ajC.fw(i));
      i += 1;
    }
    paramh = paramh.ajC.Ch().iterator();
    while (paramh.hasNext()) {
      c((Map.Entry)paramh.next());
    }
  }
  
  public void b(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    if (!paramFieldDescriptorType.BB()) {
      throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }
    a(paramFieldDescriptorType.Bz(), paramObject);
    Object localObject = a(paramFieldDescriptorType);
    if (localObject == null)
    {
      localObject = new ArrayList();
      this.ajC.a(paramFieldDescriptorType, localObject);
    }
    for (paramFieldDescriptorType = (FieldDescriptorType)localObject;; paramFieldDescriptorType = (List)localObject)
    {
      paramFieldDescriptorType.add(paramObject);
      return;
    }
  }
  
  public int fI()
  {
    int j = 0;
    int i = 0;
    while (j < this.ajC.Cg())
    {
      localObject = this.ajC.fw(j);
      i += c((a)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
      j += 1;
    }
    Object localObject = this.ajC.Ch().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      i += c((a)localEntry.getKey(), localEntry.getValue());
    }
    return i;
  }
  
  public boolean isInitialized()
  {
    int i = 0;
    while (i < this.ajC.Cg())
    {
      if (!b(this.ajC.fw(i))) {
        return false;
      }
      i += 1;
    }
    Iterator localIterator = this.ajC.Ch().iterator();
    while (localIterator.hasNext()) {
      if (!b((Map.Entry)localIterator.next())) {
        return false;
      }
    }
    return true;
  }
  
  public Iterator<Map.Entry<FieldDescriptorType, Object>> iterator()
  {
    if (this.ajE) {
      return new j.b(this.ajC.entrySet().iterator());
    }
    return this.ajC.entrySet().iterator();
  }
  
  public static abstract interface a<T extends a<T>>
    extends Comparable<T>
  {
    public abstract WireFormat.JavaType BA();
    
    public abstract boolean BB();
    
    public abstract boolean BC();
    
    public abstract WireFormat.FieldType Bz();
    
    public abstract n.a a(n.a parama, n paramn);
    
    public abstract p a(p paramp1, p paramp2);
    
    public abstract int ga();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/protobuf/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */