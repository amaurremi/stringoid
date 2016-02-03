package com.google.android.gms.internal;

import android.os.Parcel;
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

public final class ny
  extends jj
  implements Person
{
  public static final nz CREATOR = new nz();
  private static final HashMap<String, ji.a<?, ?>> alQ = new HashMap();
  String BL;
  final int BR;
  String Fc;
  String Nz;
  final Set<Integer> alR;
  String amP;
  a amQ;
  String amR;
  String amS;
  int amT;
  b amU;
  String amV;
  c amW;
  boolean amX;
  d amY;
  String amZ;
  int ana;
  List<f> anb;
  List<g> anc;
  int and;
  int ane;
  String anf;
  List<h> ang;
  boolean anh;
  int om;
  String uR;
  
  static
  {
    alQ.put("aboutMe", ji.a.l("aboutMe", 2));
    alQ.put("ageRange", ji.a.a("ageRange", 3, a.class));
    alQ.put("birthday", ji.a.l("birthday", 4));
    alQ.put("braggingRights", ji.a.l("braggingRights", 5));
    alQ.put("circledByCount", ji.a.i("circledByCount", 6));
    alQ.put("cover", ji.a.a("cover", 7, b.class));
    alQ.put("currentLocation", ji.a.l("currentLocation", 8));
    alQ.put("displayName", ji.a.l("displayName", 9));
    alQ.put("gender", ji.a.a("gender", 12, new jf().h("male", 0).h("female", 1).h("other", 2), false));
    alQ.put("id", ji.a.l("id", 14));
    alQ.put("image", ji.a.a("image", 15, c.class));
    alQ.put("isPlusUser", ji.a.k("isPlusUser", 16));
    alQ.put("language", ji.a.l("language", 18));
    alQ.put("name", ji.a.a("name", 19, d.class));
    alQ.put("nickname", ji.a.l("nickname", 20));
    alQ.put("objectType", ji.a.a("objectType", 21, new jf().h("person", 0).h("page", 1), false));
    alQ.put("organizations", ji.a.b("organizations", 22, f.class));
    alQ.put("placesLived", ji.a.b("placesLived", 23, g.class));
    alQ.put("plusOneCount", ji.a.i("plusOneCount", 24));
    alQ.put("relationshipStatus", ji.a.a("relationshipStatus", 25, new jf().h("single", 0).h("in_a_relationship", 1).h("engaged", 2).h("married", 3).h("its_complicated", 4).h("open_relationship", 5).h("widowed", 6).h("in_domestic_partnership", 7).h("in_civil_union", 8), false));
    alQ.put("tagline", ji.a.l("tagline", 26));
    alQ.put("url", ji.a.l("url", 27));
    alQ.put("urls", ji.a.b("urls", 28, h.class));
    alQ.put("verified", ji.a.k("verified", 29));
  }
  
  public ny()
  {
    this.BR = 1;
    this.alR = new HashSet();
  }
  
  public ny(String paramString1, String paramString2, c paramc, int paramInt, String paramString3)
  {
    this.BR = 1;
    this.alR = new HashSet();
    this.Nz = paramString1;
    this.alR.add(Integer.valueOf(9));
    this.BL = paramString2;
    this.alR.add(Integer.valueOf(14));
    this.amW = paramc;
    this.alR.add(Integer.valueOf(15));
    this.ana = paramInt;
    this.alR.add(Integer.valueOf(21));
    this.uR = paramString3;
    this.alR.add(Integer.valueOf(27));
  }
  
  ny(Set<Integer> paramSet, int paramInt1, String paramString1, a parama, String paramString2, String paramString3, int paramInt2, b paramb, String paramString4, String paramString5, int paramInt3, String paramString6, c paramc, boolean paramBoolean1, String paramString7, d paramd, String paramString8, int paramInt4, List<f> paramList, List<g> paramList1, int paramInt5, int paramInt6, String paramString9, String paramString10, List<h> paramList2, boolean paramBoolean2)
  {
    this.alR = paramSet;
    this.BR = paramInt1;
    this.amP = paramString1;
    this.amQ = parama;
    this.amR = paramString2;
    this.amS = paramString3;
    this.amT = paramInt2;
    this.amU = paramb;
    this.amV = paramString4;
    this.Nz = paramString5;
    this.om = paramInt3;
    this.BL = paramString6;
    this.amW = paramc;
    this.amX = paramBoolean1;
    this.Fc = paramString7;
    this.amY = paramd;
    this.amZ = paramString8;
    this.ana = paramInt4;
    this.anb = paramList;
    this.anc = paramList1;
    this.and = paramInt5;
    this.ane = paramInt6;
    this.anf = paramString9;
    this.uR = paramString10;
    this.ang = paramList2;
    this.anh = paramBoolean2;
  }
  
  public static ny i(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    paramArrayOfByte = CREATOR.dd(localParcel);
    localParcel.recycle();
    return paramArrayOfByte;
  }
  
  protected boolean a(ji.a parama)
  {
    return this.alR.contains(Integer.valueOf(parama.hm()));
  }
  
  protected Object b(ji.a parama)
  {
    switch (parama.hm())
    {
    case 10: 
    case 11: 
    case 13: 
    case 17: 
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.hm());
    case 2: 
      return this.amP;
    case 3: 
      return this.amQ;
    case 4: 
      return this.amR;
    case 5: 
      return this.amS;
    case 6: 
      return Integer.valueOf(this.amT);
    case 7: 
      return this.amU;
    case 8: 
      return this.amV;
    case 9: 
      return this.Nz;
    case 12: 
      return Integer.valueOf(this.om);
    case 14: 
      return this.BL;
    case 15: 
      return this.amW;
    case 16: 
      return Boolean.valueOf(this.amX);
    case 18: 
      return this.Fc;
    case 19: 
      return this.amY;
    case 20: 
      return this.amZ;
    case 21: 
      return Integer.valueOf(this.ana);
    case 22: 
      return this.anb;
    case 23: 
      return this.anc;
    case 24: 
      return Integer.valueOf(this.and);
    case 25: 
      return Integer.valueOf(this.ane);
    case 26: 
      return this.anf;
    case 27: 
      return this.uR;
    case 28: 
      return this.ang;
    }
    return Boolean.valueOf(this.anh);
  }
  
  public int describeContents()
  {
    nz localnz = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ny)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (ny)paramObject;
    Iterator localIterator = alQ.values().iterator();
    while (localIterator.hasNext())
    {
      ji.a locala = (ji.a)localIterator.next();
      if (a(locala))
      {
        if (((ny)paramObject).a(locala))
        {
          if (!b(locala).equals(((ny)paramObject).b(locala))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((ny)paramObject).a(locala)) {
        return false;
      }
    }
    return true;
  }
  
  public String getAboutMe()
  {
    return this.amP;
  }
  
  public Person.AgeRange getAgeRange()
  {
    return this.amQ;
  }
  
  public String getBirthday()
  {
    return this.amR;
  }
  
  public String getBraggingRights()
  {
    return this.amS;
  }
  
  public int getCircledByCount()
  {
    return this.amT;
  }
  
  public Person.Cover getCover()
  {
    return this.amU;
  }
  
  public String getCurrentLocation()
  {
    return this.amV;
  }
  
  public String getDisplayName()
  {
    return this.Nz;
  }
  
  public int getGender()
  {
    return this.om;
  }
  
  public String getId()
  {
    return this.BL;
  }
  
  public Person.Image getImage()
  {
    return this.amW;
  }
  
  public String getLanguage()
  {
    return this.Fc;
  }
  
  public Person.Name getName()
  {
    return this.amY;
  }
  
  public String getNickname()
  {
    return this.amZ;
  }
  
  public int getObjectType()
  {
    return this.ana;
  }
  
  public List<Person.Organizations> getOrganizations()
  {
    return (ArrayList)this.anb;
  }
  
  public List<Person.PlacesLived> getPlacesLived()
  {
    return (ArrayList)this.anc;
  }
  
  public int getPlusOneCount()
  {
    return this.and;
  }
  
  public int getRelationshipStatus()
  {
    return this.ane;
  }
  
  public String getTagline()
  {
    return this.anf;
  }
  
  public String getUrl()
  {
    return this.uR;
  }
  
  public List<Person.Urls> getUrls()
  {
    return (ArrayList)this.ang;
  }
  
  public boolean hasAboutMe()
  {
    return this.alR.contains(Integer.valueOf(2));
  }
  
  public boolean hasAgeRange()
  {
    return this.alR.contains(Integer.valueOf(3));
  }
  
  public boolean hasBirthday()
  {
    return this.alR.contains(Integer.valueOf(4));
  }
  
  public boolean hasBraggingRights()
  {
    return this.alR.contains(Integer.valueOf(5));
  }
  
  public boolean hasCircledByCount()
  {
    return this.alR.contains(Integer.valueOf(6));
  }
  
  public boolean hasCover()
  {
    return this.alR.contains(Integer.valueOf(7));
  }
  
  public boolean hasCurrentLocation()
  {
    return this.alR.contains(Integer.valueOf(8));
  }
  
  public boolean hasDisplayName()
  {
    return this.alR.contains(Integer.valueOf(9));
  }
  
  public boolean hasGender()
  {
    return this.alR.contains(Integer.valueOf(12));
  }
  
  public boolean hasId()
  {
    return this.alR.contains(Integer.valueOf(14));
  }
  
  public boolean hasImage()
  {
    return this.alR.contains(Integer.valueOf(15));
  }
  
  public boolean hasIsPlusUser()
  {
    return this.alR.contains(Integer.valueOf(16));
  }
  
  public boolean hasLanguage()
  {
    return this.alR.contains(Integer.valueOf(18));
  }
  
  public boolean hasName()
  {
    return this.alR.contains(Integer.valueOf(19));
  }
  
  public boolean hasNickname()
  {
    return this.alR.contains(Integer.valueOf(20));
  }
  
  public boolean hasObjectType()
  {
    return this.alR.contains(Integer.valueOf(21));
  }
  
  public boolean hasOrganizations()
  {
    return this.alR.contains(Integer.valueOf(22));
  }
  
  public boolean hasPlacesLived()
  {
    return this.alR.contains(Integer.valueOf(23));
  }
  
  public boolean hasPlusOneCount()
  {
    return this.alR.contains(Integer.valueOf(24));
  }
  
  public boolean hasRelationshipStatus()
  {
    return this.alR.contains(Integer.valueOf(25));
  }
  
  public boolean hasTagline()
  {
    return this.alR.contains(Integer.valueOf(26));
  }
  
  public boolean hasUrl()
  {
    return this.alR.contains(Integer.valueOf(27));
  }
  
  public boolean hasUrls()
  {
    return this.alR.contains(Integer.valueOf(28));
  }
  
  public boolean hasVerified()
  {
    return this.alR.contains(Integer.valueOf(29));
  }
  
  public int hashCode()
  {
    Iterator localIterator = alQ.values().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      ji.a locala = (ji.a)localIterator.next();
      if (!a(locala)) {
        break label68;
      }
      int j = locala.hm();
      i = b(locala).hashCode() + (i + j);
    }
    label68:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public HashMap<String, ji.a<?, ?>> hf()
  {
    return alQ;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public boolean isPlusUser()
  {
    return this.amX;
  }
  
  public boolean isVerified()
  {
    return this.anh;
  }
  
  public ny ns()
  {
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    nz localnz = CREATOR;
    nz.a(this, paramParcel, paramInt);
  }
  
  public static final class a
    extends jj
    implements Person.AgeRange
  {
    public static final oa CREATOR = new oa();
    private static final HashMap<String, ji.a<?, ?>> alQ = new HashMap();
    final int BR;
    final Set<Integer> alR;
    int ani;
    int anj;
    
    static
    {
      alQ.put("max", ji.a.i("max", 2));
      alQ.put("min", ji.a.i("min", 3));
    }
    
    public a()
    {
      this.BR = 1;
      this.alR = new HashSet();
    }
    
    a(Set<Integer> paramSet, int paramInt1, int paramInt2, int paramInt3)
    {
      this.alR = paramSet;
      this.BR = paramInt1;
      this.ani = paramInt2;
      this.anj = paramInt3;
    }
    
    protected boolean a(ji.a parama)
    {
      return this.alR.contains(Integer.valueOf(parama.hm()));
    }
    
    protected Object b(ji.a parama)
    {
      switch (parama.hm())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.hm());
      case 2: 
        return Integer.valueOf(this.ani);
      }
      return Integer.valueOf(this.anj);
    }
    
    public int describeContents()
    {
      oa localoa = CREATOR;
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
      Iterator localIterator = alQ.values().iterator();
      while (localIterator.hasNext())
      {
        ji.a locala = (ji.a)localIterator.next();
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
      return this.ani;
    }
    
    public int getMin()
    {
      return this.anj;
    }
    
    public boolean hasMax()
    {
      return this.alR.contains(Integer.valueOf(2));
    }
    
    public boolean hasMin()
    {
      return this.alR.contains(Integer.valueOf(3));
    }
    
    public int hashCode()
    {
      Iterator localIterator = alQ.values().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        ji.a locala = (ji.a)localIterator.next();
        if (!a(locala)) {
          break label68;
        }
        int j = locala.hm();
        i = b(locala).hashCode() + (i + j);
      }
      label68:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    public HashMap<String, ji.a<?, ?>> hf()
    {
      return alQ;
    }
    
    public boolean isDataValid()
    {
      return true;
    }
    
    public a nt()
    {
      return this;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      oa localoa = CREATOR;
      oa.a(this, paramParcel, paramInt);
    }
  }
  
  public static final class b
    extends jj
    implements Person.Cover
  {
    public static final ob CREATOR = new ob();
    private static final HashMap<String, ji.a<?, ?>> alQ = new HashMap();
    final int BR;
    final Set<Integer> alR;
    a ank;
    b anl;
    int anm;
    
    static
    {
      alQ.put("coverInfo", ji.a.a("coverInfo", 2, a.class));
      alQ.put("coverPhoto", ji.a.a("coverPhoto", 3, b.class));
      alQ.put("layout", ji.a.a("layout", 4, new jf().h("banner", 0), false));
    }
    
    public b()
    {
      this.BR = 1;
      this.alR = new HashSet();
    }
    
    b(Set<Integer> paramSet, int paramInt1, a parama, b paramb, int paramInt2)
    {
      this.alR = paramSet;
      this.BR = paramInt1;
      this.ank = parama;
      this.anl = paramb;
      this.anm = paramInt2;
    }
    
    protected boolean a(ji.a parama)
    {
      return this.alR.contains(Integer.valueOf(parama.hm()));
    }
    
    protected Object b(ji.a parama)
    {
      switch (parama.hm())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.hm());
      case 2: 
        return this.ank;
      case 3: 
        return this.anl;
      }
      return Integer.valueOf(this.anm);
    }
    
    public int describeContents()
    {
      ob localob = CREATOR;
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
      Iterator localIterator = alQ.values().iterator();
      while (localIterator.hasNext())
      {
        ji.a locala = (ji.a)localIterator.next();
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
    
    public Person.Cover.CoverInfo getCoverInfo()
    {
      return this.ank;
    }
    
    public Person.Cover.CoverPhoto getCoverPhoto()
    {
      return this.anl;
    }
    
    public int getLayout()
    {
      return this.anm;
    }
    
    public boolean hasCoverInfo()
    {
      return this.alR.contains(Integer.valueOf(2));
    }
    
    public boolean hasCoverPhoto()
    {
      return this.alR.contains(Integer.valueOf(3));
    }
    
    public boolean hasLayout()
    {
      return this.alR.contains(Integer.valueOf(4));
    }
    
    public int hashCode()
    {
      Iterator localIterator = alQ.values().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        ji.a locala = (ji.a)localIterator.next();
        if (!a(locala)) {
          break label68;
        }
        int j = locala.hm();
        i = b(locala).hashCode() + (i + j);
      }
      label68:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    public HashMap<String, ji.a<?, ?>> hf()
    {
      return alQ;
    }
    
    public boolean isDataValid()
    {
      return true;
    }
    
    public b nu()
    {
      return this;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      ob localob = CREATOR;
      ob.a(this, paramParcel, paramInt);
    }
    
    public static final class a
      extends jj
      implements Person.Cover.CoverInfo
    {
      public static final oc CREATOR = new oc();
      private static final HashMap<String, ji.a<?, ?>> alQ = new HashMap();
      final int BR;
      final Set<Integer> alR;
      int ann;
      int ano;
      
      static
      {
        alQ.put("leftImageOffset", ji.a.i("leftImageOffset", 2));
        alQ.put("topImageOffset", ji.a.i("topImageOffset", 3));
      }
      
      public a()
      {
        this.BR = 1;
        this.alR = new HashSet();
      }
      
      a(Set<Integer> paramSet, int paramInt1, int paramInt2, int paramInt3)
      {
        this.alR = paramSet;
        this.BR = paramInt1;
        this.ann = paramInt2;
        this.ano = paramInt3;
      }
      
      protected boolean a(ji.a parama)
      {
        return this.alR.contains(Integer.valueOf(parama.hm()));
      }
      
      protected Object b(ji.a parama)
      {
        switch (parama.hm())
        {
        default: 
          throw new IllegalStateException("Unknown safe parcelable id=" + parama.hm());
        case 2: 
          return Integer.valueOf(this.ann);
        }
        return Integer.valueOf(this.ano);
      }
      
      public int describeContents()
      {
        oc localoc = CREATOR;
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
        Iterator localIterator = alQ.values().iterator();
        while (localIterator.hasNext())
        {
          ji.a locala = (ji.a)localIterator.next();
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
      
      public int getLeftImageOffset()
      {
        return this.ann;
      }
      
      public int getTopImageOffset()
      {
        return this.ano;
      }
      
      public boolean hasLeftImageOffset()
      {
        return this.alR.contains(Integer.valueOf(2));
      }
      
      public boolean hasTopImageOffset()
      {
        return this.alR.contains(Integer.valueOf(3));
      }
      
      public int hashCode()
      {
        Iterator localIterator = alQ.values().iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          ji.a locala = (ji.a)localIterator.next();
          if (!a(locala)) {
            break label68;
          }
          int j = locala.hm();
          i = b(locala).hashCode() + (i + j);
        }
        label68:
        for (;;)
        {
          break;
          return i;
        }
      }
      
      public HashMap<String, ji.a<?, ?>> hf()
      {
        return alQ;
      }
      
      public boolean isDataValid()
      {
        return true;
      }
      
      public a nv()
      {
        return this;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        oc localoc = CREATOR;
        oc.a(this, paramParcel, paramInt);
      }
    }
    
    public static final class b
      extends jj
      implements Person.Cover.CoverPhoto
    {
      public static final od CREATOR = new od();
      private static final HashMap<String, ji.a<?, ?>> alQ = new HashMap();
      final int BR;
      final Set<Integer> alR;
      int lf;
      int lg;
      String uR;
      
      static
      {
        alQ.put("height", ji.a.i("height", 2));
        alQ.put("url", ji.a.l("url", 3));
        alQ.put("width", ji.a.i("width", 4));
      }
      
      public b()
      {
        this.BR = 1;
        this.alR = new HashSet();
      }
      
      b(Set<Integer> paramSet, int paramInt1, int paramInt2, String paramString, int paramInt3)
      {
        this.alR = paramSet;
        this.BR = paramInt1;
        this.lg = paramInt2;
        this.uR = paramString;
        this.lf = paramInt3;
      }
      
      protected boolean a(ji.a parama)
      {
        return this.alR.contains(Integer.valueOf(parama.hm()));
      }
      
      protected Object b(ji.a parama)
      {
        switch (parama.hm())
        {
        default: 
          throw new IllegalStateException("Unknown safe parcelable id=" + parama.hm());
        case 2: 
          return Integer.valueOf(this.lg);
        case 3: 
          return this.uR;
        }
        return Integer.valueOf(this.lf);
      }
      
      public int describeContents()
      {
        od localod = CREATOR;
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
        Iterator localIterator = alQ.values().iterator();
        while (localIterator.hasNext())
        {
          ji.a locala = (ji.a)localIterator.next();
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
        return this.lg;
      }
      
      public String getUrl()
      {
        return this.uR;
      }
      
      public int getWidth()
      {
        return this.lf;
      }
      
      public boolean hasHeight()
      {
        return this.alR.contains(Integer.valueOf(2));
      }
      
      public boolean hasUrl()
      {
        return this.alR.contains(Integer.valueOf(3));
      }
      
      public boolean hasWidth()
      {
        return this.alR.contains(Integer.valueOf(4));
      }
      
      public int hashCode()
      {
        Iterator localIterator = alQ.values().iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          ji.a locala = (ji.a)localIterator.next();
          if (!a(locala)) {
            break label68;
          }
          int j = locala.hm();
          i = b(locala).hashCode() + (i + j);
        }
        label68:
        for (;;)
        {
          break;
          return i;
        }
      }
      
      public HashMap<String, ji.a<?, ?>> hf()
      {
        return alQ;
      }
      
      public boolean isDataValid()
      {
        return true;
      }
      
      public b nw()
      {
        return this;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        od localod = CREATOR;
        od.a(this, paramParcel, paramInt);
      }
    }
  }
  
  public static final class c
    extends jj
    implements Person.Image
  {
    public static final oe CREATOR = new oe();
    private static final HashMap<String, ji.a<?, ?>> alQ = new HashMap();
    final int BR;
    final Set<Integer> alR;
    String uR;
    
    static
    {
      alQ.put("url", ji.a.l("url", 2));
    }
    
    public c()
    {
      this.BR = 1;
      this.alR = new HashSet();
    }
    
    public c(String paramString)
    {
      this.alR = new HashSet();
      this.BR = 1;
      this.uR = paramString;
      this.alR.add(Integer.valueOf(2));
    }
    
    c(Set<Integer> paramSet, int paramInt, String paramString)
    {
      this.alR = paramSet;
      this.BR = paramInt;
      this.uR = paramString;
    }
    
    protected boolean a(ji.a parama)
    {
      return this.alR.contains(Integer.valueOf(parama.hm()));
    }
    
    protected Object b(ji.a parama)
    {
      switch (parama.hm())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.hm());
      }
      return this.uR;
    }
    
    public int describeContents()
    {
      oe localoe = CREATOR;
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
      Iterator localIterator = alQ.values().iterator();
      while (localIterator.hasNext())
      {
        ji.a locala = (ji.a)localIterator.next();
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
      return this.uR;
    }
    
    public boolean hasUrl()
    {
      return this.alR.contains(Integer.valueOf(2));
    }
    
    public int hashCode()
    {
      Iterator localIterator = alQ.values().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        ji.a locala = (ji.a)localIterator.next();
        if (!a(locala)) {
          break label68;
        }
        int j = locala.hm();
        i = b(locala).hashCode() + (i + j);
      }
      label68:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    public HashMap<String, ji.a<?, ?>> hf()
    {
      return alQ;
    }
    
    public boolean isDataValid()
    {
      return true;
    }
    
    public c nx()
    {
      return this;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      oe localoe = CREATOR;
      oe.a(this, paramParcel, paramInt);
    }
  }
  
  public static final class d
    extends jj
    implements Person.Name
  {
    public static final of CREATOR = new of();
    private static final HashMap<String, ji.a<?, ?>> alQ = new HashMap();
    final int BR;
    final Set<Integer> alR;
    String amp;
    String ams;
    String anp;
    String anq;
    String anr;
    String ans;
    
    static
    {
      alQ.put("familyName", ji.a.l("familyName", 2));
      alQ.put("formatted", ji.a.l("formatted", 3));
      alQ.put("givenName", ji.a.l("givenName", 4));
      alQ.put("honorificPrefix", ji.a.l("honorificPrefix", 5));
      alQ.put("honorificSuffix", ji.a.l("honorificSuffix", 6));
      alQ.put("middleName", ji.a.l("middleName", 7));
    }
    
    public d()
    {
      this.BR = 1;
      this.alR = new HashSet();
    }
    
    d(Set<Integer> paramSet, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    {
      this.alR = paramSet;
      this.BR = paramInt;
      this.amp = paramString1;
      this.anp = paramString2;
      this.ams = paramString3;
      this.anq = paramString4;
      this.anr = paramString5;
      this.ans = paramString6;
    }
    
    protected boolean a(ji.a parama)
    {
      return this.alR.contains(Integer.valueOf(parama.hm()));
    }
    
    protected Object b(ji.a parama)
    {
      switch (parama.hm())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.hm());
      case 2: 
        return this.amp;
      case 3: 
        return this.anp;
      case 4: 
        return this.ams;
      case 5: 
        return this.anq;
      case 6: 
        return this.anr;
      }
      return this.ans;
    }
    
    public int describeContents()
    {
      of localof = CREATOR;
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
      Iterator localIterator = alQ.values().iterator();
      while (localIterator.hasNext())
      {
        ji.a locala = (ji.a)localIterator.next();
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
    
    public String getFamilyName()
    {
      return this.amp;
    }
    
    public String getFormatted()
    {
      return this.anp;
    }
    
    public String getGivenName()
    {
      return this.ams;
    }
    
    public String getHonorificPrefix()
    {
      return this.anq;
    }
    
    public String getHonorificSuffix()
    {
      return this.anr;
    }
    
    public String getMiddleName()
    {
      return this.ans;
    }
    
    public boolean hasFamilyName()
    {
      return this.alR.contains(Integer.valueOf(2));
    }
    
    public boolean hasFormatted()
    {
      return this.alR.contains(Integer.valueOf(3));
    }
    
    public boolean hasGivenName()
    {
      return this.alR.contains(Integer.valueOf(4));
    }
    
    public boolean hasHonorificPrefix()
    {
      return this.alR.contains(Integer.valueOf(5));
    }
    
    public boolean hasHonorificSuffix()
    {
      return this.alR.contains(Integer.valueOf(6));
    }
    
    public boolean hasMiddleName()
    {
      return this.alR.contains(Integer.valueOf(7));
    }
    
    public int hashCode()
    {
      Iterator localIterator = alQ.values().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        ji.a locala = (ji.a)localIterator.next();
        if (!a(locala)) {
          break label68;
        }
        int j = locala.hm();
        i = b(locala).hashCode() + (i + j);
      }
      label68:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    public HashMap<String, ji.a<?, ?>> hf()
    {
      return alQ;
    }
    
    public boolean isDataValid()
    {
      return true;
    }
    
    public d ny()
    {
      return this;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      of localof = CREATOR;
      of.a(this, paramParcel, paramInt);
    }
  }
  
  public static class e
  {
    public static int cf(String paramString)
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
    extends jj
    implements Person.Organizations
  {
    public static final og CREATOR = new og();
    private static final HashMap<String, ji.a<?, ?>> alQ = new HashMap();
    final int BR;
    int FD;
    String No;
    String Tg;
    final Set<Integer> alR;
    String amE;
    String amo;
    String ant;
    String anu;
    boolean anv;
    String mName;
    
    static
    {
      alQ.put("department", ji.a.l("department", 2));
      alQ.put("description", ji.a.l("description", 3));
      alQ.put("endDate", ji.a.l("endDate", 4));
      alQ.put("location", ji.a.l("location", 5));
      alQ.put("name", ji.a.l("name", 6));
      alQ.put("primary", ji.a.k("primary", 7));
      alQ.put("startDate", ji.a.l("startDate", 8));
      alQ.put("title", ji.a.l("title", 9));
      alQ.put("type", ji.a.a("type", 10, new jf().h("work", 0).h("school", 1), false));
    }
    
    public f()
    {
      this.BR = 1;
      this.alR = new HashSet();
    }
    
    f(Set<Integer> paramSet, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, String paramString6, String paramString7, int paramInt2)
    {
      this.alR = paramSet;
      this.BR = paramInt1;
      this.ant = paramString1;
      this.Tg = paramString2;
      this.amo = paramString3;
      this.anu = paramString4;
      this.mName = paramString5;
      this.anv = paramBoolean;
      this.amE = paramString6;
      this.No = paramString7;
      this.FD = paramInt2;
    }
    
    protected boolean a(ji.a parama)
    {
      return this.alR.contains(Integer.valueOf(parama.hm()));
    }
    
    protected Object b(ji.a parama)
    {
      switch (parama.hm())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.hm());
      case 2: 
        return this.ant;
      case 3: 
        return this.Tg;
      case 4: 
        return this.amo;
      case 5: 
        return this.anu;
      case 6: 
        return this.mName;
      case 7: 
        return Boolean.valueOf(this.anv);
      case 8: 
        return this.amE;
      case 9: 
        return this.No;
      }
      return Integer.valueOf(this.FD);
    }
    
    public int describeContents()
    {
      og localog = CREATOR;
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
      Iterator localIterator = alQ.values().iterator();
      while (localIterator.hasNext())
      {
        ji.a locala = (ji.a)localIterator.next();
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
    
    public String getDepartment()
    {
      return this.ant;
    }
    
    public String getDescription()
    {
      return this.Tg;
    }
    
    public String getEndDate()
    {
      return this.amo;
    }
    
    public String getLocation()
    {
      return this.anu;
    }
    
    public String getName()
    {
      return this.mName;
    }
    
    public String getStartDate()
    {
      return this.amE;
    }
    
    public String getTitle()
    {
      return this.No;
    }
    
    public int getType()
    {
      return this.FD;
    }
    
    public boolean hasDepartment()
    {
      return this.alR.contains(Integer.valueOf(2));
    }
    
    public boolean hasDescription()
    {
      return this.alR.contains(Integer.valueOf(3));
    }
    
    public boolean hasEndDate()
    {
      return this.alR.contains(Integer.valueOf(4));
    }
    
    public boolean hasLocation()
    {
      return this.alR.contains(Integer.valueOf(5));
    }
    
    public boolean hasName()
    {
      return this.alR.contains(Integer.valueOf(6));
    }
    
    public boolean hasPrimary()
    {
      return this.alR.contains(Integer.valueOf(7));
    }
    
    public boolean hasStartDate()
    {
      return this.alR.contains(Integer.valueOf(8));
    }
    
    public boolean hasTitle()
    {
      return this.alR.contains(Integer.valueOf(9));
    }
    
    public boolean hasType()
    {
      return this.alR.contains(Integer.valueOf(10));
    }
    
    public int hashCode()
    {
      Iterator localIterator = alQ.values().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        ji.a locala = (ji.a)localIterator.next();
        if (!a(locala)) {
          break label68;
        }
        int j = locala.hm();
        i = b(locala).hashCode() + (i + j);
      }
      label68:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    public HashMap<String, ji.a<?, ?>> hf()
    {
      return alQ;
    }
    
    public boolean isDataValid()
    {
      return true;
    }
    
    public boolean isPrimary()
    {
      return this.anv;
    }
    
    public f nz()
    {
      return this;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      og localog = CREATOR;
      og.a(this, paramParcel, paramInt);
    }
  }
  
  public static final class g
    extends jj
    implements Person.PlacesLived
  {
    public static final oh CREATOR = new oh();
    private static final HashMap<String, ji.a<?, ?>> alQ = new HashMap();
    final int BR;
    final Set<Integer> alR;
    boolean anv;
    String mValue;
    
    static
    {
      alQ.put("primary", ji.a.k("primary", 2));
      alQ.put("value", ji.a.l("value", 3));
    }
    
    public g()
    {
      this.BR = 1;
      this.alR = new HashSet();
    }
    
    g(Set<Integer> paramSet, int paramInt, boolean paramBoolean, String paramString)
    {
      this.alR = paramSet;
      this.BR = paramInt;
      this.anv = paramBoolean;
      this.mValue = paramString;
    }
    
    protected boolean a(ji.a parama)
    {
      return this.alR.contains(Integer.valueOf(parama.hm()));
    }
    
    protected Object b(ji.a parama)
    {
      switch (parama.hm())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.hm());
      case 2: 
        return Boolean.valueOf(this.anv);
      }
      return this.mValue;
    }
    
    public int describeContents()
    {
      oh localoh = CREATOR;
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
      Iterator localIterator = alQ.values().iterator();
      while (localIterator.hasNext())
      {
        ji.a locala = (ji.a)localIterator.next();
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
    
    public boolean hasPrimary()
    {
      return this.alR.contains(Integer.valueOf(2));
    }
    
    public boolean hasValue()
    {
      return this.alR.contains(Integer.valueOf(3));
    }
    
    public int hashCode()
    {
      Iterator localIterator = alQ.values().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        ji.a locala = (ji.a)localIterator.next();
        if (!a(locala)) {
          break label68;
        }
        int j = locala.hm();
        i = b(locala).hashCode() + (i + j);
      }
      label68:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    public HashMap<String, ji.a<?, ?>> hf()
    {
      return alQ;
    }
    
    public boolean isDataValid()
    {
      return true;
    }
    
    public boolean isPrimary()
    {
      return this.anv;
    }
    
    public g nA()
    {
      return this;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      oh localoh = CREATOR;
      oh.a(this, paramParcel, paramInt);
    }
  }
  
  public static final class h
    extends jj
    implements Person.Urls
  {
    public static final oi CREATOR = new oi();
    private static final HashMap<String, ji.a<?, ?>> alQ = new HashMap();
    final int BR;
    int FD;
    final Set<Integer> alR;
    String anw;
    private final int anx = 4;
    String mValue;
    
    static
    {
      alQ.put("label", ji.a.l("label", 5));
      alQ.put("type", ji.a.a("type", 6, new jf().h("home", 0).h("work", 1).h("blog", 2).h("profile", 3).h("other", 4).h("otherProfile", 5).h("contributor", 6).h("website", 7), false));
      alQ.put("value", ji.a.l("value", 4));
    }
    
    public h()
    {
      this.BR = 1;
      this.alR = new HashSet();
    }
    
    h(Set<Integer> paramSet, int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3)
    {
      this.alR = paramSet;
      this.BR = paramInt1;
      this.anw = paramString1;
      this.FD = paramInt2;
      this.mValue = paramString2;
    }
    
    protected boolean a(ji.a parama)
    {
      return this.alR.contains(Integer.valueOf(parama.hm()));
    }
    
    protected Object b(ji.a parama)
    {
      switch (parama.hm())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.hm());
      case 5: 
        return this.anw;
      case 6: 
        return Integer.valueOf(this.FD);
      }
      return this.mValue;
    }
    
    public int describeContents()
    {
      oi localoi = CREATOR;
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
      Iterator localIterator = alQ.values().iterator();
      while (localIterator.hasNext())
      {
        ji.a locala = (ji.a)localIterator.next();
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
      return this.anw;
    }
    
    public int getType()
    {
      return this.FD;
    }
    
    public String getValue()
    {
      return this.mValue;
    }
    
    public boolean hasLabel()
    {
      return this.alR.contains(Integer.valueOf(5));
    }
    
    public boolean hasType()
    {
      return this.alR.contains(Integer.valueOf(6));
    }
    
    public boolean hasValue()
    {
      return this.alR.contains(Integer.valueOf(4));
    }
    
    public int hashCode()
    {
      Iterator localIterator = alQ.values().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        ji.a locala = (ji.a)localIterator.next();
        if (!a(locala)) {
          break label68;
        }
        int j = locala.hm();
        i = b(locala).hashCode() + (i + j);
      }
      label68:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    public HashMap<String, ji.a<?, ?>> hf()
    {
      return alQ;
    }
    
    public boolean isDataValid()
    {
      return true;
    }
    
    @Deprecated
    public int nB()
    {
      return 4;
    }
    
    public h nC()
    {
      return this;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      oi localoi = CREATOR;
      oi.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/ny.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */