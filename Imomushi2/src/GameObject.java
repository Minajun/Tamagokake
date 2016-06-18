import java.awt.Graphics;
import java.awt.Point;

public abstract class GameObject implements MyGraphics{
	protected Point p; //位置
	protected int size; //サイズ

	public GameObject(){

	}

	public GameObject(Point p, int size){
		this.p = p;
		this.size = size;
	}

	//現在位置を返す
	public Point getPosition(){
		return p;
	}

	//衝突検査
	public boolean collisionDetect(GameObject obj){
		boolean flag = obj.p.equals(this.p);
		if(flag){
			collisionProc(obj);
		}
		return flag;
	}

	//衝突時の処理
	protected void collisionProc(GameObject obj){

	}

	//描画
	public void draw(Graphics g){

	}
}
