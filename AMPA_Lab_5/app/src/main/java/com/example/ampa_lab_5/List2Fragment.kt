package com.example.ampa_lab_5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ampa_lab_5.databinding.FragmentList1Binding
import com.example.ampa_lab_5.databinding.FragmentList2Binding
import com.example.ampa_lab_5.databinding.ListRowBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [List2Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class List2Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var recView : RecyclerView
    private lateinit var l2vbinding: FragmentList2Binding


    inner class MyAdapter(var data: MutableList<DataItem>) :
        RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
        inner class MyViewHolder(viewBinding : ListRowBinding) :
            RecyclerView.ViewHolder(viewBinding.root) {
            val tv1: TextView = viewBinding.lrowTv1
            val tv2: TextView = viewBinding.lrowTv2
            val img: ImageView = viewBinding.lrowImage
            val cBox: CheckBox = viewBinding.lrowCheckBox
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val viewBinding = ListRowBinding.inflate(LayoutInflater.from(parent.context),
                parent, false)
            return MyViewHolder(viewBinding)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.tv1.text = data[position].text_main
            holder.tv2.text = data[position].text_2 + data[position].item_value
            holder.cBox.isChecked = data[position].item_checked
            holder.itemView.setOnClickListener {
                Toast.makeText(requireContext(),
                    "You clicked: " + (position + 1),
                    Toast.LENGTH_SHORT).show()
            }
            holder.cBox.setOnClickListener { v ->
                data[position].item_checked = (v as CheckBox).isChecked
                Toast.makeText(requireContext(),
                    "Selected/Unselected: " + (position + 1),
                    Toast.LENGTH_SHORT).show()
            }
            when (data[position].item_type) {
                false -> holder.img.setImageResource(R.drawable.ic_img1)
                true -> holder.img.setImageResource(R.drawable.ic_img2)
            }
            holder.itemView.setOnLongClickListener {
                if (DataRepo.getinstance().deleteItem(position))
                    notifyDataSetChanged()
                true
            }
        }

        override fun getItemCount(): Int {
            return data.size
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        l2vbinding = FragmentList2Binding.inflate(layoutInflater)
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
        return l2vbinding.root
        //return inflater.inflate(R.layout.fragment_list2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val dataRepo = DataRepo.getinstance()
//        val adapter = MyAdapter(dataRepo.getData())
        recView = l2vbinding.myRecView
        recView.layoutManager = LinearLayoutManager(requireContext())
        val adapter2 = DataRepo.getinstance().getData().let { MyAdapter(it) }
        recView.adapter = adapter2


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment List2Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            List2Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}