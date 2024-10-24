//Swingクラスのインポート
import javax.swing.*;
//リストクラスをインポート
import java.util.ArrayList;
//ランダムクラスをインポート
import java.util.Random;

public class Bingo{
    public static void main(String[] args){
        //JFrameでウィンドウの作成
        JFrame frame = new JFrame("BINGO");
    
        //フレームのタイトル設定
        frame.setTitle("BINGO");

        //ウィンドウ設定、Visibleをtrueにして表示
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);

        //JLabelで数字の表示設定
        JLabel label = new JLabel("", SwingConstants.CENTER);
        label.setBounds(0, 0, 500, 400); //ラベルの位置とサイズ設定
        label.setFont(label.getFont().deriveFont(200f)); //フォント設定
        frame.add(label);

        //履歴の表示設定
        JLabel logLabel = new JLabel("", SwingConstants.CENTER);
        logLabel.setBounds(0, 400, 500, 40); //履歴ラベルの位置とサイズ設定
        frame.add(logLabel);

        //1～75を格納したリストを作成
        ArrayList<Integer> num = new  ArrayList<Integer>();
        for (int i=1; i<=75; i++){
            num.add(i);
        }

        //JButtonでボタン作成
        JButton button = new JButton("次の数字を表示");
        button.setBounds(180,350,150,40);
        frame.add(button);
        
        //ActionListenerでボタンのクリックを検知
        button.addActionListener(e->{
            StringBuilder logText = new StringBuilder(logLabel.getText());
            //リストが空かif文で判定
            if (num.isEmpty()){
                label.setText("終了");
            }
            else{
                //リスト内のランダムな数字を選択
                Random rd = new Random();
                int randomIndex = rd.nextInt(num.size());
                int selectedNumber = num.get(randomIndex);
                //選ばれた数字の表示
                label.setText(String.valueOf(selectedNumber));
                //履歴の表示
                if (logText.length()>0){
                    logText.append(" ");
                }
                logText.append(selectedNumber);
                logLabel.setText(logText.toString());
                //選ばれた数字をリストから除外
                num.remove(randomIndex);
            }
        });
    }
}