package org.bson.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.bson.util.annotations.GuardedBy;
import org.bson.util.annotations.ThreadSafe;

@ThreadSafe
abstract class CopyOnWriteMap<K, V>
  extends AbstractCopyOnWriteMap<K, V, Map<K, V>>
{
  private static final long serialVersionUID = 7935514534647505917L;
  
  @Deprecated
  protected CopyOnWriteMap()
  {
    this(Collections.emptyMap(), AbstractCopyOnWriteMap.View.Type.LIVE);
  }
  
  @Deprecated
  protected CopyOnWriteMap(Map<? extends K, ? extends V> paramMap)
  {
    this(paramMap, AbstractCopyOnWriteMap.View.Type.LIVE);
  }
  
  protected CopyOnWriteMap(Map<? extends K, ? extends V> paramMap, AbstractCopyOnWriteMap.View.Type paramType)
  {
    super(paramMap, paramType);
  }
  
  protected CopyOnWriteMap(AbstractCopyOnWriteMap.View.Type paramType)
  {
    super(Collections.emptyMap(), paramType);
  }
  
  public static <K, V> Builder<K, V> builder()
  {
    return new Builder();
  }
  
  public static <K, V> CopyOnWriteMap<K, V> newHashMap()
  {
    return builder().newHashMap();
  }
  
  public static <K, V> CopyOnWriteMap<K, V> newHashMap(Map<? extends K, ? extends V> paramMap)
  {
    return builder().addAll(paramMap).newHashMap();
  }
  
  public static <K, V> CopyOnWriteMap<K, V> newLinkedMap()
  {
    return builder().newLinkedMap();
  }
  
  public static <K, V> CopyOnWriteMap<K, V> newLinkedMap(Map<? extends K, ? extends V> paramMap)
  {
    return builder().addAll(paramMap).newLinkedMap();
  }
  
  @GuardedBy("internal-lock")
  protected abstract <N extends Map<? extends K, ? extends V>> Map<K, V> copy(N paramN);
  
  public static class Builder<K, V>
  {
    private final Map<K, V> initialValues = new HashMap();
    private AbstractCopyOnWriteMap.View.Type viewType = AbstractCopyOnWriteMap.View.Type.STABLE;
    
    public Builder<K, V> addAll(Map<? extends K, ? extends V> paramMap)
    {
      this.initialValues.putAll(paramMap);
      return this;
    }
    
    public Builder<K, V> liveViews()
    {
      this.viewType = AbstractCopyOnWriteMap.View.Type.LIVE;
      return this;
    }
    
    public CopyOnWriteMap<K, V> newHashMap()
    {
      return new CopyOnWriteMap.Hash(this.initialValues, this.viewType);
    }
    
    public CopyOnWriteMap<K, V> newLinkedMap()
    {
      return new CopyOnWriteMap.Linked(this.initialValues, this.viewType);
    }
    
    public Builder<K, V> stableViews()
    {
      this.viewType = AbstractCopyOnWriteMap.View.Type.STABLE;
      return this;
    }
  }
  
  static class Hash<K, V>
    extends CopyOnWriteMap<K, V>
  {
    private static final long serialVersionUID = 5221824943734164497L;
    
    Hash(Map<? extends K, ? extends V> paramMap, AbstractCopyOnWriteMap.View.Type paramType)
    {
      super(paramType);
    }
    
    public <N extends Map<? extends K, ? extends V>> Map<K, V> copy(N paramN)
    {
      return new HashMap(paramN);
    }
  }
  
  static class Linked<K, V>
    extends CopyOnWriteMap<K, V>
  {
    private static final long serialVersionUID = -8659999465009072124L;
    
    Linked(Map<? extends K, ? extends V> paramMap, AbstractCopyOnWriteMap.View.Type paramType)
    {
      super(paramType);
    }
    
    public <N extends Map<? extends K, ? extends V>> Map<K, V> copy(N paramN)
    {
      return new LinkedHashMap(paramN);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/util/CopyOnWriteMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */