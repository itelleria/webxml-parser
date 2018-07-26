package eu.arima.webxmlparser;

import org.apache.tomcat.util.descriptor.web.WebXml;
import org.junit.Assert;
import org.junit.Test;

public class ReaderTest {


    @Test
    public void testRead() {
        Reader reader = new Reader();
        WebXml webXml = reader.read();
        Assert.assertEquals(1, webXml.getServlets().size());
    }

}
