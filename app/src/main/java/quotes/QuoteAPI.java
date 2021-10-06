package quotes;

public class QuoteAPI {
    private String quoteText;
    private String quoteAuthor;

    public QuoteAPI(String quoteText, String quoteAuthor) {
        this.quoteText = quoteText;
        this.quoteAuthor = quoteAuthor;
    }

    public String getQuote() {
        return quoteText;
    }

    public String getAuthor() {
        return quoteAuthor;
    }

    @Override
    public String toString() {
        return "QuoteAPI{" +
                "quote='" + quoteText + '\'' +
                ", author='" + quoteAuthor + '\'' +
                '}';
    }
}
