package com.example.closet

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_closet.*
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
        val clothesActivity = ClothesActivity()
        Log.d(TAG, "MainActivity - onCreate() called")
        bottom_nav.setOnNavigationItemSelectedListener(onBottomNavItemSeletedListener)
        setPermission() // 권한을 체크하는 메소드 수행

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

    /**
     * 테드 퍼미션 설정
     */
    private fun setPermission() {
        val permission = object : PermissionListener {
            override fun onPermissionGranted() { // 설정해놓은 위험 권한들이 허용되었을 경우 이곳을 수행함.
                Toast.makeText(this@MainActivity, "권한이 혀용 되었습니다.", Toast.LENGTH_SHORT).show()
            }
            override fun onPermissionDenied(deniedPermissions: MutableList<String>?) { // 설정해놓은 위험 권한들 중 거부를 한 경우 이곳을 수행함.
                Toast.makeText(this@MainActivity, "권한이 거부 되었습니다.", Toast.LENGTH_SHORT).show()
            }
        }
        TedPermission.with(this)
                .setPermissionListener(permission)
                .setRationaleMessage("카메라 앱을 사용하시려면 권한을 허용해주세요.")
                .setDeniedMessage("권한을 거부하셨습니다. [앱 설정] -> [권한] 항목에서 허용해주세요.")
                .setPermissions(android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.CAMERA)
                .check()
    }








}