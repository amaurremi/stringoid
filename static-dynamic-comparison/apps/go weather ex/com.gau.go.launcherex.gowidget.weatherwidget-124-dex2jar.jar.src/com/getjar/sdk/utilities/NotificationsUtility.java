package com.getjar.sdk.utilities;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.getjar.sdk.comm.CommContext;
import com.getjar.sdk.data.earning.EarnUtility.EarnInfo;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class NotificationsUtility
{
  private static final String _MarketURLFormat = "market://details?id=%1$s";
  
  public static void clearEarnInstallNotification(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' cannot be NULL");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'packageName' cannot be NULL or empty");
    }
    Logger.d(Area.EARN.value() | Area.TRANSACTION.value() | Area.UI.value(), "NotificationsUtility: clearInstallNotification() '%1$s'", new Object[] { paramString });
    int i = getNotificationId(paramString, NotificationType.INSTALL_REMINDER);
    ((NotificationManager)paramContext.getSystemService("notification")).cancel(i);
  }
  
  public static void clearEarnOpenNotification(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' cannot be NULL");
    }
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'packageName' cannot be NULL or empty");
    }
    Logger.d(Area.EARN.value() | Area.TRANSACTION.value() | Area.UI.value(), "NotificationsUtility: clearOpenNotification() '%1$s'", new Object[] { paramString });
    int i = getNotificationId(paramString, NotificationType.OPEN_REMINDER);
    ((NotificationManager)paramContext.getSystemService("notification")).cancel(i);
  }
  
  public static void clearRedeemNotification(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' cannot be null");
    }
    Logger.d(Area.REDEEM.value() | Area.TRANSACTION.value() | Area.UI.value(), "NotificationsUtility: clearRedeemNotification()", new Object[0]);
    int i = getNotificationId("com.getjar.rewards", NotificationType.OPEN_WALLET);
    ((NotificationManager)paramContext.getSystemService("notification")).cancel(i);
  }
  
  private static int getNotificationId(String paramString, NotificationType paramNotificationType)
  {
    return String.format(Locale.US, "%1$s.%2$s", new Object[] { paramString, paramNotificationType.name() }).hashCode();
  }
  
  private static void internalPushBuyGoldNotification(Context paramContext, String paramString, Constants.OperationStatus paramOperationStatus)
    throws PackageManager.NameNotFoundException
  {
    PackageManager localPackageManager = paramContext.getApplicationContext().getPackageManager();
    Object localObject1 = (String)localPackageManager.getPackageInfo(paramContext.getPackageName(), 128).applicationInfo.loadLabel(localPackageManager);
    NotificationManager localNotificationManager = (NotificationManager)paramContext.getApplicationContext().getSystemService("notification");
    Notification localNotification = new Notification(17301516, paramString, System.currentTimeMillis());
    localNotification.flags |= 0x10;
    String str = "Return to " + (String)localObject1;
    Object localObject2 = "";
    localObject1 = new Intent("android.intent.action.MAIN");
    ((Intent)localObject1).addCategory("android.intent.category.LAUNCHER");
    Iterator localIterator = localPackageManager.queryIntentActivities((Intent)localObject1, 0).iterator();
    ResolveInfo localResolveInfo;
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localResolveInfo = (ResolveInfo)localIterator.next();
    } while (!localResolveInfo.activityInfo.packageName.equals(paramContext.getPackageName()));
    localObject1 = localResolveInfo.activityInfo.name;
    localObject2 = (String)localResolveInfo.activityInfo.loadLabel(localPackageManager);
    localObject2 = new Intent("android.intent.action.MAIN", null);
    ((Intent)localObject2).addCategory("android.intent.category.LAUNCHER");
    ((Intent)localObject2).setComponent(new ComponentName(paramContext.getPackageName(), (String)localObject1));
    ((Intent)localObject2).setFlags(335544320);
    ((Intent)localObject2).putExtra("getjar", true);
    ((Intent)localObject2).putExtra("getjar.sdk_level", 19);
    ((Intent)localObject2).putExtra("getjar.intent.type", "buy_gold_notification");
    ((Intent)localObject2).putExtra("getjar.operation_status", paramOperationStatus.value());
    paramOperationStatus = PendingIntent.getActivity(paramContext.getApplicationContext(), 0, (Intent)localObject2, 0);
    localNotification.setLatestEventInfo(paramContext.getApplicationContext(), paramString, str, paramOperationStatus);
    localNotificationManager.notify(0, localNotification);
  }
  
  public static void pushBuyGoldFailureNotification(Context paramContext, String paramString)
  {
    try
    {
      Logger.d(Area.UI.value(), "pushBuyGoldFailureNotification started", new Object[0]);
      internalPushBuyGoldNotification(paramContext, paramString, Constants.OperationStatus.FAILED);
      return;
    }
    catch (Exception paramContext)
    {
      Logger.e(Area.BUY_GOLD.value() | Area.TRANSACTION.value() | Area.UI.value(), paramContext, "pushBuyGoldFailureNotification() failed", new Object[0]);
    }
  }
  
  public static void pushBuyGoldSuccessNotification(Context paramContext, String paramString)
  {
    try
    {
      Logger.d(Area.UI.value(), "pushBuyGoldSuccessNotification started", new Object[0]);
      internalPushBuyGoldNotification(paramContext, paramString, Constants.OperationStatus.SUCCEEDED);
      return;
    }
    catch (Exception paramContext)
    {
      Logger.e(Area.BUY_GOLD.value() | Area.TRANSACTION.value() | Area.UI.value(), paramContext, "pushBuyGoldSuccessNotification() failed", new Object[0]);
    }
  }
  
  public static void pushEarnFailNotification(CommContext paramCommContext, String paramString, EarnUtility.EarnInfo paramEarnInfo)
  {
    try
    {
      Logger.d(Area.EARN.value() | Area.TRANSACTION.value() | Area.UI.value(), "Send Fail Notification", new Object[0]);
      Object localObject1 = paramCommContext.getApplicationContext().getPackageManager();
      Object localObject2 = (String)((PackageManager)localObject1).getPackageInfo(paramCommContext.getApplicationContext().getPackageName(), 128).applicationInfo.loadLabel((PackageManager)localObject1);
      NotificationManager localNotificationManager = (NotificationManager)paramCommContext.getApplicationContext().getSystemService("notification");
      paramString = String.format(Locale.US, paramString, new Object[] { localObject2 });
      localObject2 = new Notification(17301516, paramString, System.currentTimeMillis());
      ((Notification)localObject2).flags |= 0x10;
      String str = "Return to " + ((PackageManager)localObject1).getPackageInfo(paramCommContext.getApplicationContext().getPackageName(), 128).applicationInfo.loadLabel((PackageManager)localObject1);
      new Intent("android.intent.action.MAIN");
      localObject1 = ((PackageManager)localObject1).getLaunchIntentForPackage(paramCommContext.getApplicationContext().getPackageName());
      ((Intent)localObject1).addCategory("android.intent.category.LAUNCHER");
      ((Intent)localObject1).setFlags(67108864);
      ((Intent)localObject1).putExtra("getjar", true);
      ((Intent)localObject1).putExtra("getjar.sdk_level", 19);
      ((Intent)localObject1).putExtra("getjar.intent.type", "earn_notification");
      ((Intent)localObject1).putExtra("getjar.operation_status", Constants.OperationStatus.FAILED.value());
      if (paramEarnInfo != null)
      {
        if (!StringUtility.isNullOrEmpty(paramEarnInfo.getCurrencyType())) {
          ((Intent)localObject1).putExtra("getjar.currency_type", paramEarnInfo.getCurrencyType());
        }
        if (!StringUtility.isNullOrEmpty(paramEarnInfo.getCurrencyKey())) {
          ((Intent)localObject1).putExtra("getjar.currency_key", paramEarnInfo.getCurrencyKey());
        }
        if (!StringUtility.isNullOrEmpty(paramEarnInfo.getCurrencyName())) {
          ((Intent)localObject1).putExtra("getjar.currency_name", paramEarnInfo.getCurrencyName());
        }
      }
      paramEarnInfo = PendingIntent.getActivity(paramCommContext.getApplicationContext(), 0, (Intent)localObject1, 0);
      ((Notification)localObject2).setLatestEventInfo(paramCommContext.getApplicationContext(), paramString, str, paramEarnInfo);
      localNotificationManager.notify(0, (Notification)localObject2);
      return;
    }
    catch (Exception paramCommContext)
    {
      Logger.e(Area.EARN.value() | Area.TRANSACTION.value() | Area.UI.value(), paramCommContext, "pushFailNotification() failed", new Object[0]);
    }
  }
  
  public static void pushEarnSuccessNotification(CommContext paramCommContext, String paramString, EarnUtility.EarnInfo paramEarnInfo)
  {
    try
    {
      Logger.d(Area.EARN.value() | Area.TRANSACTION.value() | Area.UI.value(), "Send Success Notification", new Object[0]);
      PackageManager localPackageManager = paramCommContext.getApplicationContext().getPackageManager();
      Object localObject1 = (String)localPackageManager.getPackageInfo(paramCommContext.getApplicationContext().getPackageName(), 128).applicationInfo.loadLabel(localPackageManager);
      NotificationManager localNotificationManager = (NotificationManager)paramCommContext.getApplicationContext().getSystemService("notification");
      Notification localNotification = new Notification(17301516, paramString, System.currentTimeMillis());
      localNotification.flags |= 0x10;
      String str = "Return to " + (String)localObject1;
      Object localObject2 = "";
      localObject1 = new Intent("android.intent.action.MAIN");
      ((Intent)localObject1).addCategory("android.intent.category.LAUNCHER");
      Iterator localIterator = localPackageManager.queryIntentActivities((Intent)localObject1, 0).iterator();
      ResolveInfo localResolveInfo;
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localResolveInfo = (ResolveInfo)localIterator.next();
      } while (!localResolveInfo.activityInfo.packageName.equals(paramCommContext.getApplicationContext().getPackageName()));
      localObject1 = localResolveInfo.activityInfo.name;
      localObject2 = (String)localResolveInfo.activityInfo.loadLabel(localPackageManager);
      localObject2 = new Intent("android.intent.action.MAIN", null);
      ((Intent)localObject2).addCategory("android.intent.category.LAUNCHER");
      ((Intent)localObject2).setComponent(new ComponentName(paramCommContext.getApplicationContext().getPackageName(), (String)localObject1));
      ((Intent)localObject2).setFlags(67108864);
      ((Intent)localObject2).putExtra("getjar", true);
      ((Intent)localObject2).putExtra("getjar.sdk_level", 19);
      ((Intent)localObject2).putExtra("getjar.intent.type", "earn_notification");
      ((Intent)localObject2).putExtra("getjar.operation_status", Constants.OperationStatus.SUCCEEDED.value());
      if (paramEarnInfo != null)
      {
        if (!StringUtility.isNullOrEmpty(paramEarnInfo.getCurrencyType())) {
          ((Intent)localObject2).putExtra("getjar.currency_type", paramEarnInfo.getCurrencyType());
        }
        if (!StringUtility.isNullOrEmpty(paramEarnInfo.getCurrencyKey())) {
          ((Intent)localObject2).putExtra("getjar.currency_key", paramEarnInfo.getCurrencyKey());
        }
        if (!StringUtility.isNullOrEmpty(paramEarnInfo.getCurrencyName())) {
          ((Intent)localObject2).putExtra("getjar.currency_name", paramEarnInfo.getCurrencyName());
        }
      }
      paramEarnInfo = PendingIntent.getActivity(paramCommContext.getApplicationContext(), 0, (Intent)localObject2, 0);
      localNotification.setLatestEventInfo(paramCommContext.getApplicationContext(), paramString, str, paramEarnInfo);
      localNotificationManager.notify(0, localNotification);
      return;
    }
    catch (Exception paramCommContext)
    {
      Logger.e(Area.EARN.value() | Area.TRANSACTION.value() | Area.UI.value(), paramCommContext, "pushSuccessNotification() failed", new Object[0]);
    }
  }
  
  public static void showEarnInstallNotification(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' cannot be NULL");
    }
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("'packageName' cannot be NULL or empty");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("'appName' cannot be NULL or empty");
    }
    Logger.d(Area.EARN.value() | Area.TRANSACTION.value() | Area.UI.value(), "NotificationsUtility: showInstallNotification() '%1$s'", new Object[] { paramString1 });
    if (paramString1.equals("com.getjar.rewards")) {
      return;
    }
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(String.format(Locale.US, "market://details?id=%1$s", new Object[] { paramString1 })));
    localIntent.addFlags(268435456);
    localIntent.addFlags(134217728);
    localIntent.addFlags(1073741824);
    int i = getNotificationId(paramString1, NotificationType.INSTALL_REMINDER);
    Object localObject = String.format(Locale.US, "Install and open %s to earn", new Object[] { paramString2 });
    paramString1 = (NotificationManager)paramContext.getSystemService("notification");
    localObject = new Notification(17301516, (CharSequence)localObject, System.currentTimeMillis());
    ((Notification)localObject).flags |= 0x10;
    ((Notification)localObject).setLatestEventInfo(paramContext, paramString2, "Install and open this app to earn", PendingIntent.getActivity(paramContext, 0, localIntent, 0));
    paramString1.notify(i, (Notification)localObject);
  }
  
  public static boolean showEarnOpenNotification(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' cannot be NULL");
    }
    if (StringUtility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("'packageName' cannot be NULL or empty");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("'appName' cannot be NULL or empty");
    }
    Logger.d(Area.EARN.value() | Area.TRANSACTION.value() | Area.UI.value(), "NotificationsUtility: showOpenNotification() '%1$s'", new Object[] { paramString1 });
    if (paramString1.equals("com.getjar.rewards")) {
      return false;
    }
    Intent localIntent = paramContext.getApplicationContext().getPackageManager().getLaunchIntentForPackage(paramString1);
    if (localIntent == null)
    {
      Logger.w(Area.EARN.value() | Area.TRANSACTION.value() | Area.UI.value(), "NotificationsUtility showOpenNotification() '%1$s' has been uninstalled, skipping OPEN notification", new Object[] { paramString1 });
      return false;
    }
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.setFlags(270532608);
    int i = getNotificationId(paramString1, NotificationType.OPEN_REMINDER);
    Object localObject = String.format(Locale.US, "Try out %s to earn", new Object[] { paramString2 });
    paramString1 = (NotificationManager)paramContext.getSystemService("notification");
    localObject = new Notification(17301516, (CharSequence)localObject, System.currentTimeMillis());
    ((Notification)localObject).flags |= 0x10;
    ((Notification)localObject).setLatestEventInfo(paramContext, paramString2, "Try out this app to earn", PendingIntent.getActivity(paramContext, 0, localIntent, 0));
    paramString1.notify(i, (Notification)localObject);
    return true;
  }
  
  public static void showEarnedFromPurchaseNotification(Context paramContext, String paramString, long paramLong)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' cannot be NULL");
    }
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("'amount' cannot be less than zero");
    }
    Logger.d(Area.UI.value() | Area.REDEEM.value() | Area.OFFER.value(), "NotificationsUtility: showRedeemReminderNotification() START [targetPackageName:%1$s amount:%2$d]", new Object[] { paramString, Long.valueOf(paramLong) });
    String str = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1;
    if (!StringUtility.isNullOrEmpty(paramString))
    {
      localObject2 = paramContext.getApplicationContext().getPackageManager();
      try
      {
        str = (String)((PackageManager)localObject2).getPackageInfo(paramString, 128).applicationInfo.loadLabel((PackageManager)localObject2);
        localObject3 = ((PackageManager)localObject2).getLaunchIntentForPackage(paramString);
        if (localObject3 == null) {
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Logger.e(Area.TRANSACTION.value() | Area.EARN.value(), localException, "NotificationsUtility: showRedeemReminderNotification() Failed to get the name of the target app", new Object[0]);
          localObject1 = localObject3;
        }
        ((Intent)localObject3).putExtra("getjar", true);
        ((Intent)localObject3).putExtra("getjar.sdk_level", 19);
        ((Intent)localObject3).putExtra("getjar.intent.type", "earn_notification");
        ((Intent)localObject3).addCategory("android.intent.category.LAUNCHER");
        ((Intent)localObject3).setFlags(874512384);
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
    int i;
    if ((StringUtility.isNullOrEmpty(paramString)) || (StringUtility.isNullOrEmpty((String)localObject2)))
    {
      localObject2 = String.format("%1$d Credit earned for purchase!", new Object[] { Long.valueOf(paramLong) });
      localObject3 = "Open the GO Account to view";
      i = String.format("showEarnedFromPurchaseNotification_%1$d", new Object[] { Long.valueOf(paramLong) }).hashCode();
      if (localObject1 == null) {
        break label433;
      }
      paramString = PendingIntent.getActivity(paramContext, 0, (Intent)localObject1, 134217728);
    }
    for (;;)
    {
      localObject1 = (NotificationManager)paramContext.getSystemService("notification");
      Object localObject4 = new Notification(17301516, (CharSequence)localObject2, System.currentTimeMillis());
      ((Notification)localObject4).flags |= 0x10;
      ((Notification)localObject4).setLatestEventInfo(paramContext, (CharSequence)localObject3, (CharSequence)localObject2, paramString);
      ((NotificationManager)localObject1).notify(i, (Notification)localObject4);
      return;
      localObject3 = String.format("%1$d Credit earned via %2$s!", new Object[] { Long.valueOf(paramLong), localObject2 });
      localObject4 = String.format("Return to %1$s", new Object[] { localObject2 });
      i = String.format("showEarnedFromPurchaseNotification_%1$s", new Object[] { paramString }).hashCode();
      localObject2 = localObject3;
      localObject3 = localObject4;
      break;
      label433:
      paramString = IntentsUtility.getExternalWalletIntent(paramContext);
      if (paramString != null) {
        paramString = PendingIntent.getActivity(paramContext, 0, paramString, 134217728);
      } else {
        paramString = PendingIntent.getActivity(paramContext, 0, new Intent(), 134217728);
      }
    }
  }
  
  public static void showRedeemReminderNotification(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' cannot be NULL");
    }
    Logger.d(Area.UI.value() | Area.REDEEM.value() | Area.OFFER.value(), "NotificationsUtility: showRedeemReminderNotification() START", new Object[0]);
    Intent localIntent = IntentsUtility.getExternalWalletIntent(paramContext);
    if (localIntent == null)
    {
      Logger.d(Area.UI.value() | Area.REDEEM.value() | Area.OFFER.value(), "NotificationsUtility: showRedeemReminderNotification() Rewards not installed, sending install reminder", new Object[0]);
      localIntent = new Intent("android.intent.action.VIEW", Uri.parse(String.format(Locale.US, "market://details?id=%1$s", new Object[] { "com.getjar.rewards" })));
    }
    for (String str = "Please install App Rewards to claim your purchase.";; str = "Open your GO Account to redeem")
    {
      localIntent.putExtra("getjar", true);
      localIntent.putExtra("getjar.sdk_level", 19);
      localIntent.putExtra("getjar.intent.type", "redeem_notification");
      int i = getNotificationId("com.getjar.rewards", NotificationType.OPEN_WALLET);
      NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
      Notification localNotification = new Notification(17301516, str, System.currentTimeMillis());
      localNotification.flags |= 0x10;
      localNotification.setLatestEventInfo(paramContext, "Redeem your purchase", str, PendingIntent.getActivity(paramContext, 0, localIntent, 134217728));
      localNotificationManager.notify(i, localNotification);
      return;
      Logger.d(Area.UI.value() | Area.REDEEM.value() | Area.OFFER.value(), "NotificationsUtility: showRedeemReminderNotification() Rewards installed, sending open reminder", new Object[0]);
    }
  }
  
  public static enum NotificationType
  {
    INSTALL_REMINDER,  OPEN_REMINDER,  OPEN_WALLET;
    
    private NotificationType() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/utilities/NotificationsUtility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */