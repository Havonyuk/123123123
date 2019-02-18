import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler implements StartElement {
    public static MyHandler singl;
   // private static MyHandler singl;
    private StringBuilder text;
    private String shop ,name ,maker, group , composition, price;

    public MyHandler(StringBuilder text, String shop, String name, String maker, String group, String composition, String price) {
        this.text = text;
        this.shop = shop;
        this.name = name;
        this.maker = maker;
        this.group = group;
        this.composition = composition;
        this.price = price;
    }

    @Override
    public void StartElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    if (composition.equals(qName)){
        price = attributes.getValue("price");
        text.setLength(0);
    }
    if ("shop".equals(shop) || "name".equals(name) || "maker".equals(maker) || "group".equals(group)){
        text.setLength(0);
    }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("shop".equals(qName)) {
            shop = text.toString();
        }
        if ("name".equals(qName)){
            name = text.toString();
        }
        if ("maker".equals(qName)){
            maker = text.toString();
        }
        if ("group".equals(qName)){
            group = text.toString();
        }
        if ("composition".equals(qName)){
            composition = text.toString();
        }
        if ("food".equals(qName)){
            System.out.println("В магазине " + shop + " продается " + name + " от производителя " + maker + " принадлежащий к группе товаров " + group + " состоящий из " + composition + " по цене " + price + "\n");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append(ch, start, length);
    }

}
