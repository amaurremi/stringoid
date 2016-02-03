package com.uservoice.uservoicesdk.ui;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.uservoice.uservoicesdk.Config;
import com.uservoice.uservoicesdk.R.id;
import com.uservoice.uservoicesdk.R.layout;
import com.uservoice.uservoicesdk.R.string;
import com.uservoice.uservoicesdk.Session;
import com.uservoice.uservoicesdk.babayaga.Babayaga;
import com.uservoice.uservoicesdk.babayaga.Babayaga.Event;
import com.uservoice.uservoicesdk.model.ClientConfig;
import com.uservoice.uservoicesdk.model.CustomField;
import com.uservoice.uservoicesdk.model.Ticket;
import com.uservoice.uservoicesdk.rest.RestResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ContactAdapter
        extends InstantAnswersAdapter {
    private int CUSTOM_PREDEFINED_FIELD = 9;
    private int CUSTOM_TEXT_FIELD = 8;
    private Map<String, String> customFieldValues = new HashMap(Session.getInstance().getConfig().getCustomFields());

    public ContactAdapter(FragmentActivity paramFragmentActivity) {
        super(paramFragmentActivity);
        this.continueButtonMessage = R.string.uv_contact_continue_button;
    }

    private boolean validateCustomFields() {
        Iterator localIterator = Session.getInstance().getClientConfig().getCustomFields().iterator();
        while (localIterator.hasNext()) {
            Object localObject = (CustomField) localIterator.next();
            if (((CustomField) localObject).isRequired()) {
                localObject = (String) this.customFieldValues.get(((CustomField) localObject).getName());
                if ((localObject == null) || (((String) localObject).length() == 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    protected void doSubmit() {
        if (validateCustomFields()) {
            Ticket.createTicket(this.textField.getText().toString(), this.emailField.getText().toString(), this.nameField.getText().toString(), this.customFieldValues, new DefaultCallback(this.context) {
                public void onError(RestResult paramAnonymousRestResult) {
                    ContactAdapter.this.isPosting = false;
                    super.onError(paramAnonymousRestResult);
                }

                public void onModel(Ticket paramAnonymousTicket) {
                    Babayaga.track(Babayaga.Event.SUBMIT_TICKET);
                    Toast.makeText(ContactAdapter.this.context, R.string.uv_msg_ticket_created, 0).show();
                    ContactAdapter.this.context.finish();
                }
            });
            return;
        }
        this.isPosting = false;
        Toast.makeText(this.context, R.string.uv_msg_custom_fields_validation, 0).show();
    }

    protected List<Integer> getDetailRows() {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(Arrays.asList(new Integer[]{Integer.valueOf(this.EMAIL_FIELD), Integer.valueOf(this.NAME_FIELD), Integer.valueOf(this.SPACE)}));
        Iterator localIterator = Session.getInstance().getClientConfig().getCustomFields().iterator();
        while (localIterator.hasNext()) {
            if (((CustomField) localIterator.next()).isPredefined()) {
                localArrayList.add(Integer.valueOf(this.CUSTOM_PREDEFINED_FIELD));
            } else {
                localArrayList.add(Integer.valueOf(this.CUSTOM_TEXT_FIELD));
            }
        }
        return localArrayList;
    }

    public Object getItem(int paramInt) {
        int i = getItemViewType(paramInt);
        if ((i == this.CUSTOM_PREDEFINED_FIELD) || (i == this.CUSTOM_TEXT_FIELD)) {
            List localList = getRows();
            if (localList.contains(Integer.valueOf(this.CUSTOM_PREDEFINED_FIELD))) {
                i = localList.indexOf(Integer.valueOf(this.CUSTOM_PREDEFINED_FIELD));
                if (!localList.contains(Integer.valueOf(this.CUSTOM_TEXT_FIELD))) {
                    break label127;
                }
            }
            label127:
            for (int j = localList.indexOf(Integer.valueOf(this.CUSTOM_TEXT_FIELD)); ; j = localList.size()) {
                i = Math.min(i, j);
                return Session.getInstance().getClientConfig().getCustomFields().get(paramInt - i);
                i = localList.size();
                break;
            }
        }
        return super.getItem(paramInt);
    }

    protected String getSubmitString() {
        return this.context.getString(R.string.uv_send_message);
    }

    public View getView(int paramInt, final View paramView, final ViewGroup paramViewGroup) {
        int i = getItemViewType(paramInt);
        View localView = paramView;
        final Object localObject;
        if (paramView == null) {
            if (i == this.CUSTOM_TEXT_FIELD) {
                localView = this.inflater.inflate(R.layout.uv_text_field_item, null);
            }
        } else {
            if (i != this.CUSTOM_TEXT_FIELD) {
                break label177;
            }
            paramView = (TextView) localView.findViewById(R.id.uv_header_text);
            paramViewGroup = (EditText) localView.findViewById(R.id.uv_text_field);
            localObject = (CustomField) getItem(paramInt);
            String str = (String) this.customFieldValues.get(((CustomField) localObject).getName());
            paramView.setText(((CustomField) localObject).getName());
            paramViewGroup.setHint(R.string.uv_value);
            paramViewGroup.setInputType(64);
            paramViewGroup.setText(str);
            paramViewGroup.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean) {
                    if (!paramAnonymousBoolean) {
                        ContactAdapter.this.customFieldValues.put(localObject.getName(), paramViewGroup.getText().toString());
                    }
                }
            });
        }
        label177:
        do {
            return localView;
            if (i == this.CUSTOM_PREDEFINED_FIELD) {
                localView = this.inflater.inflate(R.layout.uv_select_field_item, null);
                break;
            }
            return super.getView(paramInt, paramView, paramViewGroup);
            if (i != this.CUSTOM_PREDEFINED_FIELD) {
                break label314;
            }
            paramView = (CustomField) getItem(paramInt);
            paramViewGroup = (String) this.customFieldValues.get(paramView.getName());
            ((TextView) localView.findViewById(R.id.uv_header_text)).setText(paramView.getName());
            localObject = (Spinner) localView.findViewById(R.id.uv_select_field);
            ((Spinner) localObject).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
                    paramAnonymousView = ContactAdapter.this.customFieldValues;
                    String str = paramView.getName();
                    if (paramAnonymousInt == 0) {
                    }
                    for (paramAnonymousAdapterView = null; ; paramAnonymousAdapterView = (String) paramView.getPredefinedValues().get(paramAnonymousInt - 1)) {
                        paramAnonymousView.put(str, paramAnonymousAdapterView);
                        return;
                    }
                }

                public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {
                }
            });
            ((Spinner) localObject).setAdapter(new SpinnerAdapter(this.context, paramView.getPredefinedValues()));
        } while ((paramViewGroup == null) || (!paramView.getPredefinedValues().contains(paramViewGroup)));
        ((Spinner) localObject).setSelection(paramView.getPredefinedValues().indexOf(paramViewGroup) + 1);
        return localView;
        label314:
        return super.getView(paramInt, localView, paramViewGroup);
    }

    public int getViewTypeCount() {
        return super.getViewTypeCount() + 2;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/uservoice/uservoicesdk/ui/ContactAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */