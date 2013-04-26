package com.uservoice.uservoicesdk.activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;

import com.uservoice.uservoicesdk.R;
import com.uservoice.uservoicesdk.Session;
import com.uservoice.uservoicesdk.model.Article;

public class ArticleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.article_layout);
		Article article = Session.getInstance().getArticle();
		System.out.println(article.getAnswerHtml());
		String styles = "img { width: 100%; }";
	    String html = String.format("<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"http://uservoice.com/stylesheets/vendor/typeset.css\"/><style>%s</style></head><body class=\"typeset\" style=\"font-family: sans-serif; margin: 1em\"><h3>%s</h3>%s</body></html>", styles, article.getQuestion(), article.getAnswerHtml());

		WebView webview = (WebView) findViewById(R.id.webview);
		webview.loadUrl(String.format("data:text/html;charset=utf-8,%s", Uri.encode(html)));
	}
}