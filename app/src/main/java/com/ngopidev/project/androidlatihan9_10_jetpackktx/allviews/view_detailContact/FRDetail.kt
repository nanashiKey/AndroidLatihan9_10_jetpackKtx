package com.ngopidev.project.androidlatihan9_10_jetpackktx.allviews.view_detailContact

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ngopidev.project.androidlatihan9_10_jetpackktx.R
import com.ngopidev.project.androidlatihan9_10_jetpackktx.StartApp
import com.ngopidev.project.androidlatihan9_10_jetpackktx.datareff.model.People
import kotlinx.android.synthetic.main.detail_contact.*


/**
 *   created by Irfan Assidiq on 2019-06-19
 *   email : assidiq.irfan@gmail.com
 **/
class FRDetail : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.detail_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val peopleId = activity!!.intent.getIntExtra(getString(
//            R.string.people_id), 0)
        val peopleId = arguments!!.getInt(getString(R.string.people_id))

        peopleId.let {
            val peopleDetails = (activity!!.application as StartApp)
                .getPeopleRepo().findPeople(peopleId)
            populateDetailContact(peopleDetails)
        }

    }
    private fun populateDetailContact(people : People?){
        tvName.text = people!!.nama
        tvMet.text = people.lokasi
        tvContact.text = people.contact
        tvEmail.text = people.email
        tvFacebook.text = people.facebook
        tvTwitter.text = people.twitter
    }
}