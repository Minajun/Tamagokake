import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Node extends GameObject{
	Node nextNode = null;

	public Node(Point p, int size) {
		super(p, size);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public void addNode(GameObject obj){
		if(nextNode != null){
			nextNode.addNode(this);
		}else{
			System.out.println(this.p.x + "," + this.p.y);
			nextNode = new Node(this.p, size);
		}
	}

	public void Move(GameObject obj){
		if(nextNode != null)
			nextNode.Move(this);
		this.p = (Point)obj.p.clone();
	}

	//描画
	@Override
	public void draw(Graphics g){
		g.setColor(Color.green);
		g.fillOval(p.x*size, p.y*size, size, size);
		g.setColor(Color.black);
		if(nextNode != null)
			nextNode.draw(g);
		if(nextNode == null)
			System.out.println(this.p.x + "," + this.p.y);
	}

	//ブロックの衝突判定
	public void collisionNode(GameObject obj){
		if(collisionDetect(obj) == false){
			if(nextNode != null)
				nextNode.collisionNode(obj);
		}
	}

	//衝突時の処理
	@Override
	protected void collisionProc(GameObject obj){
		System.out.println("Collision Node!!");
		//頭と衝突した時
		if(obj instanceof Head){
			System.out.println("GameOver");
			//g.drawString("GameOver...", 270, 270);
			try{
				Thread.sleep(5000);
				System.exit(1);
				}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
