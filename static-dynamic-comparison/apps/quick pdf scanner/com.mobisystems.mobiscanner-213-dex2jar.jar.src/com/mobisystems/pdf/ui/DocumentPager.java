package com.mobisystems.pdf.ui;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.l;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.mobisystems.pdf.R.id;
import com.mobisystems.pdf.R.layout;

public class DocumentPager
  extends RelativeLayout
{
  private TextView currentPageLabel;
  private ViewPager pager;
  
  public DocumentPager(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public DocumentPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DocumentPager(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.pager = new ViewPager(paramContext);
    this.pager.setId(R.id.pager_id);
    addView(this.pager, new FrameLayout.LayoutParams(-2, -2));
    paramContext = (LinearLayout)LayoutInflater.from(paramContext).inflate(R.layout.pdf_page_num_floating_view, null);
    paramAttributeSet = new RelativeLayout.LayoutParams(-2, -2);
    paramAttributeSet.addRule(12);
    paramAttributeSet.setMargins(5, 5, 5, 5);
    addView(paramContext, paramAttributeSet);
    this.currentPageLabel = ((TextView)paramContext.findViewById(R.id.current_page_label));
  }
  
  public ViewPager getPager()
  {
    return (ViewPager)findViewById(R.id.pager_id);
  }
  
  void onPageChanged(int paramInt)
  {
    this.currentPageLabel.setText("" + paramInt + "/" + getPager().D().getCount());
  }
  
  public void setAdapter(DocumentAdapter paramDocumentAdapter)
  {
    paramDocumentAdapter._pager = this;
    getPager().a(paramDocumentAdapter);
  }
  
  public void setCurrentPage(int paramInt)
  {
    if (getPager().F() != paramInt) {
      onPageChanged(paramInt);
    }
    getPager().j(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/ui/DocumentPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */