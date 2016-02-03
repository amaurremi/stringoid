package com.mongodb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class QueryBuilder
{
  private String _currentKey;
  private boolean _hasNot;
  private DBObject _query = new BasicDBObject();
  
  private void addOperand(String paramString, Object paramObject)
  {
    if (paramString == null)
    {
      paramString = (String)paramObject;
      if (this._hasNot)
      {
        paramString = new BasicDBObject("$not", paramObject);
        this._hasNot = false;
      }
      this._query.put(this._currentKey, paramString);
      return;
    }
    Object localObject;
    BasicDBObject localBasicDBObject;
    if (!(this._query.get(this._currentKey) instanceof DBObject))
    {
      localObject = new BasicDBObject();
      if (this._hasNot)
      {
        localBasicDBObject = new BasicDBObject("$not", localObject);
        this._query.put(this._currentKey, localBasicDBObject);
        this._hasNot = false;
      }
    }
    for (;;)
    {
      ((BasicDBObject)localObject).put(paramString, paramObject);
      return;
      this._query.put(this._currentKey, localObject);
      continue;
      localBasicDBObject = (BasicDBObject)this._query.get(this._currentKey);
      localObject = localBasicDBObject;
      if (localBasicDBObject.get("$not") != null) {
        localObject = (BasicDBObject)localBasicDBObject.get("$not");
      }
    }
  }
  
  public static QueryBuilder start()
  {
    return new QueryBuilder();
  }
  
  public static QueryBuilder start(String paramString)
  {
    return new QueryBuilder().put(paramString);
  }
  
  public QueryBuilder all(Object paramObject)
  {
    addOperand("$all", paramObject);
    return this;
  }
  
  public QueryBuilder and(String paramString)
  {
    return put(paramString);
  }
  
  public QueryBuilder and(DBObject... paramVarArgs)
  {
    List localList = (List)this._query.get("$and");
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this._query.put("$and", localObject);
    }
    Collections.addAll((Collection)localObject, paramVarArgs);
    return this;
  }
  
  public QueryBuilder elemMatch(DBObject paramDBObject)
  {
    addOperand("$elemMatch", paramDBObject);
    return this;
  }
  
  public QueryBuilder exists(Object paramObject)
  {
    addOperand("$exists", paramObject);
    return this;
  }
  
  public DBObject get()
  {
    Iterator localIterator = this._query.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((this._query.get(str) instanceof NullObject)) {
        throw new QueryBuilderException("No operand for key:" + str);
      }
    }
    return this._query;
  }
  
  public QueryBuilder greaterThan(Object paramObject)
  {
    addOperand("$gt", paramObject);
    return this;
  }
  
  public QueryBuilder greaterThanEquals(Object paramObject)
  {
    addOperand("$gte", paramObject);
    return this;
  }
  
  public QueryBuilder in(Object paramObject)
  {
    addOperand("$in", paramObject);
    return this;
  }
  
  public QueryBuilder is(Object paramObject)
  {
    addOperand(null, paramObject);
    return this;
  }
  
  public QueryBuilder lessThan(Object paramObject)
  {
    addOperand("$lt", paramObject);
    return this;
  }
  
  public QueryBuilder lessThanEquals(Object paramObject)
  {
    addOperand("$lte", paramObject);
    return this;
  }
  
  public QueryBuilder mod(Object paramObject)
  {
    addOperand("$mod", paramObject);
    return this;
  }
  
  public QueryBuilder near(double paramDouble1, double paramDouble2)
  {
    addOperand("$near", new Double[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    return this;
  }
  
  public QueryBuilder near(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    addOperand("$near", new Double[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2), Double.valueOf(paramDouble3) });
    return this;
  }
  
  public QueryBuilder nearSphere(double paramDouble1, double paramDouble2)
  {
    addOperand("$nearSphere", new Double[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
    return this;
  }
  
  public QueryBuilder nearSphere(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    addOperand("$nearSphere", new Double[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2), Double.valueOf(paramDouble3) });
    return this;
  }
  
  public QueryBuilder not()
  {
    this._hasNot = true;
    return this;
  }
  
  public QueryBuilder notEquals(Object paramObject)
  {
    addOperand("$ne", paramObject);
    return this;
  }
  
  public QueryBuilder notIn(Object paramObject)
  {
    addOperand("$nin", paramObject);
    return this;
  }
  
  public QueryBuilder or(DBObject... paramVarArgs)
  {
    List localList = (List)this._query.get("$or");
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this._query.put("$or", localObject);
    }
    Collections.addAll((Collection)localObject, paramVarArgs);
    return this;
  }
  
  public QueryBuilder put(String paramString)
  {
    this._currentKey = paramString;
    if (this._query.get(paramString) == null) {
      this._query.put(this._currentKey, new NullObject(null));
    }
    return this;
  }
  
  public QueryBuilder regex(Pattern paramPattern)
  {
    addOperand(null, paramPattern);
    return this;
  }
  
  public QueryBuilder size(Object paramObject)
  {
    addOperand("$size", paramObject);
    return this;
  }
  
  public QueryBuilder withinBox(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    addOperand("$within", new BasicDBObject("$box", new Object[] { { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) }, { Double.valueOf(paramDouble3), Double.valueOf(paramDouble4) } }));
    return this;
  }
  
  public QueryBuilder withinCenter(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    addOperand("$within", new BasicDBObject("$center", new Object[] { { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) }, Double.valueOf(paramDouble3) }));
    return this;
  }
  
  public QueryBuilder withinCenterSphere(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    addOperand("$within", new BasicDBObject("$centerSphere", new Object[] { { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) }, Double.valueOf(paramDouble3) }));
    return this;
  }
  
  public QueryBuilder withinPolygon(List<Double[]> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (paramList.size() < 3)) {
      throw new IllegalArgumentException("Polygon insufficient number of vertices defined");
    }
    addOperand("$within", new BasicDBObject("$polygon", paramList));
    return this;
  }
  
  private static class NullObject {}
  
  static class QueryBuilderException
    extends RuntimeException
  {
    QueryBuilderException(String paramString)
    {
      super();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/QueryBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */