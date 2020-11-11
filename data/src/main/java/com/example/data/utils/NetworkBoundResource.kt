package com.example.data.utils

import com.example.data.vo.Error
import com.example.data.vo.Resource
import com.example.data.vo.Success

fun <T> networkBoundResource(execute: () -> T): Resource<T> {
    return try {
        Success(execute.invoke())
    } catch (throwable: Throwable) {
        Error(throwable)
    }
}