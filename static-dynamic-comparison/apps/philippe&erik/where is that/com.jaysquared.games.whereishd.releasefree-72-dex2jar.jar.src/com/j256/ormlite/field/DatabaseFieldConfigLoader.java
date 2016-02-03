package com.j256.ormlite.field;

import com.j256.ormlite.misc.SqlExceptionUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;

public class DatabaseFieldConfigLoader
{
  private static final String CONFIG_FILE_END_MARKER = "# --field-end--";
  private static final String CONFIG_FILE_START_MARKER = "# --field-start--";
  private static final DataPersister DEFAULT_DATA_PERSISTER = DatabaseFieldConfig.DEFAULT_DATA_TYPE.getDataPersister();
  private static final int DEFAULT_MAX_EAGER_FOREIGN_COLLECTION_LEVEL = 1;
  private static final String FIELD_NAME_ALLOW_GENERATED_ID_INSERT = "allowGeneratedIdInsert";
  private static final String FIELD_NAME_CAN_BE_NULL = "canBeNull";
  private static final String FIELD_NAME_COLUMN_DEFINITION = "columnDefinition";
  private static final String FIELD_NAME_COLUMN_NAME = "columnName";
  private static final String FIELD_NAME_DATA_PERSISTER = "dataPersister";
  private static final String FIELD_NAME_DEFAULT_VALUE = "defaultValue";
  private static final String FIELD_NAME_FIELD_NAME = "fieldName";
  private static final String FIELD_NAME_FOREIGN = "foreign";
  private static final String FIELD_NAME_FOREIGN_AUTO_CREATE = "foreignAutoCreate";
  private static final String FIELD_NAME_FOREIGN_AUTO_REFRESH = "foreignAutoRefresh";
  private static final String FIELD_NAME_FOREIGN_COLLECTION = "foreignCollection";
  private static final String FIELD_NAME_FOREIGN_COLLECTION_COLUMN_NAME = "foreignCollectionColumnName";
  private static final String FIELD_NAME_FOREIGN_COLLECTION_EAGER = "foreignCollectionEager";
  private static final String FIELD_NAME_FOREIGN_COLLECTION_FOREIGN_FIELD_NAME = "foreignCollectionForeignFieldName";
  private static final String FIELD_NAME_FOREIGN_COLLECTION_FOREIGN_FIELD_NAME_OLD = "foreignCollectionForeignColumnName";
  private static final String FIELD_NAME_FOREIGN_COLLECTION_ORDER_ASCENDING = "foreignCollectionOrderAscending";
  private static final String FIELD_NAME_FOREIGN_COLLECTION_ORDER_COLUMN_NAME = "foreignCollectionOrderColumnName";
  private static final String FIELD_NAME_FOREIGN_COLLECTION_ORDER_COLUMN_NAME_OLD = "foreignCollectionOrderColumn";
  private static final String FIELD_NAME_FOREIGN_COLUMN_NAME = "foreignColumnName";
  private static final String FIELD_NAME_FORMAT = "format";
  private static final String FIELD_NAME_GENERATED_ID = "generatedId";
  private static final String FIELD_NAME_GENERATED_ID_SEQUENCE = "generatedIdSequence";
  private static final String FIELD_NAME_ID = "id";
  private static final String FIELD_NAME_INDEX = "index";
  private static final String FIELD_NAME_INDEX_NAME = "indexName";
  private static final String FIELD_NAME_MAX_EAGER_FOREIGN_COLLECTION_LEVEL = "foreignCollectionMaxEagerLevel";
  private static final String FIELD_NAME_MAX_EAGER_FOREIGN_COLLECTION_LEVEL_OLD = "maxEagerForeignCollectionLevel";
  private static final String FIELD_NAME_MAX_FOREIGN_AUTO_REFRESH_LEVEL = "maxForeignAutoRefreshLevel";
  private static final String FIELD_NAME_PERSISTER_CLASS = "persisterClass";
  private static final String FIELD_NAME_READ_ONLY = "readOnly";
  private static final String FIELD_NAME_THROW_IF_NULL = "throwIfNull";
  private static final String FIELD_NAME_UNIQUE = "unique";
  private static final String FIELD_NAME_UNIQUE_COMBO = "uniqueCombo";
  private static final String FIELD_NAME_UNIQUE_INDEX = "uniqueIndex";
  private static final String FIELD_NAME_UNIQUE_INDEX_NAME = "uniqueIndexName";
  private static final String FIELD_NAME_UNKNOWN_ENUM_VALUE = "unknownEnumValue";
  private static final String FIELD_NAME_USE_GET_SET = "useGetSet";
  private static final String FIELD_NAME_VERSION = "version";
  private static final String FIELD_NAME_WIDTH = "width";
  
  public static DatabaseFieldConfig fromReader(BufferedReader paramBufferedReader)
    throws SQLException
  {
    DatabaseFieldConfig localDatabaseFieldConfig = new DatabaseFieldConfig();
    for (int i = 0;; i = 1)
    {
      String str;
      do
      {
        do
        {
          try
          {
            str = paramBufferedReader.readLine();
            if (str == null)
            {
              if (i == 0) {
                break;
              }
              return localDatabaseFieldConfig;
            }
          }
          catch (IOException paramBufferedReader)
          {
            throw SqlExceptionUtil.create("Could not read DatabaseFieldConfig from stream", paramBufferedReader);
          }
        } while (str.equals("# --field-end--"));
      } while ((str.length() == 0) || (str.startsWith("#")) || (str.equals("# --field-start--")));
      String[] arrayOfString = str.split("=", -2);
      if (arrayOfString.length != 2) {
        throw new SQLException("DatabaseFieldConfig reading from stream cannot parse line: " + str);
      }
      readField(localDatabaseFieldConfig, arrayOfString[0], arrayOfString[1]);
    }
    return null;
  }
  
  private static void readField(DatabaseFieldConfig paramDatabaseFieldConfig, String paramString1, String paramString2)
  {
    if (paramString1.equals("fieldName")) {
      paramDatabaseFieldConfig.setFieldName(paramString2);
    }
    do
    {
      int j;
      do
      {
        return;
        if (paramString1.equals("columnName"))
        {
          paramDatabaseFieldConfig.setColumnName(paramString2);
          return;
        }
        if (paramString1.equals("dataPersister"))
        {
          paramDatabaseFieldConfig.setDataPersister(DataType.valueOf(paramString2).getDataPersister());
          return;
        }
        if (paramString1.equals("defaultValue"))
        {
          paramDatabaseFieldConfig.setDefaultValue(paramString2);
          return;
        }
        if (paramString1.equals("width"))
        {
          paramDatabaseFieldConfig.setWidth(Integer.parseInt(paramString2));
          return;
        }
        if (paramString1.equals("canBeNull"))
        {
          paramDatabaseFieldConfig.setCanBeNull(Boolean.parseBoolean(paramString2));
          return;
        }
        if (paramString1.equals("id"))
        {
          paramDatabaseFieldConfig.setId(Boolean.parseBoolean(paramString2));
          return;
        }
        if (paramString1.equals("generatedId"))
        {
          paramDatabaseFieldConfig.setGeneratedId(Boolean.parseBoolean(paramString2));
          return;
        }
        if (paramString1.equals("generatedIdSequence"))
        {
          paramDatabaseFieldConfig.setGeneratedIdSequence(paramString2);
          return;
        }
        if (paramString1.equals("foreign"))
        {
          paramDatabaseFieldConfig.setForeign(Boolean.parseBoolean(paramString2));
          return;
        }
        if (paramString1.equals("useGetSet"))
        {
          paramDatabaseFieldConfig.setUseGetSet(Boolean.parseBoolean(paramString2));
          return;
        }
        if (!paramString1.equals("unknownEnumValue")) {
          break;
        }
        paramString1 = paramString2.split("#", -2);
        if (paramString1.length != 2) {
          throw new IllegalArgumentException("Invalid value for unknownEnumValue which should be in class#name format: " + paramString2);
        }
        try
        {
          localObject = Class.forName(paramString1[0]);
          localObject = ((Class)localObject).getEnumConstants();
          if (localObject == null) {
            throw new IllegalArgumentException("Invalid class is not an Enum for unknownEnumValue: " + paramString2);
          }
        }
        catch (ClassNotFoundException paramDatabaseFieldConfig)
        {
          throw new IllegalArgumentException("Unknown class specified for unknownEnumValue: " + paramString2);
        }
        Object localObject = (Enum[])localObject;
        j = 0;
        int k = localObject.length;
        int i = 0;
        while (i < k)
        {
          Enum localEnum = localObject[i];
          if (localEnum.name().equals(paramString1[1]))
          {
            paramDatabaseFieldConfig.setUnknownEnumValue(localEnum);
            j = 1;
          }
          i += 1;
        }
      } while (j != 0);
      throw new IllegalArgumentException("Invalid enum value name for unknownEnumvalue: " + paramString2);
      if (paramString1.equals("throwIfNull"))
      {
        paramDatabaseFieldConfig.setThrowIfNull(Boolean.parseBoolean(paramString2));
        return;
      }
      if (paramString1.equals("format"))
      {
        paramDatabaseFieldConfig.setFormat(paramString2);
        return;
      }
      if (paramString1.equals("unique"))
      {
        paramDatabaseFieldConfig.setUnique(Boolean.parseBoolean(paramString2));
        return;
      }
      if (paramString1.equals("uniqueCombo"))
      {
        paramDatabaseFieldConfig.setUniqueCombo(Boolean.parseBoolean(paramString2));
        return;
      }
      if (paramString1.equals("index"))
      {
        paramDatabaseFieldConfig.setIndex(Boolean.parseBoolean(paramString2));
        return;
      }
      if (paramString1.equals("indexName"))
      {
        paramDatabaseFieldConfig.setIndex(true);
        paramDatabaseFieldConfig.setIndexName(paramString2);
        return;
      }
      if (paramString1.equals("uniqueIndex"))
      {
        paramDatabaseFieldConfig.setUniqueIndex(Boolean.parseBoolean(paramString2));
        return;
      }
      if (paramString1.equals("uniqueIndexName"))
      {
        paramDatabaseFieldConfig.setUniqueIndex(true);
        paramDatabaseFieldConfig.setUniqueIndexName(paramString2);
        return;
      }
      if (paramString1.equals("foreignAutoRefresh"))
      {
        paramDatabaseFieldConfig.setForeignAutoRefresh(Boolean.parseBoolean(paramString2));
        return;
      }
      if (paramString1.equals("maxForeignAutoRefreshLevel"))
      {
        paramDatabaseFieldConfig.setMaxForeignAutoRefreshLevel(Integer.parseInt(paramString2));
        return;
      }
      if (paramString1.equals("persisterClass")) {
        try
        {
          paramDatabaseFieldConfig.setPersisterClass(Class.forName(paramString2));
          return;
        }
        catch (ClassNotFoundException paramDatabaseFieldConfig)
        {
          throw new IllegalArgumentException("Could not find persisterClass: " + paramString2);
        }
      }
      if (paramString1.equals("allowGeneratedIdInsert"))
      {
        paramDatabaseFieldConfig.setAllowGeneratedIdInsert(Boolean.parseBoolean(paramString2));
        return;
      }
      if (paramString1.equals("columnDefinition"))
      {
        paramDatabaseFieldConfig.setColumnDefinition(paramString2);
        return;
      }
      if (paramString1.equals("foreignAutoCreate"))
      {
        paramDatabaseFieldConfig.setForeignAutoCreate(Boolean.parseBoolean(paramString2));
        return;
      }
      if (paramString1.equals("version"))
      {
        paramDatabaseFieldConfig.setVersion(Boolean.parseBoolean(paramString2));
        return;
      }
      if (paramString1.equals("foreignColumnName"))
      {
        paramDatabaseFieldConfig.setForeignColumnName(paramString2);
        return;
      }
      if (paramString1.equals("readOnly"))
      {
        paramDatabaseFieldConfig.setReadOnly(Boolean.parseBoolean(paramString2));
        return;
      }
      if (paramString1.equals("foreignCollection"))
      {
        paramDatabaseFieldConfig.setForeignCollection(Boolean.parseBoolean(paramString2));
        return;
      }
      if (paramString1.equals("foreignCollectionEager"))
      {
        paramDatabaseFieldConfig.setForeignCollectionEager(Boolean.parseBoolean(paramString2));
        return;
      }
      if (paramString1.equals("maxEagerForeignCollectionLevel"))
      {
        paramDatabaseFieldConfig.setForeignCollectionMaxEagerLevel(Integer.parseInt(paramString2));
        return;
      }
      if (paramString1.equals("foreignCollectionMaxEagerLevel"))
      {
        paramDatabaseFieldConfig.setForeignCollectionMaxEagerLevel(Integer.parseInt(paramString2));
        return;
      }
      if (paramString1.equals("foreignCollectionColumnName"))
      {
        paramDatabaseFieldConfig.setForeignCollectionColumnName(paramString2);
        return;
      }
      if (paramString1.equals("foreignCollectionOrderColumn"))
      {
        paramDatabaseFieldConfig.setForeignCollectionOrderColumnName(paramString2);
        return;
      }
      if (paramString1.equals("foreignCollectionOrderColumnName"))
      {
        paramDatabaseFieldConfig.setForeignCollectionOrderColumnName(paramString2);
        return;
      }
      if (paramString1.equals("foreignCollectionOrderAscending"))
      {
        paramDatabaseFieldConfig.setForeignCollectionOrderAscending(Boolean.parseBoolean(paramString2));
        return;
      }
      if (paramString1.equals("foreignCollectionForeignColumnName"))
      {
        paramDatabaseFieldConfig.setForeignCollectionForeignFieldName(paramString2);
        return;
      }
    } while (!paramString1.equals("foreignCollectionForeignFieldName"));
    paramDatabaseFieldConfig.setForeignCollectionForeignFieldName(paramString2);
  }
  
  public static void write(BufferedWriter paramBufferedWriter, DatabaseFieldConfig paramDatabaseFieldConfig, String paramString)
    throws SQLException
  {
    try
    {
      writeConfig(paramBufferedWriter, paramDatabaseFieldConfig, paramString);
      return;
    }
    catch (IOException paramBufferedWriter)
    {
      throw SqlExceptionUtil.create("Could not write config to writer", paramBufferedWriter);
    }
  }
  
  public static void writeConfig(BufferedWriter paramBufferedWriter, DatabaseFieldConfig paramDatabaseFieldConfig, String paramString)
    throws IOException
  {
    paramBufferedWriter.append("# --field-start--");
    paramBufferedWriter.newLine();
    if (paramDatabaseFieldConfig.getFieldName() != null)
    {
      paramBufferedWriter.append("fieldName").append('=').append(paramDatabaseFieldConfig.getFieldName());
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.getColumnName() != null)
    {
      paramBufferedWriter.append("columnName").append('=').append(paramDatabaseFieldConfig.getColumnName());
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.getDataPersister() != DEFAULT_DATA_PERSISTER)
    {
      int k = 0;
      localObject1 = DataType.values();
      int m = localObject1.length;
      int i = 0;
      for (;;)
      {
        int j = k;
        if (i < m)
        {
          Object localObject2 = localObject1[i];
          if (((DataType)localObject2).getDataPersister() == paramDatabaseFieldConfig.getDataPersister())
          {
            paramBufferedWriter.append("dataPersister").append('=').append(((DataType)localObject2).name());
            paramBufferedWriter.newLine();
            j = 1;
          }
        }
        else
        {
          if (j != 0) {
            break;
          }
          throw new IllegalArgumentException("Unknown data persister field: " + paramDatabaseFieldConfig.getDataPersister());
        }
        i += 1;
      }
    }
    if (paramDatabaseFieldConfig.getDefaultValue() != null)
    {
      paramBufferedWriter.append("defaultValue").append('=').append(paramDatabaseFieldConfig.getDefaultValue());
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.getWidth() != 0)
    {
      paramBufferedWriter.append("width").append('=').append(Integer.toString(paramDatabaseFieldConfig.getWidth()));
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.isCanBeNull() != true)
    {
      paramBufferedWriter.append("canBeNull").append('=').append(Boolean.toString(paramDatabaseFieldConfig.isCanBeNull()));
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.isId())
    {
      paramBufferedWriter.append("id").append('=').append("true");
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.isGeneratedId())
    {
      paramBufferedWriter.append("generatedId").append('=').append("true");
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.getGeneratedIdSequence() != null)
    {
      paramBufferedWriter.append("generatedIdSequence").append('=').append(paramDatabaseFieldConfig.getGeneratedIdSequence());
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.isForeign())
    {
      paramBufferedWriter.append("foreign").append('=').append("true");
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.isUseGetSet())
    {
      paramBufferedWriter.append("useGetSet").append('=').append("true");
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.getUnknownEnumValue() != null)
    {
      paramBufferedWriter.append("unknownEnumValue").append('=').append(paramDatabaseFieldConfig.getUnknownEnumValue().getClass().getName()).append("#").append(paramDatabaseFieldConfig.getUnknownEnumValue().name());
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.isThrowIfNull())
    {
      paramBufferedWriter.append("throwIfNull").append('=').append("true");
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.getFormat() != null)
    {
      paramBufferedWriter.append("format").append('=').append(paramDatabaseFieldConfig.getFormat());
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.isUnique())
    {
      paramBufferedWriter.append("unique").append('=').append("true");
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.isUniqueCombo())
    {
      paramBufferedWriter.append("uniqueCombo").append('=').append("true");
      paramBufferedWriter.newLine();
    }
    Object localObject1 = paramDatabaseFieldConfig.getIndexName(paramString);
    if (localObject1 != null)
    {
      paramBufferedWriter.append("indexName").append('=').append((CharSequence)localObject1);
      paramBufferedWriter.newLine();
    }
    paramString = paramDatabaseFieldConfig.getUniqueIndexName(paramString);
    if (paramString != null)
    {
      paramBufferedWriter.append("uniqueIndexName").append('=').append(paramString);
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.isForeignAutoRefresh())
    {
      paramBufferedWriter.append("foreignAutoRefresh").append('=').append("true");
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.getMaxForeignAutoRefreshLevel() != -1)
    {
      paramBufferedWriter.append("maxForeignAutoRefreshLevel").append('=').append(Integer.toString(paramDatabaseFieldConfig.getMaxForeignAutoRefreshLevel()));
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.getPersisterClass() != DatabaseFieldConfig.DEFAULT_PERSISTER_CLASS)
    {
      paramBufferedWriter.append("persisterClass").append('=').append(paramDatabaseFieldConfig.getPersisterClass().getName());
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.isAllowGeneratedIdInsert())
    {
      paramBufferedWriter.append("allowGeneratedIdInsert").append('=').append("true");
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.getColumnDefinition() != null)
    {
      paramBufferedWriter.append("columnDefinition").append('=').append(paramDatabaseFieldConfig.getColumnDefinition());
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.isForeignAutoCreate())
    {
      paramBufferedWriter.append("foreignAutoCreate").append('=').append("true");
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.isVersion())
    {
      paramBufferedWriter.append("version").append('=').append("true");
      paramBufferedWriter.newLine();
    }
    paramString = paramDatabaseFieldConfig.getForeignColumnName();
    if (paramString != null)
    {
      paramBufferedWriter.append("foreignColumnName").append('=').append(paramString);
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.isReadOnly())
    {
      paramBufferedWriter.append("readOnly").append('=').append("true");
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.isForeignCollection())
    {
      paramBufferedWriter.append("foreignCollection").append('=').append("true");
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.isForeignCollectionEager())
    {
      paramBufferedWriter.append("foreignCollectionEager").append('=').append("true");
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.getForeignCollectionMaxEagerLevel() != 1)
    {
      paramBufferedWriter.append("foreignCollectionMaxEagerLevel").append('=').append(Integer.toString(paramDatabaseFieldConfig.getForeignCollectionMaxEagerLevel()));
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.getForeignCollectionColumnName() != null)
    {
      paramBufferedWriter.append("foreignCollectionColumnName").append('=').append(paramDatabaseFieldConfig.getForeignCollectionColumnName());
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.getForeignCollectionOrderColumnName() != null)
    {
      paramBufferedWriter.append("foreignCollectionOrderColumnName").append('=').append(paramDatabaseFieldConfig.getForeignCollectionOrderColumnName());
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.isForeignCollectionOrderAscending() != true)
    {
      paramBufferedWriter.append("foreignCollectionOrderAscending").append('=').append(Boolean.toString(paramDatabaseFieldConfig.isForeignCollectionOrderAscending()));
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseFieldConfig.getForeignCollectionForeignFieldName() != null)
    {
      paramBufferedWriter.append("foreignCollectionForeignFieldName").append('=').append(paramDatabaseFieldConfig.getForeignCollectionForeignFieldName());
      paramBufferedWriter.newLine();
    }
    paramBufferedWriter.append("# --field-end--");
    paramBufferedWriter.newLine();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/field/DatabaseFieldConfigLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */