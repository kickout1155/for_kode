package com.example.forkode.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.forkode.SingleLiveEvent
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable


abstract class BaseViewModel:ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    protected val _message = SingleLiveEvent<String>()
    val message: LiveData<String> = _message

    fun addDisposable(disposable: Disposable){
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}