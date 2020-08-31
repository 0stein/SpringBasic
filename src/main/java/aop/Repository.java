package aop;

public interface Repository <E>{
	E getElementById(int id);
	void inputElement(E t);
}
