package com.updatify.o2nation;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.TooltipCompat;

import com.bumptech.glide.Glide;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.github.naz013.colorslider.ColorSlider;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseApp;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

public class EditorActivity extends AppCompatActivity {
    View _inflate;
    Snackbar.SnackbarLayout _sblayout;
    Snackbar _snackBarView;
    private String accentColor = "";
    private String activityFontName = "";
    private LinearLayout ads_back;
    private String backColor = "";
    private LinearLayout base;
    private String buttonTextColor = "";
    private String clipdata = "";
    private EditText edittext3;
    private EditText edittext4;
    private EditText edittext5;
    private EditText edittext6;
    private EditText enter_round_color;
    private AdView fbBanner;
    private InterstitialAd fbInterstitial;
    private boolean ifAdShown = false;
    private ImageView imageview1;
    private ImageView imageview2;
    private ImageView imageview43;
    private ImageView imageview44;
    private ImageView imageview54;
    private ImageView imageview57;
    private ImageView imageview58;
    private ImageView imageview59;
    private ImageView imageview60;
    private ImageView imageview61;
    private boolean isAdmobAvailable = false;
    private LinearLayout layout1;
    private LinearLayout linear10;
    private LinearLayout linear15;
    private LinearLayout linear16;
    private LinearLayout linear17;
    private LinearLayout linear18;
    private LinearLayout linear19;
    private LinearLayout linear21;
    private LinearLayout linear22;
    private LinearLayout linear23;
    private LinearLayout linear24;
    private LinearLayout linear25;
    private LinearLayout linear26;
    private LinearLayout linear27;
    private LinearLayout linear6;
    private LinearLayout linear8;
    private LinearLayout linear9;
    private double loadAdsLimit = 0.0d;
    private String mainTextColor = "";
    private LinearLayout save_holder;
    private LinearLayout seek1back;
    private SeekBar seekbar4;
    private SharedPreferences sharedPref;
    private SharedPreferences sharedPref2;
    private TextView textview1;
    private TextView textview3;
    private TextView textview4;
    private TextView textview44;
    private TextView textview45;
    private TextView textview46;
    private TextView textview5;
    private TextView textview50;
    private TextView textview51;
    private TextView textview52;
    private TextView textview53;
    private TextView textview54;
    private TextView textview55;
    private TextView textview6;
    private LinearLayout trash;
    private LinearLayout viewpagerback;
    private ScrollView vscroll6;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.updatify.o2nation.EditorActivity */
    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        EditorActivity.super.onCreate(bundle);
        setContentView(R.layout.editor);
        initialize(bundle);
        FirebaseApp.initializeApp(this);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this.linear23 = (LinearLayout) findViewById(R.id.linear23);
        this.linear24 = (LinearLayout) findViewById(R.id.linear24);
        this.linear21 = (LinearLayout) findViewById(R.id.linear21);
        this.save_holder = (LinearLayout) findViewById(R.id.save_holder);
        this.ads_back = (LinearLayout) findViewById(R.id.ads_back);
        this.imageview1 = (ImageView) findViewById(R.id.imageview1);
        this.linear6 = (LinearLayout) findViewById(R.id.linear6);
        this.imageview60 = (ImageView) findViewById(R.id.imageview60);
        this.textview1 = (TextView) findViewById(R.id.textview1);
        this.vscroll6 = (ScrollView) findViewById(R.id.vscroll6);
        this.linear22 = (LinearLayout) findViewById(R.id.linear22);
        this.linear8 = (LinearLayout) findViewById(R.id.linear8);
        this.linear26 = (LinearLayout) findViewById(R.id.linear26);
        this.linear15 = (LinearLayout) findViewById(R.id.linear15);
        this.linear27 = (LinearLayout) findViewById(R.id.linear27);
        this.viewpagerback = (LinearLayout) findViewById(R.id.viewpagerback);
        this.base = (LinearLayout) findViewById(R.id.base);
        this.trash = (LinearLayout) findViewById(R.id.trash);
        this.layout1 = (LinearLayout) findViewById(R.id.layout1);
        this.linear10 = (LinearLayout) findViewById(R.id.linear10);
        this.linear9 = (LinearLayout) findViewById(R.id.linear9);
        this.imageview2 = (ImageView) findViewById(R.id.imageview2);
        this.textview3 = (TextView) findViewById(R.id.textview3);
        this.textview4 = (TextView) findViewById(R.id.textview4);
        this.textview5 = (TextView) findViewById(R.id.textview5);
        this.textview6 = (TextView) findViewById(R.id.textview6);
        this.textview45 = (TextView) findViewById(R.id.textview45);
        this.seek1back = (LinearLayout) findViewById(R.id.seek1back);
        this.textview55 = (TextView) findViewById(R.id.textview55);
        this.linear25 = (LinearLayout) findViewById(R.id.linear25);
        this.textview46 = (TextView) findViewById(R.id.textview46);
        this.linear16 = (LinearLayout) findViewById(R.id.linear16);
        this.textview50 = (TextView) findViewById(R.id.textview50);
        this.linear17 = (LinearLayout) findViewById(R.id.linear17);
        this.textview52 = (TextView) findViewById(R.id.textview52);
        this.linear18 = (LinearLayout) findViewById(R.id.linear18);
        this.textview53 = (TextView) findViewById(R.id.textview53);
        this.linear19 = (LinearLayout) findViewById(R.id.linear19);
        this.textview51 = (TextView) findViewById(R.id.textview51);
        this.imageview43 = (ImageView) findViewById(R.id.imageview43);
        this.seekbar4 = (SeekBar) findViewById(R.id.seekbar4);
        this.textview44 = (TextView) findViewById(R.id.textview44);
        this.imageview44 = (ImageView) findViewById(R.id.imageview44);
        this.edittext6 = (EditText) findViewById(R.id.edittext6);
        this.imageview61 = (ImageView) findViewById(R.id.imageview61);
        this.enter_round_color = (EditText) findViewById(R.id.enter_round_color);
        this.imageview54 = (ImageView) findViewById(R.id.imageview54);
        this.edittext3 = (EditText) findViewById(R.id.edittext3);
        this.imageview57 = (ImageView) findViewById(R.id.imageview57);
        this.edittext4 = (EditText) findViewById(R.id.edittext4);
        this.imageview58 = (ImageView) findViewById(R.id.imageview58);
        this.edittext5 = (EditText) findViewById(R.id.edittext5);
        this.imageview59 = (ImageView) findViewById(R.id.imageview59);
        this.textview54 = (TextView) findViewById(R.id.textview54);
        this.sharedPref = getSharedPreferences("UpdatifyFiles", 0);
        this.sharedPref2 = getSharedPreferences("sharedPref", 0);
        this.imageview1.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.EditorActivity.1 */

            public void onClick(View view) {
                EditorActivity.this.finish();
            }
        });
        this.textview5.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.EditorActivity.2 */

            public void onClick(View view) {
            }
        });
        this.textview6.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.EditorActivity.3 */

            public void onClick(View view) {
            }
        });
        this.imageview43.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.EditorActivity.4 */

            public void onClick(View view) {
                EditorActivity.this.seekbar4.setProgress(EditorActivity.this.seekbar4.getProgress() - 1);
            }
        });
        this.seekbar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            /* class com.updatify.o2nation.EditorActivity.5 */

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                try {
                    EditorActivity.this._setBgCorners(EditorActivity.this.linear9, (double) i, EditorActivity.this.backColor);
                    EditorActivity.this._rippleRoundStroke(EditorActivity.this.textview5, EditorActivity.this.backColor, "#EEEEEE", (double) EditorActivity.this.seekbar4.getProgress(), 0.0d, "#FFFFFF");
                    EditorActivity.this._rippleRoundStroke(EditorActivity.this.textview6, EditorActivity.this.accentColor, "#EEEEEE", (double) EditorActivity.this.seekbar4.getProgress(), 0.0d, "#FFFFFF");
                    EditorActivity.this.textview44.setText(String.valueOf((long) i));
                } catch (Exception e) {
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                EditorActivity.this._RoundAndBorder(EditorActivity.this.seek1back, "#00007EED", 3.0d, "#FF007EED", 10.0d);
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                EditorActivity.this._RoundAndBorder(EditorActivity.this.seek1back, "#00000000", 3.0d, "#E0E0E0", 10.0d);
            }
        });
        this.imageview44.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.EditorActivity.6 */

            public void onClick(View view) {
                EditorActivity.this.seekbar4.setProgress(EditorActivity.this.seekbar4.getProgress() + 1);
            }
        });
        this.edittext6.addTextChangedListener(new TextWatcher() {
            /* class com.updatify.o2nation.EditorActivity.7 */

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                String charSequence2 = charSequence.toString();
                if (charSequence2.equals("")) {
                    EditorActivity.this.imageview2.setImageResource(R.drawable.icons_1);
                    EditorActivity.this._setImageViewRipple(EditorActivity.this.imageview2, "#FFFFFF", "#FFFFFF");
                    return;
                }
                try {
                    Glide.with(EditorActivity.this.getApplicationContext()).load(Uri.parse(charSequence2)).into(EditorActivity.this.imageview2);
                } catch (Exception e) {
                    EditorActivity.this._Snackbar_API("Invalid icon link", "", "long");
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
            }
        });
        this.imageview61.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.EditorActivity.8 */

            public void onClick(View view) {
                EditorActivity.this._getClipboardData(EditorActivity.this.edittext6);
            }
        });
        this.enter_round_color.addTextChangedListener(new TextWatcher() {
            /* class com.updatify.o2nation.EditorActivity.9 */

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                String charSequence2 = charSequence.toString();
                try {
                    if (charSequence2.trim().length() != 7) {
                        return;
                    }
                    if (charSequence2.trim().contains("#")) {
                        EditorActivity.this.backColor = charSequence2.trim();
                        EditorActivity.this._setBgCorners(EditorActivity.this.linear9, (double) EditorActivity.this.seekbar4.getProgress(), EditorActivity.this.backColor);
                        EditorActivity.this._rippleRoundStroke(EditorActivity.this.textview5, EditorActivity.this.backColor, "#EEEEEE", (double) EditorActivity.this.seekbar4.getProgress(), 0.0d, "#FFFFFF");
                        return;
                    }
                    SketchwareUtil.showMessage(EditorActivity.this.getApplicationContext(), "\"#\" symbol is required");
                } catch (Exception e) {
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
            }
        });
        this.imageview54.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.EditorActivity.10 */

            public void onClick(View view) {
                EditorActivity.this._showColorPicker(EditorActivity.this.imageview54, EditorActivity.this.enter_round_color);
            }
        });
        this.edittext3.addTextChangedListener(new TextWatcher() {
            /* class com.updatify.o2nation.EditorActivity.11 */

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                String charSequence2 = charSequence.toString();
                try {
                    if (charSequence2.trim().length() != 7) {
                        return;
                    }
                    if (charSequence2.trim().contains("#")) {
                        EditorActivity.this.accentColor = charSequence2.trim();
                        EditorActivity.this._rippleRoundStroke(EditorActivity.this.textview6, EditorActivity.this.accentColor, "#EEEEEE", (double) EditorActivity.this.seekbar4.getProgress(), 0.0d, "#FFFFFF");
                        EditorActivity.this._setBgCorners(EditorActivity.this.linear10, 120.0d, EditorActivity.this.accentColor);
                        return;
                    }
                    SketchwareUtil.showMessage(EditorActivity.this.getApplicationContext(), "\"#\" symbol is required");
                } catch (Exception e) {
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
            }
        });
        this.imageview57.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.EditorActivity.12 */

            public void onClick(View view) {
                EditorActivity.this._showColorPicker(EditorActivity.this.imageview57, EditorActivity.this.edittext3);
            }
        });
        this.edittext4.addTextChangedListener(new TextWatcher() {
            /* class com.updatify.o2nation.EditorActivity.13 */

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                String charSequence2 = charSequence.toString();
                try {
                    if (charSequence2.trim().length() != 7) {
                        return;
                    }
                    if (charSequence2.trim().contains("#")) {
                        EditorActivity.this.mainTextColor = charSequence2.trim();
                        EditorActivity.this._setTextColor(EditorActivity.this.textview3, EditorActivity.this.mainTextColor);
                        EditorActivity.this._setTextColor(EditorActivity.this.textview4, EditorActivity.this.mainTextColor);
                        EditorActivity.this._setTextColor(EditorActivity.this.textview5, EditorActivity.this.mainTextColor);
                        return;
                    }
                    SketchwareUtil.showMessage(EditorActivity.this.getApplicationContext(), "\"#\" symbol is required");
                } catch (Exception e) {
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
            }
        });
        this.imageview58.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.EditorActivity.14 */

            public void onClick(View view) {
                EditorActivity.this._showColorPicker(EditorActivity.this.imageview58, EditorActivity.this.edittext4);
            }
        });
        this.edittext5.addTextChangedListener(new TextWatcher() {
            /* class com.updatify.o2nation.EditorActivity.15 */

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                String charSequence2 = charSequence.toString();
                try {
                    if (charSequence2.trim().length() != 7) {
                        return;
                    }
                    if (charSequence2.trim().contains("#")) {
                        EditorActivity.this.buttonTextColor = charSequence2.trim();
                        EditorActivity.this._setTextColor(EditorActivity.this.textview6, EditorActivity.this.buttonTextColor);
                        return;
                    }
                    SketchwareUtil.showMessage(EditorActivity.this.getApplicationContext(), "\"#\" symbol is required");
                } catch (Exception e) {
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
            }
        });
        this.imageview59.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.EditorActivity.16 */

            public void onClick(View view) {
                EditorActivity.this._showColorPicker(EditorActivity.this.imageview59, EditorActivity.this.edittext5);
            }
        });
        this.textview54.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.EditorActivity.17 */

            public void onClick(View view) {
                EditorActivity.this.sharedPref.edit().putString("customDialog", "true").commit();
                EditorActivity.this.sharedPref.edit().putString("customDialogRound", EditorActivity.this.textview44.getText().toString()).commit();
                if (!EditorActivity.this.enter_round_color.getText().toString().trim().equals("")) {
                    EditorActivity.this.sharedPref.edit().putString("customDialogBack", EditorActivity.this.backColor).commit();
                } else if (EditorActivity.this.sharedPref.getString("customDialogBack", "").equals("")) {
                    EditorActivity.this.sharedPref.edit().putString("customDialogBack", "#FFFFFF").commit();
                }
                if (!EditorActivity.this.edittext6.getText().toString().trim().equals("")) {
                    EditorActivity.this.sharedPref.edit().putString("customDialogIcon", EditorActivity.this.edittext6.getText().toString()).commit();
                } else if (EditorActivity.this.sharedPref.getString("customDialogIcon", "").equals("")) {
                    EditorActivity.this.sharedPref.edit().putString("customDialogIcon", "null").commit();
                }
                if (!EditorActivity.this.edittext4.getText().toString().trim().equals("")) {
                    EditorActivity.this.sharedPref.edit().putString("customDialogMainTxtColor", EditorActivity.this.mainTextColor).commit();
                } else if (EditorActivity.this.sharedPref.getString("customDialogMainTxtColor", "").equals("")) {
                    EditorActivity.this.sharedPref.edit().putString("customDialogMainTxtColor", "#000000").commit();
                }
                if (!EditorActivity.this.edittext3.getText().toString().trim().equals("")) {
                    EditorActivity.this.sharedPref.edit().putString("customDialogAccent", EditorActivity.this.accentColor).commit();
                } else if (EditorActivity.this.sharedPref.getString("customDialogAccent", "").equals("")) {
                    EditorActivity.this.sharedPref.edit().putString("customDialogAccent", "#2196F3").commit();
                }
                if (!EditorActivity.this.edittext5.getText().toString().trim().equals("")) {
                    EditorActivity.this.sharedPref.edit().putString("customDialogBtnTxtColor", EditorActivity.this.buttonTextColor).commit();
                } else if (EditorActivity.this.sharedPref.getString("customDialogBtnTxtColor", "").equals("")) {
                    EditorActivity.this.sharedPref.edit().putString("customDialogBtnTxtColor", "#FFFFFF").commit();
                }
                if (EditorActivity.this.ifAdShown) {
                    EditorActivity.this.finish();
                } else {
                    EditorActivity.this.fbInterstitial.show();
                    EditorActivity.this.ifAdShown = true;
                }
                SketchwareUtil.showMessage(EditorActivity.this.getApplicationContext(), "Custom dialog saved successfully");
            }
        });
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: com.updatify.o2nation.EditorActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void initializeLogic() {
        this.loadAdsLimit = 0.0d;
        OverScrollDecoratorHelper.setUpOverScroll(this.vscroll6);
        AudienceNetworkAds.initialize(this);
        this.fbBanner = new AdView(this, "278142536768563_297676561481827", AdSize.BANNER_HEIGHT_50);
        this.ads_back.addView(this.fbBanner);
        this.fbBanner.loadAd();
        this.fbInterstitial = new InterstitialAd(this, "278142536768563_320780439171439");
        this.fbInterstitial.loadAd();
        try {
            _removeScollBar(this.vscroll6);
            _customizations();
            if (this.sharedPref.getString("customDialog", "").equals("")) {
                _setBgCorners(this.linear9, 60.0d, "#FFFFFF");
                _rippleRoundStroke(this.textview6, "#2196F3", "#802196F3", 90.0d, 0.0d, "#2196F3");
                _setBgCorners(this.linear10, 120.0d, "#2196F3");
                _rippleRoundStroke(this.textview5, "#FFFFFF", "#EEEEEE", 90.0d, 0.0d, "#2196F3");
                this.accentColor = "#2196F3";
                this.backColor = "#FFFFFF";
                this.mainTextColor = "#212121";
                this.buttonTextColor = "#FFFFFF";
                this.enter_round_color.setText("#FFFFFF");
                this.edittext3.setText("#2196F3");
                this.edittext4.setText("#000000");
                this.edittext5.setText("#FFFFFF");
                return;
            }
            this.enter_round_color.setText(this.sharedPref.getString("customDialogBack", "").toUpperCase());
            this.edittext3.setText(this.sharedPref.getString("customDialogAccent", "").toUpperCase());
            this.edittext4.setText(this.sharedPref.getString("customDialogMainTxtColor", "").toUpperCase());
            this.edittext5.setText(this.sharedPref.getString("customDialogBtnTxtColor", "").toUpperCase());
            this.seekbar4.setProgress((int) Double.parseDouble(this.sharedPref.getString("customDialogRound", "")));
            _setBgCorners(this.linear9, Double.parseDouble(this.sharedPref.getString("customDialogRound", "")), this.sharedPref.getString("customDialogBack", ""));
            this.textview44.setText(this.sharedPref.getString("customDialogRound", ""));
            _rippleRoundStroke(this.textview6, this.sharedPref.getString("customDialogAccent", ""), "#F5F5F5", Double.parseDouble(this.sharedPref.getString("customDialogRound", "")), 0.0d, "#2196F3");
            _setBgCorners(this.linear10, 120.0d, this.sharedPref.getString("customDialogAccent", ""));
            _rippleRoundStroke(this.textview5, this.sharedPref.getString("customDialogBack", ""), "#F5F5F5", Double.parseDouble(this.sharedPref.getString("customDialogRound", "")), 0.0d, "#2196F3");
            this.accentColor = this.sharedPref.getString("customDialogAccent", "");
            this.backColor = this.sharedPref.getString("customDialogBack", "");
            this.mainTextColor = this.sharedPref.getString("customDialogMainTxtColor", "");
            this.buttonTextColor = this.sharedPref.getString("customDialogBtnTxtColor", "");
            _setTextColor(this.textview3, this.sharedPref.getString("customDialogMainTxtColor", ""));
            _setTextColor(this.textview4, this.sharedPref.getString("customDialogMainTxtColor", ""));
            _setTextColor(this.textview5, this.sharedPref.getString("customDialogMainTxtColor", ""));
            _setTextColor(this.textview6, this.sharedPref.getString("customDialogBtnTxtColor", ""));
            if (!this.sharedPref.getString("customDialogIcon", "").equals("") && !this.sharedPref.getString("customDialogIcon", "").equals("null")) {
                Glide.with(getApplicationContext()).load(Uri.parse(this.sharedPref.getString("customDialogIcon", ""))).into(this.imageview2);
                this.edittext6.setText(this.sharedPref.getString("customDialogIcon", ""));
            }
        } catch (Exception e) {
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        EditorActivity.super.onActivityResult(i, i2, intent);
    }

    public void _setElevation(View view, double d) {
        view.setElevation((float) d);
    }

    public void _setInputLimit(TextView textView, double d) {
        textView.setFilters(new InputFilter[]{new InputFilter.LengthFilter((int) d)});
    }

    public void _TranslationZ(View view, double d) {
        view.setTranslationZ((float) ((int) d));
    }

    public void _setBgCorners(View view, double d, String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#" + str.replace("#", "")));
        gradientDrawable.setCornerRadius((float) ((int) d));
        gradientDrawable.setStroke(0, -1);
        view.setBackground(gradientDrawable);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.updatify.o2nation.EditorActivity */
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

    public void _setImageViewRipple(ImageView imageView, String str, String str2) {
        imageView.setImageTintList(new ColorStateList(new int[][]{new int[]{-16842919}, new int[]{16842919}}, new int[]{Color.parseColor(str), Color.parseColor(str2)}));
    }

    public void _rippleRoundStroke(View view, String str, String str2, double d, double d2, String str3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius((float) d);
        gradientDrawable.setStroke((int) d2, Color.parseColor("#" + str3.replace("#", "")));
        view.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor(str2)}), gradientDrawable, null));
    }

    public void _advancedCorners(View view, String str, double d, double d2, double d3, double d4) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadii(new float[]{(float) ((int) d), (float) ((int) d), (float) ((int) d2), (float) ((int) d2), (float) ((int) d4), (float) ((int) d4), (float) ((int) d3), (float) ((int) d3)});
        view.setBackground(gradientDrawable);
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

    public void _RoundAndBorder(View view, String str, double d, String str2, double d2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius((float) ((int) d2));
        gradientDrawable.setStroke((int) d, Color.parseColor(str2));
        view.setBackground(gradientDrawable);
    }

    public void _getClipboardData(TextView textView) {
        ClipData primaryClip = ((ClipboardManager) getSystemService(CLIPBOARD_SERVICE)).getPrimaryClip();
        if (primaryClip != null) {
            this.clipdata = primaryClip.getItemAt(0).getText().toString();
            textView.setText(this.clipdata);
            return;
        }
        SketchwareUtil.showMessage(getApplicationContext(), "Clipboard is empty!");
    }

    public void _RippleEffects(String str, View view) {
        view.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor(str)}), null, null));
    }

    public void _Snackbar_API(String str, String str2, String str3) {
        // TODO : Res Class
        this._snackBarView = Snackbar.make((ViewGroup) ((ViewGroup) findViewById(0x1020002)).getChildAt(0), "", 0);
        this._sblayout = (Snackbar.SnackbarLayout) this._snackBarView.getView();
        View inflate = getLayoutInflater().inflate(R.layout.snackbar, (ViewGroup) null);
        this._sblayout.setPadding(0, 0, 0, 0);
        this._sblayout.setBackgroundColor(Color.argb(0, 0, 0, 0));
        TextView textView = (TextView) inflate.findViewById(R.id.textview1);
        _setViewRadius((LinearLayout) inflate.findViewById(R.id.linear1), 25.0d, "#202125");
        textView.setText(str);
        textView.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product.ttf"), Typeface.NORMAL);
        this._sblayout.addView(inflate, 0);
        this._snackBarView.show();
    }

    private void _doNothingBlahBlah() {
    }

    public void _edittextFocus1(TextView textView) {
        textView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.updatify.o2nation.EditorActivity.18 */

            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EditorActivity.this._RoundAndBorder(EditorActivity.this.linear16, "#00007EED", 3.0d, "#FF007EED", 10.0d);
                } else {
                    EditorActivity.this._RoundAndBorder(EditorActivity.this.linear16, "#00000000", 3.0d, "#E0E0E0", 10.0d);
                }
            }
        });
    }

    public void _edittextFocus2(TextView textView) {
        textView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.updatify.o2nation.EditorActivity.19 */

            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EditorActivity.this._RoundAndBorder(EditorActivity.this.linear17, "#00007EED", 3.0d, "#FF007EED", 10.0d);
                } else {
                    EditorActivity.this._RoundAndBorder(EditorActivity.this.linear17, "#00000000", 3.0d, "#E0E0E0", 10.0d);
                }
            }
        });
    }

    public void _edittextFocus3(TextView textView) {
        textView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.updatify.o2nation.EditorActivity.20 */

            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EditorActivity.this._RoundAndBorder(EditorActivity.this.linear18, "#00007EED", 3.0d, "#FF007EED", 10.0d);
                } else {
                    EditorActivity.this._RoundAndBorder(EditorActivity.this.linear18, "#00000000", 3.0d, "#E0E0E0", 10.0d);
                }
            }
        });
    }

    public void _edittextFocus4(TextView textView) {
        textView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.updatify.o2nation.EditorActivity.21 */

            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EditorActivity.this._RoundAndBorder(EditorActivity.this.linear19, "#00007EED", 3.0d, "#FF007EED", 10.0d);
                } else {
                    EditorActivity.this._RoundAndBorder(EditorActivity.this.linear19, "#00000000", 3.0d, "#E0E0E0", 10.0d);
                }
            }
        });
        this.edittext6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.updatify.o2nation.EditorActivity.22 */

            public void onFocusChange(View view, boolean z) {
                if (z) {
                    EditorActivity.this._RoundAndBorder(EditorActivity.this.linear25, "#00007EED", 3.0d, "#FF007EED", 10.0d);
                } else {
                    EditorActivity.this._RoundAndBorder(EditorActivity.this.linear25, "#00000000", 3.0d, "#E0E0E0", 10.0d);
                }
            }
        });
    }

    public void _customizations() {
        _setToolTip(this.imageview43, "Less radius");
        _setToolTip(this.imageview44, "More radius");
        _setToolTip(this.imageview1, "Back");
        _setToolTip(this.imageview54, "Paste clipboard");
        _setToolTip(this.imageview61, "Paste clipboard");
        _setToolTip(this.imageview57, "Paste clipboard");
        _setToolTip(this.imageview58, "Paste clipboard");
        _setToolTip(this.imageview59, "Paste clipboard");
        _TranslationZ(this.linear10, 1.0d);
        _setInputLimit(this.enter_round_color, 7.0d);
        _setInputLimit(this.edittext3, 7.0d);
        _setInputLimit(this.edittext4, 7.0d);
        _setInputLimit(this.edittext5, 7.0d);
        _setElevation(this.linear15, 7.0d);
        _changeActivityFont("product_med");
        _RippleEffects("#EEEEEE", this.imageview43);
        _RippleEffects("#EEEEEE", this.imageview44);
        _RippleEffects("#EEEEEE", this.imageview57);
        _RippleEffects("#EEEEEE", this.imageview54);
        _RippleEffects("#EEEEEE", this.imageview61);
        _RippleEffects("#EEEEEE", this.imageview58);
        _RippleEffects("#EEEEEE", this.imageview59);
        _RippleEffects("#EEEEEE", this.imageview1);
        if (this.sharedPref2.getString("autodark", "").equals("true") || this.sharedPref2.getString("autodark", "").equals("")) {
            try {
                switch (getResources().getConfiguration().uiMode & 48) {
                    case 16:
                        this.sharedPref2.edit().putString("dark", "false").commit();
                        break;
                    case 32:
                        this.sharedPref2.edit().putString("dark", "true").commit();
                        break;
                }
            } catch (Exception e) {
            }
        }
        if (this.sharedPref2.getString("dark", "").equals("true")) {
            _NavStatusBarColor("#181818", "#181818");
            _LIGHT_ICONS();
            _RoundAndBorder(this.seek1back, "#00000000", 3.0d, "#424242", 10.0d);
            _RoundAndBorder(this.linear16, "#00000000", 3.0d, "#424242", 10.0d);
            _RoundAndBorder(this.linear17, "#00000000", 3.0d, "#424242", 10.0d);
            _RoundAndBorder(this.linear18, "#00000000", 3.0d, "#424242", 10.0d);
            _RoundAndBorder(this.linear19, "#00000000", 3.0d, "#424242", 10.0d);
            _RoundAndBorder(this.linear25, "#00000000", 3.0d, "#424242", 10.0d);
            _ICC(this.imageview1, "#FFFFFF", "#FFFFFF");
            _ICC(this.imageview60, "#0084FF", "#CC616161");
            _ICC(this.imageview57, "#FFFFFF", "#007EEF");
            _ICC(this.imageview58, "#FFFFFF", "#007EEF");
            _ICC(this.imageview59, "#FFFFFF", "#007EEF");
            _ICC(this.imageview54, "#FFFFFF", "#007EEF");
            _ICC(this.imageview61, "#FFFFFF", "#007EEF");
            _advancedCorners(this.linear15, "#181818", 60.0d, 60.0d, 0.0d, 0.0d);
            this.linear23.setBackgroundColor(-15198184);
            this.linear8.setBackgroundColor(-15198184);
            this.linear24.setBackgroundColor(-12434878);
            this.textview1.setTextColor(-1);
            this.textview45.setTextColor(-1);
            this.textview55.setTextColor(-1);
            this.textview46.setTextColor(-1);
            this.textview50.setTextColor(-1);
            this.textview52.setTextColor(-1);
            this.textview53.setTextColor(-1);
            this.textview51.setTextColor(-2039584);
            this.textview44.setTextColor(-1);
            this.edittext6.setTextColor(-1);
            this.enter_round_color.setTextColor(-1);
            this.edittext3.setTextColor(-1);
            this.edittext4.setTextColor(-1);
            this.edittext5.setTextColor(-1);
            this.edittext6.setHintTextColor(-2039584);
            this.enter_round_color.setHintTextColor(-2039584);
            this.edittext3.setHintTextColor(-2039584);
            this.edittext4.setHintTextColor(-2039584);
            this.edittext5.setHintTextColor(-2039584);
            this.linear21.setBackgroundColor(-15198184);
            this.ads_back.setBackgroundColor(-15198184);
            this.save_holder.setBackgroundColor(-15198184);
        } else {
            _NavStatusBarColor("#FFFFFF", "#FFFFFF");
            _DARK_ICONS();
            _RoundAndBorder(this.seek1back, "#00000000", 3.0d, "#E0E0E0", 10.0d);
            _RoundAndBorder(this.linear16, "#00000000", 3.0d, "#E0E0E0", 10.0d);
            _RoundAndBorder(this.linear17, "#00000000", 3.0d, "#E0E0E0", 10.0d);
            _RoundAndBorder(this.linear18, "#00000000", 3.0d, "#E0E0E0", 10.0d);
            _RoundAndBorder(this.linear19, "#00000000", 3.0d, "#E0E0E0", 10.0d);
            _RoundAndBorder(this.linear25, "#00000000", 3.0d, "#E0E0E0", 10.0d);
            _ICC(this.imageview1, "#616161", "#CC616161");
            _ICC(this.imageview60, "#0084FF", "#CC616161");
            _ICC(this.imageview57, "#616161", "#007EEF");
            _ICC(this.imageview58, "#616161", "#007EEF");
            _ICC(this.imageview59, "#616161", "#007EEF");
            _ICC(this.imageview54, "#616161", "#007EEF");
            _ICC(this.imageview61, "#616161", "#007EEF");
            _advancedCorners(this.linear15, "#FFFFFF", 60.0d, 60.0d, 0.0d, 0.0d);
        }
        _setImageViewRipple(this.imageview2, "#FFFFFF", "#FFFFFF");
        _rippleRoundStroke(this.textview54, "#007EEF", "#18FFFFFF", 30.0d, 0.0d, "#007EEF");
        _edittextFocus1(this.enter_round_color);
        _edittextFocus2(this.edittext3);
        _edittextFocus3(this.edittext4);
        _edittextFocus4(this.edittext5);
    }

    public void _setTextColor(TextView textView, String str) {
        textView.setTextColor(Color.parseColor(str));
    }

    public void _ICC(ImageView imageView, String str, String str2) {
        imageView.setImageTintList(new ColorStateList(new int[][]{new int[]{-16842919}, new int[]{16842919}}, new int[]{Color.parseColor(str), Color.parseColor(str2)}));
    }

    public void _removeScollBar(View view) {
        view.setVerticalScrollBarEnabled(false);
        view.setHorizontalScrollBarEnabled(false);
    }

    public void _setViewRadius(View view, double d, String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#" + str.replace("#", "")));
        gradientDrawable.setCornerRadius((float) ((int) d));
        view.setBackground(gradientDrawable);
    }

    public void _setToolTip(View view, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                view.setTooltipText(str);
            } else if (Build.VERSION.SDK_INT < 28) {
                TooltipCompat.setTooltipText(view, str);
            }
        } catch (Exception e) {
        }
    }

    public void _LIGHT_ICONS() {
        getWindow().getDecorView().setSystemUiVisibility(0);
    }

    public void _showColorPicker(View view, final TextView textView) {
        View inflate = getLayoutInflater().inflate(R.layout.colorpicker, (ViewGroup) null);
        PopupWindow popupWindow = new PopupWindow(inflate, -2, -2, true);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.ly);
        ColorSlider colorSlider = inflate.findViewById(R.id.slider);
        popupWindow.setAnimationStyle(16973826);
        popupWindow.showAsDropDown(view, 0, 0);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        colorSlider.setListener(new ColorSlider.OnColorSelectedListener() {
            /* class com.updatify.o2nation.EditorActivity.23 */

            public void onColorChanged(int i, int i2) {
                try {
                    textView.setText("#".concat(Integer.toHexString(i2).substring(2, 8)));
                } catch (Exception e) {
                    SketchwareUtil.showMessage(EditorActivity.this.getApplicationContext(), e.toString());
                }
            }
        });
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#FFFFFF"));
        gradientDrawable.setCornerRadius(400.0f);
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setClipToOutline(true);
        linearLayout.setElevation(7.0f);
    }
}
