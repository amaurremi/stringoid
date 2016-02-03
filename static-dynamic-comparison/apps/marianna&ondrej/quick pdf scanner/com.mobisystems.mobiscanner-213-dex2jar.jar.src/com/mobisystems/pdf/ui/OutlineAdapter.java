package com.mobisystems.pdf.ui;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.mobisystems.pdf.PDFOutline;
import com.mobisystems.pdf.PDFOutline.Item;
import com.mobisystems.pdf.R.id;
import com.mobisystems.pdf.R.layout;
import java.util.ArrayList;
import java.util.Iterator;

public class OutlineAdapter
  implements ListAdapter
{
  ArrayList<DataSetObserver> _observers = new ArrayList();
  CompoundButton.OnCheckedChangeListener _oncheckedChangeListener = new CompoundButton.OnCheckedChangeListener()
  {
    public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
    {
      ((PDFOutline.Item)paramAnonymousCompoundButton.getTag()).setExpanded(paramAnonymousBoolean);
      paramAnonymousCompoundButton = OutlineAdapter.this._observers.iterator();
      while (paramAnonymousCompoundButton.hasNext()) {
        ((DataSetObserver)paramAnonymousCompoundButton.next()).onChanged();
      }
    }
  };
  PDFOutline _outline;
  int _padding;
  
  OutlineAdapter(PDFOutline paramPDFOutline)
  {
    this._outline = paramPDFOutline;
  }
  
  public boolean areAllItemsEnabled()
  {
    return true;
  }
  
  public int getCount()
  {
    return this._outline.count();
  }
  
  public Object getItem(int paramInt)
  {
    return this._outline.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this._outline.get(paramInt).isExpandable()) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    PDFOutline.Item localItem = this._outline.get(paramInt);
    View localView = paramView;
    if (paramView == null) {
      if (!localItem.isExpandable()) {
        break label151;
      }
    }
    label151:
    for (paramView = View.inflate(paramViewGroup.getContext(), R.layout.pdf_outline_expandable_item, null);; paramView = View.inflate(paramViewGroup.getContext(), R.layout.pdf_outline_item, null))
    {
      this._padding = paramView.getPaddingLeft();
      localView = paramView;
      if (localItem.isExpandable())
      {
        paramView = (CompoundButton)localView.findViewById(R.id.expander);
        paramView.setClickable(true);
        paramView.setOnCheckedChangeListener(this._oncheckedChangeListener);
        paramView.setTag(localItem);
        paramView.setChecked(localItem.isExpanded());
      }
      paramView = (TextView)localView.findViewById(16908308);
      localView.setPadding(this._padding * (localItem.nestingLevel() + 1), localView.getPaddingTop(), localView.getPaddingRight(), localView.getPaddingBottom());
      paramView.setText(localItem.text());
      return localView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isEmpty()
  {
    return this._outline.count() == 0;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return true;
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this._observers.add(paramDataSetObserver);
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this._observers.remove(paramDataSetObserver);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/ui/OutlineAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */