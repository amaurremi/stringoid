package com.mongodb;

import java.util.Set;

class QueryOpBuilder
{
  static final String READ_PREFERENCE_META_OPERATOR = "$readPreference";
  private boolean explain;
  private DBObject hintObj;
  private String hintStr;
  private DBObject orderBy;
  private DBObject query;
  private DBObject readPref;
  private boolean snapshot;
  private DBObject specialFields;
  
  private void addToQueryObject(DBObject paramDBObject1, String paramString, DBObject paramDBObject2, boolean paramBoolean)
  {
    if (paramDBObject2 == null) {}
    while ((!paramBoolean) && (paramDBObject2.keySet().size() == 0)) {
      return;
    }
    addToQueryObject(paramDBObject1, paramString, paramDBObject2);
  }
  
  private void addToQueryObject(DBObject paramDBObject, String paramString, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    paramDBObject.put(paramString, paramObject);
  }
  
  private boolean hasSpecialQueryFields()
  {
    if (this.readPref != null) {}
    while ((this.specialFields != null) || ((this.orderBy != null) && (this.orderBy.keySet().size() > 0)) || (this.hintStr != null) || (this.hintObj != null) || (this.snapshot) || (this.explain)) {
      return true;
    }
    return false;
  }
  
  public QueryOpBuilder addExplain(boolean paramBoolean)
  {
    this.explain = paramBoolean;
    return this;
  }
  
  public QueryOpBuilder addHint(DBObject paramDBObject)
  {
    this.hintObj = paramDBObject;
    return this;
  }
  
  public QueryOpBuilder addHint(String paramString)
  {
    this.hintStr = paramString;
    return this;
  }
  
  public QueryOpBuilder addOrderBy(DBObject paramDBObject)
  {
    this.orderBy = paramDBObject;
    return this;
  }
  
  public QueryOpBuilder addQuery(DBObject paramDBObject)
  {
    this.query = paramDBObject;
    return this;
  }
  
  public QueryOpBuilder addReadPreference(DBObject paramDBObject)
  {
    this.readPref = paramDBObject;
    return this;
  }
  
  public QueryOpBuilder addSnapshot(boolean paramBoolean)
  {
    this.snapshot = paramBoolean;
    return this;
  }
  
  public QueryOpBuilder addSpecialFields(DBObject paramDBObject)
  {
    this.specialFields = paramDBObject;
    return this;
  }
  
  public DBObject get()
  {
    Object localObject2 = this.query;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new BasicDBObject();
    }
    if (hasSpecialQueryFields())
    {
      if (this.specialFields == null) {}
      for (localObject2 = new BasicDBObject();; localObject2 = this.specialFields)
      {
        addToQueryObject((DBObject)localObject2, "$query", (DBObject)localObject1, true);
        addToQueryObject((DBObject)localObject2, "$orderby", this.orderBy, false);
        if (this.hintStr != null) {
          addToQueryObject((DBObject)localObject2, "$hint", this.hintStr);
        }
        if (this.hintObj != null) {
          addToQueryObject((DBObject)localObject2, "$hint", this.hintObj);
        }
        if (this.explain) {
          ((DBObject)localObject2).put("$explain", Boolean.valueOf(true));
        }
        if (this.snapshot) {
          ((DBObject)localObject2).put("$snapshot", Boolean.valueOf(true));
        }
        if (this.readPref != null) {
          ((DBObject)localObject2).put("$readPreference", this.readPref);
        }
        return (DBObject)localObject2;
      }
    }
    return (DBObject)localObject1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/QueryOpBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */