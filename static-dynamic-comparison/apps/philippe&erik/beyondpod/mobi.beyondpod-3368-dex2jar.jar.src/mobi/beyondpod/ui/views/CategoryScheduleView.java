package mobi.beyondpod.ui.views;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ViewSwitcher.ViewFactory;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.TimeSpan;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.schedulercore.Event;
import mobi.beyondpod.schedulercore.OperationBase;
import mobi.beyondpod.schedulercore.OperationUpdateCategory;
import mobi.beyondpod.schedulercore.ScheduleUtils;
import mobi.beyondpod.schedulercore.ScheduledTask;
import mobi.beyondpod.schedulercore.ScheduledTasksManager;
import mobi.beyondpod.ui.core.ActionBarActivityBase;

public class CategoryScheduleView
  extends ActionBarActivityBase
  implements ViewSwitcher.ViewFactory
{
  private static final String CATEGORY = CoreHelper.LoadResourceString(2131297058);
  private static final String PLEASE_MAKE_SURE_THAT_START_TIMES_ARE_AT_LEAST_15_MINUTES_APART = CoreHelper.LoadResourceString(2131297056);
  private static final String TAG = CategoryScheduleView.class.getSimpleName();
  private static final String THE_START_TIME_OF_THIS_UPDATE_OVERLAPS_WITH_CATEGORY = CoreHelper.LoadResourceString(2131297057);
  CheckBox _Active;
  Button _CancelButton;
  FeedCategory _CurrentCategory;
  ScheduledTask _CurrentTask;
  int _Interval;
  ImageButton _MinusButton;
  Button _OKButton;
  private CompoundButton.OnCheckedChangeListener _OnActiveCheckChanged = new CompoundButton.OnCheckedChangeListener()
  {
    public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
    {
      CategoryScheduleView.this.ToggleActive(CategoryScheduleView.this._Active.isChecked());
    }
  };
  private View.OnClickListener _OnCancelListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      CategoryScheduleView.this.finish();
    }
  };
  private View.OnClickListener _OnMinusListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (CategoryScheduleView.this._Interval > 1)
      {
        paramAnonymousView = CategoryScheduleView.this;
        paramAnonymousView._Interval -= 1;
        CategoryScheduleView.this.UpdateInterval();
      }
    }
  };
  private View.OnClickListener _OnOKListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (!CategoryScheduleView.this.ValidateControld()) {
        return;
      }
      paramAnonymousView = new GregorianCalendar();
      paramAnonymousView.set(11, CategoryScheduleView.this._TimePicker.getCurrentHour().intValue());
      paramAnonymousView.set(12, CategoryScheduleView.this._TimePicker.getCurrentMinute().intValue());
      paramAnonymousView = new Event(paramAnonymousView.getTime(), CategoryScheduleView.this._Interval, CategoryScheduleView.this._Periods[CategoryScheduleView.this._Period.getSelectedItemPosition()]);
      OperationBase localOperationBase = ((OperationBase)ScheduledTasksManager.Operations().get(OperationUpdateCategory.OperationID)).CreateInstance("");
      ((OperationUpdateCategory)localOperationBase).setCategoryToUpdate(CategoryScheduleView.this._CurrentCategory.Value());
      if (CategoryScheduleView.this._CurrentTask == null)
      {
        CategoryScheduleView.this._CurrentTask = new ScheduledTask(paramAnonymousView, localOperationBase);
        ScheduledTasksManager.RegisterTask(CategoryScheduleView.this._CurrentTask);
      }
      for (;;)
      {
        CategoryScheduleView.this._CurrentTask.Active = CategoryScheduleView.this._Active.isChecked();
        if (CategoryScheduleView.this._CurrentTask.Active) {
          ScheduledTasksManager.SetScheduledTaskToDevice(CategoryScheduleView.this._CurrentTask);
        }
        FeedRepository.SaveRepositoryAsync();
        CategoryScheduleView.this.finish();
        return;
        ScheduledTasksManager.DeleteScheduledTaskFromDevice(CategoryScheduleView.this._CurrentTask);
        CategoryScheduleView.this._CurrentTask.Event = paramAnonymousView;
        CategoryScheduleView.this._CurrentTask.SetOperation(localOperationBase);
      }
    }
  };
  private View.OnClickListener _OnPlusListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (CategoryScheduleView.this._Interval < 99)
      {
        paramAnonymousView = CategoryScheduleView.this;
        paramAnonymousView._Interval += 1;
        CategoryScheduleView.this.UpdateInterval();
      }
    }
  };
  Spinner _Period;
  TimeSpan[] _Periods = { new TimeSpan(1L, 0L, 0L), new TimeSpan(1L, 0L, 0L, 0L), new TimeSpan(7L, 0L, 0L, 0L) };
  ImageButton _PlusButton;
  TextSwitcher _Switcher;
  TimePicker _TimePicker;
  
  private void ToggleActive(boolean paramBoolean)
  {
    this._TimePicker.setEnabled(paramBoolean);
    this._PlusButton.setEnabled(paramBoolean);
    this._MinusButton.setEnabled(paramBoolean);
    this._Period.setEnabled(paramBoolean);
  }
  
  private void UpdateInterval()
  {
    this._Switcher.setText(String.valueOf(this._Interval));
  }
  
  private boolean ValidateControld()
  {
    this._TimePicker.clearFocus();
    Object localObject1 = new GregorianCalendar();
    ((Calendar)localObject1).set(11, this._TimePicker.getCurrentHour().intValue());
    ((Calendar)localObject1).set(12, this._TimePicker.getCurrentMinute().intValue());
    localObject1 = ScheduledTasksManager.FindOverlappingTasksWith(new Event(((Calendar)localObject1).getTime(), this._Interval, this._Periods[this._Period.getSelectedItemPosition()]));
    Object localObject2 = ((ArrayList)localObject1).iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        return true;
      }
    } while ((ScheduledTask)((Iterator)localObject2).next() == this._CurrentTask);
    localObject2 = "";
    Object localObject3 = ((ScheduledTask)((ArrayList)localObject1).get(0)).Operation();
    localObject1 = localObject2;
    if ((localObject3 instanceof OperationUpdateCategory))
    {
      localObject3 = CategoryManager.GetCategoryByValue(((OperationUpdateCategory)localObject3).getCategoryToUpdate());
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((FeedCategory)localObject3).Name();
      }
    }
    Toast.makeText(this, THE_START_TIME_OF_THIS_UPDATE_OVERLAPS_WITH_CATEGORY + " '" + (String)localObject1 + "'.\n\n" + PLEASE_MAKE_SURE_THAT_START_TIMES_ARE_AT_LEAST_15_MINUTES_APART, 1).show();
    return false;
  }
  
  public View makeView()
  {
    TextView localTextView = new TextView(this);
    localTextView.setGravity(1);
    localTextView.setTextSize(28.0F);
    return localTextView;
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
    setContentView(2130903091);
    this._Period = ((Spinner)findViewById(2131230900));
    paramBundle = ArrayAdapter.createFromResource(this, 2131623958, 17367048);
    paramBundle.setDropDownViewResource(17367049);
    this._Period.setAdapter(paramBundle);
    this._PlusButton = ((ImageButton)findViewById(2131230897));
    this._PlusButton.setOnClickListener(this._OnPlusListener);
    this._MinusButton = ((ImageButton)findViewById(2131230899));
    this._MinusButton.setOnClickListener(this._OnMinusListener);
    this._Active = ((CheckBox)findViewById(2131230895));
    this._Active.setOnCheckedChangeListener(this._OnActiveCheckChanged);
    this._Switcher = ((TextSwitcher)findViewById(2131230898));
    this._Switcher.setFactory(this);
    paramBundle = AnimationUtils.loadAnimation(this, 17432576);
    Animation localAnimation = AnimationUtils.loadAnimation(this, 17432577);
    this._Switcher.setInAnimation(paramBundle);
    this._Switcher.setOutAnimation(localAnimation);
    this._TimePicker = ((TimePicker)findViewById(2131230896));
    this._TimePicker.setIs24HourView(Boolean.valueOf(DateFormat.is24HourFormat(this)));
    this._OKButton = ((Button)findViewById(2131230928));
    this._CancelButton = ((Button)findViewById(2131230929));
    this._CancelButton.setOnClickListener(this._OnCancelListener);
    this._OKButton.setOnClickListener(this._OnOKListener);
    paramBundle = getIntent().getType();
    this._CurrentCategory = CategoryManager.GetCategoryByValue(paramBundle);
    this._CurrentTask = ScheduleUtils.GetScheduledTaskForCategory(this._CurrentCategory);
    setTitle(CATEGORY + ": " + paramBundle);
    boolean bool;
    long l;
    if (this._CurrentTask != null)
    {
      paramBundle = this._Active;
      if ((this._CurrentTask.Active) && (ScheduledTasksManager.HasPendingIntentForTask(this._CurrentTask)))
      {
        bool = true;
        paramBundle.setChecked(bool);
        this._TimePicker.setCurrentHour(Integer.valueOf(this._CurrentTask.Event.UnadjustedStartTime().getHours()));
        this._TimePicker.setCurrentMinute(Integer.valueOf(this._CurrentTask.Event.UnadjustedStartTime().getMinutes()));
        this._Interval = this._CurrentTask.Event.getRecurrenceInterval();
        l = this._CurrentTask.Event.getRecurrencePeriod().getTotalMilliseconds();
        if (l != this._Periods[0].getTotalMilliseconds()) {
          break label494;
        }
        this._Period.setSelection(0);
      }
    }
    for (;;)
    {
      ToggleActive(this._Active.isChecked());
      UpdateInterval();
      return;
      bool = false;
      break;
      label494:
      if (l == this._Periods[1].getTotalMilliseconds())
      {
        this._Period.setSelection(1);
      }
      else
      {
        this._Period.setSelection(2);
        continue;
        this._Interval = 1;
        this._Period.setSelection(1);
        this._Active.setChecked(false);
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/CategoryScheduleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */