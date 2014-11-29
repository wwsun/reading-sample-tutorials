package ch6;

/**
 * For all command objects
 * @author Weiwei
 *
 */
public interface Command {
	public void execute();
	public void undo();
}
