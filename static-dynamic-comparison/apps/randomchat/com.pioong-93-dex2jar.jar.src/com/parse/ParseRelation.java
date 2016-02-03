package com.parse;

import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseRelation<T extends ParseObject>
{
  private String key;
  private ParseObject parent;
  private String targetClass;
  
  ParseRelation(ParseObject paramParseObject, String paramString)
  {
    this.parent = paramParseObject;
    this.key = paramString;
    this.targetClass = null;
  }
  
  ParseRelation(String paramString)
  {
    this.parent = null;
    this.key = null;
    this.targetClass = paramString;
  }
  
  public void add(T paramT)
  {
    paramT = new ParseRelationOperation(Collections.singleton(paramT), null);
    this.targetClass = paramT.getTargetClass();
    this.parent.performOperation(this.key, paramT);
  }
  
  JSONObject encodeToJSON()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("__type", "Relation");
    localJSONObject.put("className", this.targetClass);
    return localJSONObject;
  }
  
  void ensureParentAndKey(ParseObject paramParseObject, String paramString)
  {
    if (this.parent == null) {
      this.parent = paramParseObject;
    }
    if (this.key == null) {
      this.key = paramString;
    }
    if (this.parent != paramParseObject) {
      throw new IllegalStateException("Internal error. One ParseRelation retrieved from two different ParseObjects.");
    }
    if (!this.key.equals(paramString)) {
      throw new IllegalStateException("Internal error. One ParseRelation retrieved from two different keys.");
    }
  }
  
  public ParseQuery<T> getQuery()
  {
    ParseQuery localParseQuery;
    if (this.targetClass == null)
    {
      localParseQuery = ParseQuery.getQuery(this.parent.getClassName());
      localParseQuery.redirectClassNameForKey(this.key);
    }
    for (;;)
    {
      localParseQuery.whereRelatedTo(this.parent, this.key);
      return localParseQuery;
      localParseQuery = ParseQuery.getQuery(this.targetClass);
    }
  }
  
  String getTargetClass()
  {
    return this.targetClass;
  }
  
  public void remove(T paramT)
  {
    paramT = new ParseRelationOperation(null, Collections.singleton(paramT));
    this.targetClass = paramT.getTargetClass();
    this.parent.performOperation(this.key, paramT);
  }
  
  void setTargetClass(String paramString)
  {
    this.targetClass = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/ParseRelation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */