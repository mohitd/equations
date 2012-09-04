package com.centauri.equations.activity.settings;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.provider.Settings;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockPreferenceActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.centauri.equations.R;
import com.centauri.equations.activity.Categories;

public class SettingsActivity extends SherlockPreferenceActivity {

    public static final String ACTION_PREFERENCES = "com.centauri.equations.action.PREFERENCES";

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
				new String[] { "centauricompany@yahoo.com" });
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
			intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
			Uri uri = Uri.fromParts("package", getPackageName(),
				null);
			intent.setData(uri);
			startActivity(intent);
			return true;
		    }
		});

	getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	getSupportActionBar().setNavigationMode(
		ActionBar.NAVIGATION_MODE_STANDARD);
	getSupportActionBar().setTitle(R.string.menu_preferences);
    }

    @Override
    public void onBackPressed() {
	super.onBackPressed();
	Intent parentIntent = new Intent(this, Categories.class);
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
	    Intent parentIntent = new Intent(this, Categories.class);
	    parentIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
		    | Intent.FLAG_ACTIVITY_NEW_TASK);
	    startActivity(parentIntent);
	    finish();
	    return true;
	}
	return false;
    }
}
