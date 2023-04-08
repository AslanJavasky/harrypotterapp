package com.seniorjavasky.harry_potter_and_retrofit.data.local.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE character ADD COLUMN birthday TEXT")
    }
}
val MIGRATION_2_3 = object : Migration(2, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE character ADD COLUMN hogwarts_house TEXT")
        database.execSQL("ALTER TABLE character ADD COLUMN image_url TEXT")
    }
}