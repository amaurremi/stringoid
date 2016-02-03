package mobi.beyondpod.downloadengine;

import android.net.Uri;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.AnalyticsTracker;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.FileUtils;
import mobi.beyondpod.rsscore.helpers.TimeSpan;
import mobi.beyondpod.rsscore.helpers.Version;
import mobi.beyondpod.rsscore.rss.LicenseManager;
import mobi.beyondpod.ui.views.notifications.Message;

public class VersionCheckManager
{
  private static final String TAG = VersionCheckManager.class.getSimpleName();
  public static VersionInformation VersionInfo = LoadVersionFromInfoFile(CheckLocation.VersionInfoFile);
  private static DownloadAgent _VersionCheckAgent;
  private static File _VersionInfoFile = new File(Configuration.VersionInfoPath());
  private static File _VersionInfoTmpFile = new File(Configuration.VersionInfoPath() + ".tmp");
  
  public static void CheckForNewVersionIfNeeded()
  {
    int j = 1;
    Double localDouble = GetFileAgeinHours(_VersionInfoTmpFile);
    int i = j;
    if (localDouble != null)
    {
      i = j;
      if (localDouble.doubleValue() < 24.0D) {
        i = 0;
      }
    }
    if ((i != 0) && ((_VersionCheckAgent == null) || (!_VersionCheckAgent.IsDownloading()))) {
      DownloadVersionInfo();
    }
    AnalyticsTracker.Dispatch();
  }
  
  private static Uri ConstructAutoVersionCehckURL()
  {
    int i = LicenseManager.CurrentLicenseKind();
    String str;
    if (i == 1) {
      str = "am";
    }
    for (;;)
    {
      return Uri.parse(Configuration.BeyondPodPublicWebSite() + "/Android/VersionCheck.aspx?v=" + Configuration.ProductVersion() + "&lt=" + str + "&k=" + BeyondPodApplication.GetInstance().AppKind());
      if (i == 6) {
        str = "az";
      } else if (i == 2) {
        str = "bt";
      } else if (i == 3) {
        str = "pp";
      } else if (i == 5) {
        str = "xp";
      } else if (i == 0) {
        str = "tr";
      } else if (i == 4) {
        str = "ot";
      } else if (i == -1) {
        str = "uk";
      } else {
        str = "xx";
      }
    }
  }
  
  private static void DownloadVersionInfo()
  {
    try
    {
      _VersionCheckAgent = new DownloadAgent(ConstructAutoVersionCehckURL(), _VersionInfoTmpFile, null);
      _VersionCheckAgent.setDownloadListenter(new DownloadAgent.DownloadListener()
      {
        public void OnDownloadCompleted(DownloadAgent paramAnonymousDownloadAgent, boolean paramAnonymousBoolean)
        {
          try
          {
            paramAnonymousDownloadAgent = VersionCheckManager.LoadVersionFromInfoFile(VersionCheckManager.CheckLocation.VersionInfoTempFile);
            if ((!paramAnonymousDownloadAgent.LastPublicVersion.IsZero()) && (!paramAnonymousDownloadAgent.LastDevVersion.IsZero()) && (!VersionCheckManager.VersionInfo.equals(paramAnonymousDownloadAgent)))
            {
              FileUtils.CopyFile(VersionCheckManager._VersionInfoTmpFile.getAbsolutePath(), VersionCheckManager._VersionInfoFile.getAbsolutePath());
              Configuration.setNextNotificationTime(new Date());
              VersionCheckManager.VersionInfo = paramAnonymousDownloadAgent;
            }
            return;
          }
          catch (Exception paramAnonymousDownloadAgent)
          {
            CoreHelper.LogException(VersionCheckManager.TAG, "Unable to rename the Version Info temp file.", paramAnonymousDownloadAgent);
          }
        }
        
        public void OnDownloadError(DownloadAgent paramAnonymousDownloadAgent, Exception paramAnonymousException)
        {
          CoreHelper.WriteLogEntryInProduction(VersionCheckManager.TAG, "Unable to check for new version! Reason: " + CoreHelper.ExtractExceptionMessages(paramAnonymousException));
        }
        
        public void OnDownloadProgress(DownloadAgent paramAnonymousDownloadAgent, long paramAnonymousLong1, long paramAnonymousLong2) {}
        
        public void OnDownloadStarted(DownloadAgent paramAnonymousDownloadAgent) {}
        
        public void OnDownloadTerminated(DownloadAgent paramAnonymousDownloadAgent) {}
      });
      _VersionCheckAgent.SetAllowResume(false);
      CoreHelper.WriteTraceEntry(TAG, "Checking for New Version");
      _VersionCheckAgent.StartDownload();
      return;
    }
    catch (Exception localException)
    {
      CoreHelper.WriteLogEntry(TAG, "Unable to check for new version! Reason: " + CoreHelper.ExtractExceptionMessages(localException));
    }
  }
  
  private static Double GetFileAgeinHours(File paramFile)
  {
    if (paramFile.exists()) {
      return Double.valueOf(new TimeSpan(new Date().getTime() - paramFile.lastModified()).getTotalHours());
    }
    return null;
  }
  
  /* Error */
  private static VersionInformation LoadVersionFromInfoFile(CheckLocation paramCheckLocation)
  {
    // Byte code:
    //   0: new 11	mobi/beyondpod/downloadengine/VersionCheckManager$VersionInformation
    //   3: dup
    //   4: invokespecial 220	mobi/beyondpod/downloadengine/VersionCheckManager$VersionInformation:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: getstatic 223	mobi/beyondpod/downloadengine/VersionCheckManager$CheckLocation:VersionInfoTempFile	Lmobi/beyondpod/downloadengine/VersionCheckManager$CheckLocation;
    //   12: if_acmpne +16 -> 28
    //   15: getstatic 64	mobi/beyondpod/downloadengine/VersionCheckManager:_VersionInfoTmpFile	Ljava/io/File;
    //   18: astore_1
    //   19: aload_1
    //   20: invokevirtual 198	java/io/File:exists	()Z
    //   23: ifne +12 -> 35
    //   26: aload_2
    //   27: areturn
    //   28: getstatic 44	mobi/beyondpod/downloadengine/VersionCheckManager:_VersionInfoFile	Ljava/io/File;
    //   31: astore_1
    //   32: goto -13 -> 19
    //   35: aconst_null
    //   36: astore_0
    //   37: aconst_null
    //   38: astore 4
    //   40: new 225	java/util/Scanner
    //   43: dup
    //   44: aload_1
    //   45: invokespecial 228	java/util/Scanner:<init>	(Ljava/io/File;)V
    //   48: astore_1
    //   49: new 230	java/util/ArrayList
    //   52: dup
    //   53: invokespecial 231	java/util/ArrayList:<init>	()V
    //   56: astore_3
    //   57: aload_1
    //   58: invokevirtual 234	java/util/Scanner:hasNextLine	()Z
    //   61: ifne +31 -> 92
    //   64: aload_2
    //   65: astore_0
    //   66: aload_3
    //   67: invokevirtual 237	java/util/ArrayList:size	()I
    //   70: ifle +12 -> 82
    //   73: new 11	mobi/beyondpod/downloadengine/VersionCheckManager$VersionInformation
    //   76: dup
    //   77: aload_3
    //   78: invokespecial 240	mobi/beyondpod/downloadengine/VersionCheckManager$VersionInformation:<init>	(Ljava/util/ArrayList;)V
    //   81: astore_0
    //   82: aload_1
    //   83: ifnull +7 -> 90
    //   86: aload_1
    //   87: invokevirtual 243	java/util/Scanner:close	()V
    //   90: aload_0
    //   91: areturn
    //   92: aload_3
    //   93: invokevirtual 237	java/util/ArrayList:size	()I
    //   96: bipush 6
    //   98: if_icmpgt -34 -> 64
    //   101: aload_3
    //   102: aload_1
    //   103: invokevirtual 246	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   106: invokevirtual 250	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   109: pop
    //   110: goto -53 -> 57
    //   113: astore_3
    //   114: aload_1
    //   115: astore_0
    //   116: getstatic 31	mobi/beyondpod/downloadengine/VersionCheckManager:TAG	Ljava/lang/String;
    //   119: ldc -4
    //   121: aload_3
    //   122: invokestatic 256	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   125: aload_2
    //   126: astore_0
    //   127: aload_1
    //   128: ifnull -38 -> 90
    //   131: aload_1
    //   132: invokevirtual 243	java/util/Scanner:close	()V
    //   135: aload_2
    //   136: astore_0
    //   137: goto -47 -> 90
    //   140: astore_1
    //   141: aload_0
    //   142: ifnull +7 -> 149
    //   145: aload_0
    //   146: invokevirtual 243	java/util/Scanner:close	()V
    //   149: aload_1
    //   150: athrow
    //   151: astore_2
    //   152: aload_1
    //   153: astore_0
    //   154: aload_2
    //   155: astore_1
    //   156: goto -15 -> 141
    //   159: astore_3
    //   160: aload 4
    //   162: astore_1
    //   163: goto -49 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	paramCheckLocation	CheckLocation
    //   18	114	1	localObject1	Object
    //   140	13	1	localObject2	Object
    //   155	8	1	localObject3	Object
    //   7	129	2	localVersionInformation	VersionInformation
    //   151	4	2	localObject4	Object
    //   56	46	3	localArrayList	ArrayList
    //   113	9	3	localException1	Exception
    //   159	1	3	localException2	Exception
    //   38	123	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   49	57	113	java/lang/Exception
    //   57	64	113	java/lang/Exception
    //   66	82	113	java/lang/Exception
    //   92	110	113	java/lang/Exception
    //   40	49	140	finally
    //   116	125	140	finally
    //   49	57	151	finally
    //   57	64	151	finally
    //   66	82	151	finally
    //   92	110	151	finally
    //   40	49	159	java/lang/Exception
  }
  
  public static Double VersionInfoAgeInHours()
  {
    return GetFileAgeinHours(_VersionInfoFile);
  }
  
  public static enum CheckLocation
  {
    VersionInfoFile,  VersionInfoTempFile;
  }
  
  public static class VersionInformation
  {
    public Message AllUsers = new Message();
    public Message BetaUsers = new Message();
    public Version LastDevVersion = new Version(0, 0, 0, 0);
    public Version LastPublicVersion = new Version(0, 0, 0, 0);
    public Message TrialUsers = new Message();
    
    public VersionInformation() {}
    
    public VersionInformation(ArrayList<String> paramArrayList)
    {
      if (paramArrayList.size() > 0) {
        this.LastPublicVersion = new Version((String)paramArrayList.get(0));
      }
      if (paramArrayList.size() > 1) {
        this.LastDevVersion = new Version((String)paramArrayList.get(1));
      }
      if (paramArrayList.size() > 2) {
        this.AllUsers = new Message((String)paramArrayList.get(2));
      }
      if (paramArrayList.size() > 3) {
        this.BetaUsers = new Message((String)paramArrayList.get(3));
      }
      if (paramArrayList.size() > 4) {
        this.TrialUsers = new Message((String)paramArrayList.get(4));
      }
    }
    
    public Message GetCustomizedMessage()
    {
      int i = LicenseManager.CurrentLicenseKind();
      if (i == 2) {
        return this.BetaUsers;
      }
      if ((i == 5) || (i == 0)) {
        return this.TrialUsers;
      }
      return this.AllUsers;
    }
    
    public boolean IsNewDevVersionAvailable()
    {
      return (this.LastDevVersion != null) && (Version.Compare(this.LastDevVersion, Configuration.CurrentProductVersion()) > 0);
    }
    
    public boolean IsNewPublicVersionAvailable()
    {
      return (this.LastPublicVersion != null) && (Version.Compare(this.LastPublicVersion, Configuration.CurrentProductVersion()) > 0);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        do
        {
          return true;
          if (paramObject == null) {
            return false;
          }
          if (!(paramObject instanceof VersionInformation)) {
            return false;
          }
          paramObject = (VersionInformation)paramObject;
          if (this.AllUsers == null)
          {
            if (((VersionInformation)paramObject).AllUsers != null) {
              return false;
            }
          }
          else if (!this.AllUsers.equals(((VersionInformation)paramObject).AllUsers)) {
            return false;
          }
          if (this.BetaUsers == null)
          {
            if (((VersionInformation)paramObject).BetaUsers != null) {
              return false;
            }
          }
          else if (!this.BetaUsers.equals(((VersionInformation)paramObject).BetaUsers)) {
            return false;
          }
          if (this.LastDevVersion == null)
          {
            if (((VersionInformation)paramObject).LastDevVersion != null) {
              return false;
            }
          }
          else if (!this.LastDevVersion.equals(((VersionInformation)paramObject).LastDevVersion)) {
            return false;
          }
          if (this.LastPublicVersion == null)
          {
            if (((VersionInformation)paramObject).LastPublicVersion != null) {
              return false;
            }
          }
          else if (!this.LastPublicVersion.equals(((VersionInformation)paramObject).LastPublicVersion)) {
            return false;
          }
          if (this.TrialUsers != null) {
            break;
          }
        } while (((VersionInformation)paramObject).TrialUsers == null);
        return false;
      } while (this.TrialUsers.equals(((VersionInformation)paramObject).TrialUsers));
      return false;
    }
    
    public int hashCode()
    {
      int n = 0;
      int i;
      int j;
      label21:
      int k;
      label30:
      int m;
      if (this.AllUsers == null)
      {
        i = 0;
        if (this.BetaUsers != null) {
          break label85;
        }
        j = 0;
        if (this.LastDevVersion != null) {
          break label96;
        }
        k = 0;
        if (this.LastPublicVersion != null) {
          break label107;
        }
        m = 0;
        label40:
        if (this.TrialUsers != null) {
          break label119;
        }
      }
      for (;;)
      {
        return ((((i + 31) * 31 + j) * 31 + k) * 31 + m) * 31 + n;
        i = this.AllUsers.hashCode();
        break;
        label85:
        j = this.BetaUsers.hashCode();
        break label21;
        label96:
        k = this.LastDevVersion.hashCode();
        break label30;
        label107:
        m = this.LastPublicVersion.hashCode();
        break label40;
        label119:
        n = this.TrialUsers.hashCode();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/downloadengine/VersionCheckManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */