package bookShop.dataLayer;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "objects")
public class ObjectListWrapper<T> {
    private List<T> objects;

    @XmlElement(name = "object")
    public List<T> getObjects() {
        return objects;
    }

    public void setObjects(List<T> objects) {
        this.objects = objects;
    }
}
