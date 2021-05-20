package com.example.closet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_clothes_save.*

class ClothesSaveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clothes_save)

        // 액션바 대신 툴바를 사용하도록 설정한다
        setSupportActionBar(toolbar)
        val ab = supportActionBar!!
        ab.setDisplayShowTitleEnabled(false)
        ab.setDisplayHomeAsUpEnabled(true) // 툴바 설정 완료

//        // 카테고리 리스트 변수 선언
//        var cData = resources.getStringArray(R.array.category)
//        // 스피너를 위한 Adapter 만들기
//        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cData) // 스피너가 그려질 컨텍스트, 목록 하나하나의 레이아웃, 각 목록들의 데이터
//        sp_category.adapter = adapter
//        sp_category.setSelection(0)
//        sp_category.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                val selectedValue = cData[position]
//                textView.text = selectedValue
//            }
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//            }
//        }

        tv_category.setOnClickListener {
            val bottomSheet = BottomSheet_category()
            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }

        tv_color.setOnClickListener {
            val bottomSheet = BottomSheet_color()
            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }

        tv_season.setOnClickListener {
            val bottomSheet = BottomSheet_season()
            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }

        // 에디트 버튼 클릭
        btn_edit.setOnClickListener {

        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}