import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JApplet;


public class ImomushiMain extends JApplet implements Runnable, MouseListener{

	private int size = 20; //オブジェクトの大きさ
	private final int w = 720, h = 540; //画面の大きさ
	private Thread t;

	private Stage stage = new Stage();
	private Head head = new Head(new Point(5,5), size);
	private Node node = new Node(new Point(5,6), size);

	//Appletの初期化
	public void init(){
		setSize(w, h);
		addMouseListener(this);
		t = new Thread(this);
		t.start();
	}

	//Appletに描画
	public void paint(Graphics g){
		//クリア処理
		g.clearRect(0, 0, w, h);

		//描画処理
		stage.drawUpdate(g);
		node.draw(g);
	}

	//実行部
	public void run(){
		//ブロックの配置
		stage.addObject(new Block(new Point(0, 0), size));
		stage.addObject(new Block(new Point(20, 20), size));
		stage.addObject(new Block(new Point(0, 20), size));
		stage.addObject(new Block(new Point(20, 0), size));
		for(int i = 1; i < 20; i++){
			stage.addObject(new Block(new Point(i, 0), size));
			stage.addObject(new Block(new Point(0, i), size));
			stage.addObject(new Block(new Point(i, 20), size));
			stage.addObject(new Block(new Point(20, i), size));
		}

		//頭の配置
		stage.addObject(head);

		//節の配置
		stage.addObject(node);

		//メインループ
		while(t != null){
			try {
				//処理
				node.Move(head);
				head.Move();
				Thread.sleep(500);
				repaint();
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		int btn = e.getButton();
		if (btn == MouseEvent.BUTTON1){
			head.ChangeDist();
		  }else if (btn == MouseEvent.BUTTON3){
			  node.addNode(head);
		  }
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
