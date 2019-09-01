package dao;

import java.util.List;
import  model.Jichu;

public interface IJichu {
	public void add(Jichu jichu);
	public List<Jichu> search();
	public List<Jichu> search(String keyword);
	public Jichu SearchByKey(int id);
	
}
