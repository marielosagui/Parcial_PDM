package com.example.parcial_pdm

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcial_pdm.adapter.partido_adapter
import com.example.parcial_pdm.entities.partido
import com.example.parcial_pdm.viewModel.Partido_viewModel
import kotlinx.android.synthetic.main.fragment_fragment_principal.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [fragment_principal.OnListener] interface
 * to handle interaction events.
 * Use the [fragment_principal.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class fragment_principal : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnListener? = null

    interface OnListener {
        // TODO: Update argument type and name
        fun mostrarPartido(partido: partido)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }




    private lateinit var partidoViewModel : Partido_viewModel
    private lateinit var adapterPartido : partido_adapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_fragment_principal, container, false)

        partidoViewModel = ViewModelProviders.of(this).get(Partido_viewModel::class.java)

        adapterPartido = partido_adapter(emptyList(), {partido: partido -> (listener?.mostrarPartido(partido))})
        view.rv_partido.adapter = adapterPartido
        view.rv_partido.layoutManager = LinearLayoutManager(context)

        partidoViewModel.allPartido.observe(this, Observer {partido ->
            partido?.let{ adapterPartido.setPartido(it) }
        })

        // Inflate the layout for this fragment
        return view
    }





    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fragment_principal.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                fragment_principal().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
