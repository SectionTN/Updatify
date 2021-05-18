package com.updatify.o2nation;

import android.animation.ObjectAnimator;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.hanks.htextview.HTextView;
import com.hanks.htextview.HTextViewType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

public class Auth2Activity extends AppCompatActivity {
    public final int REQ_CD_GOOGLEAUTH = 101;
    View _inflate;
    Snackbar.SnackbarLayout _sblayout;
    Snackbar _snackBarView;
    private ChildEventListener _DBUsers_child_listener;
    private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
    private DatabaseReference DBUsers = this._firebase.getReference("USERS2827IWUWIEHDN8273");
    private OnCompleteListener<AuthResult> _mAuth_create_user_listener;
    private OnCompleteListener<Void> _mAuth_reset_password_listener;
    private OnCompleteListener<AuthResult> _mAuth_sign_in_listener;
    private Timer _timer = new Timer();
    private String activityFontName = "";
    private HashMap<String, Object> authMap = new HashMap<>();
    private FirebaseAuth.AuthStateListener authStateListener;
    private LinearLayout background;
    private ProgressDialog coreprog;
    private LinearLayout fb_login_btn;
    private GoogleSignInClient googleAuth;
    private LinearLayout google_login_btn;
    private ImageView imageview1;
    private ImageView imageview3;
    private ImageView imageview4;
    private FirebaseAuth mAuth;
    private OnCompleteListener<Void> mAuth_deleteUserListener;
    private OnCompleteListener<Void> mAuth_emailVerificationSentListener;
    private OnCompleteListener<AuthResult> mAuth_googleSignInListener;
    private OnCompleteListener<AuthResult> mAuth_phoneAuthListener;
    private OnCompleteListener<Void> mAuth_updateEmailListener;
    private OnCompleteListener<Void> mAuth_updatePasswordListener;
    private OnCompleteListener<Void> mAuth_updateProfileListener;
    private CallbackManager mCallbackManager;
    private LinearLayout rootview;
    private SharedPreferences sharedPref;
    private SharedPreferences sharedPref2;
    private LinearLayout slideshow;
    private double slideshow_num = 0.0d;
    private HTextView textview2;
    private HTextView textview3;
    private TextView textview4;
    private TextView textview5;
    private TimerTask timer1;
    private TimerTask timer2;
    private Intent tocontact = new Intent();
    private Intent tohome = new Intent();
    private String videoUrl = "";

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.updatify.o2nation.Auth2Activity */
    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        Auth2Activity.super.onCreate(bundle);
        setContentView(R.layout.auth2);
        initialize(bundle);
        FirebaseApp.initializeApp(this);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this.rootview = (LinearLayout) findViewById(R.id.rootview);
        this.background = (LinearLayout) findViewById(R.id.background);
        this.slideshow = (LinearLayout) findViewById(R.id.slideshow);
        this.google_login_btn = (LinearLayout) findViewById(R.id.google_login_btn);
        this.fb_login_btn = (LinearLayout) findViewById(R.id.fb_login_btn);
        this.textview2 = findViewById(R.id.textview2);
        this.textview3 = findViewById(R.id.textview3);
        this.imageview1 = (ImageView) findViewById(R.id.imageview1);
        this.imageview3 = (ImageView) findViewById(R.id.imageview3);
        this.textview4 = (TextView) findViewById(R.id.textview4);
        this.imageview4 = (ImageView) findViewById(R.id.imageview4);
        this.textview5 = (TextView) findViewById(R.id.textview5);
        this.mAuth = FirebaseAuth.getInstance();
        this.sharedPref = getSharedPreferences("UpdatifyFiles", 0);
        this.sharedPref2 = getSharedPreferences("sharedPref", 0);
        this.google_login_btn.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.Auth2Activity.1 */

            public void onClick(View view) {
                Auth2Activity.this._checkPerThenLogin();
            }
        });
        this.fb_login_btn.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.Auth2Activity.2 */

            public void onClick(View view) {
                Auth2Activity.this._onFacebookAuthClick();
            }
        });
        this._DBUsers_child_listener = new ChildEventListener() {
            /* class com.updatify.o2nation.Auth2Activity.3 */

            public void onChildAdded(DataSnapshot dataSnapshot, String str) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.Auth2Activity.3.1 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
            }

            public void onChildChanged(DataSnapshot dataSnapshot, String str) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.Auth2Activity.3.2 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
            }

            public void onChildMoved(DataSnapshot dataSnapshot, String str) {
            }

            public void onChildRemoved(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.Auth2Activity.3.3 */
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
        this.mAuth_updateEmailListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.Auth2Activity.4 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_updatePasswordListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.Auth2Activity.5 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_emailVerificationSentListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.Auth2Activity.6 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_deleteUserListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.Auth2Activity.7 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
            /* class com.updatify.o2nation.Auth2Activity.8 */

            public void onComplete(Task<AuthResult> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_updateProfileListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.Auth2Activity.9 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_googleSignInListener = new OnCompleteListener<AuthResult>() {
            /* class com.updatify.o2nation.Auth2Activity.10 */

            public void onComplete(Task<AuthResult> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this._mAuth_create_user_listener = new OnCompleteListener<AuthResult>() {
            /* class com.updatify.o2nation.Auth2Activity.11 */

            public void onComplete(Task<AuthResult> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this._mAuth_sign_in_listener = new OnCompleteListener<AuthResult>() {
            /* class com.updatify.o2nation.Auth2Activity.12 */

            public void onComplete(Task<AuthResult> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this._mAuth_reset_password_listener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.Auth2Activity.13 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
            }
        };
    }

    private void initializeLogic() {
        _LOGIC_FRONTEND();
        _LOGIC_BACKEND();
        _onCreate_auth_Google("1018146324937-5m0c7b0gio8ut2ll89cubiuqgiml5ors.apps.googleusercontent.com");
        _sliderStuff();
        this.mAuth = FirebaseAuth.getInstance();
        FacebookSdk.sdkInitialize(getApplicationContext());
        this.mCallbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(this.mCallbackManager, new FacebookCallback<LoginResult>() {
            /* class com.updatify.o2nation.Auth2Activity.14 */

            public void onSuccess(LoginResult loginResult) {
                Auth2Activity.this.handleFacebookToken(loginResult.getAccessToken());
            }

            public void onCancel() {
                Auth2Activity.this._coreLoading(false, "#FFFFFF", 120.0d, "#FFFFFF", 0.0d);
                Auth2Activity.this._showCustomSnackBar("Authentication failed, please try again.");
            }

            public void onError(FacebookException facebookException) {
                Auth2Activity.this._coreLoading(false, "#FFFFFF", 120.0d, "#FFFFFF", 0.0d);
                Auth2Activity.this._showCustomSnackBar("Authentication failed, please try again.");
            }
        });
        this.authStateListener = new FirebaseAuth.AuthStateListener() {
            /* class com.updatify.o2nation.Auth2Activity.15 */

            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                Auth2Activity.this.mAuth.getCurrentUser();
            }
        };
        new AccessTokenTracker() {
            /* class com.updatify.o2nation.Auth2Activity.16 */

            protected void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2) {
                if (accessToken2 == null) {
                    Auth2Activity.this.mAuth.signOut();
                }
            }
        };
    }

    public void onStart() {
        Auth2Activity.super.onStart();
        this.mAuth.addAuthStateListener(this.authStateListener);
    }

    public void onStop() {
        Auth2Activity.super.onStop();
        if (this.authStateListener != null) {
            this.mAuth.removeAuthStateListener(this.authStateListener);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.mCallbackManager.onActivityResult(i, i2, intent);
        Auth2Activity.super.onActivityResult(i, i2, intent);
        if (i == 101) {
            try {
                firebaseAuthWithGoogle(((GoogleSignInAccount) GoogleSignIn.getSignedInAccountFromIntent(intent).getResult(ApiException.class)).getIdToken());
            } catch (ApiException e) {
                if (e.toString().trim().equals("com.google.android.gms.common.api.ApiException: 10:") || e.toString().trim().equals("com.google.android.gms.common.api.ApiException: 12500:")) {
                    _showCustomSnackBar("You're not using an official version of Updatify, please download it from Play Store.");
                } else if (!e.toString().trim().equals("com.google.android.gms.common.api.ApiException: 12501:")) {
                    _showCustomSnackBar(e.toString());
                }
                _coreLoading(false, "#FFFFFF", 120.0d, "#FFFFFF", 0.0d);
            }
        }
    }

    public void _onGoogleSignClick() {
        startActivityForResult(this.googleAuth.getSignInIntent(), 101);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.updatify.o2nation.Auth2Activity */
    /* JADX WARN: Multi-variable type inference failed */
    public void _onCreate_auth_Google(String str) {
        this.googleAuth = GoogleSignIn.getClient(this, new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(str).requestEmail().build());
        this.mAuth = FirebaseAuth.getInstance();
    }

    public void _void_StartAuthGoogle() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.updatify.o2nation.Auth2Activity */
    /* JADX WARN: Multi-variable type inference failed */
    private void firebaseAuthWithGoogle(String str) {
        this.mAuth.signInWithCredential(GoogleAuthProvider.getCredential(str, (String) null)).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            /* class com.updatify.o2nation.Auth2Activity.17 */

            public void onComplete(@NonNull Task<AuthResult> task) {
                Auth2Activity.this._coreLoading(false, "#FFFFFF", 120.0d, "#FFFFFF", 0.0d);
                if (task.isSuccessful()) {
                    FirebaseUser currentUser = Auth2Activity.this.mAuth.getCurrentUser();
                    if (((AuthResult) task.getResult()).getAdditionalUserInfo().isNewUser()) {
                        Auth2Activity.this.authMap = new HashMap();
                        Auth2Activity.this.authMap.put("email", currentUser.getEmail());
                        Auth2Activity.this.authMap.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
                        Auth2Activity.this.authMap.put("username", currentUser.getDisplayName());
                        Auth2Activity.this.authMap.put("slots", "0");
                        Auth2Activity.this.authMap.put("maxSlots", "3");
                        Auth2Activity.this.authMap.put("membership", "Free Membership");
                        Auth2Activity.this.authMap.put("userimg", currentUser.getPhotoUrl().toString());
                        Auth2Activity.this.authMap.put("account_status", "true");
                        Auth2Activity.this.DBUsers.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(Auth2Activity.this.authMap);
                        Auth2Activity.this.authMap.clear();
                    }
                    Auth2Activity.this.tohome.setClass(Auth2Activity.this.getApplicationContext(), HomeActivity.class);
                    Auth2Activity.this.startActivity(Auth2Activity.this.tohome);
                    Auth2Activity.this.finish();
                    return;
                }
                Auth2Activity.this._showCustomSnackBar("Authentication failed, try again");
            }
        });
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.updatify.o2nation.Auth2Activity */
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

    public void _ICC(ImageView imageView, String str, String str2) {
        imageView.setImageTintList(new ColorStateList(new int[][]{new int[]{-16842919}, new int[]{16842919}}, new int[]{Color.parseColor(str), Color.parseColor(str2)}));
    }

    public void _RoundAndBorder(View view, String str, double d, String str2, double d2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius((float) ((int) d2));
        gradientDrawable.setStroke((int) d, Color.parseColor(str2));
        view.setBackground(gradientDrawable);
    }

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

    public void _DARK_ICONS() {
        getWindow().getDecorView().setSystemUiVisibility(8192);
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

    public void _transitionComplete(View view, String str) {
        view.setTransitionName(str);
    }

    public void _setBgCorners(View view, double d, String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#" + str.replace("#", "")));
        gradientDrawable.setCornerRadius((float) ((int) d));
        gradientDrawable.setStroke(0, -1);
        view.setBackground(gradientDrawable);
    }

    public void _notice() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View inflate = getLayoutInflater().inflate(R.layout.info_sheet, (ViewGroup) null);
        bottomSheetDialog.setContentView(inflate);
        bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(0x106000d);
        TextView textView = (TextView) inflate.findViewById(R.id.infosheet_ok);
        TextView textView2 = (TextView) inflate.findViewById(R.id.infosheet_cancel);
        TextView textView3 = (TextView) inflate.findViewById(R.id.infosheet_title);
        TextView textView4 = (TextView) inflate.findViewById(R.id.infosheet_sub);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.infosheet_btn_holder);
        textView3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_bold.ttf"), Typeface.NORMAL);
        textView4.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
        textView.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_bold.ttf"), Typeface.NORMAL);
        textView2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
        ((ImageView) inflate.findViewById(R.id.infosheet_img)).setImageResource(R.drawable.default_image);
        textView.setText("Contact us");
        textView2.setText("Dismiss");
        textView3.setText("Important Notice");
        textView4.setText("If you're an old user and your projects gone, please contact us to bring them back. Thanks!");
        _setBgCorners((LinearLayout) inflate.findViewById(R.id.infosheet_back), 80.0d, "#FFFFFF");
        _setBgCorners(textView, 200.0d, "#2196F3");
        _setBgCorners(textView2, 200.0d, "#EEEEEE");
        textView.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.Auth2Activity.18 */

            public void onClick(View view) {
                Auth2Activity.this.tocontact.setAction("android.intent.action.VIEW");
                Auth2Activity.this.tocontact.setData(Uri.parse("https://facebook.com/ilyassesalama"));
                Auth2Activity.this.startActivity(Auth2Activity.this.tocontact);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.Auth2Activity.19 */

            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.show();
    }

    public void _rippleRoundStroke(View view, String str, String str2, double d, double d2, String str3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius((float) d);
        gradientDrawable.setStroke((int) d2, Color.parseColor("#" + str3.replace("#", "")));
        view.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor(str2)}), gradientDrawable, null));
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
            /* class com.updatify.o2nation.Auth2Activity.20 */

            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case RequestNetworkController.REQUEST_PARAM /*{ENCODED_INT: 0}*/:
                        Auth2Activity.this._shadAnim(view, "elevation", 8.0d, 100.0d);
                        Auth2Activity.this._shadAnim(view, "scaleX", 1.05d, 100.0d);
                        Auth2Activity.this._shadAnim(view, "scaleY", 1.05d, 100.0d);
                        return false;
                    case RequestNetworkController.REQUEST_BODY /*{ENCODED_INT: 1}*/:
                        Auth2Activity.this._shadAnim(view, "elevation", 0.0d, 100.0d);
                        Auth2Activity.this._shadAnim(view, "scaleX", 1.0d, 100.0d);
                        Auth2Activity.this._shadAnim(view, "scaleY", 1.0d, 100.0d);
                        return false;
                    default:
                        return false;
                }
            }
        });
    }

    public void _showCustomSnackBar(String str) {
        // TODO : Make a resources class for'em
        this._snackBarView = Snackbar.make((ViewGroup) ((ViewGroup) findViewById(0x1020002)).getChildAt(0), "", 0);
        this._sblayout = (Snackbar.SnackbarLayout) this._snackBarView.getView();
        View inflate = getLayoutInflater().inflate(R.layout.snackbar, (ViewGroup) null);
        this._sblayout.setPadding(0, 0, 0, 0);
        this._sblayout.setBackgroundColor(Color.argb(0, 0, 0, 0));
        TextView textView = (TextView) inflate.findViewById(R.id.textview1);
        _setBgCorners((LinearLayout) inflate.findViewById(R.id.linear1), 20.0d, "#202125");
        textView.setText(str);
        textView.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product.ttf"), Typeface.NORMAL);
        this._sblayout.addView(inflate, 0);
        this._snackBarView.show();
    }

    private void _doNothingBlahBlah() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.updatify.o2nation.Auth2Activity */
    /* JADX WARN: Multi-variable type inference failed */
    public void _checkPerThenLogin() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") == -1 || ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == -1) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1001);
            _showCustomSnackBar("Please allow permission to continue");
            return;
        }
        _onGoogleSignClick();
        _coreLoading(true, "#FFFFFF", 90.0d, "#FFFFFF", 0.0d);
    }

    public void _removeScollBar(View view) {
        view.setVerticalScrollBarEnabled(false);
        view.setHorizontalScrollBarEnabled(false);
    }

    public void _onBackPressedAction() {
    }

    public void onBackPressed() {
        finishAffinity();
    }

    public void backPressAssist() {
    }

    public void _LIGHT_ICONS() {
        getWindow().getDecorView().setSystemUiVisibility(0);
    }

    public void _textAnimation(HTextView hTextView, String str) {
        hTextView.setAnimateType(HTextViewType.SCALE);
        hTextView.animateText(str);
    }

    public void _sliderStuff() {
        _textAnimation(this.textview2, "Welcome to Updatify");
        _textAnimation(this.textview3, "We take your app to a whole new level");
        this.slideshow_num = 1.0d;
        this.timer1 = new TimerTask() {
            /* class com.updatify.o2nation.Auth2Activity.21 */

            public void run() {
                Auth2Activity.this.runOnUiThread(new Runnable() {
                    /* class com.updatify.o2nation.Auth2Activity.21.1 */

                    public void run() {
                        if (Auth2Activity.this.slideshow_num == 1.0d) {
                            Auth2Activity.this._textAnimation(Auth2Activity.this.textview2, "1-Tap, Notification sent!");
                            Auth2Activity.this._textAnimation(Auth2Activity.this.textview3, "No delays, no confusions, we keep it simple");
                            Auth2Activity.this._FadeOutInView(Auth2Activity.this.imageview1);
                            Auth2Activity.this.timer2 = new TimerTask() {
                                /* class com.updatify.o2nation.Auth2Activity.21.1.1 */

                                public void run() {
                                    Auth2Activity.this.runOnUiThread(new Runnable() {
                                        /* class com.updatify.o2nation.Auth2Activity.21.1.1.1 */

                                        public void run() {
                                            Auth2Activity.this.imageview1.setImageResource(R.drawable.sent_messages__flatline);
                                            Auth2Activity.this._ViewFadeIn(Auth2Activity.this.imageview1, 400.0d);
                                        }
                                    });
                                }
                            };
                            Auth2Activity.this._timer.schedule(Auth2Activity.this.timer2, 300);
                            Auth2Activity.this.slideshow_num = 2.0d;
                        } else if (Auth2Activity.this.slideshow_num == 2.0d) {
                            Auth2Activity.this._textAnimation(Auth2Activity.this.textview2, "Start with an idea");
                            Auth2Activity.this._textAnimation(Auth2Activity.this.textview3, "Manage your idea in a professional way");
                            Auth2Activity.this._FadeOutInView(Auth2Activity.this.imageview1);
                            Auth2Activity.this.timer2 = new TimerTask() {
                                /* class com.updatify.o2nation.Auth2Activity.21.1.2 */

                                public void run() {
                                    Auth2Activity.this.runOnUiThread(new Runnable() {
                                        /* class com.updatify.o2nation.Auth2Activity.21.1.2.1 */

                                        public void run() {
                                            Auth2Activity.this.imageview1.setImageResource(R.drawable.achievement__flatline);
                                            Auth2Activity.this._ViewFadeIn(Auth2Activity.this.imageview1, 400.0d);
                                        }
                                    });
                                }
                            };
                            Auth2Activity.this._timer.schedule(Auth2Activity.this.timer2, 300);
                            Auth2Activity.this.slideshow_num = 3.0d;
                        } else if (Auth2Activity.this.slideshow_num == 3.0d) {
                            Auth2Activity.this._textAnimation(Auth2Activity.this.textview2, "Making your app better");
                            Auth2Activity.this._textAnimation(Auth2Activity.this.textview3, "Updatify makes your audience love your app");
                            Auth2Activity.this._FadeOutInView(Auth2Activity.this.imageview1);
                            Auth2Activity.this.timer2 = new TimerTask() {
                                /* class com.updatify.o2nation.Auth2Activity.21.1.3 */

                                public void run() {
                                    Auth2Activity.this.runOnUiThread(new Runnable() {
                                        /* class com.updatify.o2nation.Auth2Activity.21.1.3.1 */

                                        public void run() {
                                            Auth2Activity.this.imageview1.setImageResource(R.drawable.rocket_boy_flatline);
                                            Auth2Activity.this._ViewFadeIn(Auth2Activity.this.imageview1, 400.0d);
                                        }
                                    });
                                }
                            };
                            Auth2Activity.this._timer.schedule(Auth2Activity.this.timer2, 300);
                            Auth2Activity.this.slideshow_num = 4.0d;
                        } else if (Auth2Activity.this.slideshow_num == 4.0d) {
                            Auth2Activity.this._textAnimation(Auth2Activity.this.textview2, "Let's get started");
                            Auth2Activity.this._textAnimation(Auth2Activity.this.textview3, "Sign in now to Updatify your apps");
                            Auth2Activity.this._FadeOutInView(Auth2Activity.this.imageview1);
                            Auth2Activity.this.timer2 = new TimerTask() {
                                /* class com.updatify.o2nation.Auth2Activity.21.1.4 */

                                public void run() {
                                    Auth2Activity.this.runOnUiThread(new Runnable() {
                                        /* class com.updatify.o2nation.Auth2Activity.21.1.4.1 */

                                        public void run() {
                                            Auth2Activity.this.imageview1.setImageResource(R.drawable.music_flatline);
                                            Auth2Activity.this._ViewFadeIn(Auth2Activity.this.imageview1, 400.0d);
                                        }
                                    });
                                }
                            };
                            Auth2Activity.this._timer.schedule(Auth2Activity.this.timer2, 300);
                            Auth2Activity.this.slideshow_num = 1.0d;
                        }
                    }
                });
            }
        };
        this._timer.scheduleAtFixedRate(this.timer1, 5000, 5000);
    }

    public void _HandleFacebookToken() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.updatify.o2nation.Auth2Activity */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: private */
    public void handleFacebookToken(AccessToken accessToken) {
        this.mAuth.signInWithCredential(FacebookAuthProvider.getCredential(accessToken.getToken())).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            /* class com.updatify.o2nation.Auth2Activity.22 */

            public void onComplete(@NonNull Task<AuthResult> task) {
                String str;
                Auth2Activity.this._coreLoading(false, "#FFFFFF", 120.0d, "#FFFFFF", 0.0d);
                if (task.isSuccessful()) {
                    FirebaseUser currentUser = Auth2Activity.this.mAuth.getCurrentUser();
                    if (((AuthResult) task.getResult()).getAdditionalUserInfo().isNewUser()) {
                        if (currentUser.getPhotoUrl() != null) {
                            str = String.valueOf(currentUser.getPhotoUrl().toString()) + "?type=large";
                        } else {
                            str = "https://nerbly.com/updatify/media/icon.jpg";
                        }
                        Auth2Activity.this.authMap = new HashMap();
                        Auth2Activity.this.authMap.put("email", currentUser.getEmail());
                        Auth2Activity.this.authMap.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
                        Auth2Activity.this.authMap.put("username", currentUser.getDisplayName());
                        Auth2Activity.this.authMap.put("slots", "0");
                        Auth2Activity.this.authMap.put("maxSlots", "3");
                        Auth2Activity.this.authMap.put("membership", "Free Membership");
                        Auth2Activity.this.authMap.put("userimg", str);
                        Auth2Activity.this.authMap.put("account_status", "true");
                        Auth2Activity.this.DBUsers.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(Auth2Activity.this.authMap);
                        Auth2Activity.this.authMap.clear();
                    }
                    Auth2Activity.this.tohome.setClass(Auth2Activity.this.getApplicationContext(), HomeActivity.class);
                    Auth2Activity.this.startActivity(Auth2Activity.this.tohome);
                    Auth2Activity.this.finish();
                    return;
                }
                Auth2Activity.this._showCustomSnackBar("Authentication failed, try again");
            }
        });
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.updatify.o2nation.Auth2Activity */
    /* JADX WARN: Multi-variable type inference failed */
    public void _onFacebookAuthClick() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") == -1 || ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == -1) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1001);
            _showCustomSnackBar("Please allow permission to continue");
            return;
        }
        try {
            LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile", "email"));
            _coreLoading(true, "#FFFFFF", 90.0d, "#FFFFFF", 0.0d);
        } catch (Exception e) {
            _showCustomSnackBar(e.toString());
        }
    }

    public void _setUpVideoView() {
    }

    public void _LOGIC_FRONTEND() {
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
            _LIGHT_ICONS();
            this.rootview.setBackgroundColor(-15198184);
            this.textview2.setTextColor(-1);
            this.textview4.setTextColor(-1);
            _NavStatusBarColor("#181818", "#181818");
            _rippleRoundStroke(this.google_login_btn, "#181818", "#424242", 90.0d, 1.0d, "#424242");
        } else {
            _DARK_ICONS();
            this.rootview.setBackgroundColor(-1);
            _NavStatusBarColor("#FFFFFF", "#FFFFFF");
            _rippleRoundStroke(this.google_login_btn, "#FFFFFF", "#E0E0E0", 90.0d, 1.0d, "#BDBDBD");
        }
        _ICC(this.imageview4, "#FFFFFF", "#FFFFFF");
        _changeActivityFont("product_med");
        _rippleRoundStroke(this.fb_login_btn, "#167AF2", "#FFFFFF", 90.0d, 0.0d, "#BDBDBD");
    }

    public void _LOGIC_BACKEND() {
        OverScrollDecoratorHelper.setUpStaticOverScroll(this.background, 0);
    }
}
