package com.example.cp2_mobile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class ResultFragment : Fragment() {

    private lateinit var visualizar: TextView
    private lateinit var voltar:Button
    private lateinit var avancar:Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_result, container, false)
        visualizar = view.findViewById(R.id.resultMostar)
        voltar = view.findViewById(R.id.btnVoltar)
        avancar = view.findViewById(R.id.btnAvancar)

        val nome = arguments?.getString("nome")
        val email = arguments?.getString("email")
        val pais = arguments?.getString("pais")

        visualizar.text = "Nome: $nome \nEmail: $email \nPais: $pais"


        voltar.setOnClickListener{
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

        avancar.setOnClickListener{
            val intent = Intent(activity, Galeria::class.java)
            startActivity(intent)
            activity?.finish()
        }

        return view
    }

}