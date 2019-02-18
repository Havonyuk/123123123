import org.xml.sax.*;

public interface StartElement extends EntityResolver, DTDHandler, ContentHandler, ErrorHandler {
    static MyHandler getSingl() {
        if (MyHandler.singl == null) {
            MyHandler.singl = new MyHandler(new StringBuilder(), "", "", "", "", "", "");
        }
        return MyHandler.singl;
    }

    void StartElement (String uri, String localName, String qName, Attributes attributes) throws SAXException;
}
