package com.updatify.o2nation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.util.Linkify;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.TooltipCompat;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.github.florent37.viewtooltip.ViewTooltip;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hanks.htextview.HTextView;
import com.hanks.htextview.HTextViewType;
import com.wuyr.rippleanimation.RippleAnimation;

import java.io.File;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

public class HomeActivity extends AppCompatActivity {
    public final int REQ_CD_GOOGLEAUTH = 101;
    View _inflate;
    View _inflate2;
    Snackbar.SnackbarLayout _sblayout;
    Snackbar.SnackbarLayout _sblayout2;
    Snackbar _snackBarView;
    Snackbar _snackBarView2;
    ViewPager viewPager;
    private HashMap<String, Object> APIHeaders = new HashMap<>();
    private HashMap<String, Object> APIProjectsMap = new HashMap<>();
    private double MaxSlots = 0.0d;
    private String StatePixel = "";
    private ChildEventListener _DBAds_child_listener;
    private ChildEventListener _DBLogs_child_listener;
    private ChildEventListener _DBManager_child_listener;
    private ChildEventListener _DBPushUsers_child_listener;
    private ChildEventListener _DBUserProjects_child_listener;
    private ChildEventListener _DBUsers_child_listener;
    private OnSuccessListener _SIcons_delete_success_listener;
    private OnProgressListener _SIcons_download_progress_listener;
    private OnSuccessListener<FileDownloadTask.TaskSnapshot> _SIcons_download_success_listener;
    private OnFailureListener _SIcons_failure_listener;
    private OnProgressListener _SIcons_upload_progress_listener;
    private OnCompleteListener<Uri> _SIcons_upload_success_listener;
    private RequestNetwork.RequestListener _checkNetwork_request_listener;
    private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
    private DatabaseReference DBAds = this._firebase.getReference("ADSJEEKCJFJE83IXN");
    private DatabaseReference DBLogs = this._firebase.getReference("LOGSIEUDJFKSI8272827IDJD");
    private DatabaseReference DBManager = this._firebase.getReference("MANAGE2827JEHDKRKE2827");
    private DatabaseReference DBPushUsers = this._firebase.getReference("USERS2827IWUWIEHDN8273");
    private DatabaseReference DBUserProjects = this._firebase.getReference("PATH");
    private DatabaseReference DBUsers = this._firebase.getReference("USERS2827IWUWIEHDN8273");
    private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
    private StorageReference SIcons = this._firebase_storage.getReference("trOz+5fNgLCJG2qJLLtUKw==");
    private OnCompleteListener<AuthResult> _mAuth_create_user_listener;
    private OnCompleteListener<Void> _mAuth_reset_password_listener;
    private OnCompleteListener<AuthResult> _mAuth_sign_in_listener;
    private RequestNetwork.RequestListener _requestProjects_request_listener;
    private Timer _timer = new Timer();
    private ArrayList<HashMap<String, Object>> ads = new ArrayList<>();
    private double adsNum = 0.0d;
    private TimerTask adsTmr;
    private LinearLayout ads_back;
    private ObjectAnimator animation = new ObjectAnimator();
    private ObjectAnimator animation2 = new ObjectAnimator();
    private String appname = "";
    private HashMap<String, Object> authMap = new HashMap<>();
    private double availableSlots = 0.0d;
    private LinearLayout background;
    private LinearLayout badgeview;
    private LinearLayout base;
    private double bytes = 0.0d;
    private Calendar calendar = Calendar.getInstance();
    private RequestNetwork checkNetwork;
    private String clipdata = "";
    private OnCompleteListener cloud_onCompleteListener;
    private String code = "";
    private TimerTask coreTmr;
    private ProgressDialog coreprog;
    private double count = 0.0d;
    private double crab = 0.0d;
    private String decrypted = "";
    private TimerTask delete;
    private String deleteAppIcon = "";
    private String deleteAppKey = "";
    private String deleteAppName = "";
    private String deleteFileName = "";
    private double doubleBackExit = 0.0d;
    private String downloadURL = "";
    private String editingTempKey = "";
    private LinearLayout empty_base;
    private ImageView empty_notifications_img;
    private TextView empty_notifications_sub;
    private TextView empty_notifications_title;
    private LinearLayout empty_view_notifications;
    private ImageView emptyview_img;
    private TextView emptyview_txt1;
    private TextView emptyview_txt2;
    private AdView fbBanner;
    private InterstitialAd fbInterstitial;
    private GoogleSignInClient googleAuth;
    private String iconPath = "";
    private String imageName = "";
    private ImageView imageview1;
    private ImageView imageview3;
    private ImageView imageview4;
    private ImageView imageview5;
    private boolean isAdmobAvailable = false;
    private boolean isEditing = false;
    private boolean isIconPicked = false;
    private boolean isPicked = false;
    private boolean isServerLive = false;
    private LinearLayout layout1;
    private LinearLayout layout2;
    private double len = 0.0d;
    private double length = 0.0d;
    private LinearLayout linear10;
    private LinearLayout linear12;
    private LinearLayout linear13;
    private LinearLayout linear14;
    private LinearLayout linear3;
    private LinearLayout linear4;
    private LinearLayout linear5;
    private LinearLayout linear7;
    private double loadAdsLimit = 0.0d;
    private String logTempKey = "";
    private ImageView logo;
    private TimerTask logoPosition;
    private HashMap<String, Object> logsMap = new HashMap<>();
    private FirebaseAuth mAuth;
    private OnCompleteListener<Void> mAuth_deleteUserListener;
    private OnCompleteListener<Void> mAuth_emailVerificationSentListener;
    private OnCompleteListener<AuthResult> mAuth_googleSignInListener;
    private OnCompleteListener<AuthResult> mAuth_phoneAuthListener;
    private OnCompleteListener<Void> mAuth_updateEmailListener;
    private OnCompleteListener<Void> mAuth_updatePasswordListener;
    private OnCompleteListener<Void> mAuth_updateProfileListener;
    private String maxSlots = "";
    private String membership = "";
    private double n1 = 0.0d;
    private String name = "";
    private String new_version = "";
    private LinearLayout non_live_back;
    private String notificationCenterContent = "";
    private ArrayList<HashMap<String, Object>> notificationsList = new ArrayList<>();
    private double oldLogoPos = 0.0d;
    private HashMap<String, Object> phone = new HashMap<>();
    private ArrayList<HashMap<String, Object>> phones = new ArrayList<>();
    private ProgressBar progressbar1;
    private ArrayList<HashMap<String, Object>> projectsList = new ArrayList<>();
    private HashMap<String, Object> projectsMap = new HashMap<>();
    private String publishKey = "";
    private RecyclerView recyclerview1;
    private RecyclerView recyclerview2;
    private RequestNetwork requestProjects;
    private HashMap<String, Object> responseMap = new HashMap<>();
    private LinearLayout rootview;
    private SharedPreferences sharedPref;
    private TimerTask swipeToRefreshTmr;
    private SwipeRefreshLayout swiperefreshlayout1;
    private String tempAppKey = "";
    private String tempKey = "";
    private TextView textview3;
    private TextView textview4;
    private TextView textview8;
    private TextView textview9;
    private TimerTask timer;
    private TimerTask timerToLoader;
    private Intent toUpdate = new Intent();
    private Intent toauth = new Intent();
    private Intent tobrowser = new Intent();
    private Intent tologin = new Intent();
    private Intent topicker = new Intent();
    private Intent toprofile = new Intent();
    private Intent torate = new Intent();
    private LinearLayout trash;
    private TextView uploading_txt_1;
    private TextView uploading_txt_2;
    private LinearLayout uploading_view;
    private String userId = "";
    private String userImg = "";
    private String userReference = "";
    private String username = "";
    private String version = "";
    private String versionName = "";
    private LinearLayout viewpagerback;
    private LinearLayout viewpagerstuff;
    private TimerTask waitToLoadProjects;
    private TimerTask welcomeAnimation;
    private TimerTask welcomeAnimation2;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.updatify.o2nation.HomeActivity */
    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        HomeActivity.super.onCreate(bundle);
        setContentView(R.layout.home);
        initialize(bundle);
        FirebaseApp.initializeApp(this);
        if (ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") == -1 || ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == -1) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1000);
            return;
        }
        initializeLogic();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        HomeActivity.super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 1000) {
            initializeLogic();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.updatify.o2nation.HomeActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void initialize(Bundle bundle) {
        this.rootview = (LinearLayout) findViewById(R.id.rootview);
        this.background = (LinearLayout) findViewById(R.id.background);
        this.logo = (ImageView) findViewById(R.id.logo);
        this.linear3 = (LinearLayout) findViewById(R.id.linear3);
        this.viewpagerstuff = (LinearLayout) findViewById(R.id.viewpagerstuff);
        this.viewpagerback = (LinearLayout) findViewById(R.id.viewpagerback);
        this.textview8 = (TextView) findViewById(R.id.textview8);
        this.linear10 = (LinearLayout) findViewById(R.id.linear10);
        this.badgeview = (LinearLayout) findViewById(R.id.badgeview);
        this.imageview4 = (ImageView) findViewById(R.id.imageview4);
        this.imageview1 = (ImageView) findViewById(R.id.imageview1);
        this.trash = (LinearLayout) findViewById(R.id.trash);
        this.base = (LinearLayout) findViewById(R.id.base);
        this.layout1 = (LinearLayout) findViewById(R.id.layout1);
        this.layout2 = (LinearLayout) findViewById(R.id.layout2);
        this.non_live_back = (LinearLayout) findViewById(R.id.non_live_back);
        this.linear4 = (LinearLayout) findViewById(R.id.linear4);
        this.uploading_view = (LinearLayout) findViewById(R.id.uploading_view);
        this.linear14 = (LinearLayout) findViewById(R.id.linear14);
        this.ads_back = (LinearLayout) findViewById(R.id.ads_back);
        this.imageview5 = (ImageView) findViewById(R.id.imageview5);
        this.textview9 = (TextView) findViewById(R.id.textview9);
        this.linear5 = (LinearLayout) findViewById(R.id.linear5);
        this.linear7 = (LinearLayout) findViewById(R.id.linear7);
        this.imageview3 = (ImageView) findViewById(R.id.imageview3);
        this.textview3 = (TextView) findViewById(R.id.textview3);
        this.textview4 = (TextView) findViewById(R.id.textview4);
        this.linear12 = (LinearLayout) findViewById(R.id.linear12);
        this.linear13 = (LinearLayout) findViewById(R.id.linear13);
        this.progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
        this.uploading_txt_1 = (TextView) findViewById(R.id.uploading_txt_1);
        this.uploading_txt_2 = (TextView) findViewById(R.id.uploading_txt_2);
        this.empty_base = (LinearLayout) findViewById(R.id.empty_base);
        this.recyclerview1 = findViewById(R.id.recyclerview1);
        this.emptyview_img = (ImageView) findViewById(R.id.emptyview_img);
        this.emptyview_txt1 = (TextView) findViewById(R.id.emptyview_txt1);
        this.emptyview_txt2 = (TextView) findViewById(R.id.emptyview_txt2);
        this.empty_view_notifications = (LinearLayout) findViewById(R.id.empty_view_notifications);
        this.swiperefreshlayout1 = findViewById(R.id.swiperefreshlayout1);
        this.empty_notifications_img = (ImageView) findViewById(R.id.empty_notifications_img);
        this.empty_notifications_title = (TextView) findViewById(R.id.empty_notifications_title);
        this.empty_notifications_sub = (TextView) findViewById(R.id.empty_notifications_sub);
        this.recyclerview2 = findViewById(R.id.recyclerview2);
        this.requestProjects = new RequestNetwork(this);
        this.sharedPref = getSharedPreferences("sharedPref", 0);
        this.mAuth = FirebaseAuth.getInstance();
        this.checkNetwork = new RequestNetwork(this);
        this.imageview4.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.HomeActivity.1 */

            public void onClick(View view) {
                if (HomeActivity.this.viewPager.getCurrentItem() == 0) {
                    HomeActivity.this.sharedPref.edit().putString("notificationCenterContent", HomeActivity.this.notificationCenterContent).commit();
                    HomeActivity.this.badgeview.setVisibility(View.GONE);
                    HomeActivity.this.viewPager.setCurrentItem(1);
                } else if (HomeActivity.this.viewPager.getCurrentItem() == 1) {
                    HomeActivity.this.viewPager.setCurrentItem(0);
                }
            }
        });
        this.imageview1.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.HomeActivity.2 */

            /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, com.updatify.o2nation.HomeActivity] */
            /* JADX WARNING: Unknown variable types count: 1 */
            public void onClick(View view) {
                HomeActivity.this._GetAppVersionInfo();
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog((Context) HomeActivity.this, R.style.sheet_style);
                View inflate = HomeActivity.this.getLayoutInflater().inflate(R.layout.menu_sheet, (ViewGroup) null);
                bottomSheetDialog.setContentView(inflate);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.background);
                LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.line);
                LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(R.id.scroller);
                LinearLayout linearLayout4 = (LinearLayout) inflate.findViewById(R.id.linear7);
                LinearLayout linearLayout5 = (LinearLayout) inflate.findViewById(R.id.linear8);
                LinearLayout linearLayout6 = (LinearLayout) inflate.findViewById(R.id.linear9);
                LinearLayout linearLayout7 = (LinearLayout) inflate.findViewById(R.id.linear10);
                TextView textView = (TextView) inflate.findViewById(R.id.title);
                TextView textView2 = (TextView) inflate.findViewById(R.id.item4);
                TextView textView3 = (TextView) inflate.findViewById(R.id.textview1);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.item11);
                ImageView imageView2 = (ImageView) inflate.findViewById(R.id.imageview1);
                ImageView imageView3 = (ImageView) inflate.findViewById(R.id.item44);
                ImageView imageView4 = (ImageView) inflate.findViewById(R.id.item33);
                ImageView imageView5 = (ImageView) inflate.findViewById(R.id.item22);
                TextView textView4 = (TextView) inflate.findViewById(R.id.description);
                TextView textView5 = (TextView) inflate.findViewById(R.id.item3);
                TextView textView6 = (TextView) inflate.findViewById(R.id.item1);
                TextView textView7 = (TextView) inflate.findViewById(R.id.button);
                TextView textView8 = (TextView) inflate.findViewById(R.id.item2);
                textView.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
                textView4.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
                textView7.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
                textView6.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
                textView8.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
                textView2.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
                textView5.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
                textView3.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
                textView3.setText("Version: ".concat(HomeActivity.this.versionName));
                textView.setText(HomeActivity.this.username);
                if (HomeActivity.this.membership.equals("")) {
                    textView4.setText("Loading...");
                } else {
                    textView4.setText(HomeActivity.this.membership);
                }
                HomeActivity.this._ICC(imageView5, "#DF2029", "#ccDF2029");
                HomeActivity.this._ICC(imageView, "#0084FF", "#CC0084FF");
                HomeActivity.this._ICC(imageView4, "#09B83E", "#cc09B83E");
                HomeActivity.this._ICC(imageView3, "#F57D00", "#ccF57D00");
                HomeActivity.this._RoundAndBorder(linearLayout3, "#CCFFFFFF", 0.0d, "#FFFFFF", 100.0d);
                if (HomeActivity.this.sharedPref.getString("autodark", "").equals("") || HomeActivity.this.sharedPref.getString("autodark", "").equals("true")) {
                    linearLayout4.setVisibility(View.GONE);
                }
                if (HomeActivity.this.sharedPref.getString("dark", "").equals("true")) {
                    textView6.setText("Light mode");
                    imageView.setImageResource(R.drawable.twotone_wb_sunny_black_48dp);
                    textView.setTextColor(-1);
                    textView6.setTextColor(-1);
                    textView2.setTextColor(-1);
                    textView5.setTextColor(-1);
                    textView8.setTextColor(-1);
                    linearLayout2.setBackgroundColor(-12434878);
                    textView7.setTextColor(-1118482);
                    HomeActivity.this._advancedCorners(linearLayout, "#181818", 25.0d, 25.0d, 25.0d, 25.0d);
                    HomeActivity.this._rippleRoundStroke(textView7, "#181818", "#E0E0E0", 100.0d, 2.0d, "#424242");
                    HomeActivity.this._rippleRoundStroke(linearLayout4, "#181818", "#212121", 0.0d, 0.0d, "#E0E0E0");
                    HomeActivity.this._rippleRoundStroke(linearLayout5, "#181818", "#212121", 0.0d, 0.0d, "#E0E0E0");
                    HomeActivity.this._rippleRoundStroke(linearLayout6, "#181818", "#212121", 0.0d, 0.0d, "#E0E0E0");
                    HomeActivity.this._rippleRoundStroke(linearLayout7, "#181818", "#212121", 0.0d, 0.0d, "#E0E0E0");
                } else {
                    HomeActivity.this._advancedCorners(linearLayout, "#FFFFFF", 25.0d, 25.0d, 25.0d, 25.0d);
                    HomeActivity.this._rippleRoundStroke(textView7, "#FFFFFF", "#F5F5F5", 100.0d, 2.0d, "#E0E0E0");
                    HomeActivity.this._rippleRoundStroke(linearLayout4, "#FFFFFF", "#F5F5F5", 0.0d, 0.0d, "#E0E0E0");
                    HomeActivity.this._rippleRoundStroke(linearLayout5, "#FFFFFF", "#F5F5F5", 0.0d, 0.0d, "#E0E0E0");
                    HomeActivity.this._rippleRoundStroke(linearLayout6, "#FFFFFF", "#F5F5F5", 0.0d, 0.0d, "#E0E0E0");
                    HomeActivity.this._rippleRoundStroke(linearLayout7, "#FFFFFF", "#F5F5F5", 0.0d, 0.0d, "#E0E0E0");
                }
                if (!HomeActivity.this.userImg.equals("null")) {
                    HomeActivity.this._setCircleImageURL(imageView2, HomeActivity.this.userImg, 0.0d, "#00000000");
                }
                linearLayout4.setOnClickListener(new View.OnClickListener() {
                    /* class com.updatify.o2nation.HomeActivity.2.1 */

                    public void onClick(View view) {
                        if (HomeActivity.this.sharedPref.getString("autodark", "").equals("") || HomeActivity.this.sharedPref.getString("autodark", "").equals("true")) {
                            SketchwareUtil.showMessage(HomeActivity.this.getApplicationContext(), "Auto detection enabled, check Updatify settings");
                            return;
                        }
                        if (HomeActivity.this.sharedPref.getString("dark", "").equals("")) {
                            HomeActivity.this.sharedPref.edit().putString("dark", "true").commit();
                        } else if (HomeActivity.this.sharedPref.getString("dark", "").equals("true")) {
                            HomeActivity.this.sharedPref.edit().putString("dark", "false").commit();
                        } else if (HomeActivity.this.sharedPref.getString("dark", "").equals("false")) {
                            HomeActivity.this.sharedPref.edit().putString("dark", "true").commit();
                        }
                        HomeActivity.this.recreate();
                        bottomSheetDialog.dismiss();
                    }
                });
                linearLayout5.setOnClickListener(new View.OnClickListener() {
                    /* class com.updatify.o2nation.HomeActivity.2.2 */

                    public void onClick(View view) {
                        HomeActivity.this._signOutGoogleAuth();
                        bottomSheetDialog.dismiss();
                    }
                });
                linearLayout6.setOnClickListener(new View.OnClickListener() {
                    /* class com.updatify.o2nation.HomeActivity.2.3 */

                    public void onClick(View view) {
                        HomeActivity.this.tobrowser.setAction("android.intent.action.VIEW");
                        HomeActivity.this.tobrowser.setData(Uri.parse("https://youtu.be/xPgmiLhTm_o"));
                        HomeActivity.this.startActivity(HomeActivity.this.tobrowser);
                        bottomSheetDialog.dismiss();
                    }
                });
                textView7.setOnClickListener(new View.OnClickListener() {
                    /* class com.updatify.o2nation.HomeActivity.2.4 */

                    public void onClick(View view) {
                        HomeActivity.this.toprofile.setClass(HomeActivity.this.getApplicationContext(), ProfileActivity.class);
                        HomeActivity.this.toprofile.putExtra("isWantToBuy", "false");
                        HomeActivity.this.startActivity(HomeActivity.this.toprofile);
                        bottomSheetDialog.dismiss();
                    }
                });
                linearLayout7.setOnClickListener(new View.OnClickListener() {
                    /* class com.updatify.o2nation.HomeActivity.2.5 */

                    public void onClick(View view) {
                        HomeActivity.this.torate.setAction("android.intent.action.VIEW");
                        HomeActivity.this.torate.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.updatify.o2nation"));
                        HomeActivity.this.startActivity(HomeActivity.this.torate);
                        bottomSheetDialog.dismiss();
                    }
                });
                bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(17170445);
                bottomSheetDialog.show();
            }
        });
        this.non_live_back.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.HomeActivity.3 */

            /* JADX WARN: Type inference failed for: r0v0, types: [android.content.Context, com.updatify.o2nation.HomeActivity] */
            /* JADX WARNING: Unknown variable types count: 1 */
            public void onClick(View view) {
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog((Context) HomeActivity.this);
                View inflate = HomeActivity.this.getLayoutInflater().inflate(R.layout.info_sheet, (ViewGroup) null);
                bottomSheetDialog.setContentView(inflate);
                bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(17170445);
                TextView textView = (TextView) inflate.findViewById(R.id.infosheet_ok);
                TextView textView2 = (TextView) inflate.findViewById(R.id.infosheet_cancel);
                TextView textView3 = (TextView) inflate.findViewById(R.id.infosheet_title);
                TextView textView4 = (TextView) inflate.findViewById(R.id.infosheet_sub);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.infosheet_back);
                LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.infosheet_btn_holder);
                textView3.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
                textView4.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
                textView.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
                textView2.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
                ((ImageView) inflate.findViewById(R.id.infosheet_img)).setImageResource(R.drawable.astronaut);
                textView.setText("Okay");
                textView3.setText("What is meant with this?");
                textView4.setText("Non live data means that our servers are temporarily unavailable, but you still have the access to send notifications to your apps. However, you can't create, delete or modify projects during the down time.");
                HomeActivity.this._rippleRoundStroke(textView, "#006DF6", "#16FFFFFF", 25.0d, 0.0d, "#006DF6");
                if (HomeActivity.this.sharedPref.getString("dark", "").equals("true")) {
                    textView2.setTextColor(-1);
                    HomeActivity.this._setViewRadius(linearLayout, 25.0d, "#181818");
                } else {
                    HomeActivity.this._setViewRadius(linearLayout, 25.0d, "#FFFFFF");
                }
                textView2.setVisibility(View.GONE);
                textView.setOnClickListener(new View.OnClickListener() {
                    /* class com.updatify.o2nation.HomeActivity.3.1 */

                    public void onClick(View view) {
                        bottomSheetDialog.dismiss();
                    }
                });
                bottomSheetDialog.show();
            }
        });
        this.linear4.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.HomeActivity.4 */

            /* JADX WARN: Type inference failed for: r4v26, types: [android.content.Context, com.updatify.o2nation.HomeActivity] */
            /* JADX WARN: Type inference failed for: r4v32, types: [android.content.Context, com.updatify.o2nation.HomeActivity] */
            /* JADX WARN: Type inference failed for: r4v40, types: [android.content.Context, com.updatify.o2nation.HomeActivity] */
            /* JADX WARNING: Unknown variable types count: 3 */
            public void onClick(View view) {
                if (HomeActivity.this.emptyview_txt1.getText().toString().toLowerCase().contains("just") && HomeActivity.this.empty_base.getVisibility() == View.VISIBLE) {
                    HomeActivity.this._Snackbar_API("Projects are loading, please wait...", "", "");
                } else if (HomeActivity.this.uploading_view.getVisibility() == View.GONE) {
                    HomeActivity.this._Snackbar_API("Another thread is going, please wait until it finishes", "", "");
                } else if (!HomeActivity.this.isServerLive) {
                    HomeActivity.this._Snackbar_API("You can't create new projects when our list server is down", "", "");
                } else if (FirebaseAuth.getInstance().getCurrentUser() == null) {
                    HomeActivity.this.tologin.setClass(HomeActivity.this.getApplicationContext(), Auth2Activity.class);
                    HomeActivity.this.startActivity(HomeActivity.this.tologin);
                    HomeActivity.this.finish();
                } else if (HomeActivity.this.availableSlots == HomeActivity.this.MaxSlots) {
                    HomeActivity.this._onClickSnackBar("You've reached max available slots.", "GET MORE SLOTS");
                } else {
                    HomeActivity.this.sharedPref.edit().putString("picked_path", "null").commit();
                    HomeActivity.this.isIconPicked = false;
                    final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog((Context) HomeActivity.this, R.style.sheet_style);
                    View inflate = HomeActivity.this.getLayoutInflater().inflate(R.layout.creat_sheet, (ViewGroup) null);
                    bottomSheetDialog.setContentView(inflate);
                    ScrollView scrollView = (ScrollView) inflate.findViewById(R.id.vscroll1);
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.background);
                    LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.linear14);
                    LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(R.id.line);
                    LinearLayout linearLayout4 = (LinearLayout) inflate.findViewById(R.id.line2);
                    LinearLayout linearLayout5 = (LinearLayout) inflate.findViewById(R.id.scroller);
                    LinearLayout linearLayout6 = (LinearLayout) inflate.findViewById(R.id.linear6);
                    final EditText editText = (EditText) inflate.findViewById(R.id.edittext1);
                    TextView textView = (TextView) inflate.findViewById(R.id.done_btn);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.title2);
                    TextView textView3 = (TextView) inflate.findViewById(R.id.textview5);
                    TextView textView4 = (TextView) inflate.findViewById(R.id.textview2);
                    TextView textView5 = (TextView) inflate.findViewById(R.id.textview3);
                    TextView textView6 = (TextView) inflate.findViewById(R.id.close_btn);
                    final ImageView imageView = (ImageView) inflate.findViewById(R.id.img1);
                    final ImageView imageView2 = (ImageView) inflate.findViewById(R.id.imageview1);
                    LinearLayout linearLayout7 = (LinearLayout) inflate.findViewById(R.id.linear_np_vc_1);
                    LinearLayout linearLayout8 = (LinearLayout) inflate.findViewById(R.id.linear_np_vc_2);
                    OverScrollDecoratorHelper.setUpOverScroll(scrollView);
                    scrollView.setVerticalScrollBarEnabled(false);
                    final NumberPicker numberPicker = new NumberPicker(HomeActivity.this);
                    numberPicker.setMaxValue(50);
                    numberPicker.setMinValue(0);
                    numberPicker.setWrapSelectorWheel(true);
                    numberPicker.setValue(1);
                    HomeActivity.this.sharedPref.getString("dark", "").equals("true");
                    linearLayout7.addView(numberPicker);
                    final NumberPicker numberPicker2 = new NumberPicker(HomeActivity.this);
                    numberPicker2.setMaxValue(50);
                    numberPicker2.setMinValue(0);
                    numberPicker2.setWrapSelectorWheel(true);
                    numberPicker2.setValue(0);
                    HomeActivity.this.sharedPref.getString("dark", "").equals("true");
                    linearLayout8.addView(numberPicker2);
                    int i = Build.VERSION.SDK_INT;
                    HomeActivity.this._advancedCorners(linearLayout7, "#FFFFFF", 25.0d, 0.0d, 25.0d, 0.0d);
                    HomeActivity.this._advancedCorners(linearLayout8, "#FFFFFF", 0.0d, 25.0d, 0.0d, 25.0d);
                    textView2.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
                    textView.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
                    textView6.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
                    editText.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
                    textView4.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
                    textView5.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
                    textView3.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
                    HomeActivity.this._setInputLimit(editText, 30.0d);
                    HomeActivity.this._ICC(imageView, "#9E9E9E", "#CC9e9e9e");
                    HomeActivity.this._RoundAndBorder(linearLayout5, "#CCFFFFFF", 0.0d, "#FFFFFF", 100.0d);
                    HomeActivity.this._rippleRoundStroke(textView, "#006DF6", "#16FFFFFF", 25.0d, 0.0d, "#006DF6");
                    if (HomeActivity.this.sharedPref.getString("dark", "").equals("true")) {
                        HomeActivity.this._advancedCorners(linearLayout, "#181818", 25.0d, 25.0d, 25.0d, 25.0d);
                        HomeActivity.this._rippleRoundStroke(textView3, "#181818", "#E0E0E0", 100.0d, 2.0d, "#424242");
                        textView2.setTextColor(-1);
                        editText.setTextColor(-1);
                        textView4.setTextColor(-1);
                        HomeActivity.this._rippleRoundStroke(textView6, "#424242", "#E0E0E0", 25.0d, 0.0d, "#006DF6");
                        linearLayout3.setBackgroundColor(-12434878);
                        linearLayout4.setBackgroundColor(-12434878);
                        textView3.setTextColor(-1);
                        textView6.setTextColor(-1);
                    } else {
                        HomeActivity.this._rippleRoundStroke(textView3, "#FFFFFF", "#E0E0E0", 100.0d, 2.0d, "#E0E0E0");
                        HomeActivity.this._advancedCorners(linearLayout, "#ffffff", 25.0d, 25.0d, 25.0d, 25.0d);
                        HomeActivity.this._rippleRoundStroke(textView6, "#F5F5F5", "#E0E0E0", 25.0d, 0.0d, "#006DF6");
                    }
                    editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        /* class com.updatify.o2nation.HomeActivity.4.1 */

                        public void onFocusChange(View view, boolean z) {
                            if (z) {
                                HomeActivity.this._ICC(imageView, "#FF007EED", "#FF007EED");
                            } else if (editText.getText().toString().equals("")) {
                                HomeActivity.this._ICC(imageView, "#9E9E9E", "#CC9e9e9e");
                            }
                        }
                    });
                    editText.setFocusableInTouchMode(true);
                    editText.addTextChangedListener(new TextWatcher() {
                        /* class com.updatify.o2nation.HomeActivity.4.2 */

                        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                            charSequence.toString();
                        }

                        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        }

                        public void afterTextChanged(Editable editable) {
                        }
                    });
                    textView.setOnClickListener(new View.OnClickListener() {
                        /* class com.updatify.o2nation.HomeActivity.4.3 */

                        public void onClick(View view) {
                            if (editText.getText().toString().trim().equals("")) {
                                SketchwareUtil.showMessage(HomeActivity.this.getApplicationContext(), "App name required");
                            } else if (HomeActivity.this.publishKey.equals("null")) {
                                SketchwareUtil.showMessage(HomeActivity.this.getApplicationContext(), "App could not be added due to an unexpected issue.");
                            } else if (HomeActivity.this.isIconPicked) {
                                HomeActivity.this._transitionViewTime(HomeActivity.this.background, 150.0d);
                                HomeActivity.this.uploading_txt_1.setText("Connecting to Updatify...");
                                HomeActivity.this.uploading_txt_2.setText(editText.getText().toString().trim().concat(" is being added..."));
                                HomeActivity.this.uploading_view.setVisibility(View.VISIBLE);
                                HomeActivity.this.version = String.valueOf((long) numberPicker.getValue()).concat(".".concat(String.valueOf((long) numberPicker2.getValue())));
                                HomeActivity.this.appname = editText.getText().toString().replace(" ", "");
                                HomeActivity.this.SIcons.child(HomeActivity.this.imageName).putFile(Uri.fromFile(new File(HomeActivity.this.iconPath))).addOnFailureListener(HomeActivity.this._SIcons_failure_listener).addOnProgressListener(HomeActivity.this._SIcons_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                                    /* class com.updatify.o2nation.HomeActivity.4.3.1 */

                                    public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
                                        return HomeActivity.this.SIcons.child(HomeActivity.this.imageName).getDownloadUrl();
                                    }
                                }).addOnCompleteListener(HomeActivity.this._SIcons_upload_success_listener);
                                HomeActivity.this.recyclerview1.setEnabled(false);
                                bottomSheetDialog.dismiss();
                            } else {
                                HomeActivity.this._transitionViewTime(HomeActivity.this.background, 150.0d);
                                HomeActivity.this.uploading_txt_1.setText("Connecting to Updatify...");
                                HomeActivity.this.uploading_txt_2.setText(editText.getText().toString().trim().concat(" is being added..."));
                                HomeActivity.this.uploading_view.setVisibility(View.VISIBLE);
                                HomeActivity.this.calendar = Calendar.getInstance();
                                HomeActivity.this.name = editText.getText().toString().replace(" ", "");
                                HomeActivity.this.tempAppKey = editText.getText().toString().replace(" ", "").trim().concat("_".concat(String.valueOf((long) SketchwareUtil.getRandom(0, 999999999)).concat("_".concat(FirebaseAuth.getInstance().getCurrentUser().getUid()))));
                                HomeActivity.this.APIProjectsMap = new HashMap();
                                HomeActivity.this.APIProjectsMap.put("appname", editText.getText().toString().replace(" ", "").trim());
                                HomeActivity.this.APIProjectsMap.put("currVersion", String.valueOf((long) numberPicker.getValue()).concat(".".concat(String.valueOf((long) numberPicker2.getValue()))));
                                HomeActivity.this.APIProjectsMap.put("newVersion", String.valueOf((long) numberPicker.getValue()).concat(".".concat(String.valueOf((long) numberPicker2.getValue()))));
                                HomeActivity.this.APIProjectsMap.put("developer", HomeActivity.this.username);
                                HomeActivity.this.APIProjectsMap.put("email", FirebaseAuth.getInstance().getCurrentUser().getEmail());
                                HomeActivity.this.APIProjectsMap.put("openLinkMain", "https://play.google.com/store/apps/details?id=com.updatify.o2nation");
                                HomeActivity.this.APIProjectsMap.put("isCancelable", "true");
                                HomeActivity.this.APIProjectsMap.put("dialogOption", "message");
                                HomeActivity.this.APIProjectsMap.put("dialogTitle", "Updatify is connected");
                                HomeActivity.this.APIProjectsMap.put("dialogSubtitle", "Your UpdatifyComponent integration is working. Good job.");
                                HomeActivity.this.APIProjectsMap.put("dialogBtnMainTxt", "Give us 5 stars");
                                HomeActivity.this.APIProjectsMap.put("dialogBtnExtraTxt", "Cancel");
                                HomeActivity.this.APIProjectsMap.put("dialogBtnMainClick", "browser");
                                HomeActivity.this.APIProjectsMap.put("dialogBtnExtraClick", "dismiss");
                                HomeActivity.this.APIProjectsMap.put("dialogBtnMain", "true");
                                HomeActivity.this.APIProjectsMap.put("dialogBtnExtra", "true");
                                HomeActivity.this.APIProjectsMap.put("isOneTime", "false");
                                HomeActivity.this.APIProjectsMap.put("isOneTimeKey", "null");
                                HomeActivity.this.APIProjectsMap.put("customDialogRound", "null");
                                HomeActivity.this.APIProjectsMap.put("customDialogBack", "null");
                                HomeActivity.this.APIProjectsMap.put("customDialogAccent", "null");
                                HomeActivity.this.APIProjectsMap.put("customDialogMainTxtColor", "null");
                                HomeActivity.this.APIProjectsMap.put("customDialogBtnTxtColor", "null");
                                HomeActivity.this.APIProjectsMap.put("customDialogIcon", "null");
                                HomeActivity.this.APIProjectsMap.put("alertOption", "dialog");
                                HomeActivity.this.APIHeaders.put("key", HomeActivity.this.publishKey);
                                HomeActivity.this.APIHeaders.put("filename", HomeActivity.this.tempAppKey);
                                HomeActivity.this.APIHeaders.put("content", new Gson().toJson(HomeActivity.this.APIProjectsMap));
                                HomeActivity.this.requestProjects.setParams(HomeActivity.this.APIHeaders, 0);
                                HomeActivity.this.requestProjects.startRequestNetwork(RequestNetworkController.POST, "https://nerbly.com/updatify/apiv1/?do=create", "", HomeActivity.this._requestProjects_request_listener);
                                HomeActivity.this.APIProjectsMap.clear();
                                HomeActivity.this.APIHeaders.clear();
                                HomeActivity.this.tempKey = HomeActivity.this.DBUserProjects.push().getKey();
                                HomeActivity.this.logsMap = new HashMap();
                                HomeActivity.this.logsMap.put("appname", editText.getText().toString().trim());
                                HomeActivity.this.logsMap.put("status", "App registered on: ".concat(new SimpleDateFormat("dd/MM/yyyy 'at' h:mm a").format(HomeActivity.this.calendar.getTime())));
                                HomeActivity.this.logsMap.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
                                HomeActivity.this.logsMap.put("color", "#0070EE");
                                HomeActivity.this.DBLogs.push().updateChildren(HomeActivity.this.logsMap);
                                HomeActivity.this.logsMap.clear();
                                HomeActivity.this.projectsMap = new HashMap();
                                HomeActivity.this.projectsMap.put("appname", editText.getText().toString().trim());
                                HomeActivity.this.projectsMap.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
                                HomeActivity.this.projectsMap.put("email", FirebaseAuth.getInstance().getCurrentUser().getEmail());
                                HomeActivity.this.projectsMap.put("appicon", "https://nerbly.com/updatify/media/icon.jpg");
                                HomeActivity.this.projectsMap.put("currVersion", String.valueOf((long) numberPicker.getValue()).concat(".".concat(String.valueOf((long) numberPicker2.getValue()))));
                                HomeActivity.this.projectsMap.put("status", "App connected");
                                HomeActivity.this.projectsMap.put("color", "#0084FF");
                                HomeActivity.this.projectsMap.put("key", HomeActivity.this.tempKey);
                                HomeActivity.this.projectsMap.put("api", "https://nerbly.com/updatify/apiv1/files/".concat(HomeActivity.this.tempAppKey.concat(".json")));
                                HomeActivity.this.projectsMap.put("filename", HomeActivity.this.tempAppKey);
                                HomeActivity.this.DBUserProjects.child(HomeActivity.this.tempKey).updateChildren(HomeActivity.this.projectsMap);
                                HomeActivity.this.projectsMap.clear();
                                HomeActivity.this.recyclerview1.setEnabled(false);
                                bottomSheetDialog.dismiss();
                                HomeActivity.this.downloadURL = "null";
                            }
                        }
                    });
                    textView6.setOnClickListener(new View.OnClickListener() {
                        /* class com.updatify.o2nation.HomeActivity.4.4 */

                        public void onClick(View view) {
                            bottomSheetDialog.dismiss();
                        }
                    });
                    linearLayout2.setOnClickListener(new View.OnClickListener() {
                        /* class com.updatify.o2nation.HomeActivity.4.5 */

                        /* JADX WARN: Type inference failed for: r0v1, types: [android.content.Context, com.updatify.o2nation.HomeActivity] */
                        /* JADX WARN: Type inference failed for: r0v4, types: [android.app.Activity, com.updatify.o2nation.HomeActivity] */
                        /* JADX WARN: Type inference failed for: r0v6, types: [android.content.Context, com.updatify.o2nation.HomeActivity] */
                        /* JADX WARNING: Unknown variable types count: 3 */
                        public void onClick(View view) {
                            if (ContextCompat.checkSelfPermission((Context) HomeActivity.this, "android.permission.READ_EXTERNAL_STORAGE") == -1 || ContextCompat.checkSelfPermission((Context) HomeActivity.this, "android.permission.WRITE_EXTERNAL_STORAGE") == -1) {
                                ActivityCompat.requestPermissions((Activity) HomeActivity.this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1001);
                                return;
                            }
                            HomeActivity homeActivity = HomeActivity.this;
                            final ImageView imageView = imageView2;
                            homeActivity.timer = new TimerTask() {
                                /* class com.updatify.o2nation.HomeActivity.4.5.1 */

                                public void run() {
                                    HomeActivity homeActivity = HomeActivity.this;
                                    homeActivity.runOnUiThread(new Runnable() {
                                        /* class com.updatify.o2nation.HomeActivity.4.5.1.1 */

                                        public void run() {
                                            if (!HomeActivity.this.sharedPref.getString("picked_path", "").equals("") && !HomeActivity.this.sharedPref.getString("picked_path", "").equals("null")) {
                                                try {
                                                    HomeActivity.this._setImageFromFile(imageView, HomeActivity.this.sharedPref.getString("picked_path", ""));
                                                    HomeActivity.this.iconPath = HomeActivity.this.sharedPref.getString("picked_path", "");
                                                    HomeActivity.this.isIconPicked = true;
                                                    HomeActivity.this.imageName = FirebaseAuth.getInstance().getCurrentUser().getUid().concat(String.valueOf((long) SketchwareUtil.getRandom(0, 99999)));
                                                    HomeActivity.this.sharedPref.edit().putString("picked_path", "null").commit();
                                                } catch (Exception ignored) {
                                                }
                                                HomeActivity.this.timer.cancel();
                                            }
                                        }
                                    });
                                }
                            };
                            HomeActivity.this._timer.scheduleAtFixedRate(HomeActivity.this.timer, 0, 300);
                            HomeActivity.this.topicker.setClass(HomeActivity.this.getApplicationContext(), PickerActivity.class);
                            HomeActivity.this.topicker.putExtra("extension", ".png, .apng, .gif, .jpeg, .jpg");
                            HomeActivity.this.startActivity(HomeActivity.this.topicker);
                        }
                    });
                    bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(17170445);
                    bottomSheetDialog.show();
                }
            }
        });
        this.uploading_view.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.HomeActivity.5 */

            public void onClick(View view) {
            }
        });
        this._DBUsers_child_listener = new ChildEventListener() {
            /* class com.updatify.o2nation.HomeActivity.6 */

            public void onChildAdded(DataSnapshot dataSnapshot, String str) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.HomeActivity.6.1 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
            }

            public void onChildChanged(DataSnapshot dataSnapshot, String str) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.HomeActivity.6.2 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
            }

            public void onChildMoved(DataSnapshot dataSnapshot, String str) {
            }

            public void onChildRemoved(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.HomeActivity.6.3 */
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
            /* class com.updatify.o2nation.HomeActivity.7 */

            /* JADX WARN: Type inference failed for: r2v10, types: [android.content.Context, com.updatify.o2nation.HomeActivity] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.updatify.o2nation.RequestNetwork.RequestListener
            public void onResponse(String str, String str2, HashMap<String, Object> hashMap) {
                if (!str.equals("delete")) {
                    if (str2.toLowerCase().contains("not allowed")) {
                        HomeActivity.this._Snackbar_API("App could not be added due to an unexpected issue. [not allowed]", "", "long");
                    } else if (str2.toLowerCase().equals("{\"status\":true,\"errors\":[]}")) {
                        HomeActivity.this._Snackbar_API("App added successfully", "", "long");
                        HomeActivity.this.authMap.put("slots", String.valueOf((long) (HomeActivity.this.availableSlots + 1.0d)));
                        HomeActivity.this.DBPushUsers.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(HomeActivity.this.authMap);
                        HomeActivity.this.authMap.clear();
                        HomeActivity.this.fbInterstitial.show();
                        HomeActivity.this.fbInterstitial = new InterstitialAd((Context) HomeActivity.this, "278142536768563_320780439171439");
                        HomeActivity.this.fbInterstitial.loadAd();
                        HomeActivity.this.calendar = Calendar.getInstance();
                        HomeActivity.this.logTempKey = HomeActivity.this.DBPushUsers.push().getKey();
                        HomeActivity.this.logsMap = new HashMap();
                        HomeActivity.this.logsMap.put("appname", HomeActivity.this.name);
                        HomeActivity.this.logsMap.put("status", "Registered on: ".concat(new SimpleDateFormat("dd/MM/yyyy 'at' h:mm a").format(HomeActivity.this.calendar.getTime())));
                        HomeActivity.this.logsMap.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
                        HomeActivity.this.logsMap.put("color", "#0084FF");
                        HomeActivity.this.DBPushUsers.child(FirebaseAuth.getInstance().getCurrentUser().getUid().concat("/LOGS/".concat(HomeActivity.this.logTempKey))).updateChildren(HomeActivity.this.logsMap);
                        HomeActivity.this.logsMap.clear();
                    } else {
                        HomeActivity.this._Snackbar_API("App could not be updated due to an unexpected issue. ".concat("[".concat(str2).concat("]")), "", "long");
                    }
                    HomeActivity.this._updatifyCore(false, "#FFFFFF", 90.0d, "#FFFFFF", 0.0d);
                    HomeActivity.this.waitToLoadProjects = new TimerTask() {
                        /* class com.updatify.o2nation.HomeActivity.7.1 */

                        public void run() {
                            HomeActivity.this.runOnUiThread(new Runnable() {
                                /* class com.updatify.o2nation.HomeActivity.7.1.1 */

                                public void run() {
                                    HomeActivity.this._transitionViewTime(HomeActivity.this.background, 150.0d);
                                    HomeActivity.this.uploading_view.setVisibility(View.GONE);
                                    HomeActivity.this.recyclerview1.setEnabled(true);
                                }
                            });
                        }
                    };
                    HomeActivity.this._timer.schedule(HomeActivity.this.waitToLoadProjects, 1000);
                }
            }

            @Override // com.updatify.o2nation.RequestNetwork.RequestListener
            public void onErrorResponse(String str, String str2) {
                HomeActivity.this._updatifyCore(false, "#FFFFFF", 90.0d, "#FFFFFF", 0.0d);
                HomeActivity.this._Snackbar_API("Something went wrong, check your internet connection", "", "short");
                HomeActivity.this._transitionViewTime(HomeActivity.this.background, 150.0d);
                HomeActivity.this.uploading_view.setVisibility(View.GONE);
                HomeActivity.this.recyclerview1.setEnabled(true);
            }
        };
        this._DBManager_child_listener = new ChildEventListener() {
            /* class com.updatify.o2nation.HomeActivity.8 */

            public void onChildAdded(DataSnapshot dataSnapshot, String str) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.HomeActivity.8.1 */
                };
                String key = dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
                if (key.equals(new Object() {
                    /* class com.updatify.o2nation.HomeActivity.8.2 */
                    int t;

                    public String toString() {
                        this.t = 1100752262;
                        this.t = -1915229575;
                        this.t = 374746237;
                        this.t = -1041650;
                        this.t = 904089400;
                        this.t = -797935898;
                        this.t = 522352264;
                        return new String(new byte[]{(byte) (this.t >>> 14), (byte) (this.t >>> 18), (byte) (this.t >>> 12), (byte) (this.t >>> 6), (byte) (this.t >>> 11), (byte) (this.t >>> 1), (byte) (this.t >>> 4)});
                    }
                }.toString())) {
                    HomeActivity.this._decryptString(hashMap.get("publishKey").toString(), new Object() {
                        /* class com.updatify.o2nation.HomeActivity.8.3 */
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
                if (!key.equals("server")) {
                    return;
                }
                if (hashMap.get("list_status").toString().equals("offline")) {
                    HomeActivity.this.isServerLive = false;
                    HomeActivity.this._transitionViewTime(HomeActivity.this.rootview, 200.0d);
                    HomeActivity.this.non_live_back.setVisibility(View.VISIBLE);
                    if (FirebaseAuth.getInstance().getCurrentUser().getUid().concat("_userProjects").equals("")) {
                        HomeActivity.this.empty_base.setVisibility(View.VISIBLE);
                        HomeActivity.this.recyclerview1.setVisibility(View.GONE);
                        HomeActivity.this.emptyview_img.setImageResource(R.drawable.dream_flatline);
                        HomeActivity.this.emptyview_txt1.setText("You have no projects yet");
                        HomeActivity.this.emptyview_txt2.setText("Our servers are currently down anyways.");
                        return;
                    }
                    HomeActivity.this.projectsList = (ArrayList) new Gson().fromJson(FirebaseAuth.getInstance().getCurrentUser().getUid().concat("_userProjects"), new TypeToken<ArrayList<HashMap<String, Object>>>() {
                        /* class com.updatify.o2nation.HomeActivity.8.4 */
                    }.getType());
                    if (HomeActivity.this.projectsList.size() == 0) {
                        HomeActivity.this.empty_base.setVisibility(View.VISIBLE);
                        HomeActivity.this.recyclerview1.setVisibility(View.GONE);
                        HomeActivity.this.emptyview_img.setImageResource(R.drawable.dream_flatline);
                        HomeActivity.this.emptyview_txt1.setText("You have no projects yet");
                        HomeActivity.this.emptyview_txt2.setText("Our servers are currently down anyways.");
                        return;
                    }
                    HomeActivity.this.empty_base.setVisibility(View.GONE);
                    HomeActivity.this.recyclerview1.setVisibility(View.VISIBLE);
                    HomeActivity.this.recyclerview1.setAdapter(new Recyclerview1Adapter(HomeActivity.this.projectsList));
                } else if (hashMap.get("list_status").toString().equals("online")) {
                    HomeActivity.this.isServerLive = true;
                    HomeActivity.this.non_live_back.setVisibility(View.GONE);
                }
            }

            public void onChildChanged(DataSnapshot dataSnapshot, String str) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.HomeActivity.8.5 */
                };
                String key = dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
                if (key.equals(new Object() {
                    /* class com.updatify.o2nation.HomeActivity.8.6 */
                    int t;

                    public String toString() {
                        this.t = 1100752262;
                        this.t = -1915229575;
                        this.t = 374746237;
                        this.t = -1041650;
                        this.t = 904089400;
                        this.t = -797935898;
                        this.t = 522352264;
                        return new String(new byte[]{(byte) (this.t >>> 14), (byte) (this.t >>> 18), (byte) (this.t >>> 12), (byte) (this.t >>> 6), (byte) (this.t >>> 11), (byte) (this.t >>> 1), (byte) (this.t >>> 4)});
                    }
                }.toString())) {
                    HomeActivity.this._decryptString(hashMap.get("publishKey").toString(), new Object() {
                        /* class com.updatify.o2nation.HomeActivity.8.7 */
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
                if (!key.equals("server")) {
                    return;
                }
                if (hashMap.get("list_status").toString().equals("offline")) {
                    HomeActivity.this.isServerLive = false;
                    HomeActivity.this._transitionViewTime(HomeActivity.this.rootview, 200.0d);
                    HomeActivity.this.non_live_back.setVisibility(View.GONE);
                    if (HomeActivity.this.sharedPref.getString(FirebaseAuth.getInstance().getCurrentUser().getUid().concat("_userProjects"), "").equals("")) {
                        HomeActivity.this.empty_base.setVisibility(View.VISIBLE);
                        HomeActivity.this.recyclerview1.setVisibility(View.GONE);
                        HomeActivity.this.emptyview_img.setImageResource(R.drawable.dream_flatline);
                        HomeActivity.this.emptyview_txt1.setText("You have no projects yet");
                        HomeActivity.this.emptyview_txt2.setText("Our servers are currently down anyways.");
                        return;
                    }
                    HomeActivity.this.projectsList = (ArrayList) new Gson().fromJson(HomeActivity.this.sharedPref.getString(FirebaseAuth.getInstance().getCurrentUser().getUid().concat("_userProjects"), ""), new TypeToken<ArrayList<HashMap<String, Object>>>() {
                        /* class com.updatify.o2nation.HomeActivity.8.8 */
                    }.getType());
                    if (HomeActivity.this.projectsList.size() == 0) {
                        HomeActivity.this.empty_base.setVisibility(View.VISIBLE);
                        HomeActivity.this.recyclerview1.setVisibility(View.GONE);
                        HomeActivity.this.emptyview_img.setImageResource(R.drawable.dream_flatline);
                        HomeActivity.this.emptyview_txt1.setText("You have no projects yet");
                        HomeActivity.this.emptyview_txt2.setText("Click on \"Add new project\" above to connect your app with Updatify.");
                        return;
                    }
                    HomeActivity.this.empty_base.setVisibility(View.GONE);
                    HomeActivity.this.recyclerview1.setVisibility(View.VISIBLE);
                    HomeActivity.this.recyclerview1.setAdapter(new Recyclerview1Adapter(HomeActivity.this.projectsList));
                } else if (hashMap.get("list_status").toString().equals("online")) {
                    HomeActivity.this.isServerLive = true;
                    HomeActivity.this.non_live_back.setVisibility(View.GONE);
                }
            }

            public void onChildMoved(DataSnapshot dataSnapshot, String str) {
            }

            public void onChildRemoved(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.HomeActivity.8.9 */
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
        this._DBLogs_child_listener = new ChildEventListener() {
            /* class com.updatify.o2nation.HomeActivity.9 */

            public void onChildAdded(DataSnapshot dataSnapshot, String str) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.HomeActivity.9.1 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
            }

            public void onChildChanged(DataSnapshot dataSnapshot, String str) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.HomeActivity.9.2 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
            }

            public void onChildMoved(DataSnapshot dataSnapshot, String str) {
            }

            public void onChildRemoved(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.HomeActivity.9.3 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
            }

            public void onCancelled(DatabaseError databaseError) {
                databaseError.getCode();
                databaseError.getMessage();
            }
        };
        this.DBLogs.addChildEventListener(this._DBLogs_child_listener);
        this._SIcons_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
            /* class com.updatify.o2nation.HomeActivity.10 */

            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

            }
        };
        this._SIcons_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
            /* class com.updatify.o2nation.HomeActivity.11 */

            public void onProgress(FileDownloadTask.TaskSnapshot taskSnapshot) {
            }
        };
        this._SIcons_upload_success_listener = new OnCompleteListener<Uri>() {
            /* class com.updatify.o2nation.HomeActivity.12 */

            /* JADX WARN: Type inference failed for: r2v98, types: [android.content.Context, com.updatify.o2nation.HomeActivity] */
            /* JADX WARNING: Unknown variable types count: 1 */
            public void onComplete(Task<Uri> task) {
                String uri = ((Uri) task.getResult()).toString();
                HomeActivity.this._updatifyCore(false, "#0078FF", 85.0d, "#0078FF", 0.0d);
                if (uri.equals("")) {
                    HomeActivity.this._Snackbar_API("Can't add new project with icon, please try again without icon", "", "");
                    return;
                }
                HomeActivity.this.calendar = Calendar.getInstance();
                if (HomeActivity.this.isEditing) {
                    HomeActivity.this.projectsMap.put("appname", HomeActivity.this.name);
                    HomeActivity.this.projectsMap.put("appicon", uri);
                    HomeActivity.this.DBUserProjects.child(HomeActivity.this.editingTempKey).updateChildren(HomeActivity.this.projectsMap);
                    HomeActivity.this.projectsMap.clear();
                    HomeActivity.this.logTempKey = HomeActivity.this.DBPushUsers.push().getKey();
                    HomeActivity.this.logsMap = new HashMap();
                    HomeActivity.this.logsMap.put("appname", HomeActivity.this.name);
                    HomeActivity.this.logsMap.put("status", "App info edited on: ".concat(new SimpleDateFormat("dd/MM/yyyy 'at' h:mm a").format(HomeActivity.this.calendar.getTime())));
                    HomeActivity.this.logsMap.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
                    HomeActivity.this.logsMap.put("color", "#09B83E");
                    HomeActivity.this.DBPushUsers.child(FirebaseAuth.getInstance().getCurrentUser().getUid().concat("/LOGS/".concat(HomeActivity.this.logTempKey))).updateChildren(HomeActivity.this.logsMap);
                    HomeActivity.this.logsMap.clear();
                    HomeActivity.this.isIconPicked = false;
                    HomeActivity.this.downloadURL = "null";
                    HomeActivity.this.version = "";
                    HomeActivity.this.name = "";
                    HomeActivity.this.iconPath = "null";
                    HomeActivity.this.timer.cancel();
                    HomeActivity.this.isEditing = false;
                    HomeActivity.this.fbInterstitial.show();
                    HomeActivity.this.fbInterstitial = new InterstitialAd((Context) HomeActivity.this, "278142536768563_320780439171439");
                    HomeActivity.this.fbInterstitial.loadAd();
                    return;
                }
                HomeActivity.this.tempAppKey = HomeActivity.this.appname.trim().concat("_".concat(String.valueOf((long) SketchwareUtil.getRandom(0, 999999999))));
                HomeActivity.this.APIProjectsMap = new HashMap();
                HomeActivity.this.APIProjectsMap.put("appname", HomeActivity.this.appname.trim());
                HomeActivity.this.APIProjectsMap.put("currVersion", HomeActivity.this.version.concat(".".concat(HomeActivity.this.version)));
                HomeActivity.this.APIProjectsMap.put("newVersion", HomeActivity.this.version.concat(".".concat(HomeActivity.this.version)));
                HomeActivity.this.APIProjectsMap.put("developer", HomeActivity.this.username);
                HomeActivity.this.APIProjectsMap.put("email", FirebaseAuth.getInstance().getCurrentUser().getEmail());
                HomeActivity.this.APIProjectsMap.put("openLinkMain", "https://play.google.com/store/apps/details?id=com.updatify.o2nation");
                HomeActivity.this.APIProjectsMap.put("isCancelable", "true");
                HomeActivity.this.APIProjectsMap.put("dialogOption", "message");
                HomeActivity.this.APIProjectsMap.put("dialogTitle", "Updatify is connected");
                HomeActivity.this.APIProjectsMap.put("dialogSubtitle", "Your UpdatifyComponent integration is working. Good job.");
                HomeActivity.this.APIProjectsMap.put("dialogBtnMainTxt", "Give us 5 stars");
                HomeActivity.this.APIProjectsMap.put("dialogBtnExtraTxt", "Cancel");
                HomeActivity.this.APIProjectsMap.put("dialogBtnMainClick", "browser");
                HomeActivity.this.APIProjectsMap.put("dialogBtnExtraClick", "dismiss");
                HomeActivity.this.APIProjectsMap.put("dialogBtnMain", "true");
                HomeActivity.this.APIProjectsMap.put("dialogBtnExtra", "true");
                HomeActivity.this.APIProjectsMap.put("isOneTime", "false");
                HomeActivity.this.APIProjectsMap.put("isOneTimeKey", "null");
                HomeActivity.this.APIProjectsMap.put("customDialogRound", "null");
                HomeActivity.this.APIProjectsMap.put("customDialogBack", "null");
                HomeActivity.this.APIProjectsMap.put("customDialogAccent", "null");
                HomeActivity.this.APIProjectsMap.put("customDialogMainTxtColor", "null");
                HomeActivity.this.APIProjectsMap.put("customDialogBtnTxtColor", "null");
                HomeActivity.this.APIProjectsMap.put("customDialogIcon", "null");
                HomeActivity.this.APIProjectsMap.put("alertOption", "dialog");
                HomeActivity.this.APIHeaders.put("key", HomeActivity.this.publishKey);
                HomeActivity.this.APIHeaders.put("filename", HomeActivity.this.tempAppKey);
                HomeActivity.this.APIHeaders.put("content", new Gson().toJson(HomeActivity.this.APIProjectsMap));
                HomeActivity.this.requestProjects.setParams(HomeActivity.this.APIHeaders, 0);
                HomeActivity.this.requestProjects.startRequestNetwork(RequestNetworkController.POST, "https://nerbly.com/updatify/apiv1/?do=create", "", HomeActivity.this._requestProjects_request_listener);
                HomeActivity.this.APIProjectsMap.clear();
                HomeActivity.this.APIHeaders.clear();
                HomeActivity.this.tempKey = HomeActivity.this.DBUserProjects.push().getKey();
                HomeActivity.this.projectsMap = new HashMap();
                HomeActivity.this.projectsMap.put("appname", HomeActivity.this.appname.trim());
                HomeActivity.this.projectsMap.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
                HomeActivity.this.projectsMap.put("email", FirebaseAuth.getInstance().getCurrentUser().getEmail());
                HomeActivity.this.projectsMap.put("appicon", uri);
                HomeActivity.this.projectsMap.put("currVersion", HomeActivity.this.version);
                HomeActivity.this.projectsMap.put("status", "App connected");
                HomeActivity.this.projectsMap.put("color", "#0084FF");
                HomeActivity.this.projectsMap.put("key", HomeActivity.this.tempKey);
                HomeActivity.this.projectsMap.put("api", "https://nerbly.com/updatify/apiv1/files/".concat(HomeActivity.this.tempAppKey.concat(".json")));
                HomeActivity.this.projectsMap.put("filename", HomeActivity.this.tempAppKey);
                HomeActivity.this.DBUserProjects.child(HomeActivity.this.tempKey).updateChildren(HomeActivity.this.projectsMap);
                HomeActivity.this.projectsMap.clear();
                HomeActivity.this.logTempKey = HomeActivity.this.DBPushUsers.push().getKey();
                HomeActivity.this.logsMap = new HashMap();
                HomeActivity.this.logsMap.put("appname", HomeActivity.this.appname.trim());
                HomeActivity.this.logsMap.put("status", "App registered on: ".concat(new SimpleDateFormat("dd/MM/yyyy 'at' h:mm a").format(HomeActivity.this.calendar.getTime())));
                HomeActivity.this.logsMap.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
                HomeActivity.this.logsMap.put("color", "#0070EE");
                HomeActivity.this.DBPushUsers.child(FirebaseAuth.getInstance().getCurrentUser().getUid().concat("/LOGS/".concat(HomeActivity.this.logTempKey))).updateChildren(HomeActivity.this.logsMap);
                HomeActivity.this.logsMap.clear();
                HomeActivity.this.isIconPicked = false;
                HomeActivity.this.downloadURL = "null";
                HomeActivity.this.version = "";
                HomeActivity.this.name = "";
                HomeActivity.this.iconPath = "null";
                HomeActivity.this.timer.cancel();
                HomeActivity.this.waitToLoadProjects = new TimerTask() {
                    /* class com.updatify.o2nation.HomeActivity.12.1 */

                    public void run() {
                        HomeActivity.this.runOnUiThread(new Runnable() {
                            /* class com.updatify.o2nation.HomeActivity.12.1.1 */

                            public void run() {
                                HomeActivity.this._transitionViewTime(HomeActivity.this.background, 150.0d);
                                HomeActivity.this.uploading_view.setVisibility(View.GONE);
                                HomeActivity.this.recyclerview1.setEnabled(true);
                            }
                        });
                    }
                };
                HomeActivity.this._timer.schedule(HomeActivity.this.waitToLoadProjects, 1000);
            }
        };
        this._SIcons_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            /* class com.updatify.o2nation.HomeActivity.13 */

            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
            }
        };
        this._SIcons_delete_success_listener = new OnSuccessListener() {
            /* class com.updatify.o2nation.HomeActivity.14 */

            public void onSuccess(Object obj) {
            }
        };
        this._SIcons_failure_listener = new OnFailureListener() {
            /* class com.updatify.o2nation.HomeActivity.15 */

            public void onFailure(Exception exc) {
                String message = exc.getMessage();
                HomeActivity.this._updatifyCore(false, "#FFFFFF", 90.0d, "#FFFFFF", 0.0d);
                HomeActivity.this._Snackbar_API(message, "", "long");
                HomeActivity.this.recyclerview1.setEnabled(true);
            }
        };
        this._DBAds_child_listener = new ChildEventListener() {
            /* class com.updatify.o2nation.HomeActivity.16 */

            public void onChildAdded(DataSnapshot dataSnapshot, String str) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.HomeActivity.16.1 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
            }

            public void onChildChanged(DataSnapshot dataSnapshot, String str) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.HomeActivity.16.2 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
            }

            public void onChildMoved(DataSnapshot dataSnapshot, String str) {
            }

            public void onChildRemoved(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.HomeActivity.16.3 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
            }

            public void onCancelled(DatabaseError databaseError) {
                databaseError.getCode();
                databaseError.getMessage();
            }
        };
        this.DBAds.addChildEventListener(this._DBAds_child_listener);
        this.cloud_onCompleteListener = new OnCompleteListener<InstanceIdResult>() {
            /* class com.updatify.o2nation.HomeActivity.17 */

            public void onComplete(Task<InstanceIdResult> task) {
                task.isSuccessful();
                ((InstanceIdResult) task.getResult()).getToken();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this._checkNetwork_request_listener = new RequestNetwork.RequestListener() {
            /* class com.updatify.o2nation.HomeActivity.18 */

            @Override // com.updatify.o2nation.RequestNetwork.RequestListener
            public void onResponse(String str, String str2, HashMap<String, Object> hashMap) {
                if (str.equals("delete")) {
                    HomeActivity.this.authMap = new HashMap();
                    HomeActivity.this.authMap.put("slots", String.valueOf((long) (HomeActivity.this.availableSlots - 1.0d)));
                    HomeActivity.this.DBPushUsers.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(HomeActivity.this.authMap);
                    HomeActivity.this.authMap.clear();
                    HomeActivity.this.DBUserProjects.child(HomeActivity.this.deleteAppKey).removeValue();
                    HomeActivity.this._Snackbar_API("Project has been deleted permanently.", "", "short");
                    HomeActivity.this.logTempKey = HomeActivity.this.DBPushUsers.push().getKey();
                    HomeActivity.this.logsMap = new HashMap();
                    HomeActivity.this.logsMap.put("appname", HomeActivity.this.deleteAppName);
                    HomeActivity.this.logsMap.put("status", "Deleted on: ".concat(new SimpleDateFormat("dd/MM/yyyy 'at' h:mm a").format(HomeActivity.this.calendar.getTime())));
                    HomeActivity.this.logsMap.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
                    HomeActivity.this.logsMap.put("color", "#BD081C");
                    HomeActivity.this.DBPushUsers.child(FirebaseAuth.getInstance().getCurrentUser().getUid().concat("/LOGS/".concat(HomeActivity.this.logTempKey))).updateChildren(HomeActivity.this.logsMap);
                    HomeActivity.this.logsMap.clear();
                    if (!HomeActivity.this.deleteAppIcon.equals("null")) {
                        HomeActivity.this._firebase_storage.getReferenceFromUrl(HomeActivity.this.deleteAppIcon).delete().addOnSuccessListener(HomeActivity.this._SIcons_delete_success_listener).addOnFailureListener(HomeActivity.this._SIcons_failure_listener);
                    }
                    HomeActivity.this.APIHeaders.put("key", HomeActivity.this.publishKey);
                    HomeActivity.this.APIHeaders.put("filename", HomeActivity.this.deleteFileName);
                    HomeActivity.this.requestProjects.setParams(HomeActivity.this.APIHeaders, 0);
                    HomeActivity.this.requestProjects.startRequestNetwork(RequestNetworkController.POST, "https://nerbly.com/updatify/apiv1/?do=remove", "delete", HomeActivity.this._requestProjects_request_listener);
                    HomeActivity.this.APIHeaders.clear();
                    HomeActivity.this._updatifyCore(false, "#FFFFFF", 100.0d, "#FFFFFF", 0.0d);
                } else if (str.equals("GET_NOTIFICATIONS")) {
                    HomeActivity.this.swiperefreshlayout1.setRefreshing(false);
                    if (str2.equals("")) {
                        HomeActivity.this.empty_notifications_img.setImageResource(R.drawable.empty_inbox_);
                        HomeActivity.this.empty_notifications_title.setText("No notifications available");
                        HomeActivity.this.empty_notifications_sub.setText("It's impossible to not have notifications here anyways lol.");
                        HomeActivity.this.swiperefreshlayout1.setVisibility(View.GONE);
                        HomeActivity.this.empty_view_notifications.setVisibility(View.GONE);
                        return;
                    }
                    try {
                        HomeActivity.this.notificationCenterContent = str2;
                        HomeActivity.this.swiperefreshlayout1.setVisibility(View.VISIBLE);
                        HomeActivity.this.empty_view_notifications.setVisibility(View.GONE);
                        HomeActivity.this.notificationsList = (ArrayList) new Gson().fromJson(str2, new TypeToken<ArrayList<HashMap<String, Object>>>() {
                            /* class com.updatify.o2nation.HomeActivity.18.1 */
                        }.getType());
                        Collections.reverse(HomeActivity.this.notificationsList);
                        HomeActivity.this.sharedPref.edit().putString("allNotifications", new Gson().toJson(HomeActivity.this.notificationsList)).commit();
                        HomeActivity.this.recyclerview2.setAdapter(new Recyclerview2Adapter(HomeActivity.this.notificationsList));
                        HomeActivity.this._transitionViewTime(HomeActivity.this.linear3, 150.0d);
                        HomeActivity.this.imageview4.setVisibility(View.VISIBLE);
                        if (HomeActivity.this.sharedPref.getString("notification_10", "").equals("")) {
                            HomeActivity.this.swipeToRefreshTmr = new TimerTask() {
                                /* class com.updatify.o2nation.HomeActivity.18.2 */

                                public void run() {
                                    HomeActivity.this.runOnUiThread(new Runnable() {
                                        /* class com.updatify.o2nation.HomeActivity.18.2.1 */

                                        /* JADX WARN: Type inference failed for: r0v2, types: [android.app.Activity, com.updatify.o2nation.HomeActivity] */
                                        /* JADX WARNING: Unknown variable types count: 1 */
                                        public void run() {
                                            HomeActivity.this.sharedPref.edit().putString("notification_10", "true").commit();
                                        }
                                    });
                                }
                            };
                            HomeActivity.this._timer.schedule(HomeActivity.this.swipeToRefreshTmr, 2000);
                        }
                        if (!HomeActivity.this.sharedPref.getString("notificationCenterContent", "").equals(str2) && HomeActivity.this.viewPager.getCurrentItem() == 0) {
                            HomeActivity.this.badgeview.setVisibility(View.VISIBLE);
                        }
                    } catch (Exception e) {
                        SketchwareUtil.showMessage(HomeActivity.this.getApplicationContext(), e.toString());
                    }
                }
            }

            @Override // com.updatify.o2nation.RequestNetwork.RequestListener
            public void onErrorResponse(String str, String str2) {
                HomeActivity.this._Snackbar_API("Check your internet connection", "", "");
                HomeActivity.this._updatifyCore(false, "#FFFFFF", 100.0d, "#FFFFFF", 0.0d);
                HomeActivity.this.swiperefreshlayout1.setRefreshing(false);
                HomeActivity.this.notificationsList = (ArrayList) new Gson().fromJson(HomeActivity.this.sharedPref.getString("allNotifications", ""), new TypeToken<ArrayList<HashMap<String, Object>>>() {
                    /* class com.updatify.o2nation.HomeActivity.18.3 */
                }.getType());
                HomeActivity.this.recyclerview2.setAdapter(new Recyclerview2Adapter(HomeActivity.this.notificationsList));
            }
        };
        this._DBPushUsers_child_listener = new ChildEventListener() {
            /* class com.updatify.o2nation.HomeActivity.19 */

            public void onChildAdded(DataSnapshot dataSnapshot, String str) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.HomeActivity.19.1 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
            }

            public void onChildChanged(DataSnapshot dataSnapshot, String str) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.HomeActivity.19.2 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
            }

            public void onChildMoved(DataSnapshot dataSnapshot, String str) {
            }

            public void onChildRemoved(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.HomeActivity.19.3 */
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
            /* class com.updatify.o2nation.HomeActivity.20 */

            public void onChildAdded(DataSnapshot dataSnapshot, String str) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.HomeActivity.20.1 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
                HomeActivity.this.DBUserProjects.addListenerForSingleValueEvent(new ValueEventListener() {
                    /* class com.updatify.o2nation.HomeActivity.20.2 */

                    public void onDataChange(DataSnapshot dataSnapshot) {
                        HomeActivity.this.projectsList = new ArrayList();
                        try {
                            GenericTypeIndicator<HashMap<String, Object>> r1 = new GenericTypeIndicator<HashMap<String, Object>>() {
                                /* class com.updatify.o2nation.HomeActivity.20.2.1 */
                            };
                            for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                                HomeActivity.this.projectsList.add((HashMap) dataSnapshot2.getValue(r1));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (HomeActivity.this.projectsList.size() == 0) {
                            HomeActivity.this.empty_base.setVisibility(View.VISIBLE);
                            HomeActivity.this.recyclerview1.setVisibility(View.GONE);
                            HomeActivity.this.emptyview_img.setImageResource(R.drawable.dream_flatline);
                            HomeActivity.this.emptyview_txt1.setText("You have no projects yet");
                            HomeActivity.this.emptyview_txt2.setText("Click on \"Add new project\" above to connect your app with Updatify.");
                        } else {
                            HomeActivity.this.empty_base.setVisibility(View.GONE);
                            HomeActivity.this.recyclerview1.setVisibility(View.VISIBLE);
                            HomeActivity.this.recyclerview1.setAdapter(new Recyclerview1Adapter(HomeActivity.this.projectsList));
                        }
                        HomeActivity.this.sharedPref.edit().putString(FirebaseAuth.getInstance().getCurrentUser().getUid().concat("_userProjects"), new Gson().toJson(HomeActivity.this.projectsList)).commit();
                    }

                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
            }

            public void onChildChanged(DataSnapshot dataSnapshot, String str) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.HomeActivity.20.3 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
                HomeActivity.this.DBUserProjects.addListenerForSingleValueEvent(new ValueEventListener() {
                    /* class com.updatify.o2nation.HomeActivity.20.4 */

                    public void onDataChange(DataSnapshot dataSnapshot) {
                        HomeActivity.this.projectsList = new ArrayList();
                        try {
                            GenericTypeIndicator<HashMap<String, Object>> r1 = new GenericTypeIndicator<HashMap<String, Object>>() {
                                /* class com.updatify.o2nation.HomeActivity.20.4.1 */
                            };
                            for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                                HomeActivity.this.projectsList.add((HashMap) dataSnapshot2.getValue(r1));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (HomeActivity.this.projectsList.size() == 0) {
                            HomeActivity.this.empty_base.setVisibility(View.VISIBLE);
                            HomeActivity.this.recyclerview1.setVisibility(View.GONE);
                            HomeActivity.this.emptyview_img.setImageResource(R.drawable.dream_flatline);
                            HomeActivity.this.emptyview_txt1.setText("You have no projects yet");
                            HomeActivity.this.emptyview_txt2.setText("Click on \"Add new project\" above to connect your app with Updatify.");
                        } else {
                            HomeActivity.this.empty_base.setVisibility(View.GONE);
                            HomeActivity.this.recyclerview1.setVisibility(View.VISIBLE);
                            HomeActivity.this.recyclerview1.setAdapter(new Recyclerview1Adapter(HomeActivity.this.projectsList));
                        }
                        HomeActivity.this.sharedPref.edit().putString(FirebaseAuth.getInstance().getCurrentUser().getUid().concat("_userProjects"), new Gson().toJson(HomeActivity.this.projectsList)).commit();
                    }

                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
            }

            public void onChildMoved(DataSnapshot dataSnapshot, String str) {
            }

            public void onChildRemoved(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.HomeActivity.20.5 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
                HomeActivity.this.DBUserProjects.addListenerForSingleValueEvent(new ValueEventListener() {
                    /* class com.updatify.o2nation.HomeActivity.20.6 */

                    public void onDataChange(DataSnapshot dataSnapshot) {
                        HomeActivity.this.projectsList = new ArrayList();
                        try {
                            GenericTypeIndicator<HashMap<String, Object>> r1 = new GenericTypeIndicator<HashMap<String, Object>>() {
                                /* class com.updatify.o2nation.HomeActivity.20.6.1 */
                            };
                            for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                                HomeActivity.this.projectsList.add((HashMap) dataSnapshot2.getValue(r1));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (HomeActivity.this.projectsList.size() == 0) {
                            HomeActivity.this.empty_base.setVisibility(View.VISIBLE);
                            HomeActivity.this.recyclerview1.setVisibility(View.GONE);
                            HomeActivity.this.emptyview_img.setImageResource(R.drawable.dream_flatline);
                            HomeActivity.this.emptyview_txt1.setText("You have no projects yet");
                            HomeActivity.this.emptyview_txt2.setText("Click on \"Add new project\" above to connect your app with Updatify.");
                        } else {
                            HomeActivity.this.empty_base.setVisibility(View.GONE);
                            HomeActivity.this.recyclerview1.setVisibility(View.VISIBLE);
                            HomeActivity.this.recyclerview1.setAdapter(new Recyclerview1Adapter(HomeActivity.this.projectsList));
                        }
                        HomeActivity.this.sharedPref.edit().putString(FirebaseAuth.getInstance().getCurrentUser().getUid().concat("_userProjects"), new Gson().toJson(HomeActivity.this.projectsList)).commit();
                    }

                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
            }

            public void onCancelled(DatabaseError databaseError) {
                databaseError.getCode();
                databaseError.getMessage();
            }
        };
        this.DBUserProjects.addChildEventListener(this._DBUserProjects_child_listener);
        this.mAuth_updateEmailListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.HomeActivity.21 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_updatePasswordListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.HomeActivity.22 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_emailVerificationSentListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.HomeActivity.23 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_deleteUserListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.HomeActivity.24 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
            /* class com.updatify.o2nation.HomeActivity.25 */

            public void onComplete(Task<AuthResult> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_updateProfileListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.HomeActivity.26 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_googleSignInListener = new OnCompleteListener<AuthResult>() {
            /* class com.updatify.o2nation.HomeActivity.27 */

            public void onComplete(Task<AuthResult> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this._mAuth_create_user_listener = new OnCompleteListener<AuthResult>() {
            /* class com.updatify.o2nation.HomeActivity.28 */

            public void onComplete(Task<AuthResult> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this._mAuth_sign_in_listener = new OnCompleteListener<AuthResult>() {
            /* class com.updatify.o2nation.HomeActivity.29 */

            public void onComplete(Task<AuthResult> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this._mAuth_reset_password_listener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.HomeActivity.30 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
            }
        };
    }

    private void initializeLogic() {
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            this.toauth.setClass(getApplicationContext(), Auth2Activity.class);
            startActivity(this.toauth);
            SketchwareUtil.showMessage(getApplicationContext(), "You're not logged in");
            finish();
        }
        overridePendingTransition(17432576, 17432577);
        if (this.sharedPref.getString("autodark", "").equals("true") || this.sharedPref.getString("autodark", "").equals("")) {
            try {
                switch (getResources().getConfiguration().uiMode & 48) {
                    case 16:
                        this.sharedPref.edit().putString("dark", "false").commit();
                        break;
                    case 32:
                        this.sharedPref.edit().putString("dark", "true").commit();
                        break;
                }
            } catch (Exception e) {
            }
        }
        this.non_live_back.setVisibility(View.GONE);
        this.checkNetwork.startRequestNetwork(RequestNetworkController.GET, "https://nerbly.com/updatify/notifications/notifications/noti_center.json", "GET_NOTIFICATIONS", this._checkNetwork_request_listener);
        _changeUserReference();
        _changeProjectsReference();
        this.sharedPref.edit().putString("LastActivity", "HomeActivity.Java").commit();
        _onCreate_auth_Google("1018146324937-5m0c7b0gio8ut2ll89cubiuqgiml5ors.apps.googleusercontent.com");
        _LOGIC_BACKEND();
        _Logic_UI();
        if (this.sharedPref.getString("notification_2", "").equals("")) {
            this.adsTmr = new TimerTask() {
                /* class com.updatify.o2nation.HomeActivity.31 */

                public void run() {
                    HomeActivity.this.runOnUiThread(new Runnable() {
                        /* class com.updatify.o2nation.HomeActivity.31.1 */

                        /* JADX WARN: Type inference failed for: r0v1, types: [android.app.Activity, com.updatify.o2nation.HomeActivity] */
                        /* JADX WARNING: Unknown variable types count: 1 */
                        public void run() {
                            HomeActivity.this.sharedPref.edit().putString("notification_2", "true").commit();
                        }
                    });
                }
            };
            this._timer.schedule(this.adsTmr, 15000);
        } else if (!this.sharedPref.getString("notification_10", "").equals("") && this.sharedPref.getString("discountDialog1", "").equals("")) {
            _discountDialog();
        }
        this.background.setVisibility(View.INVISIBLE);
        this.background.setEnabled(false);
        this.logoPosition = new TimerTask() {
            /* class com.updatify.o2nation.HomeActivity.32 */

            public void run() {
                HomeActivity.this.runOnUiThread(new Runnable() {
                    /* class com.updatify.o2nation.HomeActivity.32.1 */

                    public void run() {
                        HomeActivity.this.oldLogoPos = (double) (HomeActivity.this.rootview.getMeasuredHeight() / 2);
                        HomeActivity.this.logo.setTranslationY((float) (-31.0d - HomeActivity.this.oldLogoPos));
                    }
                });
            }
        };
        this._timer.scheduleAtFixedRate(this.logoPosition, 0, 300);
        this.welcomeAnimation = new TimerTask() {
            /* class com.updatify.o2nation.HomeActivity.33 */

            public void run() {
                HomeActivity.this.runOnUiThread(new Runnable() {
                    /* class com.updatify.o2nation.HomeActivity.33.1 */

                    public void run() {
                        HomeActivity.this.animation.cancel();
                        HomeActivity.this.animation2.cancel();
                        try {
                            RippleAnimation.create(HomeActivity.this.logo).setDuration(600).start();
                        } catch (Exception ignored) {
                        }
                        HomeActivity.this.background.setEnabled(true);
                        HomeActivity.this.background.setVisibility(View.VISIBLE);
                        if (HomeActivity.this.sharedPref.getString("dark", "").equals("true")) {
                            HomeActivity.this._NavStatusBarColor("#181818", "#181818");
                        } else {
                            HomeActivity.this._NavStatusBarColor("#FFFFFF", "#FFFFFF");
                            HomeActivity.this._DARK_ICONS();
                        }
                        HomeActivity.this.logoPosition.cancel();
                        HomeActivity.this.animation.setTarget(HomeActivity.this.logo);
                        HomeActivity.this.animation.setPropertyName("scaleX");
                        HomeActivity.this.animation.setFloatValues(HomeActivity.this.logo.getScaleX(), 0.0f);
                        HomeActivity.this.animation.setDuration(700L);
                        HomeActivity.this.animation.setRepeatMode(ValueAnimator.REVERSE);
                        HomeActivity.this.animation.setRepeatCount(0);
                        HomeActivity.this.animation.start();
                        HomeActivity.this.animation2.setTarget(HomeActivity.this.logo);
                        HomeActivity.this.animation2.setPropertyName("scaleY");
                        HomeActivity.this.animation2.setFloatValues(HomeActivity.this.logo.getScaleY(), 0.0f);
                        HomeActivity.this.animation2.setDuration(700L);
                        HomeActivity.this.animation2.setRepeatMode(ValueAnimator.REVERSE);
                        HomeActivity.this.animation2.setRepeatCount(0);
                        HomeActivity.this.animation2.start();
                    }
                });
            }
        };
        this._timer.schedule(this.welcomeAnimation, 2000);
        this.welcomeAnimation2 = new TimerTask() {
            /* class com.updatify.o2nation.HomeActivity.34 */

            public void run() {
                HomeActivity.this.runOnUiThread(new Runnable() {
                    /* class com.updatify.o2nation.HomeActivity.34.1 */

                    public void run() {
                        HomeActivity.this.animation.setTarget(HomeActivity.this.logo);
                        HomeActivity.this.animation.setPropertyName("scaleX");
                        HomeActivity.this.animation.setFloatValues(1.0f, 1.2f);
                        HomeActivity.this.animation.setDuration(700L);
                        HomeActivity.this.animation.setRepeatMode(ValueAnimator.REVERSE);
                        HomeActivity.this.animation.setRepeatCount(900);
                        HomeActivity.this.animation.start();
                        HomeActivity.this.animation2.setTarget(HomeActivity.this.logo);
                        HomeActivity.this.animation2.setPropertyName("scaleY");
                        HomeActivity.this.animation2.setFloatValues(1.0f, 1.2f);
                        HomeActivity.this.animation2.setDuration(700L);
                        HomeActivity.this.animation2.setRepeatMode(ValueAnimator.REVERSE);
                        HomeActivity.this.animation2.setRepeatCount(900);
                        HomeActivity.this.animation2.start();
                    }
                });
            }
        };
        this._timer.schedule(this.welcomeAnimation2, 600);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColors(new int[]{Color.parseColor("#FF4099FF"), Color.parseColor("#FF0078FF")});
        gradientDrawable.setCornerRadius(0.0f);
        this.rootview.setBackground(gradientDrawable);
        _NavStatusBarColor("#4099FF", "#0078FF");
        _LIGHT_ICONS();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        HomeActivity.super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (this.viewPager.getCurrentItem() == 1) {
            this.viewPager.setCurrentItem(0);
            return;
        }
        if (this.doubleBackExit == 0.0d) {
            _Snackbar_API("Click twice to exit Updatify", "", "");
            this.timer = new TimerTask() {
                /* class com.updatify.o2nation.HomeActivity.35 */

                public void run() {
                    HomeActivity.this.runOnUiThread(new Runnable() {
                        /* class com.updatify.o2nation.HomeActivity.35.1 */

                        public void run() {
                            HomeActivity.this.doubleBackExit = 1.0d;
                        }
                    });
                }
            };
            this._timer.schedule(this.timer, 0);
            this.timer = new TimerTask() {
                /* class com.updatify.o2nation.HomeActivity.36 */

                public void run() {
                    HomeActivity.this.runOnUiThread(new Runnable() {
                        /* class com.updatify.o2nation.HomeActivity.36.1 */

                        public void run() {
                            HomeActivity.this.doubleBackExit = 0.0d;
                        }
                    });
                }
            };
            this._timer.schedule(this.timer, 1500);
        }
        if (this.doubleBackExit == 1.0d) {
            finishAffinity();
        }
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

    public void _ICC(ImageView imageView, String str, String str2) {
        imageView.setImageTintList(new ColorStateList(new int[][]{new int[]{-16842919}, new int[]{16842919}}, new int[]{Color.parseColor(str), Color.parseColor(str2)}));
    }

    public void _DARK_ICONS() {
        getWindow().getDecorView().setSystemUiVisibility(8192);
    }

    public void _advancedCorners(View view, String str, double d, double d2, double d3, double d4) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadii(new float[]{(float) ((int) d), (float) ((int) d), (float) ((int) d2), (float) ((int) d2), (float) ((int) d4), (float) ((int) d4), (float) ((int) d3), (float) ((int) d3)});
        view.setBackground(gradientDrawable);
    }

    public void _RoundAndBorder(View view, String str, double d, String str2, double d2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius((float) ((int) d2));
        gradientDrawable.setStroke((int) d, Color.parseColor(str2));
        view.setBackground(gradientDrawable);
    }

    public void _setCircleImageURL(ImageView imageView, String str, double d, String str2) {
        Glide.with(this).load(str).circleCrop().into(imageView);
    }

    public void _rippleRoundStroke(View view, String str, String str2, double d, double d2, String str3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius((float) d);
        gradientDrawable.setStroke((int) d2, Color.parseColor("#" + str3.replace("#", "")));
        view.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor("#" + str2.replace("#", ""))}), gradientDrawable, null));
    }

    public void _clickAnim(final View view) {
        view.setOnTouchListener(new View.OnTouchListener() {
            /* class com.updatify.o2nation.HomeActivity.37 */

            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case RequestNetworkController.REQUEST_PARAM:
                        HomeActivity.this._shadAnim(view, "scaleX", 1.05d, 100.0d);
                        HomeActivity.this._shadAnim(view, "scaleY", 1.05d, 100.0d);
                        return false;
                    case RequestNetworkController.REQUEST_BODY:
                        HomeActivity.this._shadAnim(view, "scaleX", 1.0d, 100.0d);
                        HomeActivity.this._shadAnim(view, "scaleY", 1.0d, 100.0d);
                        return false;
                    default:
                        return false;
                }
            }
        });
    }

    public void _shadAnim(View view, String str, double d, double d2) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setTarget(view);
        objectAnimator.setPropertyName(str);
        objectAnimator.setFloatValues((float) d);
        objectAnimator.setDuration((long) d2);
        objectAnimator.start();
    }

    public void _clicker(final View view) {
        view.setOnTouchListener(new View.OnTouchListener() {
            /* class com.updatify.o2nation.HomeActivity.38 */

            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case RequestNetworkController.REQUEST_PARAM:
                        HomeActivity.this._shadAnim(view, "scaleX", 1.1d, 100.0d);
                        HomeActivity.this._shadAnim(view, "scaleY", 1.1d, 100.0d);
                        return false;
                    case RequestNetworkController.REQUEST_BODY:
                        HomeActivity.this._shadAnim(view, "scaleX", 1.0d, 100.0d);
                        HomeActivity.this._shadAnim(view, "scaleY", 1.0d, 100.0d);
                        return false;
                    default:
                        return false;
                }
            }
        });
    }

    public void _RippleEffects(String str, View view) {
        view.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor(str)}), null, null));
    }

    public void _rad(View view, String str, String str2) {
    }

    public void _newwr(final View view) {
        view.setOnTouchListener(new View.OnTouchListener() {
            /* class com.updatify.o2nation.HomeActivity.39 */

            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case RequestNetworkController.REQUEST_PARAM:
                        HomeActivity.this._shadAnim(view, "elevation", 5.0d, 100.0d);
                        HomeActivity.this._shadAnim(view, "scaleX", 1.06d, 100.0d);
                        HomeActivity.this._shadAnim(view, "scaleY", 1.06d, 100.0d);
                        return false;
                    case RequestNetworkController.REQUEST_BODY:
                        HomeActivity.this._shadAnim(view, "elevation", 0.0d, 100.0d);
                        HomeActivity.this._shadAnim(view, "scaleX", 1.0d, 100.0d);
                        HomeActivity.this._shadAnim(view, "scaleY", 1.0d, 100.0d);
                        return false;
                    default:
                        return false;
                }
            }
        });
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.updatify.o2nation.HomeActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void _ActivityTranlation(View view, String str, Intent intent) {
        view.setTransitionName(str);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this, view, str).toBundle());
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
        textView.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product.ttf"), Typeface.NORMAL);
        this._sblayout.addView(inflate, 0);
        this._snackBarView.show();
    }

    private void _doNothingBlahBlah() {
    }

    public void _decryptString(String str, String str2) {
        try {
            Cipher instance = Cipher.getInstance("AES");

            this.publishKey = new String(instance.doFinal(Base64.decode(str, 0)));
        } catch (Exception e) {
            this.publishKey = "null";
        }
    }

    public void _Encrypt_And_Decrypt() {
    }

    private SecretKey generateKey(String str) throws Exception { ;
        byte[] bytes2 = str.getBytes("UTF-8");
        return generateKey("mod");
    }

    public void _setInputLimit(TextView textView, double d) {
        textView.setFilters(new InputFilter[]{new InputFilter.LengthFilter((int) d)});
    }

    public void _onClickSnackBar(String str, String str2) {
        this._snackBarView2 = Snackbar.make((ViewGroup) ((ViewGroup) findViewById(16908290)).getChildAt(0), "", 0);
        this._sblayout2 = (Snackbar.SnackbarLayout) this._snackBarView2.getView();
        View inflate = getLayoutInflater().inflate(R.layout.snackbar_click, (ViewGroup) null);
        this._sblayout2.setPadding(0, 0, 0, 0);
        this._sblayout2.setBackgroundColor(Color.argb(0, 0, 0, 0));
        TextView textView = (TextView) inflate.findViewById(R.id.textview1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.textview2);
        _setViewRadius((LinearLayout) inflate.findViewById(R.id.linear1), 25.0d, "#202125");
        _rippleRoundStroke(textView2, "#202125", "#EEEEEE", 20.0d, 0.0d, "#232323");
        textView.setText(str);
        textView2.setText(str2);
        textView2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_normal.ttf"), View.GONE);
        textView.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_normal.ttf"), View.GONE);
        textView2.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.HomeActivity.40 */

            public void onClick(View view) {
                HomeActivity.this.toprofile.setClass(HomeActivity.this.getApplicationContext(), ProfileActivity.class);
                HomeActivity.this.toprofile.putExtra("isWantToBuy", "true");
                HomeActivity.this.startActivity(HomeActivity.this.toprofile);
            }
        });
        this._sblayout2.addView(inflate, 0);
        this._snackBarView2.show();
    }

    private void _doNothingBlahBlah2() {
    }

    public void _ViewPager(View view, ArrayList<HashMap<String, Object>> arrayList, double d) {
        final ViewPager viewPager2 = new ViewPager(view.getContext());
        viewPager2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        viewPager2.setClipToPadding(false);
        viewPager2.setPadding(0, 0, 0, 0);
        this.adsTmr = new TimerTask() {
            /* class com.updatify.o2nation.HomeActivity.41 */

            public void run() {
                HomeActivity homeActivity = HomeActivity.this;
                final ViewPager viewPager = viewPager2;
                homeActivity.runOnUiThread(new Runnable() {
                    /* class com.updatify.o2nation.HomeActivity.41.1 */

                    public void run() {
                        HomeActivity.this.adsNum = (double) SketchwareUtil.getRandom(0, HomeActivity.this.ads.size());
                        viewPager.setCurrentItem((int) HomeActivity.this.adsNum);
                    }
                });
            }
        };
        this._timer.scheduleAtFixedRate(this.adsTmr, 0, 5000);
        viewPager2.setAdapter(new AdapterVP(arrayList));
        ((LinearLayout) view).addView(viewPager2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.updatify.o2nation.HomeActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void _addCardView(View view, double d, double d2, double d3, double d4, boolean z, String str) {
        View cardView = new CardView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        int i = (int) d;
        layoutParams.setMargins(10, i, 10, i);
        cardView.setLayoutParams(layoutParams);
        ((CardView) cardView).setCardBackgroundColor(Color.parseColor(str));
        ((CardView) cardView).setRadius((float) d2);
        ((CardView) cardView).setCardElevation((float) d3);
        ((CardView) cardView).setMaxCardElevation((float) d4);
        ((CardView) cardView).setPreventCornerOverlap(z);
        if (view.getParent() instanceof LinearLayout) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            viewGroup.removeView(view);
            viewGroup.removeAllViews();
            viewGroup.addView(cardView);
            ((CardView) cardView).addView(view);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.updatify.o2nation.HomeActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void _updatifyCore(boolean z, String str, double d, String str2, double d2) {
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

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.updatify.o2nation.HomeActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void _onCreate_auth_Google(String str) {
        this.googleAuth = GoogleSignIn.getClient(this, new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(str).requestEmail().build());
        this.mAuth = FirebaseAuth.getInstance();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.updatify.o2nation.HomeActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void _signOutGoogleAuth() {
        try {
            this.mAuth.signOut();
            this.googleAuth.signOut().addOnCompleteListener(this, new OnCompleteListener<Void>() {
                /* class com.updatify.o2nation.HomeActivity.42 */

                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        HomeActivity.this.toauth.setClass(HomeActivity.this.getApplicationContext(), Auth2Activity.class);
                        HomeActivity.this.startActivity(HomeActivity.this.toauth);
                        HomeActivity.this.finish();
                        return;
                    }
                    SketchwareUtil.showMessage(HomeActivity.this.getApplicationContext(), "Something went wrong");
                }
            });
        } catch (Exception e) {
            SketchwareUtil.showMessage(getApplicationContext(), e.toString());
        }
    }

    public void _setViewRadius(View view, double d, String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#" + str.replace("#", "")));
        gradientDrawable.setCornerRadius((float) ((int) d));
        view.setBackground(gradientDrawable);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r28v0, resolved type: com.updatify.o2nation.HomeActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void _editProject(final String str, String str2, final String str3) {
        this.isIconPicked = false;
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this, R.style.sheet_style);
        View inflate = getLayoutInflater().inflate(R.layout.edit_project, (ViewGroup) null);
        bottomSheetDialog.setContentView(inflate);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.background);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.line);
        LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(R.id.line2);
        LinearLayout linearLayout4 = (LinearLayout) inflate.findViewById(R.id.linear14);
        LinearLayout linearLayout5 = (LinearLayout) inflate.findViewById(R.id.scroller);
        LinearLayout linearLayout6 = (LinearLayout) inflate.findViewById(R.id.linear6);
        final EditText editText = (EditText) inflate.findViewById(R.id.edittext1);
        TextView textView = (TextView) inflate.findViewById(R.id.done_btn);
        TextView textView2 = (TextView) inflate.findViewById(R.id.textview5);
        TextView textView3 = (TextView) inflate.findViewById(R.id.textview2);
        TextView textView4 = (TextView) inflate.findViewById(R.id.close_btn);
        final ImageView imageView = (ImageView) inflate.findViewById(R.id.img1);
        final ImageView imageView2 = (ImageView) inflate.findViewById(R.id.imageview1);
        textView.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
        textView4.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
        editText.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
        textView3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
        ((TextView) inflate.findViewById(R.id.textview3)).setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
        textView2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
        _setCircleImageURL(imageView2, str2, 0.0d, "#FFFFFF");
        editText.setHint("Current app name: ".concat(str3));
        _setInputLimit(editText, 30.0d);
        _ICC(imageView, "#9E9E9E", "#CC9e9e9e");
        _RoundAndBorder(linearLayout5, "#CCFFFFFF", 0.0d, "#FFFFFF", 100.0d);
        _rippleRoundStroke(textView, "#016DE7", "#16FFFFFF", 25.0d, 0.0d, "#E0E0E0");
        if (this.sharedPref.getString("dark", "").equals("true")) {
            _advancedCorners(linearLayout, "#181818", 25.0d, 25.0d, 25.0d, 25.0d);
            _rippleRoundStroke(textView2, "#181818", "#E0E0E0", 100.0d, 2.0d, "#424242");
            editText.setTextColor(-1);
            textView3.setTextColor(-1);
            _rippleRoundStroke(textView4, "#424242", "#E0E0E0", 25.0d, 0.0d, "#006DF6");
            linearLayout2.setBackgroundColor(-12434878);
            linearLayout3.setBackgroundColor(-12434878);
            textView2.setTextColor(-1);
            textView4.setTextColor(-1);
        } else {
            _rippleRoundStroke(textView4, "#F5F5F5", "#E0E0E0", 25.0d, 0.0d, "#E0E0E0");
            _rippleRoundStroke(textView2, "#FFFFFF", "#E0E0E0", 100.0d, 2.0d, "#E0E0E0");
            _advancedCorners(linearLayout, "#ffffff", 25.0d, 25.0d, 25.0d, 25.0d);
        }
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.updatify.o2nation.HomeActivity.43 */

            public void onFocusChange(View view, boolean z) {
                if (z) {
                    HomeActivity.this._ICC(imageView, "#FF007EED", "#FF007EED");
                } else if (editText.getText().toString().equals("")) {
                    HomeActivity.this._ICC(imageView, "#9E9E9E", "#CC9e9e9e");
                }
            }
        });
        editText.setFocusableInTouchMode(true);
        editText.addTextChangedListener(new TextWatcher() {
            /* class com.updatify.o2nation.HomeActivity.44 */

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                charSequence.toString();
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.HomeActivity.45 */

            /* JADX WARN: Type inference failed for: r2v26, types: [android.content.Context, com.updatify.o2nation.HomeActivity] */
            /* JADX WARNING: Unknown variable types count: 1 */
            public void onClick(View view) {
                if (editText.getText().toString().trim().equals("")) {
                    if (HomeActivity.this.isIconPicked) {
                        HomeActivity.this.isEditing = true;
                        HomeActivity.this.recyclerview1.setEnabled(false);
                        HomeActivity.this.SIcons.child(HomeActivity.this.imageName).putFile(Uri.fromFile(new File(HomeActivity.this.iconPath))).addOnFailureListener(HomeActivity.this._SIcons_failure_listener).addOnProgressListener(HomeActivity.this._SIcons_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                            /* class com.updatify.o2nation.HomeActivity.45.1 */

                            public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
                                return HomeActivity.this.SIcons.child(HomeActivity.this.imageName).getDownloadUrl();
                            }
                        }).addOnCompleteListener(HomeActivity.this._SIcons_upload_success_listener);
                        HomeActivity.this._updatifyCore(true, "#FFFFFF", 90.0d, "#FFFFFF", 0.0d);
                        bottomSheetDialog.dismiss();
                        HomeActivity.this.editingTempKey = str;
                        HomeActivity.this.name = str3;
                        return;
                    }
                    HomeActivity.this._Snackbar_API("No changes were made", "", "");
                    HomeActivity.this.isEditing = false;
                    bottomSheetDialog.dismiss();
                } else if (HomeActivity.this.isIconPicked) {
                    HomeActivity.this.isEditing = true;
                    HomeActivity.this.recyclerview1.setEnabled(false);
                    HomeActivity.this.name = editText.getText().toString();
                    HomeActivity.this.editingTempKey = str;
                    HomeActivity.this.SIcons.child(HomeActivity.this.imageName).putFile(Uri.fromFile(new File(HomeActivity.this.iconPath))).addOnFailureListener(HomeActivity.this._SIcons_failure_listener).addOnProgressListener(HomeActivity.this._SIcons_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                        /* class com.updatify.o2nation.HomeActivity.45.2 */

                        public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
                            return HomeActivity.this.SIcons.child(HomeActivity.this.imageName).getDownloadUrl();
                        }
                    }).addOnCompleteListener(HomeActivity.this._SIcons_upload_success_listener);
                    HomeActivity.this._updatifyCore(true, "#FFFFFF", 90.0d, "#FFFFFF", 0.0d);
                    bottomSheetDialog.dismiss();
                } else {
                    HomeActivity.this.recyclerview1.setEnabled(false);
                    HomeActivity.this.calendar = Calendar.getInstance();
                    HomeActivity.this.name = editText.getText().toString();
                    HomeActivity.this.projectsMap = new HashMap();
                    HomeActivity.this.projectsMap.put("appname", editText.getText().toString().trim());
                    HomeActivity.this.DBUserProjects.child(str).updateChildren(HomeActivity.this.projectsMap);
                    HomeActivity.this.projectsMap.clear();
                    HomeActivity.this.logTempKey = HomeActivity.this.DBPushUsers.push().getKey();
                    HomeActivity.this.logsMap = new HashMap();
                    HomeActivity.this.logsMap.put("appname", editText.getText().toString().trim());
                    HomeActivity.this.logsMap.put("status", "App info edited on: ".concat(new SimpleDateFormat("dd/MM/yyyy 'at' h:mm a").format(HomeActivity.this.calendar.getTime())));
                    HomeActivity.this.logsMap.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
                    HomeActivity.this.logsMap.put("color", "#09B83E");
                    HomeActivity.this.DBPushUsers.child(FirebaseAuth.getInstance().getCurrentUser().getUid().concat("/LOGS/".concat(HomeActivity.this.logTempKey))).updateChildren(HomeActivity.this.logsMap);
                    HomeActivity.this.logsMap.clear();
                    bottomSheetDialog.dismiss();
                    HomeActivity.this.downloadURL = "null";
                    HomeActivity.this.isEditing = false;
                    HomeActivity.this.recyclerview1.setEnabled(true);
                    HomeActivity.this.fbInterstitial.show();
                    HomeActivity.this.fbInterstitial = new InterstitialAd((Context) HomeActivity.this, "278142536768563_320780439171439");
                    HomeActivity.this.fbInterstitial.loadAd();
                }
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.HomeActivity.46 */

            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.HomeActivity.47 */

            /* JADX WARN: Type inference failed for: r0v0, types: [android.content.Context, com.updatify.o2nation.HomeActivity] */
            /* JADX WARN: Type inference failed for: r0v2, types: [android.app.Activity, com.updatify.o2nation.HomeActivity] */
            /* JADX WARN: Type inference failed for: r0v3, types: [android.content.Context, com.updatify.o2nation.HomeActivity] */
            /* JADX WARNING: Unknown variable types count: 3 */
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission((Context) HomeActivity.this, "android.permission.READ_EXTERNAL_STORAGE") == -1 || ContextCompat.checkSelfPermission((Context) HomeActivity.this, "android.permission.WRITE_EXTERNAL_STORAGE") == -1) {
                    ActivityCompat.requestPermissions((Activity) HomeActivity.this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1001);
                    return;
                }
                HomeActivity homeActivity = HomeActivity.this;
                final ImageView imageView = imageView2;
                homeActivity.timer = new TimerTask() {
                    /* class com.updatify.o2nation.HomeActivity.47.1 */

                    public void run() {
                        HomeActivity homeActivity = HomeActivity.this;
                        homeActivity.runOnUiThread(new Runnable() {
                            /* class com.updatify.o2nation.HomeActivity.47.1.1 */

                            public void run() {
                                if (!HomeActivity.this.sharedPref.getString("picked_path", "").equals("") && !HomeActivity.this.sharedPref.getString("picked_path", "").equals("null")) {
                                    try {
                                        HomeActivity.this._setImageFromFile(imageView, HomeActivity.this.sharedPref.getString("picked_path", ""));
                                        HomeActivity.this.iconPath = HomeActivity.this.sharedPref.getString("picked_path", "");
                                        HomeActivity.this.isIconPicked = true;
                                        HomeActivity.this.imageName = FirebaseAuth.getInstance().getCurrentUser().getUid().concat(String.valueOf((long) SketchwareUtil.getRandom(0, 99999)));
                                        HomeActivity.this.sharedPref.edit().putString("picked_path", "null").commit();
                                    } catch (Exception e) {
                                    }
                                    HomeActivity.this.timer.cancel();
                                }
                            }
                        });
                    }
                };
                HomeActivity.this._timer.scheduleAtFixedRate(HomeActivity.this.timer, 0, 300);
                HomeActivity.this.topicker.setClass(HomeActivity.this.getApplicationContext(), PickerActivity.class);
                HomeActivity.this.topicker.putExtra("extension", ".png, .apng, .gif, .jpeg, .jpg");
                HomeActivity.this.startActivity(HomeActivity.this.topicker);
            }
        });
        bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(17170445);
        bottomSheetDialog.show();
    }

    public void _GetAppVersionInfo() {
        this.versionName = "null";
        try {
            this.versionName = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (Exception e) {
        }
    }

    public void _Logic_UI() {
        this.textview8.getPaint().setShader(new LinearGradient(0.0f, 0.0f, this.textview8.getPaint().measureText("Updatify"), this.textview8.getTextSize(), new int[]{Color.parseColor("#006FF2"), Color.parseColor("#00B6EF")}, (float[]) null, Shader.TileMode.CLAMP));
        _clicker(this.imageview1);
        _RippleEffects("#EEEEEE", this.imageview1);
        _clicker(this.imageview4);
        _RippleEffects("#EEEEEE", this.imageview4);
        this.textview3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
        this.textview8.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
        this.textview4.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
        this.uploading_txt_1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
        this.uploading_txt_2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
        this.emptyview_txt1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
        this.emptyview_txt2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
        _setToolTip(this.imageview1, "More options");
        _setToolTip(this.imageview4, "Notifications center");
        _setViewRadius(this.badgeview, 90.0d, "#F44336");
        _TranslationZ(this.badgeview, 1.0d);
        if (this.sharedPref.getString("dark", "").equals("true")) {
            this.background.setBackgroundColor(-15198184);
            this.ads_back.setBackgroundColor(-15198184);
            this.emptyview_txt1.setTextColor(-1);
            this.empty_notifications_title.setTextColor(-1);
            this.textview3.setTextColor(-1);
            this.uploading_txt_1.setTextColor(-1);
            this.rootview.setBackgroundColor(-1);
            _LIGHT_ICONS();
            _ICC(this.imageview1, "#FFFFFF", "#CCFFFFFF");
            _ICC(this.imageview4, "#FFFFFF", "#CCFFFFFF");
            _setViewRadius(this.linear12, 200.0d, "#212121");
            _ICC(this.imageview3, "#FFFFFF", "#ccFFFFFF");
            _rippleRoundStroke(this.linear5, "#212121", "#212121", 100.0d, 0.0d, "#0071EE");
            _rippleRoundStroke(this.linear4, "#181818", "#212121", 0.0d, 0.0d, "#0071EE");
            _rippleRoundStroke(this.uploading_view, "#181818", "#212121", 0.0d, 0.0d, "#0078FF");
            this.linear4.setOnTouchListener(new View.OnTouchListener() {
                /* class com.updatify.o2nation.HomeActivity.48 */

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case RequestNetworkController.REQUEST_PARAM:
                            HomeActivity.this._ICC(HomeActivity.this.imageview3, "#0071EE", "#CC0071EE");
                            HomeActivity.this._shadAnim(HomeActivity.this.imageview3, "rotation", 90.0d, 200.0d);
                            return false;
                        case RequestNetworkController.REQUEST_BODY:
                            HomeActivity.this._ICC(HomeActivity.this.imageview3, "#FFFFFF", "#ccFFFFFF");
                            HomeActivity.this._shadAnim(HomeActivity.this.imageview3, "rotation", 0.0d, 200.0d);
                            return false;
                        case 2:
                        default:
                            return false;
                        case 3:
                            HomeActivity.this._ICC(HomeActivity.this.imageview3, "#FFFFFF", "#ccFFFFFF");
                            HomeActivity.this._shadAnim(HomeActivity.this.imageview3, "rotation", 0.0d, 200.0d);
                            return false;
                    }
                }
            });
            _NavStatusBarColor("#181818", "#181818");
            _rippleRoundStroke(this.non_live_back, "#181818", "#424242", 90.0d, 1.0d, "#424242");
            this.textview9.setTextColor(-1118482);
            _ICC(this.imageview5, "#FFFFFF", "#ccFFFFFF");
        } else {
            this.rootview.setBackgroundColor(-15198184);
            _DARK_ICONS();
            _ICC(this.imageview1, "#616161", "#CC616161");
            _ICC(this.imageview4, "#616161", "#CC616161");
            _setViewRadius(this.linear12, 200.0d, "#F5F5F5");
            _ICC(this.imageview3, "#0071EE", "#cc0071EE");
            _rippleRoundStroke(this.linear5, "#F5F5F5", "#0071EE", 100.0d, 0.0d, "#0071EE");
            _rippleRoundStroke(this.linear4, "#FFFFFF", "#F5F5F5", 0.0d, 0.0d, "#0071EE");
            _rippleRoundStroke(this.uploading_view, "#FFFFFF", "#F5F5F5", 0.0d, 0.0d, "#0078FF");
            this.linear4.setOnTouchListener(new View.OnTouchListener() {
                /* class com.updatify.o2nation.HomeActivity.49 */

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case RequestNetworkController.REQUEST_PARAM:
                            HomeActivity.this._shadAnim(HomeActivity.this.imageview3, "rotation", 90.0d, 200.0d);
                            return false;
                        case RequestNetworkController.REQUEST_BODY:
                            HomeActivity.this._shadAnim(HomeActivity.this.imageview3, "rotation", 0.0d, 200.0d);
                            return false;
                        case 2:
                        default:
                            return false;
                        case 3:
                            HomeActivity.this._shadAnim(HomeActivity.this.imageview3, "rotation", 0.0d, 200.0d);
                            return false;
                    }
                }
            });
            _NavStatusBarColor("#FFFFFF", "#FFFFFF");
            _rippleRoundStroke(this.non_live_back, "#FFFFFF", "#BDBDBD", 90.0d, 1.0d, "#BDBDBD");
            this.textview9.setTextColor(-14606047);
            _ICC(this.imageview5, "#616161", "#CC616161");
        }
        _marqueeTextView(this.textview9, "");
    }

    public void _transitionViewTime(View view, double d) {
        AutoTransition autoTransition = new AutoTransition();
        autoTransition.setDuration((long) ((short) ((int) d)));
        TransitionManager.beginDelayedTransition((LinearLayout) view, autoTransition);
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

    public void _LIGHT_ICONS() {
        getWindow().getDecorView().setSystemUiVisibility(0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r19v0, resolved type: com.updatify.o2nation.HomeActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void _rateDialog() {
        final AlertDialog create = new AlertDialog.Builder(this).create();
        View inflate = getLayoutInflater().inflate(R.layout.notification, (ViewGroup) null);
        create.setView(inflate);
        create.getWindow().setBackgroundDrawableResource(17170445);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.background);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.lottieholder);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview1);
        TextView textView = (TextView) inflate.findViewById(R.id.cancel);
        TextView textView2 = (TextView) inflate.findViewById(R.id.textview1);
        TextView textView3 = (TextView) inflate.findViewById(R.id.okay);
        TextView textView4 = (TextView) inflate.findViewById(R.id.textview2);
        _rippleRoundStroke(textView3, "#078AFF", "#FFFFFF", 20.0d, 0.0d, "#078AFF");
        if (this.sharedPref.getString("dark", "").equals("true")) {
            textView2.setTextColor(-1);
            _setViewRadius(linearLayout, 40.0d, "#181818");
            _rippleRoundStroke(textView, "#424242", "#212121", 20.0d, 0.0d, "#078AFF");
            textView.setTextColor(-1);
        } else {
            _setViewRadius(linearLayout, 40.0d, "#FFFFFF");
            _rippleRoundStroke(textView, "#F5F5F5", "#BDBDBD", 20.0d, 0.0d, "#078AFF");
        }
        linearLayout2.setVisibility(View.INVISIBLE);
        imageView.setImageResource(R.drawable.winner_flatline);
        textView2.setText("Liking Updatify?");
        textView4.setText("Updatify needs your positive feedback on Play Store, it will not take more than 30secs, rate our app :)");
        textView3.setText("I love Updatify");
        textView2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_bold.ttf"), Typeface.NORMAL);
        textView4.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
        textView3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
        textView.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
        textView3.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.HomeActivity.50 */

            public void onClick(View view) {
                HomeActivity.this.tobrowser.setAction("android.intent.action.VIEW");
                HomeActivity.this.tobrowser.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.updatify.o2nation"));
                HomeActivity.this.startActivity(HomeActivity.this.tobrowser);
                HomeActivity.this.sharedPref.edit().putString("rateDialog1", "true").commit();
                create.dismiss();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.HomeActivity.51 */

            public void onClick(View view) {
                HomeActivity.this.sharedPref.edit().putString("rateDialog1", "true").commit();
                create.dismiss();
            }
        });
        create.setCancelable(false);
        create.show();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r18v0, resolved type: com.updatify.o2nation.HomeActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void _discountDialog() {
        final AlertDialog create = new AlertDialog.Builder(this).create();
        View inflate = getLayoutInflater().inflate(R.layout.notification, (ViewGroup) null);
        create.setView(inflate);
        create.getWindow().setBackgroundDrawableResource(17170445);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.background);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.lottieholder);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview1);
        TextView textView = (TextView) inflate.findViewById(R.id.cancel);
        TextView textView2 = (TextView) inflate.findViewById(R.id.textview1);
        TextView textView3 = (TextView) inflate.findViewById(R.id.okay);
        TextView textView4 = (TextView) inflate.findViewById(R.id.textview2);
        _rippleRoundStroke(textView3, "#078AFF", "#FFFFFF", 20.0d, 0.0d, "#078AFF");
        if (this.sharedPref.getString("dark", "").equals("true")) {
            textView2.setTextColor(-1);
            _setViewRadius(linearLayout, 40.0d, "#181818");
            _rippleRoundStroke(textView, "#424242", "#212121", 20.0d, 0.0d, "#078AFF");
            textView.setTextColor(-1);
        } else {
            _setViewRadius(linearLayout, 40.0d, "#FFFFFF");
            _rippleRoundStroke(textView, "#F5F5F5", "#BDBDBD", 20.0d, 0.0d, "#078AFF");
        }
        imageView.setImageResource(R.drawable.discount);
        textView2.setText("We've a super deal just for you");
        textView4.setText("At 50% discount, you can get 5 slots for a cheap price!\nGET IT NOW");
        textView3.setText("Buy now");
        textView2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_bold.ttf"), Typeface.NORMAL);
        textView4.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
        textView3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
        textView.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
        textView3.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.HomeActivity.52 */

            public void onClick(View view) {
                HomeActivity.this.sharedPref.edit().putString("discountDialog1", "true").commit();
                HomeActivity.this.tobrowser.setClass(HomeActivity.this.getApplicationContext(), BrowserActivity.class);
                HomeActivity.this.tobrowser.putExtra("url", "https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=5QNF32G85RDA4");
                HomeActivity.this.tobrowser.putExtra("mode", "pay");
                HomeActivity.this.startActivity(HomeActivity.this.tobrowser);
                create.dismiss();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.HomeActivity.53 */

            public void onClick(View view) {
                HomeActivity.this.sharedPref.edit().putString("discountDialog1", "true").commit();
                create.dismiss();
            }
        });
        create.setCancelable(false);
        create.show();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.updatify.o2nation.HomeActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void _adsManager() {
        AudienceNetworkAds.initialize(this);
        this.fbBanner = new AdView(this, "278142536768563_297676561481827", AdSize.BANNER_HEIGHT_50);
        this.ads_back.addView(this.fbBanner);
        this.fbBanner.loadAd();
        this.fbInterstitial = new InterstitialAd(this, "278142536768563_320780439171439");
        this.fbInterstitial.loadAd();
    }

    public void _changeUserReference() {
        this.userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        this.DBUsers = this._firebase.getReference("USERS2827IWUWIEHDN8273").child(this.userId);
        try {
            this.DBUsers.addValueEventListener(new ValueEventListener() {
                /* class com.updatify.o2nation.HomeActivity.54 */

                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (((String) dataSnapshot.child("account_status").getValue(String.class)).equals("false")) {
                        HomeActivity.this._bannedUserSheet();
                    } else if (((String) dataSnapshot.child("account_status").getValue(String.class)).equals("true")) {
                        HomeActivity.this.membership = (String) dataSnapshot.child("membership").getValue(String.class);
                        HomeActivity.this.availableSlots = Double.parseDouble((String) dataSnapshot.child("slots").getValue(String.class));
                        HomeActivity.this.MaxSlots = Double.parseDouble((String) dataSnapshot.child("maxSlots").getValue(String.class));
                        HomeActivity.this.textview4.setText(((String) dataSnapshot.child("slots").getValue(String.class)).concat("/".concat(((String) dataSnapshot.child("maxSlots").getValue(String.class)).concat(" Projects"))));
                    }
                }

                public void onCancelled(DatabaseError databaseError) {
                }
            });
        } catch (Exception e) {
            _Snackbar_API(e.toString(), "", "");
        }
    }

    public void _changeLogsReference() {
        this.userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        this.DBLogs = this._firebase.getReference("LOGSIEUDJFKSI8272827IDJD").child(this.userId).child("LOGS");
    }

    public void _marqueeTextView(TextView textView, String str) {
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setSelected(true);
        textView.setHorizontalFadingEdgeEnabled(true);
        textView.setFadingEdgeLength(20);
    }

    public void _setImageFromFile(ImageView imageView, String str) {
        Glide.with(getApplicationContext()).load(Uri.fromFile(new File(str))).circleCrop().into(imageView);
    }

    public void _setClippedView(View view, String str, double d, double d2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius((float) ((int) d));
        view.setBackground(gradientDrawable);
        view.setElevation((float) ((int) d2));
        view.setClipToOutline(true);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.updatify.o2nation.HomeActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void _viewPager() {
        this.viewPager = new ViewPager(this);
        this.viewPager.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.viewPager.setAdapter(new MyPagerAdapter(this, null));
        this.viewPager.setCurrentItem(0);
        OverScrollDecoratorHelper.setUpOverScroll(this.viewPager);
        this.base.addView(this.viewPager);
        this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class com.updatify.o2nation.HomeActivity.55 */

            public void onPageSelected(int i) {
                if (HomeActivity.this.viewPager.getCurrentItem() == 0) {
                    HomeActivity.this.imageview4.setImageResource(R.drawable.notification_48);
                    HomeActivity.this._setToolTip(HomeActivity.this.imageview4, "Notifications center");
                    HomeActivity.this._FadeOutInView(HomeActivity.this.textview8);
                    HomeActivity.this.waitToLoadProjects = new TimerTask() {
                        /* class com.updatify.o2nation.HomeActivity.55.1 */

                        public void run() {
                            HomeActivity.this.runOnUiThread(new Runnable() {
                                /* class com.updatify.o2nation.HomeActivity.55.1.1 */

                                public void run() {
                                    HomeActivity.this.textview8.setText("Updatify");
                                    HomeActivity.this._ViewFadeIn(HomeActivity.this.textview8, 200.0d);
                                }
                            });
                        }
                    };
                    HomeActivity.this._timer.schedule(HomeActivity.this.waitToLoadProjects, 200);
                } else if (HomeActivity.this.viewPager.getCurrentItem() == 1) {
                    HomeActivity.this.imageview4.setImageResource(R.drawable.home_48);
                    HomeActivity.this._setToolTip(HomeActivity.this.imageview4, "Home");
                    if (HomeActivity.this.notificationsList.size() != 0) {
                        HomeActivity.this.sharedPref.edit().putString("notificationCenterContent", HomeActivity.this.notificationCenterContent).commit();
                        HomeActivity.this.badgeview.setVisibility(View.GONE);
                    }
                    HomeActivity.this._FadeOutInView(HomeActivity.this.textview8);
                    HomeActivity.this.waitToLoadProjects = new TimerTask() {
                        /* class com.updatify.o2nation.HomeActivity.55.2 */

                        public void run() {
                            HomeActivity.this.runOnUiThread(new Runnable() {
                                /* class com.updatify.o2nation.HomeActivity.55.2.1 */

                                public void run() {
                                    HomeActivity.this.textview8.setText("Notifications center");
                                    HomeActivity.this._ViewFadeIn(HomeActivity.this.textview8, 200.0d);
                                }
                            });
                        }
                    };
                    HomeActivity.this._timer.schedule(HomeActivity.this.waitToLoadProjects, 200);
                }
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageScrollStateChanged(int i) {
            }
        });
    }

    private void foo() {
    }

    public void _TranslationZ(View view, double d) {
        view.setTranslationZ((float) ((int) d));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.updatify.o2nation.HomeActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void _LOGIC_BACKEND() {
        this.swiperefreshlayout1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            /* class com.updatify.o2nation.HomeActivity.56 */

            public void onRefresh() {
                HomeActivity.this.checkNetwork.startRequestNetwork(RequestNetworkController.GET, "https://nerbly.com/updatify/notifications/notifications/noti_center.json", "GET_NOTIFICATIONS", HomeActivity.this._checkNetwork_request_listener);
            }
        });
        _adsManager();
        this.uploading_view.setVisibility(View.GONE);
        this.imageview4.setVisibility(View.GONE);
        this.badgeview.setVisibility(View.GONE);
        FirebaseUser currentUser = this.mAuth.getCurrentUser();
        this.userImg = currentUser.getPhotoUrl().toString();
        this.username = currentUser.getDisplayName();
        this.iconPath = "null";
        this.adsNum = 1.0d;
        this.downloadURL = "null";
        this.isIconPicked = false;
        _viewPager();
        this.recyclerview1.setHasFixedSize(true);
        this.recyclerview1.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerview2.setHasFixedSize(true);
        this.recyclerview2.setLayoutManager(new LinearLayoutManager(this));
        if (!this.sharedPref.getString("logged", "").equals("1")) {
            this.sharedPref.edit().putString("logged", "1").commit();
        } else if (!this.sharedPref.getString("logged", "").equals("2")) {
            this.sharedPref.edit().putString("logged", "2").commit();
        } else if (this.sharedPref.getString("logged", "").equals("3")) {
            this.sharedPref.edit().putString("logged", "0").commit();
        } else {
            this.sharedPref.edit().putString("logged", "3").commit();
        }
    }

    public void _ViewFadeIn(View view, double d) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration((long) d);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        view.startAnimation(animationSet);
    }

    public void _FadeOutInView(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        view.startAnimation(alphaAnimation2);
        alphaAnimation.setDuration(300);
        alphaAnimation.setFillAfter(true);
        alphaAnimation2.setDuration(300);
        alphaAnimation2.setFillAfter(true);
        alphaAnimation2.setStartOffset(10 + alphaAnimation.getStartOffset());
    }

    public void _setClippedStrokeView(View view, String str, double d, String str2, double d2, double d3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius((float) ((int) d));
        gradientDrawable.setStroke((int) d2, Color.parseColor("#" + str2.replace("#", "")));
        view.setBackground(gradientDrawable);
        view.setElevation((float) ((int) d3));
        view.setClipToOutline(true);
    }

    public void _Linkify(TextView textView, String str) {
        textView.setClickable(true);
        Linkify.addLinks(textView, Linkify.MAP_ADDRESSES);
        textView.setLinkTextColor(Color.parseColor("#" + str.replace("#", "")));
        textView.setLinksClickable(true);
    }

    public void _changeProjectsReference() {
        this.userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        this.DBUserProjects.removeEventListener(this._DBUserProjects_child_listener);
        this.DBUserProjects = this._firebase.getReference("USERS2827IWUWIEHDN8273").child(this.userId).child("PROJECTS");
        this.DBUserProjects.addChildEventListener(this._DBUserProjects_child_listener);
        this.DBUserProjects.addListenerForSingleValueEvent(new ValueEventListener() {
            /* class com.updatify.o2nation.HomeActivity.57 */

            public void onDataChange(DataSnapshot dataSnapshot) {
                HomeActivity.this.projectsList = new ArrayList();
                try {
                    GenericTypeIndicator<HashMap<String, Object>> r1 = new GenericTypeIndicator<HashMap<String, Object>>() {
                        /* class com.updatify.o2nation.HomeActivity.57.1 */
                    };
                    for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                        HomeActivity.this.projectsList.add((HashMap) dataSnapshot2.getValue(r1));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (HomeActivity.this.projectsList.size() == 0) {
                    HomeActivity.this.empty_base.setVisibility(View.VISIBLE);
                    HomeActivity.this.recyclerview1.setVisibility(View.GONE);
                    HomeActivity.this.emptyview_img.setImageResource(R.drawable.dream_flatline);
                    HomeActivity.this.emptyview_txt1.setText("You have no projects yet");
                    HomeActivity.this.emptyview_txt2.setText("Click on \"Add new project\" above to connect your app with Updatify.");
                } else {
                    HomeActivity.this.empty_base.setVisibility(View.GONE);
                    HomeActivity.this.recyclerview1.setVisibility(View.VISIBLE);
                    HomeActivity.this.recyclerview1.setAdapter(new Recyclerview1Adapter(HomeActivity.this.projectsList));
                }
                HomeActivity.this.sharedPref.edit().putString(FirebaseAuth.getInstance().getCurrentUser().getUid().concat("_userProjects"), new Gson().toJson(HomeActivity.this.projectsList)).commit();
            }

            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    /* JADX DEBUG: Multi-variable search result rejected for r14v0, resolved type: com.updatify.o2nation.HomeActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void _bannedUserSheet() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View inflate = getLayoutInflater().inflate(R.layout.info_sheet, (ViewGroup) null);
        bottomSheetDialog.setContentView(inflate);
        bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(17170445);
        TextView textView = (TextView) inflate.findViewById(R.id.infosheet_ok);
        TextView textView2 = (TextView) inflate.findViewById(R.id.infosheet_cancel);
        TextView textView3 = (TextView) inflate.findViewById(R.id.infosheet_title);
        TextView textView4 = (TextView) inflate.findViewById(R.id.infosheet_sub);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.infosheet_back);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.infosheet_btn_holder);
        textView3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
        textView4.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
        textView.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
        textView2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
        ((ImageView) inflate.findViewById(R.id.infosheet_img)).setImageResource(R.drawable.explosion_flatline);
        textView.setText("Exit Updatify");
        textView2.setText("Submit review request");
        textView3.setText("Your account is suspended");
        textView4.setText("Your account was suspended for violating our terms of service. If you think that we've made this decision by mistake, send us a review request.");
        _rippleRoundStroke(textView, "#006DF6", "#16FFFFFF", 25.0d, 0.0d, "#006DF6");
        if (this.sharedPref.getString("dark", "").equals("true")) {
            textView2.setTextColor(-1);
            _rippleRoundStroke(textView2, "#424242", "#212121", 25.0d, 0.0d, "#006DF6");
            _setViewRadius(linearLayout, 25.0d, "#181818");
        } else {
            _setViewRadius(linearLayout, 25.0d, "#FFFFFF");
            _rippleRoundStroke(textView2, "#F5F5F5", "#E0E0E0", 25.0d, 0.0d, "#006DF6");
        }
        textView.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.HomeActivity.58 */

            public void onClick(View view) {
                HomeActivity.this.finish();
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.HomeActivity.59 */

            public void onClick(View view) {
                HomeActivity.this.tobrowser.setAction("android.intent.action.VIEW");
                HomeActivity.this.tobrowser.setData(Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSdtF9uaKugdLOOR5a4pVUBlWH8oaC1MzOItUgueiGk1yKT0pg/viewform"));
                HomeActivity.this.startActivity(HomeActivity.this.tobrowser);
                HomeActivity.this.finish();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.show();
    }

    public void _textAnimation(HTextView hTextView, String str) {
        hTextView.setAnimateType(HTextViewType.EVAPORATE);
        hTextView.animateText(str);
    }

    class AdapterVP extends PagerAdapter {
        ArrayList<HashMap<String, Object>> _list;
        private LayoutInflater layoutInflater;

        public AdapterVP(ArrayList<HashMap<String, Object>> arrayList) {
            this._list = arrayList;
        }

        public int getCount() {
            return this._list.size();
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        public Object instantiateItem(ViewGroup viewGroup, final int i) {
            this.layoutInflater = LayoutInflater.from(viewGroup.getContext());
            View inflate = this.layoutInflater.inflate(R.layout.banner, viewGroup, false);
            TextView textView = (TextView) inflate.findViewById(R.id.ads_txt);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.ads_back);
            textView.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
            Glide.with(HomeActivity.this.getApplicationContext()).load(Uri.parse(this._list.get(i).get("image").toString())).into((ImageView) inflate.findViewById(R.id.ads_img));
            textView.setText(this._list.get(i).get("title").toString());
            HomeActivity.this._addCardView(linearLayout, 0.0d, 20.0d, 0.0d, 0.0d, true, "#FFFFFF");
            linearLayout.setOnClickListener(new View.OnClickListener() {
                /* class com.updatify.o2nation.HomeActivity.AdapterVP.1 */

                public void onClick(View view) {
                    if (!AdapterVP.this._list.get(i).get("link").toString().equals("null")) {
                        HomeActivity.this.tobrowser.setAction("android.intent.action.VIEW");
                        HomeActivity.this.tobrowser.setData(Uri.parse(AdapterVP.this._list.get(i).get("link").toString()));
                        HomeActivity.this.startActivity(HomeActivity.this.tobrowser);
                    }
                }
            });
            viewGroup.addView(inflate, 0);
            return inflate;
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }
    }

    private class MyPagerAdapter extends PagerAdapter {
        private MyPagerAdapter() {
        }

        /* synthetic */ MyPagerAdapter(HomeActivity homeActivity, MyPagerAdapter myPagerAdapter) {
            this();
        }

        public int getCount() {
            return 2;
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View inflate = ((LayoutInflater) HomeActivity.this.getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE)).inflate(R.layout.empty, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear1);
            if (i == 0) {
                ViewGroup viewGroup2 = (ViewGroup) HomeActivity.this.layout1.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(HomeActivity.this.layout1);
                }
                linearLayout.addView(HomeActivity.this.layout1);
            } else if (i == 1) {
                ViewGroup viewGroup3 = (ViewGroup) HomeActivity.this.layout2.getParent();
                if (viewGroup3 != null) {
                    viewGroup3.removeView(HomeActivity.this.layout2);
                }
                linearLayout.addView(HomeActivity.this.layout2);
            }
            viewGroup.addView(inflate, 0);
            return inflate;
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
            HomeActivity.this.trash.addView((View) obj);
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == ((View) obj);
        }

        public Parcelable saveState() {
            return null;
        }
    }

    public class Recyclerview1Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        ArrayList<HashMap<String, Object>> _data;

        public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> arrayList) {
            this._data = arrayList;
        }

        public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            onBindViewHolder((ViewHolder) viewHolder, i);
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(((LayoutInflater) HomeActivity.this.getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE)).inflate(R.layout.apps_base, (ViewGroup) null));
        }

        public void onBindViewHolder(ViewHolder viewHolder, final int i) {
            View view = viewHolder.itemView;
            final LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linear6);
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.linear1);
            final LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.deletion_view);
            LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.pointer);
            LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.linear3);
            LinearLayout linearLayout6 = (LinearLayout) view.findViewById(R.id.linear5);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageview2);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.icon);
            LinearLayout linearLayout7 = (LinearLayout) view.findViewById(R.id.flow);
            TextView textView = (TextView) view.findViewById(R.id.version_name);
            final TextView textView2 = (TextView) view.findViewById(R.id.title);
            TextView textView3 = (TextView) view.findViewById(R.id.description);
            view.findViewById(R.id.lottie1);
            view.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            try {
                linearLayout3.setVisibility(View.GONE);
                HomeActivity.this._setToolTip(imageView, "More project options");
                textView2.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
                textView3.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
                textView.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_bold.ttf"), Typeface.NORMAL);
                HomeActivity.this._RoundAndBorder(linearLayout7, "#48000000", 0.0d, "#000000", 100.0d);
                try {
                    HomeActivity.this._advancedCorners(linearLayout4, ((HashMap) HomeActivity.this.projectsList.get(i)).get("color").toString(), 0.0d, 50.0d, 0.0d, 50.0d);
                    textView2.setText(((HashMap) HomeActivity.this.projectsList.get(i)).get("appname").toString());
                    textView3.setText(((HashMap) HomeActivity.this.projectsList.get(i)).get("status").toString());
                    textView.setText(((HashMap) HomeActivity.this.projectsList.get(i)).get("currVersion").toString());
                    if (HomeActivity.this.sharedPref.getString("dark", "").equals("true")) {
                        HomeActivity.this._ICC(imageView, "#FFFFFF", "#FFFFFF");
                        textView2.setTextColor(-1);
                        HomeActivity.this._rippleRoundStroke(linearLayout2, "#181818", "#212121", 0.0d, 0.0d, "#0078FF");
                    } else {
                        HomeActivity.this._ICC(imageView, "#616161", "#616161");
                        HomeActivity.this._rippleRoundStroke(linearLayout2, "#FFFFFF", "#F5F5F5", 0.0d, 0.0d, "#0078FF");
                    }
                    if (!((HashMap) HomeActivity.this.projectsList.get(i)).get("appicon").toString().equals("null")) {
                        HomeActivity.this._setCircleImageURL(imageView2, ((HashMap) HomeActivity.this.projectsList.get(i)).get("appicon").toString(), 0.0d, "#000000");
                    }
                    linearLayout2.setOnClickListener(new View.OnClickListener() {
                        /* class com.updatify.o2nation.HomeActivity.Recyclerview1Adapter.1 */

                        public void onClick(View view) {
                            HomeActivity.this.toUpdate.putExtra("title", ((HashMap) HomeActivity.this.projectsList.get(i)).get("appname").toString());
                            HomeActivity.this.toUpdate.putExtra("key", ((HashMap) HomeActivity.this.projectsList.get(i)).get("key").toString());
                            HomeActivity.this.toUpdate.putExtra("icon", ((HashMap) HomeActivity.this.projectsList.get(i)).get("appicon").toString());
                            HomeActivity.this.toUpdate.putExtra("api", ((HashMap) HomeActivity.this.projectsList.get(i)).get("api").toString());
                            HomeActivity.this.toUpdate.putExtra("slots", String.valueOf((long) HomeActivity.this.availableSlots));
                            HomeActivity.this.toUpdate.putExtra("filename", ((HashMap) HomeActivity.this.projectsList.get(i)).get("filename").toString());
                            HomeActivity.this.toUpdate.putExtra("currVersion", ((HashMap) HomeActivity.this.projectsList.get(i)).get("currVersion").toString());
                            HomeActivity.this.toUpdate.setClass(HomeActivity.this.getApplicationContext(), UpdaterActivity.class);
                            HomeActivity.this._ActivityTranlation(textView2, "title", HomeActivity.this.toUpdate);
                        }
                    });
                    imageView.setOnClickListener(new View.OnClickListener() {
                        /* class com.updatify.o2nation.HomeActivity.Recyclerview1Adapter.2 */

                        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, com.updatify.o2nation.HomeActivity] */
                        /* JADX WARNING: Unknown variable types count: 1 */
                        public void onClick(View view) {
                            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog((Context) HomeActivity.this);
                            View inflate = HomeActivity.this.getLayoutInflater().inflate(R.layout.options_sheet, (ViewGroup) null);
                            bottomSheetDialog.setContentView(inflate);
                            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.background);
                            LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.line);
                            LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(R.id.linear7);
                            LinearLayout linearLayout4 = (LinearLayout) inflate.findViewById(R.id.linear12);
                            TextView textView = (TextView) inflate.findViewById(R.id.item2);
                            LinearLayout linearLayout5 = (LinearLayout) inflate.findViewById(R.id.linear9);
                            LinearLayout linearLayout6 = (LinearLayout) inflate.findViewById(R.id.linear10);
                            TextView textView2 = (TextView) inflate.findViewById(R.id.title);
                            TextView textView3 = (TextView) inflate.findViewById(R.id.item4);
                            ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview1);
                            TextView textView4 = (TextView) inflate.findViewById(R.id.description);
                            TextView textView5 = (TextView) inflate.findViewById(R.id.item3);
                            TextView textView6 = (TextView) inflate.findViewById(R.id.item1);
                            TextView textView7 = (TextView) inflate.findViewById(R.id.button);
                            textView2.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_bold.ttf"), Typeface.NORMAL);
                            textView4.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
                            textView7.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
                            textView6.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
                            textView.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
                            textView3.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
                            textView5.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
                            textView2.setText(((HashMap) HomeActivity.this.projectsList.get(i)).get("appname").toString());
                            textView4.setText(((HashMap) HomeActivity.this.projectsList.get(i)).get("currVersion").toString());
                            HomeActivity.this._ICC((ImageView) inflate.findViewById(R.id.item44), "#DF2029", "#ccDF2029");
                            HomeActivity.this._ICC((ImageView) inflate.findViewById(R.id.item11), "#0084FF", "#CC0084FF");
                            HomeActivity.this._ICC((ImageView) inflate.findViewById(R.id.item33), "#09B83E", "#cc09B83E");
                            HomeActivity.this._ICC((ImageView) inflate.findViewById(R.id.item22), "#F57D00", "#ccF57D00");
                            HomeActivity.this._RoundAndBorder((LinearLayout) inflate.findViewById(R.id.scroller), "#CCFFFFFF", 0.0d, "#FFFFFF", 100.0d);
                            HomeActivity.this._setCircleImageURL(imageView, ((HashMap) HomeActivity.this.projectsList.get(i)).get("appicon").toString(), 0.0d, "#00000000");
                            if (!HomeActivity.this.isServerLive) {
                                linearLayout4.setVisibility(View.GONE);
                                linearLayout6.setVisibility(View.GONE);
                            }
                            if (HomeActivity.this.sharedPref.getString("dark", "").equals("true")) {
                                textView2.setTextColor(-1);
                                textView6.setTextColor(-1);
                                textView3.setTextColor(-1);
                                textView5.setTextColor(-1);
                                textView.setTextColor(-1);
                                linearLayout2.setBackgroundColor(-12434878);
                                textView7.setTextColor(-1118482);
                                HomeActivity.this._advancedCorners(linearLayout, "#181818", 25.0d, 25.0d, 25.0d, 25.0d);
                                HomeActivity.this._rippleRoundStroke(textView7, "#181818", "#E0E0E0", 100.0d, 2.0d, "#424242");
                                HomeActivity.this._rippleRoundStroke(linearLayout3, "#181818", "#212121", 0.0d, 0.0d, "#E0E0E0");
                                HomeActivity.this._rippleRoundStroke(linearLayout4, "#181818", "#212121", 0.0d, 0.0d, "#E0E0E0");
                                HomeActivity.this._rippleRoundStroke(linearLayout5, "#181818", "#212121", 0.0d, 0.0d, "#E0E0E0");
                                HomeActivity.this._rippleRoundStroke(linearLayout6, "#181818", "#212121", 0.0d, 0.0d, "#E0E0E0");
                            } else {
                                HomeActivity.this._advancedCorners(linearLayout, "#FFFFFF", 25.0d, 25.0d, 25.0d, 25.0d);
                                HomeActivity.this._rippleRoundStroke(textView7, "#FFFFFF", "#F5F5F5", 100.0d, 2.0d, "#E0E0E0");
                                HomeActivity.this._rippleRoundStroke(linearLayout3, "#FFFFFF", "#F5F5F5", 0.0d, 0.0d, "#E0E0E0");
                                HomeActivity.this._rippleRoundStroke(linearLayout4, "#FFFFFF", "#F5F5F5", 0.0d, 0.0d, "#E0E0E0");
                                HomeActivity.this._rippleRoundStroke(linearLayout5, "#FFFFFF", "#F5F5F5", 0.0d, 0.0d, "#E0E0E0");
                                HomeActivity.this._rippleRoundStroke(linearLayout6, "#FFFFFF", "#F5F5F5", 0.0d, 0.0d, "#E0E0E0");
                            }
                            final TextView textView8 = textView2;
                            linearLayout3.setOnClickListener(new View.OnClickListener() {
                                /* class com.updatify.o2nation.HomeActivity.Recyclerview1Adapter.2.1 */

                                public void onClick(View view) {
                                    HomeActivity.this.toUpdate.putExtra("title", ((HashMap) HomeActivity.this.projectsList.get(i)).get("appname").toString());
                                    HomeActivity.this.toUpdate.putExtra("key", ((HashMap) HomeActivity.this.projectsList.get(i)).get("key").toString());
                                    HomeActivity.this.toUpdate.putExtra("icon", ((HashMap) HomeActivity.this.projectsList.get(i)).get("appicon").toString());
                                    HomeActivity.this.toUpdate.putExtra("api", ((HashMap) HomeActivity.this.projectsList.get(i)).get("api").toString());
                                    HomeActivity.this.toUpdate.putExtra("slots", String.valueOf((long) HomeActivity.this.availableSlots));
                                    HomeActivity.this.toUpdate.putExtra("filename", ((HashMap) HomeActivity.this.projectsList.get(i)).get("filename").toString());
                                    HomeActivity.this.toUpdate.putExtra("currVersion", ((HashMap) HomeActivity.this.projectsList.get(i)).get("currVersion").toString());
                                    HomeActivity.this.toUpdate.setClass(HomeActivity.this.getApplicationContext(), UpdaterActivity.class);
                                    HomeActivity.this._ActivityTranlation(textView8, "title", HomeActivity.this.toUpdate);
                                    bottomSheetDialog.dismiss();
                                }
                            });
                            final int i2 = i;
                            linearLayout4.setOnClickListener(new View.OnClickListener() {
                                /* class com.updatify.o2nation.HomeActivity.Recyclerview1Adapter.2.2 */

                                public void onClick(View view) {
                                    HomeActivity.this.isIconPicked = false;
                                    HomeActivity.this._editProject(((HashMap) HomeActivity.this.projectsList.get(i2)).get("key").toString(), ((HashMap) HomeActivity.this.projectsList.get(i2)).get("appicon").toString(), ((HashMap) HomeActivity.this.projectsList.get(i2)).get("appname").toString());
                                    bottomSheetDialog.dismiss();
                                }
                            });
                            final int i3 = i;
                            linearLayout5.setOnClickListener(new View.OnClickListener() {
                                /* class com.updatify.o2nation.HomeActivity.Recyclerview1Adapter.2.3 */

                                public void onClick(View view) {
                                    HomeActivity homeActivity = HomeActivity.this;
                                    HomeActivity.this.getApplicationContext();
                                    ((ClipboardManager) homeActivity.getSystemService(CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", ((HashMap) HomeActivity.this.projectsList.get(i3)).get("api").toString()));
                                    HomeActivity.this._Snackbar_API("API link copied", "", "long");
                                    bottomSheetDialog.dismiss();
                                }
                            });
                            textView7.setOnClickListener(new View.OnClickListener() {
                                /* class com.updatify.o2nation.HomeActivity.Recyclerview1Adapter.2.4 */

                                public void onClick(View view) {
                                    bottomSheetDialog.dismiss();
                                }
                            });
                            final LinearLayout linearLayout7 = linearLayout;
                            final LinearLayout linearLayout8 = linearLayout3;
                            final int i4 = i;
                            linearLayout6.setOnClickListener(new View.OnClickListener() {
                                /* class com.updatify.o2nation.HomeActivity.Recyclerview1Adapter.2.5 */

                                /* JADX WARN: Type inference failed for: r1v3, types: [android.content.Context, com.updatify.o2nation.HomeActivity] */
                                /* JADX WARNING: Unknown variable types count: 1 */
                                public void onClick(View view) {
                                    HomeActivity.this._transitionViewTime(linearLayout7, 300.0d);
                                    linearLayout8.setVisibility(View.VISIBLE);
                                    HomeActivity.this.count = 10.0d;
                                    final AlertDialog create = new AlertDialog.Builder(HomeActivity.this).create();
                                    View inflate = HomeActivity.this.getLayoutInflater().inflate(R.layout.counter, (ViewGroup) null);
                                    create.setView(inflate);
                                    create.getWindow().setBackgroundDrawableResource(0x106000d);
                                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear1);
                                    final View view2 = (HTextView) inflate.findViewById(R.id.textview1);
                                    TextView textView = (TextView) inflate.findViewById(R.id.textview3);
                                    ((TextView) view2).setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_bold.ttf"), Typeface.NORMAL);
                                    ((TextView) inflate.findViewById(R.id.textview2)).setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/googlesans.ttf"), Typeface.NORMAL);
                                    textView.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
                                    textView.setText("Your project ".concat(((HashMap) HomeActivity.this.projectsList.get(i4)).get("appname").toString().concat(" data will be deleted soon including api link and cannot be recovered!")));
                                    HomeActivity.this._RoundAndBorder(view2, "#FF0070EE", 0.0d, "#FF0070EE", 100.0d);
                                    HomeActivity homeActivity = HomeActivity.this;
                                    final int i = i4;
                                    homeActivity.delete = new TimerTask() {
                                        /* class com.updatify.o2nation.HomeActivity.Recyclerview1Adapter.2.5.1 */

                                        public void run() {
                                            HomeActivity homeActivity = HomeActivity.this;
                                            final HTextView hTextView = (HTextView) view2;
                                            final AlertDialog alertDialog = create;
                                            /* class com.updatify.o2nation.HomeActivity.Recyclerview1Adapter.2.5.1.1 */
                                            homeActivity.runOnUiThread(() -> {
                                                HomeActivity.this.count -= 1.0d;
                                                HomeActivity.this._textAnimation(hTextView, String.valueOf((long) HomeActivity.this.count));
                                                if (HomeActivity.this.count == 0.0d) {
                                                    HomeActivity.this._Snackbar_API(((HashMap) HomeActivity.this.projectsList.get(i)).get("appname").toString().concat(" is being deleted..."), "", "");
                                                    HomeActivity.this.delete.cancel();
                                                    HomeActivity.this.deleteFileName = ((HashMap) HomeActivity.this.projectsList.get(i)).get("filename").toString();
                                                    if (((HashMap) HomeActivity.this.projectsList.get(i)).get("appicon").toString().equals("https://nerbly.com/updatify/media/icon.jpg") || ((HashMap) HomeActivity.this.projectsList.get(i)).get("appicon").toString().equals("https://i.imgur.com/zo5aja9.jpg")) {
                                                        HomeActivity.this.deleteAppIcon = "null";
                                                    } else {
                                                        HomeActivity.this.deleteAppIcon = ((HashMap) HomeActivity.this.projectsList.get(i)).get("appicon").toString();
                                                    }
                                                    HomeActivity.this.deleteAppKey = ((HashMap) HomeActivity.this.projectsList.get(i)).get("key").toString();
                                                    HomeActivity.this.deleteAppName = ((HashMap) HomeActivity.this.projectsList.get(i)).get("appname").toString();
                                                    HomeActivity.this.checkNetwork.startRequestNetwork(RequestNetworkController.GET, "https://google.com", "delete", HomeActivity.this._checkNetwork_request_listener);
                                                    HomeActivity.this._updatifyCore(true, "#FFFFFF", 100.0d, "#FFFFFF", 0.0d);
                                                    alertDialog.dismiss();
                                                }
                                            });
                                        }
                                    };
                                    HomeActivity.this._timer.scheduleAtFixedRate(HomeActivity.this.delete, 0, 1000);
                                    final LinearLayout linearLayout2 = linearLayout7;
                                    final LinearLayout linearLayout3 = linearLayout8;
                                    linearLayout.setOnClickListener(new View.OnClickListener() {
                                        /* class com.updatify.o2nation.HomeActivity.Recyclerview1Adapter.2.5.2 */

                                        public void onClick(View view) {
                                            HomeActivity.this.delete.cancel();
                                            HomeActivity.this._transitionViewTime(linearLayout2, 300.0d);
                                            linearLayout3.setVisibility(View.GONE);
                                            create.dismiss();
                                        }
                                    });
                                    create.setCancelable(false);
                                    create.show();
                                    bottomSheetDialog.dismiss();
                                }
                            });
                            bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(0x106000d);
                            bottomSheetDialog.show();
                        }
                    });
                    HomeActivity.this._RippleEffects("#9e9e9e", imageView);
                    HomeActivity.this._rippleRoundStroke(linearLayout3, "#4DF44336", "#66F44336", 0.0d, 0.0d, "#F44336");
                    linearLayout3.setOnClickListener(new View.OnClickListener() {
                        /* class com.updatify.o2nation.HomeActivity.Recyclerview1Adapter.3 */

                        public void onClick(View view) {
                            HomeActivity.this._Snackbar_API("This project is being deleted or already deleted", "", "");
                        }
                    });
                } catch (Exception ignored) {
                }
            } catch (Exception e2) {
                SketchwareUtil.showMessage(HomeActivity.this.getApplicationContext(), e2.toString());
            }
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

    public class Recyclerview2Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        ArrayList<HashMap<String, Object>> _data;

        public Recyclerview2Adapter(ArrayList<HashMap<String, Object>> arrayList) {
            this._data = arrayList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(((LayoutInflater) HomeActivity.this.getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE)).inflate(R.layout.notifications_center, (ViewGroup) null));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
            View view = viewHolder.itemView;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.line);
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.background);
            LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.cardview_holder);
            TextView textView = (TextView) view.findViewById(R.id.type_tv);
            TextView textView2 = (TextView) view.findViewById(R.id.title_tv);
            TextView textView3 = (TextView) view.findViewById(R.id.description_tv);
            LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.date_button_holder);
            ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressbar1);
            ImageView imageView = (ImageView) view.findViewById(R.id.thumbnail_tv);
            TextView textView4 = (TextView) view.findViewById(R.id.date_tv);
            TextView textView5 = (TextView) view.findViewById(R.id.button_tv);
            view.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            try {
                textView2.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product.ttf"), Typeface.NORMAL);
                textView3.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
                textView4.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product.ttf"), Typeface.NORMAL);
                textView5.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product.ttf"), Typeface.NORMAL);
                textView.setTypeface(Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/product.ttf"), Typeface.NORMAL);
                HomeActivity.this._RoundAndBorder(textView, this._data.get(i).get("typeColor").toString(), 0.0d, "#D50000", 100.0d);
                textView.setText(this._data.get(i).get("type").toString());
                textView2.setText(this._data.get(i).get("title").toString());
                textView3.setText(this._data.get(i).get("subtitle").toString());
                textView4.setText(this._data.get(i).get("date").toString());
                if (this._data.get(i).get("isImgOn").toString().equals("true")) {
                    Glide.with(HomeActivity.this.getApplicationContext()).load(Uri.parse(this._data.get(i).get("imgLink").toString())).into(imageView);
                    linearLayout3.setVisibility(View.VISIBLE);
                } else {
                    linearLayout3.setVisibility(View.GONE);
                }
                if (HomeActivity.this.sharedPref.getString("dark", "").equals("true")) {
                    textView2.setTextColor(-1);
                    linearLayout.setBackgroundColor(-12434878);
                    textView3.setTextColor(-4342339);
                    HomeActivity.this._rippleRoundStroke(textView5, "#181818", "#F5F5F5", 25.0d, 0.0d, "#FFFFFF");
                    HomeActivity.this._setClippedStrokeView(linearLayout3, "#181818", 20.0d, "#424242", 1.0d, 0.0d);
                } else {
                    textView2.setTextColor(-16777216);
                    textView3.setTextColor(-9079435);
                    linearLayout.setBackgroundColor(-1118482);
                    HomeActivity.this._rippleRoundStroke(textView5, "#FFFFFF", "#F5F5F5", 25.0d, 0.0d, "#FFFFFF");
                    HomeActivity.this._setClippedStrokeView(linearLayout3, "#FFFFFF", 20.0d, "#EEEEEE", 1.0d, 7.0d);
                }
                textView5.setText(this._data.get(i).get("buttonText").toString());
                textView5.setOnClickListener(new View.OnClickListener() {
                    /* class com.updatify.o2nation.HomeActivity.Recyclerview2Adapter.1 */

                    public void onClick(View view) {
                        HomeActivity.this.tobrowser.setAction("android.intent.action.VIEW");
                        HomeActivity.this.tobrowser.setData(Uri.parse(Recyclerview2Adapter.this._data.get(i).get("buttonURL").toString()));
                        HomeActivity.this.startActivity(HomeActivity.this.tobrowser);
                    }
                });
                if (this._data.get(i).get("isBtnOn").toString().equals("true")) {
                    textView5.setVisibility(View.VISIBLE);
                } else {
                    textView5.setVisibility(View.GONE);
                }
                HomeActivity.this._Linkify(textView3, "#006DF6");
            } catch (Exception e) {
                SketchwareUtil.showMessage(HomeActivity.this.getApplicationContext(), e.toString());
            }
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
