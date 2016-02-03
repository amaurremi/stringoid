package com.gau.go.launcherex.gowidget.scriptengine.parser;

import android.graphics.Color;
import java.text.Format;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;

public class u
{
  private static Map a = null;
  private static Pattern b = Pattern.compile("-{0,1}\\d+%");
  
  static
  {
    a = new HashMap();
    a.put("ANTI_ALIAS_FLAG", Integer.valueOf(1));
    a.put("FILTER_BITMAP_FLAG", Integer.valueOf(2));
    b = null;
  }
  
  private float a(String paramString, float paramFloat)
  {
    float f = paramFloat;
    if (paramString != null)
    {
      f = paramFloat;
      if (paramString.length() <= 0) {}
    }
    try
    {
      f = ((Number)NumberFormat.getPercentInstance().parseObject(paramString)).floatValue();
      return f;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return paramFloat;
  }
  
  private int a(String paramString, int paramInt)
  {
    int i = paramInt;
    if (paramString != null)
    {
      i = paramInt;
      if (paramString.length() <= 0) {}
    }
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return paramInt;
  }
  
  private r a(XmlPullParser paramXmlPullParser, r paramr)
  {
    int i;
    label70:
    boolean bool;
    do
    {
      String str;
      try
      {
        while (paramXmlPullParser.next() != 1)
        {
          str = paramXmlPullParser.getName();
          if (str != null)
          {
            i = paramXmlPullParser.getEventType();
            if ((!str.equals("set")) || (i != 2)) {
              break label70;
            }
            g(paramXmlPullParser, (ab)paramr.g(6));
          }
        }
        return paramr;
      }
      catch (Exception paramXmlPullParser)
      {
        paramXmlPullParser.printStackTrace();
      }
      bool = str.equals("image");
    } while ((!bool) || (i != 3));
    return paramr;
  }
  
  private void a(XmlPullParser paramXmlPullParser, ab paramab)
  {
    int i = 1;
    paramab = (ad)paramab.a(3);
    String str = paramXmlPullParser.getAttributeValue(null, "fromXDelta");
    label84:
    label120:
    label156:
    int j;
    if (a(str))
    {
      paramab.a(2);
      paramab.a(a(str, 0.0F));
      str = paramXmlPullParser.getAttributeValue(null, "toXDelta");
      if (!a(str)) {
        break label335;
      }
      paramab.b(2);
      paramab.b(a(str, 0.0F));
      str = paramXmlPullParser.getAttributeValue(null, "fromYDelta");
      if (!a(str)) {
        break label354;
      }
      paramab.h(2);
      paramab.d(a(str, 0.0F));
      str = paramXmlPullParser.getAttributeValue(null, "toYDelta");
      if (!a(str)) {
        break label373;
      }
      paramab.i(2);
      paramab.e(a(str, 0.0F));
      paramab.j(c(paramXmlPullParser.getAttributeValue(null, "anchor")));
      j = a(paramXmlPullParser.getAttributeValue(null, "repeatCount"), 0);
      str = paramXmlPullParser.getAttributeValue(null, "repeatMode");
      if (str == null) {
        break label408;
      }
      if (!str.equals("repeat")) {
        break label392;
      }
    }
    for (;;)
    {
      int k = a(paramXmlPullParser.getAttributeValue(null, "duration"), Integer.MAX_VALUE);
      float f = b(paramXmlPullParser.getAttributeValue(null, "speed"), Float.MAX_VALUE);
      int m = a(paramXmlPullParser.getAttributeValue(null, "startDelayTime"), 0);
      int n = a(paramXmlPullParser.getAttributeValue(null, "repeatStartDelayTime"), 0);
      paramab.f(j);
      paramab.e(i);
      paramab.g(k);
      paramab.c(f);
      paramab.c(m);
      paramab.d(n);
      return;
      paramab.a(1);
      paramab.a(b(str, 0.0F));
      break;
      label335:
      paramab.b(1);
      paramab.b(b(str, 0.0F));
      break label84;
      label354:
      paramab.h(1);
      paramab.d(b(str, 0.0F));
      break label120;
      label373:
      paramab.i(1);
      paramab.e(b(str, 0.0F));
      break label156;
      label392:
      if (str.equals("reverse")) {
        i = 2;
      } else {
        label408:
        i = 0;
      }
    }
  }
  
  private void a(XmlPullParser paramXmlPullParser, p paramp)
  {
    for (;;)
    {
      String str1;
      int i;
      try
      {
        if (paramXmlPullParser.next() != 1)
        {
          str1 = paramXmlPullParser.getName();
          if (str1 == null) {
            continue;
          }
          i = paramXmlPullParser.getEventType();
          if ((str1.equals("frame")) && (i == 2))
          {
            str1 = paramXmlPullParser.getAttributeValue(null, "src");
            int j = a(paramXmlPullParser.getAttributeValue(null, "startTime"), 0);
            int k = a(paramXmlPullParser.getAttributeValue(null, "endTime"), paramp.h());
            String str2 = paramXmlPullParser.getAttributeValue(null, "visibility");
            if ((str2 == null) || (!str2.equals("invisible"))) {
              break label160;
            }
            i = 0;
            paramp.a(str1, j, k, i);
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramXmlPullParser)
      {
        paramXmlPullParser.printStackTrace();
      }
      boolean bool = str1.equals("frames");
      if ((bool) && (i == 3))
      {
        return;
        label160:
        i = 1;
      }
    }
  }
  
  private void a(XmlPullParser paramXmlPullParser, s params)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      Object localObject1;
      int i;
      int j;
      int k;
      int m;
      int n;
      float f1;
      float f2;
      boolean bool1;
      int i1;
      int i2;
      int i3;
      Object localObject2;
      int i4;
      int i5;
      int i6;
      Object localObject3;
      try
      {
        if (paramXmlPullParser.next() != 1)
        {
          localObject1 = paramXmlPullParser.getName();
          if (localObject1 == null) {
            continue;
          }
          i = paramXmlPullParser.getEventType();
          if ((((String)localObject1).equals("set")) && (i == 2))
          {
            j = params.b();
            i = 0;
            if (i >= j) {
              continue;
            }
            params.a(i).g(6);
            i += 1;
            continue;
          }
          if ((((String)localObject1).equals("translate")) && (i == 2))
          {
            k = a(paramXmlPullParser.getAttributeValue(null, "range"), 0);
            m = a(paramXmlPullParser.getAttributeValue(null, "duration"), 0);
            n = a(paramXmlPullParser.getAttributeValue(null, "repeatCount"), 0);
            paramXmlPullParser.getAttributeValue(null, "repeatMode");
            localObject1 = paramXmlPullParser.getAttributeValue(null, "repeatMode");
            if (localObject1 == null) {
              break label2206;
            }
            if (((String)localObject1).equals("repeat"))
            {
              i = 1;
              f1 = b(paramXmlPullParser.getAttributeValue(null, "offsetX"), 0.0F);
              f2 = b(paramXmlPullParser.getAttributeValue(null, "offsetY"), 0.0F);
              bool1 = a(paramXmlPullParser.getAttributeValue(null, "outScreenX"), true);
              boolean bool2 = a(paramXmlPullParser.getAttributeValue(null, "outScreenY"), true);
              i1 = a(paramXmlPullParser.getAttributeValue(null, "startDelayTime"), 0);
              i2 = a(paramXmlPullParser.getAttributeValue(null, "repeatStartDelayTime"), 0);
              i3 = params.b();
              j = 0;
              if (j >= i3) {
                continue;
              }
              localObject1 = (ad)params.a(j).g(3);
              localObject2 = params.a(j);
              ((ad)localObject1).a(((r)localObject2).q());
              ((ad)localObject1).a(((r)localObject2).t());
              ((ad)localObject1).b(((r)localObject2).q() + f1);
              ((ad)localObject1).b(((r)localObject2).t());
              ((ad)localObject1).d(((r)localObject2).r());
              ((ad)localObject1).h(1);
              ((ad)localObject1).e(((r)localObject2).r() + f2);
              ((ad)localObject1).i(1);
              ((ad)localObject1).g((int)(m + Math.random() * k));
              ((ad)localObject1).a(bool1);
              ((ad)localObject1).b(bool2);
              ((ad)localObject1).f(n);
              ((ad)localObject1).e(i);
              ((ad)localObject1).c((int)(i1 * Math.random()));
              ((ad)localObject1).d(i2);
              j += 1;
              continue;
            }
            if (!((String)localObject1).equals("reverse")) {
              break label2206;
            }
            i = 2;
            continue;
          }
          if ((((String)localObject1).equals("rotate")) && (i == 2))
          {
            n = a(paramXmlPullParser.getAttributeValue(null, "fromDegrees"), 0);
            i1 = a(paramXmlPullParser.getAttributeValue(null, "toDegrees"), 0);
            localObject1 = paramXmlPullParser.getAttributeValue(null, "pivotX");
            if (a((String)localObject1))
            {
              f1 = a((String)localObject1, 0.0F);
              j = 1;
              localObject1 = paramXmlPullParser.getAttributeValue(null, "pivotY");
              if (a((String)localObject1))
              {
                f2 = a((String)localObject1, 0.0F);
                k = 1;
                i2 = a(paramXmlPullParser.getAttributeValue(null, "repeatCount"), 0);
                localObject1 = paramXmlPullParser.getAttributeValue(null, "repeatMode");
                if (localObject1 == null) {
                  break label2200;
                }
                if (!((String)localObject1).equals("repeat")) {
                  continue;
                }
                i = 1;
                i3 = a(paramXmlPullParser.getAttributeValue(null, "duration"), Integer.MAX_VALUE);
                i4 = a(paramXmlPullParser.getAttributeValue(null, "startDelayTime"), 0);
                i5 = a(paramXmlPullParser.getAttributeValue(null, "repeatStartDelayTime"), 0);
                i6 = params.b();
                m = 0;
                if (m >= i6) {
                  continue;
                }
                localObject1 = (x)params.a(m).g(4);
                ((x)localObject1).a(n);
                ((x)localObject1).b(i1);
                ((x)localObject1).g(i3);
                ((x)localObject1).f(i2);
                ((x)localObject1).e(i);
                ((x)localObject1).c((int)(i4 * Math.random()));
                ((x)localObject1).d(i5);
                ((x)localObject1).d(f1);
                ((x)localObject1).h(j);
                ((x)localObject1).e(f2);
                ((x)localObject1).i(k);
                m += 1;
                continue;
              }
            }
            else
            {
              f1 = b((String)localObject1, 0.0F);
              j = 0;
              continue;
            }
            f2 = b((String)localObject1, 0.0F);
            k = 0;
            continue;
            if (!((String)localObject1).equals("reverse")) {
              break label2200;
            }
            i = 2;
            continue;
          }
          if ((!((String)localObject1).equals("alpha")) || (i != 2)) {
            break label1305;
          }
          localObject1 = paramXmlPullParser.getAttributeValue(null, "fromAlpha");
          localObject2 = paramXmlPullParser.getAttributeValue(null, "toAlpha");
          m = a(paramXmlPullParser.getAttributeValue(null, "repeatCount"), 0);
          localObject3 = paramXmlPullParser.getAttributeValue(null, "repeatMode");
          if (localObject3 == null) {
            break label2194;
          }
          if (((String)localObject3).equals("repeat"))
          {
            i = 1;
            n = a(paramXmlPullParser.getAttributeValue(null, "duration"), Integer.MAX_VALUE);
            f1 = b(paramXmlPullParser.getAttributeValue(null, "speed"), Float.MAX_VALUE);
            i1 = a(paramXmlPullParser.getAttributeValue(null, "startDelayTime"), 0);
            i2 = a(paramXmlPullParser.getAttributeValue(null, "repeatStartDelayTime"), 0);
            i3 = a(paramXmlPullParser.getAttributeValue(null, "range"), 0);
            bool1 = localArrayList.isEmpty();
            k = 0;
            if (k >= params.b()) {
              continue;
            }
            localObject3 = (a)params.a(k).g(2);
            if (a((String)localObject1))
            {
              ((a)localObject3).a(1);
              ((a)localObject3).a(a((String)localObject1, 1.0F));
              if (!a((String)localObject2)) {
                break label1256;
              }
              ((a)localObject3).b(1);
              ((a)localObject3).b(a((String)localObject2, 1.0F));
              ((a)localObject3).f(m);
              ((a)localObject3).e(i);
              if (!bool1) {
                break label1277;
              }
              j = (int)(Math.random() * i3);
              localArrayList.add(Integer.valueOf(j));
              ((a)localObject3).g(n + j);
              ((a)localObject3).c(f1);
              ((a)localObject3).c(j + i1);
              ((a)localObject3).d(i2);
              k += 1;
              continue;
            }
          }
          else
          {
            if (!((String)localObject3).equals("reverse")) {
              break label2194;
            }
            i = 2;
            continue;
          }
          ((a)localObject3).a(0);
          ((a)localObject3).a(b((String)localObject1, 1.0F));
          continue;
        }
        else
        {
          return;
        }
      }
      catch (Exception paramXmlPullParser)
      {
        paramXmlPullParser.printStackTrace();
      }
      label1256:
      ((a)localObject3).b(0);
      ((a)localObject3).b(b((String)localObject2, 1.0F));
      continue;
      label1277:
      if (k < localArrayList.size())
      {
        j = ((Integer)localArrayList.get(k)).intValue();
        continue;
        label1305:
        label1354:
        label1387:
        float f3;
        label1420:
        float f4;
        label1453:
        float f5;
        label1486:
        float f6;
        if ((((String)localObject1).equals("scale")) && (i == 2))
        {
          localObject1 = paramXmlPullParser.getAttributeValue(null, "fromXScale");
          if (a((String)localObject1))
          {
            f1 = a((String)localObject1, 1.0F);
            j = 2;
            localObject1 = paramXmlPullParser.getAttributeValue(null, "toXScale");
            if (!a((String)localObject1)) {
              break label1791;
            }
            f2 = a((String)localObject1, 1.0F);
            k = 2;
            localObject1 = paramXmlPullParser.getAttributeValue(null, "fromYScale");
            if (!a((String)localObject1)) {
              break label1806;
            }
            f3 = a((String)localObject1, 1.0F);
            m = 2;
            localObject1 = paramXmlPullParser.getAttributeValue(null, "toYScale");
            if (!a((String)localObject1)) {
              break label1821;
            }
            f4 = a((String)localObject1, 1.0F);
            n = 2;
            localObject1 = paramXmlPullParser.getAttributeValue(null, "pivotX");
            if (!a((String)localObject1)) {
              break label1836;
            }
            f5 = a((String)localObject1, 0.0F);
            i1 = 1;
            localObject1 = paramXmlPullParser.getAttributeValue(null, "pivotY");
            if (!a((String)localObject1)) {
              break label1851;
            }
            f6 = a((String)localObject1, 0.0F);
            i2 = 1;
            label1519:
            i4 = a(paramXmlPullParser.getAttributeValue(null, "repeatCount"), 0);
            localObject1 = paramXmlPullParser.getAttributeValue(null, "repeatMode");
            if (localObject1 == null) {
              break label2188;
            }
            if (!((String)localObject1).equals("repeat")) {
              break label1866;
            }
            i = 1;
          }
        }
        for (;;)
        {
          i5 = a(paramXmlPullParser.getAttributeValue(null, "duration"), Integer.MAX_VALUE);
          i6 = a(paramXmlPullParser.getAttributeValue(null, "startDelayTime"), 0);
          int i7 = a(paramXmlPullParser.getAttributeValue(null, "repeatStartDelayTime"), 0);
          int i8 = params.b();
          i3 = 0;
          while (i3 < i8)
          {
            localObject1 = (y)params.a(i3).g(1);
            ((y)localObject1).a(f1);
            ((y)localObject1).a(j);
            ((y)localObject1).b(f2);
            ((y)localObject1).b(k);
            ((y)localObject1).d(f3);
            ((y)localObject1).h(m);
            ((y)localObject1).e(f4);
            ((y)localObject1).b(n);
            ((y)localObject1).g(i5);
            ((y)localObject1).f(i4);
            ((y)localObject1).e(i);
            ((y)localObject1).c((int)(i6 * Math.random()));
            ((y)localObject1).d(i7);
            ((y)localObject1).f(f5);
            ((y)localObject1).j(i1);
            ((y)localObject1).g(f6);
            ((y)localObject1).k(i2);
            i3 += 1;
          }
          break;
          f1 = b((String)localObject1, 1.0F);
          j = 1;
          break label1354;
          label1791:
          f2 = b((String)localObject1, 1.0F);
          k = 1;
          break label1387;
          label1806:
          f3 = b((String)localObject1, 1.0F);
          m = 1;
          break label1420;
          label1821:
          f4 = b((String)localObject1, 1.0F);
          n = 1;
          break label1453;
          label1836:
          f5 = b((String)localObject1, 0.0F);
          i1 = 0;
          break label1486;
          label1851:
          f6 = b((String)localObject1, 0.0F);
          i2 = 0;
          break label1519;
          label1866:
          if (((String)localObject1).equals("reverse"))
          {
            i = 2;
            continue;
            if ((((String)localObject1).equals("frames")) && (i == 2))
            {
              j = a(paramXmlPullParser.getAttributeValue(null, "amount"), 0);
              k = a(paramXmlPullParser.getAttributeValue(null, "repeatCount"), 0);
              localObject1 = paramXmlPullParser.getAttributeValue(null, "repeatMode");
              if (localObject1 == null) {
                break label2182;
              }
              if (((String)localObject1).equals("repeat")) {
                i = 1;
              }
            }
            for (;;)
            {
              n = a(paramXmlPullParser.getAttributeValue(null, "duration"), Integer.MAX_VALUE);
              f1 = b(paramXmlPullParser.getAttributeValue(null, "speed"), Float.MAX_VALUE);
              i1 = a(paramXmlPullParser.getAttributeValue(null, "startDelayTime"), 0);
              i2 = a(paramXmlPullParser.getAttributeValue(null, "repeatStartDelayTime"), 0);
              m = params.b();
              if (m <= 0) {
                break;
              }
              localObject1 = (p)params.a(0).g(5);
              ((p)localObject1).g(n);
              ((p)localObject1).c(f1);
              ((p)localObject1).f(k);
              ((p)localObject1).e(i);
              ((p)localObject1).d(i2);
              ((p)localObject1).c(i1);
              ((p)localObject1).b(j);
              a(paramXmlPullParser, (p)localObject1);
              i = 1;
              while (i < m)
              {
                ((p)localObject1).a((p)params.a(i).g(5), (p)localObject1);
                i += 1;
              }
              break;
              if (((String)localObject1).equals("reverse"))
              {
                i = 2;
                continue;
                bool1 = ((String)localObject1).equals("images");
                if ((!bool1) || (i != 3)) {
                  break;
                }
                return;
              }
              label2182:
              i = 0;
            }
          }
          else
          {
            label2188:
            i = 0;
          }
        }
        label2194:
        i = 0;
        continue;
        label2200:
        i = 0;
        continue;
        label2206:
        i = 0;
      }
      else
      {
        j = 0;
      }
    }
  }
  
  private void a(XmlPullParser paramXmlPullParser, t paramt)
  {
    int i;
    label69:
    boolean bool;
    do
    {
      String str;
      try
      {
        while (paramXmlPullParser.next() != 1)
        {
          str = paramXmlPullParser.getName();
          if (str != null)
          {
            i = paramXmlPullParser.getEventType();
            if ((!str.equals("set")) || (i != 2)) {
              break label69;
            }
            g(paramXmlPullParser, (ab)paramt.g(6));
          }
        }
        return;
      }
      catch (Exception paramXmlPullParser)
      {
        paramXmlPullParser.printStackTrace();
      }
      bool = str.equals("imageFrame");
    } while ((!bool) || (i != 3));
  }
  
  private boolean a(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      return b.matcher(paramString).find();
    }
    return false;
  }
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramString != null)
    {
      bool = paramBoolean;
      if (paramString.length() <= 0) {}
    }
    try
    {
      bool = Boolean.parseBoolean(paramString);
      return bool;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return paramBoolean;
  }
  
  private float b(String paramString, float paramFloat)
  {
    float f = paramFloat;
    if (paramString != null)
    {
      f = paramFloat;
      if (paramString.length() <= 0) {}
    }
    try
    {
      f = Float.parseFloat(paramString);
      return f;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return paramFloat;
  }
  
  private int b(String paramString, int paramInt)
  {
    int i = paramInt;
    if (paramString != null)
    {
      i = paramInt;
      if (paramString.length() <= 0) {}
    }
    try
    {
      i = Color.parseColor(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return paramInt;
  }
  
  private ArrayList b(String paramString)
  {
    int i = 0;
    localArrayList = new ArrayList();
    try
    {
      if (paramString.indexOf(';') != -1) {
        paramString = paramString.split(";");
      }
      while (i < paramString.length)
      {
        String[] arrayOfString = paramString[i].split(":");
        int j = a(arrayOfString[1], 0);
        arrayOfString = arrayOfString[0].split("~");
        localArrayList.add(new v(this, (int)b(arrayOfString[0], 0.0F), (int)b(arrayOfString[1], 0.0F), j));
        i += 1;
        continue;
        arrayOfString = new String[1];
        arrayOfString[0] = paramString;
        paramString = arrayOfString;
      }
      return localArrayList;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void b(XmlPullParser paramXmlPullParser, ab paramab)
  {
    int i = 1;
    paramab = (y)paramab.a(1);
    String str = paramXmlPullParser.getAttributeValue(null, "fromXScale");
    label86:
    label123:
    label160:
    label197:
    label234:
    int j;
    if (a(str))
    {
      paramab.a(2);
      paramab.a(a(str, 1.0F));
      str = paramXmlPullParser.getAttributeValue(null, "toXScale");
      if (!a(str)) {
        break label413;
      }
      paramab.b(2);
      paramab.b(a(str, 1.0F));
      str = paramXmlPullParser.getAttributeValue(null, "fromYScale");
      if (!a(str)) {
        break label432;
      }
      paramab.h(2);
      paramab.d(a(str, 1.0F));
      str = paramXmlPullParser.getAttributeValue(null, "toYScale");
      if (!a(str)) {
        break label451;
      }
      paramab.i(2);
      paramab.e(a(str, 1.0F));
      str = paramXmlPullParser.getAttributeValue(null, "pivotX");
      if (!a(str)) {
        break label470;
      }
      paramab.j(1);
      paramab.f(a(str, 0.0F));
      str = paramXmlPullParser.getAttributeValue(null, "pivotY");
      if (!a(str)) {
        break label489;
      }
      paramab.k(1);
      paramab.g(a(str, 0.0F));
      paramab.l(c(paramXmlPullParser.getAttributeValue(null, "anchor")));
      j = a(paramXmlPullParser.getAttributeValue(null, "repeatCount"), 0);
      str = paramXmlPullParser.getAttributeValue(null, "repeatMode");
      if (str == null) {
        break label524;
      }
      if (!str.equals("repeat")) {
        break label508;
      }
    }
    for (;;)
    {
      int k = a(paramXmlPullParser.getAttributeValue(null, "duration"), Integer.MAX_VALUE);
      float f = b(paramXmlPullParser.getAttributeValue(null, "speed"), Float.MAX_VALUE);
      int m = a(paramXmlPullParser.getAttributeValue(null, "startDelayTime"), 0);
      int n = a(paramXmlPullParser.getAttributeValue(null, "repeatStartDelayTime"), 0);
      paramab.f(j);
      paramab.e(i);
      paramab.g(k);
      paramab.c(f);
      paramab.c(m);
      paramab.d(n);
      return;
      paramab.a(1);
      paramab.a(b(str, 1.0F));
      break;
      label413:
      paramab.b(1);
      paramab.b(b(str, 1.0F));
      break label86;
      label432:
      paramab.h(1);
      paramab.d(b(str, 1.0F));
      break label123;
      label451:
      paramab.i(1);
      paramab.e(b(str, 1.0F));
      break label160;
      label470:
      paramab.j(0);
      paramab.f(b(str, 0.0F));
      break label197;
      label489:
      paramab.k(0);
      paramab.g(b(str, 0.0F));
      break label234;
      label508:
      if (str.equals("reverse")) {
        i = 2;
      } else {
        label524:
        i = 0;
      }
    }
  }
  
  private void b(XmlPullParser paramXmlPullParser, z paramz)
  {
    paramz = paramz.a();
    paramz.a(a(paramXmlPullParser.getAttributeValue(null, "dayOrNight"), 0));
    paramz.a(a(paramXmlPullParser.getAttributeValue(null, "sceneWidth"), 480), 480);
  }
  
  private int c(String paramString)
  {
    if ((paramString == null) || (paramString.equals("anchor_left_top"))) {}
    do
    {
      return 1;
      if (paramString.equals("anchor_left_bottom")) {
        return 2;
      }
      if (paramString.equals("anchor_right_top")) {
        return 3;
      }
      if (paramString.equals("anchor_right_bottom")) {
        return 4;
      }
    } while (!paramString.equals("anchor_center"));
    return 5;
  }
  
  private int c(String paramString, int paramInt)
  {
    int j = paramInt;
    if (paramString != null)
    {
      j = paramInt;
      if (paramString.length() > 0)
      {
        paramString = paramString.split("\\|");
        int i = 0;
        for (;;)
        {
          j = paramInt;
          if (i >= paramString.length) {
            break;
          }
          Integer localInteger = (Integer)a.get(paramString[i]);
          j = paramInt;
          if (localInteger != null) {
            j = paramInt | localInteger.intValue();
          }
          i += 1;
          paramInt = j;
        }
      }
    }
    return j;
  }
  
  private void c(XmlPullParser paramXmlPullParser, ab paramab)
  {
    int i = 1;
    paramab = (x)paramab.a(4);
    String str = paramXmlPullParser.getAttributeValue(null, "fromDegrees");
    label86:
    label123:
    label160:
    int j;
    if (a(str))
    {
      paramab.a(2);
      paramab.a(a(str, 0.0F));
      str = paramXmlPullParser.getAttributeValue(null, "toDegrees");
      if (!a(str)) {
        break label339;
      }
      paramab.b(2);
      paramab.b(a(str, 0.0F));
      str = paramXmlPullParser.getAttributeValue(null, "pivotX");
      if (!a(str)) {
        break label358;
      }
      paramab.h(1);
      paramab.d(a(str, 0.0F));
      str = paramXmlPullParser.getAttributeValue(null, "pivotY");
      if (!a(str)) {
        break label377;
      }
      paramab.i(1);
      paramab.e(a(str, 0.0F));
      paramab.j(c(paramXmlPullParser.getAttributeValue(null, "anchor")));
      j = a(paramXmlPullParser.getAttributeValue(null, "repeatCount"), 0);
      str = paramXmlPullParser.getAttributeValue(null, "repeatMode");
      if (str == null) {
        break label412;
      }
      if (!str.equals("repeat")) {
        break label396;
      }
    }
    for (;;)
    {
      int k = a(paramXmlPullParser.getAttributeValue(null, "duration"), Integer.MAX_VALUE);
      float f = b(paramXmlPullParser.getAttributeValue(null, "speed"), Float.MAX_VALUE);
      int m = a(paramXmlPullParser.getAttributeValue(null, "startDelayTime"), 0);
      int n = a(paramXmlPullParser.getAttributeValue(null, "repeatStartDelayTime"), 0);
      paramab.f(j);
      paramab.e(i);
      paramab.g(k);
      paramab.c(f);
      paramab.c(m);
      paramab.d(n);
      return;
      paramab.a(1);
      paramab.a(b(str, 0.0F));
      break;
      label339:
      paramab.b(1);
      paramab.b(b(str, 0.0F));
      break label86;
      label358:
      paramab.h(0);
      paramab.d(b(str, 0.0F));
      break label123;
      label377:
      paramab.i(0);
      paramab.e(b(str, 0.0F));
      break label160;
      label396:
      if (str.equals("reverse")) {
        i = 2;
      } else {
        label412:
        i = 0;
      }
    }
  }
  
  private void c(XmlPullParser paramXmlPullParser, z paramz)
  {
    paramz = paramz.c();
    paramz.a(b(paramXmlPullParser.getAttributeValue(null, "x"), 0.0F));
    paramz.b(b(paramXmlPullParser.getAttributeValue(null, "y"), 0.0F));
    paramz.a(a(paramXmlPullParser.getAttributeValue(null, "blur"), true));
    paramz.b(a(paramXmlPullParser.getAttributeValue(null, "previewblur"), false));
    String str = paramXmlPullParser.getAttributeValue(null, "src");
    if (str.indexOf("#") == 0) {}
    for (int i = b(str, 0);; i = 0)
    {
      paramz.a(i);
      paramz.a(str);
      paramz.b(a(paramXmlPullParser.getAttributeValue(null, "width"), 0));
      paramz.c(a(paramXmlPullParser.getAttributeValue(null, "height"), 0));
      paramz.d(c(paramXmlPullParser.getAttributeValue(null, "antialias"), 0));
      return;
    }
  }
  
  private void d(XmlPullParser paramXmlPullParser, ab paramab)
  {
    int i = 1;
    paramab = (a)paramab.a(2);
    String str = paramXmlPullParser.getAttributeValue(null, "fromAlpha");
    label86:
    int j;
    if (a(str))
    {
      paramab.a(1);
      paramab.a(a(str, 1.0F));
      str = paramXmlPullParser.getAttributeValue(null, "toAlpha");
      if (!a(str)) {
        break label248;
      }
      paramab.b(1);
      paramab.b(a(str, 1.0F));
      j = a(paramXmlPullParser.getAttributeValue(null, "repeatCount"), 0);
      str = paramXmlPullParser.getAttributeValue(null, "repeatMode");
      if (str == null) {
        break label283;
      }
      if (!str.equals("repeat")) {
        break label267;
      }
    }
    for (;;)
    {
      int k = a(paramXmlPullParser.getAttributeValue(null, "duration"), Integer.MAX_VALUE);
      float f = b(paramXmlPullParser.getAttributeValue(null, "speed"), Float.MAX_VALUE);
      int m = a(paramXmlPullParser.getAttributeValue(null, "startDelayTime"), 0);
      int n = a(paramXmlPullParser.getAttributeValue(null, "repeatStartDelayTime"), 0);
      paramab.f(j);
      paramab.e(i);
      paramab.g(k);
      paramab.c(f);
      paramab.c(m);
      paramab.d(n);
      return;
      paramab.a(0);
      paramab.a(b(str, 1.0F));
      break;
      label248:
      paramab.b(0);
      paramab.b(b(str, 1.0F));
      break label86;
      label267:
      if (str.equals("reverse")) {
        i = 2;
      } else {
        label283:
        i = 0;
      }
    }
  }
  
  private void d(XmlPullParser paramXmlPullParser, z paramz)
  {
    paramz = paramz.e();
    paramz.a(b(paramXmlPullParser.getAttributeValue(null, "x"), 0.0F));
    paramz.b(b(paramXmlPullParser.getAttributeValue(null, "y"), 0.0F));
    paramz.a(a(paramXmlPullParser.getAttributeValue(null, "blur"), true));
    paramz.b(a(paramXmlPullParser.getAttributeValue(null, "previewblur"), false));
    String str = paramXmlPullParser.getAttributeValue(null, "src");
    if (str.indexOf("#") == 0) {}
    for (int i = b(str, 0);; i = 0)
    {
      paramz.a(i);
      paramz.a(str);
      paramz.b(a(paramXmlPullParser.getAttributeValue(null, "width"), 0));
      paramz.c(a(paramXmlPullParser.getAttributeValue(null, "height"), 0));
      paramz.d(c(paramXmlPullParser.getAttributeValue(null, "antialias"), 0));
      return;
    }
  }
  
  private void e(XmlPullParser paramXmlPullParser, ab paramab)
  {
    paramab = (p)paramab.a(5);
    int j = a(paramXmlPullParser.getAttributeValue(null, "amount"), 0);
    int k = a(paramXmlPullParser.getAttributeValue(null, "repeatCount"), 0);
    String str = paramXmlPullParser.getAttributeValue(null, "repeatMode");
    int i;
    if (str != null) {
      if (str.equals("repeat")) {
        i = 1;
      }
    }
    for (;;)
    {
      int m = a(paramXmlPullParser.getAttributeValue(null, "duration"), Integer.MAX_VALUE);
      float f = b(paramXmlPullParser.getAttributeValue(null, "speed"), Float.MAX_VALUE);
      int n = a(paramXmlPullParser.getAttributeValue(null, "startDelayTime"), 0);
      int i1 = a(paramXmlPullParser.getAttributeValue(null, "repeatStartDelayTime"), 0);
      paramab.g(m);
      paramab.c(f);
      paramab.f(k);
      paramab.e(i);
      paramab.d(i1);
      paramab.c(n);
      paramab.b(j);
      a(paramXmlPullParser, paramab);
      return;
      if (str.equals("reverse")) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  private void e(XmlPullParser paramXmlPullParser, z paramz)
  {
    paramz = paramz.g();
    paramz.a(b(paramXmlPullParser.getAttributeValue(null, "x"), 0.0F));
    paramz.b(b(paramXmlPullParser.getAttributeValue(null, "y"), 0.0F));
    paramz.a(paramXmlPullParser.getAttributeValue(null, "src"));
  }
  
  private void f(XmlPullParser paramXmlPullParser, ab paramab)
  {
    int j = 0;
    paramab = (g)paramab.a(7);
    paramab.g(a(paramXmlPullParser.getAttributeValue(null, "duration"), Integer.MAX_VALUE));
    paramab.a((int)b(paramXmlPullParser.getAttributeValue(null, "initOffsetX"), 0.0F));
    paramab.b((int)b(paramXmlPullParser.getAttributeValue(null, "initOffsetY"), 0.0F));
    int k = a(paramXmlPullParser.getAttributeValue(null, "repeatCount"), 0);
    String str = paramXmlPullParser.getAttributeValue(null, "repeatMode");
    int i = j;
    if (str != null)
    {
      if (!str.equals("repeat")) {
        break label157;
      }
      i = 1;
    }
    for (;;)
    {
      paramab.e(i);
      paramab.f(k);
      paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, "direction");
      if (!paramXmlPullParser.equals("down")) {
        break;
      }
      paramab.h(4);
      return;
      label157:
      i = j;
      if (str.equals("reverse")) {
        i = 2;
      }
    }
    if (paramXmlPullParser.equals("right"))
    {
      paramab.h(2);
      return;
    }
    if (paramXmlPullParser.equals("up"))
    {
      paramab.h(3);
      return;
    }
    paramab.h(1);
  }
  
  private void f(XmlPullParser paramXmlPullParser, z paramz)
  {
    paramz = (r)paramz.a(1);
    String str = paramXmlPullParser.getAttributeValue(null, "x");
    if (a(str))
    {
      paramz.j(2);
      paramz.h(a(str, 0.0F));
      str = paramXmlPullParser.getAttributeValue(null, "y");
      if (!a(str)) {
        break label454;
      }
      paramz.k(2);
      paramz.i(a(str, 0.0F));
      label77:
      paramz.j(b(paramXmlPullParser.getAttributeValue(null, "anchorX"), paramz.q()));
      paramz.k(b(paramXmlPullParser.getAttributeValue(null, "anchorY"), paramz.r()));
      paramz.l(c(paramXmlPullParser.getAttributeValue(null, "anchor")));
      paramz.a(b(paramXmlPullParser.getAttributeValue(null, "initAlpha"), 1.0F));
      paramz.b(b(paramXmlPullParser.getAttributeValue(null, "initScaleX"), 1.0F));
      paramz.c(b(paramXmlPullParser.getAttributeValue(null, "initScaleY"), 1.0F));
      str = paramXmlPullParser.getAttributeValue(null, "initScalePivotX");
      if (!a(str)) {
        break label472;
      }
      paramz.c(1);
      paramz.d(a(str, 0.5F));
      label231:
      str = paramXmlPullParser.getAttributeValue(null, "initScalePivotY");
      if (!a(str)) {
        break label490;
      }
      paramz.d(1);
      paramz.e(a(str, 0.5F));
      label267:
      paramz.b(a(paramXmlPullParser.getAttributeValue(null, "initRotate"), 0));
      str = paramXmlPullParser.getAttributeValue(null, "initRotatePivotX");
      if (!a(str)) {
        break label508;
      }
      paramz.e(1);
      paramz.f(a(str, 0.5F));
      label322:
      str = paramXmlPullParser.getAttributeValue(null, "initRotatePivotY");
      if (!a(str)) {
        break label526;
      }
      paramz.f(1);
      paramz.g(a(str, 0.5F));
    }
    for (;;)
    {
      paramz.a(paramXmlPullParser.getAttributeValue(null, "src"));
      paramz.h(a(paramXmlPullParser.getAttributeValue(null, "width"), 0));
      paramz.i(a(paramXmlPullParser.getAttributeValue(null, "height"), 0));
      paramz.a(c(paramXmlPullParser.getAttributeValue(null, "antialias"), 0));
      a(paramXmlPullParser, paramz);
      return;
      paramz.j(1);
      paramz.h(b(str, 0.0F));
      break;
      label454:
      paramz.k(1);
      paramz.i(b(str, 0.0F));
      break label77;
      label472:
      paramz.c(0);
      paramz.d(b(str, 0.0F));
      break label231;
      label490:
      paramz.d(0);
      paramz.e(b(str, 0.0F));
      break label267;
      label508:
      paramz.e(0);
      paramz.f(b(str, 0.0F));
      break label322;
      label526:
      paramz.f(0);
      paramz.g(b(str, 0.0F));
    }
  }
  
  private ab g(XmlPullParser paramXmlPullParser, ab paramab)
  {
    int i;
    boolean bool;
    do
    {
      String str;
      for (;;)
      {
        try
        {
          if (paramXmlPullParser.next() != 1)
          {
            str = paramXmlPullParser.getName();
            if (str == null) {
              continue;
            }
            i = paramXmlPullParser.getEventType();
            if ((str.equals("translate")) && (i == 2)) {
              a(paramXmlPullParser, paramab);
            }
          }
          else
          {
            return paramab;
          }
        }
        catch (Exception paramXmlPullParser)
        {
          paramXmlPullParser.printStackTrace();
        }
        if ((str.equals("scale")) && (i == 2))
        {
          b(paramXmlPullParser, paramab);
        }
        else if ((str.equals("rotate")) && (i == 2))
        {
          c(paramXmlPullParser, paramab);
        }
        else if ((str.equals("alpha")) && (i == 2))
        {
          d(paramXmlPullParser, paramab);
        }
        else if ((str.equals("set")) && (i == 2))
        {
          g(paramXmlPullParser, (ab)paramab.a(6));
        }
        else if ((str.equals("frames")) && (i == 2))
        {
          e(paramXmlPullParser, paramab);
        }
        else
        {
          if ((!str.equals("cycle")) || (i != 2)) {
            break;
          }
          f(paramXmlPullParser, paramab);
        }
      }
      bool = str.equals("set");
    } while ((!bool) || (i != 3));
    return paramab;
  }
  
  private void g(XmlPullParser paramXmlPullParser, z paramz)
  {
    s locals = new s();
    Object localObject1 = paramXmlPullParser.getAttributeValue(null, "src");
    float f5 = b(paramXmlPullParser.getAttributeValue(null, "initAlpha"), 1.0F);
    float f6 = b(paramXmlPullParser.getAttributeValue(null, "initScaleX"), 1.0F);
    float f7 = b(paramXmlPullParser.getAttributeValue(null, "initScaleY"), 1.0F);
    int j = 1;
    Object localObject2 = paramXmlPullParser.getAttributeValue(null, "initScalePivotX");
    float f1;
    int i;
    float f2;
    label140:
    int i3;
    float f3;
    int k;
    label192:
    float f4;
    int m;
    label227:
    int i4;
    int i2;
    if (a((String)localObject2))
    {
      f1 = a((String)localObject2, 0.5F);
      i = 1;
      localObject2 = paramXmlPullParser.getAttributeValue(null, "initScalePivotY");
      if (!a((String)localObject2)) {
        break label386;
      }
      f2 = a((String)localObject2, 0.5F);
      i3 = a(paramXmlPullParser.getAttributeValue(null, "initRotate"), 0);
      localObject2 = paramXmlPullParser.getAttributeValue(null, "initRotatePivotX");
      if (!a((String)localObject2)) {
        break label401;
      }
      f3 = a((String)localObject2, 0.5F);
      k = 1;
      localObject2 = paramXmlPullParser.getAttributeValue(null, "initRotatePivotY");
      if (!a((String)localObject2)) {
        break label416;
      }
      f4 = a((String)localObject2, 0.5F);
      m = 1;
      i4 = c(paramXmlPullParser.getAttributeValue(null, "antialias"), 0);
      localObject2 = b(paramXmlPullParser.getAttributeValue(null, "x"));
      i2 = ((ArrayList)localObject2).size();
      n = 0;
    }
    int i6;
    int i7;
    for (;;)
    {
      if (n >= i2) {
        break label440;
      }
      v localv = (v)((ArrayList)localObject2).get(n);
      i5 = localv.a;
      i6 = localv.b;
      i7 = localv.c;
      i1 = 0;
      for (;;)
      {
        if (i1 < i7)
        {
          r localr = locals.a();
          localr.j(1);
          localr.h((float)(localv.a + Math.random() * (i6 - i5)));
          localr.a((String)localObject1);
          i1 += 1;
          continue;
          f1 = b((String)localObject2, 0.0F);
          i = 0;
          break;
          label386:
          f2 = b((String)localObject2, 0.0F);
          j = 0;
          break label140;
          label401:
          f3 = b((String)localObject2, 0.0F);
          k = 0;
          break label192;
          label416:
          f4 = b((String)localObject2, 0.0F);
          m = 0;
          break label227;
        }
      }
      n += 1;
    }
    label440:
    localObject1 = b(paramXmlPullParser.getAttributeValue(null, "y"));
    int i5 = ((ArrayList)localObject1).size();
    int i1 = -1;
    int n = 0;
    while (n < i5)
    {
      localObject2 = (v)((ArrayList)localObject1).get(n);
      i6 = ((v)localObject2).a;
      i7 = ((v)localObject2).b;
      int i8 = ((v)localObject2).c;
      i2 = 0;
      while (i2 < i8)
      {
        i1 += 1;
        localObject2 = locals.a(i1);
        ((r)localObject2).a(f5);
        ((r)localObject2).b(i3);
        ((r)localObject2).e(k);
        ((r)localObject2).f(f3);
        ((r)localObject2).f(m);
        ((r)localObject2).g(f4);
        ((r)localObject2).b(f6);
        ((r)localObject2).c(f7);
        ((r)localObject2).c(i);
        ((r)localObject2).d(f1);
        ((r)localObject2).d(j);
        ((r)localObject2).e(f2);
        ((r)localObject2).k(1);
        ((r)localObject2).i((float)(i6 + Math.random() * (i7 - i6)));
        ((r)localObject2).a(i4);
        i2 += 1;
      }
      n += 1;
    }
    a(paramXmlPullParser, locals);
    paramz.a(locals);
  }
  
  private void h(XmlPullParser paramXmlPullParser, z paramz)
  {
    paramz = paramz.a(0);
    String str = paramXmlPullParser.getAttributeValue(null, "x");
    if (a(str))
    {
      paramz.j(2);
      paramz.h(a(str, 0.0F));
      paramz.l(c(paramXmlPullParser.getAttributeValue(null, "anchor")));
      str = paramXmlPullParser.getAttributeValue(null, "y");
      if (!a(str)) {
        break label167;
      }
      paramz.k(2);
      paramz.i(a(str, 0.0F));
    }
    for (;;)
    {
      paramz.a(paramXmlPullParser.getAttributeValue(null, "src"));
      paramz.h(a(paramXmlPullParser.getAttributeValue(null, "width"), 0));
      paramz.i(a(paramXmlPullParser.getAttributeValue(null, "height"), 0));
      a(paramXmlPullParser, paramz);
      return;
      paramz.j(1);
      paramz.h(b(str, 0.0F));
      break;
      label167:
      paramz.k(1);
      paramz.i(b(str, 0.0F));
    }
  }
  
  public void a(XmlPullParser paramXmlPullParser, z paramz)
  {
    if ((paramXmlPullParser == null) || (paramz == null)) {}
    for (;;)
    {
      return;
      while (paramXmlPullParser.next() != 1)
      {
        String str = paramXmlPullParser.getName();
        if (str != null)
        {
          int i = paramXmlPullParser.getEventType();
          if ((str.equals("description")) && (i == 2)) {
            b(paramXmlPullParser, paramz);
          } else if ((str.equals("sensorBackground")) && (i == 2)) {
            c(paramXmlPullParser, paramz);
          } else if ((str.equals("background")) && (i == 2)) {
            d(paramXmlPullParser, paramz);
          } else if ((str.equals("foreground")) && (i == 2)) {
            e(paramXmlPullParser, paramz);
          } else if ((str.equals("image")) && (i == 2)) {
            f(paramXmlPullParser, paramz);
          } else if ((str.equals("images")) && (i == 2)) {
            g(paramXmlPullParser, paramz);
          } else if ((str.equals("imageFrame")) && (i == 2)) {
            h(paramXmlPullParser, paramz);
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/scriptengine/parser/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */