package com.assignment.markgreenflagkotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.Objects.equals
import java.util.regex.Matcher
import java.util.regex.Pattern

class ActivityCreateAccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        val tvButtonNext = findViewById<TextView>(R.id.tv_button_2)
        val etEmail = findViewById<EditText>(R.id.et_email)
        val ivCheckMark = findViewById<ImageView>(R.id.iv_check_email)
        val ivCheckPassword = findViewById<ImageView>(R.id.iv_check_password)
        val ivCheckPasswordRepeat = findViewById<ImageView>(R.id.iv_check_repeat_password)
        val etCreatePassword = findViewById<EditText>(R.id.et_password)
        val etRepeatPassword = findViewById<EditText>(R.id.et_repeat_password)
        val tvBadPasswordWarning = findViewById<TextView>(R.id.tv_label_password_bad)

        etEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                var ps = Pattern.compile("^\\w+[\\w-\\.]*\\@\\w+((-\\w+)|(\\w*))\\.[a-z]{2,3}$")
                var ms = ps.matcher(etEmail.text.toString())
                var bs = ms.matches()

                if(bs) {
                    ivCheckMark.visibility = View.VISIBLE;
                    etEmail.setBackgroundResource(R.drawable.textview_border_green)

                }
                else {
                    ivCheckMark.visibility = View.INVISIBLE;
                    etEmail.setBackgroundResource(R.drawable.textview_border)
                }






            }
        })

        etCreatePassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                var ps = Pattern.compile("^\\w+[\\w-\\.]*\\@\\w+((-\\w+)|(\\w*))\\.[a-z]{2,3}$")
                var ms = ps.matcher(etCreatePassword.text.toString())
                var bs = ms.matches()

                if(bs) {
                    ivCheckPassword.visibility = View.VISIBLE
                    etCreatePassword.setBackgroundResource(R.drawable.textview_border_green)
                    tvBadPasswordWarning.visibility = View.GONE

                }
                else {
                    ivCheckPassword.visibility = View.INVISIBLE
                    etCreatePassword.setBackgroundResource(R.drawable.textview_border)
                    tvBadPasswordWarning.visibility = View.VISIBLE
                }






            }
        })

        etRepeatPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                var ps = Pattern.compile("^\\w+[\\w-\\.]*\\@\\w+((-\\w+)|(\\w*))\\.[a-z]{2,3}$")
                var ms = ps.matcher(etRepeatPassword.text.toString())
                var bs = ms.matches()

                if(bs) {
                    ivCheckPasswordRepeat.visibility = View.VISIBLE
                    etRepeatPassword.setBackgroundResource(R.drawable.textview_border_green)
                    tvBadPasswordWarning.visibility = View.GONE
                    tvButtonNext.setBackgroundResource(R.drawable.gradient_button_backgroundx)
                    tvButtonNext.isEnabled = true

                }
                else {
                    ivCheckPasswordRepeat.visibility = View.INVISIBLE
                    etRepeatPassword.setBackgroundResource(R.drawable.textview_border)
                    tvBadPasswordWarning.visibility = View.VISIBLE
                    tvButtonNext.setBackgroundResource(R.drawable.textview_border_rectangle_grey_button)
                    tvButtonNext.isEnabled = false
                }






            }
        })

        tvButtonNext.setOnClickListener(View.OnClickListener {

            if (etCreatePassword.text.toString() == etRepeatPassword.text.toString()) {

                fun Context.toast(message: CharSequence) =
                    Toast.makeText(this, "Account successfully created", Toast.LENGTH_LONG).show()

            }
            else {

                ivCheckPasswordRepeat.visibility = View.INVISIBLE
                etRepeatPassword.setBackgroundResource(R.drawable.textview_border)
                tvBadPasswordWarning.visibility = View.VISIBLE
                tvButtonNext.setBackgroundResource(R.drawable.textview_border_rectangle_grey_button)
                tvButtonNext.isEnabled = false
                etRepeatPassword.requestFocus()

            }

        })


    }
}