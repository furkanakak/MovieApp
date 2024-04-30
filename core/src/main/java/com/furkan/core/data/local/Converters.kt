package com.furkan.core.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun fromGenreIdList(value: List<Int>?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toGenreIdList(value: String?): List<Int> {
        val objects = Gson().fromJson(value, Array<Int>::class.java) as Array<Int>
        return objects.toList()
    }
}