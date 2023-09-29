package cn.qfys521.xiaoming.plugin;

import lombok.Data;
import lombok.extern.java.Log;
import net.kronos.rkon.core.Rcon;
import net.kronos.rkon.core.ex.AuthenticationException;

import java.io.Console;
import java.io.IOException;

@Data
@Log
public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static void main(String[] args) {

        log.info(ANSI_BLUE+
                "\n ____                  ____ _ _            _   \n" +
                "|  _ \\ ___ ___  _ __  / ___| (_) ___ _ __ | |_ \n" +
                "| |_) / __/ _ \\| '_ \\| |   | | |/ _ \\ '_ \\| __|\n" +
                "|  _ < (_| (_) | | | | |___| | |  __/ | | | |_ \n" +
                "|_| \\_\\___\\___/|_| |_|\\____|_|_|\\___|_| |_|\\__|\n" +
                "                                               "+ANSI_RESET);
        log.info( ANSI_YELLOW+"Author: qfys521"+ANSI_RESET);
        log.info(ANSI_YELLOW+"dependencies: [rkon-core]"+ANSI_RESET);
        Console console = System.console();
        try {
            log.info(ANSI_YELLOW+"please input your server host(DO NOT APPEND SERVER PORT):"+ANSI_RESET);
            String host = console.readLine();
            log.info(ANSI_YELLOW+"please input your server port:"+ANSI_RESET);
            int port = Integer.parseInt(console.readLine());
            log.info(ANSI_YELLOW+"please input your server password:"+ANSI_RESET);
            byte[] password = console.readLine().getBytes();
            log.info(ANSI_YELLOW+"try connecting...."+ANSI_RESET);

            try {
                Rcon rcon = new Rcon(host,port,password);
                while (true){
                    log.info("please input your command,input [INTER] to send.");
                    log.info("From Server -> "+ ANSI_GREEN +rcon.command(console.readLine())+"\n"+ANSI_RESET);
                }
            } catch (IOException | AuthenticationException e) {
                log.info(ANSI_RED+ e);
            }
        }catch (Exception e){
            log.warning(ANSI_RED+ e);
        }


    }
}