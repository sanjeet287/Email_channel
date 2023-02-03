package com.sendemail.email_send;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Preparing to send Email......" );
        EmailImpl.sendEmail(EmailConstants.MESSAGE,EmailConstants.SUBJECT,EmailConstants.TO,EmailConstants.FROM);
        
    }
}
