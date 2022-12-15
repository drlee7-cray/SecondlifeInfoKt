package com.cray.secondlifeinfokt

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.URL

class MainActivity : AppCompatActivity() {

    val listView : ListView by lazy {
        findViewById(R.id.listView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = ""
        var inputStream: InputStream? = null
        try {
            inputStream = URL(url).openStream()
            val rd = BufferedReader(InputStreamReader(inputStream, "UTF-8"))
            var str: String?
            val buffer = StringBuffer()
            while (rd.readLine().also { str = it } != null) {
                buffer.append(str)
            }
            val receiveMsg = buffer.toString()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        val secondLifeInfoArr = arrayListOf<SecondListInfo>(
            SecondListInfo(
                "http://dreamplan7.cafe24.com/SL/img/%EC%B9%B4%EB%93%9C_%ED%95%9C%EA%B8%80%ED%8C%A8%EC%B9%98.jpg",
                "https://blog.naver.com/ephraimdrlee/221331633213",
                "크레이의 독특한 세컨드라이프 튜토리얼 2강. 세컨드라이프 뷰어 다운받기",
                "오늘은 세컨드라이프 뷰어를 다운받는 방법과 \n" +
                        "영어-한글 스킨을 패치하는 방법을 알아보도록 하겠습니다.\n" +
                        "\n" +
                        "참고로 본 스킨은 크레이의 개인버전 스킨이지, 공식버전은 아닌 점을 밝힙니다 :)"
            ),
            SecondListInfo(
                "http://dreamplan7.cafe24.com/SL/img/%EC%B9%B4%EB%93%9C_%EC%84%B8%EC%BB%A8%EB%93%9C%EB%9D%BC%EC%9D%B4%ED%94%84%ED%83%90%ED%97%98.jpg",
                "https://blog.naver.com/ephraimdrlee/221336863669",
                "세컨드라이프를 누려~ 1편. 어드벤쳐(탐험)",
                "대륙!\n" +
                        "세컨드라이프는 광활한 대륙과 같다고 생각됩니다.\n" +
                        "적어도 크레이가 느낀 바는 그렇더라구요\n"
            ),
            SecondListInfo(
                "http://dreamplan7.cafe24.com/SL/img/%EC%B9%B4%EB%93%9C_%EC%9D%B8%EC%9B%94%EB%93%9C%EB%AC%B4%EB%A3%8C%EC%95%84%EC%9D%B4%ED%85%9C.jpg",
                "https://blog.naver.com/ephraimdrlee/221339010139",
                "세컨드라이프를 누려~ 2편. 무료아이템 ( 인월드편 )",
                "세컨드라이프에 무료 아이템에 대해 알아보기로 했었지요?\n" +
                        "예고대로 진행하도록 하겠습니다 :)\n" +
                        "세컨드라이프의 인벤토리는 마치 윈도우 탐색기와 같습니다."
            ),
            SecondListInfo(
                "http://dreamplan7.cafe24.com/SL/img/%EC%B9%B4%EB%93%9C_%EC%95%84%EB%91%90%EC%9D%B4%EB%85%B8%ED%94%BC%EC%95%84%EB%85%B8.jpg",
                "https://blog.naver.com/ephraimdrlee/221345870599",
                "세컨드라이프 현실과 만나다, 사물인터넷과 세컨드라이프",
                "안녕하세요. 크레이입니다 :)\n" +
                        "무슨글인가 보러왔다가 갑자기 현실의 컴퓨터가 나와서 놀라셨을수도 있겠군요 ㅎㅎ\n" +
                        "가상세계 세컨드라이프는 현실과 통신할만한 기술들이 마련되어 있고,\n" +
                        "일반 사용자가 3D 인터넷 공간을 구성하면서, 그 기기들을 연결할 수 있습니다."
            ),
            SecondListInfo(
                "http://dreamplan7.cafe24.com/SL/img/%EC%B9%B4%EB%93%9C_sl%EC%9B%B9%EC%84%9C%EB%B2%84.jpg",
                "https://blog.naver.com/ephraimdrlee/221346556647",
                "사물인터넷과 세컨드라이프 첫번째 강좌, 세컨드라이프, 웹서버가 되다",
                "세컨드라이프에서 Script 스크립트 는 도대체 무엇일까요?\n" +
                        "간단히 답변 드리겠습니다. 간단한 간이 프로그램 개발 도구입니다.\n" +
                        "하지만, 어렵지 않고 누구나 사람들이 동시에 보는 가운데 \n" +
                        "실시간으로 사용할 수 있는 프로그램이라는 점에서 의미가 큽니다."
            ),
            SecondListInfo(
                "http://dreamplan7.cafe24.com/SL/img/%EC%B9%B4%EB%93%9C_sl%EC%97%B0%EA%B2%B0_%EC%8A%A4%EB%A7%88%ED%8A%B8%ED%8F%B0.jpg",
                "https://blog.naver.com/ephraimdrlee/221348448034",
                "스마트폰과 연결된 세컨드라이프\n",
                "요즘 시대는 누구나 할 것 없이 스마트폰을 다 갖고 다니시지요.\n" +
                        "어린 애들조차도 부모님께 졸라대면 \n" +
                        "'이번 수학시점 100점 맞으면 사줄께~' 라는 부모님의 말에\n" +
                        "기어이 100점을 맞아서라도 득템! 을 해내는게 요즈음의 현실입니다."
            ),
            SecondListInfo(
                "http://dreamplan7.cafe24.com/SL/img/%EC%B9%B4%EB%93%9C_%EC%95%84%EB%91%90%EC%9D%B4%EB%85%B8.jpg",
                "https://blog.naver.com/ephraimdrlee/221351023053",
                "사물인터넷과 세컨드라이프",
                "아두이노 보드란 사물인터넷의 한 종류입니다.\n" +
                        "이번 강좌는 아두이노 보드라는 실제 기계가 없으면 실행을 할 수 없는 점 양해바랍니다.\n" +
                        "하지만 현실과 가상을 연결하는 만큼 해보고 싶으신 분은 투자할만한 가치가 있겠지요?"
            ),
            SecondListInfo(
                "http://dreamplan7.cafe24.com/SL/img/%EC%B9%B4%EB%93%9C_%EC%95%84%EB%91%90%EC%9D%B4%EB%85%B8%ED%94%BC%EC%95%84%EB%85%B8.jpg",
                "https://blog.naver.com/ephraimdrlee/221351026745",
                "아두이노 보드가 전해주는 말을 들어봐!",
                "지난 파트 1에서는 아두이노 보드를 통해 간단한 샘플 프로그램을 다루어 보았었는데요.\n" +
                        "\n" +
                        "\n" +
                        "이번에는 실제 아두이노 보드를 피아노처럼 구성하여 연결하고 \n" +
                        "아두이노에서 버튼을 누르면 컴퓨터에 알려주는 컴퓨터와 소통하는 방법을 다뤄보도록 하겠습니다."
            ),
            SecondListInfo(
                "http://dreamplan7.cafe24.com/SL/img/%EC%B9%B4%EB%93%9C_cs.jpg",
                "https://blog.naver.com/ephraimdrlee/221352581116",
                "아두이노에서 신호 받아 세컨드라이프에 토스!",
                "'비주얼 스튜디오'라고 들어보셨나요?\n" +
                        "그 유명한 빌게이츠가 운영했던 마이크로 소프트사에서 만든 강력한 개발 도구입니다.\n" +
                        "바로 대부분의 사용자분들이 지금도 쓰고 있는 윈도우XP, 윈도우7 등을 개발한 곳이 \n" +
                        "바로 이 회사이기도 하지요\n"
            ),
            SecondListInfo(
                "http://dreamplan7.cafe24.com/SL/img/%EC%B9%B4%EB%93%9C_%EA%B1%B4%EB%B0%98%ED%9A%A8%EA%B3%BC.jpg",
                "https://blog.naver.com/ephraimdrlee/221353965850",
                "세컨드라이프와 아두이노 피아노에서의 건반 효과\n",
                "오늘은 맨처음 영상에서 보셨던 건반 효과를 보도록 하겠습니다.\n" +
                        "먼저 어떤 건지 위의 영상을 보실까요? :)\n" +
                        "가상세계 세컨드라이프 안에서 음정이 울리면서\n" +
                        "건반의 불도 순간 켜졌다가 페이드 아웃되면서 꺼집니다."
            )

        )

        var secondLifeAdapter = SecondLifeAdapter(this, secondLifeInfoArr )
        listView.adapter = secondLifeAdapter

        listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val selectOne = parent.getItemAtPosition(position) as SecondListInfo
                // selectOne.urlimg
                val webView = findViewById<WebView>(R.id.webView)

                webView.settings.javaScriptEnabled = true;
                webView.webViewClient = WebViewClient()
                webView.webChromeClient = WebChromeClient()
                webView.loadUrl(selectOne.linkurl)
            }

    }
}