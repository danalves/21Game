package com.daniloalvesvieira.a21game.fragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.daniloalvesvieira.a21game.PerdeuActivity

import com.daniloalvesvieira.a21game.R
import com.daniloalvesvieira.a21game.dao.CartaDAO
import com.daniloalvesvieira.a21game.model.Carta
import kotlinx.android.synthetic.main.fragment_game.*
import java.util.*
import kotlin.collections.ArrayList


/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {

    val cartaDAO = CartaDAO()
    val gerador = Random()
    var cartas: MutableList<Carta> = ArrayList()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btProxima.setOnClickListener({
            pedirCarta()
        })

        btRecomecar.setOnClickListener({
            iniciarPartida()
        })

        iniciarPartida()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_game, container, false)

        return view


    }

    fun iniciarPartida(){
        tvPontuacao.setText("0")
        cartas = cartaDAO.getBaralho().toMutableList()
    }

    fun pedirCarta(){
        val posicaoCartaSelecionada = gerador.nextInt(cartas.size)
        val cartaSelecionada = cartas.get(posicaoCartaSelecionada)

        val pontuacaoAtualizada = tvPontuacao.text.toString().toInt() + cartaSelecionada.valor

        tvPontuacao.text = pontuacaoAtualizada.toString()

        if (pontuacaoAtualizada > 21){
            val intent = Intent(context, PerdeuActivity::class.java)
            intent.putExtra("PONTUACAO", pontuacaoAtualizada.toString())
            startActivity(intent)
        } else{
            cartas.removeAt(posicaoCartaSelecionada)
            ivCarta.setImageDrawable(ContextCompat.getDrawable(context!!, cartaSelecionada.resourceId))
        }
    }

}// Required empty public constructor
