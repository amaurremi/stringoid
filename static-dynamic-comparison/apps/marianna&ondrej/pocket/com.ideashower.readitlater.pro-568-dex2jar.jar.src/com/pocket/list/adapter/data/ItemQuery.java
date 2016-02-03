package com.pocket.list.adapter.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.ideashower.readitlater.e.o;
import com.pocket.n.e;
import org.apache.a.c.k;

public class ItemQuery
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
  {
    public ItemQuery a(Parcel paramAnonymousParcel)
    {
      return new ItemQuery(paramAnonymousParcel, null);
    }
    
    public ItemQuery[] a(int paramAnonymousInt)
    {
      return new ItemQuery[paramAnonymousInt];
    }
  };
  private final n a = new n(this);
  private Integer b = Integer.valueOf(0);
  private int c = 0;
  private boolean d = false;
  private int e = 0;
  private Integer f;
  private Integer g;
  private Boolean h;
  private String i;
  private String j;
  private String k;
  private Integer l;
  private Long m;
  private Integer n;
  private String o;
  private String p;
  private Integer q;
  private boolean r;
  private boolean s;
  private m t;
  private ItemQuery.ReadOnlyItemQuery u;
  private e v;
  
  public ItemQuery() {}
  
  private ItemQuery(Parcel paramParcel)
  {
    this.b = a(paramParcel);
    this.c = paramParcel.readInt();
    this.f = a(paramParcel);
    this.g = a(paramParcel);
    this.h = c(paramParcel);
    this.i = paramParcel.readString();
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    this.l = a(paramParcel);
    this.m = b(paramParcel);
    this.n = a(paramParcel);
    this.o = paramParcel.readString();
    this.p = paramParcel.readString();
    this.q = a(paramParcel);
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.r = bool1;
      if (paramParcel.readInt() != 1) {
        break label212;
      }
      bool1 = true;
      label178:
      this.s = bool1;
      if (paramParcel.readInt() != 1) {
        break label217;
      }
    }
    label212:
    label217:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.d = bool1;
      this.e = paramParcel.readInt();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label178;
    }
  }
  
  private ItemQuery(ItemQuery paramItemQuery)
  {
    d(paramItemQuery);
  }
  
  private static Integer a(Parcel paramParcel)
  {
    paramParcel = paramParcel.readString();
    if (paramParcel == null) {
      return null;
    }
    return Integer.valueOf(paramParcel);
  }
  
  private static String a(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return paramObject.toString();
  }
  
  private static Long b(Parcel paramParcel)
  {
    paramParcel = paramParcel.readString();
    if (paramParcel == null) {
      return null;
    }
    return Long.valueOf(paramParcel);
  }
  
  private static String b(String paramString)
  {
    return (String)k.e(paramString, null);
  }
  
  private static Boolean c(Parcel paramParcel)
  {
    paramParcel = paramParcel.readString();
    if (paramParcel == null) {
      return null;
    }
    return Boolean.valueOf(paramParcel);
  }
  
  private boolean d(ItemQuery paramItemQuery)
  {
    if (a(paramItemQuery, false, true, true, true)) {
      return false;
    }
    this.b = paramItemQuery.b;
    this.c = paramItemQuery.c;
    this.f = paramItemQuery.f;
    this.g = paramItemQuery.g;
    this.h = paramItemQuery.h;
    this.i = paramItemQuery.i;
    this.j = paramItemQuery.j;
    this.k = paramItemQuery.k;
    this.l = paramItemQuery.l;
    this.m = paramItemQuery.m;
    this.n = paramItemQuery.n;
    this.o = paramItemQuery.o;
    this.p = paramItemQuery.p;
    this.q = paramItemQuery.q;
    this.d = paramItemQuery.d;
    this.r = paramItemQuery.r;
    this.s = paramItemQuery.s;
    this.e = paramItemQuery.e;
    return true;
  }
  
  public String A()
  {
    return this.k;
  }
  
  public boolean B()
  {
    return (this.k != null) && (this.k.length() > 0);
  }
  
  public Integer C()
  {
    return this.l;
  }
  
  public boolean D()
  {
    return (this.l != null) && (this.l.intValue() != 0);
  }
  
  public int E()
  {
    if (this.l != null) {
      return this.l.intValue();
    }
    return 0;
  }
  
  public Long F()
  {
    return this.m;
  }
  
  public Integer G()
  {
    return this.n;
  }
  
  public String H()
  {
    return this.o;
  }
  
  public String I()
  {
    return this.p;
  }
  
  public boolean J()
  {
    return n.a.a(this, false, false, false, false);
  }
  
  public String K()
  {
    if (f())
    {
      switch (e().intValue())
      {
      default: 
        return null;
      case 0: 
        return "queue";
      }
      return "archive";
    }
    return "all";
  }
  
  public String L()
  {
    switch (j())
    {
    case 4: 
    case 5: 
    default: 
      return null;
    case 0: 
      return "newest";
    case 1: 
      return "oldest";
    case 2: 
      return "title";
    case 3: 
      return "site";
    }
    return "relevance";
  }
  
  public String M()
  {
    switch (E())
    {
    case 0: 
    default: 
      return null;
    case 1: 
      return "article";
    case 2: 
      return "video";
    }
    return "image";
  }
  
  public l a()
  {
    return new l(this, null);
  }
  
  public void a(m paramm)
  {
    this.t = paramm;
  }
  
  public boolean a(o paramo)
  {
    if ((f()) && (paramo.al() != this.b.intValue())) {}
    while (((!f()) && (paramo.al() == 2)) || ((v()) && (paramo.ae() != this.h.booleanValue())) || ((D()) && (paramo.G() != this.l.intValue())) || ((h()) && (this.q.intValue() == 1) && (!paramo.h(true)))) {
      return false;
    }
    return true;
  }
  
  public boolean a(Object paramObject, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass())
        {
          if (paramBoolean1) {
            return false;
          }
          if ((!(paramObject instanceof ItemQuery)) || (!(this instanceof ItemQuery))) {
            return false;
          }
        }
        paramObject = (ItemQuery)paramObject;
        if (this.d != ((ItemQuery)paramObject).d) {
          return false;
        }
        if (this.l == null)
        {
          if (((ItemQuery)paramObject).l != null) {
            return false;
          }
        }
        else if (!this.l.equals(((ItemQuery)paramObject).l)) {
          return false;
        }
        if (paramBoolean3) {
          if (this.g == null)
          {
            if (((ItemQuery)paramObject).g != null) {
              return false;
            }
          }
          else if (!this.g.equals(((ItemQuery)paramObject).g)) {
            return false;
          }
        }
        if (this.h == null)
        {
          if (((ItemQuery)paramObject).h != null) {
            return false;
          }
        }
        else if (!this.h.equals(((ItemQuery)paramObject).h)) {
          return false;
        }
        if (this.e != ((ItemQuery)paramObject).e) {
          return false;
        }
        if (this.m == null)
        {
          if (((ItemQuery)paramObject).m != null) {
            return false;
          }
        }
        else if (!this.m.equals(((ItemQuery)paramObject).m)) {
          return false;
        }
        if (paramBoolean2) {
          if (this.f == null)
          {
            if (((ItemQuery)paramObject).f != null) {
              return false;
            }
          }
          else if (!this.f.equals(((ItemQuery)paramObject).f)) {
            return false;
          }
        }
        if (this.i == null)
        {
          if (((ItemQuery)paramObject).i != null) {
            return false;
          }
        }
        else if (!this.i.equals(((ItemQuery)paramObject).i)) {
          return false;
        }
        if (this.j == null)
        {
          if (((ItemQuery)paramObject).j != null) {
            return false;
          }
        }
        else if (!this.j.equals(((ItemQuery)paramObject).j)) {
          return false;
        }
        if (this.n == null)
        {
          if (((ItemQuery)paramObject).n != null) {
            return false;
          }
        }
        else if (!this.n.equals(((ItemQuery)paramObject).n)) {
          return false;
        }
        if (this.o == null)
        {
          if (((ItemQuery)paramObject).o != null) {
            return false;
          }
        }
        else if (!this.o.equals(((ItemQuery)paramObject).o)) {
          return false;
        }
        if (this.q == null)
        {
          if (((ItemQuery)paramObject).q != null) {
            return false;
          }
        }
        else if (!this.q.equals(((ItemQuery)paramObject).q)) {
          return false;
        }
        if ((paramBoolean4) && (this.c != ((ItemQuery)paramObject).c)) {
          return false;
        }
        if (this.b == null)
        {
          if (((ItemQuery)paramObject).b != null) {
            return false;
          }
        }
        else if (!this.b.equals(((ItemQuery)paramObject).b)) {
          return false;
        }
        if (this.k == null)
        {
          if (((ItemQuery)paramObject).k != null) {
            return false;
          }
        }
        else if (!this.k.equals(((ItemQuery)paramObject).k)) {
          return false;
        }
        if (this.r != ((ItemQuery)paramObject).r) {
          return false;
        }
        if (this.s != ((ItemQuery)paramObject).s) {
          return false;
        }
        if (this.p != null) {
          break;
        }
      } while (((ItemQuery)paramObject).p == null);
      return false;
    } while (this.p.equals(((ItemQuery)paramObject).p));
    return false;
  }
  
  public n b()
  {
    return this.a;
  }
  
  public ItemQuery.ReadOnlyItemQuery c()
  {
    if (this.u == null) {
      this.u = new ItemQuery.ReadOnlyItemQuery(this, null);
    }
    return this.u;
  }
  
  public e d()
  {
    if (this.v == null) {
      this.v = e.a(this);
    }
    return this.v;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Integer e()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(paramObject, true, true, true, true);
  }
  
  public boolean f()
  {
    return this.b != null;
  }
  
  public Integer g()
  {
    return this.q;
  }
  
  public boolean h()
  {
    return this.q != null;
  }
  
  public int hashCode()
  {
    int i15 = 1231;
    int i16 = 0;
    int i1;
    int i2;
    label28:
    int i3;
    label37:
    int i4;
    label47:
    int i17;
    int i5;
    label63:
    int i6;
    label73:
    int i7;
    label83:
    int i8;
    label93:
    int i9;
    label103:
    int i10;
    label113:
    int i11;
    label123:
    int i18;
    int i12;
    label139:
    int i13;
    label149:
    int i14;
    if (this.d)
    {
      i1 = 1231;
      if (this.l != null) {
        break label287;
      }
      i2 = 0;
      if (this.g != null) {
        break label298;
      }
      i3 = 0;
      if (this.h != null) {
        break label309;
      }
      i4 = 0;
      i17 = this.e;
      if (this.m != null) {
        break label321;
      }
      i5 = 0;
      if (this.f != null) {
        break label333;
      }
      i6 = 0;
      if (this.i != null) {
        break label345;
      }
      i7 = 0;
      if (this.j != null) {
        break label357;
      }
      i8 = 0;
      if (this.n != null) {
        break label369;
      }
      i9 = 0;
      if (this.o != null) {
        break label381;
      }
      i10 = 0;
      if (this.q != null) {
        break label393;
      }
      i11 = 0;
      i18 = this.c;
      if (this.b != null) {
        break label405;
      }
      i12 = 0;
      if (this.k != null) {
        break label417;
      }
      i13 = 0;
      if (!this.r) {
        break label429;
      }
      i14 = 1231;
      label161:
      if (!this.s) {
        break label437;
      }
      label168:
      if (this.p != null) {
        break label445;
      }
    }
    for (;;)
    {
      return ((i14 + (i13 + (i12 + ((i11 + (i10 + (i9 + (i8 + (i7 + (i6 + (i5 + ((i4 + (i3 + (i2 + (i1 + 31) * 31) * 31) * 31) * 31 + i17) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i18) * 31) * 31) * 31) * 31 + i15) * 31 + i16;
      i1 = 1237;
      break;
      label287:
      i2 = this.l.hashCode();
      break label28;
      label298:
      i3 = this.g.hashCode();
      break label37;
      label309:
      i4 = this.h.hashCode();
      break label47;
      label321:
      i5 = this.m.hashCode();
      break label63;
      label333:
      i6 = this.f.hashCode();
      break label73;
      label345:
      i7 = this.i.hashCode();
      break label83;
      label357:
      i8 = this.j.hashCode();
      break label93;
      label369:
      i9 = this.n.hashCode();
      break label103;
      label381:
      i10 = this.o.hashCode();
      break label113;
      label393:
      i11 = this.q.hashCode();
      break label123;
      label405:
      i12 = this.b.hashCode();
      break label139;
      label417:
      i13 = this.k.hashCode();
      break label149;
      label429:
      i14 = 1237;
      break label161;
      label437:
      i15 = 1237;
      break label168;
      label445:
      i16 = this.p.hashCode();
    }
  }
  
  public int i()
  {
    if (this.q != null) {
      return this.q.intValue();
    }
    return 0;
  }
  
  public int j()
  {
    return this.c;
  }
  
  public boolean k()
  {
    return this.d;
  }
  
  public boolean l()
  {
    return this.r;
  }
  
  public boolean m()
  {
    return this.s;
  }
  
  public int n()
  {
    return this.e;
  }
  
  public Integer o()
  {
    return this.f;
  }
  
  public boolean p()
  {
    return this.f != null;
  }
  
  public int q()
  {
    if (this.f != null) {
      return this.f.intValue();
    }
    return 0;
  }
  
  public Integer r()
  {
    return this.g;
  }
  
  public boolean s()
  {
    return this.g != null;
  }
  
  public int t()
  {
    if (this.g != null) {
      return this.g.intValue();
    }
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("ItemQuery [");
    if (this.b != null)
    {
      str = "mStatus=" + this.b + ", ";
      localStringBuilder = localStringBuilder.append(str).append("mSort=").append(this.c).append(", mCarouselOnly=").append(this.d).append(", mGroup=").append(this.e).append(", ");
      if (this.f == null) {
        break label703;
      }
      str = "mOffset=" + this.f + ", ";
      label139:
      localStringBuilder = localStringBuilder.append(str);
      if (this.g == null) {
        break label710;
      }
      str = "mCount=" + this.g + ", ";
      label182:
      localStringBuilder = localStringBuilder.append(str);
      if (this.h == null) {
        break label717;
      }
      str = "mFavorite=" + this.h + ", ";
      label225:
      localStringBuilder = localStringBuilder.append(str);
      if (this.i == null) {
        break label724;
      }
      str = "mSearch=" + this.i + ", ";
      label268:
      localStringBuilder = localStringBuilder.append(str);
      if (this.j == null) {
        break label731;
      }
      str = "mSearchType=" + this.j + ", ";
      label311:
      localStringBuilder = localStringBuilder.append(str);
      if (this.k == null) {
        break label738;
      }
      str = "mTag=" + this.k + ", ";
      label354:
      localStringBuilder = localStringBuilder.append(str);
      if (this.l == null) {
        break label745;
      }
      str = "mContentType=" + this.l + ", ";
      label397:
      localStringBuilder = localStringBuilder.append(str);
      if (this.m == null) {
        break label752;
      }
      str = "mNewFrom=" + this.m + ", ";
      label440:
      localStringBuilder = localStringBuilder.append(str);
      if (this.n == null) {
        break label759;
      }
      str = "mSearchUniqueId=" + this.n + ", ";
      label483:
      localStringBuilder = localStringBuilder.append(str);
      if (this.o == null) {
        break label766;
      }
      str = "mSearchUrl=" + this.o + ", ";
      label526:
      localStringBuilder = localStringBuilder.append(str);
      if (this.p == null) {
        break label773;
      }
      str = "mWhere=" + this.p + ", ";
      label569:
      localStringBuilder = localStringBuilder.append(str);
      if (this.q == null) {
        break label780;
      }
      str = "mShareStatus=" + this.q + ", ";
      label612:
      localStringBuilder = localStringBuilder.append(str).append("mUseRemoteSource=").append(this.r).append(", mLocalFallbackEnabled=").append(this.s).append(", ");
      if (this.v == null) {
        break label787;
      }
    }
    label703:
    label710:
    label717:
    label724:
    label731:
    label738:
    label745:
    label752:
    label759:
    label766:
    label773:
    label780:
    label787:
    for (String str = "mSearchContext=" + this.v;; str = "")
    {
      return str + "]";
      str = "";
      break;
      str = "";
      break label139;
      str = "";
      break label182;
      str = "";
      break label225;
      str = "";
      break label268;
      str = "";
      break label311;
      str = "";
      break label354;
      str = "";
      break label397;
      str = "";
      break label440;
      str = "";
      break label483;
      str = "";
      break label526;
      str = "";
      break label569;
      str = "";
      break label612;
    }
  }
  
  public Boolean u()
  {
    return this.h;
  }
  
  public boolean v()
  {
    return this.h != null;
  }
  
  public boolean w()
  {
    if (this.h != null) {
      return this.h.booleanValue();
    }
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = 1;
    paramParcel.writeString(a(this.b));
    paramParcel.writeInt(this.c);
    paramParcel.writeString(a(this.f));
    paramParcel.writeString(a(this.g));
    paramParcel.writeString(a(this.h));
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeString(a(this.l));
    paramParcel.writeString(a(this.m));
    paramParcel.writeString(a(this.n));
    paramParcel.writeString(this.o);
    paramParcel.writeString(this.p);
    paramParcel.writeString(a(this.q));
    if (this.r)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.s) {
        break label194;
      }
      paramInt = 1;
      label161:
      paramParcel.writeInt(paramInt);
      if (!this.d) {
        break label199;
      }
    }
    label194:
    label199:
    for (paramInt = i1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.e);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label161;
    }
  }
  
  public String x()
  {
    return this.i;
  }
  
  public boolean y()
  {
    return (this.i != null) && (this.i.length() > 0);
  }
  
  public String z()
  {
    return this.j;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/adapter/data/ItemQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */