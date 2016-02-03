package mobi.beyondpod.ui.views.impexp;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import java.util.ArrayList;
import mobi.beyondpod.rsscore.helpers.CoreHelper;

public class PopularCategoriesFragment
  extends Fragment
{
  static final String TAG = PopularCategoriesFragment.class.getSimpleName();
  private static final String TAG_SELECTED_CATEGORY = "SELECTED_CATEGORY";
  private String _ActiveCategory;
  ArrayList<CategoryInfo> _Categories = new ArrayList();
  RadioGroup _CategoryTabs;
  View _Content;
  PopularCagtegoryOwner _Owner;
  HorizontalScrollView _TabScrollHolder;
  RadioGroup.OnCheckedChangeListener _TabSelectedListener = new RadioGroup.OnCheckedChangeListener()
  {
    public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
    {
      paramAnonymousRadioGroup = (RadioButton)paramAnonymousRadioGroup.findViewById(paramAnonymousInt);
      if (paramAnonymousRadioGroup != null) {
        ((PopularCategoriesFragment.PopularCagtegoryOwner)PopularCategoriesFragment.this.getActivity()).onCategoryChanged((String)paramAnonymousRadioGroup.getTag());
      }
    }
  };
  
  private void BuildCategories()
  {
    this._Categories.add(new CategoryInfo(2130837883, "Recommended", "Recommended"));
    this._Categories.add(new CategoryInfo(2130837901, "Trending", "Trending"));
    this._Categories.add(new CategoryInfo(2130837880, "Publishers", "Collections"));
    this._Categories.add(new CategoryInfo(2130837886, "Regions", "Regions"));
    this._Categories.add(new CategoryInfo(2130837877, "News", "News"));
    this._Categories.add(new CategoryInfo(2130837850, "Business and Finance", "Business"));
    this._Categories.add(new CategoryInfo(2130837853, "Comedy", "Comedy"));
    this._Categories.add(new CategoryInfo(2130837898, "Technology", "Technology"));
    this._Categories.add(new CategoryInfo(2130837892, "Science and Medicine", "Science & Medicine"));
    this._Categories.add(new CategoryInfo(2130837874, "Health and Fitness", "Health & Fitness"));
    this._Categories.add(new CategoryInfo(2130837895, "Sports", "Sports"));
    this._Categories.add(new CategoryInfo(2130837868, "Games and Hobbies", "Games & Hobbies"));
    this._Categories.add(new CategoryInfo(2130837865, "Kids and Family", "Kids & Family"));
    this._Categories.add(new CategoryInfo(2130837862, "Entertainment", "Entertainment"));
    this._Categories.add(new CategoryInfo(2130837859, "Education", "Education"));
    this._Categories.add(new CategoryInfo(2130837889, "Religion and Spirituality", "Spirituality"));
    this._Categories.add(new CategoryInfo(2130837856, "Culture", "Culture"));
    this._Categories.add(new CategoryInfo(2130837847, "Arts", "Arts"));
    this._Categories.add(new CategoryInfo(2130837904, "TV and Film", "TV & Film"));
    this._Categories.add(new CategoryInfo(2130837871, "Government and Organizations", "Organizations"));
  }
  
  private void Refresh()
  {
    this._CategoryTabs.setOnCheckedChangeListener(null);
    this._CategoryTabs.check(this._CategoryTabs.findViewWithTag(this._ActiveCategory).getId());
    this._CategoryTabs.setOnCheckedChangeListener(this._TabSelectedListener);
    ScrollActiveTabInView();
  }
  
  public void FocusActiveTab()
  {
    View localView = this._CategoryTabs.findViewWithTag(this._ActiveCategory);
    if (localView != null) {
      localView.requestFocus();
    }
  }
  
  public void ScrollActiveTabInView()
  {
    if (this._CategoryTabs.getWidth() == 0)
    {
      this._CategoryTabs.postDelayed(new Runnable()
      {
        public void run()
        {
          PopularCategoriesFragment.this.ScrollActiveTabInView();
        }
      }, 1000L);
      CoreHelper.WriteTraceEntry(TAG, "Category Tabs not ready yet...");
    }
    label237:
    for (;;)
    {
      return;
      int i = 0;
      for (;;)
      {
        if (i == this._CategoryTabs.getChildCount()) {
          break label237;
        }
        RadioButton localRadioButton = (RadioButton)this._CategoryTabs.getChildAt(i);
        if (localRadioButton.isChecked())
        {
          if ((localRadioButton.getLeft() >= this._TabScrollHolder.getScrollX()) && (localRadioButton.getRight() <= this._TabScrollHolder.getScrollX() + this._TabScrollHolder.getWidth())) {
            break;
          }
          i = (int)(this._TabScrollHolder.getWidth() * 0.1D);
          if (localRadioButton.getLeft() < this._TabScrollHolder.getScrollX())
          {
            j = this._TabScrollHolder.getScrollX();
            k = localRadioButton.getLeft();
            this._TabScrollHolder.scrollBy((j - k + i) * -1, 0);
            return;
          }
          if (localRadioButton.getRight() <= this._TabScrollHolder.getScrollX() + this._TabScrollHolder.getWidth()) {
            break;
          }
          int j = localRadioButton.getRight();
          int k = this._TabScrollHolder.getScrollX();
          int m = this._TabScrollHolder.getWidth();
          this._TabScrollHolder.scrollBy(j - (k + m) + i, 0);
          return;
        }
        i += 1;
      }
    }
  }
  
  public void SetActiveCategory(String paramString)
  {
    this._ActiveCategory = paramString;
    Refresh();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    BuildCategories();
    this._Content = paramLayoutInflater.inflate(2130903152, null);
    this._TabScrollHolder = ((HorizontalScrollView)this._Content.findViewById(2131231162));
    this._TabScrollHolder.setHorizontalScrollBarEnabled(false);
    this._TabScrollHolder.setSmoothScrollingEnabled(true);
    this._TabScrollHolder.setFadingEdgeLength((int)(6.0F * getResources().getDimension(2131492952)));
    this._TabScrollHolder.setHorizontalFadingEdgeEnabled(true);
    this._CategoryTabs = ((RadioGroup)this._TabScrollHolder.findViewById(2131231163));
    int i = 0;
    if (i == this._Categories.size())
    {
      if (paramBundle == null) {
        break label231;
      }
      this._ActiveCategory = paramBundle.getString("SELECTED_CATEGORY");
      Refresh();
    }
    for (;;)
    {
      return this._Content;
      paramViewGroup = (RadioButton)paramLayoutInflater.inflate(2130903153, null);
      paramViewGroup.setText(((CategoryInfo)this._Categories.get(i)).CategoryName);
      paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(null, getActivity().getResources().getDrawable(((CategoryInfo)this._Categories.get(i)).ImageResourceId), null, null);
      paramViewGroup.setTag(((CategoryInfo)this._Categories.get(i)).CategoryTag);
      this._CategoryTabs.addView(paramViewGroup);
      i += 1;
      break;
      label231:
      this._TabScrollHolder.postDelayed(new Runnable()
      {
        public void run()
        {
          PopularCategoriesFragment.this._TabScrollHolder.scrollBy(PopularCategoriesFragment.this._CategoryTabs.getChildAt(0).getWidth() / 3, 0);
        }
      }, 100L);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("SELECTED_CATEGORY", this._ActiveCategory);
  }
  
  private static class CategoryInfo
  {
    public String CategoryName;
    public String CategoryTag;
    public int ImageResourceId;
    
    public CategoryInfo(int paramInt, String paramString1, String paramString2)
    {
      this.ImageResourceId = paramInt;
      this.CategoryTag = paramString1;
      this.CategoryName = paramString2;
    }
  }
  
  public static abstract interface PopularCagtegoryOwner
  {
    public abstract void onCategoryChanged(String paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/impexp/PopularCategoriesFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */