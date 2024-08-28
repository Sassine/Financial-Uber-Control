package dev.sassine.financialcontrol.config.mail;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
@ConfigurationProperties(prefix = "spring.mail")
public class EmailConfig {

    private String host;
    private int port;
    private String username;
    private String password;
    private String protocol;
    private boolean ssl;
    private int connectiontimeout;
    private int timeout;
    private int writetimeout;

    // Getters e Setters

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public boolean isSsl() {
        return ssl;
    }

    public void setSsl(boolean ssl) {
        this.ssl = ssl;
    }

    public int getConnectiontimeout() {
        return connectiontimeout;
    }

    public void setConnectiontimeout(int connectiontimeout) {
        this.connectiontimeout = connectiontimeout;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getWritetimeout() {
        return writetimeout;
    }

    public void setWritetimeout(int writetimeout) {
        this.writetimeout = writetimeout;
    }

    public Properties toProperties() {
        Properties properties = new Properties();
        properties.put("mail.store.protocol", protocol);
        properties.put("mail.imap.ssl.enable", String.valueOf(ssl));
        properties.put("mail.imap.connectiontimeout", String.valueOf(connectiontimeout));
        properties.put("mail.imap.timeout", String.valueOf(timeout));
        properties.put("mail.imap.writetimeout", String.valueOf(writetimeout));
        return properties;
    }
}

