import icu.beidasoft.jaxb.ReqHeader;
import icu.beidasoft.jaxb.SmsBody;
import icu.beidasoft.jaxb.SmsDeliverReq;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class Test {
    /**
     * XML 转转为 JavaBean
     * @param xml
     * @param t
     * @param <T>
     * @return
     * @throws JAXBException
     */
    public static <T> T xmlToBean(String xml, T t) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(t.getClass());
        Unmarshaller um = context.createUnmarshaller();
        StringReader sr = new StringReader(xml);
        t = (T) um.unmarshal(sr);
        return t;
    }

    /**
     * JavaBean 转换为 XML
     * @param t
     * @param <T>
     * @return
     * @throws JAXBException
     * @throws FileNotFoundException
     */
    public static <T> StringWriter beanToXml(T t) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(t.getClass());
        Marshaller m = context.createMarshaller();
        StringWriter sw = new StringWriter();
        m.marshal(t,sw);
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        m.marshal(t,new FileOutputStream("D:\\project\\test\\jaxb\\test.xml"));
        m.marshal(t,System.out);
        return sw;
    }
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        ReqHeader reqHeader = new ReqHeader();
        reqHeader.setReqNo("1");
        reqHeader.setAuthCode("AAA");
        reqHeader.setSysId("AAA123");

        SmsBody smsBody = new SmsBody();
        smsBody.setContent("测试1");
        smsBody.setDestAddr("15888");
        smsBody.setSourceAddr("888");

        SmsBody smsBody1 = new SmsBody();
        smsBody1.setContent("测试2");
        smsBody1.setDestAddr("159898");
        smsBody1.setSourceAddr("989898");

        SmsDeliverReq smsDeliverReq = new SmsDeliverReq();
        smsDeliverReq.setReqHeader(reqHeader);
        List<SmsBody> smsBodys = new ArrayList<SmsBody>();
        smsBodys.add(smsBody);
        smsBodys.add(smsBody1);
        smsDeliverReq.setS2("s2");
        smsDeliverReq.setSmsBodys(smsBodys);

        StringWriter sw = beanToXml(smsDeliverReq);
        System.out.println(sw.toString());

        SmsDeliverReq xmlToBean = xmlToBean(sw.toString(), smsDeliverReq);
        System.out.println(xmlToBean.getSmsBodys());

        System.out.println(xmlToBean.getSmsBodys().get(0).getContent());

    }
}
