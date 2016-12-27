package urlApp.logic.urlShorteningAlgorithms;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import urlApp.data.UrlPair;
import urlApp.data.UrlRepository;
import urlApp.logic.urlExceptions.UrlGeneratingException;

/**
 * Steps are following:
 * 1. Generates random alphanumeric string of SHORTENED_URL_LENGTH length. 
 * 2. Checks if string already exists in database. If so, generates another ones in loop.
 *
 */
@Primary
@Component
public class RandomStringAlgorithm implements IShorteningAlgorithm {

	private static final int SHORTENED_URL_LENGTH = 7;
	private static final int MAX_NUMBER_OF_TRIES_FOR_RANDOM_STRING_GENERATION = 1;

	@Autowired
	private UrlRepository urlRepo;

	@Override
	public String shortenUrl(String urlToShorten) {

		int counter = MAX_NUMBER_OF_TRIES_FOR_RANDOM_STRING_GENERATION;
		String shortenedUrl = null;

		while (counter > 0) {

			shortenedUrl = RandomStringUtils.randomAlphabetic(SHORTENED_URL_LENGTH);

			List<UrlPair> foundUrlPairs = urlRepo.findLongUrl(shortenedUrl);
			if (!foundUrlPairs.isEmpty()) {
				counter -= 1;
			} else {
				break;
			}
		}

		if (counter == 0)
			throw new UrlGeneratingException("Failed " + MAX_NUMBER_OF_TRIES_FOR_RANDOM_STRING_GENERATION
					+ " times to generate unique string for url:" + urlToShorten);
		return shortenedUrl;

	}
}