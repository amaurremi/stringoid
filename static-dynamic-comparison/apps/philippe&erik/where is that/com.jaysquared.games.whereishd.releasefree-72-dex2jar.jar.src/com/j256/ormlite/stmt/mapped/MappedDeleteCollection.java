package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

public class MappedDeleteCollection<T, ID>
  extends BaseMappedStatement<T, ID>
{
  private MappedDeleteCollection(TableInfo<T, ID> paramTableInfo, String paramString, FieldType[] paramArrayOfFieldType)
  {
    super(paramTableInfo, paramString, paramArrayOfFieldType);
  }
  
  private static void appendWhereIds(DatabaseType paramDatabaseType, FieldType paramFieldType, StringBuilder paramStringBuilder, int paramInt, FieldType[] paramArrayOfFieldType)
  {
    paramStringBuilder.append("WHERE ");
    paramDatabaseType.appendEscapedEntityName(paramStringBuilder, paramFieldType.getColumnName());
    paramStringBuilder.append(" IN (");
    int j = 1;
    int i = 0;
    if (i < paramInt)
    {
      if (j != 0) {
        j = 0;
      }
      for (;;)
      {
        paramStringBuilder.append('?');
        if (paramArrayOfFieldType != null) {
          paramArrayOfFieldType[i] = paramFieldType;
        }
        i += 1;
        break;
        paramStringBuilder.append(',');
      }
    }
    paramStringBuilder.append(") ");
  }
  
  private static <T, ID> MappedDeleteCollection<T, ID> build(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, int paramInt)
    throws SQLException
  {
    FieldType localFieldType = paramTableInfo.getIdField();
    if (localFieldType == null) {
      throw new SQLException("Cannot delete " + paramTableInfo.getDataClass() + " because it doesn't have an id field defined");
    }
    StringBuilder localStringBuilder = new StringBuilder(128);
    appendTableName(paramDatabaseType, localStringBuilder, "DELETE FROM ", paramTableInfo.getTableName());
    FieldType[] arrayOfFieldType = new FieldType[paramInt];
    appendWhereIds(paramDatabaseType, localFieldType, localStringBuilder, paramInt, arrayOfFieldType);
    return new MappedDeleteCollection(paramTableInfo, localStringBuilder.toString(), arrayOfFieldType);
  }
  
  public static <T, ID> int deleteIds(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, DatabaseConnection paramDatabaseConnection, Collection<ID> paramCollection, ObjectCache paramObjectCache)
    throws SQLException
  {
    paramDatabaseType = build(paramDatabaseType, paramTableInfo, paramCollection.size());
    Object[] arrayOfObject = new Object[paramCollection.size()];
    FieldType localFieldType = paramTableInfo.getIdField();
    int i = 0;
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      arrayOfObject[i] = localFieldType.convertJavaFieldToSqlArgValue(paramCollection.next());
      i += 1;
    }
    return updateRows(paramDatabaseConnection, paramTableInfo.getDataClass(), paramDatabaseType, arrayOfObject, paramObjectCache);
  }
  
  public static <T, ID> int deleteObjects(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, DatabaseConnection paramDatabaseConnection, Collection<T> paramCollection, ObjectCache paramObjectCache)
    throws SQLException
  {
    paramDatabaseType = build(paramDatabaseType, paramTableInfo, paramCollection.size());
    Object[] arrayOfObject = new Object[paramCollection.size()];
    FieldType localFieldType = paramTableInfo.getIdField();
    int i = 0;
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      arrayOfObject[i] = localFieldType.extractJavaFieldToSqlArgValue(paramCollection.next());
      i += 1;
    }
    return updateRows(paramDatabaseConnection, paramTableInfo.getDataClass(), paramDatabaseType, arrayOfObject, paramObjectCache);
  }
  
  private static <T, ID> int updateRows(DatabaseConnection paramDatabaseConnection, Class<T> paramClass, MappedDeleteCollection<T, ID> paramMappedDeleteCollection, Object[] paramArrayOfObject, ObjectCache paramObjectCache)
    throws SQLException
  {
    try
    {
      int j = paramDatabaseConnection.delete(paramMappedDeleteCollection.statement, paramArrayOfObject, paramMappedDeleteCollection.argFieldTypes);
      if ((j > 0) && (paramObjectCache != null))
      {
        int k = paramArrayOfObject.length;
        int i = 0;
        while (i < k)
        {
          paramObjectCache.remove(paramClass, paramArrayOfObject[i]);
          i += 1;
        }
      }
      logger.debug("delete-collection with statement '{}' and {} args, changed {} rows", paramMappedDeleteCollection.statement, Integer.valueOf(paramArrayOfObject.length), Integer.valueOf(j));
      if (paramArrayOfObject.length > 0) {
        logger.trace("delete-collection arguments: {}", paramArrayOfObject);
      }
      return j;
    }
    catch (SQLException paramDatabaseConnection)
    {
      throw SqlExceptionUtil.create("Unable to run delete collection stmt: " + paramMappedDeleteCollection.statement, paramDatabaseConnection);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/stmt/mapped/MappedDeleteCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */