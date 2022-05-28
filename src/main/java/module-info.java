module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires org.apache.poi.ooxml;
    requires commons.math3;
    requires org.apache.logging.log4j;
    requires org.apache.poi.examples;
    requires org.apache.poi.ooxml.schemas;
    requires org.apache.poi.scratchpad;
    requires org.apache.xmlbeans;

    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
}