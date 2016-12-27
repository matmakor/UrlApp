package urlApp.presentation.cli;

public interface ICliParser {

	public boolean hasOption(String arg);
	public String getOptionValue(String arg);
	
}
