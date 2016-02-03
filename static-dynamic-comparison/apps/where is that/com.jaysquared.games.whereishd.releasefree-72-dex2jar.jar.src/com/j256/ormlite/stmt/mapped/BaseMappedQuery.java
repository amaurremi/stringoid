package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.TableInfo;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseMappedQuery<T, ID>
  extends BaseMappedStatement<T, ID>
  implements GenericRowMapper<T>
{
  private Map<String, Integer> columnPositions = null;
  private Object parent = null;
  private Object parentId = null;
  protected final FieldType[] resultsFieldTypes;
  
  protected BaseMappedQuery(TableInfo<T, ID> paramTableInfo, String paramString, FieldType[] paramArrayOfFieldType1, FieldType[] paramArrayOfFieldType2)
  {
    super(paramTableInfo, paramString, paramArrayOfFieldType1);
    this.resultsFieldTypes = paramArrayOfFieldType2;
  }
  
  public T mapRow(DatabaseResults paramDatabaseResults)
    throws SQLException
  {
    if (this.columnPositions == null) {}
    ObjectCache localObjectCache;
    for (Object localObject1 = new HashMap();; localObject1 = this.columnPositions)
    {
      localObjectCache = paramDatabaseResults.getObjectCache();
      if (localObjectCache == null) {
        break;
      }
      localObject2 = this.idField.resultToJava(paramDatabaseResults, (Map)localObject1);
      localObject2 = localObjectCache.get(this.clazz, localObject2);
      if (localObject2 == null) {
        break;
      }
      return (T)localObject2;
    }
    Object localObject4 = this.tableInfo.createObject();
    Object localObject2 = null;
    int j = 0;
    Object localObject5 = this.resultsFieldTypes;
    int m = localObject5.length;
    int i = 0;
    Object localObject3;
    while (i < m)
    {
      Object localObject6 = localObject5[i];
      int k;
      if (((FieldType)localObject6).isForeignCollection())
      {
        k = 1;
        i += 1;
        j = k;
      }
      else
      {
        localObject3 = ((FieldType)localObject6).resultToJava(paramDatabaseResults, (Map)localObject1);
        if ((localObject3 != null) && (this.parent != null) && (((FieldType)localObject6).getField().getType() == this.parent.getClass()) && (localObject3.equals(this.parentId))) {
          ((FieldType)localObject6).assignField(localObject4, this.parent, true, localObjectCache);
        }
        for (;;)
        {
          k = j;
          if (localObject6 != this.idField) {
            break;
          }
          localObject2 = localObject3;
          k = j;
          break;
          ((FieldType)localObject6).assignField(localObject4, localObject3, false, localObjectCache);
        }
      }
    }
    if (j != 0)
    {
      paramDatabaseResults = this.resultsFieldTypes;
      j = paramDatabaseResults.length;
      i = 0;
      while (i < j)
      {
        localObject3 = paramDatabaseResults[i];
        if (((FieldType)localObject3).isForeignCollection())
        {
          localObject5 = ((FieldType)localObject3).buildForeignCollection(localObject4, localObject2);
          if (localObject5 != null) {
            ((FieldType)localObject3).assignField(localObject4, localObject5, false, localObjectCache);
          }
        }
        i += 1;
      }
    }
    if ((localObjectCache != null) && (localObject2 != null)) {
      localObjectCache.put(this.clazz, localObject2, localObject4);
    }
    if (this.columnPositions == null) {
      this.columnPositions = ((Map)localObject1);
    }
    return (T)localObject4;
  }
  
  public void setParentInformation(Object paramObject1, Object paramObject2)
  {
    this.parent = paramObject1;
    this.parentId = paramObject2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/stmt/mapped/BaseMappedQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */