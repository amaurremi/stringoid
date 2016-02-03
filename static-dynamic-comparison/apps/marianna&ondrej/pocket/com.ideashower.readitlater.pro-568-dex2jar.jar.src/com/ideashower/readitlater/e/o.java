package com.ideashower.readitlater.e;

import android.util.SparseArray;
import android.webkit.URLUtil;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.i.c;
import com.ideashower.readitlater.util.e;
import com.ideashower.readitlater.util.t;
import com.ideashower.readitlater.util.u;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class o
{
  private static final Pattern Q = Pattern.compile("(\\%(?:[0-9][a-z]|[a-z][0-9]))", 2);
  private static final Pattern R = Pattern.compile("\\s*?,\\s*?");
  private static final Pattern S = Pattern.compile("^www[0-9]*\\.");
  private static final Pattern T = Pattern.compile("^\\/index(\\.[a-z]{3,4})?$");
  private static final Pattern U = Pattern.compile("\\/index\\.(html?|php)$");
  protected boolean A = false;
  protected ArrayList B;
  protected String C;
  protected SparseArray D;
  protected int E = 0;
  protected SparseArray F;
  protected SparseArray G;
  protected ArrayList H;
  protected ArrayList I;
  protected AtomicInteger J = new AtomicInteger(0);
  protected com.pocket.m.a.a K;
  protected com.pocket.m.a.a L;
  protected ArrayList M;
  protected ArrayList N;
  protected int O;
  protected f P;
  private final Object V = new Object();
  private final Object W = new Object();
  private final Object X = new Object();
  private final Object Y = new Object();
  private q Z;
  protected int a;
  protected AtomicInteger b = new AtomicInteger(0);
  protected int c;
  protected String d;
  protected String e;
  protected String f;
  protected String g;
  protected String h;
  protected String i;
  protected String j;
  protected String k;
  protected final Object l = new Object();
  protected String m;
  protected String n;
  protected String o;
  protected final Object p = new Object();
  protected AtomicLong q = new AtomicLong(0L);
  protected AtomicBoolean r = new AtomicBoolean(false);
  protected AtomicInteger s = new AtomicInteger(0);
  protected AtomicInteger t = new AtomicInteger(0);
  protected AtomicInteger u = new AtomicInteger(0);
  protected String v;
  protected String w;
  protected AtomicBoolean x = new AtomicBoolean(false);
  protected int y = 0;
  protected int z = 0;
  
  public o(p paramp)
  {
    String str;
    if (!org.apache.a.c.k.c(paramp.h))
    {
      this.f = paramp.h;
      if (org.apache.a.c.k.c(paramp.i))
      {
        str = h(this.f);
        this.g = str;
      }
    }
    for (int i1 = 1;; i1 = 0)
    {
      label271:
      int i2;
      if (!org.apache.a.c.k.c(paramp.f))
      {
        this.d = paramp.f;
        if (org.apache.a.c.k.c(paramp.g))
        {
          str = h(this.d);
          this.e = str;
          i2 = 1;
          label279:
          this.c = paramp.d;
          if (paramp.c == 0) {
            break label381;
          }
          this.a = paramp.c;
        }
      }
      for (i1 = 1;; i1 = i3)
      {
        if (paramp.e != 0)
        {
          this.b.set(paramp.e);
          i1 = 1;
        }
        if ((i2 != 0) || (i1 != 0)) {
          break label395;
        }
        throw new IllegalArgumentException("Must have a url or itemId");
        str = paramp.i;
        break;
        str = paramp.g;
        break label271;
        this.d = this.f;
        this.e = this.g;
        i2 = i1;
        break label279;
        label381:
        this.a = paramp.e;
      }
      label395:
      if (!org.apache.a.c.k.c(paramp.k)) {}
      for (str = paramp.k;; str = paramp.j)
      {
        a(str, true);
        a(paramp.o);
        g(paramp.m);
        b(paramp.l);
        c(paramp.p);
        e(paramp.z);
        f(paramp.q);
        g(paramp.r);
        k(paramp.b);
        h(paramp.D);
        i(paramp.C);
        if (paramp.x.size() > 0) {
          a(paramp.x);
        }
        if (paramp.y.size() > 0) {
          b(paramp.y);
        }
        if (paramp.A != null) {
          c(paramp.A);
        }
        if (paramp.B != null) {
          b(paramp.B);
        }
        if ((paramp.G != null) && (paramp.G.size() > 0)) {
          a(new ArrayList(paramp.G));
        }
        c(paramp.w);
        g(paramp.F);
        f(paramp.E);
        c(paramp.H);
        c(paramp.I);
        a(paramp.J);
        if (paramp.K.c()) {
          this.Z = new q(paramp.K);
        }
        return;
      }
    }
  }
  
  public static String a(String paramString)
  {
    return org.apache.a.c.k.a(com.ideashower.readitlater.util.g.a(paramString), "www.", "");
  }
  
  public static String h(String paramString)
  {
    for (;;)
    {
      Object localObject3;
      try
      {
        URI localURI = new URI(paramString);
        Object localObject4 = localURI.getScheme().toLowerCase();
        Object localObject1 = com.ideashower.readitlater.util.g.a(paramString).toLowerCase();
        if (!((String)localObject4).equals("https")) {
          break label393;
        }
        localObject4 = "http";
        String str3 = S.matcher((CharSequence)localObject1).replaceAll("");
        localObject1 = localURI.getRawFragment();
        if ((localObject1 != null) && (!((String)localObject1).contains("/")))
        {
          if (((String)localObject1).indexOf("!") != 0) {
            break label409;
          }
          localObject3 = localObject1;
          localObject1 = l(localURI.getRawPath());
          String str2 = l(localURI.getRawQuery());
          localObject2 = localObject1;
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (str2 == null)
            {
              if (T.matcher((CharSequence)localObject1).matches()) {
                localObject2 = null;
              }
            }
            else
            {
              localObject1 = localObject2;
              if (localObject2 != null)
              {
                localObject2 = ((String)localObject2).replace("//", "/");
                localObject1 = localObject2;
                if (((String)localObject2).endsWith("/"))
                {
                  if (((String)localObject2).length() > 1) {
                    continue;
                  }
                  localObject1 = null;
                }
              }
              if (localObject1 == null) {
                break label396;
              }
              localObject2 = localObject1;
              if (((String)localObject1).length() == 0) {
                break label396;
              }
            }
          }
          else
          {
            localObject4 = new StringBuilder().append((String)localObject4).append("://").append(str3);
            if ((localURI.getPort() == 80) || (localURI.getPort() == -1)) {
              break label414;
            }
            localObject1 = ":" + localURI.getPort();
            localObject1 = ((StringBuilder)localObject4).append((String)localObject1);
            if (localObject2 == null) {
              break label421;
            }
            localObject2 = ((StringBuilder)localObject1).append((String)localObject2);
            if (str2 == null) {
              break label428;
            }
            localObject1 = "?" + str2;
            localObject2 = ((StringBuilder)localObject2).append((String)localObject1);
            if (localObject3 == null) {
              continue;
            }
            localObject1 = "#" + (String)localObject3;
            return (String)localObject1;
          }
          localObject2 = U.matcher((CharSequence)localObject1).replaceAll("");
          continue;
          localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
          continue;
          localObject1 = "";
          continue;
        }
        localObject3 = localThrowable;
      }
      catch (Throwable localThrowable)
      {
        return paramString;
      }
      continue;
      label393:
      continue;
      label396:
      Object localObject2 = localThrowable;
      if (localObject3 != null)
      {
        localObject2 = "/";
        continue;
        label409:
        localObject3 = null;
        continue;
        label414:
        String str1 = "";
        continue;
        label421:
        localObject2 = "";
        continue;
        label428:
        str1 = "";
      }
    }
  }
  
  public static String i(String paramString)
  {
    return paramString.replace("#!", "?_escaped_fragment_=");
  }
  
  private static String l(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    paramString = Q.matcher(paramString);
    StringBuffer localStringBuffer = new StringBuffer();
    while (paramString.find()) {
      paramString.appendReplacement(localStringBuffer, paramString.group().toUpperCase());
    }
    paramString.appendTail(localStringBuffer);
    return localStringBuffer.toString();
  }
  
  public static boolean l(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 2) || (paramInt == 4);
  }
  
  public static boolean m(int paramInt)
  {
    return paramInt > 0;
  }
  
  public f A()
  {
    return this.P;
  }
  
  public int B()
  {
    synchronized (this.X)
    {
      int i1 = this.E;
      return i1;
    }
  }
  
  public SparseArray C()
  {
    synchronized (this.X)
    {
      if (this.D == null)
      {
        localSparseArray = new SparseArray();
        return localSparseArray;
      }
      SparseArray localSparseArray = this.D;
      return localSparseArray;
    }
  }
  
  public boolean D()
  {
    for (;;)
    {
      synchronized (this.X)
      {
        if ((this.D != null) && (this.D.size() > 0))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public String E()
  {
    synchronized (this.V)
    {
      if (this.w == null) {
        this.w = "";
      }
      String str = this.w;
      return str;
    }
  }
  
  public String F()
  {
    synchronized (this.V)
    {
      if (this.v == null) {
        this.v = "";
      }
      String str = this.v;
      return str;
    }
  }
  
  public int G()
  {
    if (d(false)) {
      return 1;
    }
    if (L()) {
      return 2;
    }
    if (J()) {
      return 3;
    }
    return -1;
  }
  
  public int H()
  {
    return this.u.get();
  }
  
  public int I()
  {
    return this.s.get();
  }
  
  public boolean J()
  {
    return this.s.get() == 2;
  }
  
  public int K()
  {
    return this.t.get();
  }
  
  public boolean L()
  {
    return this.t.get() == 2;
  }
  
  public boolean M()
  {
    return this.b.get() != 0;
  }
  
  public boolean N()
  {
    return (!this.r.get()) && (M());
  }
  
  public int O()
  {
    synchronized (this.W)
    {
      int i1 = this.y;
      return i1;
    }
  }
  
  public int P()
  {
    synchronized (this.W)
    {
      int i1 = this.z;
      return i1;
    }
  }
  
  public boolean Q()
  {
    boolean bool2 = true;
    Object localObject1 = this.W;
    for (boolean bool1 = bool2;; bool1 = false) {
      try
      {
        if (this.y != 1)
        {
          if (this.y == 2) {
            bool1 = bool2;
          }
        }
        else {
          return bool1;
        }
      }
      finally {}
    }
  }
  
  public boolean R()
  {
    boolean bool2 = true;
    Object localObject1 = this.W;
    for (boolean bool1 = bool2;; bool1 = false) {
      try
      {
        if (this.z != 1)
        {
          if (this.z == 2) {
            bool1 = bool2;
          }
        }
        else {
          return bool1;
        }
      }
      finally {}
    }
  }
  
  public boolean S()
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    synchronized (this.W)
    {
      if (this.A) {
        return false;
      }
      if (!i.c()) {
        break label80;
      }
      if (N())
      {
        bool1 = Q();
        return bool1;
      }
    }
    if ((!R()) && (!Q()))
    {
      return bool1;
      label80:
      if ((i.d()) && (i.e()))
      {
        bool1 = bool2;
        if (R())
        {
          bool1 = bool2;
          if (Q()) {
            bool1 = true;
          }
        }
        return bool1;
      }
      if (i.d())
      {
        bool1 = Q();
        return bool1;
      }
      if (i.e())
      {
        bool1 = R();
        return bool1;
      }
      if (R()) {
        break label178;
      }
      bool1 = bool3;
      if (Q()) {
        break label178;
      }
    }
    for (;;)
    {
      return bool1;
      bool1 = true;
      break;
      label178:
      bool1 = true;
    }
  }
  
  public ArrayList T()
  {
    if (this.M == null) {
      this.M = new ArrayList();
    }
    return this.M;
  }
  
  public ArrayList U()
  {
    if (this.N == null) {
      this.N = new ArrayList();
    }
    return this.N;
  }
  
  public SparseArray V()
  {
    synchronized (this.Y)
    {
      if (this.G == null) {
        this.G = new SparseArray();
      }
      SparseArray localSparseArray = this.G;
      return localSparseArray;
    }
  }
  
  public SparseArray W()
  {
    synchronized (this.Y)
    {
      if (this.F == null) {
        this.F = new SparseArray();
      }
      SparseArray localSparseArray = this.F;
      return localSparseArray;
    }
  }
  
  public a X()
  {
    synchronized (this.Y)
    {
      if ((this.F == null) || (this.F.size() == 0)) {
        return null;
      }
      a locala = (a)this.F.get(1);
      return locala;
    }
  }
  
  public void Y()
  {
    a locala = X();
    if ((locala != null) && (this.K == null)) {
      this.K = com.pocket.m.a.a.a(locala.a());
    }
  }
  
  public String Z()
  {
    return "http://" + n() + "/favicon.ico";
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(long paramLong)
  {
    e.a(paramLong);
    this.q.set(paramLong);
  }
  
  public void a(SparseArray paramSparseArray)
  {
    Object localObject = this.X;
    if (paramSparseArray != null) {}
    for (;;)
    {
      try
      {
        v localv1;
        if (this.D == null)
        {
          this.D = new SparseArray(paramSparseArray.size());
          t.a(this.D, paramSparseArray);
          v localv2 = (v)paramSparseArray.get(1);
          localv1 = localv2;
          if (localv2 == null) {
            localv1 = (v)paramSparseArray.get(2);
          }
          if (localv1 == null) {
            this.E = 0;
          }
        }
        else
        {
          this.D.clear();
          continue;
        }
        this.E = localv1.e();
      }
      finally {}
      continue;
      if (this.D != null) {
        this.D.clear();
      }
      this.E = 0;
    }
  }
  
  public void a(a parama)
  {
    synchronized (this.Y)
    {
      if (this.F == null) {
        this.F = new SparseArray();
      }
      this.F.put(parama.b(), parama);
      return;
    }
  }
  
  public void a(b paramb)
  {
    synchronized (this.Y)
    {
      if (this.G == null) {
        this.G = new SparseArray();
      }
      this.G.put(paramb.b(), paramb);
      return;
    }
  }
  
  public void a(d paramd)
  {
    if (this.H == null) {
      this.H = new ArrayList();
    }
    this.H.add(paramd);
  }
  
  public void a(f paramf)
  {
    this.P = paramf;
  }
  
  public void a(v paramv)
  {
    synchronized (this.X)
    {
      if (this.D == null) {
        this.D = new SparseArray();
      }
      this.D.put(paramv.a(), paramv);
      this.E = paramv.e();
      return;
    }
  }
  
  public void a(v paramv, boolean paramBoolean)
  {
    synchronized (this.X)
    {
      if (this.D == null) {
        this.D = new SparseArray();
      }
      this.D.put(paramv.a(), paramv);
      if (paramBoolean) {
        this.E = paramv.e();
      }
      return;
    }
  }
  
  public void a(x paramx)
  {
    if (this.M == null) {
      this.M = new ArrayList();
    }
    this.M.add(paramx);
    if (paramx.g() == 1)
    {
      if (this.N == null) {
        this.N = new ArrayList();
      }
      this.N.add(paramx);
    }
  }
  
  public void a(y paramy)
  {
    if (this.I == null) {
      this.I = new ArrayList();
    }
    this.I.add(paramy);
  }
  
  /* Error */
  public void a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: getfield 114	com/ideashower/readitlater/e/o:p	Ljava/lang/Object;
    //   7: astore 5
    //   9: aload 5
    //   11: monitorenter
    //   12: aload 4
    //   14: astore_3
    //   15: aload_1
    //   16: ifnull +13 -> 29
    //   19: aload_1
    //   20: invokevirtual 394	java/lang/String:length	()I
    //   23: ifne +20 -> 43
    //   26: aload 4
    //   28: astore_3
    //   29: aload_0
    //   30: aload_3
    //   31: putfield 566	com/ideashower/readitlater/e/o:m	Ljava/lang/String;
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield 568	com/ideashower/readitlater/e/o:n	Ljava/lang/String;
    //   39: aload 5
    //   41: monitorexit
    //   42: return
    //   43: aload_1
    //   44: invokevirtual 571	java/lang/String:trim	()Ljava/lang/String;
    //   47: astore_3
    //   48: goto -19 -> 29
    //   51: astore_1
    //   52: aload 5
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	o
    //   0	57	1	paramString	String
    //   0	57	2	paramBoolean	boolean
    //   14	34	3	localObject1	Object
    //   1	26	4	localObject2	Object
    //   7	46	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   19	26	51	finally
    //   29	42	51	finally
    //   43	48	51	finally
    //   52	55	51	finally
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList == null)
    {
      this.M = null;
      this.N = null;
      return;
    }
    if (this.M == null) {
      this.M = new ArrayList();
    }
    for (;;)
    {
      this.M.addAll(paramArrayList);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        x localx = (x)paramArrayList.next();
        if (localx.g() == 1)
        {
          if (this.N == null) {
            this.N = new ArrayList();
          }
          this.N.add(localx);
        }
      }
      break;
      this.M.clear();
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (!x()) {}
    while (w().indexOf(paramString1) < 0) {
      return false;
    }
    ArrayList localArrayList = new ArrayList(w());
    c(null);
    localArrayList.set(localArrayList.indexOf(paramString1), paramString2);
    paramString1 = localArrayList.iterator();
    while (paramString1.hasNext()) {
      d((String)paramString1.next());
    }
    return true;
  }
  
  public void aa()
  {
    if (this.L == null) {
      this.L = com.pocket.m.a.a.a(Z());
    }
  }
  
  public com.pocket.m.a.a ab()
  {
    if (this.K == null) {
      Y();
    }
    return this.K;
  }
  
  public com.pocket.m.a.a ac()
  {
    if (this.L == null) {
      aa();
    }
    return this.L;
  }
  
  public com.pocket.m.a.d ad()
  {
    if (h()) {
      return com.pocket.m.a.d.a(f());
    }
    return com.pocket.m.a.d.a();
  }
  
  public boolean ae()
  {
    return this.x.get();
  }
  
  public ArrayList af()
  {
    if (this.H == null) {
      return new ArrayList();
    }
    return new ArrayList(this.H);
  }
  
  public ArrayList ag()
  {
    return this.I;
  }
  
  public q ah()
  {
    return this.Z;
  }
  
  public void ai()
  {
    this.Z = null;
  }
  
  public boolean aj()
  {
    return this.J.get() == 0;
  }
  
  public int ak()
  {
    synchronized (this.Y)
    {
      if (this.G == null) {
        return 0;
      }
      int i1 = this.G.size();
      return i1;
    }
  }
  
  public int al()
  {
    return this.J.get();
  }
  
  public int am()
  {
    if (this.F != null) {
      return this.F.size();
    }
    return 0;
  }
  
  public int an()
  {
    if (this.D != null) {
      return this.D.size();
    }
    return 0;
  }
  
  public int ao()
  {
    if (this.H != null) {
      return this.H.size();
    }
    return 0;
  }
  
  public int ap()
  {
    if (this.M != null) {
      return this.M.size();
    }
    return 0;
  }
  
  public boolean aq()
  {
    if (this.M == null) {
      return false;
    }
    Iterator localIterator = this.M.iterator();
    while (localIterator.hasNext()) {
      if (((x)localIterator.next()).g() == 0) {
        return true;
      }
    }
    return false;
  }
  
  public void b(SparseArray paramSparseArray)
  {
    Object localObject = this.Y;
    if (paramSparseArray != null) {}
    for (;;)
    {
      try
      {
        if (this.G == null)
        {
          this.G = new SparseArray();
          t.a(this.G, paramSparseArray);
          return;
        }
        this.G.clear();
        continue;
        if (this.G == null) {
          continue;
        }
      }
      finally {}
      this.G.clear();
    }
  }
  
  public void b(String paramString)
  {
    this.o = paramString;
  }
  
  public void b(ArrayList paramArrayList)
  {
    this.H = new ArrayList(paramArrayList);
  }
  
  public boolean b(int paramInt)
  {
    boolean bool = false;
    synchronized (this.p)
    {
      if (this.o == null) {}
      while (this.o.length() < paramInt) {
        return bool;
      }
      bool = true;
    }
  }
  
  public int c()
  {
    return this.a;
  }
  
  public void c(int paramInt)
  {
    this.O = paramInt;
  }
  
  public void c(SparseArray paramSparseArray)
  {
    Object localObject = this.Y;
    if (paramSparseArray != null) {}
    for (;;)
    {
      try
      {
        if (this.F == null)
        {
          this.F = new SparseArray(paramSparseArray.size());
          t.a(this.F, paramSparseArray);
          return;
        }
        this.F.clear();
        continue;
        if (this.F == null) {
          continue;
        }
      }
      finally {}
      this.F.clear();
    }
  }
  
  public void c(String paramString)
  {
    this.C = "";
    if (this.B != null) {
      this.B.clear();
    }
    if ((paramString != null) && (paramString.length() > 0))
    {
      Object localObject = paramString.toLowerCase();
      paramString = w();
      localObject = R.split((CharSequence)localObject);
      StringBuilder localStringBuilder = u.a();
      int i2 = localObject.length;
      int i1 = 0;
      if (i1 < i2)
      {
        String str = localObject[i1].trim();
        if ((str.length() == 0) || (paramString.contains(str))) {}
        for (;;)
        {
          i1 += 1;
          break;
          paramString.add(str);
          if (localStringBuilder.length() > 0) {
            localStringBuilder.append(", ");
          }
          localStringBuilder.append(str);
        }
      }
      this.C = localStringBuilder.toString();
      u.a(localStringBuilder);
    }
  }
  
  public void c(ArrayList paramArrayList)
  {
    this.I = paramArrayList;
  }
  
  public void c(boolean paramBoolean)
  {
    this.r.set(paramBoolean);
  }
  
  public int d()
  {
    return this.b.get();
  }
  
  public v d(int paramInt)
  {
    for (;;)
    {
      synchronized (this.X)
      {
        if (this.D != null)
        {
          v localv = (v)this.D.get(paramInt);
          return localv;
        }
      }
      Object localObject2 = null;
    }
  }
  
  public void d(String paramString)
  {
    w();
    String str1 = paramString.trim();
    if ((str1.length() == 0) || (this.B.contains(str1))) {
      return;
    }
    String str2 = this.C;
    if (this.C.length() > 0) {}
    for (paramString = ", " + str1;; paramString = str1)
    {
      this.C = str2.concat(paramString);
      this.B.add(str1);
      return;
    }
  }
  
  public boolean d(boolean paramBoolean)
  {
    return (this.r.get()) || ((paramBoolean) && (!M()));
  }
  
  public int e()
  {
    return this.c;
  }
  
  public void e(int paramInt)
  {
    this.u.set(paramInt);
  }
  
  public boolean e(String paramString)
  {
    if (!x()) {}
    int i1;
    do
    {
      return false;
      i1 = w().indexOf(paramString);
    } while (i1 < 0);
    paramString = new ArrayList(w());
    c(null);
    paramString.remove(i1);
    paramString = paramString.iterator();
    while (paramString.hasNext()) {
      d((String)paramString.next());
    }
    return true;
  }
  
  public boolean e(boolean paramBoolean)
  {
    a locala = X();
    return (locala != null) && ((!paramBoolean) || ((locala.e() > 0) && (locala.f() > 0)));
  }
  
  public int f()
  {
    if (this.c == 0) {
      throw new NullPointerException("Unique Id has not been set.");
    }
    return this.c;
  }
  
  public void f(int paramInt)
  {
    this.s.set(paramInt);
  }
  
  public void f(String paramString)
  {
    synchronized (this.V)
    {
      this.v = paramString;
      return;
    }
  }
  
  public void f(boolean paramBoolean)
  {
    synchronized (this.W)
    {
      if (this.A == paramBoolean) {
        return;
      }
      this.A = paramBoolean;
      c.a(this);
      return;
    }
  }
  
  public void g(int paramInt)
  {
    this.t.set(paramInt);
  }
  
  public void g(String paramString)
  {
    synchronized (this.V)
    {
      this.w = paramString;
      return;
    }
  }
  
  public void g(boolean paramBoolean)
  {
    this.x.set(paramBoolean);
  }
  
  public boolean g()
  {
    String str = k();
    if ((this.c == 0) && (str == null)) {}
    while (!URLUtil.isValidUrl(str)) {
      return false;
    }
    return true;
  }
  
  public void h(int paramInt)
  {
    synchronized (this.W)
    {
      this.y = paramInt;
      return;
    }
  }
  
  public boolean h()
  {
    return m(this.c);
  }
  
  public boolean h(boolean paramBoolean)
  {
    boolean bool = false;
    if (paramBoolean)
    {
      if (this.N != null) {
        return this.N.size() > 0;
      }
      return false;
    }
    paramBoolean = bool;
    if (this.M != null)
    {
      paramBoolean = bool;
      if (this.M.size() > 0) {
        paramBoolean = true;
      }
    }
    return paramBoolean;
  }
  
  public String i()
  {
    return this.d;
  }
  
  public String i(boolean paramBoolean)
  {
    if (d(false))
    {
      localStringBuilder = new StringBuilder();
      if (paramBoolean) {}
      for (str = "an ";; str = "") {
        return str + "article";
      }
    }
    if (J())
    {
      localStringBuilder = new StringBuilder();
      if (paramBoolean) {}
      for (str = "an ";; str = "") {
        return str + "image";
      }
    }
    if (L())
    {
      localStringBuilder = new StringBuilder();
      if (paramBoolean) {}
      for (str = "a ";; str = "") {
        return str + "video";
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean) {}
    for (String str = "an ";; str = "") {
      return str + "item";
    }
  }
  
  public void i(int paramInt)
  {
    synchronized (this.W)
    {
      this.z = paramInt;
      return;
    }
  }
  
  public x j(int paramInt)
  {
    if (this.M == null) {
      return null;
    }
    Iterator localIterator = this.M.iterator();
    while (localIterator.hasNext())
    {
      x localx = (x)localIterator.next();
      if (localx.b() == paramInt) {
        return localx;
      }
    }
    return null;
  }
  
  public String j()
  {
    return this.e;
  }
  
  public void j(String paramString)
  {
    this.d = paramString;
  }
  
  public String k()
  {
    if (l() != null) {
      return l();
    }
    return i();
  }
  
  public void k(int paramInt)
  {
    this.J.set(paramInt);
  }
  
  public void k(String paramString)
  {
    this.e = paramString;
  }
  
  public String l()
  {
    synchronized (this.l)
    {
      String str = this.f;
      return str;
    }
  }
  
  public String m()
  {
    synchronized (this.l)
    {
      if ((this.g == null) && (l() != null)) {
        this.g = h(l());
      }
      String str = this.g;
      return str;
    }
  }
  
  public String n()
  {
    synchronized (this.l)
    {
      if (this.h == null) {
        this.h = com.ideashower.readitlater.util.g.a(k());
      }
      String str = this.h;
      return str;
    }
  }
  
  public String o()
  {
    synchronized (this.l)
    {
      if (this.i == null) {
        this.i = org.apache.a.c.k.a(n(), "www.", "");
      }
      String str = this.i;
      return str;
    }
  }
  
  public String p()
  {
    synchronized (this.l)
    {
      if (this.k == null) {
        this.k = n().toLowerCase();
      }
      String str = this.k;
      return str;
    }
  }
  
  public String q()
  {
    synchronized (this.p)
    {
      String str = this.m;
      return str;
    }
  }
  
  public String r()
  {
    synchronized (this.p)
    {
      String str = this.o;
      return str;
    }
  }
  
  public boolean s()
  {
    return b(1);
  }
  
  public String t()
  {
    synchronized (this.p)
    {
      if (this.m == null)
      {
        str = k();
        return str;
      }
      String str = this.m;
    }
  }
  
  public String toString()
  {
    return "Item [mItemId=" + this.a + ", mResolvedId=" + this.b + ", mUniqueId=" + this.c + ", mGivenUrl=" + this.d + ", mGivenUrlNormal=" + this.e + ", mResolvedUrl=" + this.f + ", mResolvedUrlNormal=" + this.g + ", mResolvedHost=" + this.h + ", mCleanHost=" + this.i + ", mResolvedUrlLowerCase=" + this.j + ", mResolvedHostLowerCase=" + this.k + ", mUrlLock=" + this.l + ", mTitle=" + this.m + ", mLowerCaseTitle=" + this.n + ", mExcerpt=" + this.o + ", mTitleLock=" + this.p + ", mTimeAdded=" + this.q + ", mIsArticle=" + this.r + ", mHasImage=" + this.s + ", mHasVideo=" + this.t + ", mWordCount=" + this.u + ", mEncoding=" + this.v + ", mMimeType=" + this.w + ", mContentTypeLock=" + this.V + ", mFavorite=" + this.x + ", mOfflineWeb=" + this.y + ", mOfflineText=" + this.z + ", mSavingOffline=" + this.A + ", mOfflineLock=" + this.W + ", mTagArray=" + this.B + ", mTagString=" + this.C + ", mPositionsLock=" + this.X + ", mPositions=" + this.D + ", mPercent=" + this.E + ", mImages=" + this.F + ", mVideos=" + this.G + ", mMediaLock=" + this.Y + ", mAuthors=" + this.H + ", mTweetAttributionList=" + this.I + ", mStatus=" + this.J + ", mThumbAsset=" + this.K + ", mFaviconAsset=" + this.L + ", mAllShares=" + this.M + ", mApprovedShares=" + this.N + "]";
  }
  
  public long u()
  {
    return this.q.get();
  }
  
  public int v()
  {
    if (this.B == null) {
      return 0;
    }
    return this.B.size();
  }
  
  public ArrayList w()
  {
    if (this.B == null) {
      this.B = new ArrayList();
    }
    return this.B;
  }
  
  public boolean x()
  {
    return this.C.length() > 0;
  }
  
  public int y()
  {
    return this.O;
  }
  
  public g z()
  {
    if (this.O != 0) {
      return k.a().a(this.O);
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/e/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */