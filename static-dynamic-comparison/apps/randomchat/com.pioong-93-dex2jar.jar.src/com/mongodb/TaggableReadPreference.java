package com.mongodb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class TaggableReadPreference
  extends ReadPreference
{
  private static final List<DBObject> EMPTY = new ArrayList();
  final List<DBObject> _tags;
  
  TaggableReadPreference()
  {
    this._tags = EMPTY;
  }
  
  TaggableReadPreference(DBObject paramDBObject, DBObject... paramVarArgs)
  {
    if (paramDBObject == null) {
      throw new IllegalArgumentException("Must have at least one tag set");
    }
    this._tags = new ArrayList();
    this._tags.add(paramDBObject);
    Collections.addAll(this._tags, paramVarArgs);
  }
  
  private static List<ReplicaSetStatus.Tag> getTagListFromDBObject(DBObject paramDBObject)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramDBObject.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new ReplicaSetStatus.Tag(str, paramDBObject.get(str).toString()));
    }
    return localArrayList;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (TaggableReadPreference)paramObject;
    } while (this._tags.equals(((TaggableReadPreference)paramObject)._tags));
    return false;
  }
  
  public List<DBObject> getTagSets()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this._tags.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((DBObject)localIterator.next());
    }
    return localArrayList;
  }
  
  public int hashCode()
  {
    return this._tags.hashCode() * 31 + getName().hashCode();
  }
  
  public boolean isSlaveOk()
  {
    return true;
  }
  
  String printTags()
  {
    if (this._tags.isEmpty()) {
      return "";
    }
    return " : " + new BasicDBObject("tags", this._tags);
  }
  
  public DBObject toDBObject()
  {
    BasicDBObject localBasicDBObject = new BasicDBObject("mode", getName());
    if (!this._tags.isEmpty()) {
      localBasicDBObject.put("tags", this._tags);
    }
    return localBasicDBObject;
  }
  
  public String toString()
  {
    return getName() + printTags();
  }
  
  static class NearestReadPreference
    extends TaggableReadPreference
  {
    NearestReadPreference() {}
    
    NearestReadPreference(DBObject paramDBObject, DBObject... paramVarArgs)
    {
      super(paramVarArgs);
    }
    
    public String getName()
    {
      return "nearest";
    }
    
    ReplicaSetStatus.ReplicaSetNode getNode(ReplicaSetStatus.ReplicaSet paramReplicaSet)
    {
      if (this._tags.isEmpty()) {
        return paramReplicaSet.getAMember();
      }
      Iterator localIterator = this._tags.iterator();
      while (localIterator.hasNext())
      {
        ReplicaSetStatus.ReplicaSetNode localReplicaSetNode = paramReplicaSet.getAMember(TaggableReadPreference.getTagListFromDBObject((DBObject)localIterator.next()));
        if (localReplicaSetNode != null) {
          return localReplicaSetNode;
        }
      }
      return null;
    }
  }
  
  static class PrimaryPreferredReadPreference
    extends TaggableReadPreference.SecondaryReadPreference
  {
    PrimaryPreferredReadPreference() {}
    
    PrimaryPreferredReadPreference(DBObject paramDBObject, DBObject... paramVarArgs)
    {
      super(paramVarArgs);
    }
    
    public String getName()
    {
      return "primaryPreferred";
    }
    
    ReplicaSetStatus.ReplicaSetNode getNode(ReplicaSetStatus.ReplicaSet paramReplicaSet)
    {
      ReplicaSetStatus.ReplicaSetNode localReplicaSetNode = paramReplicaSet.getMaster();
      if (localReplicaSetNode != null) {
        return localReplicaSetNode;
      }
      return super.getNode(paramReplicaSet);
    }
  }
  
  static class SecondaryPreferredReadPreference
    extends TaggableReadPreference.SecondaryReadPreference
  {
    SecondaryPreferredReadPreference() {}
    
    SecondaryPreferredReadPreference(DBObject paramDBObject, DBObject... paramVarArgs)
    {
      super(paramVarArgs);
    }
    
    public String getName()
    {
      return "secondaryPreferred";
    }
    
    ReplicaSetStatus.ReplicaSetNode getNode(ReplicaSetStatus.ReplicaSet paramReplicaSet)
    {
      ReplicaSetStatus.ReplicaSetNode localReplicaSetNode = super.getNode(paramReplicaSet);
      if (localReplicaSetNode != null) {
        return localReplicaSetNode;
      }
      return paramReplicaSet.getMaster();
    }
  }
  
  static class SecondaryReadPreference
    extends TaggableReadPreference
  {
    SecondaryReadPreference() {}
    
    SecondaryReadPreference(DBObject paramDBObject, DBObject... paramVarArgs)
    {
      super(paramVarArgs);
    }
    
    public String getName()
    {
      return "secondary";
    }
    
    ReplicaSetStatus.ReplicaSetNode getNode(ReplicaSetStatus.ReplicaSet paramReplicaSet)
    {
      if (this._tags.isEmpty()) {
        return paramReplicaSet.getASecondary();
      }
      Iterator localIterator = this._tags.iterator();
      while (localIterator.hasNext())
      {
        ReplicaSetStatus.ReplicaSetNode localReplicaSetNode = paramReplicaSet.getASecondary(TaggableReadPreference.getTagListFromDBObject((DBObject)localIterator.next()));
        if (localReplicaSetNode != null) {
          return localReplicaSetNode;
        }
      }
      return null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/TaggableReadPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */