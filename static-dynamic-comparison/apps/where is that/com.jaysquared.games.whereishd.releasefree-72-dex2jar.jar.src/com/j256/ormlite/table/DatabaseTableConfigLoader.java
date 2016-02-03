package com.j256.ormlite.table;

import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import com.j256.ormlite.misc.SqlExceptionUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DatabaseTableConfigLoader
{
  private static final String CONFIG_FILE_END_MARKER = "# --table-end--";
  private static final String CONFIG_FILE_FIELDS_END = "# --table-fields-end--";
  private static final String CONFIG_FILE_FIELDS_START = "# --table-fields-start--";
  private static final String CONFIG_FILE_START_MARKER = "# --table-start--";
  private static final String FIELD_NAME_DATA_CLASS = "dataClass";
  private static final String FIELD_NAME_TABLE_NAME = "tableName";
  
  public static <T> DatabaseTableConfig<T> fromReader(BufferedReader paramBufferedReader)
    throws SQLException
  {
    DatabaseTableConfig localDatabaseTableConfig = new DatabaseTableConfig();
    int i = 0;
    for (;;)
    {
      String str;
      try
      {
        str = paramBufferedReader.readLine();
        if (str == null)
        {
          if (i == 0) {
            break;
          }
          return localDatabaseTableConfig;
        }
      }
      catch (IOException paramBufferedReader)
      {
        throw SqlExceptionUtil.create("Could not read DatabaseTableConfig from stream", paramBufferedReader);
      }
      if (!str.equals("# --table-end--")) {
        if (str.equals("# --table-fields-start--"))
        {
          readFields(paramBufferedReader, localDatabaseTableConfig);
        }
        else if ((str.length() != 0) && (!str.startsWith("#")) && (!str.equals("# --table-start--")))
        {
          String[] arrayOfString = str.split("=", -2);
          if (arrayOfString.length != 2) {
            throw new SQLException("DatabaseTableConfig reading from stream cannot parse line: " + str);
          }
          readTableField(localDatabaseTableConfig, arrayOfString[0], arrayOfString[1]);
          i = 1;
        }
      }
    }
    return null;
  }
  
  public static List<DatabaseTableConfig<?>> loadDatabaseConfigFromReader(BufferedReader paramBufferedReader)
    throws SQLException
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      DatabaseTableConfig localDatabaseTableConfig = fromReader(paramBufferedReader);
      if (localDatabaseTableConfig == null) {
        return localArrayList;
      }
      localArrayList.add(localDatabaseTableConfig);
    }
  }
  
  private static <T> void readFields(BufferedReader paramBufferedReader, DatabaseTableConfig<T> paramDatabaseTableConfig)
    throws SQLException
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        localObject = paramBufferedReader.readLine();
        if ((localObject == null) || (((String)localObject).equals("# --table-fields-end--")))
        {
          paramDatabaseTableConfig.setFieldConfigs(localArrayList);
          return;
        }
      }
      catch (IOException paramBufferedReader)
      {
        throw SqlExceptionUtil.create("Could not read next field from config file", paramBufferedReader);
      }
      Object localObject = DatabaseFieldConfigLoader.fromReader(paramBufferedReader);
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
  }
  
  private static <T> void readTableField(DatabaseTableConfig<T> paramDatabaseTableConfig, String paramString1, String paramString2)
  {
    if (paramString1.equals("dataClass")) {}
    while (!paramString1.equals("tableName")) {
      try
      {
        paramDatabaseTableConfig.setDataClass(Class.forName(paramString2));
        return;
      }
      catch (ClassNotFoundException paramDatabaseTableConfig)
      {
        throw new IllegalArgumentException("Unknown class specified for dataClass: " + paramString2);
      }
    }
    paramDatabaseTableConfig.setTableName(paramString2);
  }
  
  public static <T> void write(BufferedWriter paramBufferedWriter, DatabaseTableConfig<T> paramDatabaseTableConfig)
    throws SQLException
  {
    try
    {
      writeConfig(paramBufferedWriter, paramDatabaseTableConfig);
      return;
    }
    catch (IOException paramBufferedWriter)
    {
      throw SqlExceptionUtil.create("Could not write config to writer", paramBufferedWriter);
    }
  }
  
  private static <T> void writeConfig(BufferedWriter paramBufferedWriter, DatabaseTableConfig<T> paramDatabaseTableConfig)
    throws IOException, SQLException
  {
    paramBufferedWriter.append("# --table-start--");
    paramBufferedWriter.newLine();
    if (paramDatabaseTableConfig.getDataClass() != null)
    {
      paramBufferedWriter.append("dataClass").append('=').append(paramDatabaseTableConfig.getDataClass().getName());
      paramBufferedWriter.newLine();
    }
    if (paramDatabaseTableConfig.getTableName() != null)
    {
      paramBufferedWriter.append("tableName").append('=').append(paramDatabaseTableConfig.getTableName());
      paramBufferedWriter.newLine();
    }
    paramBufferedWriter.append("# --table-fields-start--");
    paramBufferedWriter.newLine();
    if (paramDatabaseTableConfig.getFieldConfigs() != null)
    {
      Iterator localIterator = paramDatabaseTableConfig.getFieldConfigs().iterator();
      while (localIterator.hasNext()) {
        DatabaseFieldConfigLoader.write(paramBufferedWriter, (DatabaseFieldConfig)localIterator.next(), paramDatabaseTableConfig.getTableName());
      }
    }
    paramBufferedWriter.append("# --table-fields-end--");
    paramBufferedWriter.newLine();
    paramBufferedWriter.append("# --table-end--");
    paramBufferedWriter.newLine();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/table/DatabaseTableConfigLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */