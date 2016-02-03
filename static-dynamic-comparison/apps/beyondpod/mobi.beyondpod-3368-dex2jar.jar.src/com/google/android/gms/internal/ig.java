package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.Person.AgeRange;
import com.google.android.gms.plus.model.people.Person.Cover;
import com.google.android.gms.plus.model.people.Person.Cover.CoverInfo;
import com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto;
import com.google.android.gms.plus.model.people.Person.Image;
import com.google.android.gms.plus.model.people.Person.Name;
import com.google.android.gms.plus.model.people.Person.Organizations;
import com.google.android.gms.plus.model.people.Person.PlacesLived;
import com.google.android.gms.plus.model.people.Person.Urls;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class ig
  extends es
  implements SafeParcelable, Person
{
  public static final ih CREATOR = new ih();
  private static final HashMap<String, es.a<?, ?>> Ep = new HashMap();
  private final Set<Integer> Eq;
  private String FA;
  private int FB;
  private List<f> FC;
  private List<g> FD;
  private int FE;
  private int FF;
  private String FG;
  private List<h> FH;
  private boolean FI;
  private String Fp;
  private a Fq;
  private String Fr;
  private String Fs;
  private int Ft;
  private b Fu;
  private String Fv;
  private c Fw;
  private boolean Fx;
  private String Fy;
  private d Fz;
  private int eL;
  private String iH;
  private final int kg;
  private String qa;
  private String uS;
  
  static
  {
    Ep.put("aboutMe", es.a.g("aboutMe", 2));
    Ep.put("ageRange", es.a.a("ageRange", 3, a.class));
    Ep.put("birthday", es.a.g("birthday", 4));
    Ep.put("braggingRights", es.a.g("braggingRights", 5));
    Ep.put("circledByCount", es.a.d("circledByCount", 6));
    Ep.put("cover", es.a.a("cover", 7, b.class));
    Ep.put("currentLocation", es.a.g("currentLocation", 8));
    Ep.put("displayName", es.a.g("displayName", 9));
    Ep.put("gender", es.a.a("gender", 12, new ep().c("male", 0).c("female", 1).c("other", 2), false));
    Ep.put("id", es.a.g("id", 14));
    Ep.put("image", es.a.a("image", 15, c.class));
    Ep.put("isPlusUser", es.a.f("isPlusUser", 16));
    Ep.put("language", es.a.g("language", 18));
    Ep.put("name", es.a.a("name", 19, d.class));
    Ep.put("nickname", es.a.g("nickname", 20));
    Ep.put("objectType", es.a.a("objectType", 21, new ep().c("person", 0).c("page", 1), false));
    Ep.put("organizations", es.a.b("organizations", 22, f.class));
    Ep.put("placesLived", es.a.b("placesLived", 23, g.class));
    Ep.put("plusOneCount", es.a.d("plusOneCount", 24));
    Ep.put("relationshipStatus", es.a.a("relationshipStatus", 25, new ep().c("single", 0).c("in_a_relationship", 1).c("engaged", 2).c("married", 3).c("its_complicated", 4).c("open_relationship", 5).c("widowed", 6).c("in_domestic_partnership", 7).c("in_civil_union", 8), false));
    Ep.put("tagline", es.a.g("tagline", 26));
    Ep.put("url", es.a.g("url", 27));
    Ep.put("urls", es.a.b("urls", 28, h.class));
    Ep.put("verified", es.a.f("verified", 29));
  }
  
  public ig()
  {
    this.kg = 2;
    this.Eq = new HashSet();
  }
  
  public ig(String paramString1, String paramString2, c paramc, int paramInt, String paramString3)
  {
    this.kg = 2;
    this.Eq = new HashSet();
    this.qa = paramString1;
    this.Eq.add(Integer.valueOf(9));
    this.uS = paramString2;
    this.Eq.add(Integer.valueOf(14));
    this.Fw = paramc;
    this.Eq.add(Integer.valueOf(15));
    this.FB = paramInt;
    this.Eq.add(Integer.valueOf(21));
    this.iH = paramString3;
    this.Eq.add(Integer.valueOf(27));
  }
  
  ig(Set<Integer> paramSet, int paramInt1, String paramString1, a parama, String paramString2, String paramString3, int paramInt2, b paramb, String paramString4, String paramString5, int paramInt3, String paramString6, c paramc, boolean paramBoolean1, String paramString7, d paramd, String paramString8, int paramInt4, List<f> paramList, List<g> paramList1, int paramInt5, int paramInt6, String paramString9, String paramString10, List<h> paramList2, boolean paramBoolean2)
  {
    this.Eq = paramSet;
    this.kg = paramInt1;
    this.Fp = paramString1;
    this.Fq = parama;
    this.Fr = paramString2;
    this.Fs = paramString3;
    this.Ft = paramInt2;
    this.Fu = paramb;
    this.Fv = paramString4;
    this.qa = paramString5;
    this.eL = paramInt3;
    this.uS = paramString6;
    this.Fw = paramc;
    this.Fx = paramBoolean1;
    this.Fy = paramString7;
    this.Fz = paramd;
    this.FA = paramString8;
    this.FB = paramInt4;
    this.FC = paramList;
    this.FD = paramList1;
    this.FE = paramInt5;
    this.FF = paramInt6;
    this.FG = paramString9;
    this.iH = paramString10;
    this.FH = paramList2;
    this.FI = paramBoolean2;
  }
  
  public static ig g(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    paramArrayOfByte = CREATOR.au(localParcel);
    localParcel.recycle();
    return paramArrayOfByte;
  }
  
  protected Object V(String paramString)
  {
    return null;
  }
  
  protected boolean W(String paramString)
  {
    return false;
  }
  
  protected boolean a(es.a parama)
  {
    return this.Eq.contains(Integer.valueOf(parama.cq()));
  }
  
  protected Object b(es.a parama)
  {
    switch (parama.cq())
    {
    case 10: 
    case 11: 
    case 13: 
    case 17: 
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.cq());
    case 2: 
      return this.Fp;
    case 3: 
      return this.Fq;
    case 4: 
      return this.Fr;
    case 5: 
      return this.Fs;
    case 6: 
      return Integer.valueOf(this.Ft);
    case 7: 
      return this.Fu;
    case 8: 
      return this.Fv;
    case 9: 
      return this.qa;
    case 12: 
      return Integer.valueOf(this.eL);
    case 14: 
      return this.uS;
    case 15: 
      return this.Fw;
    case 16: 
      return Boolean.valueOf(this.Fx);
    case 18: 
      return this.Fy;
    case 19: 
      return this.Fz;
    case 20: 
      return this.FA;
    case 21: 
      return Integer.valueOf(this.FB);
    case 22: 
      return this.FC;
    case 23: 
      return this.FD;
    case 24: 
      return Integer.valueOf(this.FE);
    case 25: 
      return Integer.valueOf(this.FF);
    case 26: 
      return this.FG;
    case 27: 
      return this.iH;
    case 28: 
      return this.FH;
    }
    return Boolean.valueOf(this.FI);
  }
  
  public HashMap<String, es.a<?, ?>> cj()
  {
    return Ep;
  }
  
  public int describeContents()
  {
    ih localih = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ig)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (ig)paramObject;
    Iterator localIterator = Ep.values().iterator();
    while (localIterator.hasNext())
    {
      es.a locala = (es.a)localIterator.next();
      if (a(locala))
      {
        if (((ig)paramObject).a(locala))
        {
          if (!b(locala).equals(((ig)paramObject).b(locala))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((ig)paramObject).a(locala)) {
        return false;
      }
    }
    return true;
  }
  
  List<g> fA()
  {
    return this.FD;
  }
  
  List<h> fB()
  {
    return this.FH;
  }
  
  public ig fC()
  {
    return this;
  }
  
  Set<Integer> fa()
  {
    return this.Eq;
  }
  
  a fv()
  {
    return this.Fq;
  }
  
  b fw()
  {
    return this.Fu;
  }
  
  c fx()
  {
    return this.Fw;
  }
  
  d fy()
  {
    return this.Fz;
  }
  
  List<f> fz()
  {
    return this.FC;
  }
  
  public String getAboutMe()
  {
    return this.Fp;
  }
  
  public Person.AgeRange getAgeRange()
  {
    return this.Fq;
  }
  
  public String getBirthday()
  {
    return this.Fr;
  }
  
  public String getBraggingRights()
  {
    return this.Fs;
  }
  
  public int getCircledByCount()
  {
    return this.Ft;
  }
  
  public Person.Cover getCover()
  {
    return this.Fu;
  }
  
  public String getCurrentLocation()
  {
    return this.Fv;
  }
  
  public String getDisplayName()
  {
    return this.qa;
  }
  
  public int getGender()
  {
    return this.eL;
  }
  
  public String getId()
  {
    return this.uS;
  }
  
  public Person.Image getImage()
  {
    return this.Fw;
  }
  
  public String getLanguage()
  {
    return this.Fy;
  }
  
  public Person.Name getName()
  {
    return this.Fz;
  }
  
  public String getNickname()
  {
    return this.FA;
  }
  
  public int getObjectType()
  {
    return this.FB;
  }
  
  public List<Person.Organizations> getOrganizations()
  {
    return (ArrayList)this.FC;
  }
  
  public List<Person.PlacesLived> getPlacesLived()
  {
    return (ArrayList)this.FD;
  }
  
  public int getPlusOneCount()
  {
    return this.FE;
  }
  
  public int getRelationshipStatus()
  {
    return this.FF;
  }
  
  public String getTagline()
  {
    return this.FG;
  }
  
  public String getUrl()
  {
    return this.iH;
  }
  
  public List<Person.Urls> getUrls()
  {
    return (ArrayList)this.FH;
  }
  
  int getVersionCode()
  {
    return this.kg;
  }
  
  public boolean hasAboutMe()
  {
    return this.Eq.contains(Integer.valueOf(2));
  }
  
  public boolean hasAgeRange()
  {
    return this.Eq.contains(Integer.valueOf(3));
  }
  
  public boolean hasBirthday()
  {
    return this.Eq.contains(Integer.valueOf(4));
  }
  
  public boolean hasBraggingRights()
  {
    return this.Eq.contains(Integer.valueOf(5));
  }
  
  public boolean hasCircledByCount()
  {
    return this.Eq.contains(Integer.valueOf(6));
  }
  
  public boolean hasCover()
  {
    return this.Eq.contains(Integer.valueOf(7));
  }
  
  public boolean hasCurrentLocation()
  {
    return this.Eq.contains(Integer.valueOf(8));
  }
  
  public boolean hasDisplayName()
  {
    return this.Eq.contains(Integer.valueOf(9));
  }
  
  public boolean hasGender()
  {
    return this.Eq.contains(Integer.valueOf(12));
  }
  
  public boolean hasId()
  {
    return this.Eq.contains(Integer.valueOf(14));
  }
  
  public boolean hasImage()
  {
    return this.Eq.contains(Integer.valueOf(15));
  }
  
  public boolean hasIsPlusUser()
  {
    return this.Eq.contains(Integer.valueOf(16));
  }
  
  public boolean hasLanguage()
  {
    return this.Eq.contains(Integer.valueOf(18));
  }
  
  public boolean hasName()
  {
    return this.Eq.contains(Integer.valueOf(19));
  }
  
  public boolean hasNickname()
  {
    return this.Eq.contains(Integer.valueOf(20));
  }
  
  public boolean hasObjectType()
  {
    return this.Eq.contains(Integer.valueOf(21));
  }
  
  public boolean hasOrganizations()
  {
    return this.Eq.contains(Integer.valueOf(22));
  }
  
  public boolean hasPlacesLived()
  {
    return this.Eq.contains(Integer.valueOf(23));
  }
  
  public boolean hasPlusOneCount()
  {
    return this.Eq.contains(Integer.valueOf(24));
  }
  
  public boolean hasRelationshipStatus()
  {
    return this.Eq.contains(Integer.valueOf(25));
  }
  
  public boolean hasTagline()
  {
    return this.Eq.contains(Integer.valueOf(26));
  }
  
  public boolean hasUrl()
  {
    return this.Eq.contains(Integer.valueOf(27));
  }
  
  public boolean hasUrls()
  {
    return this.Eq.contains(Integer.valueOf(28));
  }
  
  public boolean hasVerified()
  {
    return this.Eq.contains(Integer.valueOf(29));
  }
  
  public int hashCode()
  {
    Iterator localIterator = Ep.values().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      es.a locala = (es.a)localIterator.next();
      if (!a(locala)) {
        break label68;
      }
      int j = locala.cq();
      i = b(locala).hashCode() + (i + j);
    }
    label68:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public boolean isPlusUser()
  {
    return this.Fx;
  }
  
  public boolean isVerified()
  {
    return this.FI;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ih localih = CREATOR;
    ih.a(this, paramParcel, paramInt);
  }
  
  public static final class a
    extends es
    implements SafeParcelable, Person.AgeRange
  {
    public static final ii CREATOR = new ii();
    private static final HashMap<String, es.a<?, ?>> Ep = new HashMap();
    private final Set<Integer> Eq;
    private int FJ;
    private int FK;
    private final int kg;
    
    static
    {
      Ep.put("max", es.a.d("max", 2));
      Ep.put("min", es.a.d("min", 3));
    }
    
    public a()
    {
      this.kg = 1;
      this.Eq = new HashSet();
    }
    
    a(Set<Integer> paramSet, int paramInt1, int paramInt2, int paramInt3)
    {
      this.Eq = paramSet;
      this.kg = paramInt1;
      this.FJ = paramInt2;
      this.FK = paramInt3;
    }
    
    protected Object V(String paramString)
    {
      return null;
    }
    
    protected boolean W(String paramString)
    {
      return false;
    }
    
    protected boolean a(es.a parama)
    {
      return this.Eq.contains(Integer.valueOf(parama.cq()));
    }
    
    protected Object b(es.a parama)
    {
      switch (parama.cq())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.cq());
      case 2: 
        return Integer.valueOf(this.FJ);
      }
      return Integer.valueOf(this.FK);
    }
    
    public HashMap<String, es.a<?, ?>> cj()
    {
      return Ep;
    }
    
    public int describeContents()
    {
      ii localii = CREATOR;
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
      Iterator localIterator = Ep.values().iterator();
      while (localIterator.hasNext())
      {
        es.a locala = (es.a)localIterator.next();
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
    
    public a fD()
    {
      return this;
    }
    
    Set<Integer> fa()
    {
      return this.Eq;
    }
    
    public int getMax()
    {
      return this.FJ;
    }
    
    public int getMin()
    {
      return this.FK;
    }
    
    int getVersionCode()
    {
      return this.kg;
    }
    
    public boolean hasMax()
    {
      return this.Eq.contains(Integer.valueOf(2));
    }
    
    public boolean hasMin()
    {
      return this.Eq.contains(Integer.valueOf(3));
    }
    
    public int hashCode()
    {
      Iterator localIterator = Ep.values().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        es.a locala = (es.a)localIterator.next();
        if (!a(locala)) {
          break label68;
        }
        int j = locala.cq();
        i = b(locala).hashCode() + (i + j);
      }
      label68:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    public boolean isDataValid()
    {
      return true;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      ii localii = CREATOR;
      ii.a(this, paramParcel, paramInt);
    }
  }
  
  public static final class b
    extends es
    implements SafeParcelable, Person.Cover
  {
    public static final ij CREATOR = new ij();
    private static final HashMap<String, es.a<?, ?>> Ep = new HashMap();
    private final Set<Integer> Eq;
    private a FL;
    private b FM;
    private int FN;
    private final int kg;
    
    static
    {
      Ep.put("coverInfo", es.a.a("coverInfo", 2, a.class));
      Ep.put("coverPhoto", es.a.a("coverPhoto", 3, b.class));
      Ep.put("layout", es.a.a("layout", 4, new ep().c("banner", 0), false));
    }
    
    public b()
    {
      this.kg = 1;
      this.Eq = new HashSet();
    }
    
    b(Set<Integer> paramSet, int paramInt1, a parama, b paramb, int paramInt2)
    {
      this.Eq = paramSet;
      this.kg = paramInt1;
      this.FL = parama;
      this.FM = paramb;
      this.FN = paramInt2;
    }
    
    protected Object V(String paramString)
    {
      return null;
    }
    
    protected boolean W(String paramString)
    {
      return false;
    }
    
    protected boolean a(es.a parama)
    {
      return this.Eq.contains(Integer.valueOf(parama.cq()));
    }
    
    protected Object b(es.a parama)
    {
      switch (parama.cq())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.cq());
      case 2: 
        return this.FL;
      case 3: 
        return this.FM;
      }
      return Integer.valueOf(this.FN);
    }
    
    public HashMap<String, es.a<?, ?>> cj()
    {
      return Ep;
    }
    
    public int describeContents()
    {
      ij localij = CREATOR;
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
      Iterator localIterator = Ep.values().iterator();
      while (localIterator.hasNext())
      {
        es.a locala = (es.a)localIterator.next();
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
    
    a fE()
    {
      return this.FL;
    }
    
    b fF()
    {
      return this.FM;
    }
    
    public b fG()
    {
      return this;
    }
    
    Set<Integer> fa()
    {
      return this.Eq;
    }
    
    public Person.Cover.CoverInfo getCoverInfo()
    {
      return this.FL;
    }
    
    public Person.Cover.CoverPhoto getCoverPhoto()
    {
      return this.FM;
    }
    
    public int getLayout()
    {
      return this.FN;
    }
    
    int getVersionCode()
    {
      return this.kg;
    }
    
    public boolean hasCoverInfo()
    {
      return this.Eq.contains(Integer.valueOf(2));
    }
    
    public boolean hasCoverPhoto()
    {
      return this.Eq.contains(Integer.valueOf(3));
    }
    
    public boolean hasLayout()
    {
      return this.Eq.contains(Integer.valueOf(4));
    }
    
    public int hashCode()
    {
      Iterator localIterator = Ep.values().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        es.a locala = (es.a)localIterator.next();
        if (!a(locala)) {
          break label68;
        }
        int j = locala.cq();
        i = b(locala).hashCode() + (i + j);
      }
      label68:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    public boolean isDataValid()
    {
      return true;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      ij localij = CREATOR;
      ij.a(this, paramParcel, paramInt);
    }
    
    public static final class a
      extends es
      implements SafeParcelable, Person.Cover.CoverInfo
    {
      public static final ik CREATOR = new ik();
      private static final HashMap<String, es.a<?, ?>> Ep = new HashMap();
      private final Set<Integer> Eq;
      private int FO;
      private int FP;
      private final int kg;
      
      static
      {
        Ep.put("leftImageOffset", es.a.d("leftImageOffset", 2));
        Ep.put("topImageOffset", es.a.d("topImageOffset", 3));
      }
      
      public a()
      {
        this.kg = 1;
        this.Eq = new HashSet();
      }
      
      a(Set<Integer> paramSet, int paramInt1, int paramInt2, int paramInt3)
      {
        this.Eq = paramSet;
        this.kg = paramInt1;
        this.FO = paramInt2;
        this.FP = paramInt3;
      }
      
      protected Object V(String paramString)
      {
        return null;
      }
      
      protected boolean W(String paramString)
      {
        return false;
      }
      
      protected boolean a(es.a parama)
      {
        return this.Eq.contains(Integer.valueOf(parama.cq()));
      }
      
      protected Object b(es.a parama)
      {
        switch (parama.cq())
        {
        default: 
          throw new IllegalStateException("Unknown safe parcelable id=" + parama.cq());
        case 2: 
          return Integer.valueOf(this.FO);
        }
        return Integer.valueOf(this.FP);
      }
      
      public HashMap<String, es.a<?, ?>> cj()
      {
        return Ep;
      }
      
      public int describeContents()
      {
        ik localik = CREATOR;
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
        Iterator localIterator = Ep.values().iterator();
        while (localIterator.hasNext())
        {
          es.a locala = (es.a)localIterator.next();
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
      
      public a fH()
      {
        return this;
      }
      
      Set<Integer> fa()
      {
        return this.Eq;
      }
      
      public int getLeftImageOffset()
      {
        return this.FO;
      }
      
      public int getTopImageOffset()
      {
        return this.FP;
      }
      
      int getVersionCode()
      {
        return this.kg;
      }
      
      public boolean hasLeftImageOffset()
      {
        return this.Eq.contains(Integer.valueOf(2));
      }
      
      public boolean hasTopImageOffset()
      {
        return this.Eq.contains(Integer.valueOf(3));
      }
      
      public int hashCode()
      {
        Iterator localIterator = Ep.values().iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          es.a locala = (es.a)localIterator.next();
          if (!a(locala)) {
            break label68;
          }
          int j = locala.cq();
          i = b(locala).hashCode() + (i + j);
        }
        label68:
        for (;;)
        {
          break;
          return i;
        }
      }
      
      public boolean isDataValid()
      {
        return true;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        ik localik = CREATOR;
        ik.a(this, paramParcel, paramInt);
      }
    }
    
    public static final class b
      extends es
      implements SafeParcelable, Person.Cover.CoverPhoto
    {
      public static final il CREATOR = new il();
      private static final HashMap<String, es.a<?, ?>> Ep = new HashMap();
      private final Set<Integer> Eq;
      private String iH;
      private final int kg;
      private int v;
      private int w;
      
      static
      {
        Ep.put("height", es.a.d("height", 2));
        Ep.put("url", es.a.g("url", 3));
        Ep.put("width", es.a.d("width", 4));
      }
      
      public b()
      {
        this.kg = 1;
        this.Eq = new HashSet();
      }
      
      b(Set<Integer> paramSet, int paramInt1, int paramInt2, String paramString, int paramInt3)
      {
        this.Eq = paramSet;
        this.kg = paramInt1;
        this.v = paramInt2;
        this.iH = paramString;
        this.w = paramInt3;
      }
      
      protected Object V(String paramString)
      {
        return null;
      }
      
      protected boolean W(String paramString)
      {
        return false;
      }
      
      protected boolean a(es.a parama)
      {
        return this.Eq.contains(Integer.valueOf(parama.cq()));
      }
      
      protected Object b(es.a parama)
      {
        switch (parama.cq())
        {
        default: 
          throw new IllegalStateException("Unknown safe parcelable id=" + parama.cq());
        case 2: 
          return Integer.valueOf(this.v);
        case 3: 
          return this.iH;
        }
        return Integer.valueOf(this.w);
      }
      
      public HashMap<String, es.a<?, ?>> cj()
      {
        return Ep;
      }
      
      public int describeContents()
      {
        il localil = CREATOR;
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
        Iterator localIterator = Ep.values().iterator();
        while (localIterator.hasNext())
        {
          es.a locala = (es.a)localIterator.next();
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
      
      public b fI()
      {
        return this;
      }
      
      Set<Integer> fa()
      {
        return this.Eq;
      }
      
      public int getHeight()
      {
        return this.v;
      }
      
      public String getUrl()
      {
        return this.iH;
      }
      
      int getVersionCode()
      {
        return this.kg;
      }
      
      public int getWidth()
      {
        return this.w;
      }
      
      public boolean hasHeight()
      {
        return this.Eq.contains(Integer.valueOf(2));
      }
      
      public boolean hasUrl()
      {
        return this.Eq.contains(Integer.valueOf(3));
      }
      
      public boolean hasWidth()
      {
        return this.Eq.contains(Integer.valueOf(4));
      }
      
      public int hashCode()
      {
        Iterator localIterator = Ep.values().iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          es.a locala = (es.a)localIterator.next();
          if (!a(locala)) {
            break label68;
          }
          int j = locala.cq();
          i = b(locala).hashCode() + (i + j);
        }
        label68:
        for (;;)
        {
          break;
          return i;
        }
      }
      
      public boolean isDataValid()
      {
        return true;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        il localil = CREATOR;
        il.a(this, paramParcel, paramInt);
      }
    }
  }
  
  public static final class c
    extends es
    implements SafeParcelable, Person.Image
  {
    public static final im CREATOR = new im();
    private static final HashMap<String, es.a<?, ?>> Ep = new HashMap();
    private final Set<Integer> Eq;
    private String iH;
    private final int kg;
    
    static
    {
      Ep.put("url", es.a.g("url", 2));
    }
    
    public c()
    {
      this.kg = 1;
      this.Eq = new HashSet();
    }
    
    public c(String paramString)
    {
      this.Eq = new HashSet();
      this.kg = 1;
      this.iH = paramString;
      this.Eq.add(Integer.valueOf(2));
    }
    
    c(Set<Integer> paramSet, int paramInt, String paramString)
    {
      this.Eq = paramSet;
      this.kg = paramInt;
      this.iH = paramString;
    }
    
    protected Object V(String paramString)
    {
      return null;
    }
    
    protected boolean W(String paramString)
    {
      return false;
    }
    
    protected boolean a(es.a parama)
    {
      return this.Eq.contains(Integer.valueOf(parama.cq()));
    }
    
    protected Object b(es.a parama)
    {
      switch (parama.cq())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.cq());
      }
      return this.iH;
    }
    
    public HashMap<String, es.a<?, ?>> cj()
    {
      return Ep;
    }
    
    public int describeContents()
    {
      im localim = CREATOR;
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
      Iterator localIterator = Ep.values().iterator();
      while (localIterator.hasNext())
      {
        es.a locala = (es.a)localIterator.next();
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
    
    public c fJ()
    {
      return this;
    }
    
    Set<Integer> fa()
    {
      return this.Eq;
    }
    
    public String getUrl()
    {
      return this.iH;
    }
    
    int getVersionCode()
    {
      return this.kg;
    }
    
    public boolean hasUrl()
    {
      return this.Eq.contains(Integer.valueOf(2));
    }
    
    public int hashCode()
    {
      Iterator localIterator = Ep.values().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        es.a locala = (es.a)localIterator.next();
        if (!a(locala)) {
          break label68;
        }
        int j = locala.cq();
        i = b(locala).hashCode() + (i + j);
      }
      label68:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    public boolean isDataValid()
    {
      return true;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      im localim = CREATOR;
      im.a(this, paramParcel, paramInt);
    }
  }
  
  public static final class d
    extends es
    implements SafeParcelable, Person.Name
  {
    public static final in CREATOR = new in();
    private static final HashMap<String, es.a<?, ?>> Ep = new HashMap();
    private String EP;
    private String ES;
    private final Set<Integer> Eq;
    private String FQ;
    private String FR;
    private String FS;
    private String FT;
    private final int kg;
    
    static
    {
      Ep.put("familyName", es.a.g("familyName", 2));
      Ep.put("formatted", es.a.g("formatted", 3));
      Ep.put("givenName", es.a.g("givenName", 4));
      Ep.put("honorificPrefix", es.a.g("honorificPrefix", 5));
      Ep.put("honorificSuffix", es.a.g("honorificSuffix", 6));
      Ep.put("middleName", es.a.g("middleName", 7));
    }
    
    public d()
    {
      this.kg = 1;
      this.Eq = new HashSet();
    }
    
    d(Set<Integer> paramSet, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    {
      this.Eq = paramSet;
      this.kg = paramInt;
      this.EP = paramString1;
      this.FQ = paramString2;
      this.ES = paramString3;
      this.FR = paramString4;
      this.FS = paramString5;
      this.FT = paramString6;
    }
    
    protected Object V(String paramString)
    {
      return null;
    }
    
    protected boolean W(String paramString)
    {
      return false;
    }
    
    protected boolean a(es.a parama)
    {
      return this.Eq.contains(Integer.valueOf(parama.cq()));
    }
    
    protected Object b(es.a parama)
    {
      switch (parama.cq())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.cq());
      case 2: 
        return this.EP;
      case 3: 
        return this.FQ;
      case 4: 
        return this.ES;
      case 5: 
        return this.FR;
      case 6: 
        return this.FS;
      }
      return this.FT;
    }
    
    public HashMap<String, es.a<?, ?>> cj()
    {
      return Ep;
    }
    
    public int describeContents()
    {
      in localin = CREATOR;
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
      Iterator localIterator = Ep.values().iterator();
      while (localIterator.hasNext())
      {
        es.a locala = (es.a)localIterator.next();
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
    
    public d fK()
    {
      return this;
    }
    
    Set<Integer> fa()
    {
      return this.Eq;
    }
    
    public String getFamilyName()
    {
      return this.EP;
    }
    
    public String getFormatted()
    {
      return this.FQ;
    }
    
    public String getGivenName()
    {
      return this.ES;
    }
    
    public String getHonorificPrefix()
    {
      return this.FR;
    }
    
    public String getHonorificSuffix()
    {
      return this.FS;
    }
    
    public String getMiddleName()
    {
      return this.FT;
    }
    
    int getVersionCode()
    {
      return this.kg;
    }
    
    public boolean hasFamilyName()
    {
      return this.Eq.contains(Integer.valueOf(2));
    }
    
    public boolean hasFormatted()
    {
      return this.Eq.contains(Integer.valueOf(3));
    }
    
    public boolean hasGivenName()
    {
      return this.Eq.contains(Integer.valueOf(4));
    }
    
    public boolean hasHonorificPrefix()
    {
      return this.Eq.contains(Integer.valueOf(5));
    }
    
    public boolean hasHonorificSuffix()
    {
      return this.Eq.contains(Integer.valueOf(6));
    }
    
    public boolean hasMiddleName()
    {
      return this.Eq.contains(Integer.valueOf(7));
    }
    
    public int hashCode()
    {
      Iterator localIterator = Ep.values().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        es.a locala = (es.a)localIterator.next();
        if (!a(locala)) {
          break label68;
        }
        int j = locala.cq();
        i = b(locala).hashCode() + (i + j);
      }
      label68:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    public boolean isDataValid()
    {
      return true;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      in localin = CREATOR;
      in.a(this, paramParcel, paramInt);
    }
  }
  
  public static class e
  {
    public static int aB(String paramString)
    {
      if (paramString.equals("person")) {
        return 0;
      }
      if (paramString.equals("page")) {
        return 1;
      }
      throw new IllegalArgumentException("Unknown objectType string: " + paramString);
    }
  }
  
  public static final class f
    extends es
    implements SafeParcelable, Person.Organizations
  {
    public static final io CREATOR = new io();
    private static final HashMap<String, es.a<?, ?>> Ep = new HashMap();
    private String EO;
    private final Set<Integer> Eq;
    private String FU;
    private String FV;
    private boolean FW;
    private String Fe;
    private final int kg;
    private String mName;
    private int os;
    private String qL;
    private String sJ;
    
    static
    {
      Ep.put("department", es.a.g("department", 2));
      Ep.put("description", es.a.g("description", 3));
      Ep.put("endDate", es.a.g("endDate", 4));
      Ep.put("location", es.a.g("location", 5));
      Ep.put("name", es.a.g("name", 6));
      Ep.put("primary", es.a.f("primary", 7));
      Ep.put("startDate", es.a.g("startDate", 8));
      Ep.put("title", es.a.g("title", 9));
      Ep.put("type", es.a.a("type", 10, new ep().c("work", 0).c("school", 1), false));
    }
    
    public f()
    {
      this.kg = 1;
      this.Eq = new HashSet();
    }
    
    f(Set<Integer> paramSet, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, String paramString6, String paramString7, int paramInt2)
    {
      this.Eq = paramSet;
      this.kg = paramInt1;
      this.FU = paramString1;
      this.sJ = paramString2;
      this.EO = paramString3;
      this.FV = paramString4;
      this.mName = paramString5;
      this.FW = paramBoolean;
      this.Fe = paramString6;
      this.qL = paramString7;
      this.os = paramInt2;
    }
    
    protected Object V(String paramString)
    {
      return null;
    }
    
    protected boolean W(String paramString)
    {
      return false;
    }
    
    protected boolean a(es.a parama)
    {
      return this.Eq.contains(Integer.valueOf(parama.cq()));
    }
    
    protected Object b(es.a parama)
    {
      switch (parama.cq())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.cq());
      case 2: 
        return this.FU;
      case 3: 
        return this.sJ;
      case 4: 
        return this.EO;
      case 5: 
        return this.FV;
      case 6: 
        return this.mName;
      case 7: 
        return Boolean.valueOf(this.FW);
      case 8: 
        return this.Fe;
      case 9: 
        return this.qL;
      }
      return Integer.valueOf(this.os);
    }
    
    public HashMap<String, es.a<?, ?>> cj()
    {
      return Ep;
    }
    
    public int describeContents()
    {
      io localio = CREATOR;
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
      Iterator localIterator = Ep.values().iterator();
      while (localIterator.hasNext())
      {
        es.a locala = (es.a)localIterator.next();
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
    
    public f fL()
    {
      return this;
    }
    
    Set<Integer> fa()
    {
      return this.Eq;
    }
    
    public String getDepartment()
    {
      return this.FU;
    }
    
    public String getDescription()
    {
      return this.sJ;
    }
    
    public String getEndDate()
    {
      return this.EO;
    }
    
    public String getLocation()
    {
      return this.FV;
    }
    
    public String getName()
    {
      return this.mName;
    }
    
    public String getStartDate()
    {
      return this.Fe;
    }
    
    public String getTitle()
    {
      return this.qL;
    }
    
    public int getType()
    {
      return this.os;
    }
    
    int getVersionCode()
    {
      return this.kg;
    }
    
    public boolean hasDepartment()
    {
      return this.Eq.contains(Integer.valueOf(2));
    }
    
    public boolean hasDescription()
    {
      return this.Eq.contains(Integer.valueOf(3));
    }
    
    public boolean hasEndDate()
    {
      return this.Eq.contains(Integer.valueOf(4));
    }
    
    public boolean hasLocation()
    {
      return this.Eq.contains(Integer.valueOf(5));
    }
    
    public boolean hasName()
    {
      return this.Eq.contains(Integer.valueOf(6));
    }
    
    public boolean hasPrimary()
    {
      return this.Eq.contains(Integer.valueOf(7));
    }
    
    public boolean hasStartDate()
    {
      return this.Eq.contains(Integer.valueOf(8));
    }
    
    public boolean hasTitle()
    {
      return this.Eq.contains(Integer.valueOf(9));
    }
    
    public boolean hasType()
    {
      return this.Eq.contains(Integer.valueOf(10));
    }
    
    public int hashCode()
    {
      Iterator localIterator = Ep.values().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        es.a locala = (es.a)localIterator.next();
        if (!a(locala)) {
          break label68;
        }
        int j = locala.cq();
        i = b(locala).hashCode() + (i + j);
      }
      label68:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    public boolean isDataValid()
    {
      return true;
    }
    
    public boolean isPrimary()
    {
      return this.FW;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      io localio = CREATOR;
      io.a(this, paramParcel, paramInt);
    }
  }
  
  public static final class g
    extends es
    implements SafeParcelable, Person.PlacesLived
  {
    public static final ip CREATOR = new ip();
    private static final HashMap<String, es.a<?, ?>> Ep = new HashMap();
    private final Set<Integer> Eq;
    private boolean FW;
    private final int kg;
    private String mValue;
    
    static
    {
      Ep.put("primary", es.a.f("primary", 2));
      Ep.put("value", es.a.g("value", 3));
    }
    
    public g()
    {
      this.kg = 1;
      this.Eq = new HashSet();
    }
    
    g(Set<Integer> paramSet, int paramInt, boolean paramBoolean, String paramString)
    {
      this.Eq = paramSet;
      this.kg = paramInt;
      this.FW = paramBoolean;
      this.mValue = paramString;
    }
    
    protected Object V(String paramString)
    {
      return null;
    }
    
    protected boolean W(String paramString)
    {
      return false;
    }
    
    protected boolean a(es.a parama)
    {
      return this.Eq.contains(Integer.valueOf(parama.cq()));
    }
    
    protected Object b(es.a parama)
    {
      switch (parama.cq())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.cq());
      case 2: 
        return Boolean.valueOf(this.FW);
      }
      return this.mValue;
    }
    
    public HashMap<String, es.a<?, ?>> cj()
    {
      return Ep;
    }
    
    public int describeContents()
    {
      ip localip = CREATOR;
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
      Iterator localIterator = Ep.values().iterator();
      while (localIterator.hasNext())
      {
        es.a locala = (es.a)localIterator.next();
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
    
    public g fM()
    {
      return this;
    }
    
    Set<Integer> fa()
    {
      return this.Eq;
    }
    
    public String getValue()
    {
      return this.mValue;
    }
    
    int getVersionCode()
    {
      return this.kg;
    }
    
    public boolean hasPrimary()
    {
      return this.Eq.contains(Integer.valueOf(2));
    }
    
    public boolean hasValue()
    {
      return this.Eq.contains(Integer.valueOf(3));
    }
    
    public int hashCode()
    {
      Iterator localIterator = Ep.values().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        es.a locala = (es.a)localIterator.next();
        if (!a(locala)) {
          break label68;
        }
        int j = locala.cq();
        i = b(locala).hashCode() + (i + j);
      }
      label68:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    public boolean isDataValid()
    {
      return true;
    }
    
    public boolean isPrimary()
    {
      return this.FW;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      ip localip = CREATOR;
      ip.a(this, paramParcel, paramInt);
    }
  }
  
  public static final class h
    extends es
    implements SafeParcelable, Person.Urls
  {
    public static final iq CREATOR = new iq();
    private static final HashMap<String, es.a<?, ?>> Ep = new HashMap();
    private final Set<Integer> Eq;
    private String FX;
    private final int FY = 4;
    private final int kg;
    private String mValue;
    private int os;
    
    static
    {
      Ep.put("label", es.a.g("label", 5));
      Ep.put("type", es.a.a("type", 6, new ep().c("home", 0).c("work", 1).c("blog", 2).c("profile", 3).c("other", 4).c("otherProfile", 5).c("contributor", 6).c("website", 7), false));
      Ep.put("value", es.a.g("value", 4));
    }
    
    public h()
    {
      this.kg = 2;
      this.Eq = new HashSet();
    }
    
    h(Set<Integer> paramSet, int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3)
    {
      this.Eq = paramSet;
      this.kg = paramInt1;
      this.FX = paramString1;
      this.os = paramInt2;
      this.mValue = paramString2;
    }
    
    protected Object V(String paramString)
    {
      return null;
    }
    
    protected boolean W(String paramString)
    {
      return false;
    }
    
    protected boolean a(es.a parama)
    {
      return this.Eq.contains(Integer.valueOf(parama.cq()));
    }
    
    protected Object b(es.a parama)
    {
      switch (parama.cq())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.cq());
      case 5: 
        return this.FX;
      case 6: 
        return Integer.valueOf(this.os);
      }
      return this.mValue;
    }
    
    public HashMap<String, es.a<?, ?>> cj()
    {
      return Ep;
    }
    
    public int describeContents()
    {
      iq localiq = CREATOR;
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
      Iterator localIterator = Ep.values().iterator();
      while (localIterator.hasNext())
      {
        es.a locala = (es.a)localIterator.next();
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
    
    @Deprecated
    public int fN()
    {
      return 4;
    }
    
    public h fO()
    {
      return this;
    }
    
    Set<Integer> fa()
    {
      return this.Eq;
    }
    
    public String getLabel()
    {
      return this.FX;
    }
    
    public int getType()
    {
      return this.os;
    }
    
    public String getValue()
    {
      return this.mValue;
    }
    
    int getVersionCode()
    {
      return this.kg;
    }
    
    public boolean hasLabel()
    {
      return this.Eq.contains(Integer.valueOf(5));
    }
    
    public boolean hasType()
    {
      return this.Eq.contains(Integer.valueOf(6));
    }
    
    public boolean hasValue()
    {
      return this.Eq.contains(Integer.valueOf(4));
    }
    
    public int hashCode()
    {
      Iterator localIterator = Ep.values().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        es.a locala = (es.a)localIterator.next();
        if (!a(locala)) {
          break label68;
        }
        int j = locala.cq();
        i = b(locala).hashCode() + (i + j);
      }
      label68:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    public boolean isDataValid()
    {
      return true;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      iq localiq = CREATOR;
      iq.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/ig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */