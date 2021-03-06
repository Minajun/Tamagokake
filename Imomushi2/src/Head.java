import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Head extends GameObject{
	private int dist = 0;
	Node nextNode = null;

	public Head(Point p, int size, Node node) {
		super(p, size);
		// TODO 自動生成されたコンストラクター・スタブ
		nextNode = node;
	}

	//衝突時の処理
	@Override
	public void collisionProc(GameObject obj){
		if(obj instanceof Apple){
			nextNode.addNode(this);
		}
	}

	//描画
	@Override
	public void draw(Graphics g){
		g.setColor(Color.yellow);
		g.fillOval(p.x*size, p.y*size, size, size);
		g.setColor(Color.black);
	}

	//方向転換
	public void ChangeDist(){
		dist = (++dist) % 4;
	}

	//移動
	public void Move(){
		if(dist == 0){
			p.y--;
		}else if(dist == 1){
			p.x++;
		}else if(dist == 2){
			p.y++;
		}else{
			p.x--;
		}
	}
}
