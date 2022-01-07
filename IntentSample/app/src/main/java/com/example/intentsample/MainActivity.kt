package com.example.intentsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 画面部品ListViewを取得
        val lvMenu = findViewById<ListView>(R.id.lvMenu)
        // SimpleAdapterで使用するMutableListオブジェクトを用意。
        val menuList: MutableList<MutableMap<String, String>> = mutableListOf()
        // 「から揚げ定食」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録。
        var menu = mutableMapOf("name" to "から揚げ定食", "price" to "800円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to "850円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "トマトソーススパゲティ", "price" to "1200円")
        menuList.add(menu)
        menu = mutableMapOf("name" to "とんかつ定食", "price" to "1000円")
        menuList.add(menu)
        // 繰り返し
        // SimpleAdapter第4引数from用データの用意。
        val from = arrayOf("name", "price")
        // SimpleAdapter第5引数to用データの用意。
        var to = intArrayOf(android.R.id.text1, android.R.id.text2)
        // SimpleAdapterを生成。
        var adapter = SimpleAdapter(this@MainActivity, menuList, android.R.layout.simple_list_item_2, from, to)
        lvMenu.adapter = adapter

        // リストタップのリスナクラス登録。
        lvMenu.onItemClickListener = ListItemClickListener()
    }

    // リストがタップされた時の処理が記述されたメンバクラス。
    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
            // タップされた行のデータを取得。SimpleAdapterでは1行分のデータはMutableMap型！
            val item = parent.getItemAtPosition(position) as MutableMap<String, String>
            // 定食名と金額を取得。
            val menuName = item["name"]
            val menuPrice = item["price"]
            // インテントオブジェクトを生成。
            val intent2MenuThanks = Intent(
                this@MainActivity,
                MenuThanksActivity::class.java
            )
            // 第2画面に送るデータを格納。
            intent2MenuThanks.putExtra("menuName", menuName)
            intent2MenuThanks.putExtra("menuPrice", menuPrice)
            // 第2画面の起動。
            startActivity(intent2MenuThanks)
        }

    }

}


