package mobi.beyondpod.rsscore.rss;

import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.widget.Toast;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.R.string;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;

public class LicenseManager
{
  public static final int LICENSE_TYPE_AMAZON = 6;
  public static final int LICENSE_TYPE_ANDROID_MARKET = 1;
  public static final int LICENSE_TYPE_BETA = 2;
  public static final int LICENSE_TYPE_EXPIRED = 5;
  public static final int LICENSE_TYPE_IN_TRIAL = 0;
  public static final int LICENSE_TYPE_OTHER = 4;
  public static final int LICENSE_TYPE_PAYPAL = 3;
  public static final int LICENSE_TYPE_UNKNOWN = -1;
  private static final License ProVersionLicense = new License();
  private static final String TAG = "LicenseManager";
  public static Uri _CheckKeyUri;
  private static Date _DefaultTrialStartDate;
  private static final Date _InstallStartDate = new Date(1235929600000L);
  public static final String _Key;
  private static Date _TrialStartDate;
  
  static
  {
    _DefaultTrialStartDate = new Date(1235929697999L);
    _CheckKeyUri = Uri.parse("content://beyondpod.license.manager/checkKey/" + Long.toString(new Date().getTime()));
    _Key = Integer.toOctalString(_CheckKeyUri.hashCode());
  }
  
  public static Date BetaExpirationDate()
  {
    Calendar localCalendar = GregorianCalendar.getInstance();
    localCalendar.set(2009, 4, 1);
    return localCalendar.getTime();
  }
  
  public static boolean CheckAndNotifyIfInRestrictedMode()
  {
    if (IfInRestrictedMode())
    {
      Toast.makeText(BeyondPodApplication.GetInstance(), R.string.limited_mode_message, 1).show();
      return true;
    }
    return false;
  }
  
  public static int CurrentLicenseKind()
  {
    int i = 4;
    String str;
    if (IsUnlocked())
    {
      str = GetLicenseTypeString(false);
      if (StringUtils.IsNullOrEmpty(str)) {
        i = -1;
      }
    }
    do
    {
      do
      {
        return i;
        if (str.equals("Beta Tester")) {
          return 2;
        }
        if (str.equals("Android Market")) {
          return 1;
        }
        if (str.equals("Amazon Appstore")) {
          return 6;
        }
      } while (!str.equals("PayPal"));
      return 3;
      if (IfInRestrictedMode())
      {
        Configuration.setLicenseTypeString("");
        return 5;
      }
    } while (new Date().compareTo(TrialExpirationDate()) >= 0);
    return 0;
  }
  
  private static int FreeTrialDurationDays()
  {
    if (IsPartner()) {
      return 30;
    }
    return 4;
  }
  
  public static String[] GetLicenseKey()
  {
    Object localObject2 = null;
    Object localObject1 = ProVersionLicense.GetLicenseKey(_CheckKeyUri);
    if (localObject1 != null) {
      localObject1 = ((String)localObject1).split("\\|");
    }
    for (;;)
    {
      return (String[])localObject1;
      try
      {
        Object localObject3 = BeyondPodApplication.GetInstance().getContentResolver();
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = ((ContentResolver)localObject3).getType(_CheckKeyUri);
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = ((String)localObject3).split("\\|");
            return (String[])localObject1;
          }
        }
      }
      catch (Exception localException)
      {
        CoreHelper.WriteTraceEntry("LicenseManager", "Failed to get License Key!");
      }
    }
    return null;
  }
  
  public static String GetLicenseTypeString(boolean paramBoolean)
  {
    String str2 = Configuration.LicenseTypeString();
    String str1;
    if (!paramBoolean)
    {
      str1 = str2;
      if (!StringUtils.IsNullOrEmpty(str2)) {}
    }
    else
    {
      String[] arrayOfString = GetLicenseKey();
      str1 = str2;
      if (arrayOfString != null)
      {
        str1 = str2;
        if (arrayOfString.length > 1)
        {
          str1 = arrayOfString[1];
          Configuration.setLicenseTypeString(str1);
        }
      }
    }
    return str1;
  }
  
  public static String GetShortLicenseKind()
  {
    switch ()
    {
    default: 
      return "u";
    case 6: 
      return "a";
    case 1: 
      return "m";
    case 2: 
      return "b";
    case 5: 
      return "x";
    case 0: 
      return "t";
    case 4: 
      return "o";
    }
    return "P";
  }
  
  public static boolean IfInRestrictedMode()
  {
    if (IsUnlocked()) {}
    while (new Date().compareTo(TrialExpirationDate()) <= 0) {
      return false;
    }
    return true;
  }
  
  public static boolean IsKeyInstalled()
  {
    boolean bool = false;
    try
    {
      int i = BeyondPodApplication.GetInstance().getPackageManager().checkSignatures(Configuration.PackageName(), "mobi.beyondpod.unlockkey");
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private static boolean IsPartner()
  {
    return CoreHelper.IsPartnerSony();
  }
  
  public static boolean IsUnlocked()
  {
    return (IsKeyInstalled()) || (PokeKey());
  }
  
  public static boolean PokeKey()
  {
    boolean bool2 = false;
    String[] arrayOfString = GetLicenseKey();
    boolean bool1 = bool2;
    if (arrayOfString != null)
    {
      bool1 = bool2;
      if (arrayOfString.length == 2)
      {
        bool1 = bool2;
        if (_Key.equals(arrayOfString[0])) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static void SetTrialStartDate(Date paramDate)
  {
    if (paramDate != null)
    {
      _TrialStartDate = paramDate;
      if (_TrialStartDate.equals(_InstallStartDate)) {
        _TrialStartDate = new Date();
      }
    }
    Configuration.setTrialStartDate(_TrialStartDate);
  }
  
  public static Date TrialExpirationDate()
  {
    Calendar localCalendar = GregorianCalendar.getInstance();
    localCalendar.setTime(TrialExpirationWarningDate());
    localCalendar.add(6, WarningTrialDurationDays());
    return localCalendar.getTime();
  }
  
  public static Date TrialExpirationWarningDate()
  {
    Object localObject = GregorianCalendar.getInstance();
    ((Calendar)localObject).setTime(TrialStartDate());
    ((Calendar)localObject).add(6, FreeTrialDurationDays());
    localObject = ((Calendar)localObject).getTime();
    Date localDate = BetaExpirationDate();
    if (((Date)localObject).compareTo(localDate) < 0) {
      return localDate;
    }
    return (Date)localObject;
  }
  
  public static Date TrialStartDate()
  {
    if (_TrialStartDate == null)
    {
      _TrialStartDate = Configuration.getTrialStartDate();
      if (_TrialStartDate == null) {
        _TrialStartDate = _DefaultTrialStartDate;
      }
    }
    return _TrialStartDate;
  }
  
  private static int WarningTrialDurationDays()
  {
    if (IsPartner()) {
      return 15;
    }
    return 3;
  }
  
  static class License
  {
    public String GetLicenseKey(Uri paramUri)
    {
      try
      {
        String str = BeyondPodApplication.GetInstance().getResources().getString(R.string.application_licensed_to);
        if (!StringUtils.IsNullOrEmpty(str))
        {
          if (".".equals(str)) {
            return null;
          }
          paramUri = Integer.toOctalString(paramUri.toString().hashCode()) + "|" + str;
          return paramUri;
        }
      }
      catch (Exception paramUri) {}
      return null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/rss/LicenseManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */