package mobi.beyondpod.rsscore;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.webkit.WebSettings.LayoutAlgorithm;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.R.integer;
import mobi.beyondpod.R.string;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.Path;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.helpers.TimeSpan;
import mobi.beyondpod.rsscore.helpers.Version;
import mobi.beyondpod.rsscore.repository.DatabaseHelper;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.rss.LicenseManager;

public class Configuration
{
  private static final String BEYONDPOD_DATABASE_AUTOBAK = "beyondpod.db.autobak";
  public static final String BEYOND_POD_HISTORY_AUTOBAK = "BeyondPodHistory.bin.autobak";
  public static final String BEYOND_POD_ITEM_HISTORY_AUTOBAK = "BeyondPodItemHistory.bin.autobak";
  public static final String BEYOND_POD_SETTINGS_AUTOBAK = "Settings.xml.autobak";
  public static String BP_USER_AGENT;
  public static final int CONFIG_ERROR_INVALID_BEYONDPOD_ROOT = -3;
  public static final int CONFIG_ERROR_INVALID_PODCAST_ROOT = -2;
  public static final int CONFIG_ERROR_INVALID_SD_CARD_ROOT = -1;
  public static final int CONFIG_ERROR_NONE = 0;
  public static String ConfigurationInitErrorMsg;
  public static int ConfigurationInitErrorType = 0;
  private static final String DEFAULT_CONTENT_VIEW_COLOR = "#6699CC";
  public static final int DEFAULT_MAXIMUM_PODCAST_AGE_IN_DAYS = 99999;
  public static String IE_USER_AGENT;
  private static final String INTERNAL_PLAYER_SUPPORTED_EXTENSIONS = "3gp,mp4,m4v,h264.mp4,m4a,mp3,mid,xmf,mxmf,rtttl,rtx,ota,imy,ogg,wav,jpg,gif,png,bmp";
  public static String IT_USER_AGENT = "iTunes/10.6.1 (Windows; Microsoft Windows 7 Enterprise Edition Service Pack 1 (Build 7601)) AppleWebKit/534.54.16";
  private static final int MAX_RECENT_FEEDS = 3;
  public static String MA_USER_AGENT;
  public static String MO_USER_AGENT;
  private static final String PLAY_LIST_BIN_AUTOBAK = "PlayList.bin.autobak";
  private static final String SD_CARD_CANT_CREATE_FOLDER;
  private static final String SD_CARD_CANT_CREATE_FOLDER_WORKAROUND;
  private static final String SD_CARD_ERROR;
  private static final String SETTINGS_NAME = "Settings";
  public static final String SMART_PLAY_LIST_AUTOBAK = "SmartPlayList.bin.autobak";
  private static final String TAG = "Configuration";
  public static final String TRACK_STATE_AUTOBAK = "TrackState.xml.autobak";
  public static HashMap<UUID, Feed> TempFeedHolder;
  private static FeedCategory _ActiveFeedCategory;
  private static File _BeyondPodBackupManagerBackupRoot;
  private static File _BeyondPodPrivateStorageRoot;
  private static File _BeyondPodPublicStorageRoot = null;
  private static Context _Context;
  private static Version _CurrentVersion;
  private static String _EnclosureDownloadRootPath;
  private static String _GReaderAuthValue;
  private static String _GReaderCookie;
  private static boolean _IsExpirationWarningShownInThisSession;
  private static boolean _IsFirstRun;
  private static Feed _LastSelectedFeed;
  private static Pattern _SleepTimes = Pattern.compile("\\d+");
  private static boolean _UnableToEstablishWiFiConnectionInThisSession;
  public static SharedPreferences _preferences;
  static Pattern colorRegex;
  
  static
  {
    _BeyondPodPrivateStorageRoot = null;
    _BeyondPodBackupManagerBackupRoot = null;
    _EnclosureDownloadRootPath = null;
    _IsFirstRun = false;
    _UnableToEstablishWiFiConnectionInThisSession = false;
    TempFeedHolder = new HashMap();
    _IsExpirationWarningShownInThisSession = false;
    SD_CARD_ERROR = CoreHelper.LoadResourceString(R.string.error_SDCardError);
    SD_CARD_CANT_CREATE_FOLDER = CoreHelper.LoadResourceString(R.string.error_CantCreateRootFolder);
    SD_CARD_CANT_CREATE_FOLDER_WORKAROUND = CoreHelper.LoadResourceString(R.string.error_CantCreateRootFolderWorkaround);
    colorRegex = Pattern.compile("background-color: (#[A-Z_0-9]*);", 10);
    BP_USER_AGENT = "Mozilla/5.0 (Linux; U; en-us; BeyondPod)";
    IE_USER_AGENT = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0; .NET CLR 1.0.3705)";
    MO_USER_AGENT = "Mozilla/5.0 (Linux; U; Windows NT 6.1; en-us; dream)";
    MA_USER_AGENT = "Mozilla/5.0 (Linux; U; Android 1.5; en-us; T-Mobile G1 Build/CRB43) AppleWebKit/528.5+ (KHTML, like Gecko) Version/3.1.2 Mobile Safari/525.20.1";
  }
  
  public static boolean AllowCleanupForManualDownloads()
  {
    return _preferences.getBoolean("AllowCleanupForManualDownloads", false);
  }
  
  public static int AllowEpisodeStreaming()
  {
    return StringUtils.SafeParseInt(_preferences.getString("AllowEpisodeStreaming", Integer.toString(0)), 0);
  }
  
  public static boolean AllowMarginNavigationInFeedItemContentDialog()
  {
    return _preferences.getBoolean("AllowMarginNavigationInFeedItemContentDialog", false);
  }
  
  public static boolean AllowMarkingReadOfScrolledPosts()
  {
    return _preferences.getBoolean("AllowMarkingReadOfScrolledPosts", false);
  }
  
  public static boolean AllowPullToRefresh()
  {
    return _preferences.getBoolean("AllowPullToRefresh", true);
  }
  
  public static boolean AllowResumeAfterCall()
  {
    return _preferences.getBoolean("AllowResumeAfterCall", true);
  }
  
  public static boolean AllowSeekingOfInternetStreams()
  {
    return CoreHelper.ApiLevel() >= 8;
  }
  
  public static boolean AllowVideosInPlaylist()
  {
    return _preferences.getBoolean("AllowVideosInPlaylist", false);
  }
  
  public static boolean AreSettingsInitialized()
  {
    return _preferences.getBoolean("DefaultSettingsInitialized", false);
  }
  
  public static boolean AttachDownloadedPodcastsWhenSharing()
  {
    return _preferences.getBoolean("AttachDownloadedPodcastsWhenSharing", false);
  }
  
  public static boolean AutoCloseFeedContentListView()
  {
    return _preferences.getBoolean("AutoCloseFeedContentListView", false);
  }
  
  public static boolean AutoHidePlayer()
  {
    return _preferences.getBoolean("AutoHidePlayer", false);
  }
  
  public static boolean AutoPlaylistEnabled()
  {
    return _preferences.getBoolean("AutoPlaylistEnabled", true);
  }
  
  public static boolean AutoSyncSmartPlay()
  {
    return _preferences.getBoolean("AutoSyncSmartPlay", false);
  }
  
  public static int BTNextButtonAction()
  {
    int i = 2;
    if (!_preferences.contains("BTNextButtonAction")) {
      if (BTRemoteButtonAction() != 1) {
        break label58;
      }
    }
    label58:
    for (i = 1;; i = 3)
    {
      ConfigWriteHelper.getInstance().putString(_preferences, "BTNextButtonAction", Integer.toString(i));
      return StringUtils.SafeParseInt(_preferences.getString("BTNextButtonAction", Integer.toString(i)), i);
    }
  }
  
  public static int BTPreviousButtonAction()
  {
    int i = 2;
    if (!_preferences.contains("BTPreviousButtonAction")) {
      if (BTRemoteButtonAction() != 1) {
        break label58;
      }
    }
    label58:
    for (i = 2;; i = 4)
    {
      ConfigWriteHelper.getInstance().putString(_preferences, "BTPreviousButtonAction", Integer.toString(i));
      return StringUtils.SafeParseInt(_preferences.getString("BTPreviousButtonAction", Integer.toString(i)), i);
    }
  }
  
  public static int BTRemoteButtonAction()
  {
    return StringUtils.SafeParseInt(_preferences.getString("BTRemoteButtonAction", "1"), 1);
  }
  
  public static String BackupManagerBackupPath()
  {
    if (_BeyondPodBackupManagerBackupRoot == null) {
      _BeyondPodBackupManagerBackupRoot = _Context.getFilesDir();
    }
    return _BeyondPodBackupManagerBackupRoot.getAbsolutePath();
  }
  
  public static Uri BackupRestoreFileURL()
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(BeyondPodPublicWebSite())).append("/Android/help");
    if (IsCurrentVersionHD()) {}
    for (String str = "/hd/BackupRestore.htm";; str = "/BackupRestore.htm") {
      return Uri.parse(str);
    }
  }
  
  public static boolean BackupSnapshotRestoredFlag()
  {
    return _preferences.getBoolean("BackupSnapshotRestoredFlag", false);
  }
  
  public static String BeyondPodContentUrl()
  {
    StringBuilder localStringBuilder = new StringBuilder("content://beyondpod");
    if (IsCurrentVersionHD()) {}
    for (String str = "hd";; str = "") {
      return str;
    }
  }
  
  public static String BeyondPodPrivateStorageRootPath()
  {
    if (_BeyondPodPrivateStorageRoot == null) {
      _BeyondPodPrivateStorageRoot = _Context.getDir("beyondpod", 2);
    }
    return _BeyondPodPrivateStorageRoot.getAbsolutePath();
  }
  
  public static String BeyondPodPublicAPIRoot()
  {
    return "http://www.beyondpod.mobi/api";
  }
  
  public static String BeyondPodPublicStorageRootPath()
  {
    return _BeyondPodPublicStorageRoot.getPath();
  }
  
  public static String BeyondPodPublicWebSite()
  {
    return "http://www.beyondpod.mobi";
  }
  
  public static boolean CDSAllowRemoteEpisodeDeletions()
  {
    return _preferences.getBoolean("CDSAllowRemoteEpisodeDeletions", false);
  }
  
  public static int CDSAllowRemoteFeeds()
  {
    return _preferences.getInt("CDSAllowRemoteFeeds", 2);
  }
  
  public static Uri CDSCustomEndpointPath()
  {
    Object localObject2 = null;
    String str = GetDebugProperty("CDSEndpoint", null);
    Object localObject1 = localObject2;
    if (!StringUtils.IsNullOrEmpty(str))
    {
      localObject1 = localObject2;
      if (str.startsWith("http")) {
        localObject1 = Uri.parse(str + "/beyondpod");
      }
    }
    return (Uri)localObject1;
  }
  
  public static boolean CDSDebugEnabled()
  {
    return !StringUtils.IsNullOrEmpty(GetDebugProperty("CDSEndpoint", null));
  }
  
  public static String CDSDeviceID()
  {
    return _preferences.getString("CDSDeviceID", "");
  }
  
  public static boolean CDSEnabled()
  {
    return _preferences.getBoolean("CDSEnabled", false);
  }
  
  public static Uri CDSEndpoint()
  {
    Uri localUri = CDSCustomEndpointPath();
    if (localUri != null) {
      return localUri;
    }
    return Uri.parse("https://feedsync.beyondpod.mobi/beyondpod");
  }
  
  public static String CDSPassword()
  {
    return _preferences.getString("CDSPassword", "");
  }
  
  public static Uri CDSServiceEndpoint()
  {
    return Uri.withAppendedPath(CDSEndpoint(), "rest");
  }
  
  public static boolean CDSSyncFurthestPlayedPositionOnly()
  {
    return _preferences.getBoolean("CDSSyncFurthestPlayedPositionOnly", false);
  }
  
  public static int CDSSyncRetryInterval()
  {
    return _preferences.getInt("CDSSyncRetryInterval", 0);
  }
  
  public static String CDSToken()
  {
    return _preferences.getString("CDSToken", "");
  }
  
  public static Date CDSTokenExpiration()
  {
    long l = _preferences.getLong("CDSTokenExpiration", 0L);
    if (l > 0L) {
      return new Date(l);
    }
    return new Date();
  }
  
  public static String CDSUserName()
  {
    return _preferences.getString("CDSUserName", "");
  }
  
  public static Uri ChangeStorageFolderURL()
  {
    return Uri.parse(BeyondPodPublicWebSite() + "/Android/help/ChangeStorageFolder.htm");
  }
  
  public static boolean CheckForNetworkConnectivity()
  {
    return _preferences.getBoolean("CheckForNetworkConnectivity", true);
  }
  
  public static void ClearIsFirstRun()
  {
    _IsFirstRun = false;
  }
  
  public static boolean ClearStatusNotificationAtTheEndOfUpdate()
  {
    return _preferences.getBoolean("ClearStatusNotificationAtTheEndOfUpdate", false);
  }
  
  public static Uri CommunityForumURI()
  {
    return Uri.parse("http://www.beyondpod.com/forum");
  }
  
  public static void ConfigureDefaults()
  {
    setFeedsSortOrder(0);
    setPodcastsSortOrder(3);
    setGatherAnalyticsData(false);
    setMediaEndAction(0);
    setPlaylistEndAction(0);
    setForwardSkipInterval(30);
    setBackwardSkipInterval(10);
    setInternalPlayerSupportedFileExtensions("3gp,mp4,m4v,h264.mp4,m4a,mp3,mid,xmf,mxmf,rtttl,rtx,ota,imy,ogg,wav,jpg,gif,png,bmp");
    setSharePodcasts(true);
    setBTRemoteButtonAction(1);
    setEnableHeadsetButton(true);
    setPauseOnHeadsetDisconnect(true);
    setHideUnsupportedFileTypes(false);
    setSkipToEndButtonClickType(1);
    setPlayerIntegrationType(0);
    setDefaultDocFontSize("medium");
    setLoadContentViewImagesAutomatically(true);
    setHideReadItems(false);
    setMobileFormatter("");
    setMarkAsReadOnOpen(1);
    setSetAsDownloadedOnMarkRead(true);
    setIsCellularConnectionAllowed(true);
    setTurnWiFiDuringUpdate(false);
    setUpdateOnFeedOpen(false);
    setGlobalDefaultNumberPodcastsToDownload(1);
    setGlobalDefaultKeepAtMostPodcasts(5);
    setAutoPlaylistEnabled(true);
    setAreSettingsInitialized(true);
  }
  
  public static File ConstructBeyondPodRootIn(String paramString)
  {
    return new File(paramString, "BeyondPod");
  }
  
  public static Uri ConstructCategorySearchURL(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(BeyondPodPublicWebSite())).append("/android/search/CategorySearch.aspx?q=").append(URLEncoder.encode(paramString));
    if (IsCurrentVersionHD()) {}
    for (paramString = "&hsb=true";; paramString = "") {
      return Uri.parse(paramString + "&v=" + ProductVersion());
    }
  }
  
  public static File ConstructEnclosureDownloadRoot(File paramFile)
  {
    return new File(paramFile, "Podcasts");
  }
  
  public static Uri ConstructFeedSearchURL(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(BeyondPodPublicWebSite())).append("/android/search/TextAudioSearch.aspx?q=").append(URLEncoder.encode(paramString));
    if (IsCurrentVersionHD()) {}
    for (paramString = "&hsb=true";; paramString = "") {
      return Uri.parse(paramString + "&v=" + ProductVersion());
    }
  }
  
  public static String ContentTheme()
  {
    return _preferences.getString("ContentTheme", "");
  }
  
  public static Integer ContentThemeBackgroundColor()
  {
    Object localObject = ContentTheme();
    if (StringUtils.IsNullOrEmpty((String)localObject)) {}
    do
    {
      return null;
      localObject = colorRegex.matcher((CharSequence)localObject);
    } while ((!((Matcher)localObject).find()) || (((Matcher)localObject).groupCount() != 1));
    try
    {
      int i = Color.parseColor(((Matcher)localObject).group(1));
      return Integer.valueOf(i);
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static int CurrentAppStore()
  {
    return 1;
  }
  
  public static Version CurrentProductVersion()
  {
    PackageManager localPackageManager;
    if (_CurrentVersion == null) {
      localPackageManager = _Context.getPackageManager();
    }
    try
    {
      _CurrentVersion = new Version(localPackageManager.getPackageInfo(BeyondPodApplication.GetInstance().getClass().getPackage().getName(), 0).versionName);
      return _CurrentVersion;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        _CurrentVersion = new Version(0, 0, 0, 0);
      }
    }
  }
  
  public static int CurrentProductVersionCode()
  {
    try
    {
      int i = _Context.getPackageManager().getPackageInfo(BeyondPodApplication.GetInstance().getClass().getPackage().getName(), 0).versionCode;
      return i;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public static int CurrentThemeID()
  {
    return StringUtils.SafeParseInt(_preferences.getString("CurrentTheme", "-1"), -1);
  }
  
  public static String CustomSDCardLocation()
  {
    return _preferences.getString("CustomSDCardLocation", "");
  }
  
  public static int DBGChromecastEnvironment()
  {
    return StringUtils.SafeParseInt(GetDebugProperty("CCEnv", "0"), 0);
  }
  
  public static int DBGMaxFeedPosts()
  {
    return StringUtils.SafeParseInt(GetDebugProperty("MaxFeedPosts", "3000"), 3000);
  }
  
  public static int DBGShowPlayerType()
  {
    return StringUtils.SafeParseInt(GetDebugProperty("ShowPlayerType", "0"), 0);
  }
  
  public static String DNSFilePath()
  {
    return BeyondPodPrivateStorageRootPath() + "/DNSCache.bin";
  }
  
  public static String DatabaseBackupFilePath()
  {
    return BeyondPodPublicStorageRootPath() + "/" + "beyondpod.db.autobak";
  }
  
  public static String DatabaseBackupManagerFilePath()
  {
    return BackupManagerBackupPath() + "/" + "beyondpod.db.autobak";
  }
  
  public static boolean DebugDownloadProgress()
  {
    return _preferences.getBoolean("DebugDownloadProgress", false);
  }
  
  public static String DefaultBackupPath()
  {
    return _preferences.getString("DefaultBackupPath", BeyondPodPublicStorageRootPath() + "/Backups");
  }
  
  public static float DefaultDescriptionFontSizeInUnits()
  {
    String str = getDefaultDocFontSize();
    if ("x-large".equals(str)) {
      return _Context.getResources().getInteger(R.integer.Description_x_large_font_size);
    }
    if ("large".equals(str)) {
      return _Context.getResources().getInteger(R.integer.Description_large_font_size);
    }
    if ("medium".equals(str)) {
      return _Context.getResources().getInteger(R.integer.Description_medium_font_size);
    }
    if ("small".equals(str)) {
      return _Context.getResources().getInteger(R.integer.Description_small_font_size);
    }
    if ("x-small".equals(str)) {
      return _Context.getResources().getInteger(R.integer.Description_x_small_font_size);
    }
    return _Context.getResources().getInteger(R.integer.Description_medium_font_size);
  }
  
  public static int DefaultDeviceWakeLock()
  {
    if ((KeepScreenOnWhenUpdatingOverWiFi()) && ((BeyondPodApplication.IsWiFiEnabled()) || (TurnWiFiDuringUpdate()))) {
      return 268435462;
    }
    return 1;
  }
  
  public static String DefaultDownloadPath()
  {
    return Path.Combine(BeyondPodPublicStorageRootPath(), "/Downloads");
  }
  
  public static float DefaultPlaybackSpeed()
  {
    return StringUtils.SafeParseFloat(_preferences.getString("DefaultPlaybackSpeed", "1.0"), 1.0F);
  }
  
  public static float DefaultPrimaryFontSizeInUnits()
  {
    String str = getDefaultDocFontSize();
    if ("x-large".equals(str)) {
      return _Context.getResources().getInteger(R.integer.Primary_x_large_font_size);
    }
    if ("large".equals(str)) {
      return _Context.getResources().getInteger(R.integer.Primary_large_font_size);
    }
    if ("medium".equals(str)) {
      return _Context.getResources().getInteger(R.integer.Primary_medium_font_size);
    }
    if ("small".equals(str)) {
      return _Context.getResources().getInteger(R.integer.Primary_small_font_size);
    }
    if ("x-small".equals(str)) {
      return _Context.getResources().getInteger(R.integer.Primary_x_small_font_size);
    }
    return _Context.getResources().getInteger(R.integer.Primary_medium_font_size);
  }
  
  public static String DefaultUserAgent()
  {
    String str2 = _preferences.getString("DefaultUserAgent", "");
    String str1;
    if (StringUtils.IsNullOrEmpty(str2)) {
      str1 = BP_USER_AGENT;
    }
    do
    {
      return str1;
      if (StringUtils.EqualsIgnoreCase("ie", str2)) {
        return IE_USER_AGENT;
      }
      if (StringUtils.EqualsIgnoreCase("mo", str2)) {
        return MO_USER_AGENT;
      }
      if (StringUtils.EqualsIgnoreCase("ma", str2)) {
        return MA_USER_AGENT;
      }
      str1 = str2;
    } while (!StringUtils.EqualsIgnoreCase("it", str2));
    return IT_USER_AGENT;
  }
  
  public static boolean DefferAutoSyncSmartPlay()
  {
    return _preferences.getBoolean("DefferAutoSyncSmartPlay", false);
  }
  
  public static boolean DownloadEnclosuresOnWiFiOnly()
  {
    return _preferences.getBoolean("DownloadEnclosuresOnWiFiOnly", false);
  }
  
  public static boolean DownloadEnclosuresWhenChargingOnly()
  {
    return _preferences.getBoolean("DownloadEnclosuresWhenChargingOnly", false);
  }
  
  public static boolean EnableAudioPlugins()
  {
    if (!IsSpeedAlterationSupportedOnAppStore()) {
      return false;
    }
    return _preferences.getBoolean("EnableAudioPlugins", true);
  }
  
  public static boolean EnableBrowserPlugins()
  {
    return _preferences.getBoolean("EnableBrowserPlugins", false);
  }
  
  public static boolean EnableFadeInOnPlaybackStart()
  {
    return _preferences.getBoolean("EnableFadeInOnPlaybackStart", false);
  }
  
  public static boolean EnableHeadsetButton()
  {
    return _preferences.getBoolean("EnableHeadsetButton", false);
  }
  
  public static boolean EnableLoggingInProduction()
  {
    return _preferences.getBoolean("EnableLoggingInProduction", false);
  }
  
  public static boolean EnablePlayerFlipAnimation()
  {
    return _preferences.getBoolean("EnablePlayerFlipAnimation", false);
  }
  
  public static boolean EnableQuickNetworkCheck()
  {
    return StringUtils.TryParseIntFromString(_preferences.getString("HttpConnectionTimeout", "20"), Integer.valueOf(20)).intValue() < 0;
  }
  
  public static boolean EnableSonicAudioPlugin()
  {
    return _preferences.getBoolean("EnableSonicAudioPlugin", false);
  }
  
  public static String EnclosureDownloadHistoryBackupFilePath()
  {
    return BeyondPodPublicStorageRootPath() + "/" + "BeyondPodHistory.bin.autobak";
  }
  
  public static String EnclosureDownloadHistoryBackupManagerFilePath()
  {
    return BackupManagerBackupPath() + "/" + "BeyondPodHistory.bin.autobak";
  }
  
  public static String EnclosureDownloadHistoryFilePath()
  {
    return BeyondPodPrivateStorageRootPath() + "/BeyondPodHistory.bin";
  }
  
  public static String EnclosureDownloadQueueFilePath()
  {
    return BeyondPodPrivateStorageRootPath() + "/EnclosureDownloadQueue.bin";
  }
  
  public static String EnclosureDownloadRoot()
  {
    return _EnclosureDownloadRootPath;
  }
  
  public static Uri FAQFileURL()
  {
    return Uri.parse(BeyondPodPublicWebSite() + "/Android/help/FAQ.htm");
  }
  
  public static Uri FAQVideoPlayerHelpURL()
  {
    return Uri.parse(BeyondPodPublicWebSite() + "/Android/help/FAQVideoPlaybackIssues.htm");
  }
  
  public static WebSettings.LayoutAlgorithm FeedContentDialogLayoutType()
  {
    return Int2LayoutAlgorithm(_preferences.getInt("FeedContentDialogLayoutType", 2));
  }
  
  public static boolean FeedContentItemOptimizeForReading()
  {
    return _preferences.getBoolean("FeedContentItemOptimizeForReading", false);
  }
  
  public static Uri FeedFailsToLoadURL()
  {
    return Uri.parse(BeyondPodPublicWebSite() + "/Android/help/FAQFeedFailsToLoad.htm");
  }
  
  public static Uri FeedSearchTipsURL()
  {
    return Uri.parse(BeyondPodPublicWebSite() + "/Android/help/FAQFeedSearchTips.htm");
  }
  
  public static Uri FeedURLErrorHelpURL(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(BeyondPodPublicWebSite())).append("/Android/help/FeedRssLookupHelp.aspx?u=");
    if (StringUtils.IsNullOrEmpty(paramString)) {}
    for (paramString = "";; paramString = URLEncoder.encode(paramString)) {
      return Uri.parse(paramString);
    }
  }
  
  public static String FeedUpdateLogFilePath()
  {
    return BeyondPodPublicStorageRootPath() + "/FeedUpdateLog.htm";
  }
  
  public static String FeedUpdateQueueFilePath()
  {
    return BeyondPodPrivateStorageRootPath() + "/FeedUpdateQueue.bin";
  }
  
  public static boolean FeedsFragmentVisible()
  {
    return _preferences.getBoolean("FeedsFragmentVisible", true);
  }
  
  public static Feed FindFeedByIdInTempOrRepository(UUID paramUUID)
  {
    Feed localFeed2 = FeedRepository.GetFeedById(paramUUID);
    Feed localFeed1 = localFeed2;
    if (localFeed2 == null) {
      localFeed1 = (Feed)TempFeedHolder.get(paramUUID);
    }
    return localFeed1;
  }
  
  public static boolean ForceMediaDatabaseRescanOnDownloadOrDelete()
  {
    return _preferences.getBoolean("ForceMediaDtabaseRescanOnDownloadOrDelete", false);
  }
  
  public static boolean ForceMpg123Player()
  {
    return _preferences.getBoolean("ForceMpg123Player", false);
  }
  
  public static String GCMSenderID()
  {
    return "1049497099258";
  }
  
  public static String GReaderAccountName()
  {
    return _preferences.getString("GReaderAccountName", "");
  }
  
  public static String GReaderAuthValue()
  {
    if (_GReaderAuthValue == null) {
      _GReaderAuthValue = _preferences.getString("GReaderAuthValue", null);
    }
    return _GReaderAuthValue;
  }
  
  public static String GReaderCookie()
  {
    if (_GReaderCookie == null) {
      _GReaderCookie = _preferences.getString("GReaderCookie", null);
    }
    return _GReaderCookie;
  }
  
  public static boolean GatherAnalyticsData()
  {
    if (!_preferences.contains("GatherAnalyticsData")) {
      if (LicenseManager.CurrentLicenseKind() != 2) {
        break label40;
      }
    }
    label40:
    for (boolean bool = true;; bool = false)
    {
      setGatherAnalyticsData(bool);
      return _preferences.getBoolean("GatherAnalyticsData", false);
    }
  }
  
  private static String GenerateFeedPasswordKey(UUID paramUUID)
  {
    return String.format("PRIVATE_FEED_DATA:%s", new Object[] { paramUUID });
  }
  
  private static String GetDebugProperty(String paramString1, String paramString2)
  {
    if ((_preferences == null) || (CoreHelper.ApiLevel() < 9)) {}
    String str;
    do
    {
      return paramString2;
      str = _preferences.getString("DebugSettings", null);
    } while (StringUtils.IsNullOrEmpty(str));
    Properties localProperties = new Properties();
    try
    {
      localProperties.load(new StringReader(str));
      paramString1 = localProperties.getProperty(paramString1, paramString2);
      return paramString1;
    }
    catch (Exception paramString1) {}
    return paramString2;
  }
  
  public static String GetFeedPrivateData(UUID paramUUID)
  {
    return _preferences.getString(GenerateFeedPasswordKey(paramUUID), null);
  }
  
  public static int GetLastInstalledVesionCode()
  {
    return _preferences.getInt("LastInstalledVersion", 0);
  }
  
  public static boolean GoogleSyncInitialized()
  {
    return _preferences.getBoolean("GoogleSyncInitialized", false);
  }
  
  public static boolean HasCustomUserAgent()
  {
    return !StringUtils.IsNullOrEmpty(_preferences.getString("DefaultUserAgent", ""));
  }
  
  public static Uri HelpFileCDSURL()
  {
    return Uri.parse(BeyondPodPublicWebSite() + "/Android/help/CDSHelp.htm");
  }
  
  public static Uri HelpFileCategoriesURL()
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(BeyondPodPublicWebSite())).append("/Android/help");
    if (IsCurrentVersionHD()) {}
    for (String str = "/hd/OrganizeFeeds.htm";; str = "/bb/categories_bb.htm") {
      return Uri.parse(str);
    }
  }
  
  public static Uri HelpFileFeedContentURL()
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(BeyondPodPublicWebSite())).append("/Android/help");
    if (IsCurrentVersionHD()) {}
    for (String str = "/hd/bb/posts_bb.htm";; str = "/bb/f_content_bb.htm") {
      return Uri.parse(str);
    }
  }
  
  public static Uri HelpFileFeedsViewURL()
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(BeyondPodPublicWebSite())).append("/Android/help");
    if (IsCurrentVersionHD()) {}
    for (String str = "/hd/bb/posts_bb.htm";; str = "/bb/fv_bb.htm") {
      return Uri.parse(str);
    }
  }
  
  public static Uri HelpFileMyEpisodesURL()
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(BeyondPodPublicWebSite())).append("/Android/help");
    if (IsCurrentVersionHD()) {}
    for (String str = "/hd/bb/podcasts_bb.htm";; str = "/bb/pv_bb.htm") {
      return Uri.parse(str);
    }
  }
  
  public static Uri HelpFilePlayerURL()
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(BeyondPodPublicWebSite())).append("/Android/help");
    if (IsCurrentVersionHD()) {}
    for (String str = "/hd/PlayPodcasts.htm";; str = "/bb/player_bb.htm") {
      return Uri.parse(str);
    }
  }
  
  public static Uri HelpFileQuickPlayURL()
  {
    return Uri.parse(BeyondPodPublicWebSite() + "/Android/help/QuickPlayShortcut.htm");
  }
  
  public static Uri HelpFileSchedulingURL()
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(BeyondPodPublicWebSite())).append("/Android/help");
    if (IsCurrentVersionHD()) {}
    for (String str = "/hd/ScheduleUpdates.htm";; str = "/ScheduleUpdates.htm") {
      return Uri.parse(str);
    }
  }
  
  public static Uri HelpFileURL()
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(BeyondPodPublicWebSite())).append("/Android/help");
    if (IsCurrentVersionHD()) {}
    for (String str = "/hd";; str = "") {
      return Uri.parse(str);
    }
  }
  
  public static WebSettings.LayoutAlgorithm HtmlViewLayoutType()
  {
    return Int2LayoutAlgorithm(_preferences.getInt("HtmlViewLayoutType", 1));
  }
  
  public static int HttpConnectionTimeout()
  {
    int j = StringUtils.TryParseIntFromString(_preferences.getString("HttpConnectionTimeout", "20"), Integer.valueOf(20)).intValue();
    int i = j;
    if (j < 0) {
      i = 20;
    }
    return i;
  }
  
  public static boolean IgnoreGoogleReaderReadStatus()
  {
    return _preferences.getBoolean("IgnoreGoogleReaderReadStatus", false);
  }
  
  public static int IndexOfCurrentPlaylistTrackInPlaylist()
  {
    return _preferences.getInt("IndexOfCurrentPlaylistTrackInPlaylist", -1);
  }
  
  public static boolean Initialize(Context paramContext)
    throws Resources.NotFoundException, IOException
  {
    _Context = paramContext;
    _LastSelectedFeed = null;
    _ActiveFeedCategory = null;
    ConfigurationInitErrorType = 0;
    ConfigurationInitErrorMsg = null;
    _preferences = paramContext.getSharedPreferences("Settings", 0);
    if (!InitializeStorageFolders()) {
      return false;
    }
    if (!DatabaseHelper.DataBaseExists()) {
      _IsFirstRun = true;
    }
    new StartupContentBuilder().CheckAndCreateStartupContent(_IsFirstRun);
    CoreHelper.TruncateLogFileIfNecessary();
    return true;
  }
  
  public static boolean InitializeStorageFolders()
  {
    File localFile1 = CoreHelper.ExternalStorageDirectory();
    if ((localFile1 == null) || (!localFile1.exists()))
    {
      ConfigurationInitErrorType = -1;
      ConfigurationInitErrorMsg = SD_CARD_ERROR + "\n\n Unable to find path: " + localFile1;
      return false;
    }
    _BeyondPodPublicStorageRoot = ConstructBeyondPodRootIn(localFile1.getAbsolutePath());
    if (!_BeyondPodPublicStorageRoot.exists()) {
      _BeyondPodPublicStorageRoot.mkdirs();
    }
    if (!_BeyondPodPublicStorageRoot.exists())
    {
      ConfigurationInitErrorType = -3;
      ConfigurationInitErrorMsg = SD_CARD_CANT_CREATE_FOLDER + "\n\n Unable to create folder: " + _BeyondPodPublicStorageRoot.getAbsolutePath() + SD_CARD_CANT_CREATE_FOLDER_WORKAROUND;
      return false;
    }
    File localFile2 = ConstructEnclosureDownloadRoot(_BeyondPodPublicStorageRoot);
    if (!localFile2.exists()) {
      localFile2.mkdirs();
    }
    if (!localFile2.exists())
    {
      ConfigurationInitErrorType = -2;
      ConfigurationInitErrorMsg = SD_CARD_CANT_CREATE_FOLDER + "\n\n Unable to create folder: " + localFile2.getAbsolutePath() + SD_CARD_CANT_CREATE_FOLDER_WORKAROUND;
      return false;
    }
    setEnclosureDownloadRoot(localFile2.getPath());
    localFile2 = new File(RssImageCachePath());
    if (!localFile2.exists()) {
      localFile2.mkdirs();
    }
    setLastSDCardRootPath(localFile1.getAbsolutePath());
    return true;
  }
  
  public static WebSettings.LayoutAlgorithm Int2LayoutAlgorithm(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return WebSettings.LayoutAlgorithm.NORMAL;
    case 1: 
      return WebSettings.LayoutAlgorithm.NORMAL;
    case 2: 
      return WebSettings.LayoutAlgorithm.SINGLE_COLUMN;
    }
    return WebSettings.LayoutAlgorithm.NARROW_COLUMNS;
  }
  
  public static boolean IsBetaVersion()
  {
    return false;
  }
  
  public static boolean IsCellularConnectionAllowed()
  {
    return _preferences.getBoolean("AllowCellularConnections", true);
  }
  
  public static boolean IsCurrentPlaylistManuallyModified()
  {
    return _preferences.getBoolean("IsCurrentPlaylistManuallyModified", false);
  }
  
  public static boolean IsCurrentVersionHD()
  {
    return "bphd".equals(BeyondPodApplication.GetInstance().AppKind());
  }
  
  public static boolean IsExpirationWarningShownInThisSession()
  {
    return _IsExpirationWarningShownInThisSession;
  }
  
  public static boolean IsFirstRun()
  {
    return _IsFirstRun;
  }
  
  public static boolean IsInstalledOnSDCard()
  {
    if (CoreHelper.ApiLevel() < 8) {}
    for (;;)
    {
      return false;
      PackageManager localPackageManager = BeyondPodApplication.GetInstance().getPackageManager();
      try
      {
        int i = localPackageManager.getPackageInfo(PackageName(), 0).applicationInfo.flags;
        if ((i & 0x40000) == 262144) {
          return true;
        }
      }
      catch (Exception localException)
      {
        CoreHelper.LogException("Configuration", "Failed to check BeyondPod install location", localException);
      }
    }
    return false;
  }
  
  public static boolean IsSlowDevice()
  {
    return CoreHelper.ApiLevel() < 7;
  }
  
  public static boolean IsSonicSpeedAlterationSupported()
  {
    return CoreHelper.ApiLevel() > 7;
  }
  
  public static boolean IsSpeedAlterationSupportedOnAppStore()
  {
    if (IsSonicSpeedAlterationSupported()) {
      return true;
    }
    switch (CurrentAppStore())
    {
    }
    return false;
  }
  
  public static String ItemHistoryBackupFilePath()
  {
    return BeyondPodPublicStorageRootPath() + "/" + "BeyondPodItemHistory.bin.autobak";
  }
  
  public static String ItemHistoryBackupManagerFilePath()
  {
    return BackupManagerBackupPath() + "/" + "BeyondPodItemHistory.bin.autobak";
  }
  
  public static String ItemHistoryFilePath()
  {
    return BeyondPodPrivateStorageRootPath() + "/BeyondPodItemHistory.bin";
  }
  
  public static boolean KeepCurrentEpisodeForClearPlaylist()
  {
    return _preferences.getBoolean("KeepCurrentEpisodeForClearPlaylist", false);
  }
  
  public static boolean KeepCurrentEpisodeForDefferAutoSyncSmartPlay()
  {
    return _preferences.getBoolean("KeepCurrentEpisodeForDefferAutoSyncSmartPlay", true);
  }
  
  public static boolean KeepMetadataForMissingEpisodes()
  {
    return _preferences.getBoolean("KeepMetadataForMissingEpisodes", true);
  }
  
  public static boolean KeepScreenOnWhenUpdatingOverWiFi()
  {
    return ScreenPowerStateDuringWiFiUpdates() == 1;
  }
  
  public static Uri KnowledgeBaseURI()
  {
    return Uri.parse("http://beyondpod.com/support/index.php?/Knowledgebase/List");
  }
  
  public static long LastRemoteChangeTimeStamp()
  {
    return _preferences.getLong("LastRemoteChangeTimeStamp", -1L);
  }
  
  public static String LastSDCardRootPath()
  {
    return _preferences.getString("LastSDCardRootPath", null);
  }
  
  public static long LastSyncTimeStamp()
  {
    return _preferences.getLong("LastSyncTimeStamp", -1L);
  }
  
  private static int LayoutAlgorithm2Int(WebSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    if (WebSettings.LayoutAlgorithm.NORMAL.equals(paramLayoutAlgorithm)) {}
    do
    {
      return 1;
      if (WebSettings.LayoutAlgorithm.SINGLE_COLUMN.equals(paramLayoutAlgorithm)) {
        return 2;
      }
    } while (!WebSettings.LayoutAlgorithm.NARROW_COLUMNS.equals(paramLayoutAlgorithm));
    return 3;
  }
  
  public static Uri LibriVoxAudiobooksCatalogURL()
  {
    return Uri.parse(BeyondPodPublicWebSite() + "/Android/search/AudioBookCatalog.aspx");
  }
  
  public static String LicenseTypeString()
  {
    return _preferences.getString("LicenseTypeString", "");
  }
  
  public static boolean LoadContentViewImagesAutomatically()
  {
    return _preferences.getBoolean("LoadContentViewImagesAutomatically", true);
  }
  
  public static String LogFilePath()
  {
    return BeyondPodPublicStorageRootPath() + "/BeyondPodLog.txt";
  }
  
  public static String LogcatFilePath()
  {
    return BeyondPodPublicStorageRootPath() + "/LogcatLog.txt";
  }
  
  public static int MarkAsReadOnOpen()
  {
    return StringUtils.SafeParseInt(_preferences.getString("MarkAsReadOnOpen", Integer.toString(2)), 2);
  }
  
  public static Uri MetachannelCatalogURL()
  {
    return Uri.parse(BeyondPodPublicWebSite() + "/Android/search/MetaChannelsCatalog.aspx");
  }
  
  public static boolean MultilineEpisodeTitle()
  {
    return _preferences.getBoolean("MultilineEpisodeTitle", false);
  }
  
  public static boolean NotifyForBetaReleases()
  {
    return _preferences.getBoolean("NotifyForBetaReleases", false);
  }
  
  public static Uri NprPodcastDirectoryURL()
  {
    return Uri.parse("http://www.npr.org/podcasts.opml");
  }
  
  public static String OAuthAccessToken()
  {
    return _preferences.getString("OAuthToken", null);
  }
  
  public static Date OAuthAccessTokenExpiration()
  {
    return new Date(_preferences.getLong("OAuthAccessTokenExpiration", 0L));
  }
  
  public static String OAuthRefreshToken()
  {
    return _preferences.getString("OAuthRefreshToken", null);
  }
  
  public static String OAuthUser()
  {
    return _preferences.getString("OAuthUser", null);
  }
  
  public static int OrientationLock()
  {
    return StringUtils.SafeParseInt(_preferences.getString("OrientationLock", Integer.toString(0)), 0);
  }
  
  public static String PackageName()
  {
    return BeyondPodApplication.GetInstance().getPackageName();
  }
  
  public static boolean PatchVideoFilesForMediaScanner()
  {
    return _preferences.getBoolean("PatchVideoFilesForMediaScanner", true);
  }
  
  public static boolean PauseOnHeadsetDisconnect()
  {
    if (!_preferences.contains("PauseOnHeadsetDisconnect")) {
      setPauseOnHeadsetDisconnect(true);
    }
    return _preferences.getBoolean("PauseOnHeadsetDisconnect", true);
  }
  
  public static boolean PauseOnNotification()
  {
    return _preferences.getBoolean("PauseOnNotification", true);
  }
  
  public static boolean PauseOnPowerDisconnect()
  {
    return _preferences.getBoolean("PauseOnPowerDisconnect", false);
  }
  
  public static boolean PauseVideoOnScreenOff()
  {
    return _preferences.getBoolean("PauseVideoOnScreenOff", true);
  }
  
  public static float PlaybackSpeed1()
  {
    return StringUtils.SafeParseFloat(_preferences.getString("PlaybackSpeed1", "1.5f"), 1.5F);
  }
  
  public static float PlaybackSpeed2()
  {
    return StringUtils.SafeParseFloat(_preferences.getString("PlaybackSpeed2", "2.0f"), 2.0F);
  }
  
  public static float PlaybackSpeedNormal()
  {
    return 1.0F;
  }
  
  public static int PlayerIntegrationType()
  {
    return StringUtils.SafeParseInt(_preferences.getString("PlayerIntegrationType", Integer.toString(0)), 0);
  }
  
  public static int PlayerPlaybackScreenPowerState()
  {
    return StringUtils.SafeParseInt(_preferences.getString("PlayerPlaybackScreenPowerState", Integer.toString(0)), 0);
  }
  
  public static boolean PlayerPlaylistVisible()
  {
    return _preferences.getBoolean("PlayerPlaylistVisible", false);
  }
  
  public static int PlayerSleepTimeout()
  {
    int j = 0;
    int[] arrayOfInt = PlayerSleepTimeouts();
    int i = j;
    if (arrayOfInt.length > 0)
    {
      i = j;
      if (arrayOfInt[0] > 0) {
        i = arrayOfInt[0];
      }
    }
    return i;
  }
  
  public static int[] PlayerSleepTimeouts()
  {
    Object localObject = _preferences.getString("PlayerSleepTimeout", null);
    if (StringUtils.IsNullOrEmpty((String)localObject))
    {
      localObject = new int[0];
      return (int[])localObject;
    }
    int[] arrayOfInt2 = new int[7];
    localObject = _SleepTimes.matcher((CharSequence)localObject);
    int i = 0;
    label42:
    if (!((Matcher)localObject).find()) {}
    for (;;)
    {
      int[] arrayOfInt1 = new int[i];
      int j = 0;
      for (;;)
      {
        localObject = arrayOfInt1;
        if (j == i) {
          break;
        }
        arrayOfInt1[j] = arrayOfInt2[j];
        j += 1;
      }
      int k = StringUtils.SafeParseInt(((Matcher)localObject).group(), 0);
      j = i;
      if (k > 0)
      {
        j = i;
        if (k < 10000)
        {
          arrayOfInt2[i] = k;
          j = i + 1;
        }
      }
      i = j;
      if (j <= arrayOfInt2.length - 1) {
        break label42;
      }
      i = j;
    }
  }
  
  public static String PlaylistBackupFilePath()
  {
    return BeyondPodPublicStorageRootPath() + "/" + "PlayList.bin.autobak";
  }
  
  public static String PlaylistBackupManagerFilePath()
  {
    return BackupManagerBackupPath() + "/" + "PlayList.bin.autobak";
  }
  
  public static int PlaylistEndAction()
  {
    return StringUtils.SafeParseInt(_preferences.getString("PlaylistEndAction", "1"), 1);
  }
  
  public static String PlaylistFilePath()
  {
    return BeyondPodPrivateStorageRootPath() + "/PlayList.bin";
  }
  
  public static String PlaylistM3UFilePath()
  {
    return BeyondPodPublicStorageRootPath() + "/BeyondPod.m3u";
  }
  
  public static int PlaylistSizeOnSave()
  {
    return _preferences.getInt("PlaylistSizeOnSave", -1);
  }
  
  public static int PodcastNamingScheme()
  {
    return StringUtils.SafeParseInt(_preferences.getString("PodcastNamingScheme", "0"), 0);
  }
  
  public static Uri PopularPodcastDirectoriesURL()
  {
    return Uri.parse(BeyondPodPublicWebSite() + "/Android/search/PopularPodcastRepositories.aspx?v=" + ProductVersion());
  }
  
  public static boolean PreferLastSDCardRoot()
  {
    return _preferences.getBoolean("PreferLastSDCardRoot", false);
  }
  
  public static boolean PreventKeyguard()
  {
    return _preferences.getBoolean("PreventKeyguard", false);
  }
  
  public static String ProductVersion()
  {
    return CurrentProductVersion().toString();
  }
  
  public static String ProductVersionAsString()
  {
    String str2 = ProductVersion();
    if (IsBetaVersion()) {}
    for (String str1 = "BETA";; str1 = "") {
      return String.format("BeyondPod %s %s", new Object[] { str2, str1 });
    }
  }
  
  public static boolean PublishPlaylist()
  {
    return _preferences.getBoolean("PublishPlaylist", false);
  }
  
  public static boolean RemovePlayedFromPlaylist()
  {
    return _preferences.getBoolean("RemovePlayedFromPlaylist", false);
  }
  
  public static int ResumeReplayDuration()
  {
    return StringUtils.SafeParseInt(_preferences.getString("ResumeReplayDuration", "0"), 0);
  }
  
  public static boolean RichPlayerNotication()
  {
    if (CoreHelper.ApiLevel() < 11) {
      return false;
    }
    return _preferences.getBoolean("EnhancedPlayerNotication", false);
  }
  
  public static String RssCachePath()
  {
    return Path.Combine(BeyondPodPublicStorageRootPath(), "RSSCache");
  }
  
  public static String RssImageCachePath()
  {
    return Path.Combine(RssCachePath(), "img");
  }
  
  public static String RssTemplatesImagePath()
  {
    return BeyondPodContentUrl() + "/BeyondPodImagePath";
  }
  
  public static String RssTemplatesPath()
  {
    return Path.Combine(BeyondPodPublicStorageRootPath(), "RSSTemplates");
  }
  
  public static int ScreenPowerStateDuringWiFiUpdates()
  {
    if (!_preferences.contains("ScreenPowerStateDuringWiFiUpdates")) {
      if (!_preferences.getBoolean("KeepScreenOnWhenUpdatingOverWiFi", false)) {
        break label54;
      }
    }
    label54:
    for (int i = 1;; i = 2)
    {
      setScreenPowerStateDuringWiFiUpdates(i);
      return StringUtils.SafeParseInt(_preferences.getString("ScreenPowerStateDuringWiFiUpdates", "0"), 0);
    }
  }
  
  public static boolean ScrobbleEnabled()
  {
    return _preferences.getBoolean("ScrobbleEnabled", false);
  }
  
  public static boolean SetAsDownloadedOnMarkRead()
  {
    return _preferences.getBoolean("SetAsDownloadedOnMarkRead", false);
  }
  
  public static boolean SetAsPlayedOnMarkRead()
  {
    return _preferences.getBoolean("SetAsPlayedOnMarkRead", false);
  }
  
  public static void SetUnableToEstablishWiFiConnectionInThisSession(boolean paramBoolean)
  {
    _UnableToEstablishWiFiConnectionInThisSession = paramBoolean;
  }
  
  public static String SettingsBackupManagerFilePath()
  {
    return BackupManagerBackupPath() + "/" + "Settings.xml.autobak";
  }
  
  public static String SettingsFilePath()
  {
    return _Context.getFilesDir().getParent() + "/shared_prefs/" + "Settings" + ".xml";
  }
  
  public static boolean SharePodcasts()
  {
    return _preferences.getBoolean("SharePodcasts", true);
  }
  
  public static boolean ShowCDSSettings()
  {
    return _preferences.getBoolean("ShowCDSSettings", false);
  }
  
  public static boolean ShowContentListPostImages()
  {
    return _preferences.getBoolean("ShowContentListPostImages", false);
  }
  
  public static boolean ShowPodcastThumbnails()
  {
    return _preferences.getBoolean("ShowPodcastThumbnails", true);
  }
  
  public static int SkipToEndButtonClickType()
  {
    return StringUtils.SafeParseInt(_preferences.getString("SkipToEndButtonClickType", "1"), 1);
  }
  
  public static String SmartPlaylistBackupFilePath()
  {
    return BeyondPodPublicStorageRootPath() + "/" + "SmartPlayList.bin.autobak";
  }
  
  public static String SmartPlaylistBackupManagerFilePath()
  {
    return BackupManagerBackupPath() + "/" + "SmartPlayList.bin.autobak";
  }
  
  public static String SmartPlaylistFilePath()
  {
    return BeyondPodPrivateStorageRootPath() + "/SmartPlayList.bin";
  }
  
  public static int StartupView()
  {
    return StringUtils.SafeParseInt(_preferences.getString("StartupView", Integer.toString(0)), 0);
  }
  
  public static void StoreFeedPrivateData(UUID paramUUID, String paramString)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, GenerateFeedPasswordKey(paramUUID), paramString);
  }
  
  public static Uri SwitchToFeedlyHelpURL()
  {
    return Uri.parse(BeyondPodPublicWebSite() + "/Android/help/Reader2Feedly.htm");
  }
  
  public static String SyncLogFilePath()
  {
    return BeyondPodPublicStorageRootPath() + "/BeyondPodSyncLog.txt";
  }
  
  public static String TrackStateBackupManagerPath()
  {
    return Path.Combine(BackupManagerBackupPath(), "TrackState.xml.autobak");
  }
  
  public static String TrackStateBackupPath()
  {
    return Path.Combine(BeyondPodPublicStorageRootPath(), "TrackState.xml.autobak");
  }
  
  public static boolean TurnWiFiDuringUpdate()
  {
    return _preferences.getBoolean("TurnWiFiDuringUpdate", false);
  }
  
  public static int UIMode()
  {
    int i = StringUtils.SafeParseInt(_preferences.getString("UIMode", "0"), 0);
    if (i == 0)
    {
      if (_Context.getPackageManager().hasSystemFeature("android.hardware.touchscreen")) {
        return 1;
      }
      return 2;
    }
    return i;
  }
  
  public static boolean UnableToEstablishWiFiConnectionInThisSession()
  {
    return _UnableToEstablishWiFiConnectionInThisSession;
  }
  
  public static Uri UpdateAndDownloadHelpFileURL()
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(BeyondPodPublicWebSite())).append("/Android/help");
    if (IsCurrentVersionHD()) {}
    for (String str = "/hd/UpdateAndDownload.htm";; str = "/UpdateAndDownload.htm") {
      return Uri.parse(str);
    }
  }
  
  public static boolean UseAudioPluginForConfiguredFeedsOnly()
  {
    return _preferences.getBoolean("UseAudioPluginForConfiguredFeedsOnly", false);
  }
  
  public static boolean UseExternalBrowser()
  {
    return _preferences.getBoolean("UseExternalBrowser", false);
  }
  
  public static boolean UseFeedContentViewPager()
  {
    return _preferences.getBoolean("UseFeedContentViewPager", false);
  }
  
  public static String UserNotificationPreferences()
  {
    return _preferences.getString("UserNotificationPreferences", "");
  }
  
  public static Uri VersionCheckBetaURL()
  {
    return Uri.parse(BeyondPodPublicWebSite() + "/Android/BETA/Default.aspx?v=" + ProductVersion());
  }
  
  public static String VersionInfoPath()
  {
    return Path.Combine(RssCachePath(), "VerInfo.bin");
  }
  
  public static int VolumeControlsNavigationType()
  {
    return StringUtils.SafeParseInt(_preferences.getString("VolumeControlsNavigationType", "0"), 0);
  }
  
  public static int WRDoubleClickButtonAction()
  {
    return StringUtils.SafeParseInt(_preferences.getString("WRDoubleClickButtonAction", Integer.toString(1)), 1);
  }
  
  public static int WRLongPressButtonAction()
  {
    return StringUtils.SafeParseInt(_preferences.getString("WRLongPressButtonAction", Integer.toString(3)), 3);
  }
  
  public static Uri WelcomeFileURI()
  {
    if (UIMode() == 2) {
      return WelcomeGTVFileURI();
    }
    if (CoreHelper.IsPartnerSony()) {
      return WelcomeLiteSonyFileURI();
    }
    if (LicenseManager.IsUnlocked()) {
      return WelcomeProFileURI();
    }
    return WelcomeLiteFileURI();
  }
  
  public static Uri WelcomeGTVFileURI()
  {
    return Uri.parse("file:///android_asset/WelcomeGTV.htm");
  }
  
  public static Uri WelcomeLiteFileURI()
  {
    return Uri.parse("file:///android_asset/Welcome.htm");
  }
  
  public static Uri WelcomeLiteSonyFileURI()
  {
    return Uri.parse("file:///android_asset/WelcomeSony.htm");
  }
  
  public static Uri WelcomeProFileURI()
  {
    return Uri.parse("file:///android_asset/WelcomePro.htm");
  }
  
  public static Uri WhatIsNewFileURI()
  {
    return Uri.parse("file:///android_asset/WhatIsNew.htm");
  }
  
  public static int WidgetBackgroundColor()
  {
    return StringUtils.SafeParseInt(_preferences.getString("WidgetBackgroundColor", Integer.toString(1)), 1);
  }
  
  public static int WidgetSecondaryButtonAction()
  {
    return StringUtils.SafeParseInt(_preferences.getString("WidgetSecondaryButtonAction", Integer.toString(1)), 1);
  }
  
  public static void WriteLastInstalledVersionCode()
  {
    ConfigWriteHelper.getInstance().putInt(_preferences, "LastInstalledVersion", CurrentProductVersionCode());
  }
  
  public static void addRecentFeed(Feed paramFeed)
  {
    if ((paramFeed == null) || (!paramFeed.HasPodcasts())) {
      return;
    }
    Object localObject = getRecentFeeds();
    if (((LinkedList)localObject).contains(paramFeed)) {
      ((LinkedList)localObject).remove(paramFeed);
    }
    ((LinkedList)localObject).addFirst(paramFeed);
    if (((LinkedList)localObject).size() > 3) {
      ((LinkedList)localObject).removeLast();
    }
    paramFeed = new StringBuilder(90);
    localObject = ((LinkedList)localObject).iterator();
    for (;;)
    {
      if (!((Iterator)localObject).hasNext())
      {
        ConfigWriteHelper.getInstance().putString(_preferences, "RecentFeedsList", paramFeed.toString());
        return;
      }
      Feed localFeed = (Feed)((Iterator)localObject).next();
      if (paramFeed.length() > 0) {
        paramFeed.append("|");
      }
      paramFeed.append(localFeed.ID());
    }
  }
  
  public static File findAndroidReportedExternalStorage()
  {
    if (CoreHelper.ApiLevel() >= 19)
    {
      int j;
      int i;
      do
      {
        try
        {
          arrayOfFile = BeyondPodApplication.GetInstance().getExternalFilesDirs(null);
          localFile3 = Environment.getExternalStorageDirectory();
          j = arrayOfFile.length;
          i = 0;
        }
        catch (Exception localException)
        {
          File[] arrayOfFile;
          File localFile3;
          File localFile1;
          boolean bool;
          CoreHelper.WriteLogEntry("Configuration", "Unable to get Android reported SD card! Reason: " + localException.getMessage());
          break;
        }
        localFile1 = arrayOfFile[i];
        if (localFile1 != null)
        {
          bool = localFile1.getAbsolutePath().startsWith(localFile3.getAbsolutePath());
          if (!bool) {
            return ???;
          }
        }
        i += 1;
      } while (i < j);
    }
    File localFile2 = null;
    return localFile2;
  }
  
  public static FeedCategory getActiveFeedCategory()
  {
    if ((_ActiveFeedCategory == null) || (_ActiveFeedCategory == CategoryManager.CategoryNull) || (!CategoryManager.HasCategory(_ActiveFeedCategory)))
    {
      if ((_ActiveFeedCategory != null) && (_ActiveFeedCategory != CategoryManager.CategoryNull)) {
        CoreHelper.WriteTraceEntry("Configuration", "!!! Found non existing category " + _ActiveFeedCategory.toString());
      }
      _ActiveFeedCategory = CategoryManager.GetCategoryByValue(_preferences.getString("ActiveCategory", null));
    }
    return _ActiveFeedCategory;
  }
  
  public static Feed getActiveFeedFilter()
  {
    String str;
    if (_LastSelectedFeed == null)
    {
      str = _preferences.getString("ActiveFeedFilter", null);
      if (StringUtils.IsNullOrEmpty(str)) {}
    }
    try
    {
      _LastSelectedFeed = FeedRepository.GetFeedById(UUID.fromString(str));
      return _LastSelectedFeed;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        CoreHelper.LogException("Configuration", "Unable to load last ActiveFeedFilter", localException);
      }
    }
  }
  
  public static int getActiveMediaFilter()
  {
    return _preferences.getInt("ActiveMediaFilter", 0);
  }
  
  public static boolean getAllowAutoTrackDeletions()
  {
    return _preferences.getBoolean("AllowAutoTrackDeletions", true);
  }
  
  public static boolean getAutoScreenOffOnPlayback()
  {
    return _preferences.getBoolean("AutoScreenOffOnPlayback", false);
  }
  
  public static int getBackwardSkipInterval()
  {
    return StringUtils.SafeParseInt(_preferences.getString("BackwardSkipInterval", "11"), 11);
  }
  
  public static String getContentViewColor()
  {
    return _preferences.getString("ContentViewColor", "#6699CC");
  }
  
  public static int getContentViewPageSize()
  {
    return StringUtils.SafeParseInt(_preferences.getString("ContentViewPageSize", "10"), 10);
  }
  
  public static String getDefaultDocFontSize()
  {
    return _preferences.getString("ContentFontSize", "medium");
  }
  
  public static String getDefaultSendToMailAddress()
  {
    return _preferences.getString("DefaultSendToEmails", "");
  }
  
  public static boolean getEnableScreenTransitions()
  {
    return _preferences.getBoolean("EnableScreenTransitions", true);
  }
  
  public static String getExportedOPMLPath()
  {
    String str2 = _preferences.getString("ExportedOPMLPath", "");
    String str1 = str2;
    if (StringUtils.IsNullOrEmpty(str2)) {
      str1 = BeyondPodPublicStorageRootPath() + "/BeyondPodFeeds.opml";
    }
    return str1;
  }
  
  public static String getExternalUrlHandler()
  {
    return _preferences.getString("ExternalUrlHandler", "");
  }
  
  public static Uri getFeedUpdateLogURL()
  {
    return Uri.parse(BeyondPodContentUrl() + "/BeyondPodStorageRootPath/FeedUpdateLog.htm");
  }
  
  public static int getFeedsSortOrder()
  {
    return StringUtils.SafeParseInt(_preferences.getString("FeedsSortOrder", "0"), 0);
  }
  
  public static int getForwardSkipInterval()
  {
    return StringUtils.SafeParseInt(_preferences.getString("ForwardSkipInterval", "31"), 31);
  }
  
  public static int getGlobalDefaultKeepAtMostPodcasts()
  {
    return StringUtils.SafeParseInt(_preferences.getString("DefaultKeepAtMostPodcasts", "10"), 10);
  }
  
  public static int getGlobalDefaultMaximumGReaderItemsToGet()
  {
    return StringUtils.SafeParseInt(_preferences.getString("DefaultMaximumGReaderItemsToGet", "20"), 20);
  }
  
  public static TimeSpan getGlobalDefaultMaximumPodcastAge()
  {
    return new TimeSpan(StringUtils.SafeParseInt(_preferences.getString("DefaultMaximumPodcastAge", Integer.toString(99999)), 99999), 0L, 0L, 0L, 0L);
  }
  
  public static int getGlobalDefaultNumberPodcastsToDownload()
  {
    return StringUtils.SafeParseInt(_preferences.getString("DefaultNumberPodcastsToDownload", "3"), 3);
  }
  
  public static int getGlobalDefaultPodcastDownloadAction()
  {
    return StringUtils.SafeParseInt(_preferences.getString("DefaultPodcastDownloadAction", Integer.toString(1)), 1);
  }
  
  public static String getGoogleReaderPassword()
  {
    return _preferences.getString("GoogleReaderPassword", "");
  }
  
  public static String getGoogleReaderUserName()
  {
    return _preferences.getString("GoogleReaderUserName", "");
  }
  
  public static boolean getGroupByFeedIfShowingCategoryTracks()
  {
    return _preferences.getBoolean("GroupByFeedIfShowingCategoryTracks", false);
  }
  
  public static Uri getHDVersionAppStoreIntent()
  {
    switch ()
    {
    default: 
      return Uri.parse("https://market.android.com/details?id=mobi.beyondpod.hd");
    }
    return Uri.parse("http://www.amazon.com/gp/mas/dl/android?p=mobi.beyondpod.hd");
  }
  
  public static boolean getHideReadFeeds()
  {
    return _preferences.getBoolean("HideReadFeeds", false);
  }
  
  public static boolean getHideReadItems()
  {
    return _preferences.getBoolean("HideReadItems", false);
  }
  
  public static boolean getHideUnsupportedFileTypes()
  {
    return _preferences.getBoolean("HideUnsupportedFileTypes", true);
  }
  
  public static String getInternalPlayerSupportedFileExtensions()
  {
    return _preferences.getString("PlayerSupportedFileExtensions", "3gp,mp4,m4v,h264.mp4,m4a,mp3,mid,xmf,mxmf,rtttl,rtx,ota,imy,ogg,wav,jpg,gif,png,bmp");
  }
  
  public static int getItemFilter()
  {
    return _preferences.getInt("ItemFilter", 0);
  }
  
  public static int getLastActiveScreen()
  {
    return _preferences.getInt("LastActiveScreen", 0);
  }
  
  public static UUID getLastSelectedFeed()
  {
    Object localObject = _preferences.getString("LastSelectedFeed", null);
    if (StringUtils.IsNullOrEmpty((String)localObject)) {
      return null;
    }
    try
    {
      localObject = UUID.fromString((String)localObject);
      return (UUID)localObject;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public static Date getLastUpdateAndDownloadManagerRunTime()
  {
    long l = _preferences.getLong("LastUpdateAndDownloadManagerRunTime", -1L);
    if (l == -1L) {
      return new Date();
    }
    return new Date(l);
  }
  
  public static String getLinkPrefix()
  {
    return _preferences.getString("FeedItemLinkPrefix", "");
  }
  
  public static int getMediaEndAction()
  {
    return StringUtils.SafeParseInt(_preferences.getString("MediaEndAction", "0"), 0);
  }
  
  public static String getMobileFormatter()
  {
    return _preferences.getString("MobileFormatter", "");
  }
  
  public static Date getNextNotificationTime()
  {
    long l = _preferences.getLong("NextNotificationTime", -1L);
    if (l == -1L) {
      return new Date();
    }
    return new Date(l);
  }
  
  public static int getPodcastsSortOrder()
  {
    return StringUtils.SafeParseInt(_preferences.getString("PodcastsSortOrder", "0"), 0);
  }
  
  public static LinkedList<Feed> getRecentFeeds()
  {
    LinkedList localLinkedList = new LinkedList();
    Object localObject = _preferences.getString("RecentFeedsList", null);
    if (!StringUtils.IsNullOrEmpty((String)localObject))
    {
      int j;
      int i;
      do
      {
        try
        {
          localObject = ((String)localObject).split("\\|");
          j = localObject.length;
          i = 0;
        }
        catch (Exception localException)
        {
          Feed localFeed;
          CoreHelper.LogException("Configuration", "Unable to load recent feeds", localException);
          return localLinkedList;
        }
        localFeed = FeedRepository.GetFeedById(UUID.fromString(localObject[i]));
        if (localFeed != null) {
          localLinkedList.add(localFeed);
        }
        i += 1;
      } while (i < j);
    }
    return localLinkedList;
  }
  
  public static String getRepoMovedPath()
  {
    return _preferences.getString("RepoMovedPath", "");
  }
  
  public static String getShortcutKeys()
  {
    return _preferences.getString("ShortcutKeys", "");
  }
  
  public static boolean getShowAllPodcastsInCategory()
  {
    return _preferences.getBoolean("ShowAllPodcastsInCategory", false);
  }
  
  public static Uri getSuggestFeatureURL()
  {
    return Uri.parse(BeyondPodPublicWebSite() + "/SuggestFeature.htm");
  }
  
  public static int getTraceLevel()
  {
    return _preferences.getInt("TraceLevel", 0);
  }
  
  public static Date getTrialStartDate()
  {
    long l = _preferences.getLong("TrialStartDate", 0L);
    if (l == 0L) {
      return null;
    }
    return new Date(l);
  }
  
  public static Uri getUnlocKeyAppStoreIntent()
  {
    switch ()
    {
    default: 
      return Uri.parse("market://details?id=mobi.beyondpod.unlockkey");
    }
    return Uri.parse("http://www.amazon.com/gp/mas/dl/android?p=mobi.beyondpod.unlockkey");
  }
  
  public static boolean getUpdateOnFeedOpen()
  {
    return _preferences.getBoolean("UpdateOnFeedOpen", false);
  }
  
  public static boolean getUpdateOnStartup()
  {
    return _preferences.getBoolean("UpdateOnStartup", false);
  }
  
  public static int getVolumeLevel()
  {
    return _preferences.getInt("VolumeLevel", 70);
  }
  
  public static void setActiveFeedCategory(FeedCategory paramFeedCategory)
  {
    if (getActiveFeedCategory().equals(paramFeedCategory)) {
      return;
    }
    _ActiveFeedCategory = paramFeedCategory;
    ConfigWriteHelper.getInstance().putString(_preferences, "ActiveCategory", paramFeedCategory.Value());
  }
  
  public static void setActiveFeedFilter(Feed paramFeed)
  {
    _LastSelectedFeed = paramFeed;
    ConfigWriteHelper localConfigWriteHelper = ConfigWriteHelper.getInstance();
    SharedPreferences localSharedPreferences = _preferences;
    if (paramFeed == null) {}
    for (String str = "";; str = paramFeed.ID().toString())
    {
      localConfigWriteHelper.putString(localSharedPreferences, "ActiveFeedFilter", str);
      addRecentFeed(paramFeed);
      return;
    }
  }
  
  public static void setActiveMediaFilter(int paramInt)
  {
    ConfigWriteHelper.getInstance().putInt(_preferences, "ActiveMediaFilter", paramInt);
  }
  
  public static void setAllowAutoTrackDeletions(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "AllowAutoTrackDeletions", paramBoolean);
  }
  
  public static void setAllowVideosInPlaylist(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "AllowVideosInPlaylist", paramBoolean);
  }
  
  public static void setAreSettingsInitialized(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "DefaultSettingsInitialized", paramBoolean);
  }
  
  public static void setAutoCloseFeedContentListView(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "AutoCloseFeedContentListView", paramBoolean);
  }
  
  public static void setAutoPlaylistEnabled(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "AutoPlaylistEnabled", paramBoolean);
  }
  
  public static void setAutoScreenOffOnPlayback(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "AutoScreenOffOnPlayback", paramBoolean);
  }
  
  public static void setBTRemoteButtonAction(int paramInt)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "BTRemoteButtonAction", Integer.toString(paramInt));
  }
  
  public static void setBackupSnapshotRestoredFlag(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "BackupSnapshotRestoredFlag", paramBoolean);
  }
  
  public static void setBackwardSkipInterval(int paramInt)
  {
    if (getBackwardSkipInterval() == paramInt) {
      return;
    }
    ConfigWriteHelper.getInstance().putString(_preferences, "BackwardSkipInterval", Integer.toString(paramInt));
  }
  
  public static void setCDSAllowRemoteEpisodeDeletions(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "CDSAllowRemoteEpisodeDeletions", paramBoolean);
  }
  
  public static void setCDSAllowRemoteFeeds(int paramInt)
  {
    ConfigWriteHelper.getInstance().putInt(_preferences, "CDSAllowRemoteFeeds", paramInt);
  }
  
  public static void setCDSDeviceID(String paramString)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "CDSDeviceID", paramString);
  }
  
  public static void setCDSEnabled(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "CDSEnabled", paramBoolean);
  }
  
  public static void setCDSPassword(String paramString)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "CDSPassword", paramString);
  }
  
  public static void setCDSSyncFurthestPlayedPositionOnly(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "CDSSyncFurthestPlayedPositionOnly", paramBoolean);
  }
  
  public static void setCDSSyncRetryInterval(int paramInt)
  {
    ConfigWriteHelper.getInstance().putInt(_preferences, "CDSSyncRetryInterval", paramInt);
  }
  
  public static void setCDSToken(String paramString)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "CDSToken", paramString);
  }
  
  public static void setCDSTokenExpiration(Date paramDate)
  {
    ConfigWriteHelper.getInstance().putLong(_preferences, "CDSTokenExpiration", paramDate.getTime());
  }
  
  public static void setCDSUserName(String paramString)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "CDSUserName", paramString);
  }
  
  public static void setContentTheme(String paramString)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "ContentTheme", paramString);
  }
  
  public static void setContentViewColor(String paramString)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "ContentViewColor", paramString);
  }
  
  public static void setContentViewPageSize(int paramInt)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "ContentViewPageSize", Integer.toString(paramInt));
  }
  
  public static void setCustomSDCardLocation(String paramString)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "CustomSDCardLocation", paramString);
  }
  
  public static void setDefaultBackupPath(String paramString)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "DefaultBackupPath", paramString);
  }
  
  public static void setDefaultDocFontSize(String paramString)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "ContentFontSize", paramString);
  }
  
  public static void setDefaultPlaybackSpeed(float paramFloat)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "DefaultPlaybackSpeed", Float.toString(paramFloat));
  }
  
  public static void setDefferAutoSyncSmartPlay(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "DefferAutoSyncSmartPlay", paramBoolean);
  }
  
  public static void setEnableAudioPlugins(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "EnableAudioPlugins", paramBoolean);
  }
  
  public static void setEnableBrowserPlugins(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "EnableBrowserPlugins", paramBoolean);
  }
  
  public static void setEnableHeadsetButton(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "EnableHeadsetButton", paramBoolean);
  }
  
  public static void setEnableLoggingInProduction(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "EnableLoggingInProduction", paramBoolean);
  }
  
  public static void setEnableScreenTransitions(boolean paramBoolean)
  {
    if (getEnableScreenTransitions() == paramBoolean) {
      return;
    }
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "EnableScreenTransitions", paramBoolean);
  }
  
  public static void setEnableSonicAudioPlugin(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "EnableSonicAudioPlugin", paramBoolean);
  }
  
  public static void setEnclosureDownloadRoot(String paramString)
  {
    _EnclosureDownloadRootPath = paramString;
  }
  
  public static void setExpirationWarningShownInThisSession()
  {
    _IsExpirationWarningShownInThisSession = true;
  }
  
  public static void setFeedContentDialogLayoutType(WebSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    ConfigWriteHelper.getInstance().putInt(_preferences, "FeedContentDialogLayoutType", LayoutAlgorithm2Int(paramLayoutAlgorithm));
  }
  
  public static void setFeedsFragmentVisible(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "FeedsFragmentVisible", paramBoolean);
  }
  
  public static void setFeedsSortOrder(int paramInt)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "FeedsSortOrder", Integer.toString(paramInt));
  }
  
  public static void setForwardSkipInterval(int paramInt)
  {
    if (getForwardSkipInterval() == paramInt) {
      return;
    }
    ConfigWriteHelper.getInstance().putString(_preferences, "ForwardSkipInterval", Integer.toString(paramInt));
  }
  
  public static void setGReaderAccountName(String paramString)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "GReaderAccountName", paramString);
  }
  
  public static void setGReaderAuthValue(String paramString)
  {
    _GReaderAuthValue = paramString;
    ConfigWriteHelper.getInstance().putString(_preferences, "GReaderAuthValue", paramString);
  }
  
  public static void setGReaderCookie(String paramString)
  {
    _GReaderCookie = paramString;
    ConfigWriteHelper.getInstance().putString(_preferences, "GReaderCookie", paramString);
  }
  
  public static void setGatherAnalyticsData(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "GatherAnalyticsData", paramBoolean);
  }
  
  public static void setGlobalDefaultKeepAtMostPodcasts(int paramInt)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "DefaultKeepAtMostPodcasts", Integer.toString(paramInt));
  }
  
  public static void setGlobalDefaultMaximumGReaderItemsToGet(int paramInt)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "DefaultMaximumGReaderItemsToGet", Integer.toString(paramInt));
  }
  
  public static void setGlobalDefaultMaximumPodcastAge(TimeSpan paramTimeSpan)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "DefaultMaximumPodcastAge", Integer.toString((int)paramTimeSpan.getTotalDays()));
  }
  
  public static void setGlobalDefaultNumberPodcastsToDownload(int paramInt)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "DefaultNumberPodcastsToDownload", Integer.toString(paramInt));
  }
  
  public static void setGlobalDefaultPodcastDownloadAction(int paramInt)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "DefaultPodcastDownloadAction", Integer.toString(paramInt));
  }
  
  public static void setGoogleReaderPassword(String paramString)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "GoogleReaderPassword", paramString);
  }
  
  public static void setGoogleReaderUserName(String paramString)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "GoogleReaderUserName", paramString);
  }
  
  public static void setGoogleSyncInitialized(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "GoogleSyncInitialized", paramBoolean);
  }
  
  public static void setGroupByFeedIfShowingCategoryTracks(boolean paramBoolean)
  {
    if (getGroupByFeedIfShowingCategoryTracks() == paramBoolean) {
      return;
    }
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "GroupByFeedIfShowingCategoryTracks", paramBoolean);
  }
  
  public static void setHideReadFeeds(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "HideReadFeeds", paramBoolean);
  }
  
  public static void setHideReadItems(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "HideReadItems", paramBoolean);
  }
  
  public static void setHideUnsupportedFileTypes(boolean paramBoolean)
  {
    if (getHideUnsupportedFileTypes() == paramBoolean) {
      return;
    }
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "HideUnsupportedFileTypes", paramBoolean);
  }
  
  public static void setHtmlViewLayoutType(WebSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    ConfigWriteHelper.getInstance().putInt(_preferences, "HtmlViewLayoutType", LayoutAlgorithm2Int(paramLayoutAlgorithm));
  }
  
  public static void setIndexOfCurrentPlaylistTrackInPlaylist(int paramInt)
  {
    ConfigWriteHelper.getInstance().putInt(_preferences, "IndexOfCurrentPlaylistTrackInPlaylist", paramInt);
  }
  
  public static void setInternalPlayerSupportedFileExtensions(String paramString)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "PlayerSupportedFileExtensions", paramString.trim().replace("  ", " ").replace(".", "").replace(" ,", ","));
  }
  
  public static void setIsCellularConnectionAllowed(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "AllowCellularConnections", paramBoolean);
  }
  
  public static void setIsCurrentPlaylistManuallyModified(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "IsCurrentPlaylistManuallyModified", paramBoolean);
  }
  
  public static void setItemFilter(int paramInt)
  {
    ConfigWriteHelper.getInstance().putInt(_preferences, "ItemFilter", paramInt);
  }
  
  public static void setLastActiveScreen(int paramInt)
  {
    if (getLastActiveScreen() == paramInt) {
      return;
    }
    ConfigWriteHelper.getInstance().putInt(_preferences, "LastActiveScreen", Integer.valueOf(paramInt).intValue());
  }
  
  public static void setLastRemoteChangeTimeStamp(long paramLong)
  {
    ConfigWriteHelper.getInstance().putLong(_preferences, "LastRemoteChangeTimeStamp", paramLong);
  }
  
  public static void setLastSDCardRootPath(String paramString)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "LastSDCardRootPath", paramString);
  }
  
  public static void setLastSelectedFeed(UUID paramUUID)
  {
    if (getLastSelectedFeed() == paramUUID) {
      return;
    }
    ConfigWriteHelper.getInstance().putString(_preferences, "LastSelectedFeed", paramUUID.toString());
  }
  
  public static void setLastSyncTimeStamp(long paramLong)
  {
    ConfigWriteHelper.getInstance().putLong(_preferences, "LastSyncTimeStamp", paramLong);
  }
  
  public static void setLastUpdateAndDownloadManagerRunTime(Date paramDate)
  {
    ConfigWriteHelper.getInstance().putLong(_preferences, "LastUpdateAndDownloadManagerRunTime", paramDate.getTime());
  }
  
  public static void setLicenseTypeString(String paramString)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "LicenseTypeString", paramString);
  }
  
  public static void setLoadContentViewImagesAutomatically(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "LoadContentViewImagesAutomatically", paramBoolean);
  }
  
  public static void setMarkAsReadOnOpen(int paramInt)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "MarkAsReadOnOpen", Integer.toString(paramInt));
  }
  
  public static void setMediaEndAction(int paramInt)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "MediaEndAction", Integer.toString(paramInt));
  }
  
  public static void setMobileFormatter(String paramString)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "MobileFormatter", paramString);
  }
  
  public static void setMultilineEpisodeTitle(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "MultilineEpisodeTitle", paramBoolean);
  }
  
  public static void setNextNotificationTime(Date paramDate)
  {
    ConfigWriteHelper.getInstance().putLong(_preferences, "NextNotificationTime", paramDate.getTime());
  }
  
  public static void setOAuthAccessToken(String paramString)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "OAuthToken", paramString);
  }
  
  public static void setOAuthAccessTokenExpiration(Date paramDate)
  {
    ConfigWriteHelper localConfigWriteHelper = ConfigWriteHelper.getInstance();
    SharedPreferences localSharedPreferences = _preferences;
    if (paramDate == null) {}
    for (long l = 1L;; l = paramDate.getTime())
    {
      localConfigWriteHelper.putLong(localSharedPreferences, "OAuthAccessTokenExpiration", l);
      return;
    }
  }
  
  public static void setOAuthRefreshToken(String paramString)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "OAuthRefreshToken", paramString);
  }
  
  public static void setOAuthUser(String paramString)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "OAuthUser", paramString);
  }
  
  public static void setPauseOnHeadsetDisconnect(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "PauseOnHeadsetDisconnect", paramBoolean);
  }
  
  public static void setPauseVideoOnScreenOff(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "PauseVideoOnScreenOff", paramBoolean);
  }
  
  public static void setPlayerIntegrationType(int paramInt)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "PlayerIntegrationType", Integer.toString(paramInt));
  }
  
  public static void setPlayerPlaylistVisible(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "PlayerPlaylistVisible", paramBoolean);
  }
  
  public static void setPlaylistEndAction(int paramInt)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "PlaylistEndAction", Integer.toString(paramInt));
  }
  
  public static void setPlaylistSizeOnSave(int paramInt)
  {
    ConfigWriteHelper.getInstance().putInt(_preferences, "PlaylistSizeOnSave", paramInt);
  }
  
  public static void setPodcastNamingScheme(int paramInt)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "PodcastNamingScheme", Integer.toString(paramInt));
  }
  
  public static void setPodcastsSortOrder(int paramInt)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "PodcastsSortOrder", Integer.toString(paramInt));
  }
  
  public static void setPreferLastSDCardRoot(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "PreferLastSDCardRoot", paramBoolean);
  }
  
  public static void setPublishPlaylist(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "PublishPlaylist", paramBoolean);
  }
  
  public static void setRepoMovedPath(String paramString)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "RepoMovedPath", paramString);
  }
  
  public static void setRichPlayerNotication(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "EnhancedPlayerNotication", paramBoolean);
  }
  
  public static void setScreenPowerStateDuringWiFiUpdates(int paramInt)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "ScreenPowerStateDuringWiFiUpdates", Integer.toString(paramInt));
  }
  
  public static void setScrobbleEnabled(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "ScrobbleEnabled", paramBoolean);
  }
  
  public static void setSetAsDownloadedOnMarkRead(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "SetAsDownloadedOnMarkRead", paramBoolean);
  }
  
  public static void setSetAsPlayedOnMarkRead(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "SetAsPlayedOnMarkRead", paramBoolean);
  }
  
  public static void setSharePodcasts(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "SharePodcasts", paramBoolean);
  }
  
  public static void setShowAllPodcastsInCategory(boolean paramBoolean)
  {
    if (getShowAllPodcastsInCategory() == paramBoolean) {
      return;
    }
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "ShowAllPodcastsInCategory", paramBoolean);
  }
  
  public static void setShowCDSSettings(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "ShowCDSSettings", paramBoolean);
  }
  
  public static void setShowContentListPostImages(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "ShowContentListPostImages", paramBoolean);
  }
  
  public static void setSkipToEndButtonClickType(int paramInt)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "SkipToEndButtonClickType", Integer.toString(paramInt));
  }
  
  public static void setStartupView(int paramInt)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "StartupView", Integer.toString(paramInt));
  }
  
  public static void setTraceLevel(int paramInt)
  {
    if (getTraceLevel() == paramInt) {
      return;
    }
    ConfigWriteHelper.getInstance().putInt(_preferences, "TraceLevel", paramInt);
  }
  
  public static void setTrialStartDate(Date paramDate)
  {
    if (paramDate == null) {}
    for (long l = 0L;; l = paramDate.getTime())
    {
      ConfigWriteHelper.getInstance().putLong(_preferences, "TrialStartDate", l);
      return;
    }
  }
  
  public static void setTurnWiFiDuringUpdate(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "TurnWiFiDuringUpdate", paramBoolean);
  }
  
  public static void setUIMode(int paramInt)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "UIMode", Integer.toString(paramInt));
  }
  
  public static void setUpdateOnFeedOpen(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "UpdateOnFeedOpen", paramBoolean);
  }
  
  public static void setUpdateOnStartup(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "UpdateOnStartup", paramBoolean);
  }
  
  public static void setUseExternalBrowser(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "UseExternalBrowser", paramBoolean);
  }
  
  public static void setUseFeedContentViewPager(boolean paramBoolean)
  {
    ConfigWriteHelper.getInstance().putBoolean(_preferences, "UseFeedContentViewPager", paramBoolean);
  }
  
  public static void setUserNotificationPreferences(String paramString)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "UserNotificationPreferences", paramString);
  }
  
  public static void setVolumeLevel(int paramInt)
  {
    if (getVolumeLevel() == paramInt) {
      return;
    }
    ConfigWriteHelper.getInstance().putInt(_preferences, "VolumeLevel", paramInt);
  }
  
  public static void setWidgetBackgroundColor(int paramInt)
  {
    ConfigWriteHelper.getInstance().putString(_preferences, "WidgetBackgroundColor", Integer.toString(paramInt));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/Configuration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */