package com.mobisystems.pdf.ui;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ZoomButton;
import com.mobisystems.pdf.simpleViewer.R.id;
import com.mobisystems.pdf.simpleViewer.R.layout;
import com.mobisystems.pdf.simpleViewer.R.string;

public class GoToPageDialog
  extends DialogFragment
{
  static final String CURRENT_PAGE = "currentPage";
  static final String PAGES = "pages";
  int _currentPage;
  EditText _edit;
  View.OnClickListener _onBackClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (GoToPageDialog.this._currentPage <= 0) {
        return;
      }
      paramAnonymousView = GoToPageDialog.this;
      paramAnonymousView._currentPage -= 1;
      GoToPageDialog.this.updateControls();
    }
  };
  View.OnClickListener _onForwardClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (GoToPageDialog.this._currentPage + 1 >= GoToPageDialog.this._pages) {
        return;
      }
      paramAnonymousView = GoToPageDialog.this;
      paramAnonymousView._currentPage += 1;
      GoToPageDialog.this.updateControls();
    }
  };
  int _pages;
  SeekBar _seekBar;
  TextWatcher _textWatcher = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable) {}
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      try
      {
        paramAnonymousInt1 = Integer.parseInt(paramAnonymousCharSequence.toString()) - 1;
        if (paramAnonymousInt1 >= 0)
        {
          if (paramAnonymousInt1 >= GoToPageDialog.this._pages) {
            return;
          }
          GoToPageDialog.this._currentPage = paramAnonymousInt1;
          GoToPageDialog.this._seekBar.setProgress(GoToPageDialog.this._currentPage);
          return;
        }
      }
      catch (Exception paramAnonymousCharSequence) {}
    }
  };
  
  public static GoToPageDialog newInstance(int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("pages", paramInt2);
    localBundle.putInt("currentPage", paramInt1);
    GoToPageDialog localGoToPageDialog = new GoToPageDialog();
    localGoToPageDialog.setArguments(localBundle);
    return localGoToPageDialog;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this._pages = getArguments().getInt("pages");
    this._currentPage = getArguments().getInt("currentPage");
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = getActivity().getLayoutInflater().inflate(R.layout.pdf_go_to_page_dialog, null);
    this._edit = ((EditText)paramBundle.findViewById(R.id.go_to_page_edit));
    this._edit.addTextChangedListener(this._textWatcher);
    this._seekBar = ((SeekBar)paramBundle.findViewById(R.id.go_to_page_seekbar));
    this._seekBar.setMax(this._pages - 1);
    this._seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
    {
      public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean) {}
        do
        {
          return;
          GoToPageDialog.this._currentPage = paramAnonymousInt;
          paramAnonymousSeekBar = Integer.toString(GoToPageDialog.this._currentPage + 1);
        } while (paramAnonymousSeekBar.equalsIgnoreCase(GoToPageDialog.this._edit.getText().toString()));
        GoToPageDialog.this._edit.setText(paramAnonymousSeekBar);
        GoToPageDialog.this._edit.setSelection(0, paramAnonymousSeekBar.length());
      }
      
      public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}
      
      public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar) {}
    });
    ((TextView)paramBundle.findViewById(R.id.go_to_page_static_text)).setText(getString(R.string.pdf_enter_page_number, new Object[] { Integer.valueOf(this._pages) }));
    updateControls();
    ((ZoomButton)paramBundle.findViewById(R.id.go_to_page_button_minus)).setOnClickListener(this._onBackClickListener);
    ((ZoomButton)paramBundle.findViewById(R.id.go_to_page_button_plus)).setOnClickListener(this._onForwardClickListener);
    return new AlertDialog.Builder(getActivity()).setTitle(R.string.pdf_go_to_page).setView(paramBundle).setPositiveButton(R.string.pdf_button_go_to_page, null).setNegativeButton(17039360, null).create();
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    this._edit.removeTextChangedListener(this._textWatcher);
  }
  
  public void onStart()
  {
    super.onStart();
    ((AlertDialog)getDialog()).getButton(-1).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        try
        {
          i = Integer.parseInt(GoToPageDialog.this._edit.getText().toString());
          i -= 1;
        }
        catch (NumberFormatException paramAnonymousView)
        {
          int i;
          for (;;)
          {
            i = 0;
          }
          GoToPageDialog.this.getDialog().dismiss();
          ((DocumentActivity)GoToPageDialog.this.getActivity()).onGoToPage(i);
        }
        if ((i < 0) || (i >= GoToPageDialog.this._pages))
        {
          Toast.makeText(GoToPageDialog.this.getActivity(), "TODO: Invalid page number", 0).show();
          return;
        }
      }
    });
  }
  
  void updateControls()
  {
    String str = "" + (this._currentPage + 1);
    this._edit.setText(str);
    this._edit.setSelection(0, str.length());
    this._seekBar.setProgress(this._currentPage);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/ui/GoToPageDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */