package mobi.beyondpod.ui.dialogs;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Iterator;
import mobi.beyondpod.R.id;
import mobi.beyondpod.R.layout;
import mobi.beyondpod.R.string;
import mobi.beyondpod.rsscore.categories.CategoryList;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.StringUtils;

public class SelectCategoryDialog
  extends AlertDialog
{
  private DialogInterface.OnClickListener ListItemListener = new DialogInterface.OnClickListener()
  {
    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
    {
      if (paramAnonymousInt == SelectCategoryDialog.this._Adapter.getCount()) {}
      do
      {
        return;
        FeedCategory localFeedCategory = CategoryManager.GetCategoryByValue((String)SelectCategoryDialog.this._Categories.get(paramAnonymousInt));
        paramAnonymousDialogInterface = localFeedCategory;
        if (localFeedCategory == CategoryManager.CategoryNull)
        {
          paramAnonymousDialogInterface = new FeedCategory((String)SelectCategoryDialog.this._Categories.get(paramAnonymousInt));
          CategoryManager.AddCategory(paramAnonymousDialogInterface);
        }
      } while (SelectCategoryDialog.this._CategorySelectedListener == null);
      SelectCategoryDialog.this._CategorySelectedListener.onCategorySelected(paramAnonymousDialogInterface);
    }
  };
  private View _ActionFooter = null;
  ArrayAdapter<String> _Adapter;
  private TextView _ButtonFooter = null;
  public ArrayList<String> _Categories = new ArrayList();
  private OnCategorySelectedListener _CategorySelectedListener = null;
  private View _Footer = null;
  private ListView _ListView;
  String _PreferredCategory;
  private Window _Window;
  
  public SelectCategoryDialog(Context paramContext, OnCategorySelectedListener paramOnCategorySelectedListener)
  {
    super(paramContext);
    this._CategorySelectedListener = paramOnCategorySelectedListener;
  }
  
  private void SwitchToActionFooter()
  {
    this._ButtonFooter.setVisibility(4);
    this._ActionFooter.setVisibility(0);
    EditText localEditText = (EditText)this._ActionFooter.findViewById(R.id.qcc_edit_text);
    localEditText.requestFocus();
    localEditText.setText("");
    ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(localEditText, 1);
    this._Window.clearFlags(131080);
    this._Window.setSoftInputMode(21);
  }
  
  private void SwitchToButtonFooter()
  {
    this._ActionFooter.setVisibility(4);
    this._ButtonFooter.setVisibility(0);
    EditText localEditText = (EditText)this._ActionFooter.findViewById(R.id.qcc_edit_text);
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(localEditText.getWindowToken(), 2);
  }
  
  private void createFooter()
  {
    this._Footer = getLayoutInflater().inflate(R.layout.select_cat_dlg_cat_add, null);
    this._ActionFooter = this._Footer.findViewById(R.id.createCategory);
    this._ActionFooter.setVisibility(4);
    final Object localObject = (EditText)this._ActionFooter.findViewById(R.id.qcc_edit_text);
    ImageButton localImageButton1 = (ImageButton)this._ActionFooter.findViewById(R.id.qcc_add_cat_but);
    ImageButton localImageButton2 = (ImageButton)this._ActionFooter.findViewById(R.id.qcc_cancel_add_cat);
    localImageButton1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = localObject.getText().toString();
        int i = 0;
        if ((paramAnonymousView == null) || (paramAnonymousView.length() < 1)) {
          i = R.string.category_properties_vld_NameEmpty;
        }
        while (i > 0)
        {
          Toast.makeText(SelectCategoryDialog.this.getContext(), i, 1).show();
          return;
          if (CategoryManager.GetCategoryByValue(paramAnonymousView) != CategoryManager.CategoryNull) {
            i = R.string.category_properties_vld_categoryExists;
          }
        }
        CategoryManager.AddCategory(new FeedCategory(paramAnonymousView));
        SelectCategoryDialog.this.refreshCategoryList();
        SelectCategoryDialog.this._Adapter.notifyDataSetChanged();
        SelectCategoryDialog.this.SwitchToButtonFooter();
      }
    });
    localImageButton2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        SelectCategoryDialog.this.SwitchToButtonFooter();
      }
    });
    this._ButtonFooter = ((TextView)this._Footer.findViewById(R.id.addButton));
    localObject = getLayoutInflater().inflate(17367057, null).findViewById(16908308);
    if ((localObject != null) && ((localObject instanceof TextView))) {
      this._ButtonFooter.setTextColor(((TextView)localObject).getTextColors());
    }
    this._Footer.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        SelectCategoryDialog.this.SwitchToActionFooter();
      }
    });
    this._ListView.addFooterView(this._Footer);
  }
  
  private void refreshCategoryList()
  {
    this._Categories.clear();
    if (!StringUtils.IsNullOrEmpty(this._PreferredCategory))
    {
      localObject = CategoryManager.GetCategoryByValue(this._PreferredCategory);
      if (localObject != CategoryManager.CategoryNull) {
        this._PreferredCategory = ((FeedCategory)localObject).Name();
      }
      this._Categories.add(this._PreferredCategory);
    }
    Object localObject = CategoryManager.GetCategoriesForAssignment().iterator();
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        return;
      }
      FeedCategory localFeedCategory = (FeedCategory)((Iterator)localObject).next();
      if (!this._Categories.contains(localFeedCategory.Name())) {
        this._Categories.add(localFeedCategory.Name());
      }
    }
  }
  
  public AlertDialog CreateDialog(String paramString)
  {
    this._PreferredCategory = paramString;
    refreshCategoryList();
    this._Adapter = new ArrayAdapter(getContext(), 17367057, 16908308, this._Categories);
    paramString = new AlertDialog.Builder(getContext());
    paramString.setNeutralButton(R.string.alert_dialog_cancel, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        if (SelectCategoryDialog.this._CategorySelectedListener != null) {
          SelectCategoryDialog.this._CategorySelectedListener.onCategorySelected(null);
        }
      }
    });
    paramString.setAdapter(this._Adapter, this.ListItemListener);
    paramString.setTitle(R.string.opml_import_dlg_title);
    paramString.setCancelable(true);
    paramString = paramString.create();
    this._ListView = paramString.getListView();
    this._Window = paramString.getWindow();
    createFooter();
    return paramString;
  }
  
  public static abstract interface OnCategorySelectedListener
  {
    public abstract void onCategorySelected(FeedCategory paramFeedCategory);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/dialogs/SelectCategoryDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */