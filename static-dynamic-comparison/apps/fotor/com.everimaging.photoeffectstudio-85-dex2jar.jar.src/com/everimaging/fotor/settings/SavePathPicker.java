package com.everimaging.fotor.settings;

import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.everimaging.fotor.App;
import com.everimaging.fotor.b;
import com.everimaging.fotor.log.LoggerFactory;
import com.everimaging.fotor.log.LoggerFactory.LoggerType;
import com.everimaging.fotor.log.LoggerFactory.c;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SavePathPicker
        extends b
        implements View.OnClickListener, AdapterView.OnItemClickListener {
    private static final String a = SavePathPicker.class.getSimpleName();
    private static final LoggerFactory.c b = LoggerFactory.a(a, LoggerFactory.LoggerType.CONSOLE);
    private Button c;
    private File d;
    private ListView e;
    private a f;
    private TextView g;
    private View h;

    private int a(List<File> paramList, String paramString) {
        int i = 0;
        while (i < paramList.size()) {
            if (((File) paramList.get(i)).getAbsolutePath().equals(paramString)) {
                return i;
            }
            i += 1;
        }
        return -1;
    }

    @SuppressLint({"DefaultLocale"})
    private List<File> a(File paramFile) {
        ArrayList localArrayList = new ArrayList();
        paramFile = paramFile.listFiles();
        if (paramFile != null) {
            int j = paramFile.length;
            int i = 0;
            while (i < j) {
                Object localObject = paramFile[i];
                if ((((File) localObject).isDirectory()) && (!((File) localObject).getName().startsWith("."))) {
                    localArrayList.add(localObject);
                }
                i += 1;
            }
        }
        return localArrayList;
    }

    private void a(File paramFile, boolean paramBoolean) {
        List localList = a(paramFile);
        this.d = paramFile;
        this.g.setText(this.d.getAbsolutePath());
        this.f.a(localList);
        if (this.d.getAbsolutePath().equals(Environment.getExternalStorageDirectory().getParentFile().getAbsolutePath())) {
            this.c.setEnabled(false);
        }
        for (; ; ) {
            if (!paramBoolean) {
                int i = a(localList, App.h());
                if (i >= 0) {
                    this.e.smoothScrollToPosition(i);
                }
            }
            if (localList.size() <= 0) {
                break;
            }
            this.h.setVisibility(8);
            return;
            this.c.setEnabled(true);
        }
        this.h.setVisibility(0);
    }

    public void onClick(View paramView) {
        a(this.d.getParentFile(), true);
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(2130903208);
        this.c = ((Button) findViewById(2131558865));
        this.c.setOnClickListener(this);
        this.e = ((ListView) findViewById(2131558863));
        this.g = ((TextView) findViewById(2131558862));
        this.h = findViewById(2131558864);
        this.d = new File(App.h()).getParentFile();
        if ((this.d == null) || (!this.d.isDirectory())) {
            this.d = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
        }
        this.f = new a();
        this.e.setAdapter(this.f);
        this.e.setOnItemClickListener(this);
        a(this.d, false);
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131755012, paramMenu);
        return true;
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
        a(this.f.a(paramInt), true);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131558932) {
            paramMenuItem = new AlertDialog.Builder(this);
            paramMenuItem.setTitle(17039380);
            paramMenuItem.setMessage(2131296655);
            paramMenuItem.setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                    App.a(App.d);
                    SavePathPicker.a().c(new Object[]{"restore Selected path:" + App.h()});
                    SavePathPicker.a(SavePathPicker.this).notifyDataSetChanged();
                    SavePathPicker.a(SavePathPicker.this, new File(App.d).getParentFile(), false);
                }
            });
            paramMenuItem.setNegativeButton(17039360, null);
            paramMenuItem.show();
            return true;
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    class a
            extends BaseAdapter
            implements View.OnClickListener {
        public List<File> a = new ArrayList();
        private LayoutInflater c = LayoutInflater.from(SavePathPicker.this);

        public a() {
        }

        public File a(int paramInt) {
            return (File) this.a.get(paramInt);
        }

        public void a(List<File> paramList) {
            this.a = paramList;
            notifyDataSetChanged();
        }

        public int getCount() {
            return this.a.size();
        }

        public long getItemId(int paramInt) {
            return paramInt;
        }

        public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
            Object localObject;
            if (paramView == null) {
                paramView = this.c.inflate(2130903209, null);
                localObject = (TextView) paramView.findViewById(2131558866);
                paramViewGroup = new a();
                paramViewGroup.a = ((TextView) localObject);
                paramViewGroup.b = ((ImageButton) paramView.findViewById(2131558867));
                paramView.setTag(paramViewGroup);
            }
            for (; ; ) {
                paramViewGroup.b.setSelected(false);
                paramViewGroup.b.setOnClickListener(this);
                paramViewGroup.b.setTag(Integer.valueOf(paramInt));
                localObject = (File) this.a.get(paramInt);
                if (((File) localObject).getAbsolutePath().equals(App.h())) {
                    paramViewGroup.b.setSelected(true);
                }
                paramViewGroup.a.setText(((File) localObject).getName());
                return paramView;
                paramViewGroup = (a) paramView.getTag();
            }
        }

        public void onClick(View paramView) {
            int i = ((Integer) paramView.getTag()).intValue();
            final File localFile = (File) this.a.get(i);
            if (!paramView.isSelected()) {
                paramView = new AlertDialog.Builder(SavePathPicker.this);
                paramView.setTitle(17039380);
                paramView.setMessage(2131296654);
                paramView.setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                        App.a(localFile.getAbsolutePath());
                        SavePathPicker.a.this.notifyDataSetChanged();
                    }
                });
                paramView.setNegativeButton(17039360, null);
                paramView.show();
            }
        }

        class a {
            TextView a;
            ImageButton b;

            a() {
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/settings/SavePathPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */