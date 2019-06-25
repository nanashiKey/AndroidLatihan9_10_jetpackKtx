package com.ngopidev.project.androidlatihan9_10_jetpackktx.allviews.view_cl

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.ngopidev.project.androidlatihan9_10_jetpackktx.R
import com.ngopidev.project.androidlatihan9_10_jetpackktx.allviews.view_addData.AddActivity
import com.ngopidev.project.androidlatihan9_10_jetpackktx.allviews.view_detailContact.DetailActivity
import com.ngopidev.project.androidlatihan9_10_jetpackktx.datareff.model.People
import kotlinx.android.synthetic.main.fr_list_contact.*


/**
 *   created by Irfan Assidiq on 2019-06-13
 *   email : assidiq.irfan@gmail.com
 **/
class ListPeopleFR : Fragment(), ListPeopleAdapter.OnItemClickListener {

    private lateinit var viewModel: PeopleListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this)
            .get(PeopleListViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fr_list_contact, container,
            false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addFab.setOnClickListener {
//            val intent = Intent(context, AddActivity::class.java)
//            startActivity(intent)
            view.findNavController().navigate(R.id.FRAddPeople)
        }

        viewModel.getPeopleList().observe(this, Observer<List<People>>{
            peoples -> peoples?.let{
            populatePeopleList(peoples)
        }
        })
    }

    private fun populatePeopleList(peopleList : List<People>){
        peopleRCView.adapter = ListPeopleAdapter(peopleList, this)
    }

    override fun onItemClick(people: People, itemView: View) {
//        d("TAG_PEOPLE", "People List")
//        Toast.makeText(activity!!.applicationContext,
//            "Test People", Toast.LENGTH_SHORT).show()

//        val detailIntent = Intent(context, DetailActivity::class.java)
//        detailIntent.putExtra(getString(R.string.people_id), people.id)
//        startActivity(detailIntent)

        val detailBundling = Bundle().apply {
            putInt(getString(R.string.people_id), people.id)
        }

        view!!.findNavController().navigate(R.id.FRDetail, detailBundling)
    }
}