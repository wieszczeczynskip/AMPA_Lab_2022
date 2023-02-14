package com.example.ampa_lab_4

import android.graphics.Color
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentRight.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentRight : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var myAM: ActionMode? = null
    private val myAMCallback: ActionMode.Callback = object : ActionMode.Callback {
        override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
            val inflater = mode.menuInflater
            inflater.inflate(R.menu.menu_color, menu)
            return true
        }
        override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
            return false // Return false if nothing is done
        }
        override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
            return when (item.itemId) {
                R.id.black -> {
                    view?.findViewById<Button>(R.id.color2)?.setBackgroundColor(Color.BLACK)
                    mode.finish() // Action picked -> close the Context. Action Bar
                    true
                }
                R.id.blue -> {
                    view?.findViewById<Button>(R.id.color2)?.setBackgroundColor(Color.BLUE)
                    mode.finish() // Action picked -> close the Context. Action Bar
                    true
                }
                else -> {
                    mode.finish()
                    false
                }
            }
        }
        override fun onDestroyActionMode(p0: ActionMode?) {
            myAM = null
        }
    }

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
        val view = inflater.inflate(R.layout.fragment_right, container, false)

        val button_color = view.findViewById<Button>(R.id.color2)
        button_color!!.setOnLongClickListener(View.OnLongClickListener { view ->
            if (myAM != null) {
                return@OnLongClickListener false
            }
            myAM = requireActivity().startActionMode(myAMCallback)
            view.isSelected = true
            true
        })

        val fab = view.findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener { view ->
            requireActivity().theme.applyStyle(R.style.Theme_AMPA_Lab_4,true)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<View>(R.id.button_rf).setOnClickListener { _ ->
            view.findNavController().navigate(R.id.action_right_frag_to_rightright_frag)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentRight.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentRight().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}