package crittercism.android;

import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.math.BigInteger;

public final class h
{
  public static BigInteger a()
  {
    BigInteger localBigInteger = BigInteger.valueOf(-1L);
    try
    {
      Object localObject = new StatFs(Environment.getDataDirectory().getPath());
      localObject = BigInteger.valueOf(((StatFs)localObject).getAvailableBlocks()).multiply(BigInteger.valueOf(((StatFs)localObject).getBlockSize()));
      return (BigInteger)localObject;
    }
    catch (Exception localException) {}
    return localBigInteger;
  }
  
  public static BigInteger b()
  {
    BigInteger localBigInteger = BigInteger.valueOf(-1L);
    try
    {
      Object localObject = new StatFs(Environment.getDataDirectory().getPath());
      localObject = BigInteger.valueOf(((StatFs)localObject).getBlockCount()).multiply(BigInteger.valueOf(((StatFs)localObject).getBlockSize()));
      return (BigInteger)localObject;
    }
    catch (Exception localException) {}
    return localBigInteger;
  }
  
  public static BigInteger c()
  {
    BigInteger localBigInteger = BigInteger.valueOf(-1L);
    try
    {
      Object localObject = new StatFs(Environment.getExternalStorageDirectory().getPath());
      localObject = BigInteger.valueOf(((StatFs)localObject).getAvailableBlocks()).multiply(BigInteger.valueOf(((StatFs)localObject).getBlockSize()));
      return (BigInteger)localObject;
    }
    catch (Exception localException) {}
    return localBigInteger;
  }
  
  public static BigInteger d()
  {
    BigInteger localBigInteger = BigInteger.valueOf(-1L);
    try
    {
      Object localObject = new StatFs(Environment.getExternalStorageDirectory().getPath());
      localObject = BigInteger.valueOf(((StatFs)localObject).getBlockCount()).multiply(BigInteger.valueOf(((StatFs)localObject).getBlockSize()));
      return (BigInteger)localObject;
    }
    catch (Exception localException) {}
    return localBigInteger;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/crittercism/android/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */