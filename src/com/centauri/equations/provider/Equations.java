package com.centauri.equations.provider;

import android.app.SearchManager;
import android.net.Uri;
import android.provider.BaseColumns;

public final class Equations {
    private Equations() {
    }

    public static final String AUTHORITY = "com.centauri.equations.provider.EquationsProvider";

    public static final class Formula implements BaseColumns {
	private Formula() {
	}

	public static final Uri CONTENT_URI = Uri.parse("content://"
		+ AUTHORITY + "/formulas");

	public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.centauri.formula";
	public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/com.centauri.formula";

	public static final String FORMULA_NAME = SearchManager.SUGGEST_COLUMN_TEXT_1;
	public static final String CATEGORY = "category";
    }
}
