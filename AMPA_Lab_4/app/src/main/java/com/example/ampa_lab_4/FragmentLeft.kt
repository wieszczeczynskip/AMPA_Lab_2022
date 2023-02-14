package com.example.ampa_lab_4

import android.R.attr.button
import android.graphics.Color
import android.graphics.Color.green
import android.graphics.Typeface
import android.os.Bundle
import android.util.TypedValue
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentLeft.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentLeft : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_left, container, false)
        val fontsize = view.findViewById<Button>(R.id.fontsize)
        registerForContextMenu(fontsize)
        val fontstyle = view.findViewById<Button>(R.id.fontstyle)
        registerForContextMenu(fontstyle)
        val color = view.findViewById<Button>(R.id.color)
        registerForContextMenu(color)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<View>(R.id.button_lf).setOnClickListener { _ ->
            view.findNavController().navigate(R.id.action_left_frag_to_center_frag)
        }
    }

    override fun onCreateContextMenu(cm: ContextMenu, v: View, cmi: ContextMenu.ContextMenuInfo?)
    {
        super.onCreateContextMenu(cm, v, cmi)

        if(v.id == R.id.fontsize) {
            requireActivity().getMenuInflater().inflate(R.menu.menu_fontsize,cm)
        }
        if(v.id == R.id.fontstyle) {
            requireActivity().getMenuInflater().inflate(R.menu.menu_fontstyle,cm)
        }
        if(v.id == R.id.color) {
            requireActivity().getMenuInflater().inflate(R.menu.menu_color,cm)
        }

    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {
        return when (item.itemId)
        {
            R.id.small -> {
                if (item.isChecked) {
                    item.isChecked = false
                    view?.findViewById<Button>(R.id.fontsize)?.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14F)
                }
                else {
                    item.isChecked = true
                    view?.findViewById<Button>(R.id.fontsize)?.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14F)
                }
                true}
            R.id.medium -> {
                if (item.isChecked) {
                    item.isChecked = false
                    view?.findViewById<Button>(R.id.fontsize)?.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14F)
                }
                else {
                    item.isChecked = true
                    view?.findViewById<Button>(R.id.fontsize)?.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18F)
                }
                true}
            R.id.large -> {
                if (item.isChecked) {
                    item.isChecked = false
                    view?.findViewById<Button>(R.id.fontsize)?.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14F)
                }
                else {
                    item.isChecked = true
                    view?.findViewById<Button>(R.id.fontsize)?.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22F)
                }
                true}
            R.id.blue -> {
                if (item.isChecked) {
                    item.isChecked = false
                    view?.findViewById<Button>(R.id.color)?.setBackgroundColor(Color.GREEN)
                }
                else {
                    item.isChecked = true
                    view?.findViewById<Button>(R.id.color)?.setBackgroundColor(Color.BLUE)
                }
                true}
            R.id.black -> {
                if (item.isChecked) {
                    item.isChecked = false
                    view?.findViewById<Button>(R.id.color)?.setBackgroundColor(Color.GREEN)
                }
                else {
                    item.isChecked = true
                    view?.findViewById<Button>(R.id.color)?.setBackgroundColor(Color.BLACK)
                }
                true}
            R.id.bold -> {
                if (item.isChecked) {
                    item.isChecked = false
                    view?.findViewById<Button>(R.id.fontstyle)?.setTypeface(Typeface.DEFAULT)
                }
                else {
                    item.isChecked = true
                    view?.findViewById<Button>(R.id.fontstyle)?.setTypeface(null, Typeface.BOLD)
                }
                true
            }
            R.id.italics -> {
                if (item.isChecked) {
                    item.isChecked = false
                    view?.findViewById<Button>(R.id.fontstyle)?.setTypeface(Typeface.DEFAULT)
                }
                else {
                    item.isChecked = true
                    view?.findViewById<Button>(R.id.fontstyle)?.setTypeface(null, Typeface.ITALIC)
                }
                true
            }
            else -> // for unprocessed menu items
                super.onOptionsItemSelected(item)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentLeft.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentLeft().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}