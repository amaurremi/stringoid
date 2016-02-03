package com.quoord.tapatalkpro.ics.slidingMenu.login;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.quoord.tapatalkpro.util.Prefs;
import com.quoord.tapatalkpro.util.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Pattern;

public class CustomFieldView {
    public Activity activity;
    private ChoicesAdapter choicesAdapter;
    private int dayOfMonth = 1;
    private int defaultPosition;
    private TextView description;
    public EditText fieldValue;
    private LayoutInflater inflater;
    private LinearLayout info;
    private boolean isMulti = false;
    private int monthOfYear = 1;
    private ArrayList<KeyValue> options = new ArrayList();
    private SharedPreferences prefs;
    public CustomRegisterField registerField;
    private ArrayList<Integer> selectedPositon = new ArrayList();
    private int year = 1970;

    public CustomFieldView(Activity paramActivity, CustomRegisterField paramCustomRegisterField) {
        this.activity = paramActivity;
        this.registerField = paramCustomRegisterField;
        this.prefs = Prefs.get(this.activity);
    }

    private void setValueForMultiField() {
        String str = "";
        int i = 0;
        if (i >= this.selectedPositon.size()) {
            this.fieldValue.setText(str);
            return;
        }
        if (i == this.selectedPositon.size() - 1) {
        }
        for (str = str + ((KeyValue) this.options.get(((Integer) this.selectedPositon.get(i)).intValue())).value; ; str = str + ((KeyValue) this.options.get(((Integer) this.selectedPositon.get(i)).intValue())).value + ",") {
            i += 1;
            break;
        }
    }

    public Dialog createMultiChoiceDialog() {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.activity);
        localBuilder.setAdapter(this.choicesAdapter, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        });
        localBuilder.setPositiveButton(2131100288, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                if (CustomFieldView.this.isMulti) {
                    CustomFieldView.this.setValueForMultiField();
                }
                while (CustomFieldView.this.defaultPosition == -1) {
                    return;
                }
                paramAnonymousDialogInterface = (CustomFieldView.KeyValue) CustomFieldView.this.options.get(CustomFieldView.this.defaultPosition);
                CustomFieldView.this.fieldValue.setText(paramAnonymousDialogInterface.value);
            }
        });
        localBuilder.setNegativeButton(2131100289, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
            }
        });
        return localBuilder.create();
    }

    public HashMap getCBOXHashRequiedField() {
        HashMap localHashMap = new HashMap();
        int i;
        if (this.registerField.type.equalsIgnoreCase("cbox")) {
            i = 0;
        }
        for (; ; ) {
            if (i >= this.registerField.options.length()) {
                return localHashMap;
            }
            if (this.selectedPositon.contains(Integer.valueOf(i))) {
                localHashMap.put(((KeyValue) this.options.get(i)).key, Integer.valueOf(1));
            }
            i += 1;
        }
    }

    public ArrayList<Integer> getDefaultMulPosition() {
        ArrayList localArrayList = new ArrayList();
        String[] arrayOfString;
        int i;
        if ((this.registerField.defaultValue != null) && (!this.registerField.defaultValue.equals(""))) {
            arrayOfString = this.registerField.defaultValue.split("\\|");
            i = 0;
            if (i < arrayOfString.length) {
            }
        } else {
            return localArrayList;
        }
        String str = arrayOfString[i];
        int j = 0;
        for (; ; ) {
            if (j >= this.options.size()) {
                i += 1;
                break;
            }
            if (((KeyValue) this.options.get(j)).key.equalsIgnoreCase(str)) {
                this.defaultPosition = j;
                localArrayList.add(Integer.valueOf(this.defaultPosition));
            }
            j += 1;
        }
    }

    public int getDefaultPosition() {
        int i;
        Object localObject1;
        label80:
        Object localObject2;
        Locale localLocale;
        if ((this.registerField.defaultValue != null) && (!this.registerField.defaultValue.equals(""))) {
            i = 0;
            if (i < this.options.size()) {
            }
        } else {
            if (this.registerField.name.equalsIgnoreCase("gender")) {
                localObject1 = this.prefs.getString("tapatalk_gender", "");
                if (!((String) localObject1).equals("")) {
                    i = 0;
                    if (i < this.options.size()) {
                        break label246;
                    }
                }
            }
            if (this.registerField.name.equalsIgnoreCase("Country")) {
                localObject2 = this.prefs.getString("tapatalk_locale", "");
                localObject1 = localObject2;
                if (!((String) localObject2).equals("")) {
                    localObject1 = localObject2;
                    if (((String) localObject2).contains("_")) {
                        localObject1 = ((String) localObject2).substring(((String) localObject2).indexOf("_") + 1, ((String) localObject2).length());
                    }
                }
                localLocale = this.activity.getResources().getConfiguration().locale;
                localObject2 = localObject1;
                if (((String) localObject1).equals("")) {
                    localObject2 = localLocale.getCountry();
                }
                i = 0;
            }
        }
        for (; ; ) {
            if (i >= this.options.size()) {
                return -1;
                if (((KeyValue) this.options.get(i)).key.equalsIgnoreCase(this.registerField.defaultValue)) {
                    return i;
                }
                i += 1;
                break;
                label246:
                if ((((KeyValue) this.options.get(i)).key.equalsIgnoreCase((String) localObject1)) || (((KeyValue) this.options.get(i)).value.equalsIgnoreCase((String) localObject1))) {
                    return i;
                }
                i += 1;
                break label80;
            }
            if ((((KeyValue) this.options.get(i)).key.equalsIgnoreCase((String) localObject2)) || (((KeyValue) this.options.get(i)).value.equalsIgnoreCase((String) localObject2)) || (((KeyValue) this.options.get(i)).value.equalsIgnoreCase(localLocale.getDisplayCountry()))) {
                return i;
            }
            i += 1;
        }
    }

    public View getRequiedView() {
        this.inflater = this.activity.getLayoutInflater();
        RelativeLayout localRelativeLayout = (RelativeLayout) this.inflater.inflate(2130903345, null);
        Object localObject1 = (TextView) localRelativeLayout.findViewById(2131231577);
        this.fieldValue = ((EditText) localRelativeLayout.findViewById(2131231578));
        this.description = ((TextView) localRelativeLayout.findViewById(2131230993));
        this.info = ((LinearLayout) localRelativeLayout.findViewById(2131231579));
        Object localObject3;
        Object localObject2;
        label504:
        label541:
        int i;
        if ((this.registerField.description != null) && (!this.registerField.description.equals(""))) {
            this.fieldValue.setCompoundDrawables(null, null, this.activity.getResources().getDrawable(2130839017), null);
            this.description.setText(this.registerField.description);
            this.info.setVisibility(0);
            ((TextView) localObject1).setText(this.registerField.name);
            this.info.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    if (CustomFieldView.this.description.getVisibility() == 8) {
                        CustomFieldView.this.description.setVisibility(0);
                        return;
                    }
                    CustomFieldView.this.description.setVisibility(8);
                }
            });
            if (this.registerField.name.equalsIgnoreCase("Birthday")) {
                localObject3 = this.prefs.getString("tapatalk_birthday", "");
                if (!((String) localObject3).equals("")) {
                    localObject1 = ((String) localObject3).split("-");
                    if (localObject1.length == 3) {
                        this.year = Integer.valueOf(localObject1[0]).intValue();
                        this.monthOfYear = (Integer.valueOf(localObject1[1]).intValue() - 1);
                        this.dayOfMonth = Integer.valueOf(localObject1[2]).intValue();
                    }
                }
                localObject2 = "";
                localObject1 = localObject2;
                if (this.registerField.format != null) {
                    localObject1 = localObject2;
                    if (!this.registerField.format.equals("")) {
                        if (!this.registerField.format.equals("nnnn-nn-nn")) {
                            localObject1 = localObject2;
                            if (!this.registerField.format.equals("nnnn/nn/nn")) {
                            }
                        } else {
                            localObject1 = "\\d{4}-\\d{2}-\\d{2}";
                        }
                        if ((this.registerField.format.equals("nn-nn-nnnn")) || (this.registerField.format.equals("nn/nn/nnnn"))) {
                            localObject1 = "\\d{2}-\\d{2}-\\d{4}";
                        }
                    }
                }
                if (Pattern.matches((String) localObject1, (CharSequence) localObject3)) {
                    if ((this.registerField.format.equals("nnnn-nn-nn")) || (this.registerField.format.equals("nnnn/nn/nn"))) {
                        this.fieldValue.setText((CharSequence) localObject3);
                    }
                    if ((this.registerField.format.equals("nn-nn-nnnn")) || (this.registerField.format.equals("nn/nn/nnnn"))) {
                        if (this.monthOfYear >= 10) {
                            break label900;
                        }
                        localObject1 = "" + "0" + this.monthOfYear;
                        if (this.dayOfMonth >= 10) {
                            break label926;
                        }
                        localObject1 = localObject1 + "-0" + this.dayOfMonth;
                        new StringBuilder(String.valueOf(localObject1)).append("-").append(this.year).toString();
                        this.fieldValue.setText((CharSequence) localObject3);
                    }
                }
                this.fieldValue.setInputType(0);
                this.fieldValue.setClickable(true);
                this.fieldValue.setFocusable(false);
                this.fieldValue.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        new DatePickerDialog(CustomFieldView.this.activity, new DatePickerDialog.OnDateSetListener() {
                            public void onDateSet(DatePicker paramAnonymous2DatePicker, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3) {
                                if (paramAnonymous2Int2 + 1 < 10) {
                                    paramAnonymous2DatePicker = "" + "0" + (paramAnonymous2Int2 + 1);
                                    if (paramAnonymous2Int3 >= 10) {
                                        break label363;
                                    }
                                }
                                label363:
                                for (String str = "" + "0" + paramAnonymous2Int3; ; str = "" + paramAnonymous2Int3) {
                                    if (CustomFieldView.this.registerField.format.equals("nnnn-nn-nn")) {
                                        CustomFieldView.this.fieldValue.setText(paramAnonymous2Int1 + "-" + paramAnonymous2DatePicker + "-" + str);
                                    }
                                    if (CustomFieldView.this.registerField.format.equals("nnnn/nn/nn")) {
                                        CustomFieldView.this.fieldValue.setText(paramAnonymous2Int1 + "/" + paramAnonymous2DatePicker + "/" + str);
                                    }
                                    if (CustomFieldView.this.registerField.format.equals("nn-nn-nnnn")) {
                                        CustomFieldView.this.fieldValue.setText(paramAnonymous2DatePicker + "-" + str + "-" + paramAnonymous2Int1);
                                    }
                                    if (CustomFieldView.this.registerField.format.equals("nn/nn/nnnn")) {
                                        CustomFieldView.this.fieldValue.setText(paramAnonymous2DatePicker + "/" + str + "/" + paramAnonymous2Int1);
                                    }
                                    return;
                                    paramAnonymous2DatePicker = "" + (paramAnonymous2Int2 + 1);
                                    break;
                                }
                            }
                        }, CustomFieldView.this.year, CustomFieldView.this.monthOfYear, CustomFieldView.this.dayOfMonth).show();
                    }
                });
            }
            if ((this.registerField.type != null) && ((this.registerField.type.equalsIgnoreCase("radio")) || (this.registerField.type.equalsIgnoreCase("cbox")) || (this.registerField.type.equalsIgnoreCase("drop")))) {
                if (this.registerField.options != null) {
                    localObject1 = this.registerField.options.split("\\|");
                    i = 0;
                    label699:
                    if (i < localObject1.length) {
                        break label957;
                    }
                }
                this.fieldValue.setInputType(0);
                this.fieldValue.setClickable(true);
                this.fieldValue.setFocusable(false);
                this.fieldValue.setHint(this.activity.getString(2131100935));
                if (!this.registerField.type.equalsIgnoreCase("cbox")) {
                    break label1040;
                }
                localObject1 = getDefaultMulPosition();
                if (((ArrayList) localObject1).size() != 0) {
                    break label1016;
                }
                this.choicesAdapter = new ChoicesAdapter(this.options);
            }
        }
        for (; ; ) {
            this.fieldValue.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    Util.hideSoftKeyb(CustomFieldView.this.activity, CustomFieldView.this.fieldValue);
                    CustomFieldView.this.fieldValue.requestFocus();
                    CustomFieldView.this.createMultiChoiceDialog().show();
                }
            });
            if ((this.registerField.type != null) && ((this.registerField.type.equals("input")) || (this.registerField.type.equals("textarea"))) && (this.registerField.defaultValue != null) && (!this.registerField.defaultValue.equals(""))) {
                this.fieldValue.setText(this.registerField.defaultValue);
            }
            return localRelativeLayout;
            this.info.setVisibility(8);
            break;
            label900:
            localObject1 = "" + this.monthOfYear;
            break label504;
            label926:
            localObject1 = localObject1 + "-" + this.dayOfMonth;
            break label541;
            label957:
            localObject2 = localObject1[i].split("=");
            if (localObject2.length >= 2) {
                localObject3 = new KeyValue();
                ((KeyValue) localObject3).key = localObject2[0];
                ((KeyValue) localObject3).value = localObject2[1];
                this.options.add(localObject3);
            }
            i += 1;
            break label699;
            label1016:
            this.choicesAdapter = new ChoicesAdapter(this.options, (ArrayList) localObject1);
            setValueForMultiField();
            continue;
            label1040:
            i = getDefaultPosition();
            this.choicesAdapter = new ChoicesAdapter(this.options, i);
            if (i != -1) {
                this.fieldValue.setText(((KeyValue) this.options.get(i)).value);
            }
        }
    }

    public String getSingleCheckRequiedField() {
        return ((KeyValue) this.options.get(this.defaultPosition)).key;
    }

    public class ChoicesAdapter
            extends BaseAdapter {
        private ArrayList<CustomFieldView.KeyValue> allItems;

        public ChoicesAdapter() {
            ArrayList localArrayList;
            this.allItems = localArrayList;
            CustomFieldView.this.isMulti = true;
        }

        public ChoicesAdapter(int paramInt) {
            this.allItems = paramInt;
            int i;
            CustomFieldView.this.defaultPosition = i;
            CustomFieldView.this.isMulti = false;
        }

        public ChoicesAdapter(ArrayList<Integer> paramArrayList) {
            this.allItems = paramArrayList;
            ArrayList localArrayList;
            CustomFieldView.this.selectedPositon = localArrayList;
            CustomFieldView.this.isMulti = true;
        }

        public int getCount() {
            return this.allItems.size();
        }

        public Object getItem(int paramInt) {
            return this.allItems.get(paramInt);
        }

        public long getItemId(int paramInt) {
            return 0L;
        }

        public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup) {
            if (paramView == null) {
                paramViewGroup = new CustomFieldView.ViewHolder(CustomFieldView.this, null);
                paramView = CustomFieldView.this.inflater.inflate(2130903344, null);
                paramViewGroup.ckbox = ((CheckBox) paramView.findViewById(2131231006));
                paramViewGroup.title = ((TextView) paramView.findViewById(2131230769));
                paramViewGroup.radio = ((RadioButton) paramView.findViewById(2131231576));
                paramView.setTag(paramViewGroup);
                if (!CustomFieldView.this.isMulti) {
                    break label218;
                }
                paramViewGroup.ckbox.setVisibility(0);
                paramViewGroup.radio.setVisibility(8);
                if (!CustomFieldView.this.selectedPositon.contains(Integer.valueOf(paramInt))) {
                    break label207;
                }
                paramViewGroup.ckbox.setChecked(true);
            }
            for (; ; ) {
                paramView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        if (CustomFieldView.this.isMulti) {
                            if (!CustomFieldView.this.selectedPositon.contains(Integer.valueOf(paramInt))) {
                                CustomFieldView.this.selectedPositon.add(Integer.valueOf(paramInt));
                            }
                        }
                        for (; ; ) {
                            CustomFieldView.ChoicesAdapter.this.notifyDataSetChanged();
                            return;
                            CustomFieldView.this.selectedPositon.remove(Integer.valueOf(paramInt));
                            continue;
                            CustomFieldView.this.defaultPosition = paramInt;
                        }
                    }
                });
                paramViewGroup.radio.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        CustomFieldView.this.defaultPosition = paramInt;
                        CustomFieldView.ChoicesAdapter.this.notifyDataSetChanged();
                    }
                });
                paramViewGroup.ckbox.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        if (CustomFieldView.this.selectedPositon.contains(Integer.valueOf(paramInt))) {
                            CustomFieldView.this.selectedPositon.remove(Integer.valueOf(paramInt));
                            return;
                        }
                        CustomFieldView.this.selectedPositon.add(Integer.valueOf(paramInt));
                    }
                });
                CustomFieldView.KeyValue localKeyValue = (CustomFieldView.KeyValue) getItem(paramInt);
                paramViewGroup.title.setText(localKeyValue.value);
                return paramView;
                paramViewGroup = (CustomFieldView.ViewHolder) paramView.getTag();
                break;
                label207:
                paramViewGroup.ckbox.setChecked(false);
                continue;
                label218:
                paramViewGroup.ckbox.setVisibility(8);
                paramViewGroup.radio.setVisibility(0);
                if (CustomFieldView.this.defaultPosition == paramInt) {
                    paramViewGroup.radio.setChecked(true);
                } else {
                    paramViewGroup.radio.setChecked(false);
                }
            }
        }
    }

    public class KeyValue {
        public String key;
        public String value;

        public KeyValue() {
        }
    }

    private class ViewHolder {
        public CheckBox ckbox;
        public RadioButton radio;
        public TextView title;

        private ViewHolder() {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ics/slidingMenu/login/CustomFieldView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */