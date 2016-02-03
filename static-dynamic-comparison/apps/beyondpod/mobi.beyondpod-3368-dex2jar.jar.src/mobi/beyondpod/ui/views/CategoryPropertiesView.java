package mobi.beyondpod.ui.views;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import mobi.beyondpod.rsscore.StartupContentBuilder;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.schedulercore.OperationUpdateCategory;
import mobi.beyondpod.schedulercore.ScheduleUtils;
import mobi.beyondpod.schedulercore.ScheduledTask;
import mobi.beyondpod.ui.core.ActionBarActivityBase;
import mobi.beyondpod.ui.dialogs.ColorPickerDialog;
import mobi.beyondpod.ui.dialogs.ColorPickerDialog.OnColorChangedListener;

public class CategoryPropertiesView
  extends ActionBarActivityBase
{
  private static final String ADD_CATEGORY = CoreHelper.LoadResourceString(2131297055);
  private static final String EDIT_CATEGORY = CoreHelper.LoadResourceString(2131297052);
  private static final String NEW_CATEGORY;
  private static final String TAG = CategoryPropertiesView.class.getSimpleName();
  private static final String UNABLE_TO_MODIFY_CATEGORY = CoreHelper.LoadResourceString(2131297053);
  Button _CancelButton;
  View _ColorSample;
  FeedCategory _CurrentCategory;
  Handler _Handler = new Handler();
  EditText _Name;
  Button _OKButton;
  private View.OnClickListener _OnCancelListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      CategoryPropertiesView.this.finish();
    }
  };
  private View.OnClickListener _OnOKListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (!CategoryPropertiesView.this.ValidateControls()) {
        return;
      }
      String str = CategoryPropertiesView.this._Name.getText().toString();
      FeedCategory localFeedCategory = CategoryPropertiesView.this._CurrentCategory;
      for (;;)
      {
        try
        {
          if (CategoryPropertiesView.this._CurrentCategory == CategoryManager.AllFeeds) {
            paramAnonymousView = new FeedCategory(str);
          }
        }
        catch (Exception localException1)
        {
          paramAnonymousView = localFeedCategory;
        }
        try
        {
          CategoryManager.AddCategory(paramAnonymousView);
          CategoryManager.SetCategoryColor(paramAnonymousView, CategoryPropertiesView.this._SelectedColor);
          FeedRepository.SaveRepositoryAsync();
          StartupContentBuilder.BackupRepositoriesAsync();
          CategoryPropertiesView.this.finish();
          return;
        }
        catch (Exception localException2)
        {
          for (;;) {}
        }
        paramAnonymousView = localFeedCategory;
        if (!StringUtils.EqualsIgnoreCase(CategoryPropertiesView.this._CurrentCategory.Name(), str))
        {
          paramAnonymousView = ScheduleUtils.GetScheduledTaskForCategory(CategoryPropertiesView.this._CurrentCategory);
          if (paramAnonymousView != null) {
            ((OperationUpdateCategory)paramAnonymousView.Operation()).setCategoryToUpdate(str);
          }
          CategoryManager.RenameCategory(CategoryPropertiesView.this._CurrentCategory, str);
          paramAnonymousView = localFeedCategory;
          continue;
          CoreHelper.LogException(CategoryPropertiesView.class.getSimpleName(), CategoryPropertiesView.UNABLE_TO_MODIFY_CATEGORY, localException1);
        }
      }
    }
  };
  int _SelectedColor;
  
  static
  {
    NEW_CATEGORY = CoreHelper.LoadResourceString(2131297054);
  }
  
  private boolean ValidateControls()
  {
    String str = this._Name.getText().toString().trim();
    if ((str.length() == 0) || (str.contains("^")) || (str.contains("|")))
    {
      Toast.makeText(this, 2131296313, 1).show();
      this._Name.requestFocus();
      return false;
    }
    if ((this._CurrentCategory == CategoryManager.AllFeeds) && (CategoryManager.GetCategoryByValue(str) != CategoryManager.CategoryNull))
    {
      Toast.makeText(this, 2131296314, 1).show();
      this._Name.requestFocus();
      return false;
    }
    this._Name.setText(str.trim());
    return true;
  }
  
  void SetColor(int paramInt)
  {
    this._SelectedColor = paramInt;
    View localView = this._ColorSample;
    if (this._SelectedColor == 0) {}
    for (paramInt = -16777216;; paramInt = this._SelectedColor)
    {
      localView.setBackgroundColor(paramInt);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!FeedRepository.IsRepositoryAvailable())
    {
      CoreHelper.WriteTraceEntry(TAG, "Closing view because the repository is not Loaded");
      finish();
      return;
    }
    setContentView(2130903089);
    this._Name = ((EditText)findViewById(2131230891));
    this._CurrentCategory = CategoryManager.GetCategoryByValue(getIntent().getType());
    if (this._CurrentCategory != CategoryManager.AllFeeds)
    {
      setTitle(EDIT_CATEGORY);
      this._Name.setText(this._CurrentCategory.Name());
      this._Name.setInputType(0);
      this._Handler.postDelayed(new Runnable()
      {
        public void run()
        {
          CategoryPropertiesView.this._Name.setInputType(96);
        }
      }, 1000L);
    }
    for (;;)
    {
      ((Button)findViewById(2131230893)).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          new ColorPickerDialog(CategoryPropertiesView.this, new ColorPickerDialog.OnColorChangedListener()
          {
            public void colorChanged(int paramAnonymous2Int)
            {
              CategoryPropertiesView.this.SetColor(paramAnonymous2Int);
            }
          }, CategoryPropertiesView.this._SelectedColor).show();
        }
      });
      this._ColorSample = findViewById(2131230892);
      SetColor(this._CurrentCategory.Color());
      this._OKButton = ((Button)findViewById(2131230928));
      this._CancelButton = ((Button)findViewById(2131230929));
      this._CancelButton.setOnClickListener(this._OnCancelListener);
      this._OKButton.setOnClickListener(this._OnOKListener);
      return;
      setTitle(ADD_CATEGORY);
      this._Name.setText(NEW_CATEGORY);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/CategoryPropertiesView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */