package com.example.project2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class Adapter (val mCtx: Context, val layoutResId: Int, val list:List<Users>)
    : ArrayAdapter<Users>(mCtx, layoutResId, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(layoutResId, null)

        val email = view.findViewById<TextView>(R.id.emailText)
        val pass = view.findViewById<TextView>(R.id.passwordText)

        val user = list[position]

        email.text = user.email
        pass.text = user.pass

        return view
    }
}