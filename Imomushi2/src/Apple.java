import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Apple extends GameObject {
	Apple nextApple = null;
	boolean incNode = false;

	public Apple(Point p, int size) {
		super(p, size);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public void addApple(GameObject obj){
		if(nextApple != null){
			nextApple.addApple(this);
		}else{
			//System.out.println(this.p.x + "," + this.p.y);
			nextApple = new Apple(this.p, size);
		}
	}

	//描画
	@Override
	public void draw(Graphics g){
		g.setColor(Color.red);
		g.fillOval(p.x*size, p.y*size, size, size);
		g.setColor(Color.black);
		if(nextApple != null)
			nextApple.draw(g);
		if(nextApple == null)
			System.out.println(this.p.x + "," + this.p.y);
	}

	//リンゴの衝突判定
	public void collisionApple(GameObject obj){
		if(collisionDetect(obj) == false){
			if(nextApple != null)
				nextApple.collisionApple(obj);
		}
	}

	//衝突時の処理
	@Override
	protected void collisionProc(GameObject obj){
		System.out.println("Collision Apple!!");
		//頭と衝突した時
		if(obj instanceof Head){
			System.out.println("increase node");
			//g.drawString("GameOver...", 270, 270);
			try{
				Thread.sleep(0);
				this.p.setLocation(5,13);
				obj.collisionProc(this);

				}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		else if(obj instanceof Block){
			this.p.setLocation((int)(Math.random()*size),(int)(Math.random()*size));
		}
	}

	public void setincNode(){
		incNode = !incNode;
	}
}
