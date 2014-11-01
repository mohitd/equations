/**
 * 
 */
package com.centauri.equations;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author mohitd2000
 * 
 */
public class AppRater {

    private final static String APP_TITLE = "Equations";

    private final static int DAYS_UNTIL_PROMPT = 3;
    private final static int LAUNCHES_UNTIL_PROMPT = 10;

    public static void appLaunched(Context mContext) {
        SharedPreferences prefs = mContext.getSharedPreferences("apprater",
                Context.MODE_PRIVATE);
        if (prefs.getBoolean("dontshowagain", false)) {
            return;
        }

        SharedPreferences.Editor editor = prefs.edit();

        // Increment launch counter
        long launch_count = prefs.getLong("launch_count", 0) + 1;
        editor.putLong("launch_count", launch_count);

        // Get date of first launch
        Long date_firstLaunch = prefs.getLong("date_firstlaunch", 0);
        if (date_firstLaunch == 0) {
            date_firstLaunch = System.currentTimeMillis();
            editor.putLong("date_firstlaunch", date_firstLaunch);
        }

        // Wait at least n days before opening
        if (launch_count >= LAUNCHES_UNTIL_PROMPT) {
            if (System.currentTimeMillis() >= date_firstLaunch
                    + (DAYS_UNTIL_PROMPT * 24 * 60 * 60 * 1000)) {
                showRateDialog(mContext, editor);
            }
        }

        editor.commit();
    }

    public static void showRateDialog(final Context mContext,
            final SharedPreferences.Editor editor) {
        final Dialog dialog = new Dialog(mContext);
        dialog.setTitle("Rate " + APP_TITLE);

        LinearLayout ll = new LinearLayout(mContext);
        ll.setOrientation(LinearLayout.VERTICAL);

        TextView tv = new TextView(mContext);
        tv.setText("If you enjoy using " + APP_TITLE
                + ", please take a moment to rate it. Thanks for your support!");
        tv.setPadding(4, 0, 4, 10);
        ll.addView(tv);

        Button b1 = new Button(mContext, null,
                android.R.attr.buttonBarButtonStyle);
        b1.setText("Rate " + APP_TITLE);
        b1.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri
                        .parse("market://details?id="
                                + mContext.getPackageName())));
                if (editor != null) {
                    editor.putBoolean("dontshowagain", true);
                    editor.commit();
                }
                dialog.dismiss();
            }
        });
        ll.addView(b1);

        Button b2 = new Button(mContext, null,
                android.R.attr.buttonBarButtonStyle);
        b2.setText("Remind me later");
        b2.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        ll.addView(b2);

        Button b3 = new Button(mContext, null,
                android.R.attr.buttonBarButtonStyle);
        b3.setText("No, thanks");
        b3.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                if (editor != null) {
                    editor.putBoolean("dontshowagain", true);
                    editor.commit();
                }
                dialog.dismiss();
            }
        });
        ll.addView(b3);

        dialog.setContentView(ll);
        dialog.show();
    }
}
