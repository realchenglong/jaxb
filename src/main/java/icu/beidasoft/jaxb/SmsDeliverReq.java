package icu.beidasoft.jaxb;


import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "SMSDELIVERREQeeeeeeeee")
public class SmsDeliverReq {

    private String ss  ;

    private String s2  ;

    private ReqHeader reqHeader;
    private List<SmsBody> smsBodys;

    @XmlElement(name = "s1")
    public String getSs(){
        return this.ss;
    }
    public void setSs(String ss){
        this.ss = ss;
    }
    @XmlAttribute(name = "s2")
    public String getS2(){
        return this.s2;
    }
    public void setS2(String ss){
        this.s2 = ss;
    }

    @XmlElement(name = "REQHEADER")
    public ReqHeader getReqHeader() {
        return reqHeader;
    }

    public void setReqHeader(ReqHeader reqHeader) {
        this.reqHeader = reqHeader;
    }

    /**
     * 在JAXB标准中，@XmlElementWrapper注解表示生成一个包装 XML 表示形式的包装器元素。
     * 此元素主要用于生成一个包装集合的包装器 XML 元素。因此，该注释支持两种形式的序列化。
     * @XmlElementWrapper 仅允许出现在集合属性上
     * @return
     */
    @XmlElementWrapper(name = "SMSBODYSsss")
    @XmlElement(name = "SMSBODY1111")
    public List<SmsBody> getSmsBodys() {
        return smsBodys;
    }

    public void setSmsBodys(List<SmsBody> smsBodys) {
        this.smsBodys = smsBodys;
    }
}
