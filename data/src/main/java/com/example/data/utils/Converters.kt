package com.example.data.utils

import androidx.room.TypeConverter
import com.example.data.model.Owner
import com.google.gson.Gson

class Converters {

    private val gson: Gson = Gson()

    @TypeConverter
    fun fromOwner(value: Owner?): String? {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toOwner(json: String?): Owner? {
        return gson.fromJson(json, Owner::class.java)
    }
}