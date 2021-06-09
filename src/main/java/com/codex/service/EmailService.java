package com.codex.service;

public interface EmailService {
    void sendMessage(String toAddress, String subject, String message);
}
