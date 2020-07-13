package org.techtown.tmap_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    double longitude;
    double latitude;
    location location1;
    location location2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TMapView tmapview = new TMapView(this);
        Button button = findViewById(R.id.location_searching);
        FrameLayout frameLayout = findViewById(R.id.map_view);
        Button button1 = findViewById(R.id.road_searching);

        // 버튼을 클릭하면 자신의 현재 위치를 알 수 있다.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TMapPoint tMapPoint = tmapview.getLocationPoint();
                latitude = 37.4505;  //tMapPoint.getLatitude();
                longitude = 127.1269;  //tMapPoint.getLongitude();
                tmapview.setLocationPoint(longitude, latitude);
                tmapview.setCenterPoint(longitude, latitude);
            }
        });

        // 버튼을 클릭하면 길찾기 불러오기
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), SearchLoadActivity.class);
                Intent intent1 = getIntent();
                startActivityForResult(intent, 1000);

                location1 = intent1.getParcelableExtra("startpoint");
                location2 = intent1.getParcelableExtra("endpoint");
                //Log.d(location1.latitude, location1.longitude);
            }
        });
        // api 키를 보내고 지도를 받음.
        tmapview.setSKTMapApiKey("l7xxdd40e62e60a746978e47d0ea01d18854");
        tmapview.setLanguage(TMapView.LANGUAGE_KOREAN);     // 언어
        tmapview.setIconVisibility(true);   // 현재위치로 표시될 아이콘을 표시할지 여부
        tmapview.setZoomLevel(15);          // 지도 축척레벨 설정
        tmapview.setMapType(TMapView.MAPTYPE_STANDARD); // 지도 타입을 설정.(지금은 일반지도)
        tmapview.setCompassMode(true); // 단말의 방향에 따라 움직이는 나침반 모드
        tmapview.setTrackingMode(true); // 화면 중심을 단말의 현제위치로 이동시켜주는 트래킹 모드 설정

        frameLayout.addView(tmapview);

        tmapview.setOnClickListenerCallBack(new TMapView.OnClickListenerCallback() {
            @Override
            public boolean onPressEvent(ArrayList arrayList, ArrayList arrayList1, TMapPoint tMapPoint, PointF pointF) {
                //Toast.makeText(MapEvent.this, "onPress~!", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onPressUpEvent(ArrayList arrayList, ArrayList arrayList1, TMapPoint tMapPoint, PointF pointF) {
                //Toast.makeText(MapEvent.this, "onPressUp~!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }



}