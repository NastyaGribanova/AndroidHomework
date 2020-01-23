package com.example.myapplication

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.myapplication.db.AppNoteDB
import com.example.myapplication.db.Note
import com.example.myapplication.db.NotesContract
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.activity_note.*
import kotlinx.android.synthetic.main.item_note.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import java.util.*

class NoteFragment : Fragment(), OnFragmentListener, CoroutineScope by MainScope() {

    private lateinit var mListener: OnFragmentListener
    private lateinit var db: AppNoteDB
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(activity as MainActivity)
        return inflater.inflate(R.layout.note_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context?.let { db = AppNoteDB(it) }
        checkPermissions()
        setText()
        initListeners()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentListener) {
            mListener = context
        } else {
            throw RuntimeException(context.toString() + "must implement interface")
        }
    }

    private fun addNote (
        title: String,
        description: String,
        date: java.util.Date,
        latitude: String,
        longitude: String){
        launch { db.notesDao().addNote(Note(0, title, description, date, latitude, longitude))}
    }

    private fun updateNote (
        id: Int,
        title: String,
        description: String,
        date: java.util.Date,
        latitude: String,
        longitude: String){
        launch { db.notesDao().updateNote(id, title, description, date, latitude, longitude)}
    }

    private fun setText() {
        if (arguments?.getString(NotesContract.DATA.ARG_ACTION) == NotesContract.ACTION.ADD_ACTION) btn_add.text = "ADD"
        else btn_add.text = "CHANGE"
        et_title.setText(arguments?.getString(NotesContract.DATA.ARG_TITLE).toString())
        et_description.setText(arguments?.getString(NotesContract.DATA.ARG_DESCRIPTION).toString())
    }

    private fun initListeners() {
        btn_add.setOnClickListener {
            if (arguments?.getString(NotesContract.DATA.ARG_ACTION).toString() == NotesContract.ACTION.ADD_ACTION) {
                addNote(et_title.text.toString(), et_description.text.toString(), Calendar.getInstance().time,  tv_latitude.text.toString(), tv_longitude.text.toString())
            } else {
                updateNote(arguments?.getInt(NotesContract.DATA.ARG_ID) ?: 0, et_title.text.toString(),
                    et_description.text.toString(), Calendar.getInstance().time, tv_latitude.text.toString(), tv_longitude.text.toString())
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1000 ->
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) location()
        }
    }

    private fun location() {
        fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
            tv_latitude.text = location?.latitude.toString()
            tv_longitude.text = location?.longitude.toString()
        }
    }

    private fun checkPermissions() {
        val permissionsStatus = activity?.let { ContextCompat.checkSelfPermission(it, Manifest.permission.ACCESS_COARSE_LOCATION) }
        if (permissionsStatus == PackageManager.PERMISSION_GRANTED) {
            location()
        } else {
            activity?.let { ActivityCompat.requestPermissions(it, arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION), 1000) }
        }
    }

    companion object {
        fun newInstance(
            action: String = "",
            id: Int = 0,
            title: String = "",
            description: String = ""
        ): NoteFragment = newInstance().apply {
            arguments = Bundle().apply {
                putString(NotesContract.DATA.ARG_ACTION, action)
                putInt(NotesContract.DATA.ARG_ID, id)
                putString(NotesContract.DATA.ARG_TITLE, title)
                putString(NotesContract.DATA.ARG_DESCRIPTION, description)
            }
        }
    }

    override fun changeFragment(comand: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun changeNotes(action: String, note: Note) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

interface OnFragmentListener {
    fun changeFragment(comand: String)
    fun changeNotes(action: String, note: Note)
}
