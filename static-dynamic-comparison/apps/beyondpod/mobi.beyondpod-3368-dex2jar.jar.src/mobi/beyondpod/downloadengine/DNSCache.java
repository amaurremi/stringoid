package mobi.beyondpod.downloadengine;

import java.net.InetAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import mobi.beyondpod.rsscore.helpers.StringUtils;

public class DNSCache
{
  public static final String TAG = DNSCache.class.getSimpleName();
  private static ArrayList<DNSEntry> _DNSList;
  
  private static ArrayList<DNSEntry> DNSList()
  {
    if (_DNSList == null) {
      LoadFromFile();
    }
    return _DNSList;
  }
  
  public static DNSEntry GetEntry(String paramString)
  {
    Iterator localIterator = DNSList().iterator();
    DNSEntry localDNSEntry;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localDNSEntry = (DNSEntry)localIterator.next();
    } while (!localDNSEntry.HostName.equals(paramString));
    return localDNSEntry;
  }
  
  public static boolean HasEntry(String paramString)
  {
    return GetEntry(paramString) != null;
  }
  
  /* Error */
  public static void LoadFromFile()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_0
    //   2: aconst_null
    //   3: astore_3
    //   4: new 41	java/util/ArrayList
    //   7: dup
    //   8: invokespecial 73	java/util/ArrayList:<init>	()V
    //   11: putstatic 30	mobi/beyondpod/downloadengine/DNSCache:_DNSList	Ljava/util/ArrayList;
    //   14: new 75	java/io/File
    //   17: dup
    //   18: invokestatic 80	mobi/beyondpod/rsscore/Configuration:DNSFilePath	()Ljava/lang/String;
    //   21: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore_1
    //   25: aload_1
    //   26: invokevirtual 86	java/io/File:exists	()Z
    //   29: ifeq +76 -> 105
    //   32: new 88	java/io/FileInputStream
    //   35: dup
    //   36: aload_1
    //   37: invokespecial 91	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   40: astore_1
    //   41: new 93	java/io/DataInputStream
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 96	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   49: astore_3
    //   50: aconst_null
    //   51: astore_0
    //   52: new 6	mobi/beyondpod/downloadengine/DNSCache$DNSEntry
    //   55: dup
    //   56: aload_3
    //   57: invokevirtual 99	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   60: aload_3
    //   61: invokevirtual 99	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   64: invokespecial 102	mobi/beyondpod/downloadengine/DNSCache$DNSEntry:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: astore_2
    //   68: aload_2
    //   69: astore_0
    //   70: aload_0
    //   71: ifnull -21 -> 50
    //   74: getstatic 30	mobi/beyondpod/downloadengine/DNSCache:_DNSList	Ljava/util/ArrayList;
    //   77: aload_0
    //   78: invokevirtual 105	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   81: pop
    //   82: goto -32 -> 50
    //   85: astore_2
    //   86: aload_1
    //   87: astore_0
    //   88: getstatic 22	mobi/beyondpod/downloadengine/DNSCache:TAG	Ljava/lang/String;
    //   91: ldc 107
    //   93: aload_2
    //   94: invokestatic 113	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   97: aload_1
    //   98: ifnull +7 -> 105
    //   101: aload_1
    //   102: invokevirtual 116	java/io/FileInputStream:close	()V
    //   105: getstatic 22	mobi/beyondpod/downloadengine/DNSCache:TAG	Ljava/lang/String;
    //   108: new 118	java/lang/StringBuilder
    //   111: dup
    //   112: ldc 120
    //   114: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: getstatic 30	mobi/beyondpod/downloadengine/DNSCache:_DNSList	Ljava/util/ArrayList;
    //   120: invokevirtual 125	java/util/ArrayList:size	()I
    //   123: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: ldc -125
    //   128: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 140	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: return
    //   138: astore_0
    //   139: aload_1
    //   140: invokevirtual 116	java/io/FileInputStream:close	()V
    //   143: aload_1
    //   144: ifnull +57 -> 201
    //   147: aload_1
    //   148: invokevirtual 116	java/io/FileInputStream:close	()V
    //   151: goto -46 -> 105
    //   154: astore_0
    //   155: getstatic 22	mobi/beyondpod/downloadengine/DNSCache:TAG	Ljava/lang/String;
    //   158: ldc 107
    //   160: aload_0
    //   161: invokestatic 113	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   164: goto -59 -> 105
    //   167: astore_1
    //   168: aload_0
    //   169: ifnull +7 -> 176
    //   172: aload_0
    //   173: invokevirtual 116	java/io/FileInputStream:close	()V
    //   176: aload_1
    //   177: athrow
    //   178: astore_0
    //   179: getstatic 22	mobi/beyondpod/downloadengine/DNSCache:TAG	Ljava/lang/String;
    //   182: ldc 107
    //   184: aload_0
    //   185: invokestatic 113	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   188: goto -12 -> 176
    //   191: astore_0
    //   192: getstatic 22	mobi/beyondpod/downloadengine/DNSCache:TAG	Ljava/lang/String;
    //   195: ldc 107
    //   197: aload_0
    //   198: invokestatic 113	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   201: goto -96 -> 105
    //   204: astore_2
    //   205: aload_1
    //   206: astore_0
    //   207: aload_2
    //   208: astore_1
    //   209: goto -41 -> 168
    //   212: astore_2
    //   213: aload_3
    //   214: astore_1
    //   215: goto -129 -> 86
    //   218: astore_2
    //   219: goto -149 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	87	0	localObject1	Object
    //   138	1	0	localEOFException	java.io.EOFException
    //   154	19	0	localException1	Exception
    //   178	7	0	localException2	Exception
    //   191	7	0	localException3	Exception
    //   206	1	0	localObject2	Object
    //   24	124	1	localObject3	Object
    //   167	39	1	localObject4	Object
    //   208	7	1	localObject5	Object
    //   67	2	2	localDNSEntry	DNSEntry
    //   85	9	2	localException4	Exception
    //   204	4	2	localObject6	Object
    //   212	1	2	localException5	Exception
    //   218	1	2	localException6	Exception
    //   3	211	3	localDataInputStream	java.io.DataInputStream
    // Exception table:
    //   from	to	target	type
    //   41	50	85	java/lang/Exception
    //   74	82	85	java/lang/Exception
    //   139	143	85	java/lang/Exception
    //   52	68	138	java/io/EOFException
    //   101	105	154	java/lang/Exception
    //   32	41	167	finally
    //   88	97	167	finally
    //   172	176	178	java/lang/Exception
    //   147	151	191	java/lang/Exception
    //   41	50	204	finally
    //   52	68	204	finally
    //   74	82	204	finally
    //   139	143	204	finally
    //   32	41	212	java/lang/Exception
    //   52	68	218	java/lang/Exception
  }
  
  public static URI PatchHostAddress(URI paramURI)
  {
    DNSEntry localDNSEntry = GetEntry(paramURI.getHost());
    URI localURI = paramURI;
    if (localDNSEntry != null) {
      localURI = URI.create(paramURI.toString().replaceFirst(localDNSEntry.HostName, localDNSEntry.HostAddress));
    }
    return localURI;
  }
  
  /* Error */
  public static void SaveToFile()
  {
    // Byte code:
    //   0: invokestatic 80	mobi/beyondpod/rsscore/Configuration:DNSFilePath	()Ljava/lang/String;
    //   3: astore_3
    //   4: aconst_null
    //   5: astore_2
    //   6: aconst_null
    //   7: astore 4
    //   9: aload_2
    //   10: astore_1
    //   11: getstatic 22	mobi/beyondpod/downloadengine/DNSCache:TAG	Ljava/lang/String;
    //   14: new 118	java/lang/StringBuilder
    //   17: dup
    //   18: ldc -94
    //   20: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   23: invokestatic 39	mobi/beyondpod/downloadengine/DNSCache:DNSList	()Ljava/util/ArrayList;
    //   26: invokevirtual 125	java/util/ArrayList:size	()I
    //   29: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: ldc -92
    //   34: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 140	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_2
    //   44: astore_1
    //   45: new 166	java/io/DataOutputStream
    //   48: dup
    //   49: new 168	java/io/FileOutputStream
    //   52: dup
    //   53: aload_3
    //   54: invokespecial 169	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   57: invokespecial 172	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   60: astore_2
    //   61: iconst_0
    //   62: istore_0
    //   63: iload_0
    //   64: invokestatic 39	mobi/beyondpod/downloadengine/DNSCache:DNSList	()Ljava/util/ArrayList;
    //   67: invokevirtual 125	java/util/ArrayList:size	()I
    //   70: if_icmpne +16 -> 86
    //   73: aload_2
    //   74: invokevirtual 173	java/io/DataOutputStream:close	()V
    //   77: aload_2
    //   78: ifnull +111 -> 189
    //   81: aload_2
    //   82: invokevirtual 173	java/io/DataOutputStream:close	()V
    //   85: return
    //   86: invokestatic 39	mobi/beyondpod/downloadengine/DNSCache:DNSList	()Ljava/util/ArrayList;
    //   89: iload_0
    //   90: invokevirtual 177	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   93: checkcast 6	mobi/beyondpod/downloadengine/DNSCache$DNSEntry
    //   96: astore_1
    //   97: aload_2
    //   98: aload_1
    //   99: getfield 58	mobi/beyondpod/downloadengine/DNSCache$DNSEntry:HostName	Ljava/lang/String;
    //   102: invokevirtual 180	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   105: aload_2
    //   106: aload_1
    //   107: getfield 151	mobi/beyondpod/downloadengine/DNSCache$DNSEntry:HostAddress	Ljava/lang/String;
    //   110: invokevirtual 180	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   113: iload_0
    //   114: iconst_1
    //   115: iadd
    //   116: istore_0
    //   117: goto -54 -> 63
    //   120: astore_3
    //   121: aload 4
    //   123: astore_2
    //   124: aload_2
    //   125: astore_1
    //   126: getstatic 22	mobi/beyondpod/downloadengine/DNSCache:TAG	Ljava/lang/String;
    //   129: ldc -74
    //   131: aload_3
    //   132: invokestatic 113	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   135: aload_2
    //   136: ifnull -51 -> 85
    //   139: aload_2
    //   140: invokevirtual 173	java/io/DataOutputStream:close	()V
    //   143: return
    //   144: astore_1
    //   145: getstatic 22	mobi/beyondpod/downloadengine/DNSCache:TAG	Ljava/lang/String;
    //   148: ldc -74
    //   150: aload_1
    //   151: invokestatic 113	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   154: return
    //   155: astore_2
    //   156: aload_1
    //   157: ifnull +7 -> 164
    //   160: aload_1
    //   161: invokevirtual 173	java/io/DataOutputStream:close	()V
    //   164: aload_2
    //   165: athrow
    //   166: astore_1
    //   167: getstatic 22	mobi/beyondpod/downloadengine/DNSCache:TAG	Ljava/lang/String;
    //   170: ldc -74
    //   172: aload_1
    //   173: invokestatic 113	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   176: goto -12 -> 164
    //   179: astore_1
    //   180: getstatic 22	mobi/beyondpod/downloadengine/DNSCache:TAG	Ljava/lang/String;
    //   183: ldc -74
    //   185: aload_1
    //   186: invokestatic 113	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   189: return
    //   190: astore_3
    //   191: aload_2
    //   192: astore_1
    //   193: aload_3
    //   194: astore_2
    //   195: goto -39 -> 156
    //   198: astore_3
    //   199: goto -75 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   62	55	0	i	int
    //   10	116	1	localObject1	Object
    //   144	17	1	localException1	Exception
    //   166	7	1	localException2	Exception
    //   179	7	1	localException3	Exception
    //   192	1	1	localObject2	Object
    //   5	135	2	localObject3	Object
    //   155	37	2	localObject4	Object
    //   194	1	2	localObject5	Object
    //   3	51	3	str	String
    //   120	12	3	localException4	Exception
    //   190	4	3	localObject6	Object
    //   198	1	3	localException5	Exception
    //   7	115	4	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   11	43	120	java/lang/Exception
    //   45	61	120	java/lang/Exception
    //   139	143	144	java/lang/Exception
    //   11	43	155	finally
    //   45	61	155	finally
    //   126	135	155	finally
    //   160	164	166	java/lang/Exception
    //   81	85	179	java/lang/Exception
    //   63	77	190	finally
    //   86	113	190	finally
    //   63	77	198	java/lang/Exception
    //   86	113	198	java/lang/Exception
  }
  
  public static void UpdateEntry(InetAddress paramInetAddress)
  {
    if ((paramInetAddress == null) || (StringUtils.IsNullOrEmpty(paramInetAddress.getHostName())) || (StringUtils.IsNullOrEmpty(paramInetAddress.getHostAddress()))) {}
    do
    {
      DNSEntry localDNSEntry;
      do
      {
        return;
        localDNSEntry = GetEntry(paramInetAddress.getHostName());
        if (localDNSEntry == null) {
          break;
        }
      } while (localDNSEntry.HostAddress.equals(paramInetAddress.getHostAddress()));
      localDNSEntry.HostAddress = paramInetAddress.getHostAddress();
      return;
      DNSList().add(new DNSEntry(paramInetAddress.getHostName(), paramInetAddress.getHostAddress()));
    } while (1 == 0);
    SaveToFile();
  }
  
  private static class DNSEntry
  {
    public String HostAddress;
    public String HostName;
    
    DNSEntry(String paramString1, String paramString2)
    {
      this.HostName = paramString1;
      this.HostAddress = paramString2;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/downloadengine/DNSCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */