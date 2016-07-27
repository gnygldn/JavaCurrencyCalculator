package main.java;
import com.thoughtworks.xstream.XStream;


public class XmlDeserializer {
    public ExchangeInfoList ConvertedList;


    public XmlDeserializer(String infoList)
    {
        ConvertedList = DeserializeXmlList(infoList);
    }

    private ExchangeInfoList DeserializeXmlList(String infoList) {
        XStream xstream = new XStream();
        return (ExchangeInfoList)xstream.fromXML(infoList);
    }

}
