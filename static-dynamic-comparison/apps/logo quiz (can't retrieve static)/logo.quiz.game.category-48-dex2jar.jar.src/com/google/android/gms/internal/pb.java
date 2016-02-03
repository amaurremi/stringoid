package com.google.android.gms.internal;

import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class pb
{
  private static int a(String paramString, pc.a.a[] paramArrayOfa)
  {
    int m = paramArrayOfa.length;
    int i = 0;
    int j = 14;
    if (i < m)
    {
      pc.a.a locala = paramArrayOfa[i];
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
  
  public static a a(DataMap paramDataMap)
  {
    pc localpc = new pc();
    ArrayList localArrayList = new ArrayList();
    localpc.avS = a(paramDataMap, localArrayList);
    return new a(localpc, localArrayList);
  }
  
  private static pc.a.a a(List<Asset> paramList, Object paramObject)
  {
    pc.a.a locala1 = new pc.a.a();
    if (paramObject == null)
    {
      locala1.type = 14;
      return locala1;
    }
    locala1.avW = new pc.a.a.a();
    if ((paramObject instanceof String))
    {
      locala1.type = 2;
      locala1.avW.avY = ((String)paramObject);
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
        locala1.avW.awc = ((Integer)paramObject).intValue();
      }
      else if ((paramObject instanceof Long))
      {
        locala1.type = 5;
        locala1.avW.awb = ((Long)paramObject).longValue();
      }
      else if ((paramObject instanceof Double))
      {
        locala1.type = 3;
        locala1.avW.avZ = ((Double)paramObject).doubleValue();
      }
      else if ((paramObject instanceof Float))
      {
        locala1.type = 4;
        locala1.avW.awa = ((Float)paramObject).floatValue();
      }
      else if ((paramObject instanceof Boolean))
      {
        locala1.type = 8;
        locala1.avW.awe = ((Boolean)paramObject).booleanValue();
      }
      else if ((paramObject instanceof Byte))
      {
        locala1.type = 7;
        locala1.avW.awd = ((Byte)paramObject).byteValue();
      }
      else if ((paramObject instanceof byte[]))
      {
        locala1.type = 1;
        locala1.avW.avX = ((byte[])paramObject);
      }
      else if ((paramObject instanceof String[]))
      {
        locala1.type = 11;
        locala1.avW.awh = ((String[])paramObject);
      }
      else if ((paramObject instanceof long[]))
      {
        locala1.type = 12;
        locala1.avW.awi = ((long[])paramObject);
      }
      else if ((paramObject instanceof float[]))
      {
        locala1.type = 15;
        locala1.avW.awj = ((float[])paramObject);
      }
      else if ((paramObject instanceof Asset))
      {
        locala1.type = 13;
        locala1.avW.awk = a(paramList, (Asset)paramObject);
      }
      else
      {
        if (!(paramObject instanceof DataMap)) {
          break;
        }
        locala1.type = 9;
        paramObject = (DataMap)paramObject;
        localObject2 = ((DataMap)paramObject).keySet();
        localObject1 = new pc.a[((Set)localObject2).size()];
        localObject2 = ((Set)localObject2).iterator();
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          localObject1[i] = new pc.a();
          localObject1[i].name = ((String)localObject3);
          localObject1[i].avU = a(paramList, ((DataMap)paramObject).get((String)localObject3));
          i += 1;
        }
        locala1.avW.awf = ((pc.a[])localObject1);
      }
    }
    int j;
    label584:
    pc.a.a locala2;
    if ((paramObject instanceof ArrayList))
    {
      locala1.type = 10;
      localObject2 = (ArrayList)paramObject;
      localObject3 = new pc.a.a[((ArrayList)localObject2).size()];
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
        locala1.avW.awg = ((pc.a.a[])localObject3);
        break;
        throw new RuntimeException("newFieldValueFromValue: unexpected value " + paramObject.getClass().getSimpleName());
      }
    }
  }
  
  public static DataMap a(a parama)
  {
    DataMap localDataMap = new DataMap();
    pc.a[] arrayOfa = parama.avQ.avS;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      pc.a locala = arrayOfa[i];
      a(parama.avR, localDataMap, locala.name, locala.avU);
      i += 1;
    }
    return localDataMap;
  }
  
  private static ArrayList a(List<Asset> paramList, pc.a.a.a parama, int paramInt)
  {
    ArrayList localArrayList = new ArrayList(parama.awg.length);
    parama = parama.awg;
    int k = parama.length;
    int i = 0;
    if (i < k)
    {
      pc.a[] arrayOfa = parama[i];
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
          arrayOfa = arrayOfa.avW.awf;
          int m = arrayOfa.length;
          int j = 0;
          while (j < m)
          {
            pc.a locala = arrayOfa[j];
            a(paramList, localDataMap, locala.name, locala.avU);
            j += 1;
          }
          localArrayList.add(localDataMap);
        }
        else if (paramInt == 2)
        {
          localArrayList.add(arrayOfa.avW.avY);
        }
        else
        {
          if (paramInt != 6) {
            break label191;
          }
          localArrayList.add(Integer.valueOf(arrayOfa.avW.awc));
        }
      }
      label191:
      throw new IllegalArgumentException("Unexpected typeOfArrayList: " + paramInt);
    }
    return localArrayList;
  }
  
  private static void a(List<Asset> paramList, DataMap paramDataMap, String paramString, pc.a.a parama)
  {
    int i = parama.type;
    if (i == 14)
    {
      paramDataMap.putString(paramString, null);
      return;
    }
    Object localObject1 = parama.avW;
    if (i == 1)
    {
      paramDataMap.putByteArray(paramString, ((pc.a.a.a)localObject1).avX);
      return;
    }
    if (i == 11)
    {
      paramDataMap.putStringArray(paramString, ((pc.a.a.a)localObject1).awh);
      return;
    }
    if (i == 12)
    {
      paramDataMap.putLongArray(paramString, ((pc.a.a.a)localObject1).awi);
      return;
    }
    if (i == 15)
    {
      paramDataMap.putFloatArray(paramString, ((pc.a.a.a)localObject1).awj);
      return;
    }
    if (i == 2)
    {
      paramDataMap.putString(paramString, ((pc.a.a.a)localObject1).avY);
      return;
    }
    if (i == 3)
    {
      paramDataMap.putDouble(paramString, ((pc.a.a.a)localObject1).avZ);
      return;
    }
    if (i == 4)
    {
      paramDataMap.putFloat(paramString, ((pc.a.a.a)localObject1).awa);
      return;
    }
    if (i == 5)
    {
      paramDataMap.putLong(paramString, ((pc.a.a.a)localObject1).awb);
      return;
    }
    if (i == 6)
    {
      paramDataMap.putInt(paramString, ((pc.a.a.a)localObject1).awc);
      return;
    }
    if (i == 7)
    {
      paramDataMap.putByte(paramString, (byte)((pc.a.a.a)localObject1).awd);
      return;
    }
    if (i == 8)
    {
      paramDataMap.putBoolean(paramString, ((pc.a.a.a)localObject1).awe);
      return;
    }
    if (i == 13)
    {
      if (paramList == null) {
        throw new RuntimeException("populateBundle: unexpected type for: " + paramString);
      }
      paramDataMap.putAsset(paramString, (Asset)paramList.get((int)((pc.a.a.a)localObject1).awk));
      return;
    }
    if (i == 9)
    {
      parama = new DataMap();
      localObject1 = ((pc.a.a.a)localObject1).awf;
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        a(paramList, parama, ((pc.a)localObject2).name, ((pc.a)localObject2).avU);
        i += 1;
      }
      paramDataMap.putDataMap(paramString, parama);
      return;
    }
    if (i == 10)
    {
      i = a(paramString, ((pc.a.a.a)localObject1).awg);
      paramList = a(paramList, (pc.a.a.a)localObject1, i);
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
  
  private static pc.a[] a(DataMap paramDataMap, List<Asset> paramList)
  {
    Object localObject1 = paramDataMap.keySet();
    pc.a[] arrayOfa = new pc.a[((Set)localObject1).size()];
    localObject1 = ((Set)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      String str = (String)((Iterator)localObject1).next();
      Object localObject2 = paramDataMap.get(str);
      arrayOfa[i] = new pc.a();
      arrayOfa[i].name = str;
      arrayOfa[i].avU = a(paramList, localObject2);
      i += 1;
    }
    return arrayOfa;
  }
  
  public static class a
  {
    public final pc avQ;
    public final List<Asset> avR;
    
    public a(pc parampc, List<Asset> paramList)
    {
      this.avQ = parampc;
      this.avR = paramList;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/pb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */