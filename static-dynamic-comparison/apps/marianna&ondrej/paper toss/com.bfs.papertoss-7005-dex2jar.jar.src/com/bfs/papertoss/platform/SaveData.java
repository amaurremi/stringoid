package com.bfs.papertoss.platform;

import android.content.Context;
import android.util.Log;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.util.HashMap;

public class SaveData
{
  private static final String[] BUCKETS = { "raught8734yewrliu", "y34qq87rweyufhie", "UYGO*^Tyg^*tYJGo86tU", "GO7ti76RFhgF76rTJYT", "LUYTi76rtf&^r", "$#@tr3w$T@qRWasT$@Qwq1", "_)I[oI0[i{io-0iO:i", "MBNVCHGcmnBYT%786%76%", "��TERWy54wTE", "�a���o�y�����������" };
  private static final String DEFAULT_GROUP = "DEFAULT_GROUP";
  private static final String OBFUSCATED = "OBFUSCATED";
  private static final String SAVE_FILE = "savedata.xml";
  private static boolean modified = false;
  private static HashMap save_data = null;
  
  private static String convertToHex(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    int k;
    int j;
    if (i < paramArrayOfByte.length)
    {
      k = paramArrayOfByte[i] >>> 4 & 0xF;
      j = 0;
    }
    for (;;)
    {
      if ((k >= 0) && (k <= 9)) {
        localStringBuffer.append((char)(k + 48));
      }
      for (;;)
      {
        k = paramArrayOfByte[i] & 0xF;
        if (j < 1) {
          break label91;
        }
        i += 1;
        break;
        localStringBuffer.append((char)(k - 10 + 97));
      }
      return localStringBuffer.toString();
      label91:
      j += 1;
    }
  }
  
  public static void deleteGroup(String paramString)
  {
    save_data.remove(paramString);
    modified = true;
  }
  
  public static void deleteKey(String paramString1, String paramString2)
  {
    getGroup(paramString2).remove(paramString1);
    modified = true;
  }
  
  public static HashMap getGroup(String paramString)
  {
    if ((paramString == null) || (paramString.compareTo("") == 0)) {
      return save_data;
    }
    Object localObject = save_data.get(paramString);
    if (localObject != null)
    {
      if ((localObject instanceof HashMap)) {
        return (HashMap)localObject;
      }
      Log.w("SaveData", "Inavlid group for save data: " + paramString + ". Value will not be saved.");
      return null;
    }
    localObject = new HashMap();
    save_data.put(paramString, localObject);
    return (HashMap)localObject;
  }
  
  public static String getSHA(String paramString)
  {
    try
    {
      paramString = paramString + BUCKETS[(Math.abs(paramString.hashCode()) % BUCKETS.length)];
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA");
      byte[] arrayOfByte = new byte[32];
      localMessageDigest.update(paramString.getBytes("iso-8859-1"), 0, paramString.length());
      paramString = convertToHex(localMessageDigest.digest());
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public static boolean groupExists(String paramString)
  {
    if ((paramString == null) || (paramString.compareTo("") == 0)) {
      return true;
    }
    return save_data.containsKey(paramString);
  }
  
  public static boolean keyExists(String paramString1, String paramString2)
  {
    return getGroup(paramString2).containsKey(paramString1);
  }
  
  public static boolean load()
  {
    modified = false;
    Object localObject = null;
    try
    {
      FileInputStream localFileInputStream = Globals.m_context.openFileInput("savedata.xml");
      localObject = localFileInputStream;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;) {}
    }
    if (localObject != null) {
      try
      {
        localObject = new ObjectInputStream((InputStream)localObject);
        save_data = (HashMap)((ObjectInputStream)localObject).readObject();
        ((ObjectInputStream)localObject).close();
        return true;
      }
      catch (Exception localException)
      {
        Log.w("SaveData", "There was an error reading the saved data.", localException);
        localException.printStackTrace();
      }
    }
    save_data = new HashMap();
    return false;
  }
  
  public static void main(String[] paramArrayOfString) {}
  
  public static boolean obfuscatedKeyExists(String paramString)
  {
    return keyExists(paramString, "OBFUSCATED");
  }
  
  public static int obfuscatedRead(int paramInt, String paramString)
  {
    int i = read(0, paramString, "OBFUSCATED");
    int j = read(0, paramString + "modifier", "OBFUSCATED");
    paramString = read("", paramString + "hash", "OBFUSCATED");
    if (getSHA(i + "-" + j).compareTo(paramString) == 0) {
      return i;
    }
    return paramInt;
  }
  
  public static void obfuscatedWrite(int paramInt, String paramString)
  {
    int i = (int)System.currentTimeMillis();
    String str = getSHA(paramInt + "-" + i);
    write(Integer.valueOf(paramInt), paramString, "OBFUSCATED");
    write(Integer.valueOf(i), paramString + "modifier", "OBFUSCATED");
    write(str, paramString + "hash", "OBFUSCATED");
  }
  
  public static double read(double paramDouble, String paramString1, String paramString2)
  {
    return ((Double)read(Double.valueOf(paramDouble), paramString1, paramString2)).doubleValue();
  }
  
  public static int read(int paramInt, String paramString)
  {
    return ((Integer)read(Integer.valueOf(paramInt), paramString, "DEFAULT_GROUP")).intValue();
  }
  
  public static int read(int paramInt, String paramString1, String paramString2)
  {
    return ((Integer)read(Integer.valueOf(paramInt), paramString1, paramString2)).intValue();
  }
  
  public static Object read(Object paramObject, String paramString1, String paramString2)
  {
    paramString1 = getGroup(paramString2).get(paramString1);
    if (paramString1 != null) {
      return paramString1;
    }
    return paramObject;
  }
  
  public static String read(String paramString1, String paramString2, String paramString3)
  {
    return (String)read(paramString1, paramString2, paramString3);
  }
  
  public static boolean read(boolean paramBoolean, String paramString)
  {
    return read(paramBoolean, paramString, "DEFAULT_GROUP");
  }
  
  public static boolean read(boolean paramBoolean, String paramString1, String paramString2)
  {
    return ((Boolean)read(Boolean.valueOf(paramBoolean), paramString1, paramString2)).booleanValue();
  }
  
  public static void save()
  {
    if ((save_data == null) || (!modified)) {
      return;
    }
    try
    {
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(Globals.m_context.openFileOutput("savedata.xml", 0));
      localObjectOutputStream.writeObject(save_data);
      localObjectOutputStream.close();
      modified = false;
      return;
    }
    catch (Exception localException)
    {
      Log.w("SaveData", "There was an error writing the saved data.", localException);
      localException.printStackTrace();
    }
  }
  
  public static void write(Object paramObject, String paramString)
  {
    write(paramObject, paramString, "DEFAULT_GROUP");
  }
  
  public static void write(Object paramObject, String paramString1, String paramString2)
  {
    getGroup(paramString2).put(paramString1, paramObject);
    modified = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/bfs/papertoss/platform/SaveData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */