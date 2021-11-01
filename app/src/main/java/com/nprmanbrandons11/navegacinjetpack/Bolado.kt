package com.nprmanbrandons11.navegacinjetpack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Bolado.newInstance] factory method to
 * create an instance of this fragment.
 */
class Bolado : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var count : Int = 0
    var wins : Int = 0
    lateinit var scoreMax: String
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

        return inflater.inflate(R.layout.fragment_bolado, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var botonresignarse: Button = view.findViewById(R.id.boton_resig)
        botonresignarse.setOnClickListener{
            var bundle = bundleOf("score" to scoreMax)
            findNavController().navigate(R.id.action_bolado_to_secondFragment,bundle)
        }
        var botonlanzar: Button = view.findViewById(R.id.boton_lanzar)
        botonlanzar.setOnClickListener{
        val prob = 0 .. 1
        val resultado = prob.random()
        var resul : TextView = view.findViewById(R.id.cara_sol)
        if (resultado.toInt() == 1){
            wins++
            count ++
            resul.text = getString(R.string.youwin)

        }
        else{
            count ++
            resul.text = getString(R.string.youlose)

        }
            var score : TextView = view.findViewById(R.id.score)
            score.text = "$wins" + "/" +"$count"
            scoreMax = "$wins" + "/" +"$count"

        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Bolado.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Bolado().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}