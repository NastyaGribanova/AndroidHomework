package com.example.myapplication.bottomNavigation

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.recyclerView.*
import kotlinx.android.synthetic.main.companion_fragment.*
import kotlinx.android.synthetic.main.dialog_fragment.view.*

class CompanionFragment : Fragment() {

    companion object {
        fun newInstance() = CompanionFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.companion_fragment, container, false)

    private var adapter: CompanionAdapter? = null

    private val list: ArrayList<CompanionRecycler> = getDataSource()

    private fun getDataSource(): ArrayList<CompanionRecycler> = arrayListOf(
        CompanionRecycler("Susan", "The girl"),
        CompanionRecycler("Liz Shaw", "Scientist and civilian member of UNIT"),
        CompanionRecycler("Melanie Bush", "Computer programmer"),
        CompanionRecycler("K9", "Robot dog"),
        CompanionRecycler("Vislor Turlough", "Alien"),
        CompanionRecycler("Kamelion", "Shape-changing android "),
        CompanionRecycler("Rose Tyler", "Best companion"),
        CompanionRecycler("Captain Jack Harkness", "Gay captain"),
        CompanionRecycler("Amy Pond", "Redhead best companion"),
        CompanionRecycler("Rory Williams", "Redhead best companion's boyfriend"),
        CompanionRecycler("Clara Oswald", "Smart girl")
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            adapter = CompanionAdapter(getDataSource()) { companion ->
                delete(companion)
            }
            rv_companions.adapter = adapter

            setRecyclerViewItemTouchListener()

            btn_show_dialog.setOnClickListener {
                showDialog()
            }
    }

    private fun setRecyclerViewItemTouchListener() {
        val itemTouchCallback = object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                viewHolder1: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, swipeDir: Int) {
                val index = viewHolder.adapterPosition
                list.removeAt(index)
                adapter?.updateList(list)
            }
        }
        val itemTouchHelper = ItemTouchHelper(itemTouchCallback)
        rv_companions.addItemDecoration(itemTouchHelper)
        itemTouchHelper.attachToRecyclerView(rv_companions)
    }

    private fun delete(companion: CompanionRecycler) {
        list.remove(companion)
        adapter?.updateList(list)
    }

    private fun showDialog() {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_fragment, null)
        val builder = context?.let {
            AlertDialog.Builder(it)
                .setView(dialogView)
        }
        val dialog = builder?.show()
        dialogView.btn_add_dialog.setOnClickListener {
            dialog?.dismiss()
            val name = dialogView.et_name_dialog.text.toString()
            val description = dialogView.et_description_dialog.text.toString()
            var index = dialogView.et_index_dialog.text.toString().toInt() - 1
            val listSize = list.size
            if (index > listSize) {
                index = listSize
            }
            list.add(index, CompanionRecycler(name, description))
            adapter?.updateList(list)
        }

        dialogView.btn_cancel_dialog.setOnClickListener {
            dialog?.dismiss()
        }
    }
}
