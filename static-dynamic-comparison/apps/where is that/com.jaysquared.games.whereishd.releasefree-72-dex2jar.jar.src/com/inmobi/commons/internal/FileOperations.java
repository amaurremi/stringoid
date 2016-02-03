package com.inmobi.commons.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

public class FileOperations
{
  public static boolean getBooleanPreferences(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (paramString1 == null) || (paramString2 == null) || ("".equals(paramString1.trim())) || ("".equals(paramString2.trim())))
    {
      Log.debug("[InMobi]-4.1.1", "Failed to get preferences..App context NULL");
      return false;
    }
    return paramContext.getSharedPreferences(paramString1, 0).getBoolean(paramString2, false);
  }
  
  public static int getIntPreferences(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (paramString1 == null) || (paramString2 == null) || ("".equals(paramString1.trim())) || ("".equals(paramString2.trim())))
    {
      Log.debug("[InMobi]-4.1.1", "Failed to get preferences..App context NULL");
      return 0;
    }
    return paramContext.getSharedPreferences(paramString1, 0).getInt(paramString2, 0);
  }
  
  public static long getLongPreferences(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (paramString1 == null) || (paramString2 == null) || ("".equals(paramString1.trim())) || ("".equals(paramString2.trim())))
    {
      Log.debug("[InMobi]-4.1.1", "Failed to get preferences..App context NULL");
      return 0L;
    }
    return paramContext.getSharedPreferences(paramString1, 0).getLong(paramString2, 0L);
  }
  
  public static String getPreferences(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (paramString1 == null) || (paramString2 == null) || ("".equals(paramString1.trim())) || ("".equals(paramString2.trim())))
    {
      Log.debug("[InMobi]-4.1.1", "Failed to get preferences..App context NULL");
      return null;
    }
    return paramContext.getSharedPreferences(paramString1, 0).getString(paramString2, null);
  }
  
  public static boolean isFileExist(Context paramContext, String paramString)
  {
    boolean bool = false;
    if (new File(paramContext.getDir("data", 0), paramString).exists()) {
      bool = true;
    }
    return bool;
  }
  
  public static String readFileAsString(Context paramContext, String paramString)
    throws IOException
  {
    paramContext = new File(paramContext.getCacheDir().getAbsolutePath() + File.separator + paramString);
    paramContext.createNewFile();
    paramContext = new BufferedReader(new FileReader(paramContext));
    paramString = new StringBuffer();
    for (;;)
    {
      String str = paramContext.readLine();
      if (str == null) {
        break;
      }
      paramString.append("\n").append(str);
    }
    paramContext.close();
    if (paramString.length() >= 1) {
      return paramString.substring(1).toString();
    }
    return "";
  }
  
  public static Object readFromFile(Context paramContext, String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if ((paramContext == null) || (paramString == null) || ("".equals(paramString.trim())))
    {
      Log.internal("[InMobi]-4.1.1", "Cannot read map application context or Filename NULL");
      localObject1 = localObject2;
    }
    for (;;)
    {
      return localObject1;
      paramContext = new File(paramContext.getDir("data", 0), paramString);
      try
      {
        paramContext = new ObjectInputStream(new FileInputStream(paramContext));
      }
      catch (EOFException paramContext)
      {
        for (;;)
        {
          try
          {
            paramString = paramContext.readObject();
            localObject1 = paramString;
            if (paramContext == null) {
              break;
            }
            try
            {
              paramContext.close();
              return paramString;
            }
            catch (IOException paramContext)
            {
              Log.internal("[InMobi]-4.1.1", "Log File Close Exception");
              return Boolean.valueOf(false);
            }
            paramContext = paramContext;
            paramContext = null;
          }
          catch (ClassNotFoundException paramString)
          {
            continue;
          }
          catch (IOException paramString)
          {
            continue;
          }
          catch (StreamCorruptedException paramString)
          {
            continue;
          }
          catch (FileNotFoundException paramString)
          {
            continue;
          }
          catch (EOFException paramString)
          {
            continue;
          }
          Log.internal("[InMobi]-4.1.1", "End of File reached");
          paramString = (String)localObject1;
        }
      }
      catch (FileNotFoundException paramString)
      {
        for (;;)
        {
          paramContext = null;
          Log.internal("[InMobi]-4.1.1", "Event log File doesnot exist", paramString);
          paramString = (String)localObject1;
        }
      }
      catch (StreamCorruptedException paramString)
      {
        for (;;)
        {
          paramContext = null;
          Log.internal("[InMobi]-4.1.1", "Event log File corrupted", paramString);
          paramString = (String)localObject1;
        }
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          paramContext = null;
          Log.internal("[InMobi]-4.1.1", "Event log File IO Exception", paramString);
          paramString = (String)localObject1;
        }
      }
      catch (ClassNotFoundException paramString)
      {
        for (;;)
        {
          paramContext = null;
          Log.internal("[InMobi]-4.1.1", "Error: class not found", paramString);
          paramString = (String)localObject1;
        }
      }
    }
  }
  
  public static boolean saveToFile(Context paramContext, String paramString, Object paramObject)
  {
    if ((paramContext == null) || (paramString == null) || ("".equals(paramString.trim())) || (paramObject == null))
    {
      Log.internal("[InMobi]-4.1.1", "Cannot read map application context of Filename NULL");
      return false;
    }
    paramContext = new File(paramContext.getDir("data", 0), paramString);
    try
    {
      paramContext = new ObjectOutputStream(new FileOutputStream(paramContext, false));
      paramContext.writeObject(paramObject);
      paramContext.flush();
      if (paramContext != null) {}
      return false;
    }
    catch (FileNotFoundException paramContext)
    {
      try
      {
        paramContext.close();
        return true;
      }
      catch (IOException paramContext)
      {
        Log.internal("[InMobi]-4.1.1", "Log File Close Exception");
      }
      paramContext = paramContext;
      Log.internal("[InMobi]-4.1.1", "Log File Not found", paramContext);
      return false;
    }
    catch (IOException paramContext)
    {
      Log.internal("[InMobi]-4.1.1", "Log File IO Exception", paramContext);
      return false;
    }
  }
  
  public static void setPreferences(Context paramContext, String paramString1, String paramString2, float paramFloat)
  {
    if ((paramContext == null) || (paramString1 == null) || (paramString2 == null) || ("".equals(paramString1.trim())) || ("".equals(paramString2.trim())))
    {
      Log.debug("[InMobi]-4.1.1", "Failed to set preferences..App context NULL");
      return;
    }
    paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
    paramContext.putFloat(paramString2, paramFloat);
    paramContext.commit();
  }
  
  public static void setPreferences(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if ((paramContext == null) || (paramString1 == null) || (paramString2 == null) || ("".equals(paramString1.trim())) || ("".equals(paramString2.trim())))
    {
      Log.debug("[InMobi]-4.1.1", "Failed to set preferences..App context NULL");
      return;
    }
    paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
    paramContext.putInt(paramString2, paramInt);
    paramContext.commit();
  }
  
  public static void setPreferences(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    if ((paramContext == null) || (paramString1 == null) || (paramString2 == null) || ("".equals(paramString1.trim())) || ("".equals(paramString2.trim())))
    {
      Log.debug("[InMobi]-4.1.1", "Failed to set preferences..App context NULL");
      return;
    }
    paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
    paramContext.putLong(paramString2, paramLong);
    paramContext.commit();
  }
  
  public static void setPreferences(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramContext == null) || (paramString1 == null) || (paramString2 == null) || ("".equals(paramString1.trim())) || ("".equals(paramString2.trim())))
    {
      Log.debug("[InMobi]-4.1.1", "Failed to set preferences..App context NULL");
      return;
    }
    paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
    paramContext.putBoolean(paramString2, paramBoolean);
    paramContext.commit();
  }
  
  public static boolean setPreferences(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramContext == null) || (paramString1 == null) || (paramString2 == null) || ("".equals(paramString1.trim())) || ("".equals(paramString2.trim())))
    {
      Log.internal("[InMobi]-4.1.1", "Failed to set preferences..App context NULL");
      return false;
    }
    paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
    paramContext.putString(paramString2, paramString3);
    paramContext.commit();
    return true;
  }
  
  public static void writeStringToFile(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
    throws IOException
  {
    paramContext = new File(paramContext.getCacheDir().getAbsolutePath() + File.separator + paramString1);
    paramContext.createNewFile();
    paramContext = new BufferedWriter(new FileWriter(paramContext, paramBoolean));
    paramContext.write(paramString2);
    paramContext.close();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/internal/FileOperations.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */