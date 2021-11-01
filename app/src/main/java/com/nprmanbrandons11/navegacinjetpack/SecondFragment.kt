package com.nprmanbrandons11.navegacinjetpack

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var argumento:String? = null
    var argumentoscore:String? = null
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
        argumento= arguments?.getString("user")

        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        argumentoscore = arguments?.getString("score")
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvscore:TextView = view.findViewById(R.id.scoretv)
        if(argumentoscore != null){

        tvscore.text = argumentoscore}
        else{
            tvscore.text = "0"
        }


        val tv:TextView = view.findViewById(R.id.usuario_nombre)
        tv.text = argumento
        var botoncerrar: Button = view.findViewById(R.id.boton_cerrarsesion)
        var botoncambiar: Button = view.findViewById(R.id.boton_cambiar)
        var botonjugar: Button = view.findViewById(R.id.boton_irbolado)
        botoncerrar.setOnClickListener{
            findNavController().navigate(R.id.action_secondFragment_to_fragmentMain)

        }
        botoncambiar.setOnClickListener{
            findNavController().navigate(R.id.action_secondFragment_to_loginFragment)

        }
        botonjugar.setOnClickListener{
            findNavController().navigate(R.id.action_secondFragment_to_bolado)

        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}