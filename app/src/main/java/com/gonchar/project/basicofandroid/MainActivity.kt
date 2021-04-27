package com.gonchar.project.basicofandroid

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.gonchar.project.basicofandroid.Constants.Companion.EMPTY_STRING

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var btnOk: Button? = null
    private var etMessage: EditText? = null
    private var tvResult: TextView? = null
    private var tvMadeBy: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initLayoutElements()
    }

    /**
     * this method find and init view element & set click listener for someone from it
     */
    private fun initLayoutElements() {
        btnOk = findViewById(R.id.btnOk)
        etMessage = findViewById(R.id.etMessage)
        tvResult = findViewById(R.id.tvResult)
        tvMadeBy = findViewById(R.id.tvMadeBy)

        btnOk!!.setOnClickListener(this)
        tvMadeBy!!.setOnClickListener(this)
    }

    /**
     * his method handles different element clicks
     */
    override fun onClick(v: View?) {

        when (v!!.id) {
            btnOk!!.id -> kotlin.run {
                tvResult!!.text = etMessage!!.text
                etMessage!!.setText(EMPTY_STRING)
            }
            tvMadeBy!!.id -> kotlin.run {
                when (tvMadeBy!!.text.toString()) {
                    getString(R.string.main_tvmadeby_deftext) ->
                        tvMadeBy!!.setText(R.string.main_tvmadeby_deftext_ua)

                    getString(R.string.main_tvmadeby_deftext_ua) ->
                        tvMadeBy!!.setText(R.string.main_tvmadeby_deftext)
                }
            }
        }
    }
}