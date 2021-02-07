package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class GoodsIssuePage1Activity extends AppCompatActivity {

    //region Create

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_issue_page1);
    }

    //endregion

    //region メンバ変数

    // 伝票一覧
    private ArrayList<Long> SlipList = new ArrayList<Long>();

    // 現在の伝票Index
    private int CurrentSlipIndex = 0;

    //endregion

    //region アプリを終了

    public void btnExit_Click(View view) {

        finish();
    }

    //endregion

    //region 伝票を追加

    public void btnSlipAdd_Click(View view) {
    }

    //endregion

    //region 開始ボタンをクリックして、作業画面に遷移

    public void btnStart_Click(View view) {

        Intent intent = new Intent(this, GoodsIssuePage2Activity.class);
        SlipList.add((long) 0);
        //Long[] a = new Long[]{};
        intent.putExtra("SlipList",SlipList);
        intent.putExtra("CurrentSlipIndex",CurrentSlipIndex);

        // 遷移
        startActivity(intent);
    }

    //endregion
}