package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.a.b.a;
import com.google.android.gms.plus.a.b.a.a;
import com.google.android.gms.plus.a.b.a.b;
import com.google.android.gms.plus.a.b.a.b.a;
import com.google.android.gms.plus.a.b.a.b.b;
import com.google.android.gms.plus.a.b.a.c;
import com.google.android.gms.plus.a.b.a.d;
import com.google.android.gms.plus.a.b.a.e;
import com.google.android.gms.plus.a.b.a.f;
import com.google.android.gms.plus.a.b.a.g;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class ir
  extends fb
  implements SafeParcelable, a
{
  private static final HashMap<String, fb.a<?, ?>> Qx;
  public static final fm Rx = new fm();
  private String Fv;
  private String Gi;
  private final Set<Integer> Qy;
  private String RA;
  private String RB;
  private int RC;
  private b RD;
  private String RE;
  private c RF;
  private boolean RG;
  private String RH;
  private d RI;
  private String RJ;
  private int RK;
  private List<f> RL;
  private List<g> RM;
  private int RN;
  private int RO;
  private String RP;
  private List<h> RQ;
  private boolean RR;
  private String Ry;
  private a Rz;
  private final int qh;
  private String vc;
  private int xg;
  
  static
  {
    Qx = new HashMap();
    Qx.put("aboutMe", fb.a.h("aboutMe", 2));
    Qx.put("ageRange", fb.a.a("ageRange", 3, a.class));
    Qx.put("birthday", fb.a.h("birthday", 4));
    Qx.put("braggingRights", fb.a.h("braggingRights", 5));
    Qx.put("circledByCount", fb.a.e("circledByCount", 6));
    Qx.put("cover", fb.a.a("cover", 7, b.class));
    Qx.put("currentLocation", fb.a.h("currentLocation", 8));
    Qx.put("displayName", fb.a.h("displayName", 9));
    Qx.put("gender", fb.a.a("gender", 12, new ey().d("male", 0).d("female", 1).d("other", 2), false));
    Qx.put("id", fb.a.h("id", 14));
    Qx.put("image", fb.a.a("image", 15, c.class));
    Qx.put("isPlusUser", fb.a.g("isPlusUser", 16));
    Qx.put("language", fb.a.h("language", 18));
    Qx.put("name", fb.a.a("name", 19, d.class));
    Qx.put("nickname", fb.a.h("nickname", 20));
    Qx.put("objectType", fb.a.a("objectType", 21, new ey().d("person", 0).d("page", 1), false));
    Qx.put("organizations", fb.a.b("organizations", 22, f.class));
    Qx.put("placesLived", fb.a.b("placesLived", 23, g.class));
    Qx.put("plusOneCount", fb.a.e("plusOneCount", 24));
    Qx.put("relationshipStatus", fb.a.a("relationshipStatus", 25, new ey().d("single", 0).d("in_a_relationship", 1).d("engaged", 2).d("married", 3).d("its_complicated", 4).d("open_relationship", 5).d("widowed", 6).d("in_domestic_partnership", 7).d("in_civil_union", 8), false));
    Qx.put("tagline", fb.a.h("tagline", 26));
    Qx.put("url", fb.a.h("url", 27));
    Qx.put("urls", fb.a.b("urls", 28, h.class));
    Qx.put("verified", fb.a.g("verified", 29));
  }
  
  public ir()
  {
    this.qh = 2;
    this.Qy = new HashSet();
  }
  
  ir(Set<Integer> paramSet, int paramInt1, String paramString1, a parama, String paramString2, String paramString3, int paramInt2, b paramb, String paramString4, String paramString5, int paramInt3, String paramString6, c paramc, boolean paramBoolean1, String paramString7, d paramd, String paramString8, int paramInt4, List<f> paramList, List<g> paramList1, int paramInt5, int paramInt6, String paramString9, String paramString10, List<h> paramList2, boolean paramBoolean2)
  {
    this.Qy = paramSet;
    this.qh = paramInt1;
    this.Ry = paramString1;
    this.Rz = parama;
    this.RA = paramString2;
    this.RB = paramString3;
    this.RC = paramInt2;
    this.RD = paramb;
    this.RE = paramString4;
    this.vc = paramString5;
    this.xg = paramInt3;
    this.Gi = paramString6;
    this.RF = paramc;
    this.RG = paramBoolean1;
    this.RH = paramString7;
    this.RI = paramd;
    this.RJ = paramString8;
    this.RK = paramInt4;
    this.RL = paramList;
    this.RM = paramList1;
    this.RN = paramInt5;
    this.RO = paramInt6;
    this.RP = paramString9;
    this.Fv = paramString10;
    this.RQ = paramList2;
    this.RR = paramBoolean2;
  }
  
  protected boolean a(fb.a parama)
  {
    return this.Qy.contains(Integer.valueOf(parama.qK()));
  }
  
  protected Object aP(String paramString)
  {
    return null;
  }
  
  protected boolean aQ(String paramString)
  {
    return false;
  }
  
  protected Object b(fb.a parama)
  {
    switch (parama.qK())
    {
    case 10: 
    case 11: 
    case 13: 
    case 17: 
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.qK());
    case 2: 
      return this.Ry;
    case 3: 
      return this.Rz;
    case 4: 
      return this.RA;
    case 5: 
      return this.RB;
    case 6: 
      return Integer.valueOf(this.RC);
    case 7: 
      return this.RD;
    case 8: 
      return this.RE;
    case 9: 
      return this.vc;
    case 12: 
      return Integer.valueOf(this.xg);
    case 14: 
      return this.Gi;
    case 15: 
      return this.RF;
    case 16: 
      return Boolean.valueOf(this.RG);
    case 18: 
      return this.RH;
    case 19: 
      return this.RI;
    case 20: 
      return this.RJ;
    case 21: 
      return Integer.valueOf(this.RK);
    case 22: 
      return this.RL;
    case 23: 
      return this.RM;
    case 24: 
      return Integer.valueOf(this.RN);
    case 25: 
      return Integer.valueOf(this.RO);
    case 26: 
      return this.RP;
    case 27: 
      return this.Fv;
    case 28: 
      return this.RQ;
    }
    return Boolean.valueOf(this.RR);
  }
  
  public int describeContents()
  {
    fm localfm = Rx;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ir)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (ir)paramObject;
    Iterator localIterator = Qx.values().iterator();
    while (localIterator.hasNext())
    {
      fb.a locala = (fb.a)localIterator.next();
      if (a(locala))
      {
        if (((ir)paramObject).a(locala))
        {
          if (!b(locala).equals(((ir)paramObject).b(locala))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((ir)paramObject).a(locala)) {
        return false;
      }
    }
    return true;
  }
  
  public String getDisplayName()
  {
    return this.vc;
  }
  
  public String getId()
  {
    return this.Gi;
  }
  
  public String getLanguage()
  {
    return this.RH;
  }
  
  public String getUrl()
  {
    return this.Fv;
  }
  
  public int hashCode()
  {
    Iterator localIterator = Qx.values().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      fb.a locala = (fb.a)localIterator.next();
      if (!a(locala)) {
        break label68;
      }
      int j = locala.qK();
      i = b(locala).hashCode() + (i + j);
    }
    label68:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  int lX()
  {
    return this.qh;
  }
  
  public int oR()
  {
    return this.xg;
  }
  
  public HashMap<String, fb.a<?, ?>> qE()
  {
    return Qx;
  }
  
  Set<Integer> rI()
  {
    return this.Qy;
  }
  
  public String sF()
  {
    return this.Ry;
  }
  
  a sG()
  {
    return this.Rz;
  }
  
  public String sH()
  {
    return this.RA;
  }
  
  public String sI()
  {
    return this.RB;
  }
  
  public int sJ()
  {
    return this.RC;
  }
  
  b sK()
  {
    return this.RD;
  }
  
  public String sL()
  {
    return this.RE;
  }
  
  c sM()
  {
    return this.RF;
  }
  
  public boolean sN()
  {
    return this.RG;
  }
  
  d sO()
  {
    return this.RI;
  }
  
  public String sP()
  {
    return this.RJ;
  }
  
  public int sQ()
  {
    return this.RK;
  }
  
  List<f> sR()
  {
    return this.RL;
  }
  
  List<g> sS()
  {
    return this.RM;
  }
  
  public int sT()
  {
    return this.RN;
  }
  
  public int sU()
  {
    return this.RO;
  }
  
  public String sV()
  {
    return this.RP;
  }
  
  List<h> sW()
  {
    return this.RQ;
  }
  
  public boolean sX()
  {
    return this.RR;
  }
  
  public ir sY()
  {
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    fm localfm = Rx;
    fm.a(this, paramParcel, paramInt);
  }
  
  public static final class a
    extends fb
    implements SafeParcelable, a.a
  {
    private static final HashMap<String, fb.a<?, ?>> Qx;
    public static final fn RS = new fn();
    private final Set<Integer> Qy;
    private int RT;
    private int RU;
    private final int qh;
    
    static
    {
      Qx = new HashMap();
      Qx.put("max", fb.a.e("max", 2));
      Qx.put("min", fb.a.e("min", 3));
    }
    
    public a()
    {
      this.qh = 1;
      this.Qy = new HashSet();
    }
    
    a(Set<Integer> paramSet, int paramInt1, int paramInt2, int paramInt3)
    {
      this.Qy = paramSet;
      this.qh = paramInt1;
      this.RT = paramInt2;
      this.RU = paramInt3;
    }
    
    protected boolean a(fb.a parama)
    {
      return this.Qy.contains(Integer.valueOf(parama.qK()));
    }
    
    protected Object aP(String paramString)
    {
      return null;
    }
    
    protected boolean aQ(String paramString)
    {
      return false;
    }
    
    protected Object b(fb.a parama)
    {
      switch (parama.qK())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.qK());
      case 2: 
        return Integer.valueOf(this.RT);
      }
      return Integer.valueOf(this.RU);
    }
    
    public int describeContents()
    {
      fn localfn = RS;
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof a)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      paramObject = (a)paramObject;
      Iterator localIterator = Qx.values().iterator();
      while (localIterator.hasNext())
      {
        fb.a locala = (fb.a)localIterator.next();
        if (a(locala))
        {
          if (((a)paramObject).a(locala))
          {
            if (!b(locala).equals(((a)paramObject).b(locala))) {
              return false;
            }
          }
          else {
            return false;
          }
        }
        else if (((a)paramObject).a(locala)) {
          return false;
        }
      }
      return true;
    }
    
    public int getMax()
    {
      return this.RT;
    }
    
    public int hashCode()
    {
      Iterator localIterator = Qx.values().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        fb.a locala = (fb.a)localIterator.next();
        if (!a(locala)) {
          break label68;
        }
        int j = locala.qK();
        i = b(locala).hashCode() + (i + j);
      }
      label68:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    int lX()
    {
      return this.qh;
    }
    
    public HashMap<String, fb.a<?, ?>> qE()
    {
      return Qx;
    }
    
    Set<Integer> rI()
    {
      return this.Qy;
    }
    
    public int sZ()
    {
      return this.RU;
    }
    
    public a ta()
    {
      return this;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      fn localfn = RS;
      fn.a(this, paramParcel, paramInt);
    }
  }
  
  public static final class b
    extends fb
    implements SafeParcelable, a.b
  {
    private static final HashMap<String, fb.a<?, ?>> Qx;
    public static final fo RV = new fo();
    private final Set<Integer> Qy;
    private a RW;
    private b RX;
    private int RY;
    private final int qh;
    
    static
    {
      Qx = new HashMap();
      Qx.put("coverInfo", fb.a.a("coverInfo", 2, a.class));
      Qx.put("coverPhoto", fb.a.a("coverPhoto", 3, b.class));
      Qx.put("layout", fb.a.a("layout", 4, new ey().d("banner", 0), false));
    }
    
    public b()
    {
      this.qh = 1;
      this.Qy = new HashSet();
    }
    
    b(Set<Integer> paramSet, int paramInt1, a parama, b paramb, int paramInt2)
    {
      this.Qy = paramSet;
      this.qh = paramInt1;
      this.RW = parama;
      this.RX = paramb;
      this.RY = paramInt2;
    }
    
    protected boolean a(fb.a parama)
    {
      return this.Qy.contains(Integer.valueOf(parama.qK()));
    }
    
    protected Object aP(String paramString)
    {
      return null;
    }
    
    protected boolean aQ(String paramString)
    {
      return false;
    }
    
    protected Object b(fb.a parama)
    {
      switch (parama.qK())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.qK());
      case 2: 
        return this.RW;
      case 3: 
        return this.RX;
      }
      return Integer.valueOf(this.RY);
    }
    
    public int describeContents()
    {
      fo localfo = RV;
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof b)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      paramObject = (b)paramObject;
      Iterator localIterator = Qx.values().iterator();
      while (localIterator.hasNext())
      {
        fb.a locala = (fb.a)localIterator.next();
        if (a(locala))
        {
          if (((b)paramObject).a(locala))
          {
            if (!b(locala).equals(((b)paramObject).b(locala))) {
              return false;
            }
          }
          else {
            return false;
          }
        }
        else if (((b)paramObject).a(locala)) {
          return false;
        }
      }
      return true;
    }
    
    public int hashCode()
    {
      Iterator localIterator = Qx.values().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        fb.a locala = (fb.a)localIterator.next();
        if (!a(locala)) {
          break label68;
        }
        int j = locala.qK();
        i = b(locala).hashCode() + (i + j);
      }
      label68:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    int lX()
    {
      return this.qh;
    }
    
    public HashMap<String, fb.a<?, ?>> qE()
    {
      return Qx;
    }
    
    Set<Integer> rI()
    {
      return this.Qy;
    }
    
    a tb()
    {
      return this.RW;
    }
    
    b tc()
    {
      return this.RX;
    }
    
    public int td()
    {
      return this.RY;
    }
    
    public b te()
    {
      return this;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      fo localfo = RV;
      fo.a(this, paramParcel, paramInt);
    }
    
    public static final class a
      extends fb
      implements SafeParcelable, a.b.a
    {
      private static final HashMap<String, fb.a<?, ?>> Qx;
      public static final fp RZ = new fp();
      private final Set<Integer> Qy;
      private int Sa;
      private int Sb;
      private final int qh;
      
      static
      {
        Qx = new HashMap();
        Qx.put("leftImageOffset", fb.a.e("leftImageOffset", 2));
        Qx.put("topImageOffset", fb.a.e("topImageOffset", 3));
      }
      
      public a()
      {
        this.qh = 1;
        this.Qy = new HashSet();
      }
      
      a(Set<Integer> paramSet, int paramInt1, int paramInt2, int paramInt3)
      {
        this.Qy = paramSet;
        this.qh = paramInt1;
        this.Sa = paramInt2;
        this.Sb = paramInt3;
      }
      
      protected boolean a(fb.a parama)
      {
        return this.Qy.contains(Integer.valueOf(parama.qK()));
      }
      
      protected Object aP(String paramString)
      {
        return null;
      }
      
      protected boolean aQ(String paramString)
      {
        return false;
      }
      
      protected Object b(fb.a parama)
      {
        switch (parama.qK())
        {
        default: 
          throw new IllegalStateException("Unknown safe parcelable id=" + parama.qK());
        case 2: 
          return Integer.valueOf(this.Sa);
        }
        return Integer.valueOf(this.Sb);
      }
      
      public int describeContents()
      {
        fp localfp = RZ;
        return 0;
      }
      
      public boolean equals(Object paramObject)
      {
        if (!(paramObject instanceof a)) {
          return false;
        }
        if (this == paramObject) {
          return true;
        }
        paramObject = (a)paramObject;
        Iterator localIterator = Qx.values().iterator();
        while (localIterator.hasNext())
        {
          fb.a locala = (fb.a)localIterator.next();
          if (a(locala))
          {
            if (((a)paramObject).a(locala))
            {
              if (!b(locala).equals(((a)paramObject).b(locala))) {
                return false;
              }
            }
            else {
              return false;
            }
          }
          else if (((a)paramObject).a(locala)) {
            return false;
          }
        }
        return true;
      }
      
      public int hashCode()
      {
        Iterator localIterator = Qx.values().iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          fb.a locala = (fb.a)localIterator.next();
          if (!a(locala)) {
            break label68;
          }
          int j = locala.qK();
          i = b(locala).hashCode() + (i + j);
        }
        label68:
        for (;;)
        {
          break;
          return i;
        }
      }
      
      int lX()
      {
        return this.qh;
      }
      
      public HashMap<String, fb.a<?, ?>> qE()
      {
        return Qx;
      }
      
      Set<Integer> rI()
      {
        return this.Qy;
      }
      
      public int tf()
      {
        return this.Sa;
      }
      
      public int tg()
      {
        return this.Sb;
      }
      
      public a th()
      {
        return this;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        fp localfp = RZ;
        fp.a(this, paramParcel, paramInt);
      }
    }
    
    public static final class b
      extends fb
      implements SafeParcelable, a.b.b
    {
      private static final HashMap<String, fb.a<?, ?>> Qx;
      public static final fq Sc = new fq();
      private String Fv;
      private final Set<Integer> Qy;
      private int lL;
      private final int qh;
      private int w;
      
      static
      {
        Qx = new HashMap();
        Qx.put("height", fb.a.e("height", 2));
        Qx.put("url", fb.a.h("url", 3));
        Qx.put("width", fb.a.e("width", 4));
      }
      
      public b()
      {
        this.qh = 1;
        this.Qy = new HashSet();
      }
      
      b(Set<Integer> paramSet, int paramInt1, int paramInt2, String paramString, int paramInt3)
      {
        this.Qy = paramSet;
        this.qh = paramInt1;
        this.lL = paramInt2;
        this.Fv = paramString;
        this.w = paramInt3;
      }
      
      protected boolean a(fb.a parama)
      {
        return this.Qy.contains(Integer.valueOf(parama.qK()));
      }
      
      protected Object aP(String paramString)
      {
        return null;
      }
      
      protected boolean aQ(String paramString)
      {
        return false;
      }
      
      protected Object b(fb.a parama)
      {
        switch (parama.qK())
        {
        default: 
          throw new IllegalStateException("Unknown safe parcelable id=" + parama.qK());
        case 2: 
          return Integer.valueOf(this.lL);
        case 3: 
          return this.Fv;
        }
        return Integer.valueOf(this.w);
      }
      
      public int describeContents()
      {
        fq localfq = Sc;
        return 0;
      }
      
      public boolean equals(Object paramObject)
      {
        if (!(paramObject instanceof b)) {
          return false;
        }
        if (this == paramObject) {
          return true;
        }
        paramObject = (b)paramObject;
        Iterator localIterator = Qx.values().iterator();
        while (localIterator.hasNext())
        {
          fb.a locala = (fb.a)localIterator.next();
          if (a(locala))
          {
            if (((b)paramObject).a(locala))
            {
              if (!b(locala).equals(((b)paramObject).b(locala))) {
                return false;
              }
            }
            else {
              return false;
            }
          }
          else if (((b)paramObject).a(locala)) {
            return false;
          }
        }
        return true;
      }
      
      public int getHeight()
      {
        return this.lL;
      }
      
      public String getUrl()
      {
        return this.Fv;
      }
      
      public int getWidth()
      {
        return this.w;
      }
      
      public int hashCode()
      {
        Iterator localIterator = Qx.values().iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          fb.a locala = (fb.a)localIterator.next();
          if (!a(locala)) {
            break label68;
          }
          int j = locala.qK();
          i = b(locala).hashCode() + (i + j);
        }
        label68:
        for (;;)
        {
          break;
          return i;
        }
      }
      
      int lX()
      {
        return this.qh;
      }
      
      public HashMap<String, fb.a<?, ?>> qE()
      {
        return Qx;
      }
      
      Set<Integer> rI()
      {
        return this.Qy;
      }
      
      public b ti()
      {
        return this;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        fq localfq = Sc;
        fq.a(this, paramParcel, paramInt);
      }
    }
  }
  
  public static final class c
    extends fb
    implements SafeParcelable, a.c
  {
    private static final HashMap<String, fb.a<?, ?>> Qx;
    public static final fr Sd = new fr();
    private String Fv;
    private final Set<Integer> Qy;
    private final int qh;
    
    static
    {
      Qx = new HashMap();
      Qx.put("url", fb.a.h("url", 2));
    }
    
    public c()
    {
      this.qh = 1;
      this.Qy = new HashSet();
    }
    
    c(Set<Integer> paramSet, int paramInt, String paramString)
    {
      this.Qy = paramSet;
      this.qh = paramInt;
      this.Fv = paramString;
    }
    
    protected boolean a(fb.a parama)
    {
      return this.Qy.contains(Integer.valueOf(parama.qK()));
    }
    
    protected Object aP(String paramString)
    {
      return null;
    }
    
    protected boolean aQ(String paramString)
    {
      return false;
    }
    
    protected Object b(fb.a parama)
    {
      switch (parama.qK())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.qK());
      }
      return this.Fv;
    }
    
    public int describeContents()
    {
      fr localfr = Sd;
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof c)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      paramObject = (c)paramObject;
      Iterator localIterator = Qx.values().iterator();
      while (localIterator.hasNext())
      {
        fb.a locala = (fb.a)localIterator.next();
        if (a(locala))
        {
          if (((c)paramObject).a(locala))
          {
            if (!b(locala).equals(((c)paramObject).b(locala))) {
              return false;
            }
          }
          else {
            return false;
          }
        }
        else if (((c)paramObject).a(locala)) {
          return false;
        }
      }
      return true;
    }
    
    public String getUrl()
    {
      return this.Fv;
    }
    
    public int hashCode()
    {
      Iterator localIterator = Qx.values().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        fb.a locala = (fb.a)localIterator.next();
        if (!a(locala)) {
          break label68;
        }
        int j = locala.qK();
        i = b(locala).hashCode() + (i + j);
      }
      label68:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    int lX()
    {
      return this.qh;
    }
    
    public HashMap<String, fb.a<?, ?>> qE()
    {
      return Qx;
    }
    
    Set<Integer> rI()
    {
      return this.Qy;
    }
    
    public c tj()
    {
      return this;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      fr localfr = Sd;
      fr.a(this, paramParcel, paramInt);
    }
  }
  
  public static final class d
    extends fb
    implements SafeParcelable, a.d
  {
    private static final HashMap<String, fb.a<?, ?>> Qx;
    public static final fs Se = new fs();
    private String QX;
    private final Set<Integer> Qy;
    private String Ra;
    private String Sf;
    private String Sg;
    private String Sh;
    private String Si;
    private final int qh;
    
    static
    {
      Qx = new HashMap();
      Qx.put("familyName", fb.a.h("familyName", 2));
      Qx.put("formatted", fb.a.h("formatted", 3));
      Qx.put("givenName", fb.a.h("givenName", 4));
      Qx.put("honorificPrefix", fb.a.h("honorificPrefix", 5));
      Qx.put("honorificSuffix", fb.a.h("honorificSuffix", 6));
      Qx.put("middleName", fb.a.h("middleName", 7));
    }
    
    public d()
    {
      this.qh = 1;
      this.Qy = new HashSet();
    }
    
    d(Set<Integer> paramSet, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    {
      this.Qy = paramSet;
      this.qh = paramInt;
      this.QX = paramString1;
      this.Sf = paramString2;
      this.Ra = paramString3;
      this.Sg = paramString4;
      this.Sh = paramString5;
      this.Si = paramString6;
    }
    
    protected boolean a(fb.a parama)
    {
      return this.Qy.contains(Integer.valueOf(parama.qK()));
    }
    
    protected Object aP(String paramString)
    {
      return null;
    }
    
    protected boolean aQ(String paramString)
    {
      return false;
    }
    
    protected Object b(fb.a parama)
    {
      switch (parama.qK())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.qK());
      case 2: 
        return this.QX;
      case 3: 
        return this.Sf;
      case 4: 
        return this.Ra;
      case 5: 
        return this.Sg;
      case 6: 
        return this.Sh;
      }
      return this.Si;
    }
    
    public int describeContents()
    {
      fs localfs = Se;
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof d)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      paramObject = (d)paramObject;
      Iterator localIterator = Qx.values().iterator();
      while (localIterator.hasNext())
      {
        fb.a locala = (fb.a)localIterator.next();
        if (a(locala))
        {
          if (((d)paramObject).a(locala))
          {
            if (!b(locala).equals(((d)paramObject).b(locala))) {
              return false;
            }
          }
          else {
            return false;
          }
        }
        else if (((d)paramObject).a(locala)) {
          return false;
        }
      }
      return true;
    }
    
    public int hashCode()
    {
      Iterator localIterator = Qx.values().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        fb.a locala = (fb.a)localIterator.next();
        if (!a(locala)) {
          break label68;
        }
        int j = locala.qK();
        i = b(locala).hashCode() + (i + j);
      }
      label68:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    int lX()
    {
      return this.qh;
    }
    
    public HashMap<String, fb.a<?, ?>> qE()
    {
      return Qx;
    }
    
    Set<Integer> rI()
    {
      return this.Qy;
    }
    
    public String sg()
    {
      return this.QX;
    }
    
    public String sj()
    {
      return this.Ra;
    }
    
    public String tk()
    {
      return this.Sf;
    }
    
    public String tl()
    {
      return this.Sg;
    }
    
    public String tm()
    {
      return this.Sh;
    }
    
    public String tn()
    {
      return this.Si;
    }
    
    public d to()
    {
      return this;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      fs localfs = Se;
      fs.a(this, paramParcel, paramInt);
    }
  }
  
  public static final class f
    extends fb
    implements SafeParcelable, a.e
  {
    private static final HashMap<String, fb.a<?, ?>> Qx;
    public static final ft Sj = new ft();
    private String QW;
    private final Set<Integer> Qy;
    private String Rm;
    private String Sk;
    private String Sl;
    private boolean Sm;
    private String mName;
    private final int qh;
    private int sw;
    private String th;
    private String vf;
    
    static
    {
      Qx = new HashMap();
      Qx.put("department", fb.a.h("department", 2));
      Qx.put("description", fb.a.h("description", 3));
      Qx.put("endDate", fb.a.h("endDate", 4));
      Qx.put("location", fb.a.h("location", 5));
      Qx.put("name", fb.a.h("name", 6));
      Qx.put("primary", fb.a.g("primary", 7));
      Qx.put("startDate", fb.a.h("startDate", 8));
      Qx.put("title", fb.a.h("title", 9));
      Qx.put("type", fb.a.a("type", 10, new ey().d("work", 0).d("school", 1), false));
    }
    
    public f()
    {
      this.qh = 1;
      this.Qy = new HashSet();
    }
    
    f(Set<Integer> paramSet, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, String paramString6, String paramString7, int paramInt2)
    {
      this.Qy = paramSet;
      this.qh = paramInt1;
      this.Sk = paramString1;
      this.vf = paramString2;
      this.QW = paramString3;
      this.Sl = paramString4;
      this.mName = paramString5;
      this.Sm = paramBoolean;
      this.Rm = paramString6;
      this.th = paramString7;
      this.sw = paramInt2;
    }
    
    protected boolean a(fb.a parama)
    {
      return this.Qy.contains(Integer.valueOf(parama.qK()));
    }
    
    protected Object aP(String paramString)
    {
      return null;
    }
    
    protected boolean aQ(String paramString)
    {
      return false;
    }
    
    protected Object b(fb.a parama)
    {
      switch (parama.qK())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.qK());
      case 2: 
        return this.Sk;
      case 3: 
        return this.vf;
      case 4: 
        return this.QW;
      case 5: 
        return this.Sl;
      case 6: 
        return this.mName;
      case 7: 
        return Boolean.valueOf(this.Sm);
      case 8: 
        return this.Rm;
      case 9: 
        return this.th;
      }
      return Integer.valueOf(this.sw);
    }
    
    public int describeContents()
    {
      ft localft = Sj;
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof f)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      paramObject = (f)paramObject;
      Iterator localIterator = Qx.values().iterator();
      while (localIterator.hasNext())
      {
        fb.a locala = (fb.a)localIterator.next();
        if (a(locala))
        {
          if (((f)paramObject).a(locala))
          {
            if (!b(locala).equals(((f)paramObject).b(locala))) {
              return false;
            }
          }
          else {
            return false;
          }
        }
        else if (((f)paramObject).a(locala)) {
          return false;
        }
      }
      return true;
    }
    
    public String getDescription()
    {
      return this.vf;
    }
    
    public String getLocation()
    {
      return this.Sl;
    }
    
    public String getName()
    {
      return this.mName;
    }
    
    public String getTitle()
    {
      return this.th;
    }
    
    public int getType()
    {
      return this.sw;
    }
    
    public int hashCode()
    {
      Iterator localIterator = Qx.values().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        fb.a locala = (fb.a)localIterator.next();
        if (!a(locala)) {
          break label68;
        }
        int j = locala.qK();
        i = b(locala).hashCode() + (i + j);
      }
      label68:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    int lX()
    {
      return this.qh;
    }
    
    public HashMap<String, fb.a<?, ?>> qE()
    {
      return Qx;
    }
    
    Set<Integer> rI()
    {
      return this.Qy;
    }
    
    public String sf()
    {
      return this.QW;
    }
    
    public String su()
    {
      return this.Rm;
    }
    
    public String tp()
    {
      return this.Sk;
    }
    
    public boolean tq()
    {
      return this.Sm;
    }
    
    public f tr()
    {
      return this;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      ft localft = Sj;
      ft.a(this, paramParcel, paramInt);
    }
  }
  
  public static final class g
    extends fb
    implements SafeParcelable, a.f
  {
    private static final HashMap<String, fb.a<?, ?>> Qx;
    public static final fu Sn = new fu();
    private final Set<Integer> Qy;
    private boolean Sm;
    private String mValue;
    private final int qh;
    
    static
    {
      Qx = new HashMap();
      Qx.put("primary", fb.a.g("primary", 2));
      Qx.put("value", fb.a.h("value", 3));
    }
    
    public g()
    {
      this.qh = 1;
      this.Qy = new HashSet();
    }
    
    g(Set<Integer> paramSet, int paramInt, boolean paramBoolean, String paramString)
    {
      this.Qy = paramSet;
      this.qh = paramInt;
      this.Sm = paramBoolean;
      this.mValue = paramString;
    }
    
    protected boolean a(fb.a parama)
    {
      return this.Qy.contains(Integer.valueOf(parama.qK()));
    }
    
    protected Object aP(String paramString)
    {
      return null;
    }
    
    protected boolean aQ(String paramString)
    {
      return false;
    }
    
    protected Object b(fb.a parama)
    {
      switch (parama.qK())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.qK());
      case 2: 
        return Boolean.valueOf(this.Sm);
      }
      return this.mValue;
    }
    
    public int describeContents()
    {
      fu localfu = Sn;
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof g)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      paramObject = (g)paramObject;
      Iterator localIterator = Qx.values().iterator();
      while (localIterator.hasNext())
      {
        fb.a locala = (fb.a)localIterator.next();
        if (a(locala))
        {
          if (((g)paramObject).a(locala))
          {
            if (!b(locala).equals(((g)paramObject).b(locala))) {
              return false;
            }
          }
          else {
            return false;
          }
        }
        else if (((g)paramObject).a(locala)) {
          return false;
        }
      }
      return true;
    }
    
    public String getValue()
    {
      return this.mValue;
    }
    
    public int hashCode()
    {
      Iterator localIterator = Qx.values().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        fb.a locala = (fb.a)localIterator.next();
        if (!a(locala)) {
          break label68;
        }
        int j = locala.qK();
        i = b(locala).hashCode() + (i + j);
      }
      label68:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    int lX()
    {
      return this.qh;
    }
    
    public HashMap<String, fb.a<?, ?>> qE()
    {
      return Qx;
    }
    
    Set<Integer> rI()
    {
      return this.Qy;
    }
    
    public boolean tq()
    {
      return this.Sm;
    }
    
    public g ts()
    {
      return this;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      fu localfu = Sn;
      fu.a(this, paramParcel, paramInt);
    }
  }
  
  public static final class h
    extends fb
    implements SafeParcelable, a.g
  {
    private static final HashMap<String, fb.a<?, ?>> Qx;
    public static final fv So = new fv();
    private final Set<Integer> Qy;
    private String Sp;
    private final int Sq = 4;
    private String mValue;
    private final int qh;
    private int sw;
    
    static
    {
      Qx = new HashMap();
      Qx.put("label", fb.a.h("label", 5));
      Qx.put("type", fb.a.a("type", 6, new ey().d("home", 0).d("work", 1).d("blog", 2).d("profile", 3).d("other", 4).d("otherProfile", 5).d("contributor", 6).d("website", 7), false));
      Qx.put("value", fb.a.h("value", 4));
    }
    
    public h()
    {
      this.qh = 2;
      this.Qy = new HashSet();
    }
    
    h(Set<Integer> paramSet, int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3)
    {
      this.Qy = paramSet;
      this.qh = paramInt1;
      this.Sp = paramString1;
      this.sw = paramInt2;
      this.mValue = paramString2;
    }
    
    protected boolean a(fb.a parama)
    {
      return this.Qy.contains(Integer.valueOf(parama.qK()));
    }
    
    protected Object aP(String paramString)
    {
      return null;
    }
    
    protected boolean aQ(String paramString)
    {
      return false;
    }
    
    protected Object b(fb.a parama)
    {
      switch (parama.qK())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.qK());
      case 5: 
        return this.Sp;
      case 6: 
        return Integer.valueOf(this.sw);
      }
      return this.mValue;
    }
    
    public int describeContents()
    {
      fv localfv = So;
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof h)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      paramObject = (h)paramObject;
      Iterator localIterator = Qx.values().iterator();
      while (localIterator.hasNext())
      {
        fb.a locala = (fb.a)localIterator.next();
        if (a(locala))
        {
          if (((h)paramObject).a(locala))
          {
            if (!b(locala).equals(((h)paramObject).b(locala))) {
              return false;
            }
          }
          else {
            return false;
          }
        }
        else if (((h)paramObject).a(locala)) {
          return false;
        }
      }
      return true;
    }
    
    public String getLabel()
    {
      return this.Sp;
    }
    
    public int getType()
    {
      return this.sw;
    }
    
    public String getValue()
    {
      return this.mValue;
    }
    
    public int hashCode()
    {
      Iterator localIterator = Qx.values().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        fb.a locala = (fb.a)localIterator.next();
        if (!a(locala)) {
          break label68;
        }
        int j = locala.qK();
        i = b(locala).hashCode() + (i + j);
      }
      label68:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    int lX()
    {
      return this.qh;
    }
    
    public HashMap<String, fb.a<?, ?>> qE()
    {
      return Qx;
    }
    
    Set<Integer> rI()
    {
      return this.Qy;
    }
    
    @Deprecated
    public int tt()
    {
      return 4;
    }
    
    public h tu()
    {
      return this;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      fv localfv = So;
      fv.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/ir.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */