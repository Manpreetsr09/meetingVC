package man.run2.mymeetingapp


import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.activity.enableEdgeToEdge

import com.zegocloud.uikit.prebuilt.videoconference.ZegoUIKitPrebuiltVideoConferenceConfig
import com.zegocloud.uikit.prebuilt.videoconference.ZegoUIKitPrebuiltVideoConferenceFragment


class ConfrenceActivity : AppCompatActivity() {

    lateinit var meetingID : String
    lateinit var username : String
    lateinit var meetingIDTextView : TextView
    lateinit var shareBTn : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confrence)


        meetingIDTextView = findViewById(R.id.meeting_id_textview)
        shareBTn = findViewById(R.id.share_line)
meetingID = intent.getStringExtra("MEETIND_ID").toString()
        username = intent.getStringExtra("USERNAME").toString()

    meetingIDTextView.setText("MEETING ID :"+ meetingID)
    }
    fun addFragment() {
        val appID: Long = Constant.appId
        val appSign: String = Constant.appSign
        val conferenceID: String = meetingID
        val userID: String = username
        val userName: String = username
        val config = ZegoUIKitPrebuiltVideoConferenceConfig()
        val fragment = ZegoUIKitPrebuiltVideoConferenceFragment.newInstance(
            appID,
            appSign,
            userID,
            userName,
            conferenceID,
            config
        )
        supportFragmentManager.beginTransaction()
            .replace(R.id.call_fragment_container, fragment)
            .commitNow()
    }

}