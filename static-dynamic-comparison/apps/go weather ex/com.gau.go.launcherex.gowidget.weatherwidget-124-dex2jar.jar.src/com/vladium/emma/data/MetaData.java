package com.vladium.emma.data;

import com.vladium.logging.Logger;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class MetaData
  implements IMetaData, Cloneable
{
  private HashMap m_classMap;
  private boolean m_hasLineNumberInfo;
  private boolean m_hasSrcFileInfo;
  private final CoverageOptions m_options;
  private transient HashSet m_packagesWarned;
  
  MetaData(CoverageOptions paramCoverageOptions)
  {
    this.m_options = paramCoverageOptions;
    this.m_hasSrcFileInfo = true;
    this.m_hasLineNumberInfo = true;
    this.m_classMap = new HashMap();
    this.m_packagesWarned = new HashSet();
  }
  
  private MetaData(CoverageOptions paramCoverageOptions, HashMap paramHashMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.m_options = paramCoverageOptions;
    this.m_hasSrcFileInfo = paramBoolean1;
    this.m_hasLineNumberInfo = paramBoolean2;
    this.m_classMap = paramHashMap;
  }
  
  static MetaData readExternal(DataInput paramDataInput)
    throws IOException
  {
    CoverageOptions localCoverageOptions = CoverageOptions.readExternal(paramDataInput);
    boolean bool1 = paramDataInput.readBoolean();
    boolean bool2 = paramDataInput.readBoolean();
    int j = paramDataInput.readInt();
    HashMap localHashMap = new HashMap(j);
    int i = 0;
    while (i < j)
    {
      localHashMap.put(paramDataInput.readUTF(), ClassDescriptor.readExternal(paramDataInput));
      i += 1;
    }
    return new MetaData(localCoverageOptions, localHashMap, bool1, bool2);
  }
  
  static void writeExternal(MetaData paramMetaData, DataOutput paramDataOutput)
    throws IOException
  {
    CoverageOptions.writeExternal(paramMetaData.m_options, paramDataOutput);
    paramDataOutput.writeBoolean(paramMetaData.m_hasSrcFileInfo);
    paramDataOutput.writeBoolean(paramMetaData.m_hasLineNumberInfo);
    paramMetaData = paramMetaData.m_classMap;
    int j = paramMetaData.size();
    paramDataOutput.writeInt(j);
    paramMetaData = paramMetaData.entrySet().iterator();
    int i = 0;
    while (i < j)
    {
      Object localObject = (Map.Entry)paramMetaData.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (ClassDescriptor)((Map.Entry)localObject).getValue();
      paramDataOutput.writeUTF(str);
      ClassDescriptor.writeExternal((ClassDescriptor)localObject, paramDataOutput);
      i += 1;
    }
  }
  
  public boolean add(ClassDescriptor paramClassDescriptor, boolean paramBoolean)
  {
    boolean bool = false;
    Object localObject = paramClassDescriptor.getClassVMName();
    if (!paramBoolean)
    {
      paramBoolean = bool;
      if (this.m_classMap.containsKey(localObject)) {}
    }
    else
    {
      this.m_classMap.put(localObject, paramClassDescriptor);
      int i = 0;
      if (!paramClassDescriptor.hasSrcFileInfo())
      {
        this.m_hasSrcFileInfo = false;
        i = 1;
      }
      if (!paramClassDescriptor.hasCompleteLineNumberInfo())
      {
        this.m_hasLineNumberInfo = false;
        i = 1;
      }
      if (i != 0)
      {
        localObject = Logger.getLogger();
        if (((Logger)localObject).atINFO())
        {
          String str = paramClassDescriptor.getPackageVMName();
          if (this.m_packagesWarned.add(str)) {
            ((Logger)localObject).info("package [" + str + "] contains classes [" + paramClassDescriptor.getName() + "] without full debug info");
          }
        }
      }
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public CoverageOptions getOptions()
  {
    return this.m_options;
  }
  
  public boolean hasDescriptor(String paramString)
  {
    return this.m_classMap.containsKey(paramString);
  }
  
  public boolean hasLineNumberData()
  {
    return this.m_hasLineNumberInfo;
  }
  
  public boolean hasSrcFileData()
  {
    return this.m_hasSrcFileInfo;
  }
  
  public boolean isEmpty()
  {
    return this.m_classMap.isEmpty();
  }
  
  public Iterator iterator()
  {
    return this.m_classMap.values().iterator();
  }
  
  public Object lock()
  {
    return this.m_classMap;
  }
  
  public IMergeable merge(IMergeable paramIMergeable)
  {
    if ((paramIMergeable == null) || (paramIMergeable.isEmpty()) || (paramIMergeable == this)) {}
    do
    {
      return this;
      paramIMergeable = (MetaData)paramIMergeable;
      Iterator localIterator = paramIMergeable.m_classMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = ((Map.Entry)localObject).getValue();
        this.m_classMap.put(str, localObject);
      }
      if (!paramIMergeable.hasSrcFileData()) {
        this.m_hasSrcFileInfo = false;
      }
    } while (paramIMergeable.hasLineNumberData());
    this.m_hasLineNumberInfo = false;
    return this;
  }
  
  /* Error */
  public IMetaData shallowCopy()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 217	java/lang/Object:clone	()Ljava/lang/Object;
    //   4: checkcast 2	com/vladium/emma/data/MetaData
    //   7: astore_2
    //   8: aload_0
    //   9: invokevirtual 219	com/vladium/emma/data/MetaData:lock	()Ljava/lang/Object;
    //   12: astore_1
    //   13: aload_1
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 33	com/vladium/emma/data/MetaData:m_classMap	Ljava/util/HashMap;
    //   19: invokevirtual 220	java/util/HashMap:clone	()Ljava/lang/Object;
    //   22: checkcast 30	java/util/HashMap
    //   25: astore_3
    //   26: aload_1
    //   27: monitorexit
    //   28: aload_2
    //   29: aload_3
    //   30: putfield 33	com/vladium/emma/data/MetaData:m_classMap	Ljava/util/HashMap;
    //   33: aload_2
    //   34: areturn
    //   35: astore_1
    //   36: new 222	java/lang/Error
    //   39: dup
    //   40: aload_1
    //   41: invokevirtual 223	java/lang/CloneNotSupportedException:toString	()Ljava/lang/String;
    //   44: invokespecial 225	java/lang/Error:<init>	(Ljava/lang/String;)V
    //   47: athrow
    //   48: astore_2
    //   49: aload_1
    //   50: monitorexit
    //   51: aload_2
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	MetaData
    //   35	15	1	localCloneNotSupportedException	CloneNotSupportedException
    //   7	27	2	localMetaData	MetaData
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
    return this.m_classMap.size();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/data/MetaData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */