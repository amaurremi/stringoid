package com.pocket.list.widget.b.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.SparseArray;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.a.o;
import com.ideashower.readitlater.db.operation.f;
import com.ideashower.readitlater.e.x;
import com.ideashower.readitlater.util.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class d
  extends c
{
  private static ArrayList c = new ArrayList();
  private static SparseArray d;
  private static Resources e = g.c().getResources();
  private static String f = g.a(2131493524);
  private static String g = g.a(2131493496);
  
  public d(ArrayList paramArrayList, Rect paramRect, TextPaint paramTextPaint, float paramFloat, int paramInt, boolean paramBoolean)
  {
    super(a(paramArrayList, paramRect.right - paramRect.left, paramTextPaint, paramInt, paramBoolean), paramRect, paramTextPaint, paramFloat, paramInt);
  }
  
  private static String a(int paramInt, Resources paramResources)
  {
    return paramResources.getQuantityString(2131427331, paramInt, new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static String a(ArrayList paramArrayList, int paramInt1, TextPaint paramTextPaint, int paramInt2, boolean paramBoolean)
  {
    if (paramInt2 > 0) {}
    Object localObject2;
    for (int i = Math.min(paramInt1, paramInt2); i == 0; i = paramInt1)
    {
      localObject2 = "";
      return (String)localObject2;
    }
    int m = i + j.a(2.0F);
    if (paramBoolean) {}
    ArrayList localArrayList;
    Object localObject3;
    for (Object localObject1 = f + " ";; localObject1 = "")
    {
      localArrayList = c;
      localObject2 = o.c();
      localObject3 = paramArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((o)localObject2).a((x)((Iterator)localObject3).next());
        if (!localArrayList.contains(localObject4)) {
          localArrayList.add(localObject4);
        }
      }
    }
    int n = localArrayList.size();
    Object localObject4 = a(n);
    localObject4[0] = 0;
    localObject1 = (String)localObject1 + ((f)localArrayList.get(0)).h();
    int j = 0;
    int k = 0;
    if (paramTextPaint.measureText((String)localObject1) > m) {
      j = 1;
    }
    for (;;)
    {
      localArrayList.clear();
      localObject2 = localObject1;
      if (j == 0) {
        break;
      }
      if (paramBoolean)
      {
        return a(paramArrayList, paramInt1, paramTextPaint, paramInt2, false);
        i = 1;
        for (localObject2 = localObject1;; localObject2 = localObject1)
        {
          if (i >= n) {
            break label595;
          }
          localObject4[i] = ((String)localObject2).length();
          localObject3 = ((f)localArrayList.get(i)).h();
          if (i == n - 1) {}
          for (localObject1 = " " + g + " ";; localObject1 = ", ")
          {
            localObject1 = (String)localObject2 + (String)localObject1 + (String)localObject3;
            if (paramTextPaint.measureText((String)localObject2) <= m) {
              break label511;
            }
            k = i;
            i = j;
            for (;;)
            {
              j = i;
              if (k <= 0) {
                break;
              }
              localObject3 = ((String)localObject2).substring(0, localObject4[k]) + a(n - k, e);
              localObject1 = localObject3;
              j = i;
              if (paramTextPaint.measureText((String)localObject3) <= m) {
                break;
              }
              localObject1 = localObject3;
              if (k == 1)
              {
                localObject1 = ((String)localObject2).substring(0, localObject4[k]) + " " + g + " " + (n - k);
                i = 1;
              }
              k -= 1;
            }
          }
          label511:
          i += 1;
        }
      }
      paramInt1 = ((String)localObject1).length();
      paramArrayList = "";
      while (paramInt1 > 1)
      {
        paramArrayList = ((String)localObject1).substring(0, paramInt1) + "...";
        if (paramTextPaint.measureText(paramArrayList) <= m) {
          return paramArrayList;
        }
        if (paramInt1 == 2) {
          return "";
        }
        paramInt1 -= 1;
      }
      return paramArrayList;
      label595:
      localObject1 = localObject2;
      j = k;
    }
  }
  
  private static int[] a(int paramInt)
  {
    if (d == null) {
      d = new SparseArray();
    }
    int[] arrayOfInt = (int[])d.get(paramInt);
    if (arrayOfInt == null)
    {
      arrayOfInt = new int[paramInt];
      d.put(paramInt, arrayOfInt);
      return arrayOfInt;
    }
    Arrays.fill(arrayOfInt, 0);
    return arrayOfInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/widget/b/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */