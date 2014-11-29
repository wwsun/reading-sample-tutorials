package ch6;

public class RemoteControl {
	Command[] onCommands;
	Command[] offCommands;
	
	public RemoteControl() {
		onCommands = new Command[7];
		offCommands = new Command[7];
		
		Command noCommand = new noCommand();
		for (int i = 0; i < 7; i++) {
			onCommands[i] = noCommand;
			offCommands[i] = noCommand;
		}
	}
	
	public void setCommand(int slot, Command onCommand, Command offCommand){
		onCommands[slot] = onCommand;
		offCommands[slot] = offCommand;
	}
	
	public void onButtonWasPushed(int slot) {
		onCommands[slot].execute();
	}
	
	public void offButtonWasPushed(int slot){
		offCommands[slot].execute();
	}
	 
	public String toString() {
		 StringBuffer strbuf = new StringBuffer();
		 strbuf.append("\n------Remote Control-------\n");
		 for (int i = 0; i < onCommands.length; i++) {
			strbuf.append("[slot " + i + "] " + onCommands[i].getClass().getName() + "  "
					+ offCommands[i].getClass().getName() + "\n");
		}
		return strbuf.toString();
	}
	
}
