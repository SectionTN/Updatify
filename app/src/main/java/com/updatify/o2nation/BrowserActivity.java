package com.updatify.o2nation;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class BrowserActivity extends AppCompatActivity {
    View _inflate;
    Snackbar.SnackbarLayout _sblayout;
    Snackbar _snackBarView;
    private ChildEventListener _DBPushUsers_child_listener;
    private ChildEventListener _DBUsers_child_listener;
    private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
    private DatabaseReference DBPushUsers = this._firebase.getReference("USERS2827IWUWIEHDN8273");
    private DatabaseReference DBUsers = this._firebase.getReference("USERS2827IWUWIEHDN8273");
    private OnCompleteListener<AuthResult> _mAuth_create_user_listener;
    private OnCompleteListener<Void> _mAuth_reset_password_listener;
    private OnCompleteListener<AuthResult> _mAuth_sign_in_listener;
    private Timer _timer = new Timer();
    private HashMap<String, Object> authMap = new HashMap<>();
    private double availableSlots = 0.0d;
    private double doubleBackExit = 0.0d;
    private boolean isFirstView = false;
    private boolean isPurchased = false;
    private LinearLayout linear1;
    private FirebaseAuth mAuth;
    private OnCompleteListener<Void> mAuth_deleteUserListener;
    private OnCompleteListener<Void> mAuth_emailVerificationSentListener;
    private OnCompleteListener<AuthResult> mAuth_googleSignInListener;
    private OnCompleteListener<AuthResult> mAuth_phoneAuthListener;
    private OnCompleteListener<Void> mAuth_updateEmailListener;
    private OnCompleteListener<Void> mAuth_updatePasswordListener;
    private OnCompleteListener<Void> mAuth_updateProfileListener;
    private double maxSlots = 0.0d;
    private ProgressBar progressbar1;
    private TimerTask timer;
    private Intent toauth = new Intent();
    private Intent tohome = new Intent();
    private String userId = "";
    private TimerTask waitThenHome;
    private WebView webview1;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.updatify.o2nation.BrowserActivity */
    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        BrowserActivity.super.onCreate(bundle);
        setContentView(R.layout.browser);
        initialize(bundle);
        FirebaseApp.initializeApp(this);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this.linear1 = (LinearLayout) findViewById(R.id.linear1);
        this.progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
        this.webview1 = (WebView) findViewById(R.id.webview1);
        this.webview1.getSettings().setJavaScriptEnabled(true);
        this.webview1.getSettings().setSupportZoom(true);
        this.mAuth = FirebaseAuth.getInstance();
        this.webview1.setWebViewClient(new WebViewClient() {
            /* class com.updatify.o2nation.BrowserActivity.1 */

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }
        });
        this._DBUsers_child_listener = new ChildEventListener() {
            /* class com.updatify.o2nation.BrowserActivity.2 */

            public void onChildAdded(DataSnapshot dataSnapshot, String str) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.BrowserActivity.2.1 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
            }

            public void onChildChanged(DataSnapshot dataSnapshot, String str) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.BrowserActivity.2.2 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
                if (FirebaseAuth.getInstance().getCurrentUser() != null) {
                    try {
                        BrowserActivity.this.DBUsers.addValueEventListener(new ValueEventListener() {
                            /* class com.updatify.o2nation.BrowserActivity.2.3 */

                            public void onDataChange(DataSnapshot dataSnapshot) {
                                BrowserActivity.this.maxSlots = Double.parseDouble((String) dataSnapshot.child("maxSlots").getValue(String.class));
                                BrowserActivity.this.availableSlots = Double.parseDouble((String) dataSnapshot.child("slots").getValue(String.class));
                            }

                            public void onCancelled(DatabaseError databaseError) {
                            }
                        });
                    } catch (Exception e) {
                        SketchwareUtil.showMessage(BrowserActivity.this.getApplicationContext(), e.toString());
                    }
                } else {
                    BrowserActivity.this.toauth.setClass(BrowserActivity.this.getApplicationContext(), Auth2Activity.class);
                    BrowserActivity.this.startActivity(BrowserActivity.this.toauth);
                    FirebaseAuth.getInstance().signOut();
                    BrowserActivity.this.finish();
                }
            }

            public void onChildMoved(DataSnapshot dataSnapshot, String str) {
            }

            public void onChildRemoved(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.BrowserActivity.2.4 */
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
        this._DBPushUsers_child_listener = new ChildEventListener() {
            /* class com.updatify.o2nation.BrowserActivity.3 */

            public void onChildAdded(DataSnapshot dataSnapshot, String str) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.BrowserActivity.3.1 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
            }

            public void onChildChanged(DataSnapshot dataSnapshot, String str) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.BrowserActivity.3.2 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
            }

            public void onChildMoved(DataSnapshot dataSnapshot, String str) {
            }

            public void onChildRemoved(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.BrowserActivity.3.3 */
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
        this.mAuth_updateEmailListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.BrowserActivity.4 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_updatePasswordListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.BrowserActivity.5 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_emailVerificationSentListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.BrowserActivity.6 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_deleteUserListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.BrowserActivity.7 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
            /* class com.updatify.o2nation.BrowserActivity.8 */

            public void onComplete(Task<AuthResult> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_updateProfileListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.BrowserActivity.9 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_googleSignInListener = new OnCompleteListener<AuthResult>() {
            /* class com.updatify.o2nation.BrowserActivity.10 */

            public void onComplete(Task<AuthResult> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this._mAuth_create_user_listener = new OnCompleteListener<AuthResult>() {
            /* class com.updatify.o2nation.BrowserActivity.11 */

            public void onComplete(Task<AuthResult> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this._mAuth_sign_in_listener = new OnCompleteListener<AuthResult>() {
            /* class com.updatify.o2nation.BrowserActivity.12 */

            public void onComplete(Task<AuthResult> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this._mAuth_reset_password_listener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.BrowserActivity.13 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
            }
        };
    }

    private void initializeLogic() {
        _NavStatusBarColor("#FFFFFF", "#FFFFFF");
        _DARK_ICONS();
        _removeScollBar(this.webview1);
        this.isPurchased = false;
        this.isFirstView = false;
        this.webview1.loadUrl(getIntent().getStringExtra("url"));
        _swipeToRefreshWeb(this.webview1, this.linear1);
        _webviewProgress(this.progressbar1, this.webview1);
        _changeUserReference();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        BrowserActivity.super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (getIntent().getStringExtra("mode").equals("pay")) {
            if (this.doubleBackExit == 0.0d) {
                _showCustomSnackBar("Click twice to cancel the payment");
                this.timer = new TimerTask() {
                    /* class com.updatify.o2nation.BrowserActivity.14 */

                    public void run() {
                        BrowserActivity.this.runOnUiThread(new Runnable() {
                            /* class com.updatify.o2nation.BrowserActivity.14.1 */

                            public void run() {
                                BrowserActivity.this.doubleBackExit = 1.0d;
                            }
                        });
                    }
                };
                this._timer.schedule(this.timer, 0);
                this.timer = new TimerTask() {
                    /* class com.updatify.o2nation.BrowserActivity.15 */

                    public void run() {
                        BrowserActivity.this.runOnUiThread(new Runnable() {
                            /* class com.updatify.o2nation.BrowserActivity.15.1 */

                            public void run() {
                                BrowserActivity.this.doubleBackExit = 0.0d;
                            }
                        });
                    }
                };
                this._timer.schedule(this.timer, 1200);
            }
            if (this.doubleBackExit == 1.0d) {
                this.DBUsers.removeEventListener(this._DBUsers_child_listener);
                finish();
            }
        } else if (this.webview1.canGoBack()) {
            this.webview1.goBack();
        } else {
            this.DBUsers.removeEventListener(this._DBUsers_child_listener);
            finish();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.updatify.o2nation.BrowserActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void _swipeToRefreshWeb(final WebView webView, View view) {
        try {
            final View swipeRefreshLayout = new SwipeRefreshLayout(this);
            swipeRefreshLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            ((LinearLayout) view).addView(swipeRefreshLayout);
            webView.getSettings().setJavaScriptEnabled(true);
            ((LinearLayout) view).removeView(webView);
            ((LinearLayout) view).post(new Runnable() {
                /* class com.updatify.o2nation.BrowserActivity.16 */

                public void run() {
                    ((SwipeRefreshLayout) swipeRefreshLayout).addView(webView);
                }
            });
            ((SwipeRefreshLayout) swipeRefreshLayout).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                /* class com.updatify.o2nation.BrowserActivity.17 */

                public void onRefresh() {
                    webView.reload();
                }
            });
            webView.setWebViewClient(new WebViewClient() {
                /* class com.updatify.o2nation.BrowserActivity.18 */

                public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    if (str.equals("https://nerbly.com/payment/updatify/paymentok")) {
                        if (BrowserActivity.this.isFirstView) {
                            BrowserActivity.this.isPurchased = true;
                            BrowserActivity.this.isFirstView = false;
                            BrowserActivity.this.authMap.put("maxSlots", String.valueOf((long) (BrowserActivity.this.maxSlots + 5.0d)));
                            BrowserActivity.this.DBPushUsers.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(BrowserActivity.this.authMap);
                            BrowserActivity.this.authMap.clear();
                            SketchwareUtil.showMessage(BrowserActivity.this.getApplicationContext(), "Payment successful, thank you!");
                            BrowserActivity.this.waitThenHome = new TimerTask() {
                                /* class com.updatify.o2nation.BrowserActivity.18.1 */

                                public void run() {
                                    BrowserActivity.this.runOnUiThread(new Runnable() {
                                        /* class com.updatify.o2nation.BrowserActivity.18.1.1 */

                                        public void run() {
                                            BrowserActivity.this.tohome.setClass(BrowserActivity.this.getApplicationContext(), HomeActivity.class);
                                            BrowserActivity.this.startActivity(BrowserActivity.this.tohome);
                                            BrowserActivity.this.finish();
                                        }
                                    });
                                }
                            };
                            BrowserActivity.this._timer.schedule(BrowserActivity.this.waitThenHome, 1000);
                            return;
                        }
                        BrowserActivity.this.isPurchased = false;
                        SketchwareUtil.showMessage(BrowserActivity.this.getApplicationContext(), "You already purchased slots, you'll be redirected to home shortly");
                    } else if (str.equals("https://nerbly.com/payment/updatify/paymentfail")) {
                        SketchwareUtil.showMessage(BrowserActivity.this.getApplicationContext(), "Payment cancelled by user");
                        BrowserActivity.this.finish();
                    }
                }

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    webView.loadUrl(str);
                    return true;
                }

                public void onPageFinished(WebView webView, String str) {
                    ((SwipeRefreshLayout) swipeRefreshLayout).setRefreshing(false);
                    if (str.equals("https://nerbly.com/payment/updatify/paymentok")) {
                        BrowserActivity.this.waitThenHome = new TimerTask() {
                            /* class com.updatify.o2nation.BrowserActivity.18.2 */

                            public void run() {
                                BrowserActivity.this.runOnUiThread(new Runnable() {
                                    /* class com.updatify.o2nation.BrowserActivity.18.2.1 */

                                    public void run() {
                                        BrowserActivity.this.tohome.setClass(BrowserActivity.this.getApplicationContext(), HomeActivity.class);
                                        BrowserActivity.this.startActivity(BrowserActivity.this.tohome);
                                        BrowserActivity.this.finish();
                                    }
                                });
                            }
                        };
                        BrowserActivity.this._timer.schedule(BrowserActivity.this.waitThenHome, 2000);
                    } else if (str.equals("https://nerbly.com/payment/updatify/paymentfail")) {
                        BrowserActivity.this.finish();
                    }
                }

                public void onReceivedError(WebView webView, int i, String str, String str2) {
                    BrowserActivity.this.webview1.setVisibility(View.GONE);
                    SketchwareUtil.showMessage(BrowserActivity.this.getApplicationContext(), "Check your internet connection!");
                    BrowserActivity.this.finish();
                }
            });
        } catch (Exception ignored) {
        }
    }

    public void _webviewProgress(final ProgressBar progressBar, WebView webView) {
        progressBar.setFitsSystemWindows(true);
        progressBar.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_INSET);
        webView.setWebChromeClient(new WebChromeClient() {
            /* class com.updatify.o2nation.BrowserActivity.19 */

            public void onProgressChanged(WebView webView, int i) {
                progressBar.setProgress(i);
            }
        });
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

    public void _showCustomSnackBar(String str) {
        // TODO : Res class
        this._snackBarView = Snackbar.make((ViewGroup) ((ViewGroup) findViewById(0x1020002)).getChildAt(0), "", 0);
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

    public void _setViewRadius(View view, double d, String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#" + str.replace("#", "")));
        gradientDrawable.setCornerRadius((float) ((int) d));
        view.setBackground(gradientDrawable);
    }

    public void _changeUserReference() {
        this.userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        this.DBUsers = this._firebase.getReference("USERS2827IWUWIEHDN8273").child(this.userId);
        this.DBUsers.addValueEventListener(new ValueEventListener() {
            /* class com.updatify.o2nation.BrowserActivity.20 */

            public void onDataChange(DataSnapshot dataSnapshot) {
                BrowserActivity.this.maxSlots = Double.parseDouble((String) dataSnapshot.child("maxSlots").getValue(String.class));
                BrowserActivity.this.availableSlots = Double.parseDouble((String) dataSnapshot.child("slots").getValue(String.class));
            }

            public void onCancelled(DatabaseError databaseError) {
                BrowserActivity.this.finish();
                SketchwareUtil.showMessage(BrowserActivity.this.getApplicationContext(), "Check your internet connection!");
            }
        });
    }
}
