package a;

import android.graphics.drawable.Drawable;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.Comparator;
import java.util.List;

public class a
{
  public static final Comparator<String> a = new b();
  
  public static int a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int i = (int)(paramFloat1 * 255.0F + 0.5D);
    int j = (int)(paramFloat2 * 255.0F + 0.5D);
    int k = (int)(paramFloat3 * 255.0F + 0.5D);
    return (i & 0xFF) << 16 | ((int)(paramFloat4 * 255.0F + 0.5D) & 0xFF) << 24 | (j & 0xFF) << 8 | (k & 0xFF) << 0;
  }
  
  public static Drawable a(Class<?> paramClass, String paramString)
  {
    return Drawable.createFromStream(paramClass.getClassLoader().getResourceAsStream(paramString), paramString);
  }
  
  public static String a(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return "";
    }
    paramCharSequence = paramCharSequence.toString();
    try
    {
      String str = URLEncoder.encode(paramCharSequence, "UTF8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return paramCharSequence;
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: ldc 68
    //   2: invokestatic 74	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore 5
    //   7: aload_0
    //   8: ldc 76
    //   10: invokevirtual 82	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   13: astore 4
    //   15: aload 4
    //   17: astore_0
    //   18: new 84	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   25: astore 4
    //   27: aload 5
    //   29: aload_0
    //   30: invokevirtual 89	java/security/MessageDigest:digest	([B)[B
    //   33: astore_0
    //   34: aload_0
    //   35: arraylength
    //   36: istore_2
    //   37: iconst_0
    //   38: istore_1
    //   39: iload_1
    //   40: iload_2
    //   41: if_icmpge +53 -> 94
    //   44: aload_0
    //   45: iload_1
    //   46: baload
    //   47: istore_3
    //   48: aload 4
    //   50: iload_3
    //   51: sipush 240
    //   54: iand
    //   55: iconst_4
    //   56: iushr
    //   57: invokestatic 95	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   60: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload 4
    //   66: iload_3
    //   67: bipush 15
    //   69: iand
    //   70: invokestatic 95	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   73: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: iload_1
    //   78: iconst_1
    //   79: iadd
    //   80: istore_1
    //   81: goto -42 -> 39
    //   84: astore 4
    //   86: aload_0
    //   87: invokevirtual 102	java/lang/String:getBytes	()[B
    //   90: astore_0
    //   91: goto -73 -> 18
    //   94: aload 4
    //   96: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: astore_0
    //   100: aload_0
    //   101: areturn
    //   102: astore_0
    //   103: new 105	java/lang/RuntimeException
    //   106: dup
    //   107: aload_0
    //   108: invokespecial 108	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	paramString	String
    //   38	43	1	i	int
    //   36	6	2	j	int
    //   47	23	3	k	int
    //   13	52	4	localObject	Object
    //   84	11	4	localUnsupportedEncodingException	UnsupportedEncodingException
    //   5	23	5	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   7	15	84	java/io/UnsupportedEncodingException
    //   0	7	102	java/security/NoSuchAlgorithmException
    //   7	15	102	java/security/NoSuchAlgorithmException
    //   18	37	102	java/security/NoSuchAlgorithmException
    //   48	77	102	java/security/NoSuchAlgorithmException
    //   86	91	102	java/security/NoSuchAlgorithmException
    //   94	100	102	java/security/NoSuchAlgorithmException
  }
  
  public static String a(List<String> paramList, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)paramList.get(0));
    int j = paramList.size();
    int i = 1;
    while (i < j)
    {
      localStringBuilder.append(paramString).append((String)paramList.get(i));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static StringBuilder a(InputStream paramInputStream)
    throws IOException
  {
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream, "UTF-8"));
    StringBuilder localStringBuilder = new StringBuilder();
    char[] arrayOfChar = new char['Ϩ'];
    for (int i = 0; i >= 0; i = paramInputStream.read(arrayOfChar)) {
      localStringBuilder.append(arrayOfChar, 0, i);
    }
    return localStringBuilder;
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      paramCloseable.printStackTrace();
    }
  }
  
  public static void a(HttpURLConnection paramHttpURLConnection)
  {
    if (paramHttpURLConnection != null) {
      paramHttpURLConnection.disconnect();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */