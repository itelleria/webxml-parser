package eu.arima.webxmlparser;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.descriptor.web.WebXml;
import org.apache.tomcat.util.descriptor.web.WebXmlParser;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Reader {

    public WebXml read() {
        WebXml webXml = new WebXml();

        WebXmlParser parser = new WebXmlParser(false, true, true);

        try (InputStream is = Reader.class.getResourceAsStream("/web.xml")) {
            boolean success = parser.parseWebXml(new InputSource(is), webXml, false);
            if (!success) {
                throw new IllegalStateException("Error parsing");
            }
        } catch (IOException e) {
            throw new IllegalStateException("Error reading", e);
        }

        return webXml;
    }

}
