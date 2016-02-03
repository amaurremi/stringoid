package com.google.android.gms.internal;

import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class lv
{
  private static int a(String paramString, lw.a.a[] paramArrayOfa)
  {
    int m = paramArrayOfa.length;
    int i = 0;
    int j = 14;
    if (i < m)
    {
      lw.a.a locala = paramArrayOfa[i];
      int k;
      if (j == 14) {
        if ((locala.type == 9) || (locala.type == 2) || (locala.type == 6)) {
          k = locala.type;
        }
      }
      do
      {
        do
        {
          i += 1;
          j = k;
          break;
          k = j;
        } while (locala.type == 14);
        throw new IllegalArgumentException("Unexpected TypedValue type: " + locala.type + " for key " + paramString);
        k = j;
      } while (locala.type == j);
      throw new IllegalArgumentException("The ArrayList elements should all be the same type, but ArrayList with key " + paramString + " contains items of type " + j + " and " + locala.type);
    }
    return j;
  }
  
  static int a(List<Asset> paramList, Asset paramAsset)
  {
    paramList.add(paramAsset);
    return paramList.size() - 1;
  }
  
  public static lv.a a(DataMap paramDataMap)
  {
    lw locallw = new lw();
    ArrayList localArrayList = new ArrayList();
    locallw.amr = a(paramDataMap, localArrayList);
    return new lv.a(locallw, localArrayList);
  }
  
  private static lw.a.a a(List<Asset> paramList, Object paramObject)
  {
    lw.a.a locala1 = new lw.a.a();
    if (paramObject == null)
    {
      locala1.type = 14;
      return locala1;
    }
    locala1.amv = new lw.a.a.a();
    if ((paramObject instanceof String))
    {
      locala1.type = 2;
      locala1.amv.amx = ((String)paramObject);
    }
    Object localObject2;
    Object localObject1;
    int i;
    Object localObject3;
    for (;;)
    {
      return locala1;
      if ((paramObject instanceof Integer))
      {
        locala1.type = 6;
        locala1.amv.amB = ((Integer)paramObject).intValue();
      }
      else if ((paramObject instanceof Long))
      {
        locala1.type = 5;
        locala1.amv.amA = ((Long)paramObject).longValue();
      }
      else if ((paramObject instanceof Double))
      {
        locala1.type = 3;
        locala1.amv.amy = ((Double)paramObject).doubleValue();
      }
      else if ((paramObject instanceof Float))
      {
        locala1.type = 4;
        locala1.amv.amz = ((Float)paramObject).floatValue();
      }
      else if ((paramObject instanceof Boolean))
      {
        locala1.type = 8;
        locala1.amv.amD = ((Boolean)paramObject).booleanValue();
      }
      else if ((paramObject instanceof Byte))
      {
        locala1.type = 7;
        locala1.amv.amC = ((Byte)paramObject).byteValue();
      }
      else if ((paramObject instanceof byte[]))
      {
        locala1.type = 1;
        locala1.amv.amw = ((byte[])paramObject);
      }
      else if ((paramObject instanceof String[]))
      {
        locala1.type = 11;
        locala1.amv.amG = ((String[])paramObject);
      }
      else if ((paramObject instanceof long[]))
      {
        locala1.type = 12;
        locala1.amv.amH = ((long[])paramObject);
      }
      else if ((paramObject instanceof float[]))
      {
        locala1.type = 15;
        locala1.amv.amI = ((float[])paramObject);
      }
      else if ((paramObject instanceof Asset))
      {
        locala1.type = 13;
        locala1.amv.amJ = a(paramList, (Asset)paramObject);
      }
      else
      {
        if (!(paramObject instanceof DataMap)) {
          break;
        }
        locala1.type = 9;
        paramObject = (DataMap)paramObject;
        localObject2 = ((DataMap)paramObject).keySet();
        localObject1 = new lw.a[((Set)localObject2).size()];
        localObject2 = ((Set)localObject2).iterator();
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          localObject1[i] = new lw.a();
          localObject1[i].name = ((String)localObject3);
          localObject1[i].amt = a(paramList, ((DataMap)paramObject).get((String)localObject3));
          i += 1;
        }
        locala1.amv.amE = ((lw.a[])localObject1);
      }
    }
    int j;
    label584:
    lw.a.a locala2;
    if ((paramObject instanceof ArrayList))
    {
      locala1.type = 10;
      localObject2 = (ArrayList)paramObject;
      localObject3 = new lw.a.a[((ArrayList)localObject2).size()];
      paramObject = null;
      int k = ((ArrayList)localObject2).size();
      j = 0;
      i = 14;
      if (j < k)
      {
        localObject1 = ((ArrayList)localObject2).get(j);
        locala2 = a(paramList, localObject1);
        if ((locala2.type != 14) && (locala2.type != 2) && (locala2.type != 6) && (locala2.type != 9)) {
          throw new IllegalArgumentException("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + localObject1.getClass());
        }
        if ((i == 14) && (locala2.type != 14))
        {
          i = locala2.type;
          paramObject = localObject1;
        }
      }
    }
    for (;;)
    {
      localObject3[j] = locala2;
      j += 1;
      break label584;
      if (locala2.type != i)
      {
        throw new IllegalArgumentException("ArrayList elements must all be of the sameclass, but this one contains a " + paramObject.getClass() + " and a " + localObject1.getClass());
        locala1.amv.amF = ((lw.a.a[])localObject3);
        break;
        throw new RuntimeException("newFieldValueFromValue: unexpected value " + paramObject.getClass().getSimpleName());
      }
    }
  }
  
  public static DataMap a(lv.a parama)
  {
    DataMap localDataMap = new DataMap();
    lw.a[] arrayOfa = parama.amp.amr;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      lw.a locala = arrayOfa[i];
      a(parama.amq, localDataMap, locala.name, locala.amt);
      i += 1;
    }
    return localDataMap;
  }
  
  private static ArrayList a(List<Asset> paramList, lw.a.a.a parama, int paramInt)
  {
    ArrayList localArrayList = new ArrayList(parama.amF.length);
    parama = parama.amF;
    int k = parama.length;
    int i = 0;
    if (i < k)
    {
      lw.a[] arrayOfa = parama[i];
      if (arrayOfa.type == 14) {
        localArrayList.add(null);
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramInt == 9)
        {
          DataMap localDataMap = new DataMap();
          arrayOfa = arrayOfa.amv.amE;
          int m = arrayOfa.length;
          int j = 0;
          while (j < m)
          {
            lw.a locala = arrayOfa[j];
            a(paramList, localDataMap, locala.name, locala.amt);
            j += 1;
          }
          localArrayList.add(localDataMap);
        }
        else if (paramInt == 2)
        {
          localArrayList.add(arrayOfa.amv.amx);
        }
        else
        {
          if (paramInt != 6) {
            break label191;
          }
          localArrayList.add(Integer.valueOf(arrayOfa.amv.amB));
        }
      }
      label191:
      throw new IllegalArgumentException("Unexpected typeOfArrayList: " + paramInt);
    }
    return localArrayList;
  }
  
  private static void a(List<Asset> paramList, DataMap paramDataMap, String paramString, lw.a.a parama)
  {
    int i = parama.type;
    if (i == 14)
    {
      paramDataMap.putString(paramString, null);
      return;
    }
    Object localObject1 = parama.amv;
    if (i == 1)
    {
      paramDataMap.putByteArray(paramString, ((lw.a.a.a)localObject1).amw);
      return;
    }
    if (i == 11)
    {
      paramDataMap.putStringArray(paramString, ((lw.a.a.a)localObject1).amG);
      return;
    }
    if (i == 12)
    {
      paramDataMap.putLongArray(paramString, ((lw.a.a.a)localObject1).amH);
      return;
    }
    if (i == 15)
    {
      paramDataMap.putFloatArray(paramString, ((lw.a.a.a)localObject1).amI);
      return;
    }
    if (i == 2)
    {
      paramDataMap.putString(paramString, ((lw.a.a.a)localObject1).amx);
      return;
    }
    if (i == 3)
    {
      paramDataMap.putDouble(paramString, ((lw.a.a.a)localObject1).amy);
      return;
    }
    if (i == 4)
    {
      paramDataMap.putFloat(paramString, ((lw.a.a.a)localObject1).amz);
      return;
    }
    if (i == 5)
    {
      paramDataMap.putLong(paramString, ((lw.a.a.a)localObject1).amA);
      return;
    }
    if (i == 6)
    {
      paramDataMap.putInt(paramString, ((lw.a.a.a)localObject1).amB);
      return;
    }
    if (i == 7)
    {
      paramDataMap.putByte(paramString, (byte)((lw.a.a.a)localObject1).amC);
      return;
    }
    if (i == 8)
    {
      paramDataMap.putBoolean(paramString, ((lw.a.a.a)localObject1).amD);
      return;
    }
    if (i == 13)
    {
      if (paramList == null) {
        throw new RuntimeException("populateBundle: unexpected type for: " + paramString);
      }
      paramDataMap.putAsset(paramString, (Asset)paramList.get((int)((lw.a.a.a)localObject1).amJ));
      return;
    }
    if (i == 9)
    {
      parama = new DataMap();
      localObject1 = ((lw.a.a.a)localObject1).amE;
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        a(paramList, parama, ((lw.a)localObject2).name, ((lw.a)localObject2).amt);
        i += 1;
      }
      paramDataMap.putDataMap(paramString, parama);
      return;
    }
    if (i == 10)
    {
      i = a(paramString, ((lw.a.a.a)localObject1).amF);
      paramList = a(paramList, (lw.a.a.a)localObject1, i);
      if (i == 14)
      {
        paramDataMap.putStringArrayList(paramString, paramList);
        return;
      }
      if (i == 9)
      {
        paramDataMap.putDataMapArrayList(paramString, paramList);
        return;
      }
      if (i == 2)
      {
        paramDataMap.putStringArrayList(paramString, paramList);
        return;
      }
      if (i == 6)
      {
        paramDataMap.putIntegerArrayList(paramString, paramList);
        return;
      }
      throw new IllegalStateException("Unexpected typeOfArrayList: " + i);
    }
    throw new RuntimeException("populateBundle: unexpected type " + i);
  }
  
  private static lw.a[] a(DataMap paramDataMap, List<Asset> paramList)
  {
    Object localObject1 = paramDataMap.keySet();
    lw.a[] arrayOfa = new lw.a[((Set)localObject1).size()];
    localObject1 = ((Set)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      String str = (String)((Iterator)localObject1).next();
      Object localObject2 = paramDataMap.get(str);
      arrayOfa[i] = new lw.a();
      arrayOfa[i].name = str;
      arrayOfa[i].amt = a(paramList, localObject2);
      i += 1;
    }
    return arrayOfa;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/lv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */