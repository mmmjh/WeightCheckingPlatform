package dao;

import java.util.List;

import model.Allcontent;

public interface Cont {
	public List<Allcontent> search();
	public List<Allcontent> search1();
	public void add(double num,int id);

}
