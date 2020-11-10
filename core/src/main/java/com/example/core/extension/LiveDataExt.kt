package com.example.core.extension

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations

fun<T> LiveData<T>.asMutable(): MutableLiveData<T>?{
    return this as? MutableLiveData<T>
}

fun <X, Y> LiveData<X>.map(body: (X) -> (Y)): LiveData<Y> {
    return Transformations.map(this, body)
}

fun <X, Y> LiveData<X>.switchMap(body: (X) -> LiveData<Y>): LiveData<Y> {
    return Transformations.switchMap(this, body)
}

fun <T> LiveData<T>.postValue(value: T) {
    this.asMutable()?.postValue(value)
}