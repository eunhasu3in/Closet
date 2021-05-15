package com.example.closet

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.core.content.FileProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    // 메인액티비티 클래스가 가지고 있는 멤버들
    private lateinit var homeFragment: HomeFragment
    private lateinit var fashionistaFragment: FashionistaFragment
    private lateinit var closetFragment: ClosetFragment
    private lateinit var feedFragment: FeedFragment
    private lateinit var mypageFragment: MypageFragment

    companion object {
        const val TAG : String = "로그"
   }

    // 화면이 메모리에 올라갔을 때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 레이아웃과 연결
        setContentView(R.layout.activity_main)
        Log.d(TAG, "MainActivity - onCreate() called")
        bottom_nav.setOnNavigationItemSelectedListener(onBottomNavItemSeletedListener)
        // setPermission() // 권한을 체크하는 메소드 수행
        homeFragment = HomeFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.fragments_frame, homeFragment).commit() // add는 프레그먼트 추가해주는 것
    }


    // 바텀 네비게이션 아이템 클릭 리스너 설정
    private val onBottomNavItemSeletedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        // when은 코틀린에서 switch문
        when(it.itemId) {
            R.id.menu_home -> {
                Log.d(TAG, "MainActivity - 홈버튼 클릭!")
                homeFragment = HomeFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, homeFragment).commit() // replace는 다른 프레그먼트로 교체해주는 것
            }
            R.id.menu_fashionista -> {
                Log.d(TAG, "MainActivity - 패셔니스타 버튼 클릭!")
                fashionistaFragment = FashionistaFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, fashionistaFragment).commit() // replace는 다른 프레그먼트로 교체해주는 것
            }
            R.id.menu_closet -> {
                Log.d(TAG, "MainActivity - 옷장 버튼 클릭!")
                closetFragment = ClosetFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, closetFragment).commit() // replace는 다른 프레그먼트로 교체해주는 것
            }
            R.id.menu_feed -> {
                Log.d(TAG, "MainActivity - 피드 버튼 클릭!")
                feedFragment = FeedFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, feedFragment).commit() // replace는 다른 프레그먼트로 교체해주는 것
            }
            R.id.menu_mypage -> {
                Log.d(TAG, "MainActivity - 마이페이지 버튼 클릭!")
                mypageFragment = MypageFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, mypageFragment).commit() // replace는 다른 프레그먼트로 교체해주는 것
            }
        } // when문 끝

        true

    }

//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        Log.d(HomeFragment.TAG, "MainActivity - onNavigationItemSelected() called")
//        // when은 코틀린에서 switch문
//
//    }
}