package mygame;
import java.util.Vector;

public interface Kranen {

	public Vector positie = null;

	public Container container = null;

	public abstract void setContainer(Container Container);

	public abstract Container getContainer();

}
