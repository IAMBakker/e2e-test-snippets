package datamodel;

public class TestItem {

    private final int key;
    private final String searchTerm;
    private final String testClass;
    private String text;
    private String url;

    public TestItem(int key, String searchTerm, String testClass) {
        this.key = key;
        this.searchTerm = searchTerm;
        this.testClass = testClass;
    }

    @Override
    public String toString() {
        return "TestItem{" +
                "key=" + key +
                ", searchTerm='" + searchTerm + '\'' +
                ", testClass='" + testClass + '\'' +
                ", text='" + text + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public int getKey() {
        return key;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public String getTestClass() {
        return testClass;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
