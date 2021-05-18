package com.updatify.o2nation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
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
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    View _inflate;
    Snackbar.SnackbarLayout _sblayout;
    Snackbar _snackBarView;
    private OnCompleteListener<AuthResult> _mAuth_create_user_listener;
    private OnCompleteListener<Void> _mAuth_reset_password_listener;
    private OnCompleteListener<AuthResult> _mAuth_sign_in_listener;
    private RequestNetwork.RequestListener _requestVersion_request_listener;
    private Timer _timer = new Timer();
    private String activityFontName = "";
    private double checkVal = 0.0d;
    private ImageView imageview1;
    private LinearLayout linear1;
    private LinearLayout linear2;
    private ImageView logo;
    private FirebaseAuth mAuth;
    private OnCompleteListener<Void> mAuth_deleteUserListener;
    private OnCompleteListener<Void> mAuth_emailVerificationSentListener;
    private OnCompleteListener<AuthResult> mAuth_googleSignInListener;
    private OnCompleteListener<AuthResult> mAuth_phoneAuthListener;
    private OnCompleteListener<Void> mAuth_updateEmailListener;
    private OnCompleteListener<Void> mAuth_updatePasswordListener;
    private OnCompleteListener<Void> mAuth_updateProfileListener;
    private HashMap<String, Object> map = new HashMap<>();
    private RequestNetwork requestVersion;
    private String requiredPermission = "";
    private SharedPreferences sharedPref;
    private TextView textview1;
    private TextView textview2;
    private TextView textview3;
    private TimerTask timer;
    private Intent toAuth = new Intent();
    private Intent toHome = new Intent();
    private Intent tobrowser = new Intent();
    private double versionCode = 0.0d;
    private HashMap<String, Object> versionMap = new HashMap<>();
    private String versionName = "";

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.updatify.o2nation.MainActivity */
    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        MainActivity.super.onCreate(bundle);
        setContentView(R.layout.main);
        initialize(bundle);
        FirebaseApp.initializeApp(this);
        initializeLogic();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.updatify.o2nation.MainActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void initialize(Bundle bundle) {
        this.linear1 = (LinearLayout) findViewById(R.id.linear1);
        this.logo = (ImageView) findViewById(R.id.logo);
        this.linear2 = (LinearLayout) findViewById(R.id.linear2);
        this.imageview1 = (ImageView) findViewById(R.id.imageview1);
        this.textview1 = (TextView) findViewById(R.id.textview1);
        this.textview2 = (TextView) findViewById(R.id.textview2);
        this.textview3 = (TextView) findViewById(R.id.textview3);
        this.sharedPref = getSharedPreferences("sharedPref", 0);
        this.mAuth = FirebaseAuth.getInstance();
        this.requestVersion = new RequestNetwork(this);
        this.textview3.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.MainActivity.1 */

            /* JADX WARN: Type inference failed for: r0v0, types: [com.updatify.o2nation.MainActivity, android.app.Activity] */
            /* JADX WARNING: Unknown variable types count: 1 */
            public void onClick(View view) {
                ActivityCompat.requestPermissions((Activity) MainActivity.this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1001);
            }
        });
        this._requestVersion_request_listener = new RequestNetwork.RequestListener() {
            /* class com.updatify.o2nation.MainActivity.2 */

            /* JADX WARN: Type inference failed for: r2v21, types: [android.content.Context, com.updatify.o2nation.MainActivity] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // com.updatify.o2nation.RequestNetwork.RequestListener
            public void onResponse(String str, String str2, HashMap<String, Object> hashMap) {
                try {
                    MainActivity.this.versionMap = (HashMap) new Gson().fromJson(str2, new TypeToken<HashMap<String, Object>>() {
                        /* class com.updatify.o2nation.MainActivity.2.1 */
                    }.getType());
                    if (Double.parseDouble(MainActivity.this.versionMap.get("newversion").toString()) > Double.parseDouble(MainActivity.this.versionName)) {
                        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog((Context) MainActivity.this);
                        View inflate = MainActivity.this.getLayoutInflater().inflate(R.layout.info_sheet, (ViewGroup) null);
                        bottomSheetDialog.setContentView(inflate);
                        bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(17170445);
                        TextView textView = (TextView) inflate.findViewById(R.id.infosheet_ok);
                        TextView textView2 = (TextView) inflate.findViewById(R.id.infosheet_cancel);
                        TextView textView3 = (TextView) inflate.findViewById(R.id.infosheet_title);
                        TextView textView4 = (TextView) inflate.findViewById(R.id.infosheet_sub);
                        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.infosheet_back);
                        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.infosheet_btn_holder);
                        textView3.setTypeface(Typeface.createFromAsset(MainActivity.this.getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
                        textView4.setTypeface(Typeface.createFromAsset(MainActivity.this.getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
                        textView.setTypeface(Typeface.createFromAsset(MainActivity.this.getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
                        textView2.setTypeface(Typeface.createFromAsset(MainActivity.this.getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
                        ((ImageView) inflate.findViewById(R.id.infosheet_img)).setImageResource(R.drawable.marketing__flatline);
                        textView.setText(MainActivity.this.versionMap.get("okay").toString());
                        textView2.setText(MainActivity.this.versionMap.get("cancel").toString());
                        textView3.setText(MainActivity.this.versionMap.get("title").toString());
                        textView4.setText(MainActivity.this.versionMap.get("subtitle").toString());
                        MainActivity.this._rippleRoundStroke(textView, "#006DF6", "#16FFFFFF", 25.0d, 0.0d, "#006DF6");
                        if (MainActivity.this.sharedPref.getString("dark", "").equals("true")) {
                            MainActivity.this._setBgCorners(linearLayout, 25.0d, "#181818");
                            MainActivity.this._rippleRoundStroke(textView2, "#424242", "#212121", 25.0d, 0.0d, "#006DF6");
                            textView2.setTextColor(-1);
                        } else {
                            MainActivity.this._setBgCorners(linearLayout, 25.0d, "#FFFFFF");
                            MainActivity.this._rippleRoundStroke(textView2, "#F5F5F5", "#E0E0E0", 25.0d, 0.0d, "#006DF6");
                        }
                        if (MainActivity.this.versionMap.get("exittype").toString().equals("1")) {
                            textView2.setVisibility(View.GONE);
                        }
                        textView.setOnClickListener(new View.OnClickListener() {
                            /* class com.updatify.o2nation.MainActivity.2.2 */

                            public void onClick(View view) {
                                if (MainActivity.this.versionMap.get("mainaction").toString().equals("update")) {
                                    MainActivity.this.tobrowser.setAction("android.intent.action.VIEW");
                                    MainActivity.this.tobrowser.setData(Uri.parse(MainActivity.this.versionMap.get("link").toString()));
                                    MainActivity.this.startActivity(MainActivity.this.tobrowser);
                                } else if (MainActivity.this.versionMap.get("mainaction").toString().equals("exit")) {
                                    MainActivity.this.finishAffinity();
                                } else {
                                    SketchwareUtil.showMessage(MainActivity.this.getApplicationContext(), "Check main action");
                                }
                            }
                        });
                        textView2.setOnClickListener(new View.OnClickListener() {
                            /* class com.updatify.o2nation.MainActivity.2.3 */

                            public void onClick(View view) {
                                if (MainActivity.this.versionMap.get("cancelaction").toString().equals("exit")) {
                                    MainActivity.this.finishAffinity();
                                } else if (MainActivity.this.versionMap.get("cancelaction").toString().equals("update")) {
                                    MainActivity.this.tobrowser.setAction("android.intent.action.VIEW");
                                    MainActivity.this.tobrowser.setData(Uri.parse(MainActivity.this.versionMap.get("link").toString()));
                                    MainActivity.this.startActivity(MainActivity.this.tobrowser);
                                } else if (!MainActivity.this.versionMap.get("cancelaction").toString().equals("open")) {
                                } else {
                                    if (FirebaseAuth.getInstance().getCurrentUser() != null) {
                                        MainActivity.this.toHome.setClass(MainActivity.this.getApplicationContext(), HomeActivity.class);
                                        MainActivity.this.startActivity(MainActivity.this.toHome);
                                        MainActivity.this.finish();
                                        return;
                                    }
                                    MainActivity.this.toAuth.setClass(MainActivity.this.getApplicationContext(), Auth2Activity.class);
                                    MainActivity.this.startActivity(MainActivity.this.toAuth);
                                    MainActivity.this.finish();
                                }
                            }
                        });
                        if (MainActivity.this.versionMap.get("cancelable").toString().equals("true")) {
                            bottomSheetDialog.setCancelable(true);
                        } else {
                            bottomSheetDialog.setCancelable(false);
                        }
                        bottomSheetDialog.show();
                    } else if (FirebaseAuth.getInstance().getCurrentUser() != null) {
                        MainActivity.this.toHome.setClass(MainActivity.this.getApplicationContext(), HomeActivity.class);
                        MainActivity.this.startActivity(MainActivity.this.toHome);
                        MainActivity.this.finish();
                    } else {
                        MainActivity.this.toAuth.setClass(MainActivity.this.getApplicationContext(), Auth2Activity.class);
                        MainActivity.this.startActivity(MainActivity.this.toAuth);
                        MainActivity.this.finish();
                    }
                } catch (Exception e) {
                    SketchwareUtil.showMessage(MainActivity.this.getApplicationContext(), e.toString());
                }
            }

            @Override // com.updatify.o2nation.RequestNetwork.RequestListener
            public void onErrorResponse(String str, String str2) {
                MainActivity.this.requestVersion.startRequestNetwork(RequestNetworkController.GET, "https://nerbly.com/updatify/version.json", "", MainActivity.this._requestVersion_request_listener);
            }
        };
        this.mAuth_updateEmailListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.MainActivity.3 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_updatePasswordListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.MainActivity.4 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_emailVerificationSentListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.MainActivity.5 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_deleteUserListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.MainActivity.6 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
            /* class com.updatify.o2nation.MainActivity.7 */

            public void onComplete(Task<AuthResult> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_updateProfileListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.MainActivity.8 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_googleSignInListener = new OnCompleteListener<AuthResult>() {
            /* class com.updatify.o2nation.MainActivity.9 */

            public void onComplete(Task<AuthResult> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this._mAuth_create_user_listener = new OnCompleteListener<AuthResult>() {
            /* class com.updatify.o2nation.MainActivity.10 */

            public void onComplete(Task<AuthResult> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this._mAuth_sign_in_listener = new OnCompleteListener<AuthResult>() {
            /* class com.updatify.o2nation.MainActivity.11 */

            public void onComplete(Task<AuthResult> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this._mAuth_reset_password_listener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.MainActivity.12 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: com.updatify.o2nation.MainActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void initializeLogic() {
        _GetAppVersionInfo();
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
        this.linear2.setVisibility(View.GONE);
        this.sharedPref.getString("dark", "").equals("true");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColors(new int[]{Color.parseColor("#FF4099FF"), Color.parseColor("#FF0078FF")});
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TL_BR);
        gradientDrawable.setCornerRadius(0.0f);
        this.linear1.setBackground(gradientDrawable);
        if (ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") == -1 || ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == -1) {
            this.timer = new TimerTask() {
                /* class com.updatify.o2nation.MainActivity.13 */

                public void run() {
                    MainActivity.this.runOnUiThread(new Runnable() {
                        /* class com.updatify.o2nation.MainActivity.13.1 */

                        public void run() {
                            MainActivity.this._transitionViewTime(MainActivity.this.linear1, 200.0d);
                            MainActivity.this.linear2.setVisibility(View.VISIBLE);
                            MainActivity.this._NavStatusBarColor("#4099FF", "#FFFFFF");
                        }
                    });
                }
            };
            this._timer.schedule(this.timer, 1000);
        } else {
            this.requestVersion.startRequestNetwork(RequestNetworkController.GET, "https://nerbly.com/updatify/version.json", "", this._requestVersion_request_listener);
        }
        _changeActivityFont("product");
        _advancedCorners(this.linear2, "#FFFFFF", 30.0d, 30.0d, 0.0d, 0.0d);
        _rippleRoundStroke(this.textview3, "#0078FF", "#FFFFFF", 18.0d, 0.0d, "#0078FF");
        _NavStatusBarColor("#4099FF", "#0078FF");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        MainActivity.super.onActivityResult(i, i2, intent);
    }

    public void _ICC(ImageView imageView, String str, String str2) {
        imageView.setImageTintList(new ColorStateList(new int[][]{new int[]{-16842919}, new int[]{16842919}}, new int[]{Color.parseColor(str), Color.parseColor(str2)}));
    }

    public void _HideNavigationBar() {
        getWindow().getDecorView().setSystemUiVisibility(4098);
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

    public void _GetAppVersionInfo() {
        this.versionName = "null";
        this.versionCode = -1.0d;
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            this.versionName = packageInfo.versionName;
            this.versionCode = (double) packageInfo.versionCode;
        } catch (Exception e) {
        }
    }

    public void _advancedCorners(View view, String str, double d, double d2, double d3, double d4) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadii(new float[]{(float) ((int) d), (float) ((int) d), (float) ((int) d2), (float) ((int) d2), (float) ((int) d4), (float) ((int) d4), (float) ((int) d3), (float) ((int) d3)});
        view.setBackground(gradientDrawable);
    }

    public void _setBgCorners(View view, double d, String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#" + str.replace("#", "")));
        gradientDrawable.setCornerRadius((float) ((int) d));
        gradientDrawable.setStroke(0, -1);
        view.setBackground(gradientDrawable);
    }

    public void _FinishAffinity() {
        finishAffinity();
    }

    public void _rippleRoundStroke(View view, String str, String str2, double d, double d2, String str3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius((float) d);
        gradientDrawable.setStroke((int) d2, Color.parseColor("#" + str3.replace("#", "")));
        view.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor(str2)}), gradientDrawable, null));
    }

    public void _transparentStatusBar() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(-16743563);
            window.setFlags(512, 512);
        }
    }

    public void _LIGHT_ICONS() {
        getWindow().getDecorView().setSystemUiVisibility(0);
    }

    public void _checkPermission() {
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        MainActivity.super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 1001) {
            return;
        }
        if (iArr[0] == 0) {
            _transitionViewTime(this.linear1, 80.0d);
            this.linear2.setVisibility(View.GONE);
            this.requestVersion.startRequestNetwork(RequestNetworkController.GET, "https://nerbly.com/updatify/version.json", "", this._requestVersion_request_listener);
            _NavStatusBarColor("#4099FF", "#0078FF");
            return;
        }
        _showCustomSnackBar("We need permission to continue");
    }

    public void _showCustomSnackBar(String str) {
        this._snackBarView = Snackbar.make((ViewGroup) ((ViewGroup) findViewById(16908290)).getChildAt(0), "", 0);
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

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.updatify.o2nation.MainActivity */
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

    public void _transitionViewTime(View view, double d) {
        AutoTransition autoTransition = new AutoTransition();
        autoTransition.setDuration((long) ((short) ((int) d)));
        TransitionManager.beginDelayedTransition((LinearLayout) view, autoTransition);
    }
}
