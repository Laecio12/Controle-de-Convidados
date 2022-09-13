package com.laecio.convidados.repository

import android.content.ContentValues
import android.content.Context
import com.laecio.convidados.constants.DatabaseConstants
import com.laecio.convidados.model.GuestModel

class GuestRepository private constructor(context: Context) {
    private val guestDatabase = GuestDatabase(context)

    //Singleton
    companion object {
        private lateinit var repository: GuestRepository

        fun getInstance(context: Context): GuestRepository {

            if (!::repository.isInitialized) {
                repository = GuestRepository(context)
            }
            return repository
        }
    }

    fun insert(guest: GuestModel): Boolean {
        return try {
            val db = guestDatabase.writableDatabase

            val presence = if (guest.presence) 1 else 0

            val values = ContentValues()

            values.put(DatabaseConstants.Guest.Columns.NAME, guest.name)
            values.put(DatabaseConstants.Guest.Columns.PRESENCE, presence)

            db.insert(DatabaseConstants.Guest.TABLE_NAME, null, values)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun update(guest: GuestModel): Boolean {
        return try {
            val db = guestDatabase.writableDatabase

            val presence = if (guest.presence) 1 else 0

            val values = ContentValues()

            values.put(DatabaseConstants.Guest.Columns.NAME, guest.name)
            values.put(DatabaseConstants.Guest.Columns.PRESENCE, presence)

            val selection = DatabaseConstants.Guest.Columns.Id + "= ?"

            val args = arrayOf(guest.id.toString())

            db.update(DatabaseConstants.Guest.TABLE_NAME, values, selection, args)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun delete(id: Int): Boolean {
        return try {
            val db = guestDatabase.writableDatabase

            val selection = DatabaseConstants.Guest.Columns.Id + "= ?"

            val args = arrayOf(id.toString())

            db.delete(DatabaseConstants.Guest.TABLE_NAME, selection, args)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun getAll(): List<GuestModel> {
        val listGuests = mutableListOf<GuestModel>()

        try {
            val db = guestDatabase.readableDatabase

            val projection = arrayOf(
                DatabaseConstants.Guest.Columns.Id,
                DatabaseConstants.Guest.Columns.NAME,
                DatabaseConstants.Guest.Columns.PRESENCE
            )

            val cursor = db.query(DatabaseConstants.Guest.TABLE_NAME, projection,
                null, null, null, null, null)

            if(cursor != null && cursor.count > 0 ) {
                while (cursor.moveToNext()) {
                    val id = cursor.getInt(cursor.getColumnIndex(DatabaseConstants.Guest.Columns.Id))
                    val name = cursor.getString(cursor.getColumnIndex(DatabaseConstants.Guest.Columns.NAME))
                    val presence = cursor.getInt(cursor.getColumnIndex(DatabaseConstants.Guest.Columns.PRESENCE))

                    val guest = GuestModel(id, name, presence == 1)

                    listGuests.add(guest)
                }
            }

            cursor.close()
        } catch (e: Exception) {
            listGuests
        }

        return listGuests
    }

    fun getAllPresents(): List<GuestModel> {
        val listGuests = mutableListOf<GuestModel>()

        try {
            val db = guestDatabase.readableDatabase

            val projection = arrayOf(
                DatabaseConstants.Guest.Columns.Id,
                DatabaseConstants.Guest.Columns.NAME,
                DatabaseConstants.Guest.Columns.PRESENCE
            )

            val selection = DatabaseConstants.Guest.Columns.PRESENCE + "= ?"

            val args = arrayOf("1")

            val cursor = db.query(DatabaseConstants.Guest.TABLE_NAME, projection,
                selection, args, null, null, null)

            if(cursor != null && cursor.count > 0 ) {
                while (cursor.moveToNext()) {
                    val id = cursor.getInt(cursor.getColumnIndex(DatabaseConstants.Guest.Columns.Id))
                    val name = cursor.getString(cursor.getColumnIndex(DatabaseConstants.Guest.Columns.NAME))
                    val presence = cursor.getInt(cursor.getColumnIndex(DatabaseConstants.Guest.Columns.PRESENCE))

                    val guest = GuestModel(id, name, presence == 1)

                    listGuests.add(guest)
                }
            }

            cursor.close()
        } catch (e: Exception) {
            listGuests
        }

        return listGuests
    }

    fun getAllAbsents(): List<GuestModel> {
        val listGuests = mutableListOf<GuestModel>()

        try {
            val db = guestDatabase.readableDatabase

            val projection = arrayOf(
                DatabaseConstants.Guest.Columns.Id,
                DatabaseConstants.Guest.Columns.NAME,
                DatabaseConstants.Guest.Columns.PRESENCE
            )

            val selection = DatabaseConstants.Guest.Columns.PRESENCE + "= ?"

            val args = arrayOf("0")

            val cursor = db.query(DatabaseConstants.Guest.TABLE_NAME, projection,
                selection, args, null, null, null)

            if(cursor != null && cursor.count > 0 ) {
                while (cursor.moveToNext()) {
                    val id = cursor.getInt(cursor.getColumnIndex(DatabaseConstants.Guest.Columns.Id))
                    val name = cursor.getString(cursor.getColumnIndex(DatabaseConstants.Guest.Columns.NAME))
                    val presence = cursor.getInt(cursor.getColumnIndex(DatabaseConstants.Guest.Columns.PRESENCE))

                    val guest = GuestModel(id, name, presence == 1)

                    listGuests.add(guest)
                }
            }

            cursor.close()
        } catch (e: Exception) {
            listGuests
        }

        return listGuests
    }

}