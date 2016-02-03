package mobi.beyondpod.ui.dialogs;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mobi.beyondpod.rsscore.StartupContentBuilder;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.schedulercore.ScheduleUtils;
import mobi.beyondpod.schedulercore.ScheduledTasksManager;

public class DeleteCategoryDialog
{
  private static final String DATA = CoreHelper.LoadResourceString(2131297007);
  FeedCategory _Category;
  Context _Context;
  DialogInterface.OnClickListener _OnOK = new DialogInterface.OnClickListener()
  {
    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
    {
      CategoryManager.DeleteCategory(DeleteCategoryDialog.this._Category);
      paramAnonymousDialogInterface = ScheduleUtils.GetScheduledTaskForCategory(DeleteCategoryDialog.this._Category);
      if (paramAnonymousDialogInterface != null) {
        ScheduledTasksManager.DeleteScheduledTask(paramAnonymousDialogInterface);
      }
      FeedRepository.AutoSaveRepository();
      StartupContentBuilder.BackupRepositoriesAsync();
    }
  };
  
  public static void ShowDialog(Context paramContext, FeedCategory paramFeedCategory)
  {
    DeleteCategoryDialog localDeleteCategoryDialog = new DeleteCategoryDialog();
    localDeleteCategoryDialog._Category = paramFeedCategory;
    localDeleteCategoryDialog._Context = paramContext;
    localDeleteCategoryDialog.CreateDialog().show();
  }
  
  public Dialog CreateDialog()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this._Context).setIcon(17301543).setTitle(2131296709);
    Context localContext = this._Context;
    if (this._Category != null) {}
    for (String str = this._Category.Name();; str = DATA) {
      return localBuilder.setMessage(localContext.getString(2131296710, new Object[] { str })).setPositiveButton(2131296752, this._OnOK).setNegativeButton(2131296315, null).create();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/dialogs/DeleteCategoryDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */