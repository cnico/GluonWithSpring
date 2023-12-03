package com.test.gluonwithspring;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.io.ClassPathResource;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication(scanBasePackages = "com.test")
@ImportAutoConfiguration({SpringFxConfiguration.class})
public class HelloApplication extends Application {

	private static final Logger logger = LoggerFactory.getLogger(HelloApplication.class);

	private Stage mainStage;
	
	private static HelloApplication instance;
	
	public static HelloApplication getHelloApplication() {
		return instance;
	}
	
	@Override
	public void init() throws Exception {
		super.init();
		instance = this;
	}
	
    @Override
    public void start(Stage stage) throws IOException {

    	this.mainStage = stage;
    	
        FXMLLoader fxmlLoader = new FXMLLoader(new ClassPathResource("com/test/gluonwithspring/hello-view.fxml").getURL());
        Parent helloView = fxmlLoader.load();

        Scene scene = new Scene(helloView, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    public void close() {
    	this.mainStage.close();
    }
    
    public static void main(String[] args) {
    	logger.info("Starting main ...");
    	
    	// Lancement de Spring
    	new SpringApplicationBuilder(HelloApplication.class).run();
        
        String mainRunner = System.getProperty("sun.java.command");
        if ("org.springframework.boot.SpringApplicationAotProcessor".equals(mainRunner)) {
        	//For Spring's AOT build phase with maven, the SpringContext is sufficient and the JavaFX window make AOT generation fail.
        	logger.info("Simple run for Spring AOT");
        	return;
        }
        
        //Effective launch of JavaFX app
        logger.info("Starting JavaFX...");
        launch();
    }

}