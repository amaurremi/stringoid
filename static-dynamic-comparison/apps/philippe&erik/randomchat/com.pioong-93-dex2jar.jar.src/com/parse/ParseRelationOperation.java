package com.parse;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ParseRelationOperation<T extends ParseObject>
  implements ParseFieldOperation
{
  private Set<String> relationsToAdd;
  private Set<String> relationsToRemove;
  private String targetClass;
  
  private ParseRelationOperation(String paramString, Set<String> paramSet1, Set<String> paramSet2)
  {
    this.targetClass = paramString;
    this.relationsToAdd = new HashSet(paramSet1);
    this.relationsToRemove = new HashSet(paramSet2);
  }
  
  ParseRelationOperation(Set<T> paramSet1, Set<T> paramSet2)
  {
    this.targetClass = null;
    this.relationsToAdd = new HashSet();
    this.relationsToRemove = new HashSet();
    if (paramSet1 != null)
    {
      paramSet1 = paramSet1.iterator();
      if (paramSet1.hasNext()) {}
    }
    else if (paramSet2 != null)
    {
      paramSet1 = paramSet2.iterator();
    }
    label230:
    do
    {
      for (;;)
      {
        if (!paramSet1.hasNext())
        {
          if (this.targetClass != null) {
            return;
          }
          throw new IllegalArgumentException("Cannot create a ParseRelationOperation with no objects.");
          ParseObject localParseObject = (ParseObject)paramSet1.next();
          if (localParseObject.getObjectId() == null) {
            throw new IllegalArgumentException("All objects in a relation must have object ids.");
          }
          this.relationsToAdd.add(localParseObject.getObjectId());
          if (this.targetClass == null)
          {
            this.targetClass = localParseObject.getClassName();
            break;
          }
          if (this.targetClass.equals(localParseObject.getClassName())) {
            break;
          }
          throw new IllegalArgumentException("All objects in a relation must be of the same class.");
        }
        paramSet2 = (ParseObject)paramSet1.next();
        if (paramSet2.getObjectId() == null) {
          throw new IllegalArgumentException("All objects in a relation must have object ids.");
        }
        this.relationsToRemove.add(paramSet2.getObjectId());
        if (this.targetClass != null) {
          break label230;
        }
        this.targetClass = paramSet2.getClassName();
      }
    } while (this.targetClass.equals(paramSet2.getClassName()));
    throw new IllegalArgumentException("All objects in a relation must be of the same class.");
  }
  
  public Object apply(Object paramObject, ParseObject paramParseObject, String paramString)
  {
    if (paramObject == null)
    {
      paramObject = new ParseRelation(paramParseObject, paramString);
      ((ParseRelation)paramObject).setTargetClass(this.targetClass);
      return paramObject;
    }
    if ((paramObject instanceof ParseRelation))
    {
      paramObject = (ParseRelation)paramObject;
      if ((this.targetClass != null) && (((ParseRelation)paramObject).getTargetClass() != null))
      {
        if (!((ParseRelation)paramObject).getTargetClass().equals(this.targetClass)) {
          throw new IllegalArgumentException("Related object object must be of class " + ((ParseRelation)paramObject).getTargetClass() + ", but " + this.targetClass + " was passed in.");
        }
        ((ParseRelation)paramObject).setTargetClass(this.targetClass);
      }
      return paramObject;
    }
    throw new IllegalArgumentException("Operation is invalid after previous operation.");
  }
  
  JSONArray convertSetToArray(Set<String> paramSet)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    paramSet = paramSet.iterator();
    for (;;)
    {
      if (!paramSet.hasNext()) {
        return localJSONArray;
      }
      String str = (String)paramSet.next();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("__type", "Pointer");
      localJSONObject.put("className", this.targetClass);
      localJSONObject.put("objectId", str);
      localJSONArray.put(localJSONObject);
    }
  }
  
  public JSONObject encode()
    throws JSONException
  {
    JSONObject localJSONObject1 = null;
    JSONObject localJSONObject2 = null;
    if (this.relationsToAdd.size() > 0)
    {
      localJSONObject1 = new JSONObject();
      localJSONObject1.put("__op", "AddRelation");
      localJSONObject1.put("objects", convertSetToArray(this.relationsToAdd));
    }
    if (this.relationsToRemove.size() > 0)
    {
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("__op", "RemoveRelation");
      localJSONObject2.put("objects", convertSetToArray(this.relationsToRemove));
    }
    if ((localJSONObject1 != null) && (localJSONObject2 != null))
    {
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject3.put("__op", "Batch");
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(localJSONObject1);
      localJSONArray.put(localJSONObject2);
      localJSONObject3.put("ops", localJSONArray);
      return localJSONObject3;
    }
    if (localJSONObject1 != null) {
      return localJSONObject1;
    }
    if (localJSONObject2 != null) {
      return localJSONObject2;
    }
    throw new IllegalArgumentException("A ParseRelationOperation was created without any data.");
  }
  
  String getTargetClass()
  {
    return this.targetClass;
  }
  
  public ParseFieldOperation mergeWithPrevious(ParseFieldOperation paramParseFieldOperation)
  {
    if (paramParseFieldOperation == null) {
      return this;
    }
    if ((paramParseFieldOperation instanceof ParseDeleteOperation)) {
      throw new IllegalArgumentException("You can't modify a relation after deleting it.");
    }
    if ((paramParseFieldOperation instanceof ParseRelationOperation))
    {
      Object localObject = (ParseRelationOperation)paramParseFieldOperation;
      if ((((ParseRelationOperation)localObject).targetClass != null) && (!((ParseRelationOperation)localObject).targetClass.equals(this.targetClass))) {
        throw new IllegalArgumentException("Related object object must be of class " + ((ParseRelationOperation)localObject).targetClass + ", but " + this.targetClass + " was passed in.");
      }
      paramParseFieldOperation = new HashSet(((ParseRelationOperation)localObject).relationsToAdd);
      localObject = new HashSet(((ParseRelationOperation)localObject).relationsToRemove);
      if (this.relationsToAdd != null)
      {
        paramParseFieldOperation.addAll(this.relationsToAdd);
        ((Set)localObject).removeAll(this.relationsToAdd);
      }
      if (this.relationsToRemove != null)
      {
        paramParseFieldOperation.removeAll(this.relationsToRemove);
        ((Set)localObject).addAll(this.relationsToRemove);
      }
      return new ParseRelationOperation(this.targetClass, paramParseFieldOperation, (Set)localObject);
    }
    throw new IllegalArgumentException("Operation is invalid after previous operation.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/ParseRelationOperation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */