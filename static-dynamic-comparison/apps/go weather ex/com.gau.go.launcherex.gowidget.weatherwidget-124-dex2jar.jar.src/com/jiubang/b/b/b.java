package com.jiubang.b.b;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class b
{
  private Resources a;
  private Context b;
  private int c = 0;
  private c d;
  private List e = new ArrayList();
  private List f = new ArrayList();
  private List g = new ArrayList();
  private boolean h = false;
  private int i = 0;
  private boolean j = false;
  private int k = 0;
  private boolean l = false;
  private int m = 0;
  private boolean n = false;
  private int o = 0;
  private boolean p = false;
  private int q = 0;
  private boolean r = false;
  private int s = 0;
  private boolean t = false;
  private int u = 0;
  private boolean v = false;
  private int w = 0;
  
  public b(Context paramContext, int paramInt1, int paramInt2)
  {
    this.b = paramContext;
    this.c = paramInt1;
    this.a = paramContext.getResources();
    a(paramInt2);
    this.d = new c(paramContext);
  }
  
  private boolean a(int paramInt)
  {
    XmlResourceParser localXmlResourceParser = this.a.getXml(paramInt);
    Object localObject3 = "";
    Object localObject1 = "";
    Object localObject2 = "";
    int i4 = 0;
    paramInt = 0;
    int i3 = 0;
    int i2 = 0;
    int i1 = 0;
    int i10 = localXmlResourceParser.getEventType();
    String str1;
    int i5;
    int i7;
    int i8;
    Object localObject6;
    int i9;
    for (;;)
    {
      if (i10 == 1) {
        return true;
      }
      str1 = localXmlResourceParser.getName();
      if (i10 != 2) {
        break label526;
      }
      localObject4 = localObject3;
      localObject3 = localObject2;
      i5 = 0;
      i6 = i1;
      localObject2 = localObject4;
      i1 = i3;
      i3 = i2;
      i2 = i6;
      if (i5 < localXmlResourceParser.getAttributeCount()) {
        break;
      }
      localObject4 = localObject3;
      localObject5 = localObject1;
      i5 = i2;
      i6 = i3;
      i7 = i1;
      i8 = paramInt;
      localObject6 = localObject2;
      i9 = i4;
      label134:
      i10 = localXmlResourceParser.next();
      i4 = i9;
      localObject3 = localObject6;
      paramInt = i8;
      i3 = i7;
      i2 = i6;
      i1 = i5;
      localObject1 = localObject5;
      localObject2 = localObject4;
    }
    String str2 = localXmlResourceParser.getAttributeName(i5);
    Object localObject4 = localXmlResourceParser.getAttributeValue(i5);
    int i6 = i4;
    Object localObject5 = localObject2;
    if (str1.equals("festival"))
    {
      if (str2.equals("name"))
      {
        localObject5 = localObject4;
        i6 = i4;
      }
    }
    else
    {
      label233:
      if (!str1.equals("info")) {
        break label651;
      }
      if (!str2.equals("month")) {
        break label348;
      }
      i9 = Integer.parseInt((String)localObject4);
      localObject2 = localObject1;
      localObject6 = localObject3;
      i8 = i1;
      i7 = i3;
      i4 = i2;
    }
    for (;;)
    {
      i5 += 1;
      localObject1 = localObject2;
      i2 = i4;
      i3 = i7;
      i1 = i8;
      paramInt = i9;
      localObject3 = localObject6;
      i4 = i6;
      localObject2 = localObject5;
      break;
      i6 = i4;
      localObject5 = localObject2;
      if (!str2.equals("algorithm")) {
        break label233;
      }
      i6 = Integer.parseInt((String)localObject4);
      localObject5 = localObject2;
      break label233;
      label348:
      if (str2.equals("week"))
      {
        i8 = Integer.parseInt((String)localObject4);
        i4 = i2;
        i7 = i3;
        i9 = paramInt;
        localObject6 = localObject3;
        localObject2 = localObject1;
      }
      else if (str2.equals("day"))
      {
        i7 = Integer.parseInt((String)localObject4);
        i4 = i2;
        i8 = i1;
        i9 = paramInt;
        localObject6 = localObject3;
        localObject2 = localObject1;
      }
      else if (str2.equals("weekday"))
      {
        i4 = Integer.parseInt((String)localObject4);
        i7 = i3;
        i8 = i1;
        i9 = paramInt;
        localObject6 = localObject3;
        localObject2 = localObject1;
      }
      else
      {
        i4 = i2;
        i7 = i3;
        i8 = i1;
        i9 = paramInt;
        localObject6 = localObject3;
        localObject2 = localObject4;
        if (!str2.equals("mark"))
        {
          if (str2.equals("mark_day"))
          {
            i4 = i2;
            i7 = i3;
            i8 = i1;
            i9 = paramInt;
            localObject6 = localObject4;
            localObject2 = localObject1;
            continue;
            label526:
            i9 = i4;
            localObject6 = localObject3;
            i8 = paramInt;
            i7 = i3;
            i6 = i2;
            i5 = i1;
            localObject5 = localObject1;
            localObject4 = localObject2;
            if (i10 != 3) {
              break label134;
            }
            i9 = i4;
            localObject6 = localObject3;
            i8 = paramInt;
            i7 = i3;
            i6 = i2;
            i5 = i1;
            localObject5 = localObject1;
            localObject4 = localObject2;
            if (!str1.equals("festival")) {
              break label134;
            }
            i9 = i4;
            localObject6 = localObject3;
            i8 = paramInt;
            i7 = i3;
            i6 = i2;
            i5 = i1;
            localObject5 = localObject1;
            localObject4 = localObject2;
            if (a(i4, (String)localObject3, paramInt, i3, i2, i1, (String)localObject1, (String)localObject2)) {
              break label134;
            }
            return false;
          }
          label651:
          i4 = i2;
          i7 = i3;
          i8 = i1;
          i9 = paramInt;
          localObject6 = localObject3;
          localObject2 = localObject1;
        }
      }
    }
  }
  
  private boolean a(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, String paramString3)
  {
    if ((paramInt1 < 0) || (paramInt1 > 5)) {
      return false;
    }
    switch (paramInt1)
    {
    default: 
      return false;
    case 0: 
      return b(paramString1, paramInt2, paramInt4);
    case 1: 
      return a(paramString1, paramInt2, paramInt4);
    case 2: 
      return a(paramString1, paramInt2, paramInt3, paramInt5);
    case 3: 
      return a(paramString1, paramString2);
    case 4: 
      return b(paramString1, paramString2);
    }
    return c(paramString1, paramString3);
  }
  
  private boolean a(String paramString, int paramInt1, int paramInt2)
  {
    String str = this.b.getPackageName();
    int i1 = this.a.getIdentifier(paramString, "string", str);
    if (i1 == 0) {
      return false;
    }
    this.f.add(new a(paramInt1, paramInt2, i1));
    return true;
  }
  
  private boolean a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = this.b.getPackageName();
    int i1 = this.a.getIdentifier(paramString, "string", str);
    if (i1 == 0) {
      return false;
    }
    this.g.add(new d(paramInt1, paramInt2, paramInt3, i1));
    return true;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    String str = this.b.getPackageName();
    if (paramString2.equals("year_first_day"))
    {
      this.i = this.a.getIdentifier(paramString1, "string", str);
      if (this.i != 0) {}
    }
    do
    {
      do
      {
        return false;
        this.h = true;
        return true;
      } while (!paramString2.equals("year_last_day"));
      this.k = this.a.getIdentifier(paramString1, "string", str);
    } while (this.k == 0);
    this.j = true;
    return true;
  }
  
  private boolean a(StringBuffer paramStringBuffer, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.e.iterator();
    a locala;
    do
    {
      if (!localIterator.hasNext()) {
        return false;
      }
      locala = (a)localIterator.next();
    } while ((locala.a != paramInt1) || (locala.b != paramInt2));
    paramStringBuffer.append(this.a.getString(locala.c));
    return true;
  }
  
  private boolean a(StringBuffer paramStringBuffer, Calendar paramCalendar)
  {
    Iterator localIterator = this.g.iterator();
    d locald;
    do
    {
      if (!localIterator.hasNext()) {
        return false;
      }
      locald = (d)localIterator.next();
    } while (!a(paramCalendar, locald.a, locald.b, locald.c));
    paramStringBuffer.append(this.a.getString(locald.d));
    return true;
  }
  
  private boolean a(Calendar paramCalendar, int paramInt1, int paramInt2, int paramInt3)
  {
    int i3 = paramCalendar.get(1);
    int i1 = paramCalendar.get(2);
    int i2 = paramCalendar.get(5);
    paramCalendar = Calendar.getInstance();
    paramCalendar.set(1, i3);
    paramCalendar.set(2, i1);
    paramCalendar.set(5, 1);
    i3 = paramInt3 - paramCalendar.get(7) + 1;
    paramInt3 = paramInt2;
    if (i3 > 0) {
      paramInt3 = paramInt2 - 1;
    }
    return (i1 == paramInt1) && (i2 == i3 + paramInt3 * 7);
  }
  
  private boolean b(String paramString, int paramInt1, int paramInt2)
  {
    String str = this.b.getPackageName();
    int i1 = this.a.getIdentifier(paramString, "string", str);
    if (i1 == 0) {
      return false;
    }
    this.e.add(new a(paramInt1, paramInt2, i1));
    return true;
  }
  
  private boolean b(String paramString1, String paramString2)
  {
    String str = this.b.getPackageName();
    if (paramString2.equals("year_first_day"))
    {
      this.m = this.a.getIdentifier(paramString1, "string", str);
      if (this.m != 0) {}
    }
    do
    {
      do
      {
        return false;
        this.l = true;
        return true;
      } while (!paramString2.equals("year_last_day"));
      this.o = this.a.getIdentifier(paramString1, "string", str);
    } while (this.o == 0);
    this.n = true;
    return true;
  }
  
  private boolean b(StringBuffer paramStringBuffer, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.f.iterator();
    a locala;
    do
    {
      if (!localIterator.hasNext()) {
        return false;
      }
      locala = (a)localIterator.next();
    } while ((locala.a != paramInt1) || (locala.b != paramInt2));
    paramStringBuffer.append(this.a.getString(locala.c));
    return true;
  }
  
  private boolean b(StringBuffer paramStringBuffer, Calendar paramCalendar)
  {
    if ((this.h) && (b(paramCalendar)))
    {
      paramStringBuffer.append(this.a.getString(this.i));
      return true;
    }
    if ((this.j) && (c(paramCalendar)))
    {
      paramStringBuffer.append(this.a.getString(this.k));
      return true;
    }
    return false;
  }
  
  private boolean b(Calendar paramCalendar)
  {
    int i1 = paramCalendar.get(2);
    int i2 = paramCalendar.get(5);
    return (i1 == 0) && (i2 == 1);
  }
  
  private boolean c(String paramString1, String paramString2)
  {
    String str = this.b.getPackageName();
    if (this.a.getIdentifier(paramString1, "string", str) == 0) {}
    do
    {
      return false;
      if (paramString2.equals("qingming_day"))
      {
        this.p = true;
        this.q = this.a.getIdentifier(paramString1, "string", str);
        return false;
      }
      if (paramString2.equals("election_day"))
      {
        this.r = true;
        this.s = this.a.getIdentifier(paramString1, "string", str);
        return false;
      }
      if (paramString2.equals("memorial_day"))
      {
        this.t = true;
        this.u = this.a.getIdentifier(paramString1, "string", str);
        return false;
      }
    } while (!paramString2.equals("easter_day"));
    this.v = true;
    this.w = this.a.getIdentifier(paramString1, "string", str);
    return false;
  }
  
  private boolean c(StringBuffer paramStringBuffer, Calendar paramCalendar)
  {
    if ((this.l) && (d(paramCalendar)))
    {
      paramStringBuffer.append(this.a.getString(this.m));
      return true;
    }
    if ((this.n) && (e(paramCalendar)))
    {
      paramStringBuffer.append(this.a.getString(this.o));
      return true;
    }
    return false;
  }
  
  private boolean c(Calendar paramCalendar)
  {
    int i1 = paramCalendar.get(2);
    int i2 = paramCalendar.get(5);
    return (i1 == 11) && (i2 == 31);
  }
  
  private boolean d(StringBuffer paramStringBuffer, Calendar paramCalendar)
  {
    int i1 = (int)(97.52000000000001D - 1.9D * Math.sin(1.572D));
    if ((int)(365.242D * (paramCalendar.get(1) - 1900) + i1) != this.d.a(paramCalendar)) {
      return false;
    }
    paramStringBuffer.append(this.a.getString(this.q));
    return true;
  }
  
  private boolean d(Calendar paramCalendar)
  {
    int i1 = this.d.b(paramCalendar);
    int i2 = this.d.c(paramCalendar);
    return (i1 == 0) && (i2 == 1);
  }
  
  private boolean e(StringBuffer paramStringBuffer, Calendar paramCalendar)
  {
    int i3 = paramCalendar.get(1);
    int i1 = paramCalendar.get(5);
    if ((i3 < 1900) || (i3 > 2099)) {
      return false;
    }
    int i2 = paramCalendar.get(2);
    i3 -= 1900;
    int i5 = i3 % 19;
    int i4 = i3 / 4;
    i5 = (i5 * 11 + 4 - (i5 * 7 + 1) / 19) % 29;
    i3 = 25 - i5 - (i3 + i4 + 31 - i5) % 7;
    if (i3 > 0)
    {
      if ((i2 == 3) && (i1 == i3))
      {
        paramStringBuffer.append(this.a.getString(this.w));
        return true;
      }
    }
    else if (i3 == 0)
    {
      if ((i2 == 2) && (i1 == 31))
      {
        paramStringBuffer.append(this.a.getString(this.w));
        return true;
      }
    }
    else if ((i2 == 2) && (i1 == i3 + 31))
    {
      paramStringBuffer.append(this.a.getString(this.w));
      return true;
    }
    return false;
  }
  
  private boolean e(Calendar paramCalendar)
  {
    int i1 = paramCalendar.get(1);
    int i2 = paramCalendar.get(2);
    int i3 = paramCalendar.get(5);
    paramCalendar = Calendar.getInstance();
    paramCalendar.set(1, i1);
    paramCalendar.set(2, i2);
    paramCalendar.set(5, i3);
    paramCalendar.add(6, 1);
    return d(paramCalendar);
  }
  
  private boolean f(StringBuffer paramStringBuffer, Calendar paramCalendar)
  {
    int i1 = paramCalendar.get(1);
    int i2 = paramCalendar.get(2);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, i1);
    localCalendar.set(2, i2);
    localCalendar.set(5, 1);
    if (localCalendar.get(7) == 3)
    {
      if (a(paramCalendar, 10, 2, 3))
      {
        paramStringBuffer.append(this.a.getString(this.s));
        return true;
      }
    }
    else if (a(paramCalendar, 10, 1, 3))
    {
      paramStringBuffer.append(this.a.getString(this.s));
      return true;
    }
    return false;
  }
  
  private boolean g(StringBuffer paramStringBuffer, Calendar paramCalendar)
  {
    int i1 = paramCalendar.get(2);
    if (i1 != 4) {}
    Calendar localCalendar;
    do
    {
      return false;
      int i2 = paramCalendar.get(1);
      localCalendar = Calendar.getInstance();
      localCalendar.set(1, i2);
      localCalendar.set(2, i1);
      localCalendar.set(5, 31);
      i1 = paramCalendar.get(5);
    } while (31 - (localCalendar.get(7) - 2 + 7) % 7 != i1);
    paramStringBuffer.append(this.a.getString(this.u));
    return true;
  }
  
  public String a(Calendar paramCalendar)
  {
    StringBuffer localStringBuffer = new StringBuffer("");
    if (a(localStringBuffer, paramCalendar.get(2), paramCalendar.get(5))) {
      return localStringBuffer.toString();
    }
    if (b(localStringBuffer, this.d.b(paramCalendar), this.d.c(paramCalendar))) {
      return localStringBuffer.toString();
    }
    if (a(localStringBuffer, paramCalendar)) {
      return localStringBuffer.toString();
    }
    if (b(localStringBuffer, paramCalendar)) {
      return localStringBuffer.toString();
    }
    if (c(localStringBuffer, paramCalendar)) {
      return localStringBuffer.toString();
    }
    if (this.c == 1)
    {
      if ((this.p) && (d(localStringBuffer, paramCalendar))) {
        return localStringBuffer.toString();
      }
    }
    else if (this.c == 2)
    {
      if ((this.v) && (e(localStringBuffer, paramCalendar))) {
        return localStringBuffer.toString();
      }
      if ((this.r) && (f(localStringBuffer, paramCalendar))) {
        return localStringBuffer.toString();
      }
      if ((this.t) && (g(localStringBuffer, paramCalendar))) {
        return localStringBuffer.toString();
      }
    }
    return "";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/b/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */