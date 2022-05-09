package com.console.social.network.sample;

import java.util.Scanner;

import com.console.social.network.sample.view.CommandLineController;
import com.console.social.network.sample.view.view.PromptView;
import com.console.social.network.sample.view.view.WelcomeView;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import com.console.social.network.sample.view.view.ErrorView;
import com.console.social.network.sample.view.view.GoodByeView;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocialNetworkSampleApplication implements CommandLineRunner {

    private final CommandLineController commandLineController;

    public SocialNetworkSampleApplication(
            CommandLineController commandLineController
    ) {
        this.commandLineController = commandLineController;
    }

    public static void main(String[] args) {
        SpringApplication.run(SocialNetworkSampleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        try {
            WelcomeView.render();
            while(true) {
                Scanner sc = new Scanner(System.in);

                PromptView.render();

                String command = sc.nextLine();
                String[] commandWords = command.split("\\s+");

                if(commandWords[0].equals("exit")) {
                    GoodByeView.render();
                    break;
                }

                this.commandLineController.__call(commandWords);
            }
        } catch (Exception e) {
            ErrorView.render(e);
        }
    }

}
