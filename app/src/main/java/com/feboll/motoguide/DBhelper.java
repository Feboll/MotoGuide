package com.feboll.motoguide;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Iam on 05.10.2014.
 */
public class DBhelper extends SQLiteAssetHelper {
	private static final String DATABASE_NAME = "motoguide";
	private static final int DATABASE_VERSION = 1;

	public DBhelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	public Cursor getBrand() {

		SQLiteDatabase db = getReadableDatabase();
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

		String [] sqlSelect = {"_id", "moto_brand_name", "moto_brand_histori"};
		String sqlTables = "moto_brand";

		qb.setTables(sqlTables);
		Cursor c = qb.query(db, sqlSelect, null, null, null, null, null);
		c.moveToFirst();

		return c;

	}
}
