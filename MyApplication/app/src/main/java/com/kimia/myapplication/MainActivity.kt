package com.kimia.myapplication

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.kimia.demo.R
import com.kinexcs.kimia.move.deskercise.exercise.data.SessionDetail
import com.kinexcs.kimia.move.deskercise.exercise.sdk.MoveSDK

class MainActivity : AppCompatActivity() {

    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { r ->
            val result = MoveSDK.handleResult(r.resultCode, r.data)
            result.exception?.let {
                // show error here
                Toast.makeText(this, it.message.orEmpty(), Toast.LENGTH_SHORT).show()
            }
            result.detail?.let { detail: SessionDetail ->
                // success data here
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val moveSdk = MoveSDK()

        findViewById<View>(R.id.bt5Min).setOnClickListener {
            launcher.launch(moveSdk.getIntent5MinutesExercise(this, getRandom()))
        }
        findViewById<View>(R.id.bt10Min).setOnClickListener {
            launcher.launch(moveSdk.getIntent10MinutesExercise(this, getRandom()))
        }
        findViewById<View>(R.id.bt15Min).setOnClickListener {
            launcher.launch(moveSdk.getIntent15MinutesExercise(this, getRandom()))
        }
    }

    private fun getRandom(): Boolean {
        return findViewById<CheckBox>(R.id.cbRandom).isChecked
    }
}