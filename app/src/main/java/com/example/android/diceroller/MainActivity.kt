/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.diceroller
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var sec: MutableList<Int> = mutableListOf<Int>()
        var user_sec: MutableList<Int> = mutableListOf<Int>()
        var finished  = false
        val button_red : Button = findViewById(R.id.rojo)
        val button_yellow : Button = findViewById(R.id.amarillo)
        val button_blue : Button = findViewById(R.id.azul)
        val button_green : Button = findViewById(R.id.verde)
        val button_start : Button = findViewById(R.id.start)
        val button_check : Button = findViewById(R.id.check)
        val toast = Toast.makeText(applicationContext,"Juego terminado", Toast.LENGTH_SHORT)
        val toast2 = Toast.makeText(applicationContext,"Inicio", Toast.LENGTH_SHORT)

        button_start.setOnClickListener{
            finished = false
            reset(sec,user_sec)
            addToSecu(sec)
            toast2.show()
            showSec(sec)
        }

        button_check.setOnClickListener{
            if(finished==false){
                if(checkSec(sec,user_sec)){
                    addToSecu(sec)
                    user_sec.clear()
                    showSec(sec)
                }else{
                    finished=true
                    toast.show()
                }
            }
        }
        button_red.setOnClickListener{
            addUserSec(user_sec,1)
        }
        button_green.setOnClickListener{
            addUserSec(user_sec,2)
        }
        button_yellow.setOnClickListener{
            addUserSec(user_sec,3)
        }
        button_blue.setOnClickListener{
            addUserSec(user_sec,4)
        }
        //showSec(sec)

    }

    fun addToSecu(sec : MutableList<Int>)  {
        val numb= Random.nextInt(4) + 1
        sec.add(numb)
    }

    fun checkSec(sec : MutableList<Int>, secUsr : MutableList<Int>) : Boolean {
        return sec == secUsr
    }

    fun reset(sec: MutableList<Int>, secUsr: MutableList<Int>){
        sec.clear()
        secUsr.clear()
    }

    fun addUserSec(secUsr: MutableList<Int>, color: Int){
        when(color){
            1 -> secUsr.add(1)
            2 -> secUsr.add(2)
            3 -> secUsr.add(3)
            else -> secUsr.add(4)
        }
    }

    fun showSec(sec: MutableList<Int>){
        var t = Toast.makeText(applicationContext,"Inicio", Toast.LENGTH_SHORT)
        for (color in sec){
            when(color){
                1 -> Toast.makeText(applicationContext,"Rojo", Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(applicationContext,"Verde", Toast.LENGTH_SHORT).show()
                3 -> Toast.makeText(applicationContext,"Amarillo", Toast.LENGTH_SHORT).show()
                4 -> Toast.makeText(applicationContext,"Azul", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
