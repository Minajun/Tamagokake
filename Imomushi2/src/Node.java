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
	public void draw(Graphics g){
		g.setColor(Color.green);
		g.fillOval(p.x*size, p.y*size, size, size);
		g.setColor(Color.black);
		if(nextNode != null)
			nextNode.draw(g);
	}
}
