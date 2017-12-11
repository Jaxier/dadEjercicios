package dad.cgi.model;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum Interprete {
	BASH("BASH", "bash -c"),
	POWERSHELL("PowerShell", "powershell.exe"),
	SIMBOLO_SISTEMA("Símbolo del Sistema (CMD)", "cmd /c");
	
	private final String value;
	private final String command;
	
	private Interprete(String value, String command) {
		this.value = value;
		this.command = command;
	}
	
	public String getCommand() {
		return command;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
}
