package com.acme.flipv1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu

import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.view.get

class GameConfig : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_config)
        val btnInit = findViewById<Button>(R.id.startBtn)
        val seekBarH = findViewById<SeekBar>(R.id.seekBarX)
        val seekBarY = findViewById<SeekBar>(R.id.seekBarY)
        val seekBarColors =  findViewById<SeekBar>(R.id.seekBarColors)

//        Barras
        seekBarH?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, i: Int, fromUser: Boolean) {
                updateXTiles(seekBar.progress)
            }

            override fun onStartTrackingTouch(seekbar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
        seekBarY?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, i: Int, fromUser: Boolean) {
                updateYTiles(seekBar.progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        seekBarColors.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged( seekBar: SeekBar, progress: Int, fromUser : Boolean) {
                updateColors(seekBar.progress)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })
        updateColors(seekBarColors.progress)
//Boton
        btnInit.setOnClickListener{
            starPlay(it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_game_config,menu)
//        menu?.getItem(0)?.subMenu?.getItem(3)?.isVisible = true
//        menu?.getItem(0)?.subMenu?.getItem(4)?.isVisible = true

        return super.onCreateOptionsMenu(menu)
    }

    private fun updateColors(progress: Int) {
        var tcolors = findViewById<TextView>(R.id.seekBarColorstxt)
        tcolors.text = getString(R.string.num_colors)+" "+(progress+2)
    }

    private fun updateYTiles(progress: Int) {
        var ty = findViewById<TextView>(R.id.seekBarYtxt)
        ty.text = getString(R.string.num_ele_x)+" "+(progress+3)
    }

    private fun updateXTiles(progress: Int) {
        var tx = findViewById<TextView>(R.id.seekBarXtxt)
        tx.text = getString(R.string.num_ele_x)+" "+(progress+3)
    }

    private fun starPlay(view : View) {
    }
}
