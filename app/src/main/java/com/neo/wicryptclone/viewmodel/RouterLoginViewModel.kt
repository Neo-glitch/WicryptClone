package com.neo.wicryptclone.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class RouterLoginViewModel: ViewModel() {

    var mRouterCode: MutableLiveData<String> = MutableLiveData()

    fun genRandomNumber() {
        var rand = Random
        val upperBound = 10
        var firstNum = rand.nextInt(upperBound)
        var secondNum = rand.nextInt(upperBound)
        var thirdNum = rand.nextInt(upperBound)
        var fourthNum = rand.nextInt(upperBound)
        var fifthNum = rand.nextInt(upperBound)
        var sixthNum = rand.nextInt(upperBound)

        mRouterCode.value = "$firstNum$secondNum$thirdNum$fourthNum$fifthNum$sixthNum"
    }
}