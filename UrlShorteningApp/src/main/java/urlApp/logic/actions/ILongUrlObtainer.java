package urlApp.logic.actions;

import urlApp.logic.urlExceptions.UrlNotFoundException;

public interface ILongUrlObtainer {

	public String getLongUrl(String shortUrlToBeResolved) throws UrlNotFoundException;
	
}
