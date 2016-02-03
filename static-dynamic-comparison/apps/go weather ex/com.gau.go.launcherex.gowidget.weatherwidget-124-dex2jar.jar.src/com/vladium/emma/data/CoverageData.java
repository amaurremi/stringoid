package com.vladium.emma.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class CoverageData
  implements ICoverageData, Cloneable
{
  private HashMap m_coverageMap;
  
  CoverageData()
  {
    this.m_coverageMap = new HashMap();
  }
  
  private CoverageData(HashMap paramHashMap)
  {
    this.m_coverageMap = paramHashMap;
  }
  
  static CoverageData readExternal(DataInput paramDataInput)
    throws IOException
  {
    int k = paramDataInput.readInt();
    HashMap localHashMap = new HashMap(k);
    int i = 0;
    while (i < k)
    {
      String str = paramDataInput.readUTF();
      long l = paramDataInput.readLong();
      int m = paramDataInput.readInt();
      boolean[][] arrayOfBoolean = new boolean[m][];
      int j = 0;
      while (j < m)
      {
        arrayOfBoolean[j] = DataFactory.readBooleanArray(paramDataInput);
        j += 1;
      }
      localHashMap.put(str, new ICoverageData.DataHolder(arrayOfBoolean, l));
      i += 1;
    }
    return new CoverageData(localHashMap);
  }
  
  static void writeExternal(CoverageData paramCoverageData, DataOutput paramDataOutput)
    throws IOException
  {
    paramCoverageData = paramCoverageData.m_coverageMap;
    int k = paramCoverageData.size();
    paramDataOutput.writeInt(k);
    paramCoverageData = paramCoverageData.entrySet().iterator();
    int i = 0;
    while (i < k)
    {
      Object localObject = (Map.Entry)paramCoverageData.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (ICoverageData.DataHolder)((Map.Entry)localObject).getValue();
      boolean[][] arrayOfBoolean = ((ICoverageData.DataHolder)localObject).m_coverage;
      paramDataOutput.writeUTF(str);
      paramDataOutput.writeLong(((ICoverageData.DataHolder)localObject).m_stamp);
      int m = arrayOfBoolean.length;
      paramDataOutput.writeInt(m);
      int j = 0;
      while (j < m)
      {
        DataFactory.writeBooleanArray(arrayOfBoolean[j], paramDataOutput);
        j += 1;
      }
      i += 1;
    }
  }
  
  public void addClass(boolean[][] paramArrayOfBoolean, String paramString, long paramLong)
  {
    this.m_coverageMap.put(paramString, new ICoverageData.DataHolder(paramArrayOfBoolean, paramLong));
  }
  
  public ICoverageData.DataHolder getCoverage(ClassDescriptor paramClassDescriptor)
  {
    if (paramClassDescriptor == null) {
      throw new IllegalArgumentException("null input: cls");
    }
    return (ICoverageData.DataHolder)this.m_coverageMap.get(paramClassDescriptor.getClassVMName());
  }
  
  public boolean isEmpty()
  {
    return this.m_coverageMap.isEmpty();
  }
  
  public Object lock()
  {
    return this.m_coverageMap;
  }
  
  public IMergeable merge(IMergeable paramIMergeable)
  {
    if ((paramIMergeable == null) || (paramIMergeable.isEmpty()) || (paramIMergeable == this)) {}
    ICoverageData.DataHolder localDataHolder;
    for (;;)
    {
      return this;
      paramIMergeable = ((CoverageData)paramIMergeable).m_coverageMap.entrySet().iterator();
      while (paramIMergeable.hasNext())
      {
        localObject2 = (Map.Entry)paramIMergeable.next();
        localObject1 = (String)((Map.Entry)localObject2).getKey();
        localDataHolder = (ICoverageData.DataHolder)((Map.Entry)localObject2).getValue();
        localObject2 = (ICoverageData.DataHolder)this.m_coverageMap.get(localObject1);
        if (localObject2 == null)
        {
          this.m_coverageMap.put(localObject1, localDataHolder);
        }
        else
        {
          if (localDataHolder.m_stamp == ((ICoverageData.DataHolder)localObject2).m_stamp) {
            break label145;
          }
          this.m_coverageMap.put(localObject1, localDataHolder);
        }
      }
    }
    label145:
    Object localObject1 = localDataHolder.m_coverage;
    Object localObject2 = ((ICoverageData.DataHolder)localObject2).m_coverage;
    int i = 0;
    int k = localObject2.length;
    label166:
    Object localObject3;
    if (i < k)
    {
      localDataHolder = localObject1[i];
      localObject3 = localObject2[i];
      if (localObject3 != null) {
        break label196;
      }
    }
    for (;;)
    {
      i += 1;
      break label166;
      break;
      label196:
      int j = 0;
      int m = localObject3.length;
      while (j < m)
      {
        if (localDataHolder[j] != 0) {
          localObject3[j] = 1;
        }
        j += 1;
      }
    }
  }
  
  /* Error */
  public ICoverageData shallowCopy()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 159	java/lang/Object:clone	()Ljava/lang/Object;
    //   4: checkcast 2	com/vladium/emma/data/CoverageData
    //   7: astore_2
    //   8: aload_0
    //   9: invokevirtual 161	com/vladium/emma/data/CoverageData:lock	()Ljava/lang/Object;
    //   12: astore_1
    //   13: aload_1
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 19	com/vladium/emma/data/CoverageData:m_coverageMap	Ljava/util/HashMap;
    //   19: invokevirtual 162	java/util/HashMap:clone	()Ljava/lang/Object;
    //   22: checkcast 16	java/util/HashMap
    //   25: astore_3
    //   26: aload_1
    //   27: monitorexit
    //   28: aload_2
    //   29: aload_3
    //   30: putfield 19	com/vladium/emma/data/CoverageData:m_coverageMap	Ljava/util/HashMap;
    //   33: aload_2
    //   34: areturn
    //   35: astore_1
    //   36: new 164	java/lang/Error
    //   39: dup
    //   40: aload_1
    //   41: invokevirtual 167	java/lang/CloneNotSupportedException:toString	()Ljava/lang/String;
    //   44: invokespecial 168	java/lang/Error:<init>	(Ljava/lang/String;)V
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: monitorexit
    //   51: aload_2
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	CoverageData
    //   35	15	1	localCloneNotSupportedException	CloneNotSupportedException
    //   7	27	2	localCoverageData	CoverageData
    //   48	4	2	localObject2	Object
    //   25	5	3	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   0	8	35	java/lang/CloneNotSupportedException
    //   15	28	48	finally
    //   49	51	48	finally
  }
  
  public int size()
  {
    return this.m_coverageMap.size();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/data/CoverageData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */