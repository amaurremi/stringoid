package com.mongodb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class ReadPreference
{
  @Deprecated
  public static final ReadPreference PRIMARY = _PRIMARY;
  @Deprecated
  public static final ReadPreference SECONDARY = _SECONDARY_PREFERRED;
  private static final ReadPreference _NEAREST;
  private static final ReadPreference _PRIMARY = new PrimaryReadPreference(null);
  private static final ReadPreference _PRIMARY_PREFERRED;
  private static final ReadPreference _SECONDARY = new TaggableReadPreference.SecondaryReadPreference();
  private static final ReadPreference _SECONDARY_PREFERRED = new TaggableReadPreference.SecondaryPreferredReadPreference();
  
  static
  {
    _PRIMARY_PREFERRED = new TaggableReadPreference.PrimaryPreferredReadPreference();
    _NEAREST = new TaggableReadPreference.NearestReadPreference();
  }
  
  public static ReadPreference nearest()
  {
    return _NEAREST;
  }
  
  public static TaggableReadPreference nearest(DBObject paramDBObject, DBObject... paramVarArgs)
  {
    return new TaggableReadPreference.NearestReadPreference(paramDBObject, paramVarArgs);
  }
  
  public static ReadPreference primary()
  {
    return _PRIMARY;
  }
  
  public static ReadPreference primaryPreferred()
  {
    return _PRIMARY_PREFERRED;
  }
  
  public static TaggableReadPreference primaryPreferred(DBObject paramDBObject, DBObject... paramVarArgs)
  {
    return new TaggableReadPreference.PrimaryPreferredReadPreference(paramDBObject, paramVarArgs);
  }
  
  public static ReadPreference secondary()
  {
    return _SECONDARY;
  }
  
  public static TaggableReadPreference secondary(DBObject paramDBObject, DBObject... paramVarArgs)
  {
    return new TaggableReadPreference.SecondaryReadPreference(paramDBObject, paramVarArgs);
  }
  
  public static ReadPreference secondaryPreferred()
  {
    return _SECONDARY_PREFERRED;
  }
  
  public static TaggableReadPreference secondaryPreferred(DBObject paramDBObject, DBObject... paramVarArgs)
  {
    return new TaggableReadPreference.SecondaryPreferredReadPreference(paramDBObject, paramVarArgs);
  }
  
  public static ReadPreference valueOf(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException();
    }
    paramString = paramString.toLowerCase();
    if (paramString.equals(_PRIMARY.getName().toLowerCase())) {
      return _PRIMARY;
    }
    if (paramString.equals(_SECONDARY.getName().toLowerCase())) {
      return _SECONDARY;
    }
    if (paramString.equals(_SECONDARY_PREFERRED.getName().toLowerCase())) {
      return _SECONDARY_PREFERRED;
    }
    if (paramString.equals(_PRIMARY_PREFERRED.getName().toLowerCase())) {
      return _PRIMARY_PREFERRED;
    }
    if (paramString.equals(_NEAREST.getName().toLowerCase())) {
      return _NEAREST;
    }
    throw new IllegalArgumentException("No match for read preference of " + paramString);
  }
  
  public static TaggableReadPreference valueOf(String paramString, DBObject paramDBObject, DBObject... paramVarArgs)
  {
    if (paramString == null) {
      throw new IllegalArgumentException();
    }
    paramString = paramString.toLowerCase();
    if (paramString.equals(_SECONDARY.getName().toLowerCase())) {
      return new TaggableReadPreference.SecondaryReadPreference(paramDBObject, paramVarArgs);
    }
    if (paramString.equals(_SECONDARY_PREFERRED.getName().toLowerCase())) {
      return new TaggableReadPreference.SecondaryPreferredReadPreference(paramDBObject, paramVarArgs);
    }
    if (paramString.equals(_PRIMARY_PREFERRED.getName().toLowerCase())) {
      return new TaggableReadPreference.PrimaryPreferredReadPreference(paramDBObject, paramVarArgs);
    }
    if (paramString.equals(_NEAREST.getName().toLowerCase())) {
      return new TaggableReadPreference.NearestReadPreference(paramDBObject, paramVarArgs);
    }
    throw new IllegalArgumentException("No match for read preference of " + paramString);
  }
  
  @Deprecated
  public static ReadPreference withTags(DBObject paramDBObject)
  {
    return new TaggedReadPreference(paramDBObject);
  }
  
  @Deprecated
  public static ReadPreference withTags(Map<String, String> paramMap)
  {
    return new TaggedReadPreference(paramMap);
  }
  
  public abstract String getName();
  
  abstract ReplicaSetStatus.ReplicaSetNode getNode(ReplicaSetStatus.ReplicaSet paramReplicaSet);
  
  public abstract boolean isSlaveOk();
  
  public abstract DBObject toDBObject();
  
  private static class PrimaryReadPreference
    extends ReadPreference
  {
    public boolean equals(Object paramObject)
    {
      return (paramObject != null) && (getClass() == paramObject.getClass());
    }
    
    public String getName()
    {
      return "primary";
    }
    
    ReplicaSetStatus.ReplicaSetNode getNode(ReplicaSetStatus.ReplicaSet paramReplicaSet)
    {
      return paramReplicaSet.getMaster();
    }
    
    public int hashCode()
    {
      return getName().hashCode();
    }
    
    public boolean isSlaveOk()
    {
      return false;
    }
    
    public DBObject toDBObject()
    {
      return new BasicDBObject("mode", getName());
    }
    
    public String toString()
    {
      return getName();
    }
  }
  
  @Deprecated
  public static class TaggedReadPreference
    extends ReadPreference
  {
    private final ReadPreference _pref;
    private final DBObject _tags;
    
    public TaggedReadPreference(DBObject paramDBObject)
    {
      if ((paramDBObject == null) || (paramDBObject.keySet().size() == 0)) {
        throw new IllegalArgumentException("tags can not be null or empty");
      }
      this._tags = paramDBObject;
      paramDBObject = splitMapIntoMultipleMaps(this._tags);
      this._pref = new TaggableReadPreference.SecondaryReadPreference((DBObject)paramDBObject.get(0), getRemainingMaps(paramDBObject));
    }
    
    public TaggedReadPreference(Map<String, String> paramMap)
    {
      if ((paramMap == null) || (paramMap.size() == 0)) {
        throw new IllegalArgumentException("tags can not be null or empty");
      }
      this._tags = new BasicDBObject(paramMap);
      paramMap = splitMapIntoMultipleMaps(this._tags);
      this._pref = new TaggableReadPreference.SecondaryReadPreference((DBObject)paramMap.get(0), getRemainingMaps(paramMap));
    }
    
    private DBObject[] getRemainingMaps(List<DBObject> paramList)
    {
      if (paramList.size() <= 1) {
        return new DBObject[0];
      }
      return (DBObject[])paramList.subList(1, paramList.size() - 1).toArray(new DBObject[paramList.size() - 1]);
    }
    
    private static List<DBObject> splitMapIntoMultipleMaps(DBObject paramDBObject)
    {
      ArrayList localArrayList = new ArrayList(paramDBObject.keySet().size());
      Iterator localIterator = paramDBObject.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localArrayList.add(new BasicDBObject(str, paramDBObject.get(str).toString()));
      }
      return localArrayList;
    }
    
    public String getName()
    {
      return this._pref.getName();
    }
    
    ReplicaSetStatus.ReplicaSetNode getNode(ReplicaSetStatus.ReplicaSet paramReplicaSet)
    {
      return this._pref.getNode(paramReplicaSet);
    }
    
    public DBObject getTags()
    {
      BasicDBObject localBasicDBObject = new BasicDBObject();
      Iterator localIterator = this._tags.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localBasicDBObject.put(str, this._tags.get(str));
      }
      return localBasicDBObject;
    }
    
    public boolean isSlaveOk()
    {
      return this._pref.isSlaveOk();
    }
    
    public DBObject toDBObject()
    {
      return this._pref.toDBObject();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/ReadPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */