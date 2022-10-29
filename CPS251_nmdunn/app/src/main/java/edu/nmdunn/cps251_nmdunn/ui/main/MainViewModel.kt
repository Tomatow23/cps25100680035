package edu.nmdunn.cps251_nmdunn.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    companion object{
        // TODO: Implement the ViewModel
        var str: MutableLiveData<String> = MutableLiveData()
        var str1 = ""

        fun addStr(str_fun: String){
            str1 += "\n" + str_fun
            str.value = str1
        }
    }
    fun returnStr():MutableLiveData<String> {
        return str
    }

}