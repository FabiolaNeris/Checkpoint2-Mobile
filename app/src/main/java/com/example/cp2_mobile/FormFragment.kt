package com.example.cp2_mobile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast


class FormFragment : Fragment() {
   private lateinit var editNome: EditText
   private lateinit var editEmail: EditText
   private lateinit var spinnerPais: Spinner
   private lateinit var btnEnviar: Button


   override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View? {
      val view = inflater.inflate(R.layout.fragment_form, container, false)

      editNome = view.findViewById(R.id.textName)
      editEmail = view.findViewById(R.id.textEmail)
      spinnerPais = view.findViewById(R.id.spinnerPais)
      btnEnviar = view.findViewById(R.id.btnEnviar)


      //opcoes de paises
      val opcoes = arrayOf("Brasil", "Agentina", "Mexico")
      val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, opcoes)
      adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
      spinnerPais.adapter = adapter

      btnEnviar.setOnClickListener{
         val nome = editNome.text.toString().trim()
         val email = editEmail.text.toString().trim()
         val pais = spinnerPais.selectedItem.toString()

         if (nome.isEmpty() || email.isEmpty() || pais == "Selecione um país") {
            Toast.makeText(requireContext(), "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            return@setOnClickListener
         }


         val bundle = Bundle().apply {
            putString("nome", nome)
            putString("email", email)
            putString("pais", pais)
         }

         val resultFragment = ResultFragment().apply {
            arguments = bundle
         }

         parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, resultFragment)
            .addToBackStack(null)
            .commit()
      }

      return view
   }


}