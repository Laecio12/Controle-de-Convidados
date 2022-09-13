package com.laecio.convidados.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.laecio.convidados.constants.DatabaseConstants

class GuestDatabase(context: Context): SQLiteOpenHelper(context, NAME, null, VERSION) {

    companion object{
        private const val NAME = "guestdb"
        private const val VERSION  = 1
    }

    override fun onCreate(db: SQLiteDatabase) {

        db.execSQL("CREATE TABLE " + DatabaseConstants.Guest.TABLE_NAME + " ("+
                DatabaseConstants.Guest.Columns.Id + " integer primary key autoincrement, " +
                DatabaseConstants.Guest.Columns.NAME + " text, " +
                DatabaseConstants.Guest.Columns.PRESENCE + " integer);")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersiion: Int) {
        TODO("Not yet implemented")
    }
}