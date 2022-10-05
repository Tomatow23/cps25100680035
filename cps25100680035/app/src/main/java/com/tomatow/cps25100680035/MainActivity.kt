package com.tomatow.cps25100680035

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.tomatow.cps25100680035.databinding.ActivityMainBinding
import kotlin.math.roundToLong


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var result : TextView
    private lateinit var billAmount : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val calcTip : Button = binding.calcTip

        result = binding.tipAmount
        billAmount = binding.billAmount


        var percent1 : Double?
        var percent2 : Double?
        var percent3 : Double?

        fun checkString(){
            val et : EditText = billAmount
            val stringVal : String = et.text.toString()
            val maybeDouble : Double? = stringVal.toDoubleOrNull()
            if(stringVal.isNotEmpty()){
                if(maybeDouble != null || stringVal.toInt().equals(Int)){
                    percent1 = stringVal.toDouble() * 0.15
                    percent2 = stringVal.toDouble() * 0.20
                    percent3 = stringVal.toDouble() * 0.25
                    percent1 = (percent1!! * 100.0).roundToLong() / 100.0
                    percent2 = (percent2!! * 100.0).roundToLong() / 100.0
                    percent3 = (percent3!! * 100.0).roundToLong() / 100.0

                    result.append("15%: $" + percent1.toString() +
                            "\n" + "20%: $" + percent2.toString() + "\n" +
                            "25%: $" + percent3.toString() + "\n" )
                }
            }else{
                result.text = ""
                result.text = resources.getString(R.string.valid_input)
            }
        }

        val listener = View.OnClickListener {
            result.text = ""
            checkString()

        }
        calcTip.setOnClickListener(listener)
        }
    }
