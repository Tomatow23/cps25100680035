package edu.nmdunn.cps251_nmdunn

import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.LifecycleOwner
import edu.nmdunn.cps251_nmdunn.ui.main.MainViewModel
import java.time.LocalTime
import java.time.format.DateTimeFormatter


class DemoObserver : LifecycleObserver {

    private val LOG_TAG = "DemoObserver"
    private lateinit var msg: String
    private var time_run = ""
    var viewModel = MainViewModel
    private fun getTime(): String {
        time_run = DateTimeFormatter
            .ofPattern("HH:mm:ss.SSS")
            .format(LocalTime.now())
        return time_run
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        msg = Thread.currentThread().stackTrace[2].methodName
        viewModel.addStr(msg + getTime() + "\n******")

        Log.i(LOG_TAG, msg)
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        msg = Thread.currentThread().stackTrace[2].methodName
        viewModel.addStr(msg + getTime() + "\n******")
//        Log.i(LOG_TAG, msg)
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        msg = Thread.currentThread().stackTrace[2].methodName
        viewModel.addStr(msg + getTime())
        Log.i(LOG_TAG, msg)
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        msg = Thread.currentThread().stackTrace[2].methodName
        viewModel.addStr(msg + getTime())
        Log.i(LOG_TAG, msg)
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        msg = Thread.currentThread().stackTrace[2].methodName
        viewModel.addStr(msg + getTime())
        Log.i(LOG_TAG, msg)
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        msg = Thread.currentThread().stackTrace[2].methodName
        viewModel.addStr(msg + getTime() + "\n******")
        Log.i(LOG_TAG, msg)
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny(owner: LifecycleOwner, event: Lifecycle.Event) {
        Log.i(LOG_TAG, owner.lifecycle.currentState.name)
    }
    }