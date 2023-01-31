package ru.calypso;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 
 * @author CalypsoToolz
 *
 */

public class Telegram {

	private final String urlToken;

	public Telegram(String token) {
		this.urlToken = "https://api.telegram.org/bot" + token + "/sendMessage";
	}

	/**
	 * 
	 * @param txt
	 * @param chatIdOrName (ид группы/канала или имя (ex. @fproject)
	 */
	public void sendMessage(final String txt, final String chatIdOrName) {
		HttpURLConnection con = null;
		try {
			final String urlParameters = "?chat_id=" + chatIdOrName + "&text=" + txt.replace("\n", "%0A");
			URL myurl = new URL(urlToken + urlParameters);
			con = (HttpURLConnection) myurl.openConnection();
			con.setRequestMethod(WEB_REQUEST_METHOD_GET);
			StringBuilder content;
			try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
				String line;
				content = new StringBuilder();

				while ((line = in.readLine()) != null) {
					content.append(line);
					content.append(System.lineSeparator());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.disconnect();
		}
	}
}
