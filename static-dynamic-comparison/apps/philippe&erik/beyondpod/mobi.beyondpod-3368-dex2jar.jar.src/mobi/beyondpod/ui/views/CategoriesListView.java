package mobi.beyondpod.ui.views;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.mobeta.android.dslv.DragSortListView;
import com.mobeta.android.dslv.DragSortListView.DropListener;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.categories.CategoryList;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEvent;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEventListener;
import mobi.beyondpod.schedulercore.ScheduledTasksManager;
import mobi.beyondpod.ui.commands.CommandManager;

public class CategoriesListView
  extends DragSortListView
  implements RepositoryEvents.RepositoryEventListener, AdapterView.OnItemClickListener
{
  boolean ReorderEnabled = false;
  private CategoriesViewAdapter _Adapter;
  private DragSortListView.DropListener _DropListener = new DragSortListView.DropListener()
  {
    public void drop(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      CategoryManager.MoveCategory(CategoriesListView.this._Adapter.GetCategoryAtPosition(paramAnonymousInt1), CategoriesListView.this._Adapter.GetCategoryAtPosition(paramAnonymousInt2));
    }
  };
  
  public CategoriesListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setTextFilterEnabled(false);
    setLongClickable(true);
  }
  
  private void Refresh()
  {
    SetCategories(CategoryManager.GetCategoriesForFilter(), Configuration.getActiveFeedCategory());
  }
  
  private void SetCategories(CategoryList paramCategoryList, FeedCategory paramFeedCategory)
  {
    if (this._Adapter != null) {
      this._Adapter.SetCategories(paramCategoryList);
    }
  }
  
  public void DisableDragDrop()
  {
    setDropListener(null);
    this.ReorderEnabled = false;
    this._Adapter.notifyDataSetChanged();
  }
  
  public void EnableDragDrop()
  {
    setDropListener(this._DropListener);
    this.ReorderEnabled = true;
    this._Adapter.notifyDataSetChanged();
  }
  
  public void Initialize()
  {
    this._Adapter = new CategoriesViewAdapter(getContext(), this);
    SetCategories(CategoryManager.GetCategoriesForFilter(), Configuration.getActiveFeedCategory());
    setAdapter(this._Adapter);
    setCacheColorHint(0);
    EnableDragDrop();
    setFadingEdgeLength((int)getResources().getDimension(2131492952));
    setVerticalFadingEdgeEnabled(true);
    setOnItemClickListener(this);
  }
  
  public void OnAfterDeactivate()
  {
    BeyondPodApplication.MessageBus.Unsubscribe(this, RepositoryEvents.RepositoryEvent.class);
    DisableDragDrop();
  }
  
  public void OnBeforeActivate()
  {
    BeyondPodApplication.MessageBus.Subscribe(this, RepositoryEvents.RepositoryEvent.class);
    ScheduledTasksManager.RescheduleAllActiveTasksIfNeeded();
    Refresh();
    EnableDragDrop();
  }
  
  protected void OnItemSelected(int paramInt)
  {
    final FeedCategory localFeedCategory = this._Adapter.getSelectedCategory(paramInt);
    String[] arrayOfString;
    if (localFeedCategory != null)
    {
      if ((localFeedCategory != CategoryManager.AllFeeds) && (localFeedCategory != CategoryManager.Unassigned)) {
        break label80;
      }
      arrayOfString = new String[1];
      arrayOfString[0] = getContext().getString(2131296628);
    }
    for (;;)
    {
      new AlertDialog.Builder(getContext()).setItems(arrayOfString, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          switch (paramAnonymousInt)
          {
          default: 
            return;
          case 0: 
            CommandManager.CmdSetUpdateSchedule(localFeedCategory, CategoriesListView.this.getContext(), false);
            return;
          case 1: 
            CommandManager.CmdEditCategory(localFeedCategory);
            return;
          }
          CommandManager.CmdDeleteCategory(CategoriesListView.this.getContext(), localFeedCategory);
        }
      }).setTitle(localFeedCategory.Name()).show();
      return;
      label80:
      arrayOfString = new String[3];
      arrayOfString[0] = getContext().getString(2131296628);
      arrayOfString[1] = getContext().getString(2131296629);
      arrayOfString[2] = getContext().getString(2131296627);
    }
  }
  
  public void OnRepositoryEvent(RepositoryEvents.RepositoryEvent paramRepositoryEvent)
  {
    if ((paramRepositoryEvent.Type == 13) || (paramRepositoryEvent.Type == 12) || (paramRepositoryEvent.Type == 14)) {
      Refresh();
    }
  }
  
  public int VisibleCount()
  {
    return this._Adapter.getCount();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    OnItemSelected(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/CategoriesListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */