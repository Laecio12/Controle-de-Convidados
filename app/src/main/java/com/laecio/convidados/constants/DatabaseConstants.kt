package com.laecio.convidados.constants

class DatabaseConstants private constructor(){

    object Guest {
        const val TABLE_NAME = "Guests"

        object Columns {
            const val Id = "id"
            const val NAME = "name"
            const val PRESENCE = "presence"
        }
    }
}