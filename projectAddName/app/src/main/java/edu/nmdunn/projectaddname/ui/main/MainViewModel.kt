package edu.nmdunn.projectaddname.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
//    private var result: MutableLiveData<String> = MutableLiveData()
    private var result: String = ""


    fun setName(name: String){
        if(result.isEmpty()){
            result = name
        }else{
            addName(name)
        }
    }
    fun addName(name: String){
        result += " $name "

    }
    fun getName(): String {
        return result
    }
}