package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(3000);
        Socket s = serverSocket.accept();

        System.out.println("connesso al client");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        Scanner scanner= new Scanner(System.in);

        double num1=0.0;
        double num2=0.0;
        String operazione=" ";

        while(true){
            num1=Double.parseDouble(in.readLine());
            num2=Double.parseDouble(in.readLine());
            operazione=in.readLine();
            double risultato=0.0;
            if(operazione.equals("+")){
                risultato=num1+num2;
                
            }else if(operazione.equals("-")){
                risultato=num1-num2;
            }else if(operazione.equals("*")){
                risultato=num1*num2;
            }else if(operazione.equals("/")){
                if(num2==0){
                    out.println("hai sbagliato, stai dividendo per 0");
                    break;
                }else{
                    risultato=num1/num2;
                }
                
            }
            out.println(risultato);
        }
    }
}