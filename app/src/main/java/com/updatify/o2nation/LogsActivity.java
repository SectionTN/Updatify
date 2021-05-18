package com.updatify.o2nation;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

public class LogsActivity extends AppCompatActivity {
    private ChildEventListener _DBLogs_child_listener;
    private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
    private DatabaseReference DBLogs = this._firebase.getReference("LOGSIEUDJFKSI8272827IDJD");
    private OnCompleteListener<AuthResult> _mAuth_create_user_listener;
    private OnCompleteListener<Void> _mAuth_reset_password_listener;
    private OnCompleteListener<AuthResult> _mAuth_sign_in_listener;
    private String activityFontName = "";
    private LinearLayout ads_back;
    private AdView fbBanner;
    private InterstitialAd fbInterstitial;
    private ImageView imageview1;
    private ImageView imageview3;
    private boolean isAdmobAvailable = false;
    private LinearLayout line1;
    private LinearLayout line2;
    private LinearLayout linear1;
    private LinearLayout linear2;
    private LinearLayout linear3;
    private LinearLayout linear6;
    private double loadAdsLimit = 0.0d;
    private ArrayList<HashMap<String, Object>> logsList = new ArrayList<>();
    private FirebaseAuth mAuth;
    private OnCompleteListener<Void> mAuth_deleteUserListener;
    private OnCompleteListener<Void> mAuth_emailVerificationSentListener;
    private OnCompleteListener<AuthResult> mAuth_googleSignInListener;
    private OnCompleteListener<AuthResult> mAuth_phoneAuthListener;
    private OnCompleteListener<Void> mAuth_updateEmailListener;
    private OnCompleteListener<Void> mAuth_updatePasswordListener;
    private OnCompleteListener<Void> mAuth_updateProfileListener;
    private RecyclerView recyclerview1;
    private SharedPreferences sharedPref;
    private TextView textview1;
    private TextView textview2;
    private TextView textview3;
    private String userId = "";

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.updatify.o2nation.LogsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        LogsActivity.super.onCreate(bundle);
        setContentView(R.layout.logs);
        initialize(bundle);
        FirebaseApp.initializeApp(this);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this.linear1 = (LinearLayout) findViewById(R.id.linear1);
        this.line1 = (LinearLayout) findViewById(R.id.line1);
        this.ads_back = (LinearLayout) findViewById(R.id.ads_back);
        this.linear3 = (LinearLayout) findViewById(R.id.linear3);
        this.line2 = (LinearLayout) findViewById(R.id.line2);
        this.recyclerview1 = findViewById(R.id.recyclerview1);
        this.linear2 = (LinearLayout) findViewById(R.id.linear2);
        this.imageview1 = (ImageView) findViewById(R.id.imageview1);
        this.linear6 = (LinearLayout) findViewById(R.id.linear6);
        this.textview1 = (TextView) findViewById(R.id.textview1);
        this.imageview3 = (ImageView) findViewById(R.id.imageview3);
        this.textview2 = (TextView) findViewById(R.id.textview2);
        this.textview3 = (TextView) findViewById(R.id.textview3);
        this.sharedPref = getSharedPreferences("sharedPref", 0);
        this.mAuth = FirebaseAuth.getInstance();
        this.imageview1.setOnClickListener(new View.OnClickListener() {
            /* class com.updatify.o2nation.LogsActivity.1 */

            public void onClick(View view) {
                LogsActivity.this.supportFinishAfterTransition();
            }
        });
        this._DBLogs_child_listener = new ChildEventListener() {
            /* class com.updatify.o2nation.LogsActivity.2 */

            public void onChildAdded(DataSnapshot dataSnapshot, String str) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.LogsActivity.2.1 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
            }

            public void onChildChanged(DataSnapshot dataSnapshot, String str) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.LogsActivity.2.2 */
                };
                dataSnapshot.getKey();
                HashMap hashMap = (HashMap) dataSnapshot.getValue(r0);
            }

            public void onChildMoved(DataSnapshot dataSnapshot, String str) {
            }

            public void onChildRemoved(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<HashMap<String, Object>> r0 = new GenericTypeIndicator<HashMap<String, Object>>() {
                    /* class com.updatify.o2nation.LogsActivity.2.3 */
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
        this.mAuth_updateEmailListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.LogsActivity.3 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_updatePasswordListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.LogsActivity.4 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_emailVerificationSentListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.LogsActivity.5 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_deleteUserListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.LogsActivity.6 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
            /* class com.updatify.o2nation.LogsActivity.7 */

            public void onComplete(Task<AuthResult> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_updateProfileListener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.LogsActivity.8 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this.mAuth_googleSignInListener = new OnCompleteListener<AuthResult>() {
            /* class com.updatify.o2nation.LogsActivity.9 */

            public void onComplete(Task<AuthResult> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this._mAuth_create_user_listener = new OnCompleteListener<AuthResult>() {
            /* class com.updatify.o2nation.LogsActivity.10 */

            public void onComplete(Task<AuthResult> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this._mAuth_sign_in_listener = new OnCompleteListener<AuthResult>() {
            /* class com.updatify.o2nation.LogsActivity.11 */

            public void onComplete(Task<AuthResult> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this._mAuth_reset_password_listener = new OnCompleteListener<Void>() {
            /* class com.updatify.o2nation.LogsActivity.12 */

            public void onComplete(Task<Void> task) {
                task.isSuccessful();
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.updatify.o2nation.LogsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void initializeLogic() {
        this.recyclerview1.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerview1.setHasFixedSize(true);
        this.loadAdsLimit = 0.0d;
        _LOGIC_UI();
        this.sharedPref.edit().putString("LastActivity", "LogsActivity.Java").commit();
        _changeLogsReference();
        _transitionComplete(this.textview1, "tolog");
        AudienceNetworkAds.initialize(this);
        this.fbBanner = new AdView(this, "278142536768563_297676561481827", AdSize.BANNER_HEIGHT_50);
        this.ads_back.addView(this.fbBanner);
        this.fbBanner.loadAd();
        this.fbInterstitial = new InterstitialAd(this, "278142536768563_320780439171439");
        this.fbInterstitial.loadAd();
        OverScrollDecoratorHelper.setUpOverScroll(this.recyclerview1, 0);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        LogsActivity.super.onActivityResult(i, i2, intent);
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

    public void _setBgCorners(View view, double d, String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#" + str.replace("#", "")));
        gradientDrawable.setCornerRadius((float) ((int) d));
        gradientDrawable.setStroke(0, -1);
        view.setBackground(gradientDrawable);
    }

    public void _removeScollBar(View view) {
        view.setVerticalScrollBarEnabled(false);
        view.setHorizontalScrollBarEnabled(false);
    }

    public void _removeListViewSelect(ListView listView) {
        listView.setSelector(17170445);
    }

    public void _ICC(ImageView imageView, String str, String str2) {
        imageView.setImageTintList(new ColorStateList(new int[][]{new int[]{-16842919}, new int[]{16842919}}, new int[]{Color.parseColor(str), Color.parseColor(str2)}));
    }

    public void _RippleEffects(String str, View view) {
        view.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor(str)}), null, null));
    }

    public void _clickAnim(final View view) {
        view.setOnTouchListener(new View.OnTouchListener() {
            /* class com.updatify.o2nation.LogsActivity.13 */

            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case RequestNetworkController.REQUEST_PARAM /*{ENCODED_INT: 0}*/:
                        LogsActivity.this._shadAnim(view, "scaleX", 1.05d, 100.0d);
                        LogsActivity.this._shadAnim(view, "scaleY", 1.05d, 100.0d);
                        return false;
                    case RequestNetworkController.REQUEST_BODY /*{ENCODED_INT: 1}*/:
                        LogsActivity.this._shadAnim(view, "scaleX", 1.0d, 100.0d);
                        LogsActivity.this._shadAnim(view, "scaleY", 1.0d, 100.0d);
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

    public void _DARK_ICONS() {
        getWindow().getDecorView().setSystemUiVisibility(8192);
    }

    public void _transitionComplete(View view, String str) {
        view.setTransitionName(str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.updatify.o2nation.LogsActivity */
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

    public void _LOGIC_UI() {
        _RippleEffects("#EEEEEE", this.imageview1);
        _clickAnim(this.imageview1);
        this.textview1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
        this.textview2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
        this.textview3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
        this.recyclerview1.setVisibility(View.GONE);
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
        if (this.sharedPref.getString("dark", "").equals("true")) {
            _ICC(this.imageview1, "#FFFFFF", "#FFFFFF");
            _NavStatusBarColor("#181818", "#181818");
            _LIGHT_ICONS();
            this.linear1.setBackgroundColor(-15198184);
            this.line1.setBackgroundColor(-12434878);
            this.line2.setBackgroundColor(-12434878);
            this.textview2.setTextColor(-1);
            this.textview1.setTextColor(-1);
            this.ads_back.setBackgroundColor(-15198184);
            return;
        }
        _ICC(this.imageview1, "#9E9E9E", "#CC9E9E9E");
        _DARK_ICONS();
        _NavStatusBarColor("#FFFFFF", "#FFFFFF");
    }

    public void _LIGHT_ICONS() {
        getWindow().getDecorView().setSystemUiVisibility(0);
    }

    public void _changeLogsReference() {
        this.userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        this.DBLogs = this._firebase.getReference("USERS2827IWUWIEHDN8273").child(this.userId).child("LOGS");
        this.DBLogs.addListenerForSingleValueEvent(new ValueEventListener() {
            /* class com.updatify.o2nation.LogsActivity.14 */

            public void onDataChange(DataSnapshot dataSnapshot) {
                LogsActivity.this.logsList = new ArrayList();
                try {
                    GenericTypeIndicator<HashMap<String, Object>> r1 = new GenericTypeIndicator<HashMap<String, Object>>() {
                        /* class com.updatify.o2nation.LogsActivity.14.1 */
                    };
                    for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                        LogsActivity.this.logsList.add((HashMap) dataSnapshot2.getValue(r1));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (LogsActivity.this.logsList.size() == 0) {
                    LogsActivity.this.linear2.setVisibility(View.VISIBLE);
                    LogsActivity.this.recyclerview1.setVisibility(View.GONE);
                    LogsActivity.this.imageview3.setImageResource(R.drawable.dream_flatline);
                    LogsActivity.this.textview2.setText("No logs available yet");
                    LogsActivity.this.textview3.setText("it's seems like you've not tried Updatify yet, go to tutorial page to learn how to use it :)");
                    return;
                }
                LogsActivity.this.linear2.setVisibility(View.GONE);
                LogsActivity.this.recyclerview1.setVisibility(View.VISIBLE);
                Collections.reverse(LogsActivity.this.logsList);
                LogsActivity.this.recyclerview1.setAdapter(new Recyclerview1Adapter(LogsActivity.this.logsList));
            }

            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public class Recyclerview1Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        ArrayList<HashMap<String, Object>> _data;


        public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> arrayList) {
            this._data = arrayList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(((LayoutInflater) LogsActivity.this.getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE)).inflate(R.layout.log, (ViewGroup) null));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            View view = viewHolder.itemView;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linear1);
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.linear4);
            LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.linear3);
            TextView textView = (TextView) view.findViewById(R.id.textview1);
            TextView textView2 = (TextView) view.findViewById(R.id.textview2);
            view.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            LogsActivity.this._setBgCorners((LinearLayout) view.findViewById(R.id.linear2), 100.0d, ((HashMap) LogsActivity.this.logsList.get(i)).get("color").toString());
            textView.setTypeface(Typeface.createFromAsset(LogsActivity.this.getAssets(), "fonts/product_med.ttf"), Typeface.NORMAL);
            textView2.setTypeface(Typeface.createFromAsset(LogsActivity.this.getAssets(), "fonts/product_normal.ttf"), Typeface.NORMAL);
            textView.setText(((HashMap) LogsActivity.this.logsList.get(i)).get("appname").toString());
            textView2.setText(((HashMap) LogsActivity.this.logsList.get(i)).get("status").toString());
            if (LogsActivity.this.sharedPref.getString("dark", "").equals("true")) {
                textView.setTextColor(-1);
                linearLayout2.setBackgroundColor(-12434878);
            }
            linearLayout.setOnClickListener(new View.OnClickListener() {
                /* class com.updatify.o2nation.LogsActivity.Recyclerview1Adapter.1 */

                /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, com.updatify.o2nation.LogsActivity] */
                /* JADX WARNING: Unknown variable types count: 1 */
                public void onClick(View view) {
                    LogsActivity.this.fbInterstitial.show();
                    LogsActivity.this.fbInterstitial = new InterstitialAd((Context) LogsActivity.this, "278142536768563_320780439171439");
                    LogsActivity.this.fbInterstitial.loadAd();
                }
            });
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
