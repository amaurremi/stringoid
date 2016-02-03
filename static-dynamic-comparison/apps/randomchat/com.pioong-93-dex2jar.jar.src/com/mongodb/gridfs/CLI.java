package com.mongodb.gridfs;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.util.Util;
import java.io.File;
import java.io.PrintStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.Iterator;

public class CLI
{
  private static GridFS _gridfs;
  private static Mongo _mongo = null;
  private static String db;
  private static String host = "127.0.0.1";
  
  static
  {
    db = "test";
  }
  
  private static GridFS getGridFS()
    throws Exception
  {
    if (_gridfs == null) {
      _gridfs = new GridFS(getMongo().getDB(db));
    }
    return _gridfs;
  }
  
  private static Mongo getMongo()
    throws Exception
  {
    if (_mongo == null) {
      _mongo = new MongoClient(host);
    }
    return _mongo;
  }
  
  public static void main(String[] paramArrayOfString)
    throws Exception
  {
    if (paramArrayOfString.length < 1) {
      printUsage();
    }
    int i;
    label12:
    Object localObject;
    for (;;)
    {
      return;
      i = 0;
      if (i < paramArrayOfString.length)
      {
        localObject = paramArrayOfString[i];
        if (!((String)localObject).equals("--db")) {
          break label50;
        }
        db = paramArrayOfString[(i + 1)];
        i += 1;
      }
      for (;;)
      {
        i += 1;
        break label12;
        break;
        label50:
        if (!((String)localObject).equals("--host")) {
          break label74;
        }
        host = paramArrayOfString[(i + 1)];
        i += 1;
      }
      label74:
      if (((String)localObject).equals("help"))
      {
        printUsage();
        return;
      }
      if (!((String)localObject).equals("list")) {
        break;
      }
      paramArrayOfString = getGridFS();
      System.out.printf("%-60s %-10s\n", new Object[] { "Filename", "Length" });
      paramArrayOfString = paramArrayOfString.getFileList().iterator();
      while (paramArrayOfString.hasNext())
      {
        localObject = (DBObject)paramArrayOfString.next();
        System.out.printf("%-60s %-10d\n", new Object[] { ((DBObject)localObject).get("filename"), Long.valueOf(((Number)((DBObject)localObject).get("length")).longValue()) });
      }
    }
    if (((String)localObject).equals("get"))
    {
      localObject = getGridFS();
      paramArrayOfString = paramArrayOfString[(i + 1)];
      localObject = ((GridFS)localObject).findOne(paramArrayOfString);
      if (localObject == null)
      {
        System.err.println("can't find file: " + paramArrayOfString);
        return;
      }
      ((GridFSDBFile)localObject).writeTo(((GridFSDBFile)localObject).getFilename());
      return;
    }
    if (((String)localObject).equals("put"))
    {
      paramArrayOfString = getGridFS().createFile(new File(paramArrayOfString[(i + 1)]));
      paramArrayOfString.save();
      paramArrayOfString.validate();
      return;
    }
    if (((String)localObject).equals("md5"))
    {
      localObject = getGridFS();
      paramArrayOfString = paramArrayOfString[(i + 1)];
      localObject = ((GridFS)localObject).findOne(paramArrayOfString);
      if (localObject == null)
      {
        System.err.println("can't find file: " + paramArrayOfString);
        return;
      }
      paramArrayOfString = MessageDigest.getInstance("MD5");
      paramArrayOfString.reset();
      localObject = new DigestInputStream(((GridFSDBFile)localObject).getInputStream(), paramArrayOfString);
      int j;
      for (i = 0;; i = j + i)
      {
        j = i;
        if (((DigestInputStream)localObject).read() >= 0)
        {
          j = i + 1;
          i = ((DigestInputStream)localObject).read(new byte[17]);
          if (i >= 0) {}
        }
        else
        {
          paramArrayOfString = paramArrayOfString.digest();
          System.out.println("length: " + j + " md5: " + Util.toHex(paramArrayOfString));
          return;
        }
      }
    }
    System.err.println("unknown option: " + (String)localObject);
  }
  
  private static void printUsage()
  {
    System.out.println("Usage : [--bucket bucketname] action");
    System.out.println("  where  action is one of:");
    System.out.println("      list                      : lists all files in the store");
    System.out.println("      put filename              : puts the file filename into the store");
    System.out.println("      get filename1 filename2   : gets filename1 from store and sends to filename2");
    System.out.println("      md5 filename              : does an md5 hash on a file in the db (for testing)");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/gridfs/CLI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */