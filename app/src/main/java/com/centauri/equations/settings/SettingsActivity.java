package com.centauri.equations.settings;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;

import com.centauri.equations.MainActivity;
import com.centauri.equations.R;

public class SettingsActivity extends PreferenceActivity {

    public static final String ACTION_PREFERENCES = "com.centauri.equations.action.PREFERENCES";

    @SuppressLint("InlinedApi")
    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);

        ((Preference) findPreference("feedback_key"))
                .setOnPreferenceClickListener(new OnPreferenceClickListener() {

                    public boolean onPreferenceClick(Preference preference) {
                        Intent emailIntent = new Intent(Intent.ACTION_SEND);
                        emailIntent.putExtra(Intent.EXTRA_EMAIL,
                                new String[] { "centauriappsco@gmail.com" });
                        emailIntent.setType("plain/text");
                        emailIntent
                                .putExtra(Intent.EXTRA_SUBJECT, "Feedback: ");
                        startActivity(Intent.createChooser(emailIntent,
                                getResources()
                                        .getString(R.string.send_feedback)));
                        return true;
                    }
                });

        ((Preference) findPreference("bug_key"))
                .setOnPreferenceClickListener(new OnPreferenceClickListener() {

                    public boolean onPreferenceClick(Preference preference) {
                        Intent emailIntent = new Intent(Intent.ACTION_SEND);
                        emailIntent.putExtra(Intent.EXTRA_EMAIL,
                                new String[] { "centauricompany@yahoo.com" });
                        emailIntent.setType("plain/text");
                        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Bug: ");
                        startActivity(Intent.createChooser(
                                emailIntent,
                                getResources().getString(
                                        R.string.report_problem)));
                        return true;
                    }
                });

        ((Preference) findPreference("open_source_key"))
                .setOnPreferenceClickListener(new OnPreferenceClickListener() {

                    public boolean onPreferenceClick(Preference preference) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(
                                SettingsActivity.this);
                        builder.setTitle(getResources().getString(
                                R.string.open_source));
                        builder.setMessage(getResources().getString(
                                R.string.open_source_licenses));
                        builder.setNeutralButton(
                                getResources().getString(R.string.cancel),
                                new DialogInterface.OnClickListener() {

                                    public void onClick(DialogInterface dialog,
                                            int which) {
                                        dialog.dismiss();
                                    }
                                });
                        builder.create().show();
                        return true;
                    }
                });

        ((Preference) findPreference("db_problems_key"))
                .setOnPreferenceClickListener(new OnPreferenceClickListener() {

                    public boolean onPreferenceClick(Preference preference) {
                        Intent intent = new Intent();
                        final int buildVersion = Build.VERSION.SDK_INT;
                        if (buildVersion >= 9) {
                            intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                            Uri uri = Uri.fromParts("package",
                                    getPackageName(), null);
                            intent.setData(uri);
                        } else {
                            final String appPkgName = (buildVersion == 8 ? "pkg"
                                    : "com.android.settings.ApplicationPkgName");
                            intent.setAction(Intent.ACTION_VIEW);
                            intent.setClassName("com.android.settings",
                                    "com.android.settings.InstalledAppDetails");
                            intent.putExtra(appPkgName, getPackageName());
                        }
                        startActivity(intent);
                        return true;
                    }
                });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent parentIntent = new Intent(this, MainActivity.class);
        parentIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(parentIntent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            Intent parentIntent = new Intent(this, MainActivity.class);
            parentIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                    | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(parentIntent);
            finish();
            return true;
        }
        return false;
    }
}
