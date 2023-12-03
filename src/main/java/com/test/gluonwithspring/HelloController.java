package com.test.gluonwithspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class HelloController {

	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

	@FXML
	private Label welcomeText;
 
	@FXML
	private MenuBar menuBar;
	// Dossier
	@FXML
	private MenuItem menu1;
	@FXML
	private MenuItem menuOpen;
	@FXML
	private MenuItem menuClose;
	
	@FXML
	protected void onHelloButtonClick() {
		final String helloWorldMessage = ApplicationContextHolder.getApplicationContext().getBean("helloWorldMessage", String.class);

		welcomeText.setText(helloWorldMessage);
		logger.info(helloWorldMessage);
	}
	
	@FXML
	protected void menuDemoExecuted() {
		logger.info("menuDemoExecuted");
	}
	
	@FXML
	protected void menuCloseExecuted() {
		logger.info("menuCloseExecuted");
		HelloApplication.getHelloApplication().close();
	}

}