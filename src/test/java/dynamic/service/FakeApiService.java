package dynamic.service;

import static java.lang.String.format;

public class FakeApiService {
    private FakeApiService(){}
    public static final String GO_TO_EBAY_URL = "{\"step\" : \"GO_TO_URL\", \"parameters\": {\"Url\":\"www.ebay.com\"}}";
    public static final String SEND_GET = "{\"step\" : \"SEND_GET\", \"parameters\": {\"Url\":\"www.ebay.com/api\", \"Headers\": \"Auth:blabla, repeat:true\"}}";
    public static final String RUN_DB_QUERY = "{\"step\" : \"RUN_DB_QUERY\", \"parameters\": {\"Query\":\"SELECT * FROM USERS WHERE ID = t1\"}}";
    public static final String TEST_CASE = format("[%s, %s, %s]", GO_TO_EBAY_URL, SEND_GET, RUN_DB_QUERY);
}
