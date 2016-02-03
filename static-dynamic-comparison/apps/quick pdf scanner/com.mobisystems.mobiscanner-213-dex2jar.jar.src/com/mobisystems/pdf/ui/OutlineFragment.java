package com.mobisystems.pdf.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.mobisystems.pdf.PDFDocument;
import com.mobisystems.pdf.PDFOutline;
import com.mobisystems.pdf.PDFOutline.Item;
import com.mobisystems.pdf.R.id;
import com.mobisystems.pdf.R.layout;

public class OutlineFragment
  extends Fragment
  implements DocumentActivity.Observer
{
  static final String KEY_CURRENT_ITEM = "pdf.outline.current.item";
  static final String KEY_EXPANED_ITEMS = "pdf.outline.expanded.items";
  int _currentItem = 0;
  int[] _expandedItems;
  ListView _list;
  AdapterView.OnItemClickListener _onItemClickListener = new AdapterView.OnItemClickListener()
  {
    public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      paramAnonymousAdapterView = (DocumentActivity)OutlineFragment.this.getActivity();
      Utils.executePDFAction(paramAnonymousAdapterView.getOutline().get(paramAnonymousInt).action(), paramAnonymousInt, paramAnonymousAdapterView, OutlineFragment.this.getActivity());
      OutlineFragment.this.getFragmentManager().popBackStack();
    }
  };
  
  public void onContentModeChanged(DocumentActivity.ContentMode paramContentMode) {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.pdf_outline_fragment, paramViewGroup, false);
    paramLayoutInflater.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        OutlineFragment.this.getFragmentManager().popBackStack();
      }
    });
    this._list = ((ListView)paramLayoutInflater.findViewById(R.id.outline_list));
    this._list.setChoiceMode(2);
    this._list.setOnItemClickListener(this._onItemClickListener);
    if (paramBundle != null)
    {
      this._expandedItems = paramBundle.getIntArray("pdf.outline.expanded.items");
      this._currentItem = paramBundle.getInt("pdf.outline.current.item");
    }
    ((DocumentActivity)getActivity()).registerObserver(this);
    updateItems();
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    ((DocumentActivity)getActivity()).unregisterObserver(this);
    this._list = null;
    super.onDestroyView();
  }
  
  public void onDocumentChanged(PDFDocument paramPDFDocument)
  {
    updateItems();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    int m = 0;
    super.onSaveInstanceState(paramBundle);
    PDFOutline localPDFOutline = ((DocumentActivity)getActivity()).getOutline();
    if (localPDFOutline == null) {
      return;
    }
    this._currentItem = this._list.getFirstVisiblePosition();
    paramBundle.putInt("pdf.outline.current.item", this._currentItem);
    int i = 0;
    int k;
    for (int j = 0; i < localPDFOutline.count(); j = k)
    {
      k = j;
      if (localPDFOutline.get(i).isExpanded()) {
        k = j + 1;
      }
      i += 1;
    }
    int[] arrayOfInt = new int[j];
    j = 0;
    i = m;
    while (i < localPDFOutline.count())
    {
      k = j;
      if (localPDFOutline.get(i).isExpanded())
      {
        arrayOfInt[j] = i;
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    paramBundle.putIntArray("pdf.outline.expanded.items", arrayOfInt);
  }
  
  void updateItems()
  {
    Object localObject = ((DocumentActivity)getActivity()).getOutline();
    if (localObject == null) {
      return;
    }
    if (this._expandedItems != null)
    {
      int j = 0;
      int k;
      for (int i = 0;; i = k)
      {
        k = i;
        if (j >= this._expandedItems.length) {
          break;
        }
        while (i < this._expandedItems[j])
        {
          if (((PDFOutline)localObject).get(i).isExpandable()) {
            ((PDFOutline)localObject).get(i).setExpanded(false);
          }
          i += 1;
        }
        k = i + 1;
        ((PDFOutline)localObject).get(i).setExpanded(true);
        j += 1;
      }
      while (k < ((PDFOutline)localObject).count())
      {
        if (((PDFOutline)localObject).get(k).isExpandable()) {
          ((PDFOutline)localObject).get(k).setExpanded(false);
        }
        k += 1;
      }
    }
    localObject = new OutlineAdapter((PDFOutline)localObject);
    this._list.setAdapter((ListAdapter)localObject);
    this._list.setSelectionFromTop(this._currentItem, 0);
    this._expandedItems = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/ui/OutlineFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */