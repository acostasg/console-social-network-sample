package com.console.social.network.sample.view.view;

public class WelcomeView {
    public static void render() {
        System.out.println(" ==== Welcome, social network technical test ====\n");
        System.out.println(" ===  Availables Commands:  ===");
        System.out.println(" For posting writte: user name -> message ");
        System.out.println(" Alice -> Hello world\n");
        System.out.println(" For reader writte: user name");
        System.out.println(" Bob\n");
        System.out.println(" For following writte: user name follows another user");
        System.out.println(" Alice follows Bob\n");
        System.out.println(" For view wall writte: user name wall ");
        System.out.println(" Bob wall\n");
        System.out.println(" === For exit application write: exit ===\n");
    }
}
