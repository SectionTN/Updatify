package com.updatify.o2nation;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.github.florent37.viewtooltip.ViewTooltip;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerFullScreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

public class ProfileActivity extends AppCompatActivity {
    View _inflate;
    Snackbar.SnackbarLayout _sblayout;
    Snackbar _snackBarView;
    private ChildEventListener _DBUsers_child_listener;
    private OnCompleteListener<AuthResult> _auth_create_user_listener;
    private OnCompleteListener<Void> _auth_reset_password_listener;
    private OnCompleteListener<AuthResult> _auth_sign_in_listener;
    private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
    private DatabaseReference DBUsers = this._firebase.getReference("USERS2827IWUWIEHDN8273");
    private OnCompleteListener<AuthResult> _mAuth_create_user_listener;
    private OnCompleteListener<Void> _mAuth_reset_password_listener;
    private OnCompleteListener<AuthResult> _mAuth_sign_in_listener;
    private RequestNetwork.RequestListener _requestMoreblock_request_listener;
    private Timer _timer = new Timer();
    private LinearLayout ads_back;
    private FirebaseAuth auth;
    private HashMap<String, Object> authMap = new HashMap<>();
    private OnCompleteListener<Void> auth_deleteUserListener;
    private OnCompleteListener<Void> auth_emailVerificationSentListener;
    private OnCompleteListener<AuthResult> auth_googleSignInListener;
    private OnCompleteListener<AuthResult> auth_phoneAuthListener;
    private OnCompleteListener<Void> auth_updateEmailListener;
    private OnCompleteListener<Void> auth_updatePasswordListener;
    private OnCompleteListener<Void> auth_updateProfileListener;
    private LinearLayout banner_back;
    private ProgressDialog coreprog;
    private LinearLayout darkmode_options;
    private AdView fbBanner;
    private InterstitialAd fbInterstitial;
    private String fontName = "";
    private LinearLayout id_view;
    private ImageView imageview1;
    private ImageView imageview10;
    private ImageView imageview11;
    private ImageView imageview14;
    private ImageView imageview16;
    private ImageView imageview17;
    private ImageView imageview18;
    private ImageView imageview19;
    private ImageView imageview2;
    private ImageView imageview3;
    private ImageView imageview4;
    private ImageView imageview5;
    private ImageView imageview6;
    private ImageView imageview7;
    private ImageView imageview8;
    private ImageView imageview9;
    private boolean isEditing = false;
    private LinearLayout linear1;
    private LinearLayout linear10;
    private LinearLayout linear11;
    private LinearLayout linear13;
    private LinearLayout linear14;
    private LinearLayout linear16;
    private LinearLayout linear17;
    private LinearLayout linear19;
    private LinearLayout linear2;
    private LinearLayout linear20;
    private LinearLayout linear21;
    private LinearLayout linear22;
    private LinearLayout linear23;
    private LinearLayout linear26;
    private LinearLayout linear27;
    private LinearLayout linear28;
    private LinearLayout linear29;
    private LinearLayout linear30;
    private LinearLayout linear31;
    private LinearLayout linear32;
    private LinearLayout linear33;
    private LinearLayout linear34;
    private LinearLayout linear35;
    private LinearLayout linear36;
    private LinearLayout linear37;
    private LinearLayout linear38;
    private LinearLayout linear39;
    private LinearLayout linear4;
    private LinearLayout linear41;
    private LinearLayout linear42;
    private LinearLayout linear43;
    private LinearLayout linear44;
    private LinearLayout linear5;
    private ArrayList<HashMap<String, Object>> logsList = new ArrayList<>();
    private FirebaseAuth mAuth;
    private OnCompleteListener<Void> mAuth_deleteUserListener;
    private OnCompleteListener<Void> mAuth_emailVerificationSentListener;
    private OnCompleteListener<AuthResult> mAuth_googleSignInListener;
    private OnCompleteListener<AuthResult> mAuth_phoneAuthListener;
    private OnCompleteListener<Void> mAuth_updateEmailListener;
    private OnCompleteListener<Void> mAuth_updatePasswordListener;
    private OnCompleteListener<Void> mAuth_updateProfileListener;
    private double maxSlots = 0.0d;
    private RadioButton radiobutton1;
    private RadioButton radiobutton2;
    private RequestNetwork requestMoreblock;
    private ArrayList<HashMap<String, Object>> rwot = new ArrayList<>();
    private SharedPreferences sharedPref;
    private TextView textview1;
    private TextView textview11;
    private TextView textview13;
    private TextView textview15;
    private TextView textview16;
    private TextView textview17;
    private TextView textview19;
    private TextView textview2;
    private TextView textview20;
    private TextView textview22;
    private TextView textview23;
    private TextView textview24;
    private TextView textview3;
    private TextView textview4;
    private TextView textview6;
    private TextView textview9;
    private TimerTask tmr;
    private Intent toIntent = new Intent();
    private Intent tobrowser = new Intent();
    private Intent tohelp = new Intent();
    private Intent tologin = new Intent();
    private String userId = "";
    private String username = "";
    private ScrollView vscroll1;
    private YouTubePlayerView youtubeplayer1;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.updatify.o2nation.ProfileActivity */
    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        ProfileActivity.super.onCreate(bundle);
        setContentView(R.layout.profile);
        initialize(bundle);
        FirebaseApp.initializeApp(this);
        initializeLogic();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.updatify.o2nation.ProfileActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void initialize(Bundle bundle) {
        this.linear21 = (LinearLayout) findViewById(R.id.linear21);
        this.ads_back = (LinearLayout) findViewById(R.id.ads_back);
        this.vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
        this.linear1 = (LinearLayout) findViewById(R.id.linear1);
        this.linear2 = (LinearLayout) findViewById(R.id.linear2);
        this.textview4 = (TextView) findViewById(R.id.textview4);
        this.textview3 = (TextView) findViewById(R.id.textview3);
        this.banner_back = (LinearLayout) findViewById(R.id.banner_back);
        this.id_view = (LinearLayout) findViewById(R.id.id_view);
        this.linear4 = (LinearLayout) findViewById(R.id.linear4);
        this.linear30 = (LinearLayout) findViewById(R.id.linear30);
        this.linear26 = (LinearLayout) findViewById(R.id.linear26);
        this.linear33 = (LinearLayout) findViewById(R.id.linear33);
        this.linear28 = (LinearLayout) findViewById(R.id.linear28);
        this.linear10 = (LinearLayout) findViewById(R.id.linear10);
        this.linear22 = (LinearLayout) findViewById(R.id.linear22);
        this.linear19 = (LinearLayout) findViewById(R.id.linear19);
        this.youtubeplayer1 = findViewById(R.id.youtubeplayer1);
        this.linear13 = (LinearLayout) findViewById(R.id.linear13);
        this.darkmode_options = (LinearLayout) findViewById(R.id.darkmode_options);
        this.linear16 = (LinearLayout) findViewById(R.id.linear16);
        this.textview16 = (TextView) findViewById(R.id.textview16);
        this.imageview1 = (ImageView) findViewById(R.id.imageview1);
        this.textview1 = (TextView) findViewById(R.id.textview1);
        this.imageview2 = (ImageView) findViewById(R.id.imageview2);
        this.textview2 = (TextView) findViewById(R.id.textview2);
        this.imageview3 = (ImageView) findViewById(R.id.imageview3);
        this.textview24 = (TextView) findViewById(R.id.textview24);
        this.imageview5 = (ImageView) findViewById(R.id.imageview5);
        this.imageview4 = (ImageView) findViewById(R.id.imageview4);
        this.linear5 = (LinearLayout) findViewById(R.id.linear5);
        this.imageview11 = (ImageView) findViewById(R.id.imageview11);
        this.textview6 = (TextView) findViewById(R.id.textview6);
        this.linear31 = (LinearLayout) findViewById(R.id.linear31);
        this.linear32 = (LinearLayout) findViewById(R.id.linear32);
        this.imageview14 = (ImageView) findViewById(R.id.imageview14);
        this.linear27 = (LinearLayout) findViewById(R.id.linear27);
        this.textview19 = (TextView) findViewById(R.id.textview19);
        this.linear34 = (LinearLayout) findViewById(R.id.linear34);
        this.linear35 = (LinearLayout) findViewById(R.id.linear35);
        this.imageview16 = (ImageView) findViewById(R.id.imageview16);
        this.linear29 = (LinearLayout) findViewById(R.id.linear29);
        this.textview20 = (TextView) findViewById(R.id.textview20);
        this.imageview6 = (ImageView) findViewById(R.id.imageview6);
        this.linear11 = (LinearLayout) findViewById(R.id.linear11);
        this.textview9 = (TextView) findViewById(R.id.textview9);
        this.imageview10 = (ImageView) findViewById(R.id.imageview10);
        this.linear23 = (LinearLayout) findViewById(R.id.linear23);
        this.textview17 = (TextView) findViewById(R.id.textview17);
        this.imageview9 = (ImageView) findViewById(R.id.imageview9);
        this.linear20 = (LinearLayout) findViewById(R.id.linear20);
        this.textview15 = (TextView) findViewById(R.id.textview15);
        this.imageview7 = (ImageView) findViewById(R.id.imageview7);
        this.linear14 = (LinearLayout) findViewById(R.id.linear14);
        this.imageview19 = (ImageView) findViewById(R.id.imageview19);
        this.textview11 = (TextView) findViewById(R.id.textview11);
        this.linear36 = (LinearLayout) findViewById(R.id.linear36);
        this.linear39 = (LinearLayout) findViewById(R.id.linear39);
        this.linear41 = (LinearLayout) findViewById(R.id.linear41);
        this.linear44 = (LinearLayout) findViewById(R.id.linear44);
        this.linear37 = (LinearLayout) findViewById(R.id.linear37);
        this.linear38 = (LinearLayout) findViewById(R.id.linear38);
        this.imageview17 = (ImageView) findViewById(R.id.imageview17);
        this.textview22 = (TextView) findViewById(R.id.textview22);
        this.radiobutton1 = (RadioButton) findViewById(R.id.radiobutton1);
        this.linear42 = (LinearLayout) findViewById(R.id.linear42);
        this.linear43 = (LinearLayout) findViewById(R.id.linear43);
        this.imageview18 = (ImageView) findViewById(R.id.imageview18);
        this.textview23 = (TextView) findViewById(R.id.textview23);
        this.radiobutton2 = (RadioButton) findViewById(R.id.radiobutton2);
        this.imageview8 = (ImageView) findViewById(R.id.imageview8);
        this.linear17 = (LinearLayout) findViewById(R.id.linear17);
        this.textview13 = (TextView) findViewById(R.id.textview13);
        this.auth = FirebaseAuth.getInstance();
        this.sharedPref = getSharedPreferences("sharedPref", 0);
        this.mAuth = FirebaseAuth.getInstance();
        this.requestMoreblock = new RequestNetwork(this);
        this.id_view.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.ProfileActivity.1 */

            public void onClick(View view) {
                ProfileActivity profileActivity = ProfileActivity.this;
                ProfileActivity.this.getApplicationContext();
                ((ClipboardManager) profileActivity.getSystemService(CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", ProfileActivity.this.textview24.getText().toString()));
                ProfileActivity.this._Snackbar_API("Copied to clipboard", "", "");
            }
        });
        this.linear4.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.ProfileActivity.2 */

            public void onClick(View view) {
                if (ProfileActivity.this.linear28.getVisibility() == View.VISIBLE) {
                    ProfileActivity.this._shadAnim(ProfileActivity.this.imageview11, "rotation", 0.0d, 200.0d);
                    ProfileActivity.this._autoTransitionScroll(ProfileActivity.this.vscroll1);
                    ProfileActivity.this.linear28.setVisibility(View.GONE);
                    ProfileActivity.this.linear26.setVisibility(View.GONE);
                    ProfileActivity.this.linear30.setVisibility(View.GONE);
                    ProfileActivity.this.linear33.setVisibility(View.GONE);
                    return;
                }
                ProfileActivity.this._shadAnim(ProfileActivity.this.imageview11, "rotation", 180.0d, 200.0d);
                ProfileActivity.this._autoTransitionScroll(ProfileActivity.this.vscroll1);
                ProfileActivity.this.linear28.setVisibility(View.VISIBLE);
                ProfileActivity.this.linear26.setVisibility(View.VISIBLE);
                ProfileActivity.this.linear30.setVisibility(View.VISIBLE);
                ProfileActivity.this.linear33.setVisibility(View.VISIBLE);
            }
        });
        this.linear26.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.ProfileActivity.3 */

            public void onClick(View view) {
                ProfileActivity.this.tobrowser.setClass(ProfileActivity.this.getApplicationContext(), BrowserActivity.class);
                ProfileActivity.this.tobrowser.putExtra("url", "https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=5QNF32G85RDA4");
                ProfileActivity.this.tobrowser.putExtra("mode", "pay");
                ProfileActivity.this.startActivity(ProfileActivity.this.tobrowser);
            }
        });
        this.linear28.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.ProfileActivity.4 */

            /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, com.updatify.o2nation.ProfileActivity] */
            /* JADX WARNING: Unknown variable types count: 1 */
            public void onClick(View view) {
                ProfileActivity.this._Snackbar_API("Not available at the moment", "", "");
                ProfileActivity.this.fbInterstitial.show();
                ProfileActivity.this.fbInterstitial = new InterstitialAd((Context) ProfileActivity.this, "278142536768563_320780439171439");
                ProfileActivity.this.fbInterstitial.loadAd();
            }
        });
        this.linear10.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.ProfileActivity.5 */

            public void onClick(View view) {
                ProfileActivity.this.toIntent.setClass(ProfileActivity.this.getApplicationContext(), LogsActivity.class);
                ProfileActivity.this._ActivityTranlation(ProfileActivity.this.textview9, "tolog", ProfileActivity.this.toIntent);
            }
        });
        this.linear22.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.ProfileActivity.6 */

            /* JADX WARN: Type inference failed for: r0v0, types: [android.content.Context, com.updatify.o2nation.ProfileActivity] */
            /* JADX WARN: Type inference failed for: r0v2, types: [com.updatify.o2nation.ProfileActivity, android.app.Activity] */
            /* JADX WARN: Type inference failed for: r0v4, types: [android.content.Context, com.updatify.o2nation.ProfileActivity] */
            /* JADX WARNING: Unknown variable types count: 3 */
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission((Context) ProfileActivity.this, "android.permission.READ_EXTERNAL_STORAGE") == -1 || ContextCompat.checkSelfPermission((Context) ProfileActivity.this, "android.permission.WRITE_EXTERNAL_STORAGE") == -1) {
                    ActivityCompat.requestPermissions((Activity) ProfileActivity.this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1001);
                    ProfileActivity.this._Snackbar_API("We need permission to add moreblock", "", "");
                    return;
                }
                ProfileActivity.this.requestMoreblock.startRequestNetwork(RequestNetworkController.GET, "https://nerbly.com/updatify/component.html", "", ProfileActivity.this._requestMoreblock_request_listener);
                ProfileActivity.this._coreLoading(true, "#FFFFFF", 90.0d, "#FFFFFF", 0.0d);
            }
        });
        this.linear19.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.ProfileActivity.7 */

            public void onClick(View view) {
                ProfileActivity.this._autoTransitionScroll(ProfileActivity.this.vscroll1);
                if (ProfileActivity.this.youtubeplayer1.getVisibility() == View.VISIBLE) {
                    ProfileActivity.this.youtubeplayer1.setVisibility(View.GONE);
                } else {
                    ProfileActivity.this.youtubeplayer1.setVisibility(View.GONE);
                }
            }
        });
        this.linear13.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.ProfileActivity.8 */

            public void onClick(View view) {
                if (ProfileActivity.this.darkmode_options.getVisibility() == View.VISIBLE) {
                    ProfileActivity.this._shadAnim(ProfileActivity.this.imageview19, "rotation", 0.0d, 200.0d);
                    ProfileActivity.this._autoTransitionScroll(ProfileActivity.this.vscroll1);
                    ProfileActivity.this.darkmode_options.setVisibility(View.GONE);
                    return;
                }
                ProfileActivity.this._shadAnim(ProfileActivity.this.imageview19, "rotation", 180.0d, 200.0d);
                ProfileActivity.this._autoTransitionScroll(ProfileActivity.this.vscroll1);
                ProfileActivity.this.darkmode_options.setVisibility(View.VISIBLE);
                ProfileActivity.this.tmr = new TimerTask() {
                    /* class com.updatify.o2nation.ProfileActivity.8.1 */

                    public void run() {
                        ProfileActivity.this.runOnUiThread(new Runnable() {
                            /* class com.updatify.o2nation.ProfileActivity.8.1.1 */

                            public void run() {
                                ProfileActivity.this.vscroll1.smoothScrollTo(0, ProfileActivity.this.vscroll1.getBottom());
                            }
                        });
                    }
                };
                ProfileActivity.this._timer.schedule(ProfileActivity.this.tmr, 300);
            }
        });
        this.linear16.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.ProfileActivity.9 */

            public void onClick(View view) {
                ProfileActivity.this.tobrowser.setClass(ProfileActivity.this.getApplicationContext(), BrowserActivity.class);
                ProfileActivity.this.tobrowser.putExtra("url", "https://docs.google.com/forms/d/e/1FAIpQLSe6IzKWVW-sccbRgxmOhKBic7TeqDcp3dATVlmhhygIplbCrg/viewform");
                ProfileActivity.this.tobrowser.putExtra("mode", "browser");
                ProfileActivity.this.startActivity(ProfileActivity.this.tobrowser);
            }
        });
        this.imageview1.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.ProfileActivity.10 */

            public void onClick(View view) {
                ProfileActivity.this.finish();
            }
        });
        this.imageview2.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.ProfileActivity.11 */

            public void onClick(View view) {
            }
        });
        this.imageview3.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.ProfileActivity.12 */

            public void onClick(View view) {
                if (FirebaseAuth.getInstance().getCurrentUser() == null) {
                    ProfileActivity.this.tologin.setClass(ProfileActivity.this.getApplicationContext(), Auth2Activity.class);
                    ProfileActivity.this.startActivity(ProfileActivity.this.tologin);
                } else if (ProfileActivity.this.isEditing) {
                    ProfileActivity.this._autoTransitionScroll(ProfileActivity.this.vscroll1);
                    ProfileActivity.this.imageview3.setImageResource(R.drawable.twotone_visibility_off_black_48dp_2);
                    ProfileActivity.this.isEditing = false;
                    ProfileActivity.this._setViewSize(ProfileActivity.this.imageview2, 100.0d, 100.0d);
                } else {
                    ProfileActivity.this._autoTransitionScroll(ProfileActivity.this.vscroll1);
                    ProfileActivity.this.imageview3.setImageResource(R.drawable.twotone_visibility_off_black_48dp_1);
                    ProfileActivity.this._setViewSize(ProfileActivity.this.imageview2, ((double) SketchwareUtil.getDisplayWidthPixels(ProfileActivity.this.getApplicationContext())) / 3.5d, ((double) SketchwareUtil.getDisplayWidthPixels(ProfileActivity.this.getApplicationContext())) / 3.5d);
                    ProfileActivity.this.isEditing = true;
                }
            }
        });
        this.linear39.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.ProfileActivity.13 */

            public void onClick(View view) {
                SketchwareUtil.showMessage(ProfileActivity.this.getApplicationContext(), "Restarting Updatify...");
                ProfileActivity.this.radiobutton1.setChecked(true);
                ProfileActivity.this.radiobutton2.setChecked(false);
                ProfileActivity.this.startActivity(Intent.makeRestartActivityTask(ProfileActivity.this.getPackageManager().getLaunchIntentForPackage(ProfileActivity.this.getPackageName()).getComponent()));
                Runtime.getRuntime().exit(0);
            }
        });
        this.linear44.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.ProfileActivity.14 */

            public void onClick(View view) {
                ProfileActivity.this.radiobutton1.setChecked(false);
                ProfileActivity.this.radiobutton2.setChecked(true);
            }
        });
        this.radiobutton1.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.ProfileActivity.15 */

            public void onClick(View view) {
                SketchwareUtil.showMessage(ProfileActivity.this.getApplicationContext(), "Restarting Updatify...");
                ProfileActivity.this.radiobutton1.setChecked(true);
                ProfileActivity.this.radiobutton2.setChecked(false);
                ProfileActivity.this.startActivity(Intent.makeRestartActivityTask(ProfileActivity.this.getPackageManager().getLaunchIntentForPackage(ProfileActivity.this.getPackageName()).getComponent()));
                Runtime.getRuntime().exit(0);
            }
        });
        this.radiobutton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.updatify.o2nation.ProfileActivity.16 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    ProfileActivity.this.sharedPref.edit().putString("autodark", "true").commit();
                    try {
                        switch (ProfileActivity.this.getResources().getConfiguration().uiMode & 48) {
                            case 16:
                                ProfileActivity.this.sharedPref.edit().putString("dark", "false").commit();
                                return;
                            case 32:
                                ProfileActivity.this.sharedPref.edit().putString("dark", "true").commit();
                                return;
                            default:
                                return;
                        }
                    } catch (Exception e) {
                    }
                } else {
                    ProfileActivity.this.sharedPref.edit().putString("autodark", "false").commit();
                }
            }
        });
        this.radiobutton2.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.ProfileActivity.17 */

            public void onClick(View view) {
                ProfileActivity.this.radiobutton1.setChecked(false);
                ProfileActivity.this.radiobutton2.setChecked(true);
            }
        });
        this.radiobutton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.updatify.o2nation.ProfileActivity.18 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    ProfileActivity.this.sharedPref.edit().putString("autodark", "false").commit();
                } else {
                    ProfileActivity.this.sharedPref.edit().putString("autodark", "true").commit();
                }
            }
        });
        this._DBUsers_child_listener = new ChildEventListener() {
            /* class com.updatify.o2nation.ProfileActivity.19 */

            public void onChildAdded(DataSnapshot dataSnapshot, String str) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.ProfileActivity.19.1 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
                ProfileActivity.this.DBUsers.addValueEventListener(new ValueEventListener() {
                    /* class com.updatify.o2nation.ProfileActivity.19.2 */

                    public void onDataChange(DataSnapshot dataSnapshot) {
                        ProfileActivity.this.maxSlots = Double.parseDouble((String) dataSnapshot.child("maxSlots").getValue(String.class));
                        ProfileActivity.this.textview3.setText((CharSequence) dataSnapshot.child("membership").getValue(String.class));
                    }

                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
            }

            public void onChildChanged(DataSnapshot dataSnapshot, String str) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.ProfileActivity.19.3 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
                ProfileActivity.this.DBUsers.addValueEventListener(new ValueEventListener() {
                    /* class com.updatify.o2nation.ProfileActivity.19.4 */

                    public void onDataChange(DataSnapshot dataSnapshot) {
                        ProfileActivity.this.maxSlots = Double.parseDouble((String) dataSnapshot.child("maxSlots").getValue(String.class));
                        ProfileActivity.this.textview3.setText((CharSequence) dataSnapshot.child("membership").getValue(String.class));
                    }

                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
            }

            public void onChildMoved(DataSnapshot dataSnapshot, String str) {
            }

            public void onChildRemoved(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.ProfileActivity.19.5 */
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
        this._requestMoreblock_request_listener = new RequestNetwork.RequestListener() {
            /* class com.updatify.o2nation.ProfileActivity.20 */

            @Override // com.updatify.o2nation.RequestNetwork.RequestListener
            public void onResponse(String str, String str2, HashMap<String, Object> hashMap) {
                ProfileActivity.this._coreLoading(false, "#FFFFFF", 25.0d, "#FFFFFF", 0.0d);
                ProfileActivity.this._addMoreBlock(str2);
            }

            @Override // com.updatify.o2nation.RequestNetwork.RequestListener
            public void onErrorResponse(String str, String str2) {
                ProfileActivity.this._Snackbar_API(str2, "", "");
                ProfileActivity.this._coreLoading(false, "#FFFFFF", 25.0d, "#FFFFFF", 0.0d);
            }
        };
        this.auth_updateEmailListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.ProfileActivity.21 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.auth_updatePasswordListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.ProfileActivity.22 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.auth_emailVerificationSentListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.ProfileActivity.23 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.auth_deleteUserListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.ProfileActivity.24 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.auth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
            /* class com.updatify.o2nation.ProfileActivity.25 */

            public void onComplete(Task<AuthResult> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.auth_updateProfileListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.ProfileActivity.26 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.auth_googleSignInListener = new OnCompleteListener<AuthResult>() {
            /* class com.updatify.o2nation.ProfileActivity.27 */

            public void onComplete(Task<AuthResult> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this._auth_create_user_listener = new OnCompleteListener<AuthResult>() {
            /* class com.updatify.o2nation.ProfileActivity.28 */

            public void onComplete(Task<AuthResult> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this._auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
            /* class com.updatify.o2nation.ProfileActivity.29 */

            public void onComplete(Task<AuthResult> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this._auth_reset_password_listener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.ProfileActivity.30 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
            }
        };
        this.mAuth_updateEmailListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.ProfileActivity.31 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_updatePasswordListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.ProfileActivity.32 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_emailVerificationSentListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.ProfileActivity.33 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_deleteUserListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.ProfileActivity.34 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
            /* class com.updatify.o2nation.ProfileActivity.35 */

            public void onComplete(Task<AuthResult> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_updateProfileListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.ProfileActivity.36 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_googleSignInListener = new OnCompleteListener<AuthResult>() {
            /* class com.updatify.o2nation.ProfileActivity.37 */

            public void onComplete(Task<AuthResult> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this._mAuth_create_user_listener = new OnCompleteListener<AuthResult>() {
            /* class com.updatify.o2nation.ProfileActivity.38 */

            public void onComplete(Task<AuthResult> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this._mAuth_sign_in_listener = new OnCompleteListener<AuthResult>() {
            /* class com.updatify.o2nation.ProfileActivity.39 */

            public void onComplete(Task<AuthResult> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this._mAuth_reset_password_listener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.ProfileActivity.40 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: com.updatify.o2nation.ProfileActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void initializeLogic() {
        AudienceNetworkAds.initialize(this);
        this.fbBanner = new AdView(this, "278142536768563_297676561481827", AdSize.BANNER_HEIGHT_50);
        this.ads_back.addView(this.fbBanner);
        this.fbBanner.loadAd();
        this.fbInterstitial = new InterstitialAd(this, "278142536768563_320780439171439");
        this.fbInterstitial.loadAd();
        _LOGIC_BACKEND();
        _changeUserReference();
        _logic_UI();
        FirebaseUser currentUser = this.mAuth.getCurrentUser();
        this.username = currentUser.getDisplayName();
        this.textview4.setText(currentUser.getDisplayName());
        _setCircleImageURL(this.imageview2, currentUser.getPhotoUrl().toString(), 0.0d, "#FFFFFF");
        this.sharedPref.edit().putString("LastActivity", "ProfileActivity.Java").commit();
        _transitionComplete(this.textview4, "username");
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            this.tologin.setClass(getApplicationContext(), Auth2Activity.class);
            startActivity(this.tologin);
            finish();
        }
        this.isEditing = false;
        _YouTubePlayerStuff();
        OverScrollDecoratorHelper.setUpOverScroll(this.vscroll1);
        if (getIntent().hasExtra("isWantToBuy") && getIntent().getStringExtra("isWantToBuy").equals("true")) {
            ViewTooltip.on(this, this.linear4).autoHide(true, 3000).clickToHide(true).text("Click here and select what suits you").color(-865046416).textColor(-1).corner(20).position(ViewTooltip.Position.BOTTOM).arrowWidth(18).arrowHeight(18).distanceWithView(0).show();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        ProfileActivity.super.onActivityResult(i, i2, intent);
    }

    public void onResume() {
        ProfileActivity.super.onResume();
    }

    public void onPause() {
        ProfileActivity.super.onPause();
    }

    public void onDestroy() {
        ProfileActivity.super.onDestroy();
    }

    public void onStart() {
        ProfileActivity.super.onStart();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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

    public void _Shadow(View view, double d) {
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

    public void _clickAnim(final View view) {
        view.setOnTouchListener(new View.OnTouchListener() {
            /* class com.updatify.o2nation.ProfileActivity.41 */

            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case RequestNetworkController.REQUEST_PARAM:
                        ProfileActivity.this._shadAnim(view, "scaleX", 1.1d, 100.0d);
                        ProfileActivity.this._shadAnim(view, "scaleY", 1.1d, 100.0d);
                        return false;
                    case RequestNetworkController.REQUEST_BODY:
                        ProfileActivity.this._shadAnim(view, "scaleX", 1.0d, 100.0d);
                        ProfileActivity.this._shadAnim(view, "scaleY", 1.0d, 100.0d);
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

    public void _RippleEffects(String str, View view) {
        view.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor(str)}), null, null));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.updatify.o2nation.ProfileActivity */
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

    public void _decoupage(final View view) {
        view.setOnTouchListener(new View.OnTouchListener() {
            /* class com.updatify.o2nation.ProfileActivity.42 */

            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case RequestNetworkController.REQUEST_PARAM:
                        ProfileActivity.this._shadAnim(view, "scaleX", 1.02d, 100.0d);
                        ProfileActivity.this._shadAnim(view, "scaleY", 1.02d, 100.0d);
                        return false;
                    case RequestNetworkController.REQUEST_BODY:
                        ProfileActivity.this._shadAnim(view, "scaleX", 1.0d, 100.0d);
                        ProfileActivity.this._shadAnim(view, "scaleY", 1.0d, 100.0d);
                        return false;
                    default:
                        return false;
                }
            }
        });
    }

    public void _transitionComplete(View view, String str) {
        view.setTransitionName(str);
    }

    public void _setViewSize(View view, double d, double d2) {
        view.setLayoutParams(new LinearLayout.LayoutParams((int) d, (int) d2));
    }

    public void _autoTransitionScroll(View view) {
        TransitionManager.beginDelayedTransition((ScrollView) view, new AutoTransition());
    }

    public void _ViewFadeIn(View view, double d) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration((long) d);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        view.startAnimation(animationSet);
    }

    public void _setCircleImageURL(ImageView imageView, String str, double d, String str2) {
        Glide.with(this).load(str).circleCrop().into(imageView);
    }

    public void _Snackbar_API(String str, String str2, String str3) {
        this._snackBarView = Snackbar.make((ViewGroup) ((ViewGroup) findViewById(16908290)).getChildAt(0), "", 0);
        this._sblayout = (Snackbar.SnackbarLayout) this._snackBarView.getView();
        View inflate = getLayoutInflater().inflate(R.layout.snackbar, (ViewGroup) null);
        this._sblayout.setPadding(0, 0, 0, 0);
        this._sblayout.setBackgroundColor(Color.argb(0, 0, 0, 0));
        TextView textView = (TextView) inflate.findViewById(R.id.textview1);
        _setViewRadius((LinearLayout) inflate.findViewById(R.id.linear1), 20.0d, "#202125");
        textView.setText(str);
        textView.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product.ttf"), Typeface.NORMAL);
        this._sblayout.addView(inflate, 0);
        this._snackBarView.show();
    }

    private void _doNothingBlahBlah() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.updatify.o2nation.ProfileActivity */
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

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.updatify.o2nation.ProfileActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void _ActivityTranlation(View view, String str, Intent intent) {
        view.setTransitionName(str);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this, view, str).toBundle());
    }

    public void _setViewRadius(View view, double d, String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#" + str.replace("#", "")));
        gradientDrawable.setCornerRadius((float) ((int) d));
        view.setBackground(gradientDrawable);
    }

    public void _addMoreBlock(String str) {
        if (!FileUtil.isExistFile(FileUtil.getExternalStorageDir().concat("/.sketchware/collection/more_block/list"))) {
            _Snackbar_API("Something went wrong, check if sketchware is installed properly", "", "");
        } else if (!FileUtil.readFile(FileUtil.getExternalStorageDir().concat("/.sketchware/collection/more_block/list")).contains(str.replace("\n", ""))) {
            FileUtil.writeFile(FileUtil.getExternalStorageDir().concat("/.sketchware/collection/more_block/list"), FileUtil.readFile(FileUtil.getExternalStorageDir().concat("/.sketchware/collection/more_block/list")).trim().concat("\n").concat(str.replace("\n", "")));
            _Snackbar_API("UpdatifyComponent has been added to your sketchware collections successfully.\n[RESTART SKETCHWARE TO APPLY CHANGES]", "", "");
        } else {
            _Snackbar_API("You already have the latest version of UpdatifyComponent", "", "");
        }
    }

    public void _rippleRoundStroke(View view, String str, String str2, double d, double d2, String str3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius((float) d);
        gradientDrawable.setStroke((int) d2, Color.parseColor("#" + str3.replace("#", "")));
        view.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor(str2)}), gradientDrawable, null));
    }

    public void _removeScollBar(View view) {
        view.setVerticalScrollBarEnabled(false);
        view.setHorizontalScrollBarEnabled(false);
    }

    public void _logic_UI() {
        this.linear28.setVisibility(View.GONE);
        this.linear26.setVisibility(View.GONE);
        this.linear30.setVisibility(View.GONE);
        this.linear33.setVisibility(View.GONE);
        this.darkmode_options.setVisibility(View.GONE);
        _setViewSize(this.imageview2, 100.0d, 100.0d);
        this.imageview1.setImageResource(R.drawable.twotone_arrow_back_black_48dp);
        _ViewFadeIn(this.imageview1, 500.0d);
        _ViewFadeIn(this.imageview3, 500.0d);
        this.youtubeplayer1.setVisibility(View.VISIBLE);
        this.textview3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
        _clickAnim(this.imageview1);
        _clickAnim(this.imageview3);
        _setToolTip(this.imageview1, "Back home");
        _setToolTip(this.imageview3, "Control picture size");
        _changeActivityFont("product_med");
        _removeScollBar(this.vscroll1);
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
            this.radiobutton1.setChecked(true);
            this.radiobutton2.setChecked(false);
        } else if (this.sharedPref.getString("autodark", "").equals("false")) {
            this.radiobutton1.setChecked(false);
            this.radiobutton2.setChecked(true);
        }
        if (this.sharedPref.getString("dark", "").equals("true")) {
            _NavStatusBarColor("#181818", "#181818");
            _LIGHT_ICONS();
            _RippleEffects("#EEEEEE", this.imageview1);
            _ICC(this.imageview1, "#FFFFFF", "#CCFFFFFF");
            _RippleEffects("#EEEEEE", this.imageview3);
            _ICC(this.imageview3, "#FFFFFF", "#CCFFFFFF");
            _rippleRoundStroke(this.imageview4, "#181818", "#E0E0E0", 100.0d, 2.0d, "#424242");
            _rippleRoundStroke(this.imageview6, "#181818", "#E0E0E0", 100.0d, 2.0d, "#424242");
            _rippleRoundStroke(this.imageview10, "#181818", "#E0E0E0", 100.0d, 2.0d, "#424242");
            _rippleRoundStroke(this.imageview7, "#181818", "#212121", 100.0d, 2.0d, "#424242");
            _rippleRoundStroke(this.imageview8, "#181818", "#E0E0E0", 100.0d, 2.0d, "#424242");
            _rippleRoundStroke(this.imageview9, "#181818", "#E0E0E0", 100.0d, 2.0d, "#424242");
            _rippleRoundStroke(this.imageview16, "#181818", "#E0E0E0", 100.0d, 2.0d, "#424242");
            _rippleRoundStroke(this.imageview14, "#181818", "#E0E0E0", 100.0d, 2.0d, "#424242");
            _rippleRoundStroke(this.linear10, "#181818", "#212121", 0.0d, 0.0d, "#E0E0E0");
            _rippleRoundStroke(this.linear4, "#181818", "#212121", 0.0d, 0.0d, "#E0E0E0");
            _rippleRoundStroke(this.linear13, "#181818", "#212121", 0.0d, 0.0d, "#E0E0E0");
            _rippleRoundStroke(this.linear16, "#181818", "#212121", 0.0d, 0.0d, "#E0E0E0");
            _rippleRoundStroke(this.linear19, "#181818", "#212121", 0.0d, 0.0d, "#E0E0E0");
            _rippleRoundStroke(this.linear22, "#181818", "#212121", 0.0d, 0.0d, "#E0E0E0");
            this.textview6.setTextColor(-1);
            this.textview19.setTextColor(-1);
            this.textview20.setTextColor(-1);
            this.textview4.setTextColor(-1);
            this.textview17.setTextColor(-1);
            this.textview15.setTextColor(-1);
            this.textview9.setTextColor(-1);
            this.textview11.setTextColor(-1);
            this.textview13.setTextColor(-1);
            this.textview16.setTextColor(-1);
            this.textview22.setTextColor(-1);
            this.textview23.setTextColor(-1);
            _rippleRoundStroke(this.imageview7, "#181818", "#E0E0E0", 100.0d, 2.0d, "#424242");
            _rippleRoundStroke(this.imageview17, "#181818", "#E0E0E0", 100.0d, 2.0d, "#424242");
            _rippleRoundStroke(this.imageview18, "#181818", "#E0E0E0", 100.0d, 2.0d, "#424242");
            this.linear21.setBackgroundColor(-15198184);
            _ICC(this.imageview11, "#FFFFFF", "#CCFFFFFF");
            _ICC(this.imageview19, "#FFFFFF", "#CCFFFFFF");
            _rippleRoundStroke(this.linear26, "#181818", "#212121", 0.0d, 0.0d, "#E0E0E0");
            _rippleRoundStroke(this.linear28, "#181818", "#212121", 0.0d, 0.0d, "#E0E0E0");
            _rippleRoundStroke(this.linear39, "#181818", "#212121", 0.0d, 0.0d, "#E0E0E0");
            _rippleRoundStroke(this.linear44, "#181818", "#212121", 0.0d, 0.0d, "#E0E0E0");
            this.textview16.setBackgroundColor(-15198184);
            _setRadioButtonColor(this.radiobutton1, "#FFFFFF");
            _setRadioButtonColor(this.radiobutton2, "#FFFFFF");
            this.ads_back.setBackgroundColor(-15198184);
            _rippleRoundStroke(this.id_view, "#181818", "#424242", 90.0d, 1.0d, "#424242");
            this.textview24.setTextColor(-1118482);
            _ICC(this.imageview5, "#FFFFFF", "#ccFFFFFF");
            return;
        }
        _NavStatusBarColor("#FFFFFF", "#FFFFFF");
        _DARK_ICONS();
        _RippleEffects("#EEEEEE", this.imageview1);
        _ICC(this.imageview1, "#616161", "#CC616161");
        _RippleEffects("#EEEEEE", this.imageview3);
        _ICC(this.imageview3, "#FF0070EE", "#CC0070EE");
        this.linear4.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor("#F5F5F5")}), new ColorDrawable(-1), null));
        this.linear10.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor("#F5F5F5")}), new ColorDrawable(-1), null));
        this.linear13.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor("#F5F5F5")}), new ColorDrawable(-1), null));
        this.linear16.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor("#F5F5F5")}), new ColorDrawable(-1), null));
        this.linear19.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor("#F5F5F5")}), new ColorDrawable(-1), null));
        this.linear22.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor("#F5F5F5")}), new ColorDrawable(-1), null));
        this.linear26.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor("#F5F5F5")}), new ColorDrawable(-1), null));
        this.linear28.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor("#F5F5F5")}), new ColorDrawable(-1), null));
        _rippleRoundStroke(this.imageview4, "#FFFFFF", "#E0E0E0", 100.0d, 2.0d, "#E0E0E0");
        _rippleRoundStroke(this.imageview6, "#FFFFFF", "#E0E0E0", 100.0d, 2.0d, "#E0E0E0");
        _rippleRoundStroke(this.imageview10, "#FFFFFF", "#E0E0E0", 100.0d, 2.0d, "#E0E0E0");
        _rippleRoundStroke(this.imageview7, "#FFFFFF", "#E0E0E0", 100.0d, 2.0d, "#E0E0E0");
        _rippleRoundStroke(this.imageview8, "#FFFFFF", "#E0E0E0", 100.0d, 2.0d, "#E0E0E0");
        _rippleRoundStroke(this.imageview9, "#FFFFFF", "#E0E0E0", 100.0d, 2.0d, "#E0E0E0");
        _rippleRoundStroke(this.imageview16, "#FFFFFF", "#E0E0E0", 100.0d, 2.0d, "#E0E0E0");
        _rippleRoundStroke(this.imageview14, "#FFFFFF", "#E0E0E0", 100.0d, 2.0d, "#E0E0E0");
        _rippleRoundStroke(this.imageview7, "#FFFFFF", "#E0E0E0", 100.0d, 2.0d, "#E0E0E0");
        _ICC(this.imageview11, "#616161", "#CC616161");
        _ICC(this.imageview19, "#616161", "#CC616161");
        _rippleRoundStroke(this.imageview17, "#FFFFFF", "#E0E0E0", 100.0d, 2.0d, "#E0E0E0");
        _rippleRoundStroke(this.imageview18, "#FFFFFF", "#E0E0E0", 100.0d, 2.0d, "#E0E0E0");
        _rippleRoundStroke(this.linear39, "#FFFFFF", "#E0E0E0", 0.0d, 0.0d, "#E0E0E0");
        _rippleRoundStroke(this.linear44, "#FFFFFF", "#E0E0E0", 0.0d, 0.0d, "#E0E0E0");
        _rippleRoundStroke(this.id_view, "#FFFFFF", "#BDBDBD", 90.0d, 1.0d, "#BDBDBD");
        this.textview24.setTextColor(-14606047);
        _ICC(this.imageview5, "#616161", "#CC616161");
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

    public void _setRadioButtonColor(RadioButton radioButton, String str) {
        radioButton.setButtonTintList(ColorStateList.valueOf(Color.parseColor(str)));
    }

    public void _admobRewardedAdsLib() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r15v0, resolved type: com.updatify.o2nation.ProfileActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void _congratulationsAd() {
        final AlertDialog create = new AlertDialog.Builder(this).create();
        View inflate = getLayoutInflater().inflate(R.layout.notification, (ViewGroup) null);
        create.setView(inflate);
        create.getWindow().setBackgroundDrawableResource(17170445);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.background);
        TextView textView = (TextView) inflate.findViewById(R.id.cancel);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.imageview1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.textview1);
        TextView textView3 = (TextView) inflate.findViewById(R.id.okay);
        TextView textView4 = (TextView) inflate.findViewById(R.id.textview2);
        _rippleRoundStroke(textView3, "#078AFF", "#FFFFFF", 20.0d, 0.0d, "#078AFF");
        if (this.sharedPref.getString("dark", "").equals("true")) {
            textView2.setTextColor(-1);
            _setViewRadius(linearLayout, 40.0d, "#181818");
        } else {
            _setViewRadius(linearLayout, 40.0d, "#FFFFFF");
        }
        textView.setVisibility(View.GONE);
        imageView.setImageResource(R.drawable.party);
        textView2.setText("Congratulations!");
        textView4.setText("You've received 1 free slot, it has been added to your account.");
        textView2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_bold.ttf"), Typeface.NORMAL);
        textView4.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
        textView3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
        textView3.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.ProfileActivity.43 */

            public void onClick(View view) {
                create.dismiss();
            }
        });
        create.setCancelable(false);
        create.show();
    }

    public void _YouTubePlayerStuff() {
        getLifecycle().addObserver(this.youtubeplayer1);
        this.youtubeplayer1.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            /* class com.updatify.o2nation.ProfileActivity.44 */

            public void onReady(YouTubePlayer youTubePlayer) {
                youTubePlayer.cueVideo("xPgmiLhTm_o", 0.0f);
            }
        });
        this.youtubeplayer1.addFullScreenListener(new YouTubePlayerFullScreenListener() {
            /* class com.updatify.o2nation.ProfileActivity.45 */

            public void onYouTubePlayerEnterFullScreen() {
                ProfileActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }

            public void onYouTubePlayerExitFullScreen() {
                ProfileActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
        });
    }

    public void _changeUserReference() {
        this.userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        this.DBUsers = this._firebase.getReference("USERS2827IWUWIEHDN8273").child(this.userId);
        try {
            this.DBUsers.addValueEventListener(new ValueEventListener() {
                /* class com.updatify.o2nation.ProfileActivity.46 */

                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (((String) dataSnapshot.child("account_status").getValue(String.class)).equals("false")) {
                        SketchwareUtil.showMessage(ProfileActivity.this.getApplicationContext(), "Your account is banned");
                        ProfileActivity.this.tologin.setClass(ProfileActivity.this.getApplicationContext(), Auth2Activity.class);
                        ProfileActivity.this.startActivity(ProfileActivity.this.tologin);
                        ProfileActivity.this.finish();
                    } else if (((String) dataSnapshot.child("account_status").getValue(String.class)).equals("true")) {
                        ProfileActivity.this.maxSlots = Double.parseDouble((String) dataSnapshot.child("maxSlots").getValue(String.class));
                        ProfileActivity.this.textview3.setText((CharSequence) dataSnapshot.child("membership").getValue(String.class));
                    }
                }

                public void onCancelled(DatabaseError databaseError) {
                }
            });
        } catch (Exception e) {
            _Snackbar_API(e.toString(), "", "");
        }
    }

    public void _LOGIC_BACKEND() {
        this.textview24.setText("Include this when you contact us: ".concat(FirebaseAuth.getInstance().getCurrentUser().getUid()));
        _marqueeTextView(this.textview24, "");
    }

    public void _marqueeTextView(TextView textView, String str) {
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setSelected(true);
        textView.setHorizontalFadingEdgeEnabled(true);
        textView.setFadingEdgeLength(20);
    }
}
