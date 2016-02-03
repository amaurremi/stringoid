package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.Person.AgeRange;
import com.google.android.gms.plus.model.people.Person.Cover;
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

public final class ks
  extends hy
  implements SafeParcelable, Person
{
  public static final kt CREATOR = new kt();
  private static final HashMap<String, hy.a<?, ?>> acr = new HashMap();
  private String Ar;
  private String Ln;
  private final Set<Integer> acs;
  private String adA;
  private int adB;
  private List<ks.f> adC;
  private List<ks.g> adD;
  private int adE;
  private int adF;
  private String adG;
  private List<ks.h> adH;
  private boolean adI;
  private String adq;
  private ks.a adr;
  private String ads;
  private String adt;
  private int adu;
  private ks.b adv;
  private String adw;
  private ks.c adx;
  private boolean ady;
  private ks.d adz;
  private int ml;
  private String qY;
  private String xG;
  private final int xM;
  
  static
  {
    acr.put("aboutMe", hy.a.j("aboutMe", 2));
    acr.put("ageRange", hy.a.a("ageRange", 3, ks.a.class));
    acr.put("birthday", hy.a.j("birthday", 4));
    acr.put("braggingRights", hy.a.j("braggingRights", 5));
    acr.put("circledByCount", hy.a.g("circledByCount", 6));
    acr.put("cover", hy.a.a("cover", 7, ks.b.class));
    acr.put("currentLocation", hy.a.j("currentLocation", 8));
    acr.put("displayName", hy.a.j("displayName", 9));
    acr.put("gender", hy.a.a("gender", 12, new hv().f("male", 0).f("female", 1).f("other", 2), false));
    acr.put("id", hy.a.j("id", 14));
    acr.put("image", hy.a.a("image", 15, ks.c.class));
    acr.put("isPlusUser", hy.a.i("isPlusUser", 16));
    acr.put("language", hy.a.j("language", 18));
    acr.put("name", hy.a.a("name", 19, ks.d.class));
    acr.put("nickname", hy.a.j("nickname", 20));
    acr.put("objectType", hy.a.a("objectType", 21, new hv().f("person", 0).f("page", 1), false));
    acr.put("organizations", hy.a.b("organizations", 22, ks.f.class));
    acr.put("placesLived", hy.a.b("placesLived", 23, ks.g.class));
    acr.put("plusOneCount", hy.a.g("plusOneCount", 24));
    acr.put("relationshipStatus", hy.a.a("relationshipStatus", 25, new hv().f("single", 0).f("in_a_relationship", 1).f("engaged", 2).f("married", 3).f("its_complicated", 4).f("open_relationship", 5).f("widowed", 6).f("in_domestic_partnership", 7).f("in_civil_union", 8), false));
    acr.put("tagline", hy.a.j("tagline", 26));
    acr.put("url", hy.a.j("url", 27));
    acr.put("urls", hy.a.b("urls", 28, ks.h.class));
    acr.put("verified", hy.a.i("verified", 29));
  }
  
  public ks()
  {
    this.xM = 2;
    this.acs = new HashSet();
  }
  
  public ks(String paramString1, String paramString2, ks.c paramc, int paramInt, String paramString3)
  {
    this.xM = 2;
    this.acs = new HashSet();
    this.Ln = paramString1;
    this.acs.add(Integer.valueOf(9));
    this.xG = paramString2;
    this.acs.add(Integer.valueOf(14));
    this.adx = paramc;
    this.acs.add(Integer.valueOf(15));
    this.adB = paramInt;
    this.acs.add(Integer.valueOf(21));
    this.qY = paramString3;
    this.acs.add(Integer.valueOf(27));
  }
  
  ks(Set<Integer> paramSet, int paramInt1, String paramString1, ks.a parama, String paramString2, String paramString3, int paramInt2, ks.b paramb, String paramString4, String paramString5, int paramInt3, String paramString6, ks.c paramc, boolean paramBoolean1, String paramString7, ks.d paramd, String paramString8, int paramInt4, List<ks.f> paramList, List<ks.g> paramList1, int paramInt5, int paramInt6, String paramString9, String paramString10, List<ks.h> paramList2, boolean paramBoolean2)
  {
    this.acs = paramSet;
    this.xM = paramInt1;
    this.adq = paramString1;
    this.adr = parama;
    this.ads = paramString2;
    this.adt = paramString3;
    this.adu = paramInt2;
    this.adv = paramb;
    this.adw = paramString4;
    this.Ln = paramString5;
    this.ml = paramInt3;
    this.xG = paramString6;
    this.adx = paramc;
    this.ady = paramBoolean1;
    this.Ar = paramString7;
    this.adz = paramd;
    this.adA = paramString8;
    this.adB = paramInt4;
    this.adC = paramList;
    this.adD = paramList1;
    this.adE = paramInt5;
    this.adF = paramInt6;
    this.adG = paramString9;
    this.qY = paramString10;
    this.adH = paramList2;
    this.adI = paramBoolean2;
  }
  
  public static ks i(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    paramArrayOfByte = CREATOR.bG(localParcel);
    localParcel.recycle();
    return paramArrayOfByte;
  }
  
  protected boolean a(hy.a parama)
  {
    return this.acs.contains(Integer.valueOf(parama.fN()));
  }
  
  protected Object aF(String paramString)
  {
    return null;
  }
  
  protected boolean aG(String paramString)
  {
    return false;
  }
  
  protected Object b(hy.a parama)
  {
    switch (parama.fN())
    {
    case 10: 
    case 11: 
    case 13: 
    case 17: 
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.fN());
    case 2: 
      return this.adq;
    case 3: 
      return this.adr;
    case 4: 
      return this.ads;
    case 5: 
      return this.adt;
    case 6: 
      return Integer.valueOf(this.adu);
    case 7: 
      return this.adv;
    case 8: 
      return this.adw;
    case 9: 
      return this.Ln;
    case 12: 
      return Integer.valueOf(this.ml);
    case 14: 
      return this.xG;
    case 15: 
      return this.adx;
    case 16: 
      return Boolean.valueOf(this.ady);
    case 18: 
      return this.Ar;
    case 19: 
      return this.adz;
    case 20: 
      return this.adA;
    case 21: 
      return Integer.valueOf(this.adB);
    case 22: 
      return this.adC;
    case 23: 
      return this.adD;
    case 24: 
      return Integer.valueOf(this.adE);
    case 25: 
      return Integer.valueOf(this.adF);
    case 26: 
      return this.adG;
    case 27: 
      return this.qY;
    case 28: 
      return this.adH;
    }
    return Boolean.valueOf(this.adI);
  }
  
  public int describeContents()
  {
    kt localkt = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ks)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (ks)paramObject;
    Iterator localIterator = acr.values().iterator();
    while (localIterator.hasNext())
    {
      hy.a locala = (hy.a)localIterator.next();
      if (a(locala))
      {
        if (((ks)paramObject).a(locala))
        {
          if (!b(locala).equals(((ks)paramObject).b(locala))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((ks)paramObject).a(locala)) {
        return false;
      }
    }
    return true;
  }
  
  public HashMap<String, hy.a<?, ?>> fG()
  {
    return acr;
  }
  
  public String getAboutMe()
  {
    return this.adq;
  }
  
  public Person.AgeRange getAgeRange()
  {
    return this.adr;
  }
  
  public String getBirthday()
  {
    return this.ads;
  }
  
  public String getBraggingRights()
  {
    return this.adt;
  }
  
  public int getCircledByCount()
  {
    return this.adu;
  }
  
  public Person.Cover getCover()
  {
    return this.adv;
  }
  
  public String getCurrentLocation()
  {
    return this.adw;
  }
  
  public String getDisplayName()
  {
    return this.Ln;
  }
  
  public int getGender()
  {
    return this.ml;
  }
  
  public String getId()
  {
    return this.xG;
  }
  
  public Person.Image getImage()
  {
    return this.adx;
  }
  
  public String getLanguage()
  {
    return this.Ar;
  }
  
  public Person.Name getName()
  {
    return this.adz;
  }
  
  public String getNickname()
  {
    return this.adA;
  }
  
  public int getObjectType()
  {
    return this.adB;
  }
  
  public List<Person.Organizations> getOrganizations()
  {
    return (ArrayList)this.adC;
  }
  
  public List<Person.PlacesLived> getPlacesLived()
  {
    return (ArrayList)this.adD;
  }
  
  public int getPlusOneCount()
  {
    return this.adE;
  }
  
  public int getRelationshipStatus()
  {
    return this.adF;
  }
  
  public String getTagline()
  {
    return this.adG;
  }
  
  public String getUrl()
  {
    return this.qY;
  }
  
  public List<Person.Urls> getUrls()
  {
    return (ArrayList)this.adH;
  }
  
  int getVersionCode()
  {
    return this.xM;
  }
  
  public boolean hasAboutMe()
  {
    return this.acs.contains(Integer.valueOf(2));
  }
  
  public boolean hasAgeRange()
  {
    return this.acs.contains(Integer.valueOf(3));
  }
  
  public boolean hasBirthday()
  {
    return this.acs.contains(Integer.valueOf(4));
  }
  
  public boolean hasBraggingRights()
  {
    return this.acs.contains(Integer.valueOf(5));
  }
  
  public boolean hasCircledByCount()
  {
    return this.acs.contains(Integer.valueOf(6));
  }
  
  public boolean hasCover()
  {
    return this.acs.contains(Integer.valueOf(7));
  }
  
  public boolean hasCurrentLocation()
  {
    return this.acs.contains(Integer.valueOf(8));
  }
  
  public boolean hasDisplayName()
  {
    return this.acs.contains(Integer.valueOf(9));
  }
  
  public boolean hasGender()
  {
    return this.acs.contains(Integer.valueOf(12));
  }
  
  public boolean hasId()
  {
    return this.acs.contains(Integer.valueOf(14));
  }
  
  public boolean hasImage()
  {
    return this.acs.contains(Integer.valueOf(15));
  }
  
  public boolean hasIsPlusUser()
  {
    return this.acs.contains(Integer.valueOf(16));
  }
  
  public boolean hasLanguage()
  {
    return this.acs.contains(Integer.valueOf(18));
  }
  
  public boolean hasName()
  {
    return this.acs.contains(Integer.valueOf(19));
  }
  
  public boolean hasNickname()
  {
    return this.acs.contains(Integer.valueOf(20));
  }
  
  public boolean hasObjectType()
  {
    return this.acs.contains(Integer.valueOf(21));
  }
  
  public boolean hasOrganizations()
  {
    return this.acs.contains(Integer.valueOf(22));
  }
  
  public boolean hasPlacesLived()
  {
    return this.acs.contains(Integer.valueOf(23));
  }
  
  public boolean hasPlusOneCount()
  {
    return this.acs.contains(Integer.valueOf(24));
  }
  
  public boolean hasRelationshipStatus()
  {
    return this.acs.contains(Integer.valueOf(25));
  }
  
  public boolean hasTagline()
  {
    return this.acs.contains(Integer.valueOf(26));
  }
  
  public boolean hasUrl()
  {
    return this.acs.contains(Integer.valueOf(27));
  }
  
  public boolean hasUrls()
  {
    return this.acs.contains(Integer.valueOf(28));
  }
  
  public boolean hasVerified()
  {
    return this.acs.contains(Integer.valueOf(29));
  }
  
  public int hashCode()
  {
    Iterator localIterator = acr.values().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      hy.a locala = (hy.a)localIterator.next();
      if (!a(locala)) {
        break label68;
      }
      int j = locala.fN();
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
    return this.ady;
  }
  
  public boolean isVerified()
  {
    return this.adI;
  }
  
  ks.a kF()
  {
    return this.adr;
  }
  
  ks.b kG()
  {
    return this.adv;
  }
  
  ks.c kH()
  {
    return this.adx;
  }
  
  ks.d kI()
  {
    return this.adz;
  }
  
  List<ks.f> kJ()
  {
    return this.adC;
  }
  
  List<ks.g> kK()
  {
    return this.adD;
  }
  
  List<ks.h> kL()
  {
    return this.adH;
  }
  
  public ks kM()
  {
    return this;
  }
  
  Set<Integer> kk()
  {
    return this.acs;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    kt localkt = CREATOR;
    kt.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */