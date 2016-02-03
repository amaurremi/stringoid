package mobi.beyondpod.ui.views.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.rsscore.helpers.TimeSpan;
import mobi.beyondpod.rsscore.rss.LicenseManager;
import mobi.beyondpod.schedulercore.ScheduledTasksManager;
import mobi.beyondpod.sync.ChangeTracker;
import mobi.beyondpod.sync.TrackedChangeBase;
import mobi.beyondpod.ui.commands.CommandManager;

public class CommonMenuHandler
{
  private static final String BEYOND_POD_HELP = CoreHelper.LoadResourceString(2131297061);
  private static final int FIRST = 150;
  public static final int HELP_KIND_CATEGORIES = 159;
  public static final int HELP_KIND_FEED_CONTENT = 162;
  public static final int HELP_KIND_HELP_HOME = 158;
  public static final int HELP_KIND_MY_EPISODES = 160;
  public static final int HELP_KIND_PLAYER = 161;
  private static final int MENU_ABOUT = 154;
  private static final int MENU_EPISODE_SYNC = 155;
  private static final int MENU_EXIT = 153;
  private static final int MENU_GET_SUPPORT = 152;
  public static final int MENU_MANAGE_CATEGORIES = 163;
  private static final int MENU_OPEN_SETTINGS_SELECTOR = 150;
  private static final int MENU_PLAY_VIDEO_AS_AUDIO = 151;
  public static final int MENU_SEARCH = 164;
  private static final int MENU_UNLOCK_APP = 156;
  private static final int MENU_VIEW_UPDATE_LOG = 157;
  
  public static Menu AddMoreMenuAt(Menu paramMenu, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramMenu = paramMenu.addSubMenu(0, 0, paramInt1, 2131296625).setIcon(17301573);
    paramMenu.add(0, paramInt2, 1, 2131296681);
    MenuItem localMenuItem;
    if (!LicenseManager.IsUnlocked())
    {
      if (CoreHelper.GetFirstDownloadedUnlockKey() != null)
      {
        paramInt1 = 2131296691;
        paramMenu.add(0, 156, 2, paramInt1);
      }
    }
    else
    {
      paramMenu.add(0, 150, 3, 2131296626);
      paramMenu.add(0, 163, 4, 2131296631);
      if (paramBoolean) {
        paramMenu.add(0, 164, 5, 2131296694);
      }
      if ((ChangeTracker.IsTrackingEnabled()) && (Configuration.CDSDebugEnabled())) {
        paramMenu.add(0, 155, 6, 2131297233);
      }
      localMenuItem = paramMenu.add(0, 151, 7, 2131296658).setCheckable(true);
      if (!Configuration.AllowVideosInPlaylist()) {
        break label239;
      }
    }
    label239:
    for (paramBoolean = false;; paramBoolean = true)
    {
      localMenuItem.setChecked(paramBoolean);
      paramMenu.add(0, 157, 8, 2131296680);
      paramMenu.add(0, 152, 9, 2131296684);
      paramMenu.add(0, 154, 10, 2131296688);
      paramMenu.add(0, 153, 11, 2131296687);
      return paramMenu;
      paramInt1 = 2131296690;
      break;
    }
  }
  
  public static boolean HandleCommonMenu(MenuItem paramMenuItem, Context paramContext)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    case 163: 
      CommandManager.CmdOpenManageCategoriesView();
      return true;
    case 150: 
      CommandManager.CmdShowGlobalSettings();
      return true;
    case 153: 
      CommandManager.CmdExit();
      return true;
    case 154: 
      CommandManager.CmdOpenAboutDialog(paramContext);
      return true;
    case 156: 
      CommandManager.CmdUnlockBeyondPod(paramContext);
      return true;
    case 164: 
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).onSearchRequested();
      }
      return true;
    case 152: 
      paramMenuItem = paramContext.getString(2131297012);
      localObject1 = paramContext.getString(2131296685);
      localObject2 = paramContext.getString(2131296686);
      localObject3 = paramContext.getString(2131296683);
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramContext);
      paramContext = new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          switch (paramAnonymousInt)
          {
          default: 
            return;
          case 0: 
            CommandManager.CmdStartHtmlViewActivity(Configuration.FAQFileURL(), CommonMenuHandler.this.getString(2131297012), false);
            return;
          case 1: 
            CommandManager.CmdOpenExternalBrowser(Configuration.KnowledgeBaseURI().toString());
            return;
          case 2: 
            CommandManager.CmdOpenExternalBrowser(Configuration.CommunityForumURI().toString());
            return;
          }
          CommandManager.CmdSuggestFeature(CommonMenuHandler.this);
        }
      };
      localBuilder.setItems(new String[] { paramMenuItem, localObject1, localObject2, localObject3 }, paramContext).setTitle(2131296684).create().show();
      return true;
    case 157: 
      CommandManager.CmdShowUpdateLog(paramContext);
      return true;
    case 158: 
      CommandManager.CmdStartHtmlViewActivity(Configuration.HelpFileURL(), BEYOND_POD_HELP, false);
      return true;
    case 160: 
      CommandManager.CmdStartHtmlViewActivity(Configuration.HelpFileMyEpisodesURL(), BEYOND_POD_HELP, false);
      return true;
    case 159: 
      CommandManager.CmdStartHtmlViewActivity(Configuration.HelpFileCategoriesURL(), BEYOND_POD_HELP, false);
      return true;
    case 162: 
      CommandManager.CmdStartHtmlViewActivity(Configuration.HelpFileFeedContentURL(), BEYOND_POD_HELP, false);
      return true;
    case 161: 
      CommandManager.CmdStartHtmlViewActivity(Configuration.HelpFilePlayerURL(), BEYOND_POD_HELP, false);
      return true;
    case 155: 
      localObject1 = new StringBuilder();
      localObject2 = ChangeTracker.PendingUploadChanges();
      if (((ArrayList)localObject2).size() > 0)
      {
        paramMenuItem = ((ArrayList)localObject2).size() + " pending changes";
        localObject2 = ((ArrayList)localObject2).iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext())
        {
          if (Configuration.LastRemoteChangeTimeStamp() > 0L) {
            ((StringBuilder)localObject1).append("\nLast remote change: " + DateTime.FormatDateTime(new Date(Configuration.LastRemoteChangeTimeStamp())));
          }
          if (Configuration.LastSyncTimeStamp() > 0L) {
            ((StringBuilder)localObject1).append("\nLast sync timestamp: " + DateTime.FormatDateTime(new Date(Configuration.LastSyncTimeStamp())));
          }
          localObject2 = LayoutInflater.from(paramContext).inflate(2130903092, null);
          ((TextView)((View)localObject2).findViewById(2131230901)).setText(((StringBuilder)localObject1).toString());
          new AlertDialog.Builder(paramContext).setTitle(paramMenuItem).setPositiveButton(2131297234, new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              ScheduledTasksManager.ScheduleSyncTaskIfSyncIsEnabled(0, TimeSpan.fromSeconds(1.0D), true);
            }
          }).setNeutralButton(2131297236, new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              CommandManager.CmdViewFileContent(Configuration.SyncLogFilePath(), true);
            }
          }).setView((View)localObject2).create().show();
          return true;
          paramMenuItem = "No Pending Changes";
          break;
        }
        localObject3 = (TrackedChangeBase)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append(" • ");
        ((StringBuilder)localObject1).append(DateTime.FormatDateTime(new Date(((TrackedChangeBase)localObject3).TimeStamp())));
        ((StringBuilder)localObject1).append(" - " + ((TrackedChangeBase)localObject3).ChangeName() + " ");
        ((StringBuilder)localObject1).append(((TrackedChangeBase)localObject3).FriendlyName());
        ((StringBuilder)localObject1).append("\n\n");
      }
    }
    if (Configuration.AllowVideosInPlaylist()) {}
    for (boolean bool = false;; bool = true)
    {
      Configuration.setAllowVideosInPlaylist(bool);
      CommandManager.CmdLoadCurrentTrack();
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/base/CommonMenuHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */