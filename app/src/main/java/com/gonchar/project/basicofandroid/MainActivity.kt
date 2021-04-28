package com.gonchar.project.basicofandroid

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnOk: Button
    private lateinit var etMessage: EditText
    private lateinit var tvResult: TextView
    private lateinit var tvMadeBy: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initLayoutElements()
        initListener()
    }

    /**
     * this method set clickListener to element which needed be clickable
     */
    private fun initListener() {
        btnOk.setOnClickListener(this)
        tvMadeBy.setOnClickListener(this)
    }

    /**
     * this method find and init view element & set click listener for someone from it
     */
    private fun initLayoutElements() {
        btnOk = findViewById(R.id.btnOk)
        etMessage = findViewById(R.id.etMessage)
        tvResult = findViewById(R.id.tvResult)
        tvMadeBy = findViewById(R.id.tvMadeBy)
    }

    /**
     * his method handles different element clicks
     */
    override fun onClick(v: View?) {

        when (v!!.id) {
            btnOk.id -> {
                tvResult.text = etMessage.text
                etMessage.text.clear()
            }
            tvMadeBy.id -> {
                when (tvMadeBy.text.toString()) {
                    getString(R.string.main_tad_supervised) ->
                        tvMadeBy.text = getString(R.string.main_tag_label)

                    getString(R.string.main_tag_label) ->
                        tvMadeBy.text = getString(R.string.main_tad_supervised)
                }
            }
        }
    }
}