package com.feboll.motoguide;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBhelper extends SQLiteAssetHelper {
	private static final String DATABASE_NAME = "motoguide";
	private static final int DATABASE_VERSION = 1;

	public DBhelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	//Получаем марки мотоциклов------------------------------------------------------------------------------------------------------------------------
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
	//-------------------------------------------------------------------------------------------------------------------------------------------------
	//Получаем название марки--------------------------------------------------------------------------------------------------------------------------
	public String getBrandName(int position) {
		SQLiteDatabase db = getReadableDatabase();
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

		String [] sqlSelect = {"_id", "moto_brand_name", "moto_brand_histori"};
		String sqlTables = "moto_brand";

		qb.setTables(sqlTables);
		Cursor c = qb.query(db, sqlSelect, null, null, null, null, null);
		c.moveToPosition(position);

		return c.getString(1);
	}
	//-------------------------------------------------------------------------------------------------------------------------------------------------
	//Получаем классы мотоциклов для данной марки------------------------------------------------------------------------------------------------------
	public Cursor getMotoType(int moto_brand_id) {
		SQLiteDatabase db = getReadableDatabase();
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

		String [] sqlSelect = {"_id", String.valueOf(moto_brand_id), "moto_type_name"};
		String sqlTables = "moto_type";

		qb.setTables(sqlTables);
		Cursor c = qb.query(db, sqlSelect, null, null, null, null, null);
		c.moveToFirst();

		return c;
	}
	//-------------------------------------------------------------------------------------------------------------------------------------------------
	//Получаем модели для данной марки-----------------------------------------------------------------------------------------------------------------
	public Cursor getMotoItem(int moto_brand_id, int moto_type_id) {

		SQLiteDatabase db = getReadableDatabase();
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

		String [] sqlSelect = {"_id", String.valueOf(moto_brand_id), String.valueOf(moto_type_id), "moto_item_name"};
		String sqlTables = "moto_item";

		qb.setTables(sqlTables);
		Cursor c = qb.query(db, sqlSelect, null, null, null, null, null);
		c.moveToFirst();

		return c;
	}
	//-------------------------------------------------------------------------------------------------------------------------------------------------

}
