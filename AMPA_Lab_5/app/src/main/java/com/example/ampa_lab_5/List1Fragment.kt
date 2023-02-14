package com.example.ampa_lab_5

import android.os.Bundle
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.ampa_lab_5.databinding.FragmentList1Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [List1Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class List1Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var list1 : ListView
    var data = DataRepo.getinstance().item_text_list
    private lateinit var binding: FragmentList1Binding

    val onItemClickListener = AdapterView.OnItemClickListener {parentview,
                                                               itemView,
                                                               position, id ->
        var txt = "Clicked " + (position) + " : Checked"
        val check_list : SparseBooleanArray = list1.checkedItemPositions
        for (i in 0 until check_list.size() ) {
            if (check_list.valueAt(i)) {
                val indeks = check_list.keyAt(i)
                txt += " " + (indeks).toString()
            }
        }
        Toast.makeText(requireContext(), txt, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentList1Binding.inflate(layoutInflater)
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
        //return inflater.inflate(R.layout.fragment_list1, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list1 = binding.listview1
        val adapter1: ArrayAdapter<String> =
            ArrayAdapter<String>(requireContext(), R.layout.simple_list_item_1, data)
        list1.adapter = adapter1
        list1.onItemClickListener = onItemClickListener
        //return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment List1Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            List1Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}