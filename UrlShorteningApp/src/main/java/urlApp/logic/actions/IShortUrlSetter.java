package urlApp.logic.actions;

public interface IShortUrlSetter {

	/**
	 * 
	 * @param longUrlToBeConverted
	 * @param shortUrlToConvertTo - if short url is not set by user then IShorteningAlgorithm will be used to generate it.
	 * @return short url that was set for given longUrlToBeConverted 
	 * @throws IllegalArgumentException if shortUrlToConvertTo specified by user contains forbidden characters (is not alphanumeric)
	 */
	public String setShortUrl(String longUrlToBeConverted, String shortUrlToConvertTo) throws IllegalArgumentException;
	
}
