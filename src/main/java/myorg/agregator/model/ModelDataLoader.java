package myorg.agregator.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class ModelDataLoader {
    private ModelDataLoader() {}
    public static Document getDocument(String urlAddress) throws IOException {
        return Jsoup.connect(urlAddress)
                .userAgent(ModelConstants.MODEL_USER_AGENT)
                .referrer(ModelConstants.MODEL_REFERRER)
                .get();
    }
}
