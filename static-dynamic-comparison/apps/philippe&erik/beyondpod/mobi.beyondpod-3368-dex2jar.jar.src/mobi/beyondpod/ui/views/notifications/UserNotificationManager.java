package mobi.beyondpod.ui.views.notifications;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.dialogs.TipNotifyDialog;
import mobi.beyondpod.ui.dialogs.TipNotifyDialog.CloseListener;

public class UserNotificationManager
{
  static boolean _NotifiedAboutIncorrectTime = false;
  private static NotificationPreferences _Preferences = new NotificationPreferences();
  
  public static void NotifyDeviceTimeIncorrect(ViewGroup paramViewGroup)
  {
    if (_NotifiedAboutIncorrectTime) {
      return;
    }
    _NotifiedAboutIncorrectTime = true;
    Message localMessage = new Message();
    Resources localResources = BeyondPodApplication.GetInstance().getResources();
    localMessage.MessageText = localResources.getString(2131296740);
    localMessage.MessageTitle = localResources.getString(2131296714);
    localMessage.URL = "android.settings.DATE_SETTINGS";
    ShowPopupNotificationMessage(paramViewGroup, localMessage, null);
  }
  
  public static void NotifyUpdateErrors(ViewGroup paramViewGroup)
  {
    Message localMessage = new Message();
    localMessage.MessageText = BeyondPodApplication.GetInstance().getResources().getString(2131296739);
    localMessage.URL = Uri.parse(Configuration.BeyondPodContentUrl() + "/BeyondPodStorageRootPath/FeedUpdateLog.htm").toString();
    localMessage.MessageTitle = "Update and Download Log";
    ShowPopupNotificationMessage(paramViewGroup, localMessage, null);
  }
  
  private static void OpenNotification(Context paramContext, final int paramInt, final OnContinueListener paramOnContinueListener, boolean paramBoolean)
  {
    if ((paramContext == null) || ("0".equals(_Preferences.GetPreference(paramInt, "1"))))
    {
      if (paramOnContinueListener != null) {
        paramOnContinueListener.OnContinue();
      }
      return;
    }
    View localView = LayoutInflater.from(paramContext).inflate(2130903101, null);
    Object localObject = (TextView)localView.findViewById(2131230809);
    switch (paramInt)
    {
    default: 
      label124:
      localObject = new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          if (UserNotificationManager.this.isChecked()) {
            UserNotificationManager._Preferences.SetPreference(paramInt, "0");
          }
          if (paramOnContinueListener != null) {
            paramOnContinueListener.OnContinue();
          }
        }
      };
      paramContext = new AlertDialog.Builder(paramContext).setIcon(17301543).setTitle(2131296714).setView(localView);
      if (!paramBoolean) {
        paramContext.setNeutralButton(2131296759, (DialogInterface.OnClickListener)localObject);
      }
      break;
    }
    for (;;)
    {
      try
      {
        paramContext.create().show();
        return;
      }
      catch (Exception paramContext) {}
      if (paramOnContinueListener == null) {
        break;
      }
      paramOnContinueListener.OnContinue();
      return;
      ((TextView)localObject).setText(2131296715);
      break label124;
      ((TextView)localObject).setText(2131296716);
      break label124;
      ((TextView)localObject).setText(2131296717);
      break label124;
      ((TextView)localObject).setText(2131296718);
      break label124;
      ((TextView)localObject).setText(2131296719);
      break label124;
      ((TextView)localObject).setText(2131296720);
      break label124;
      ((TextView)localObject).setText(2131296721);
      break label124;
      paramContext.setPositiveButton(2131296759, (DialogInterface.OnClickListener)localObject);
      paramContext.setNegativeButton(2131296315, null);
    }
  }
  
  public static void ResetDefaultPrefs()
  {
    _Preferences.ResetDefaultPrefs();
  }
  
  public static void ShowPopupNotificationDialog(View paramView, Message paramMessage, OnContinueListener paramOnContinueListener)
  {
    new TipNotifyDialog(paramView.getContext(), new TipNotifyDialog.CloseListener()
    {
      public void onClosed()
      {
        if (UserNotificationManager.this != null) {
          UserNotificationManager.this.OnContinue();
        }
      }
    }, paramMessage.FormattedMessage(paramView.getContext())).show(paramView);
  }
  
  public static void ShowPopupNotificationMessage(ViewGroup paramViewGroup, Message paramMessage, final OnContinueListener paramOnContinueListener)
  {
    if ((!paramMessage.HasText()) || (paramViewGroup == null)) {}
    for (;;)
    {
      return;
      final Object localObject = (ViewStub)paramViewGroup.findViewById(2131230882);
      if (localObject != null) {}
      for (localObject = (LinearLayout)((ViewStub)localObject).inflate(); ((LinearLayout)localObject).getVisibility() != 0; localObject = (LinearLayout)paramViewGroup.findViewById(2131230883))
      {
        TextView localTextView = (TextView)((LinearLayout)localObject).findViewById(2131231121);
        localTextView.setText(paramMessage.FormattedMessage(paramViewGroup.getContext()));
        ImageView localImageView = (ImageView)((LinearLayout)localObject).findViewById(2131231122);
        localTextView.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            paramAnonymousView = UserNotificationManager.this.ExpandURLTokens();
            if (!StringUtils.IsNullOrEmpty(paramAnonymousView))
            {
              if (paramAnonymousView.startsWith("android.settings")) {
                CommandManager.StartActivity(new Intent(paramAnonymousView));
              }
            }
            else {
              return;
            }
            if (paramAnonymousView.startsWith(Configuration.BeyondPodContentUrl()))
            {
              CommandManager.CmdStartHtmlViewActivity(Uri.parse(paramAnonymousView), UserNotificationManager.this.MessageTitle, false);
              return;
            }
            CommandManager.CmdOpenExternalBrowser(paramAnonymousView);
          }
        });
        localImageView.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            paramAnonymousView = AnimationUtils.loadAnimation(UserNotificationManager.this.getContext(), 2130968594);
            paramAnonymousView.setAnimationListener(new Animation.AnimationListener()
            {
              public void onAnimationEnd(Animation paramAnonymous2Animation)
              {
                this.val$headerView.setVisibility(8);
                if (this.val$listener != null) {
                  this.val$listener.OnContinue();
                }
              }
              
              public void onAnimationRepeat(Animation paramAnonymous2Animation) {}
              
              public void onAnimationStart(Animation paramAnonymous2Animation) {}
            });
            localObject.startAnimation(paramAnonymousView);
          }
        });
        paramViewGroup = AnimationUtils.loadAnimation(paramViewGroup.getContext(), 2130968593);
        paramViewGroup.setAnimationListener(new Animation.AnimationListener()
        {
          public void onAnimationEnd(Animation paramAnonymousAnimation) {}
          
          public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public void onAnimationStart(Animation paramAnonymousAnimation)
          {
            UserNotificationManager.this.setVisibility(0);
          }
        });
        ((LinearLayout)localObject).startAnimation(paramViewGroup);
        return;
      }
    }
  }
  
  public static void TipHowToMarkReadUnread(View paramView)
  {
    TipNotifyOncePopupDialog(paramView, 8);
  }
  
  public static void TipNotifyConsiderUsingTabletVersion(ViewGroup paramViewGroup)
  {
    TipNotifyOnce(paramViewGroup, 12);
  }
  
  public static void TipNotifyHowToAddRemovePlaylist(View paramView)
  {
    TipNotifyOncePopupDialog(paramView, 14);
  }
  
  public static void TipNotifyHowToChangeCategory(ViewGroup paramViewGroup)
  {
    TipNotifyOnce(paramViewGroup, 19);
  }
  
  public static void TipNotifyHowToReorderPlaylist(ViewGroup paramViewGroup)
  {
    TipNotifyOnce(paramViewGroup, 15);
  }
  
  public static void TipNotifyHowToUseContentView(ViewGroup paramViewGroup)
  {
    TipNotifyOnce(paramViewGroup, 18);
  }
  
  private static void TipNotifyOnce(ViewGroup paramViewGroup, int paramInt)
  {
    if ("0".equals(_Preferences.GetPreference(paramInt, "1"))) {
      return;
    }
    Message localMessage = new Message();
    Resources localResources = BeyondPodApplication.GetInstance().getResources();
    switch (paramInt)
    {
    }
    for (;;)
    {
      ShowPopupNotificationMessage(paramViewGroup, localMessage, new OnContinueListener()
      {
        public void OnContinue()
        {
          UserNotificationManager._Preferences.SetPreference(this.val$whichPref, "0");
        }
      });
      return;
      localMessage.MessageText = localResources.getString(2131296728);
      localMessage.ImageResourceId = 2130838113;
      localMessage.URL = localResources.getString(2131296729);
      continue;
      localMessage.MessageText = localResources.getString(2131296730);
      localMessage.ImageResourceId = 2130838112;
      continue;
      localMessage.MessageText = localResources.getString(2131296731);
      localMessage.ImageResourceId = 2130838113;
      continue;
      localMessage.MessageText = localResources.getString(2131296732);
      localMessage.ImageResourceId = 2130838114;
      localMessage.URL = Configuration.HelpFileFeedContentURL().toString();
      continue;
      localMessage.MessageText = localResources.getString(2131296733);
      localMessage.ImageResourceId = 2130837970;
      continue;
      localMessage.MessageText = localResources.getString(2131296735);
      continue;
      localMessage.MessageText = localResources.getString(2131296738);
      continue;
      localMessage.MessageText = localResources.getString(2131296741);
      continue;
      localMessage.MessageText = localResources.getString(2131296743);
      continue;
      localMessage.MessageText = localResources.getString(2131296736);
      localMessage.URL = Configuration.getHDVersionAppStoreIntent().toString();
      continue;
      localMessage.MessageText = localResources.getString(2131296737);
      localMessage.URL = Configuration.SwitchToFeedlyHelpURL().toString();
    }
  }
  
  public static void TipNotifyOnceCategories(ViewGroup paramViewGroup)
  {
    TipNotifyOnce(paramViewGroup, 2);
  }
  
  private static void TipNotifyOncePopupDialog(View paramView, int paramInt)
  {
    if ("0".equals(_Preferences.GetPreference(paramInt, "1"))) {
      return;
    }
    Message localMessage = new Message();
    Resources localResources = BeyondPodApplication.GetInstance().getResources();
    switch (paramInt)
    {
    }
    for (;;)
    {
      ShowPopupNotificationDialog(paramView, localMessage, new OnContinueListener()
      {
        public void OnContinue()
        {
          UserNotificationManager._Preferences.SetPreference(this.val$whichPref, "0");
        }
      });
      return;
      localMessage.MessageText = localResources.getString(2131296733);
      localMessage.ImageResourceId = 2130837970;
      continue;
      localMessage.MessageText = localResources.getString(2131296734);
      localMessage.ImageResourceId = 2130838010;
      localMessage.ImageAltResourceId = 2130837831;
    }
  }
  
  public static void TipNotifySleepSetting(ViewGroup paramViewGroup)
  {
    TipNotifyOnce(paramViewGroup, 5);
  }
  
  public static void TipNotifyStartupScreen(ViewGroup paramViewGroup)
  {
    TipNotifyOnce(paramViewGroup, 6);
  }
  
  public static void TipNotifySwitchingToFeedly(ViewGroup paramViewGroup)
  {
    TipNotifyOnce(paramViewGroup, 20);
  }
  
  public static void TipNotifyTapToAddRemovewPlaylist(ViewGroup paramViewGroup)
  {
    TipNotifyOnce(paramViewGroup, 16);
  }
  
  public static void TipNotifyVolumeSwitchPosts(Context paramContext)
  {
    ToastNotifyOnce(paramContext, 7);
  }
  
  private static void ToastNotifyOnce(Context paramContext, int paramInt)
  {
    if ("0".equals(_Preferences.GetPreference(paramInt, "1"))) {}
    for (;;)
    {
      return;
      _Preferences.SetPreference(paramInt, "0");
      Message localMessage = new Message();
      Resources localResources = BeyondPodApplication.GetInstance().getResources();
      switch (paramInt)
      {
      }
      while (localMessage.HasText())
      {
        Toast.makeText(paramContext, localMessage.FormattedMessage(paramContext), 1).show();
        return;
        localMessage.MessageText = localResources.getString(2131296742);
      }
    }
  }
  
  public static void WarnAboutInstalledOnSDCard(Context paramContext, OnContinueListener paramOnContinueListener)
  {
    OpenNotification(paramContext, 10, paramOnContinueListener, false);
  }
  
  public static void WarnAboutMarkingAllAsRead(Context paramContext, OnContinueListener paramOnContinueListener)
  {
    OpenNotification(paramContext, 11, paramOnContinueListener, true);
  }
  
  public static void WarnAboutMarkingScrolledAllAsRead(Context paramContext, OnContinueListener paramOnContinueListener)
  {
    OpenNotification(paramContext, 17, paramOnContinueListener, true);
  }
  
  public static void WarnAboutMoviePlayback(Context paramContext, OnContinueListener paramOnContinueListener)
  {
    OpenNotification(paramContext, 4, paramOnContinueListener, false);
  }
  
  public static void WarnAboutPlaybackInExternalPlayer(Context paramContext, OnContinueListener paramOnContinueListener)
  {
    OpenNotification(paramContext, 0, paramOnContinueListener, true);
  }
  
  public static void WarnAboutStartUpdateAndDownload(Context paramContext, OnContinueListener paramOnContinueListener)
  {
    OpenNotification(paramContext, 13, paramOnContinueListener, true);
  }
  
  public static void WarnAboutStreamingInExternalPlayer(Context paramContext, OnContinueListener paramOnContinueListener)
  {
    OpenNotification(paramContext, 1, paramOnContinueListener, false);
  }
  
  public static boolean isNotificationEnabledFor(int paramInt)
  {
    return "1".equals(_Preferences.GetPreference(paramInt, "1"));
  }
  
  public static void setNotificationPreferenceFor(int paramInt, boolean paramBoolean)
  {
    NotificationPreferences localNotificationPreferences = _Preferences;
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localNotificationPreferences.SetPreference(paramInt, str);
      return;
    }
  }
  
  public static abstract interface OnContinueListener
  {
    public abstract void OnContinue();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/notifications/UserNotificationManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */