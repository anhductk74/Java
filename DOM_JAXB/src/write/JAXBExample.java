package write;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JAXBExample {

    public static void main(String[] args) throws JAXBException {
        Student st = new Student();

        st.setId("1");
        st.setName("duc");
        st.setAddress("vku");

        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        File file = new File("student.xml");
        marshaller.marshal(st, file);
    }
}
