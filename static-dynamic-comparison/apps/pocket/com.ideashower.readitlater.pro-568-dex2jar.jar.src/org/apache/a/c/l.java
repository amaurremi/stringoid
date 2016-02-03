package org.apache.a.c;

import java.io.PrintStream;

public class l
{
  public static final String A;
  public static final String B;
  public static final String C;
  public static final String D;
  public static final String E;
  public static final String F;
  public static final String G;
  public static final String H;
  public static final String I;
  public static final String J;
  public static final String K;
  public static final String L;
  public static final String M;
  public static final String N;
  public static final String O;
  public static final String P;
  public static final boolean Q;
  public static final boolean R;
  public static final boolean S;
  public static final boolean T;
  public static final boolean U;
  public static final boolean V;
  public static final boolean W;
  public static final boolean X;
  public static final boolean Y;
  public static final boolean Z;
  public static final String a;
  public static final boolean aa;
  public static final boolean ab;
  public static final boolean ac;
  public static final boolean ad;
  public static final boolean ae;
  public static final boolean af;
  public static final boolean ag;
  public static final boolean ah;
  public static final boolean ai;
  public static final boolean aj;
  public static final boolean ak;
  public static final boolean al;
  public static final boolean am;
  public static final boolean an;
  public static final boolean ao;
  public static final boolean ap;
  public static final boolean aq;
  public static final boolean ar;
  public static final boolean as;
  public static final boolean at;
  public static final boolean au;
  private static final d av;
  public static final String b;
  public static final String c;
  public static final String d;
  public static final String e;
  public static final String f;
  public static final String g;
  public static final String h;
  public static final String i;
  public static final String j;
  public static final String k;
  public static final String l;
  public static final String m;
  public static final String n;
  public static final String o;
  public static final String p;
  public static final String q;
  public static final String r;
  public static final String s;
  public static final String t;
  public static final String u;
  public static final String v;
  public static final String w;
  public static final String x;
  public static final String y;
  public static final String z;
  
  static
  {
    boolean bool2 = false;
    a = c("awt.toolkit");
    b = c("file.encoding");
    c = c("file.separator");
    d = c("java.awt.fonts");
    e = c("java.awt.graphicsenv");
    f = c("java.awt.headless");
    g = c("java.awt.printerjob");
    h = c("java.class.path");
    i = c("java.class.version");
    j = c("java.compiler");
    k = c("java.endorsed.dirs");
    l = c("java.ext.dirs");
    m = c("java.home");
    n = c("java.io.tmpdir");
    o = c("java.library.path");
    p = c("java.runtime.name");
    q = c("java.runtime.version");
    r = c("java.specification.name");
    s = c("java.specification.vendor");
    t = c("java.specification.version");
    av = d.a(t);
    u = c("java.util.prefs.PreferencesFactory");
    v = c("java.vendor");
    w = c("java.vendor.url");
    x = c("java.version");
    y = c("java.vm.info");
    z = c("java.vm.name");
    A = c("java.vm.specification.name");
    B = c("java.vm.specification.vendor");
    C = c("java.vm.specification.version");
    D = c("java.vm.vendor");
    E = c("java.vm.version");
    F = c("line.separator");
    G = c("os.arch");
    H = c("os.name");
    I = c("os.version");
    J = c("path.separator");
    String str;
    if (c("user.country") == null)
    {
      str = c("user.region");
      K = str;
      L = c("user.dir");
      M = c("user.home");
      N = c("user.language");
      O = c("user.name");
      P = c("user.timezone");
      Q = a("1.1");
      R = a("1.2");
      S = a("1.3");
      T = a("1.4");
      U = a("1.5");
      V = a("1.6");
      W = a("1.7");
      X = b("AIX");
      Y = b("HP-UX");
      Z = b("Irix");
      if ((!b("Linux")) && (!b("LINUX"))) {
        break label749;
      }
    }
    label749:
    for (boolean bool1 = true;; bool1 = false)
    {
      aa = bool1;
      ab = b("Mac");
      ac = b("Mac OS X");
      ad = b("FreeBSD");
      ae = b("OpenBSD");
      af = b("NetBSD");
      ag = b("OS/2");
      ah = b("Solaris");
      ai = b("SunOS");
      if ((!X) && (!Y) && (!Z) && (!aa) && (!ac) && (!ah) && (!ai) && (!ad) && (!ae))
      {
        bool1 = bool2;
        if (!af) {}
      }
      else
      {
        bool1 = true;
      }
      aj = bool1;
      ak = b("Windows");
      al = c("Windows", "5.0");
      am = c("Windows", "5.2");
      an = c("Windows Server 2008", "6.1");
      ao = c("Windows 9", "4.0");
      ap = c("Windows 9", "4.1");
      aq = c("Windows", "4.9");
      ar = b("Windows NT");
      as = c("Windows", "5.1");
      at = c("Windows", "6.0");
      au = c("Windows", "6.1");
      return;
      str = c("user.country");
      break;
    }
  }
  
  private static boolean a(String paramString)
  {
    return a(t, paramString);
  }
  
  static boolean a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return false;
    }
    return paramString1.startsWith(paramString2);
  }
  
  static boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    while ((!paramString1.startsWith(paramString3)) || (!paramString2.startsWith(paramString4))) {
      return false;
    }
    return true;
  }
  
  private static boolean b(String paramString)
  {
    return b(H, paramString);
  }
  
  static boolean b(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return false;
    }
    return paramString1.startsWith(paramString2);
  }
  
  private static String c(String paramString)
  {
    try
    {
      String str = System.getProperty(paramString);
      return str;
    }
    catch (SecurityException localSecurityException)
    {
      System.err.println("Caught a SecurityException reading the system property '" + paramString + "'; the SystemUtils property value will default to null.");
    }
    return null;
  }
  
  private static boolean c(String paramString1, String paramString2)
  {
    return a(H, I, paramString1, paramString2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/a/c/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */