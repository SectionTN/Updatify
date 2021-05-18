package com.updatify.o2nation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.TooltipCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.firebase.FirebaseApp;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PickerActivity extends AppCompatActivity {
    private AppBarLayout _app_bar;
    private CoordinatorLayout _coordinator;
    private Toolbar _toolbar;
    private String activityFontName = "";
    private CollapsingToolbarLayout collapsingtoolbar1;
    private String current_filepath = "";
    private LinearLayout empty_base;
    private ImageView emptyview_img;
    private TextView emptyview_txt1;
    private TextView emptyview_txt2;
    private String extension = "";
    private double f_position = 0.0d;
    private ArrayList<String> file_list = new ArrayList<>();
    private ArrayList<String> file_list_2 = new ArrayList<>();
    private ArrayList<HashMap<String, Object>> file_lm = new ArrayList<>();
    private ImageView imageview1;
    private ImageView imageview3;
    private LinearLayout linear3;
    private LinearLayout linear4;
    private LinearLayout linear5;
    private LinearLayout linear7;
    private LinearLayout linear_d_main;
    private HashMap<String, Object> map_file = new HashMap<>();
    private double n_f = 0.0d;
    private String path_bind = "";
    private RecyclerView recyclerview1;
    private SharedPreferences sharedPref;
    private SwipeRefreshLayout swiperefreshlayout1;
    private TextView textview4;
    private TextView textview8;
    private TextView txt_path;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.updatify.o2nation.PickerActivity */
    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        PickerActivity.super.onCreate(bundle);
        setContentView(R.layout.picker);
        initialize(bundle);
        FirebaseApp.initializeApp(this);
        if (ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") == -1) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 1000);
            return;
        }
        initializeLogic();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        PickerActivity.super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 1000) {
            initializeLogic();
        }
    }

    private void initialize(Bundle bundle) {
        this._app_bar = findViewById(R.id._app_bar);
        this._coordinator = findViewById(R.id._coordinator);
        this._toolbar = findViewById(R.id._toolbar);
        setSupportActionBar(this._toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        this._toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.PickerActivity.1 */

            public void onClick(View view) {
                PickerActivity.this.onBackPressed();
            }
        });
        this.linear_d_main = (LinearLayout) findViewById(R.id.linear_d_main);
        this.collapsingtoolbar1 = findViewById(R.id.collapsingtoolbar1);
        this.linear4 = (LinearLayout) findViewById(R.id.linear4);
        this.swiperefreshlayout1 = findViewById(R.id.swiperefreshlayout1);
        this.empty_base = (LinearLayout) findViewById(R.id.empty_base);
        this.linear3 = (LinearLayout) findViewById(R.id.linear3);
        this.textview8 = (TextView) findViewById(R.id.textview8);
        this.imageview1 = (ImageView) findViewById(R.id.imageview1);
        this.linear5 = (LinearLayout) findViewById(R.id.linear5);
        this.linear7 = (LinearLayout) findViewById(R.id.linear7);
        this.imageview3 = (ImageView) findViewById(R.id.imageview3);
        this.textview4 = (TextView) findViewById(R.id.textview4);
        this.txt_path = (TextView) findViewById(R.id.txt_path);
        this.recyclerview1 = findViewById(R.id.recyclerview1);
        this.emptyview_img = (ImageView) findViewById(R.id.emptyview_img);
        this.emptyview_txt1 = (TextView) findViewById(R.id.emptyview_txt1);
        this.emptyview_txt2 = (TextView) findViewById(R.id.emptyview_txt2);
        this.sharedPref = getSharedPreferences("sharedPref", 0);
        this.linear4.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.PickerActivity.2 */

            public void onClick(View view) {
                if (PickerActivity.this.txt_path.getText().toString().toLowerCase().equals("/storage/emulated/0")) {
                    PickerActivity.this.finish();
                    return;
                }
                PickerActivity.this._go_to(PickerActivity.this.current_filepath.substring(0, (PickerActivity.this.current_filepath.length() - Uri.parse(PickerActivity.this.current_filepath).getLastPathSegment().length()) - 1));
                PickerActivity.this._refresh();
                try {
                    PickerActivity.this.recyclerview1.scrollToPosition((int) PickerActivity.this.f_position);
                } catch (Exception e) {
                }
            }
        });
        this.swiperefreshlayout1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            /* class com.updatify.o2nation.PickerActivity.3 */

            public void onRefresh() {
                PickerActivity.this.swiperefreshlayout1.setRefreshing(false);
                PickerActivity.this._go_to(PickerActivity.this.current_filepath);
                PickerActivity.this._refresh();
            }
        });
        this.imageview1.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.PickerActivity.4 */

            public void onClick(View view) {
                PickerActivity.this.finish();
            }
        });
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.updatify.o2nation.PickerActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void initializeLogic() {
        _LOGIC_FRONTEND();
        _LOGIC_BACKEND();
        _go_to(FileUtil.getExternalStorageDir());
        this.recyclerview1.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerview1.setAdapter(new Recyclerview1Adapter(this.file_lm));
        this.recyclerview1.setHasFixedSize(true);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        PickerActivity.super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (this.txt_path.getText().toString().toLowerCase().equals("/storage/emulated/0")) {
            finish();
            return;
        }
        _go_to(this.current_filepath.substring(0, (this.current_filepath.length() - Uri.parse(this.current_filepath).getLastPathSegment().length()) - 1));
        _refresh();
        try {
            this.recyclerview1.scrollToPosition((int) this.f_position);
        } catch (Exception e) {
        }
    }

    public void onStart() {
        PickerActivity.super.onStart();
        this._app_bar.setExpanded(true, true);
    }

    public void _go_to(String str) {
        if (FileUtil.isDirectory(str)) {
            this.current_filepath = str;
            this.file_list.clear();
            this.file_lm.clear();
            this.file_list_2.clear();
            FileUtil.listDir(str, this.file_list);
            Collections.sort(this.file_list, String.CASE_INSENSITIVE_ORDER);
            this.n_f = 0.0d;
            for (int i = 0; i < this.file_list.size(); i++) {
                if (FileUtil.isDirectory(this.file_list.get((int) this.n_f))) {
                    this.map_file = new HashMap<>();
                    this.map_file.put("type", "Folder");
                    this.map_file.put("name", Uri.parse(this.file_list.get((int) this.n_f)).getLastPathSegment());
                    this.map_file.put("path", this.file_list.get((int) this.n_f));
                    this.file_lm.add(this.map_file);
                } else {
                    this.file_list_2.add(this.file_list.get((int) this.n_f));
                }
                this.n_f += 1.0d;
            }
            this.file_list.clear();
            this.n_f = 0.0d;
            for (int i2 = 0; i2 < this.file_list_2.size(); i2++) {
                _get_extension(this.file_list_2.get((int) this.n_f));
                if (getIntent().getStringExtra("extension").contains(this.extension)) {
                    this.map_file = new HashMap<>();
                    this.map_file.put("type", "Image");
                    this.map_file.put("name", Uri.parse(this.file_list_2.get((int) this.n_f)).getLastPathSegment());
                    this.map_file.put("path", this.file_list_2.get((int) this.n_f));
                    this.file_lm.add(this.map_file);
                }
                this.n_f += 1.0d;
            }
            this.file_list_2.clear();
            this.txt_path.setText(str);
        }
    }

    public void _refresh() {
        this.txt_path.setText(this.current_filepath);
        this.recyclerview1.setAdapter(new Recyclerview1Adapter(this.file_lm));
        if (this.file_lm.size() == 0) {
            this.emptyview_img.setImageResource(R.drawable.empty_inbox_);
            this.emptyview_txt1.setText("Empty directory");
            this.emptyview_txt2.setText("This folder is empty, what a desert.");
            this.swiperefreshlayout1.setVisibility(View.GONE);
            this.empty_base.setVisibility(View.VISIBLE);
            return;
        }
        this.swiperefreshlayout1.setVisibility(View.VISIBLE);
        this.empty_base.setVisibility(View.GONE);
    }

    public void _setImageFromFile(ImageView imageView, String str) {
        Glide.with(this).load(Uri.fromFile(new File(str))).circleCrop().into(imageView);
    }

    public void _get_extension(String str) {
        try {
            this.extension = str.substring(str.lastIndexOf("."), str.length());
        } catch (Exception e) {
            this.extension = "unknown";
        }
        this.extension = this.extension.toLowerCase().trim();
    }

    public void _LOGIC_FRONTEND() {
        this.textview8.getPaint().setShader(new LinearGradient(0.0f, 0.0f, this.textview8.getPaint().measureText("Pick an icon"), this.textview8.getTextSize(), new int[]{Color.parseColor("#006FF2"), Color.parseColor("#00B6EF")}, (float[]) null, Shader.TileMode.CLAMP));
        this.txt_path.setSelected(true);
        getSupportActionBar().hide();
        _changeActivityFont("product");
        this.textview8.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
        this.textview4.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
        this.emptyview_txt1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
        _RippleEffects("#EEEEEE", this.imageview1);
        if (this.sharedPref.getString("dark", "").equals("true")) {
            _NavStatusBarColor("#181818", "#181818");
            _rippleRoundStroke(this.linear5, "#212121", "#212121", 100.0d, 0.0d, "#0071EE");
            _rippleRoundStroke(this.linear4, "#181818", "#212121", 0.0d, 0.0d, "#0071EE");
            _ICC(this.imageview3, "#FFFFFF", "#FFFFFF");
            _ICC(this.imageview1, "#FFFFFF", "#FFFFFF");
            _LIGHT_ICONS();
            this.linear_d_main.setBackgroundColor(-15198184);
            this.linear3.setBackgroundColor(-15198184);
            this.textview4.setTextColor(-1);
            this.emptyview_txt1.setTextColor(-1);
            return;
        }
        _NavStatusBarColor("#FFFFFF", "#FFFFFF");
        _rippleRoundStroke(this.linear5, "#F5F5F5", "#0071EE", 100.0d, 0.0d, "#0071EE");
        _rippleRoundStroke(this.linear4, "#FFFFFF", "#F5F5F5", 0.0d, 0.0d, "#0071EE");
        _ICC(this.imageview3, "#0071EE", "#0071EE");
        _DARK_ICONS();
        this.linear_d_main.setBackgroundColor(-1);
        this.textview4.setTextColor(-14606047);
        this.linear3.setBackgroundColor(-1);
        this.emptyview_txt1.setTextColor(-14606047);
    }

    public void _NavStatusBarColor(String str, String str2) {
        if (Build.VERSION.SDK_INT > 21) {
            Window window = getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(Color.parseColor("#" + str.replace("#", "")));
            window.setNavigationBarColor(Color.parseColor("#" + str2.replace("#", "")));
        }
    }

    public void _DARK_ICONS() {
        getWindow().getDecorView().setSystemUiVisibility(8192);
    }

    public void _LIGHT_ICONS() {
        getWindow().getDecorView().setSystemUiVisibility(0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.updatify.o2nation.PickerActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void _changeActivityFont(String str) {
        this.activityFontName = str.trim();
        if (this.activityFontName.contains(".ttf")) {
            this.activityFontName = this.activityFontName.replace(".ttf", "");
        }
        overrideFonts(this, getWindow().getDecorView());
    }

    private void overrideFonts(Context context, View view) {
        try {
            Typeface createFromAsset = Typeface.createFromAsset(getAssets(), "fonts/" + this.activityFontName + ".ttf");
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    overrideFonts(context, viewGroup.getChildAt(i));
                }
            } else if (view instanceof TextView) {
                ((TextView) view).setTypeface(createFromAsset);
            } else if (view instanceof EditText) {
                ((EditText) view).setTypeface(createFromAsset);
            } else if (view instanceof Switch) {
                ((Switch) view).setTypeface(createFromAsset);
            } else if (view instanceof CheckBox) {
                ((CheckBox) view).setTypeface(createFromAsset);
            } else if (view instanceof Button) {
                ((Button) view).setTypeface(createFromAsset);
            }
        } catch (Exception e) {
            SketchwareUtil.showMessage(getApplicationContext(), e.toString());
        }
    }

    public void _rippleRoundStroke(View view, String str, String str2, double d, double d2, String str3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius((float) d);
        gradientDrawable.setStroke((int) d2, Color.parseColor("#" + str3.replace("#", "")));
        view.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor(str2)}), gradientDrawable, null));
    }

    public void _RoundAndBorder(View view, String str, double d, String str2, double d2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius((float) ((int) d2));
        gradientDrawable.setStroke((int) d, Color.parseColor(str2));
        view.setBackground(gradientDrawable);
    }

    public void _ICC(ImageView imageView, String str, String str2) {
        imageView.setImageTintList(new ColorStateList(new int[][]{new int[]{-16842919}, new int[]{16842919}}, new int[]{Color.parseColor(str), Color.parseColor(str2)}));
    }

    public void _LOGIC_BACKEND() {
        ViewCompat.setNestedScrollingEnabled(this.recyclerview1, true);
        this.swiperefreshlayout1.setVisibility(View.VISIBLE);
        this.empty_base.setVisibility(View.GONE);
        _setToolTip(this.imageview1, "Exit file picker");
    }

    public void _advancedCorners(View view, String str, double d, double d2, double d3, double d4) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadii(new float[]{(float) ((int) d), (float) ((int) d), (float) ((int) d2), (float) ((int) d2), (float) ((int) d4), (float) ((int) d4), (float) ((int) d3), (float) ((int) d3)});
        view.setBackground(gradientDrawable);
    }

    public void _setClippedView(View view, String str, double d, double d2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius((float) ((int) d));
        view.setBackground(gradientDrawable);
        view.setElevation((float) ((int) d2));
        view.setClipToOutline(true);
    }

    public void _RippleEffects(String str, View view) {
        view.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor(str)}), null, null));
    }

    public void _setToolTip(View view, String str) {
        try {
            if (Double.parseDouble(Build.VERSION.SDK) >= 28.0d) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    view.setTooltipText(str);
                }
            } else if (Double.parseDouble(Build.VERSION.SDK) < 28.0d) {
                TooltipCompat.setTooltipText(view, str);
            }
        } catch (Exception ignored) {
        }
    }

    public class Recyclerview1Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        ArrayList<HashMap<String, Object>> _data;


        public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> arrayList) {
            this._data = arrayList;
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(((LayoutInflater) PickerActivity.this.getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE)).inflate(R.layout.apps_base, (ViewGroup) null));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
            View view = viewHolder.itemView;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linear6);
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.linear1);
            LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.pointer);
            LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.linear3);
            LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.linear5);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageview2);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.icon);
            LinearLayout linearLayout6 = (LinearLayout) view.findViewById(R.id.flow);
            TextView textView = (TextView) view.findViewById(R.id.title);
            TextView textView2 = (TextView) view.findViewById(R.id.description);
            view.findViewById(R.id.lottie1);
            imageView.setVisibility(View.GONE);
            ((LinearLayout) view.findViewById(R.id.deletion_view)).setVisibility(View.GONE);
            ((TextView) view.findViewById(R.id.version_name)).setVisibility(View.GONE);
            linearLayout6.setVisibility(View.GONE);
            textView.setTypeface(Typeface.createFromAsset(PickerActivity.this.getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
            textView2.setTypeface(Typeface.createFromAsset(PickerActivity.this.getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
            PickerActivity.this._RoundAndBorder(linearLayout6, "#48000000", 0.0d, "#000000", 100.0d);
            view.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            textView2.setText(this._data.get(i).get("type").toString());
            if (this._data.get(i).get("type").toString().equals("Folder")) {
                Glide.with(PickerActivity.this).load(Integer.valueOf(R.drawable.folder_80px)).circleCrop().into(imageView2);
                PickerActivity.this._advancedCorners(linearLayout3, "#FF9C25", 0.0d, 50.0d, 0.0d, 50.0d);
            } else {
                PickerActivity.this._advancedCorners(linearLayout3, "#007EEF", 0.0d, 50.0d, 0.0d, 50.0d);
                PickerActivity.this.path_bind = this._data.get(i).get("path").toString();
                if (PickerActivity.this.path_bind.endsWith(".gif") || PickerActivity.this.path_bind.endsWith(".png") || PickerActivity.this.path_bind.endsWith(".jpeg") || PickerActivity.this.path_bind.endsWith(".jpg") || PickerActivity.this.path_bind.endsWith(".apng")) {
                    PickerActivity.this._setImageFromFile(imageView2, PickerActivity.this.path_bind);
                } else {
                    imageView2.setImageResource(R.drawable.default_image);
                }
            }
            textView.setText(this._data.get(i).get("name").toString());
            linearLayout2.setOnClickListener(new View.OnClickListener() {
                /* class com.updatify.o2nation.PickerActivity.Recyclerview1Adapter.1 */

                public void onClick(View view) {
                    PickerActivity.this.f_position = (double) i;
                    if (((HashMap) PickerActivity.this.file_lm.get(i)).get("type").toString().equals("Folder")) {
                        PickerActivity.this._go_to(((HashMap) PickerActivity.this.file_lm.get(i)).get("path").toString());
                        PickerActivity.this._refresh();
                        return;
                    }
                    PickerActivity.this.sharedPref.edit().putString("picked_path", ((HashMap) PickerActivity.this.file_lm.get(i)).get("path").toString()).commit();
                    PickerActivity.this.finish();
                }
            });
            if (PickerActivity.this.sharedPref.getString("dark", "").equals("true")) {
                PickerActivity.this._rippleRoundStroke(linearLayout2, "#181818", "#212121", 0.0d, 0.0d, "#0071EE");
                textView.setTextColor(-1);
                return;
            }
            PickerActivity.this._rippleRoundStroke(linearLayout2, "#FFFFFF", "#E0E0E0", 0.0d, 0.0d, "#0071EE");
            textView.setTextColor(-14606047);
        }

        public int getItemCount() {
            return this._data.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public ViewHolder(View view) {
                super(view);
            }
        }
    }
}
