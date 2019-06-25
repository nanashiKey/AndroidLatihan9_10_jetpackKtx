package com.ngopidev.project.androidlatihan9_10_jetpackktx.allviews.view_addData

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.ngopidev.project.androidlatihan9_10_jetpackktx.R
import com.ngopidev.project.androidlatihan9_10_jetpackktx.StartApp
import com.ngopidev.project.androidlatihan9_10_jetpackktx.datareff.model.People
import kotlinx.android.synthetic.main.fr_tambah_contact.*


/**
 *   created by Irfan Assidiq on 2019-06-19
 *   email : assidiq.irfan@gmail.com
 **/
class FRAddPeople : Fragment(){

    lateinit var btn_ : Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val views : View = inflater.inflate(R.layout.fr_tambah_contact, container,
            false)
        btn_ = views.findViewById(R.id.btn_save)
        return views
    }

    private fun savePeopleContact(){
        val people = People(
            textInputNama.editText!!.text.toString(),
            textInputMet.editText!!.text.toString(),
            textInputContact.editText!!.text.toString(),
            textInputEmail.editText!!.text.toString(),
            textInputFB.editText!!.text.toString(),
            textInputTwitter.editText!!.text.toString()
        )
        (activity!!.application as StartApp).getPeopleRepo().insertPeople(people)
//        activity!!.finish()
        Navigation.findNavController(view!!).navigateUp()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_.setOnClickListener {
            savePeopleContact()
        }
    }
}