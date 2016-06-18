import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stage {
	private List<GameObject> list = null;

	public Stage(){
		list = new ArrayList<GameObject>();
	}

	public void addObject(GameObject obj){
		list.add(obj);
	}

	public void drawUpdate(Graphics g){
		Iterator<GameObject> itr = list.iterator();
		while(itr.hasNext()){
			GameObject obj = itr.next();
			obj.draw(g);
		}
	}
}
