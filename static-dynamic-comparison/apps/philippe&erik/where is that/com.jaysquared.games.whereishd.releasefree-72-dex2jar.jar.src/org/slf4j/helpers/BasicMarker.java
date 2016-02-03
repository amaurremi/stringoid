package org.slf4j.helpers;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.slf4j.Marker;

public class BasicMarker
  implements Marker
{
  private static String CLOSE = " ]";
  private static String OPEN = "[ ";
  private static String SEP = ", ";
  private static final long serialVersionUID = 1803952589649545191L;
  private final String name;
  private List refereceList;
  
  BasicMarker(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("A merker name cannot be null");
    }
    this.name = paramString;
  }
  
  public void add(Marker paramMarker)
  {
    if (paramMarker == null) {
      try
      {
        throw new IllegalArgumentException("A null value cannot be added to a Marker as reference.");
      }
      finally {}
    }
    boolean bool = contains(paramMarker);
    if (bool) {}
    for (;;)
    {
      return;
      if (!paramMarker.contains(this))
      {
        if (this.refereceList == null) {
          this.refereceList = new Vector();
        }
        this.refereceList.add(paramMarker);
      }
    }
  }
  
  public boolean contains(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Other cannot be null");
    }
    if (this.name.equals(paramString)) {
      return true;
    }
    if (hasReferences())
    {
      int i = 0;
      for (;;)
      {
        if (i >= this.refereceList.size()) {
          break label78;
        }
        if (((Marker)this.refereceList.get(i)).contains(paramString)) {
          break;
        }
        i += 1;
      }
    }
    label78:
    return false;
  }
  
  public boolean contains(Marker paramMarker)
  {
    if (paramMarker == null) {
      throw new IllegalArgumentException("Other cannot be null");
    }
    if (equals(paramMarker)) {
      return true;
    }
    if (hasReferences())
    {
      int i = 0;
      for (;;)
      {
        if (i >= this.refereceList.size()) {
          break label75;
        }
        if (((Marker)this.refereceList.get(i)).contains(paramMarker)) {
          break;
        }
        i += 1;
      }
    }
    label75:
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == null);
      bool1 = bool2;
    } while (!(paramObject instanceof Marker));
    paramObject = (Marker)paramObject;
    return this.name.equals(((Marker)paramObject).getName());
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public boolean hasChildren()
  {
    return hasReferences();
  }
  
  /* Error */
  public boolean hasReferences()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 55	org/slf4j/helpers/BasicMarker:refereceList	Ljava/util/List;
    //   6: ifnull +23 -> 29
    //   9: aload_0
    //   10: getfield 55	org/slf4j/helpers/BasicMarker:refereceList	Ljava/util/List;
    //   13: invokeinterface 79 1 0
    //   18: istore_1
    //   19: iload_1
    //   20: ifle +9 -> 29
    //   23: iconst_1
    //   24: istore_2
    //   25: aload_0
    //   26: monitorexit
    //   27: iload_2
    //   28: ireturn
    //   29: iconst_0
    //   30: istore_2
    //   31: goto -6 -> 25
    //   34: astore_3
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_3
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	BasicMarker
    //   18	2	1	i	int
    //   24	7	2	bool	boolean
    //   34	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	34	finally
  }
  
  public int hashCode()
  {
    return this.name.hashCode();
  }
  
  /* Error */
  public Iterator iterator()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 55	org/slf4j/helpers/BasicMarker:refereceList	Ljava/util/List;
    //   6: ifnull +17 -> 23
    //   9: aload_0
    //   10: getfield 55	org/slf4j/helpers/BasicMarker:refereceList	Ljava/util/List;
    //   13: invokeinterface 98 1 0
    //   18: astore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_1
    //   22: areturn
    //   23: getstatic 103	java/util/Collections:EMPTY_LIST	Ljava/util/List;
    //   26: invokeinterface 98 1 0
    //   31: astore_1
    //   32: goto -13 -> 19
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	BasicMarker
    //   18	14	1	localIterator	Iterator
    //   35	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	35	finally
    //   23	32	35	finally
  }
  
  /* Error */
  public boolean remove(Marker paramMarker)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 55	org/slf4j/helpers/BasicMarker:refereceList	Ljava/util/List;
    //   9: astore 6
    //   11: aload 6
    //   13: ifnonnull +12 -> 25
    //   16: iload 5
    //   18: istore 4
    //   20: aload_0
    //   21: monitorexit
    //   22: iload 4
    //   24: ireturn
    //   25: aload_0
    //   26: getfield 55	org/slf4j/helpers/BasicMarker:refereceList	Ljava/util/List;
    //   29: invokeinterface 79 1 0
    //   34: istore_3
    //   35: iconst_0
    //   36: istore_2
    //   37: iload 5
    //   39: istore 4
    //   41: iload_2
    //   42: iload_3
    //   43: if_icmpge -23 -> 20
    //   46: aload_1
    //   47: aload_0
    //   48: getfield 55	org/slf4j/helpers/BasicMarker:refereceList	Ljava/util/List;
    //   51: iload_2
    //   52: invokeinterface 83 2 0
    //   57: checkcast 6	org/slf4j/Marker
    //   60: invokevirtual 105	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   63: ifeq +20 -> 83
    //   66: aload_0
    //   67: getfield 55	org/slf4j/helpers/BasicMarker:refereceList	Ljava/util/List;
    //   70: iload_2
    //   71: invokeinterface 107 2 0
    //   76: pop
    //   77: iconst_1
    //   78: istore 4
    //   80: goto -60 -> 20
    //   83: iload_2
    //   84: iconst_1
    //   85: iadd
    //   86: istore_2
    //   87: goto -50 -> 37
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	BasicMarker
    //   0	95	1	paramMarker	Marker
    //   36	51	2	i	int
    //   34	10	3	j	int
    //   18	61	4	bool1	boolean
    //   1	37	5	bool2	boolean
    //   9	3	6	localList	List
    // Exception table:
    //   from	to	target	type
    //   5	11	90	finally
    //   25	35	90	finally
    //   46	77	90	finally
  }
  
  public String toString()
  {
    if (!hasReferences()) {
      return getName();
    }
    Iterator localIterator = iterator();
    StringBuffer localStringBuffer = new StringBuffer(getName());
    localStringBuffer.append(' ').append(OPEN);
    while (localIterator.hasNext())
    {
      localStringBuffer.append(((Marker)localIterator.next()).getName());
      if (localIterator.hasNext()) {
        localStringBuffer.append(SEP);
      }
    }
    localStringBuffer.append(CLOSE);
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/slf4j/helpers/BasicMarker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */