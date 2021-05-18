package com.updatify.o2nation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.TooltipCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.NotificationCompat;

import com.bumptech.glide.Glide;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.android.play.core.tasks.OnCompleteListener;
import com.google.android.play.core.tasks.OnFailureListener;
import com.google.android.play.core.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.gson.Gson;

import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

public class UpdaterActivity extends AppCompatActivity {
    View _inflate;
    Snackbar.SnackbarLayout _sblayout;
    Snackbar _snackBarView;
    AlertDialog updatifyDialog;
    BottomSheetDialog updatifySheet;
    private HashMap<String, Object> APIHeaders = new HashMap<>();
    private HashMap<String, Object> APIProjectsMap = new HashMap<>();
    private ChildEventListener _DBManager_child_listener;
    private ChildEventListener _DBPushUsers_child_listener;
    private ChildEventListener _DBUserProjects_child_listener;
    private ChildEventListener _DBUsers_child_listener;
    private RequestNetwork.RequestListener _checkNet_request_listener;
    private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
    private DatabaseReference DBManager = this._firebase.getReference("MANAGE2827JEHDKRKE2827");
    private DatabaseReference DBPushUsers = this._firebase.getReference("USERS2827IWUWIEHDN8273");
    private DatabaseReference DBUserProjects = this._firebase.getReference("PATH");
    private DatabaseReference DBUsers = this._firebase.getReference("USERS2827IWUWIEHDN8273");
    private RequestNetwork.RequestListener _requestProjects_request_listener;
    private Timer _timer = new Timer();
    private String accentColor = "";
    private LinearLayout ads_back;
    private String alertOption = "";
    private HashMap<String, Object> authMap = new HashMap<>();
    private String backColor = "";
    private LinearLayout back_alertdia;
    private LinearLayout back_alertsheet;
    private LinearLayout background;
    private CoordinatorLayout background2;
    private LinearLayout bsheet_options;
    private boolean button1 = false;
    private boolean button2 = false;
    private String buttonTextColor = "";
    private Calendar calendar = Calendar.getInstance();
    private RequestNetwork checkNet;
    private CheckBox checkbox1;
    private CheckBox checkbox2;
    private Calendar cleaners = Calendar.getInstance();
    private String clipdata = "";
    private LinearLayout close1_back;
    private String color = "";
    private ProgressDialog coreprog;
    private double counter = 0.0d;
    private double customRound = 0.0d;
    private boolean customStat = false;
    private AlertDialog.Builder dialog;
    private String dialogTheme = "";
    private TextView dismiss2;
    private LinearLayout dismiss2_back;
    private EditText edittext1;
    private EditText edittext4;
    private EditText edittext6;
    private EditText edittext7;
    private EditText edittext8;
    private EditText edittext9;
    private TextView exit1;
    private TextView exit2;
    private LinearLayout exit2_back;
    private LinearLayout exit_back;
    private String extraClickAction = "";
    private AdView fbBanner;
    private InterstitialAd fbInterstitial;
    private String filename = "";
    private String fontName = "";
    private HorizontalScrollView hscroll1;
    private HorizontalScrollView hscroll2;
    private HorizontalScrollView hscroll3;
    private HorizontalScrollView hscroll4;
    private ImageView imageview1;
    private ImageView imageview10;
    private ImageView imageview2;
    private ImageView imageview3;
    private ImageView imageview4;
    private ImageView imageview5;
    private ImageView imageview6;
    private ImageView imageview7;
    private ImageView imageview8;
    private ImageView imageview9;
    private ImageView img_alertdia;
    private ImageView img_alertsheet;
    private boolean isAdmobAvailable = false;
    private boolean isSwitch1Enabled = false;
    private boolean isSwitch2Enabled = false;
    private LinearLayout line1;
    private LinearLayout line2;
    private LinearLayout line3;
    private LinearLayout linear1;
    private LinearLayout linear10;
    private LinearLayout linear11;
    private LinearLayout linear12;
    private LinearLayout linear13;
    private LinearLayout linear2;
    private LinearLayout linear20;
    private LinearLayout linear21;
    private LinearLayout linear22;
    private LinearLayout linear23;
    private LinearLayout linear24;
    private LinearLayout linear25;
    private LinearLayout linear26;
    private LinearLayout linear27;
    private LinearLayout linear29;
    private LinearLayout linear30;
    private LinearLayout linear31;
    private LinearLayout linear32;
    private LinearLayout linear33;
    private LinearLayout linear34;
    private LinearLayout linear35;
    private LinearLayout linear36;
    private LinearLayout linear4;
    private LinearLayout linear5;
    private LinearLayout linear9;
    private double loadAdsLimit = 0.0d;
    private String logTempKey = "";
    private HashMap<String, Object> logsMap = new HashMap<>();
    private FirebaseAuth mAuth;
    private String mainClickAction = "";
    private String mainTextColor = "";
    private double n1 = 0.0d;
    private double n2 = 0.0d;
    private double n3 = 0.0d;
    private double newVersion = 0.0d;
    private String newVersion_ = "";
    private boolean onStart = false;
    private HashMap<String, Object> projectsMap = new HashMap<>();
    private String publishKey = "";
    private RequestNetwork requestProjects;
    private ReviewInfo reviewInfo;
    private ReviewManager reviewManager;
    private LinearLayout scrollback;
    private SharedPreferences sharedPref;
    private SharedPreferences sharedPref2;
    private BottomSheetBehavior sheetBehavior;
    private LinearLayout slider;
    private LinearLayout switch_back1;
    private LinearLayout switch_back2;
    private LinearLayout switch_btn1;
    private LinearLayout switch_btn2;
    private TextView textview1;
    private TextView textview10;
    private TextView textview11;
    private TextView textview15;
    private TextView textview2;
    private TextView textview20;
    private TextView textview22;
    private TextView textview24;
    private TextView textview25;
    private TextView textview26;
    private TextView textview29;
    private TextView textview30;
    private TextView textview31;
    private TextView textview33;
    private TextView textview34;
    private TextView textview37;
    private TextView textview38;
    private TextView textview43;
    private TextView textview44;
    private TextView textview45;
    private TextView textview46;
    private TextView textview47;
    private TextView textview48;
    private TextView textview49;
    private TextView textview50;
    private TextView textview51;
    private TextView textview52;
    private TextView textview53;
    private TextView textview54;
    private TextView textview56;
    private TextView textview57;
    private TextView textview6;
    private TextView textview7;
    private TextView textview8;
    private TextView textview9;
    private TimerTask timer;
    private String title = "";
    private Intent toeditor = new Intent();
    private Intent tologin = new Intent();
    private String typeace = "";
    private TextView update1;
    private LinearLayout update1_back;
    private LinearLayout update2_back;
    private TextView url2;
    private String userId = "";
    private String username = "";
    private ScrollView vscroll1;
    private TextView warning1;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.updatify.o2nation.UpdaterActivity */
    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        UpdaterActivity.super.onCreate(bundle);
        setContentView(R.layout.updater);
        initialize(bundle);
        FirebaseApp.initializeApp(this);
        initializeLogic();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.updatify.o2nation.UpdaterActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void initialize(Bundle bundle) {
        this.background = (LinearLayout) findViewById(R.id.background);
        this.ads_back = (LinearLayout) findViewById(R.id.ads_back);
        this.background2 = findViewById(R.id.background2);
        this.scrollback = (LinearLayout) findViewById(R.id.scrollback);
        this.bsheet_options = (LinearLayout) findViewById(R.id.bsheet_options);
        this.vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
        this.linear1 = (LinearLayout) findViewById(R.id.linear1);
        this.linear2 = (LinearLayout) findViewById(R.id.linear2);
        this.linear9 = (LinearLayout) findViewById(R.id.linear9);
        this.edittext1 = (EditText) findViewById(R.id.edittext1);
        this.linear10 = (LinearLayout) findViewById(R.id.linear10);
        this.edittext4 = (EditText) findViewById(R.id.edittext4);
        this.linear31 = (LinearLayout) findViewById(R.id.linear31);
        this.hscroll3 = (HorizontalScrollView) findViewById(R.id.hscroll3);
        this.linear35 = (LinearLayout) findViewById(R.id.linear35);
        this.hscroll4 = (HorizontalScrollView) findViewById(R.id.hscroll4);
        this.linear25 = (LinearLayout) findViewById(R.id.linear25);
        this.edittext9 = (EditText) findViewById(R.id.edittext9);
        this.linear11 = (LinearLayout) findViewById(R.id.linear11);
        this.hscroll1 = (HorizontalScrollView) findViewById(R.id.hscroll1);
        this.linear24 = (LinearLayout) findViewById(R.id.linear24);
        this.edittext8 = (EditText) findViewById(R.id.edittext8);
        this.linear20 = (LinearLayout) findViewById(R.id.linear20);
        this.edittext6 = (EditText) findViewById(R.id.edittext6);
        this.linear29 = (LinearLayout) findViewById(R.id.linear29);
        this.hscroll2 = (HorizontalScrollView) findViewById(R.id.hscroll2);
        this.linear23 = (LinearLayout) findViewById(R.id.linear23);
        this.edittext7 = (EditText) findViewById(R.id.edittext7);
        this.line1 = (LinearLayout) findViewById(R.id.line1);
        this.linear13 = (LinearLayout) findViewById(R.id.linear13);
        this.line3 = (LinearLayout) findViewById(R.id.line3);
        this.linear21 = (LinearLayout) findViewById(R.id.linear21);
        this.line2 = (LinearLayout) findViewById(R.id.line2);
        this.linear33 = (LinearLayout) findViewById(R.id.linear33);
        this.imageview1 = (ImageView) findViewById(R.id.imageview1);
        this.linear4 = (LinearLayout) findViewById(R.id.linear4);
        this.imageview2 = (ImageView) findViewById(R.id.imageview2);
        this.linear5 = (LinearLayout) findViewById(R.id.linear5);
        this.textview1 = (TextView) findViewById(R.id.textview1);
        this.imageview3 = (ImageView) findViewById(R.id.imageview3);
        this.textview2 = (TextView) findViewById(R.id.textview2);
        this.textview6 = (TextView) findViewById(R.id.textview6);
        this.textview7 = (TextView) findViewById(R.id.textview7);
        this.textview8 = (TextView) findViewById(R.id.textview8);
        this.textview9 = (TextView) findViewById(R.id.textview9);
        this.textview43 = (TextView) findViewById(R.id.textview43);
        this.textview44 = (TextView) findViewById(R.id.textview44);
        this.linear32 = (LinearLayout) findViewById(R.id.linear32);
        this.textview45 = (TextView) findViewById(R.id.textview45);
        this.textview46 = (TextView) findViewById(R.id.textview46);
        this.textview47 = (TextView) findViewById(R.id.textview47);
        this.textview48 = (TextView) findViewById(R.id.textview48);
        this.textview53 = (TextView) findViewById(R.id.textview53);
        this.textview54 = (TextView) findViewById(R.id.textview54);
        this.linear36 = (LinearLayout) findViewById(R.id.linear36);
        this.back_alertdia = (LinearLayout) findViewById(R.id.back_alertdia);
        this.back_alertsheet = (LinearLayout) findViewById(R.id.back_alertsheet);
        this.img_alertdia = (ImageView) findViewById(R.id.img_alertdia);
        this.textview56 = (TextView) findViewById(R.id.textview56);
        this.img_alertsheet = (ImageView) findViewById(R.id.img_alertsheet);
        this.textview57 = (TextView) findViewById(R.id.textview57);
        this.textview31 = (TextView) findViewById(R.id.textview31);
        this.switch_back1 = (LinearLayout) findViewById(R.id.switch_back1);
        this.switch_btn1 = (LinearLayout) findViewById(R.id.switch_btn1);
        this.textview10 = (TextView) findViewById(R.id.textview10);
        this.textview11 = (TextView) findViewById(R.id.textview11);
        this.linear12 = (LinearLayout) findViewById(R.id.linear12);
        this.exit_back = (LinearLayout) findViewById(R.id.exit_back);
        this.update1_back = (LinearLayout) findViewById(R.id.update1_back);
        this.close1_back = (LinearLayout) findViewById(R.id.close1_back);
        this.imageview5 = (ImageView) findViewById(R.id.imageview5);
        this.exit1 = (TextView) findViewById(R.id.exit1);
        this.imageview6 = (ImageView) findViewById(R.id.imageview6);
        this.update1 = (TextView) findViewById(R.id.update1);
        this.imageview7 = (ImageView) findViewById(R.id.imageview7);
        this.warning1 = (TextView) findViewById(R.id.warning1);
        this.textview29 = (TextView) findViewById(R.id.textview29);
        this.textview30 = (TextView) findViewById(R.id.textview30);
        this.textview20 = (TextView) findViewById(R.id.textview20);
        this.switch_back2 = (LinearLayout) findViewById(R.id.switch_back2);
        this.switch_btn2 = (LinearLayout) findViewById(R.id.switch_btn2);
        this.textview37 = (TextView) findViewById(R.id.textview37);
        this.textview38 = (TextView) findViewById(R.id.textview38);
        this.linear30 = (LinearLayout) findViewById(R.id.linear30);
        this.exit2_back = (LinearLayout) findViewById(R.id.exit2_back);
        this.update2_back = (LinearLayout) findViewById(R.id.update2_back);
        this.dismiss2_back = (LinearLayout) findViewById(R.id.dismiss2_back);
        this.imageview8 = (ImageView) findViewById(R.id.imageview8);
        this.exit2 = (TextView) findViewById(R.id.exit2);
        this.imageview9 = (ImageView) findViewById(R.id.imageview9);
        this.url2 = (TextView) findViewById(R.id.url2);
        this.imageview10 = (ImageView) findViewById(R.id.imageview10);
        this.dismiss2 = (TextView) findViewById(R.id.dismiss2);
        this.textview26 = (TextView) findViewById(R.id.textview26);
        this.textview52 = (TextView) findViewById(R.id.textview52);
        this.linear26 = (LinearLayout) findViewById(R.id.linear26);
        this.imageview4 = (ImageView) findViewById(R.id.imageview4);
        this.linear27 = (LinearLayout) findViewById(R.id.linear27);
        this.textview34 = (TextView) findViewById(R.id.textview34);
        this.textview15 = (TextView) findViewById(R.id.textview15);
        this.linear22 = (LinearLayout) findViewById(R.id.linear22);
        this.checkbox1 = (CheckBox) findViewById(R.id.checkbox1);
        this.textview22 = (TextView) findViewById(R.id.textview22);
        this.textview24 = (TextView) findViewById(R.id.textview24);
        this.linear34 = (LinearLayout) findViewById(R.id.linear34);
        this.checkbox2 = (CheckBox) findViewById(R.id.checkbox2);
        this.textview49 = (TextView) findViewById(R.id.textview49);
        this.textview50 = (TextView) findViewById(R.id.textview50);
        this.slider = (LinearLayout) findViewById(R.id.slider);
        this.textview51 = (TextView) findViewById(R.id.textview51);
        this.textview25 = (TextView) findViewById(R.id.textview25);
        this.textview33 = (TextView) findViewById(R.id.textview33);
        this.requestProjects = new RequestNetwork(this);
        this.dialog = new AlertDialog.Builder(this);
        this.sharedPref = getSharedPreferences("UpdatifyFiles", 0);
        this.sharedPref2 = getSharedPreferences("sharedPref", 0);
        this.checkNet = new RequestNetwork(this);
        this.imageview1.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.UpdaterActivity.1 */

            public void onClick(View view) {
                UpdaterActivity.this.supportFinishAfterTransition();
            }
        });
        this.imageview2.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.UpdaterActivity.2 */

            public void onClick(View view) {
                View inflate = UpdaterActivity.this.getLayoutInflater().inflate(R.layout.popup, (ViewGroup) null);
                final PopupWindow popupWindow = new PopupWindow(inflate, -2, -2, true);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.item1);
                LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.back);
                TextView textView = (TextView) inflate.findViewById(R.id.item1txt);
                popupWindow.setAnimationStyle(16973826);
                popupWindow.showAsDropDown(UpdaterActivity.this.imageview2, 0, 10);
                UpdaterActivity.this._ICC((ImageView) inflate.findViewById(R.id.item1img), "#09B83E", "#cc09B83E");
                if (UpdaterActivity.this.sharedPref2.getString("dark", "").equals("true")) {
                    textView.setTextColor(-15198184);
                    popupWindow.setBackgroundDrawable(new BitmapDrawable());
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setColor(Color.parseColor("#FFFFFF"));
                    gradientDrawable.setCornerRadius(20.0f);
                    linearLayout2.setBackground(gradientDrawable);
                } else {
                    textView.setTextColor(-1);
                    popupWindow.setBackgroundDrawable(new BitmapDrawable());
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    gradientDrawable2.setColor(Color.parseColor("#181818"));
                    gradientDrawable2.setCornerRadius(20.0f);
                    linearLayout2.setBackground(gradientDrawable2);
                }
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    /* class com.updatify.o2nation.UpdaterActivity.2.1 */

                    public void onClick(View view) {
                        UpdaterActivity updaterActivity = UpdaterActivity.this;
                        UpdaterActivity.this.getApplicationContext();
                        ((ClipboardManager) updaterActivity.getSystemService(CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", UpdaterActivity.this.getIntent().getStringExtra("api")));
                        UpdaterActivity.this._Snackbar_API("API link copied", "", "long");
                        popupWindow.dismiss();
                    }
                });
            }
        });
        this.textview45.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.UpdaterActivity.3 */

            public void onClick(View view) {
                UpdaterActivity.this.textview45.setTextColor(-16744723);
                UpdaterActivity.this.textview46.setTextColor(-6381922);
                UpdaterActivity.this.textview47.setTextColor(-6381922);
                UpdaterActivity.this.textview48.setTextColor(-6381922);
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.textview45, "#E0EBF6", 3.0d, "#007EED", 100.0d);
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.textview46, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.textview47, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.textview48, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.textview45, "elevation", 5.0d, 100.0d);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.textview46, "elevation", 0.0d, 100.0d);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.textview47, "elevation", 0.0d, 100.0d);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.textview48, "elevation", 0.0d, 100.0d);
                UpdaterActivity.this.dialogTheme = "update";
                UpdaterActivity.this._autoTransitionScroll(UpdaterActivity.this.vscroll1);
                UpdaterActivity.this.customStat = false;
            }
        });
        this.textview46.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.UpdaterActivity.4 */

            public void onClick(View view) {
                UpdaterActivity.this.textview46.setTextColor(-2154455);
                UpdaterActivity.this.textview45.setTextColor(-6381922);
                UpdaterActivity.this.textview47.setTextColor(-6381922);
                UpdaterActivity.this.textview48.setTextColor(-6381922);
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.textview46, "#FFEFEF", 3.0d, "#DF2029", 100.0d);
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.textview45, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.textview47, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.textview48, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.textview46, "elevation", 5.0d, 100.0d);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.textview45, "elevation", 0.0d, 100.0d);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.textview47, "elevation", 0.0d, 100.0d);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.textview48, "elevation", 0.0d, 100.0d);
                UpdaterActivity.this.dialogTheme = "warning";
                UpdaterActivity.this.customStat = false;
                UpdaterActivity.this._autoTransitionScroll(UpdaterActivity.this.vscroll1);
            }
        });
        this.textview47.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.UpdaterActivity.5 */

            public void onClick(View view) {
                UpdaterActivity.this.textview47.setTextColor(-688896);
                UpdaterActivity.this.textview46.setTextColor(-6381922);
                UpdaterActivity.this.textview45.setTextColor(-6381922);
                UpdaterActivity.this.textview48.setTextColor(-6381922);
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.textview47, "#FFF3E7", 3.0d, "#F57D00", 100.0d);
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.textview48, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.textview45, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.textview46, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.textview45, "elevation", 0.0d, 100.0d);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.textview46, "elevation", 0.0d, 100.0d);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.textview48, "elevation", 0.0d, 100.0d);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.textview47, "elevation", 5.0d, 100.0d);
                UpdaterActivity.this.dialogTheme = "message";
                UpdaterActivity.this._autoTransitionScroll(UpdaterActivity.this.vscroll1);
                UpdaterActivity.this.customStat = false;
            }
        });
        this.textview48.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.UpdaterActivity.6 */

            public void onClick(View view) {
                if (UpdaterActivity.this.dialogTheme.equals("custom")) {
                    UpdaterActivity.this.toeditor.setClass(UpdaterActivity.this.getApplicationContext(), EditorActivity.class);
                    UpdaterActivity.this.startActivity(UpdaterActivity.this.toeditor);
                    return;
                }
                if (UpdaterActivity.this.sharedPref.getString("customDialog", "").equals("")) {
                    UpdaterActivity.this.toeditor.setClass(UpdaterActivity.this.getApplicationContext(), EditorActivity.class);
                    UpdaterActivity.this.startActivity(UpdaterActivity.this.toeditor);
                } else {
                    UpdaterActivity.this._Snackbar_API("Click again to show editor", "", "");
                }
                UpdaterActivity.this.dialogTheme = "custom";
                UpdaterActivity.this.textview45.setTextColor(-6381922);
                UpdaterActivity.this.textview46.setTextColor(-6381922);
                UpdaterActivity.this.textview47.setTextColor(-6381922);
                UpdaterActivity.this.textview48.setTextColor(-14606047);
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.textview45, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.textview46, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.textview47, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.textview48, "#E0E0E0", 3.0d, "#212121", 100.0d);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.textview45, "elevation", 0.0d, 100.0d);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.textview46, "elevation", 0.0d, 100.0d);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.textview47, "elevation", 0.0d, 100.0d);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.textview48, "elevation", 5.0d, 100.0d);
            }
        });
        this.back_alertdia.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.UpdaterActivity.7 */

            public void onClick(View view) {
                UpdaterActivity.this.alertOption = "dialog";
                if (UpdaterActivity.this.sharedPref2.getString("dark", "").equals("true")) {
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.back_alertdia, "#00000000", 3.0d, "#007EED", 100.0d);
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.back_alertsheet, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                } else {
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.back_alertdia, "#E0EBF6", 3.0d, "#007EED", 100.0d);
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.back_alertsheet, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                }
                UpdaterActivity.this.textview56.setTextColor(-16744723);
                UpdaterActivity.this.textview57.setTextColor(-6381922);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.back_alertdia, "elevation", 5.0d, 100.0d);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.back_alertsheet, "elevation", 0.0d, 100.0d);
                UpdaterActivity.this._ICC(UpdaterActivity.this.img_alertdia, "#FFFFFF", "#FFFFFF");
                UpdaterActivity.this._ICC(UpdaterActivity.this.img_alertsheet, "#9E9E9E", "#9E9E9E");
                UpdaterActivity.this._setBgCorners(UpdaterActivity.this.img_alertdia, 90.0d, "#007EED");
                UpdaterActivity.this._setBgCorners(UpdaterActivity.this.img_alertsheet, 90.0d, "#00000000");
            }
        });
        this.back_alertsheet.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.UpdaterActivity.8 */

            public void onClick(View view) {
                UpdaterActivity.this.alertOption = "sheet";
                if (UpdaterActivity.this.sharedPref2.getString("dark", "").equals("true")) {
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.back_alertdia, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.back_alertsheet, "#00000000", 3.0d, "#F57D00", 100.0d);
                } else {
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.back_alertdia, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.back_alertsheet, "#FFF3E7", 3.0d, "#F57D00", 100.0d);
                }
                UpdaterActivity.this.textview57.setTextColor(-688896);
                UpdaterActivity.this.textview56.setTextColor(-6381922);
                UpdaterActivity.this._ICC(UpdaterActivity.this.img_alertdia, "#9E9E9E", "#9E9E9E");
                UpdaterActivity.this._ICC(UpdaterActivity.this.img_alertsheet, "#FFFFFF", "#FFFFFF");
                UpdaterActivity.this._setBgCorners(UpdaterActivity.this.img_alertdia, 90.0d, "#00000000");
                UpdaterActivity.this._setBgCorners(UpdaterActivity.this.img_alertsheet, 90.0d, "#F57D00");
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.back_alertdia, "elevation", 0.0d, 100.0d);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.back_alertsheet, "elevation", 5.0d, 100.0d);
            }
        });
        this.switch_back1.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.UpdaterActivity.9 */

            public void onClick(View view) {
                UpdaterActivity.this._transitionViewTime(UpdaterActivity.this.linear1, 150.0d);
                if (UpdaterActivity.this.isSwitch1Enabled) {
                    UpdaterActivity.this.edittext9.setVisibility(View.GONE);
                    UpdaterActivity.this.linear11.setVisibility(View.GONE);
                    UpdaterActivity.this.hscroll1.setVisibility(View.GONE);
                    if (UpdaterActivity.this.mainClickAction.equals("browser")) {
                        UpdaterActivity.this.linear24.setVisibility(View.VISIBLE);
                        UpdaterActivity.this.edittext8.setVisibility(View.VISIBLE);
                    } else {
                        UpdaterActivity.this.linear24.setVisibility(View.GONE);
                        UpdaterActivity.this.edittext8.setVisibility(View.GONE);
                    }
                    UpdaterActivity.this.isSwitch1Enabled = false;
                    UpdaterActivity.this.switch_back1.setGravity(3);
                    UpdaterActivity.this.button1 = false;
                    if (UpdaterActivity.this.sharedPref2.getString("dark", "").equals("true")) {
                        UpdaterActivity.this._setViewRadius(UpdaterActivity.this.switch_back1, 90.0d, "#424242");
                        UpdaterActivity.this._setViewRadius(UpdaterActivity.this.switch_btn1, 90.0d, "#2196F3");
                        return;
                    }
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.switch_back1, "#EEEEEE", 1.0d, "#E0E0E0", 90.0d);
                    UpdaterActivity.this._setViewRadius(UpdaterActivity.this.switch_btn1, 90.0d, "#2196F3");
                    return;
                }
                UpdaterActivity.this.edittext9.setVisibility(View.VISIBLE);
                UpdaterActivity.this.linear24.setVisibility(View.VISIBLE);
                UpdaterActivity.this.edittext8.setVisibility(View.VISIBLE);
                UpdaterActivity.this.linear11.setVisibility(View.VISIBLE);
                UpdaterActivity.this.hscroll1.setVisibility(View.VISIBLE);
                UpdaterActivity.this.isSwitch1Enabled = true;
                UpdaterActivity.this.switch_back1.setGravity(5);
                UpdaterActivity.this.button1 = true;
                if (UpdaterActivity.this.sharedPref2.getString("dark", "").equals("true")) {
                    UpdaterActivity.this._setViewRadius(UpdaterActivity.this.switch_back1, 90.0d, "#2196F3");
                    UpdaterActivity.this._setViewRadius(UpdaterActivity.this.switch_btn1, 90.0d, "#FFFFFF");
                    return;
                }
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.switch_back1, "#2196F3", 1.0d, "#E0E0E0", 90.0d);
                UpdaterActivity.this._setViewRadius(UpdaterActivity.this.switch_btn1, 90.0d, "#FFFFFF");
            }
        });
        this.linear12.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.UpdaterActivity.10 */

            public void onClick(View view) {
            }
        });
        this.exit_back.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.UpdaterActivity.11 */

            public void onClick(View view) {
                UpdaterActivity.this.exit1.setTextColor(-2154455);
                UpdaterActivity.this.update1.setTextColor(-6381922);
                UpdaterActivity.this.warning1.setTextColor(-6381922);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.exit_back, "elevation", 5.0d, 100.0d);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.update1_back, "elevation", 0.0d, 100.0d);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.close1_back, "elevation", 0.0d, 100.0d);
                UpdaterActivity.this.mainClickAction = "exit";
                UpdaterActivity.this._autoTransitionScroll(UpdaterActivity.this.vscroll1);
                UpdaterActivity.this.edittext8.setVisibility(View.GONE);
                UpdaterActivity.this.linear24.setVisibility(View.GONE);
                UpdaterActivity.this._setBgCorners(UpdaterActivity.this.imageview5, 90.0d, "#df2029");
                UpdaterActivity.this._setBgCorners(UpdaterActivity.this.imageview6, 90.0d, "#00000000");
                UpdaterActivity.this._setBgCorners(UpdaterActivity.this.imageview7, 90.0d, "#00000000");
                UpdaterActivity.this._ICC(UpdaterActivity.this.imageview5, "#FFFFFF", "#FFFFFF");
                UpdaterActivity.this._ICC(UpdaterActivity.this.imageview6, "#9E9E9E", "#9E9E9E");
                UpdaterActivity.this._ICC(UpdaterActivity.this.imageview7, "#9E9E9E", "#9E9E9E");
                if (UpdaterActivity.this.sharedPref2.getString("dark", "").equals("true")) {
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.exit_back, "#00000000", 3.0d, "#DF2029", 100.0d);
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.update1_back, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.close1_back, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                    return;
                }
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.exit_back, "#FFEFEF", 3.0d, "#DF2029", 100.0d);
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.update1_back, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.close1_back, "#00000000", 3.0d, "#E0E0E0", 100.0d);
            }
        });
        this.update1_back.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.UpdaterActivity.12 */

            public void onClick(View view) {
                UpdaterActivity.this.update1.setTextColor(-16744723);
                UpdaterActivity.this.exit1.setTextColor(-6381922);
                UpdaterActivity.this.warning1.setTextColor(-6381922);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.update1_back, "elevation", 5.0d, 100.0d);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.exit_back, "elevation", 0.0d, 100.0d);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.close1_back, "elevation", 0.0d, 100.0d);
                UpdaterActivity.this.mainClickAction = "browser";
                UpdaterActivity.this._autoTransitionScroll(UpdaterActivity.this.vscroll1);
                UpdaterActivity.this.edittext8.setVisibility(View.VISIBLE);
                UpdaterActivity.this.linear24.setVisibility(View.VISIBLE);
                UpdaterActivity.this._ICC(UpdaterActivity.this.imageview5, "#9E9E9E", "#9E9E9E");
                UpdaterActivity.this._ICC(UpdaterActivity.this.imageview6, "#FFFFFF", "#FFFFFF");
                UpdaterActivity.this._ICC(UpdaterActivity.this.imageview7, "#9E9E9E", "#9E9E9E");
                UpdaterActivity.this._setBgCorners(UpdaterActivity.this.imageview5, 90.0d, "#00000000");
                UpdaterActivity.this._setBgCorners(UpdaterActivity.this.imageview6, 90.0d, "#007EED");
                UpdaterActivity.this._setBgCorners(UpdaterActivity.this.imageview7, 90.0d, "#00000000");
                if (UpdaterActivity.this.sharedPref2.getString("dark", "").equals("true")) {
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.exit_back, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.update1_back, "#00000000", 3.0d, "#007EED", 100.0d);
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.close1_back, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                    return;
                }
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.exit_back, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.update1_back, "#E0EBF6", 3.0d, "#007EED", 100.0d);
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.close1_back, "#00000000", 3.0d, "#E0E0E0", 100.0d);
            }
        });
        this.close1_back.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.UpdaterActivity.13 */

            public void onClick(View view) {
                UpdaterActivity.this.warning1.setTextColor(-688896);
                UpdaterActivity.this.update1.setTextColor(-6381922);
                UpdaterActivity.this.exit1.setTextColor(-6381922);
                UpdaterActivity.this.mainClickAction = "dismiss";
                UpdaterActivity.this._autoTransitionScroll(UpdaterActivity.this.vscroll1);
                UpdaterActivity.this.edittext8.setVisibility(View.GONE);
                UpdaterActivity.this.linear24.setVisibility(View.GONE);
                UpdaterActivity.this._ICC(UpdaterActivity.this.imageview6, "#9E9E9E", "#9E9E9E");
                UpdaterActivity.this._ICC(UpdaterActivity.this.imageview5, "#9E9E9E", "#9E9E9E");
                UpdaterActivity.this._ICC(UpdaterActivity.this.imageview7, "#FFFFFF", "#FFFFFF");
                UpdaterActivity.this._setBgCorners(UpdaterActivity.this.imageview5, 90.0d, "#00000000");
                UpdaterActivity.this._setBgCorners(UpdaterActivity.this.imageview6, 90.0d, "#00000000");
                UpdaterActivity.this._setBgCorners(UpdaterActivity.this.imageview7, 90.0d, "#F57D00");
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.exit_back, "elevation", 0.0d, 100.0d);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.update1_back, "elevation", 0.0d, 100.0d);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.close1_back, "elevation", 5.0d, 100.0d);
                if (UpdaterActivity.this.sharedPref2.getString("dark", "").equals("true")) {
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.exit_back, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.update1_back, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.close1_back, "#00000000", 3.0d, "#F57D00", 100.0d);
                    return;
                }
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.exit_back, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.update1_back, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.close1_back, "#FFF3E7", 3.0d, "#F57D00", 100.0d);
            }
        });
        this.switch_back2.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.UpdaterActivity.14 */

            public void onClick(View view) {
                UpdaterActivity.this._transitionViewTime(UpdaterActivity.this.linear1, 150.0d);
                if (UpdaterActivity.this.isSwitch2Enabled) {
                    if (UpdaterActivity.this.sharedPref2.getString("dark", "").equals("true")) {
                        UpdaterActivity.this._setViewRadius(UpdaterActivity.this.switch_back2, 90.0d, "#424242");
                        UpdaterActivity.this._setViewRadius(UpdaterActivity.this.switch_btn2, 90.0d, "#2196F3");
                    } else {
                        UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.switch_back2, "#EEEEEE", 1.0d, "#E0E0E0", 90.0d);
                        UpdaterActivity.this._setViewRadius(UpdaterActivity.this.switch_btn2, 90.0d, "#2196F3");
                    }
                    UpdaterActivity.this.isSwitch2Enabled = false;
                    UpdaterActivity.this.button2 = false;
                    UpdaterActivity.this.edittext6.setVisibility(View.GONE);
                    UpdaterActivity.this.linear29.setVisibility(View.GONE);
                    UpdaterActivity.this.hscroll2.setVisibility(View.GONE);
                    if (UpdaterActivity.this.extraClickAction.equals("browser")) {
                        UpdaterActivity.this.edittext7.setVisibility(View.VISIBLE);
                        UpdaterActivity.this.linear23.setVisibility(View.VISIBLE);
                    } else {
                        UpdaterActivity.this.edittext7.setVisibility(View.GONE);
                        UpdaterActivity.this.linear23.setVisibility(View.GONE);
                    }
                    UpdaterActivity.this.switch_back2.setGravity(3);
                    return;
                }
                if (UpdaterActivity.this.sharedPref2.getString("dark", "").equals("true")) {
                    UpdaterActivity.this._setViewRadius(UpdaterActivity.this.switch_back2, 90.0d, "#2196F3");
                    UpdaterActivity.this._setViewRadius(UpdaterActivity.this.switch_btn2, 90.0d, "#FFFFFF");
                } else {
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.switch_back2, "#2196F3", 1.0d, "#E0E0E0", 90.0d);
                    UpdaterActivity.this._setViewRadius(UpdaterActivity.this.switch_btn2, 90.0d, "#FFFFFF");
                }
                UpdaterActivity.this.button2 = true;
                UpdaterActivity.this.isSwitch2Enabled = true;
                UpdaterActivity.this.edittext6.setVisibility(View.VISIBLE);
                UpdaterActivity.this.linear29.setVisibility(View.VISIBLE);
                UpdaterActivity.this.hscroll2.setVisibility(View.VISIBLE);
                UpdaterActivity.this.switch_back2.setGravity(5);
            }
        });
        this.exit2_back.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.UpdaterActivity.15 */

            public void onClick(View view) {
                UpdaterActivity.this.exit2.setTextColor(-2154455);
                UpdaterActivity.this.url2.setTextColor(-6381922);
                UpdaterActivity.this.dismiss2.setTextColor(-6381922);
                UpdaterActivity.this.extraClickAction = "exit";
                UpdaterActivity.this._autoTransitionScroll(UpdaterActivity.this.vscroll1);
                UpdaterActivity.this.edittext7.setVisibility(View.GONE);
                UpdaterActivity.this.linear23.setVisibility(View.GONE);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.exit2_back, "elevation", 5.0d, 100.0d);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.update2_back, "elevation", 0.0d, 100.0d);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.dismiss2_back, "elevation", 0.0d, 100.0d);
                UpdaterActivity.this._setBgCorners(UpdaterActivity.this.imageview8, 90.0d, "#df2029");
                UpdaterActivity.this._setBgCorners(UpdaterActivity.this.imageview9, 90.0d, "#00000000");
                UpdaterActivity.this._setBgCorners(UpdaterActivity.this.imageview10, 90.0d, "#00000000");
                UpdaterActivity.this._ICC(UpdaterActivity.this.imageview8, "#FFFFFF", "#FFFFFF");
                UpdaterActivity.this._ICC(UpdaterActivity.this.imageview9, "#9E9E9E", "#9E9E9E");
                UpdaterActivity.this._ICC(UpdaterActivity.this.imageview10, "#9E9E9E", "#9E9E9E");
                if (UpdaterActivity.this.sharedPref2.getString("dark", "").equals("true")) {
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.exit2_back, "#00000000", 3.0d, "#DF2029", 100.0d);
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.update2_back, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.dismiss2_back, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                    return;
                }
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.exit2_back, "#FFEFEF", 3.0d, "#DF2029", 100.0d);
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.update2_back, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.dismiss2_back, "#00000000", 3.0d, "#E0E0E0", 100.0d);
            }
        });
        this.update2_back.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.UpdaterActivity.16 */

            public void onClick(View view) {
                UpdaterActivity.this.url2.setTextColor(-16748306);
                UpdaterActivity.this.exit2.setTextColor(-6381922);
                UpdaterActivity.this.dismiss2.setTextColor(-6381922);
                UpdaterActivity.this.extraClickAction = "browser";
                UpdaterActivity.this._autoTransitionScroll(UpdaterActivity.this.vscroll1);
                UpdaterActivity.this.edittext7.setVisibility(View.VISIBLE);
                UpdaterActivity.this.linear23.setVisibility(View.VISIBLE);
                UpdaterActivity.this._ICC(UpdaterActivity.this.imageview8, "#9E9E9E", "#9E9E9E");
                UpdaterActivity.this._ICC(UpdaterActivity.this.imageview9, "#FFFFFF", "#FFFFFF");
                UpdaterActivity.this._ICC(UpdaterActivity.this.imageview10, "#9E9E9E", "#9E9E9E");
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.exit2_back, "elevation", 0.0d, 100.0d);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.update2_back, "elevation", 5.0d, 100.0d);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.dismiss2_back, "elevation", 0.0d, 100.0d);
                UpdaterActivity.this._setBgCorners(UpdaterActivity.this.imageview8, 90.0d, "#00000000");
                UpdaterActivity.this._setBgCorners(UpdaterActivity.this.imageview9, 90.0d, "#007EED");
                UpdaterActivity.this._setBgCorners(UpdaterActivity.this.imageview10, 90.0d, "#00000000");
                if (UpdaterActivity.this.sharedPref2.getString("dark", "").equals("true")) {
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.exit2_back, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.update2_back, "#00000000", 3.0d, "#007EED", 100.0d);
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.dismiss2_back, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                    return;
                }
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.update2_back, "#E0EBF6", 3.0d, "#007EED", 100.0d);
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.exit2_back, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.dismiss2_back, "#00000000", 3.0d, "#E0E0E0", 100.0d);
            }
        });
        this.dismiss2_back.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.UpdaterActivity.17 */

            public void onClick(View view) {
                UpdaterActivity.this.dismiss2.setTextColor(-688896);
                UpdaterActivity.this.url2.setTextColor(-6381922);
                UpdaterActivity.this.exit2.setTextColor(-6381922);
                UpdaterActivity.this.extraClickAction = "dismiss";
                UpdaterActivity.this._autoTransitionScroll(UpdaterActivity.this.vscroll1);
                UpdaterActivity.this.edittext7.setVisibility(View.GONE);
                UpdaterActivity.this.linear23.setVisibility(View.GONE);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.dismiss2_back, "elevation", 5.0d, 100.0d);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.update2_back, "elevation", 0.0d, 100.0d);
                UpdaterActivity.this._shadAnim(UpdaterActivity.this.exit2_back, "elevation", 0.0d, 100.0d);
                UpdaterActivity.this._ICC(UpdaterActivity.this.imageview10, "#FFFFFF", "#FFFFFF");
                UpdaterActivity.this._ICC(UpdaterActivity.this.imageview8, "#9E9E9E", "#9E9E9E");
                UpdaterActivity.this._ICC(UpdaterActivity.this.imageview9, "#9E9E9E", "#9E9E9E");
                UpdaterActivity.this._setBgCorners(UpdaterActivity.this.imageview8, 90.0d, "#00000000");
                UpdaterActivity.this._setBgCorners(UpdaterActivity.this.imageview9, 90.0d, "#00000000");
                UpdaterActivity.this._setBgCorners(UpdaterActivity.this.imageview10, 90.0d, "#F57D00");
                if (UpdaterActivity.this.sharedPref2.getString("dark", "").equals("true")) {
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.exit2_back, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.update2_back, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.dismiss2_back, "#00000000", 3.0d, "#F57D00", 100.0d);
                    return;
                }
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.dismiss2_back, "#FFF3E7", 3.0d, "#F57D00", 100.0d);
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.exit2_back, "#00000000", 3.0d, "#E0E0E0", 100.0d);
                UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.update2_back, "#00000000", 3.0d, "#E0E0E0", 100.0d);
            }
        });
        this.imageview4.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.UpdaterActivity.18 */

            /* JADX WARN: Type inference failed for: r4v0, types: [android.content.Context, com.updatify.o2nation.UpdaterActivity] */
            /* JADX WARN: Type inference failed for: r10v2, types: [android.content.Context, com.updatify.o2nation.UpdaterActivity] */
            /* JADX WARN: Type inference failed for: r10v7, types: [android.content.Context, com.updatify.o2nation.UpdaterActivity] */
            /* JADX WARNING: Unknown variable types count: 3 */
            public void onClick(View view) {
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog((Context) UpdaterActivity.this);
                View inflate = UpdaterActivity.this.getLayoutInflater().inflate(R.layout.creat_sheet, (ViewGroup) null);
                bottomSheetDialog.setContentView(inflate);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.background);
                LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.linear14);
                LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(R.id.linear15);
                LinearLayout linearLayout4 = (LinearLayout) inflate.findViewById(R.id.scroller);
                LinearLayout linearLayout5 = (LinearLayout) inflate.findViewById(R.id.linear14);
                LinearLayout linearLayout6 = (LinearLayout) inflate.findViewById(R.id.linear3);
                LinearLayout linearLayout7 = (LinearLayout) inflate.findViewById(R.id.linear6);
                EditText editText = (EditText) inflate.findViewById(R.id.edittext1);
                TextView textView = (TextView) inflate.findViewById(R.id.done_btn);
                TextView textView2 = (TextView) inflate.findViewById(R.id.title2);
                TextView textView3 = (TextView) inflate.findViewById(R.id.textview5);
                TextView textView4 = (TextView) inflate.findViewById(R.id.close_btn);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.img1);
                LinearLayout linearLayout8 = (LinearLayout) inflate.findViewById(R.id.linear_np_vc_1);
                LinearLayout linearLayout9 = (LinearLayout) inflate.findViewById(R.id.linear_np_vc_2);
                final NumberPicker numberPicker = new NumberPicker(UpdaterActivity.this);
                numberPicker.setMaxValue(50);
                numberPicker.setMinValue(0);
                numberPicker.setWrapSelectorWheel(true);
                numberPicker.setValue(1);
                linearLayout9.addView(numberPicker);
                final NumberPicker numberPicker2 = new NumberPicker(UpdaterActivity.this);
                numberPicker2.setMaxValue(50);
                numberPicker2.setMinValue(0);
                numberPicker2.setWrapSelectorWheel(true);
                numberPicker2.setValue(1);
                linearLayout8.addView(numberPicker2);
                textView.setTypeface(Typeface.createFromAsset(UpdaterActivity.this.getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
                textView4.setTypeface(Typeface.createFromAsset(UpdaterActivity.this.getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
                textView.setText("Choose");
                textView4.setText("Close");
                linearLayout5.setVisibility(View.GONE);
                linearLayout6.setVisibility(View.GONE);
                linearLayout3.setVisibility(View.GONE);
                ((LinearLayout) inflate.findViewById(R.id.line)).setVisibility(View.GONE);
                ((LinearLayout) inflate.findViewById(R.id.line2)).setVisibility(View.GONE);
                UpdaterActivity.this._advancedCorners(linearLayout8, "#FFFFFF", 25.0d, 0.0d, 25.0d, 0.0d);
                UpdaterActivity.this._advancedCorners(linearLayout9, "#FFFFFF", 0.0d, 25.0d, 0.0d, 25.0d);
                UpdaterActivity.this._RoundAndBorder(linearLayout4, "#CCFFFFFF", 0.0d, "#FFFFFF", 100.0d);
                UpdaterActivity.this._rippleRoundStroke(textView, "#FF016DE7", "#16FFFFFF", 25.0d, 0.0d, "#00B7F0");
                if (UpdaterActivity.this.sharedPref2.getString("dark", "").equals("true")) {
                    UpdaterActivity.this._advancedCorners(linearLayout, "#181818", 25.0d, 25.0d, 25.0d, 25.0d);
                    UpdaterActivity.this._rippleRoundStroke(textView4, "#424242", "#212121", 25.0d, 0.0d, "#00B7F0");
                    textView4.setTextColor(-1);
                } else {
                    UpdaterActivity.this._advancedCorners(linearLayout, "#ffffff", 25.0d, 25.0d, 25.0d, 25.0d);
                    UpdaterActivity.this._rippleRoundStroke(textView4, "#F5F5F5", "#16000000", 25.0d, 0.0d, "#00B7F0");
                }
                textView.setOnClickListener(new View.OnClickListener() {
                    /* class com.updatify.o2nation.UpdaterActivity.18.1 */

                    public void onClick(View view) {
                        UpdaterActivity.this.textview34.setText(String.valueOf((long) numberPicker2.getValue()).concat(".".concat(String.valueOf((long) numberPicker.getValue()))));
                        UpdaterActivity.this.newVersion_ = String.valueOf((long) numberPicker2.getValue()).concat(".".concat(String.valueOf((long) numberPicker.getValue())));
                        bottomSheetDialog.dismiss();
                    }
                });
                textView4.setOnClickListener(new View.OnClickListener() {
                    /* class com.updatify.o2nation.UpdaterActivity.18.2 */

                    public void onClick(View view) {
                        bottomSheetDialog.dismiss();
                    }
                });
                bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(17170445);
                bottomSheetDialog.show();
            }
        });
        this.checkbox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.updatify.o2nation.UpdaterActivity.19 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            }
        });
        this.textview51.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.UpdaterActivity.20 */

            public void onClick(View view) {
                if (UpdaterActivity.this.sheetBehavior.getState() == 3) {
                    UpdaterActivity.this.sheetBehavior.setState(4);
                }
                if (FirebaseAuth.getInstance().getCurrentUser() == null) {
                    UpdaterActivity.this.tologin.setClass(UpdaterActivity.this.getApplicationContext(), Auth2Activity.class);
                    UpdaterActivity.this.startActivity(UpdaterActivity.this.tologin);
                    UpdaterActivity.this.finish();
                } else if (UpdaterActivity.this.edittext1.getText().toString().trim().equals("")) {
                    UpdaterActivity.this._Snackbar_API("Dialog title is required", "", "short");
                } else if (UpdaterActivity.this.edittext4.getText().toString().trim().equals("")) {
                    UpdaterActivity.this._Snackbar_API("Dialog subtitle is required", "", "short");
                } else if (UpdaterActivity.this.publishKey.equals("null")) {
                    UpdaterActivity.this._Snackbar_API("App could not be updated due to an unexpected issue. [key]", "", "short");
                } else if (UpdaterActivity.this.isSwitch1Enabled) {
                    if (UpdaterActivity.this.edittext9.getText().toString().trim().equals("")) {
                        UpdaterActivity.this._Snackbar_API("Main button text is required", "", "short");
                    } else if (UpdaterActivity.this.mainClickAction.equals("browser")) {
                        if (UpdaterActivity.this.edittext8.getText().toString().trim().equals("")) {
                            UpdaterActivity.this._Snackbar_API("Link is required", "", "long");
                        } else if (!UpdaterActivity.this.isSwitch2Enabled) {
                            UpdaterActivity.this._sendUpdate();
                        } else if (UpdaterActivity.this.edittext6.getText().toString().trim().equals("")) {
                            UpdaterActivity.this._Snackbar_API("Extra button text is required", "", "short");
                        } else if (!UpdaterActivity.this.extraClickAction.equals("browser")) {
                            UpdaterActivity.this._sendUpdate();
                        } else if (UpdaterActivity.this.edittext7.getText().toString().trim().equals("")) {
                            UpdaterActivity.this._Snackbar_API("Link is required", "", "long");
                        } else {
                            UpdaterActivity.this._sendUpdate();
                        }
                    } else if (!UpdaterActivity.this.isSwitch2Enabled) {
                        UpdaterActivity.this._sendUpdate();
                    } else if (UpdaterActivity.this.edittext6.getText().toString().trim().equals("")) {
                        UpdaterActivity.this._Snackbar_API("Extra button text is required", "", "short");
                    } else if (!UpdaterActivity.this.extraClickAction.equals("browser")) {
                        UpdaterActivity.this._sendUpdate();
                    } else if (UpdaterActivity.this.edittext7.getText().toString().trim().equals("")) {
                        UpdaterActivity.this._Snackbar_API("Link is required", "", "long");
                    } else {
                        UpdaterActivity.this._sendUpdate();
                    }
                } else if (!UpdaterActivity.this.isSwitch2Enabled) {
                    UpdaterActivity.this._sendUpdate();
                } else if (UpdaterActivity.this.edittext6.getText().toString().trim().equals("")) {
                    UpdaterActivity.this._Snackbar_API("Extra button text is required", "", "short");
                } else if (!UpdaterActivity.this.extraClickAction.equals("browser")) {
                    UpdaterActivity.this._sendUpdate();
                } else if (UpdaterActivity.this.edittext7.getText().toString().trim().equals("")) {
                    UpdaterActivity.this._Snackbar_API("Link is required", "", "long");
                } else {
                    UpdaterActivity.this._sendUpdate();
                }
            }
        });
        this.textview25.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.UpdaterActivity.21 */

            /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, com.updatify.o2nation.UpdaterActivity] */
            /* JADX WARNING: Unknown variable types count: 1 */
            public void onClick(View view) {
                UpdaterActivity.this._Snackbar_API("Draft has been saved", "", "");
                UpdaterActivity.this._saveNewDraft();
                UpdaterActivity.this.fbInterstitial.show();
                UpdaterActivity.this.fbInterstitial = new InterstitialAd((Context) UpdaterActivity.this, "278142536768563_320780439171439");
                UpdaterActivity.this.fbInterstitial.loadAd();
            }
        });
        this.textview33.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.UpdaterActivity.22 */

            public void onClick(View view) {
                UpdaterActivity.this._previewDialog(UpdaterActivity.this.alertOption);
            }
        });
        this._DBUsers_child_listener = new ChildEventListener() {
            /* class com.updatify.o2nation.UpdaterActivity.23 */

            public void onChildAdded(DataSnapshot dataSnapshot, String str) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.UpdaterActivity.23.1 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
            }

            public void onChildChanged(DataSnapshot dataSnapshot, String str) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.UpdaterActivity.23.2 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
            }

            public void onChildMoved(DataSnapshot dataSnapshot, String str) {
            }

            public void onChildRemoved(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.UpdaterActivity.23.3 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
            }

            public void onCancelled(DatabaseError databaseError) {
                databaseError.getCode();
                databaseError.getMessage();
            }
        };
        this.DBUsers.addChildEventListener(this._DBUsers_child_listener);
        this._requestProjects_request_listener = new RequestNetwork.RequestListener() {
            /* class com.updatify.o2nation.UpdaterActivity.24 */

            /* JADX WARN: Type inference failed for: r2v13, types: [android.content.Context, com.updatify.o2nation.UpdaterActivity] */
            /* JADX WARN: Type inference failed for: r4v42, types: [android.content.Context, com.updatify.o2nation.UpdaterActivity] */
            /* JADX WARNING: Unknown variable types count: 2 */
            @Override // com.updatify.o2nation.RequestNetwork.RequestListener
            public void onResponse(String str, String str2, HashMap<String, Object> hashMap) {
                try {
                    UpdaterActivity.this.calendar = Calendar.getInstance();
                    if (str2.toLowerCase().contains("not allowed")) {
                        UpdaterActivity.this._Snackbar_API("App could not be updated due to an unexpected issue. [not allowed]", "", "long");
                    } else if (str2.toLowerCase().equals("{\"status\":true,\"errors\":[]}")) {
                        UpdaterActivity.this._saveNewDraft();
                        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog((Context) UpdaterActivity.this);
                        View inflate = UpdaterActivity.this.getLayoutInflater().inflate(R.layout.info_sheet, (ViewGroup) null);
                        bottomSheetDialog.setContentView(inflate);
                        bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(17170445);
                        TextView textView = (TextView) inflate.findViewById(R.id.infosheet_ok);
                        TextView textView2 = (TextView) inflate.findViewById(R.id.infosheet_cancel);
                        TextView textView3 = (TextView) inflate.findViewById(R.id.infosheet_title);
                        TextView textView4 = (TextView) inflate.findViewById(R.id.infosheet_sub);
                        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.infosheet_back);
                        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.infosheet_btn_holder);
                        textView3.setTypeface(Typeface.createFromAsset(UpdaterActivity.this.getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
                        textView4.setTypeface(Typeface.createFromAsset(UpdaterActivity.this.getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
                        textView.setTypeface(Typeface.createFromAsset(UpdaterActivity.this.getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
                        textView2.setTypeface(Typeface.createFromAsset(UpdaterActivity.this.getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
                        ((ImageView) inflate.findViewById(R.id.infosheet_img)).setImageResource(R.drawable.rocket_boy_flatline);
                        textView3.setText("Notification sent successfully!");
                        textView.setVisibility(View.GONE);
                        textView4.setText(UpdaterActivity.this.getIntent().getStringExtra("title").concat(" has been updated to version ".concat(UpdaterActivity.this.newVersion_)));
                        UpdaterActivity.this._rippleRoundStroke(textView, "#006DF6", "#16FFFFFF", 25.0d, 0.0d, "#006DF6");
                        if (UpdaterActivity.this.sharedPref2.getString("dark", "").equals("true")) {
                            UpdaterActivity.this._advancedCorners(linearLayout, "#181818", 25.0d, 25.0d, 25.0d, 25.0d);
                            UpdaterActivity.this._rippleRoundStroke(textView2, "#424242", "#212121", 25.0d, 0.0d, "#006DF6");
                            textView2.setTextColor(-1);
                            textView3.setTextColor(-1);
                        } else {
                            UpdaterActivity.this._advancedCorners(linearLayout, "#ffffff", 25.0d, 25.0d, 25.0d, 25.0d);
                            UpdaterActivity.this._rippleRoundStroke(textView2, "#F5F5F5", "#E0E0E0", 25.0d, 0.0d, "#006DF6");
                        }
                        textView.setOnClickListener(new View.OnClickListener() {
                            /* class com.updatify.o2nation.UpdaterActivity.24.1 */

                            public void onClick(View view) {
                                bottomSheetDialog.dismiss();
                            }
                        });
                        textView2.setOnClickListener(new View.OnClickListener() {
                            /* class com.updatify.o2nation.UpdaterActivity.24.2 */

                            public void onClick(View view) {
                                bottomSheetDialog.dismiss();
                            }
                        });
                        bottomSheetDialog.show();
                        UpdaterActivity.this.projectsMap.put("currVersion", UpdaterActivity.this.newVersion_);
                        if (UpdaterActivity.this.dialogTheme.equals("warning")) {
                            UpdaterActivity.this.projectsMap.put("status", "Warned on ".concat(new SimpleDateFormat("dd/MM/yyyy").format(UpdaterActivity.this.calendar.getTime())));
                        } else if (UpdaterActivity.this.dialogTheme.equals("update")) {
                            UpdaterActivity.this.projectsMap.put("status", "Updated on ".concat(new SimpleDateFormat("dd/MM/yyyy").format(UpdaterActivity.this.calendar.getTime()).concat(" to version ".concat(UpdaterActivity.this.newVersion_))));
                        } else {
                            UpdaterActivity.this.projectsMap.put("status", "Sent message on ".concat(new SimpleDateFormat("dd/MM/yyyy").format(UpdaterActivity.this.calendar.getTime())));
                        }
                        if (UpdaterActivity.this.dialogTheme.equals("warning")) {
                            UpdaterActivity.this.projectsMap.put("color", "#BD081C");
                        } else if (UpdaterActivity.this.dialogTheme.equals("message")) {
                            UpdaterActivity.this.projectsMap.put("color", "#F57D00");
                        } else if (UpdaterActivity.this.sharedPref.getString("customDialog", "").equals("")) {
                            UpdaterActivity.this.projectsMap.put("color", "#0084FF");
                        } else {
                            UpdaterActivity.this.projectsMap.put("color", UpdaterActivity.this.sharedPref.getString("customDialogAccent", ""));
                        }
                        UpdaterActivity.this.DBUserProjects.child(UpdaterActivity.this.getIntent().getStringExtra("key")).updateChildren(UpdaterActivity.this.projectsMap);
                        UpdaterActivity.this.projectsMap.clear();
                        UpdaterActivity.this.logsMap = new HashMap();
                        UpdaterActivity.this.logsMap.put("appname", UpdaterActivity.this.getIntent().getStringExtra("title"));
                        if (UpdaterActivity.this.dialogTheme.equals("warning")) {
                            UpdaterActivity.this.logsMap.put("status", "Warned on ".concat(new SimpleDateFormat("dd/MM/yyyy").format(UpdaterActivity.this.calendar.getTime())));
                        } else if (UpdaterActivity.this.dialogTheme.equals("update")) {
                            UpdaterActivity.this.logsMap.put("status", "Updated on ".concat(new SimpleDateFormat("dd/MM/yyyy").format(UpdaterActivity.this.calendar.getTime()).concat(" to version ".concat(UpdaterActivity.this.newVersion_))));
                        } else {
                            UpdaterActivity.this.logsMap.put("status", "Sent message on ".concat(new SimpleDateFormat("dd/MM/yyyy").format(UpdaterActivity.this.calendar.getTime())));
                        }
                        UpdaterActivity.this.logsMap.put("uid", "");
                        if (UpdaterActivity.this.dialogTheme.equals("warning")) {
                            UpdaterActivity.this.logsMap.put("color", "#BD081C");
                        } else if (UpdaterActivity.this.dialogTheme.equals("update")) {
                            UpdaterActivity.this.logsMap.put("color", "#0084FF");
                        } else {
                            UpdaterActivity.this.logsMap.put("color", "#F57D00");
                        }
                        UpdaterActivity.this.logTempKey = UpdaterActivity.this.DBPushUsers.push().getKey();
                        UpdaterActivity.this.DBPushUsers.child("".concat("/LOGS/".concat(UpdaterActivity.this.logTempKey))).updateChildren(UpdaterActivity.this.logsMap);
                        UpdaterActivity.this.logsMap.clear();
                        UpdaterActivity.this.fbInterstitial.show();
                        UpdaterActivity.this.fbInterstitial = new InterstitialAd((Context) UpdaterActivity.this, "278142536768563_320780439171439");
                        UpdaterActivity.this.fbInterstitial.loadAd();
                    } else if (str2.toLowerCase().equals("{\"status\":false,\"errors\":[\"file not exists\"]}")) {
                        UpdaterActivity.this._Snackbar_API("This project is not available in our servers, it might be deleted.", "", "long");
                    } else {
                        UpdaterActivity.this._Snackbar_API("App could not be updated due to an unexpected issue. ".concat("[".concat(str2).concat("]")), "", "long");
                    }
                    UpdaterActivity.this._coreLoading(false, "#FFFFFF", 25.0d, "#FFFFFF", 0.0d);
                } catch (Exception e) {
                    UpdaterActivity.this._Snackbar_API("Random error: ".concat(e.toString()), "", "long");
                }
            }

            @Override // com.updatify.o2nation.RequestNetwork.RequestListener
            public void onErrorResponse(String str, String str2) {
                UpdaterActivity.this._Snackbar_API("Check your network then try again", "", "long");
                UpdaterActivity.this._coreLoading(false, "#FFFFFF", 25.0d, "#FFFFFF", 0.0d);
            }
        };
        this._DBManager_child_listener = new ChildEventListener() {
            /* class com.updatify.o2nation.UpdaterActivity.25 */

            public void onChildAdded(DataSnapshot dataSnapshot, String str) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.UpdaterActivity.25.1 */
                };
                String key = dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
                if (key.equals("publish")) {
                    UpdaterActivity.this._decryptString(hashMap.get("publishKey").toString(), new Object() {
                        /* class com.updatify.o2nation.UpdaterActivity.25.2 */
                        int t;

                        public String toString() {
                            this.t = -1462938080;
                            this.t = -422301062;
                            this.t = -40478172;
                            this.t = -772474458;
                            this.t = -1501905297;
                            this.t = -1127858665;
                            this.t = -1008328564;
                            this.t = 338466366;
                            this.t = 899067179;
                            this.t = 103817909;
                            this.t = -291383262;
                            this.t = 1440747590;
                            this.t = -701157971;
                            this.t = 1637869611;
                            this.t = -758050477;
                            this.t = 1196853863;
                            this.t = -630508879;
                            this.t = -852017678;
                            this.t = 2038778243;
                            this.t = 1222813723;
                            this.t = 1118712162;
                            this.t = 1763795626;
                            this.t = 160148237;
                            this.t = 1345401412;
                            this.t = 699363051;
                            this.t = 151587091;
                            this.t = -357389040;
                            this.t = 743055269;
                            this.t = 1150938367;
                            this.t = -270984684;
                            this.t = 345762927;
                            this.t = 224289383;
                            this.t = -2082183599;
                            this.t = 974383928;
                            this.t = 1352312338;
                            this.t = 530090646;
                            this.t = -1012823267;
                            this.t = 1923394348;
                            this.t = 1391419555;
                            this.t = 95599002;
                            this.t = 1106558366;
                            this.t = 435791939;
                            this.t = 898728210;
                            this.t = 1282348767;
                            this.t = -1926037919;
                            this.t = 1511326962;
                            this.t = 69906194;
                            this.t = 413993029;
                            this.t = 1522930889;
                            this.t = -1745329580;
                            this.t = -1395168871;
                            this.t = -323398528;
                            this.t = 1618957697;
                            this.t = 674323622;
                            this.t = 770214244;
                            this.t = -1501064223;
                            this.t = -1355304948;
                            this.t = -1140800052;
                            this.t = -1940807824;
                            this.t = 1320347259;
                            this.t = -1460980423;
                            this.t = -1991946805;
                            this.t = -931469950;
                            this.t = 961999303;
                            this.t = -1172769627;
                            this.t = -1234764979;
                            this.t = 1687611040;
                            this.t = 1963165296;
                            this.t = -949644969;
                            this.t = 230708256;
                            this.t = 409057686;
                            this.t = -1997730496;
                            this.t = -508909315;
                            this.t = 1892816311;
                            this.t = 1116936051;
                            this.t = 825811714;
                            this.t = 719543218;
                            this.t = 305556903;
                            return new String(new byte[]{(byte) (this.t >>> 10), (byte) (this.t >>> 14), (byte) (this.t >>> 3), (byte) (this.t >>> 3), (byte) (this.t >>> 1), (byte) (this.t >>> 13), (byte) (this.t >>> 1), (byte) (this.t >>> 15), (byte) (this.t >>> 24), (byte) (this.t >>> 7), (byte) (this.t >>> 15), (byte) (this.t >>> 24), (byte) (this.t >>> 12), (byte) (this.t >>> 19), (byte) (this.t >>> 22), (byte) (this.t >>> 1), (byte) (this.t >>> 13), (byte) (this.t >>> 16), (byte) (this.t >>> 3), (byte) (this.t >>> 7), (byte) (this.t >>> 19), (byte) (this.t >>> 15), (byte) (this.t >>> 21), (byte) (this.t >>> 16), (byte) (this.t >>> 19), (byte) (this.t >>> 21), (byte) (this.t >>> 11), (byte) (this.t >>> 13), (byte) (this.t >>> 24), (byte) (this.t >>> 7), (byte) (this.t >>> 15), (byte) (this.t >>> 9), (byte) (this.t >>> 12), (byte) (this.t >>> 5), (byte) (this.t >>> 15), (byte) (this.t >>> 9), (byte) (this.t >>> 15), (byte) (this.t >>> 9), (byte) (this.t >>> 24), (byte) (this.t >>> 3), (byte) (this.t >>> 12), (byte) (this.t >>> 23), (byte) (this.t >>> 20), (byte) (this.t >>> 17), (byte) (this.t >>> 1), (byte) (this.t >>> 12), (byte) (this.t >>> 11), (byte) (this.t >>> 5), (byte) (this.t >>> 4), (byte) (this.t >>> 9), (byte) (this.t >>> 18), (byte) (this.t >>> 4), (byte) (this.t >>> 8), (byte) (this.t >>> 23), (byte) (this.t >>> 9), (byte) (this.t >>> 21), (byte) (this.t >>> 16), (byte) (this.t >>> 10), (byte) (this.t >>> 14), (byte) (this.t >>> 17), (byte) (this.t >>> 8), (byte) (this.t >>> 16), (byte) (this.t >>> 21), (byte) (this.t >>> 18), (byte) (this.t >>> 1), (byte) (this.t >>> 17), (byte) (this.t >>> 17), (byte) (this.t >>> 5), (byte) (this.t >>> 12), (byte) (this.t >>> 22), (byte) (this.t >>> 17), (byte) (this.t >>> 2), (byte) (this.t >>> 11), (byte) (this.t >>> 11), (byte) (this.t >>> 14), (byte) (this.t >>> 24), (byte) (this.t >>> 12), (byte) (this.t >>> 22)});
                        }
                    }.toString());
                }
            }

            public void onChildChanged(DataSnapshot dataSnapshot, String str) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.UpdaterActivity.25.3 */
                };
                String key = dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
                if (key.equals("publish")) {
                    UpdaterActivity.this._decryptString(hashMap.get("publishKey").toString(), new Object() {
                        /* class com.updatify.o2nation.UpdaterActivity.25.4 */
                        int t;

                        public String toString() {
                            this.t = -1462938080;
                            this.t = -422301062;
                            this.t = -40478172;
                            this.t = -772474458;
                            this.t = -1501905297;
                            this.t = -1127858665;
                            this.t = -1008328564;
                            this.t = 338466366;
                            this.t = 899067179;
                            this.t = 103817909;
                            this.t = -291383262;
                            this.t = 1440747590;
                            this.t = -701157971;
                            this.t = 1637869611;
                            this.t = -758050477;
                            this.t = 1196853863;
                            this.t = -630508879;
                            this.t = -852017678;
                            this.t = 2038778243;
                            this.t = 1222813723;
                            this.t = 1118712162;
                            this.t = 1763795626;
                            this.t = 160148237;
                            this.t = 1345401412;
                            this.t = 699363051;
                            this.t = 151587091;
                            this.t = -357389040;
                            this.t = 743055269;
                            this.t = 1150938367;
                            this.t = -270984684;
                            this.t = 345762927;
                            this.t = 224289383;
                            this.t = -2082183599;
                            this.t = 974383928;
                            this.t = 1352312338;
                            this.t = 530090646;
                            this.t = -1012823267;
                            this.t = 1923394348;
                            this.t = 1391419555;
                            this.t = 95599002;
                            this.t = 1106558366;
                            this.t = 435791939;
                            this.t = 898728210;
                            this.t = 1282348767;
                            this.t = -1926037919;
                            this.t = 1511326962;
                            this.t = 69906194;
                            this.t = 413993029;
                            this.t = 1522930889;
                            this.t = -1745329580;
                            this.t = -1395168871;
                            this.t = -323398528;
                            this.t = 1618957697;
                            this.t = 674323622;
                            this.t = 770214244;
                            this.t = -1501064223;
                            this.t = -1355304948;
                            this.t = -1140800052;
                            this.t = -1940807824;
                            this.t = 1320347259;
                            this.t = -1460980423;
                            this.t = -1991946805;
                            this.t = -931469950;
                            this.t = 961999303;
                            this.t = -1172769627;
                            this.t = -1234764979;
                            this.t = 1687611040;
                            this.t = 1963165296;
                            this.t = -949644969;
                            this.t = 230708256;
                            this.t = 409057686;
                            this.t = -1997730496;
                            this.t = -508909315;
                            this.t = 1892816311;
                            this.t = 1116936051;
                            this.t = 825811714;
                            this.t = 719543218;
                            this.t = 305556903;
                            return new String(new byte[]{(byte) (this.t >>> 10), (byte) (this.t >>> 14), (byte) (this.t >>> 3), (byte) (this.t >>> 3), (byte) (this.t >>> 1), (byte) (this.t >>> 13), (byte) (this.t >>> 1), (byte) (this.t >>> 15), (byte) (this.t >>> 24), (byte) (this.t >>> 7), (byte) (this.t >>> 15), (byte) (this.t >>> 24), (byte) (this.t >>> 12), (byte) (this.t >>> 19), (byte) (this.t >>> 22), (byte) (this.t >>> 1), (byte) (this.t >>> 13), (byte) (this.t >>> 16), (byte) (this.t >>> 3), (byte) (this.t >>> 7), (byte) (this.t >>> 19), (byte) (this.t >>> 15), (byte) (this.t >>> 21), (byte) (this.t >>> 16), (byte) (this.t >>> 19), (byte) (this.t >>> 21), (byte) (this.t >>> 11), (byte) (this.t >>> 13), (byte) (this.t >>> 24), (byte) (this.t >>> 7), (byte) (this.t >>> 15), (byte) (this.t >>> 9), (byte) (this.t >>> 12), (byte) (this.t >>> 5), (byte) (this.t >>> 15), (byte) (this.t >>> 9), (byte) (this.t >>> 15), (byte) (this.t >>> 9), (byte) (this.t >>> 24), (byte) (this.t >>> 3), (byte) (this.t >>> 12), (byte) (this.t >>> 23), (byte) (this.t >>> 20), (byte) (this.t >>> 17), (byte) (this.t >>> 1), (byte) (this.t >>> 12), (byte) (this.t >>> 11), (byte) (this.t >>> 5), (byte) (this.t >>> 4), (byte) (this.t >>> 9), (byte) (this.t >>> 18), (byte) (this.t >>> 4), (byte) (this.t >>> 8), (byte) (this.t >>> 23), (byte) (this.t >>> 9), (byte) (this.t >>> 21), (byte) (this.t >>> 16), (byte) (this.t >>> 10), (byte) (this.t >>> 14), (byte) (this.t >>> 17), (byte) (this.t >>> 8), (byte) (this.t >>> 16), (byte) (this.t >>> 21), (byte) (this.t >>> 18), (byte) (this.t >>> 1), (byte) (this.t >>> 17), (byte) (this.t >>> 17), (byte) (this.t >>> 5), (byte) (this.t >>> 12), (byte) (this.t >>> 22), (byte) (this.t >>> 17), (byte) (this.t >>> 2), (byte) (this.t >>> 11), (byte) (this.t >>> 11), (byte) (this.t >>> 14), (byte) (this.t >>> 24), (byte) (this.t >>> 12), (byte) (this.t >>> 22)});
                        }
                    }.toString());
                }
            }

            public void onChildMoved(DataSnapshot dataSnapshot, String str) {
            }

            public void onChildRemoved(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.UpdaterActivity.25.5 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
            }

            public void onCancelled(DatabaseError databaseError) {
                databaseError.getCode();
                databaseError.getMessage();
            }
        };
        this.DBManager.addChildEventListener(this._DBManager_child_listener);
        this._checkNet_request_listener = new RequestNetwork.RequestListener() {
            /* class com.updatify.o2nation.UpdaterActivity.26 */

            @Override // com.updatify.o2nation.RequestNetwork.RequestListener
            public void onResponse(String str, String str2, HashMap<String, Object> hashMap) {
                if (str.equals("delete")) {
                    UpdaterActivity.this.APIHeaders.put("key", UpdaterActivity.this.publishKey);
                    UpdaterActivity.this.APIHeaders.put("filename", UpdaterActivity.this.getIntent().getStringExtra("filename"));
                    UpdaterActivity.this.checkNet.setParams(UpdaterActivity.this.APIHeaders, 0);
                    UpdaterActivity.this.checkNet.startRequestNetwork(RequestNetworkController.POST, "https://nerbly.com/updatify/apiv1/?do=remove", "delete_file", UpdaterActivity.this._checkNet_request_listener);
                } else if (str.equals("delete_file")) {
                    UpdaterActivity.this.APIHeaders.clear();
                    UpdaterActivity.this.authMap = new HashMap();
                    UpdaterActivity.this.authMap.put("slots", String.valueOf((long) (Double.parseDouble(UpdaterActivity.this.getIntent().getStringExtra("slots")) - 1.0d)));
                    UpdaterActivity.this.DBUsers.child("").updateChildren(UpdaterActivity.this.authMap);
                    UpdaterActivity.this.authMap.clear();
                    UpdaterActivity.this.DBUserProjects.child(UpdaterActivity.this.getIntent().getStringExtra("key")).removeValue();
                    UpdaterActivity.this.logsMap = new HashMap();
                    UpdaterActivity.this.logsMap.put("appname", UpdaterActivity.this.getIntent().getStringExtra("title"));
                    UpdaterActivity.this.logsMap.put("status", "Deleted on ".concat(new SimpleDateFormat("dd/MM/yyyy").format(UpdaterActivity.this.calendar.getTime())));
                    UpdaterActivity.this.logsMap.put("uid", "");
                    UpdaterActivity.this.logsMap.put("color", "#BD081C");
                    UpdaterActivity.this.logTempKey = UpdaterActivity.this.DBPushUsers.push().getKey();
                    UpdaterActivity.this.DBPushUsers.child("".concat("/LOGS/".concat(UpdaterActivity.this.logTempKey))).updateChildren(UpdaterActivity.this.logsMap);
                    UpdaterActivity.this.logsMap.clear();
                    UpdaterActivity.this.timer.cancel();
                    UpdaterActivity.this._coreLoading(false, "#FFFFFF", 125.0d, "#FFFFFF", 0.0d);
                    UpdaterActivity.this.finish();
                }
            }

            @Override // com.updatify.o2nation.RequestNetwork.RequestListener
            public void onErrorResponse(String str, String str2) {
                UpdaterActivity.this._Snackbar_API("Check your network then try again", "", "long");
                UpdaterActivity.this._coreLoading(false, "#FFFFFF", 25.0d, "#FFFFFF", 0.0d);
            }
        };
        this._DBPushUsers_child_listener = new ChildEventListener() {
            /* class com.updatify.o2nation.UpdaterActivity.27 */

            public void onChildAdded(DataSnapshot dataSnapshot, String str) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.UpdaterActivity.27.1 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
            }

            public void onChildChanged(DataSnapshot dataSnapshot, String str) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.UpdaterActivity.27.2 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
            }

            public void onChildMoved(DataSnapshot dataSnapshot, String str) {
            }

            public void onChildRemoved(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.UpdaterActivity.27.3 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
            }

            public void onCancelled(DatabaseError databaseError) {
                databaseError.getCode();
                databaseError.getMessage();
            }
        };
        this.DBPushUsers.addChildEventListener(this._DBPushUsers_child_listener);
        this._DBUserProjects_child_listener = new ChildEventListener() {
            /* class com.updatify.o2nation.UpdaterActivity.28 */

            public void onChildAdded(DataSnapshot dataSnapshot, String str) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.UpdaterActivity.28.1 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
            }

            public void onChildChanged(DataSnapshot dataSnapshot, String str) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.UpdaterActivity.28.2 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
            }

            public void onChildMoved(DataSnapshot dataSnapshot, String str) {
            }

            public void onChildRemoved(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.UpdaterActivity.28.3 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
            }

            public void onCancelled(DatabaseError databaseError) {
                databaseError.getCode();
                databaseError.getMessage();
            }
        };
        this.DBUserProjects.addChildEventListener(this._DBUserProjects_child_listener);
    }

    private void initializeLogic() {
        this.mAuth = FirebaseAuth.getInstance();
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
        _changeProjectsReference();
        _LOGIC_UI();
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            this.tologin.setClass(getApplicationContext(), Auth2Activity.class);
            startActivity(this.tologin);
        }
        this.button1 = true;
        this.button2 = true;
        this.mainClickAction = "browser";
        this.extraClickAction = "exit";
        this.dialogTheme = "update";
        _transitionComplete(this.textview1, "title");
        _LOGIC_BACKEND();
        this.sharedPref2.edit().putString("LastActivity", "UpdateActivity.Java").commit();
        if (!getIntent().getStringExtra("icon").equals("null")) {
            _setCircleImageURL(this.imageview3, getIntent().getStringExtra("icon"), 0.0d, "#00000000");
            _getProjectDraftData();
        }
        this.isSwitch1Enabled = true;
        this.isSwitch2Enabled = false;
        this.loadAdsLimit = 0.0d;
        this.textview1.setText(getIntent().getStringExtra("title"));
        this.textview2.setText(getIntent().getStringExtra("currVersion"));
        this.filename = getIntent().getStringExtra("filename");
        this.newVersion_ = getIntent().getStringExtra("currVersion");
        if (this.sharedPref.getString("updater_notification_1", "").equals("")) {
            this.timer = new TimerTask() {
                /* class com.updatify.o2nation.UpdaterActivity.29 */

                public void run() {
                    UpdaterActivity.this.runOnUiThread(new Runnable() {
                        /* class com.updatify.o2nation.UpdaterActivity.29.1 */

                        public void run() {
                            UpdaterActivity.this._tapTarget(UpdaterActivity.this.textview48, "You may need this", "You can customize notification dialog by clicking here.", "#006DF6");
                            UpdaterActivity.this.sharedPref.edit().putString("updater_notification_1", "true").commit();
                        }
                    });
                }
            };
            this._timer.schedule(this.timer, 500);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        UpdaterActivity.super.onActivityResult(i, i2, intent);
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

    public void _removeScollBar(View view) {
        view.setVerticalScrollBarEnabled(false);
        view.setHorizontalScrollBarEnabled(false);
    }

    public void _RippleEffects(String str, View view) {
        view.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor(str)}), null, null));
    }

    public void _shadAnim(View view, String str, double d, double d2) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setTarget(view);
        objectAnimator.setPropertyName(str);
        objectAnimator.setFloatValues((float) d);
        objectAnimator.setDuration((long) d2);
        objectAnimator.start();
    }

    public void _clickAnim(final View view) {
        view.setOnTouchListener(new View.OnTouchListener() {
            /* class com.updatify.o2nation.UpdaterActivity.30 */

            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case RequestNetworkController.REQUEST_PARAM:
                        UpdaterActivity.this._shadAnim(view, "scaleX", 1.01d, 100.0d);
                        UpdaterActivity.this._shadAnim(view, "scaleY", 1.01d, 100.0d);
                        UpdaterActivity.this._shadAnim(view, "elevation", 5.0d, 100.0d);
                        return false;
                    case RequestNetworkController.REQUEST_BODY:
                        UpdaterActivity.this._shadAnim(view, "scaleX", 1.0d, 100.0d);
                        UpdaterActivity.this._shadAnim(view, "scaleY", 1.0d, 100.0d);
                        UpdaterActivity.this._shadAnim(view, "elevation", 0.0d, 100.0d);
                        return false;
                    case 2:
                    default:
                        return false;
                    case 3:
                        UpdaterActivity.this._shadAnim(view, "scaleX", 1.0d, 100.0d);
                        UpdaterActivity.this._shadAnim(view, "scaleY", 1.0d, 100.0d);
                        UpdaterActivity.this._shadAnim(view, "elevation", 0.0d, 100.0d);
                        return false;
                }
            }
        });
    }

    public void _ICC(ImageView imageView, String str, String str2) {
        imageView.setImageTintList(new ColorStateList(new int[][]{new int[]{-16842919}, new int[]{16842919}}, new int[]{Color.parseColor(str), Color.parseColor(str2)}));
    }

    public void _transitionComplete(View view, String str) {
        view.setTransitionName(str);
    }

    public void _setCircleImageURL(ImageView imageView, String str, double d, String str2) {
        Glide.with(this).load(str).circleCrop().into(imageView);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.updatify.o2nation.UpdaterActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void _changeActivityFont(String str) {
        this.fontName = "fonts/".concat(str.concat(".ttf"));
        overrideFonts(this, getWindow().getDecorView());
    }

    private void overrideFonts(Context context, View view) {
        try {
            Typeface createFromAsset = Typeface.createFromAsset(getAssets(), this.fontName);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    overrideFonts(context, viewGroup.getChildAt(i));
                }
            } else if (view instanceof TextView) {
                ((TextView) view).setTypeface(createFromAsset);
            } else if (view instanceof EditText) {
                ((EditText) view).setTypeface(createFromAsset);
            } else if (view instanceof Button) {
                ((Button) view).setTypeface(createFromAsset);
            }
        } catch (Exception e) {
            SketchwareUtil.showMessage(getApplicationContext(), "Error Loading Font");
        }
    }

    public void _Passo(TextView textView) {
        textView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.updatify.o2nation.UpdaterActivity.31 */

            public void onFocusChange(View view, boolean z) {
                if (z) {
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.edittext1, "#00007EED", 3.0d, "#FF007EED", 10.0d);
                } else {
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.edittext1, "#00000000", 3.0d, "#E0E0E0", 10.0d);
                }
            }
        });
    }

    public void _RoundAndBorder(View view, String str, double d, String str2, double d2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius((float) ((int) d2));
        gradientDrawable.setStroke((int) d, Color.parseColor(str2));
        view.setBackground(gradientDrawable);
    }

    public void _ss(TextView textView) {
        textView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.updatify.o2nation.UpdaterActivity.32 */

            public void onFocusChange(View view, boolean z) {
                if (z) {
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.edittext4, "#00007EED", 3.0d, "#FF007EED", 10.0d);
                } else {
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.edittext4, "#00000000", 3.0d, "#E0E0E0", 10.0d);
                }
            }
        });
    }

    public void _ee8w(TextView textView) {
        textView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.updatify.o2nation.UpdaterActivity.33 */

            public void onFocusChange(View view, boolean z) {
                if (z) {
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.edittext6, "#00007EED", 3.0d, "#FF007EED", 10.0d);
                } else {
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.edittext6, "#00000000", 3.0d, "#E0E0E0", 10.0d);
                }
            }
        });
    }

    public void _rippleRoundStroke(View view, String str, String str2, double d, double d2, String str3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius((float) d);
        gradientDrawable.setStroke((int) d2, Color.parseColor("#" + str3.replace("#", "")));
        view.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor(str2)}), gradientDrawable, null));
    }

    public void _second(final View view) {
        view.setOnTouchListener(new View.OnTouchListener() {
            /* class com.updatify.o2nation.UpdaterActivity.34 */

            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case RequestNetworkController.REQUEST_PARAM:
                        UpdaterActivity.this._shadAnim(view, "elevation", 5.0d, 100.0d);
                        UpdaterActivity.this._shadAnim(view, "scaleX", 1.03d, 100.0d);
                        UpdaterActivity.this._shadAnim(view, "scaleY", 1.03d, 100.0d);
                        return false;
                    case RequestNetworkController.REQUEST_BODY:
                        UpdaterActivity.this._shadAnim(view, "elevation", 0.0d, 100.0d);
                        UpdaterActivity.this._shadAnim(view, "scaleX", 1.0d, 100.0d);
                        UpdaterActivity.this._shadAnim(view, "scaleY", 1.0d, 100.0d);
                        return false;
                    default:
                        return false;
                }
            }
        });
    }

    public void _gh(TextView textView) {
        textView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.updatify.o2nation.UpdaterActivity.35 */

            public void onFocusChange(View view, boolean z) {
                if (z) {
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.edittext7, "#00000000", 3.0d, "#FF007EED", 10.0d);
                } else {
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.edittext7, "#00000000", 3.0d, "#E0E0E0", 10.0d);
                }
            }
        });
    }

    public void _advancedCorners(View view, String str, double d, double d2, double d3, double d4) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadii(new float[]{(float) ((int) d), (float) ((int) d), (float) ((int) d2), (float) ((int) d2), (float) ((int) d4), (float) ((int) d4), (float) ((int) d3), (float) ((int) d3)});
        view.setBackground(gradientDrawable);
    }

    public void _setMax(double d) {
    }

    public void _sbd(TextView textView) {
        textView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.updatify.o2nation.UpdaterActivity.36 */

            public void onFocusChange(View view, boolean z) {
                if (z) {
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.edittext8, "#00007EED", 3.0d, "#FF007EED", 10.0d);
                } else {
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.edittext8, "#00000000", 3.0d, "#E0E0E0", 10.0d);
                }
            }
        });
    }

    public void _jeie(TextView textView) {
        textView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.updatify.o2nation.UpdaterActivity.37 */

            public void onFocusChange(View view, boolean z) {
                if (z) {
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.edittext9, "#00007EED", 3.0d, "#FF007EED", 10.0d);
                } else {
                    UpdaterActivity.this._RoundAndBorder(UpdaterActivity.this.edittext9, "#00000000", 3.0d, "#E0E0E0", 10.0d);
                }
            }
        });
    }

    public void _autoTransitionScroll(View view) {
        TransitionManager.beginDelayedTransition((ScrollView) view, new AutoTransition());
    }

    public void _performClick(View view) {
        view.performClick();
    }

    public void _notify(String str, String str2, String str3, double d) {
        int identifier = getResources().getIdentifier(str, "drawable", getPackageName());
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.createNotificationChannel(new NotificationChannel("Updatify Material", "Push update", (int) d));
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "Updatify Material");
        Intent intent = new Intent(getApplicationContext(), LogsActivity.class);
        intent.setFlags(603979776);
        builder.setContentTitle(str2).setContentText(str3).setDefaults(-1).setAutoCancel(true).setSound(RingtoneManager.getDefaultUri(2)).setSmallIcon(identifier).setContentIntent(PendingIntent.getActivity(getApplicationContext(), (int) System.currentTimeMillis(), intent, 134217728));
        notificationManager.notify(0, builder.build());
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

    public void _Snackbar_API(String str, String str2, String str3) {
        this._snackBarView = Snackbar.make((ViewGroup) ((ViewGroup) findViewById(16908290)).getChildAt(0), "", 0);
        this._sblayout = (Snackbar.SnackbarLayout) this._snackBarView.getView();
        View inflate = getLayoutInflater().inflate(R.layout.snackbar, (ViewGroup) null);
        this._sblayout.setPadding(0, 0, 0, 0);
        this._sblayout.setBackgroundColor(Color.argb(0, 0, 0, 0));
        TextView textView = (TextView) inflate.findViewById(R.id.textview1);
        _setViewRadius((LinearLayout) inflate.findViewById(R.id.linear1), 25.0d, "#202125");
        textView.setText(str);
        textView.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
        this._sblayout.addView(inflate, 0);
        this._snackBarView.show();
    }

    private void _doNothingBlahBlah() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.updatify.o2nation.UpdaterActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void _coreLoading(boolean z, String str, double d, String str2, double d2) {
        if (z) {
            if (this.coreprog == null) {
                this.coreprog = new ProgressDialog(this);
                this.coreprog.setCancelable(false);
                this.coreprog.setCanceledOnTouchOutside(false);
                this.coreprog.requestWindowFeature(1);
                this.coreprog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            }
            this.coreprog.show();
            this.coreprog.setContentView(R.layout.loading_log);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(Color.parseColor("#" + str.replace("#", "")));
            gradientDrawable.setCornerRadius((float) ((int) d));
            gradientDrawable.setStroke((int) d2, Color.parseColor("#" + str2.replace("#", "")));
            ((LinearLayout) this.coreprog.findViewById(R.id.background)).setBackground(gradientDrawable);
        } else if (this.coreprog != null) {
            this.coreprog.dismiss();
        }
    }

    public void _sendUpdate() {
        _coreLoading(true, "#FFFFFF", 125.0d, "#FFFFFF", 0.0d);
        this.APIProjectsMap.put("currVersion", this.textview2.getText().toString());
        this.APIProjectsMap.put("newVersion", this.newVersion_);
        this.APIProjectsMap.put("developer", FirebaseAuth.getInstance().getCurrentUser().getUid());
        this.APIProjectsMap.put("email", FirebaseAuth.getInstance().getCurrentUser().getEmail());
        this.APIProjectsMap.put("alertOption", this.alertOption);
        if (this.checkbox1.isChecked()) {
            this.APIProjectsMap.put("isCancelable", "true");
        } else {
            this.APIProjectsMap.put("isCancelable", "false");
        }
        if (this.checkbox2.isChecked()) {
            this.APIProjectsMap.put("isOneTime", "true");
            this.APIProjectsMap.put("isOneTimeKey", this.textview1.getText().toString().concat(String.valueOf((long) SketchwareUtil.getRandom(0, 9999999))));
        } else {
            this.APIProjectsMap.put("isOneTime", "false");
            this.APIProjectsMap.put("isOneTimeKey", "null");
        }
        if (!this.dialogTheme.equals("custom")) {
            this.APIProjectsMap.put("dialogOption", this.dialogTheme);
        } else if (this.sharedPref.getString("customDialog", "").equals("")) {
            this.APIProjectsMap.put("dialogOption", "update");
        } else {
            this.APIProjectsMap.put("dialogOption", "custom");
        }
        if (this.dialogTheme.equals("custom")) {
            this.APIProjectsMap.put("customDialogRound", this.sharedPref.getString("customDialogRound", ""));
            this.APIProjectsMap.put("customDialogBack", this.sharedPref.getString("customDialogBack", ""));
            this.APIProjectsMap.put("customDialogAccent", this.sharedPref.getString("customDialogAccent", ""));
            this.APIProjectsMap.put("customDialogMainTxtColor", this.sharedPref.getString("customDialogMainTxtColor", ""));
            this.APIProjectsMap.put("customDialogBtnTxtColor", this.sharedPref.getString("customDialogBtnTxtColor", ""));
            if (!this.sharedPref.getString("customDialogIcon", "").equals("null") && !this.sharedPref.getString("customDialogIcon", "").equals("")) {
                this.APIProjectsMap.put("customDialogIcon", this.sharedPref.getString("customDialogIcon", ""));
            } else if (this.dialogTheme.equals("message")) {
                this.APIProjectsMap.put("customDialogIcon", "https://i.imgur.com/1L1fc20.png");
            } else if (this.dialogTheme.equals("warning")) {
                this.APIProjectsMap.put("customDialogIcon", "https://i.imgur.com/H6JtunA.png");
            } else {
                this.APIProjectsMap.put("customDialogIcon", "https://i.imgur.com/UZhQY2V.png");
            }
        }
        this.APIProjectsMap.put("dialogTitle", this.edittext1.getText().toString());
        this.APIProjectsMap.put("dialogSubtitle", this.edittext4.getText().toString());
        this.APIProjectsMap.put("dialogBtnMainTxt", this.edittext9.getText().toString());
        this.APIProjectsMap.put("dialogBtnExtraTxt", this.edittext6.getText().toString());
        this.APIProjectsMap.put("dialogBtnMainClick", this.mainClickAction);
        this.APIProjectsMap.put("dialogBtnExtraClick", this.extraClickAction);
        if (this.isSwitch1Enabled) {
            this.APIProjectsMap.put("dialogBtnMain", "true");
            this.APIProjectsMap.put("openLinkMain", this.edittext8.getText().toString());
        } else {
            this.APIProjectsMap.put("dialogBtnMain", "false");
            this.APIProjectsMap.put("openLinkMain", "null");
        }
        if (this.isSwitch2Enabled) {
            this.APIProjectsMap.put("dialogBtnExtra", "true");
            this.APIProjectsMap.put("openLinkExtra", this.edittext7.getText().toString());
        } else {
            this.APIProjectsMap.put("dialogBtnExtra", "false");
            this.APIProjectsMap.put("openLinkExtra", "null");
        }
        this.APIHeaders.put("key", this.publishKey);
        this.APIHeaders.put("filename", this.filename);
        this.APIHeaders.put("content", new Gson().toJson(this.APIProjectsMap));
        this.requestProjects.setParams(this.APIHeaders, 0);
        this.requestProjects.startRequestNetwork(RequestNetworkController.POST, "https://nerbly.com/updatify/apiv1/?do=update", "", this._requestProjects_request_listener);
        this.APIProjectsMap.clear();
        this.APIHeaders.clear();
    }

    public void _decryptString(String str, String str2) {
        try {
            Cipher instance = Cipher.getInstance("AES");
            instance.init(2, (SecretKeySpec) generateKey(str2));
            this.publishKey = new String(instance.doFinal(Base64.decode(str, 0)));
        } catch (Exception e) {
            this.publishKey = "null";
        }
    }

    public void _Encrypt_And_Decrypt() {
    }

    private SecretKey generateKey(String str) throws Exception {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str.getBytes("UTF-8");
        instance.update(bytes, 0, bytes.length);
        return new SecretKeySpec(instance.digest(), "AES");
    }

    public void _setViewRadius(View view, double d, String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#" + str.replace("#", "")));
        gradientDrawable.setCornerRadius((float) ((int) d));
        view.setBackground(gradientDrawable);
    }

    public void _getProjectDraftData() {
        if (this.sharedPref.getString(getIntent().getStringExtra("title").concat("_data"), "").equals("true")) {
            if (this.sharedPref.getString(getIntent().getStringExtra("title").concat("_title"), "").equals("")) {
                this.edittext1.setText("Update released!");
            } else {
                this.edittext1.setText(this.sharedPref.getString(getIntent().getStringExtra("title").concat("_title"), ""));
            }
            if (this.sharedPref.getString(getIntent().getStringExtra("title").concat("_message"), "").equals("")) {
                this.edittext4.setText("Hello user! you are using old version of ".concat(getIntent().getStringExtra("title").concat(" need to update to the latest version in order to experience a total multifunctions.")));
            } else {
                this.edittext4.setText(this.sharedPref.getString(getIntent().getStringExtra("title").concat("_message"), ""));
            }
            if (this.sharedPref.getString(getIntent().getStringExtra("title").concat("_mainbtntxt"), "").equals("")) {
                this.edittext9.setText("Install now");
            } else {
                this.edittext9.setText(this.sharedPref.getString(getIntent().getStringExtra("title").concat("_mainbtntxt"), ""));
            }
            if (this.sharedPref.getString(getIntent().getStringExtra("title").concat("_mainurl"), "").equals("")) {
                this.edittext8.setText("https://play.google.com/store/apps/details?id=com.updatify.o2nation");
            } else {
                this.edittext8.setText(this.sharedPref.getString(getIntent().getStringExtra("title").concat("_mainurl"), ""));
            }
            if (this.sharedPref.getString(getIntent().getStringExtra("title").concat("_extrabtntxt"), "").equals("")) {
                this.edittext6.setText("What's new?");
            } else {
                this.edittext6.setText(this.sharedPref.getString(getIntent().getStringExtra("title").concat("_extrabtntxt"), ""));
            }
            if (this.sharedPref.getString(getIntent().getStringExtra("title").concat("_extraurl"), "").equals("")) {
                this.edittext7.setText("https://www.example.com/news");
            } else {
                this.edittext7.setText(this.sharedPref.getString(getIntent().getStringExtra("title").concat("_extraurl"), ""));
            }
            if (this.sharedPref.getString(getIntent().getStringExtra("title").concat("_cancelable"), "").equals("")) {
                this.checkbox1.setChecked(true);
            } else if (this.sharedPref.getString(getIntent().getStringExtra("title").concat("_cancelable"), "").equals("true")) {
                this.checkbox1.setChecked(true);
            } else if (this.sharedPref.getString(getIntent().getStringExtra("title").concat("_cancelable"), "").equals("false")) {
                this.checkbox1.setChecked(false);
            }
        } else {
            this.edittext1.setText("Update released!");
            this.edittext4.setText("Hello user! you are using old version of ".concat(getIntent().getStringExtra("title").concat(", you need to update to the latest version in order to experience a total multifunctions.")));
            this.edittext9.setText("Install now");
            this.edittext8.setText("https://play.google.com/store/apps/details?id=com.updatify.o2nation");
            this.edittext6.setText("What's new ?");
            this.edittext7.setText("https://www.example.com/news");
        }
    }

    public void _saveNewDraft() {
        this.sharedPref.edit().putString(getIntent().getStringExtra("title").concat("_data"), "true").commit();
        if (!this.edittext1.getText().toString().equals("")) {
            this.sharedPref.edit().putString(getIntent().getStringExtra("title").concat("_title"), this.edittext1.getText().toString()).commit();
        }
        if (!this.edittext4.getText().toString().equals("")) {
            this.sharedPref.edit().putString(getIntent().getStringExtra("title").concat("_message"), this.edittext4.getText().toString()).commit();
        }
        if (!this.edittext9.getText().toString().equals("")) {
            this.sharedPref.edit().putString(getIntent().getStringExtra("title").concat("_mainbtntxt"), this.edittext9.getText().toString()).commit();
        }
        if (!this.edittext8.getText().toString().equals("")) {
            this.sharedPref.edit().putString(getIntent().getStringExtra("title").concat("_mainurl"), this.edittext8.getText().toString()).commit();
        }
        if (!this.edittext6.getText().toString().equals("")) {
            this.sharedPref.edit().putString(getIntent().getStringExtra("title").concat("_extrabtntxt"), this.edittext6.getText().toString()).commit();
        }
        if (!this.edittext7.getText().toString().equals("")) {
            this.sharedPref.edit().putString(getIntent().getStringExtra("title").concat("_extraurl"), this.edittext7.getText().toString()).commit();
        }
        if (this.checkbox1.isChecked()) {
            this.sharedPref.edit().putString(getIntent().getStringExtra("title").concat("_cancelable"), "true").commit();
        } else {
            this.sharedPref.edit().putString(getIntent().getStringExtra("title").concat("_cancelable"), "false").commit();
        }
    }

    public void _setBgCorners(View view, double d, String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#" + str.replace("#", "")));
        gradientDrawable.setCornerRadius((float) ((int) d));
        gradientDrawable.setStroke(0, -1);
        view.setBackground(gradientDrawable);
    }

    public void _SetTextSize(TextView textView, double d) {
        textView.setTextSize((float) d);
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

    public void _LOGIC_UI() {
        if (this.sharedPref2.getString("dark", "").equals("true")) {
            _RoundAndBorder(this.back_alertdia, "#00000000", 3.0d, "#007EED", 100.0d);
            _RoundAndBorder(this.back_alertsheet, "#00000000", 3.0d, "#E0E0E0", 100.0d);
            _setViewRadius(this.switch_back1, 90.0d, "#2196F3");
            _setViewRadius(this.switch_btn1, 90.0d, "#FFFFFF");
            _RoundAndBorder(this.switch_back2, "#424242", 0.0d, "#E0E0E0", 90.0d);
            _setViewRadius(this.switch_btn2, 90.0d, "#2196F3");
            this.background.setBackgroundColor(-15198184);
            this.textview1.setTextColor(-1);
            this.textview6.setTextColor(-1);
            this.textview8.setTextColor(-1);
            this.textview43.setTextColor(-1);
            this.textview53.setTextColor(-1);
            this.textview33.setTextColor(-1);
            this.textview31.setTextColor(-1);
            _ICC(this.imageview2, "#FFFFFF", "#CCFFFFFF");
            _ICC(this.imageview1, "#FFFFFF", "#CCFFFFFF");
            _RoundAndBorder(this.exit2_back, "#FFEFEF", 3.0d, "#DF2029", 100.0d);
            _RoundAndBorder(this.textview33, "#424242", 0.0d, "#424242", 25.0d);
            _RoundAndBorder(this.update2_back, "#00000000", 3.0d, "#424242", 100.0d);
            _RoundAndBorder(this.dismiss2_back, "#00000000", 3.0d, "#424242", 100.0d);
            _RoundAndBorder(this.textview45, "#E0EBF6", 3.0d, "#007EED", 100.0d);
            _RoundAndBorder(this.textview46, "#00000000", 3.0d, "#424242", 100.0d);
            _RoundAndBorder(this.textview47, "#00000000", 3.0d, "#424242", 100.0d);
            _RoundAndBorder(this.textview48, "#00000000", 3.0d, "#424242", 100.0d);
            _RoundAndBorder(this.textview51, "#006DF6", 0.0d, "#E0E0E0", 25.0d);
            _RoundAndBorder(this.edittext1, "#00000000", 3.0d, "#424242", 10.0d);
            _RoundAndBorder(this.edittext4, "#00000000", 3.0d, "#424242", 10.0d);
            _RoundAndBorder(this.edittext6, "#00000000", 3.0d, "#424242", 10.0d);
            _RoundAndBorder(this.edittext7, "#00000000", 3.0d, "#424242", 10.0d);
            _RoundAndBorder(this.edittext8, "#00000000", 3.0d, "#424242", 10.0d);
            _RoundAndBorder(this.edittext9, "#00000000", 3.0d, "#424242", 10.0d);
            _RoundAndBorder(this.exit_back, "#00000000", 3.0d, "#424242", 100.0d);
            _RoundAndBorder(this.update1_back, "#00000000", 3.0d, "#424242", 100.0d);
            _RoundAndBorder(this.close1_back, "#00000000", 3.0d, "#424242", 100.0d);
            _rippleRoundStroke(this.imageview4, "#181818", "#424242", 100.0d, 2.0d, "#424242");
            _LIGHT_ICONS();
            _NavStatusBarColor("#181818", "#181818");
            this.textview10.setTextColor(-1);
            this.textview29.setTextColor(-1);
            this.textview20.setTextColor(-1);
            this.textview37.setTextColor(-1);
            this.textview26.setTextColor(-1);
            this.textview15.setTextColor(-1);
            this.textview22.setTextColor(-1);
            this.textview49.setTextColor(-1);
            this.edittext1.setHintTextColor(-2039584);
            this.edittext4.setHintTextColor(-2039584);
            this.edittext9.setHintTextColor(-2039584);
            this.edittext8.setHintTextColor(-2039584);
            this.edittext6.setHintTextColor(-2039584);
            this.edittext7.setHintTextColor(-2039584);
            this.edittext1.setTextColor(-1);
            this.edittext4.setTextColor(-1);
            this.edittext9.setTextColor(-1);
            this.edittext8.setTextColor(-1);
            this.edittext6.setTextColor(-1);
            this.edittext7.setTextColor(-1);
            this.line1.setBackgroundColor(-12434878);
            this.line2.setBackgroundColor(-12434878);
            this.line3.setBackgroundColor(-12434878);
            _checkBoxColor(this.checkbox1, "#FFFFFF");
            _checkBoxColor(this.checkbox2, "#FFFFFF");
            _RoundAndBorder(this.textview33, "#424242", 0.0d, "#E0E0E0", 25.0d);
            this.textview33.setTextColor(-1);
            this.ads_back.setBackgroundColor(-15198184);
            _advancedCorners(this.bsheet_options, "#181818", 30.0d, 30.0d, 0.0d, 0.0d);
            _setViewRadius(this.slider, 90.0d, "#424242");
        } else {
            _advancedCorners(this.bsheet_options, "#FFFFFF", 30.0d, 30.0d, 0.0d, 0.0d);
            _setViewRadius(this.slider, 90.0d, "#BDBDBD");
            _RoundAndBorder(this.back_alertdia, "#E0EBF6", 3.0d, "#007EED", 100.0d);
            _RoundAndBorder(this.back_alertsheet, "#00000000", 3.0d, "#E0E0E0", 100.0d);
            _setViewRadius(this.switch_back1, 90.0d, "#2196F3");
            _setViewRadius(this.switch_btn1, 90.0d, "#FFFFFF");
            _RoundAndBorder(this.switch_back2, "#EEEEEE", 1.0d, "#E0E0E0", 90.0d);
            _setViewRadius(this.switch_btn2, 90.0d, "#2196F3");
            _NavStatusBarColor("#ffffff", "#ffffff");
            _DARK_ICONS();
            _RoundAndBorder(this.exit2_back, "#FFEFEF", 3.0d, "#DF2029", 100.0d);
            _RoundAndBorder(this.update2_back, "#00000000", 3.0d, "#E0E0E0", 100.0d);
            _RoundAndBorder(this.dismiss2_back, "#00000000", 3.0d, "#E0E0E0", 100.0d);
            _RoundAndBorder(this.textview45, "#E0EBF6", 3.0d, "#007EED", 100.0d);
            _RoundAndBorder(this.textview46, "#00000000", 3.0d, "#E0E0E0", 100.0d);
            _RoundAndBorder(this.textview47, "#00000000", 3.0d, "#E0E0E0", 100.0d);
            _RoundAndBorder(this.textview48, "#00000000", 3.0d, "#E0E0E0", 100.0d);
            _RoundAndBorder(this.textview51, "#006DF6", 0.0d, "#E0E0E0", 25.0d);
            _ICC(this.imageview2, "#616161", "#CC616161");
            _ICC(this.imageview1, "#616161", "#CC616161");
            _RoundAndBorder(this.edittext1, "#00000000", 3.0d, "#E0E0E0", 10.0d);
            _RoundAndBorder(this.edittext4, "#00000000", 3.0d, "#E0E0E0", 10.0d);
            _RoundAndBorder(this.edittext6, "#00000000", 3.0d, "#E0E0E0", 10.0d);
            _RoundAndBorder(this.edittext7, "#00000000", 3.0d, "#E0E0E0", 10.0d);
            _RoundAndBorder(this.edittext8, "#00000000", 3.0d, "#E0E0E0", 10.0d);
            _RoundAndBorder(this.edittext9, "#00000000", 3.0d, "#E0E0E0", 10.0d);
            _RoundAndBorder(this.exit_back, "#00000000", 3.0d, "#E0E0E0", 100.0d);
            _RoundAndBorder(this.update1_back, "#00000000", 3.0d, "#E0E0E0", 100.0d);
            _RoundAndBorder(this.close1_back, "#00000000", 3.0d, "#E0E0E0", 100.0d);
            _rippleRoundStroke(this.imageview4, "#FFFFFF", "#E0E0E0", 100.0d, 2.0d, "#E0E0E0");
            _RoundAndBorder(this.textview33, "#F5F5F5", 0.0d, "#E0E0E0", 25.0d);
        }
        _RoundAndBorder(this.textview25, "#00B6EF", 0.0d, "#E0E0E0", 25.0d);
        this.edittext7.setVisibility(View.GONE);
        this.linear23.setVisibility(View.GONE);
        this.edittext6.setVisibility(View.GONE);
        this.edittext1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
        this.edittext4.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
        this.edittext9.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
        this.edittext8.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
        this.edittext6.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
        this.edittext7.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
        _performClick(this.update1_back);
        _performClick(this.textview45);
        _performClick(this.exit2_back);
        _ICC(this.imageview4, "#9E9E9E", "#006DF6");
        _removeScollBar(this.hscroll1);
        _removeScollBar(this.hscroll2);
        _removeScollBar(this.vscroll1);
        _RippleEffects("#EEEEEE", this.imageview1);
        _RippleEffects("#EEEEEE", this.imageview2);
        _clickAnim(this.imageview1);
        _clickAnim(this.imageview2);
        _clickAnim(this.textview33);
        _clickAnim(this.textview25);
        _clickAnim(this.textview51);
        this.linear29.setVisibility(View.GONE);
        this.hscroll2.setVisibility(View.GONE);
        this.edittext7.setVisibility(View.GONE);
        this.linear23.setVisibility(View.GONE);
        _ss(this.edittext4);
        _ee8w(this.edittext6);
        _sbd(this.edittext8);
        _jeie(this.edittext9);
        _Passo(this.edittext1);
        _gh(this.edittext7);
        _setToolTip(this.imageview1, "Back home");
        _setToolTip(this.imageview2, "More options");
        _setToolTip(this.imageview4, "Select new version");
        this.exit2.setTextColor(-2154455);
        this.url2.setTextColor(-6381922);
        this.dismiss2.setTextColor(-6381922);
        _shadAnim(this.exit2_back, "elevation", 5.0d, 100.0d);
        _shadAnim(this.update2_back, "elevation", 0.0d, 100.0d);
        _shadAnim(this.dismiss2_back, "elevation", 0.0d, 100.0d);
        this.edittext7.setVisibility(View.GONE);
        this.linear23.setVisibility(View.GONE);
        this.textview45.setTextColor(-16744723);
        this.textview46.setTextColor(-6381922);
        this.textview47.setTextColor(-6381922);
        this.textview48.setTextColor(-6381922);
        _shadAnim(this.textview45, "elevation", 5.0d, 100.0d);
        _shadAnim(this.textview46, "elevation", 0.0d, 100.0d);
        _shadAnim(this.textview47, "elevation", 0.0d, 100.0d);
        _shadAnim(this.textview48, "elevation", 0.0d, 100.0d);
        _changeActivityFont("product_med");
        this.textview1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
        this.textview2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_bold.ttf"), Typeface.NORMAL);
        this.textview25.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
        this.textview24.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
        this.textview51.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
        this.textview33.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
        _SetTextSize(this.textview33, 13.0d);
        _SetTextSize(this.textview25, 13.0d);
        _SetTextSize(this.textview51, 13.0d);
        this.textview1.setText(getIntent().getStringExtra("title"));
        this.textview56.setTextColor(-16744723);
        this.textview57.setTextColor(-6381922);
        _shadAnim(this.back_alertdia, "elevation", 5.0d, 100.0d);
        _shadAnim(this.back_alertsheet, "elevation", 0.0d, 100.0d);
        _ICC(this.img_alertdia, "#FFFFFF", "#FFFFFF");
        _ICC(this.img_alertsheet, "#9E9E9E", "#9E9E9E");
        _setBgCorners(this.img_alertdia, 90.0d, "#007EED");
        _setBgCorners(this.img_alertsheet, 90.0d, "#00000000");
    }

    public void _LIGHT_ICONS() {
        getWindow().getDecorView().setSystemUiVisibility(0);
    }

    public void _checkBoxColor(CheckBox checkBox, String str) {
        try {
            checkBox.setButtonTintList(ColorStateList.valueOf(Color.parseColor(str)));
        } catch (Exception e) {
        }
    }

    public void _transitionViewTime(View view, double d) {
        AutoTransition autoTransition = new AutoTransition();
        autoTransition.setDuration((long) ((short) ((int) d)));
        TransitionManager.beginDelayedTransition((LinearLayout) view, autoTransition);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.updatify.o2nation.UpdaterActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void _tapTarget(View view, String str, String str2, String str3) {
        TapTargetView.showFor((Activity) this, TapTarget.forView(view, str, str2).outerCircleColorInt(Color.parseColor("#" + str3.replace("#", ""))).outerCircleAlpha(0.9f).targetCircleColor(17170443).titleTextSize(24).titleTextColor(17170443).descriptionTextSize(20).descriptionTextColor(17170443).textColor(17170443).dimColor(17170445).drawShadow(false).cancelable(true).tintTarget(false).transparentTarget(true).targetRadius(40), (TapTargetView.Listener) new TapTargetView.Listener() {
            /* class com.updatify.o2nation.UpdaterActivity.38 */

            @Override // com.updatify.o2nation.UpdaterActivity.TapTargetView.Listener
            public void onTargetClick(TapTargetView tapTargetView) {
                super.onTargetClick(tapTargetView);
            }
        });
    }

    public void _changeProjectsReference() {
        this.userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        this.DBUserProjects.removeEventListener(this._DBUserProjects_child_listener);
        this.DBUserProjects = this._firebase.getReference("USERS2827IWUWIEHDN8273").child(this.userId).child("PROJECTS");
        this.DBUserProjects.addChildEventListener(this._DBUserProjects_child_listener);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.updatify.o2nation.UpdaterActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void _LOGIC_BACKEND() {
        this.alertOption = "dialog";
        if (SketchwareUtil.getRandom(1, 3) == 2) {
            this.reviewManager = ReviewManagerFactory.create(this);
            this.reviewManager.requestReviewFlow().addOnCompleteListener(new OnCompleteListener<ReviewInfo>() {
                /* class com.updatify.o2nation.UpdaterActivity.39 */

                /* JADX WARN: Type inference failed for: r1v1, types: [com.updatify.o2nation.UpdaterActivity, android.app.Activity] */
                /* JADX WARNING: Unknown variable types count: 1 */
                public void onComplete(@NonNull Task<ReviewInfo> task) {
                    if (task.isSuccessful()) {
                        UpdaterActivity.this.reviewInfo = (ReviewInfo) task.getResult();
                        UpdaterActivity.this.reviewManager.launchReviewFlow((Activity) UpdaterActivity.this, UpdaterActivity.this.reviewInfo).addOnFailureListener(new OnFailureListener() {
                            /* class com.updatify.o2nation.UpdaterActivity.39.1 */

                            public void onFailure(Exception exc) {
                            }
                        }).addOnCompleteListener(new OnCompleteListener<Void>() {
                            /* class com.updatify.o2nation.UpdaterActivity.39.2 */

                            public void onComplete(@NonNull Task<Void> task) {
                            }
                        });
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                /* class com.updatify.o2nation.UpdaterActivity.40 */

                public void onFailure(Exception exc) {
                }
            });
        }
        OverScrollDecoratorHelper.setUpOverScroll(this.vscroll1);
        OverScrollDecoratorHelper.setUpOverScroll(this.hscroll1);
        OverScrollDecoratorHelper.setUpOverScroll(this.hscroll2);
        OverScrollDecoratorHelper.setUpOverScroll(this.hscroll3);
        OverScrollDecoratorHelper.setUpOverScroll(this.hscroll4);
        AudienceNetworkAds.initialize(this);
        this.fbBanner = new AdView(this, "278142536768563_297676561481827", AdSize.BANNER_HEIGHT_50);
        this.ads_back.addView(this.fbBanner);
        this.fbBanner.loadAd();
        this.fbInterstitial = new InterstitialAd(this, "278142536768563_320780439171439");
        this.fbInterstitial.loadAd();
        this.sheetBehavior = BottomSheetBehavior.from(this.bsheet_options);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r22v0, resolved type: com.updatify.o2nation.UpdaterActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void _previewDialog(final String str) {
        try {
            if (this.dialogTheme.equals("warning")) {
                this.color = "#BD081C";
                this.backColor = "#FFFFFF";
                this.customRound = 60.0d;
                this.mainTextColor = "#FF616161";
                this.buttonTextColor = "#FFFFFF";
            } else if (this.dialogTheme.equals("message")) {
                this.customRound = 60.0d;
                this.color = "#00B489";
                this.backColor = "#FFFFFF";
                this.mainTextColor = "#FF616161";
                this.buttonTextColor = "#FFFFFF";
            } else if (this.dialogTheme.equals("update")) {
                this.color = "#0084FF";
                this.backColor = "#FFFFFF";
                this.customRound = 60.0d;
                this.mainTextColor = "#FF616161";
                this.buttonTextColor = "#FFFFFF";
            } else if (this.sharedPref.getString("customDialog", "").equals("")) {
                this.color = "#0084FF";
                this.backColor = "#FFFFFF";
                this.customRound = 60.0d;
                this.mainTextColor = "#FF616161";
                this.buttonTextColor = "#FFFFFF";
            } else {
                this.color = this.sharedPref.getString("customDialogAccent", "");
                this.backColor = this.sharedPref.getString("customDialogBack", "");
                this.customRound = Double.parseDouble(this.sharedPref.getString("customDialogRound", ""));
                this.mainTextColor = this.sharedPref.getString("customDialogMainTxtColor", "");
                this.buttonTextColor = this.sharedPref.getString("customDialogBtnTxtColor", "");
            }
            String editable = this.edittext1.getText().toString();
            String editable2 = this.edittext4.getText().toString();
            String editable3 = this.edittext9.getText().toString();
            String editable4 = this.edittext6.getText().toString();
            View inflate = getLayoutInflater().inflate(R.layout.dialogpreview, (ViewGroup) null);
            if (str.equals("sheet")) {
                this.updatifySheet = new BottomSheetDialog(this);
                this.updatifySheet.setContentView(inflate);
                this.updatifySheet.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(17170445);
            } else if (str.equals("dialog")) {
                this.updatifyDialog = new AlertDialog.Builder(this).create();
                this.updatifyDialog.setView(inflate);
                this.updatifyDialog.getWindow().setBackgroundDrawableResource(17170445);
            }
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.dia_img_back);
            TextView textView = (TextView) inflate.findViewById(R.id.dia_title);
            TextView textView2 = (TextView) inflate.findViewById(R.id.dia_subtitle);
            TextView textView3 = (TextView) inflate.findViewById(R.id.dia_main);
            TextView textView4 = (TextView) inflate.findViewById(R.id.dia_extra);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.dia_img);
            linearLayout.setTranslationZ(1.0f);
            _setTextColor(textView, this.mainTextColor);
            _setTextColor(textView2, this.mainTextColor);
            _setTextColor(textView3, this.buttonTextColor);
            _setTextColor(textView4, this.mainTextColor);
            _setViewRadius((LinearLayout) inflate.findViewById(R.id.dia_back), this.customRound, this.backColor);
            _rippleRoundStroke(textView3, this.color, "#FFFFFF", this.customRound, 0.0d, "#FFFFFF");
            _rippleRoundStroke(textView4, this.backColor, "#E0E0E0", this.customRound, 0.0d, "#FFFFFF");
            _setViewRadius(linearLayout, 200.0d, this.color);
            textView.setText(editable);
            textView2.setText(editable2);
            textView4.setText(editable3);
            textView3.setText(editable4);
            textView3.setVisibility(View.GONE);
            textView4.setVisibility(View.GONE);
            if (!this.dialogTheme.equals("custom")) {
                if (this.dialogTheme.equals("message")) {
                    imageView.setImageResource(R.drawable.icons_3);
                } else if (this.dialogTheme.equals("warning")) {
                    imageView.setImageResource(R.drawable.icons_4);
                } else {
                    imageView.setImageResource(R.drawable.icons_1);
                }
                imageView.setImageTintList(new ColorStateList(new int[][]{new int[]{-16842919}, new int[]{16842919}}, new int[]{Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF")}));
            } else if (this.sharedPref.getString("customDialogIcon", "").equals("null") || this.sharedPref.getString("customDialogIcon", "").equals("")) {
                imageView.setImageResource(R.drawable.icons_1);
                imageView.setImageTintList(new ColorStateList(new int[][]{new int[]{-16842919}, new int[]{16842919}}, new int[]{Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF")}));
            } else {
                Glide.with(getApplicationContext()).load(Uri.parse(this.sharedPref.getString("customDialogIcon", ""))).into(imageView);
            }
            if (this.isSwitch1Enabled) {
                textView3.setVisibility(View.VISIBLE);
                textView3.setOnClickListener(new View.OnClickListener() {
                    /* class com.updatify.o2nation.UpdaterActivity.41 */

                    public void onClick(View view) {
                        if (str.equals("sheet")) {
                            UpdaterActivity.this.updatifySheet.dismiss();
                        } else if (str.equals("dialog")) {
                            UpdaterActivity.this.updatifyDialog.dismiss();
                        }
                    }
                });
            }
            if (this.isSwitch2Enabled) {
                textView4.setVisibility(View.VISIBLE);
                textView4.setOnClickListener(new View.OnClickListener() {
                    /* class com.updatify.o2nation.UpdaterActivity.42 */

                    public void onClick(View view) {
                        if (str.equals("sheet")) {
                            UpdaterActivity.this.updatifySheet.dismiss();
                        } else if (str.equals("dialog")) {
                            UpdaterActivity.this.updatifyDialog.dismiss();
                        }
                    }
                });
            }
            if (str.equals("sheet")) {
                this.updatifySheet.show();
            } else if (str.equals("dialog")) {
                this.updatifyDialog.show();
            }
        } catch (Exception e) {
            _Snackbar_API(e.toString(), "", "");
        }
    }

    public void _setTextColor(TextView textView, String str) {
        textView.setTextColor(Color.parseColor(str));
    }

    static class UiUtil {
        UiUtil() {
        }

        static int dp(Context context, int i) {
            return (int) TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
        }

        static int sp(Context context, int i) {
            return (int) TypedValue.applyDimension(2, (float) i, context.getResources().getDisplayMetrics());
        }

        static int themeIntAttr(Context context, String str) {
            Resources.Theme theme = context.getTheme();
            if (theme == null) {
                return -1;
            }
            TypedValue typedValue = new TypedValue();
            int identifier = context.getResources().getIdentifier(str, "attr", context.getPackageName());
            if (identifier == 0) {
                return -1;
            }
            theme.resolveAttribute(identifier, typedValue, true);
            return typedValue.data;
        }

        static int setAlpha(int i, float f) {
            if (f > 1.0f) {
                f = 1.0f;
            } else if (f <= 0.0f) {
                f = 0.0f;
            }
            return (((int) (((float) (i >>> 24)) * f)) << 24) | (16777215 & i);
        }
    }

    static class FloatValueAnimatorBuilder {
        private final ValueAnimator animator;
        private EndListener endListener;

        protected FloatValueAnimatorBuilder() {
            this(false);
        }

        FloatValueAnimatorBuilder(boolean z) {
            if (z) {
                this.animator = ValueAnimator.ofFloat(1.0f, 0.0f);
            } else {
                this.animator = ValueAnimator.ofFloat(0.0f, 1.0f);
            }
        }

        public FloatValueAnimatorBuilder delayBy(long j) {
            this.animator.setStartDelay(j);
            return this;
        }

        public FloatValueAnimatorBuilder duration(long j) {
            this.animator.setDuration(j);
            return this;
        }

        public FloatValueAnimatorBuilder interpolator(TimeInterpolator timeInterpolator) {
            this.animator.setInterpolator(timeInterpolator);
            return this;
        }

        public FloatValueAnimatorBuilder repeat(int i) {
            this.animator.setRepeatCount(i);
            return this;
        }

        public FloatValueAnimatorBuilder onUpdate(final UpdateListener updateListener) {
            this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.updatify.o2nation.UpdaterActivity.FloatValueAnimatorBuilder.1 */

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    updateListener.onUpdate(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            return this;
        }

        public FloatValueAnimatorBuilder onEnd(EndListener endListener2) {
            this.endListener = endListener2;
            return this;
        }

        public ValueAnimator build() {
            if (this.endListener != null) {
                this.animator.addListener(new AnimatorListenerAdapter() {
                    /* class com.updatify.o2nation.UpdaterActivity.FloatValueAnimatorBuilder.2 */

                    public void onAnimationEnd(Animator animator) {
                        FloatValueAnimatorBuilder.this.endListener.onEnd();
                    }
                });
            }
            return this.animator;
        }

        interface EndListener {
            void onEnd();
        }

        interface UpdateListener {
            void onUpdate(float f);
        }
    }

    static class ReflectUtil {
        ReflectUtil() {
        }

        static Object getPrivateField(Object obj, String str) throws NoSuchFieldException, IllegalAccessException {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        }
    }

    static class TapTarget extends Activity {
        final CharSequence description;
        final CharSequence title;
        Rect bounds;
        boolean cancelable;
        float descriptionTextAlpha;
        Typeface descriptionTypeface;
        boolean drawShadow;
        Drawable icon;
        int id;
        float outerCircleAlpha;
        int targetRadius;
        boolean tintTarget;
        Typeface titleTypeface;
        boolean transparentTarget;
        private Integer descriptionTextColor;
        private int descriptionTextColorRes;
        private int descriptionTextDimen;
        private int descriptionTextSize;
        private Integer dimColor;
        private int dimColorRes;
        private Integer outerCircleColor;
        private int outerCircleColorRes;
        private Integer targetCircleColor;
        private int targetCircleColorRes;
        private Integer titleTextColor;
        private int titleTextColorRes;
        private int titleTextDimen;
        private int titleTextSize;

        protected TapTarget(Rect rect, CharSequence charSequence, CharSequence charSequence2) {
            this(charSequence, charSequence2);
            if (rect == null) {
                throw new IllegalArgumentException("Cannot pass null bounds or title");
            }
            this.bounds = rect;
        }

        protected TapTarget(CharSequence charSequence, CharSequence charSequence2) {
            this.outerCircleAlpha = 0.96f;
            this.targetRadius = 44;
            this.outerCircleColorRes = -1;
            this.targetCircleColorRes = -1;
            this.dimColorRes = -1;
            this.titleTextColorRes = -1;
            this.descriptionTextColorRes = -1;
            this.outerCircleColor = null;
            this.targetCircleColor = null;
            this.dimColor = null;
            this.titleTextColor = null;
            this.descriptionTextColor = null;
            this.titleTextDimen = -1;
            this.descriptionTextDimen = -1;
            this.titleTextSize = 20;
            this.descriptionTextSize = 18;
            this.id = -1;
            this.drawShadow = false;
            this.cancelable = true;
            this.tintTarget = true;
            this.transparentTarget = false;
            this.descriptionTextAlpha = 0.54f;
            if (charSequence == null) {
                throw new IllegalArgumentException("Cannot pass null title");
            }
            this.title = charSequence;
            this.description = charSequence2;
        }

        public static TapTarget forView(View view, CharSequence charSequence) {
            return forView(view, charSequence, null);
        }

        public static TapTarget forView(View view, CharSequence charSequence, CharSequence charSequence2) {
            return new ViewTapTarget(view, charSequence, charSequence2);
        }

        public static TapTarget forBounds(Rect rect, CharSequence charSequence) {
            return forBounds(rect, charSequence, null);
        }

        public static TapTarget forBounds(Rect rect, CharSequence charSequence, CharSequence charSequence2) {
            return new TapTarget(rect, charSequence, charSequence2);
        }

        public TapTarget transparentTarget(boolean z) {
            this.transparentTarget = z;
            return this;
        }

        public TapTarget outerCircleColor(int i) {
            this.outerCircleColorRes = i;
            return this;
        }

        public TapTarget outerCircleColorInt(int i) {
            this.outerCircleColor = Integer.valueOf(i);
            return this;
        }

        public TapTarget outerCircleAlpha(float f) {
            if (f < 0.0f || f > 1.0f) {
                throw new IllegalArgumentException("Given an invalid alpha value: " + f);
            }
            this.outerCircleAlpha = f;
            return this;
        }

        public TapTarget targetCircleColor(int i) {
            this.targetCircleColorRes = i;
            return this;
        }

        public TapTarget targetCircleColorInt(int i) {
            this.targetCircleColor = Integer.valueOf(i);
            return this;
        }

        public TapTarget textColor(int i) {
            this.titleTextColorRes = i;
            this.descriptionTextColorRes = i;
            return this;
        }

        public TapTarget textColorInt(int i) {
            this.titleTextColor = Integer.valueOf(i);
            this.descriptionTextColor = Integer.valueOf(i);
            return this;
        }

        public TapTarget titleTextColor(int i) {
            this.titleTextColorRes = i;
            return this;
        }

        public TapTarget titleTextColorInt(int i) {
            this.titleTextColor = Integer.valueOf(i);
            return this;
        }

        public TapTarget descriptionTextColor(int i) {
            this.descriptionTextColorRes = i;
            return this;
        }

        public TapTarget descriptionTextColorInt(int i) {
            this.descriptionTextColor = Integer.valueOf(i);
            return this;
        }

        public TapTarget textTypeface(Typeface typeface) {
            if (typeface == null) {
                throw new IllegalArgumentException("Cannot use a null typeface");
            }
            this.titleTypeface = typeface;
            this.descriptionTypeface = typeface;
            return this;
        }

        public TapTarget titleTypeface(Typeface typeface) {
            if (typeface == null) {
                throw new IllegalArgumentException("Cannot use a null typeface");
            }
            this.titleTypeface = typeface;
            return this;
        }

        public TapTarget descriptionTypeface(Typeface typeface) {
            if (typeface == null) {
                throw new IllegalArgumentException("Cannot use a null typeface");
            }
            this.descriptionTypeface = typeface;
            return this;
        }

        public TapTarget titleTextSize(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Given negative text size");
            }
            this.titleTextSize = i;
            return this;
        }

        public TapTarget descriptionTextSize(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Given negative text size");
            }
            this.descriptionTextSize = i;
            return this;
        }

        public TapTarget titleTextDimen(int i) {
            this.titleTextDimen = i;
            return this;
        }

        public TapTarget descriptionTextAlpha(float f) {
            if (f < 0.0f || f > 1.0f) {
                throw new IllegalArgumentException("Given an invalid alpha value: " + f);
            }
            this.descriptionTextAlpha = f;
            return this;
        }

        public TapTarget descriptionTextDimen(int i) {
            this.descriptionTextDimen = i;
            return this;
        }

        public TapTarget dimColor(int i) {
            this.dimColorRes = i;
            return this;
        }

        public TapTarget dimColorInt(int i) {
            this.dimColor = Integer.valueOf(i);
            return this;
        }

        public TapTarget drawShadow(boolean z) {
            this.drawShadow = z;
            return this;
        }

        public TapTarget cancelable(boolean z) {
            this.cancelable = z;
            return this;
        }

        public TapTarget tintTarget(boolean z) {
            this.tintTarget = z;
            return this;
        }

        public TapTarget icon(Drawable drawable) {
            return icon(drawable, false);
        }

        public TapTarget icon(Drawable drawable, boolean z) {
            if (drawable == null) {
                throw new IllegalArgumentException("Cannot use null drawable");
            }
            this.icon = drawable;
            if (!z) {
                this.icon.setBounds(new Rect(0, 0, this.icon.getIntrinsicWidth(), this.icon.getIntrinsicHeight()));
            }
            return this;
        }

        public TapTarget id(int i) {
            this.id = i;
            return this;
        }

        public TapTarget targetRadius(int i) {
            this.targetRadius = i;
            return this;
        }

        public int id() {
            return this.id;
        }

        public void onReady(Runnable runnable) {
            runnable.run();
        }

        public Rect bounds() {
            if (this.bounds != null) {
                return this.bounds;
            }
            throw new IllegalStateException("Requesting bounds that are not set! Make sure your target is ready");
        }

        Integer outerCircleColorInt(Context context) {
            return colorResOrInt(context, this.outerCircleColor, this.outerCircleColorRes);
        }

        Integer targetCircleColorInt(Context context) {
            return colorResOrInt(context, this.targetCircleColor, this.targetCircleColorRes);
        }

        Integer dimColorInt(Context context) {
            return colorResOrInt(context, this.dimColor, this.dimColorRes);
        }

        Integer titleTextColorInt(Context context) {
            return colorResOrInt(context, this.titleTextColor, this.titleTextColorRes);
        }

        Integer descriptionTextColorInt(Context context) {
            return colorResOrInt(context, this.descriptionTextColor, this.descriptionTextColorRes);
        }

        int titleTextSizePx(Context context) {
            return dimenOrSize(context, this.titleTextSize, this.titleTextDimen);
        }

        int descriptionTextSizePx(Context context) {
            return dimenOrSize(context, this.descriptionTextSize, this.descriptionTextDimen);
        }

        private Integer colorResOrInt(Context context, Integer num, int i) {
            if (i == -1 || Build.VERSION.SDK_INT < 23) {
                return num;
            }
            return Integer.valueOf(context.getColor(i));
        }

        private int dimenOrSize(Context context, int i, int i2) {
            if (i2 != -1) {
                return context.getResources().getDimensionPixelSize(i2);
            }
            return UiUtil.sp(context, i);
        }
    }

    static class TapTargetView extends View {
        final int CIRCLE_PADDING;
        final int GUTTER_DIM;
        final int SHADOW_DIM;
        final int SHADOW_JITTER_DIM;
        final int TARGET_PADDING;
        final int TARGET_PULSE_RADIUS;
        final int TARGET_RADIUS;
        final int TEXT_MAX_WIDTH;
        final int TEXT_PADDING;
        final int TEXT_POSITIONING_BIAS;
        final int TEXT_SPACING;
        final ViewGroup boundingParent;
        final TextPaint descriptionPaint;
        final Paint outerCirclePaint;
        final Paint outerCircleShadowPaint;
        final ViewManager parent;
        final TapTarget target;
        final Rect targetBounds;
        final Paint targetCirclePaint;
        final Paint targetCirclePulsePaint;
        final TextPaint titlePaint;
        private final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
        int bottomBoundary;
        int calculatedOuterCircleRadius;
        boolean cancelable;
        boolean debug;
        DynamicLayout debugLayout;
        Paint debugPaint;
        SpannableStringBuilder debugStringBuilder;
        TextPaint debugTextPaint;
        CharSequence description;
        StaticLayout descriptionLayout;
        int dimColor;
        Rect drawingBounds;
        boolean isDark;
        float lastTouchX;
        float lastTouchY;
        Listener listener;
        int outerCircleAlpha;
        int[] outerCircleCenter;
        Path outerCirclePath;
        float outerCircleRadius;
        ViewOutlineProvider outlineProvider;
        boolean shouldDrawShadow;
        boolean shouldTintTarget;
        int targetCircleAlpha;
        int targetCirclePulseAlpha;
        float targetCirclePulseRadius;
        float targetCircleRadius;
        final ValueAnimator pulseAnimation = new FloatValueAnimatorBuilder().duration(1000).repeat(-1).interpolator(new AccelerateDecelerateInterpolator()).onUpdate(new FloatValueAnimatorBuilder.UpdateListener() {
            /* class com.updatify.o2nation.UpdaterActivity.TapTargetView.4 */

            @Override
            // com.updatify.o2nation.UpdaterActivity.FloatValueAnimatorBuilder.UpdateListener
            public void onUpdate(float f) {
                float delayedLerp = TapTargetView.this.delayedLerp(f, 0.5f);
                TapTargetView.this.targetCirclePulseRadius = (1.0f + delayedLerp) * ((float) TapTargetView.this.TARGET_RADIUS);
                TapTargetView.this.targetCirclePulseAlpha = (int) ((1.0f - delayedLerp) * 255.0f);
                TapTargetView.this.targetCircleRadius = ((float) TapTargetView.this.TARGET_RADIUS) + (TapTargetView.this.halfwayLerp(f) * ((float) TapTargetView.this.TARGET_PULSE_RADIUS));
                if (TapTargetView.this.outerCircleRadius != ((float) TapTargetView.this.calculatedOuterCircleRadius)) {
                    TapTargetView.this.outerCircleRadius = (float) TapTargetView.this.calculatedOuterCircleRadius;
                }
                TapTargetView.this.calculateDrawingBounds();
                TapTargetView.this.invalidateViewAndOutline(TapTargetView.this.drawingBounds);
            }
        }).build();
        int textAlpha;
        final FloatValueAnimatorBuilder.UpdateListener expandContractUpdateListener = new FloatValueAnimatorBuilder.UpdateListener() {
            /* class com.updatify.o2nation.UpdaterActivity.TapTargetView.1 */

            @Override
            // com.updatify.o2nation.UpdaterActivity.FloatValueAnimatorBuilder.UpdateListener
            public void onUpdate(float f) {
                float f2 = ((float) TapTargetView.this.calculatedOuterCircleRadius) * f;
                boolean z = f2 > TapTargetView.this.outerCircleRadius;
                if (!z) {
                    TapTargetView.this.calculateDrawingBounds();
                }
                float f3 = TapTargetView.this.target.outerCircleAlpha * 255.0f;
                TapTargetView.this.outerCircleRadius = f2;
                TapTargetView.this.outerCircleAlpha = (int) Math.min(f3, f * 1.5f * f3);
                TapTargetView.this.outerCirclePath.reset();
                TapTargetView.this.outerCirclePath.addCircle((float) TapTargetView.this.outerCircleCenter[0], (float) TapTargetView.this.outerCircleCenter[1], TapTargetView.this.outerCircleRadius, Path.Direction.CW);
                TapTargetView.this.targetCircleAlpha = (int) Math.min(255.0f, f * 1.5f * 255.0f);
                if (z) {
                    TapTargetView.this.targetCircleRadius = ((float) TapTargetView.this.TARGET_RADIUS) * Math.min(1.0f, f * 1.5f);
                } else {
                    TapTargetView.this.targetCircleRadius = ((float) TapTargetView.this.TARGET_RADIUS) * f;
                    TapTargetView.this.targetCirclePulseRadius *= f;
                }
                TapTargetView.this.textAlpha = (int) (TapTargetView.this.delayedLerp(f, 0.7f) * 255.0f);
                if (z) {
                    TapTargetView.this.calculateDrawingBounds();
                }
                TapTargetView.this.invalidateViewAndOutline(TapTargetView.this.drawingBounds);
            }
        };
        Rect textBounds;
        Bitmap tintedTarget;
        CharSequence title;
        StaticLayout titleLayout;
        int topBoundary;
        boolean visible;
        private ValueAnimator[] animators = {this.expandAnimation, this.pulseAnimation, this.dismissConfirmAnimation, this.dismissAnimation};
        private boolean isDismissed = false;
        private boolean isDismissing = false;
        final ValueAnimator dismissAnimation = new FloatValueAnimatorBuilder(true).duration(250).interpolator(new AccelerateDecelerateInterpolator()).onUpdate(new FloatValueAnimatorBuilder.UpdateListener() {
            /* class com.updatify.o2nation.UpdaterActivity.TapTargetView.5 */

            @Override
            // com.updatify.o2nation.UpdaterActivity.FloatValueAnimatorBuilder.UpdateListener
            public void onUpdate(float f) {
                TapTargetView.this.expandContractUpdateListener.onUpdate(f);
            }
        }).onEnd(new FloatValueAnimatorBuilder.EndListener() {
            /* class com.updatify.o2nation.UpdaterActivity.TapTargetView.6 */

            @Override // com.updatify.o2nation.UpdaterActivity.FloatValueAnimatorBuilder.EndListener
            public void onEnd() {
                TapTargetView.this.onDismiss(true);
                ViewUtil.removeView(TapTargetView.this.parent, TapTargetView.this);
            }
        }).build();
        private final ValueAnimator dismissConfirmAnimation = new FloatValueAnimatorBuilder().duration(250).interpolator(new AccelerateDecelerateInterpolator()).onUpdate(new FloatValueAnimatorBuilder.UpdateListener() {
            /* class com.updatify.o2nation.UpdaterActivity.TapTargetView.7 */

            @Override
            // com.updatify.o2nation.UpdaterActivity.FloatValueAnimatorBuilder.UpdateListener
            public void onUpdate(float f) {
                float min = Math.min(1.0f, 2.0f * f);
                TapTargetView.this.outerCircleRadius = ((float) TapTargetView.this.calculatedOuterCircleRadius) * ((0.2f * min) + 1.0f);
                TapTargetView.this.outerCircleAlpha = (int) ((1.0f - min) * TapTargetView.this.target.outerCircleAlpha * 255.0f);
                TapTargetView.this.outerCirclePath.reset();
                TapTargetView.this.outerCirclePath.addCircle((float) TapTargetView.this.outerCircleCenter[0], (float) TapTargetView.this.outerCircleCenter[1], TapTargetView.this.outerCircleRadius, Path.Direction.CW);
                TapTargetView.this.targetCircleRadius = (1.0f - f) * ((float) TapTargetView.this.TARGET_RADIUS);
                TapTargetView.this.targetCircleAlpha = (int) ((1.0f - f) * 255.0f);
                TapTargetView.this.targetCirclePulseRadius = (1.0f + f) * ((float) TapTargetView.this.TARGET_RADIUS);
                TapTargetView.this.targetCirclePulseAlpha = (int) ((1.0f - f) * ((float) TapTargetView.this.targetCirclePulseAlpha));
                TapTargetView.this.textAlpha = (int) ((1.0f - min) * 255.0f);
                TapTargetView.this.calculateDrawingBounds();
                TapTargetView.this.invalidateViewAndOutline(TapTargetView.this.drawingBounds);
            }
        }).onEnd(new FloatValueAnimatorBuilder.EndListener() {
            /* class com.updatify.o2nation.UpdaterActivity.TapTargetView.8 */

            @Override // com.updatify.o2nation.UpdaterActivity.FloatValueAnimatorBuilder.EndListener
            public void onEnd() {
                TapTargetView.this.onDismiss(true);
                ViewUtil.removeView(TapTargetView.this.parent, TapTargetView.this);
            }
        }).build();
        private boolean isInteractable = true;
        final ValueAnimator expandAnimation = new FloatValueAnimatorBuilder().duration(250).delayBy(250).interpolator(new AccelerateDecelerateInterpolator()).onUpdate(new FloatValueAnimatorBuilder.UpdateListener() {
            /* class com.updatify.o2nation.UpdaterActivity.TapTargetView.2 */

            @Override
            // com.updatify.o2nation.UpdaterActivity.FloatValueAnimatorBuilder.UpdateListener
            public void onUpdate(float f) {
                TapTargetView.this.expandContractUpdateListener.onUpdate(f);
            }
        }).onEnd(new FloatValueAnimatorBuilder.EndListener() {
            /* class com.updatify.o2nation.UpdaterActivity.TapTargetView.3 */

            @Override // com.updatify.o2nation.UpdaterActivity.FloatValueAnimatorBuilder.EndListener
            public void onEnd() {
                TapTargetView.this.pulseAnimation.start();
                TapTargetView.this.isInteractable = true;
            }
        }).build();

        public TapTargetView(final Context context, ViewManager viewManager, final ViewGroup viewGroup, final TapTarget tapTarget, Listener listener2) {
            super(context);
            if (tapTarget == null) {
                throw new IllegalArgumentException("Target cannot be null");
            }
            this.target = tapTarget;
            this.parent = viewManager;
            this.boundingParent = viewGroup;
            this.listener = listener2 == null ? new Listener() : listener2;
            this.title = tapTarget.title;
            this.description = tapTarget.description;
            this.TARGET_PADDING = UiUtil.dp(context, 20);
            this.CIRCLE_PADDING = UiUtil.dp(context, 40);
            this.TARGET_RADIUS = UiUtil.dp(context, tapTarget.targetRadius);
            this.TEXT_PADDING = UiUtil.dp(context, 40);
            this.TEXT_SPACING = UiUtil.dp(context, 8);
            this.TEXT_MAX_WIDTH = UiUtil.dp(context, 360);
            this.TEXT_POSITIONING_BIAS = UiUtil.dp(context, 20);
            this.GUTTER_DIM = UiUtil.dp(context, 88);
            this.SHADOW_DIM = UiUtil.dp(context, 8);
            this.SHADOW_JITTER_DIM = UiUtil.dp(context, 1);
            this.TARGET_PULSE_RADIUS = (int) (0.1f * ((float) this.TARGET_RADIUS));
            this.outerCirclePath = new Path();
            this.targetBounds = new Rect();
            this.drawingBounds = new Rect();
            this.titlePaint = new TextPaint();
            this.titlePaint.setTextSize((float) tapTarget.titleTextSizePx(context));
            this.titlePaint.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
            this.titlePaint.setAntiAlias(true);
            this.descriptionPaint = new TextPaint();
            this.descriptionPaint.setTextSize((float) tapTarget.descriptionTextSizePx(context));
            this.descriptionPaint.setTypeface(Typeface.create(Typeface.SANS_SERIF, Typeface.NORMAL));
            this.descriptionPaint.setAntiAlias(true);
            this.descriptionPaint.setAlpha(137);
            this.outerCirclePaint = new Paint();
            this.outerCirclePaint.setAntiAlias(true);
            this.outerCirclePaint.setAlpha((int) (tapTarget.outerCircleAlpha * 255.0f));
            this.outerCircleShadowPaint = new Paint();
            this.outerCircleShadowPaint.setAntiAlias(true);
            this.outerCircleShadowPaint.setAlpha(50);
            this.outerCircleShadowPaint.setStyle(Paint.Style.STROKE);
            this.outerCircleShadowPaint.setStrokeWidth((float) this.SHADOW_JITTER_DIM);
            this.outerCircleShadowPaint.setColor(-16777216);
            this.targetCirclePaint = new Paint();
            this.targetCirclePaint.setAntiAlias(true);
            this.targetCirclePulsePaint = new Paint();
            this.targetCirclePulsePaint.setAntiAlias(true);
            applyTargetOptions(context);
            this.globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
                /* class com.updatify.o2nation.UpdaterActivity.TapTargetView.9 */

                public void onGlobalLayout() {
                    if (!TapTargetView.this.isDismissing) {
                        TapTargetView.this.updateTextLayouts();
                        final TapTarget tapTarget2 = tapTarget;
                        tapTarget.onReady(new Runnable() {
                            /* class com.updatify.o2nation.UpdaterActivity.TapTargetView.9.1 */

                            public void run() {
                                int[] iArr = new int[2];
                                TapTargetView.this.targetBounds.set(tapTarget2.bounds());
                                TapTargetView.this.getLocationOnScreen(iArr);
                                TapTargetView.this.targetBounds.offset(-iArr[0], -iArr[1]);
                                if (viewGroup != null) {
                                    DisplayMetrics displayMetrics = new DisplayMetrics();
                                    ((WindowManager) context.getSystemService(WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMetrics);
                                    Rect rect = new Rect();
                                    viewGroup.getWindowVisibleDisplayFrame(rect);
                                    TapTargetView.this.topBoundary = Math.max(0, rect.top);
                                    TapTargetView.this.bottomBoundary = Math.min(rect.bottom, displayMetrics.heightPixels);
                                }
                                TapTargetView.this.drawTintedTarget();
                                TapTargetView.this.requestFocus();
                                TapTargetView.this.calculateDimensions();
                                TapTargetView.this.startExpandAnimation();
                            }
                        });
                    }
                }
            };
            getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
            setFocusableInTouchMode(true);
            setClickable(true);
            setOnClickListener(new View.OnClickListener() {
                /* class com.updatify.o2nation.UpdaterActivity.TapTargetView.10 */

                public void onClick(View view) {
                    boolean z = true;
                    if (TapTargetView.this.listener != null && TapTargetView.this.outerCircleCenter != null && TapTargetView.this.isInteractable) {
                        boolean z2 = TapTargetView.this.distance(TapTargetView.this.targetBounds.centerX(), TapTargetView.this.targetBounds.centerY(), (int) TapTargetView.this.lastTouchX, (int) TapTargetView.this.lastTouchY) <= ((double) TapTargetView.this.targetCircleRadius);
                        if (TapTargetView.this.distance(TapTargetView.this.outerCircleCenter[0], TapTargetView.this.outerCircleCenter[1], (int) TapTargetView.this.lastTouchX, (int) TapTargetView.this.lastTouchY) > ((double) TapTargetView.this.outerCircleRadius)) {
                            z = false;
                        }
                        if (z2) {
                            TapTargetView.this.isInteractable = false;
                            TapTargetView.this.listener.onTargetClick(TapTargetView.this);
                        } else if (z) {
                            TapTargetView.this.listener.onOuterCircleClick(TapTargetView.this);
                        } else if (TapTargetView.this.cancelable) {
                            TapTargetView.this.isInteractable = false;
                            TapTargetView.this.listener.onTargetCancel(TapTargetView.this);
                        }
                    }
                }
            });
            setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.updatify.o2nation.UpdaterActivity.TapTargetView.11 */

                public boolean onLongClick(View view) {
                    if (TapTargetView.this.listener == null || !TapTargetView.this.targetBounds.contains((int) TapTargetView.this.lastTouchX, (int) TapTargetView.this.lastTouchY)) {
                        return false;
                    }
                    TapTargetView.this.listener.onTargetLongClick(TapTargetView.this);
                    return true;
                }
            });
        }

        public static TapTargetView showFor(Activity activity, TapTarget tapTarget) {
            return showFor(activity, tapTarget, (Listener) null);
        }

        public static TapTargetView showFor(Activity activity, TapTarget tapTarget, Listener listener2) {
            if (activity == null) {
                throw new IllegalArgumentException("Activity is null");
            }
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            TapTargetView tapTargetView = new TapTargetView(activity, viewGroup, (ViewGroup) viewGroup.findViewById(16908290), tapTarget, listener2);
            viewGroup.addView(tapTargetView, layoutParams);
            return tapTargetView;
        }

        public static TapTargetView showFor(Dialog dialog, TapTarget tapTarget) {
            return showFor(dialog, tapTarget, (Listener) null);
        }

        public static TapTargetView showFor(Dialog dialog, TapTarget tapTarget, Listener listener2) {
            if (dialog == null) {
                throw new IllegalArgumentException("Dialog is null");
            }
            Context context = dialog.getContext();
            WindowManager windowManager = (WindowManager) context.getSystemService(WINDOW_SERVICE);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION;
            layoutParams.format = 1;
            layoutParams.flags = 0;
            layoutParams.gravity = 8388659;
            layoutParams.x = 0;
            layoutParams.y = 0;
            layoutParams.width = -1;
            layoutParams.height = -1;
            TapTargetView tapTargetView = new TapTargetView(context, windowManager, null, tapTarget, listener2);
            windowManager.addView(tapTargetView, layoutParams);
            return tapTargetView;
        }

        /* access modifiers changed from: private */
        public void startExpandAnimation() {
            if (!this.visible) {
                this.isInteractable = false;
                this.expandAnimation.start();
                this.visible = true;
            }
        }

        protected void applyTargetOptions(Context context) {
            boolean z = true;
            int i = -16777216;
            this.shouldTintTarget = this.target.tintTarget;
            this.shouldDrawShadow = this.target.drawShadow;
            this.cancelable = this.target.cancelable;
            if (this.shouldDrawShadow && Build.VERSION.SDK_INT >= 21 && !this.target.transparentTarget) {
                this.outlineProvider = new ViewOutlineProvider() {
                    /* class com.updatify.o2nation.UpdaterActivity.TapTargetView.12 */

                    public void getOutline(View view, Outline outline) {
                        if (TapTargetView.this.outerCircleCenter != null) {
                            outline.setOval((int) (((float) TapTargetView.this.outerCircleCenter[0]) - TapTargetView.this.outerCircleRadius), (int) (((float) TapTargetView.this.outerCircleCenter[1]) - TapTargetView.this.outerCircleRadius), (int) (((float) TapTargetView.this.outerCircleCenter[0]) + TapTargetView.this.outerCircleRadius), (int) (((float) TapTargetView.this.outerCircleCenter[1]) + TapTargetView.this.outerCircleRadius));
                            outline.setAlpha(((float) TapTargetView.this.outerCircleAlpha) / 255.0f);
                            if (Build.VERSION.SDK_INT >= 22) {
                                outline.offset(0, TapTargetView.this.SHADOW_DIM);
                            }
                        }
                    }
                };
                setOutlineProvider(this.outlineProvider);
                setElevation((float) this.SHADOW_DIM);
            }
            if (!this.shouldDrawShadow || this.outlineProvider != null || Build.VERSION.SDK_INT >= 18) {
                setLayerType(View.LAYER_TYPE_HARDWARE, null);
            } else {
                setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            }
            Resources.Theme theme = context.getTheme();
            if (UiUtil.themeIntAttr(context, "isLightTheme") != 0) {
                z = false;
            }
            this.isDark = z;
            Integer outerCircleColorInt = this.target.outerCircleColorInt(context);
            if (outerCircleColorInt != null) {
                this.outerCirclePaint.setColor(outerCircleColorInt.intValue());
            } else if (theme != null) {
                this.outerCirclePaint.setColor(UiUtil.themeIntAttr(context, "colorPrimary"));
            } else {
                this.outerCirclePaint.setColor(-1);
            }
            Integer targetCircleColorInt = this.target.targetCircleColorInt(context);
            if (targetCircleColorInt != null) {
                this.targetCirclePaint.setColor(targetCircleColorInt.intValue());
            } else {
                this.targetCirclePaint.setColor(this.isDark ? -16777216 : -1);
            }
            if (this.target.transparentTarget) {
                this.targetCirclePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            }
            this.targetCirclePulsePaint.setColor(this.targetCirclePaint.getColor());
            Integer dimColorInt = this.target.dimColorInt(context);
            if (dimColorInt != null) {
                this.dimColor = UiUtil.setAlpha(dimColorInt.intValue(), 0.3f);
            } else {
                this.dimColor = -1;
            }
            Integer titleTextColorInt = this.target.titleTextColorInt(context);
            if (titleTextColorInt != null) {
                this.titlePaint.setColor(titleTextColorInt.intValue());
            } else {
                TextPaint textPaint = this.titlePaint;
                if (!this.isDark) {
                    i = -1;
                }
                textPaint.setColor(i);
            }
            Integer descriptionTextColorInt = this.target.descriptionTextColorInt(context);
            if (descriptionTextColorInt != null) {
                this.descriptionPaint.setColor(descriptionTextColorInt.intValue());
            } else {
                this.descriptionPaint.setColor(this.titlePaint.getColor());
            }
            if (this.target.titleTypeface != null) {
                this.titlePaint.setTypeface(this.target.titleTypeface);
            }
            if (this.target.descriptionTypeface != null) {
                this.descriptionPaint.setTypeface(this.target.descriptionTypeface);
            }
        }

        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            onDismiss(false);
        }

        void onDismiss(boolean z) {
            if (!this.isDismissed) {
                this.isDismissing = false;
                this.isDismissed = true;
                ValueAnimator[] valueAnimatorArr = this.animators;
                for (ValueAnimator valueAnimator : valueAnimatorArr) {
                    valueAnimator.cancel();
                    valueAnimator.removeAllUpdateListeners();
                }
                ViewUtil.removeOnGlobalLayoutListener(getViewTreeObserver(), this.globalLayoutListener);
                this.visible = false;
                if (this.listener != null) {
                    this.listener.onTargetDismissed(this, z);
                }
            }
        }

        protected void onDraw(Canvas canvas) {
            if (!this.isDismissed && this.outerCircleCenter != null) {
                if (this.topBoundary > 0 && this.bottomBoundary > 0) {
                    canvas.clipRect(0, this.topBoundary, getWidth(), this.bottomBoundary);
                }
                if (this.dimColor != -1) {
                    canvas.drawColor(this.dimColor);
                }
                this.outerCirclePaint.setAlpha(this.outerCircleAlpha);
                if (this.shouldDrawShadow && this.outlineProvider == null) {
                    int save = canvas.save();
                    canvas.clipPath(this.outerCirclePath, Region.Op.DIFFERENCE);
                    drawJitteredShadow(canvas);
                    canvas.restoreToCount(save);
                }
                canvas.drawCircle((float) this.outerCircleCenter[0], (float) this.outerCircleCenter[1], this.outerCircleRadius, this.outerCirclePaint);
                this.targetCirclePaint.setAlpha(this.targetCircleAlpha);
                if (this.targetCirclePulseAlpha > 0) {
                    this.targetCirclePulsePaint.setAlpha(this.targetCirclePulseAlpha);
                    canvas.drawCircle((float) this.targetBounds.centerX(), (float) this.targetBounds.centerY(), this.targetCirclePulseRadius, this.targetCirclePulsePaint);
                }
                canvas.drawCircle((float) this.targetBounds.centerX(), (float) this.targetBounds.centerY(), this.targetCircleRadius, this.targetCirclePaint);
                int save2 = canvas.save();
                canvas.translate((float) this.textBounds.left, (float) this.textBounds.top);
                this.titlePaint.setAlpha(this.textAlpha);
                if (this.titleLayout != null) {
                    this.titleLayout.draw(canvas);
                }
                if (!(this.descriptionLayout == null || this.titleLayout == null)) {
                    canvas.translate(0.0f, (float) (this.titleLayout.getHeight() + this.TEXT_SPACING));
                    this.descriptionPaint.setAlpha((int) (this.target.descriptionTextAlpha * ((float) this.textAlpha)));
                    this.descriptionLayout.draw(canvas);
                }
                canvas.restoreToCount(save2);
                int save3 = canvas.save();
                if (this.tintedTarget != null) {
                    canvas.translate((float) (this.targetBounds.centerX() - (this.tintedTarget.getWidth() / 2)), (float) (this.targetBounds.centerY() - (this.tintedTarget.getHeight() / 2)));
                    canvas.drawBitmap(this.tintedTarget, 0.0f, 0.0f, this.targetCirclePaint);
                } else if (this.target.icon != null) {
                    canvas.translate((float) (this.targetBounds.centerX() - (this.target.icon.getBounds().width() / 2)), (float) (this.targetBounds.centerY() - (this.target.icon.getBounds().height() / 2)));
                    this.target.icon.setAlpha(this.targetCirclePaint.getAlpha());
                    this.target.icon.draw(canvas);
                }
                canvas.restoreToCount(save3);
                if (this.debug) {
                    drawDebugInformation(canvas);
                }
            }
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            this.lastTouchX = motionEvent.getX();
            this.lastTouchY = motionEvent.getY();
            return super.onTouchEvent(motionEvent);
        }

        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (!isVisible() || !this.cancelable || i != 4) {
                return false;
            }
            keyEvent.startTracking();
            return true;
        }

        public boolean onKeyUp(int i, KeyEvent keyEvent) {
            if (!isVisible() || !this.isInteractable || !this.cancelable || i != 4 || !keyEvent.isTracking() || keyEvent.isCanceled()) {
                return false;
            }
            this.isInteractable = false;
            if (this.listener != null) {
                this.listener.onTargetCancel(this);
            } else {
                new Listener().onTargetCancel(this);
            }
            return true;
        }

        public void dismiss(boolean z) {
            this.isDismissing = true;
            this.pulseAnimation.cancel();
            this.expandAnimation.cancel();
            if (z) {
                this.dismissConfirmAnimation.start();
            } else {
                this.dismissAnimation.start();
            }
        }

        public void setDrawDebug(boolean z) {
            if (this.debug != z) {
                this.debug = z;
                postInvalidate();
            }
        }

        public boolean isVisible() {
            return !this.isDismissed && this.visible;
        }

        void drawJitteredShadow(Canvas canvas) {
            float f = ((float) this.outerCircleAlpha) * 0.2f;
            this.outerCircleShadowPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.outerCircleShadowPaint.setAlpha((int) f);
            canvas.drawCircle((float) this.outerCircleCenter[0], (float) (this.outerCircleCenter[1] + this.SHADOW_DIM), this.outerCircleRadius, this.outerCircleShadowPaint);
            this.outerCircleShadowPaint.setStyle(Paint.Style.STROKE);
            for (int i = 6; i > 0; i--) {
                this.outerCircleShadowPaint.setAlpha((int) ((((float) i) / 7.0f) * f));
                canvas.drawCircle((float) this.outerCircleCenter[0], (float) (this.outerCircleCenter[1] + this.SHADOW_DIM), this.outerCircleRadius + ((float) ((7 - i) * this.SHADOW_JITTER_DIM)), this.outerCircleShadowPaint);
            }
        }

        void drawDebugInformation(Canvas canvas) {
            if (this.debugPaint == null) {
                this.debugPaint = new Paint();
                this.debugPaint.setARGB(255, 255, 0, 0);
                this.debugPaint.setStyle(Paint.Style.STROKE);
                this.debugPaint.setStrokeWidth((float) UiUtil.dp(getContext(), 1));
            }
            if (this.debugTextPaint == null) {
                this.debugTextPaint = new TextPaint();
                this.debugTextPaint.setColor(-65536);
                this.debugTextPaint.setTextSize((float) UiUtil.sp(getContext(), 16));
            }
            this.debugPaint.setStyle(Paint.Style.STROKE);
            canvas.drawRect(this.textBounds, this.debugPaint);
            canvas.drawRect(this.targetBounds, this.debugPaint);
            canvas.drawCircle((float) this.outerCircleCenter[0], (float) this.outerCircleCenter[1], 10.0f, this.debugPaint);
            canvas.drawCircle((float) this.outerCircleCenter[0], (float) this.outerCircleCenter[1], (float) (this.calculatedOuterCircleRadius - this.CIRCLE_PADDING), this.debugPaint);
            canvas.drawCircle((float) this.targetBounds.centerX(), (float) this.targetBounds.centerY(), (float) (this.TARGET_RADIUS + this.TARGET_PADDING), this.debugPaint);
            this.debugPaint.setStyle(Paint.Style.FILL);
            String str = "Text bounds: " + this.textBounds.toShortString() + "n" + "Target bounds: " + this.targetBounds.toShortString() + "n" + "Center: " + this.outerCircleCenter[0] + " " + this.outerCircleCenter[1] + "n" + "View size: " + getWidth() + " " + getHeight() + "n" + "Target bounds: " + this.targetBounds.toShortString();
            if (this.debugStringBuilder == null) {
                this.debugStringBuilder = new SpannableStringBuilder(str);
            } else {
                this.debugStringBuilder.clear();
                this.debugStringBuilder.append((CharSequence) str);
            }
            if (this.debugLayout == null) {
                this.debugLayout = new DynamicLayout(str, this.debugTextPaint, getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            }
            int save = canvas.save();
            this.debugPaint.setARGB(220, 0, 0, 0);
            canvas.translate(0.0f, (float) this.topBoundary);
            canvas.drawRect(0.0f, 0.0f, (float) this.debugLayout.getWidth(), (float) this.debugLayout.getHeight(), this.debugPaint);
            this.debugPaint.setARGB(255, 255, 0, 0);
            this.debugLayout.draw(canvas);
            canvas.restoreToCount(save);
        }

        void drawTintedTarget() {
            Drawable drawable = this.target.icon;
            if (!this.shouldTintTarget || drawable == null) {
                this.tintedTarget = null;
            } else if (this.tintedTarget == null) {
                this.tintedTarget = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.tintedTarget);
                drawable.setColorFilter(new PorterDuffColorFilter(this.outerCirclePaint.getColor(), PorterDuff.Mode.SRC_ATOP));
                drawable.draw(canvas);
                drawable.setColorFilter(null);
            }
        }

        void updateTextLayouts() {
            int min = Math.min(getWidth(), this.TEXT_MAX_WIDTH) - (this.TEXT_PADDING * 2);
            if (min > 0) {
                this.titleLayout = new StaticLayout(this.title, this.titlePaint, min, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                if (this.description != null) {
                    this.descriptionLayout = new StaticLayout(this.description, this.descriptionPaint, min, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                } else {
                    this.descriptionLayout = null;
                }
            }
        }

        float halfwayLerp(float f) {
            if (f < 0.5f) {
                return f / 0.5f;
            }
            return (1.0f - f) / 0.5f;
        }

        float delayedLerp(float f, float f2) {
            if (f < f2) {
                return 0.0f;
            }
            return (f - f2) / (1.0f - f2);
        }

        void calculateDimensions() {
            this.textBounds = getTextBounds();
            this.outerCircleCenter = getOuterCircleCenterPoint();
            this.calculatedOuterCircleRadius = getOuterCircleRadius(this.outerCircleCenter[0], this.outerCircleCenter[1], this.textBounds, this.targetBounds);
        }

        void calculateDrawingBounds() {
            if (this.outerCircleCenter != null) {
                this.drawingBounds.left = (int) Math.max(0.0f, ((float) this.outerCircleCenter[0]) - this.outerCircleRadius);
                this.drawingBounds.top = (int) Math.min(0.0f, ((float) this.outerCircleCenter[1]) - this.outerCircleRadius);
                this.drawingBounds.right = (int) Math.min((float) getWidth(), ((float) this.outerCircleCenter[0]) + this.outerCircleRadius + ((float) this.CIRCLE_PADDING));
                this.drawingBounds.bottom = (int) Math.min((float) getHeight(), ((float) this.outerCircleCenter[1]) + this.outerCircleRadius + ((float) this.CIRCLE_PADDING));
            }
        }

        int getOuterCircleRadius(int i, int i2, Rect rect, Rect rect2) {
            int centerX = rect2.centerX();
            int centerY = rect2.centerY();
            int i3 = (int) (1.1f * ((float) this.TARGET_RADIUS));
            Rect rect3 = new Rect(centerX, centerY, centerX, centerY);
            rect3.inset(-i3, -i3);
            return Math.max(maxDistanceToPoints(i, i2, rect), maxDistanceToPoints(i, i2, rect3)) + this.CIRCLE_PADDING;
        }

        Rect getTextBounds() {
            int totalTextHeight = getTotalTextHeight();
            int totalTextWidth = getTotalTextWidth();
            int centerY = ((this.targetBounds.centerY() - this.TARGET_RADIUS) - this.TARGET_PADDING) - totalTextHeight;
            if (centerY <= this.topBoundary) {
                centerY = this.targetBounds.centerY() + this.TARGET_RADIUS + this.TARGET_PADDING;
            }
            int max = Math.max(this.TEXT_PADDING, (this.targetBounds.centerX() - ((getWidth() / 2) - this.targetBounds.centerX() < 0 ? -this.TEXT_POSITIONING_BIAS : this.TEXT_POSITIONING_BIAS)) - totalTextWidth);
            return new Rect(max, centerY, Math.min(getWidth() - this.TEXT_PADDING, totalTextWidth + max), totalTextHeight + centerY);
        }

        int[] getOuterCircleCenterPoint() {
            int centerY;
            if (inGutter(this.targetBounds.centerY())) {
                return new int[]{this.targetBounds.centerX(), this.targetBounds.centerY()};
            }
            int max = this.TARGET_PADDING + (Math.max(this.targetBounds.width(), this.targetBounds.height()) / 2);
            int totalTextHeight = getTotalTextHeight();
            boolean z = ((this.targetBounds.centerY() - this.TARGET_RADIUS) - this.TARGET_PADDING) - totalTextHeight > 0;
            int min = Math.min(this.textBounds.left, this.targetBounds.left - max);
            int max2 = Math.max(this.textBounds.right, max + this.targetBounds.right);
            int height = this.titleLayout == null ? 0 : this.titleLayout.getHeight();
            if (z) {
                centerY = (((this.targetBounds.centerY() - this.TARGET_RADIUS) - this.TARGET_PADDING) - totalTextHeight) + height;
            } else {
                centerY = this.targetBounds.centerY() + this.TARGET_RADIUS + this.TARGET_PADDING + height;
            }
            return new int[]{(min + max2) / 2, centerY};
        }

        int getTotalTextHeight() {
            if (this.titleLayout == null) {
                return 0;
            }
            if (this.descriptionLayout == null) {
                return this.titleLayout.getHeight() + this.TEXT_SPACING;
            }
            return this.titleLayout.getHeight() + this.descriptionLayout.getHeight() + this.TEXT_SPACING;
        }

        int getTotalTextWidth() {
            if (this.titleLayout == null) {
                return 0;
            }
            if (this.descriptionLayout == null) {
                return this.titleLayout.getWidth();
            }
            return Math.max(this.titleLayout.getWidth(), this.descriptionLayout.getWidth());
        }

        boolean inGutter(int i) {
            return this.bottomBoundary > 0 ? i < this.GUTTER_DIM || i > this.bottomBoundary - this.GUTTER_DIM : i < this.GUTTER_DIM || i > getHeight() - this.GUTTER_DIM;
        }

        int maxDistanceToPoints(int i, int i2, Rect rect) {
            return (int) Math.max(distance(i, i2, rect.left, rect.top), Math.max(distance(i, i2, rect.right, rect.top), Math.max(distance(i, i2, rect.left, rect.bottom), distance(i, i2, rect.right, rect.bottom))));
        }

        double distance(int i, int i2, int i3, int i4) {
            return Math.sqrt(Math.pow((double) (i3 - i), 2.0d) + Math.pow((double) (i4 - i2), 2.0d));
        }

        void invalidateViewAndOutline(Rect rect) {
            invalidate(rect);
            if (this.outlineProvider != null && Build.VERSION.SDK_INT >= 21) {
                invalidateOutline();
            }
        }

        public static class Listener {
            public void onTargetClick(TapTargetView tapTargetView) {
                tapTargetView.dismiss(true);
            }

            public void onTargetLongClick(TapTargetView tapTargetView) {
                onTargetClick(tapTargetView);
            }

            public void onTargetCancel(TapTargetView tapTargetView) {
                tapTargetView.dismiss(false);
            }

            public void onOuterCircleClick(TapTargetView tapTargetView) {
            }

            public void onTargetDismissed(TapTargetView tapTargetView, boolean z) {
            }
        }
    }

    static class ViewUtil {
        ViewUtil() {
        }

        private static boolean isLaidOut(View view) {
            return true;
        }

        static void onLaidOut(final View view, final Runnable runnable) {
            if (isLaidOut(view)) {
                runnable.run();
                return;
            }
            final ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                /* class com.updatify.o2nation.UpdaterActivity.ViewUtil.1 */

                public void onGlobalLayout() {
                    ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver = viewTreeObserver;
                    } else {
                        viewTreeObserver = view.getViewTreeObserver();
                    }
                    ViewUtil.removeOnGlobalLayoutListener(viewTreeObserver, this);
                    runnable.run();
                }
            });
        }

        static void removeOnGlobalLayoutListener(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            if (Build.VERSION.SDK_INT >= 16) {
                viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
            } else {
                viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
            }
        }

        static void removeView(ViewManager viewManager, View view) {
            if (viewManager != null && view != null) {
                try {
                    viewManager.removeView(view);
                } catch (Exception e) {
                }
            }
        }
    }

    static class ViewTapTarget extends TapTarget {
        final View view;

        ViewTapTarget(View view2, CharSequence charSequence, CharSequence charSequence2) {
            super(charSequence, charSequence2);
            if (view2 == null) {
                throw new IllegalArgumentException("Given null view to target");
            }
            this.view = view2;
        }

        @Override // com.updatify.o2nation.UpdaterActivity.TapTarget
        public void onReady(final Runnable runnable) {
            ViewUtil.onLaidOut(this.view, new Runnable() {
                /* class com.updatify.o2nation.UpdaterActivity.ViewTapTarget.1 */

                public void run() {
                    int[] iArr = new int[2];
                    ViewTapTarget.this.view.getLocationOnScreen(iArr);
                    ViewTapTarget.this.bounds = new Rect(iArr[0], iArr[1], iArr[0] + ViewTapTarget.this.view.getWidth(), iArr[1] + ViewTapTarget.this.view.getHeight());
                    if (ViewTapTarget.this.icon == null && ViewTapTarget.this.view.getWidth() > 0 && ViewTapTarget.this.view.getHeight() > 0) {
                        Bitmap createBitmap = Bitmap.createBitmap(ViewTapTarget.this.view.getWidth(), ViewTapTarget.this.view.getHeight(), Bitmap.Config.ARGB_8888);
                        ViewTapTarget.this.view.draw(new Canvas(createBitmap));
                        ViewTapTarget.this.icon = new BitmapDrawable(ViewTapTarget.this.view.getContext().getResources(), createBitmap);
                        ViewTapTarget.this.icon.setBounds(0, 0, ViewTapTarget.this.icon.getIntrinsicWidth(), ViewTapTarget.this.icon.getIntrinsicHeight());
                    }
                    runnable.run();
                }
            });
        }
    }

    static class TapTargetSequence {
        private final Activity activity;
        private final Dialog dialog;
        private final Queue<TapTarget> targets;
        boolean considerOuterCircleCanceled;
        boolean continueOnCancel;
        Listener listener;
        private boolean active;
        private TapTargetView currentView;
        private final TapTargetView.Listener tapTargetListener = new TapTargetView.Listener() {
            /* class com.updatify.o2nation.UpdaterActivity.TapTargetSequence.1 */

            @Override // com.updatify.o2nation.UpdaterActivity.TapTargetView.Listener
            public void onTargetClick(TapTargetView tapTargetView) {
                super.onTargetClick(tapTargetView);
                if (TapTargetSequence.this.listener != null) {
                    TapTargetSequence.this.listener.onSequenceStep(tapTargetView.target, true);
                }
                TapTargetSequence.this.showNext();
            }

            @Override // com.updatify.o2nation.UpdaterActivity.TapTargetView.Listener
            public void onOuterCircleClick(TapTargetView tapTargetView) {
                if (TapTargetSequence.this.considerOuterCircleCanceled) {
                    onTargetCancel(tapTargetView);
                }
            }

            @Override // com.updatify.o2nation.UpdaterActivity.TapTargetView.Listener
            public void onTargetCancel(TapTargetView tapTargetView) {
                super.onTargetCancel(tapTargetView);
                if (TapTargetSequence.this.continueOnCancel) {
                    if (TapTargetSequence.this.listener != null) {
                        TapTargetSequence.this.listener.onSequenceStep(tapTargetView.target, false);
                    }
                    TapTargetSequence.this.showNext();
                } else if (TapTargetSequence.this.listener != null) {
                    TapTargetSequence.this.listener.onSequenceCanceled(tapTargetView.target);
                }
            }
        };

        public TapTargetSequence(Activity activity2) {
            if (activity2 == null) {
                throw new IllegalArgumentException("Activity is null");
            }
            this.activity = activity2;
            this.dialog = null;
            this.targets = new LinkedList();
        }

        public TapTargetSequence(Dialog dialog2) {
            if (dialog2 == null) {
                throw new IllegalArgumentException("Given null Dialog");
            }
            this.dialog = dialog2;
            this.activity = null;
            this.targets = new LinkedList();
        }

        public TapTargetSequence targets(List<TapTarget> list) {
            this.targets.addAll(list);
            return this;
        }

        public TapTargetSequence targets(TapTarget... tapTargetArr) {
            Collections.addAll(this.targets, tapTargetArr);
            return this;
        }

        public TapTargetSequence target(TapTarget tapTarget) {
            this.targets.add(tapTarget);
            return this;
        }

        public TapTargetSequence continueOnCancel(boolean z) {
            this.continueOnCancel = z;
            return this;
        }

        public TapTargetSequence considerOuterCircleCanceled(boolean z) {
            this.considerOuterCircleCanceled = z;
            return this;
        }

        public TapTargetSequence listener(Listener listener2) {
            this.listener = listener2;
            return this;
        }

        public void start() {
            if (!this.targets.isEmpty() && !this.active) {
                this.active = true;
                showNext();
            }
        }

        public void startWith(int i) {
            if (!this.active) {
                while (this.targets.peek() != null && this.targets.peek().id() != i) {
                    this.targets.poll();
                }
                TapTarget peek = this.targets.peek();
                if (peek == null || peek.id() != i) {
                    throw new IllegalStateException("Given target " + i + " not in sequence");
                }
                start();
            }
        }

        public void startAt(int i) {
            if (!this.active) {
                if (i < 0 || i >= this.targets.size()) {
                    throw new IllegalArgumentException("Given invalid index " + i);
                }
                int size = this.targets.size() - i;
                while (this.targets.peek() != null && this.targets.size() != size) {
                    this.targets.poll();
                }
                if (this.targets.size() != size) {
                    throw new IllegalStateException("Given index " + i + " not in sequence");
                }
                start();
            }
        }

        public boolean cancel() {
            if (this.targets.isEmpty() || !this.active || this.currentView == null || !this.currentView.cancelable) {
                return false;
            }
            this.currentView.dismiss(false);
            this.active = false;
            this.targets.clear();
            if (this.listener != null) {
                this.listener.onSequenceCanceled(this.currentView.target);
            }
            return true;
        }

        void showNext() {
            try {
                TapTarget remove = this.targets.remove();
                if (this.activity != null) {
                    this.currentView = TapTargetView.showFor(this.activity, remove, this.tapTargetListener);
                } else {
                    this.currentView = TapTargetView.showFor(this.dialog, remove, this.tapTargetListener);
                }
            } catch (NoSuchElementException e) {
                if (this.listener != null) {
                    this.listener.onSequenceFinish();
                }
            }
        }

        public interface Listener {
            void onSequenceCanceled(TapTarget tapTarget);

            void onSequenceFinish();

            void onSequenceStep(TapTarget tapTarget, boolean z);
        }
    }
}
