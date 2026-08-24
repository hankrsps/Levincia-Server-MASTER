package ca.momoperes.canarywebhooks;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Response;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.json.simple.JSONObject;

public class WebhookClient implements Runnable {

	private static final Executor HTTP = Executor.newInstance();
	private static final RequestConfig REQUEST_CONFIG = RequestConfig.custom()
			.setCookieSpec(CookieSpecs.IGNORE_COOKIES)
			.build();

	private final URI target;
	private WebhookIdentifier identifier;

	protected WebhookClient(URI target, WebhookIdentifier identifier) {
		this.target = target;
		this.identifier = identifier;
	}

	public Response sendPayload(Payload payload) throws IOException {

		ArrayList<Response> list = new ArrayList<Response>();
		Response response = null;
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				PayloadObject object = payload.toObject();
				try {
					final Response responsed = executePost(object);
					list.add(responsed);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		});

		thread.start();

		if (list.size() > 0) {
			if (list.get(0) != null) {
				response = list.get(0);
				list.clear();
			}
		}

		return response;
	}

	public Response executePost(String body, ContentType contentType) throws IOException {
		HttpPost post = new HttpPost(target);
		post.setConfig(REQUEST_CONFIG);
		post.setEntity(new StringEntity(body, contentType));
		return HTTP.execute(post);
	}

	public Response executePost(JSONObject object) throws IOException {
		return executePost(object.toJSONString(), ContentType.APPLICATION_JSON);
	}

	public URI getTarget() {
		return target;
	}

	public WebhookIdentifier getIdentifier() {
		return identifier;
	}

	public void setIdentifier(WebhookIdentifier identifier) {
		this.identifier = identifier;
	}

	@Override
	public void run() {

	}
}
