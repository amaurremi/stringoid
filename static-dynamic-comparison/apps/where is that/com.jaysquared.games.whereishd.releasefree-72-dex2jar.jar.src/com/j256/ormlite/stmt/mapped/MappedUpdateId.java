package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

public class MappedUpdateId<T, ID>
  extends BaseMappedStatement<T, ID>
{
  private MappedUpdateId(TableInfo<T, ID> paramTableInfo, String paramString, FieldType[] paramArrayOfFieldType)
  {
    super(paramTableInfo, paramString, paramArrayOfFieldType);
  }
  
  public static <T, ID> MappedUpdateId<T, ID> build(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo)
    throws SQLException
  {
    FieldType localFieldType = paramTableInfo.getIdField();
    if (localFieldType == null) {
      throw new SQLException("Cannot update-id in " + paramTableInfo.getDataClass() + " because it doesn't have an id field");
    }
    StringBuilder localStringBuilder = new StringBuilder(64);
    appendTableName(paramDatabaseType, localStringBuilder, "UPDATE ", paramTableInfo.getTableName());
    localStringBuilder.append("SET ");
    appendFieldColumnName(paramDatabaseType, localStringBuilder, localFieldType, null);
    localStringBuilder.append("= ? ");
    appendWhereFieldEq(paramDatabaseType, localFieldType, localStringBuilder, null);
    return new MappedUpdateId(paramTableInfo, localStringBuilder.toString(), new FieldType[] { localFieldType, localFieldType });
  }
  
  private Object extractIdToFieldObject(T paramT)
    throws SQLException
  {
    return this.idField.extractJavaFieldToSqlArgValue(paramT);
  }
  
  public int execute(DatabaseConnection paramDatabaseConnection, T paramT, ID paramID, ObjectCache paramObjectCache)
    throws SQLException
  {
    try
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = convertIdToFieldObject(paramID);
      arrayOfObject[1] = extractIdToFieldObject(paramT);
      int i = paramDatabaseConnection.update(this.statement, arrayOfObject, this.argFieldTypes);
      if (i > 0)
      {
        if (paramObjectCache != null)
        {
          paramDatabaseConnection = this.idField.extractJavaFieldValue(paramT);
          paramDatabaseConnection = paramObjectCache.updateId(this.clazz, paramDatabaseConnection, paramID);
          if ((paramDatabaseConnection != null) && (paramDatabaseConnection != paramT)) {
            this.idField.assignField(paramDatabaseConnection, paramID, false, paramObjectCache);
          }
        }
        this.idField.assignField(paramT, paramID, false, paramObjectCache);
      }
      logger.debug("updating-id with statement '{}' and {} args, changed {} rows", this.statement, Integer.valueOf(arrayOfObject.length), Integer.valueOf(i));
      if (arrayOfObject.length > 0) {
        logger.trace("updating-id arguments: {}", arrayOfObject);
      }
      return i;
    }
    catch (SQLException paramDatabaseConnection)
    {
      throw SqlExceptionUtil.create("Unable to run update-id stmt on object " + paramT + ": " + this.statement, paramDatabaseConnection);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/stmt/mapped/MappedUpdateId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */