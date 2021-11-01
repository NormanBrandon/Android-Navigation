package com.nprmanbrandons11.navegacinjetpack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var botoncerrar: Button = view.findViewById(R.id.boton_login)
        botoncerrar.setOnClickListener{
            var psswd :EditText = view.findViewById(R.id.edit_passwd)
            var user :EditText = view.findViewById(R.id.edit_user)


            if (psswd.text.toString().equals("1234") && user.text.toString().equals("norman@gmail.com")){
                val usuario = user.text.toString()
                val bundle = bundleOf("user" to usuario)
                findNavController().navigate(R.id.action_loginFragment_to_secondFragment, bundle)

            }
            else{
                Toast.makeText(view.context,"Contraseña o Usuario Incorrectos",Toast.LENGTH_LONG).show()
                //Toast.makeText(view.context,psswd.text.toString(),Toast.LENGTH_LONG).show()
                //Toast.makeText(view.context,user.text.toString(),Toast.LENGTH_LONG).show()
            }


        }

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}