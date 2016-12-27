package urlApp.logic.urlShorteningAlgorithms;

public interface IShorteningAlgorithm {

	public static final String BASE_URL = "smrtcd.rs";
	public static final String URL_SEPARATOR = "/";
	
	public String shortenUrl(String urlToShorten);
	
}