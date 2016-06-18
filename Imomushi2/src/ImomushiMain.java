import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JApplet;


public class ImomushiMain extends JApplet implements Runnable, MouseListener{

	private int size = 20; //オブジェクトの大きさ
	private final int w = 720, h = 540; //画面の大きさ
	private Thread t;


	private Node node = new Node(new Point(5,6), size);
	private Head head = new Head(new Point(5,5), size, node);
	private Block block = new Block(new Point(0,0), size);
	private Apple apple = new Apple(new Point(10,10), size);

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
		drawUpdate(g);
	}

	//実行部
	public void run(){
		//ブロックの配置
		block.addBlock(block, new Point(20,20));
		block.addBlock(block, new Point(0,20));
		block.addBlock(block, new Point(0,20));
		block.addBlock(block, new Point(20,0));
		block.addBlock(block, new Point(15,10));
		block.addBlock(block, new Point(5,13));
		block.addBlock(block, new Point(14,10));
		block.addBlock(block, new Point(11,9));
		for(int i = 1; i < 20; i++){
			block.addBlock(block, new Point(i,0));
			block.addBlock(block, new Point(0,i));
			block.addBlock(block, new Point(i,20));
			block.addBlock(block, new Point(20,i));
		}


		//メインループ
		while(t != null){
			try {
				//処理
				node.Move(head);
				head.Move();
				block.CollisionBlocks(head);
				node.CollisionNode(head);
				apple.collisionApple(head);
				block.CollisionBlocks(apple);
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

	public void drawUpdate(Graphics g){
		head.draw(g);
		node.draw(g);
		block.draw(g);
		apple.draw(g);
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
