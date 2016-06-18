import java.awt.Graphics;
import java.awt.Point;

public class Block extends GameObject{
	Block nextBlock = null;
	boolean colApple = false;

	public Block(Point p, int size) {
		super(p, size);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	//ブロックの追加
	public void addBlock(GameObject obj, Point p){
		if(nextBlock != null){
			nextBlock.addBlock(obj, p);
		}else{
			nextBlock = new Block(p, size);
		}
	}

	//描画
	@Override
	public void draw(Graphics g){
		if(nextBlock != null){
			nextBlock.draw(g);
		}
		g.drawRect(p.x*size, p.y*size, size, size);
	}

	//ブロックの衝突判定
	public void collisionBlocks(GameObject obj){
		if(nextBlock != null){
			if(collisionDetect(obj) == false){
				nextBlock.collisionBlocks(obj);
			}
		}
	}

	//衝突時の処理
	@Override
	protected void collisionProc(GameObject obj){
		System.out.println("Collision!!");
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
		//リンゴと衝突したとき
		else if(obj instanceof Apple){
			System.out.println("collision apple");
			obj.collisionProc(this);
		}
		else{
		}
	}
}
