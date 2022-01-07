package com.example.listviewsample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // ListViewオブジェクトを取得。
        val lvMenu = findViewById<ListView>(R.id.lvMenu)
        // リストビューに表示するリストデータを生成。
        val menuList = mutableListOf("から揚げ定食", "ハンバーグ定食", "生姜焼き定食", "ステーキ定食", "野菜炒め定食", "とんかつ定食")
        // アダプタオブジェクトを生成。
        val adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, menuList)
        // リストビューにアダプタオブジェクトを設定
        lvMenu.adapter = adapter
        // リストビューにリスナを設定。
        lvMenu.onItemClickListener = ListItemClickListener()
    }

    // リストがタップされた時の処理が記述されたメンバクラス。
    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            // 注文確認ダイアログフラグメントオブジェクトを生成。
            val dialogFragment = OrderConfirmDialogFragment()
            // ダイアログを表示。
            dialogFragment.show(supportFragmentManager, "OrderConfirmDialogFragment")
        }
    }
}