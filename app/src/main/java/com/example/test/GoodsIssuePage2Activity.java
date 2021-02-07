package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GoodsIssuePage2Activity extends AppCompatActivity {

    //region Create

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_issue_page2);

//        // 伝票一覧&現在の伝票Index取得
//        Intent intent = getIntent();
//        SlipList = intent.getLongArrayExtra("SlipList");
//        CurrentSlipIndex = intent.getIntExtra("CurrentSlipIndex",-1);
//
//        // データ取得
//        GetSlipData(SlipList[CurrentSlipIndex]);

        // リフレッシュ
        Refresh();
    }

    //endregion

    //region メンバ変数

    // 伝票一覧
    private long[] SlipList;

    // 現在の伝票Index
    private int CurrentSlipIndex = -1;

    //endregion

    //region 進行状況

    // 現在の進行状況
    private ProgressEnum CurrentProgressState = ProgressEnum.Instruct;

    private enum ProgressEnum
    {
        Start,
        Instruct,
        Complete,
        Confirm
    };

    //endregion

    //region 伝票データを取得する

    private void GetSlipData(long slipNo)
    {
        CurrentProgressState = ProgressEnum.Instruct;


    }


    //endregion

    //region 画面をリフレッシュする

    private void Refresh()
    {
        TextView txtProgressPhase2 = findViewById(R.id.txtProgressPhase2);
        TextView txtProgressPhase3 = findViewById(R.id.txtProgressPhase3);
        TextView txtProgressPhase4 = findViewById(R.id.txtProgressPhase4);
        TextView txtGoodsIssuePage2Guidance = findViewById(R.id.txtGoodsIssuePage2Guidance);
        Button btnProceed = findViewById(R.id.btnProceed);

        switch (CurrentProgressState)
        {
            // 指示
            case Instruct:

                // 進行状況
                txtProgressPhase2.setBackgroundColor(getColor(R.color.red));
                txtProgressPhase3.setBackgroundColor(getColor(R.color.transparent));
                txtProgressPhase4.setBackgroundColor(getColor(R.color.transparent));
                txtProgressPhase2.setTextColor(getColor(R.color.white));
                txtProgressPhase3.setTextColor(getColor(R.color.black));
                txtProgressPhase4.setTextColor(getColor(R.color.black));

                // ガイダンス
                txtGoodsIssuePage2Guidance.setText(R.string.text_1);

                // 進行ボタン
                btnProceed.setText("出庫指示");
                btnProceed.setBackgroundColor(getColor(R.color.orange));

                break;

            // 完了
            case Complete:

                // 進行状況
                txtProgressPhase2.setBackgroundColor(getColor(R.color.red));
                txtProgressPhase3.setBackgroundColor(getColor(R.color.red));
                txtProgressPhase4.setBackgroundColor(getColor(R.color.transparent));
                txtProgressPhase2.setTextColor(getColor(R.color.white));
                txtProgressPhase3.setTextColor(getColor(R.color.white));
                txtProgressPhase4.setTextColor(getColor(R.color.black));

                // ガイダンス
                txtGoodsIssuePage2Guidance.setText(R.string.text_2);

                // 進行ボタン
                btnProceed.setText("出庫完了");
                btnProceed.setBackgroundColor(getColor(R.color.orange));

                break;

            // 確認
            case Confirm:

                // 進行状況
                txtProgressPhase2.setBackgroundColor(getColor(R.color.red));
                txtProgressPhase3.setBackgroundColor(getColor(R.color.red));
                txtProgressPhase4.setBackgroundColor(getColor(R.color.red));
                txtProgressPhase2.setTextColor(getColor(R.color.white));
                txtProgressPhase3.setTextColor(getColor(R.color.white));
                txtProgressPhase4.setTextColor(getColor(R.color.white));

                // ガイダンス
                txtGoodsIssuePage2Guidance.setText(R.string.text_3);

                // 進行ボタン
                btnProceed.setText("受領確認");
                btnProceed.setBackgroundColor(getColor(R.color.red));

                break;
        }
    }

    //endregion

    //region 前伝票を表示する

    public void btnPreviousSlip_Click(View view) {
    }

    //endregion

    //region 次伝票を表示する

    public void btnNextSlip_Click(View view) {
    }

    //endregion

    //region 現在の進行状況を一つ進める

    public void btnProceed_Click(View view) {

        // 現在の進行状況を一つ進める
        switch (CurrentProgressState)
        {
            // 指示
            case Instruct:
                CurrentProgressState = ProgressEnum.Complete;
                break;

            // 完了
            case Complete:
                CurrentProgressState = ProgressEnum.Confirm;
                break;

            // 確認
            case Confirm:

                if(true)
                {
                    // 他伝票を進行する
                    CurrentProgressState = ProgressEnum.Instruct;
                }
                else
                {
                    // 出庫伝票一覧に戻る
                    finish();
                }

                break;
        }

        // 伝票データを再取得
        GetSlipData(0);

        // 画面をリフレッシュ
        Refresh();
    }

    // 進行状況を更新する
    private void UpdateProgressState(long slipNo)
    {


    }

    //endregion
}